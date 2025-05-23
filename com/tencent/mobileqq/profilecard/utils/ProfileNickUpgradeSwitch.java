package com.tencent.mobileqq.profilecard.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class ProfileNickUpgradeSwitch implements IAccountCallback {
    static IPatchRedirector $redirector_ = null;
    private static final String SWITCH_NAME = "qq_profile_nick_upgrade_8930_switch";
    private static final String TAG = "ProfileNickUpgradeSwitch";
    private boolean mIsEnable;
    private boolean mIsUpdated;

    /* loaded from: classes16.dex */
    private static class Holder {
        static IPatchRedirector $redirector_;
        private static final ProfileNickUpgradeSwitch sInstance;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36625);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                sInstance = new ProfileNickUpgradeSwitch();
            }
        }

        Holder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    ProfileNickUpgradeSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mIsUpdated = false;
        this.mIsEnable = false;
        MobileQQ.sMobileQQ.registerAccountCallback(this);
        updateSwitchLocal();
    }

    private void checkIsValidAndUpdate() {
        if (this.mIsUpdated) {
            return;
        }
        updateSwitchLocal();
    }

    public static ProfileNickUpgradeSwitch getInstance() {
        return Holder.sInstance;
    }

    private void updateSwitchLocal() {
        this.mIsEnable = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(SWITCH_NAME, false);
        this.mIsUpdated = true;
        QLog.i(TAG, 1, "updateSwitchLocal:" + this.mIsEnable);
    }

    public boolean isEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        checkIsValidAndUpdate();
        return this.mIsEnable;
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChangeFailed(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime);
        }
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChanged(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
            return;
        }
        this.mIsUpdated = false;
        if (QLog.isDebugVersion() && appRuntime != null) {
            QLog.d(TAG, 1, "onAccountChanged:" + appRuntime.getCurrentAccountUin());
        }
    }

    @Override // mqq.app.IAccountCallback
    public void onLogout(Constants.LogoutReason logoutReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) logoutReason);
            return;
        }
        this.mIsUpdated = false;
        if (QLog.isDebugVersion() && logoutReason != null) {
            QLog.d(TAG, 1, "onLogout:" + logoutReason.toString());
        }
    }
}
