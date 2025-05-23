package com.tencent.icgame.game.utils;

import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes7.dex */
public class j {
    public static boolean a(Window window, boolean z16) {
        int i3;
        if (window != null) {
            try {
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i16 = declaredField.getInt(null);
                int i17 = declaredField2.getInt(attributes);
                if (z16) {
                    i3 = i17 | i16;
                } else {
                    i3 = (~i16) & i17;
                }
                declaredField2.setInt(attributes, i3);
                window.setAttributes(attributes);
                return true;
            } catch (Exception e16) {
                g.k("ICGameStatusBarUtil_", "", e16);
            }
        }
        return false;
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
            g.k("ICGameStatusBarUtil_", "", e16);
            return false;
        }
    }

    public static void c(Window window) {
        int i3 = Build.VERSION.SDK_INT;
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (i3 >= 28) {
            attributes.layoutInDisplayCutoutMode = 1;
        }
        window.setAttributes(attributes);
    }

    public static int d(Window window) {
        if (!b(window, true)) {
            a(window, true);
        }
        window.getDecorView().setSystemUiVisibility(9216);
        return 3;
    }
}
