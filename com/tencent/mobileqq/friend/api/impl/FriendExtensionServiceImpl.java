package com.tencent.mobileqq.friend.api.impl;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.friend.api.IFriendExtensionService;
import com.tencent.mobileqq.friend.cache.b;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.DeleteTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FriendExtensionServiceImpl implements IFriendExtensionService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "FriendExtensionServiceImpl";
    private EntityManager mEntityManager;
    private b mExtensionCache;

    public FriendExtensionServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static FriendExtensionServiceImpl getService(AppRuntime appRuntime) {
        return (FriendExtensionServiceImpl) appRuntime.getRuntimeService(IFriendExtensionService.class, "all");
    }

    private static void report(String str, int i3, int i16, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", str);
        hashMap.put("friendUin", str2);
        hashMap.put("version", "2");
        hashMap.put("localRingId", String.valueOf(i3));
        hashMap.put("targetRingId", String.valueOf(i16));
        hashMap.put("stack", Log.getStackTraceString(new Throwable("\u6253\u5370\u5806\u6808")));
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            hashMap.put("curUin", peekAppRuntime.getCurrentUin());
            QQBeaconReport.report(peekAppRuntime.getCurrentUin(), "specialCare_data_check", hashMap);
        } else {
            QQBeaconReport.report("", "specialCare_data_check", hashMap);
        }
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendExtensionService
    public ExtensionInfo deleteExtensionInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ExtensionInfo) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        }
        boolean z16 = false;
        ExtensionInfo extensionInfo = null;
        try {
            extensionInfo = this.mExtensionCache.n(str);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new DeleteTransaction(new ExtensionInfo().getTableName(), "uin=?", new String[]{str}));
            z16 = this.mEntityManager.doMultiDBOperateByTransaction(arrayList);
        } catch (Exception e16) {
            QLog.d(TAG, 1, "deleteExtension", e16);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "deleteExtension| friendUin: " + str + ", isSuccess: " + z16);
        }
        return extensionInfo;
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendExtensionService
    public List<ExtensionInfo> getAllExtensionInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mExtensionCache.i();
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendExtensionService
    public ExtensionInfo getExtensionInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? getExtensionInfo(str, true) : (ExtensionInfo) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendExtensionService
    public List<ExtensionInfo> getFriendRingIdListFromDB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (List) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mEntityManager.query(ExtensionInfo.class, true, "friendRingId!=0 AND uin is not null", null, null, null, null, null);
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendExtensionService
    public void initCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.mExtensionCache.k();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        EntityManager createEntityManager = appRuntime.getEntityManagerFactory().createEntityManager();
        this.mEntityManager = createEntityManager;
        this.mExtensionCache = new b(appRuntime, createEntityManager);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.mEntityManager.close();
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102555", false);
        QLog.d(TAG, 1, "clearCacheSwitch = " + isSwitchOn);
        if (isSwitchOn && (bVar = this.mExtensionCache) != null) {
            bVar.h();
        }
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendExtensionService
    public boolean saveExtensionInfo(ExtensionInfo extensionInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) extensionInfo)).booleanValue();
        }
        if (extensionInfo == null) {
            QLog.d(TAG, 1, "updateExtensionInfo| info == null");
            return false;
        }
        this.mExtensionCache.p(extensionInfo);
        return saveToDB(extensionInfo);
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendExtensionService
    public boolean saveExtensionInfoList(List<ExtensionInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) list)).booleanValue();
        }
        if (list != null && list.size() != 0) {
            Iterator<ExtensionInfo> it = list.iterator();
            while (it.hasNext()) {
                this.mExtensionCache.p(it.next());
            }
            return this.mExtensionCache.a(list);
        }
        QLog.d(TAG, 1, "updateExtensionInfoList| infoList is empty!");
        return false;
    }

    public boolean saveToDB(ExtensionInfo extensionInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) extensionInfo)).booleanValue();
        }
        if (extensionInfo == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        if (this.mEntityManager.isOpen()) {
            if (extensionInfo.getStatus() == 1000) {
                arrayList.add(new PersistOrReplaceTransaction(extensionInfo));
                this.mEntityManager.doMultiDBOperateByTransaction(arrayList);
                if (extensionInfo.getStatus() != 1001) {
                    return false;
                }
                return true;
            }
            if (extensionInfo.getStatus() != 1001 && extensionInfo.getStatus() != 1002) {
                return false;
            }
            arrayList.add(new UpdateTransaction(extensionInfo));
            return this.mEntityManager.doMultiDBOperateByTransaction(arrayList);
        }
        QLog.d(TAG, 1, "saveToDB| em closed uin = " + extensionInfo.uin);
        return false;
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendExtensionService
    public ExtensionInfo getExtensionInfo(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ExtensionInfo) iPatchRedirector.redirect((short) 6, this, str, Boolean.valueOf(z16));
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ExtensionInfo j3 = this.mExtensionCache.j(str);
        return (j3 == null && z16 && !this.mExtensionCache.l()) ? this.mExtensionCache.c(str) : j3;
    }
}
