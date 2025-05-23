package com.tencent.tencentmap.mapsdk.maps.model.transform;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class OverlayAnimator {
    private Animator.AnimatorListener mAnimatorListener;
    private AnimatorSet mAnimatorSet = new AnimatorSet();
    private long mDuration;
    private Object mObject;

    /* JADX INFO: Access modifiers changed from: protected */
    public OverlayAnimator(Object obj, long j3) {
        this.mObject = obj;
        this.mDuration = j3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addAnimationListener() {
        if (this.mAnimatorSet == null) {
            return;
        }
        if (this.mAnimatorListener == null) {
            this.mAnimatorListener = new Animator.AnimatorListener() { // from class: com.tencent.tencentmap.mapsdk.maps.model.transform.OverlayAnimator.1
                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    OverlayAnimator.this.innerAnimationEnd();
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                }
            };
        }
        this.mAnimatorSet.addListener(this.mAnimatorListener);
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.mAnimatorSet.addListener(animatorListener);
    }

    public void cancelAnimation() {
        synchronized (this) {
            this.mAnimatorSet.cancel();
        }
    }

    protected abstract ValueAnimator createSegmentAnimator(int i3);

    public void endAnimation() {
        synchronized (this) {
            this.mAnimatorSet.end();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AnimatorSet getAnimatorSet() {
        return this.mAnimatorSet;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public Object getObject() {
        return this.mObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeAnimationListener() {
        AnimatorSet animatorSet = this.mAnimatorSet;
        if (animatorSet == null) {
            return;
        }
        animatorSet.removeListener(this.mAnimatorListener);
        this.mAnimatorListener = null;
    }

    protected void setAnimatorSet(AnimatorSet animatorSet) {
        this.mAnimatorSet = animatorSet;
    }

    public void setDuration(long j3) {
        this.mDuration = j3;
    }

    public void setObject(Object obj) {
        this.mObject = obj;
    }

    public void startAnimation() {
        synchronized (this) {
            if (!this.mAnimatorSet.isRunning()) {
                this.mAnimatorSet.start();
            }
        }
    }

    protected void innerAnimationEnd() {
    }
}
