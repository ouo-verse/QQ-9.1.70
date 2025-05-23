package androidx.constraintlayout.motion.utils;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class CurveFit {
    public static final int CONSTANT = 2;
    public static final int LINEAR = 1;
    public static final int SPLINE = 0;

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class Constant extends CurveFit {
        double mTime;
        double[] mValue;

        Constant(double d16, double[] dArr) {
            this.mTime = d16;
            this.mValue = dArr;
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public void getPos(double d16, double[] dArr) {
            double[] dArr2 = this.mValue;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public double getSlope(double d16, int i3) {
            return 0.0d;
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public double[] getTimePoints() {
            return new double[]{this.mTime};
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public void getPos(double d16, float[] fArr) {
            int i3 = 0;
            while (true) {
                double[] dArr = this.mValue;
                if (i3 >= dArr.length) {
                    return;
                }
                fArr[i3] = (float) dArr[i3];
                i3++;
            }
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public void getSlope(double d16, double[] dArr) {
            for (int i3 = 0; i3 < this.mValue.length; i3++) {
                dArr[i3] = 0.0d;
            }
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public double getPos(double d16, int i3) {
            return this.mValue[i3];
        }
    }

    public static CurveFit get(int i3, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i3 = 2;
        }
        if (i3 != 0) {
            if (i3 != 2) {
                return new LinearCurveFit(dArr, dArr2);
            }
            return new Constant(dArr[0], dArr2[0]);
        }
        return new MonotonicCurveFit(dArr, dArr2);
    }

    public static CurveFit getArc(int[] iArr, double[] dArr, double[][] dArr2) {
        return new ArcCurveFit(iArr, dArr, dArr2);
    }

    public abstract double getPos(double d16, int i3);

    public abstract void getPos(double d16, double[] dArr);

    public abstract void getPos(double d16, float[] fArr);

    public abstract double getSlope(double d16, int i3);

    public abstract void getSlope(double d16, double[] dArr);

    public abstract double[] getTimePoints();
}
