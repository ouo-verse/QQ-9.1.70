package com.tencent.mobileqq.util;

import android.app.Activity;
import com.tencent.widget.immersive.SystemBarCompact;

/* compiled from: P */
/* loaded from: classes20.dex */
public class cp {
    public static void a(Activity activity, int i3) {
        SystemBarCompact systemBarCompact = new SystemBarCompact(activity, true, -1);
        systemBarCompact.init();
        systemBarCompact.setStatusBarColor(i3);
    }
}
