package com.tencent.mobileqq.qqlive.listener.trtc;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class RemoteUserAudioInfo {
    static IPatchRedirector $redirector_;
    public String userId;
    public int volume;

    public RemoteUserAudioInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
