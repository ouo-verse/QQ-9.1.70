package com.qq.e.comm.plugin.k;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ba {
    public static void a(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }
}
