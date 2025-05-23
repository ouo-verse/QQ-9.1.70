package com.tencent.ams.fusion.widget.animatorview.animator;

import android.graphics.Canvas;
import com.tencent.ams.fusion.widget.animatorview.AnimatorConfig;
import com.tencent.ams.fusion.widget.animatorview.AnimatorUtils;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ColorAnimator extends Animator {
    static IPatchRedirector $redirector_;
    private final int mFromColor;
    private final int mToColor;

    public ColorAnimator(AnimatorLayer animatorLayer, int i3, int i16) {
        super(animatorLayer);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, animatorLayer, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mFromColor = AnimatorConfig.isGrayModeOn() ? AnimatorUtils.convertGrayColor(i3) : i3;
            this.mToColor = AnimatorConfig.isGrayModeOn() ? AnimatorUtils.convertGrayColor(i16) : i16;
        }
    }

    private void postColor(AnimatorLayer animatorLayer, int i3) {
        resetMatrix(animatorLayer, animatorLayer.getMatrix());
        animatorLayer.getPaint().setColor(i3);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator
    protected void onPostAnimation(Canvas canvas, AnimatorLayer animatorLayer, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, canvas, animatorLayer, Boolean.valueOf(z16));
            return;
        }
        if (z16 && !shouldRepeat()) {
            postColor(animatorLayer, this.mToColor);
            return;
        }
        float progress = getProgress();
        if (getRepeatMode() == 2 && getRepeatIndex() % 2 != 0) {
            progress = 1.0f - progress;
        }
        postColor(animatorLayer, AnimatorUtils.getTransitionColor(progress, this.mFromColor, this.mToColor));
    }
}
