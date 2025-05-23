package com.tencent.mobileqq.troop.onlinemember.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService;
import com.tencent.mobileqq.troop.onlinemember.data.TroopAllOnlineData;
import com.tencent.mobileqq.troop.onlinemember.data.a;
import com.tencent.mobileqq.troop.onlinemember.data.b;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopOnlineMemberServiceImpl implements ITroopOnlineMemberService {
    static IPatchRedirector $redirector_ = null;
    private static final int DEFAULT_CACHE_TIME = 10;
    private static final String TAG = "TroopOnlineMemberServiceImpl";
    protected AppRuntime mApp;
    private Map<String, a> mDetailOnlineDataMap;
    protected long mLastReqLocationTime;
    private Map<String, TroopAllOnlineData> troopAllGameOnlineDataMap;

    public TroopOnlineMemberServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mDetailOnlineDataMap = new ConcurrentHashMap();
            this.troopAllGameOnlineDataMap = new ConcurrentHashMap();
        }
    }

    @Override // com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService
    public long getAIOTipsNextReqTime(String str) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str)).longValue();
        }
        a aVar = this.mDetailOnlineDataMap.get(str);
        if (aVar != null) {
            j3 = aVar.f298039c;
        } else {
            j3 = 0;
        }
        if (j3 <= 0) {
            return NetConnInfoCenter.getServerTime();
        }
        return j3;
    }

    @Override // com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService
    public List<String> getAllGameOnlineList(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (List) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        }
        TroopAllOnlineData troopAllOnlineData = this.troopAllGameOnlineDataMap.get(str);
        if (troopAllOnlineData == null) {
            return null;
        }
        return troopAllOnlineData.memberUinList;
    }

    @Override // com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService
    public long getAllGameOnlineNextReqTime(String str) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Long) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str)).longValue();
        }
        TroopAllOnlineData troopAllOnlineData = this.troopAllGameOnlineDataMap.get(str);
        if (troopAllOnlineData != null) {
            j3 = troopAllOnlineData.nextReqTime;
        } else {
            j3 = 0;
        }
        if (j3 <= 0) {
            return NetConnInfoCenter.getServerTime();
        }
        return j3;
    }

    @Override // com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService
    public long getAllNextReqTime(String str) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str)).longValue();
        }
        EntityManager createEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
        TroopAllOnlineData troopAllOnlineData = (TroopAllOnlineData) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) TroopAllOnlineData.class, str);
        createEntityManager.close();
        if (troopAllOnlineData != null) {
            j3 = troopAllOnlineData.nextReqTime;
        } else {
            j3 = 0;
        }
        if (j3 <= 0) {
            return NetConnInfoCenter.getServerTime();
        }
        return j3;
    }

    @Override // com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService
    public List<String> getAllOnlineList(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (List) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
        EntityManager createEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
        TroopAllOnlineData troopAllOnlineData = (TroopAllOnlineData) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) TroopAllOnlineData.class, str);
        createEntityManager.close();
        if (troopAllOnlineData == null) {
            return null;
        }
        return troopAllOnlineData.memberUinList;
    }

    @Override // com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService
    public List<b> getDetailMemberListFromCache(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        a aVar = this.mDetailOnlineDataMap.get(str);
        if (aVar == null) {
            return null;
        }
        return aVar.f298037a;
    }

    @Override // com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService
    public long getDetailNextReqTime(String str) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).longValue();
        }
        a aVar = this.mDetailOnlineDataMap.get(str);
        if (aVar != null) {
            j3 = aVar.f298040d;
        } else {
            j3 = 0;
        }
        if (j3 <= 0) {
            return NetConnInfoCenter.getServerTime();
        }
        return j3;
    }

    @Override // com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService
    public long getLastReqLocationTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Long) iPatchRedirector.redirect((short) 21, (Object) this)).longValue();
        }
        return this.mLastReqLocationTime;
    }

    @Override // com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService
    public int getOnlineCount(String str) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str)).intValue();
        }
        if (TextUtils.isEmpty(str) || (aVar = this.mDetailOnlineDataMap.get(str)) == null) {
            return 0;
        }
        return aVar.f298042f;
    }

    @Override // com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService
    public String getOnlineTip(String str) {
        boolean z16;
        String str2;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        TroopInfo findTroopInfo = ((ITroopInfoService) this.mApp.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str);
        if (findTroopInfo != null) {
            z16 = findTroopInfo.isKicked();
        } else {
            z16 = true;
        }
        if (z16) {
            return "";
        }
        a aVar = this.mDetailOnlineDataMap.get(str);
        if (aVar != null) {
            str2 = aVar.f298038b;
            i3 = aVar.f298042f;
        } else {
            str2 = null;
            i3 = 0;
        }
        if (str2 == null) {
            return "";
        }
        if (findTroopInfo != null && findTroopInfo.getMemberNumClient() > 0 && i3 > findTroopInfo.getMemberNumClient() && !TextUtils.isEmpty(str2)) {
            str2 = str2.replace(String.valueOf(i3), String.valueOf(findTroopInfo.getMemberNumClient()));
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("getOnlineTip onlineCount: %s, memberNum: %s", Integer.valueOf(i3), Integer.valueOf(findTroopInfo.getMemberNumClient())));
            }
        }
        return str2;
    }

    @Override // com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService
    public int getRequestListServiceType(String str) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str)).intValue();
        }
        a aVar = this.mDetailOnlineDataMap.get(str);
        if (aVar != null && (i3 = aVar.f298041e) > 0) {
            return i3;
        }
        return 1;
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
        } else {
            this.mDetailOnlineDataMap.clear();
        }
    }

    @Override // com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService
    public void removeDetailOnlineData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.mDetailOnlineDataMap.remove(str);
        } catch (Exception e16) {
            QLog.i(TAG, 1, "removeDetailOnlineData: e = " + e16.toString());
        }
    }

    @Override // com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService
    public void removeDetailOnlineList(String str) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            if (TextUtils.isEmpty(str) || (aVar = this.mDetailOnlineDataMap.get(str)) == null) {
                return;
            }
            aVar.f298037a = null;
            aVar.f298040d = NetConnInfoCenter.getServerTime();
        }
    }

    @Override // com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService
    public void setLastReqLocationTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, j3);
        } else {
            this.mLastReqLocationTime = j3;
        }
    }

    @Override // com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService
    public void updateAIOTipsCache(String str, int i3, String str2, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Integer.valueOf(i3), str2, Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (i3 <= 0) {
            i3 = 10;
        }
        a aVar = this.mDetailOnlineDataMap.get(str);
        if (aVar == null) {
            aVar = new a();
            this.mDetailOnlineDataMap.put(str, aVar);
        }
        if (i3 != 4 || !TextUtils.isEmpty(str2)) {
            aVar.f298038b = str2;
            aVar.f298042f = i17;
        }
        aVar.f298039c = NetConnInfoCenter.getServerTime() + i3;
        if (i16 != -1) {
            aVar.f298041e = i16;
        }
    }

    @Override // com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService
    public void updateAllGameOnlineList(String str, List<String> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, str, list, Integer.valueOf(i3));
            return;
        }
        if (i3 <= 0) {
            i3 = 10;
        }
        TroopAllOnlineData troopAllOnlineData = this.troopAllGameOnlineDataMap.get(str);
        if (troopAllOnlineData == null) {
            troopAllOnlineData = new TroopAllOnlineData();
            this.troopAllGameOnlineDataMap.put(str, troopAllOnlineData);
        }
        troopAllOnlineData.troopUin = str;
        troopAllOnlineData.memberUinList = list;
        troopAllOnlineData.nextReqTime = NetConnInfoCenter.getServerTime() + i3;
    }

    @Override // com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService
    public void updateAllOnlineList(String str, List<String> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, str, list, Integer.valueOf(i3));
            return;
        }
        if (i3 <= 0) {
            i3 = 10;
        }
        TroopAllOnlineData troopAllOnlineData = new TroopAllOnlineData();
        troopAllOnlineData.troopUin = str;
        troopAllOnlineData.memberUinList = list;
        troopAllOnlineData.nextReqTime = NetConnInfoCenter.getServerTime() + i3;
        EntityManager createEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
        createEntityManager.persistOrReplace(troopAllOnlineData);
        createEntityManager.close();
    }

    @Override // com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService
    public void updateDetailOnlineListCache(String str, List<b> list, int i3, String str2, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, list, Integer.valueOf(i3), str2, Integer.valueOf(i16));
            return;
        }
        if (i3 <= 0) {
            i3 = 10;
        }
        a aVar = this.mDetailOnlineDataMap.get(str);
        if (aVar == null) {
            aVar = new a();
            this.mDetailOnlineDataMap.put(str, aVar);
        }
        if (!TextUtils.isEmpty(str2)) {
            aVar.f298038b = str2;
            aVar.f298042f = i16;
        }
        if (list != null && list.size() > 0) {
            aVar.f298037a = list;
        }
        aVar.f298040d = NetConnInfoCenter.getServerTime() + i3;
    }
}
