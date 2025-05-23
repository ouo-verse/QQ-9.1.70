package com.tencent.gdtad.basics.adshake.animatorview.animator;

import android.animation.TimeInterpolator;
import android.graphics.Canvas;
import com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes6.dex */
public class ScaleAnimator extends Animator {
    private float mFromXScale;
    private float mFromYScale;
    private float mPx;
    private float mPy;
    private int mScalePointType;
    private float mToXScale;
    private float mToYScale;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface ScalePointType {
        public static final int ABSOLUTE_POSITION = 1;
        public static final int RELATIVE_POSITION = 2;
    }

    public ScaleAnimator(AnimatorLayer animatorLayer, int i3, int i16, int i17, int i18) {
        this(animatorLayer, i3, i16, i17, i18, Float.MIN_VALUE, Float.MIN_VALUE);
    }

    private float computeScale(float f16, float f17, float f18) {
        float f19 = f16 + ((f17 - f16) * f18);
        if (f19 < 0.0f) {
            return 0.0f;
        }
        return f19;
    }

    private static float getScaleFromSize(int i3, int i16) {
        if (i3 == 0) {
            return 1.0f;
        }
        return i16 / i3;
    }

    private void postScale(Canvas canvas, AnimatorLayer animatorLayer, float f16, float f17, float f18) {
        resetMatrix(animatorLayer, animatorLayer.getMatrix());
        float f19 = this.mPx;
        if (f19 == Float.MIN_VALUE) {
            f19 = animatorLayer.getCenterX();
        }
        float f26 = f19;
        float f27 = this.mPy;
        if (f27 == Float.MIN_VALUE) {
            f27 = animatorLayer.getCenterY();
        }
        animatorLayer.postScale(f16, f17, f26, f27, f18);
        drawCanvas(canvas, animatorLayer);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.Animator
    protected void onPostAnimation(Canvas canvas, AnimatorLayer animatorLayer, boolean z16) {
        if (z16 && !shouldRepeat()) {
            postScale(canvas, animatorLayer, this.mToXScale, this.mToYScale, 1.0f);
            return;
        }
        float progress = getProgress();
        TimeInterpolator timeInterpolator = this.mInterpolator;
        if (timeInterpolator != null) {
            progress = timeInterpolator.getInterpolation(progress);
        }
        if (getRepeatMode() == 2 && getRepeatIndex() % 2 != 0) {
            progress = 1.0f - progress;
        }
        float f16 = progress;
        postScale(canvas, animatorLayer, computeScale(this.mFromXScale, this.mToXScale, f16), computeScale(this.mFromYScale, this.mToYScale, f16), f16);
    }

    public ScaleAnimator(AnimatorLayer animatorLayer, int i3, int i16, int i17, int i18, float f16, float f17) {
        this(animatorLayer, getScaleFromSize(animatorLayer.getWidth(), i3), getScaleFromSize(animatorLayer.getWidth(), i16), getScaleFromSize(animatorLayer.getHeight(), i17), getScaleFromSize(animatorLayer.getHeight(), i18), f16, f17);
    }

    public ScaleAnimator(AnimatorLayer animatorLayer, float f16, float f17, float f18, float f19) {
        this(animatorLayer, f16, f17, f18, f19, Float.MIN_VALUE, Float.MIN_VALUE);
    }

    public ScaleAnimator(AnimatorLayer animatorLayer, float f16, float f17, float f18, float f19, float f26, float f27) {
        super(animatorLayer);
        this.mScalePointType = 2;
        this.mFromXScale = f16;
        this.mToXScale = f17;
        this.mFromYScale = f18;
        this.mToYScale = f19;
        this.mPx = f26;
        this.mPy = f27;
    }
}
