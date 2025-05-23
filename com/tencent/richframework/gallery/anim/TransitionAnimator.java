package com.tencent.richframework.gallery.anim;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.tencent.biz.richframework.animation.interpolator.EaseCubicInterpolator;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.richframework.gallery.anim.TransitionAnimator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\"B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\"\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000e\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006J \u0010\u0012\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J,\u0010\u0019\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0017J\u0018\u0010\u001c\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001b\u001a\u00020\u001aR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/richframework/gallery/anim/TransitionAnimator;", "", "Lcom/tencent/richframework/gallery/anim/TransitionAnimConfig;", "animConfig", "", "valueType", "", "animatedValue", "getCurValue", "Landroid/view/View;", "view", "translationX", "translationY", "", "setTranslation", "coverView", "width", "height", "setViewLayoutParams", "Lcom/tencent/richframework/gallery/anim/TransitionInitData;", "initData", "Lcom/tencent/richframework/gallery/anim/TransitionAnimator$OnAnimCallback;", "onAnimCallback", "", "isReverse", "startAnim", "", "duration", "fadeCover", "Landroid/view/animation/Interpolator;", "sAnimInterpolator", "Landroid/view/animation/Interpolator;", "<init>", "()V", "OnAnimCallback", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class TransitionAnimator {

    @NotNull
    public static final TransitionAnimator INSTANCE = new TransitionAnimator();
    private static final Interpolator sAnimInterpolator = new EaseCubicInterpolator(0.39f, 0.0f, 0.23f, 1.0f);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/richframework/gallery/anim/TransitionAnimator$OnAnimCallback;", "", "onAnimaUpdate", "", "value", "", "onAnimationCancel", "onAnimationEnd", "onAnimationStart", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public interface OnAnimCallback {
        void onAnimaUpdate(float value);

        void onAnimationCancel();

        void onAnimationEnd();

        void onAnimationStart();
    }

    TransitionAnimator() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getCurValue(TransitionAnimConfig animConfig, int valueType, float animatedValue) {
        if (animConfig == null) {
            return 0.0f;
        }
        float startValue = animConfig.getStartValue(valueType);
        return startValue + ((animConfig.getEndValue(valueType) - startValue) * animatedValue);
    }

    public final void fadeCover(@Nullable final View coverView, long duration) {
        if (coverView == null) {
            return;
        }
        coverView.animate().alpha(0.0f).setDuration(duration).setListener(new Animator.AnimatorListener() { // from class: com.tencent.richframework.gallery.anim.TransitionAnimator$fadeCover$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                coverView.setAlpha(1.0f);
                coverView.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }).start();
    }

    public final void setTranslation(@Nullable View view, float translationX, float translationY) {
        if (view == null) {
            return;
        }
        view.setTranslationX(translationX);
        view.setTranslationY(translationY);
    }

    public final void setViewLayoutParams(@Nullable View coverView, int width, int height) {
        if (coverView != null && (coverView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.LayoutParams layoutParams = coverView.getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.width = width;
                marginLayoutParams.height = height;
                coverView.setLayoutParams(marginLayoutParams);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
    }

    public final void startAnim(@Nullable final TransitionAnimConfig animConfig, @Nullable final TransitionInitData initData, @Nullable final OnAnimCallback onAnimCallback, boolean isReverse) {
        float f16;
        if (animConfig != null && initData != null) {
            RFWLog.d("TM-TransitionAnimator", RFWLog.USR, "startAnim  isReverse = " + isReverse);
            float f17 = 1.0f;
            final float f18 = 0.0f;
            if (isReverse) {
                f16 = 1.0f;
            } else {
                f16 = 0.0f;
            }
            if (isReverse) {
                f17 = 0.0f;
            }
            ValueAnimator valueAnimator = ValueAnimator.ofFloat(f16, f17).setDuration(initData.getTransitionAniDurationMs());
            Intrinsics.checkNotNullExpressionValue(valueAnimator, "valueAnimator");
            valueAnimator.setInterpolator(sAnimInterpolator);
            valueAnimator.addListener(new Animator.AnimatorListener() { // from class: com.tencent.richframework.gallery.anim.TransitionAnimator$startAnim$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(@NotNull Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    TransitionAnimator.OnAnimCallback onAnimCallback2 = TransitionAnimator.OnAnimCallback.this;
                    if (onAnimCallback2 != null) {
                        onAnimCallback2.onAnimationCancel();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(@NotNull Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    TransitionAnimator.OnAnimCallback onAnimCallback2 = TransitionAnimator.OnAnimCallback.this;
                    if (onAnimCallback2 != null) {
                        onAnimCallback2.onAnimationEnd();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(@NotNull Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(@NotNull Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    TransitionAnimator.OnAnimCallback onAnimCallback2 = TransitionAnimator.OnAnimCallback.this;
                    if (onAnimCallback2 != null) {
                        onAnimCallback2.onAnimationStart();
                    }
                }
            });
            RectF layoutEndRect = initData.getLayoutEndRect();
            if (layoutEndRect != null) {
                f18 = layoutEndRect.top;
            }
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.richframework.gallery.anim.TransitionAnimator$startAnim$2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(@NotNull ValueAnimator animation) {
                    float curValue;
                    float curValue2;
                    float curValue3;
                    float curValue4;
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    if (!(animation.getAnimatedValue() instanceof Float)) {
                        return;
                    }
                    Object animatedValue = animation.getAnimatedValue();
                    if (animatedValue != null) {
                        float floatValue = ((Float) animatedValue).floatValue();
                        TransitionAnimator transitionAnimator = TransitionAnimator.INSTANCE;
                        curValue = transitionAnimator.getCurValue(TransitionAnimConfig.this, 3, floatValue);
                        curValue2 = transitionAnimator.getCurValue(TransitionAnimConfig.this, 4, floatValue);
                        RectF imageEndRect = initData.getImageEndRect();
                        Intrinsics.checkNotNull(imageEndRect);
                        int width = (int) (curValue * imageEndRect.width());
                        RectF imageEndRect2 = initData.getImageEndRect();
                        Intrinsics.checkNotNull(imageEndRect2);
                        int height = (int) (curValue2 * imageEndRect2.height());
                        curValue3 = transitionAnimator.getCurValue(TransitionAnimConfig.this, 7, floatValue);
                        curValue4 = transitionAnimator.getCurValue(TransitionAnimConfig.this, 8, floatValue);
                        TransitionAnimator.OnAnimCallback onAnimCallback2 = onAnimCallback;
                        Intrinsics.checkNotNull(onAnimCallback2);
                        onAnimCallback2.onAnimaUpdate(floatValue);
                        transitionAnimator.setTranslation(TransitionAnimConfig.this.getImageView(), (int) curValue3, ((int) curValue4) - f18);
                        transitionAnimator.setViewLayoutParams(TransitionAnimConfig.this.getImageView(), width, height);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                }
            });
            valueAnimator.start();
        }
    }
}
