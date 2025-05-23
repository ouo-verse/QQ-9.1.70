package com.tencent.mobileqq.troop.troopapps.api.impl;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import com.tencent.mobileqq.troop.troopapps.data.TroopAppInfo;
import com.tencent.mobileqq.utils.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xa1e.oidb_0xa1e$AppClick;
import tencent.im.oidb.cmd0xa1e.oidb_0xa1e$ReqBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAppServiceImpl implements ITroopAppService {
    static IPatchRedirector $redirector_ = null;
    protected static final int FLAG_APP_LIST_CHANGED_FROM_WEB_OPERATE = 2;
    protected static final int FLAG_CHECKED_UPDATE_AFTER_LOGINED = 1;
    private static final String TAG = ".troop.troop_app";
    protected static final String TROOP_APP_LIST_DATA = "troop_app_list_data";
    private AppRuntime app;
    protected boolean isProfileAppListChangedFromWebOperate;
    final Object lock;
    String mAllAppString;
    protected Map<String, JSONObject> mAppConfig;
    String mAppIdDate;

    @NonNull
    SparseArray<Integer> mAppIdNums;
    protected SparseArray<com.tencent.mobileqq.troop.troopapps.data.a> mAppListItems;
    ThreadLocal<SimpleDateFormat> mDateFormat;
    TroopAppHandler mTroopAppHandler;
    protected ConcurrentHashMap<String, ArrayList<Long>> mTroopCardAppIdListCache;
    protected String profileAppListChangedTroopUin;
    protected ConcurrentHashMap<Long, TroopAppInfo> troopAppInfoCache;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends ThreadLocal<SimpleDateFormat> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAppServiceImpl.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (SimpleDateFormat) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.getDefault());
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b extends c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAppServiceImpl.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopapps.api.impl.TroopAppServiceImpl.c
        protected void b(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            if (z16) {
                synchronized (TroopAppServiceImpl.this.mAppIdNums) {
                    TroopAppServiceImpl.this.mAppIdNums.clear();
                    TroopAppServiceImpl.this.saveAppIdNums();
                }
                TroopAppServiceImpl.this.updateAppIdCalendarDay();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static abstract class c extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        public c() {
            super(false);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        protected abstract void b(boolean z16);

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            QLog.i(".troop.troop_app", 2, "clickReport errorCode = " + i3);
            if (i3 != 0) {
                z16 = false;
            }
            b(z16);
        }
    }

    public TroopAppServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.lock = new Object();
        this.isProfileAppListChangedFromWebOperate = false;
        this.mAppIdNums = new SparseArray<>(10);
        this.mAppConfig = new ConcurrentHashMap();
        this.mAppListItems = new SparseArray<>();
        this.mDateFormat = new a();
    }

    private void initAppIdNums() {
        String decodeString = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeString(ITroopAppService.KEY_APPID_CLICK_NUM, "");
        this.mAppIdNums.clear();
        if (TextUtils.isEmpty(decodeString)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(decodeString);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                this.mAppIdNums.put(optJSONObject.optInt("appId"), Integer.valueOf(optJSONObject.optInt(WidgetCacheConstellationData.NUM)));
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void initTroopAppInfoList() {
        if (AppSetting.b("6.0") < 0) {
            return;
        }
        EntityManager createEntityManager = this.app.getEntityManagerFactory().createEntityManager();
        synchronized (this.lock) {
            List<? extends Entity> query = createEntityManager.query(TroopAIOAppInfo.class);
            if (query == null) {
                query = new ArrayList<>();
            }
            ListIterator<? extends Entity> listIterator = query.listIterator();
            while (listIterator.hasNext()) {
                TroopAIOAppInfo troopAIOAppInfo = (TroopAIOAppInfo) listIterator.next();
                com.tencent.mobileqq.troop.troopapps.data.a aVar = this.mAppListItems.get(troopAIOAppInfo.groupType);
                j.b(aVar);
                aVar.f(troopAIOAppInfo.appid, troopAIOAppInfo);
            }
        }
        createEntityManager.close();
    }

    private boolean isAppInfoDayRequest(int i3) {
        boolean z16;
        com.tencent.mobileqq.troop.troopapps.data.a aVar = this.mAppListItems.get(i3, null);
        if (aVar != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        j.a(z16);
        if (aVar == null) {
            return false;
        }
        if (!this.mDateFormat.get().format(Calendar.getInstance().getTime()).equals(aVar.f299427b)) {
            return true;
        }
        return false;
    }

    private void loadAllAppConfigs() {
        for (ITroopAppService.a aVar : ITroopAppService.a.f299360b) {
            String string = this.app.getPreferences().getString("KEY_APP_CONFIG_PREFIX-" + aVar.f299361a, null);
            if (!TextUtils.isEmpty(string)) {
                this.mAppConfig.put(aVar.f299361a, aVar.a(string));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logTroopAIOAppInfoList(String str, String str2, List<TroopAIOAppInfo> list) {
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, str2 + " end");
            if (list != null) {
                Iterator<TroopAIOAppInfo> it = list.iterator();
                while (it.hasNext()) {
                    QLog.d(str, 2, it.next().toString());
                }
            } else {
                QLog.d(str, 2, "arg is null");
            }
            QLog.d(str, 2, str2 + " end");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveAppIdNums() {
        String str;
        JSONArray jSONArray = new JSONArray();
        for (int i3 = 0; i3 < this.mAppIdNums.size(); i3++) {
            int keyAt = this.mAppIdNums.keyAt(i3);
            int intValue = this.mAppIdNums.get(keyAt).intValue();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", keyAt);
                jSONObject.put(WidgetCacheConstellationData.NUM, intValue);
                jSONArray.mo162put(jSONObject);
            } catch (JSONException unused) {
                if (QLog.isColorLevel()) {
                    QLog.e(".troop.troop_app", 2, "saveAppIdNums exception");
                }
            }
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        if (jSONArray.length() != 0) {
            str = jSONArray.toString();
        } else {
            str = "";
        }
        from.encodeString(ITroopAppService.KEY_APPID_CLICK_NUM, str).commitAsync();
    }

    private void saveTroopAppInfosToDB(ArrayList<TroopAIOAppInfo> arrayList, int i3) {
        ThreadManagerV2.post(new Runnable(arrayList, this.app.getEntityManagerFactory().createEntityManager(), i3) { // from class: com.tencent.mobileqq.troop.troopapps.api.impl.TroopAppServiceImpl.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ArrayList f299372d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ EntityManager f299373e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f299374f;

            {
                this.f299372d = arrayList;
                this.f299373e = r7;
                this.f299374f = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, TroopAppServiceImpl.this, arrayList, r7, Integer.valueOf(i3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (this.f299372d != null) {
                    String tableNameSafe = TableBuilder.getTableNameSafe(TroopAIOAppInfo.class);
                    if (QLog.isColorLevel()) {
                        List<? extends Entity> query = this.f299373e.query(TroopAIOAppInfo.class);
                        TroopAppServiceImpl.this.logTroopAIOAppInfoList(".troop.troop_appVASH", "before delete type:" + this.f299374f, query);
                    }
                    this.f299373e.delete(tableNameSafe, "groupType=?", new String[]{String.valueOf(this.f299374f)});
                    if (QLog.isColorLevel()) {
                        List<? extends Entity> query2 = this.f299373e.query(TroopAIOAppInfo.class);
                        TroopAppServiceImpl.this.logTroopAIOAppInfoList(".troop.troop_appVASH", "before update after delete type:" + this.f299374f, query2);
                    }
                    Iterator it = this.f299372d.iterator();
                    while (it.hasNext()) {
                        TroopAIOAppInfo troopAIOAppInfo = (TroopAIOAppInfo) it.next();
                        troopAIOAppInfo.setStatus(1000);
                        TroopAppServiceImpl.this.updateEntity(this.f299373e, troopAIOAppInfo);
                    }
                    if (QLog.isColorLevel()) {
                        List<? extends Entity> query3 = this.f299373e.query(TroopAIOAppInfo.class);
                        TroopAppServiceImpl.this.logTroopAIOAppInfoList(".troop.troop_appVASH", "after update type:" + this.f299374f, query3);
                    }
                }
                this.f299373e.close();
            }
        }, 8, null, false);
    }

    private void setAppConfig(String str, JSONObject jSONObject) {
        j.b(str);
        j.b(jSONObject);
        if (str == null) {
            str = "";
        }
        if (jSONObject == null) {
            return;
        }
        this.mAppConfig.put(str, jSONObject);
        this.app.getPreferences().edit().putString("KEY_APP_CONFIG_PREFIX-" + str, jSONObject.toString()).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAppIdCalendarDay() {
        this.mAppIdDate = this.mDateFormat.get().format(Calendar.getInstance().getTime());
        this.app.getPreferences().edit().putString(ITroopAppService.KEY_APPID_CLICK_DATE, this.mAppIdDate).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateEntity(EntityManager entityManager, Entity entity) {
        if (entityManager.isOpen()) {
            if (entity.getStatus() == 1000) {
                entityManager.persistOrReplace(entity);
                if (entity.getStatus() != 1001) {
                    return false;
                }
                return true;
            }
            if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
                return entityManager.update(entity);
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public void addReportClick(int i3, boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Boolean.valueOf(z16), str);
        } else {
            if (i3 <= 0) {
                return;
            }
            synchronized (this.mAppIdNums) {
                this.mAppIdNums.put(i3, Integer.valueOf(this.mAppIdNums.get(i3, 0).intValue() + 1));
                saveAppIdNums();
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public void addTroopApp(ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) arrayList, (Object) arrayList2);
            return;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList.containsAll(arrayList2)) {
                this.mTroopAppHandler.R2(getAppListTimestamp(0), arrayList, arrayList2);
            } else if (QLog.isColorLevel()) {
                QLog.d(".troop.troop_app.addTroopApp.troop.troop_app", 2, "appids to add are not contained in Appids list!");
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public void addTroopAppInfo(Long l3, TroopAppInfo troopAppInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) l3, (Object) troopAppInfo);
        } else {
            this.troopAppInfoCache.put(l3, troopAppInfo);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public void addTroopAppInfos(ArrayList<TroopAIOAppInfo> arrayList, int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) arrayList, i3);
            return;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            com.tencent.mobileqq.troop.troopapps.data.a aVar = this.mAppListItems.get(i3);
            if (aVar != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            j.a(z16);
            if (aVar == null) {
                return;
            }
            synchronized (this.lock) {
                Iterator<TroopAIOAppInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    TroopAIOAppInfo next = it.next();
                    aVar.f(next.appid, next);
                }
            }
            ThreadManagerV2.post(new Runnable(this.app.getEntityManagerFactory().createEntityManager(), i3, arrayList) { // from class: com.tencent.mobileqq.troop.troopapps.api.impl.TroopAppServiceImpl.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ EntityManager f299369d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f299370e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ ArrayList f299371f;

                {
                    this.f299369d = r6;
                    this.f299370e = i3;
                    this.f299371f = arrayList;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TroopAppServiceImpl.this, r6, Integer.valueOf(i3), arrayList);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        List<? extends Entity> query = this.f299369d.query(TroopAIOAppInfo.class);
                        TroopAppServiceImpl.this.logTroopAIOAppInfoList(".troop.troop_appVASH", "before updateEntity(" + this.f299370e + ")", query);
                    }
                    Iterator it5 = this.f299371f.iterator();
                    while (it5.hasNext()) {
                        TroopAppServiceImpl.this.updateEntity(this.f299369d, (TroopAIOAppInfo) it5.next());
                    }
                    if (QLog.isColorLevel()) {
                        List<? extends Entity> query2 = this.f299369d.query(TroopAIOAppInfo.class);
                        TroopAppServiceImpl.this.logTroopAIOAppInfoList(".troop.troop_appVASH", "after updateEntity(" + this.f299370e + ")", query2);
                    }
                    this.f299369d.close();
                }
            }, 8, null, false);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public void clearLocalTroopAppRedPoint(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
            return;
        }
        EntityManager createEntityManager = this.app.getEntityManagerFactory().createEntityManager();
        ArrayList arrayList = new ArrayList();
        int[] iArr = {0, 32};
        if (createEntityManager != null) {
            synchronized (this.lock) {
                z16 = false;
                for (int i16 = 0; i16 < 2; i16++) {
                    com.tencent.mobileqq.troop.troopapps.data.a aVar = this.mAppListItems.get(iArr[i16]);
                    j.b(aVar);
                    TroopAIOAppInfo troopAIOAppInfo = aVar.f299429d.get(Integer.valueOf(i3));
                    if (troopAIOAppInfo != null) {
                        arrayList.add(troopAIOAppInfo);
                        troopAIOAppInfo.redPoint = false;
                        z16 = true;
                    }
                }
            }
        } else {
            z16 = false;
        }
        if (z16) {
            ThreadManagerV2.post(new Runnable(arrayList, createEntityManager) { // from class: com.tencent.mobileqq.troop.troopapps.api.impl.TroopAppServiceImpl.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ArrayList f299377d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ EntityManager f299378e;

                {
                    this.f299377d = arrayList;
                    this.f299378e = createEntityManager;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TroopAppServiceImpl.this, arrayList, createEntityManager);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Iterator it = this.f299377d.iterator();
                    while (it.hasNext()) {
                        TroopAppServiceImpl.this.updateEntity(this.f299378e, (TroopAIOAppInfo) it.next());
                    }
                    this.f299378e.close();
                }
            }, 8, null, false);
        }
        if (QLog.isColorLevel()) {
            QLog.d(".troop.troop_app", 2, "appid" + i3 + "clearLocalTroopAppRedPoint," + z16);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public void clearTroopAppRedPoint(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            if (getAppInfo(i3, i16) == null) {
                return;
            }
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(Integer.valueOf(i3));
            this.mTroopAppHandler.F2(arrayList, 0);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public void clearTroopAppRedPoints() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        com.tencent.mobileqq.troop.troopapps.data.a aVar = this.mAppListItems.get(0, null);
        j.b(aVar);
        if (aVar == null) {
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<TroopAIOAppInfo> b16 = aVar.b();
        synchronized (this.lock) {
            Iterator<TroopAIOAppInfo> it = b16.iterator();
            while (it.hasNext()) {
                TroopAIOAppInfo next = it.next();
                if (next.redPoint) {
                    arrayList.add(Integer.valueOf(next.appid));
                }
            }
        }
        this.mTroopAppHandler.F2(arrayList, 0);
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public void clickReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        if (this.mAppIdNums.size() == 0) {
            QLog.d(".troop.troop_app", 2, "clickReport appidNums size == 0");
            return;
        }
        if (this.mDateFormat.get().format(Calendar.getInstance().getTime()).equals(this.mAppIdDate)) {
            return;
        }
        oidb_0xa1e$ReqBody oidb_0xa1e_reqbody = new oidb_0xa1e$ReqBody();
        oidb_0xa1e_reqbody.platform.set(2);
        oidb_0xa1e_reqbody.position.set(1);
        ArrayList arrayList = new ArrayList();
        synchronized (this.mAppIdNums) {
            for (int i3 = 0; i3 < this.mAppIdNums.size(); i3++) {
                int keyAt = this.mAppIdNums.keyAt(i3);
                int intValue = this.mAppIdNums.get(keyAt).intValue();
                oidb_0xa1e$AppClick oidb_0xa1e_appclick = new oidb_0xa1e$AppClick();
                oidb_0xa1e_appclick.appid.set(keyAt);
                oidb_0xa1e_appclick.click_num.set(intValue);
                arrayList.add(oidb_0xa1e_appclick);
            }
        }
        oidb_0xa1e_reqbody.rpt_app_click.set(arrayList);
        ProtoUtils.a(this.app, new b(), oidb_0xa1e_reqbody.toByteArray(), "OidbSvc.0xa1e", 2590, 0);
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public boolean ensureAppInfoExist(TroopAIOAppInfo troopAIOAppInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) troopAIOAppInfo)).booleanValue();
        }
        int i3 = troopAIOAppInfo.appid;
        com.tencent.mobileqq.troop.troopapps.data.a aVar = this.mAppListItems.get(troopAIOAppInfo.groupType);
        if (aVar != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        j.a(z16);
        if (aVar == null) {
            return false;
        }
        if (aVar.f299429d.get(Integer.valueOf(i3)) != null) {
            return true;
        }
        aVar.f(troopAIOAppInfo.appid, troopAIOAppInfo);
        return false;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public JSONObject getAppConfig(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (JSONObject) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        j.b(str);
        if (str == null) {
            return null;
        }
        return this.mAppConfig.get(str);
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public TroopAIOAppInfo getAppInfo(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (TroopAIOAppInfo) iPatchRedirector.redirect((short) 26, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        TroopAIOAppInfo troopAIOAppInfo = null;
        com.tencent.mobileqq.troop.troopapps.data.a aVar = this.mAppListItems.get(i16, null);
        if (aVar == null) {
            z16 = false;
        }
        j.a(z16);
        if (aVar == null) {
            return null;
        }
        synchronized (this.lock) {
            TroopAIOAppInfo troopAIOAppInfo2 = aVar.f299429d.get(Integer.valueOf(i3));
            if (troopAIOAppInfo2 != null) {
                troopAIOAppInfo = new TroopAIOAppInfo(troopAIOAppInfo2);
            }
        }
        return troopAIOAppInfo;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public synchronized boolean getAppListChangedFromWebOperate(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, i3)).booleanValue();
        }
        com.tencent.mobileqq.troop.troopapps.data.a aVar = this.mAppListItems.get(i3, null);
        boolean z17 = true;
        if (aVar != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        j.a(z16);
        if (aVar == null) {
            return false;
        }
        if ((aVar.f299426a & 2) == 0) {
            z17 = false;
        }
        return z17;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public int getAppListTimestamp(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this, i3)).intValue();
        }
        com.tencent.mobileqq.troop.troopapps.data.a aVar = this.mAppListItems.get(i3);
        if (aVar != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        j.a(z16);
        if (aVar == null) {
            return 0;
        }
        return aVar.f299428c;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public List<TroopAIOAppInfo> getCopyAppInfos(List<TroopAIOAppInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (List) iPatchRedirector.redirect((short) 30, (Object) this, (Object) list);
        }
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        synchronized (this.lock) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                arrayList.add(list.get(i3));
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public boolean getProfileAppListChangedFromWebOperate(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str)).booleanValue();
        }
        synchronized (this) {
            if (!TextUtils.isEmpty(this.profileAppListChangedTroopUin) && this.profileAppListChangedTroopUin.equals(str)) {
                return this.isProfileAppListChangedFromWebOperate;
            }
            return false;
        }
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public List<TroopAIOAppInfo> getTroopAppList(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (List) iPatchRedirector.redirect((short) 21, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
        j.a(i3 == 0 || i3 == 32);
        if (AppSetting.b("6.0") < 0) {
            return Collections.emptyList();
        }
        if (z16) {
            this.mTroopAppHandler.G2(1, i3, null, getAppListChangedFromWebOperate(i3));
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.lock) {
            com.tencent.mobileqq.troop.troopapps.data.a aVar = this.mAppListItems.get(i3);
            j.b(aVar);
            for (TroopAIOAppInfo troopAIOAppInfo : aVar.b()) {
                if (troopAIOAppInfo.isValidTroopApp()) {
                    arrayList.add(troopAIOAppInfo);
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public byte[] getTroopAppListData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (byte[]) iPatchRedirector.redirect((short) 36, (Object) this, (Object) str);
        }
        String string = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "_" + str, 0).getString(TROOP_APP_LIST_DATA, null);
        if (string == null) {
            return null;
        }
        try {
            return PluginBaseInfoHelper.Base64Helper.decode(string, 0);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public ArrayList<Long> getTroopCardAppIdListCache(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (ArrayList) iPatchRedirector.redirect((short) 34, (Object) this, (Object) str);
        }
        return this.mTroopCardAppIdListCache.get(str);
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public ArrayList<TroopAppInfo> getTroopCardAppInfosCache(ArrayList<Long> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (ArrayList) iPatchRedirector.redirect((short) 35, (Object) this, (Object) arrayList);
        }
        ArrayList<TroopAppInfo> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            Iterator<Long> it = arrayList.iterator();
            while (it.hasNext()) {
                TroopAppInfo troopAppInfo = this.troopAppInfoCache.get(it.next());
                if (troopAppInfo != null) {
                    arrayList2.add(troopAppInfo);
                }
            }
        }
        return arrayList2;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public synchronized boolean isCheckedUpdateAfterLogined(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, i3)).booleanValue();
        }
        com.tencent.mobileqq.troop.troopapps.data.a aVar = this.mAppListItems.get(i3, null);
        boolean z17 = true;
        if (aVar != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        j.a(z16);
        if (aVar == null) {
            return false;
        }
        if ((aVar.f299426a & 1) == 0) {
            z17 = false;
        }
        return z17;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public boolean makeAppidsInOrder(List<Integer> list, int i3) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, (Object) list, i3)).booleanValue();
        }
        com.tencent.mobileqq.troop.troopapps.data.a aVar = this.mAppListItems.get(i3, null);
        boolean z18 = true;
        if (list != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        j.a(z16);
        if (aVar != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        j.a(z17);
        if (aVar == null || list == null) {
            return false;
        }
        new ArrayList();
        if (list.size() == aVar.f299429d.size()) {
            z18 = false;
        }
        synchronized (this.lock) {
            if (!z18) {
                try {
                    z18 = aVar.c(list);
                    if (z18 && QLog.isColorLevel()) {
                        QLog.d(".troop.troop_app", 2, "makeAppidsInOrder() app order changed!");
                    }
                } catch (Throwable th5) {
                    throw th5;
                }
            }
            if (z18) {
                aVar.e(list, i3);
                saveTroopAppInfosToDB(aVar.b(), i3);
            }
        }
        return z18;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public boolean needRequestDetail(TroopAIOAppInfo troopAIOAppInfo) {
        boolean z16;
        TroopAIOAppInfo troopAIOAppInfo2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) troopAIOAppInfo)).booleanValue();
        }
        int i3 = troopAIOAppInfo.appid;
        com.tencent.mobileqq.troop.troopapps.data.a aVar = this.mAppListItems.get(troopAIOAppInfo.groupType);
        if (aVar != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        j.a(z16);
        if (aVar == null || (troopAIOAppInfo2 = aVar.f299429d.get(Integer.valueOf(i3))) == null) {
            return true;
        }
        j.b(troopAIOAppInfo.hashVal);
        j.b(troopAIOAppInfo2.hashVal);
        if (TextUtils.equals(troopAIOAppInfo.hashVal, troopAIOAppInfo2.hashVal) && troopAIOAppInfo2.isValidTroopApp() && troopAIOAppInfo.identifyMask == troopAIOAppInfo2.identifyMask && troopAIOAppInfo.redPoint == troopAIOAppInfo2.redPoint) {
            return false;
        }
        return true;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        this.app = appRuntime;
        this.mTroopAppHandler = (TroopAppHandler) ((AppInterface) appRuntime).getBusinessHandler(TroopAppHandler.class.getName());
        loadAllAppConfigs();
        int[] iArr = {0, 32};
        for (int i3 = 0; i3 < 2; i3++) {
            int i16 = iArr[i3];
            com.tencent.mobileqq.troop.troopapps.data.a aVar = new com.tencent.mobileqq.troop.troopapps.data.a();
            aVar.f299427b = this.app.getPreferences().getString("appinfo_date_" + i16, "");
            aVar.f299428c = this.app.getPreferences().getInt("KEY_APP_LIST_TIME_STAMP_" + i16, 0);
            this.mAppListItems.put(i16, aVar);
        }
        initTroopAppInfoList();
        initAppIdNums();
        this.mAppIdDate = this.app.getPreferences().getString(ITroopAppService.KEY_APPID_CLICK_DATE, null);
        this.mAllAppString = this.app.getPreferences().getString(ITroopAppService.KEY_ALL_APP_STRING, HardCodeUtil.qqStr(R.string.uay));
        if (this.troopAppInfoCache == null) {
            synchronized (this) {
                if (this.troopAppInfoCache == null) {
                    this.troopAppInfoCache = new ConcurrentHashMap<>();
                }
            }
        }
        if (this.mTroopCardAppIdListCache == null) {
            synchronized (this) {
                if (this.mTroopCardAppIdListCache == null) {
                    this.mTroopCardAppIdListCache = new ConcurrentHashMap<>();
                }
            }
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        int[] iArr = {0, 32};
        synchronized (this.lock) {
            for (int i3 = 0; i3 < 2; i3++) {
                int i16 = iArr[i3];
                setCheckedUpdateAfterLogined(false, i16);
                com.tencent.mobileqq.troop.troopapps.data.a aVar = this.mAppListItems.get(i16);
                j.b(aVar);
                aVar.f299429d.clear();
                aVar.a();
                aVar.f299428c = 0;
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public void removeTroopAppByAppid(int i3, int i16) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        com.tencent.mobileqq.troop.troopapps.data.a aVar = this.mAppListItems.get(i16);
        if (aVar != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        j.a(z16);
        if (aVar == null) {
            return;
        }
        TroopAIOAppInfo remove = aVar.f299429d.remove(Integer.valueOf(i3));
        if (remove != null) {
            j.a(aVar.d(remove));
            if (QLog.isColorLevel()) {
                QLog.d(".troop.troop_app", 2, "removeTroopAppByAppid appid: ", Integer.valueOf(i3), "/", Integer.valueOf(i16), " removed");
            }
            ThreadManagerV2.post(new Runnable(this.app.getEntityManagerFactory().createEntityManager(), remove) { // from class: com.tencent.mobileqq.troop.troopapps.api.impl.TroopAppServiceImpl.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ EntityManager f299375d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ TroopAIOAppInfo f299376e;

                {
                    this.f299375d = r8;
                    this.f299376e = remove;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TroopAppServiceImpl.this, r8, remove);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        this.f299375d.remove(this.f299376e);
                        this.f299375d.close();
                    }
                }
            }, 8, null, false);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(".troop.troop_app", 2, "removeTroopAppByAppid appid: ", Integer.valueOf(i3), "/", Integer.valueOf(i16), " remove fail, not contains app");
        }
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public void saveAppListTimestamp(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        com.tencent.mobileqq.troop.troopapps.data.a aVar = this.mAppListItems.get(i16);
        if (aVar == null) {
            z16 = false;
        }
        j.a(z16);
        if (aVar == null) {
            return;
        }
        aVar.f299428c = i3;
        this.app.getPreferences().edit().putInt("KEY_APP_LIST_TIME_STAMP_" + i16, i3).commit();
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public synchronized void setAppListChangedFromWebOperate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        boolean z17 = false;
        com.tencent.mobileqq.troop.troopapps.data.a aVar = this.mAppListItems.get(0, null);
        if (aVar != null) {
            z17 = true;
        }
        j.a(z17);
        if (aVar == null) {
            return;
        }
        if (z16) {
            aVar.f299426a |= 2;
        } else {
            aVar.f299426a &= -3;
        }
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public synchronized void setCheckedUpdateAfterLogined(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        com.tencent.mobileqq.troop.troopapps.data.a aVar = this.mAppListItems.get(i3, null);
        if (aVar != null) {
            z17 = true;
        }
        j.a(z17);
        if (aVar == null) {
            return;
        }
        if (z16) {
            aVar.f299426a |= 1;
        } else {
            aVar.f299426a &= -2;
        }
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public void setProfileAppListChangedFromWebOperate(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), str);
            return;
        }
        synchronized (this) {
            this.isProfileAppListChangedFromWebOperate = z16;
            this.profileAppListChangedTroopUin = str;
        }
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public void setTroopAppListData(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) str, (Object) bArr);
            return;
        }
        if (bArr == null) {
            return;
        }
        this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin() + "_" + str, 0).edit().putString(TROOP_APP_LIST_DATA, PluginBaseInfoHelper.Base64Helper.encodeToString(bArr, 2)).commit();
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public void setTroopCardAppListCache(String str, ArrayList<Long> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) str, (Object) arrayList);
        } else {
            this.mTroopCardAppIdListCache.put(str, arrayList);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public void sortTroopAppList(ArrayList<Integer> arrayList) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) arrayList);
            return;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            com.tencent.mobileqq.troop.troopapps.data.a aVar = this.mAppListItems.get(0, null);
            if (aVar != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            j.a(z16);
            if (aVar == null) {
                return;
            }
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                if (!aVar.f299429d.containsKey(it.next())) {
                    QLog.w(".troop.troop_app", 1, "sortTroopAppList error, there is no appid in hashtable");
                    return;
                }
            }
            this.mTroopAppHandler.T2(getAppListTimestamp(0), arrayList);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public void tryParseAppConfig(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) jSONObject);
            return;
        }
        for (ITroopAppService.a aVar : ITroopAppService.a.f299360b) {
            JSONObject b16 = aVar.b(jSONObject.optJSONObject(aVar.f299361a));
            if (b16 != null) {
                setAppConfig(aVar.f299361a, b16);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public void update0xca02Info(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            return;
        }
        SharedPreferences.Editor edit = this.app.getPreferences().edit();
        this.mAllAppString = str;
        edit.putString(ITroopAppService.KEY_ALL_APP_STRING, str).commit();
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public void updateAppInfoCalendarDay(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
            return;
        }
        String format = this.mDateFormat.get().format(Calendar.getInstance().getTime());
        com.tencent.mobileqq.troop.troopapps.data.a aVar = this.mAppListItems.get(i3, null);
        if (aVar != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        j.a(z16);
        if (aVar != null) {
            aVar.f299427b = format;
        }
        this.app.getPreferences().edit().putString("appinfo_date_" + i3, format).commit();
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
    public List<TroopAIOAppInfo> getTroopAppList(boolean z16, TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (List) iPatchRedirector.redirect((short) 22, this, Boolean.valueOf(z16), troopInfo);
        }
        int i3 = (troopInfo == null || troopInfo.dwGroupClassExt != 32) ? 0 : 32;
        if (QLog.isColorLevel()) {
            QLog.d(".troop.troop_app", 2, "getTroopAppList with info: ", String.valueOf(troopInfo), " type: ", Integer.valueOf(i3), " requestServerIfNecessary: ", Boolean.valueOf(z16));
        }
        if (z16) {
            boolean z18 = !isCheckedUpdateAfterLogined(i3) || getAppListChangedFromWebOperate(i3) || isAppInfoDayRequest(i3);
            if (QLog.isColorLevel()) {
                QLog.d(".troop.troop_app", 2, "getTroopAppList shouldRequestServer: ", Boolean.valueOf(z18));
            }
            z17 = z18;
        }
        return getTroopAppList(z17, i3);
    }
}
