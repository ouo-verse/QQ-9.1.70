package com.tencent.gamematrix.gmcg.base.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGDisplayUtil {
    public static String deleteQuotation(String str) {
        if (str.length() > 0 && str.substring(0, 1).equals("\"") && str.substring(str.length() - 1, str.length()).equals("\"")) {
            String substring = str.substring(1, str.length() - 1);
            if (substring.substring(0, 1).equals("'") && substring.substring(substring.length() - 1, substring.length()).equals("'")) {
                return substring.substring(1, substring.length() - 1);
            }
            return substring;
        }
        return str;
    }

    public static int dip2px(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getActionBarHeight(Context context) {
        return new Rect().top;
    }

    public static float getScaledDensity(Context context) {
        return context.getResources().getDisplayMetrics().scaledDensity;
    }

    @TargetApi(17)
    public static int getScreenHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    @TargetApi(17)
    public static int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static float getStatusBarHeight(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(((Integer) cls.getField("status_bar_height").get(cls.newInstance())).intValue());
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0.0f;
        }
    }

    public static int px2dip(Context context, float f16) {
        return (int) ((f16 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2sp(Context context, float f16) {
        return (int) ((f16 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int sp2px(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
