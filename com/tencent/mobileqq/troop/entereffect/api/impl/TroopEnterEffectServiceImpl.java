package com.tencent.mobileqq.troop.entereffect.api.impl;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.IAnonymousChatApi;
import com.tencent.mobileqq.troop.api.ITroopEnterEffectApi;
import com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService;
import com.tencent.mobileqq.troop.entereffect.e;
import com.tencent.mobileqq.troop.entereffect.f;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.api.VasSkey;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import tencent.qun.group_effect.group_effect_commu$TGetMyEffectRsp0x2;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopEnterEffectServiceImpl implements ITroopEnterEffectService {
    static IPatchRedirector $redirector_ = null;
    private static final String KEY_HAD_MIGRATE = "key_troop_enter_effect_had_migrate";
    private static final String SP_NAME = "troop_enter_effect_";
    public int effectId;
    public int groupLevel;
    private AtomicBoolean hasConfigInited;
    private Object lock;
    protected AppRuntime mApp;
    protected e mEffectConfig;
    protected SparseArray<String> mEffectNameMap;
    protected HashMap<String, Object> mEntranceStatusMap;
    protected Handler mHandler;
    private HashMap<String, Long> mLastNotifyTimeMap;
    private long mNotifyInterval;
    protected ConcurrentHashMap<String, List<f>> mTroopEnterEffectDatas;
    public int setMode;
    public int svipLevel;
    public int svipType;
    private long todayStartTime;

    public TroopEnterEffectServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mEffectNameMap = new SparseArray<>();
        this.mTroopEnterEffectDatas = new ConcurrentHashMap<>();
        this.lock = new Object();
        this.mEntranceStatusMap = new HashMap<>();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.hasConfigInited = new AtomicBoolean(false);
        this.mLastNotifyTimeMap = new HashMap<>();
    }

    private e.b readEffectInfo() {
        byte[] fileToBytes = FileUtils.fileToBytes(BaseApplication.getContext().getFileStreamPath("troop_enter_effect_config_" + this.mApp.getCurrentAccountUin()));
        if (fileToBytes != null) {
            group_effect_commu$TGetMyEffectRsp0x2 group_effect_commu_tgetmyeffectrsp0x2 = new group_effect_commu$TGetMyEffectRsp0x2();
            try {
                group_effect_commu_tgetmyeffectrsp0x2.mergeFrom(fileToBytes);
                e.b bVar = new e.b();
                bVar.a(group_effect_commu_tgetmyeffectrsp0x2);
                return bVar;
            } catch (Exception e16) {
                QLog.e(ITroopEnterEffectService.TAG, 1, "readEffectInfo error: " + e16.getMessage());
                return null;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public void addTroopEnterEffectData(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) fVar);
            return;
        }
        if (fVar != null && !TextUtils.isEmpty(fVar.f295260c)) {
            synchronized (this.lock) {
                List<f> list = this.mTroopEnterEffectDatas.get(fVar.f295260c);
                if (list == null) {
                    list = Collections.synchronizedList(new LinkedList());
                    this.mTroopEnterEffectDatas.put(fVar.f295260c, list);
                }
                if (fVar.f295259b.equals(this.mApp.getCurrentAccountUin())) {
                    list.add(0, fVar);
                } else {
                    list.add(fVar);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public e.b getAllEffectInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (e.b) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.mEffectConfig.f295227b;
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public int getEffectId(String str) {
        e.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this, (Object) str)).intValue();
        }
        e.b bVar = this.mEffectConfig.f295227b;
        if (bVar == null || (cVar = bVar.f295235d.get(str)) == null) {
            return 0;
        }
        return cVar.f295237b;
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public e.c getEffectInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (e.c) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        }
        e.b bVar = this.mEffectConfig.f295227b;
        if (bVar != null) {
            return bVar.f295235d.get(str);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public f getFirstEffectData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (f) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.lock) {
            List<f> list = this.mTroopEnterEffectDatas.get(str);
            if (list == null || list.isEmpty()) {
                return null;
            }
            return list.get(0);
        }
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public int getGroupLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Integer) iPatchRedirector.redirect((short) 37, (Object) this)).intValue();
        }
        return this.groupLevel;
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public int getMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this)).intValue();
        }
        return this.setMode;
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public long getNotifyInterval() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Long) iPatchRedirector.redirect((short) 28, (Object) this)).longValue();
        }
        return this.mNotifyInterval;
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public SharedPreferences getSharedPreferences() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        String str = SP_NAME + this.mApp.getCurrentAccountUin();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_TROOP);
        if (!from.decodeBool(KEY_HAD_MIGRATE, false)) {
            QMMKV.migrateToSpAdapter(MobileQQ.sMobileQQ, str, 0, QMMKVFile.FILE_TROOP);
            from.encodeBool(KEY_HAD_MIGRATE, true);
        }
        return QMMKV.fromSpAdapter(MobileQQ.sMobileQQ, str, QMMKVFile.FILE_TROOP);
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public int getSvipLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, (Object) this)).intValue();
        }
        return this.svipLevel;
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public int getSvipType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Integer) iPatchRedirector.redirect((short) 36, (Object) this)).intValue();
        }
        return this.svipType;
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public synchronized e getTroopEnterEffectConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (e) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        if (!this.hasConfigInited.get()) {
            readEffectConfigData(true);
        }
        return this.mEffectConfig;
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public boolean hasSetEffect(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str)).booleanValue();
        }
        e.b bVar = this.mEffectConfig.f295227b;
        if (bVar == null) {
            return false;
        }
        e.c cVar = bVar.f295235d.get(str);
        if (this.mEffectConfig.f295227b.f295233b <= 0 && (cVar == null || cVar.f295237b <= 0)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public boolean hasShowGrayTipsToday() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        long j3 = getSharedPreferences().getLong(ITroopEnterEffectService.SP_KEY_SHOW_GRAY_TIPS_TIME, 0L);
        if (j3 == 0) {
            return false;
        }
        if (this.todayStartTime == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.todayStartTime = currentTimeMillis - (currentTimeMillis % 86400000);
        }
        if (j3 - (j3 % 86400000) != this.todayStartTime) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public boolean isAllTroopShowEnterance() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return getTroopEnterEffectConfig().f295226a;
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public boolean isEffectOn(String str) {
        ConcurrentHashMap<String, e.c> concurrentHashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str)).booleanValue();
        }
        if (!TextUtils.isEmpty(str)) {
            e.b bVar = this.mEffectConfig.f295227b;
            if (bVar != null && (concurrentHashMap = bVar.f295235d) != null) {
                e.c cVar = concurrentHashMap.get(str);
                if (cVar == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(ITroopEnterEffectService.TAG, 2, "isEffectOn troopUin = " + str + " globalEffectId = " + this.mEffectConfig.f295227b.f295233b);
                    }
                    if (this.mEffectConfig.f295227b.f295233b <= 0) {
                        return false;
                    }
                    return true;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(ITroopEnterEffectService.TAG, 2, "isEffectOn troopUin = " + str + " isOn = " + cVar.f295239d);
                }
                return cVar.f295239d;
            }
            if (QLog.isColorLevel()) {
                QLog.d(ITroopEnterEffectService.TAG, 2, "isEffectOn troopUin = " + str + " effectInfo is Empty");
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public void notifyEnterTroop(String str) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(ITroopEnterEffectService.TAG, 2, "notifyEnterTroop troopUin: " + str);
        }
        if (!this.hasConfigInited.get()) {
            ThreadManagerV2.post(new Runnable(str) { // from class: com.tencent.mobileqq.troop.entereffect.api.impl.TroopEnterEffectServiceImpl.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f295223d;

                {
                    this.f295223d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopEnterEffectServiceImpl.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    TroopEnterEffectServiceImpl troopEnterEffectServiceImpl = TroopEnterEffectServiceImpl.this;
                    troopEnterEffectServiceImpl.mEffectConfig = troopEnterEffectServiceImpl.getTroopEnterEffectConfig();
                    if (TroopEnterEffectServiceImpl.this.mEffectConfig.f295228c.get()) {
                        TroopEnterEffectServiceImpl.this.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.troop.entereffect.api.impl.TroopEnterEffectServiceImpl.2.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    TroopEnterEffectServiceImpl.this.notifyEnterTroop(anonymousClass2.f295223d);
                                }
                            }
                        });
                    }
                }
            }, 8, null, true);
            return;
        }
        if (!this.mEffectConfig.f295226a) {
            if (QLog.isColorLevel()) {
                QLog.d(ITroopEnterEffectService.TAG, 2, "notifyEnterTroop function not enable");
                return;
            }
            return;
        }
        if (!isEffectOn(str)) {
            return;
        }
        if (((IAnonymousChatApi) QRoute.api(IAnonymousChatApi.class)).getAioAnonymousStatus(str)) {
            if (QLog.isColorLevel()) {
                QLog.d(ITroopEnterEffectService.TAG, 2, "notifyEnterTroop is Anonymous");
                return;
            }
            return;
        }
        if (this.mLastNotifyTimeMap.containsKey(str)) {
            j3 = this.mLastNotifyTimeMap.get(str).longValue();
        } else {
            j3 = 0;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime > j3 + this.mNotifyInterval) {
            try {
                ((ITroopEnterEffectApi) QRoute.api(ITroopEnterEffectApi.class)).sendTroopEnterEffectCMD(this.mApp, 8192L, Long.parseLong(str));
                this.mLastNotifyTimeMap.put(str, Long.valueOf(elapsedRealtime));
                return;
            } catch (NumberFormatException unused) {
                if (QLog.isColorLevel()) {
                    QLog.d(ITroopEnterEffectService.TAG, 2, "notifyEnterTroop parseLong error");
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(ITroopEnterEffectService.TAG, 2, "notifyEnterTroop in time interval");
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        this.mApp = appRuntime;
        this.mEffectConfig = new e();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.entereffect.api.impl.TroopEnterEffectServiceImpl.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopEnterEffectServiceImpl.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    TroopEnterEffectServiceImpl.this.requestVIPInfo();
                }
            }
        }, 16, null, false);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mEntranceStatusMap.clear();
        }
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public void readEffectConfigData(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(ITroopEnterEffectService.TAG, 2, "readEffectConfigData start");
        }
        File fileFromLocal = VasUpdateUtil.getFileFromLocal(this.mApp, 1000L, VasUpdateConstants.SCID_ENTER_EFFECT_CONFIG, this.mApp.getApplication().getFilesDir() + File.separator + VasUpdateConstants.SCID_ENTER_EFFECT_CONFIG, z16, null);
        if (fileFromLocal != null) {
            String readFileToStringEx = FileUtils.readFileToStringEx(fileFromLocal, -1);
            if (!TextUtils.isEmpty(readFileToStringEx)) {
                this.mEffectConfig.a(readFileToStringEx);
            }
            if (QLog.isColorLevel()) {
                QLog.d(ITroopEnterEffectService.TAG, 2, "readEffectConfigData success");
            }
            this.mEffectConfig.f295228c.set(true);
        }
        updateEffectInfo(readEffectInfo());
        this.hasConfigInited.set(true);
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public void removeAllEffectDatas(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.lock) {
                List<f> list = this.mTroopEnterEffectDatas.get(str);
                if (list != null) {
                    list.clear();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public void removeEnterEffectData(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) fVar);
            return;
        }
        if (fVar != null && !TextUtils.isEmpty(fVar.f295260c)) {
            synchronized (this.lock) {
                List<f> list = this.mTroopEnterEffectDatas.get(fVar.f295260c);
                if (list != null) {
                    list.remove(fVar);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public void report(String str, String str2, String... strArr) {
        String str3;
        String str4;
        String str5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, str, str2, strArr);
            return;
        }
        String str6 = "";
        if (strArr.length <= 0) {
            str3 = "";
        } else {
            str3 = strArr[0];
        }
        if (strArr.length <= 1) {
            str4 = "";
        } else {
            str4 = strArr[1];
        }
        if (strArr.length <= 2) {
            str5 = "";
        } else {
            str5 = strArr[2];
        }
        if (strArr.length > 3) {
            str6 = strArr[3];
        }
        ReportController.o(null, "dc00899", "Grp_action", "", str, str2, 0, 0, str3, str4, str5, str6);
    }

    protected void requestVIPInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        if (NetConnInfoCenter.getServerTime() - this.mApp.getApplication().getApplicationContext().getSharedPreferences(this.mApp.getCurrentAccountUin(), 0).getLong(AppConstants.Preferences.VIP_INFO_REQ_TIME, 0L) <= r0.getInt(AppConstants.Preferences.VIP_INFO_UPDATE_FREQ, 10) * 60) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(ITroopEnterEffectService.TAG, 2, "updateVipInfo");
        }
        String currentAccountUin = this.mApp.getCurrentAccountUin();
        ((ITroopEnterEffectApi) QRoute.api(ITroopEnterEffectApi.class)).sendGetBaseVipInfoReq(this.mApp, VasSkey.getSkey((TicketManager) this.mApp.getManager(2), currentAccountUin), currentAccountUin);
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public void saveEffectConfigData(group_effect_commu$TGetMyEffectRsp0x2 group_effect_commu_tgetmyeffectrsp0x2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) group_effect_commu_tgetmyeffectrsp0x2);
            return;
        }
        Runnable runnable = new Runnable(group_effect_commu_tgetmyeffectrsp0x2) { // from class: com.tencent.mobileqq.troop.entereffect.api.impl.TroopEnterEffectServiceImpl.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ group_effect_commu$TGetMyEffectRsp0x2 f295225d;

            {
                this.f295225d = group_effect_commu_tgetmyeffectrsp0x2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopEnterEffectServiceImpl.this, (Object) group_effect_commu_tgetmyeffectrsp0x2);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                FileOutputStream fileOutputStream = null;
                try {
                    try {
                        fileOutputStream = BaseApplication.getContext().openFileOutput("troop_enter_effect_config_" + TroopEnterEffectServiceImpl.this.mApp.getCurrentAccountUin(), 0);
                        fileOutputStream.write(this.f295225d.toByteArray());
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        try {
                            fileOutputStream.close();
                        } catch (IOException e16) {
                            e = e16;
                            if (!QLog.isColorLevel()) {
                                return;
                            }
                            QLog.e(ITroopEnterEffectService.TAG, 2, QLog.getStackTraceString(e));
                        }
                    } catch (IOException e17) {
                        if (QLog.isColorLevel()) {
                            QLog.e(ITroopEnterEffectService.TAG, 2, QLog.getStackTraceString(e17));
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e18) {
                                e = e18;
                                if (!QLog.isColorLevel()) {
                                    return;
                                }
                                QLog.e(ITroopEnterEffectService.TAG, 2, QLog.getStackTraceString(e));
                            }
                        }
                    }
                } catch (Throwable th5) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e19) {
                            if (QLog.isColorLevel()) {
                                QLog.e(ITroopEnterEffectService.TAG, 2, QLog.getStackTraceString(e19));
                            }
                        }
                    }
                    throw th5;
                }
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            ThreadManagerV2.post(runnable, 5, null, true);
        } else {
            runnable.run();
        }
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public void setGroupLevel(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, i3);
        } else {
            this.groupLevel = i3;
        }
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public void setMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
        } else {
            this.setMode = i3;
        }
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public void setNotifyInterval(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, j3);
        } else {
            this.mNotifyInterval = j3;
        }
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public void setSvipLevel(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, i3);
        } else {
            this.svipLevel = i3;
        }
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public void setSvipType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, i3);
        } else {
            this.svipType = i3;
        }
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public void updateEffectInfo(long j3, int i3, String str, int i16, int i17) {
        e.b bVar;
        ConcurrentHashMap<String, e.c> concurrentHashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Long.valueOf(j3), Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.setMode = 8;
        this.svipLevel = i16;
        this.svipType = i17;
        this.effectId = i3;
        e eVar = this.mEffectConfig;
        if (eVar == null || (bVar = eVar.f295227b) == null || (concurrentHashMap = bVar.f295235d) == null) {
            return;
        }
        if (concurrentHashMap.get(String.valueOf(j3)) == null) {
            this.mEffectConfig.f295227b.f295235d.put(String.valueOf(j3), new e.c(j3, i3, str));
        } else {
            Iterator<Map.Entry<String, e.c>> it = this.mEffectConfig.f295227b.f295235d.entrySet().iterator();
            while (it.hasNext()) {
                e.c value = it.next().getValue();
                value.f295237b = i3;
                value.f295238c = str;
                value.f295236a = j3;
            }
        }
        saveEffectConfigData(this.mEffectConfig.f295227b.b());
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public void updateEffectStatus(ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) arrayList);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(ITroopEnterEffectService.TAG, 2, "updateEffectStatus size = " + arrayList.size());
        }
        e eVar = this.mEffectConfig;
        if (eVar != null && eVar.f295227b != null) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String[] split = it.next().split(",");
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    e.c cVar = this.mEffectConfig.f295227b.f295235d.get(str);
                    if (cVar == null) {
                        cVar = new e.c();
                    }
                    if (str2.equals("1")) {
                        cVar.f295239d = false;
                        this.mEffectConfig.f295227b.f295235d.put(str, cVar);
                        if (QLog.isColorLevel()) {
                            QLog.d(ITroopEnterEffectService.TAG, 2, "updateEffectStatus off group uin = " + str);
                        }
                    } else if (str2.equals("0")) {
                        e.b bVar = this.mEffectConfig.f295227b;
                        if (bVar.f295233b > 0) {
                            bVar.f295235d.remove(str);
                            if (QLog.isColorLevel()) {
                                QLog.d(ITroopEnterEffectService.TAG, 2, "updateEffectStatus on group uin = " + str + " has globaleffect remove infodata");
                            }
                        } else {
                            cVar.f295239d = true;
                            bVar.f295235d.put(str, cVar);
                            if (QLog.isColorLevel()) {
                                QLog.d(ITroopEnterEffectService.TAG, 2, "updateEffectStatus on group uin = " + str + " not has globaleffect update infoData");
                            }
                        }
                    }
                }
            }
            saveEffectConfigData(this.mEffectConfig.f295227b.b());
        }
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public void updateGlobalEffectInfo(int i3, String str, int i16, int i17) {
        e.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(ITroopEnterEffectService.TAG, 2, "updateGlobalEffectInfo: effectId = " + i3 + " effectName = " + str + " svipLevel = " + i16 + " svipType = " + i17);
        }
        this.setMode = 8;
        this.svipLevel = i16;
        this.svipType = i17;
        this.effectId = i3;
        e eVar = this.mEffectConfig;
        if (eVar != null && (bVar = eVar.f295227b) != null) {
            bVar.f295233b = i3;
            bVar.f295234c = str;
            saveEffectConfigData(bVar.b());
        }
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public void updateNoLongerShowTips(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        getSharedPreferences().edit().putBoolean(ITroopEnterEffectService.SP_KEY_NO_LONGER_TIPS_ID + str, true).commit();
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public int getEffectId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 34)) ? this.effectId : ((Integer) iPatchRedirector.redirect((short) 34, (Object) this)).intValue();
    }

    @Override // com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService
    public void updateEffectInfo(e.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            this.mEffectConfig.f295227b = bVar;
        } else {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) bVar);
        }
    }
}
