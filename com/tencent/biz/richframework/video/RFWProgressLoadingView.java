package com.tencent.biz.richframework.video;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.animation.interpolator.EaseCubicInterpolator;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;

/* loaded from: classes5.dex */
public class RFWProgressLoadingView extends FrameLayout {
    private boolean isShowLoadingView;
    private ValueAnimator mFadeInAnimator;
    private ValueAnimator mFadeOutAnimation;
    private CycleAnimationListener mListener;
    private AnimatorSet mLoadingAnimation;
    private View mLoadingView;
    private AnimatorSet mOpacityAnimation;
    private int mOrientation;
    private ValueAnimator mScaleXAnimator;
    private final Runnable mStartAnimationRunnable;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class CycleAnimationListener implements Animator.AnimatorListener {
        CycleAnimationListener() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator != null) {
                try {
                    animator.start();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z16) {
            onAnimationStart(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z16) {
            onAnimationEnd(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class OpacityAnimationListener implements ValueAnimator.AnimatorUpdateListener {
        private final WeakReference<RFWProgressLoadingView> mWRFProgressLoadingView;

        OpacityAnimationListener(@NonNull RFWProgressLoadingView rFWProgressLoadingView) {
            this.mWRFProgressLoadingView = new WeakReference<>(rFWProgressLoadingView);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            View loadingView;
            RFWProgressLoadingView rFWProgressLoadingView = this.mWRFProgressLoadingView.get();
            if (rFWProgressLoadingView != null && (loadingView = rFWProgressLoadingView.getLoadingView()) != null && loadingView.getBackground() != null) {
                loadingView.getBackground().setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class ScaleXAnimationListener implements ValueAnimator.AnimatorUpdateListener {
        private final int mAnimOrientation;
        private final WeakReference<RFWProgressLoadingView> mWRFProgressLoadingView;

        ScaleXAnimationListener(RFWProgressLoadingView rFWProgressLoadingView, int i3) {
            this.mWRFProgressLoadingView = new WeakReference<>(rFWProgressLoadingView);
            this.mAnimOrientation = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            View loadingView;
            int screenHeight;
            RFWProgressLoadingView rFWProgressLoadingView = this.mWRFProgressLoadingView.get();
            if (rFWProgressLoadingView != null && (loadingView = rFWProgressLoadingView.getLoadingView()) != null && loadingView.getLayoutParams() != null) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (this.mAnimOrientation == 16) {
                    screenHeight = ViewUtils.getScreenWidth();
                } else {
                    screenHeight = ViewUtils.getScreenHeight() / 2;
                }
                loadingView.setX(screenHeight - intValue);
                loadingView.getLayoutParams().width = intValue * 2;
                loadingView.setLayoutParams(loadingView.getLayoutParams());
            }
        }
    }

    public RFWProgressLoadingView(@NonNull Context context) {
        super(context);
        this.isShowLoadingView = false;
        this.mOrientation = 16;
        this.mStartAnimationRunnable = new Runnable() { // from class: com.tencent.biz.richframework.video.RFWProgressLoadingView.1
            @Override // java.lang.Runnable
            public void run() {
                if (RFWProgressLoadingView.this.mLoadingAnimation != null) {
                    RFWProgressLoadingView.this.mLoadingAnimation.removeAllListeners();
                    if (RFWProgressLoadingView.this.mListener != null) {
                        RFWProgressLoadingView.this.mLoadingAnimation.addListener(RFWProgressLoadingView.this.mListener);
                    }
                    RFWProgressLoadingView.this.mLoadingAnimation.start();
                }
            }
        };
    }

    public AnimatorSet getLoadingAnimation() {
        int screenHeight;
        AnimatorSet animatorSet = this.mLoadingAnimation;
        if (animatorSet != null) {
            return animatorSet;
        }
        if (this.mLoadingView == null) {
            return null;
        }
        int[] iArr = new int[2];
        iArr[0] = 0;
        if (this.mOrientation == 16) {
            screenHeight = ViewUtils.getScreenWidth();
        } else {
            screenHeight = ViewUtils.getScreenHeight() / 2;
        }
        iArr[1] = screenHeight;
        this.mScaleXAnimator = ValueAnimator.ofInt(iArr);
        ValueAnimator ofInt = ValueAnimator.ofInt(0, ViewUtils.getScreenWidth());
        this.mScaleXAnimator = ofInt;
        ofInt.setDuration(800L);
        EaseCubicInterpolator easeCubicInterpolator = new EaseCubicInterpolator(0.0f, 0.0f, 0.25f, 1.0f);
        this.mScaleXAnimator.setInterpolator(easeCubicInterpolator);
        this.mScaleXAnimator.addUpdateListener(new ScaleXAnimationListener(this, this.mOrientation));
        ValueAnimator ofInt2 = ValueAnimator.ofInt(0, 255);
        this.mFadeInAnimator = ofInt2;
        ofInt2.setDuration(600L);
        ValueAnimator ofInt3 = ValueAnimator.ofInt(255, 0);
        this.mFadeOutAnimation = ofInt3;
        ofInt3.setDuration(200L);
        this.mOpacityAnimation = new AnimatorSet();
        this.mFadeOutAnimation.addUpdateListener(new OpacityAnimationListener(this));
        this.mOpacityAnimation.setInterpolator(easeCubicInterpolator);
        this.mOpacityAnimation.playSequentially(this.mFadeInAnimator, this.mFadeOutAnimation);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.mLoadingAnimation = animatorSet2;
        animatorSet2.playTogether(this.mScaleXAnimator, this.mOpacityAnimation);
        this.mLoadingAnimation.setStartDelay(200L);
        this.mListener = new CycleAnimationListener();
        return this.mLoadingAnimation;
    }

    public View getLoadingView() {
        View view = this.mLoadingView;
        if (view != null) {
            return view;
        }
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
            this.mListener = null;
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

    public void showAnimation() {
        View view = this.mLoadingView;
        if (view != null) {
            view.setVisibility(0);
        }
        this.mLoadingAnimation = getLoadingAnimation();
        if (!this.isShowLoadingView) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.mStartAnimationRunnable);
            RFWThreadManager.getUIHandler().postDelayed(this.mStartAnimationRunnable, 300L);
            this.isShowLoadingView = true;
        }
    }
}
