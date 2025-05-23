package com.tencent.mobileqq.ar;

import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ar.FaceScanDownloadManager;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ar.aidl.a;
import com.tencent.mobileqq.ar.arengine.ae;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.qrscan.api.IQRScanMainProcService;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.AppService;
import mqq.app.Constants;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArConfigService extends AppService {

    /* renamed from: d, reason: collision with root package name */
    WeakReference<QQAppInterface> f197351d;

    /* renamed from: e, reason: collision with root package name */
    ARGlobalConfigManager f197352e = null;

    /* renamed from: f, reason: collision with root package name */
    Object f197353f = new Object();

    /* renamed from: h, reason: collision with root package name */
    private RemoteCallbackList<com.tencent.mobileqq.ar.aidl.c> f197354h = new RemoteCallbackList<>();

    /* renamed from: i, reason: collision with root package name */
    private RemoteCallbackList<com.tencent.mobileqq.ar.aidl.b> f197355i = new RemoteCallbackList<>();

    /* renamed from: m, reason: collision with root package name */
    private s f197356m = new a();
    private final a.AbstractBinderC7399a C = new ArConfigManagerStub(this);
    private Handler D = new Handler();
    private RemoteCallbackList<com.tencent.mobileqq.ar.aidl.d> E = new RemoteCallbackList<>();
    private boolean F = false;
    private boolean G = false;
    private int H = 0;
    private boolean I = false;
    private int J = 0;
    private boolean K = false;
    private int L = 0;
    private boolean M = true;
    private int N = 100;
    private boolean P = true;
    private int Q = 100;
    private com.tencent.mobileqq.earlydownload.b R = new com.tencent.mobileqq.earlydownload.b() { // from class: com.tencent.mobileqq.ar.ArConfigService.3
        @Override // com.tencent.mobileqq.earlydownload.b
        public void a(XmlData xmlData, long j3, long j16) {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_ArConfigService", 2, String.format("onDownloadProgress data=%s curOffset=%s totalLen=%s", xmlData, Long.valueOf(j3), Long.valueOf(j16)));
            }
            if ("qq.android.ar.native.so64_v8.0.0".equals(xmlData.strResName)) {
                ArConfigService.this.H = (int) ((j3 * 100) / j16);
            }
            final int i3 = ((((ArConfigService.this.H + ArConfigService.this.J) + ArConfigService.this.L) + ArConfigService.this.N) + ArConfigService.this.Q) / 5;
            if (!ArConfigService.this.F) {
                ArConfigService.this.D.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ArConfigService.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ArConfigService.this.C0(i3);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.earlydownload.b
        public void b(XmlData xmlData) {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_ArConfigService", 2, "EarlyDownLoadListener");
            }
        }

        @Override // com.tencent.mobileqq.earlydownload.b
        public void c(XmlData xmlData, boolean z16, int i3, boolean z17, String str) {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_ArConfigService", 2, String.format("onDownloadFinish data=%s result=%s", xmlData, Boolean.valueOf(z16)));
            }
            if (z16) {
                if ("qq.android.ar.native.so64_v8.0.0".equals(xmlData.strResName)) {
                    ArConfigService.this.G = true;
                }
                if (ArConfigService.this.G && ArConfigService.this.I && ArConfigService.this.K && ArConfigService.this.M && ArConfigService.this.P) {
                    ArConfigService.this.D.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ArConfigService.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ArConfigService.this.D0();
                        }
                    });
                    return;
                }
                return;
            }
            if (!ArConfigService.this.F) {
                ArConfigService.this.D.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ArConfigService.3.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ArConfigService.this.B0();
                    }
                });
                ArConfigService.this.F = true;
            }
        }

        @Override // com.tencent.mobileqq.earlydownload.b
        public void d(XmlData xmlData) {
        }
    };
    private ae.d S = new ae.d() { // from class: com.tencent.mobileqq.ar.ArConfigService.4
        @Override // com.tencent.mobileqq.ar.arengine.ae.d
        public void a(long j3, long j16) {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_ArConfigService", 2, String.format("onARResourceDownloadUpdateProgress curOffset=%s totalLen=%s", Long.valueOf(j3), Long.valueOf(j16)));
            }
            ArConfigService.this.L = (int) ((j3 * 100) / j16);
            final int i3 = ((((ArConfigService.this.H + ArConfigService.this.J) + ArConfigService.this.L) + ArConfigService.this.N) + ArConfigService.this.Q) / 5;
            if (!ArConfigService.this.F) {
                ArConfigService.this.D.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ArConfigService.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ArConfigService.this.C0(i3);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.ar.arengine.ae.d
        public void b() {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_ArConfigService", 2, "mARSDK2ResourceDownloadCallback");
            }
        }

        @Override // com.tencent.mobileqq.ar.arengine.ae.d
        public void c(boolean z16, ae.e eVar) {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_ArConfigService", 2, String.format("onARResourceDownloadComplete mARSDK2ResourceDownloadCallback result=%s", Boolean.valueOf(z16)));
            }
            if (z16) {
                ArConfigService.this.K = true;
                if (ArConfigService.this.G && ArConfigService.this.I && ArConfigService.this.K && ArConfigService.this.M && ArConfigService.this.P) {
                    ArConfigService.this.D.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ArConfigService.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ArConfigService.this.D0();
                        }
                    });
                    return;
                }
                return;
            }
            if (!ArConfigService.this.F) {
                ArConfigService.this.D.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ArConfigService.4.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ArConfigService.this.B0();
                    }
                });
                ArConfigService.this.F = true;
            }
        }

        @Override // com.tencent.mobileqq.ar.arengine.ae.d
        public void d() {
        }
    };
    private ae.d T = new ae.d() { // from class: com.tencent.mobileqq.ar.ArConfigService.5
        @Override // com.tencent.mobileqq.ar.arengine.ae.d
        public void a(long j3, long j16) {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_ArConfigService", 2, String.format("onARResourceDownloadUpdateProgress curOffset=%s totalLen=%s", Long.valueOf(j3), Long.valueOf(j16)));
            }
            ArConfigService.this.J = (int) ((j3 * 100) / j16);
            final int i3 = ((((ArConfigService.this.H + ArConfigService.this.J) + ArConfigService.this.L) + ArConfigService.this.N) + ArConfigService.this.Q) / 5;
            if (!ArConfigService.this.F) {
                ArConfigService.this.D.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ArConfigService.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ArConfigService.this.C0(i3);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.ar.arengine.ae.d
        public void b() {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_ArConfigService", 2, "mARCloudResourceDownloadCallback");
            }
        }

        @Override // com.tencent.mobileqq.ar.arengine.ae.d
        public void c(boolean z16, ae.e eVar) {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_ArConfigService", 2, String.format("onARResourceDownloadComplete mARCloudResourceDownloadCallback result=%s", Boolean.valueOf(z16)));
            }
            if (z16) {
                ArConfigService.this.I = true;
                if (ArConfigService.this.G && ArConfigService.this.I && ArConfigService.this.K && ArConfigService.this.M && ArConfigService.this.P) {
                    ArConfigService.this.D.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ArConfigService.5.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ArConfigService.this.D0();
                        }
                    });
                    return;
                }
                return;
            }
            if (!ArConfigService.this.F) {
                ArConfigService.this.D.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ArConfigService.5.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ArConfigService.this.B0();
                    }
                });
                ArConfigService.this.F = true;
            }
        }

        @Override // com.tencent.mobileqq.ar.arengine.ae.d
        public void d() {
        }
    };
    private ae.d U = new ae.d() { // from class: com.tencent.mobileqq.ar.ArConfigService.6
        @Override // com.tencent.mobileqq.ar.arengine.ae.d
        public void a(long j3, long j16) {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_ArConfigService", 2, String.format("mARCOREResourceDownloadCallBack onARResourceDownloadUpdateProgress curOffset=%s totalLen=%s", Long.valueOf(j3), Long.valueOf(j16)));
            }
            ArConfigService.this.N = (int) ((j3 * 100) / j16);
            final int i3 = ((((ArConfigService.this.H + ArConfigService.this.J) + ArConfigService.this.L) + ArConfigService.this.N) + ArConfigService.this.Q) / 5;
            if (!ArConfigService.this.F) {
                ArConfigService.this.D.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ArConfigService.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ArConfigService.this.C0(i3);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.ar.arengine.ae.d
        public void b() {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_ArConfigService", 2, "mARCOREResourceDownloadCallBack");
            }
        }

        @Override // com.tencent.mobileqq.ar.arengine.ae.d
        public void c(boolean z16, ae.e eVar) {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_ArConfigService", 2, String.format("onARResourceDownloadComplete mARCOREResourceDownloadCallBack result=%s", Boolean.valueOf(z16)));
            }
            if (z16) {
                ArConfigService.this.M = true;
                if (ArConfigService.this.G && ArConfigService.this.I && ArConfigService.this.K && ArConfigService.this.M && ArConfigService.this.P) {
                    ArConfigService.this.D.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ArConfigService.6.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ArConfigService.this.D0();
                        }
                    });
                    return;
                }
                return;
            }
            if (!ArConfigService.this.F) {
                ArConfigService.this.D.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ArConfigService.6.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ArConfigService.this.B0();
                    }
                });
                ArConfigService.this.F = true;
            }
        }

        @Override // com.tencent.mobileqq.ar.arengine.ae.d
        public void d() {
        }
    };
    private ae.d V = new ae.d() { // from class: com.tencent.mobileqq.ar.ArConfigService.7
        @Override // com.tencent.mobileqq.ar.arengine.ae.d
        public void a(long j3, long j16) {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_ArConfigService", 2, String.format("mARFeatureDownloadCallBack onARResourceDownloadUpdateProgress curOffset=%s totalLen=%s", Long.valueOf(j3), Long.valueOf(j16)));
            }
            ArConfigService.this.Q = (int) ((j3 * 100) / j16);
            final int i3 = ((((ArConfigService.this.H + ArConfigService.this.J) + ArConfigService.this.L) + ArConfigService.this.N) + ArConfigService.this.Q) / 5;
            if (!ArConfigService.this.F) {
                ArConfigService.this.D.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ArConfigService.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ArConfigService.this.C0(i3);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.ar.arengine.ae.d
        public void b() {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_ArConfigService", 2, "mARFeatureDownloadCallBack");
            }
        }

        @Override // com.tencent.mobileqq.ar.arengine.ae.d
        public void c(boolean z16, ae.e eVar) {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_ArConfigService", 2, String.format("mARFeatureDownloadCallBack  result=%s", Boolean.valueOf(z16)));
            }
            if (z16) {
                ArConfigService.this.P = true;
                if (ArConfigService.this.G && ArConfigService.this.I && ArConfigService.this.K && ArConfigService.this.M && ArConfigService.this.P) {
                    ArConfigService.this.D.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ArConfigService.7.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ArConfigService.this.D0();
                        }
                    });
                    return;
                }
                return;
            }
            if (!ArConfigService.this.F) {
                ArConfigService.this.D.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ArConfigService.7.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ArConfigService.this.B0();
                    }
                });
                ArConfigService.this.F = true;
            }
        }

        @Override // com.tencent.mobileqq.ar.arengine.ae.d
        public void d() {
        }
    };

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.ArConfigService$8, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass8 implements Runnable {
        final /* synthetic */ ArConfigService this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.B0();
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    static class ArConfigManagerStub extends a.AbstractBinderC7399a {

        /* renamed from: d, reason: collision with root package name */
        WeakReference<ArConfigService> f197382d;

        public ArConfigManagerStub(ArConfigService arConfigService) {
            QLog.d("ArConfig_ArConfigService", 1, "ArConfigManagerStub constructor");
            this.f197382d = new WeakReference<>(arConfigService);
        }

        @Override // com.tencent.mobileqq.ar.aidl.a
        public void A2() {
            final ArConfigService arConfigService;
            WeakReference<ArConfigService> weakReference = this.f197382d;
            if (weakReference != null) {
                arConfigService = weakReference.get();
            } else {
                arConfigService = null;
            }
            if (arConfigService != null) {
                arConfigService.F = false;
                arConfigService.p0();
                arConfigService.m0();
                arConfigService.o0();
                arConfigService.l0();
                arConfigService.n0();
                if (!arConfigService.F) {
                    final int i3 = ((((arConfigService.H + arConfigService.J) + arConfigService.L) + arConfigService.N) + arConfigService.Q) / 5;
                    arConfigService.D.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ArConfigService.ArConfigManagerStub.1
                        @Override // java.lang.Runnable
                        public void run() {
                            arConfigService.C0(i3);
                            QLog.d("ArConfig_ArConfigService", 1, "downloadArSo first progress " + i3);
                        }
                    });
                    if (i3 == 100) {
                        arConfigService.D.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ArConfigService.ArConfigManagerStub.2
                            @Override // java.lang.Runnable
                            public void run() {
                                arConfigService.D0();
                            }
                        });
                        return;
                    }
                    return;
                }
                return;
            }
            QLog.d("ArConfig_ArConfigService", 1, "downloadArSo error arConfigService is null");
        }

        @Override // com.tencent.mobileqq.ar.aidl.a
        public ArConfigInfo D3() throws RemoteException {
            ArConfigService arConfigService;
            ArResourceManager arResourceManager;
            WeakReference<ArConfigService> weakReference = this.f197382d;
            ArConfigInfo arConfigInfo = null;
            if (weakReference != null) {
                arConfigService = weakReference.get();
            } else {
                arConfigService = null;
            }
            if (arConfigService == null) {
                QLog.d("ArConfig_ArConfigService", 1, "getArConfigInfo error arConfigService is null");
                return null;
            }
            QQAppInterface qQAppInterface = arConfigService.f197351d.get();
            if (qQAppInterface != null && (arResourceManager = (ArResourceManager) qQAppInterface.getManager(QQManagerFactory.AR_RESOURCE_MANAGER)) != null) {
                arConfigInfo = arResourceManager.j();
            }
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_ArConfigService", 2, "getArConfigInfo | mConfigInfo = " + arConfigInfo);
            }
            return arConfigInfo;
        }

        @Override // com.tencent.mobileqq.ar.aidl.a
        public void N2(com.tencent.mobileqq.ar.aidl.c cVar) throws RemoteException {
            ArConfigService arConfigService;
            QLog.d("ArConfig_ArConfigService", 1, "unregisterCallback");
            WeakReference<ArConfigService> weakReference = this.f197382d;
            if (weakReference != null) {
                arConfigService = weakReference.get();
            } else {
                arConfigService = null;
            }
            if (arConfigService == null) {
                QLog.d("ArConfig_ArConfigService", 1, "unregisterCallback error arConfigService is null");
            } else if (cVar != null && arConfigService.f197354h != null) {
                arConfigService.f197354h.unregister(cVar);
            }
        }

        @Override // com.tencent.mobileqq.ar.aidl.a
        public void N4(com.tencent.mobileqq.ar.aidl.d dVar) {
            ArConfigService arConfigService;
            WeakReference<ArConfigService> weakReference = this.f197382d;
            if (weakReference != null) {
                arConfigService = weakReference.get();
            } else {
                arConfigService = null;
            }
            if (arConfigService == null) {
                QLog.d("ArConfig_ArConfigService", 1, "unregisterArSoCallback error arConfigService is null");
            } else if (dVar != null) {
                arConfigService.E.unregister(dVar);
            }
        }

        @Override // com.tencent.mobileqq.ar.aidl.a
        public void S2(ArConfigInfo arConfigInfo) throws RemoteException {
            ArConfigService arConfigService;
            ArResourceManager arResourceManager;
            WeakReference<ArConfigService> weakReference = this.f197382d;
            if (weakReference != null) {
                arConfigService = weakReference.get();
            } else {
                arConfigService = null;
            }
            if (arConfigService == null) {
                QLog.d("ArConfig_ArConfigService", 1, "handleNewConfig error arConfigService is null");
                return;
            }
            QQAppInterface qQAppInterface = arConfigService.f197351d.get();
            if (qQAppInterface != null && (arResourceManager = (ArResourceManager) qQAppInterface.getManager(QQManagerFactory.AR_RESOURCE_MANAGER)) != null) {
                arResourceManager.n(arConfigInfo);
            }
        }

        @Override // com.tencent.mobileqq.ar.aidl.a
        public void V2(int i3) throws RemoteException {
            ArConfigService arConfigService;
            WeakReference<ArConfigService> weakReference = this.f197382d;
            if (weakReference != null) {
                arConfigService = weakReference.get();
            } else {
                arConfigService = null;
            }
            if (arConfigService == null) {
                QLog.d("ArConfig_ArConfigService", 1, "downloadFaceResource error arConfigService is null");
            } else if (((AppService) arConfigService).app instanceof QQAppInterface) {
                FaceScanDownloadManager.d(i3, (QQAppInterface) ((AppService) arConfigService).app);
            }
        }

        @Override // com.tencent.mobileqq.ar.aidl.a
        public void Y() {
            ArConfigService arConfigService;
            WeakReference<ArConfigService> weakReference = this.f197382d;
            if (weakReference != null) {
                arConfigService = weakReference.get();
            } else {
                arConfigService = null;
            }
            if (arConfigService != null) {
                arConfigService.l0();
            } else {
                QLog.d("ArConfig_ArConfigService", 1, "downloadArCoreSo error arConfigService is null");
            }
        }

        @Override // com.tencent.mobileqq.ar.aidl.a
        public boolean a3() {
            ArConfigService arConfigService;
            WeakReference<ArConfigService> weakReference = this.f197382d;
            if (weakReference != null) {
                arConfigService = weakReference.get();
            } else {
                arConfigService = null;
            }
            if (arConfigService == null) {
                QLog.d("ArConfig_ArConfigService", 1, "isArSoReady error arConfigService is null");
                return false;
            }
            if (!ArConfigService.d0() || !arConfigService.s0() || !arConfigService.x0() || !arConfigService.q0() || !arConfigService.u0()) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.ar.aidl.a
        public void b5() throws RemoteException {
            ArConfigService arConfigService;
            ArResourceManager arResourceManager;
            WeakReference<ArConfigService> weakReference = this.f197382d;
            if (weakReference != null) {
                arConfigService = weakReference.get();
            } else {
                arConfigService = null;
            }
            if (arConfigService == null) {
                QLog.d("ArConfig_ArConfigService", 1, "downloadResource error arConfigService is null");
                return;
            }
            QQAppInterface qQAppInterface = arConfigService.f197351d.get();
            if (qQAppInterface != null && (arResourceManager = (ArResourceManager) qQAppInterface.getManager(QQManagerFactory.AR_RESOURCE_MANAGER)) != null) {
                arResourceManager.e(false, false);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("click_download", "1");
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(qQAppInterface.getCurrentAccountUin(), "ar_client_download_times", true, 0L, 0L, hashMap, null);
            }
        }

        @Override // com.tencent.mobileqq.ar.aidl.a
        public void cancelDownload() throws RemoteException {
            ArConfigService arConfigService;
            ArResourceManager arResourceManager;
            WeakReference<ArConfigService> weakReference = this.f197382d;
            if (weakReference != null) {
                arConfigService = weakReference.get();
            } else {
                arConfigService = null;
            }
            if (arConfigService == null) {
                QLog.d("ArConfig_ArConfigService", 1, "cancelDownload error arConfigService is null");
                return;
            }
            QQAppInterface qQAppInterface = arConfigService.f197351d.get();
            if (qQAppInterface != null && (arResourceManager = (ArResourceManager) qQAppInterface.getManager(QQManagerFactory.AR_RESOURCE_MANAGER)) != null) {
                arResourceManager.f197416m.b();
            }
        }

        @Override // com.tencent.mobileqq.ar.aidl.a
        public void f4(com.tencent.mobileqq.ar.aidl.b bVar) throws RemoteException {
            ArConfigService arConfigService;
            WeakReference<ArConfigService> weakReference = this.f197382d;
            if (weakReference != null) {
                arConfigService = weakReference.get();
            } else {
                arConfigService = null;
            }
            if (arConfigService == null) {
                QLog.d("ArConfig_ArConfigService", 1, "unregisterFaceCallback error arConfigService is null");
            } else if (bVar != null && arConfigService.f197355i != null) {
                arConfigService.f197355i.unregister(bVar);
            }
        }

        @Override // com.tencent.mobileqq.ar.aidl.a
        public boolean l2() {
            ArConfigService arConfigService;
            WeakReference<ArConfigService> weakReference = this.f197382d;
            if (weakReference != null) {
                arConfigService = weakReference.get();
            } else {
                arConfigService = null;
            }
            if (arConfigService != null) {
                return arConfigService.q0();
            }
            QLog.d("ArConfig_ArConfigService", 1, "isArCoreSoReady error arConfigService is null");
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
        @Override // com.tencent.mobileqq.ar.aidl.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public ArEffectConfig m1() throws RemoteException {
            ArConfigService arConfigService;
            ArResourceManager arResourceManager;
            WeakReference<ArConfigService> weakReference;
            ArEffectConfig arEffectConfig = null;
            try {
                weakReference = this.f197382d;
            } catch (Exception unused) {
                QLog.d("ArConfig_ArConfigService", 1, "getArEffectConfig error weakArConfigService is null");
            }
            if (weakReference != null) {
                arConfigService = weakReference.get();
                if (arConfigService != null) {
                    QLog.d("ArConfig_ArConfigService", 1, "getArEffectConfig error arConfigService is null");
                    return null;
                }
                WeakReference<QQAppInterface> weakReference2 = arConfigService.f197351d;
                if (weakReference2 == null) {
                    QLog.d("ArConfig_ArConfigService", 1, "getArEffectConfig error arConfigService.weakApp is null");
                    return null;
                }
                QQAppInterface qQAppInterface = weakReference2.get();
                if (qQAppInterface != null && (arResourceManager = (ArResourceManager) qQAppInterface.getManager(QQManagerFactory.AR_RESOURCE_MANAGER)) != null) {
                    arEffectConfig = arResourceManager.l();
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ArConfig_ArConfigService", 2, "getArEffectConfig|mEffectConfig=" + arEffectConfig);
                }
                return arEffectConfig;
            }
            arConfigService = null;
            if (arConfigService != null) {
            }
        }

        @Override // com.tencent.mobileqq.ar.aidl.a
        public void n0(com.tencent.mobileqq.ar.aidl.d dVar) {
            ArConfigService arConfigService;
            WeakReference<ArConfigService> weakReference = this.f197382d;
            if (weakReference != null) {
                arConfigService = weakReference.get();
            } else {
                arConfigService = null;
            }
            if (arConfigService == null) {
                QLog.d("ArConfig_ArConfigService", 1, "registerArSoCallback error arConfigService is null");
            } else if (dVar != null) {
                arConfigService.E.register(dVar);
            }
        }

        @Override // com.tencent.mobileqq.ar.aidl.a
        public void onToolScannerActivityStateChanged(int i3) {
            ArConfigService arConfigService;
            WeakReference<ArConfigService> weakReference = this.f197382d;
            if (weakReference != null) {
                arConfigService = weakReference.get();
            } else {
                arConfigService = null;
            }
            if (arConfigService == null) {
                QLog.d("ArConfig_ArConfigService", 1, "onToolScannerActivityStateChanged error arConfigService is null");
                return;
            }
            IQRScanMainProcService iQRScanMainProcService = (IQRScanMainProcService) ((AppService) arConfigService).app.getRuntimeService(IQRScanMainProcService.class, "");
            if (iQRScanMainProcService != null) {
                iQRScanMainProcService.onToolScannerActivityStateChanged(i3);
            }
        }

        @Override // com.tencent.mobileqq.ar.aidl.a
        public boolean r1() throws RemoteException {
            ArConfigService arConfigService;
            WeakReference<ArConfigService> weakReference = this.f197382d;
            if (weakReference != null) {
                arConfigService = weakReference.get();
            } else {
                arConfigService = null;
            }
            boolean z16 = false;
            if (arConfigService == null) {
                QLog.d("ArConfig_ArConfigService", 1, "isFaceResConfigReady error arConfigService is null");
                return false;
            }
            if ((((AppService) arConfigService).app instanceof QQAppInterface) && !(z16 = FaceScanDownloadManager.h((QQAppInterface) ((AppService) arConfigService).app))) {
                FaceScanDownloadManager.m((QQAppInterface) ((AppService) arConfigService).app);
            }
            return z16;
        }

        @Override // com.tencent.mobileqq.ar.aidl.a
        public ARCommonConfigInfo t1() throws RemoteException {
            ArConfigService arConfigService;
            WeakReference<ArConfigService> weakReference = this.f197382d;
            ARCommonConfigInfo aRCommonConfigInfo = null;
            if (weakReference != null) {
                arConfigService = weakReference.get();
            } else {
                arConfigService = null;
            }
            if (arConfigService == null) {
                QLog.d("ArConfig_ArConfigService", 1, "getARCommonConfigInfo error arConfigService is null");
                return null;
            }
            ARGlobalConfigManager aRGlobalConfigManager = arConfigService.f197352e;
            if (aRGlobalConfigManager != null) {
                aRCommonConfigInfo = aRGlobalConfigManager.e();
            }
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_ArConfigService", 2, String.format("getARCommonConfigInfo arCommonConfigInfo=%s", aRCommonConfigInfo));
            }
            return aRCommonConfigInfo;
        }

        @Override // com.tencent.mobileqq.ar.aidl.a
        public void w2(com.tencent.mobileqq.ar.aidl.b bVar) throws RemoteException {
            ArConfigService arConfigService;
            WeakReference<ArConfigService> weakReference = this.f197382d;
            if (weakReference != null) {
                arConfigService = weakReference.get();
            } else {
                arConfigService = null;
            }
            if (arConfigService == null) {
                QLog.d("ArConfig_ArConfigService", 1, "registerFaceCallback error arConfigService is null");
            } else if (bVar != null && arConfigService.f197355i != null) {
                arConfigService.f197355i.register(bVar);
            }
        }

        @Override // com.tencent.mobileqq.ar.aidl.a
        public void z4(com.tencent.mobileqq.ar.aidl.c cVar) throws RemoteException {
            ArConfigService arConfigService;
            WeakReference<ArConfigService> weakReference = this.f197382d;
            if (weakReference != null) {
                arConfigService = weakReference.get();
            } else {
                arConfigService = null;
            }
            if (arConfigService == null) {
                QLog.d("ArConfig_ArConfigService", 1, "registerArCallback error arConfigService is null");
            } else if (cVar != null && arConfigService.f197354h != null) {
                arConfigService.f197354h.register(cVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b implements FaceScanDownloadManager.a {
        b() {
        }

        @Override // com.tencent.mobileqq.ar.FaceScanDownloadManager.a
        public void a(int i3, boolean z16) {
            if (ArConfigService.this.f197355i != null) {
                try {
                    int beginBroadcast = ArConfigService.this.f197355i.beginBroadcast();
                    for (int i16 = 0; i16 < beginBroadcast; i16++) {
                        if (z16) {
                            try {
                                ((com.tencent.mobileqq.ar.aidl.b) ArConfigService.this.f197355i.getBroadcastItem(i16)).R3(i3);
                            } catch (RemoteException e16) {
                                e16.printStackTrace();
                            }
                        } else {
                            ((com.tencent.mobileqq.ar.aidl.b) ArConfigService.this.f197355i.getBroadcastItem(i16)).H4(i3, 0);
                        }
                    }
                    ArConfigService.this.f197355i.finishBroadcast();
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ArConfig_ArConfigService", 2, "FaceScanDownloadManager notify onFinish error:" + e17.getMessage());
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.ar.FaceScanDownloadManager.a
        public void onProgress(int i3, int i16) {
            if (ArConfigService.this.f197355i != null) {
                try {
                    int beginBroadcast = ArConfigService.this.f197355i.beginBroadcast();
                    for (int i17 = 0; i17 < beginBroadcast; i17++) {
                        try {
                            ((com.tencent.mobileqq.ar.aidl.b) ArConfigService.this.f197355i.getBroadcastItem(i17)).X0(i3, i16);
                        } catch (RemoteException e16) {
                            e16.printStackTrace();
                        }
                    }
                    ArConfigService.this.f197355i.finishBroadcast();
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ArConfig_ArConfigService", 2, "FaceScanDownloadManager notify onProgress error:" + e17.getMessage());
                    }
                }
            }
        }
    }

    public ArConfigService() {
        QLog.w("ArConfig_ArConfigService", 1, "ArConfig_ArConfigService, init");
    }

    public static boolean A0(AppRuntime appRuntime) {
        boolean z16;
        com.tencent.mobileqq.earlydownload.handler.a aVar = (com.tencent.mobileqq.earlydownload.handler.a) ((IEarlyDownloadService) appRuntime.getRuntimeService(IEarlyDownloadService.class, "")).getEarlyHandler("qq.android.ar.native.so64_v8.0.0");
        boolean z17 = false;
        if (aVar != null) {
            boolean A = aVar.A();
            int v3 = aVar.v();
            if (aVar.A() && v3 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            boolean e16 = ArNativeSoLoader.e("ArMapEngine800Arch64");
            boolean z18 = z16 & e16;
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_ArConfigService", 2, String.format("isArSoDownload isSuccess=%s version=%s fileExist = %s result=%s ", Boolean.valueOf(A), Integer.valueOf(v3), Boolean.valueOf(e16), Boolean.valueOf(z18)));
            }
            z17 = z18;
        }
        QLog.d("ArConfig_ArConfigService", 1, "isArSoDownload ArNativeSoDownloadHandler so ready:=" + z17);
        return z17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        RemoteCallbackList<com.tencent.mobileqq.ar.aidl.d> remoteCallbackList = this.E;
        if (remoteCallbackList != null) {
            try {
                int beginBroadcast = remoteCallbackList.beginBroadcast();
                for (int i3 = 0; i3 < beginBroadcast; i3++) {
                    try {
                        this.E.getBroadcastItem(i3).p();
                    } catch (Exception unused) {
                    }
                }
                this.E.finishBroadcast();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("ArConfig_ArConfigService", 2, "notifyArSoDownloadFail fail!", e16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(int i3) {
        RemoteCallbackList<com.tencent.mobileqq.ar.aidl.d> remoteCallbackList = this.E;
        if (remoteCallbackList != null) {
            try {
                int beginBroadcast = remoteCallbackList.beginBroadcast();
                for (int i16 = 0; i16 < beginBroadcast; i16++) {
                    try {
                        this.E.getBroadcastItem(i16).F(i3);
                    } catch (Exception unused) {
                    }
                }
                this.E.finishBroadcast();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("ArConfig_ArConfigService", 2, "notifyArSoDownloadProcess fail!", e16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0() {
        if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArConfigService", 2, "notifyArSoDownloadSuccess ");
        }
        RemoteCallbackList<com.tencent.mobileqq.ar.aidl.d> remoteCallbackList = this.E;
        if (remoteCallbackList != null) {
            try {
                int beginBroadcast = remoteCallbackList.beginBroadcast();
                for (int i3 = 0; i3 < beginBroadcast; i3++) {
                    try {
                        this.E.getBroadcastItem(i3).t();
                    } catch (Exception unused) {
                    }
                }
                this.E.finishBroadcast();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("ArConfig_ArConfigService", 2, "notifyArSoDownloadSuccess fail!", e16);
                }
            }
        }
    }

    static /* bridge */ /* synthetic */ boolean d0() {
        return k0();
    }

    private static boolean k0() {
        return ArNativeSoLoader.c("ArMapEngine800Arch64");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0() {
        if (this.f197351d.get() == null) {
            QLog.d("ArConfig_ArConfigService", 1, "downArCoreSoInternal,mApp is null! ");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArConfigService", 2, "downArCoreSoInternal");
        }
        w81.b.a();
        this.M = true;
        this.N = 100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0() {
        ArrayList<ARCommonConfigInfo.NativeSoRes> arrayList;
        if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArConfigService", 2, "downloadArCloudSoInternal");
        }
        QQAppInterface qQAppInterface = this.f197351d.get();
        if (qQAppInterface == null) {
            QLog.d("ArConfig_ArConfigService", 1, "downloadArCloudSoInternal,mApp is null! ");
            return;
        }
        boolean s06 = s0();
        this.I = s06;
        if (!s06) {
            ARGlobalConfigManager aRGlobalConfigManager = (ARGlobalConfigManager) this.app.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
            if (aRGlobalConfigManager != null) {
                try {
                    ARCommonConfigInfo f16 = aRGlobalConfigManager.f(true);
                    if (f16 != null && (arrayList = f16.nativeSoResList) != null && arrayList.size() > 0) {
                        new ArNativeSoManager(qQAppInterface).j(f16.nativeSoResList, "arcloud", this.T);
                    }
                    this.J = 0;
                    return;
                } catch (Exception e16) {
                    QLog.e("ArConfig_ArConfigService", 1, "downloadArCloudSoInternal fail!", e16);
                    if (!this.F) {
                        this.D.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ArConfigService.10
                            @Override // java.lang.Runnable
                            public void run() {
                                ArConfigService.this.B0();
                            }
                        });
                        this.F = true;
                        return;
                    }
                    return;
                }
            }
            return;
        }
        this.J = 100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        ArrayList<ARCommonConfigInfo.NativeSoRes> arrayList;
        if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArConfigService", 2, "downloadArFeatureSoInternal");
        }
        QQAppInterface qQAppInterface = this.f197351d.get();
        if (qQAppInterface == null) {
            QLog.d("ArConfig_ArConfigService", 1, "downloadArFeatureSoInternal,mApp is null! ");
            return;
        }
        boolean u06 = u0();
        this.P = u06;
        if (!u06) {
            ARGlobalConfigManager aRGlobalConfigManager = (ARGlobalConfigManager) this.app.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
            if (aRGlobalConfigManager != null) {
                try {
                    ARCommonConfigInfo f16 = aRGlobalConfigManager.f(true);
                    if (f16 != null && (arrayList = f16.nativeSoResList) != null && arrayList.size() > 0) {
                        new ArNativeSoManager(qQAppInterface).j(f16.nativeSoResList, "arfeature", this.V);
                    }
                    this.Q = 0;
                    return;
                } catch (Exception e16) {
                    QLog.e("ArConfig_ArConfigService", 1, "downloadArCloudSoInternal fail!", e16);
                    if (!this.F) {
                        this.D.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ArConfigService.9
                            @Override // java.lang.Runnable
                            public void run() {
                                ArConfigService.this.B0();
                            }
                        });
                        this.F = true;
                        return;
                    }
                    return;
                }
            }
            return;
        }
        this.Q = 100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        ArrayList<ARCommonConfigInfo.NativeSoRes> arrayList;
        if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArConfigService", 2, "downloadArSDK2SoInternal");
        }
        QQAppInterface qQAppInterface = this.f197351d.get();
        if (qQAppInterface == null) {
            QLog.d("ArConfig_ArConfigService", 1, "downloadArSDK2SoInternal,mApp is null! ");
            return;
        }
        boolean x06 = x0();
        this.K = x06;
        if (!x06) {
            ARGlobalConfigManager aRGlobalConfigManager = (ARGlobalConfigManager) this.app.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
            if (aRGlobalConfigManager != null) {
                try {
                    ARCommonConfigInfo f16 = aRGlobalConfigManager.f(true);
                    if (f16 != null && (arrayList = f16.nativeSoResList) != null && arrayList.size() > 0) {
                        new ArNativeSoManager(qQAppInterface).j(f16.nativeSoResList, "arsdk2", this.S);
                    }
                    this.L = 0;
                    return;
                } catch (Exception e16) {
                    QLog.e("ArConfig_ArConfigService", 1, "downloadArSDK2SoInternal fail!", e16);
                    if (!this.F) {
                        this.D.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ArConfigService.11
                            @Override // java.lang.Runnable
                            public void run() {
                                ArConfigService.this.B0();
                            }
                        });
                        this.F = true;
                        return;
                    }
                    return;
                }
            }
            return;
        }
        this.L = 100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0() {
        boolean z06;
        if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArConfigService", 2, "downloadArSoInternal");
        }
        if (k0()) {
            z06 = true;
        } else {
            z06 = z0();
        }
        this.G = z06;
        if (!z06) {
            com.tencent.mobileqq.earlydownload.handler.a aVar = (com.tencent.mobileqq.earlydownload.handler.a) ((IEarlyDownloadService) this.app.getRuntimeService(IEarlyDownloadService.class, "")).getEarlyHandler("qq.android.ar.native.so64_v8.0.0");
            if (aVar != null) {
                aVar.c(this.R);
                this.H = 0;
                XmlData o16 = aVar.o();
                if (o16 != null && o16.loadState == 2) {
                    QLog.d("ArConfig_ArConfigService", 1, "downloadArSoInternal in download queue? force download!!!");
                    aVar.M(true, true);
                    return;
                } else {
                    aVar.I(true);
                    return;
                }
            }
            return;
        }
        this.H = 100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q0() {
        return r0(this.app);
    }

    public static boolean r0(AppRuntime appRuntime) {
        w81.b.a();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s0() {
        return t0(this.app);
    }

    public static boolean t0(AppRuntime appRuntime) {
        boolean z16;
        ARCommonConfigInfo f16;
        ArrayList<ARCommonConfigInfo.NativeSoRes> arrayList;
        ARGlobalConfigManager aRGlobalConfigManager = (ARGlobalConfigManager) appRuntime.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
        if (aRGlobalConfigManager == null) {
            return false;
        }
        try {
            f16 = aRGlobalConfigManager.f(true);
        } catch (Exception e16) {
            QLog.e("ArConfig_ArConfigService", 1, "isArCloudSoDownload fail!", e16);
        }
        if (f16 != null && (arrayList = f16.nativeSoResList) != null && arrayList.size() > 0) {
            z16 = new ArNativeSoManager((QQAppInterface) appRuntime).r(f16.nativeSoResList, "arcloud");
            QLog.d("ArConfig_ArConfigService", 1, String.format("isArCloudSoDownload result=%s", Boolean.valueOf(z16)));
            return z16;
        }
        z16 = false;
        QLog.d("ArConfig_ArConfigService", 1, String.format("isArCloudSoDownload result=%s", Boolean.valueOf(z16)));
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u0() {
        return v0(this.app);
    }

    public static boolean v0(AppRuntime appRuntime) {
        return true;
    }

    public static boolean w0(AppRuntime appRuntime) {
        if (k0() && t0(appRuntime) && y0(appRuntime) && r0(appRuntime)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x0() {
        return y0(this.app);
    }

    public static boolean y0(AppRuntime appRuntime) {
        boolean z16;
        ARCommonConfigInfo f16;
        ArrayList<ARCommonConfigInfo.NativeSoRes> arrayList;
        ARGlobalConfigManager aRGlobalConfigManager = (ARGlobalConfigManager) appRuntime.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
        if (aRGlobalConfigManager == null) {
            return false;
        }
        try {
            f16 = aRGlobalConfigManager.f(true);
        } catch (Exception e16) {
            QLog.e("ArConfig_ArConfigService", 1, "isArSDK2SoDownload fail!", e16);
        }
        if (f16 != null && (arrayList = f16.nativeSoResList) != null && arrayList.size() > 0) {
            z16 = new ArNativeSoManager((QQAppInterface) appRuntime).r(f16.nativeSoResList, "arsdk2");
            QLog.d("ArConfig_ArConfigService", 1, String.format("isArSDK2SoDownload result=%s", Boolean.valueOf(z16)));
            return z16;
        }
        z16 = false;
        QLog.d("ArConfig_ArConfigService", 1, String.format("isArSDK2SoDownload result=%s", Boolean.valueOf(z16)));
        return z16;
    }

    private boolean z0() {
        return A0(this.app);
    }

    @Override // mqq.app.AppService
    public void onAccountChanged() {
        super.onAccountChanged();
        QLog.d("ArConfig_ArConfigService", 1, "[onAccountChanged]");
        stopSelf();
    }

    @Override // mqq.app.AppService, android.app.Service
    public IBinder onBind(Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArConfigService", 2, "onBind");
        }
        return this.C;
    }

    @Override // mqq.app.AppService, android.app.Service
    public void onCreate() {
        super.onCreate();
        if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArConfigService", 2, "onCreate, " + this);
        }
        if (this.app instanceof QQAppInterface) {
            WeakReference<QQAppInterface> weakReference = new WeakReference<>((QQAppInterface) this.app);
            this.f197351d = weakReference;
            QQAppInterface qQAppInterface = weakReference.get();
            if (qQAppInterface == null) {
                QLog.d("ArConfig_ArConfigService", 1, "onCreate,mApp is null! ");
                return;
            }
            ArResourceManager arResourceManager = (ArResourceManager) qQAppInterface.getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
            if (arResourceManager != null) {
                arResourceManager.a(this.f197356m);
            }
            ARGlobalConfigManager aRGlobalConfigManager = (ARGlobalConfigManager) qQAppInterface.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
            this.f197352e = aRGlobalConfigManager;
            if (aRGlobalConfigManager != null) {
                aRGlobalConfigManager.b(this.f197356m);
            }
            FaceScanDownloadManager.a(new b());
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArConfigService", 2, "onDestroy, " + this);
        }
        this.f197354h.kill();
        this.f197355i.kill();
        this.f197354h = null;
        this.f197355i = null;
        this.f197351d = null;
        this.f197352e = null;
        FaceScanDownloadManager.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppService
    public void onLogout(Constants.LogoutReason logoutReason) {
        stopSelf();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        ArResourceManager arResourceManager;
        QQAppInterface qQAppInterface = this.f197351d.get();
        if (qQAppInterface != null && (arResourceManager = (ArResourceManager) qQAppInterface.getManager(QQManagerFactory.AR_RESOURCE_MANAGER)) != null) {
            arResourceManager.s(this.f197356m);
        }
        return super.onUnbind(intent);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements s {
        a() {
        }

        @Override // com.tencent.mobileqq.ar.s
        public void e(int i3) {
            if (ArConfigService.this.f197354h != null) {
                try {
                    int beginBroadcast = ArConfigService.this.f197354h.beginBroadcast();
                    for (int i16 = 0; i16 < beginBroadcast; i16++) {
                        ((com.tencent.mobileqq.ar.aidl.c) ArConfigService.this.f197354h.getBroadcastItem(i16)).e(i3);
                    }
                    ArConfigService.this.f197354h.finishBroadcast();
                } catch (RemoteException e16) {
                    e16.printStackTrace();
                }
                QQAppInterface qQAppInterface = ArConfigService.this.f197351d.get();
                if (qQAppInterface == null) {
                    QLog.d("ArConfig_ArConfigService", 1, "onDownloadError,mApp is null! ");
                } else {
                    i.g(qQAppInterface.getCurrentAccountUin(), false, i3);
                }
            }
        }

        @Override // com.tencent.mobileqq.ar.s
        public void i(long j3, long j16) {
            if (ArConfigService.this.f197354h != null) {
                try {
                    int beginBroadcast = ArConfigService.this.f197354h.beginBroadcast();
                    for (int i3 = 0; i3 < beginBroadcast; i3++) {
                        ((com.tencent.mobileqq.ar.aidl.c) ArConfigService.this.f197354h.getBroadcastItem(i3)).i(j3, j16);
                    }
                    ArConfigService.this.f197354h.finishBroadcast();
                } catch (RemoteException e16) {
                    e16.printStackTrace();
                }
            }
        }

        @Override // com.tencent.mobileqq.ar.s
        public void j(ArEffectConfig arEffectConfig) {
            if (ArConfigService.this.f197354h != null) {
                try {
                    int beginBroadcast = ArConfigService.this.f197354h.beginBroadcast();
                    for (int i3 = 0; i3 < beginBroadcast; i3++) {
                        ((com.tencent.mobileqq.ar.aidl.c) ArConfigService.this.f197354h.getBroadcastItem(i3)).Q4(null, arEffectConfig, null);
                    }
                    ArConfigService.this.f197354h.finishBroadcast();
                } catch (RemoteException e16) {
                    e16.printStackTrace();
                }
            }
        }

        @Override // com.tencent.mobileqq.ar.s
        public void l(ArConfigInfo arConfigInfo) {
            if (ArConfigService.this.f197354h != null) {
                try {
                    int beginBroadcast = ArConfigService.this.f197354h.beginBroadcast();
                    for (int i3 = 0; i3 < beginBroadcast; i3++) {
                        ((com.tencent.mobileqq.ar.aidl.c) ArConfigService.this.f197354h.getBroadcastItem(i3)).Q4(arConfigInfo, null, null);
                    }
                    ArConfigService.this.f197354h.finishBroadcast();
                } catch (RemoteException e16) {
                    e16.printStackTrace();
                }
            }
        }

        @Override // com.tencent.mobileqq.ar.s
        public void m(ARCommonConfigInfo aRCommonConfigInfo) {
            if (ArConfigService.this.f197354h != null) {
                try {
                    int beginBroadcast = ArConfigService.this.f197354h.beginBroadcast();
                    for (int i3 = 0; i3 < beginBroadcast; i3++) {
                        ((com.tencent.mobileqq.ar.aidl.c) ArConfigService.this.f197354h.getBroadcastItem(i3)).Q4(null, null, aRCommonConfigInfo);
                    }
                    ArConfigService.this.f197354h.finishBroadcast();
                } catch (RemoteException e16) {
                    e16.printStackTrace();
                }
            }
        }

        @Override // com.tencent.mobileqq.ar.s
        public void onDownloadSuccess() {
            if (ArConfigService.this.f197354h != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("ArConfig_ArConfigService", 2, "onDownloadSuccess before sync");
                }
                synchronized (ArConfigService.this.f197353f) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ArConfig_ArConfigService", 2, "onDownloadSuccess  sync start");
                    }
                    try {
                        int beginBroadcast = ArConfigService.this.f197354h.beginBroadcast();
                        for (int i3 = 0; i3 < beginBroadcast; i3++) {
                            try {
                                ((com.tencent.mobileqq.ar.aidl.c) ArConfigService.this.f197354h.getBroadcastItem(i3)).onDownloadSuccess();
                            } catch (RemoteException e16) {
                                e16.printStackTrace();
                            }
                        }
                        ArConfigService.this.f197354h.finishBroadcast();
                        if (QLog.isColorLevel()) {
                            QLog.d("ArConfig_ArConfigService", 2, "onDownloadSuccess  sync end");
                        }
                    } catch (Exception e17) {
                        e17.printStackTrace();
                        QLog.d("ArConfig_ArConfigService", 1, "onDownloadSuccess  sync fail end,error reason:binder server muti-thread");
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ArConfig_ArConfigService", 2, "onDownloadSuccess after sync");
                }
                QQAppInterface qQAppInterface = ArConfigService.this.f197351d.get();
                if (qQAppInterface == null) {
                    QLog.d("ArConfig_ArConfigService", 1, "onDownloadSuccess,mApp is null! ");
                } else {
                    i.g(qQAppInterface.getCurrentAccountUin(), true, 0);
                }
            }
        }

        @Override // com.tencent.mobileqq.ar.s
        public void k() {
        }
    }
}
