package com.tencent.mobileqq.profilecard.utils;

import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;
import com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* loaded from: classes16.dex */
public class ProfileServiceUtils {
    static IPatchRedirector $redirector_;

    public ProfileServiceUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static <T extends AbsProfileBusinessProcessor> T getBusinessProcessor(AppRuntime appRuntime, Class<? extends AbsProfileBusinessProcessor> cls) {
        return (T) getIProfileProtocolService(appRuntime).getBusinessProcessor(cls);
    }

    public static IProfileProtocolService getIProfileProtocolService(AppRuntime appRuntime) {
        return (IProfileProtocolService) appRuntime.getRuntimeService(IProfileProtocolService.class, "all");
    }
}
