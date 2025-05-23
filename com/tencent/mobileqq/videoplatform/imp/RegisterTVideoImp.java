package com.tencent.mobileqq.videoplatform.imp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.videoplatform.api.IRegisterTVideo;

/* compiled from: P */
/* loaded from: classes20.dex */
public class RegisterTVideoImp implements IRegisterTVideo {
    static IPatchRedirector $redirector_;

    public RegisterTVideoImp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IRegisterTVideo
    public void registerTVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }
}
