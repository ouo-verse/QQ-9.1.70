package com.tencent.mobileqq.profilecard.api.impl;

import com.tencent.mobileqq.profilecard.api.IProfileHandlerApi;
import com.tencent.mobileqq.profilecard.handler.ProfileCardHandler;
import com.tencent.mobileqq.profilecommon.handler.ProfileCommonHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes16.dex */
public class ProfileHandlerApiImpl implements IProfileHandlerApi {
    static IPatchRedirector $redirector_;
    private static final String PROFILE_CARD_HANDLER;
    private static final String PROFILE_COMMON_HANDLER;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42248);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            PROFILE_CARD_HANDLER = ProfileCardHandler.class.getName();
            PROFILE_COMMON_HANDLER = ProfileCommonHandler.class.getName();
        }
    }

    public ProfileHandlerApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileHandlerApi
    public String getProfileCardHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return PROFILE_CARD_HANDLER;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileHandlerApi
    public String getProfileCommonHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return PROFILE_COMMON_HANDLER;
    }
}
