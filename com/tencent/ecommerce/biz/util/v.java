package com.tencent.ecommerce.biz.util;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public class v {
    private static void a(Window window, boolean z16) {
        View decorView = window.getDecorView();
        if (z16) {
            decorView.setSystemUiVisibility(9216);
        } else {
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-8193));
        }
    }

    public static boolean b(Window window, boolean z16) {
        a(window, z16);
        return true;
    }

    public static boolean c(Window window, boolean z16) {
        boolean z17 = false;
        if (window != null) {
            try {
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i3 = declaredField.getInt(null);
                int i16 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, z16 ? i3 | i16 : (~i3) & i16);
                window.setAttributes(attributes);
                z17 = true;
            } catch (Exception unused) {
                if (cg0.a.c()) {
                    cg0.a.a(ImmersiveUtils.TAG, "setStatusBarDarkModeForFlyme", "setStatusBarDarkModeForFlyme: failed");
                }
            }
            View decorView = window.getDecorView();
            if (decorView != null) {
                int systemUiVisibility = decorView.getSystemUiVisibility();
                int i17 = z16 ? systemUiVisibility | 8192 : systemUiVisibility & (-8193);
                if (i17 != systemUiVisibility) {
                    decorView.setSystemUiVisibility(i17);
                }
            }
        }
        return z17;
    }
}
