package com.tencent.mobileqq.mini.entry.util;

import android.view.View;

/* loaded from: classes33.dex */
public class MiniAppDesktopPullAnimateUtil {
    private static final String TAG = "MiniAppDesktopPullAnimateUtil";

    MiniAppDesktopPullAnimateUtil() {
    }

    public static void setMiniAppDesktopAnimate(View view, float f16) {
        view.setScaleX(getMiniAppDesktopsScale(f16));
        view.setScaleY(getMiniAppDesktopsScale(f16));
        view.setAlpha(getMiniAppDesktopAlpha(f16));
    }

    public static float getMiniAppDesktopAlpha(float f16) {
        return Math.min(1.0f, (f16 <= 0.12f || f16 >= 0.3f) ? f16 > 0.3f ? 1.0f : 0.0f : (f16 - 0.12f) * 5.5555553f);
    }

    public static float getMiniAppDesktopsScale(float f16) {
        float f17 = 0.8f;
        if (f16 > 0.12f && f16 < 0.3f) {
            f17 = 0.8f + ((f16 - 0.12f) * 5.5555553f * 0.2f);
        } else if (f16 > 0.3f) {
            f17 = 1.0f;
        }
        return Math.min(1.0f, f17);
    }
}
