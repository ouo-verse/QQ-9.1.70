package com.tencent.mobileqq.troop.troopsetting.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingFragmentV2;
import com.tencent.mobileqq.troop.troopsetting.activity.g;
import com.tencent.mobileqq.troop.troopsetting.api.ITroopSettingApi;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopSettingApiImpl implements ITroopSettingApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TroopSettingApiImpl";

    public TroopSettingApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.api.ITroopSettingApi
    public String getSimpleNameForTroopSettingActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return TroopSettingFragmentV2.class.getSimpleName();
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.api.ITroopSettingApi
    public Class<? extends Fragment> getTroopSettingFragmentClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return TroopSettingFragmentV2.class;
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.api.ITroopSettingApi
    public boolean handleShowSearchWayInAIO(@NonNull Context context, @Nullable String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) str)).booleanValue();
        }
        if (str == null || "".equals(str) || str.length() < 5) {
            return false;
        }
        TroopInfo findTroopInfo = ((ITroopInfoService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str);
        if (findTroopInfo != null && findTroopInfo.isOwnerOrAdmin()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.e(TAG, 2, "gotoGroupSearchSetting not admin " + str);
            return false;
        }
        Bundle b16 = aq.b(str, 115);
        b16.putString("focusItem", "searchWay");
        g.a(context, b16, 1);
        return true;
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.api.ITroopSettingApi
    public boolean isInstanceOfTroopSettingActivity(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity)).booleanValue();
        }
        return false;
    }
}
