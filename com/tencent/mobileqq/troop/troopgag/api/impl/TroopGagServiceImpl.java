package com.tencent.mobileqq.troop.troopgag.api.impl;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopgag.api.ITroopGagService;
import com.tencent.mobileqq.troop.troopgag.data.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopGagServiceImpl implements ITroopGagService {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "TroopGagServiceImpl";
    protected AppRuntime mApp;

    public TroopGagServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private String gagTimeToStringCountDown(Context context, long j3) {
        long j16;
        long serverTime = NetConnInfoCenter.getServerTime();
        if (j3 <= serverTime) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, String.format("error: gagTimeToStringCountDown gagTime <= currentTimeMs", new Object[0]));
            }
            j16 = 0;
        } else {
            j16 = j3 - serverTime;
        }
        return remainingTimeToStringCountDown(context, j16, j3);
    }

    private boolean isAdmin(String str) {
        TroopInfo troopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getTroopInfoFromCache(str);
        if (troopInfoFromCache == null) {
            return false;
        }
        MemberRole memberRole = troopInfoFromCache.memberRole;
        if (memberRole != MemberRole.ADMIN && memberRole != MemberRole.OWNER) {
            return false;
        }
        return true;
    }

    private String remainingTimeToStringCountDown(Context context, long j3, long j16) {
        Context applicationContext = this.mApp.getApplication().getApplicationContext();
        String string = applicationContext.getString(R.string.emx);
        String string2 = applicationContext.getString(R.string.emw);
        String string3 = applicationContext.getString(R.string.emv);
        String qqStr = HardCodeUtil.qqStr(R.string.ugd);
        if (j3 < 60) {
            return String.format(qqStr, 1, string);
        }
        if (j3 <= 3540) {
            return String.format(qqStr, Long.valueOf((j3 + 57) / 60), string);
        }
        if (j3 <= 84600) {
            return String.format(qqStr, Long.valueOf(Math.round((((float) j3) * 1.0f) / 3600.0f)), string2);
        }
        return String.format(qqStr, Long.valueOf(Math.round((((float) j3) * 1.0f) / 86400.0f)), string3);
    }

    @Override // com.tencent.mobileqq.troop.troopgag.api.ITroopGagService
    public d getSelfGagInfo(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (d) iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16));
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("fightgag.getSelfGagInfo240:sUin=%s,", str));
        }
        TroopInfo troopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getTroopInfoFromCache(str);
        if (troopInfoFromCache == null) {
            QLog.e(TAG, 1, "getSelfGagInfo troopInfo is null");
            return new d(str, false, "", 0L);
        }
        long serverTime = NetConnInfoCenter.getServerTime();
        boolean isAdmin = isAdmin(str);
        if (troopInfoFromCache.dwGagTimeStamp != 0 && !isAdmin) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, String.format("getTroopGagInfo:sUin=%s, Troop Gag", str));
            }
            return new d(str, true, this.mApp.getApplication().getApplicationContext().getString(R.string.ei8), 60L);
        }
        long j3 = troopInfoFromCache.dwGagTimeStamp_me;
        if (j3 != 0 && serverTime < j3 + 3) {
            QLog.d(TAG, 1, "fightgag.getSelfGagInfo:sUin= " + str + ",dwGagTimeStamp_me = " + troopInfoFromCache.dwGagTimeStamp_me + ",lCutTimeStamp  = " + serverTime);
            Context applicationContext = this.mApp.getApplication().getApplicationContext();
            String string = applicationContext.getString(R.string.f171419ev2);
            long j16 = troopInfoFromCache.dwGagTimeStamp_me;
            long j17 = 3 + j16;
            if (z16) {
                j17 = j16 - 30;
            }
            return new d(str, true, String.format(string, gagTimeToStringCountDown(applicationContext, j17)), 60L);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, String.format("getTroopGagInfo:sUin=%s, not Gag", str));
        }
        return new d(str, false, "", 0L);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.mApp = appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }
}
