package com.tencent.avcore.jni.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class NtrtcNetworkParam {
    static IPatchRedirector $redirector_;
    public String deviceImsi;
    public int networkType;

    public NtrtcNetworkParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
