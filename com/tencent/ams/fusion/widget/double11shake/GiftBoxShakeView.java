package com.tencent.ams.fusion.widget.double11shake;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.double11shake.DoubleElevenShakeAnimationHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class GiftBoxShakeView extends DoubleElevenShakeView {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "GiftBoxShakeView";
    private Drawable mShakeIconDrawable;

    public GiftBoxShakeView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // com.tencent.ams.fusion.widget.double11shake.DoubleElevenShakeView
    protected AnimatorLayer createShakeIconLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Drawable drawable = this.mShakeIconDrawable;
        if (drawable == null) {
            return null;
        }
        return DoubleElevenShakeAnimationHelper.getShakeIconAnimatorLayer(drawable, this.mAnimationType, new DoubleElevenShakeAnimationHelper.IconParams((getWidth() / 2.0f) - getShakeCircleBgRadius(), getShakeIconCenterY() - getShakeCircleBgRadius(), getShakeCircleBgRadius() * 2.0f, getShakeCircleBgRadius() * 2.0f, this.mIconZoomFactor), (Animator.AnimatorListener) null);
    }

    public void setShakeIconDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable);
        } else {
            this.mShakeIconDrawable = drawable;
        }
    }
}
