package com.tencent.biz.richframework.animation.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.lifecycle.RFWLifecycleHelper;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TransitionAnimator {
    private static final ColorDrawable mWindowBgDrawable = new ColorDrawable(-33554432);

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface OnAnimCallback {
        void onAnimationCancel();

        void onAnimationEnd();

        void onAnimationStart();
    }

    public static void fadeCover(final View view, long j3, final boolean z16) {
        if (view == null) {
            return;
        }
        QLog.d("TM-TransitionAnimator", 1, "fadeCover");
        view.animate().alpha(0.0f).setDuration(j3).setListener(new Animator.AnimatorListener() { // from class: com.tencent.biz.richframework.animation.transition.TransitionAnimator.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (z16) {
                    view.setAlpha(1.0f);
                }
                view.setVisibility(8);
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
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float getCurValue(TransitionAnimConfig transitionAnimConfig, int i3, float f16) {
        if (transitionAnimConfig == null) {
            return 0.0f;
        }
        float startValue = transitionAnimConfig.getStartValue(i3);
        return startValue + ((transitionAnimConfig.getEndValue(i3) - startValue) * f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setImageViewPadding(int i3, int i16, int i17, int i18, TransitionInitData transitionInitData, TransitionAnimConfig transitionAnimConfig) {
        int i19;
        int i26;
        int i27;
        if (transitionInitData != null && transitionAnimConfig != null && transitionAnimConfig.getImageView() != null) {
            float width = transitionInitData.getLayoutEndRect().width() - transitionInitData.getImageEndRect().width();
            float height = transitionInitData.getLayoutEndRect().height() - transitionInitData.getImageEndRect().height();
            float f16 = (transitionInitData.getImageEndRect().left - transitionInitData.getLayoutEndRect().left) / width;
            float f17 = (transitionInitData.getLayoutEndRect().right - transitionInitData.getImageEndRect().right) / width;
            float f18 = (transitionInitData.getImageEndRect().top - transitionInitData.getLayoutEndRect().top) / height;
            float f19 = (transitionInitData.getLayoutEndRect().bottom - transitionInitData.getImageEndRect().bottom) / height;
            int i28 = 0;
            if (width > 0.0f && i3 > i17) {
                float f26 = i3 - i17;
                i26 = (int) (f16 * f26);
                i19 = (int) (f17 * f26);
            } else {
                i19 = 0;
                i26 = 0;
            }
            if (height > 0.0f && i16 > i18) {
                float f27 = i16 - i18;
                i28 = (int) (f18 * f27);
                i27 = (int) (f19 * f27);
            } else {
                i27 = 0;
            }
            if (i26 == 0 && i28 == 0 && i19 == 0 && i27 == 0) {
                return;
            }
            transitionAnimConfig.getImageView().setPadding(i26, i28, i19, i27);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setImageViewScale(float f16, float f17, float f18, TransitionInitData transitionInitData, TransitionAnimConfig transitionAnimConfig) {
        float scaleFactor;
        if (transitionInitData != null && transitionAnimConfig != null) {
            float f19 = 1.0f;
            if (transitionInitData.getStartScaleType() == ImageView.ScaleType.FIT_CENTER && transitionInitData.getEndScaleType() == ImageView.ScaleType.CENTER_CROP) {
                scaleFactor = (transitionAnimConfig.getScaleFactor() - 1.0f) * f16;
            } else {
                if (transitionInitData.getStartScaleType() == ImageView.ScaleType.CENTER_CROP && transitionInitData.getEndScaleType() == ImageView.ScaleType.FIT_CENTER) {
                    scaleFactor = transitionAnimConfig.getScaleFactor();
                    f19 = (1.0f - transitionAnimConfig.getScaleFactor()) * f16;
                }
                setScale(transitionAnimConfig.getImageView(), ((float) (1.0d / f17)) * f19, ((float) (1.0d / f18)) * f19);
            }
            f19 += scaleFactor;
            setScale(transitionAnimConfig.getImageView(), ((float) (1.0d / f17)) * f19, ((float) (1.0d / f18)) * f19);
        }
    }

    public static void setScale(View view, float f16, float f17) {
        if (view == null) {
            return;
        }
        view.setScaleX(f16);
        view.setScaleY(f17);
    }

    public static void setTranslation(View view, float f16, float f17) {
        if (view == null) {
            return;
        }
        view.setTranslationX(f16);
        view.setTranslationY(f17);
    }

    public static void setViewLayoutParams(View view, int i3, int i16) {
        if (view != null && (view.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i16;
            view.setLayoutParams(layoutParams);
        }
    }

    public static void startAnim(final TransitionAnimConfig transitionAnimConfig, final TransitionInitData transitionInitData, final OnAnimCallback onAnimCallback, boolean z16) {
        float f16;
        if (transitionAnimConfig != null && transitionInitData != null) {
            QLog.d("TM-TransitionAnimator", 1, "startAnim  isReverse = " + z16);
            AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
            float f17 = 1.0f;
            if (z16) {
                f16 = 1.0f;
            } else {
                f16 = 0.0f;
            }
            if (z16) {
                f17 = 0.0f;
            }
            ValueAnimator duration = ValueAnimator.ofFloat(f16, f17).setDuration(transitionInitData.getTransitionAniDurationMs());
            duration.setInterpolator(accelerateDecelerateInterpolator);
            duration.addListener(new Animator.AnimatorListener() { // from class: com.tencent.biz.richframework.animation.transition.TransitionAnimator.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    QLog.d("TM-TransitionAnimator", 1, "[onAnimationCancel] animation: " + animator + " | onAnimCallback: " + OnAnimCallback.this + " | isRunningInBackground: " + RFWLifecycleHelper.getInstance().isRunningInBackground());
                    OnAnimCallback onAnimCallback2 = OnAnimCallback.this;
                    if (onAnimCallback2 != null) {
                        onAnimCallback2.onAnimationCancel();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    QLog.d("TM-TransitionAnimator", 1, "[onAnimationEnd] animation: " + animator + " | onAnimCallback: " + OnAnimCallback.this + " | isRunningInBackground: " + RFWLifecycleHelper.getInstance().isRunningInBackground());
                    OnAnimCallback onAnimCallback2 = OnAnimCallback.this;
                    if (onAnimCallback2 != null) {
                        onAnimCallback2.onAnimationEnd();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    QLog.d("TM-TransitionAnimator", 1, "[onAnimationStart] animation: " + animator + " | onAnimCallback: " + OnAnimCallback.this + " | isRunningInBackground: " + RFWLifecycleHelper.getInstance().isRunningInBackground());
                    OnAnimCallback onAnimCallback2 = OnAnimCallback.this;
                    if (onAnimCallback2 != null) {
                        onAnimCallback2.onAnimationStart();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.richframework.animation.transition.TransitionAnimator.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!(valueAnimator.getAnimatedValue() instanceof Float)) {
                        return;
                    }
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float curValue = TransitionAnimator.getCurValue(TransitionAnimConfig.this, 5, floatValue);
                    float curValue2 = TransitionAnimator.getCurValue(TransitionAnimConfig.this, 6, floatValue);
                    float curValue3 = TransitionAnimator.getCurValue(TransitionAnimConfig.this, 1, floatValue);
                    float curValue4 = TransitionAnimator.getCurValue(TransitionAnimConfig.this, 2, floatValue);
                    float curValue5 = TransitionAnimator.getCurValue(TransitionAnimConfig.this, 3, floatValue);
                    float curValue6 = TransitionAnimator.getCurValue(TransitionAnimConfig.this, 4, floatValue);
                    int width = (int) (transitionInitData.getLayoutEndRect().width() * curValue3);
                    int height = (int) (transitionInitData.getLayoutEndRect().height() * curValue4);
                    int width2 = (int) (curValue5 * transitionInitData.getImageEndRect().width());
                    int height2 = (int) (curValue6 * transitionInitData.getImageEndRect().height());
                    TransitionAnimator.setScale(TransitionAnimConfig.this.getRootView(), curValue3, curValue4);
                    TransitionAnimator.setTranslation(TransitionAnimConfig.this.getRootView(), curValue, curValue2);
                    TransitionAnimator.setImageViewPadding(width, height, width2, height2, transitionInitData, TransitionAnimConfig.this);
                    TransitionAnimator.setViewLayoutParams(TransitionAnimConfig.this.getImageView(), width, height);
                    TransitionAnimator.setImageViewScale(floatValue, curValue3, curValue4, transitionInitData, TransitionAnimConfig.this);
                }
            });
            duration.start();
            return;
        }
        QLog.d("TM-TransitionAnimator", 1, "[startAnim] animConfig == null || initData == null.");
    }
}
