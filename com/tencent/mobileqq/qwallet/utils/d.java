package com.tencent.mobileqq.qwallet.utils;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static Method f279255a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f279256b;

    /* renamed from: c, reason: collision with root package name */
    private static Field f279257c;

    /* renamed from: d, reason: collision with root package name */
    private static int f279258d;

    static {
        try {
            f279255a = Activity.class.getMethod("setStatusBarDarkIcon", Integer.TYPE);
        } catch (NoSuchMethodException e16) {
            QLog.e("FlymeOSStatusBarFontUtils", 1, "error msg in qqpay-api module: ", e16);
        }
        try {
            f279256b = Activity.class.getMethod("setStatusBarDarkIcon", Boolean.TYPE);
        } catch (NoSuchMethodException e17) {
            QLog.e("FlymeOSStatusBarFontUtils", 1, "error msg in qqpay-api module: ", e17);
        }
        try {
            f279257c = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException e18) {
            QLog.e("FlymeOSStatusBarFontUtils", 1, "error msg in qqpay-api module: ", e18);
        }
        try {
            f279258d = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(null);
        } catch (IllegalAccessException e19) {
            QLog.e("FlymeOSStatusBarFontUtils", 1, "error msg in qqpay-api module: ", e19);
        } catch (NoSuchFieldException e26) {
            QLog.e("FlymeOSStatusBarFontUtils", 1, "error msg in qqpay-api module: ", e26);
        }
    }

    private static void a(Window window, int i3) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        Field field = f279257c;
        if (field != null) {
            try {
                if (field.getInt(attributes) != i3) {
                    f279257c.set(attributes, Integer.valueOf(i3));
                    window.setAttributes(attributes);
                }
            } catch (IllegalAccessException e16) {
                QLog.e("FlymeOSStatusBarFontUtils", 1, "error msg in qqpay-api module: ", e16);
            }
        }
    }

    public static void b(Activity activity, boolean z16) {
        c(activity, z16, true);
    }

    private static void c(Activity activity, boolean z16, boolean z17) {
        Method method = f279256b;
        if (method != null) {
            try {
                method.invoke(activity, Boolean.valueOf(z16));
                return;
            } catch (IllegalAccessException e16) {
                QLog.e("FlymeOSStatusBarFontUtils", 1, "error msg in qqpay-api module: ", e16);
                return;
            } catch (InvocationTargetException e17) {
                QLog.e("FlymeOSStatusBarFontUtils", 1, "error msg in qqpay-api module: ", e17);
                return;
            }
        }
        if (z17) {
            e(activity.getWindow(), z16);
        }
    }

    private static void d(View view, boolean z16) {
        int i3;
        int systemUiVisibility = view.getSystemUiVisibility();
        if (z16) {
            i3 = f279258d | systemUiVisibility;
        } else {
            i3 = (~f279258d) & systemUiVisibility;
        }
        if (i3 != systemUiVisibility) {
            view.setSystemUiVisibility(i3);
        }
    }

    public static void e(Window window, boolean z16) {
        View decorView = window.getDecorView();
        if (decorView != null) {
            d(decorView, z16);
            a(window, 0);
        }
    }
}
