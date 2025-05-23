package com.tencent.mobileqq.profilecard.utils;

import android.animation.ValueAnimator;
import android.view.View;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExpandAnimation {
    public static final long DEFAULT_ANIMATION_DURATION = 300;
    public static final int DEFAULT_STOW_HEIGHT = 0;
    private long mAnimationDuration = 300;
    private ValueAnimator mHeightAnimation = null;
    private boolean mIsExpand;
    private View mLayoutView;
    private int mViewHeight;

    public ExpandAnimation(View view) {
        this.mLayoutView = view;
    }

    private void animateToggle(long j3) {
        ValueAnimator ofFloat;
        ValueAnimator valueAnimator = this.mHeightAnimation;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (this.mIsExpand) {
            ofFloat = ValueAnimator.ofFloat(0.0f, this.mViewHeight);
        } else {
            ofFloat = ValueAnimator.ofFloat(this.mViewHeight, 0.0f);
        }
        this.mHeightAnimation = ofFloat;
        long j16 = j3 / 2;
        ofFloat.setDuration(j16);
        this.mHeightAnimation.setStartDelay(j16);
        this.mHeightAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.profilecard.utils.ExpandAnimation.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ExpandAnimation.setViewHeight(ExpandAnimation.this.mLayoutView, (int) ((Float) valueAnimator2.getAnimatedValue()).floatValue());
            }
        });
        this.mHeightAnimation.start();
    }

    public static void setViewHeight(View view, int i3) {
        view.getLayoutParams().height = i3;
        view.requestLayout();
    }

    public void initExpand(boolean z16) {
        this.mIsExpand = z16;
        if (z16) {
            return;
        }
        setViewHeight(this.mLayoutView, 0);
    }

    public boolean isExpand() {
        return this.mIsExpand;
    }

    public void setAnimationDuration(long j3) {
        this.mAnimationDuration = j3;
    }

    public void toggleExpand() {
        if (this.mIsExpand) {
            collapse();
        } else {
            expand();
        }
    }

    public void updateViewHeight(int i3) {
        ValueAnimator valueAnimator = this.mHeightAnimation;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (this.mViewHeight != i3 && isExpand()) {
            setViewHeight(this.mLayoutView, i3);
        }
        this.mViewHeight = i3;
    }

    public void collapse() {
        this.mIsExpand = false;
        animateToggle(this.mAnimationDuration);
    }

    public void expand() {
        this.mIsExpand = true;
        animateToggle(this.mAnimationDuration);
    }
}
