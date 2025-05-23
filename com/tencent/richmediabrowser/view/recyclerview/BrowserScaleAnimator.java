package com.tencent.richmediabrowser.view.recyclerview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;
import com.tencent.richmediabrowser.listener.IBrowserScaleControlListener;
import com.tencent.richmediabrowser.listener.IBrowserScaleEventListener;

/* compiled from: P */
/* loaded from: classes25.dex */
public class BrowserScaleAnimator extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
    private static final float BIGGER = 1.07f;
    private static final float SMALLER = 0.93f;
    private float mTargetScale;
    private IBrowserScaleControlListener scaleControlListener;
    private IBrowserScaleEventListener scaleEventListener;
    private float tempScale;

    /* renamed from: x, reason: collision with root package name */
    private float f365139x;

    /* renamed from: y, reason: collision with root package name */
    private float f365140y;

    public BrowserScaleAnimator(float f16, float f17, float f18) {
        this.mTargetScale = f16;
        this.f365139x = f17;
        this.f365140y = f18;
    }

    private boolean isScaleContine() {
        IBrowserScaleControlListener iBrowserScaleControlListener = this.scaleControlListener;
        if (iBrowserScaleControlListener == null) {
            return false;
        }
        float currentScale = iBrowserScaleControlListener.getCurrentScale();
        float f16 = this.tempScale;
        if ((f16 <= 1.0f || currentScale >= this.mTargetScale) && (f16 >= 1.0f || currentScale <= this.mTargetScale)) {
            return false;
        }
        return true;
    }

    public void initAnimator() {
        IBrowserScaleControlListener iBrowserScaleControlListener = this.scaleControlListener;
        if (iBrowserScaleControlListener != null) {
            float currentScale = iBrowserScaleControlListener.getCurrentScale();
            float f16 = this.mTargetScale;
            if (currentScale < f16) {
                this.tempScale = BIGGER;
            }
            if (currentScale > f16) {
                this.tempScale = SMALLER;
            }
            setFloatValues(currentScale, f16);
            setInterpolator(new DecelerateInterpolator());
            setDuration(400L);
            addUpdateListener(this);
            addListener(this);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        IBrowserScaleEventListener iBrowserScaleEventListener = this.scaleEventListener;
        if (iBrowserScaleEventListener != null) {
            iBrowserScaleEventListener.onScaleAnimationCancel();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        IBrowserScaleEventListener iBrowserScaleEventListener = this.scaleEventListener;
        if (iBrowserScaleEventListener != null) {
            iBrowserScaleEventListener.onScaleAnimationEnd();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        IBrowserScaleEventListener iBrowserScaleEventListener = this.scaleEventListener;
        if (iBrowserScaleEventListener != null) {
            iBrowserScaleEventListener.onScaleAnimationRepeat();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        IBrowserScaleEventListener iBrowserScaleEventListener = this.scaleEventListener;
        if (iBrowserScaleEventListener != null) {
            iBrowserScaleEventListener.onScaleAnimationStart();
        }
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        IBrowserScaleControlListener iBrowserScaleControlListener = this.scaleControlListener;
        if (iBrowserScaleControlListener != null) {
            float f16 = this.tempScale;
            iBrowserScaleControlListener.startScale(f16, f16, this.f365139x, this.f365140y);
            if (!isScaleContine()) {
                float currentScale = this.mTargetScale / this.scaleControlListener.getCurrentScale();
                this.scaleControlListener.startScale(currentScale, currentScale, this.f365139x, this.f365140y);
            }
        }
    }

    public void setBrowserScaleControlListener(IBrowserScaleControlListener iBrowserScaleControlListener) {
        this.scaleControlListener = iBrowserScaleControlListener;
    }

    public void setBrowserScaleEventListener(IBrowserScaleEventListener iBrowserScaleEventListener) {
        this.scaleEventListener = iBrowserScaleEventListener;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator, boolean z16) {
        onAnimationEnd(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator, boolean z16) {
        onAnimationStart(animator);
    }
}
