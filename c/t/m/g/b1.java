package c.t.m.g;

/* compiled from: P */
/* loaded from: classes.dex */
public class b1 {
    public static double a(double d16) {
        return (d16 * 3.141592653589793d) / 180.0d;
    }

    public static double a(double d16, double d17, double d18, double d19) {
        double a16 = a(d16);
        double a17 = a(d18);
        return Math.round((((Math.asin(Math.sqrt(Math.pow(Math.sin((a16 - a17) / 2.0d), 2.0d) + ((Math.cos(a16) * Math.cos(a17)) * Math.pow(Math.sin((a(d17) - a(d19)) / 2.0d), 2.0d)))) * 2.0d) * 6378.137d) * 1000.0d) * 1000.0d) / 1000.0d;
    }
}
