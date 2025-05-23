package com.tencent.richmediabrowser.animation;

import android.graphics.Rect;

/* compiled from: P */
/* loaded from: classes25.dex */
public class AnimationUtils {
    private static final float HEIGHER_IMGE_FACTOR = 1.5f;

    public static float getAIOImageScale(int i3, int i16, int i17, int i18) {
        float f16 = 1.0f;
        if (i3 == 0 || i16 == 0) {
            return 1.0f;
        }
        int i19 = (i16 * i17) / i3;
        if ((!isLongPhoto(i3, i16) || i3 > i17 || i16 > i18) && (i3 >= 135 || i16 >= 135)) {
            f16 = i18 >= i19 ? i17 / i3 : i18 / i16;
        }
        return Math.min(f16, 2.0f);
    }

    public static Rect getAnimationEndDstRect(int i3, int i16, int i17, int i18, boolean z16) {
        char c16;
        float aIOImageScale = getAIOImageScale(i3, i16, i17, i18);
        if (!(i16 >= i3 * 3) || ((i3 <= i17 && i16 <= i18) || (i3 < 135 && i16 < 135))) {
            c16 = 17;
        } else {
            aIOImageScale = Math.min(i17 / i3, 2.0f);
            c16 = '1';
        }
        if (z16 || aIOImageScale <= 1.0f) {
            i3 = (int) (i3 * aIOImageScale);
            i16 = (int) (i16 * aIOImageScale);
        }
        Rect rect = new Rect(0, 0, i3, i16);
        if (c16 == '1') {
            rect.offset((i17 - i3) / 2, 0);
        } else if (c16 == 17) {
            rect.offset((i17 - i3) / 2, (i18 - i16) / 2);
        }
        return rect;
    }

    public static boolean isLongPhoto(long j3, long j16) {
        if (j3 < j16 * 3 && j16 < j3 * 3) {
            return false;
        }
        return true;
    }

    public static Rect getAnimationEndDstRect(int i3, int i16, int i17, int i18) {
        return getAnimationEndDstRect(i3, i16, i17, i18, true);
    }
}
