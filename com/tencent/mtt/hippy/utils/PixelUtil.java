package com.tencent.mtt.hippy.utils;

import android.util.DisplayMetrics;
import android.util.TypedValue;

/* loaded from: classes20.dex */
public class PixelUtil {
    private static DisplayMetrics sDisplayMetrics;

    public static float dp2px(double d16) {
        return dp2px((float) d16);
    }

    public static float getDensity() {
        return getMetrics().density;
    }

    private static DisplayMetrics getMetrics() {
        if (sDisplayMetrics == null) {
            sDisplayMetrics = ContextHolder.getAppContext().getResources().getDisplayMetrics();
        }
        return sDisplayMetrics;
    }

    public static float px2dp(float f16) {
        return f16 / getDensity();
    }

    public static float px2sp(float f16) {
        return f16 / getMetrics().scaledDensity;
    }

    public static void setDisplayMetrics(DisplayMetrics displayMetrics) {
        sDisplayMetrics = displayMetrics;
    }

    public static float sp2px(float f16) {
        return TypedValue.applyDimension(2, f16, getMetrics());
    }

    public static float dp2px(float f16) {
        return TypedValue.applyDimension(1, f16, getMetrics());
    }
}
