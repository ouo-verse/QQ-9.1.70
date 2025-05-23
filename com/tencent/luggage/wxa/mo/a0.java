package com.tencent.luggage.wxa.mo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a0 {
    public static final int a(Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return com.tencent.luggage.wxa.kn.a.a(context, i3);
    }

    public static final int b(Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return ContextCompat.getColor(context, i3);
    }

    public static final int c(Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getResources().getDimensionPixelSize(i3);
    }

    public static final Drawable d(Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return ContextCompat.getDrawable(context, i3);
    }

    public static final String e(Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        String string = context.getResources().getString(i3);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(id)");
        return string;
    }

    public static final View a(View view, String name) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        View b16 = b(view, name);
        Intrinsics.checkNotNull(b16);
        return b16;
    }

    public static final View b(View view, String name) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(name, "name");
        if (view.getId() == name.hashCode()) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            Intrinsics.checkNotNullExpressionValue(childAt, "view.getChildAt(i)");
            View b16 = b(childAt, name);
            if (b16 != null) {
                return b16;
            }
        }
        return null;
    }

    public static final void c(View view, String value) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        if (view.getId() == -1) {
            isBlank = StringsKt__StringsJVMKt.isBlank(value);
            if (!isBlank) {
                view.setId(value.hashCode());
                return;
            }
            return;
        }
        throw new IllegalArgumentException("already had id");
    }

    public static final void d(View view, int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPadding(b(view), i3, c(view), a(view));
    }

    public static final void a(View view, int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPadding(b(view), d(view), c(view), i3);
    }

    public static final int d(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getPaddingTop();
    }

    public static final int a(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getPaddingBottom();
    }

    public static final void b(View view, int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPadding(i3, d(view), c(view), a(view));
    }

    public static final void c(View view, int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPadding(b(view), d(view), i3, a(view));
    }

    public static final int b(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getPaddingLeft();
    }

    public static final int c(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getPaddingRight();
    }
}
