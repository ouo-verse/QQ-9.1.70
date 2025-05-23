package com.tencent.richframework.widget.scroll;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes25.dex */
public class BounceBackState implements Animator.AnimatorListener, IDecoratorState, ValueAnimator.AnimatorUpdateListener {
    protected final float mDecelerateFactor;
    protected final float mDoubleDecelerateFactor;
    protected final OverScrollDecorator mManager;
    protected final Interpolator mBounceBackInterpolator = new DecelerateInterpolator();
    protected final AnimationAttributes mAnimAttributes = new AnimationAttributes();

    public BounceBackState(OverScrollDecorator overScrollDecorator, float f16) {
        this.mManager = overScrollDecorator;
        this.mDecelerateFactor = f16;
        this.mDoubleDecelerateFactor = f16 * 2.0f;
    }

    protected Animator createAnimator() {
        View view = this.mManager.getView();
        OverScrollDecorator overScrollDecorator = this.mManager;
        IOverScrollDecor iOverScrollDecor = overScrollDecorator.mOverScrollDecor;
        OverScrollStartAttributes overScrollStartAttributes = overScrollDecorator.mStartAttr;
        float f16 = overScrollDecorator.mVelocity;
        iOverScrollDecor.initAnimationAttributes(view, this.mAnimAttributes);
        float f17 = 0.0f;
        if (f16 != 0.0f && ((f16 >= 0.0f || !overScrollStartAttributes.mDir) && (f16 <= 0.0f || overScrollStartAttributes.mDir))) {
            float f18 = -f16;
            float f19 = f18 / this.mDecelerateFactor;
            if (f19 >= 0.0f) {
                f17 = f19;
            }
            float f26 = this.mAnimAttributes.mAbsOffset + ((f18 * f16) / this.mDoubleDecelerateFactor);
            ObjectAnimator createSlowdownAnimator = createSlowdownAnimator(view, (int) f17, f26);
            ObjectAnimator createBounceBackAnimator = createBounceBackAnimator(f26);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(createSlowdownAnimator, createBounceBackAnimator);
            return animatorSet;
        }
        return createBounceBackAnimator(this.mAnimAttributes.mAbsOffset);
    }

    protected ObjectAnimator createBounceBackAnimator(float f16) {
        View view = this.mManager.getView();
        OverScrollStartAttributes overScrollStartAttributes = this.mManager.mStartAttr;
        float abs = Math.abs(f16);
        AnimationAttributes animationAttributes = this.mAnimAttributes;
        float f17 = (abs / animationAttributes.mMaxOffset) * 800.0f;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, animationAttributes.mProperty, overScrollStartAttributes.mAbsOffset);
        ofFloat.setDuration(Math.max((int) f17, 200));
        ofFloat.setInterpolator(this.mBounceBackInterpolator);
        ofFloat.addUpdateListener(this);
        return ofFloat;
    }

    protected ObjectAnimator createSlowdownAnimator(View view, int i3, float f16) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, this.mAnimAttributes.mProperty, f16);
        ofFloat.setDuration(i3);
        ofFloat.setInterpolator(this.mBounceBackInterpolator);
        ofFloat.addUpdateListener(this);
        return ofFloat;
    }

    @Override // com.tencent.richframework.widget.scroll.IDecoratorState
    public void handleEntryTransition(IDecoratorState iDecoratorState) {
        Animator createAnimator = createAnimator();
        createAnimator.addListener(this);
        createAnimator.start();
    }

    @Override // com.tencent.richframework.widget.scroll.IDecoratorState
    public boolean handleMoveTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.tencent.richframework.widget.scroll.IDecoratorState
    public boolean handleUpOrCancelTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        OverScrollDecorator overScrollDecorator = this.mManager;
        overScrollDecorator.issueStateTransition(overScrollDecorator.mIdleState);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
    }
}
