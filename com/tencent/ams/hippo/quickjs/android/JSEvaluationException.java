package com.tencent.ams.hippo.quickjs.android;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class JSEvaluationException extends RuntimeException {
    static IPatchRedirector $redirector_;
    private JSException jsException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSEvaluationException(JSException jSException) {
        super(jSException.toString());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) jSException);
        }
    }

    public JSException getJSException() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSException) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.jsException;
    }
}
