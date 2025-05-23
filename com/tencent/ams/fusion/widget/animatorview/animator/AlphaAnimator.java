package com.tencent.ams.fusion.widget.animatorview.animator;

import android.animation.TimeInterpolator;
import android.graphics.Canvas;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AlphaAnimator extends Animator {
    static IPatchRedirector $redirector_;
    private float mFromAlpha;
    private float mToAlpha;

    public AlphaAnimator(AnimatorLayer animatorLayer, float f16, float f17) {
        super(animatorLayer);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, animatorLayer, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.mFromAlpha = f16;
            this.mToAlpha = f17;
        }
    }

    private float computeAlpha() {
        float progress = getProgress();
        TimeInterpolator timeInterpolator = this.mInterpolator;
        if (timeInterpolator != null) {
            progress = timeInterpolator.getInterpolation(progress);
        }
        if (getRepeatMode() == 2 && getRepeatIndex() % 2 != 0) {
            progress = 1.0f - progress;
        }
        float f16 = this.mFromAlpha;
        float f17 = f16 + ((this.mToAlpha - f16) * progress);
        if (f17 < 0.0f) {
            return 0.0f;
        }
        if (f17 > 1.0f) {
            return 1.0f;
        }
        return f17;
    }

    private void postAlpha(Canvas canvas, AnimatorLayer animatorLayer, int i3) {
        resetMatrix(animatorLayer, animatorLayer.getMatrix());
        animatorLayer.postAlpha(i3);
    }

    public float getFromAlpha() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Float) iPatchRedirector.redirect((short) 3, (Object) this)).floatValue();
        }
        return this.mFromAlpha;
    }

    public float getToAlpha() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
        }
        return this.mToAlpha;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator
    protected void onPostAnimation(Canvas canvas, AnimatorLayer animatorLayer, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, canvas, animatorLayer, Boolean.valueOf(z16));
        } else if (z16 && !shouldRepeat()) {
            postAlpha(canvas, animatorLayer, (int) (this.mToAlpha * 255.0f));
        } else {
            postAlpha(canvas, animatorLayer, (int) (computeAlpha() * 255.0f));
        }
    }
}
