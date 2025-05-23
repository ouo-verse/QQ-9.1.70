package com.tencent.luggage.wxa.ml;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.luggage.wxa.uk.n0;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public static final t f134779a = new t();

    public static /* synthetic */ void a(t tVar, Context context, View view, View view2, int i3, com.tencent.luggage.wxa.wj.c cVar, boolean z16, int i16, Object obj) {
        if ((i16 & 32) != 0) {
            z16 = false;
        }
        tVar.a(context, view, view2, i3, cVar, z16);
    }

    public final void a(Context context, View rootView, View view, int i3, com.tencent.luggage.wxa.wj.c window, boolean z16) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(window, "window");
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        int i16 = R.dimen.c3i;
        if (i3 != 1 && i3 != 3) {
            if ((view != null ? view.getParent() : null) instanceof RelativeLayout) {
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                Resources resources = context.getResources();
                if (!z16) {
                    i16 = R.dimen.c3h;
                }
                layoutParams2.bottomMargin = resources.getDimensionPixelSize(i16);
            }
            if (window.shouldInLargeScreenCompatMode() || !a(context)) {
                ViewGroup.LayoutParams layoutParams3 = rootView.getLayoutParams();
                layoutParams3.width = -1;
                rootView.setLayoutParams(layoutParams3);
                return;
            } else {
                if ((view != null ? view.getParent() : null) instanceof RelativeLayout) {
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.c3g);
                    return;
                }
                return;
            }
        }
        if ((view != null ? view.getParent() : null) instanceof RelativeLayout) {
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams;
            Resources resources2 = context.getResources();
            if (!z16) {
                i16 = R.dimen.c3g;
            }
            layoutParams4.bottomMargin = resources2.getDimensionPixelSize(i16);
        }
        if (rootView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.LayoutParams layoutParams5 = rootView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = context.getResources().getDimensionPixelSize(R.dimen.c3l);
        }
        if (window.shouldInLargeScreenCompatMode()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams6 = rootView.getLayoutParams();
        layoutParams6.width = context.getResources().getDimensionPixelSize(R.dimen.c3k);
        rootView.setLayoutParams(layoutParams6);
    }

    public final boolean a(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static final void a(Context context, int[] dialogMeasuredWidthHeight, DisplayMetrics dm5) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dialogMeasuredWidthHeight, "dialogMeasuredWidthHeight");
        Intrinsics.checkNotNullParameter(dm5, "dm");
        if (n0.a(context) || context.getResources().getConfiguration().orientation == 2) {
            int i3 = dialogMeasuredWidthHeight[0];
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.c3k);
            int max = Math.max(dimensionPixelSize, context.getResources().getDisplayMetrics().widthPixels / 2);
            if (i3 < dimensionPixelSize) {
                i3 = dimensionPixelSize;
            } else if (i3 > max) {
                i3 = max;
            }
            dialogMeasuredWidthHeight[0] = i3;
        }
    }
}
