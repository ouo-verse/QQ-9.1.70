package com.tencent.mars.mm;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class SpeedTestCtx {
    static IPatchRedirector $redirector_;
    public byte[] downloadCtx;
    public byte[] uploadCtx;

    public SpeedTestCtx() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.uploadCtx = null;
            this.downloadCtx = null;
        }
    }
}
