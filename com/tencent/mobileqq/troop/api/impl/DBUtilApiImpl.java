package com.tencent.mobileqq.troop.api.impl;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.IDBUtilApi;
import com.tencent.mobileqq.troop.navigatebar.bean.TroopAioNavMsg;
import com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class DBUtilApiImpl implements IDBUtilApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DBUtilApiImpl";

    public DBUtilApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IDBUtilApi
    public void setTroopLuckyCharacterStatus(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, str3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setTroopLuckyCharacterStatus troopUin = " + str2 + ", wording = " + str3);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences(str, 0).edit();
            edit.putLong(str + ITroopSPUtilApi.KEY_TROOP_LUCKY_CHARACTER_STATUS + str2 + "time", currentTimeMillis);
            edit.putString(str + ITroopSPUtilApi.KEY_TROOP_LUCKY_CHARACTER_STATUS + str2 + "wording", str3);
            edit.apply();
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IDBUtilApi
    public Object transJsonToAioNavMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        return TroopAioNavMsg.parseFromJsonStr(str);
    }
}
