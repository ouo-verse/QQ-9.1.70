package com.tencent.biz.richframework.compat;

import android.app.Activity;
import android.view.Window;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWThemeUtil {
    public static void setNavigationBarColor(Activity activity, int i3) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.setNavigationBarColor(i3);
    }

    public static void setStatusBarColor(Activity activity, int i3) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.clearFlags(67108864);
        ImmersiveUtils.setSystemUiVisibilityUsedOr(window, 1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i3);
    }

    public static boolean setStatusTextColor(boolean z16, Window window) {
        return ImmersiveUtils.setStatusTextColor(z16, window);
    }
}
