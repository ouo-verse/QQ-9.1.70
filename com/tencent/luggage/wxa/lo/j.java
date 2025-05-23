package com.tencent.luggage.wxa.lo;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class j {
    public static final void a(View view, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = i3;
        }
    }

    public static final void b(View view, int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i3);
    }
}
