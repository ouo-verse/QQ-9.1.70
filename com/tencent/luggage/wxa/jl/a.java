package com.tencent.luggage.wxa.jl;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.luggage.wxa.tn.w;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        if (view instanceof ViewGroup) {
            ((ViewGroup) view).setDescendantFocusability(131072);
        }
        w.d("MicroMsg.AppBrand.AccessibilityExt", "doAccessibilityFocus, focused: " + view.requestFocus());
    }
}
