package com.tencent.mobileqq.zootopia.utils;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\n\u0010\u0005\u001a\u00020\u0003*\u00020\u0000\u001a\u001e\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\t\u001a\u00020\b\"\u00020\u0006\u001a-\u0010\u0011\u001a\u00020\u0003\"\b\b\u0000\u0010\r*\u00020\f*\u00020\u00002\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u000e\u00a2\u0006\u0002\b\u000f\u00a8\u0006\u0012"}, d2 = {"Landroid/view/View;", "", ViewStickEventHelper.IS_SHOW, "", "c", "b", "", "radius", "", NodeProps.COLORS, "Landroid/graphics/drawable/GradientDrawable;", "a", "Landroid/view/ViewGroup$LayoutParams;", "T", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "block", "d", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class l {
    public static final GradientDrawable a(View view, int i3, int... colors) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(colors, "colors");
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (colors.length > 1) {
            gradientDrawable.setColors(colors);
        } else {
            gradientDrawable.setColor(colors[0]);
        }
        gradientDrawable.setCornerRadius(i3);
        view.setBackgroundDrawable(gradientDrawable);
        return gradientDrawable;
    }

    public static final void b(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
    }

    public static final void c(View view, boolean z16) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (z16) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public static final <T extends ViewGroup.LayoutParams> void d(View view, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type T of com.tencent.mobileqq.zootopia.utils.ViewExKt.updateLayoutParams");
        block.invoke(layoutParams);
        view.setLayoutParams(layoutParams);
    }
}
