package com.tencent.aio.view_dsl.dsl;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u0007\n\u0002\b\t\"(\u0010\u0007\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006\"(\u0010\n\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\u0004\"\u0004\b\t\u0010\u0006\"(\u0010\r\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000b\u0010\u0004\"\u0004\b\f\u0010\u0006\"(\u0010\u0010\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u0004\"\u0004\b\u000f\u0010\u0006\"(\u0010\u0013\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0011\u0010\u0004\"\u0004\b\u0012\u0010\u0006\"(\u0010\u0016\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0014\u0010\u0004\"\u0004\b\u0015\u0010\u0006\"(\u0010\u001c\u001a\u00020\u0017*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00178F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\"(\u0010\u001f\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001d\u0010\u0004\"\u0004\b\u001e\u0010\u0006\u00a8\u0006 "}, d2 = {"Landroid/view/View;", "", "value", "getLayout_constraintTop_toTopOf", "(Landroid/view/View;)I", h.F, "(Landroid/view/View;I)V", "layout_constraintTop_toTopOf", "getLayout_constraintTop_toBottomOf", "g", "layout_constraintTop_toBottomOf", "getLayout_constraintStart_toStartOf", "f", "layout_constraintStart_toStartOf", "getLayout_constraintBottom_toBottomOf", "a", "layout_constraintBottom_toBottomOf", "getLayout_constraintEnd_toEndOf", "b", "layout_constraintEnd_toEndOf", "getLayout_constraintStart_toEndOf", "e", "layout_constraintStart_toEndOf", "", "getLayout_constraintHorizontal_bias", "(Landroid/view/View;)F", "d", "(Landroid/view/View;F)V", "layout_constraintHorizontal_bias", "getLayout_constraintEnd_toStartOf", "c", "layout_constraintEnd_toStartOf", "core_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a {
    public static final void a(@NotNull View layout_constraintBottom_toBottomOf, int i3) {
        Intrinsics.checkNotNullParameter(layout_constraintBottom_toBottomOf, "$this$layout_constraintBottom_toBottomOf");
        if (layout_constraintBottom_toBottomOf.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
            ViewGroup.LayoutParams layoutParams = layout_constraintBottom_toBottomOf.getLayoutParams();
            if (layoutParams != null) {
                ((ConstraintLayout.LayoutParams) layoutParams).bottomToBottom = i3;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
    }

    public static final void b(@NotNull View layout_constraintEnd_toEndOf, int i3) {
        Intrinsics.checkNotNullParameter(layout_constraintEnd_toEndOf, "$this$layout_constraintEnd_toEndOf");
        if (layout_constraintEnd_toEndOf.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
            ViewGroup.LayoutParams layoutParams = layout_constraintEnd_toEndOf.getLayoutParams();
            if (layoutParams != null) {
                ((ConstraintLayout.LayoutParams) layoutParams).endToEnd = i3;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
    }

    public static final void c(@NotNull View layout_constraintEnd_toStartOf, int i3) {
        Intrinsics.checkNotNullParameter(layout_constraintEnd_toStartOf, "$this$layout_constraintEnd_toStartOf");
        if (layout_constraintEnd_toStartOf.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
            ViewGroup.LayoutParams layoutParams = layout_constraintEnd_toStartOf.getLayoutParams();
            if (layoutParams != null) {
                ((ConstraintLayout.LayoutParams) layoutParams).endToStart = i3;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
    }

    public static final void d(@NotNull View layout_constraintHorizontal_bias, float f16) {
        Intrinsics.checkNotNullParameter(layout_constraintHorizontal_bias, "$this$layout_constraintHorizontal_bias");
        if (layout_constraintHorizontal_bias.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
            ViewGroup.LayoutParams layoutParams = layout_constraintHorizontal_bias.getLayoutParams();
            if (layoutParams != null) {
                ((ConstraintLayout.LayoutParams) layoutParams).horizontalBias = f16;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
    }

    public static final void e(@NotNull View layout_constraintStart_toEndOf, int i3) {
        Intrinsics.checkNotNullParameter(layout_constraintStart_toEndOf, "$this$layout_constraintStart_toEndOf");
        if (layout_constraintStart_toEndOf.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
            ViewGroup.LayoutParams layoutParams = layout_constraintStart_toEndOf.getLayoutParams();
            if (layoutParams != null) {
                ((ConstraintLayout.LayoutParams) layoutParams).startToEnd = i3;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
    }

    public static final void f(@NotNull View layout_constraintStart_toStartOf, int i3) {
        Intrinsics.checkNotNullParameter(layout_constraintStart_toStartOf, "$this$layout_constraintStart_toStartOf");
        if (layout_constraintStart_toStartOf.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
            ViewGroup.LayoutParams layoutParams = layout_constraintStart_toStartOf.getLayoutParams();
            if (layoutParams != null) {
                ((ConstraintLayout.LayoutParams) layoutParams).startToStart = i3;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
    }

    public static final void g(@NotNull View layout_constraintTop_toBottomOf, int i3) {
        Intrinsics.checkNotNullParameter(layout_constraintTop_toBottomOf, "$this$layout_constraintTop_toBottomOf");
        if (layout_constraintTop_toBottomOf.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
            ViewGroup.LayoutParams layoutParams = layout_constraintTop_toBottomOf.getLayoutParams();
            if (layoutParams != null) {
                ((ConstraintLayout.LayoutParams) layoutParams).topToBottom = i3;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
    }

    public static final void h(@NotNull View layout_constraintTop_toTopOf, int i3) {
        Intrinsics.checkNotNullParameter(layout_constraintTop_toTopOf, "$this$layout_constraintTop_toTopOf");
        if (layout_constraintTop_toTopOf.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
            ViewGroup.LayoutParams layoutParams = layout_constraintTop_toTopOf.getLayoutParams();
            if (layoutParams != null) {
                ((ConstraintLayout.LayoutParams) layoutParams).topToTop = i3;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
    }
}
