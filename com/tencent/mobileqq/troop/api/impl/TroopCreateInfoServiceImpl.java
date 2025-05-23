package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService;
import com.tencent.mobileqq.troop.data.TroopCreateInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopCreateInfoServiceImpl implements ITroopCreateInfoService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TroopCreateServiceImpl";
    protected TroopCreateInfo createInfo;

    public TroopCreateInfoServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCreateInfoService
    public void clearTroopCreateInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        TroopCreateInfo troopCreateInfo = this.createInfo;
        if (troopCreateInfo != null) {
            troopCreateInfo.reset();
            this.createInfo.setCreateScene("");
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TROOP_CREATE, 2, "clearTroopCreateInfo");
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCreateInfoService
    public void deleteInInviteList(String str, String str2) {
        TroopCreateInfo troopCreateInfo;
        List<TroopCreateInfo.a> list;
        TroopCreateInfo.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (str != null && str2 != null && (troopCreateInfo = this.createInfo) != null && str.equals(troopCreateInfo.troopUin) && (list = this.createInfo.inviteMembers) != null) {
            Iterator<TroopCreateInfo.a> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    aVar = it.next();
                    if (str2.equals(aVar.f294787a)) {
                        break;
                    }
                } else {
                    aVar = null;
                    break;
                }
            }
            if (aVar != null) {
                this.createInfo.inviteMembers.remove(aVar);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "deleteInInviteList troopUin:" + str + "  memberUin:" + str2);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCreateInfoService
    public TroopCreateInfo getTroopCreateInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TroopCreateInfo) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.createInfo == null) {
            this.createInfo = new TroopCreateInfo();
        }
        return this.createInfo;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCreateInfoService
    public boolean isInInviteList(String str, String str2) {
        TroopCreateInfo troopCreateInfo;
        List<TroopCreateInfo.a> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        if (str != null && str2 != null && (troopCreateInfo = this.createInfo) != null && str.equals(troopCreateInfo.troopUin) && (list = this.createInfo.inviteMembers) != null) {
            Iterator<TroopCreateInfo.a> it = list.iterator();
            while (it.hasNext()) {
                if (str2.equals(it.next().f294787a)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.createInfo = new TroopCreateInfo();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            clearTroopCreateInfo();
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCreateInfoService
    public final void refreshCreateInfo(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, i3);
        } else {
            this.createInfo.reset();
            this.createInfo.parseFromJsonString(str);
        }
    }
}
