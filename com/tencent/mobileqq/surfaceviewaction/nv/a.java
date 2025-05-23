package com.tencent.mobileqq.surfaceviewaction.nv;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.presseffect.PressEffectImageView;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends d {
    static IPatchRedirector $redirector_;
    protected String T;

    public a(SpriteNativeView spriteNativeView, String str) {
        super(spriteNativeView);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) spriteNativeView, (Object) str);
        } else {
            this.T = str;
        }
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.nv.d
    protected ImageView C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ImageView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new PressEffectImageView(this.P.getContext());
    }

    public void E(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) onClickListener);
        } else {
            this.R.setOnClickListener(onClickListener);
        }
    }
}
