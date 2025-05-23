package com.tencent.tavsticker.utils;

import android.content.res.Resources;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ScreenUtil {
    private static final String TAG = "ScreenUtil";

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getStatusBarHeight() {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return Resources.getSystem().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }
}
