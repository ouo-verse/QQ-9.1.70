package com.tencent.state;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0016J(\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0016\u0010\u0016\u001a\u00020\u00012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0018\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J(\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001dH\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/tencent/state/SquarePropAnimator;", "Lcom/tencent/state/ISquareAnimator;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "animator", "Landroid/view/ViewPropertyAnimator;", "kotlin.jvm.PlatformType", c.f123400v, "", "duration", "", "listener", "Lcom/tencent/state/AnimListener;", "pivot", "pivotX", "pivotY", "scale", BasicAnimation.KeyPath.SCALE_X, BasicAnimation.KeyPath.SCALE_Y, "fromScaleX", "fromScaleY", "setUpdateListener", "update", "Lkotlin/Function0;", "", "start", CanvasView.ACTION_TRANSLATE, "translateX", "", "translateY", "fromXDelta", "toXDelta", "fromYDelta", "toYDelta", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class SquarePropAnimator implements ISquareAnimator {
    private final ViewPropertyAnimator animator;
    private final View view;

    public SquarePropAnimator(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.animator = view.animate();
    }

    @Override // com.tencent.state.ISquareAnimator
    public ISquareAnimator alpha(float alpha) {
        this.animator.alpha(alpha);
        return this;
    }

    @Override // com.tencent.state.ISquareAnimator
    public ISquareAnimator duration(long duration) {
        ViewPropertyAnimator animator = this.animator;
        Intrinsics.checkNotNullExpressionValue(animator, "animator");
        animator.setDuration(duration);
        return this;
    }

    @Override // com.tencent.state.ISquareAnimator
    public ISquareAnimator listener(final AnimListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.animator.setListener(new AnimatorListenerAdapter() { // from class: com.tencent.state.SquarePropAnimator$listener$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                AnimListener.this.onAnimationEnd(null);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                AnimListener.this.onAnimationRepeat(null);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                AnimListener.this.onAnimationStart(null);
            }
        });
        return this;
    }

    @Override // com.tencent.state.ISquareAnimator
    public ISquareAnimator pivot(float pivotX, float pivotY) {
        this.view.setPivotX(pivotX);
        this.view.setPivotY(pivotY);
        return this;
    }

    @Override // com.tencent.state.ISquareAnimator
    public ISquareAnimator scale(float scaleX, float scaleY, float fromScaleX, float fromScaleY) {
        this.animator.scaleX(scaleX).scaleY(scaleY);
        return this;
    }

    @Override // com.tencent.state.ISquareAnimator
    public ISquareAnimator setUpdateListener(final Function0<Unit> update) {
        Intrinsics.checkNotNullParameter(update, "update");
        this.animator.setUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.state.SquarePropAnimator$setUpdateListener$1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Function0.this.invoke();
            }
        });
        return this;
    }

    @Override // com.tencent.state.ISquareAnimator
    public void start() {
        this.animator.start();
    }

    @Override // com.tencent.state.ISquareAnimator
    public ISquareAnimator translate(int fromXDelta, int toXDelta, int fromYDelta, int toYDelta) {
        return this;
    }

    @Override // com.tencent.state.ISquareAnimator
    public ISquareAnimator translate(int translateX, int translateY) {
        this.animator.translationX(translateX).translationY(translateY);
        return this;
    }
}
