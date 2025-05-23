package com.tencent.avcore.jni.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class NtrtcAppParam {
    static IPatchRedirector $redirector_;
    public String appId;
    public int productAppId;
    public String productId;
    public String productVersion;

    public NtrtcAppParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
