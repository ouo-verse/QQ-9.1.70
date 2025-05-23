package com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.animation;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.PathInterpolator;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007J0\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\b\u0010\u000e\u001a\u00020\u0004H\u0007R\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/animation/c;", "", "Landroid/view/View;", "targetView", "", "duration", "", "beginValue", "targetValue", "Landroid/animation/ValueAnimator;", "f", "", "resId", "c", "e", "b", "J", h.F, "()J", "TOTAL_ITEM_SELECT_ANIMATION_DURATION", "Landroid/view/animation/PathInterpolator;", "Landroid/view/animation/PathInterpolator;", "IOS_EASY_OUT_INTERPOLATOR", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f227609a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final long TOTAL_ITEM_SELECT_ANIMATION_DURATION = Math.max(200L, 200L) + 100;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final PathInterpolator IOS_EASY_OUT_INTERPOLATOR = new PathInterpolator(0.0f, 0.79f, 0.16f, 1.0f);

    c() {
    }

    @JvmStatic
    @NotNull
    public static final ValueAnimator c(@NotNull final View targetView, long duration, int beginValue, int targetValue, final int resId) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        ValueAnimator animator = ValueAnimator.ofInt(beginValue, targetValue);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.animation.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                c.d(targetView, resId, valueAnimator);
            }
        });
        animator.setDuration(duration);
        Intrinsics.checkNotNullExpressionValue(animator, "animator");
        return animator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(View targetView, int i3, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(targetView, "$targetView");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        targetView.setBackgroundResource(i3);
        targetView.getBackground().setAlpha(intValue);
    }

    @JvmStatic
    public static final long e() {
        return 300L;
    }

    @JvmStatic
    @NotNull
    public static final ValueAnimator f(@NotNull final View targetView, long duration, float beginValue, float targetValue) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        ValueAnimator animator = ValueAnimator.ofFloat(beginValue, targetValue);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.animation.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                c.g(targetView, valueAnimator);
            }
        });
        animator.setDuration(duration);
        Intrinsics.checkNotNullExpressionValue(animator, "animator");
        return animator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(View targetView, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(targetView, "$targetView");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        targetView.setScaleX(floatValue);
        targetView.setScaleY(floatValue);
    }

    public final long h() {
        return TOTAL_ITEM_SELECT_ANIMATION_DURATION;
    }
}
