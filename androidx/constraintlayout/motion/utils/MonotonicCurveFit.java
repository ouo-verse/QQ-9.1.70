package androidx.constraintlayout.motion.utils;

import java.lang.reflect.Array;

/* compiled from: P */
/* loaded from: classes.dex */
public class MonotonicCurveFit extends CurveFit {
    private static final String TAG = "MonotonicCurveFit";
    private double[] mT;
    private double[][] mTangent;
    private double[][] mY;

    public MonotonicCurveFit(double[] dArr, double[][] dArr2) {
        int length = dArr.length;
        int length2 = dArr2[0].length;
        int i3 = length - 1;
        double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i3, length2);
        double[][] dArr4 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length2);
        for (int i16 = 0; i16 < length2; i16++) {
            int i17 = 0;
            while (i17 < i3) {
                int i18 = i17 + 1;
                double d16 = dArr[i18] - dArr[i17];
                double[] dArr5 = dArr3[i17];
                double d17 = (dArr2[i18][i16] - dArr2[i17][i16]) / d16;
                dArr5[i16] = d17;
                if (i17 == 0) {
                    dArr4[i17][i16] = d17;
                } else {
                    dArr4[i17][i16] = (dArr3[i17 - 1][i16] + d17) * 0.5d;
                }
                i17 = i18;
            }
            dArr4[i3][i16] = dArr3[length - 2][i16];
        }
        for (int i19 = 0; i19 < i3; i19++) {
            for (int i26 = 0; i26 < length2; i26++) {
                double d18 = dArr3[i19][i26];
                if (d18 == 0.0d) {
                    dArr4[i19][i26] = 0.0d;
                    dArr4[i19 + 1][i26] = 0.0d;
                } else {
                    double d19 = dArr4[i19][i26] / d18;
                    int i27 = i19 + 1;
                    double d26 = dArr4[i27][i26] / d18;
                    double hypot = Math.hypot(d19, d26);
                    if (hypot > 9.0d) {
                        double d27 = 3.0d / hypot;
                        double[] dArr6 = dArr4[i19];
                        double[] dArr7 = dArr3[i19];
                        dArr6[i26] = d19 * d27 * dArr7[i26];
                        dArr4[i27][i26] = d27 * d26 * dArr7[i26];
                    }
                }
            }
        }
        this.mT = dArr;
        this.mY = dArr2;
        this.mTangent = dArr4;
    }

    private static double diff(double d16, double d17, double d18, double d19, double d26, double d27) {
        double d28 = d17 * d17;
        double d29 = d17 * 6.0d;
        double d36 = 3.0d * d16;
        return ((((((((((-6.0d) * d28) * d19) + (d29 * d19)) + ((6.0d * d28) * d18)) - (d29 * d18)) + ((d36 * d27) * d28)) + ((d36 * d26) * d28)) - (((2.0d * d16) * d27) * d17)) - (((4.0d * d16) * d26) * d17)) + (d16 * d26);
    }

    private static double interpolate(double d16, double d17, double d18, double d19, double d26, double d27) {
        double d28 = d17 * d17;
        double d29 = d28 * d17;
        double d36 = 3.0d * d28;
        double d37 = ((((((-2.0d) * d29) * d19) + (d36 * d19)) + ((d29 * 2.0d) * d18)) - (d36 * d18)) + d18;
        double d38 = d16 * d27;
        double d39 = d16 * d26;
        return ((((d37 + (d38 * d29)) + (d29 * d39)) - (d38 * d28)) - (((d16 * 2.0d) * d26) * d28)) + (d39 * d17);
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d16, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int i3 = 0;
        int length2 = this.mY[0].length;
        if (d16 <= dArr2[0]) {
            for (int i16 = 0; i16 < length2; i16++) {
                dArr[i16] = this.mY[0][i16];
            }
            return;
        }
        int i17 = length - 1;
        if (d16 >= dArr2[i17]) {
            while (i3 < length2) {
                dArr[i3] = this.mY[i17][i3];
                i3++;
            }
            return;
        }
        int i18 = 0;
        while (i18 < i17) {
            if (d16 == this.mT[i18]) {
                for (int i19 = 0; i19 < length2; i19++) {
                    dArr[i19] = this.mY[i18][i19];
                }
            }
            double[] dArr3 = this.mT;
            int i26 = i18 + 1;
            double d17 = dArr3[i26];
            if (d16 < d17) {
                double d18 = dArr3[i18];
                double d19 = d17 - d18;
                double d26 = (d16 - d18) / d19;
                while (i3 < length2) {
                    double[][] dArr4 = this.mY;
                    double d27 = dArr4[i18][i3];
                    double d28 = dArr4[i26][i3];
                    double[][] dArr5 = this.mTangent;
                    dArr[i3] = interpolate(d19, d26, d27, d28, dArr5[i18][i3], dArr5[i26][i3]);
                    i3++;
                }
                return;
            }
            i18 = i26;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getSlope(double d16, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int length2 = this.mY[0].length;
        double d17 = dArr2[0];
        if (d16 > d17) {
            d17 = dArr2[length - 1];
            if (d16 < d17) {
                d17 = d16;
            }
        }
        int i3 = 0;
        while (i3 < length - 1) {
            double[] dArr3 = this.mT;
            int i16 = i3 + 1;
            double d18 = dArr3[i16];
            if (d17 <= d18) {
                double d19 = dArr3[i3];
                double d26 = d18 - d19;
                double d27 = (d17 - d19) / d26;
                for (int i17 = 0; i17 < length2; i17++) {
                    double[][] dArr4 = this.mY;
                    double d28 = dArr4[i3][i17];
                    double d29 = dArr4[i16][i17];
                    double[][] dArr5 = this.mTangent;
                    dArr[i17] = diff(d26, d27, d28, d29, dArr5[i3][i17], dArr5[i16][i17]) / d26;
                }
                return;
            }
            i3 = i16;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mT;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getSlope(double d16, int i3) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i16 = 0;
        double d17 = dArr[0];
        if (d16 >= d17) {
            d17 = dArr[length - 1];
            if (d16 < d17) {
                d17 = d16;
            }
        }
        while (i16 < length - 1) {
            double[] dArr2 = this.mT;
            int i17 = i16 + 1;
            double d18 = dArr2[i17];
            if (d17 <= d18) {
                double d19 = dArr2[i16];
                double d26 = d18 - d19;
                double[][] dArr3 = this.mY;
                double d27 = dArr3[i16][i3];
                double d28 = dArr3[i17][i3];
                double[][] dArr4 = this.mTangent;
                return diff(d26, (d17 - d19) / d26, d27, d28, dArr4[i16][i3], dArr4[i17][i3]) / d26;
            }
            i16 = i17;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d16, float[] fArr) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i3 = 0;
        int length2 = this.mY[0].length;
        if (d16 <= dArr[0]) {
            for (int i16 = 0; i16 < length2; i16++) {
                fArr[i16] = (float) this.mY[0][i16];
            }
            return;
        }
        int i17 = length - 1;
        if (d16 >= dArr[i17]) {
            while (i3 < length2) {
                fArr[i3] = (float) this.mY[i17][i3];
                i3++;
            }
            return;
        }
        int i18 = 0;
        while (i18 < i17) {
            if (d16 == this.mT[i18]) {
                for (int i19 = 0; i19 < length2; i19++) {
                    fArr[i19] = (float) this.mY[i18][i19];
                }
            }
            double[] dArr2 = this.mT;
            int i26 = i18 + 1;
            double d17 = dArr2[i26];
            if (d16 < d17) {
                double d18 = dArr2[i18];
                double d19 = d17 - d18;
                double d26 = (d16 - d18) / d19;
                while (i3 < length2) {
                    double[][] dArr3 = this.mY;
                    double d27 = dArr3[i18][i3];
                    double d28 = dArr3[i26][i3];
                    double[][] dArr4 = this.mTangent;
                    fArr[i3] = (float) interpolate(d19, d26, d27, d28, dArr4[i18][i3], dArr4[i26][i3]);
                    i3++;
                }
                return;
            }
            i18 = i26;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getPos(double d16, int i3) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i16 = 0;
        if (d16 <= dArr[0]) {
            return this.mY[0][i3];
        }
        int i17 = length - 1;
        if (d16 >= dArr[i17]) {
            return this.mY[i17][i3];
        }
        while (i16 < i17) {
            double[] dArr2 = this.mT;
            double d17 = dArr2[i16];
            if (d16 == d17) {
                return this.mY[i16][i3];
            }
            int i18 = i16 + 1;
            double d18 = dArr2[i18];
            if (d16 < d18) {
                double d19 = d18 - d17;
                double d26 = (d16 - d17) / d19;
                double[][] dArr3 = this.mY;
                double d27 = dArr3[i16][i3];
                double d28 = dArr3[i18][i3];
                double[][] dArr4 = this.mTangent;
                return interpolate(d19, d26, d27, d28, dArr4[i16][i3], dArr4[i18][i3]);
            }
            i16 = i18;
        }
        return 0.0d;
    }
}
