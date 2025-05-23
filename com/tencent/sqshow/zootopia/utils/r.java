package com.tencent.sqshow.zootopia.utils;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes34.dex */
public class r {
    public static boolean a(Window window, boolean z16) {
        if (window != null) {
            try {
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i3 = declaredField.getInt(null);
                int i16 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, z16 ? i16 | i3 : (~i3) & i16);
                window.setAttributes(attributes);
                return true;
            } catch (Exception e16) {
                QLog.w("StatusBarUtil_", 2, "", e16);
            }
        }
        return false;
    }

    public static void d(Activity activity) {
        Window window = activity.getWindow();
        window.clearFlags(201326592);
        window.getDecorView().setSystemUiVisibility(1792);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
    }

    public static int c(Window window) {
        if (!b(window, true)) {
            a(window, true);
        }
        window.getDecorView().setSystemUiVisibility(9216);
        return 3;
    }

    public static boolean b(Window window, boolean z16) {
        if (window == null) {
            return false;
        }
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i3 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Class<?> cls3 = Integer.TYPE;
            Method method = cls.getMethod("setExtraFlags", cls3, cls3);
            if (z16) {
                method.invoke(window, Integer.valueOf(i3), Integer.valueOf(i3));
            } else {
                method.invoke(window, 0, Integer.valueOf(i3));
            }
            return true;
        } catch (Exception e16) {
            QLog.w("StatusBarUtil_", 2, "", e16);
            return false;
        }
    }
}
