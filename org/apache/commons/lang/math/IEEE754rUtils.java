package org.apache.commons.lang.math;

/* compiled from: P */
/* loaded from: classes29.dex */
public class IEEE754rUtils {
    public static double max(double[] dArr) {
        if (dArr != null) {
            if (dArr.length != 0) {
                double d16 = dArr[0];
                for (int i3 = 1; i3 < dArr.length; i3++) {
                    d16 = max(dArr[i3], d16);
                }
                return d16;
            }
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static double min(double[] dArr) {
        if (dArr != null) {
            if (dArr.length != 0) {
                double d16 = dArr[0];
                for (int i3 = 1; i3 < dArr.length; i3++) {
                    d16 = min(dArr[i3], d16);
                }
                return d16;
            }
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static float max(float[] fArr) {
        if (fArr != null) {
            if (fArr.length != 0) {
                float f16 = fArr[0];
                for (int i3 = 1; i3 < fArr.length; i3++) {
                    f16 = max(fArr[i3], f16);
                }
                return f16;
            }
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static float min(float[] fArr) {
        if (fArr != null) {
            if (fArr.length != 0) {
                float f16 = fArr[0];
                for (int i3 = 1; i3 < fArr.length; i3++) {
                    f16 = min(fArr[i3], f16);
                }
                return f16;
            }
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static double max(double d16, double d17, double d18) {
        return max(max(d16, d17), d18);
    }

    public static double min(double d16, double d17, double d18) {
        return min(min(d16, d17), d18);
    }

    public static double max(double d16, double d17) {
        return Double.isNaN(d16) ? d17 : Double.isNaN(d17) ? d16 : Math.max(d16, d17);
    }

    public static double min(double d16, double d17) {
        return Double.isNaN(d16) ? d17 : Double.isNaN(d17) ? d16 : Math.min(d16, d17);
    }

    public static float max(float f16, float f17, float f18) {
        return max(max(f16, f17), f18);
    }

    public static float min(float f16, float f17, float f18) {
        return min(min(f16, f17), f18);
    }

    public static float max(float f16, float f17) {
        return Float.isNaN(f16) ? f17 : Float.isNaN(f17) ? f16 : Math.max(f16, f17);
    }

    public static float min(float f16, float f17) {
        return Float.isNaN(f16) ? f17 : Float.isNaN(f17) ? f16 : Math.min(f16, f17);
    }
}
