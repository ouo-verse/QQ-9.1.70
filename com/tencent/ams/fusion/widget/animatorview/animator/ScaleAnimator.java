package com.tencent.ams.fusion.widget.animatorview.animator;

import android.animation.TimeInterpolator;
import android.graphics.Canvas;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ScaleAnimator extends Animator {
    static IPatchRedirector $redirector_;
    private final float mFromXScale;
    private final float mFromYScale;
    private final float mToXScale;
    private final float mToYScale;

    public ScaleAnimator(AnimatorLayer animatorLayer, int i3, int i16, int i17, int i18) {
        this(animatorLayer, getScaleFromSize(animatorLayer.getWidth(), i3), getScaleFromSize(animatorLayer.getWidth(), i16), getScaleFromSize(animatorLayer.getHeight(), i17), getScaleFromSize(animatorLayer.getHeight(), i18));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, animatorLayer, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
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
        animatorLayer.getPx();
        animatorLayer.getPy();
        animatorLayer.getCenterX();
        animatorLayer.getCenterX();
        animatorLayer.getCenterY();
        animatorLayer.getCenterY();
        animatorLayer.postScale(f16, f17);
        drawCanvas(canvas, animatorLayer);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator
    protected void onPostAnimation(Canvas canvas, AnimatorLayer animatorLayer, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, canvas, animatorLayer, Boolean.valueOf(z16));
            return;
        }
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

    public ScaleAnimator(AnimatorLayer animatorLayer, float f16, float f17, float f18, float f19) {
        super(animatorLayer);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, animatorLayer, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        this.mFromXScale = f16;
        this.mToXScale = f17;
        this.mFromYScale = f18;
        this.mToYScale = f19;
    }
}
