package androidx.constraintlayout.motion.utils;

import java.lang.reflect.Array;

/* compiled from: P */
/* loaded from: classes.dex */
public class HyperSpline {
    double[][] mCtl;
    Cubic[][] mCurve;
    double[] mCurveLength;
    int mDimensionality;
    int mPoints;
    double mTotalLength;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Cubic {
        public static final double HALF = 0.5d;
        public static final double THIRD = 0.3333333333333333d;
        double mA;
        double mB;
        double mC;
        double mD;

        public Cubic(double d16, double d17, double d18, double d19) {
            this.mA = d16;
            this.mB = d17;
            this.mC = d18;
            this.mD = d19;
        }

        public double eval(double d16) {
            return (((((this.mD * d16) + this.mC) * d16) + this.mB) * d16) + this.mA;
        }

        public double vel(double d16) {
            return (((this.mD * 0.3333333333333333d * d16) + (this.mC * 0.5d)) * d16) + this.mB;
        }
    }

    public HyperSpline(double[][] dArr) {
        setup(dArr);
    }

    static Cubic[] calcNaturalCubic(int i3, double[] dArr) {
        double[] dArr2 = new double[i3];
        double[] dArr3 = new double[i3];
        double[] dArr4 = new double[i3];
        int i16 = i3 - 1;
        int i17 = 0;
        dArr2[0] = 0.5d;
        int i18 = 1;
        for (int i19 = 1; i19 < i16; i19++) {
            dArr2[i19] = 1.0d / (4.0d - dArr2[i19 - 1]);
        }
        int i26 = i16 - 1;
        dArr2[i16] = 1.0d / (2.0d - dArr2[i26]);
        dArr3[0] = (dArr[1] - dArr[0]) * 3.0d * dArr2[0];
        while (i18 < i16) {
            int i27 = i18 + 1;
            int i28 = i18 - 1;
            dArr3[i18] = (((dArr[i27] - dArr[i28]) * 3.0d) - dArr3[i28]) * dArr2[i18];
            i18 = i27;
        }
        double d16 = (((dArr[i16] - dArr[i26]) * 3.0d) - dArr3[i26]) * dArr2[i16];
        dArr3[i16] = d16;
        dArr4[i16] = d16;
        while (i26 >= 0) {
            dArr4[i26] = dArr3[i26] - (dArr2[i26] * dArr4[i26 + 1]);
            i26--;
        }
        Cubic[] cubicArr = new Cubic[i16];
        while (i17 < i16) {
            double d17 = dArr[i17];
            double d18 = dArr4[i17];
            int i29 = i17 + 1;
            double d19 = dArr[i29];
            double d26 = dArr4[i29];
            cubicArr[i17] = new Cubic((float) d17, d18, (((d19 - d17) * 3.0d) - (d18 * 2.0d)) - d26, ((d17 - d19) * 2.0d) + d18 + d26);
            i17 = i29;
        }
        return cubicArr;
    }

    public double approxLength(Cubic[] cubicArr) {
        int i3;
        int length = cubicArr.length;
        double[] dArr = new double[cubicArr.length];
        double d16 = 0.0d;
        double d17 = 0.0d;
        double d18 = 0.0d;
        while (true) {
            i3 = 0;
            if (d17 >= 1.0d) {
                break;
            }
            double d19 = 0.0d;
            while (i3 < cubicArr.length) {
                double d26 = dArr[i3];
                double eval = cubicArr[i3].eval(d17);
                dArr[i3] = eval;
                double d27 = d26 - eval;
                d19 += d27 * d27;
                i3++;
            }
            if (d17 > 0.0d) {
                d18 += Math.sqrt(d19);
            }
            d17 += 0.1d;
        }
        while (i3 < cubicArr.length) {
            double d28 = dArr[i3];
            double eval2 = cubicArr[i3].eval(1.0d);
            dArr[i3] = eval2;
            double d29 = d28 - eval2;
            d16 += d29 * d29;
            i3++;
        }
        return d18 + Math.sqrt(d16);
    }

    public void getPos(double d16, double[] dArr) {
        double d17 = d16 * this.mTotalLength;
        int i3 = 0;
        while (true) {
            double[] dArr2 = this.mCurveLength;
            if (i3 >= dArr2.length - 1) {
                break;
            }
            double d18 = dArr2[i3];
            if (d18 >= d17) {
                break;
            }
            d17 -= d18;
            i3++;
        }
        for (int i16 = 0; i16 < dArr.length; i16++) {
            dArr[i16] = this.mCurve[i16][i3].eval(d17 / this.mCurveLength[i3]);
        }
    }

    public void getVelocity(double d16, double[] dArr) {
        double d17 = d16 * this.mTotalLength;
        int i3 = 0;
        while (true) {
            double[] dArr2 = this.mCurveLength;
            if (i3 >= dArr2.length - 1) {
                break;
            }
            double d18 = dArr2[i3];
            if (d18 >= d17) {
                break;
            }
            d17 -= d18;
            i3++;
        }
        for (int i16 = 0; i16 < dArr.length; i16++) {
            dArr[i16] = this.mCurve[i16][i3].vel(d17 / this.mCurveLength[i3]);
        }
    }

    public void setup(double[][] dArr) {
        int i3;
        int length = dArr[0].length;
        this.mDimensionality = length;
        int length2 = dArr.length;
        this.mPoints = length2;
        this.mCtl = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length2);
        this.mCurve = new Cubic[this.mDimensionality];
        for (int i16 = 0; i16 < this.mDimensionality; i16++) {
            for (int i17 = 0; i17 < this.mPoints; i17++) {
                this.mCtl[i16][i17] = dArr[i17][i16];
            }
        }
        int i18 = 0;
        while (true) {
            i3 = this.mDimensionality;
            if (i18 >= i3) {
                break;
            }
            Cubic[][] cubicArr = this.mCurve;
            double[] dArr2 = this.mCtl[i18];
            cubicArr[i18] = calcNaturalCubic(dArr2.length, dArr2);
            i18++;
        }
        this.mCurveLength = new double[this.mPoints - 1];
        this.mTotalLength = 0.0d;
        Cubic[] cubicArr2 = new Cubic[i3];
        for (int i19 = 0; i19 < this.mCurveLength.length; i19++) {
            for (int i26 = 0; i26 < this.mDimensionality; i26++) {
                cubicArr2[i26] = this.mCurve[i26][i19];
            }
            double d16 = this.mTotalLength;
            double[] dArr3 = this.mCurveLength;
            double approxLength = approxLength(cubicArr2);
            dArr3[i19] = approxLength;
            this.mTotalLength = d16 + approxLength;
        }
    }

    public HyperSpline() {
    }

    public void getPos(double d16, float[] fArr) {
        double d17 = d16 * this.mTotalLength;
        int i3 = 0;
        while (true) {
            double[] dArr = this.mCurveLength;
            if (i3 >= dArr.length - 1) {
                break;
            }
            double d18 = dArr[i3];
            if (d18 >= d17) {
                break;
            }
            d17 -= d18;
            i3++;
        }
        for (int i16 = 0; i16 < fArr.length; i16++) {
            fArr[i16] = (float) this.mCurve[i16][i3].eval(d17 / this.mCurveLength[i3]);
        }
    }

    public double getPos(double d16, int i3) {
        double[] dArr;
        double d17 = d16 * this.mTotalLength;
        int i16 = 0;
        while (true) {
            dArr = this.mCurveLength;
            if (i16 >= dArr.length - 1) {
                break;
            }
            double d18 = dArr[i16];
            if (d18 >= d17) {
                break;
            }
            d17 -= d18;
            i16++;
        }
        return this.mCurve[i3][i16].eval(d17 / dArr[i16]);
    }
}
