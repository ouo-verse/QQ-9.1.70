package com.tencent.mobileqq.ar;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ar.model.ArDownloadInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArResourceManager implements Manager, Handler.Callback {
    public j C;
    private EntityManager E;
    private boolean H;
    private String I;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<AppInterface> f197411d;

    /* renamed from: e, reason: collision with root package name */
    SharedPreferences f197412e;

    /* renamed from: h, reason: collision with root package name */
    protected volatile ArConfigInfo f197414h;

    /* renamed from: i, reason: collision with root package name */
    protected volatile ArEffectConfig f197415i;

    /* renamed from: m, reason: collision with root package name */
    public m f197416m;
    private Vector<WeakReference<s>> D = new Vector<>();
    private Handler F = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
    private Handler G = new Handler(Looper.getMainLooper(), this);

    /* renamed from: f, reason: collision with root package name */
    public String f197413f = i.e();

    public ArResourceManager(AppInterface appInterface) {
        this.f197411d = new WeakReference<>(appInterface);
        this.f197412e = appInterface.getApp().getSharedPreferences("pref_ar_config" + appInterface.getAccount(), 0);
        this.E = appInterface.getEntityManagerFactory().createEntityManager();
        this.I = appInterface.getAccount();
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ArResourceManager.1
            @Override // java.lang.Runnable
            public void run() {
                ArResourceManager.this.j();
                ArResourceManager.this.l();
                ArResourceManager.this.r();
            }
        }, 8, null, true);
        this.f197416m = new m(appInterface, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(s sVar) {
        if (sVar != null) {
            this.D.add(new WeakReference<>(sVar));
        }
    }

    public boolean b(String str) {
        int i3;
        int i16;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ArDownloadInfo m3 = m(str);
        if (m3 == null) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        j jVar = this.C;
        if (jVar == null) {
            i3 = 3;
        } else {
            i3 = jVar.f198371b;
        }
        if (jVar == null) {
            i16 = 1000;
        } else {
            i16 = jVar.f198372c;
        }
        if (currentTimeMillis - m3.dailyStartTime > 86400000) {
            if (m3.totalRetryCount >= i16) {
                return false;
            }
            return true;
        }
        if (m3.dailyRetryCount > i3 || m3.totalRetryCount > i16) {
            return false;
        }
        return true;
    }

    public synchronized void c() {
        if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArResourceManager", 2, "clearArConfigInfo");
        }
        this.f197414h = null;
        AppInterface appInterface = this.f197411d.get();
        if (appInterface != null) {
            ArConfigInfo.deleteConfigFile(appInterface.getCurrentAccountUin());
        }
    }

    public void d(ArConfigInfo arConfigInfo, boolean z16, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArResourceManager", 2, "downloadArResource isAuto: " + z16 + ", needCheckZip: " + z17 + ", config: " + arConfigInfo);
        }
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.arg1 = z16 ? 1 : 0;
        obtain.arg2 = z17 ? 1 : 0;
        obtain.obj = arConfigInfo;
        this.F.sendMessageDelayed(obtain, 0L);
    }

    public void e(boolean z16, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArResourceManager", 2, "downloadArResource isAuto: " + z16 + ", needCheckZip: " + z17);
        }
        ArConfigInfo j3 = j();
        if (j3 == null) {
            QLog.i("ArConfig_ArResourceManager", 1, "config  null");
        } else {
            d(j3, z16, z17);
        }
    }

    public void f(int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArResourceManager", 2, "downloadError errorCode: " + i3 + ", result: " + i16);
        }
        synchronized (this.D) {
            int i17 = 0;
            while (i17 < this.D.size()) {
                WeakReference<s> weakReference = this.D.get(i17);
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().e(i3);
                    i17++;
                }
                this.D.remove(i17);
                i17--;
                i17++;
            }
        }
    }

    public void g(long j3, long j16) {
        if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArResourceManager", 2, "downloadProgress downloadSize: " + j3 + ", totalSize: " + j16);
        }
        synchronized (this.D) {
            int i3 = 0;
            while (i3 < this.D.size()) {
                WeakReference<s> weakReference = this.D.get(i3);
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().i(j3, j16);
                    i3++;
                }
                this.D.remove(i3);
                i3--;
                i3++;
            }
        }
    }

    public synchronized void h(final ArConfigInfo arConfigInfo, final boolean z16, final boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArResourceManager", 2, "downloadResource isAuto: " + z16 + ", needCheckZip: " + z17 + ", config: " + arConfigInfo);
        }
        if (z16) {
            t(false, 1, 0L, null);
            t(false, 3, 0L, null);
        }
        if (!ARDeviceController.b().e()) {
            if (QLog.isColorLevel()) {
                QLog.i("ArConfig_ArResourceManager", 2, "downloadResource device is not support AR!");
            }
            return;
        }
        if (arConfigInfo != null && z16) {
            QLog.i("ArConfig_ArResourceManager", 1, "sendMessage REPORT_AR_RESOURCE ");
            t(false, 2, 10000L, null);
        }
        AppInterface appInterface = this.f197411d.get();
        if (appInterface == null) {
            return;
        }
        if (!NetworkUtil.isNetSupport(appInterface.getApp())) {
            if (QLog.isColorLevel()) {
                QLog.i("ArConfig_ArResourceManager", 2, "downloadResource isNetSupport = false!");
            }
            return;
        }
        if (z16) {
            if (!p()) {
                if (QLog.isColorLevel()) {
                    QLog.d("ArConfig_ArResourceManager", 2, "downloadArResource, isCanAutoPreDownload = false");
                }
                return;
            } else if (!q()) {
                if (QLog.isColorLevel()) {
                    QLog.d("ArConfig_ArResourceManager", 2, "downloadArResource, isNetworkCanPreDownload = false");
                }
                return;
            }
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ArResourceManager.2
            @Override // java.lang.Runnable
            public void run() {
                ArResourceManager.this.f197416m.e(arConfigInfo, z16, z17);
            }
        }, 5, null, true);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3;
        boolean z16;
        boolean z17;
        String str;
        boolean z18;
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        int i16 = message.what;
        boolean z19 = true;
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    if (i16 == 4) {
                        QLog.d("ArConfig_ArResourceManager", 2, "start DOWNLAOD_AR_RESOURCE ");
                        if (message.arg1 == 1) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (message.arg2 != 1) {
                            z19 = false;
                        }
                        h((ArConfigInfo) message.obj, z18, z19);
                    }
                } else if (serverTimeMillis - this.f197412e.getLong("ar_so_report_time", 0L) >= 86400000) {
                    int i17 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).getInt("ar_native_so_version", 0);
                    if (i17 > 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    HashMap<String, String> hashMap = new HashMap<>();
                    if (z17) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    hashMap.put("param_FailCode", str);
                    hashMap.put("ar_so_version", String.valueOf(i17));
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.I, "olympic_ar_native_so_report", z17, 0L, 0L, hashMap, null);
                    this.f197412e.edit().putLong("ar_so_report_time", serverTimeMillis).commit();
                }
            } else {
                try {
                    if (serverTimeMillis - this.f197412e.getLong("ar_res_report_time", 0L) >= 86400000 && this.f197414h != null) {
                        Iterator<ArCloudConfigInfo> it = this.f197414h.mArCloudConfigInfos.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                ArCloudConfigInfo next = it.next();
                                if (!FileUtils.fileExists(next.E.f198412h)) {
                                    z16 = true;
                                    z19 = false;
                                    break;
                                }
                                ArModelResource arModelResource = next.F;
                                if (arModelResource != null && !FileUtils.fileExists(arModelResource.D)) {
                                    z16 = false;
                                    break;
                                }
                            } else {
                                z16 = true;
                                break;
                            }
                        }
                        i.h(this.I, z19, z16);
                        this.f197412e.edit().putLong("ar_res_report_time", serverTimeMillis).commit();
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ArConfig_ArResourceManager", 2, "REPORT_AR_RESOURCE:" + e16.toString());
                    }
                }
            }
        } else {
            if (this.f197414h != null) {
                i3 = this.f197414h.version;
                z19 = false;
            } else {
                i3 = 0;
            }
            if (serverTimeMillis - this.f197412e.getLong("ar_config_report_time", 0L) >= 86400000) {
                i.f(this.I, z19, i3);
                this.f197412e.edit().putLong("ar_config_report_time", serverTimeMillis).commit();
            }
        }
        return false;
    }

    public void i() {
        if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArResourceManager", 2, "downloadSuccess");
        }
        synchronized (this.D) {
            int i3 = 0;
            while (i3 < this.D.size()) {
                WeakReference<s> weakReference = this.D.get(i3);
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().onDownloadSuccess();
                    i3++;
                }
                this.D.remove(i3);
                i3--;
                i3++;
            }
        }
    }

    public ArConfigInfo j() {
        AppInterface appInterface = this.f197411d.get();
        if (this.f197414h == null && appInterface != null) {
            synchronized (this) {
                if (QLog.isColorLevel()) {
                    QLog.d("ArConfig_ArResourceManager", 2, "getArConfigInfo | load config from file.");
                }
                this.f197414h = ArConfigInfo.loadConfigFromFile(appInterface.getAccount());
            }
        }
        return this.f197414h;
    }

    public int k() {
        j jVar = this.C;
        if (jVar == null) {
            return 3;
        }
        return jVar.f198370a;
    }

    public ArEffectConfig l() {
        if (this.f197415i == null) {
            this.f197415i = ArEffectConfig.a();
        }
        return this.f197415i;
    }

    public synchronized ArDownloadInfo m(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArDownloadInfo arDownloadInfo = (ArDownloadInfo) DBMethodProxy.find(this.E, (Class<? extends Entity>) ArDownloadInfo.class, str);
        if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArResourceManager", 2, "getEntity, info=" + arDownloadInfo);
        }
        return arDownloadInfo;
    }

    public void n(ArConfigInfo arConfigInfo) {
        if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArResourceManager", 2, "handleNewConfig config: " + arConfigInfo);
        }
        if (arConfigInfo == null) {
            return;
        }
        try {
            Iterator<ArCloudConfigInfo> it = arConfigInfo.mArCloudConfigInfos.iterator();
            while (it.hasNext()) {
                ArCloudConfigInfo next = it.next();
                ArFeatureInfo arFeatureInfo = next.E;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(this.f197413f);
                sb5.append("ar_feature/");
                sb5.append(next.f197702i);
                String str = File.separator;
                sb5.append(str);
                sb5.append(next.E.f198409d);
                sb5.append("_signature.db");
                arFeatureInfo.f198412h = sb5.toString();
                next.E.f198413i = this.f197413f + "ar_model/" + next.f197702i + str;
                ArModelResource arModelResource = next.F;
                if (arModelResource != null) {
                    if (next.f197702i == 100) {
                        arModelResource.D = this.f197413f + "ar_cloud_marker_model/" + next.f197702i + str + next.F.f198421e + "_model.zip";
                    } else {
                        arModelResource.D = this.f197413f + "ar_model/" + next.f197702i + str + next.F.f198421e + "_model.zip";
                    }
                }
                ArrayList<ArVideoResourceInfo> arrayList = next.D;
                if (arrayList != null && arrayList.size() > 0) {
                    Iterator<ArVideoResourceInfo> it5 = next.D.iterator();
                    while (it5.hasNext()) {
                        ArVideoResourceInfo next2 = it5.next();
                        if (next2.D == 4) {
                            next2.F = y81.a.a(next2.E);
                        } else {
                            next2.F = next.E.f198413i + next2.f198430i + "_model.zip";
                        }
                    }
                }
            }
            if (u(arConfigInfo)) {
                synchronized (this.D) {
                    int i3 = 0;
                    while (i3 < this.D.size()) {
                        WeakReference<s> weakReference = this.D.get(i3);
                        if (weakReference != null && weakReference.get() != null) {
                            weakReference.get().l(arConfigInfo);
                            i3++;
                        }
                        this.D.remove(i3);
                        i3--;
                        i3++;
                    }
                }
                d(arConfigInfo, true, true);
                return;
            }
            c();
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_ArResourceManager", 2, "saveArConfigToFile error!");
            }
        } catch (Exception e16) {
            QLog.i("ArConfig_ArResourceManager", 1, "handleNewConfig config: " + e16.getMessage());
        }
    }

    public synchronized void o(ArDownloadInfo arDownloadInfo) {
        if (arDownloadInfo == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PersistOrReplaceTransaction(arDownloadInfo));
        this.E.doMultiDBOperateByTransaction(arrayList);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        this.H = true;
    }

    public boolean p() {
        int i3;
        j jVar = this.C;
        if (jVar == null) {
            i3 = 1;
        } else {
            i3 = jVar.f198374e;
        }
        if (i3 == 1) {
            return true;
        }
        return false;
    }

    public boolean q() {
        int i3;
        j jVar = this.C;
        if (jVar == null) {
            i3 = 3;
        } else {
            i3 = jVar.f198370a;
        }
        boolean z16 = true;
        if (i3 == 1) {
            return true;
        }
        int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
        if (i3 != 0 ? !(i3 != 3 ? systemNetwork == 1 || systemNetwork == 4 || systemNetwork == 3 : systemNetwork == 1) : !(systemNetwork == 1 || systemNetwork == 4)) {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArResourceManager", 2, "isNetworkCanPreDownload,dpcNet=" + i3 + ", type=" + systemNetwork);
        }
        return z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void r() {
        boolean z16;
        if (this.C == null) {
            this.C = new j();
            String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.olympic_act_config.name());
            boolean z17 = false;
            try {
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ArConfig_ArResourceManager", 2, "loadDPCConfig Exception:" + e16.toString());
                }
            }
            if (featureValue.length() > 0) {
                String[] split = featureValue.split("\\|");
                if (split.length >= 9) {
                    this.C.f198370a = Integer.valueOf(split[4]).intValue();
                    this.C.f198371b = Integer.valueOf(split[5]).intValue();
                    this.C.f198372c = Integer.valueOf(split[6]).intValue();
                    this.C.f198373d = Integer.valueOf(split[7]).intValue();
                    this.C.f198374e = Integer.valueOf(split[8]).intValue();
                    z16 = false;
                    if (z16) {
                        j jVar = this.C;
                        jVar.f198370a = 3;
                        jVar.f198371b = 3;
                        jVar.f198372c = 1000;
                        jVar.f198373d = 1;
                        jVar.f198374e = 1;
                    }
                    if (this.C.f198373d == 1) {
                        z17 = true;
                    }
                    com.tencent.mobileqq.olympic.utils.a.i(z17);
                    if (!QLog.isColorLevel()) {
                        QLog.d("ArConfig_ArResourceManager", 2, "loadDPCConfig|dpc:" + this.C.toString());
                        return;
                    }
                    return;
                }
            }
            z16 = true;
            if (z16) {
            }
            if (this.C.f198373d == 1) {
            }
            com.tencent.mobileqq.olympic.utils.a.i(z17);
            if (!QLog.isColorLevel()) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(s sVar) {
        synchronized (this.D) {
            int i3 = 0;
            while (i3 < this.D.size()) {
                WeakReference<s> weakReference = this.D.get(i3);
                if (weakReference != null && weakReference.get() != null) {
                    if (weakReference.get() == sVar) {
                        this.D.remove(i3);
                        return;
                    }
                    i3++;
                }
                this.D.remove(i3);
                i3--;
                i3++;
            }
        }
    }

    protected void t(boolean z16, int i3, long j3, Object obj) {
        Handler handler;
        if (!this.H) {
            synchronized (this) {
                if (!this.H) {
                    if (z16) {
                        handler = this.G;
                    } else {
                        handler = this.F;
                    }
                    handler.sendMessageDelayed(Message.obtain(handler, i3, 0, 0, obj), j3);
                }
            }
        }
    }

    public synchronized boolean u(ArConfigInfo arConfigInfo) {
        if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArResourceManager", 2, "updateArConfigInfo | config = " + arConfigInfo);
        }
        AppInterface appInterface = this.f197411d.get();
        if (appInterface != null && ArConfigInfo.saveArConfigToFile(arConfigInfo, appInterface.getCurrentAccountUin())) {
            this.f197414h = arConfigInfo;
            return true;
        }
        return false;
    }

    public synchronized void v(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArDownloadInfo m3 = m(str);
        if (m3 == null) {
            if (!z16) {
                ArDownloadInfo arDownloadInfo = new ArDownloadInfo();
                arDownloadInfo.md5 = str;
                arDownloadInfo.dailyRetryCount = 1;
                arDownloadInfo.totalRetryCount = 1;
                arDownloadInfo.dailyStartTime = currentTimeMillis;
                o(arDownloadInfo);
            }
            return;
        }
        if (z16) {
            m3.dailyRetryCount = 0;
            m3.dailyStartTime = currentTimeMillis;
        } else if (currentTimeMillis - m3.dailyStartTime >= 86400000) {
            m3.dailyRetryCount = 1;
            m3.dailyStartTime = currentTimeMillis;
            m3.totalRetryCount++;
        } else {
            m3.dailyRetryCount++;
            m3.totalRetryCount++;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UpdateTransaction(m3));
        this.E.doMultiDBOperateByTransaction(arrayList);
    }
}
