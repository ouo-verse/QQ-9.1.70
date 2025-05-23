package com.tencent.ams.fusion.widget.animatorview.animator;

import android.animation.TimeInterpolator;
import android.graphics.Canvas;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TranslateAnimator extends Animator {
    static IPatchRedirector $redirector_;
    private float mFromXDelta;
    private float mFromYDelta;
    private float mToXDelta;
    private float mToYDelta;

    public TranslateAnimator(AnimatorLayer animatorLayer, float f16, float f17, float f18, float f19) {
        super(animatorLayer);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, animatorLayer, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        this.mFromXDelta = f16;
        this.mToXDelta = f17;
        this.mFromYDelta = f18;
        this.mToYDelta = f19;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator
    protected void onPostAnimation(Canvas canvas, AnimatorLayer animatorLayer, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, canvas, animatorLayer, Boolean.valueOf(z16));
            return;
        }
        if (z16 && !shouldRepeat()) {
            postTranslate(canvas, animatorLayer, this.mToXDelta, this.mToYDelta);
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
        float f16 = this.mFromXDelta;
        float f17 = f16 + ((this.mToXDelta - f16) * progress);
        float f18 = this.mFromYDelta;
        postTranslate(canvas, animatorLayer, f17, f18 + ((this.mToYDelta - f18) * progress));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void postTranslate(Canvas canvas, AnimatorLayer animatorLayer, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, canvas, animatorLayer, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            resetMatrix(animatorLayer, animatorLayer.getMatrix());
            animatorLayer.postTranslate(f16, f17);
        }
    }
}
