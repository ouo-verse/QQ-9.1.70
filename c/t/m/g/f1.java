package c.t.m.g;

/* compiled from: P */
/* loaded from: classes.dex */
public class f1 {
    public static int a(boolean z16) {
        return z16 ? 1 : 0;
    }

    public static boolean b(double d16, double d17) {
        if (d16 != Double.MIN_VALUE && d16 != 1.401298464324817E-45d && a(d16, 0.0d, d17)) {
            return true;
        }
        return false;
    }

    public static boolean a(double d16) {
        return b(d16, 1.0E-10d);
    }

    public static final boolean a(double d16, double d17) {
        return a(d16, d17, 1.0E-8d);
    }

    public static final boolean a(double d16, double d17, double d18) {
        return (Double.isNaN(d16) || Double.isNaN(d17) || Math.abs(d16 - d17) >= d18) ? false : true;
    }
}
