package com.tencent.luggage.wxa.po;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.luggage.wxa.lo.f;
import com.tencent.mm.ui.statusbar.DrawStatusBarFrameLayout;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static DrawStatusBarFrameLayout a(View view) {
        if (view == null) {
            return null;
        }
        while (!(view instanceof DrawStatusBarFrameLayout)) {
            Object parent = view.getParent();
            if (parent == null || !(parent instanceof ViewGroup)) {
                return null;
            }
            view = (View) parent;
        }
        return (DrawStatusBarFrameLayout) view;
    }

    public static void a(View view, int i3, boolean z16) {
        if (view != null && com.tencent.mm.ui.statusbar.a.f152668g) {
            DrawStatusBarFrameLayout a16 = a(view);
            if (a16 != null) {
                a16.a(i3, z16);
                return;
            }
            Activity h16 = b.h(view.getContext());
            if (h16 == null || h16.getWindow() == null) {
                return;
            }
            h16.getWindow().setStatusBarColor(i3);
            f.b(h16.getWindow(), z16);
        }
    }

    public static int a(Activity activity) {
        if (com.tencent.mm.ui.statusbar.a.f152668g && activity != null) {
            return com.tencent.mm.ui.statusbar.a.a(activity).c();
        }
        return 0;
    }
}
