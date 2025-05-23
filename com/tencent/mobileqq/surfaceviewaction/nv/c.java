package com.tencent.mobileqq.surfaceviewaction.nv;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.surfaceviewaction.f;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends com.tencent.mobileqq.surfaceviewaction.a {
    static IPatchRedirector $redirector_;
    protected SpriteNativeView P;
    protected f Q;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.Q = new f(0.0f, 0.0f);
        }
    }

    public boolean A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        this.M = this.P.getWidth();
        this.N = this.P.getHeight();
        return e();
    }

    public void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.a
    public com.tencent.mobileqq.surfaceviewaction.e<c> j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.surfaceviewaction.e) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.P;
    }
}
