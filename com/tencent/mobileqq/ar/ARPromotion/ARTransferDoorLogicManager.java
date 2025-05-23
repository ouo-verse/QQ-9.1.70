package com.tencent.mobileqq.ar.ARPromotion;

import android.graphics.PointF;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.av.avgesture.AVGestureWrapper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARPromotion.a;
import com.tencent.mobileqq.ar.ARPromotion.d;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecog;
import com.tencent.mobileqq.ar.arengine.y;
import com.tencent.mobileqq.ar.model.QQARSession;
import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ARTransferDoorLogicManager implements a.InterfaceC7395a {
    public static final String C = "ARTransferDoorLogicManager";

    /* renamed from: h, reason: collision with root package name */
    public ARScanEntryView f196835h;

    /* renamed from: i, reason: collision with root package name */
    public WeakReference<QQARSession> f196836i;

    /* renamed from: k, reason: collision with root package name */
    MqqHandler f196838k;

    /* renamed from: l, reason: collision with root package name */
    private a f196839l;

    /* renamed from: m, reason: collision with root package name */
    private AppInterface f196840m;

    /* renamed from: n, reason: collision with root package name */
    private RelativeLayout f196841n;

    /* renamed from: o, reason: collision with root package name */
    private e f196842o;

    /* renamed from: p, reason: collision with root package name */
    private com.tencent.mobileqq.ar.ARPromotion.a f196843p;

    /* renamed from: t, reason: collision with root package name */
    private String f196847t;

    /* renamed from: a, reason: collision with root package name */
    public final int f196828a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final int f196829b = 2;

    /* renamed from: c, reason: collision with root package name */
    public final int f196830c = 3;

    /* renamed from: d, reason: collision with root package name */
    public final int f196831d = 4;

    /* renamed from: e, reason: collision with root package name */
    public final int f196832e = 5;

    /* renamed from: f, reason: collision with root package name */
    public final int f196833f = 6;

    /* renamed from: g, reason: collision with root package name */
    public int f196834g = 1;

    /* renamed from: j, reason: collision with root package name */
    volatile d.a f196837j = null;

    /* renamed from: q, reason: collision with root package name */
    private volatile int f196844q = -1;

    /* renamed from: r, reason: collision with root package name */
    private boolean f196845r = false;

    /* renamed from: s, reason: collision with root package name */
    private String f196846s = "";

    /* renamed from: u, reason: collision with root package name */
    private boolean f196848u = true;

    /* renamed from: v, reason: collision with root package name */
    private String f196849v = "";

    /* renamed from: w, reason: collision with root package name */
    private ArCloudConfigInfo f196850w = null;

    /* renamed from: x, reason: collision with root package name */
    private long f196851x = 0;

    /* renamed from: y, reason: collision with root package name */
    private boolean f196852y = true;

    /* renamed from: z, reason: collision with root package name */
    private int f196853z = 0;
    private int A = 15;
    private y B = new y();

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
        boolean a();

        void d(int[] iArr, int[] iArr2, int[] iArr3, boolean z16);

        void e(View view);

        int f(int i3);

        int getGameStatus();

        void h(int i3, int i16, int i17, int i18);

        void i();

        String k();

        void m();

        boolean n();

        boolean p();

        String q();
    }

    public void A(int i3) {
        this.f196834g = i3;
        QLog.d(C, 2, "setGamePlayMode mode " + i3);
    }

    public void B(int i3, int i16, int i17, int i18) {
        String str = C;
        QLog.i(str, 1, "setRecogRes");
        a aVar = this.f196839l;
        if (aVar != null) {
            aVar.h(i3, i16, i17, i18);
        } else {
            QLog.i(str, 1, "setRecogRes failed.");
        }
    }

    public void C() {
        QLog.d(C, 2, "startPhonePoseDetect");
        this.f196843p.c();
        this.f196844q = -1;
    }

    public void D(ArCloudConfigInfo arCloudConfigInfo) {
        QLog.d(C, 2, "startRenderTransferGame config " + arCloudConfigInfo);
        if (this.f196850w == null) {
            this.f196850w = arCloudConfigInfo;
        }
        if (arCloudConfigInfo == null && this.f196850w != null && u()) {
            arCloudConfigInfo = this.f196850w;
        }
        WeakReference<QQARSession> weakReference = this.f196836i;
        if (weakReference != null && weakReference.get() != null) {
            this.f196836i.get().w1(4096L, arCloudConfigInfo);
        }
    }

    public void E() {
        QLog.d(C, 2, "stopPhonePoseDetect");
        this.f196843p.b();
    }

    public void F(int i3) {
        String str = C;
        QLog.d(str, 2, "switchGameStatus " + i3);
        a aVar = this.f196839l;
        if (aVar != null) {
            aVar.f(i3);
            return;
        }
        boolean z16 = true;
        Object[] objArr = new Object[1];
        if (("switchGameStatus " + i3 + "|" + this.f196839l) == null) {
            z16 = false;
        }
        objArr[0] = Boolean.valueOf(z16);
        QLog.d(str, 2, objArr);
    }

    public void G() {
        e eVar = this.f196842o;
        if (eVar != null) {
            eVar.b(this.f196841n);
        }
        this.f196839l = null;
        E();
        this.f196844q = -1;
    }

    public void H() {
        QLog.d(C, 2, "ARWorldGC ARWorldCupGameLogicManager uninit");
        this.f196839l = null;
        RelativeLayout relativeLayout = this.f196841n;
        if (relativeLayout != null) {
            relativeLayout.setOnTouchListener(null);
            this.f196841n = null;
        }
        this.f196835h = null;
        this.f196840m = null;
        this.f196837j = null;
        MqqHandler mqqHandler = this.f196838k;
        if (mqqHandler != null) {
            mqqHandler.removeCallbacksAndMessages(null);
        }
        this.f196842o = null;
        com.tencent.mobileqq.ar.ARPromotion.a aVar = this.f196843p;
        if (aVar != null) {
            aVar.b();
            this.f196843p = null;
        }
        this.f196844q = -1;
        this.f196850w = null;
    }

    public void I(boolean z16, final String str) {
        QLog.d(C, 2, "updateUITipsMessage " + z16 + ";" + str);
        if (this.f196845r == z16 && this.f196846s.equalsIgnoreCase(str)) {
            return;
        }
        this.f196845r = z16;
        this.f196846s = str;
        if (z16) {
            this.f196838k.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.6
                @Override // java.lang.Runnable
                public void run() {
                    if (ARTransferDoorLogicManager.this.f196841n != null && ARTransferDoorLogicManager.this.f196842o != null) {
                        ARTransferDoorLogicManager.this.f196841n.setVisibility(0);
                        ARTransferDoorLogicManager.this.f196842o.a(ARTransferDoorLogicManager.this.f196841n);
                        ARTransferDoorLogicManager.this.f196842o.d(str);
                    }
                }
            });
        } else {
            this.f196838k.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.7
                @Override // java.lang.Runnable
                public void run() {
                    if (ARTransferDoorLogicManager.this.f196841n != null && ARTransferDoorLogicManager.this.f196842o != null) {
                        ARTransferDoorLogicManager.this.f196842o.b(ARTransferDoorLogicManager.this.f196841n);
                    }
                }
            });
        }
    }

    public void J() {
        String str = C;
        QLog.i(str, 1, "zoomOutWorldCupSparks .");
        a aVar = this.f196839l;
        if (aVar != null) {
            aVar.i();
        } else {
            QLog.i(str, 1, "zoomOutWorldCupSparks failed.");
        }
    }

    @Override // com.tencent.mobileqq.ar.ARPromotion.a.InterfaceC7395a
    public void a(boolean z16) {
        t();
        if (z16) {
            a aVar = this.f196839l;
            if (aVar != null && this.f196834g == 1) {
                if (aVar.p()) {
                    l(6);
                    this.f196839l.m();
                    this.f196844q = -1;
                } else {
                    this.f196844q = 0;
                }
            } else if (aVar != null && this.f196834g == 2) {
                l(2);
                this.f196844q = 0;
            } else if (aVar == null) {
                l(2);
                this.f196844q = 0;
            }
            QLog.d(C, 2, "onPhonePoseChaned standBy SUCCESS with mode: " + this.f196834g + "-mCurrentPoseStatus:" + this.f196844q);
            return;
        }
        a aVar2 = this.f196839l;
        if (aVar2 != null && aVar2.p() && this.f196834g == 1) {
            l(1);
        } else if (this.f196834g == 2) {
            l(1);
        }
        this.f196844q = 1;
        QLog.d(C, 2, "onPhonePoseChaned standBy FAIL with mode: " + this.f196834g + "-mCurrentPoseStatus:" + this.f196844q);
    }

    public void l(int i3) {
        ARScanEntryView aRScanEntryView;
        QLog.d(C, 2, "OnARTransferStatusChanged status changeTo " + i3);
        if (this.f196838k != null && (aRScanEntryView = this.f196835h) != null) {
            if (aRScanEntryView == null || aRScanEntryView.p()) {
                switch (i3) {
                    case 1:
                        this.f196838k.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.8
                            @Override // java.lang.Runnable
                            public void run() {
                                ARTransferDoorLogicManager aRTransferDoorLogicManager = ARTransferDoorLogicManager.this;
                                ARScanEntryView aRScanEntryView2 = aRTransferDoorLogicManager.f196835h;
                                if (aRScanEntryView2 == null) {
                                    return;
                                }
                                if (aRTransferDoorLogicManager.f196834g == 2) {
                                    aRScanEntryView2.w1(false);
                                    ARTransferDoorLogicManager.this.f196835h.x1(1);
                                } else {
                                    aRTransferDoorLogicManager.I(true, HardCodeUtil.qqStr(R.string.jro));
                                }
                            }
                        });
                        return;
                    case 2:
                        this.f196838k.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.9
                            @Override // java.lang.Runnable
                            public void run() {
                                ARTransferDoorLogicManager aRTransferDoorLogicManager = ARTransferDoorLogicManager.this;
                                ARScanEntryView aRScanEntryView2 = aRTransferDoorLogicManager.f196835h;
                                if (aRScanEntryView2 == null) {
                                    return;
                                }
                                if (aRTransferDoorLogicManager.f196834g == 2) {
                                    aRScanEntryView2.w1(true);
                                    ARTransferDoorLogicManager.this.f196835h.x1(2);
                                } else {
                                    aRTransferDoorLogicManager.I(false, "");
                                }
                                if (ARTransferDoorLogicManager.this.f196848u) {
                                    ReportController.o(null, "CliOper", "", "", "0X80098C8", "0X80098C8", 0, 0, ARTransferDoorLogicManager.this.f196849v, "0", "0", "");
                                    ARTransferDoorLogicManager.this.f196848u = false;
                                }
                            }
                        });
                        return;
                    case 3:
                        this.f196838k.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.10
                            @Override // java.lang.Runnable
                            public void run() {
                                ARTransferDoorLogicManager aRTransferDoorLogicManager = ARTransferDoorLogicManager.this;
                                ARScanEntryView aRScanEntryView2 = aRTransferDoorLogicManager.f196835h;
                                if (aRScanEntryView2 != null && aRTransferDoorLogicManager.f196834g == 2) {
                                    aRScanEntryView2.w1(true);
                                    ARTransferDoorLogicManager.this.f196835h.x1(3);
                                }
                            }
                        });
                        return;
                    case 4:
                        this.f196838k.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.11
                            @Override // java.lang.Runnable
                            public void run() {
                                ARTransferDoorLogicManager aRTransferDoorLogicManager = ARTransferDoorLogicManager.this;
                                ARScanEntryView aRScanEntryView2 = aRTransferDoorLogicManager.f196835h;
                                if (aRScanEntryView2 == null) {
                                    return;
                                }
                                if (aRTransferDoorLogicManager.f196834g == 2) {
                                    aRScanEntryView2.w1(true);
                                    ARTransferDoorLogicManager.this.f196835h.x1(2);
                                } else {
                                    aRTransferDoorLogicManager.I(false, "");
                                }
                            }
                        });
                        return;
                    case 5:
                        this.f196838k.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.12
                            @Override // java.lang.Runnable
                            public void run() {
                                ARTransferDoorLogicManager aRTransferDoorLogicManager = ARTransferDoorLogicManager.this;
                                ARScanEntryView aRScanEntryView2 = aRTransferDoorLogicManager.f196835h;
                                if (aRScanEntryView2 == null) {
                                    return;
                                }
                                if (aRTransferDoorLogicManager.f196834g == 2) {
                                    aRScanEntryView2.w1(false);
                                    ARTransferDoorLogicManager.this.f196835h.x1(4);
                                } else {
                                    aRTransferDoorLogicManager.I(false, "");
                                }
                            }
                        });
                        return;
                    case 6:
                        this.f196838k.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.13
                            @Override // java.lang.Runnable
                            public void run() {
                                ARTransferDoorLogicManager aRTransferDoorLogicManager = ARTransferDoorLogicManager.this;
                                ARScanEntryView aRScanEntryView2 = aRTransferDoorLogicManager.f196835h;
                                if (aRScanEntryView2 != null && aRTransferDoorLogicManager.f196834g == 2) {
                                    aRScanEntryView2.x1(0);
                                    ARTransferDoorLogicManager.this.f196835h.w1(false);
                                }
                            }
                        });
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void m(a aVar) {
        int i3;
        if (aVar != null) {
            this.f196839l = aVar;
            RelativeLayout relativeLayout = this.f196841n;
            if (relativeLayout != null) {
                aVar.e(relativeLayout);
            }
            this.f196847t = this.f196839l.k();
            if (this.f196839l.a()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            this.f196834g = i3;
            this.f196849v = this.f196839l.q();
        }
    }

    public void n() {
        String str = C;
        QLog.d(str, 2, "doOnPause");
        if (this.f196839l == null) {
            QLog.d(str, 2, "doOnPause but do nothing here");
            return;
        }
        e eVar = this.f196842o;
        if (eVar != null) {
            eVar.b(this.f196841n);
        }
        this.f196841n.setVisibility(8);
        l(6);
        E();
        this.f196844q = -1;
    }

    public void o() {
        QLog.d(C, 2, "doOnResume");
    }

    public int p() {
        return this.f196844q;
    }

    public int q() {
        a aVar = this.f196839l;
        if (aVar != null) {
            return aVar.getGameStatus();
        }
        return 0;
    }

    public void r(AppInterface appInterface, ScanTorchActivity scanTorchActivity, RelativeLayout relativeLayout) {
        boolean z16;
        this.f196840m = appInterface;
        this.f196841n = relativeLayout;
        this.f196838k = ThreadManager.getUIHandler();
        com.tencent.mobileqq.ar.ARPromotion.a aVar = new com.tencent.mobileqq.ar.ARPromotion.a(scanTorchActivity);
        this.f196843p = aVar;
        aVar.e(this);
        if (this.f196839l != null && relativeLayout != null) {
            QLog.d(C, 2, "init " + relativeLayout.getChildCount());
            this.f196839l.e(this.f196841n);
        } else {
            String str = C;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("init ");
            if (this.f196839l != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d(str, 2, sb5.toString());
        }
        this.f196842o = new e(scanTorchActivity);
    }

    public void s(int[] iArr, int[] iArr2, int[] iArr3, boolean z16) {
        String str = C;
        QLog.i(str, 1, "insertWorldCupSpark start.");
        a aVar = this.f196839l;
        if (aVar != null && aVar.n()) {
            this.f196839l.d(iArr, iArr2, iArr3, z16);
        } else {
            QLog.i(str, 1, "insertWorldCupSpark failed.");
        }
    }

    public boolean t() {
        int q16;
        if (this.f196839l == null || (q16 = q()) == 0 || q16 == 1) {
            return true;
        }
        return false;
    }

    public boolean u() {
        if (this.f196834g == 2) {
            return true;
        }
        return false;
    }

    public void v(final boolean z16) {
        MqqHandler mqqHandler = this.f196838k;
        if (mqqHandler != null) {
            mqqHandler.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.5
                @Override // java.lang.Runnable
                public void run() {
                    if (z16) {
                        ARTransferDoorLogicManager.this.f196841n.setVisibility(0);
                    } else {
                        ARTransferDoorLogicManager.this.f196841n.setVisibility(8);
                    }
                    QLog.d(ARTransferDoorLogicManager.C, 2, "makeARTransferPromotionTouchViewVisiable " + z16);
                }
            });
        }
    }

    public void w() {
        QLog.d(C, 2, "notifyEnterIntoTransferDoorStatus");
        WeakReference<QQARSession> weakReference = this.f196836i;
        if (weakReference != null && weakReference.get() != null) {
            this.f196836i.get().u0(1);
        }
    }

    public void x(y yVar, final int i3, final int i16, final int i17, final int i18) {
        boolean z16;
        boolean z17;
        boolean z18;
        int i19;
        String str = C;
        QLog.d(str, 2, "processInternalGestureRecogResult");
        if (!t()) {
            QLog.d(str, 2, "processInternalGestureRecogResult into Error status");
        }
        this.B = yVar;
        if (this.f196851x > 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        y.b bVar = yVar.f198296d;
        if (bVar.f198306f == 0 && bVar.f198305e > 0) {
            E();
            if (z16) {
                l(4);
                QLog.d(str, 2, "processInternalGestureRecogResult start draw circle");
            }
            y.a aVar = this.B.f198296d.f198303c;
            PointF i26 = ARLocalGestureCircleRecog.i(i3, i16, i17, i18, new PointF(aVar.f198298b, aVar.f198299c));
            y.a aVar2 = this.B.f198296d.f198303c;
            int i27 = (int) ((aVar2.f198297a / i16) * i17);
            int i28 = (int) i26.x;
            int i29 = (int) i26.y;
            if (aVar2.f198300d) {
                i19 = 1;
            } else {
                i19 = -1;
            }
            B(i27, i28, i29, i19);
            F(1);
            ARVideoRecordUIControllerImpl.t().L(6);
            this.B.f198296d.f198311k = 0;
        }
        y yVar2 = this.B;
        y.b bVar2 = yVar2.f198296d;
        int i36 = bVar2.f198305e;
        int i37 = bVar2.f198306f;
        if (i36 > i37) {
            int i38 = yVar2.f198295c.f198321g;
            if (i38 == 1) {
                if (i37 == 0) {
                    i37 = 0;
                    z17 = true;
                    z18 = true;
                } else {
                    z18 = false;
                    z17 = true;
                }
            } else {
                if (i36 >= 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (i37 < 1) {
                    i37 = 0;
                    z18 = true;
                } else {
                    z18 = false;
                }
            }
            if (z17) {
                if (i38 == 1) {
                    int[] iArr = new int[i36 - i37];
                    int[] iArr2 = new int[i36 - i37];
                    int[] iArr3 = new int[i36 - i37];
                    int i39 = i37;
                    while (true) {
                        y.b bVar3 = this.B.f198296d;
                        if (i39 >= bVar3.f198305e) {
                            break;
                        }
                        PointF i46 = ARLocalGestureCircleRecog.i(i3, i3, i17, i18, bVar3.f198304d[i39]);
                        int i47 = i39 - i37;
                        iArr[i47] = (int) i46.x;
                        iArr2[i47] = (int) i46.y;
                        iArr3[i47] = this.B.f198296d.f198308h[i39];
                        i39++;
                    }
                    s(iArr, iArr2, iArr3, z18);
                } else {
                    this.f196853z = 0;
                    if (this.f196852y) {
                        this.f196852y = false;
                        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.1
                            @Override // java.lang.Runnable
                            public void run() {
                                WeakReference<QQARSession> weakReference;
                                boolean z19;
                                int i48 = 0;
                                while (true) {
                                    if (i48 >= 2) {
                                        break;
                                    }
                                    if (ARTransferDoorLogicManager.this.B.f198296d.f198311k > ARTransferDoorLogicManager.this.B.f198296d.f198309i - 1) {
                                        ARTransferDoorLogicManager.this.f196852y = true;
                                        break;
                                    }
                                    if (ARTransferDoorLogicManager.this.f196852y) {
                                        break;
                                    }
                                    PointF i49 = ARLocalGestureCircleRecog.i(i3, i16, i17, i18, ARTransferDoorLogicManager.this.B.f198296d.f198307g[ARTransferDoorLogicManager.this.B.f198296d.f198311k]);
                                    int[] iArr4 = {(int) i49.x};
                                    int[] iArr5 = {(int) i49.y};
                                    int[] iArr6 = {ARTransferDoorLogicManager.this.B.f198296d.f198308h[ARTransferDoorLogicManager.this.B.f198296d.f198311k]};
                                    ARTransferDoorLogicManager aRTransferDoorLogicManager = ARTransferDoorLogicManager.this;
                                    if (aRTransferDoorLogicManager.B.f198296d.f198311k == 0) {
                                        z19 = true;
                                    } else {
                                        z19 = false;
                                    }
                                    aRTransferDoorLogicManager.s(iArr4, iArr5, iArr6, z19);
                                    ARTransferDoorLogicManager.this.B.f198296d.f198311k++;
                                    QLog.i(ARTransferDoorLogicManager.C, 1, "DrawCircle. mDrawCirclePuase = " + ARTransferDoorLogicManager.this.f196852y + ", genIdx = " + ARTransferDoorLogicManager.this.B.f198296d.f198311k);
                                    i48++;
                                }
                                if (!ARTransferDoorLogicManager.this.f196852y && (weakReference = ARTransferDoorLogicManager.this.f196836i) != null && weakReference.get() != null) {
                                    ARTransferDoorLogicManager.this.f196836i.get().Y0(this, ARTransferDoorLogicManager.this.A);
                                }
                            }
                        };
                        QLog.i(str, 1, "DrawCircle. resume. mDrawCirclePuase = " + this.f196852y + ", genIdx = " + this.B.f198296d.f198311k);
                        WeakReference<QQARSession> weakReference = this.f196836i;
                        if (weakReference != null && weakReference.get() != null && !this.f196852y) {
                            this.f196836i.get().Y0(runnable, this.A);
                        }
                    }
                }
            }
        }
        y.b bVar4 = this.B.f198296d;
        if (bVar4.f198301a == -1 && bVar4.f198302b != -1 && bVar4.f198305e > 0) {
            this.f196852y = true;
            y();
            l(3);
            this.f196851x = System.currentTimeMillis();
            WeakReference<QQARSession> weakReference2 = this.f196836i;
            if (weakReference2 != null && weakReference2.get() != null) {
                this.f196836i.get().Y0(new Runnable() { // from class: com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ARTransferDoorLogicManager.this.B.f198296d.f198301a == 0) {
                            ARTransferDoorLogicManager.this.l(5);
                        } else if (ARTransferDoorLogicManager.this.B.f198296d.f198305e == 0) {
                            ARTransferDoorLogicManager.this.C();
                        }
                        ARTransferDoorLogicManager.this.f196851x = 0L;
                    }
                }, 1000L);
            }
        }
        QLog.i(C, 1, "zoomOutWorldCupSparks curent state " + this.B.f198296d.f198301a);
        y.b bVar5 = this.B.f198296d;
        if (bVar5.f198301a == 0 && bVar5.f198302b != 0) {
            l(5);
            F(2);
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.3
                @Override // java.lang.Runnable
                public void run() {
                    ReportController.o(null, "dc00898", "", "", "0X80098C9", "0X80098C9", 0, 0, ARTransferDoorLogicManager.this.f196849v, "", "", "");
                }
            });
            WeakReference<QQARSession> weakReference3 = this.f196836i;
            if (weakReference3 != null && weakReference3.get() != null) {
                this.f196836i.get().Y0(new Runnable() { // from class: com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AVGestureWrapper.clearCache();
                        } catch (Exception e16) {
                            QLog.i(ARTransferDoorLogicManager.C, 2, "AVGestureWrapper.clearCache failed. err = " + e16.getMessage());
                        } catch (UnsatisfiedLinkError e17) {
                            QLog.i(ARTransferDoorLogicManager.C, 2, "AVGestureWrapper.clearCache failed. UnsatisfiedLinkError. err = " + e17.getMessage());
                        }
                        ARTransferDoorLogicManager.this.J();
                    }
                }, 1500L);
            }
        }
    }

    public void y() {
        this.f196851x = 0L;
        this.f196852y = true;
        this.f196853z = 0;
        this.A = 15;
    }

    public void z(QQARSession qQARSession) {
        this.f196836i = new WeakReference<>(qQARSession);
    }
}
