package com.tencent.qcircle.tavcut.util;

/* compiled from: P */
/* loaded from: classes22.dex */
public class FloatUtils {
    public static boolean isEquals(float f16, float f17) {
        return ((double) Math.abs(f16 - f17)) < 1.0E-13d;
    }

    public static boolean isEqualsToZero(double d16) {
        return Math.abs(d16) < 1.0E-13d;
    }

    public static boolean isEquals(double d16, double d17) {
        return Math.abs(d16 - d17) < 1.0E-13d;
    }

    public static boolean isEqualsToZero(float f16) {
        return ((double) Math.abs(f16)) < 1.0E-13d;
    }
}
