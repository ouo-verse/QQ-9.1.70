package com.tencent.mobileqq.ark.util;

/* compiled from: P */
/* loaded from: classes11.dex */
public class g {
    public static double[] a(double d16, double d17) {
        if (b(d16, d17)) {
            return new double[]{d16, d17};
        }
        double d18 = d16 - 105.0d;
        double d19 = d17 - 35.0d;
        double c16 = c(d18, d19);
        double d26 = d(d18, d19);
        double d27 = (d17 / 180.0d) * 3.141592653589793d;
        double sin = Math.sin(d27);
        double d28 = 1.0d - ((0.006693421622965943d * sin) * sin);
        double sqrt = Math.sqrt(d28);
        return new double[]{(d16 * 2.0d) - (d16 + ((d26 * 180.0d) / (((6378245.0d / sqrt) * Math.cos(d27)) * 3.141592653589793d))), (d17 * 2.0d) - (d17 + ((c16 * 180.0d) / ((6335552.717000426d / (d28 * sqrt)) * 3.141592653589793d)))};
    }

    private static boolean b(double d16, double d17) {
        if (d16 < 72.004d || d16 > 137.8347d || d17 < 0.8293d || d17 > 55.8271d) {
            return true;
        }
        return false;
    }

    private static double c(double d16, double d17) {
        double d18 = d16 * 2.0d;
        double sqrt = (-100.0d) + d18 + (d17 * 3.0d) + (d17 * 0.2d * d17) + (0.1d * d16 * d17) + (Math.sqrt(Math.abs(d16)) * 0.2d) + ((((Math.sin((6.0d * d16) * 3.141592653589793d) * 20.0d) + (Math.sin(d18 * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d);
        double d19 = d17 * 3.141592653589793d;
        return sqrt + ((((Math.sin(d19) * 20.0d) + (Math.sin((d17 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d17 / 12.0d) * 3.141592653589793d) * 160.0d) + (Math.sin(d19 / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    private static double d(double d16, double d17) {
        double d18 = d16 * 0.1d;
        return d16 + 300.0d + (d17 * 2.0d) + (d18 * d16) + (d18 * d17) + (Math.sqrt(Math.abs(d16)) * 0.1d) + ((((Math.sin((6.0d * d16) * 3.141592653589793d) * 20.0d) + (Math.sin((d16 * 2.0d) * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(d16 * 3.141592653589793d) * 20.0d) + (Math.sin((d16 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d16 / 12.0d) * 3.141592653589793d) * 150.0d) + (Math.sin((d16 / 30.0d) * 3.141592653589793d) * 300.0d)) * 2.0d) / 3.0d);
    }
}
