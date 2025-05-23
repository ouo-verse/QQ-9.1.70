package com.tencent.mobileqq.wink.utils;

import android.app.Activity;
import android.view.Window;

/* compiled from: P */
/* loaded from: classes21.dex */
public class q {
    public static void a(Activity activity, int i3) {
        if (activity == null) {
            return;
        }
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i3);
        window.setNavigationBarColor(i3);
    }
}
