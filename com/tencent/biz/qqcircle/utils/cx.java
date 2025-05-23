package com.tencent.biz.qqcircle.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class cx {

    /* renamed from: a, reason: collision with root package name */
    private static int f92753a = -1;

    /* renamed from: b, reason: collision with root package name */
    private static int f92754b = -1;

    /* renamed from: c, reason: collision with root package name */
    public static int f92755c = 480;

    public static int a(float f16) {
        return (int) ((f16 * RFWApplication.getApplication().getResources().getDisplayMetrics().density) + 0.5f);
    }

    @TargetApi(13)
    public static int b(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        int i3 = point.y;
        f92755c = i3;
        return i3;
    }

    @TargetApi(13)
    public static int c(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.x;
    }

    public static int d(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier != 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int e(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (NoSuchMethodException e16) {
            QLog.e("ViewUtils", 1, e16.getMessage());
            return -1;
        }
    }

    public static int f() {
        if (f92754b < 0) {
            if (RFWApplication.getApplication().getResources().getConfiguration().orientation == 2) {
                f92754b = RFWApplication.getApplication().getResources().getDisplayMetrics().widthPixels;
            } else {
                f92754b = RFWApplication.getApplication().getResources().getDisplayMetrics().heightPixels;
            }
        }
        return f92754b;
    }

    public static int g() {
        if (f92753a < 0) {
            if (RFWApplication.getApplication().getResources().getConfiguration().orientation == 2) {
                f92753a = RFWApplication.getApplication().getResources().getDisplayMetrics().heightPixels;
            } else {
                f92753a = RFWApplication.getApplication().getResources().getDisplayMetrics().widthPixels;
            }
        }
        return f92753a;
    }

    public static int h() {
        Resources resources = RFWApplication.getApplication().getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean i(View view, boolean z16, boolean z17) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        Rect rect2 = new Rect();
        if (!view.getLocalVisibleRect(rect2)) {
            return true;
        }
        if (rect2.top < 0 && z17) {
            return true;
        }
        if (rect2.left < 0 && z16) {
            return true;
        }
        int abs = Math.abs(Math.abs(rect.left - rect.right) - Math.abs(rect2.left - rect2.right));
        int abs2 = Math.abs(Math.abs(rect.top - rect.bottom) - Math.abs(rect2.top - rect2.bottom));
        if ((!z16 || abs == 0) && (!z17 || abs2 == 0)) {
            return false;
        }
        return true;
    }

    public static int j(float f16) {
        return (int) ((f16 / RFWApplication.getApplication().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int k(float f16) {
        return (int) ((f16 * RFWApplication.getApplication().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
