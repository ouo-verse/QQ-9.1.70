package com.tencent.mobileqq.abtest.api.impl;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.mobileqq.abtest.api.IAddFriendTabApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.utils.abtest.QCommonOnlineExpProviderImpl;
import com.tencent.mobileqq.widget.FriendPermissionsSwitch;

/* compiled from: P */
/* loaded from: classes9.dex */
public class AddFriendTabApiImpl implements IAddFriendTabApi {
    static IPatchRedirector $redirector_;

    public AddFriendTabApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.abtest.api.IAddFriendTabApi
    public FrameLayout createPermissionSwitchForContacts(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
        FriendPermissionsSwitch friendPermissionsSwitch = new FriendPermissionsSwitch(context);
        friendPermissionsSwitch.t();
        return friendPermissionsSwitch;
    }

    @Override // com.tencent.mobileqq.abtest.api.IAddFriendTabApi
    public FrameLayout createPermissionSwitchGeneral(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        }
        return new FriendPermissionsSwitch(context);
    }

    @Override // com.tencent.mobileqq.abtest.api.IAddFriendTabApi
    public int getReportParam(FrameLayout frameLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) frameLayout)).intValue();
        }
        if (frameLayout instanceof FriendPermissionsSwitch) {
            return ((FriendPermissionsSwitch) frameLayout).h();
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.abtest.api.IAddFriendTabApi
    public boolean getSwitchExpRes(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(str);
        expEntity.reportExpExposure();
        return expEntity.isExperiment();
    }

    @Override // com.tencent.mobileqq.abtest.api.IAddFriendTabApi
    public int getSwitchResult(FrameLayout frameLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) frameLayout)).intValue();
        }
        if (frameLayout instanceof FriendPermissionsSwitch) {
            return ((FriendPermissionsSwitch) frameLayout).i();
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.abtest.api.IAddFriendTabApi
    public boolean isAddQZonePermissionSwitch(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, i3)).booleanValue();
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(QCommonOnlineExpProviderImpl.EXP_QZONE_PEZRMISSION_SWITCH);
        if (expEntity.isExperiment(QCommonOnlineExpProviderImpl.EXP_QZONE_PEZRMISSION_SWITCH_A)) {
            return false;
        }
        if (expEntity.isExperiment(QCommonOnlineExpProviderImpl.EXP_QZONE_PEZRMISSION_SWITCH_B)) {
            if (i3 != 0) {
                return false;
            }
        } else if (expEntity.isExperiment(QCommonOnlineExpProviderImpl.EXP_QZONE_PEZRMISSION_SWITCH_C)) {
            if (i3 != 1) {
                return false;
            }
        } else if (!expEntity.isExperiment(QCommonOnlineExpProviderImpl.EXP_QZONE_PEZRMISSION_SWITCH_D)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.abtest.api.IAddFriendTabApi
    public void showBlockLayoutOnly(FrameLayout frameLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) frameLayout);
        } else if (frameLayout instanceof FriendPermissionsSwitch) {
            ((FriendPermissionsSwitch) frameLayout).o();
        }
    }
}
