package com.facebook.yoga;

/* compiled from: P */
/* loaded from: classes2.dex */
public class YogaMeasureOutput {
    public static float getHeight(long j3) {
        return Float.intBitsToFloat((int) (j3 & (-1)));
    }

    public static float getWidth(long j3) {
        return Float.intBitsToFloat((int) ((j3 >> 32) & (-1)));
    }

    public static long make(float f16, float f17) {
        return Float.floatToRawIntBits(f17) | (Float.floatToRawIntBits(f16) << 32);
    }

    public static long make(int i3, int i16) {
        return make(i3, i16);
    }
}
