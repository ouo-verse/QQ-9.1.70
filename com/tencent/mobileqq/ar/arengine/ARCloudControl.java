package com.tencent.mobileqq.ar.arengine;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.ScanEntranceReport;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudPretreatmentManager;
import com.tencent.mobileqq.ar.arengine.d;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import v81.a;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ARCloudControl {
    private static final Object Z = new Object();

    /* renamed from: a0, reason: collision with root package name */
    private static boolean f197747a0 = false;

    /* renamed from: b0, reason: collision with root package name */
    private static boolean f197748b0 = false;
    long A;
    int B;
    long C;
    long D;
    long E;
    String F;
    int G;
    long H;
    private boolean K;
    private boolean L;
    private boolean M;
    private long N;
    private long O;
    private ArrayList<String> P;
    private boolean Q;
    private QQPermission T;
    private byte[] U;
    private boolean V;
    private long W;
    ArLBSActivity Y;

    /* renamed from: a, reason: collision with root package name */
    com.tencent.mobileqq.ar.arengine.a f197749a;

    /* renamed from: b, reason: collision with root package name */
    ARCloudPretreatmentManager f197750b;

    /* renamed from: c, reason: collision with root package name */
    v81.a f197751c;

    /* renamed from: d, reason: collision with root package name */
    int f197752d;

    /* renamed from: e, reason: collision with root package name */
    int f197753e;

    /* renamed from: f, reason: collision with root package name */
    int f197754f;

    /* renamed from: g, reason: collision with root package name */
    int f197755g;

    /* renamed from: h, reason: collision with root package name */
    int f197756h;

    /* renamed from: i, reason: collision with root package name */
    int f197757i;

    /* renamed from: k, reason: collision with root package name */
    long f197759k;

    /* renamed from: l, reason: collision with root package name */
    AppInterface f197760l;

    /* renamed from: m, reason: collision with root package name */
    Activity f197761m;

    /* renamed from: n, reason: collision with root package name */
    ARCommonConfigInfo f197762n;

    /* renamed from: w, reason: collision with root package name */
    long f197771w;

    /* renamed from: x, reason: collision with root package name */
    long f197772x;

    /* renamed from: y, reason: collision with root package name */
    long f197773y;

    /* renamed from: z, reason: collision with root package name */
    long f197774z;

    /* renamed from: j, reason: collision with root package name */
    int f197758j = 10000;

    /* renamed from: o, reason: collision with root package name */
    private HandlerThread f197763o = null;

    /* renamed from: p, reason: collision with root package name */
    private Handler f197764p = null;

    /* renamed from: q, reason: collision with root package name */
    private boolean f197765q = true;

    /* renamed from: r, reason: collision with root package name */
    private volatile boolean f197766r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f197767s = false;

    /* renamed from: t, reason: collision with root package name */
    private boolean f197768t = true;

    /* renamed from: u, reason: collision with root package name */
    private f f197769u = null;

    /* renamed from: v, reason: collision with root package name */
    private boolean f197770v = true;
    int I = -1;
    long J = 0;
    private boolean R = true;
    private m S = null;
    SosoInterfaceOnLocationListener X = new d(0, true, true, 3000, true, false, "QQARScan");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements a.d {
        a() {
        }

        @Override // v81.a.d
        public void a(com.tencent.mobileqq.ar.arengine.b bVar) {
            ARCloudControl.this.R = false;
            if (ARCloudControl.this.f197767s) {
                return;
            }
            if (ARCloudControl.this.f197764p != null) {
                ARCloudControl.this.f197764p.removeMessages(2);
            }
            QLog.i("AREngine_ARCloudControl", 1, "onARCloudLBSLocationCheckComplete. retCode = " + bVar.f198147a + ", imageId = " + bVar.f198148b);
            if (ARCloudControl.this.f197769u != null) {
                ARCloudControl aRCloudControl = ARCloudControl.this;
                m.e(aRCloudControl.f197762n.recognitions, aRCloudControl.S, bVar);
                ARCloudControl.this.f197769u.p(0, ARCloudControl.this.S);
            }
            ARCloudControl.this.S = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements ARCloudPretreatmentManager.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f197777a;

        b(q qVar) {
            this.f197777a = qVar;
        }

        @Override // com.tencent.mobileqq.ar.arengine.ARCloudPretreatmentManager.a
        public void a(j jVar) {
            this.f197777a.f198250k = jVar;
        }

        @Override // com.tencent.mobileqq.ar.arengine.ARCloudPretreatmentManager.a
        public void b(k kVar) {
            this.f197777a.f198249j = kVar;
        }

        @Override // com.tencent.mobileqq.ar.arengine.ARCloudPretreatmentManager.a
        public void c(j jVar) {
            this.f197777a.f198247h = jVar;
        }

        @Override // com.tencent.mobileqq.ar.arengine.ARCloudPretreatmentManager.a
        public void d(int i3, p pVar, long j3) {
            if (!ARCloudControl.this.f197767s && i3 == ARCloudPretreatmentManager.f197784d) {
                ARCloudControl aRCloudControl = ARCloudControl.this;
                aRCloudControl.D = j3;
                aRCloudControl.E += j3;
                this.f197777a.f198240a = aRCloudControl.f197751c.i();
                q qVar = this.f197777a;
                qVar.f198241b = pVar;
                ARCloudControl aRCloudControl2 = ARCloudControl.this;
                qVar.f198242c = aRCloudControl2.f197755g;
                qVar.f198243d = aRCloudControl2.f197756h;
                qVar.f198244e = aRCloudControl2.f197759k;
                qVar.f198245f = aRCloudControl2.f197757i;
                qVar.f198254o = Integer.toString(aRCloudControl2.f197760l.getAppid());
                this.f197777a.f198255p = Long.parseLong(ARCloudControl.this.f197760l.getCurrentAccountUin());
                this.f197777a.f198256q = System.currentTimeMillis();
                ARCloudControl.this.G(this.f197777a);
                if (ARCloudControl.this.f197769u != null) {
                    ARCloudControl.this.f197769u.C();
                }
            }
        }

        @Override // com.tencent.mobileqq.ar.arengine.ARCloudPretreatmentManager.a
        public void e(l lVar) {
            this.f197777a.f198251l = lVar;
        }

        @Override // com.tencent.mobileqq.ar.arengine.ARCloudPretreatmentManager.a
        public void f(i iVar) {
            this.f197777a.f198248i = iVar;
        }

        @Override // com.tencent.mobileqq.ar.arengine.ARCloudPretreatmentManager.a
        public void g(r rVar) {
            this.f197777a.f198246g = rVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class c implements a.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f197779a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ q f197780b;

        c(long j3, q qVar) {
            this.f197779a = j3;
            this.f197780b = qVar;
        }

        @Override // v81.a.c
        public void a(int i3, String str, m mVar) {
            boolean z16;
            int i16;
            String str2;
            com.tencent.mobileqq.ar.arengine.d dVar;
            d.a[] aVarArr;
            com.tencent.mobileqq.ar.arengine.d dVar2;
            boolean z17 = false;
            ARCloudControl.this.f197768t = false;
            if (ARCloudControl.this.f197767s) {
                return;
            }
            try {
                ARCloudControl aRCloudControl = ARCloudControl.this;
                if (mVar != null && (dVar2 = mVar.f198206d) != null) {
                    i16 = dVar2.f198162j;
                } else {
                    i16 = 0;
                }
                aRCloudControl.G = i16;
                if (mVar != null && (dVar = mVar.f198206d) != null && (aVarArr = dVar.f198161i) != null && aVarArr.length > 0) {
                    str2 = aVarArr[0].f198165a;
                } else {
                    str2 = "";
                }
                aRCloudControl.F = str2;
            } catch (Exception e16) {
                QLog.i("AREngine_ARCloudControl", 1, "  mCloudTime  mImageId " + e16.getMessage());
            }
            ARCloudControl aRCloudControl2 = ARCloudControl.this;
            if (aRCloudControl2.f197772x != 0) {
                aRCloudControl2.H = System.currentTimeMillis() - ARCloudControl.this.f197772x;
            }
            ARCloudControl aRCloudControl3 = ARCloudControl.this;
            if (aRCloudControl3.f197773y != 0) {
                aRCloudControl3.C += System.currentTimeMillis() - ARCloudControl.this.f197773y;
            }
            if (ARCloudControl.this.f197764p != null) {
                ARCloudControl.this.f197764p.removeMessages(1);
            }
            QLog.i("AREngine_ARCloudControl", 1, "[DEBUG_SCAN_yt_face] onARCloudUploadImgComplete  retCode = " + i3 + ", rspInfo = , sessionId = " + str + ",uploadCost = " + (System.currentTimeMillis() - this.f197779a));
            QLog.i("AREngine_ARCloudControl", 1, String.format("selectImage total time cost:start Time is %s", "requestToUpload"));
            if (ARCloudControl.this.f197769u != null) {
                if (i3 == 0 && mVar != null && (com.tencent.mobileqq.ar.arengine.d.b(mVar.f198206d) || g.b(mVar.f198207e) || com.tencent.mobileqq.ar.arengine.e.c(mVar.f198212j) || o.a(mVar.f198208f) || t.b(mVar.f198213k))) {
                    QLog.d("AREngine_ARCloudControl", 2, "mResult set:" + ARCloudControl.this.I);
                    ARCloudControl.this.I = 0;
                }
                if (mVar != null && com.tencent.mobileqq.ar.arengine.d.b(mVar.f198206d)) {
                    mVar.f198206d.f198157e = this.f197780b.f198241b.f198235a;
                }
                if (mVar != null && g.b(mVar.f198207e)) {
                    mVar.f198207e.f198176e = this.f197780b.f198241b.f198235a;
                }
                if (mVar != null && t.b(mVar.f198213k)) {
                    mVar.f198213k.f198263e = this.f197780b.f198241b.f198235a;
                }
                if (!ARCloudControl.this.L) {
                    if (i3 == 0 && mVar != null && (com.tencent.mobileqq.ar.arengine.d.b(mVar.f198206d) || g.b(mVar.f198207e) || o.a(mVar.f198208f) || h.b(mVar.f198210h) || t.b(mVar.f198213k))) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    ScanEntranceReport.c().d(z16, ARCloudControl.this.f197769u.x());
                    ARCloudControl.this.L = true;
                }
                if (!ARCloudControl.this.M && i3 == 0 && mVar != null && (com.tencent.mobileqq.ar.arengine.d.b(mVar.f198206d) || g.b(mVar.f198207e) || o.a(mVar.f198208f) || h.b(mVar.f198210h) || t.b(mVar.f198213k))) {
                    ScanEntranceReport.c().e(ARCloudControl.this.f197769u.x(), ARCloudControl.this.f197749a.f197984r);
                    ARCloudControl.this.M = true;
                }
                if (ARCloudControl.this.P != null) {
                    ARCloudControl.this.P.add(str);
                }
                ARCloudControl aRCloudControl4 = ARCloudControl.this;
                if (aRCloudControl4.I != 0 || mVar == null || !m.d(aRCloudControl4.f197762n.recognitions, mVar)) {
                    f fVar = ARCloudControl.this.f197769u;
                    if (mVar == null) {
                        mVar = null;
                    }
                    fVar.p(i3, mVar);
                    return;
                }
                ARCloudControl aRCloudControl5 = ARCloudControl.this;
                if (aRCloudControl5.f197762n.switchLBSLocation == 1) {
                    long j3 = mVar.f198204b;
                    if (j3 != 128 || (j3 == 128 && aRCloudControl5.f197769u.t(mVar.f198212j))) {
                        z17 = true;
                    }
                    if (z17) {
                        QLog.i("AREngine_ARCloudControl", 1, "normal process run requestToCheckLBSLocation.");
                        ARCloudControl.this.E(i3, mVar);
                        return;
                    } else {
                        QLog.i("AREngine_ARCloudControl", 1, "MIGObjectClaasify not need  run requestToCheckLBSLocation.");
                        ARCloudControl.this.f197769u.p(i3, mVar);
                        return;
                    }
                }
                aRCloudControl5.f197769u.p(2, null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class d extends SosoInterfaceOnLocationListener {
        d(int i3, boolean z16, boolean z17, long j3, boolean z18, boolean z19, String str) {
            super(i3, z16, z17, j3, z18, z19, str);
        }

        @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            SosoLocation sosoLocation;
            ARCloudControl.this.R = false;
            if (ARCloudControl.this.f197764p != null) {
                ARCloudControl.this.f197764p.removeMessages(2);
            }
            if (ARCloudControl.this.f197767s) {
                return;
            }
            if (i3 == 0 && sosoLbsInfo != null && (sosoLocation = sosoLbsInfo.mLocation) != null) {
                int i16 = (int) (sosoLocation.mLat02 * 1000000.0d);
                int i17 = (int) (sosoLocation.mLon02 * 1000000.0d);
                QLog.i("AREngine_ARCloudControl", 1, "GetLBSLocation. onLocationFinish. gps info. Lat_02 = " + sosoLocation.mLat02 + ", Lon_02 = " + sosoLocation.mLon02 + ", latitude = " + i16 + ", longitude = " + i17 + ", altitude = " + sosoLocation.altitude + ", accuracy = " + sosoLocation.accuracy + ", name = " + sosoLocation.name + ", address = " + sosoLocation.address);
                ARCloudControl aRCloudControl = ARCloudControl.this;
                ARCloudControl.this.F(m.a(aRCloudControl.f197762n.recognitions, aRCloudControl.S), i16, i17);
                return;
            }
            QLog.i("AREngine_ARCloudControl", 1, "GetLBSLocation. onLocationFinish. gps info failed. errCode = " + i3);
            com.tencent.mobileqq.ar.arengine.b bVar = new com.tencent.mobileqq.ar.arengine.b();
            bVar.f198147a = 2;
            ARCloudControl aRCloudControl2 = ARCloudControl.this;
            m.e(aRCloudControl2.f197762n.recognitions, aRCloudControl2.S, bVar);
            if (ARCloudControl.this.f197769u != null) {
                ARCloudControl.this.f197769u.p(0, ARCloudControl.this.S);
            }
            ARCloudControl.this.S = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class e extends QQPermission.BasePermissionsListener {
        e() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            ARCloudControl.this.grant();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            com.tencent.mobileqq.ar.arengine.b bVar = new com.tencent.mobileqq.ar.arengine.b();
            bVar.f198147a = 2;
            ARCloudControl aRCloudControl = ARCloudControl.this;
            m.e(aRCloudControl.f197762n.recognitions, aRCloudControl.S, bVar);
            if (ARCloudControl.this.f197769u != null) {
                ARCloudControl.this.f197769u.p(0, ARCloudControl.this.S);
            }
            ARCloudControl.this.S = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface f {
        void C();

        void E(boolean z16);

        long F();

        void c();

        void n(boolean z16);

        boolean o();

        void p(int i3, m mVar);

        boolean t(ac acVar);

        long x();

        void z(boolean z16);
    }

    private void B(Runnable runnable) {
        C(runnable, 0L);
    }

    private void C(Runnable runnable, long j3) {
        synchronized (Z) {
            Handler handler = this.f197764p;
            if (handler != null) {
                handler.postDelayed(runnable, j3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(byte[] bArr, ArrayList<ARRecognition> arrayList) {
        if (this.f197750b != null) {
            this.f197750b.d(bArr, arrayList, new b(new q()), this.f197753e, this.f197754f, this.f197752d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(int i3, m mVar) {
        boolean z16;
        QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocation.");
        this.S = mVar;
        Handler handler = this.f197764p;
        if (handler != null) {
            if (handler.hasMessages(2)) {
                this.f197764p.removeMessages(2);
            }
            Message obtain = Message.obtain(this.f197764p, new Runnable() { // from class: com.tencent.mobileqq.ar.arengine.ARCloudControl.8
                @Override // java.lang.Runnable
                public void run() {
                    if (ARCloudControl.this.f197769u != null && ARCloudControl.this.R) {
                        QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocation timeout.");
                        ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(ARCloudControl.this.X);
                        if (ARCloudControl.this.f197767s) {
                            return;
                        }
                        com.tencent.mobileqq.ar.arengine.b bVar = new com.tencent.mobileqq.ar.arengine.b();
                        bVar.f198147a = 2;
                        ARCloudControl aRCloudControl = ARCloudControl.this;
                        m.e(aRCloudControl.f197762n.recognitions, aRCloudControl.S, bVar);
                        if (ARCloudControl.this.f197769u != null) {
                            ARCloudControl.this.f197769u.p(0, ARCloudControl.this.S);
                        }
                        ARCloudControl.this.S = null;
                    }
                }
            });
            obtain.what = 2;
            this.f197764p.sendMessageDelayed(obtain, this.f197758j);
        }
        this.Y = m.b(this.f197762n.recognitions, mVar);
        if (this.T == null) {
            this.T = QQPermissionFactory.getQQPermission(this.f197761m, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_SCAN_AR, QQPermissionConstants.Business.SCENE.AR_SCAN_CLOUD_LOCATION));
        }
        QQPermission qQPermission = this.T;
        if (qQPermission != null) {
            if (qQPermission.hasPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                QLog.d("AREngine_ARCloudControl", 1, "checkSelfPermission. not grant");
                this.T.requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 2, new e());
                return;
            } else {
                QLog.d("AREngine_ARCloudControl", 1, "checkSelfPermission. grant");
                grant();
                return;
            }
        }
        QLog.e("AREngine_ARCloudControl", 1, "mQQPermission is null!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(String str, int i3, int i16) {
        QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocationInternal.");
        System.currentTimeMillis();
        if (this.f197751c != null) {
            this.R = true;
            Handler handler = this.f197764p;
            if (handler != null) {
                if (handler.hasMessages(2)) {
                    this.f197764p.removeMessages(2);
                }
                Message obtain = Message.obtain(this.f197764p, new Runnable() { // from class: com.tencent.mobileqq.ar.arengine.ARCloudControl.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ARCloudControl.this.f197769u != null && ARCloudControl.this.R) {
                            QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocation timeout.");
                            if (!ARCloudControl.this.f197767s) {
                                ARCloudControl.this.f197765q = true;
                                ARCloudControl.this.f197769u.p(1, null);
                                ARCloudControl.this.S = null;
                            }
                        }
                    }
                });
                obtain.what = 2;
                this.f197764p.sendMessageDelayed(obtain, this.f197758j);
            }
            this.f197751c.m(str, i3, i16, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(q qVar) {
        QLog.i("AREngine_ARCloudControl", 1, "[DEBUG_SCAN_yt_face] requestToUploadImg. : ");
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f197751c != null) {
            this.f197768t = true;
            this.B++;
            synchronized (Z) {
                Handler handler = this.f197764p;
                if (handler != null) {
                    if (handler.hasMessages(1)) {
                        this.f197764p.removeMessages(1);
                    }
                    Message obtain = Message.obtain(this.f197764p, new Runnable() { // from class: com.tencent.mobileqq.ar.arengine.ARCloudControl.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ARCloudControl.this.f197769u != null && ARCloudControl.this.f197768t) {
                                QLog.i("AREngine_ARCloudControl", 1, "onARCloudUploadImgComplete .isTimeOut= ");
                                if (!ARCloudControl.this.f197767s) {
                                    ARCloudControl.this.f197765q = true;
                                    ARCloudControl.this.f197769u.p(1, null);
                                    ARCloudControl.this.f197771w = System.currentTimeMillis();
                                }
                            }
                        }
                    });
                    obtain.what = 1;
                    this.f197764p.sendMessageDelayed(obtain, this.f197758j);
                }
            }
            this.f197751c.n(qVar, new c(currentTimeMillis, qVar));
        }
    }

    private void I(byte[] bArr) {
        QLog.i("AREngine_ARCloudControl", 1, "saveTmpPreviewData should nerver be called ");
        if (bArr != null && bArr.length > 0) {
            byte[] bArr2 = this.U;
            if (bArr2 == null || bArr2.length != bArr.length) {
                this.U = new byte[bArr.length];
            }
            System.arraycopy(bArr, 0, this.U, 0, bArr.length);
            this.V = true;
            if (this.W <= 0) {
                this.W = System.currentTimeMillis();
            }
        }
    }

    private void O() {
        QLog.i("AREngine_ARCloudControl", 1, "startUploadThread.");
        synchronized (Z) {
            if (this.f197763o == null) {
                HandlerThread newFreeHandlerThread = ThreadManagerV2.newFreeHandlerThread("ARCloudEnginePreprocessThread", 0);
                this.f197763o = newFreeHandlerThread;
                newFreeHandlerThread.start();
                this.f197764p = new Handler(this.f197763o.getLooper());
            }
        }
    }

    private void Q() {
        QLog.i("AREngine_ARCloudControl", 1, "stopUploadThread.");
        synchronized (Z) {
            Handler handler = this.f197764p;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.f197764p = null;
            HandlerThread handlerThread = this.f197763o;
            if (handlerThread != null) {
                handlerThread.quit();
                this.f197763o.interrupt();
            }
            this.f197763o = null;
        }
    }

    private void R() {
        QLog.i("AREngine_ARCloudControl", 1, "stopUploadingImg.");
        v81.a aVar = this.f197751c;
        if (aVar != null) {
            aVar.e();
        }
    }

    private void w() {
        this.U = null;
        this.V = false;
        this.W = 0L;
    }

    public static synchronized boolean z() {
        boolean z16;
        synchronized (ARCloudControl.class) {
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_ARCloudControl", 2, "loadNativeLibrary" + f197748b0 + ", loadSoSuccess=" + f197747a0);
            }
            if (f197748b0) {
                return f197747a0;
            }
            if (com.tencent.mobileqq.ar.h.d(com.tencent.mobileqq.ar.h.b())) {
                f197748b0 = true;
                try {
                    if (com.tencent.mobileqq.ar.h.e(com.tencent.mobileqq.ar.h.b()) == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    f197747a0 = z16;
                } catch (Throwable th5) {
                    f197747a0 = false;
                    QLog.i("AREngine_ARCloudControl", 1, "load ARCloud so failed. err msg = " + th5.getMessage());
                }
                QLog.d("AREngine_ARCloudControl", 1, "loadArNativeSo");
                return f197747a0;
            }
            QLog.i("AREngine_ARCloudControl", 1, "load ARCloud so failed. ARCloud so is not exist!");
            return f197747a0;
        }
    }

    public void A() {
        if (this.f197767s) {
            return;
        }
        this.f197774z = System.currentTimeMillis();
        u();
        this.f197767s = true;
        this.f197765q = false;
        Q();
        R();
    }

    public void H() {
        if (!this.f197767s) {
            return;
        }
        v();
        this.f197771w = System.currentTimeMillis();
        this.f197765q = true;
        QLog.i("AREngine_ARCloudControl", 1, String.format("selectImage total time cost:start Time is %s", "resume"));
        this.f197770v = true;
        this.f197767s = false;
        O();
        w();
    }

    public void J(final byte[] bArr) {
        boolean z16;
        f fVar;
        if (this.J == 0) {
            this.J = System.currentTimeMillis();
        }
        if (this.f197766r && this.f197749a != null) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean c16 = this.f197749a.c(bArr);
            this.f197766r = false;
            f fVar2 = this.f197769u;
            if (fVar2 != null) {
                fVar2.z(c16);
            }
            QLog.i("AREngine_ARCloudControl", 1, "isSameSceneWithBestImg = " + c16 + " cost time:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
        if (this.f197765q && this.f197749a != null) {
            if (this.f197770v) {
                QLog.i("AREngine_ARCloudControl", 1, "selectImage start");
                QLog.i("AREngine_ARCloudControl", 1, String.format("selectImage total time cost:start Time is %s", "firstTimeStart"));
                this.f197770v = false;
                if (this.N == 0) {
                    this.N = System.currentTimeMillis();
                }
                if (this.Q) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.arengine.ARCloudControl.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.jog), 0).show();
                        }
                    });
                }
            }
            f fVar3 = this.f197769u;
            if (fVar3 != null) {
                fVar3.c();
            }
            this.f197772x = System.currentTimeMillis();
            boolean d16 = this.f197749a.d(bArr, this.f197753e, this.f197754f);
            if (d16 && this.O == 0) {
                this.O = System.currentTimeMillis();
            }
            f fVar4 = this.f197769u;
            if (fVar4 != null) {
                boolean o16 = fVar4.o();
                long F = this.f197769u.F();
                if (d16 && !this.V && o16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AREngine_ARCloudControl", 2, "selectImage save tmp preview data");
                    }
                    I(bArr);
                } else if (d16 && this.V && System.currentTimeMillis() < this.W + F) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AREngine_ARCloudControl", 2, "selectImage update tmp preview data");
                    }
                    I(bArr);
                } else if (!d16 && this.V && System.currentTimeMillis() >= this.W + F) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AREngine_ARCloudControl", 2, "selectImage use tmp preview data");
                    }
                    bArr = this.U;
                    w();
                    d16 = true;
                    z16 = d16;
                    this.f197769u.n(d16);
                } else {
                    z16 = false;
                    this.f197769u.n(d16);
                }
                d16 = false;
                z16 = d16;
                this.f197769u.n(d16);
            } else {
                z16 = false;
            }
            if (!d16) {
                this.f197765q = true;
                return;
            }
            this.f197773y = System.currentTimeMillis();
            QLog.i("AREngine_ARCloudControl", 1, String.format("selectImage total time cost:%sms", Long.valueOf(System.currentTimeMillis() - this.f197771w)) + ":select result is " + d16);
            this.A = System.currentTimeMillis() - this.J;
            this.f197765q = false;
            if (this.Q) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.arengine.ARCloudControl.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QQToast.makeText(BaseApplication.getContext(), String.format(HardCodeUtil.qqStr(R.string.jof), Integer.valueOf(ARCloudControl.this.f197749a.f197984r)), 0).show();
                    }
                });
            }
            if (!z16) {
                bArr = this.f197749a.a();
            }
            f fVar5 = this.f197769u;
            if (fVar5 != null) {
                fVar5.E(true);
            }
            if (!this.K && (fVar = this.f197769u) != null) {
                long x16 = fVar.x();
                ScanEntranceReport.c().f(x16, this.N, this.O, this.f197749a.f197984r);
                com.tencent.mobileqq.ar.a.a().b(x16, this.O);
                this.K = true;
            }
            B(new Runnable() { // from class: com.tencent.mobileqq.ar.arengine.ARCloudControl.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bArr == null) {
                        ARCloudControl.this.f197765q = true;
                        ARCloudControl.this.f197770v = true;
                    } else {
                        if (ARCloudControl.this.f197762n.recognitions == null) {
                            return;
                        }
                        w.a().j();
                        w.a().f198284a = System.currentTimeMillis();
                        ARCloudControl aRCloudControl = ARCloudControl.this;
                        aRCloudControl.D(bArr, aRCloudControl.f197762n.recognitions);
                    }
                }
            });
        }
    }

    public void K(boolean z16) {
        this.f197766r = z16;
    }

    public void L(int i3, int i16, int i17) {
        this.f197753e = i3;
        this.f197754f = i16;
        this.f197752d = i17;
    }

    public void M(boolean z16) {
        this.f197765q = z16;
    }

    public void N() {
        this.f197765q = true;
        this.f197770v = true;
        this.f197767s = false;
        this.f197771w = System.currentTimeMillis();
        O();
        w();
    }

    public void P() {
        QLog.i("AREngine_ARCloudControl", 1, "stop.");
        this.f197767s = true;
        this.f197765q = false;
        Q();
        R();
    }

    public void S() {
        QLog.i("AREngine_ARCloudControl", 1, "uninit");
        com.tencent.mobileqq.ar.arengine.a aVar = this.f197749a;
        if (aVar != null) {
            aVar.e();
            this.f197749a = null;
        }
        ARCloudPretreatmentManager aRCloudPretreatmentManager = this.f197750b;
        if (aRCloudPretreatmentManager != null) {
            aRCloudPretreatmentManager.l();
            this.f197750b = null;
        }
        this.f197769u = null;
        ArrayList<String> arrayList = this.P;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.P.clear();
        }
        this.P = null;
        this.S = null;
        v81.a aVar2 = this.f197751c;
        if (aVar2 != null) {
            aVar2.g();
        }
        this.f197761m = null;
    }

    @QQPermissionDenied(1)
    public void denied() {
        QLog.d("AREngine_ARCloudControl", 1, "CheckPermission user denied = ");
        this.S = null;
    }

    @QQPermissionGrant(1)
    public void grant() {
        QLog.d("AREngine_ARCloudControl", 1, "CheckPermission user grant = ");
        ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).startLocation(this.X);
    }

    public void u() {
        QLog.d("AREngine_ARCloudControl", 2, "arCloudReport mResult:" + this.I);
        ARReport.c().s(this.A, this.C, this.D, this.B, this.F, this.G, this.E, this.H, this.f197774z - this.f197771w, this.I);
    }

    public void v() {
        this.f197771w = 0L;
        this.f197774z = 0L;
        this.A = 0L;
        this.B = 0;
        this.C = 0L;
        this.D = 0L;
        this.E = 0L;
        this.F = null;
        this.G = 0;
        this.I = -1;
        this.f197772x = 0L;
        this.f197773y = 0L;
        this.J = 0L;
    }

    public ArrayList<String> x() {
        return this.P;
    }

    public boolean y(f fVar, AppInterface appInterface, Activity activity, int i3, int i16, int i17, ARCommonConfigInfo aRCommonConfigInfo) {
        long j3;
        long currentTimeMillis = System.currentTimeMillis();
        f197747a0 = z();
        ARReport.c().f(System.currentTimeMillis() - currentTimeMillis, f197747a0);
        if (!f197747a0) {
            return false;
        }
        this.f197749a = new com.tencent.mobileqq.ar.arengine.a(com.tencent.mobileqq.ar.arengine.a.f197966u);
        this.f197750b = new ARCloudPretreatmentManager();
        this.f197749a.b(BaseApplication.getContext().getApplicationContext());
        this.f197750b.c();
        this.f197760l = appInterface;
        this.f197761m = activity;
        this.f197756h = i3;
        this.f197755g = i16;
        this.f197757i = i17;
        this.f197769u = fVar;
        v81.a aVar = new v81.a(appInterface, true);
        this.f197751c = aVar;
        aVar.l();
        this.f197762n = aRCommonConfigInfo;
        if (aRCommonConfigInfo != null) {
            j3 = ARRecognition.a(aRCommonConfigInfo.recognitions);
        } else {
            j3 = 0;
        }
        this.f197759k = j3;
        this.f197770v = true;
        if (this.P == null) {
            this.P = new ArrayList<>();
        }
        this.P.clear();
        ARReport.c().g(System.currentTimeMillis() - currentTimeMillis, f197747a0);
        return true;
    }
}
