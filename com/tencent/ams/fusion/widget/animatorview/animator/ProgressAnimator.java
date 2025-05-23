package com.tencent.ams.fusion.widget.animatorview.animator;

import android.animation.TimeInterpolator;
import android.graphics.Canvas;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class ProgressAnimator extends Animator {
    static IPatchRedirector $redirector_;
    private float mFromProgress;
    private float mToProgress;

    public ProgressAnimator(AnimatorLayer animatorLayer, float f16, float f17) {
        super(animatorLayer);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, animatorLayer, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.mFromProgress = f16;
            this.mToProgress = f17;
        }
    }

    private float getProgressDiff() {
        return this.mToProgress - this.mFromProgress;
    }

    private void postProgress(Canvas canvas, AnimatorLayer animatorLayer, float f16) {
        resetMatrix(animatorLayer, animatorLayer.getMatrix());
        animatorLayer.postProgress(f16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float computeProgress() {
        float progressDiff;
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
        }
        float progress = getProgress();
        TimeInterpolator timeInterpolator = this.mInterpolator;
        if (timeInterpolator != null) {
            progress = timeInterpolator.getInterpolation(progress);
        }
        if (getRepeatMode() == 2 && getRepeatIndex() % 2 != 0) {
            progressDiff = getProgressDiff() * (1.0f - progress);
            f16 = this.mFromProgress;
        } else {
            progressDiff = getProgressDiff() * progress;
            f16 = this.mFromProgress;
        }
        return progressDiff + f16;
    }

    public float getToProgress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
        }
        return this.mToProgress;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator
    public void onPostAnimation(Canvas canvas, AnimatorLayer animatorLayer, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, canvas, animatorLayer, Boolean.valueOf(z16));
        } else if (z16 && !shouldRepeat()) {
            postProgress(canvas, animatorLayer, this.mToProgress);
        } else {
            postProgress(canvas, animatorLayer, computeProgress());
        }
    }

    public void setFromProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
        } else {
            this.mFromProgress = f16;
        }
    }

    public void setToProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
        } else {
            this.mToProgress = f16;
        }
    }
}
