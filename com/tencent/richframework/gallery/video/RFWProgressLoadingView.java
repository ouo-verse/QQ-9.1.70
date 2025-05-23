package com.tencent.richframework.gallery.video;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.richframework.thread.RFWThreadManager;

/* loaded from: classes25.dex */
public class RFWProgressLoadingView extends FrameLayout {
    private boolean isShowLoadingView;
    private ValueAnimator mFadeInAnimator;
    private ValueAnimator mFadeOutAnimation;
    private AnimatorSet mLoadingAnimation;
    private View mLoadingView;
    private AnimatorSet mOpacityAnimation;
    private int mOrientation;
    private ValueAnimator mScaleXAnimator;
    private final Runnable mStartAnimationRunnable;

    /* loaded from: classes25.dex */
    private static class CycleAnimationListener implements Animator.AnimatorListener {
    }

    public RFWProgressLoadingView(@NonNull Context context) {
        super(context);
        this.isShowLoadingView = false;
        this.mOrientation = 16;
        this.mStartAnimationRunnable = new Runnable() { // from class: com.tencent.richframework.gallery.video.RFWProgressLoadingView.1
            @Override // java.lang.Runnable
            public void run() {
                if (RFWProgressLoadingView.this.mLoadingAnimation != null) {
                    RFWProgressLoadingView.this.mLoadingAnimation.removeAllListeners();
                    RFWProgressLoadingView.access$100(RFWProgressLoadingView.this);
                    RFWProgressLoadingView.this.mLoadingAnimation.start();
                }
            }
        };
    }

    static /* synthetic */ CycleAnimationListener access$100(RFWProgressLoadingView rFWProgressLoadingView) {
        rFWProgressLoadingView.getClass();
        return null;
    }

    public void hideAnimation() {
        this.isShowLoadingView = false;
        if (this.mStartAnimationRunnable != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.mStartAnimationRunnable);
        }
        View view = this.mLoadingView;
        if (view != null) {
            view.setVisibility(8);
        }
        ValueAnimator valueAnimator = this.mFadeInAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.mFadeInAnimator.cancel();
            this.mFadeInAnimator = null;
        }
        ValueAnimator valueAnimator2 = this.mFadeOutAnimation;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
            this.mFadeOutAnimation.cancel();
            this.mFadeOutAnimation = null;
        }
        ValueAnimator valueAnimator3 = this.mScaleXAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
            this.mScaleXAnimator.cancel();
            this.mScaleXAnimator = null;
        }
        AnimatorSet animatorSet = this.mOpacityAnimation;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.mOpacityAnimation.cancel();
            this.mOpacityAnimation = null;
        }
        AnimatorSet animatorSet2 = this.mLoadingAnimation;
        if (animatorSet2 != null && animatorSet2.isRunning()) {
            this.mLoadingAnimation.removeAllListeners();
            this.mLoadingAnimation.cancel();
            this.mLoadingAnimation = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        hideAnimation();
        super.onDetachedFromWindow();
    }

    public void setLoadingView(View view) {
        this.mLoadingView = view;
    }

    public void setScreenOrientation(int i3) {
        this.mOrientation = i3;
    }
}
