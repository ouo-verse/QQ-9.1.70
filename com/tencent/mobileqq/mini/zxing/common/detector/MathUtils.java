package com.tencent.mobileqq.mini.zxing.common.detector;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MathUtils {
    MathUtils() {
    }

    public static float distance(float f16, float f17, float f18, float f19) {
        double d16 = f16 - f18;
        double d17 = f17 - f19;
        return (float) Math.sqrt((d16 * d16) + (d17 * d17));
    }

    public static int round(float f16) {
        float f17;
        if (f16 < 0.0f) {
            f17 = -0.5f;
        } else {
            f17 = 0.5f;
        }
        return (int) (f16 + f17);
    }

    public static int sum(int[] iArr) {
        int i3 = 0;
        for (int i16 : iArr) {
            i3 += i16;
        }
        return i3;
    }

    public static float distance(int i3, int i16, int i17, int i18) {
        double d16 = i3 - i17;
        double d17 = i16 - i18;
        return (float) Math.sqrt((d16 * d16) + (d17 * d17));
    }
}
