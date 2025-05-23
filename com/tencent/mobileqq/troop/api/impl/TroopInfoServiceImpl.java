package com.tencent.mobileqq.troop.api.impl;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopExtDBInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopSystemMsgUtilApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ITroopListTempApi;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopInfoServiceImpl implements ITroopInfoService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TroopInfoServiceImpl";
    protected AppRuntime app;

    public TroopInfoServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopInfoService
    public void asyncGetTroopInfo(String str, com.tencent.mobileqq.data.troop.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) aVar);
        } else {
            aVar.a(findTroopInfo(str));
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopInfoService
    public TroopInfo findTroopInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? findTroopInfo(str, false, true) : (TroopInfo) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopInfoService
    public TroopInfo findTroopInfoInUI(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
        return findTroopInfo(str, false, false);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopInfoService
    public long getInsertJoinTroopMsgTime(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Long) iPatchRedirector.redirect((short) 21, (Object) this, (Object) str)).longValue();
        }
        String str2 = "line_" + this.app.getCurrentAccountUin() + "_" + str;
        String str3 = str2 + "_migrate_key";
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        if (!from.decodeBool(str3, false)) {
            long j3 = this.app.getPreferences().getLong(str2, -1L);
            if (j3 != -1) {
                from.encodeLong(str2, j3);
            }
            from.encodeBool(str3, true);
        }
        return from.decodeLong(str2, -1L);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopInfoService
    public String getTroopCodeByTroopUin(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        TroopInfo findTroopInfo = findTroopInfo(str);
        if (findTroopInfo != null) {
            return findTroopInfo.troopcode;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopInfoService
    public void getTroopCodeByTroopUinAsync(String str, ITroopInfoService.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, (Object) aVar);
            return;
        }
        if (!TextUtils.isEmpty(str) && aVar != null) {
            String troopCodeByTroopUin = getTroopCodeByTroopUin(str);
            if (Looper.getMainLooper() == Looper.myLooper()) {
                aVar.onResult(troopCodeByTroopUin);
                return;
            } else {
                ThreadManager.getUIHandler().post(new Runnable(aVar, troopCodeByTroopUin) { // from class: com.tencent.mobileqq.troop.api.impl.TroopInfoServiceImpl.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ ITroopInfoService.a f294251d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f294252e;

                    {
                        this.f294251d = aVar;
                        this.f294252e = troopCodeByTroopUin;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, TroopInfoServiceImpl.this, aVar, troopCodeByTroopUin);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            this.f294251d.onResult(this.f294252e);
                        }
                    }
                });
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "getTroopCodeByTroopUinAsync, param is empty");
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopInfoService
    public TroopInfo getTroopInfo(String str) {
        TroopInfo findTroopInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            findTroopInfo = new TroopInfo(str);
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "getTroopInfo, troopUin isEmpty:" + str);
            }
        } else {
            findTroopInfo = findTroopInfo(str);
            if (findTroopInfo == null) {
                findTroopInfo = new TroopInfo(str);
                ITroopSystemMsgUtilApi iTroopSystemMsgUtilApi = (ITroopSystemMsgUtilApi) QRoute.api(ITroopSystemMsgUtilApi.class);
                findTroopInfo.troopname = iTroopSystemMsgUtilApi.getTroopNameFromSP(this.app.getApplicationContext(), str);
                findTroopInfo.dwGroupFlagExt = iTroopSystemMsgUtilApi.getTroopFlagExtFromSP(this.app.getApplicationContext(), str);
            }
            if (TextUtils.isEmpty(findTroopInfo.troopname)) {
                findTroopInfo.troopname = str;
            }
        }
        return findTroopInfo;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopInfoService
    public TroopInfo getTroopInfoFromCache(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        return findTroopInfo(str);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopInfoService
    public ArrayList<String> getTroopMemberForTroopHead(String str) {
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (ArrayList) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        }
        TroopInfo troopInfo = getTroopInfo(str);
        ArrayList<String> arrayList = new ArrayList<>();
        int i3 = 0;
        if (troopInfo != null && (str3 = troopInfo.extDBInfo.headerUinsNew) != null) {
            if (!TextUtils.isEmpty(str3) && !" ".equals(troopInfo.extDBInfo.headerUinsNew)) {
                String[] split = troopInfo.extDBInfo.headerUinsNew.split(";");
                int length = split.length;
                while (i3 < length) {
                    String str4 = split[i3];
                    if (!TextUtils.isEmpty(str4) && !" ".equals(str4)) {
                        arrayList.add(str4);
                    }
                    i3++;
                }
            } else {
                return arrayList;
            }
        } else {
            TroopExtDBInfo troopExtDBInfo = (TroopExtDBInfo) ((ITroopListTempApi) QRoute.api(ITroopListTempApi.class)).getTroopExtDBInfoSync(str);
            if (troopExtDBInfo != null && (str2 = troopExtDBInfo.headerUinsNew) != null && !TextUtils.isEmpty(str2) && !" ".equals(troopExtDBInfo.headerUinsNew)) {
                String[] split2 = troopExtDBInfo.headerUinsNew.split(";");
                int length2 = split2.length;
                while (i3 < length2) {
                    String str5 = split2[i3];
                    if (!TextUtils.isEmpty(str5) && !" ".equals(str5)) {
                        arrayList.add(str5);
                    }
                    i3++;
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopInfoService
    public String getTroopNameByID(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        }
        TroopInfo findTroopInfo = findTroopInfo(str);
        if (findTroopInfo != null && findTroopInfo.getTroopDisplayName() != null) {
            return findTroopInfo.getTroopDisplayName();
        }
        return str;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopInfoService
    public String getTroopUin(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        }
        return getTroopUinByTroopCode(str);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopInfoService
    public String getTroopUinByTroopCode(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ((ITroopListTempApi) QRoute.api(ITroopListTempApi.class)).getTroopUinByTroopCode(str);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopInfoService
    public boolean isHomeworkTroop(String str) {
        TroopInfo findTroopInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str) || (findTroopInfo = findTroopInfo(str)) == null || !findTroopInfo.isHomeworkTroop()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopInfoService
    public boolean isQidianPrivateTroop(String str) {
        TroopInfo findTroopInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str) || (findTroopInfo = findTroopInfo(str)) == null || !TroopInfo.isQidianPrivateTroop(findTroopInfo.dwGroupFlagExt3)) {
            return false;
        }
        return true;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.app = appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopInfoService
    public void setInsertJoinTroopMsgTime(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, str, Long.valueOf(j3));
            return;
        }
        String str2 = "line_" + this.app.getCurrentAccountUin() + "_" + str;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        from.encodeBool(str2 + "_migrate_key", true);
        from.encodeLong(str2, j3);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopInfoService
    public void tryToCancelTroopHideChat(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        TroopInfo troopInfo = getTroopInfo(str);
        if (troopInfo == null) {
            return;
        }
        boolean isCmdUinFlagEx2Open = TroopInfo.isCmdUinFlagEx2Open(troopInfo.cmdUinFlagEx2, 512);
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "tryToCancelTroopHideChat hindChatIsChecked:" + isCmdUinFlagEx2Open);
        }
        if (isCmdUinFlagEx2Open) {
            QLog.i(TAG, 1, "[tryToCancelTroopHideChat] hindChatIsChecked");
            troopInfo.setCmdUinFlagEx2(false, 512);
            ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).updateHiddenChat(this.app, troopInfo);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopInfoService
    public TroopInfo findTroopInfo(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? findTroopInfo(str, z16, true) : (TroopInfo) iPatchRedirector.redirect((short) 6, this, str, Boolean.valueOf(z16));
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopInfoService
    public TroopInfo findTroopInfo(String str, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 7, this, str, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Object troopInfoFromCache = ((ITroopListTempApi) QRoute.api(ITroopListTempApi.class)).getTroopInfoFromCache(str);
        if (troopInfoFromCache instanceof TroopInfo) {
            return (TroopInfo) troopInfoFromCache;
        }
        return null;
    }
}
