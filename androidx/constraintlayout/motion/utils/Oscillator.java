package androidx.constraintlayout.motion.utils;

import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes.dex */
public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;
    double[] mArea;
    int mType;
    float[] mPeriod = new float[0];
    double[] mPosition = new double[0];
    double PI2 = 6.283185307179586d;
    private boolean mNormalized = false;

    public void addPoint(double d16, float f16) {
        int length = this.mPeriod.length + 1;
        int binarySearch = Arrays.binarySearch(this.mPosition, d16);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.mPosition = Arrays.copyOf(this.mPosition, length);
        this.mPeriod = Arrays.copyOf(this.mPeriod, length);
        this.mArea = new double[length];
        double[] dArr = this.mPosition;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.mPosition[binarySearch] = d16;
        this.mPeriod[binarySearch] = f16;
        this.mNormalized = false;
    }

    double getDP(double d16) {
        if (d16 <= 0.0d) {
            d16 = 1.0E-5d;
        } else if (d16 >= 1.0d) {
            d16 = 0.999999d;
        }
        int binarySearch = Arrays.binarySearch(this.mPosition, d16);
        if (binarySearch > 0 || binarySearch == 0) {
            return 0.0d;
        }
        int i3 = (-binarySearch) - 1;
        float[] fArr = this.mPeriod;
        float f16 = fArr[i3];
        int i16 = i3 - 1;
        float f17 = fArr[i16];
        double d17 = f16 - f17;
        double[] dArr = this.mPosition;
        double d18 = dArr[i3];
        double d19 = dArr[i16];
        double d26 = d17 / (d18 - d19);
        return (f17 - (d26 * d19)) + (d16 * d26);
    }

    double getP(double d16) {
        if (d16 < 0.0d) {
            d16 = 0.0d;
        } else if (d16 > 1.0d) {
            d16 = 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.mPosition, d16);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch == 0) {
            return 0.0d;
        }
        int i3 = (-binarySearch) - 1;
        float[] fArr = this.mPeriod;
        float f16 = fArr[i3];
        int i16 = i3 - 1;
        float f17 = fArr[i16];
        double d17 = f16 - f17;
        double[] dArr = this.mPosition;
        double d18 = dArr[i3];
        double d19 = dArr[i16];
        double d26 = d17 / (d18 - d19);
        return this.mArea[i16] + ((f17 - (d26 * d19)) * (d16 - d19)) + ((d26 * ((d16 * d16) - (d19 * d19))) / 2.0d);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
    public double getSlope(double d16) {
        double dp5;
        double signum;
        double dp6;
        double dp7;
        double sin;
        switch (this.mType) {
            case 1:
                return 0.0d;
            case 2:
                dp5 = getDP(d16) * 4.0d;
                signum = Math.signum((((getP(d16) * 4.0d) + 3.0d) % 4.0d) - 2.0d);
                return dp5 * signum;
            case 3:
                dp6 = getDP(d16);
                return dp6 * 2.0d;
            case 4:
                dp6 = -getDP(d16);
                return dp6 * 2.0d;
            case 5:
                dp7 = (-this.PI2) * getDP(d16);
                sin = Math.sin(this.PI2 * getP(d16));
                return dp7 * sin;
            case 6:
                dp5 = getDP(d16) * 4.0d;
                signum = (((getP(d16) * 4.0d) + 2.0d) % 4.0d) - 2.0d;
                return dp5 * signum;
            default:
                dp7 = this.PI2 * getDP(d16);
                sin = Math.cos(this.PI2 * getP(d16));
                return dp7 * sin;
        }
    }

    public double getValue(double d16) {
        double abs;
        switch (this.mType) {
            case 1:
                return Math.signum(0.5d - (getP(d16) % 1.0d));
            case 2:
                abs = Math.abs((((getP(d16) * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((getP(d16) * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                abs = ((getP(d16) * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos(this.PI2 * getP(d16));
            case 6:
                double abs2 = 1.0d - Math.abs(((getP(d16) * 4.0d) % 4.0d) - 2.0d);
                abs = abs2 * abs2;
                break;
            default:
                return Math.sin(this.PI2 * getP(d16));
        }
        return 1.0d - abs;
    }

    public void normalize() {
        double d16 = 0.0d;
        int i3 = 0;
        while (true) {
            if (i3 >= this.mPeriod.length) {
                break;
            }
            d16 += r7[i3];
            i3++;
        }
        double d17 = 0.0d;
        int i16 = 1;
        while (true) {
            float[] fArr = this.mPeriod;
            if (i16 >= fArr.length) {
                break;
            }
            int i17 = i16 - 1;
            float f16 = (fArr[i17] + fArr[i16]) / 2.0f;
            double[] dArr = this.mPosition;
            d17 += (dArr[i16] - dArr[i17]) * f16;
            i16++;
        }
        int i18 = 0;
        while (true) {
            float[] fArr2 = this.mPeriod;
            if (i18 >= fArr2.length) {
                break;
            }
            fArr2[i18] = (float) (fArr2[i18] * (d16 / d17));
            i18++;
        }
        this.mArea[0] = 0.0d;
        int i19 = 1;
        while (true) {
            float[] fArr3 = this.mPeriod;
            if (i19 < fArr3.length) {
                int i26 = i19 - 1;
                float f17 = (fArr3[i26] + fArr3[i19]) / 2.0f;
                double[] dArr2 = this.mPosition;
                double d18 = dArr2[i19] - dArr2[i26];
                double[] dArr3 = this.mArea;
                dArr3[i19] = dArr3[i26] + (d18 * f17);
                i19++;
            } else {
                this.mNormalized = true;
                return;
            }
        }
    }

    public void setType(int i3) {
        this.mType = i3;
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.mPosition) + " period=" + Arrays.toString(this.mPeriod);
    }
}
