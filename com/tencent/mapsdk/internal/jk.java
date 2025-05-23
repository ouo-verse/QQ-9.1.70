package com.tencent.mapsdk.internal;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class jk {
    public static double a(long j3, float f16) {
        float f17 = ((float) j3) / 5000.0f;
        return ((-f16) * f17 * (f17 - 2.0f)) + 0.0f;
    }

    private static double b(long j3, float f16, float f17, long j16) {
        float f18 = ((float) j3) / ((float) j16);
        return (f17 * f18 * f18) + f16;
    }

    private static double c(long j3, float f16, float f17, long j16) {
        float f18;
        float f19;
        long j17 = ((float) j3) / (((float) j16) / 2.0f);
        if (j17 < 1) {
            f19 = (float) j17;
            f18 = (f17 / 2.0f) * f19;
        } else {
            f18 = (-f17) / 2.0f;
            long j18 = j17 - 1;
            f19 = (float) ((j18 * (j18 - 2)) - 1);
        }
        return (f18 * f19) + f16;
    }

    private static double d(long j3, float f16, float f17, long j16) {
        return (f17 * Math.pow(j3 / j16, 3.0d)) + f16;
    }

    private static double e(long j3, float f16, float f17, long j16) {
        return (f17 * (Math.pow((((float) j3) / ((float) j16)) - 1.0f, 3.0d) + 1.0d)) + f16;
    }

    private static double f(long j3, float f16, float f17, long j16) {
        double d16;
        double pow;
        long j17 = j3 / (j16 / 2);
        if (j17 < 1) {
            d16 = f17 / 2.0f;
            pow = Math.pow(j17, 3.0d);
        } else {
            d16 = f17 / 2.0f;
            pow = Math.pow(j17 - 2, 3.0d) + 2.0d;
        }
        return (d16 * pow) + f16;
    }

    private static double g(long j3, float f16, float f17, long j16) {
        float f18 = ((float) j3) / ((float) j16);
        return (f17 * f18 * f18 * f18 * f18) + f16;
    }

    private static double h(long j3, float f16, float f17, long j16) {
        float f18 = (float) (j3 / (j16 - 1));
        return ((-f17) * ((((f18 * f18) * f18) * f18) - 1.0f)) + f16;
    }

    private static double i(long j3, float f16, float f17, long j16) {
        float f18;
        float f19;
        long j17 = j3 / (j16 / 2);
        if (j17 < 1) {
            f19 = (float) j17;
            f18 = (f17 / 2.0f) * f19 * f19 * f19;
        } else {
            f18 = (-f17) / 2.0f;
            long j18 = j17 - 2;
            f19 = (float) ((((j18 * j18) * j18) * j18) - 2);
        }
        return (f18 * f19) + f16;
    }

    private static double j(long j3, float f16, float f17, long j16) {
        float f18 = (float) (j3 / j16);
        return (f17 * f18 * f18 * f18 * f18 * f18) + f16;
    }

    private static double k(long j3, float f16, float f17, long j16) {
        long j17 = (j3 / j16) - 1;
        return (f17 * ((float) ((j17 * j17 * j17 * j17 * j17) + 1))) + f16;
    }

    private static double l(long j3, float f16, float f17, long j16) {
        float f18;
        float f19;
        long j17 = j3 / (j16 / 2);
        if (j17 < 1) {
            f19 = (float) j17;
            f18 = (f17 / 2.0f) * f19 * f19 * f19 * f19;
        } else {
            f18 = f17 / 2.0f;
            long j18 = j17 - 2;
            f19 = (float) ((j18 * j18 * j18 * j18 * j18) + 2);
        }
        return (f18 * f19) + f16;
    }

    private static double m(long j3, float f16, float f17, long j16) {
        return (f17 * (1.0d - Math.cos((j3 / j16) * 1.5707963267948966d))) + f16;
    }

    private static double n(long j3, float f16, float f17, long j16) {
        return (f17 * Math.sin((j3 / j16) * 1.5707963267948966d)) + f16;
    }

    private static double o(long j3, float f16, float f17, long j16) {
        return ((f17 / 2.0f) * (1.0d - Math.cos((j3 * 3.141592653589793d) / j16))) + f16;
    }

    private static double p(long j3, float f16, float f17, long j16) {
        return (f17 * Math.pow(2.0d, ((j3 / j16) - 1) * 10)) + f16;
    }

    private static double q(long j3, float f16, float f17, long j16) {
        return (f17 * ((-Math.pow(2.0d, (j3 * (-10)) / j16)) + 1.0d)) + f16;
    }

    private static double r(long j3, float f16, float f17, long j16) {
        long j17 = j3 / j16;
        return (f17 * (1.0d - Math.sqrt(1 - (j17 * j17)))) + f16;
    }

    private static double s(long j3, float f16, float f17, long j16) {
        long j17 = j3 / (j16 - 1);
        return (f17 * Math.sqrt(1 - (j17 * j17))) + f16;
    }

    private static double t(long j3, float f16, float f17, long j16) {
        long j17 = j3 / (j16 / 2);
        if (j17 < 1) {
            return ((f17 / 2.0f) * (1.0d - Math.sqrt(1 - (j17 * j17)))) + f16;
        }
        long j18 = j17 - 2;
        return ((f17 / 2.0f) * (Math.sqrt(1 - (j18 * j18)) + 1.0d)) + f16;
    }

    private static double u(long j3, float f16, float f17, long j16) {
        float f18;
        long j17;
        long j18 = j3 / (j16 / 2);
        if (j18 < 1) {
            f18 = f17 / 2.0f;
            j17 = j18 * j18 * ((j18 * 4) - 3);
        } else {
            f18 = f17 / 2.0f;
            long j19 = j18 - 2;
            j17 = (j19 * j19 * ((j19 * 4) + 3)) + 2;
        }
        return (f18 * ((float) j17)) + f16;
    }

    private static double v(long j3, float f16, float f17, long j16) {
        float f18 = (float) (j3 / j16);
        return (f17 * f18 * f18 * ((float) ((r0 * 21) - 20))) + f16;
    }

    private static double w(long j3, float f16, float f17, long j16) {
        long j17 = (j3 / j16) - 1;
        return (f17 * ((float) ((j17 * j17 * ((j17 * 21) + 20)) + 1))) + f16;
    }

    public static double a(long j3, float f16, float f17, long j16) {
        return ((f17 * ((float) j3)) / ((float) j16)) + f16;
    }
}
