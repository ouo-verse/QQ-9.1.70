package com.tencent.ams.fusion.widget.slopecard;

import android.graphics.Bitmap;
import com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ReversibleBitmapLayer extends BitmapLayer {
    static IPatchRedirector $redirector_;
    private Bitmap mReverseBitmap;

    public ReversibleBitmapLayer(Bitmap bitmap) {
        super(bitmap);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bitmap);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer
    public Bitmap getBitmap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bitmap) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        float f16 = this.mRotationYDegrees % 360.0f;
        if (f16 >= 90.0f && f16 <= 270.0f) {
            return this.mReverseBitmap;
        }
        return super.getBitmap();
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postRotationY(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
        } else {
            super.postRotationY(f16);
        }
    }

    public void setReverseBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmap);
        } else {
            this.mReverseBitmap = adapterGrayBitmap(bitmap);
        }
    }
}
