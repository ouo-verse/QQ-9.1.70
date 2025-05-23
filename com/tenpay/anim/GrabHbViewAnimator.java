package com.tenpay.anim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.luggage.wxa.c8.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tenpay/anim/GrabHbViewAnimator;", "", "animatedView", "Landroid/view/View;", "closeView", "(Landroid/view/View;Landroid/view/View;)V", "start", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class GrabHbViewAnimator {

    @NotNull
    private final View animatedView;

    @NotNull
    private final View closeView;

    public GrabHbViewAnimator(@NotNull View animatedView, @NotNull View closeView) {
        Intrinsics.checkNotNullParameter(animatedView, "animatedView");
        Intrinsics.checkNotNullParameter(closeView, "closeView");
        this.animatedView = animatedView;
        this.closeView = closeView;
    }

    public final void start() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.animatedView, BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.animatedView, BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.animatedView, c.f123400v, 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.setDuration(400L);
        animatorSet.setInterpolator(new OvershootInterpolator(1.5f));
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.tenpay.anim.GrabHbViewAnimator$start$lambda$2$$inlined$doOnStart$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator) {
                View view;
                Intrinsics.checkNotNullParameter(animator, "animator");
                view = GrabHbViewAnimator.this.closeView;
                view.setVisibility(4);
            }
        });
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.tenpay.anim.GrabHbViewAnimator$start$lambda$2$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator) {
                View view;
                Intrinsics.checkNotNullParameter(animator, "animator");
                view = GrabHbViewAnimator.this.closeView;
                view.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }
        });
        animatorSet.start();
    }
}
