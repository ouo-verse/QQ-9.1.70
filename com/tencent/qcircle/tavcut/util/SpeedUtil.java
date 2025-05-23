package com.tencent.qcircle.tavcut.util;

import java.math.BigDecimal;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SpeedUtil {
    public static final float MAX_SPEED = 5.0f;
    public static final float MIN_SPEED = 0.2f;

    public static float convertSeekValue(int i3) {
        if (i3 <= 50) {
            return (((i3 * 1.0f) / 50.0f) * 0.8f) + 0.2f;
        }
        return ((((i3 * 1.0f) - 50.0f) / 50.0f) * 4.0f) + 1.0f;
    }

    public static int convertSpeedToSeekValue(float f16) {
        float f17;
        if (f16 > 1.0f) {
            f17 = (((f16 - 1.0f) / 4.0f) * 50.0f) + 50.0f;
        } else if (f16 < 1.0f) {
            f17 = ((f16 - 0.2f) / 0.8f) * 50.0f;
        } else {
            return 50;
        }
        return (int) f17;
    }

    public static boolean floatEqual(float f16, float f17) {
        if (Math.abs(f16 - f17) < 1.0E-5d) {
            return true;
        }
        return false;
    }

    public static float getPreciseValue(float f16) {
        return getPreciseValue(f16, 1);
    }

    public static float getPreciseValue(float f16, int i3) {
        return new BigDecimal(f16).setScale(Math.max(i3, 1), 4).floatValue();
    }
}
