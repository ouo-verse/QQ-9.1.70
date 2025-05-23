package com.tencent.ams.fusion.widget.animatorview.animator;

import android.graphics.Canvas;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class KeepAnimator extends Animator {
    static IPatchRedirector $redirector_;

    public KeepAnimator(AnimatorLayer animatorLayer) {
        super(animatorLayer);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) animatorLayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator
    public void onPostAnimation(Canvas canvas, AnimatorLayer animatorLayer, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, canvas, animatorLayer, Boolean.valueOf(z16));
        } else {
            resetMatrix(animatorLayer, animatorLayer.getMatrix());
            animatorLayer.setMatrixChanged(false);
        }
    }
}
