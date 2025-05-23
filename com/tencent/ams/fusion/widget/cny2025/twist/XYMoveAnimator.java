package com.tencent.ams.fusion.widget.cny2025.twist;

import android.graphics.Canvas;
import com.tencent.ams.fusion.widget.animatorview.Logger;
import com.tencent.ams.fusion.widget.animatorview.animator.ProgressAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class XYMoveAnimator extends ProgressAnimator {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "XYMoveAnimator";
    private final float mDeltaX;
    private final float mDeltaY;
    private final float mFromX;
    private final float mFromY;

    public XYMoveAnimator(AnimatorLayer animatorLayer, float f16, float f17, float f18, float f19) {
        super(animatorLayer, 0.0f, 1.0f);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, animatorLayer, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        this.mFromX = f16;
        this.mDeltaX = f17 - f16;
        this.mFromY = f18;
        this.mDeltaY = f19 - f18;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.fusion.widget.animatorview.animator.ProgressAnimator, com.tencent.ams.fusion.widget.animatorview.animator.Animator
    public void onPostAnimation(Canvas canvas, AnimatorLayer animatorLayer, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, canvas, animatorLayer, Boolean.valueOf(z16));
            return;
        }
        super.onPostAnimation(canvas, animatorLayer, z16);
        if (animatorLayer == null) {
            Logger.e(TAG, "onPostAnimation, layer is null");
            return;
        }
        if (z16 && !shouldRepeat()) {
            animatorLayer.setX(this.mFromX + (this.mDeltaX * getToProgress()));
            animatorLayer.setY(this.mFromY + (this.mDeltaY * getToProgress()));
        } else {
            animatorLayer.setX(this.mFromX + (this.mDeltaX * computeProgress()));
            animatorLayer.setY(this.mFromY + (this.mDeltaY * computeProgress()));
        }
    }
}
