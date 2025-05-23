package com.tencent.richmediabrowser.view.recyclerview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.RectF;
import android.view.animation.DecelerateInterpolator;
import com.tencent.richmediabrowser.listener.IBrowserFlingControlListener;
import com.tencent.richmediabrowser.listener.IBrowserFlingEventListener;

/* compiled from: P */
/* loaded from: classes25.dex */
public class BrowserFlingAnimator extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
    private IBrowserFlingControlListener flingControlListener;
    private IBrowserFlingEventListener flingEventListener;
    private int mCurrentX;
    private int mCurrentY;
    private OverScroller mScroller;

    public BrowserFlingAnimator(Context context) {
        OverScroller overScroller = new OverScroller(context);
        this.mScroller = overScroller;
        overScroller.setFriction(0.04f);
        setFloatValues(0.0f);
        setInterpolator(new DecelerateInterpolator());
        setDuration(400L);
        addUpdateListener(this);
        addListener(this);
    }

    public void cancelFling() {
        this.mScroller.forceFinished(true);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        IBrowserFlingEventListener iBrowserFlingEventListener = this.flingEventListener;
        if (iBrowserFlingEventListener != null) {
            iBrowserFlingEventListener.onFlingAnimationCancel();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        IBrowserFlingEventListener iBrowserFlingEventListener = this.flingEventListener;
        if (iBrowserFlingEventListener != null) {
            iBrowserFlingEventListener.onFlingAnimationEnd();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        IBrowserFlingEventListener iBrowserFlingEventListener = this.flingEventListener;
        if (iBrowserFlingEventListener != null) {
            iBrowserFlingEventListener.onFlingAnimationRepeat();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        IBrowserFlingEventListener iBrowserFlingEventListener = this.flingEventListener;
        if (iBrowserFlingEventListener != null) {
            iBrowserFlingEventListener.onFlingAnimationStart();
        }
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset() && this.flingControlListener != null) {
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            this.flingControlListener.startFling(this.mCurrentX - currX, this.mCurrentY - currY);
            this.mCurrentX = currX;
            this.mCurrentY = currY;
        }
    }

    public void setBrowserFlingControlListener(IBrowserFlingControlListener iBrowserFlingControlListener) {
        this.flingControlListener = iBrowserFlingControlListener;
    }

    public void setBrowserFlingEventListener(IBrowserFlingEventListener iBrowserFlingEventListener) {
        this.flingEventListener = iBrowserFlingEventListener;
    }

    public void startFling(int i3, int i16, int i17, int i18, boolean z16, boolean z17) {
        RectF currentMatrixRectF;
        int i19;
        int i26;
        int i27;
        int i28;
        IBrowserFlingControlListener iBrowserFlingControlListener = this.flingControlListener;
        if (iBrowserFlingControlListener == null || (currentMatrixRectF = iBrowserFlingControlListener.getCurrentMatrixRectF()) == null) {
            return;
        }
        int round = Math.round(-currentMatrixRectF.left);
        float f16 = i3;
        if (currentMatrixRectF.width() > f16) {
            i26 = Math.round(currentMatrixRectF.width() - f16);
            i19 = 0;
        } else {
            i19 = round;
            i26 = i19;
        }
        int round2 = Math.round(-currentMatrixRectF.top);
        float f17 = i16;
        if (currentMatrixRectF.height() > f17) {
            i28 = Math.round(currentMatrixRectF.height() - f17);
            i27 = 0;
        } else {
            i27 = round2;
            i28 = i27;
        }
        this.mCurrentX = round;
        this.mCurrentY = round2;
        if (round != i26 || round2 != i28) {
            this.mScroller.fling(round, round2, i17, i18, i19, i26, i27, i28);
        }
        start();
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
