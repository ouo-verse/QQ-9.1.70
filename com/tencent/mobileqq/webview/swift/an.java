package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes20.dex */
public class an {
    static IPatchRedirector $redirector_;

    public static void a(Activity activity) {
        b(activity, 1);
    }

    public static void b(Activity activity, int i3) {
        if (Build.VERSION.SDK_INT >= 28 && activity != null) {
            Window window = activity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = i3;
            window.setAttributes(attributes);
        }
    }

    public static void c(Activity activity, ClassCastException classCastException) {
        QLog.e("WebViewUIUtils", 1, Log.getStackTraceString(classCastException.getCause()));
        try {
            View decorView = activity.getWindow().getDecorView();
            h(decorView, "mStatusColorViewState");
            h(decorView, "mNavigationColorViewState");
        } catch (Throwable th5) {
            QLog.e("WebViewUIUtils", 1, "dumpViewInError ", th5);
        }
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isGrayVersion()) {
        } else {
            throw new RuntimeException(classCastException.getCause());
        }
    }

    public static int d(Activity activity) {
        int i3;
        if (Build.VERSION.SDK_INT >= 28 && activity != null) {
            i3 = activity.getWindow().getAttributes().layoutInDisplayCutoutMode;
            return i3;
        }
        return 0;
    }

    public static void e(Activity activity) {
        if (activity != null) {
            activity.getWindow().getDecorView().setSystemUiVisibility(5894);
        }
    }

    public static void f(Activity activity) {
        if (activity != null) {
            activity.getWindow().getDecorView().setSystemUiVisibility(0);
        }
    }

    private static void g(View view, StringBuilder sb5) {
        if (view == null) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                if (viewGroup.getChildAt(i3) instanceof ViewGroup) {
                    g(view, sb5);
                } else {
                    sb5.append("view:");
                    sb5.append(view.getClass().getSimpleName());
                    sb5.append("\n");
                }
            }
            return;
        }
        sb5.append("view:");
        sb5.append(view.getClass().getSimpleName());
        sb5.append("\n");
    }

    private static void h(View view, String str) throws IllegalAccessException, NoSuchFieldException {
        Field declaredField = view.getClass().getDeclaredField(str);
        if (declaredField == null) {
            QLog.e("WebViewUIUtils", 1, str, " field is null");
            return;
        }
        declaredField.setAccessible(true);
        Object obj = declaredField.get(view);
        if (obj == null) {
            QLog.e("WebViewUIUtils", 1, str, " statusAttri is null");
            return;
        }
        Field declaredField2 = obj.getClass().getDeclaredField("view");
        if (declaredField2 == null) {
            QLog.e("WebViewUIUtils", 1, str, " viewField is null");
            return;
        }
        declaredField2.setAccessible(true);
        View view2 = (View) declaredField2.get(obj);
        if (view2 != null) {
            StringBuilder sb5 = new StringBuilder(100);
            g(view2, sb5);
            QLog.e("WebViewUIUtils", 1, str, sb5.toString());
            return;
        }
        QLog.d("WebViewUIUtils", 1, str, " viewFromState is null");
    }
}
