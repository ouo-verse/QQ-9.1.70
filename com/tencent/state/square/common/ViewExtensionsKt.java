package com.tencent.state.square.common;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0012\u0010\u0004\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\b\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0001\u001a\f\u0010\t\u001a\u0004\u0018\u00010\u0005*\u00020\n\u001a \u0010\u000b\u001a\u0004\u0018\u00010\u0005*\u00020\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\r\u001a\u001e\u0010\u000f\u001a\u00020\u0010*\u00020\n2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\r\u001a\u0014\u0010\u0012\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0001\u00a8\u0006\u0013"}, d2 = {"calPt", "", "Landroid/content/Context;", "pxValue", "calPx", "Landroid/view/View;", "dip", "dpValue", "", "firstOrNull", "Landroid/view/ViewGroup;", "firstTopOrNull", "filter", "Lkotlin/Function1;", "", "forEachChild", "", "block", "reversePx", "square_base_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class ViewExtensionsKt {
    public static final int calPt(@Nullable Context context, int i3) {
        if (context == null) {
            return i3 * 3;
        }
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return (int) ((i3 * 3) / resources.getDisplayMetrics().density);
    }

    public static final int calPx(@NotNull View calPx, int i3) {
        Intrinsics.checkNotNullParameter(calPx, "$this$calPx");
        Resources resources = calPx.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return (int) ((i3 / 3) * resources.getDisplayMetrics().density);
    }

    public static final int dip(@Nullable Context context, int i3) {
        if (context == null) {
            return i3;
        }
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return (int) ((i3 * resources.getDisplayMetrics().density) + 0.5f);
    }

    @Nullable
    public static final View firstOrNull(@NotNull ViewGroup firstOrNull) {
        Intrinsics.checkNotNullParameter(firstOrNull, "$this$firstOrNull");
        if (firstOrNull.getChildCount() > 0) {
            return firstOrNull.getChildAt(0);
        }
        return null;
    }

    @Nullable
    public static final View firstTopOrNull(@NotNull ViewGroup firstTopOrNull, @NotNull Function1<? super View, Boolean> filter) {
        float f16;
        boolean z16;
        Intrinsics.checkNotNullParameter(firstTopOrNull, "$this$firstTopOrNull");
        Intrinsics.checkNotNullParameter(filter, "filter");
        int childCount = firstTopOrNull.getChildCount();
        View view = null;
        for (int i3 = 0; i3 < childCount; i3++) {
            View child = firstTopOrNull.getChildAt(i3);
            Intrinsics.checkNotNullExpressionValue(child, "child");
            float elevation = child.getElevation();
            if (view != null) {
                f16 = view.getElevation();
            } else {
                f16 = 0.0f;
            }
            if (elevation > f16) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && filter.invoke(child).booleanValue()) {
                view = child;
            }
        }
        return view;
    }

    public static final void forEachChild(@NotNull ViewGroup forEachChild, @NotNull Function1<? super View, Unit> block) {
        Intrinsics.checkNotNullParameter(forEachChild, "$this$forEachChild");
        Intrinsics.checkNotNullParameter(block, "block");
        int childCount = forEachChild.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = forEachChild.getChildAt(i3);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
            block.invoke(childAt);
        }
    }

    public static final int reversePx(@Nullable Context context, int i3) {
        if (context == null) {
            return i3 * 3;
        }
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return (int) ((i3 * 3) / resources.getDisplayMetrics().density);
    }

    public static final int dip(@Nullable Context context, float f16) {
        if (context == null) {
            return (int) f16;
        }
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }

    public static final int calPx(@Nullable Context context, int i3) {
        if (context == null) {
            return i3 / 3;
        }
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return (int) ((i3 / 3) * resources.getDisplayMetrics().density);
    }
}
