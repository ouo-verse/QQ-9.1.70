package com.tencent.mobileqq.profilecard.api.impl;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardBlacklistApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi;
import com.tencent.mobileqq.profilecard.listener.CheckBlacklistListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes16.dex */
public class ProfileCardBlacklistApiImpl implements IProfileCardBlacklistApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileCardBlacklistApiImpl";

    public ProfileCardBlacklistApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardBlacklistApi
    public String getBlacklistTipMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        boolean isBlacklistUin = ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).isBlacklistUin(str, null);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "ProfileCardBlacklistApiImpl isBlacklist sync result is " + isBlacklistUin);
        }
        if (isBlacklistUin) {
            return HardCodeUtil.qqStr(R.string.f170037yk3);
        }
        return "";
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardBlacklistApi
    public int getProfileCardBlacklistReportType(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).intValue();
        }
        if (!((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).isBlackOrBlackedUin(str, null)) {
            return 3;
        }
        if (((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).isBlacklistUin(str, null)) {
            return 2;
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardBlacklistApi
    public boolean isBlackOrBlackedUin(String str, CheckBlacklistListener checkBlacklistListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) checkBlacklistListener)).booleanValue();
        }
        boolean isBlackOrBlackedUin = ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).isBlackOrBlackedUin(str, checkBlacklistListener);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "ProfileCardBlacklistApiImpl isBlackOrBlackedUin sync result is " + isBlackOrBlackedUin);
        }
        return isBlackOrBlackedUin;
    }
}
