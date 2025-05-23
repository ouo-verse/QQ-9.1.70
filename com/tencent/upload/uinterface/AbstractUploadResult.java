package com.tencent.upload.uinterface;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AbstractUploadResult {
    static IPatchRedirector $redirector_;
    public int flowId;
    public String sessionId;

    public AbstractUploadResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
