package com.tencent.mobileqq.msf.sdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* loaded from: classes15.dex */
public class MsfMessagePair {
    static IPatchRedirector $redirector_;
    public FromServiceMsg fromServiceMsg;
    public String sendProcess;
    public ToServiceMsg toServiceMsg;

    public MsfMessagePair(String str, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, toServiceMsg, fromServiceMsg);
            return;
        }
        this.sendProcess = str;
        this.toServiceMsg = toServiceMsg;
        this.fromServiceMsg = fromServiceMsg;
    }

    public MsfMessagePair(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        this.sendProcess = null;
        this.toServiceMsg = toServiceMsg;
        this.fromServiceMsg = fromServiceMsg;
    }
}
