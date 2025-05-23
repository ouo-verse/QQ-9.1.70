package com.tencent.mobileqq.qqlive.data.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveEventMsg {
    static IPatchRedirector $redirector_;
    public int errorCode;
    public int eventId;
    public String message;

    public QQLiveEventMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QQLiveEventMsg{eventId=" + this.eventId + ", errorCode=" + this.errorCode + ", message='" + this.message + '}';
    }
}
