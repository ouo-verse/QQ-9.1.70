package com.tencent.mobileqq.videoplatform.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.videoplatform.api.IRegisterTVideo;
import com.tencent.mobileqq.videoplatform.imp.RegisterTVideoImp;

/* compiled from: P */
/* loaded from: classes20.dex */
public class RegisterTVideoUtil {
    static IPatchRedirector $redirector_;
    private static IRegisterTVideo sRegisterTVideo;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14796);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sRegisterTVideo = new RegisterTVideoImp();
        }
    }

    public RegisterTVideoUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void registerTVideo() {
        sRegisterTVideo.registerTVideo();
    }

    public static void setRegisterTVideoImp(IRegisterTVideo iRegisterTVideo) {
        sRegisterTVideo = iRegisterTVideo;
    }
}
