package com.tencent.biz.qui.quicommon;

import android.os.Build;
import android.view.Window;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    public static void a(Window window, int i3) {
        if (window == null) {
            return;
        }
        window.addFlags(Integer.MIN_VALUE);
        window.setNavigationBarColor(i3);
    }

    public static void b(@NonNull Window window) {
        if (Build.VERSION.SDK_INT >= 29) {
            window.setNavigationBarContrastEnforced(false);
        }
        a(window, 0);
    }
}
