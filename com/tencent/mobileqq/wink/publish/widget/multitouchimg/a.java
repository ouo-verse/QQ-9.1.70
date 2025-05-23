package com.tencent.mobileqq.wink.publish.widget.multitouchimg;

import android.annotation.TargetApi;
import android.view.View;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a {
    public static void a(View view, Runnable runnable) {
        b(view, runnable);
    }

    @TargetApi(16)
    private static void b(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
