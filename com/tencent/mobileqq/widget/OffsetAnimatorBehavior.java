package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0002\u0018\u0019B\u0013\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0015\u0010\u0016J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005R\u0016\u0010\f\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/widget/OffsetAnimatorBehavior;", "Lcom/google/android/material/appbar/AppBarLayout$Behavior;", "", "newOffset", "offsetRange", "Landroid/view/animation/Interpolator;", "interpolator", "", "c", "Lcom/tencent/mobileqq/widget/OffsetAnimatorBehavior$b;", "g", "Lcom/tencent/mobileqq/widget/OffsetAnimatorBehavior$b;", "listener", "Landroid/animation/ValueAnimator;", tl.h.F, "Landroid/animation/ValueAnimator;", "f", "()Landroid/animation/ValueAnimator;", "setOffsetAnimator", "(Landroid/animation/ValueAnimator;)V", "offsetAnimator", "<init>", "(Lcom/tencent/mobileqq/widget/OffsetAnimatorBehavior$b;)V", "i", "a", "b", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public class OffsetAnimatorBehavior extends AppBarLayout.Behavior {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final b listener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator offsetAnimator;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/widget/OffsetAnimatorBehavior$b;", "", "", "newOffset", "", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface b {
        void a(int newOffset);
    }

    public OffsetAnimatorBehavior() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ long d(OffsetAnimatorBehavior offsetAnimatorBehavior, int i3, int i16, Interpolator interpolator, int i17, Object obj) {
        if (obj == null) {
            if ((i17 & 4) != 0) {
                interpolator = new AccelerateDecelerateInterpolator();
            }
            return offsetAnimatorBehavior.c(i3, i16, interpolator);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateTopAndBottomOffsetTo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(OffsetAnimatorBehavior this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        this$0.setTopAndBottomOffset(intValue);
        b bVar = this$0.listener;
        if (bVar != null) {
            bVar.a(intValue);
        }
    }

    public final long c(int newOffset, int offsetRange, @NotNull Interpolator interpolator) {
        long coerceAtLeast;
        ValueAnimator valueAnimator;
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        int topAndBottomOffset = getTopAndBottomOffset();
        boolean z16 = true;
        if (topAndBottomOffset == newOffset) {
            ValueAnimator valueAnimator2 = this.offsetAnimator;
            if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
                z16 = false;
            }
            if (z16 && (valueAnimator = this.offsetAnimator) != null) {
                valueAnimator.cancel();
                return 0L;
            }
            return 0L;
        }
        ValueAnimator valueAnimator3 = this.offsetAnimator;
        if (valueAnimator3 == null) {
            ValueAnimator valueAnimator4 = new ValueAnimator();
            valueAnimator4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.widget.ae
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator5) {
                    OffsetAnimatorBehavior.e(OffsetAnimatorBehavior.this, valueAnimator5);
                }
            });
            this.offsetAnimator = valueAnimator4;
        } else if (valueAnimator3 != null) {
            valueAnimator3.cancel();
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((Math.abs(newOffset - topAndBottomOffset) / offsetRange) * ((float) 500), 250L);
        ValueAnimator valueAnimator5 = this.offsetAnimator;
        if (valueAnimator5 != null) {
            valueAnimator5.setDuration(coerceAtLeast);
            valueAnimator5.setInterpolator(interpolator);
            valueAnimator5.setIntValues(topAndBottomOffset, newOffset);
            valueAnimator5.start();
        }
        return coerceAtLeast;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: f, reason: from getter */
    public final ValueAnimator getOffsetAnimator() {
        return this.offsetAnimator;
    }

    public OffsetAnimatorBehavior(@Nullable b bVar) {
        this.listener = bVar;
    }

    public /* synthetic */ OffsetAnimatorBehavior(b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bVar);
    }
}
