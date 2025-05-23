package org.jbox2d.common;

/* loaded from: classes29.dex */
class PlatformMathUtils {
    private static final float INV_SHIFT23 = 1.1920929E-7f;
    private static final float SHIFT23 = 8388608.0f;

    public static final float fastPow(float f16, float f17) {
        int i3;
        int i16;
        float floatToRawIntBits = (Float.floatToRawIntBits(f16) * 1.1920929E-7f) - 127.0f;
        if (floatToRawIntBits >= 0.0f) {
            i3 = (int) floatToRawIntBits;
        } else {
            i3 = ((int) floatToRawIntBits) - 1;
        }
        float f18 = floatToRawIntBits - i3;
        float f19 = f17 * (floatToRawIntBits + ((f18 - (f18 * f18)) * 0.346607f));
        if (f19 >= 0.0f) {
            i16 = (int) f19;
        } else {
            i16 = ((int) f19) - 1;
        }
        float f26 = f19 - i16;
        return Float.intBitsToFloat((int) (((f19 + 127.0f) - ((f26 - (f26 * f26)) * 0.33971f)) * SHIFT23));
    }
}
