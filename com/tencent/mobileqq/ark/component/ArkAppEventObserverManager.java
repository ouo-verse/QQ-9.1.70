package com.tencent.mobileqq.ark.component;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkAppEventObserverManager {

    /* renamed from: a, reason: collision with root package name */
    private String f199180a;

    /* renamed from: c, reason: collision with root package name */
    private SensorEventListener f199182c;

    /* renamed from: i, reason: collision with root package name */
    private float f199188i;

    /* renamed from: j, reason: collision with root package name */
    private float f199189j;

    /* renamed from: k, reason: collision with root package name */
    private float f199190k;

    /* renamed from: d, reason: collision with root package name */
    private ArkConnectionHandler f199183d = null;

    /* renamed from: e, reason: collision with root package name */
    private Sensor f199184e = null;

    /* renamed from: f, reason: collision with root package name */
    private float[] f199185f = new float[3];

    /* renamed from: g, reason: collision with root package name */
    private float[] f199186g = new float[3];

    /* renamed from: h, reason: collision with root package name */
    private Sensor f199187h = null;

    /* renamed from: l, reason: collision with root package name */
    private double f199191l = 0.0d;

    /* renamed from: m, reason: collision with root package name */
    private double f199192m = 0.0d;

    /* renamed from: n, reason: collision with root package name */
    private String f199193n = null;

    /* renamed from: o, reason: collision with root package name */
    private final int f199194o = 0;

    /* renamed from: p, reason: collision with root package name */
    private d f199195p = null;

    /* renamed from: q, reason: collision with root package name */
    private long f199196q = 0;

    /* renamed from: r, reason: collision with root package name */
    private f f199197r = null;

    /* renamed from: s, reason: collision with root package name */
    private long f199198s = 0;

    /* renamed from: t, reason: collision with root package name */
    private g f199199t = null;

    /* renamed from: u, reason: collision with root package name */
    private long f199200u = 0;

    /* renamed from: v, reason: collision with root package name */
    private b f199201v = null;

    /* renamed from: w, reason: collision with root package name */
    private long f199202w = 0;

    /* renamed from: x, reason: collision with root package name */
    private c f199203x = null;

    /* renamed from: y, reason: collision with root package name */
    private long f199204y = 0;

    /* renamed from: b, reason: collision with root package name */
    private SosoInterfaceOnLocationListener f199181b = new SosoInterfaceOnLocationListener(3, true, true, 0, true, false, "ArkAppEventObserverManager") { // from class: com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.1
        @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
        public void onConsecutiveFailure(int i3, int i16) {
            if (QLog.isColorLevel()) {
                QLog.d("ArkAppEventObserverManager", 2, "onConsecutiveFailure errCode=" + i3 + ", failCount=" + i16);
            }
            if (i16 < 3) {
                return;
            }
            ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(ArkAppEventObserverManager.this.f199180a, new Runnable() { // from class: com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.1.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ArkAppEventObserverManager.this.f199199t != null) {
                        ArkAppEventObserverManager.this.f199199t.a(false, 0.0d, 0.0d);
                    }
                    ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(ArkAppEventObserverManager.this.f199181b);
                    ArkAppEventObserverManager.this.f199199t = null;
                }
            });
        }

        @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
        public void onLocationFinish(final int i3, final SosoLbsInfo sosoLbsInfo) {
            if (QLog.isColorLevel()) {
                QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish errCode=" + i3);
            }
            ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(ArkAppEventObserverManager.this.f199180a, new Runnable() { // from class: com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.1.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z16;
                    boolean z17;
                    Object obj;
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder("onLocationFinish mPositionCallback=");
                        sb5.append(ArkAppEventObserverManager.this.f199199t);
                        sb5.append(", mPositionCallbackId=");
                        sb5.append(ArkAppEventObserverManager.this.f199200u);
                        sb5.append(", mGetCurrentPositionCallback=");
                        sb5.append(ArkAppEventObserverManager.this.f199203x);
                        sb5.append(", mGetCurrentPositionCallbackId=");
                        sb5.append(ArkAppEventObserverManager.this.f199204y);
                        sb5.append(", lbsInfo=");
                        sb5.append(sosoLbsInfo);
                        sb5.append(", lbsInfo.mLocation=");
                        SosoLbsInfo sosoLbsInfo2 = sosoLbsInfo;
                        if (sosoLbsInfo2 != null) {
                            obj = sosoLbsInfo2.mLocation;
                        } else {
                            obj = "NULL";
                        }
                        sb5.append(obj);
                        QLog.d("ArkAppEventObserverManager", 2, sb5.toString());
                    }
                    if (ArkAppEventObserverManager.this.f199199t == null && ArkAppEventObserverManager.this.f199203x == null) {
                        ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(ArkAppEventObserverManager.this.f199181b);
                        return;
                    }
                    SosoLbsInfo sosoLbsInfo3 = sosoLbsInfo;
                    if (sosoLbsInfo3 != null && sosoLbsInfo3.mLocation != null) {
                        if (QLog.isColorLevel()) {
                            if (ArkAppEventObserverManager.this.f199199t != null) {
                                QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish errCode=" + i3 + ", positionCallback=" + ArkAppEventObserverManager.this.f199199t + ", lat02=" + sosoLbsInfo.mLocation.mLat02 + ", lon02=" + sosoLbsInfo.mLocation.mLon02 + ", lat84=" + sosoLbsInfo.mLocation.mLat84 + ", lon84=" + sosoLbsInfo.mLocation.mLon84 + ", mLastLat=" + ArkAppEventObserverManager.this.f199191l + ", mLastLon=" + ArkAppEventObserverManager.this.f199192m);
                            } else if (ArkAppEventObserverManager.this.f199203x != null) {
                                QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish errCode=" + i3 + ", getcurrentPositionCallback=" + ArkAppEventObserverManager.this.f199203x + ", lat02=" + sosoLbsInfo.mLocation.mLat02 + ", lon02=" + sosoLbsInfo.mLocation.mLon02 + ", lat84=" + sosoLbsInfo.mLocation.mLat84 + ", lon84=" + sosoLbsInfo.mLocation.mLon84 + ", mLastLat=" + ArkAppEventObserverManager.this.f199191l + ", mLastLon=" + ArkAppEventObserverManager.this.f199192m);
                            }
                        }
                        SosoLocation sosoLocation = sosoLbsInfo.mLocation;
                        double d16 = sosoLocation.mLat84;
                        double d17 = sosoLocation.mLon84;
                        if (d16 <= 1.0E-6d && d17 <= 1.0E-6d) {
                            double[] a16 = com.tencent.mobileqq.ark.util.g.a(sosoLocation.mLon02, sosoLocation.mLat02);
                            d17 = a16[0];
                            d16 = a16[1];
                            if (QLog.isColorLevel()) {
                                QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish gcj02towgs84 curLat=" + d16 + ", curLon=" + d17);
                            }
                        }
                        if (ArkAppEventObserverManager.this.f199199t != null && (Math.abs(d16 - ArkAppEventObserverManager.this.f199191l) >= 1.0E-6d || Math.abs(d17 - ArkAppEventObserverManager.this.f199192m) >= 1.0E-6d)) {
                            g gVar = ArkAppEventObserverManager.this.f199199t;
                            if (i3 == 0) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            gVar.a(z17, d16, d17);
                            ArkAppEventObserverManager.this.f199191l = d16;
                            ArkAppEventObserverManager.this.f199192m = d17;
                        }
                        if (ArkAppEventObserverManager.this.f199203x != null) {
                            c cVar = ArkAppEventObserverManager.this.f199203x;
                            if (i3 == 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            cVar.a(z16, d16, d17);
                            if (ArkAppEventObserverManager.this.f199204y != 0) {
                                ArkAppEventObserverManager.this.f199203x.c(ArkAppEventObserverManager.this.f199204y);
                            }
                            ArkAppEventObserverManager.this.f199203x = null;
                            ArkAppEventObserverManager.this.f199204y = 0L;
                            if (ArkAppEventObserverManager.this.f199199t == null) {
                                ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(ArkAppEventObserverManager.this.f199181b);
                            }
                        }
                    }
                }
            });
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class ArkConnectionHandler implements INetInfoHandler {
        ArkConnectionHandler() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            if (QLog.isColorLevel()) {
                QLog.d("ArkAppEventObserverManager", 2, "onNetMobile2None mLastNetType=" + ArkAppEventObserverManager.this.f199193n);
            }
            ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(ArkAppEventObserverManager.this.f199180a, new Runnable() { // from class: com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.ArkConnectionHandler.6
                @Override // java.lang.Runnable
                public void run() {
                    if (ArkAppEventObserverManager.this.f199201v != null && !"none".equals(ArkAppEventObserverManager.this.f199193n)) {
                        ArkAppEventObserverManager.this.f199201v.b(true, "none");
                        ArkAppEventObserverManager.this.f199193n = "none";
                    }
                }
            });
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(String str) {
            if (QLog.isColorLevel()) {
                QLog.d("ArkAppEventObserverManager", 2, "onNetMobile2Wifi mLastNetType=" + ArkAppEventObserverManager.this.f199193n);
            }
            ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(ArkAppEventObserverManager.this.f199180a, new Runnable() { // from class: com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.ArkConnectionHandler.5
                @Override // java.lang.Runnable
                public void run() {
                    if (ArkAppEventObserverManager.this.f199201v != null && !"wifi".equals(ArkAppEventObserverManager.this.f199193n)) {
                        ArkAppEventObserverManager.this.f199201v.b(true, "wifi");
                        ArkAppEventObserverManager.this.f199193n = "wifi";
                    }
                }
            });
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(String str) {
            if (QLog.isColorLevel()) {
                QLog.d("ArkAppEventObserverManager", 2, "onNetNone2Mobile mLastNetType=" + ArkAppEventObserverManager.this.f199193n);
            }
            ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(ArkAppEventObserverManager.this.f199180a, new Runnable() { // from class: com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.ArkConnectionHandler.4
                @Override // java.lang.Runnable
                public void run() {
                    if (ArkAppEventObserverManager.this.f199201v != null && !"cellular".equals(ArkAppEventObserverManager.this.f199193n)) {
                        ArkAppEventObserverManager.this.f199201v.b(true, "cellular");
                        ArkAppEventObserverManager.this.f199193n = "cellular";
                    }
                }
            });
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(String str) {
            if (QLog.isColorLevel()) {
                QLog.d("ArkAppEventObserverManager", 2, "onNetNone2Wifi mLastNetType=" + ArkAppEventObserverManager.this.f199193n);
            }
            ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(ArkAppEventObserverManager.this.f199180a, new Runnable() { // from class: com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.ArkConnectionHandler.3
                @Override // java.lang.Runnable
                public void run() {
                    if (ArkAppEventObserverManager.this.f199201v != null && !"wifi".equals(ArkAppEventObserverManager.this.f199193n)) {
                        ArkAppEventObserverManager.this.f199201v.b(true, "wifi");
                        ArkAppEventObserverManager.this.f199193n = "wifi";
                    }
                }
            });
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(String str) {
            if (QLog.isColorLevel()) {
                QLog.d("ArkAppEventObserverManager", 2, "onNetWifi2Mobile mLastNetType=" + ArkAppEventObserverManager.this.f199193n);
            }
            ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(ArkAppEventObserverManager.this.f199180a, new Runnable() { // from class: com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.ArkConnectionHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ArkAppEventObserverManager.this.f199201v != null && !"cellular".equals(ArkAppEventObserverManager.this.f199193n)) {
                        ArkAppEventObserverManager.this.f199201v.b(true, "cellular");
                        ArkAppEventObserverManager.this.f199193n = "cellular";
                    }
                }
            });
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            if (QLog.isColorLevel()) {
                QLog.d("ArkAppEventObserverManager", 2, "onNetWifi2None mLastNetType=" + ArkAppEventObserverManager.this.f199193n);
            }
            ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(ArkAppEventObserverManager.this.f199180a, new Runnable() { // from class: com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.ArkConnectionHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ArkAppEventObserverManager.this.f199201v != null && !"none".equals(ArkAppEventObserverManager.this.f199193n)) {
                        ArkAppEventObserverManager.this.f199201v.b(true, "none");
                        ArkAppEventObserverManager.this.f199193n = "none";
                    }
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface b extends e {
        void b(boolean z16, String str);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface c extends e {
        void a(boolean z16, double d16, double d17);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface d extends e {
        void d(boolean z16, float f16, float f17, float f18);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface e {
        void c(long j3);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface f extends e {
        void e(boolean z16, float f16, float f17, float f18);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface g extends e {
        void a(boolean z16, double d16, double d17);
    }

    public ArkAppEventObserverManager(String str) {
        this.f199182c = null;
        this.f199180a = str;
        this.f199182c = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(final SensorEvent sensorEvent) {
        final long currentTimeMillis = System.currentTimeMillis();
        ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(this.f199180a, new Runnable() { // from class: com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.2
            @Override // java.lang.Runnable
            public void run() {
                for (int i3 = 0; i3 < 3; i3++) {
                    ArkAppEventObserverManager.this.f199186g[i3] = (float) ((sensorEvent.values[i3] * 0.1d) + (ArkAppEventObserverManager.this.f199186g[i3] * 0.9d));
                    ArkAppEventObserverManager.this.f199185f[i3] = sensorEvent.values[i3] - ArkAppEventObserverManager.this.f199186g[i3];
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ArkAppEventObserverManager", 2, "onMotionSensorChange curTime=" + currentTimeMillis + ", mMotionX=" + ArkAppEventObserverManager.this.f199185f[0] + ", mMotionY=" + ArkAppEventObserverManager.this.f199185f[1] + ", mMotionZ=" + ArkAppEventObserverManager.this.f199185f[2]);
                }
                if (ArkAppEventObserverManager.this.f199195p != null) {
                    ArkAppEventObserverManager.this.f199195p.d(true, ArkAppEventObserverManager.this.f199185f[0], ArkAppEventObserverManager.this.f199185f[1], ArkAppEventObserverManager.this.f199185f[2]);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(final SensorEvent sensorEvent) {
        final long currentTimeMillis = System.currentTimeMillis();
        ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(this.f199180a, new Runnable() { // from class: com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.3
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    QLog.d("ArkAppEventObserverManager", 2, "onOrientationSensorChange curTime=" + currentTimeMillis + ", event[0]=" + sensorEvent.values[0] + ", event[1]=" + sensorEvent.values[1] + ", event[2]=" + sensorEvent.values[2]);
                }
                ArkAppEventObserverManager.this.f199188i = 360.0f - sensorEvent.values[0];
                ArkAppEventObserverManager.this.f199189j = -sensorEvent.values[1];
                ArkAppEventObserverManager.this.f199190k = -sensorEvent.values[2];
                if (QLog.isColorLevel()) {
                    QLog.d("ArkAppEventObserverManager", 2, "onOrientationSensorChange update alpha=" + ArkAppEventObserverManager.this.f199188i + ", update beta=" + ArkAppEventObserverManager.this.f199189j + ", update gamma=" + ArkAppEventObserverManager.this.f199190k);
                }
                if (ArkAppEventObserverManager.this.f199197r != null) {
                    ArkAppEventObserverManager.this.f199197r.e(true, ArkAppEventObserverManager.this.f199188i, ArkAppEventObserverManager.this.f199189j, ArkAppEventObserverManager.this.f199190k);
                }
            }
        });
    }

    public void C() {
        E("Motion");
        E("Orientation");
        E("Position");
        E("ConnectionTypeChange");
    }

    public void D(e eVar, long j3) {
        c cVar;
        b bVar;
        g gVar;
        f fVar;
        d dVar;
        if (eVar instanceof d) {
            if (QLog.isColorLevel()) {
                QLog.d("ArkAppEventObserverManager", 2, "attachEvent MotionCallback");
            }
            long j16 = this.f199196q;
            if (j16 != 0 && (dVar = this.f199195p) != null) {
                dVar.c(j16);
            }
            this.f199195p = (d) eVar;
            this.f199196q = j3;
            if (this.f199184e == null) {
                SensorManager sensorManager = (SensorManager) F().getApp().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
                Sensor defaultSensor = SensorMonitor.getDefaultSensor(sensorManager, 1);
                this.f199184e = defaultSensor;
                if (defaultSensor != null) {
                    SensorMonitor.registerListener(sensorManager, this.f199182c, defaultSensor, 1);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ArkAppEventObserverManager", 2, "mMotionSensor is NULL");
                }
                this.f199195p.d(false, 0.0f, 0.0f, 0.0f);
                return;
            }
            return;
        }
        if (eVar instanceof f) {
            if (QLog.isColorLevel()) {
                QLog.d("ArkAppEventObserverManager", 2, "attachEvent OrientationCallback");
            }
            long j17 = this.f199198s;
            if (j17 != 0 && (fVar = this.f199197r) != null) {
                fVar.c(j17);
            }
            this.f199197r = (f) eVar;
            this.f199198s = j3;
            if (this.f199187h == null) {
                SensorManager sensorManager2 = (SensorManager) F().getApp().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
                Sensor defaultSensor2 = SensorMonitor.getDefaultSensor(sensorManager2, 3);
                this.f199187h = defaultSensor2;
                SensorMonitor.registerListener(sensorManager2, this.f199182c, defaultSensor2, 1);
                return;
            }
            return;
        }
        if (eVar instanceof g) {
            if (QLog.isColorLevel()) {
                QLog.d("ArkAppEventObserverManager", 2, "attachEvent PositionCallback callback=" + eVar + ", cbId=" + j3 + ", mPositionCallback=" + this.f199199t + ", mPositionCallbackId=" + this.f199200u);
            }
            long j18 = this.f199200u;
            if (j18 != 0 && (gVar = this.f199199t) != null) {
                gVar.c(j18);
            }
            this.f199199t = (g) eVar;
            this.f199200u = j3;
            ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).startLocation(this.f199181b);
            return;
        }
        if (eVar instanceof b) {
            if (QLog.isColorLevel()) {
                QLog.d("ArkAppEventObserverManager", 2, "attachEvent ConnectionCallback");
            }
            long j19 = this.f199202w;
            if (j19 != 0 && (bVar = this.f199201v) != null) {
                bVar.c(j19);
            }
            this.f199201v = (b) eVar;
            this.f199202w = j3;
            if (this.f199183d == null) {
                this.f199183d = new ArkConnectionHandler();
                AppNetConnInfo.registerConnectionChangeReceiver(F().getApp(), this.f199183d);
                return;
            }
            return;
        }
        if (eVar instanceof c) {
            if (QLog.isColorLevel()) {
                QLog.d("ArkAppEventObserverManager", 2, "attachEvent GetCurrentPositionCallback");
            }
            long j26 = this.f199204y;
            if (j26 != 0 && (cVar = this.f199203x) != null) {
                cVar.c(j26);
            }
            this.f199203x = (c) eVar;
            this.f199204y = j3;
            ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).startLocation(this.f199181b);
        }
    }

    public void E(String str) {
        b bVar;
        g gVar;
        f fVar;
        d dVar;
        if (QLog.isColorLevel()) {
            QLog.d("ArkAppEventObserverManager", 2, "detachEvent eventName=" + str);
        }
        if ("Motion".equals(str)) {
            if (this.f199184e != null) {
                ((SensorManager) F().getApp().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR)).unregisterListener(this.f199182c, this.f199184e);
                this.f199184e = null;
            }
            long j3 = this.f199196q;
            if (j3 != 0 && (dVar = this.f199195p) != null) {
                dVar.c(j3);
            }
            this.f199195p = null;
            this.f199196q = 0L;
            return;
        }
        if ("Orientation".equals(str)) {
            if (this.f199187h != null) {
                ((SensorManager) F().getApp().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR)).unregisterListener(this.f199182c, this.f199187h);
                this.f199187h = null;
            }
            long j16 = this.f199198s;
            if (j16 != 0 && (fVar = this.f199197r) != null) {
                fVar.c(j16);
            }
            this.f199197r = null;
            this.f199198s = 0L;
            return;
        }
        if ("Position".equals(str)) {
            ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(this.f199181b);
            if (QLog.isColorLevel()) {
                QLog.d("ArkAppEventObserverManager", 2, "detachEvent PositionCallback mPositionCallback=" + this.f199199t + ", mPositionCallbackId=" + this.f199200u);
            }
            long j17 = this.f199200u;
            if (j17 != 0 && (gVar = this.f199199t) != null) {
                gVar.c(j17);
            }
            this.f199199t = null;
            this.f199200u = 0L;
            this.f199191l = 0.0d;
            this.f199192m = 0.0d;
            return;
        }
        if ("ConnectionTypeChange".equals(str)) {
            ArkConnectionHandler arkConnectionHandler = this.f199183d;
            if (arkConnectionHandler != null) {
                AppNetConnInfo.unregisterNetInfoHandler(arkConnectionHandler);
                this.f199183d = null;
            }
            long j18 = this.f199202w;
            if (j18 != 0 && (bVar = this.f199201v) != null) {
                bVar.c(j18);
            }
            this.f199201v = null;
            this.f199202w = 0L;
            this.f199193n = null;
        }
    }

    AppRuntime F() {
        return MobileQQ.sMobileQQ.waitAppRuntime(null);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements SensorEventListener {
        a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                ArkAppEventObserverManager.this.G(sensorEvent);
            } else if (sensorEvent.sensor.getType() == 3) {
                ArkAppEventObserverManager.this.H(sensorEvent);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
        }
    }
}
