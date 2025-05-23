package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class OnReceiveVerify {
    static IPatchRedirector $redirector_;
    public int addMessageTimes;
    public int notifyUITimes;
    public String playback;
    public String req;
    public String resp;
    public String result;

    public OnReceiveVerify() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
