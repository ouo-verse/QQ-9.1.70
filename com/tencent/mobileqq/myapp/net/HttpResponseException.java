package com.tencent.mobileqq.myapp.net;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class HttpResponseException extends Exception {
    static IPatchRedirector $redirector_ = null;
    private static final long serialVersionUID = 1;
    private int stateCode;

    public HttpResponseException(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.stateCode = i3;
        }
    }

    public int getStateCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return this.stateCode;
    }
}
