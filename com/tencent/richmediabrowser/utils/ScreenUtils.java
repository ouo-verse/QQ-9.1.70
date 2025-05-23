package com.tencent.richmediabrowser.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ScreenUtils {
    public static int dip2px(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getScreenHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        windowManager.getDefaultDisplay().getMetrics(new DisplayMetrics());
        return windowManager.getDefaultDisplay().getHeight();
    }

    public static int getScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        windowManager.getDefaultDisplay().getMetrics(new DisplayMetrics());
        return windowManager.getDefaultDisplay().getWidth();
    }

    public static int px2dip(Context context, float f16) {
        return (int) ((f16 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
