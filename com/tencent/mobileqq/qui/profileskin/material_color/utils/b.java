package com.tencent.mobileqq.qui.profileskin.material_color.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static double a(double d16, double d17, double d18) {
        if (d18 < d16) {
            return d16;
        }
        if (d18 > d17) {
            return d17;
        }
        return d18;
    }

    public static int b(int i3, int i16, int i17) {
        if (i17 < i3) {
            return i3;
        }
        if (i17 > i16) {
            return i16;
        }
        return i17;
    }

    public static double c(double d16, double d17, double d18) {
        return ((1.0d - d18) * d16) + (d18 * d17);
    }

    public static double[] d(double[] dArr, double[][] dArr2) {
        double d16 = dArr[0];
        double[] dArr3 = dArr2[0];
        double d17 = dArr3[0] * d16;
        double d18 = dArr[1];
        double d19 = d17 + (dArr3[1] * d18);
        double d26 = dArr[2];
        double d27 = d19 + (dArr3[2] * d26);
        double[] dArr4 = dArr2[1];
        double d28 = (dArr4[0] * d16) + (dArr4[1] * d18) + (dArr4[2] * d26);
        double[] dArr5 = dArr2[2];
        return new double[]{d27, d28, (d16 * dArr5[0]) + (d18 * dArr5[1]) + (d26 * dArr5[2])};
    }

    public static double e(double d16) {
        double d17 = d16 % 360.0d;
        if (d17 < 0.0d) {
            return d17 + 360.0d;
        }
        return d17;
    }

    public static int f(double d16) {
        if (d16 < 0.0d) {
            return -1;
        }
        if (d16 == 0.0d) {
            return 0;
        }
        return 1;
    }
}
