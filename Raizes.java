package raizes;

public class Raizes {

    public interface Funcao {

        public double funcao(double x);
    }

    private static int sign(double x) {
        return (x < 0.0) ? -1 : (x > 0.0) ? 1 : 0;
    }

    public static void printRaizes(Funcao funcao, double lowerBound,
            double upperBound, double step) {
        double x = lowerBound, ox = x;
        double y = funcao.funcao(x), oy = y;
        int s = sign(y), os = s;

        for (; x <= upperBound; x += step) {
            s = sign(y = funcao.funcao(x));
            if (s == 0) {
                System.out.println(x);
            } else if (s != os) {
                double dx = x - ox;
                double dy = y - oy;
                double cx = x - dx * (y / dy);
                System.out.println("~" + cx);
            }
            ox = x;
            oy = y;
            os = s;
        }
    }

    public static void main(String[] args) {
        Funcao polinomio = new Funcao() {
            @Override
            public double funcao(double x) {
                return x * x * x - 3 * x * x + 2 * x;
            }
        };
        printRaizes(polinomio, -1.0, 4, 0.002);
    }
    
}