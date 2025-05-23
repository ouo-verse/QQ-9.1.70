package androidx.constraintlayout.motion.utils;

/* compiled from: P */
/* loaded from: classes.dex */
public class LinearCurveFit extends CurveFit {
    private static final String TAG = "LinearCurveFit";
    private double[] mT;
    private double mTotalLength;
    private double[][] mY;

    public LinearCurveFit(double[] dArr, double[][] dArr2) {
        this.mTotalLength = Double.NaN;
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.mT = dArr;
        this.mY = dArr2;
        if (length2 > 2) {
            int i3 = 0;
            double d16 = 0.0d;
            while (true) {
                double d17 = d16;
                if (i3 < dArr.length) {
                    double d18 = dArr2[i3][0];
                    if (i3 > 0) {
                        Math.hypot(d18 - d16, d18 - d17);
                    }
                    i3++;
                    d16 = d18;
                } else {
                    this.mTotalLength = 0.0d;
                    return;
                }
            }
        }
    }

    private double getLength2D(double d16) {
        if (Double.isNaN(this.mTotalLength)) {
            return 0.0d;
        }
        double[] dArr = this.mT;
        int length = dArr.length;
        if (d16 <= dArr[0]) {
            return 0.0d;
        }
        int i3 = length - 1;
        if (d16 >= dArr[i3]) {
            return this.mTotalLength;
        }
        double d17 = 0.0d;
        double d18 = 0.0d;
        double d19 = 0.0d;
        int i16 = 0;
        while (i16 < i3) {
            double[] dArr2 = this.mY[i16];
            double d26 = dArr2[0];
            double d27 = dArr2[1];
            if (i16 > 0) {
                d17 += Math.hypot(d26 - d18, d27 - d19);
            }
            double[] dArr3 = this.mT;
            double d28 = dArr3[i16];
            if (d16 == d28) {
                return d17;
            }
            int i17 = i16 + 1;
            double d29 = dArr3[i17];
            if (d16 < d29) {
                double d36 = (d16 - d28) / (d29 - d28);
                double[][] dArr4 = this.mY;
                double[] dArr5 = dArr4[i16];
                double d37 = dArr5[0];
                double[] dArr6 = dArr4[i17];
                double d38 = 1.0d - d36;
                return d17 + Math.hypot(d27 - ((dArr5[1] * d38) + (dArr6[1] * d36)), d26 - ((d37 * d38) + (dArr6[0] * d36)));
            }
            i16 = i17;
            d18 = d26;
            d19 = d27;
        }
        return 0.0d;
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
                double d19 = (d16 - d18) / (d17 - d18);
                while (i3 < length2) {
                    double[][] dArr4 = this.mY;
                    dArr[i3] = (dArr4[i18][i3] * (1.0d - d19)) + (dArr4[i26][i3] * d19);
                    i3++;
                }
                return;
            }
            i18 = i26;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0017, code lost:
    
        if (r13 >= r4) goto L4;
     */
    @Override // androidx.constraintlayout.motion.utils.CurveFit
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getSlope(double d16, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int length2 = this.mY[0].length;
        double d17 = dArr2[0];
        if (d16 > d17) {
            d17 = dArr2[length - 1];
        }
        d16 = d17;
        int i3 = 0;
        while (i3 < length - 1) {
            double[] dArr3 = this.mT;
            int i16 = i3 + 1;
            double d18 = dArr3[i16];
            if (d16 <= d18) {
                double d19 = d18 - dArr3[i3];
                for (int i17 = 0; i17 < length2; i17++) {
                    double[][] dArr4 = this.mY;
                    dArr[i17] = (dArr4[i16][i17] - dArr4[i3][i17]) / d19;
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

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0012, code lost:
    
        if (r8 >= r3) goto L4;
     */
    @Override // androidx.constraintlayout.motion.utils.CurveFit
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double getSlope(double d16, int i3) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i16 = 0;
        double d17 = dArr[0];
        if (d16 >= d17) {
            d17 = dArr[length - 1];
        }
        d16 = d17;
        while (i16 < length - 1) {
            double[] dArr2 = this.mT;
            int i17 = i16 + 1;
            double d18 = dArr2[i17];
            if (d16 <= d18) {
                double d19 = d18 - dArr2[i16];
                double[][] dArr3 = this.mY;
                return (dArr3[i17][i3] - dArr3[i16][i3]) / d19;
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
                double d19 = (d16 - d18) / (d17 - d18);
                while (i3 < length2) {
                    double[][] dArr3 = this.mY;
                    fArr[i3] = (float) ((dArr3[i18][i3] * (1.0d - d19)) + (dArr3[i26][i3] * d19));
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
                double d19 = (d16 - d17) / (d18 - d17);
                double[][] dArr3 = this.mY;
                return (dArr3[i16][i3] * (1.0d - d19)) + (dArr3[i18][i3] * d19);
            }
            i16 = i18;
        }
        return 0.0d;
    }
}
