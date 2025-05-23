package com.tencent.mobileqq.profilecard.bussiness.accountinfo;

import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class ProfileAccountInfoV2Component extends BaseProfileAccountInfoV2Component {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileAccountInfoV2Component";

    public ProfileAccountInfoV2Component(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        }
    }
}
