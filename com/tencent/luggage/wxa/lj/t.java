package com.tencent.luggage.wxa.lj;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public static final t f133575a = new t();

    public static final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        a(view, null, 1, null);
    }

    public static final void b(View view, Context context) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        w.d("Luggage.WAGameCapsuleBarStyleApplier", "setupCapsuleMarginsForGame, this:" + view.getClass().getSimpleName() + ", context:" + context.getClass().getSimpleName() + ", density:" + context.getResources().getDisplayMetrics().density);
        if (view instanceof d) {
            view = ((d) view).getCapsuleContentAreaView();
        } else if (!(view instanceof AppBrandCapsuleBarPlaceHolderView)) {
            throw new IllegalStateException("Unrecognized View class".toString());
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            t tVar = f133575a;
            marginLayoutParams.rightMargin = tVar.a(context, R.dimen.c1e) + tVar.a(context, R.dimen.c1y);
            view.requestLayout();
        }
    }

    public static /* synthetic */ void a(View view, Context context, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "this.context");
        }
        a(view, context);
    }

    public static final void a(View view, Context context) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        w.d("Luggage.WAGameCapsuleBarStyleApplier", "setupCapsuleContainerMarginForGame, this:" + view.getClass().getSimpleName() + ", context:" + context.getClass().getSimpleName() + ", density:" + context.getResources().getDisplayMetrics().density);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            t tVar = f133575a;
            marginLayoutParams.topMargin = tVar.a(context, R.dimen.c1z);
            marginLayoutParams.height = tVar.a(context, R.dimen.bfh);
            view.requestLayout();
        }
    }

    public final int a(Context context, int i3) {
        return context.getResources().getDimensionPixelSize(i3);
    }
}
