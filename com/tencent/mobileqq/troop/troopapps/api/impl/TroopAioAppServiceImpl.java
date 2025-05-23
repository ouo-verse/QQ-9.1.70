package com.tencent.mobileqq.troop.troopapps.api.impl;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.troopapps.FullListGroupAppsDbHelper;
import com.tencent.mobileqq.troop.troopapps.GrayGroupAppsDbHelper;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService;
import com.tencent.mobileqq.troop.troopapps.data.FullListGroupAppEntity;
import com.tencent.mobileqq.troop.troopapps.data.GrayGroupAppEntity;
import com.tencent.mobileqq.troop.troopapps.f;
import com.tencent.mobileqq.troop.troopapps.g;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAioAppServiceImpl implements ITroopAioAppService, StudyModeChangeListener {
    static IPatchRedirector $redirector_ = null;
    private static final String SP_KEY_FULL_APP_LIST_HASH = "SP_KEY_FULL_APP_LIST_HASH";
    private static final String TAG = "TroopAioAppServiceImpl";
    String fullAppListHash;
    List<TroopAIOAppInfo> fullAppsListInfos;
    private ConcurrentHashMap<Long, GrayGroupAppEntity> grayAppInfoMap;
    private final AtomicBoolean isCacheInit;
    private AppRuntime mApp;
    private FullListGroupAppsDbHelper mFullListGroupAppsDbHelper;
    private GrayGroupAppsDbHelper mGrayGroupAppsDbHelper;
    private TroopAppHandler mTroopAppHander;

    public TroopAioAppServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.fullAppListHash = "";
            this.isCacheInit = new AtomicBoolean(false);
        }
    }

    private void clearAll() {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "clearAll.");
        }
        this.grayAppInfoMap.clear();
        this.fullAppsListInfos.clear();
        this.fullAppListHash = "";
        saveFullAppListHashInSp();
        grayGroupAppsDbHelper().e();
        fullListGroupAppsDbHelper().c();
    }

    private List<TroopAIOAppInfo> getAppsInGrayList(GrayGroupAppEntity grayGroupAppEntity) {
        ArrayList arrayList = new ArrayList(20);
        List<TroopAIOAppInfo> list = grayGroupAppEntity.troopAIOAppInfos;
        HashSet hashSet = new HashSet(20);
        Iterator<TroopAIOAppInfo> it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(Integer.valueOf(it.next().appid));
        }
        for (TroopAIOAppInfo troopAIOAppInfo : this.fullAppsListInfos) {
            if (!troopAIOAppInfo.isGray) {
                arrayList.add(troopAIOAppInfo);
            } else if (hashSet.contains(Integer.valueOf(troopAIOAppInfo.appid))) {
                arrayList.add(troopAIOAppInfo);
            }
        }
        return arrayList;
    }

    private List<TroopAIOAppInfo> getAppsOnlyInFullList() {
        ArrayList arrayList = new ArrayList(20);
        for (TroopAIOAppInfo troopAIOAppInfo : this.fullAppsListInfos) {
            if (!troopAIOAppInfo.isGray) {
                arrayList.add(troopAIOAppInfo);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initAioAppsCache$0() {
        this.mGrayGroupAppsDbHelper.c();
        this.mFullListGroupAppsDbHelper.b();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "login fullList from db ");
        }
        readFullAppListHashFromSp();
    }

    private void readFullAppListHashFromSp() {
        String str = "_" + this.mApp.getCurrentUin();
        this.fullAppListHash = PreferenceManager.getDefaultSharedPreferences(this.mApp.getApp()).getString(SP_KEY_FULL_APP_LIST_HASH + str, "");
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService
    public void clearRedDotInCacheAndDb(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
            return;
        }
        ArrayList arrayList = new ArrayList(this.fullAppsListInfos);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            TroopAIOAppInfo troopAIOAppInfo = (TroopAIOAppInfo) it.next();
            if (i3 == troopAIOAppInfo.appid) {
                troopAIOAppInfo.redPoint = false;
            }
        }
        this.fullAppsListInfos = arrayList;
        FullListGroupAppEntity fullListGroupAppEntity = new FullListGroupAppEntity();
        fullListGroupAppEntity.troopAIOAppInfos = this.fullAppsListInfos;
        fullListGroupAppsDbHelper().e(fullListGroupAppEntity);
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService
    public FullListGroupAppsDbHelper fullListGroupAppsDbHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (FullListGroupAppsDbHelper) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mFullListGroupAppsDbHelper;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService
    public List<TroopAIOAppInfo> getAllAppsFromCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        List<TroopAIOAppInfo> appsOnlyInFullList = getAppsOnlyInFullList();
        Iterator<Map.Entry<Long, GrayGroupAppEntity>> it = this.grayAppInfoMap.entrySet().iterator();
        while (it.hasNext()) {
            appsOnlyInFullList.addAll(getAppsInGrayList(it.next().getValue()));
        }
        return appsOnlyInFullList;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService
    public List<TroopAIOAppInfo> getAppsFromCache(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (List) iPatchRedirector.redirect((short) 12, (Object) this, j3);
        }
        GrayGroupAppEntity grayGroupAppEntity = this.grayAppInfoMap.get(Long.valueOf(j3));
        if (grayGroupAppEntity == null) {
            return getAppsOnlyInFullList();
        }
        return getAppsInGrayList(grayGroupAppEntity);
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService
    public void getAppsInObserver(long j3) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, j3);
            return;
        }
        boolean b16 = f.b(this.mApp, j3);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getAppsInObserver: invoked.  needRequest: " + b16);
        }
        if (b16) {
            TroopInfo findTroopInfo = ((ITroopInfoService) this.mApp.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(String.valueOf(j3));
            if (findTroopInfo == null) {
                i3 = 0;
            } else {
                i3 = (int) findTroopInfo.dwGroupClassExt;
            }
            f.g(this.mApp, j3, i3);
            return;
        }
        if (!g.d(getAppsFromCache(j3))) {
            f.d(this.mApp, j3);
        } else {
            g.f(new Runnable(j3) { // from class: com.tencent.mobileqq.troop.troopapps.api.impl.TroopAioAppServiceImpl.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ long f299368d;

                {
                    this.f299368d = j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TroopAioAppServiceImpl.this, Long.valueOf(j3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    TroopAioAppServiceImpl.this.mGrayGroupAppsDbHelper.b();
                    if (!g.d(TroopAioAppServiceImpl.this.getAppsFromCache(this.f299368d))) {
                        f.d(TroopAioAppServiceImpl.this.mApp, this.f299368d);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService
    public String getFullAppListHash() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.fullAppListHash;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService
    public List<TroopAIOAppInfo> getFullAppsListInfos() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.fullAppsListInfos;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService
    public ConcurrentHashMap<Long, GrayGroupAppEntity> getGrayAppInfoMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.grayAppInfoMap;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService
    public String getGrayAppsHash(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this, j3);
        }
        List<TroopAIOAppInfo> appsFromCache = getAppsFromCache(j3);
        if (g.d(appsFromCache)) {
            return "";
        }
        for (TroopAIOAppInfo troopAIOAppInfo : appsFromCache) {
            if (!TextUtils.isEmpty(troopAIOAppInfo.hashVal)) {
                return troopAIOAppInfo.hashVal;
            }
        }
        return "";
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService
    public long getRequestIntervalSecond(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Long) iPatchRedirector.redirect((short) 19, (Object) this, j3)).longValue();
        }
        GrayGroupAppEntity grayGroupAppEntity = this.grayAppInfoMap.get(Long.valueOf(j3));
        long seconds = TimeUnit.DAYS.toSeconds(1L);
        if (grayGroupAppEntity == null) {
            return seconds;
        }
        int i3 = grayGroupAppEntity.requestIntervalSecond;
        if (i3 <= 0) {
            return seconds;
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService
    public GrayGroupAppsDbHelper grayGroupAppsDbHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (GrayGroupAppsDbHelper) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mGrayGroupAppsDbHelper;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService
    public void initAioAppsCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else if (this.isCacheInit.compareAndSet(false, true)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.troopapps.api.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    TroopAioAppServiceImpl.this.lambda$initAioAppsCache$0();
                }
            }, 32, null, true);
        }
    }

    @Override // com.tencent.mobileqq.studymode.StudyModeChangeListener
    public void onChange(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        } else {
            clearAll();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        QLog.i(TAG, 1, "onCreate." + hashCode());
        this.mApp = appRuntime;
        this.mGrayGroupAppsDbHelper = new GrayGroupAppsDbHelper(appRuntime);
        this.mFullListGroupAppsDbHelper = new FullListGroupAppsDbHelper(this.mApp);
        this.grayAppInfoMap = new ConcurrentHashMap<>(20);
        this.mTroopAppHander = (TroopAppHandler) ((AppInterface) this.mApp).getBusinessHandler(TroopAppHandler.class.getName());
        this.fullAppsListInfos = new ArrayList(20);
        e.f299400a.d(this);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.i(TAG, 1, "onDestroy." + hashCode());
        e.f299400a.c(this);
        this.grayAppInfoMap.clear();
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService
    public void requestClearRedDot(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>(1);
        arrayList.add(Integer.valueOf(i3));
        this.mTroopAppHander.F2(arrayList, 0);
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService
    public void saveFullAppListHashInSp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        String str = "_" + this.mApp.getCurrentUin();
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.mApp.getApp()).edit();
        edit.putString(SP_KEY_FULL_APP_LIST_HASH + str, this.fullAppListHash);
        edit.apply();
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService
    public void setFullAppListHash(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            this.fullAppListHash = str;
        }
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService
    public void setFullAppsListInfos(List<TroopAIOAppInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        } else {
            this.fullAppsListInfos = list;
        }
    }
}
