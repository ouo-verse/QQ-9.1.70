package com.tencent.centaur.host.loader.inject;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CentaurInjectFailException extends Exception {
    static IPatchRedirector $redirector_;
    private int errCode;

    public CentaurInjectFailException(int i3, Throwable th5) {
        super(th5);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) th5);
        } else {
            this.errCode = i3;
        }
    }

    public int getErrCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.errCode;
    }
}
