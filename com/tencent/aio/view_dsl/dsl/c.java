package com.tencent.aio.view_dsl.dsl;

import android.content.res.Resources;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0017\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001\u00a2\u0006\u0004\b\u0004\u0010\u0003\u001a\u0017\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0003\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\u0006\u001a\u0012\u0010\f\u001a\u00020\u000b*\u00020\t2\u0006\u0010\n\u001a\u00020\t\u001a\u0012\u0010\u000e\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b\"\u0015\u0010\u0011\u001a\u00020\u0007*\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0012"}, d2 = {"T", "", "e", "(Ljava/lang/Number;)Ljava/lang/Object;", "a", "g", "", "", "f", "Landroid/view/View;", "otherView", "Landroid/graphics/Rect;", "c", "otherRect", "d", "b", "(I)I", "dp", "core_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class c {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T a(@NotNull Number autoType) {
        Intrinsics.checkNotNullParameter(autoType, "$this$autoType");
        return autoType;
    }

    public static final int b(int i3) {
        return ((Number) e(Integer.valueOf(i3))).intValue();
    }

    @NotNull
    public static final Rect c(@NotNull View getRelativeRectTo, @NotNull View otherView) {
        Intrinsics.checkNotNullParameter(getRelativeRectTo, "$this$getRelativeRectTo");
        Intrinsics.checkNotNullParameter(otherView, "otherView");
        Rect rect = new Rect();
        otherView.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        getRelativeRectTo.getGlobalVisibleRect(rect2);
        return d(rect2, rect);
    }

    @NotNull
    public static final Rect d(@NotNull Rect relativeTo, @NotNull Rect otherRect) {
        Intrinsics.checkNotNullParameter(relativeTo, "$this$relativeTo");
        Intrinsics.checkNotNullParameter(otherRect, "otherRect");
        int i3 = relativeTo.left;
        int i16 = i3 - otherRect.left;
        int i17 = relativeTo.top;
        int i18 = i17 - otherRect.top;
        return new Rect(i16, i18, (relativeTo.right + i16) - i3, (relativeTo.bottom + i18) - i17);
    }

    public static final <T> T e(@NotNull Number toDp) {
        Intrinsics.checkNotNullParameter(toDp, "$this$toDp");
        float floatValue = toDp.floatValue();
        Resources system = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(system, "Resources.getSystem()");
        return (T) Float.valueOf(TypedValue.applyDimension(1, floatValue, system.getDisplayMetrics()));
    }

    public static final int f(@NotNull String toLayoutId) {
        Intrinsics.checkNotNullParameter(toLayoutId, "$this$toLayoutId");
        int hashCode = toLayoutId.hashCode();
        if (Intrinsics.areEqual(toLayoutId, b.m())) {
            hashCode = 0;
        }
        return Math.abs(hashCode);
    }

    public static final <T> T g(@NotNull Number toSp) {
        Intrinsics.checkNotNullParameter(toSp, "$this$toSp");
        float floatValue = toSp.floatValue();
        Resources system = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(system, "Resources.getSystem()");
        return (T) Float.valueOf(TypedValue.applyDimension(2, floatValue, system.getDisplayMetrics()));
    }
}
