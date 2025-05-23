package com.tencent.android.androidbypass.custom;

import android.view.ViewGroup;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000e\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0006\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003\"\u0018\u0010\b\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0003\"\u0018\u0010\n\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0003\"\u0018\u0010\f\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u0003\"\u0018\u0010\u000e\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u0003\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/android/androidbypass/custom/f;", "", "c", "(Lcom/tencent/android/androidbypass/custom/f;)I", NodeProps.MARGIN_LEFT, "d", NodeProps.MARGIN_RIGHT, "e", NodeProps.MARGIN_TOP, "a", NodeProps.MARGIN_BOTTOM, "b", NodeProps.MARGIN_HORIZONTAL, "f", NodeProps.MARGIN_VERTICAL, "bypass_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class e {
    public static final int a(@NotNull f marginBottom) {
        Intrinsics.checkNotNullParameter(marginBottom, "$this$marginBottom");
        ViewGroup.MarginLayoutParams d16 = marginBottom.d();
        if (d16 != null) {
            return d16.bottomMargin;
        }
        return 0;
    }

    public static final int b(@NotNull f marginHorizontal) {
        Intrinsics.checkNotNullParameter(marginHorizontal, "$this$marginHorizontal");
        return c(marginHorizontal) + d(marginHorizontal);
    }

    public static final int c(@NotNull f marginLeft) {
        Intrinsics.checkNotNullParameter(marginLeft, "$this$marginLeft");
        ViewGroup.MarginLayoutParams d16 = marginLeft.d();
        if (d16 != null) {
            return d16.leftMargin;
        }
        return 0;
    }

    public static final int d(@NotNull f marginRight) {
        Intrinsics.checkNotNullParameter(marginRight, "$this$marginRight");
        ViewGroup.MarginLayoutParams d16 = marginRight.d();
        if (d16 != null) {
            return d16.rightMargin;
        }
        return 0;
    }

    public static final int e(@NotNull f marginTop) {
        Intrinsics.checkNotNullParameter(marginTop, "$this$marginTop");
        ViewGroup.MarginLayoutParams d16 = marginTop.d();
        if (d16 != null) {
            return d16.topMargin;
        }
        return 0;
    }

    public static final int f(@NotNull f marginVertical) {
        Intrinsics.checkNotNullParameter(marginVertical, "$this$marginVertical");
        return e(marginVertical) + a(marginVertical);
    }
}
