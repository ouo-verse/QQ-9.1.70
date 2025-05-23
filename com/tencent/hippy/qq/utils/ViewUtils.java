package com.tencent.hippy.qq.utils;

import android.util.DisplayMetrics;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ViewUtils {
    public static int getScreenSmallerSideWidth() {
        DisplayMetrics displayMetrics = HippyUtils.getDisplayMetrics();
        if (displayMetrics == null) {
            return 0;
        }
        int i3 = displayMetrics.widthPixels;
        int i16 = displayMetrics.heightPixels;
        if (i3 >= i16) {
            return i16;
        }
        return i3;
    }
}
