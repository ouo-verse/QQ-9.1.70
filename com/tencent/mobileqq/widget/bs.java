package com.tencent.mobileqq.widget;

import android.view.View;
import android.widget.FrameLayout;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bs {

    /* renamed from: a, reason: collision with root package name */
    private static long f316779a = 400;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f316780b = false;

    public static void a() {
        f316780b = false;
    }

    public static void b(FrameLayout frameLayout) {
        if (f316780b) {
            return;
        }
        f316780b = true;
        frameLayout.invalidate();
        View childAt = frameLayout.getChildAt(1);
        View childAt2 = frameLayout.getChildAt(0);
        c cVar = new c(childAt);
        cVar.setDuration(f316779a);
        cVar.setFillAfter(true);
        d dVar = new d(childAt2);
        dVar.setDuration(f316779a);
        dVar.setFillAfter(true);
        childAt.startAnimation(cVar);
        childAt2.startAnimation(dVar);
    }
}
