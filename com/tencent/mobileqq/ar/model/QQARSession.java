package com.tencent.mobileqq.ar.model;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager;
import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.ar.ARRenderModel.e;
import com.tencent.mobileqq.ar.ARRenderModel.k;
import com.tencent.mobileqq.ar.ARRenderModel.l;
import com.tencent.mobileqq.ar.ARRenderModel.n;
import com.tencent.mobileqq.ar.ARRenderModel.p;
import com.tencent.mobileqq.ar.ARRenderModel.q;
import com.tencent.mobileqq.ar.ARRenderModel.r;
import com.tencent.mobileqq.ar.DrawView2;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudControl;
import com.tencent.mobileqq.ar.arengine.ARLocalControl;
import com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog;
import com.tencent.mobileqq.ar.arengine.aa;
import com.tencent.mobileqq.ar.arengine.ab;
import com.tencent.mobileqq.ar.arengine.ac;
import com.tencent.mobileqq.ar.arengine.ad;
import com.tencent.mobileqq.ar.arengine.af;
import com.tencent.mobileqq.ar.arengine.g;
import com.tencent.mobileqq.ar.arengine.h;
import com.tencent.mobileqq.ar.arengine.m;
import com.tencent.mobileqq.ar.arengine.o;
import com.tencent.mobileqq.ar.arengine.t;
import com.tencent.mobileqq.ar.arengine.v;
import com.tencent.mobileqq.ar.arengine.x;
import com.tencent.mobileqq.ar.arengine.y;
import com.tencent.mobileqq.ar.arengine.z;
import com.tencent.mobileqq.ar.f;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import x81.i;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQARSession extends a implements ARCloudControl.f, Camera.PreviewCallback, ARLocalControl.a, com.tencent.mobileqq.ar.ARRenderModel.b, ad.d, r.b {

    /* renamed from: n1, reason: collision with root package name */
    public static boolean f198445n1 = false;

    /* renamed from: o1, reason: collision with root package name */
    private static QQARSession f198446o1 = null;

    /* renamed from: p1, reason: collision with root package name */
    private static boolean f198447p1 = true;
    ArCloudConfigInfo M;
    int N;
    private volatile boolean S;
    private boolean Z0;

    /* renamed from: a1, reason: collision with root package name */
    private boolean f198449a1;

    /* renamed from: e1, reason: collision with root package name */
    private long f198457e1;

    /* renamed from: f1, reason: collision with root package name */
    private boolean f198459f1;

    /* renamed from: h1, reason: collision with root package name */
    private ARTransferDoorLogicManager f198463h1;
    private final boolean C = true;
    private final long D = 1;
    private final long E = 2179;
    public ARLocalControl F = null;
    public ArCloudConfigInfo G = null;
    public boolean H = true;
    public boolean I = false;
    public long J = 4096;
    ARScanStarFaceConfigInfo K = null;
    boolean L = false;
    private boolean P = false;
    private boolean Q = false;
    private boolean R = false;
    private ARCommonConfigInfo T = null;
    private ArConfigInfo U = null;
    private v V = null;
    private boolean W = false;
    private long X = 0;
    private long Y = 0;
    private boolean Z = false;

    /* renamed from: a0, reason: collision with root package name */
    private long f198448a0 = 0;

    /* renamed from: b0, reason: collision with root package name */
    private long f198450b0 = 0;

    /* renamed from: c0, reason: collision with root package name */
    private int f198452c0 = 5;

    /* renamed from: d0, reason: collision with root package name */
    private int f198454d0 = 5;

    /* renamed from: e0, reason: collision with root package name */
    private int f198456e0 = 5;

    /* renamed from: f0, reason: collision with root package name */
    private int f198458f0 = 5;

    /* renamed from: g0, reason: collision with root package name */
    private int f198460g0 = 5;

    /* renamed from: h0, reason: collision with root package name */
    private int f198462h0 = 5;

    /* renamed from: i0, reason: collision with root package name */
    private r f198464i0 = null;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f198466j0 = true;

    /* renamed from: k0, reason: collision with root package name */
    private ARNativeBridge f198468k0 = null;

    /* renamed from: l0, reason: collision with root package name */
    private d f198470l0 = null;

    /* renamed from: m0, reason: collision with root package name */
    private ARCloudControl f198472m0 = null;

    /* renamed from: n0, reason: collision with root package name */
    private ad f198474n0 = null;

    /* renamed from: o0, reason: collision with root package name */
    private ArrayList<ArCloudConfigInfo> f198475o0 = null;

    /* renamed from: p0, reason: collision with root package name */
    private HandlerThread f198476p0 = null;

    /* renamed from: q0, reason: collision with root package name */
    private Handler f198477q0 = null;

    /* renamed from: r0, reason: collision with root package name */
    private Object f198478r0 = new Object();

    /* renamed from: s0, reason: collision with root package name */
    private int f198479s0 = 0;

    /* renamed from: t0, reason: collision with root package name */
    private int f198480t0 = 0;

    /* renamed from: u0, reason: collision with root package name */
    private int f198481u0 = 0;

    /* renamed from: v0, reason: collision with root package name */
    private int f198482v0 = 0;

    /* renamed from: w0, reason: collision with root package name */
    private int f198483w0 = 17;

    /* renamed from: x0, reason: collision with root package name */
    private Runnable f198484x0 = null;

    /* renamed from: y0, reason: collision with root package name */
    private ArrayList<Runnable> f198485y0 = null;

    /* renamed from: z0, reason: collision with root package name */
    private z f198486z0 = null;
    private z A0 = null;
    private x B0 = null;
    private x C0 = null;
    private m D0 = null;
    private boolean E0 = false;
    private boolean F0 = false;
    private ac G0 = null;
    private boolean H0 = false;
    private volatile boolean I0 = false;
    private long J0 = 0;
    private ArCloudConfigInfo K0 = null;
    private ArCloudConfigInfo L0 = null;
    private long M0 = 0;
    private long N0 = 0;
    private long O0 = 0;
    private long P0 = 0;
    private boolean Q0 = false;
    private long R0 = 0;
    private long S0 = 0;
    private int T0 = 0;
    private long U0 = 0;
    private long V0 = 0;
    private int W0 = 0;
    private long X0 = 0;
    private long Y0 = 0;

    /* renamed from: b1, reason: collision with root package name */
    private boolean f198451b1 = true;

    /* renamed from: c1, reason: collision with root package name */
    private boolean f198453c1 = true;

    /* renamed from: d1, reason: collision with root package name */
    private boolean f198455d1 = true;

    /* renamed from: g1, reason: collision with root package name */
    private String f198461g1 = "0";

    /* renamed from: i1, reason: collision with root package name */
    private long f198465i1 = 0;

    /* renamed from: j1, reason: collision with root package name */
    private int f198467j1 = 0;

    /* renamed from: k1, reason: collision with root package name */
    private long f198469k1 = 0;

    /* renamed from: l1, reason: collision with root package name */
    private long f198471l1 = 0;

    /* renamed from: m1, reason: collision with root package name */
    private volatile int f198473m1 = 0;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.model.QQARSession$19, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass19 implements Runnable {
        final /* synthetic */ QQARSession this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.K0 != null && !this.this$0.K0.f()) {
                if (this.this$0.K0.n()) {
                    this.this$0.G1();
                }
                if (this.this$0.J0 == 1) {
                    this.this$0.r1(1L);
                    this.this$0.N0();
                } else if (this.this$0.J0 == 2) {
                    this.this$0.O0();
                } else if (this.this$0.J0 == 2048) {
                    this.this$0.Q0();
                }
                this.this$0.E1();
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.model.QQARSession$29, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass29 implements Runnable {
        final /* synthetic */ QQARSession this$0;

        @Override // java.lang.Runnable
        public void run() {
            QQARSession qQARSession = this.this$0;
            if (qQARSession.f198521d == 2 && qQARSession.Q) {
                QQARSession qQARSession2 = this.this$0;
                ARLocalControl aRLocalControl = qQARSession2.F;
                if (aRLocalControl != null) {
                    aRLocalControl.i(false, qQARSession2.f198481u0, this.this$0.f198482v0);
                }
                this.this$0.f198473m1 = 0;
                this.this$0.I = false;
            }
        }
    }

    public QQARSession() {
        this.f198522e = 1;
        f198447p1 = false;
        CameraProxy.v().N(this);
    }

    private boolean A0() {
        return false;
    }

    private boolean B1() {
        QLog.i("AREngine_QQARSession", 2, "stopCloudRecog.");
        ARCloudControl aRCloudControl = this.f198472m0;
        if (aRCloudControl != null) {
            aRCloudControl.P();
            return true;
        }
        return true;
    }

    public static boolean D0() {
        return f198447p1;
    }

    private boolean D1() {
        QLog.i("AREngine_QQARSession", 2, "stopLocalRecog.");
        ARLocalControl aRLocalControl = this.F;
        if (aRLocalControl != null) {
            aRLocalControl.u();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G1() {
        QLog.i("AREngine_QQARSession", 1, "stopSensorTrack.");
        this.Q0 = false;
        r rVar = this.f198464i0;
        if (rVar != null) {
            rVar.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H1() {
        r rVar = this.f198464i0;
        if (rVar != null) {
            rVar.j();
            this.f198464i0 = null;
        }
        ARLocalControl aRLocalControl = this.F;
        if (aRLocalControl != null) {
            aRLocalControl.v();
            this.F = null;
        }
        ARCloudControl aRCloudControl = this.f198472m0;
        if (aRCloudControl != null) {
            aRCloudControl.S();
            this.f198472m0 = null;
        }
        ad adVar = this.f198474n0;
        if (adVar != null) {
            adVar.w();
            this.f198474n0 = null;
        }
        if (this.f198470l0 != null) {
            this.f198470l0 = null;
        }
        this.f198468k0 = null;
        this.I = false;
        this.f198473m1 = 0;
        synchronized (this.f198478r0) {
            if (this.f198476p0 != null) {
                Handler handler = this.f198477q0;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                this.f198477q0 = null;
                this.f198476p0.quitSafely();
                this.f198476p0 = null;
                this.f198485y0 = null;
            }
        }
    }

    private void I0(final boolean z16, final ArCloudConfigInfo arCloudConfigInfo) {
        long j3;
        long currentTimeMillis = System.currentTimeMillis() - this.f198457e1;
        if (currentTimeMillis >= 1000) {
            j3 = 0;
        } else {
            j3 = 1000 - currentTimeMillis;
        }
        QLog.i("AREngine_QQARSession", 1, String.format("onARObjectClassifyDownloadComplete result=%s timeCost=%s timeDelay=%s", Boolean.valueOf(z16), Long.valueOf(currentTimeMillis), Long.valueOf(j3)));
        Z0(new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.16
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                if ((!z16 || !arCloudConfigInfo.a()) && QQARSession.this.P) {
                    QQARSession qQARSession = QQARSession.this;
                    if (qQARSession.f198521d == 2 && qQARSession.V != null) {
                        v vVar = QQARSession.this.V;
                        if (z16) {
                            i3 = 4;
                        } else {
                            i3 = 5;
                        }
                        vVar.h(1, i3);
                    }
                }
                if (QQARSession.this.f198484x0 != null) {
                    QLog.i("AREngine_QQARSession", 1, "processCloudObjectClassifyResult post task for handle timeout");
                    QQARSession.o1(QQARSession.this.f198484x0);
                    QQARSession.this.f198484x0 = null;
                }
                if (!z16) {
                    QLog.i("AREngine_QQARSession", 1, "onARObjectClassifyDownloadComplete. download resource failed.");
                    QLog.i("AREngine_QQARSession", 1, "onARObjectClassifyDownloadComplete end.");
                    QQARSession.this.O0();
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.16.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.qqStr(R.string.qmo), 1).show();
                        }
                    });
                    return;
                }
                QLog.i("AREngine_QQARSession", 1, "onARObjectClassifyDownloadComplete end. isNeedInternalRender = " + arCloudConfigInfo.j() + ", isNeedExternalRender = " + arCloudConfigInfo.g() + ", isNeedWaitUserOperation = " + arCloudConfigInfo.l());
                if (arCloudConfigInfo.a()) {
                    if (QQARSession.this.P) {
                        QQARSession qQARSession2 = QQARSession.this;
                        if (qQARSession2.f198521d == 2) {
                            qQARSession2.G = arCloudConfigInfo;
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (QQARSession.this.P) {
                    QQARSession qQARSession3 = QQARSession.this;
                    if (qQARSession3.f198521d == 2 && qQARSession3.V != null) {
                        try {
                            ReportController.o(null, "CliOper", "", "", "0X80081DE", "0X80081DE", 0, 0, arCloudConfigInfo.f197703m + "", "2", "", "");
                        } catch (Exception e16) {
                            QLog.i("AREngine_QQARSession", 1, "0X80081DE. error = " + e16.getMessage());
                        }
                        QQARSession.this.V.m(2L, new f(arCloudConfigInfo));
                    }
                }
                if (arCloudConfigInfo.f()) {
                    QQARSession.this.O0();
                    return;
                }
                if (arCloudConfigInfo.j()) {
                    ARVideoRecordUIControllerImpl.t().L(2);
                    if (arCloudConfigInfo.n()) {
                        QQARSession.this.z1(false);
                    }
                    QQARSession.this.x1(2L, arCloudConfigInfo, -1, 0.0f, 0.0f, 0.0f);
                    return;
                }
                if (!arCloudConfigInfo.l() && !arCloudConfigInfo.g()) {
                    QQARSession.this.O0();
                } else if (arCloudConfigInfo.g() && arCloudConfigInfo.n()) {
                    QQARSession.this.z1(true);
                }
            }
        }, j3);
        this.M = null;
    }

    private void K0(final boolean z16, final ArCloudConfigInfo arCloudConfigInfo) {
        long j3;
        long currentTimeMillis = System.currentTimeMillis() - this.f198457e1;
        if (currentTimeMillis >= 1000) {
            j3 = 0;
        } else {
            j3 = 1000 - currentTimeMillis;
        }
        QLog.i("AREngine_QQARSession", 1, String.format("onARSceneRecogDownloadCompleteInteral result=%s timeCost=%s timeDelay=%s", Boolean.valueOf(z16), Long.valueOf(currentTimeMillis), Long.valueOf(j3)));
        Z0(new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.18
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                if ((!z16 || !arCloudConfigInfo.a()) && QQARSession.this.P) {
                    QQARSession qQARSession = QQARSession.this;
                    if (qQARSession.f198521d == 2 && qQARSession.V != null) {
                        v vVar = QQARSession.this.V;
                        if (z16) {
                            i3 = 4;
                        } else {
                            i3 = 5;
                        }
                        vVar.h(1, i3);
                    }
                }
                if (QQARSession.this.f198484x0 != null) {
                    QLog.i("AREngine_QQARSession", 1, "processCloudSceneRecogResult post task for handle timeout");
                    QQARSession.o1(QQARSession.this.f198484x0);
                    QQARSession.this.f198484x0 = null;
                }
                if (!z16) {
                    QLog.i("AREngine_QQARSession", 1, "onARSceneRecogDownloadComplete. download resource failed.");
                    QLog.i("AREngine_QQARSession", 1, "onARSceneRecogDownloadComplete end.");
                    QQARSession.this.Q0();
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.qqStr(R.string.qmm), 1).show();
                        }
                    });
                    return;
                }
                QLog.i("AREngine_QQARSession", 1, "onARSceneRecogDownloadComplete end. isNeedInternalRender = " + arCloudConfigInfo.j() + ", isNeedExternalRender = " + arCloudConfigInfo.g() + ", isNeedWaitUserOperation = " + arCloudConfigInfo.l());
                if (arCloudConfigInfo.a()) {
                    if (QQARSession.this.P) {
                        QQARSession qQARSession2 = QQARSession.this;
                        if (qQARSession2.f198521d == 2) {
                            qQARSession2.G = arCloudConfigInfo;
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (QQARSession.this.P) {
                    QQARSession qQARSession3 = QQARSession.this;
                    if (qQARSession3.f198521d == 2 && qQARSession3.V != null) {
                        QQARSession.this.V.m(2048L, new f(arCloudConfigInfo));
                    }
                }
                if (arCloudConfigInfo.f()) {
                    QQARSession.this.Q0();
                    return;
                }
                if (arCloudConfigInfo.j()) {
                    ARVideoRecordUIControllerImpl.t().L(2);
                    if (arCloudConfigInfo.n()) {
                        QQARSession.this.z1(false);
                    }
                    QQARSession.this.x1(2048L, arCloudConfigInfo, -1, 0.0f, 0.0f, 0.0f);
                    return;
                }
                if (!arCloudConfigInfo.l() && !arCloudConfigInfo.g()) {
                    QQARSession.this.Q0();
                } else if (arCloudConfigInfo.g() && arCloudConfigInfo.n()) {
                    QQARSession.this.z1(true);
                }
            }
        }, j3);
        this.M = null;
    }

    private void M0() {
        QLog.i("AREngine_QQARSession", 1, "onProcessCloudFaceRecogResultComplete.");
        if (ARRecognition.j(this.T.recognitions, 1L)) {
            r1(1L);
        }
        P0();
        this.f198449a1 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0() {
        QLog.i("AREngine_QQARSession", 1, "onProcessCloudMarkerRecogResultComplete.");
        if (!ARRecognition.j(this.T.recognitions, 1L)) {
            U0(1L);
        }
        P0();
        this.Z0 = false;
    }

    private void P0() {
        QLog.i("AREngine_QQARSession", 1, "processCloudRecogResult end.");
        q1();
    }

    private void S0(int i3) {
        if (i3 == 0) {
            this.f198521d = 2;
        } else {
            this.f198521d = 5;
            this.Q = false;
        }
        QLog.d("AREngine_QQARSession", 1, "start end. mCurEngineState = " + this.f198521d);
        QLog.d("AREngine_QQARSession", 1, "onStartComplete. retCode = " + i3);
        v vVar = this.V;
        if (vVar != null) {
            vVar.c(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0() {
        QLog.d("AREngine_QQARSession", 1, "pauseCloudRecog.");
        ARCloudControl aRCloudControl = this.f198472m0;
        if (aRCloudControl != null) {
            aRCloudControl.A();
        }
    }

    private void V0(Runnable runnable) {
        synchronized (this.f198478r0) {
            Handler handler = this.f198477q0;
            if (handler != null) {
                handler.post(runnable);
                this.f198485y0.add(runnable);
            }
        }
    }

    private void W0(Runnable runnable, long j3) {
        synchronized (this.f198478r0) {
            Handler handler = this.f198477q0;
            if (handler != null) {
                handler.postDelayed(runnable, j3);
                this.f198485y0.add(runnable);
            }
        }
    }

    public static void X0(Runnable runnable) {
        if (w0() != null) {
            w0().V0(runnable);
        }
    }

    public static void Z0(Runnable runnable, long j3) {
        if (w0() != null) {
            w0().W0(runnable, j3);
        }
    }

    private void a1(o oVar) {
        QLog.i("AREngine_QQARSession", 1, "processCloudFaceRecogResult start.");
        this.F.g(oVar);
        r1(4L);
        this.f198449a1 = true;
        QLog.i("AREngine_QQARSession", 1, "processCloudFaceRecogResult end.");
    }

    private void b1(com.tencent.mobileqq.ar.arengine.d dVar) {
        QLog.i("AREngine_QQARSession", 1, "processCloudMarkerRecogResult start.");
        this.E0 = true;
        this.f198484x0 = new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.10
            @Override // java.lang.Runnable
            public void run() {
                QLog.i("AREngine_QQARSession", 1, "processCloudMarkerRecogResult. download resource timeout.");
                QQARSession.this.f198474n0.e();
                QQARSession.this.h(false, null);
            }
        };
        if (!this.f198474n0.h(dVar, this, false, this.f198461g1)) {
            QLog.i("AREngine_QQARSession", 1, "processCloudMarkerRecogResult end. download preprocess failed.");
            this.E0 = false;
            N0();
            return;
        }
        Z0(this.f198484x0, 30000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1(boolean z16) {
        v vVar;
        if (this.P && this.f198521d == 2 && (vVar = this.V) != null) {
            vVar.j(z16);
        }
    }

    private void d1(t tVar) {
        QLog.i("AREngine_QQARSession", 1, "processCloudSceneRecogResult start.");
        this.f198484x0 = new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.13
            @Override // java.lang.Runnable
            public void run() {
                QLog.i("AREngine_QQARSession", 1, "processCloudSceneRecogResult. download resource timeout.");
                QQARSession.this.f198474n0.e();
                QQARSession.this.q(false, null);
            }
        };
        if (!this.f198474n0.l(tVar, this, false, this.f198461g1)) {
            QLog.i("AREngine_QQARSession", 1, "processCloudSceneRecogResult end. download preprocess failed.");
            Q0();
        } else {
            QLog.i("AREngine_QQARSession", 1, "processCloudSceneRecogResult post task for handle timeout");
            Z0(this.f198484x0, 30000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1(com.tencent.mobileqq.ar.arengine.b bVar, ArLBSActivity arLBSActivity) {
        v vVar;
        if (this.P && this.f198521d == 2 && (vVar = this.V) != null) {
            vVar.q(bVar, arLBSActivity);
        }
    }

    private void f1(x xVar, x xVar2) {
        if (QLog.isColorLevel() && ARLocalFaceRecog.B) {
            QLog.d("AREngine_QQARSession", 2, "ARFaceTest processLocalFaceRecogResult. curLocalFaceRecogResult = " + xVar);
        }
        d dVar = this.f198470l0;
        if (dVar != null) {
            dVar.x(xVar.f198291b);
        }
        d dVar2 = this.f198470l0;
        if (dVar2 != null) {
            dVar2.requestRender();
        }
        L0(null, xVar);
    }

    private void g1(y yVar) {
        QLog.i("AREngine_QQARSession", 1, "processLocalGestureCircleRecogResult");
        ARTransferDoorLogicManager aRTransferDoorLogicManager = this.f198463h1;
        if (aRTransferDoorLogicManager != null) {
            aRTransferDoorLogicManager.x(yVar, this.f198481u0, this.f198482v0, this.f198479s0, this.f198480t0);
        }
    }

    private void h1(z zVar, z zVar2) {
        if (zVar.f198323c != 2) {
            if (zVar.f198330j.j()) {
                d dVar = this.f198470l0;
                if (dVar != null) {
                    dVar.x(zVar.f198322b);
                }
                d dVar2 = this.f198470l0;
                if (dVar2 != null) {
                    dVar2.requestRender();
                }
                this.O0 = 0L;
                this.P0 = 0L;
                if (zVar.f198323c == 0) {
                    x1(1L, zVar.f198330j, zVar.f198325e, zVar.f198326f, zVar.f198327g, zVar.f198328h);
                }
                G0(new com.tencent.mobileqq.ar.ARRenderModel.d(zVar.f198325e, zVar.f198326f, zVar.f198327g, zVar.f198328h, zVar.f198329i, this.F.j(this.f198479s0, this.f198480t0)));
                this.Z0 = true;
                return;
            }
            return;
        }
        if (zVar2 != null && zVar2.f198323c != 2) {
            this.O0 = System.currentTimeMillis();
        }
        this.P0 = System.currentTimeMillis();
        if (this.O0 > 0) {
            if (E0()) {
                G0(new com.tencent.mobileqq.ar.ARRenderModel.d(zVar.f198325e, 0.0f, 0.0f, 0.0f, new float[16], this.F.j(this.f198479s0, this.f198480t0)));
            }
            if (this.P0 - this.O0 > 1500) {
                this.O0 = 0L;
                ARVideoRecordUIControllerImpl.t().C(1);
                E1();
            }
        }
    }

    private void i1(ac acVar) {
        boolean z16;
        QLog.i("AREngine_QQARSession", 1, "processMIGCloudObjectClassifyResult start.");
        if (acVar.h() == -1) {
            R0();
            return;
        }
        if (acVar.h() == 1) {
            j1(acVar);
            return;
        }
        ac acVar2 = this.G0;
        if (acVar2 != null && acVar.k(acVar2)) {
            z16 = false;
        } else {
            z16 = true;
        }
        ARCloudControl aRCloudControl = this.f198472m0;
        if (aRCloudControl != null && z16) {
            aRCloudControl.K(true);
            QLog.i("AREngine_QQARSession", 1, "processMIGCloudObjectClassifyResultInternal setCompareSameSceneFlag.");
        } else {
            j1(acVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1(ac acVar) {
        QLog.i("AREngine_QQARSession", 1, "processMIGCloudObjectClassifyResultInternal start.");
        if (acVar.h() == 1) {
            ReportController.o(null, "dc00898", "", "", "0X8008999", "0X8008999", 0, 0, "1", "", "", "");
            if (this.G0 != null) {
                z0(false);
            }
            this.f198484x0 = new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.12
                @Override // java.lang.Runnable
                public void run() {
                    QLog.i("AREngine_QQARSession", 1, "processMIGCloudObjectClassifyResult. download resource timeout.");
                    QQARSession.this.f198474n0.e();
                    QQARSession.this.A(false, null);
                }
            };
            if (!this.f198474n0.j(acVar, this, false, this.f198461g1)) {
                QLog.i("AREngine_QQARSession", 1, "processMIGCloudObjectClassifyResult end. download preprocess failed.");
                R0();
                return;
            } else {
                QLog.i("AREngine_QQARSession", 1, "processMIGCloudObjectClassifyResult post task for handle timeout");
                Z0(this.f198484x0, 30000L);
                return;
            }
        }
        ReportController.o(null, "dc00898", "", "", "0X8008999", "0X8008999", 0, 0, "0", "", "", "");
        ac.a e16 = acVar.e();
        if (e16 != null) {
            this.G0 = acVar;
            L0(null, e16);
            q1();
        }
        if (e16 == null || !e16.f198003b) {
            R0();
        }
    }

    private void k1(g gVar) {
        QLog.i("AREngine_QQARSession", 1, "processYouTuCloudObjectClassifyResult start.");
        this.f198484x0 = new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.11
            @Override // java.lang.Runnable
            public void run() {
                QLog.i("AREngine_QQARSession", 1, "processCloudObjectClassifyResult. download resource timeout.");
                QQARSession.this.f198474n0.e();
                QQARSession.this.A(false, null);
            }
        };
        if (!this.f198474n0.j(gVar, this, false, this.f198461g1)) {
            QLog.i("AREngine_QQARSession", 1, "processYouTuCloudObjectClassifyResult end. download preprocess failed.");
            O0();
        } else {
            QLog.i("AREngine_QQARSession", 1, "processYouTuCloudObjectClassifyResult post task for handle timeout");
            Z0(this.f198484x0, 30000L);
        }
    }

    private void l1(Runnable runnable) {
        synchronized (this.f198478r0) {
            if (this.f198477q0 != null && this.f198485y0 != null) {
                int i3 = 0;
                while (true) {
                    if (i3 >= this.f198485y0.size()) {
                        break;
                    }
                    if (runnable.equals(this.f198485y0.get(i3))) {
                        QLog.i("AREngine_QQARSession", 1, "removeTask. task = " + this.f198485y0.get(i3));
                        this.f198485y0.remove(i3);
                        this.f198477q0.removeCallbacks(runnable);
                        break;
                    }
                    i3++;
                }
            }
        }
    }

    private void m1() {
        synchronized (this.f198478r0) {
            if (this.f198477q0 != null && this.f198485y0 != null) {
                QLog.i("AREngine_QQARSession", 1, "removeAllTask. task count = " + this.f198485y0.size());
                for (int i3 = 0; i3 < this.f198485y0.size(); i3++) {
                    this.f198477q0.removeCallbacks(this.f198485y0.get(i3));
                }
                this.f198485y0.clear();
            }
        }
    }

    public static void n1() {
        if (w0() != null) {
            w0().m1();
        }
    }

    public static void o1(Runnable runnable) {
        if (w0() != null) {
            w0().l1(runnable);
        }
    }

    private void p1() {
        if (this.f198473m1 != 1) {
            return;
        }
        ARLocalControl aRLocalControl = this.F;
        if (aRLocalControl != null) {
            aRLocalControl.r();
        }
        ARTransferDoorLogicManager aRTransferDoorLogicManager = this.f198463h1;
        if (aRTransferDoorLogicManager != null) {
            aRTransferDoorLogicManager.y();
        }
    }

    private void q1() {
        QLog.d("AREngine_QQARSession", 1, "resumeCloudRecog.");
        if (this.W0 == 0) {
            this.X0 = 0L;
        }
        this.D0 = null;
        this.E0 = false;
        ARCloudControl aRCloudControl = this.f198472m0;
        if (aRCloudControl != null) {
            aRCloudControl.H();
        }
    }

    public static QQARSession s0() {
        if (f198446o1 == null) {
            f198446o1 = new QQARSession();
        }
        return f198446o1;
    }

    public static void t0() {
        f198446o1 = null;
        f198447p1 = true;
    }

    private boolean t1() {
        QLog.i("AREngine_QQARSession", 2, "startCloudRecog.");
        ARCloudControl aRCloudControl = this.f198472m0;
        if (aRCloudControl != null) {
            aRCloudControl.L(this.f198481u0, this.f198482v0, this.f198483w0);
            this.f198472m0.N();
            return true;
        }
        return false;
    }

    public static e v0(ArCloudConfigInfo arCloudConfigInfo, boolean z16, long j3, int i3, float f16, float f17, float f18) {
        String str;
        String str2;
        String str3;
        ArCloudConfigInfo.b bVar;
        ArCloudConfigInfo.b e16;
        int i16;
        String str4;
        int i17;
        ArCloudConfigInfo.b bVar2;
        String str5;
        long j16;
        if (arCloudConfigInfo == null) {
            return null;
        }
        int i18 = arCloudConfigInfo.f197702i;
        if (i18 == 0) {
            String e17 = af.e(arCloudConfigInfo);
            String c16 = af.c(arCloudConfigInfo);
            String d16 = af.d(arCloudConfigInfo);
            if (!TextUtils.isEmpty(e17) && new File(e17).exists() && !TextUtils.isEmpty(c16) && new File(c16).exists()) {
                k kVar = new k(arCloudConfigInfo.E.f198409d, arCloudConfigInfo.f197702i, arCloudConfigInfo.f197701h, c16, e17, d16, com.tencent.mobileqq.ar.g.d(arCloudConfigInfo.F.C), i3, f16, f17, f18);
                kVar.f197227c = j3;
                QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo. key = " + kVar.f197225a + ", arType = " + kVar.f197226b + ", trackMode = " + kVar.f197228d + ", resPath = " + kVar.f197284j + ", luaPath = " + kVar.f197283i + ", musicPath = " + kVar.f197285k + ", recogType = " + j3);
                return kVar;
            }
            QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo failed. resource path empty or file not exist.");
            return null;
        }
        if (i18 == 2 || i18 == 3) {
            if (!VersionUtils.isIceScreamSandwich()) {
                QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo failed. NOT IceScreamSandwich.");
                return null;
            }
            if (com.tencent.mobileqq.ar.g.b()) {
                QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo failed. isRubbishDeviceNeedsSoftwareDecode.");
                return null;
            }
            String i19 = af.i(arCloudConfigInfo);
            if (!TextUtils.isEmpty(i19) && new File(i19).exists()) {
                f fVar = new f(arCloudConfigInfo);
                int c17 = com.tencent.mobileqq.ar.g.c(fVar);
                int i26 = c17 == 0 ? Integer.MAX_VALUE : c17;
                Pair<Integer, i> g16 = com.tencent.mobileqq.ar.g.g(fVar);
                int intValue = g16.first.intValue();
                i iVar = g16.second;
                if (arCloudConfigInfo.f()) {
                    str = ", videoPlayCount = ";
                    str2 = ", recogType = ";
                    str3 = "AREngine_QQARSession";
                    bVar = null;
                } else {
                    if (z16 && (j3 == 2 || j3 == 2048)) {
                        str3 = "AREngine_QQARSession";
                    } else {
                        if (j3 == 1) {
                            str3 = "AREngine_QQARSession";
                            if (arCloudConfigInfo.f197701h != 2) {
                                str = ", videoPlayCount = ";
                                str2 = ", recogType = ";
                            }
                        } else {
                            str = ", videoPlayCount = ";
                            str2 = ", recogType = ";
                            str3 = "AREngine_QQARSession";
                        }
                        e16 = com.tencent.mobileqq.ar.g.e(arCloudConfigInfo.D.get(0).f198429h, UniformGLRenderManagerImpl.U, UniformGLRenderManagerImpl.V);
                        bVar = e16;
                    }
                    str2 = ", recogType = ";
                    str = ", videoPlayCount = ";
                    e16 = com.tencent.mobileqq.ar.g.f(arCloudConfigInfo.D.get(0).f198429h, UniformGLRenderManagerImpl.U, UniformGLRenderManagerImpl.V, arCloudConfigInfo.n());
                    bVar = e16;
                }
                p pVar = new p(arCloudConfigInfo.E.f198409d, arCloudConfigInfo.f197702i, arCloudConfigInfo.f197701h, intValue, iVar, bVar, i19, i26, i3, f16, f17, f18);
                pVar.f197227c = j3;
                QLog.i(str3, 1, "getARRenderResourceInfo. key = " + pVar.f197225a + ", arType = " + pVar.f197226b + ", trackMode = " + pVar.f197228d + ", renderType = " + pVar.f197320i + ", keyingParams = " + pVar.f197323l + ", videoPath = " + pVar.f197321j + ", layout = " + pVar.f197324m + str + i26 + str2 + j3);
                return pVar;
            }
            QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo failed. video path empty or file not exist.");
            return null;
        }
        if (i18 != 4) {
            if (i18 == 5) {
                if (com.tencent.mobileqq.ar.g.b()) {
                    Iterator<ArVideoResourceInfo> it = arCloudConfigInfo.D.iterator();
                    while (it.hasNext()) {
                        ArVideoResourceInfo next = it.next();
                        if (next != null && ((i16 = next.D) == 2 || i16 == 3)) {
                            QLog.i("AREngine_QQARSession", 1, "getMultiFragmentAnimARResourceInfo failed. isRubbishDeviceNeedsSoftwareDecode.");
                            return null;
                        }
                    }
                }
                com.tencent.mobileqq.ar.ARRenderModel.o oVar = new com.tencent.mobileqq.ar.ARRenderModel.o(arCloudConfigInfo.f197703m, arCloudConfigInfo.f197702i, arCloudConfigInfo.f197701h, arCloudConfigInfo, i3, f16, f17, f18);
                oVar.f197227c = j3;
                return oVar;
            }
            if (i18 != 100) {
                if (i18 == 7) {
                    return new l(arCloudConfigInfo.f197703m, arCloudConfigInfo.f197702i, arCloudConfigInfo.f197701h, i3, f16, f17, f18, af.c(arCloudConfigInfo), af.e(arCloudConfigInfo));
                }
                return null;
            }
            String h16 = af.h(arCloudConfigInfo);
            if (!TextUtils.isEmpty(h16) && new File(h16).exists()) {
                n nVar = new n(arCloudConfigInfo.E.f198409d, arCloudConfigInfo.f197702i, 1, "", h16, "", arCloudConfigInfo, i3, f16, f17, f18);
                QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo. key = " + nVar.f197225a + ", resType = " + nVar.f197226b + ", resPath = " + nVar.f197317k + ", luaPath = " + nVar.f197316j + ", musicPath = " + nVar.f197318l);
                return nVar;
            }
            QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo failed. resource path empty or file not exist.");
            return null;
        }
        f fVar2 = new f(arCloudConfigInfo);
        int c18 = com.tencent.mobileqq.ar.g.c(fVar2);
        if (c18 == 0) {
            c18 = Integer.MAX_VALUE;
        }
        Pair<Integer, i> g17 = com.tencent.mobileqq.ar.g.g(fVar2);
        int intValue2 = g17.first.intValue();
        i iVar2 = g17.second;
        if (arCloudConfigInfo.f()) {
            str4 = "AREngine_QQARSession";
            i17 = 0;
            bVar2 = null;
        } else if ((z16 && (j3 == 2 || j3 == 2048)) || (j3 == 1 && arCloudConfigInfo.f197701h == 2)) {
            str4 = "AREngine_QQARSession";
            bVar2 = com.tencent.mobileqq.ar.g.f(arCloudConfigInfo.D.get(0).f198429h, UniformGLRenderManagerImpl.U, UniformGLRenderManagerImpl.V, arCloudConfigInfo.n());
            i17 = 0;
        } else {
            str4 = "AREngine_QQARSession";
            i17 = 0;
            bVar2 = com.tencent.mobileqq.ar.g.e(arCloudConfigInfo.D.get(0).f198429h, UniformGLRenderManagerImpl.U, UniformGLRenderManagerImpl.V);
        }
        Pair<Long, String> d17 = y81.a.d(arCloudConfigInfo.D.get(i17).f198427e + "|" + arCloudConfigInfo.D.get(0).E);
        if (d17 != null) {
            j16 = d17.first.longValue();
            str5 = d17.second;
        } else {
            str5 = "";
            j16 = 0;
        }
        q qVar = new q(arCloudConfigInfo.E.f198409d, arCloudConfigInfo.f197702i, arCloudConfigInfo.f197701h, intValue2, iVar2, bVar2, str5, j16, com.tencent.mobileqq.ar.g.b(), c18, i3, f16, f17, f18);
        qVar.f197227c = j3;
        QLog.i(str4, 1, "getARRenderResourceInfo. key = " + qVar.f197225a + ", arType = " + qVar.f197226b + ", trackMode = " + qVar.f197228d + ", renderType = " + qVar.f197325i + ", keyingParams = " + qVar.f197330n + ", videoUrl = " + qVar.f197326j + ", videoSize = " + qVar.f197327k + ", layout = " + qVar.f197331o + ", isSoftDecode = " + qVar.f197328l + ", videoPlayCount = " + c18 + ", recogType = " + j3);
        return qVar;
    }

    private boolean v1() {
        QLog.i("AREngine_QQARSession", 2, "startLocalRecog.");
        ARLocalControl aRLocalControl = this.F;
        if (aRLocalControl == null || !aRLocalControl.k(this.f198525i, this.f198448a0, this.f198481u0, this.f198482v0, this.U, this.f198475o0, this.K, this)) {
            return false;
        }
        return this.F.t();
    }

    public static QQARSession w0() {
        return f198446o1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x1(long j3, ArCloudConfigInfo arCloudConfigInfo, int i3, float f16, float f17, float f18) {
        e v06 = v0(arCloudConfigInfo, false, j3, i3, f16, f17, f18);
        if (v06 == null) {
            return false;
        }
        QLog.d("AREngine_QQARSession", 1, "startModelRender. recogType = " + j3 + ", key = " + v06.f197225a + ", resType = " + v06.f197226b);
        if (this.f198470l0 != null) {
            this.J0 = j3;
            this.K0 = arCloudConfigInfo;
            e v07 = v0(this.L0, false, j3, i3, f16, f17, f18);
            if (v07 != null && v07.f197225a.equalsIgnoreCase(v06.f197225a)) {
                return true;
            }
            if (v07 != null && !v07.f197225a.equalsIgnoreCase(v06.f197225a)) {
                this.f198470l0.q();
                this.f198470l0.u(v06);
            } else {
                this.f198470l0.u(v06);
            }
            d dVar = this.f198470l0;
            if (dVar != null) {
                dVar.requestRender();
            }
            CameraProxy.v().p();
            if (this.P && this.f198521d == 2 && this.V != null) {
                if (!arCloudConfigInfo.e() && arCloudConfigInfo.j()) {
                    ARVideoRecordUIControllerImpl.t().L(3);
                }
                this.V.i(j3, true, new f(arCloudConfigInfo));
            }
            this.L0 = this.K0;
            if (this.T0 == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.V0 = currentTimeMillis;
                this.T0 = (int) (currentTimeMillis - this.U0);
            }
            if (this.W0 == 0 && this.D0 != null) {
                long currentTimeMillis2 = System.currentTimeMillis();
                this.Y0 = currentTimeMillis2;
                this.W0 = (int) (currentTimeMillis2 - this.X0);
            }
        }
        return true;
    }

    private boolean y1() {
        QLog.i("AREngine_QQARSession", 2, "startRenderManager.");
        d dVar = this.f198470l0;
        if (dVar == null) {
            return false;
        }
        dVar.r(0, this.f198468k0);
        this.f198470l0.r(8, this.f198463h1);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(boolean z16) {
        this.G0 = null;
        ac.a aVar = ac.a.f198002g;
        aVar.f198004c = z16;
        L0(null, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z1(boolean z16) {
        QLog.i("AREngine_QQARSession", 1, "startSensorTrack. isForExternalTrack = " + z16);
        this.Q0 = z16;
        r rVar = this.f198464i0;
        if (rVar != null) {
            rVar.f();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.ar.arengine.ad.d
    public void A(boolean z16, ArCloudConfigInfo arCloudConfigInfo) {
        ArWebInfo arWebInfo;
        if (z16 && arCloudConfigInfo != null && (arWebInfo = arCloudConfigInfo.H) != null && arWebInfo.f198433e && arWebInfo.f198432d && !TextUtils.isEmpty(arWebInfo.f198434f) && !arCloudConfigInfo.j()) {
            this.V.r(0, arCloudConfigInfo.H.f198434f);
            this.M = arCloudConfigInfo;
            this.N = 2;
            return;
        }
        I0(z16, arCloudConfigInfo);
    }

    public void A1() {
        QLog.i("AREngine_QQARSession", 1, "stop start. mCurEngineState = " + this.f198521d);
        if (this.f198521d == 5) {
            return;
        }
        this.f198521d = 4;
        this.L = false;
        Runnable runnable = this.f198484x0;
        if (runnable != null) {
            o1(runnable);
            this.f198484x0 = null;
        }
        n1();
        X0(new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.3
            @Override // java.lang.Runnable
            public void run() {
                QQARSession.this.C1();
                QLog.i("AREngine_QQARSession", 1, "stop end. mCurEngineState = " + QQARSession.this.f198521d);
            }
        });
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.b
    public void B(String str, final int i3) {
        QLog.i("AREngine_QQARSession", 1, "onRenderManagerCallback. onARAnimationPlayError. key = " + str + ", remainPlayCount = " + i3);
        X0(new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.24
            @Override // java.lang.Runnable
            public void run() {
                if (!QQARSession.this.K0.f()) {
                    if (QQARSession.this.K0.n()) {
                        QQARSession.this.G1();
                    }
                    if (QQARSession.this.J0 == 1) {
                        QQARSession.this.r1(1L);
                        QQARSession.this.N0();
                    } else if (QQARSession.this.J0 == 2) {
                        QQARSession.this.O0();
                    } else if (QQARSession.this.J0 == 2048) {
                        QQARSession.this.Q0();
                    }
                    QQARSession.this.E1();
                }
                if (QQARSession.this.P) {
                    QQARSession qQARSession = QQARSession.this;
                    if (qQARSession.f198521d == 2 && qQARSession.V != null) {
                        QQARSession.this.V.n(3, new f(QQARSession.this.K0), i3);
                    }
                }
            }
        });
    }

    public boolean B0() {
        return this.Q;
    }

    @Override // com.tencent.mobileqq.ar.arengine.ARCloudControl.f
    public void C() {
        QLog.i("AREngine_QQARSession", 1, "onARCloudUploadStart.");
        this.f198467j1++;
    }

    public boolean C0() {
        return this.P;
    }

    public boolean C1() {
        QLog.i("AREngine_QQARSession", 1, "stopInternal.");
        this.L = true;
        G1();
        D1();
        B1();
        this.f198486z0 = null;
        this.A0 = null;
        this.B0 = null;
        this.C0 = null;
        this.D0 = null;
        this.E0 = false;
        this.J0 = 0L;
        this.K0 = null;
        this.L0 = null;
        this.M0 = 0L;
        this.N0 = 0L;
        this.O0 = 0L;
        this.P0 = 0L;
        this.Q0 = false;
        this.L = false;
        this.R0 = 0L;
        this.S0 = 0L;
        return true;
    }

    @Override // com.tencent.mobileqq.ar.arengine.ARLocalControl.a
    public void D(long j3, ab abVar) {
        if (this.f198473m1 == 1) {
            if (abVar.f197989a != 4096) {
                return;
            }
            g1((y) abVar);
        } else {
            aa aaVar = new aa();
            if ((1 & j3) != 0) {
                aaVar.f197987b = (z) abVar;
            }
            if ((j3 & 4) != 0) {
                aaVar.f197988c = (x) abVar;
            }
            J0(aaVar, null);
        }
    }

    @Override // com.tencent.mobileqq.ar.arengine.ARCloudControl.f
    public void E(boolean z16) {
        QLog.i("AREngine_QQARSession", 1, "onARCloudPretreatComplete. result = " + z16);
        if (z16 && this.f198453c1) {
            this.f198453c1 = false;
            ReportController.o(null, "dc00898", "", "", "0X80085AD", "0X80085AD", 0, 0, "", "", "", "");
        }
    }

    public boolean E0() {
        if (this.K0 != null) {
            return true;
        }
        return false;
    }

    public void E1() {
        int i3;
        QLog.d("AREngine_QQARSession", 1, "stopModelRender.");
        d dVar = this.f198470l0;
        if (dVar != null && this.K0 != null) {
            dVar.q();
            if (CameraProxy.v().B()) {
                CameraProxy.v().n(this.f198479s0, this.f198480t0);
            }
            if (this.P && this.V != null && ((i3 = this.f198521d) == 2 || i3 == 4)) {
                this.V.i(this.J0, false, new f(this.K0));
            }
        }
        this.J0 = 0L;
        this.K0 = null;
        this.L0 = null;
    }

    @Override // com.tencent.mobileqq.ar.arengine.ARCloudControl.f
    public long F() {
        return this.T.mARCloudUploadDelayTime;
    }

    public void F0() {
        ArWebInfo arWebInfo;
        QLog.d("AREngine_QQARSession", 1, "engine notifyRenderReady ");
        ArCloudConfigInfo arCloudConfigInfo = this.M;
        if (arCloudConfigInfo != null && (arWebInfo = arCloudConfigInfo.H) != null && arWebInfo.f198433e && arWebInfo.f198432d && !TextUtils.isEmpty(arWebInfo.f198434f)) {
            int i3 = this.N;
            if (i3 == 1) {
                H0(true, this.M);
            } else if (i3 == 2) {
                I0(true, this.M);
            }
        }
    }

    public void F1() {
        d dVar;
        QLog.d("AREngine_QQARSession", 1, "stopModelRenderOnly.");
        if (this.P && this.f198521d == 2 && (dVar = this.f198470l0) != null) {
            dVar.q();
        }
    }

    public void G0(com.tencent.mobileqq.ar.ARRenderModel.d dVar) {
        L0(dVar, null);
    }

    @Override // com.tencent.mobileqq.ar.model.a
    public void H(Context context, AppInterface appInterface) {
        super.H(context, appInterface);
        System.currentTimeMillis();
        QLog.d("AREngine_QQARSession", 1, String.format("init context=%s appInterface=%s mIsInited=%s", context, appInterface, Boolean.valueOf(this.P)));
        if (this.P) {
            return;
        }
        this.f198464i0 = new r();
        synchronized (this.f198478r0) {
            if (this.f198476p0 == null) {
                HandlerThread newFreeHandlerThread = ThreadManagerV2.newFreeHandlerThread("AREngineThread", 0);
                this.f198476p0 = newFreeHandlerThread;
                newFreeHandlerThread.start();
                this.f198477q0 = new Handler(this.f198476p0.getLooper());
                this.f198485y0 = new ArrayList<>();
            }
        }
        this.P = true;
    }

    public void H0(final boolean z16, final ArCloudConfigInfo arCloudConfigInfo) {
        long j3;
        long currentTimeMillis = System.currentTimeMillis() - this.f198457e1;
        if (currentTimeMillis >= 1000) {
            j3 = 0;
        } else {
            j3 = 1000 - currentTimeMillis;
        }
        QLog.i("AREngine_QQARSession", 1, String.format("onARMarkerAllDownloadCompleteInternal result=%s timeCost=%s timeDelay=%s", Boolean.valueOf(z16), Long.valueOf(currentTimeMillis), Long.valueOf(j3)));
        Z0(new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.14
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                if ((!z16 || !arCloudConfigInfo.e()) && ((!z16 || !arCloudConfigInfo.a()) && QQARSession.this.P)) {
                    QQARSession qQARSession = QQARSession.this;
                    if (qQARSession.f198521d == 2 && qQARSession.V != null) {
                        v vVar = QQARSession.this.V;
                        if (z16) {
                            i3 = 4;
                        } else {
                            i3 = 5;
                        }
                        vVar.h(1, i3);
                    }
                }
                if (QQARSession.this.f198484x0 != null) {
                    QQARSession.o1(QQARSession.this.f198484x0);
                    QQARSession.this.f198484x0 = null;
                }
                if (!z16) {
                    QLog.i("AREngine_QQARSession", 1, "onARMarkerAllDownloadComplete. download resource failed.");
                    QLog.i("AREngine_QQARSession", 1, "processCloudMarkerRecogResult end.");
                    QQARSession.this.E0 = false;
                    QQARSession.this.N0();
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.14.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.qqStr(R.string.qmn), 1).show();
                        }
                    });
                    return;
                }
                if (arCloudConfigInfo.e()) {
                    if (QQARSession.this.P) {
                        QQARSession qQARSession2 = QQARSession.this;
                        if (qQARSession2.f198521d == 2 && qQARSession2.V != null) {
                            v vVar2 = QQARSession.this.V;
                            ArCloudConfigInfo arCloudConfigInfo2 = arCloudConfigInfo;
                            vVar2.e(arCloudConfigInfo2, arCloudConfigInfo2, 10, 0, null);
                        }
                    }
                } else if (arCloudConfigInfo.a()) {
                    if (QQARSession.this.P) {
                        QQARSession qQARSession3 = QQARSession.this;
                        if (qQARSession3.f198521d == 2) {
                            qQARSession3.G = arCloudConfigInfo;
                        }
                    }
                } else {
                    ArCloudConfigInfo arCloudConfigInfo3 = arCloudConfigInfo;
                    ArFeatureInfo arFeatureInfo = arCloudConfigInfo3.E;
                    String str = arFeatureInfo.f198409d;
                    String str2 = arFeatureInfo.f198412h;
                    if (!arCloudConfigInfo3.f() && QQARSession.this.S) {
                        if (QQARSession.this.P) {
                            QQARSession qQARSession4 = QQARSession.this;
                            if (qQARSession4.f198521d == 2 && qQARSession4.V != null) {
                                QQARSession.this.V.m(1L, new f(arCloudConfigInfo));
                            }
                        }
                        if (arCloudConfigInfo.j()) {
                            if (arCloudConfigInfo.j()) {
                                ARVideoRecordUIControllerImpl.t().L(1);
                            }
                            QQARSession.this.U0(1L);
                            QQARSession.this.x1(1L, arCloudConfigInfo, 0, 0.0f, 0.0f, 0.0f);
                            if (arCloudConfigInfo.n()) {
                                QQARSession.this.z1(false);
                            }
                        } else if (!arCloudConfigInfo.l() && !arCloudConfigInfo.g()) {
                            QQARSession.this.N0();
                        } else if (arCloudConfigInfo.g()) {
                            QQARSession.this.U0(1L);
                            if (arCloudConfigInfo.n()) {
                                QQARSession.this.z1(true);
                            }
                        }
                    }
                    ARLocalControl aRLocalControl = QQARSession.this.F;
                    if (aRLocalControl != null) {
                        aRLocalControl.h(str, str2, arCloudConfigInfo);
                        QQARSession.this.M0 = 0L;
                        QQARSession.this.N0 = 0L;
                    }
                    QLog.i("AREngine_QQARSession", 1, "processCloudMarkerRecogResult end. isNeedInternalRender = " + arCloudConfigInfo.j() + ", isNeedExternalRender = " + arCloudConfigInfo.g() + ", isNeedWaitUserOperation = " + arCloudConfigInfo.l());
                }
                QQARSession.this.E0 = false;
                QQARSession.this.M = null;
            }
        }, j3);
    }

    @Override // com.tencent.mobileqq.ar.model.a
    public void I() {
        boolean z16;
        v vVar;
        QLog.i("AREngine_QQARSession", 1, "ARengine status  pause. now ");
        if (this.P && this.f198521d == 2) {
            G1();
            E1();
            T0();
            ARLocalControl aRLocalControl = this.F;
            if (aRLocalControl != null && !aRLocalControl.m(4L)) {
                z16 = true;
            } else {
                z16 = false;
            }
            U0(5L);
            if (z16 && (vVar = this.V) != null) {
                vVar.d(z16);
            }
            this.I0 = true;
            if (this.G0 != null) {
                z0(true);
            }
            this.f198449a1 = false;
            p1();
            if (this.F != null && this.f198473m1 == 1) {
                U0(4096L);
                this.F.i(false, this.f198481u0, this.f198482v0);
            }
            ad adVar = this.f198474n0;
            if (adVar != null) {
                adVar.e();
            }
            this.S = false;
            this.f198521d = 3;
            this.f198470l0.D(null);
        }
    }

    @Override // com.tencent.mobileqq.ar.model.a
    public void J() {
        int i3;
        QLog.d("AREngine_QQARSession", 1, "ARengine status resume now start. + mCurrentSessionStatus:=" + this.f198521d);
        if (this.P && (i3 = this.f198521d) != 0 && i3 != 4 && i3 != 5 && i3 != 2) {
            this.f198470l0.D(this);
            z1(this.Q0);
            this.f198486z0 = null;
            this.A0 = null;
            this.B0 = null;
            this.C0 = null;
            this.D0 = null;
            this.E0 = false;
            this.I0 = false;
            this.G0 = null;
            this.H0 = false;
            this.J0 = 0L;
            this.K0 = null;
            this.L0 = null;
            this.M0 = 0L;
            this.N0 = 0L;
            this.O0 = 0L;
            this.P0 = 0L;
            this.Q0 = false;
            this.L = false;
            this.R0 = 0L;
            this.S0 = 0L;
            if (!this.I && this.f198473m1 != 1) {
                q1();
                if (!ARRecognition.j(this.T.recognitions, 1L)) {
                    U0(5L);
                } else {
                    U0(4L);
                    r1(1L);
                }
                this.S = true;
                this.f198521d = 2;
                QLog.d("AREngine_QQARSession", 1, "ARengine status resume now end.");
                return;
            }
            r1(4096L);
            this.F.i(true, this.f198481u0, this.f198482v0);
            this.S = true;
            this.f198521d = 2;
        }
    }

    public synchronized void J0(aa aaVar, m mVar) {
        boolean z16;
        long j3;
        z zVar;
        v vVar;
        if (this.P && this.f198521d == 2) {
            if (aaVar != null) {
                z zVar2 = aaVar.f197987b;
                if (zVar2 != null) {
                    this.f198486z0 = zVar2;
                }
                x xVar = aaVar.f197988c;
                if (xVar != null) {
                    this.B0 = xVar;
                }
            }
            if (mVar != null) {
                this.D0 = mVar;
            }
            long j16 = this.f198448a0;
            if (j16 != 0 && this.f198450b0 != 0) {
                if (aaVar != null && (zVar = aaVar.f197987b) != null) {
                    if (zVar.f198323c == 0) {
                        try {
                            ReportController.o(null, "CliOper", "", "", "0X80081DE", "0X80081DE", 0, 0, zVar.f198330j.f197703m, "1", "", "");
                        } catch (Exception e16) {
                            QLog.i("AREngine_QQARSession", 1, "0X80081DE. error = " + e16.getMessage());
                        }
                        if (ARRecognition.j(this.T.recognitions, 1L)) {
                            T0();
                        }
                        ArCloudConfigInfo arCloudConfigInfo = aaVar.f197987b.f198330j;
                        QLog.i("AREngine_QQARSession", 1, "localRecogResult. isNeedInternalRender = " + arCloudConfigInfo.j() + ", isNeedExternalRender = " + arCloudConfigInfo.g() + ", isNeedWaitUserOperation = " + arCloudConfigInfo.l());
                        if (this.P && this.f198521d == 2 && (vVar = this.V) != null) {
                            vVar.m(1L, new f(arCloudConfigInfo));
                        }
                        if (!arCloudConfigInfo.f()) {
                            if (arCloudConfigInfo.j()) {
                                U0(1L);
                                z zVar3 = aaVar.f197987b;
                                x1(1L, arCloudConfigInfo, zVar3.f198325e, zVar3.f198326f, zVar3.f198327g, zVar3.f198328h);
                                if (arCloudConfigInfo.n()) {
                                    z1(false);
                                }
                            } else {
                                if (!arCloudConfigInfo.l() && !arCloudConfigInfo.g()) {
                                    N0();
                                }
                                if (arCloudConfigInfo.g()) {
                                    U0(1L);
                                    if (arCloudConfigInfo.n()) {
                                        z1(true);
                                    }
                                }
                            }
                        } else if (!arCloudConfigInfo.j() && ((arCloudConfigInfo.l() || arCloudConfigInfo.g()) && arCloudConfigInfo.g())) {
                            U0(1L);
                            if (arCloudConfigInfo.n()) {
                                z1(true);
                            }
                        }
                    }
                    z zVar4 = aaVar.f197987b;
                    if (zVar4.f198323c == 2 || zVar4.f198330j.f()) {
                        h1(aaVar.f197987b, this.A0);
                        if (aaVar.f197987b.f198323c != 2) {
                            this.M0 = 0L;
                            this.N0 = 0L;
                        } else if (this.D0 != null && this.E0) {
                            this.M0 = 0L;
                            this.N0 = 0L;
                        } else {
                            if (this.M0 == 0) {
                                this.M0 = System.currentTimeMillis();
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            this.N0 = currentTimeMillis;
                            long j17 = this.M0;
                            if (j17 > 0 && currentTimeMillis - j17 > 1500) {
                                this.M0 = -1L;
                                N0();
                            }
                        }
                    }
                } else if (aaVar != null && aaVar.f197988c != null) {
                    f1(this.B0, this.C0);
                    int size = this.B0.f198293d.size();
                    if (size > 0) {
                        Iterator<DrawView2.a> it = this.B0.f198293d.iterator();
                        z16 = false;
                        while (it.hasNext()) {
                            if (!it.next().f197444r) {
                                z16 = true;
                            }
                        }
                    } else {
                        z16 = false;
                    }
                    if (QLog.isColorLevel() && ARLocalFaceRecog.B) {
                        QLog.d("AREngine_QQARSession", 2, "[ScanStarFace]onARRecogComplete faceDataSize = " + size + ",hasRealFace = " + z16);
                    }
                    if (z16) {
                        try {
                            ReportController.o(null, "CliOper", "", "", "0X80081DE", "0X80081DE", 0, 0, String.valueOf(aaVar.f197988c.f198293d.get(0).f197432f), "3", "", "");
                        } catch (Exception e17) {
                            QLog.i("AREngine_QQARSession", 1, "0X80081DE. error = " + e17.getMessage());
                        }
                        this.R0 = 0L;
                        this.S0 = 0L;
                    } else {
                        if (ARLocalFaceRecog.k()) {
                            j3 = 4500;
                        } else {
                            j3 = 3000;
                        }
                        if (this.R0 == 0) {
                            this.R0 = System.currentTimeMillis();
                        }
                        long currentTimeMillis2 = System.currentTimeMillis();
                        this.S0 = currentTimeMillis2;
                        long j18 = this.R0;
                        if (j18 > 0 && currentTimeMillis2 - j18 > j3) {
                            if (QLog.isColorLevel()) {
                                QLog.d("AREngine_QQARSession", 2, "[ScanStarFace]onARRecogComplete stop Local Face Recog,lost all faces more than " + j3);
                            }
                            U0(4L);
                            this.R0 = -1L;
                            x xVar2 = this.B0;
                            xVar2.f198292c = true;
                            f1(xVar2, this.C0);
                            this.B0 = null;
                            this.C0 = null;
                            M0();
                        }
                    }
                } else if (mVar != null) {
                    ARRecognition.d c16 = ARRecognition.c(this.T.recognitions, mVar);
                    long j19 = c16.f196964a;
                    boolean z17 = c16.f196965b;
                    boolean j26 = ARRecognition.j(this.T.recognitions, j19);
                    if (this.G0 != null && j19 != 128) {
                        z0(false);
                        if (this.H0) {
                            r1(1L);
                            this.H0 = false;
                        }
                    }
                    if (j19 != 0) {
                        if (j19 == 4) {
                            if (j26) {
                                a1(mVar.f198208f);
                            } else if (ARRecognition.g(this.T.recognitions, 8L, 1L)) {
                                a1(mVar.f198208f);
                            } else {
                                z zVar5 = this.f198486z0;
                                if (zVar5 == null || zVar5.f198323c == 2) {
                                    U0(1L);
                                    a1(mVar.f198208f);
                                }
                            }
                        } else if (j19 == 2) {
                            if (j26) {
                                k1(mVar.f198207e);
                            } else if (ARRecognition.g(this.T.recognitions, 2L, 1L)) {
                                k1(mVar.f198207e);
                            } else {
                                z zVar6 = this.f198486z0;
                                if (zVar6 == null || zVar6.f198323c == 2) {
                                    U0(1L);
                                    k1(mVar.f198207e);
                                }
                            }
                        } else if (j19 == 128) {
                            if (j26) {
                                i1(mVar.f198212j);
                            } else {
                                if (this.I0) {
                                    if (this.G0 != null) {
                                        z0(false);
                                    }
                                    if (this.H0) {
                                        this.H0 = false;
                                    }
                                    return;
                                }
                                if (ARRecognition.g(this.T.recognitions, 128L, 1L)) {
                                    i1(mVar.f198212j);
                                } else {
                                    z zVar7 = this.f198486z0;
                                    if (zVar7 == null || zVar7.f198323c == 2) {
                                        U0(1L);
                                        this.H0 = true;
                                        i1(mVar.f198212j);
                                    }
                                }
                            }
                        } else if (j19 == 1) {
                            if (j26) {
                                b1(mVar.f198206d);
                            } else {
                                if (z17) {
                                    r1(1L);
                                }
                                b1(mVar.f198206d);
                            }
                        } else if (j19 == 2048) {
                            if (j26) {
                                d1(mVar.f198213k);
                            } else if (ARRecognition.g(this.T.recognitions, 2048L, 1L)) {
                                d1(mVar.f198213k);
                            } else {
                                z zVar8 = this.f198486z0;
                                if (zVar8 == null || zVar8.f198323c == 2) {
                                    U0(1L);
                                    d1(mVar.f198213k);
                                }
                            }
                        }
                    }
                }
            } else if (j16 != 0) {
                if (aaVar == null) {
                    return;
                }
                z zVar9 = aaVar.f197987b;
                if (zVar9 != null) {
                    h1(zVar9, this.A0);
                } else {
                    x xVar3 = aaVar.f197988c;
                    if (xVar3 != null) {
                        f1(xVar3, this.C0);
                    }
                }
            } else if (this.f198450b0 != 0) {
                if (mVar == null) {
                    return;
                }
                if (g.b(mVar.f198207e)) {
                    k1(mVar.f198207e);
                } else if (com.tencent.mobileqq.ar.arengine.e.c(mVar.f198212j)) {
                    i1(mVar.f198212j);
                } else if (com.tencent.mobileqq.ar.arengine.d.b(mVar.f198206d)) {
                    N0();
                } else if (o.a(mVar.f198208f)) {
                    M0();
                } else if (t.b(mVar.f198213k)) {
                    d1(mVar.f198213k);
                }
            }
            if (aaVar != null) {
                z zVar10 = aaVar.f197987b;
                if (zVar10 != null) {
                    this.A0 = zVar10;
                    ArCloudConfigInfo arCloudConfigInfo2 = zVar10.f198330j;
                    if (arCloudConfigInfo2 != null && !arCloudConfigInfo2.f()) {
                        this.f198486z0 = null;
                        this.A0 = null;
                    }
                } else {
                    x xVar4 = aaVar.f197988c;
                    if (xVar4 != null) {
                        this.C0 = xVar4;
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.ar.model.a
    public void K() {
        QLog.i("AREngine_QQARSession", 1, "uninit start. mIsInited = " + this.P);
        if (!this.P) {
            return;
        }
        CameraProxy.v().I(this);
        X0(new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.4
            @Override // java.lang.Runnable
            public void run() {
                QLog.i("AREngine_QQARSession", 1, "uninit run. mIsInited = " + QQARSession.this.P);
                QQARSession.this.H1();
                QQARSession qQARSession = QQARSession.this;
                qQARSession.f198521d = 5;
                qQARSession.P = false;
                QLog.i("AREngine_QQARSession", 1, "uninit end. mIsInited = " + QQARSession.this.P);
            }
        });
    }

    public void L0(com.tencent.mobileqq.ar.ARRenderModel.f fVar, ab abVar) {
        v vVar;
        v vVar2;
        v vVar3;
        if (abVar != null) {
            long j3 = abVar.f197989a;
            if (j3 == 4) {
                if (this.P && this.f198521d == 2 && (vVar3 = this.V) != null) {
                    vVar3.l(j3, 0, null, abVar);
                    return;
                }
                return;
            }
        }
        if (abVar != null) {
            long j16 = abVar.f197989a;
            if (j16 == 128) {
                if (this.P && this.f198521d == 2 && (vVar2 = this.V) != null) {
                    vVar2.l(j16, 0, null, abVar);
                    return;
                }
                return;
            }
        }
        if (this.K0 != null) {
            d dVar = this.f198470l0;
            if (dVar != null) {
                dVar.requestRender();
            }
            if (this.K0.g() && this.Q0) {
                if (this.P && this.f198521d == 2 && (vVar = this.V) != null) {
                    vVar.l(this.J0, this.K0.f197701h, fVar, null);
                    return;
                }
                return;
            }
            d dVar2 = this.f198470l0;
            if (dVar2 != null) {
                dVar2.z(fVar);
                return;
            }
            return;
        }
        d dVar3 = this.f198470l0;
        if (dVar3 != null) {
            dVar3.z(fVar);
        }
    }

    public void O0() {
        QLog.i("AREngine_QQARSession", 1, "onProcessCloudObjectClassifyResultComplete.");
        if (ARRecognition.j(this.T.recognitions, 1L)) {
            r1(1L);
        }
        P0();
    }

    public void Q0() {
        QLog.i("AREngine_QQARSession", 1, "onProcessCloudSceneRecogResultComplete.");
        if (ARRecognition.j(this.T.recognitions, 1L)) {
            r1(1L);
        }
        P0();
    }

    public void R0() {
        QLog.i("AREngine_QQARSession", 1, "onProcessMigCloudObjectClassifyResultComplete.");
        if (ARRecognition.j(this.T.recognitions, 1L)) {
            r1(1L);
            this.H0 = false;
        }
        this.G0 = null;
        P0();
    }

    public void U0(long j3) {
        QLog.d("AREngine_QQARSession", 1, "pauseLocalRecog. recogType = " + j3);
        ARLocalControl aRLocalControl = this.F;
        if (aRLocalControl != null) {
            aRLocalControl.q(j3);
        }
    }

    public void Y0(Runnable runnable, long j3) {
        if (this.Q && this.f198521d == 2) {
            Z0(runnable, j3);
        }
    }

    @Override // com.tencent.mobileqq.ar.model.CameraProxy.c
    public boolean Yd(byte[] bArr) {
        if (this.f198521d == 2) {
            onPreviewFrame(bArr, null);
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.b
    public void b(final ArVideoResourceInfo arVideoResourceInfo, final com.tencent.mobileqq.ar.ARRenderModel.c cVar) {
        QLog.i("AREngine_QQARSession", 1, "onRenderManagerCallback. onMultiARAnimationInteraction.");
        X0(new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.25
            @Override // java.lang.Runnable
            public void run() {
                if (QQARSession.this.P) {
                    QQARSession qQARSession = QQARSession.this;
                    if (qQARSession.f198521d == 2 && qQARSession.V != null) {
                        QQARSession.this.V.b(arVideoResourceInfo, cVar);
                    }
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.ar.arengine.ARCloudControl.f
    public void c() {
        if (this.f198469k1 == 0) {
            this.f198469k1 = System.currentTimeMillis();
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.b
    public void e(final ArCloudConfigInfo arCloudConfigInfo, final int i3, final int i16, final Object obj) {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_QQARSession", 2, "onCommonCallbackFromManager, resourceInfo=" + arCloudConfigInfo + ", action=" + i3 + ", result=" + i16 + " ,data=" + obj);
        }
        X0(new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.26
            @Override // java.lang.Runnable
            public void run() {
                int i17;
                ArCloudConfigInfo arCloudConfigInfo2 = arCloudConfigInfo;
                if (arCloudConfigInfo2 != null && arCloudConfigInfo2.e() && (i17 = i3) != 100 && i17 != 101) {
                    QQARSession.this.V.e(null, arCloudConfigInfo, i3, i16, obj);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.b
    public void f(String str, final int i3) {
        QLog.i("AREngine_QQARSession", 1, "onRenderManagerCallback. onARAnimationStart. key = " + str + ", remainPlayCount = " + i3);
        X0(new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.21
            @Override // java.lang.Runnable
            public void run() {
                if (QQARSession.this.P) {
                    QQARSession qQARSession = QQARSession.this;
                    if (qQARSession.f198521d == 2 && qQARSession.V != null) {
                        QQARSession.this.V.n(0, new f(QQARSession.this.K0), i3);
                    }
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.ar.arengine.ad.d
    public void g(boolean z16, int i3, ArCloudConfigInfo arCloudConfigInfo) {
        QLog.i("AREngine_QQARSession", 1, "onARMarkerResourceDownloadComplete. result = " + z16 + " type  " + i3);
    }

    @Override // com.tencent.mobileqq.ar.arengine.ad.d
    public void h(boolean z16, ArCloudConfigInfo arCloudConfigInfo) {
        ArWebInfo arWebInfo;
        QLog.i("AREngine_QQARSession", 1, String.format("onARMarkerAllDownloadComplete result=%s config=%s", Boolean.valueOf(z16), arCloudConfigInfo));
        if (z16 && arCloudConfigInfo != null && (arWebInfo = arCloudConfigInfo.H) != null && arWebInfo.f198433e && arWebInfo.f198432d && !TextUtils.isEmpty(arWebInfo.f198434f) && !arCloudConfigInfo.j()) {
            this.V.r(0, arCloudConfigInfo.H.f198434f);
            this.N = 1;
            this.M = arCloudConfigInfo;
            return;
        }
        H0(z16, arCloudConfigInfo);
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.b
    public void i(String str, final int i3) {
        QLog.i("AREngine_QQARSession", 1, "onRenderManagerCallback. onARAnimationPlayInterrupt. key = " + str + ", remainPlayCount = " + i3);
        X0(new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.23
            @Override // java.lang.Runnable
            public void run() {
                if (!QQARSession.this.K0.f()) {
                    if (QQARSession.this.K0.n()) {
                        QQARSession.this.G1();
                    }
                    if (QQARSession.this.J0 == 1) {
                        QQARSession.this.r1(1L);
                        QQARSession.this.N0();
                    } else if (QQARSession.this.J0 == 2) {
                        QQARSession.this.O0();
                    } else if (QQARSession.this.J0 == 2048) {
                        QQARSession.this.Q0();
                    }
                    QQARSession.this.E1();
                }
                if (QQARSession.this.P) {
                    QQARSession qQARSession = QQARSession.this;
                    if (qQARSession.f198521d == 2 && qQARSession.V != null) {
                        QQARSession.this.V.n(2, new f(QQARSession.this.K0), i3);
                    }
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.ar.arengine.ad.d
    public void j(int i3) {
        v vVar;
        if (this.P && this.f198521d == 2 && (vVar = this.V) != null) {
            vVar.h(2, i3);
        }
    }

    @Override // com.tencent.mobileqq.ar.arengine.ad.d
    public void k(int i3) {
        v vVar;
        QLog.i("AREngine_QQARSession", 1, "onARMarkerAllDownloadProgress. progress = " + i3);
        if (this.P && this.f198521d == 2 && (vVar = this.V) != null) {
            vVar.h(2, i3);
        }
    }

    @Override // com.tencent.mobileqq.ar.arengine.ad.d
    public void l() {
        v vVar;
        QLog.i("AREngine_QQARSession", 1, "onARMarkerAllDownloadStart.");
        this.f198457e1 = System.currentTimeMillis();
        if (this.P && this.f198521d == 2 && (vVar = this.V) != null) {
            vVar.h(0, 4);
        }
    }

    @Override // com.tencent.mobileqq.ar.arengine.ad.d
    public void m() {
        QLog.i("AREngine_QQARSession", 1, "onARSceneRecogDownloadStart.");
        this.f198457e1 = System.currentTimeMillis();
        X0(new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.17
            @Override // java.lang.Runnable
            public void run() {
                if (QQARSession.this.P) {
                    QQARSession qQARSession = QQARSession.this;
                    if (qQARSession.f198521d == 2 && qQARSession.V != null) {
                        QQARSession.this.V.h(0, 4);
                    }
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.ar.arengine.ARCloudControl.f
    public void n(boolean z16) {
        if (z16) {
            QLog.i("AREngine_QQARSession", 1, "onARCloudSelectImageComplete. result = " + z16);
            if (this.X0 == 0) {
                this.X0 = System.currentTimeMillis();
            }
            if (this.f198469k1 > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.f198469k1;
                if (currentTimeMillis > 0) {
                    this.f198471l1 += currentTimeMillis;
                }
                this.f198469k1 = 0L;
            }
        }
    }

    @Override // com.tencent.mobileqq.ar.arengine.ARCloudControl.f
    public boolean o() {
        return false;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera2) {
        d dVar;
        x xVar;
        z zVar;
        if (this.P && (dVar = this.f198470l0) != null) {
            if (this.Q && this.f198521d == 2) {
                dVar.B(dVar.t() + 1);
                ARLocalControl aRLocalControl = this.F;
                if (aRLocalControl != null && ((!aRLocalControl.m(1L) || !this.F.m(4L) || !this.F.m(4096L)) && !A0())) {
                    if (this.f198473m1 == 0 || (this.f198473m1 == 1 && this.f198463h1.p() == 0 && this.f198463h1.t())) {
                        this.F.p(this.f198470l0.t(), bArr);
                    }
                    if (this.I) {
                        d dVar2 = this.f198470l0;
                        dVar2.x(dVar2.t());
                        d dVar3 = this.f198470l0;
                        if (dVar3 != null) {
                            dVar3.requestRender();
                        }
                    } else if ((!this.F.m(1L) && (zVar = this.f198486z0) != null && zVar.f198323c == 2) || ((!this.F.m(4L) && (xVar = this.B0) != null && xVar.f198293d.size() == 0) || (!this.F.m(4L) && this.F.n(4L)))) {
                        d dVar4 = this.f198470l0;
                        dVar4.x(dVar4.t());
                        d dVar5 = this.f198470l0;
                        if (dVar5 != null) {
                            dVar5.requestRender();
                        }
                    }
                } else {
                    d dVar6 = this.f198470l0;
                    dVar6.x(dVar6.t());
                    d dVar7 = this.f198470l0;
                    if (dVar7 != null) {
                        dVar7.requestRender();
                    }
                }
                ARCloudControl aRCloudControl = this.f198472m0;
                if (aRCloudControl != null) {
                    aRCloudControl.J(bArr);
                    return;
                }
                return;
            }
            dVar.B(dVar.t() + 1);
            d dVar8 = this.f198470l0;
            dVar8.x(dVar8.t());
            d dVar9 = this.f198470l0;
            if (dVar9 != null) {
                dVar9.requestRender();
            }
        }
    }

    @Override // com.tencent.mobileqq.ar.arengine.ARCloudControl.f
    public void p(int i3, final m mVar) {
        z zVar;
        x xVar;
        boolean z16;
        boolean z17;
        String str;
        if (this.I) {
            QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete mIsForbiddenLocalMarkAndCloudRecg:do nothing but return ");
            return;
        }
        QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. retCode = " + i3 + ", recogResult = " + mVar + ":time is:" + (System.currentTimeMillis() - this.f198465i1));
        this.f198465i1 = System.currentTimeMillis();
        if (i3 == 0 && this.f198455d1) {
            this.f198455d1 = false;
            ReportController.o(null, "dc00898", "", "", "0X80085AE", "0X80085AE", 0, 0, "", "", "", "");
        }
        if ((this.D0 != null && this.G0 == null) || (((zVar = this.f198486z0) != null && zVar.f198323c != 2) || (((xVar = this.B0) != null && xVar.f198293d.size() > 0) || E0()))) {
            if (this.D0 != null && this.G0 == null) {
                QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. mCurCloudRecogResult != null.");
            } else {
                z zVar2 = this.f198486z0;
                if (zVar2 != null && zVar2.f198323c != 2) {
                    QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. mCurLocalMarkerRecogResult.state != ARConstants.AR_TRACK_STATE_LOST.");
                } else {
                    x xVar2 = this.B0;
                    if (xVar2 != null && xVar2.f198293d.size() > 0) {
                        QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. mCurLocalFaceRecogResult.faceDatas.size() > 0.");
                    } else if (E0()) {
                        QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. isModelRenderStarted().");
                    }
                }
            }
            ARCloudControl aRCloudControl = this.f198472m0;
            if (aRCloudControl != null) {
                aRCloudControl.M(true);
                return;
            }
            return;
        }
        m mVar2 = this.D0;
        if (mVar2 == null && this.G0 != null) {
            QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. deal mCurMIGObjectClassifyResult sucess");
        } else if (mVar2 != null && this.G0 != null) {
            QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. deal mCurMIGObjectClassifyResult error happen");
        }
        if (i3 == 0 && mVar != null) {
            if (!com.tencent.mobileqq.ar.arengine.d.b(mVar.f198206d) && !g.b(mVar.f198207e) && !com.tencent.mobileqq.ar.arengine.e.c(mVar.f198212j) && !o.a(mVar.f198208f) && !t.b(mVar.f198213k)) {
                z16 = false;
            } else {
                z16 = true;
            }
            z17 = h.b(mVar.f198210h);
            if (z17 && z16 && ARRecognition.k(mVar, this.T.recognitions, 64L)) {
                QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard other recog result as OCR preRecog has high priority");
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onARCloudUploadImgComplete result:  marker{success: ");
                sb5.append(com.tencent.mobileqq.ar.arengine.d.b(mVar.f198206d));
                sb5.append(", priority: ");
                sb5.append(this.f198452c0);
                sb5.append("}");
                sb5.append("  object{success: ");
                sb5.append(g.b(mVar.f198207e));
                sb5.append(", priority: ");
                sb5.append(this.f198454d0);
                sb5.append("}");
                sb5.append("  face{success: ");
                sb5.append(o.a(mVar.f198208f));
                sb5.append(", priority: ");
                sb5.append(this.f198456e0);
                sb5.append("}");
                sb5.append("  pre ocr{success: ");
                sb5.append(h.b(mVar.f198210h));
                sb5.append(", priority: ");
                sb5.append(this.f198458f0);
                sb5.append("}");
                sb5.append(" \n mig-object{success: ");
                sb5.append(com.tencent.mobileqq.ar.arengine.e.c(mVar.f198212j));
                sb5.append(", priority: ");
                sb5.append(this.f198460g0);
                sb5.append("}name:");
                ac acVar = mVar.f198212j;
                if (acVar != null) {
                    str = acVar.toString();
                } else {
                    str = "";
                }
                sb5.append(str);
                sb5.append("  scene{success: ");
                sb5.append(t.b(mVar.f198213k));
                sb5.append(", priority: ");
                sb5.append(this.f198462h0);
                sb5.append("}");
                QLog.i("AREngine_QQARSession", 2, sb5.toString());
            }
        } else {
            z16 = false;
            z17 = false;
        }
        if (z16 && !this.f198459f1) {
            QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete first recognize success.");
            this.f198459f1 = true;
        }
        if (z17 && !z16) {
            this.F0 = true;
            X0(new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.5
                @Override // java.lang.Runnable
                public void run() {
                    QQARSession.this.c1(true);
                }
            });
        } else if (!z17 && this.F0) {
            this.F0 = false;
            X0(new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.6
                @Override // java.lang.Runnable
                public void run() {
                    QQARSession.this.c1(false);
                }
            });
        }
        if (!z16) {
            if (this.G0 != null) {
                z0(true);
                if (this.P && this.f198521d == 2 && !this.I0) {
                    R0();
                }
            }
            if (!ARRecognition.j(this.T.recognitions, 1L) && (this.f198448a0 & 1) != 0) {
                T0();
                r1(1L);
            }
            ARCloudControl aRCloudControl2 = this.f198472m0;
            if (aRCloudControl2 != null) {
                aRCloudControl2.M(true);
            }
            QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. cloud recog failed.");
            return;
        }
        if (z16) {
            final com.tencent.mobileqq.ar.arengine.b c16 = m.c(this.T.recognitions, mVar);
            if (m.d(this.T.recognitions, mVar) && c16.f198147a != 1) {
                final ArLBSActivity b16 = m.b(this.T.recognitions, mVar);
                X0(new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.7
                    @Override // java.lang.Runnable
                    public void run() {
                        QQARSession.this.e1(c16, b16);
                    }
                });
                ARCloudControl aRCloudControl3 = this.f198472m0;
                if (aRCloudControl3 != null) {
                    aRCloudControl3.M(true);
                }
                QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. lbs location failed.");
                return;
            }
        }
        T0();
        this.M0 = 0L;
        this.N0 = 0L;
        X0(new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.8
            @Override // java.lang.Runnable
            public void run() {
                QLog.i("AREngine_QQARSession", 1, "processCloudRecogResult start.");
                QQARSession.this.J0(null, mVar);
            }
        });
        ARCloudControl aRCloudControl4 = this.f198472m0;
        if (aRCloudControl4 != null) {
            aRCloudControl4.M(true);
        }
    }

    @Override // com.tencent.mobileqq.ar.arengine.ad.d
    public void q(boolean z16, ArCloudConfigInfo arCloudConfigInfo) {
        ArWebInfo arWebInfo;
        if (z16 && arCloudConfigInfo != null && (arWebInfo = arCloudConfigInfo.H) != null && arWebInfo.f198433e && arWebInfo.f198432d && !TextUtils.isEmpty(arWebInfo.f198434f) && !arCloudConfigInfo.j()) {
            this.V.r(0, arCloudConfigInfo.H.f198434f);
            this.M = arCloudConfigInfo;
            this.N = 2;
            return;
        }
        K0(z16, arCloudConfigInfo);
    }

    public void r0() {
        QLog.d("AREngine_QQARSession", 1, String.format("CloseAREngineRecoglizeFunction  ", new Object[0]));
        X0(new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.27
            @Override // java.lang.Runnable
            public void run() {
                QQARSession qQARSession = QQARSession.this;
                if (qQARSession.f198521d == 2 && qQARSession.Q) {
                    if (QQARSession.this.E0()) {
                        QQARSession.this.F1();
                        QQARSession.this.J0 = 0L;
                        QQARSession.this.K0 = null;
                        QQARSession.this.L0 = null;
                    }
                    QQARSession.this.U0(5L);
                    QQARSession.this.T0();
                    QQARSession.this.H = false;
                    return;
                }
                QLog.d("AREngine_QQARSession", 1, String.format("enterIntoCertainWorkStatus with error status so return", new Object[0]));
            }
        });
    }

    public void r1(long j3) {
        QLog.d("AREngine_QQARSession", 1, "resumeLocalRecog. recogType = " + j3);
        ARLocalControl aRLocalControl = this.F;
        if (aRLocalControl != null) {
            if ((1 & j3) != 0) {
                this.f198486z0 = null;
                this.A0 = null;
                this.M0 = 0L;
                this.N0 = 0L;
                this.O0 = 0L;
                this.P0 = 0L;
            }
            if ((4 & j3) != 0) {
                this.B0 = null;
                this.C0 = null;
                this.R0 = 0L;
                this.S0 = 0L;
            }
            aRLocalControl.s(j3);
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.b
    public void s() {
        QLog.i("AREngine_QQARSession", 1, "onRenderReadyStatus ready");
        X0(new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.20
            @Override // java.lang.Runnable
            public void run() {
                if (QQARSession.this.P) {
                    QQARSession qQARSession = QQARSession.this;
                    if (qQARSession.f198521d == 2 && qQARSession.V != null) {
                        QQARSession.this.V.k();
                    }
                }
            }
        });
    }

    public int s1() {
        X0(new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.1
            @Override // java.lang.Runnable
            public void run() {
                QQARSession.this.u1();
            }
        });
        return 0;
    }

    @Override // com.tencent.mobileqq.ar.arengine.ARCloudControl.f
    public boolean t(ac acVar) {
        if (this.G0 == null) {
            return true;
        }
        return !r0.k(acVar);
    }

    @Override // com.tencent.mobileqq.ar.arengine.ad.d
    public void u(int i3) {
        v vVar;
        if (this.P && this.f198521d == 2 && (vVar = this.V) != null) {
            vVar.h(2, i3);
        }
    }

    public void u0(int i3) {
        QLog.d("AREngine_QQARSession", 1, String.format("enterIntoCertainWorkStatus on workMode=%s", Integer.valueOf(i3)));
        if (i3 == 1 && this.f198473m1 != i3) {
            X0(new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.28
                @Override // java.lang.Runnable
                public void run() {
                    QQARSession qQARSession = QQARSession.this;
                    if (qQARSession.f198521d == 2 && qQARSession.Q) {
                        if (QQARSession.this.E0()) {
                            QQARSession.this.F1();
                            QQARSession.this.J0 = 0L;
                            QQARSession.this.K0 = null;
                            QQARSession.this.L0 = null;
                        }
                        QQARSession.this.U0(5L);
                        QQARSession.this.T0();
                        QQARSession qQARSession2 = QQARSession.this;
                        qQARSession2.H = false;
                        ARLocalControl aRLocalControl = qQARSession2.F;
                        if (aRLocalControl != null) {
                            aRLocalControl.i(true, qQARSession2.f198481u0, QQARSession.this.f198482v0);
                        }
                        QQARSession.this.f198473m1 = 1;
                        QQARSession.this.I = true;
                        return;
                    }
                    QLog.d("AREngine_QQARSession", 1, String.format("enterIntoCertainWorkStatus with error status so return", new Object[0]));
                }
            });
        }
    }

    public int u1() {
        QLog.d("AREngine_QQARSession", 1, "start startInternal. mCurEngineState = " + this.f198521d);
        if (this.f198521d == 0 && CameraProxy.v().B()) {
            this.T0 = 0;
            this.U0 = System.currentTimeMillis();
            this.V0 = 0L;
            this.W0 = 0;
            this.X0 = 0L;
            this.Y0 = 0L;
            this.f198481u0 = CameraProxy.v().z();
            this.f198482v0 = CameraProxy.v().y();
            this.f198483w0 = CameraProxy.v().x();
            this.f198480t0 = UniformGLRenderManagerImpl.V;
            this.f198479s0 = UniformGLRenderManagerImpl.U;
            ARNativeBridge aRNativeBridge = new ARNativeBridge();
            this.f198468k0 = aRNativeBridge;
            if (!aRNativeBridge.isLoadSoSuccess()) {
                QLog.d("AREngine_QQARSession", 1, "startAR internal fail");
                this.f198468k0 = null;
                this.Q = false;
                S0(6);
                return 6;
            }
            y1();
            this.f198464i0.c(this.f198525i, this);
            if (this.F != null && !v1()) {
                S0(7);
                return 7;
            }
            if (!ARRecognition.j(this.T.recognitions, 1L)) {
                U0(5L);
            } else {
                U0(4L);
                r1(1L);
            }
            if (this.f198472m0 != null && !t1()) {
                S0(3);
                return 3;
            }
            this.f198521d = 2;
            this.f198470l0.D(this);
            S0(0);
            return 0;
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.ar.arengine.ad.d
    public void v() {
        QLog.i("AREngine_QQARSession", 1, "onARObjectClassifyDownloadStart.");
        this.f198457e1 = System.currentTimeMillis();
        X0(new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.15
            @Override // java.lang.Runnable
            public void run() {
                if (QQARSession.this.P) {
                    QQARSession qQARSession = QQARSession.this;
                    if (qQARSession.f198521d == 2 && qQARSession.V != null) {
                        QQARSession.this.V.h(0, 4);
                    }
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.b
    public void w(String str, final int i3) {
        QLog.i("AREngine_QQARSession", 1, "onRenderManagerCallback. onARAnimationComplete. key = " + str + ", remainPlayCount = " + i3);
        X0(new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.22
            @Override // java.lang.Runnable
            public void run() {
                if (QQARSession.this.K0 == null) {
                    QLog.d("AREngine_QQARSession", 1, "onARAnimationComplete mCurARResourceInfo is null!");
                    return;
                }
                if (i3 == 0) {
                    if (!QQARSession.this.K0.f()) {
                        if (!QQARSession.this.K0.l() && !QQARSession.this.K0.g() && !QQARSession.this.K0.k()) {
                            if (!QQARSession.this.K0.n()) {
                                if (QQARSession.this.J0 == 1) {
                                    QQARSession.this.r1(1L);
                                    QQARSession.this.N0();
                                } else if (QQARSession.this.J0 == 2) {
                                    QQARSession.this.O0();
                                } else if (QQARSession.this.J0 == 2048) {
                                    QQARSession.this.Q0();
                                }
                                QQARSession.this.E1();
                            }
                        } else {
                            QQARSession.this.K0.n();
                            if (QQARSession.this.K0.g() && QQARSession.this.K0.n()) {
                                QQARSession.this.z1(true);
                            }
                        }
                    } else if (QQARSession.this.K0.g() && QQARSession.this.K0.n()) {
                        QQARSession.this.z1(true);
                    }
                }
                if (QQARSession.this.P) {
                    QQARSession qQARSession = QQARSession.this;
                    if (qQARSession.f198521d == 2 && qQARSession.V != null) {
                        QQARSession.this.V.n(1, new f(QQARSession.this.K0), i3);
                    }
                }
            }
        });
    }

    public void w1(final long j3, final ArCloudConfigInfo arCloudConfigInfo) {
        Y0(new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.2
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("AREngine_QQARSession", 1, "ARTransferDoorLogicManager startModelRender in AREngine." + QQARSession.this.f198521d + ";" + QQARSession.this.Q);
                QQARSession qQARSession = QQARSession.this;
                if (qQARSession.f198521d == 2 && qQARSession.Q && !QQARSession.this.E0()) {
                    QQARSession.this.x1(j3, arCloudConfigInfo, -1, 0.0f, 0.0f, 0.0f);
                    QLog.d("AREngine_QQARSession", 1, "startModelRender. recogType for external ");
                }
            }
        }, 500L);
    }

    @Override // com.tencent.mobileqq.ar.arengine.ARCloudControl.f
    public long x() {
        Context context = this.f198525i;
        if (context instanceof ScanTorchActivity) {
            return ((ScanTorchActivity) context).getTimeActivityVisible();
        }
        return 0L;
    }

    public ArrayList<String> x0() {
        ARCloudControl aRCloudControl = this.f198472m0;
        if (aRCloudControl != null) {
            return aRCloudControl.x();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.r.b
    public void y(float[] fArr) {
        d dVar = this.f198470l0;
        if (dVar != null) {
            dVar.y(0, fArr);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0249  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int y0(boolean z16, boolean z17, boolean z18, boolean z19, ARCommonConfigInfo aRCommonConfigInfo, ArConfigInfo arConfigInfo, ARScanStarFaceConfigInfo aRScanStarFaceConfigInfo, v vVar, Activity activity, ARTransferDoorLogicManager aRTransferDoorLogicManager, d dVar) {
        ARCloudControl aRCloudControl;
        QLog.d("AREngine_QQARSession", 1, String.format("initAR isEnableARCloudFromSettings=%s isEnableARCloudFromH5=%s isTestMode=%s commonConfig=%s markerConfig=%s faceConfig=%s arEngineCallback=%s mIsArInited=%s", Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z19), aRCommonConfigInfo, arConfigInfo, aRScanStarFaceConfigInfo, vVar, Boolean.valueOf(this.Q)));
        if (this.Q) {
            return 0;
        }
        if (aRCommonConfigInfo == null) {
            this.Q = false;
            QLog.i("AREngine_QQARSession", 1, "initAR fail! commonConfig is null.");
            if (vVar != null) {
                vVar.c(3);
            }
            return 3;
        }
        f198445n1 = z19;
        this.T = aRCommonConfigInfo;
        this.U = arConfigInfo;
        this.K = aRScanStarFaceConfigInfo;
        this.V = vVar;
        this.W = aRCommonConfigInfo.isEnableARCloud();
        this.X = ARRecognition.b(aRCommonConfigInfo.recognitions);
        long a16 = ARRecognition.a(aRCommonConfigInfo.recognitions);
        this.Y = a16;
        this.Z = this.W;
        if (!z17) {
            this.Z = false;
        }
        if (z16) {
            this.Z = true;
        }
        if (z18) {
            this.I = true;
            this.Z = false;
            this.f198448a0 = 4096L;
        } else {
            this.f198448a0 = this.X & 1;
        }
        this.f198450b0 = a16 & 2179;
        if (this.T.recognitions != null) {
            int i3 = 0;
            while (i3 < this.T.recognitions.size()) {
                long j3 = 1 << ((int) this.T.recognitions.get(i3).f196956d);
                if ((this.f198448a0 & j3) == 0 && (this.f198450b0 & j3) == 0) {
                    this.T.recognitions.remove(i3);
                    i3--;
                }
                i3++;
            }
        }
        this.f198452c0 = ARRecognition.e(this.T.recognitions, 1L);
        this.f198454d0 = ARRecognition.e(this.T.recognitions, 2L);
        this.f198456e0 = ARRecognition.e(this.T.recognitions, 4L);
        this.f198458f0 = ARRecognition.e(this.T.recognitions, 64L);
        this.f198460g0 = ARRecognition.e(this.T.recognitions, 128L);
        this.f198462h0 = ARRecognition.e(this.T.recognitions, 2048L);
        QLog.i("AREngine_QQARSession", 1, "initAR mIsEnableARCloudFromConfig=" + this.W + " mLocalRecogTypeFromConfig=" + this.X + " mCloudRecogTypeFromConfig=" + this.Y + " mIsEnableARCloudFromClientSupport=true mLocalRecogTypeFromClientSupport=1 mCloudRecogTypeFromClientSupport=2179 mIsEnableARCloud=" + this.Z + " mLocalRecogType=" + this.f198448a0 + " mCloudRecogType=" + this.f198450b0 + " mMarkerRecogPriority=" + this.f198452c0 + " mObjectClassifyPriority=" + this.f198454d0 + " mFaceRecogPriority=" + this.f198456e0 + " mPreOcrRecogPriority=" + this.f198458f0 + " mSceneRecogPriority=" + this.f198462h0);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Build.MODEL = ");
        sb5.append(DeviceInfoMonitor.getModel());
        QLog.i("AREngine_QQARSession", 1, sb5.toString());
        this.f198470l0 = dVar;
        this.f198463h1 = aRTransferDoorLogicManager;
        ad adVar = new ad(this.f198526m, this.f198525i);
        this.f198474n0 = adVar;
        ARCommonConfigInfo aRCommonConfigInfo2 = this.T;
        if (aRCommonConfigInfo2 != null) {
            long j16 = aRCommonConfigInfo2.aRCloudCacheExpireTime;
            if (j16 > 0) {
                adVar.p(j16 * 60 * 1000, f198445n1);
                this.f198475o0 = this.f198474n0.n();
                if (this.f198448a0 != 0 && this.F == null) {
                    this.F = new ARLocalControl();
                }
                if (this.Z && this.f198472m0 == null) {
                    aRCloudControl = new ARCloudControl();
                    this.f198472m0 = aRCloudControl;
                    if (!aRCloudControl.y(this, this.f198526m, activity, 900000000, 900000000, 0, this.T)) {
                        QLog.i("AREngine_QQARSession", 1, "initAR fail! ARCloud init ar so fail.");
                        this.f198472m0 = null;
                        this.Q = false;
                        if (vVar != null) {
                            vVar.c(8);
                        }
                        return 8;
                    }
                }
                this.Q = true;
                this.f198521d = 0;
                return 0;
            }
        }
        adVar.p(86400000L, f198445n1);
        this.f198475o0 = this.f198474n0.n();
        if (this.f198448a0 != 0) {
            this.F = new ARLocalControl();
        }
        if (this.Z) {
            aRCloudControl = new ARCloudControl();
            this.f198472m0 = aRCloudControl;
            if (!aRCloudControl.y(this, this.f198526m, activity, 900000000, 900000000, 0, this.T)) {
            }
        }
        this.Q = true;
        this.f198521d = 0;
        return 0;
    }

    @Override // com.tencent.mobileqq.ar.arengine.ARCloudControl.f
    public void z(final boolean z16) {
        m mVar = this.D0;
        if (mVar != null && mVar.f198212j != null) {
            X0(new Runnable() { // from class: com.tencent.mobileqq.ar.model.QQARSession.9
                @Override // java.lang.Runnable
                public void run() {
                    boolean z17 = false;
                    if (QQARSession.this.I0) {
                        if (QQARSession.this.G0 != null) {
                            QQARSession.this.z0(false);
                            return;
                        }
                        return;
                    }
                    if (QQARSession.this.D0 != null && QQARSession.this.D0.f198212j != null && QQARSession.this.P && QQARSession.this.f198521d == 2) {
                        z17 = true;
                    }
                    if (z16 && z17) {
                        QQARSession qQARSession = QQARSession.this;
                        qQARSession.j1(qQARSession.D0.f198212j);
                    } else if (z17) {
                        if (QQARSession.this.G0 != null) {
                            QQARSession.this.z0(true);
                        }
                        QQARSession.this.R0();
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.r.b
    public void d(float f16, float f17, float f18, long j3) {
    }
}
