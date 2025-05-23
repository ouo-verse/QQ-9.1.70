package com.tencent.mobileqq.surfaceviewaction.gl;

import android.view.MotionEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends com.tencent.mobileqq.surfaceviewaction.a {
    static IPatchRedirector $redirector_;
    protected SpriteGLView P;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    interface a {
        boolean c(MotionEvent motionEvent, int i3, int i16);
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void A(int i3, int i16, int i17, int i18, int i19, int i26, int i27, float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), fArr);
            return;
        }
        this.M = i3;
        this.N = i16;
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.a
    public com.tencent.mobileqq.surfaceviewaction.e j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.surfaceviewaction.e) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.P;
    }
}
