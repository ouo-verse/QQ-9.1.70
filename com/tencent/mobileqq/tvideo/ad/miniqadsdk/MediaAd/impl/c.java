package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.QAdBaseVideoController;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.QAdInsideAdConstance$CustomCmd;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.player.QAdPlayerManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.QAdBaseVideoView;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadutils.QAdDeviceUtils;
import com.tencent.qqlive.playerinterface.QAdUserInfo;
import com.tencent.qqlive.playerinterface.QAdVideoItem;
import java.util.ArrayList;
import kt3.b;
import kt3.h;
import kt3.j;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class c implements b.InterfaceC10678b, bv2.b, b.a {
    protected static String M;
    protected volatile QAdUserInfo D;
    protected volatile j E;
    protected volatile String F;
    protected ViewGroup H;
    private volatile long I;
    protected ju2.a J;

    /* renamed from: d, reason: collision with root package name */
    protected volatile Context f303629d;

    /* renamed from: e, reason: collision with root package name */
    protected QAdPlayerManager f303630e;

    /* renamed from: h, reason: collision with root package name */
    protected QAdBaseVideoController f303632h;

    /* renamed from: i, reason: collision with root package name */
    protected volatile kt3.d f303633i;

    /* renamed from: m, reason: collision with root package name */
    protected volatile a f303634m;

    /* renamed from: f, reason: collision with root package name */
    protected volatile long f303631f = 0;
    protected volatile int C = 0;
    private volatile boolean G = false;
    protected final vu2.a L = new vu2.a(u());
    protected String K = pw2.b.a();

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void n(int i3, int i16);
    }

    public c(Context context, ViewGroup viewGroup) {
        QAdPlayerManager qAdPlayerManager = new QAdPlayerManager(context, viewGroup, F());
        this.f303630e = qAdPlayerManager;
        qAdPlayerManager.G(this);
        this.f303630e.F(this);
        this.f303629d = context;
        this.H = viewGroup;
    }

    private void A(long j3) {
        this.I = j3;
        kt3.d dVar = this.f303633i;
        if (dVar != null) {
            dVar.i(u(), this.f303631f, j3);
        }
    }

    private void H(iu2.a aVar) {
        kt3.d dVar = this.f303633i;
        if (dVar != null) {
            n.e(M, "onAdError, adType = " + u() + ",errorType = 1,errorCode = " + aVar.a());
            this.C = 7;
            dVar.l(u(), 1, aVar.a(), new h(aVar.d(), aVar.c(), 0L));
        }
        K(4);
    }

    private void I(int i3, long j3) {
        kt3.d dVar = this.f303633i;
        if (dVar != null) {
            n.e(M, "onAdPlayerError, adType = " + u() + ",errorType = 1,errorCode = " + i3);
            this.C = 7;
            dVar.c(u(), 1, i3, new h(j3));
        }
        K(3);
    }

    private synchronized void t(@NonNull iu2.a aVar) {
        if (this.f303632h != null && aVar.a() != 101) {
            String t06 = this.f303632h.t0();
            String j3 = QAdDeviceUtils.j();
            String valueOf = String.valueOf(QAdVideoHelper.h(this.E, j3));
            String valueOf2 = String.valueOf(QAdDeviceUtils.m(j3));
            tu2.a d16 = QAdVideoHelper.d(this.E);
            tu2.b e16 = QAdVideoHelper.e(this.D);
            this.f303632h.x1(true);
            this.f303632h.f0(aVar, d16, e16, this.F, t06, valueOf2, valueOf);
        }
    }

    private void x(int i3) {
        n.e(M, "handleAdPlayerErrorFail, errorCode = " + i3);
        QAdBaseVideoController qAdBaseVideoController = this.f303632h;
        if (qAdBaseVideoController != null) {
            qAdBaseVideoController.Z0(i3);
            this.f303632h.J0(QAdBaseVideoView.SkipCause.PLAY_FAILED);
            this.f303632h.a1(3, i3);
        }
        I(i3, this.f303630e.m());
    }

    private void y(int i3) {
        n.e(M, "handleAdPlayerErrorStuck, errorCode = " + i3);
        QAdBaseVideoController qAdBaseVideoController = this.f303632h;
        if (qAdBaseVideoController != null) {
            qAdBaseVideoController.Z0(i3);
            this.f303632h.J0(QAdBaseVideoView.SkipCause.PLAY_STUCK);
            this.f303632h.a1(4, i3);
        }
        I(i3, this.f303630e.m());
    }

    protected boolean F() {
        return false;
    }

    public void G(int i3) {
        n.e(M, "notifyAdComplete, getCurrentPosition = " + this.I);
        kt3.d dVar = this.f303633i;
        if (dVar != null) {
            this.C = 7;
            dVar.h(u(), this.I);
        }
        K(i3);
    }

    public void J(int i3) {
        G(i3);
    }

    public void K(int i3) {
        n.e(M, "onAdVideoFinish");
        this.C = 7;
        a aVar = this.f303634m;
        if (aVar != null) {
            aVar.n(u(), i3);
        }
    }

    public Object L(String str, Object obj) {
        kt3.d dVar = this.f303633i;
        if (dVar != null) {
            return dVar.g(u(), str, obj);
        }
        return null;
    }

    public synchronized boolean M() {
        n.e(M, "pauseAd");
        if (this.G) {
            n.e(M, "pauseAd 1, isPauseBySelf");
            return true;
        }
        if (this.C == 5) {
            boolean x16 = this.f303630e.x();
            n.e(M, "pauseAd 2, attempt to call mQAdPlayerManager.pause()");
            if (x16) {
                n.e(M, "pauseAd 3, mQAdPlayerManager.pause() success");
                this.f303632h.e1();
                kt3.d dVar = this.f303633i;
                if (this.C != 6 && dVar != null) {
                    this.C = 6;
                }
            }
            return true;
        }
        return false;
    }

    public synchronized void N() {
        n.e(M, "release");
        QAdBaseVideoController qAdBaseVideoController = this.f303632h;
        if (qAdBaseVideoController != null) {
            qAdBaseVideoController.F();
            this.f303632h.f1();
        }
        this.f303630e.y();
        this.C = 7;
        this.f303629d = null;
        this.f303631f = 0L;
        this.G = false;
    }

    public boolean O(boolean z16) {
        return this.f303630e.D(z16);
    }

    public synchronized void P(kt3.d dVar) {
        this.f303633i = dVar;
    }

    public synchronized void Q(a aVar) {
        this.f303634m = aVar;
    }

    public synchronized boolean R() {
        if (this.G) {
            n.e(M, "startAd 1, isPauseBySelf");
            return true;
        }
        boolean z16 = false;
        if (this.C != 4 && this.C != 6) {
            return false;
        }
        n.e(M, "startAd 2, attempt to call mQAdPlayerManager.start()");
        if (this.f303630e.I()) {
            n.e(M, "call-ad startAd 3, mQAdPlayerManager.start() success");
            this.f303632h.z(v());
            QAdBaseVideoController qAdBaseVideoController = this.f303632h;
            if (this.C == 4) {
                z16 = true;
            }
            qAdBaseVideoController.H1(z16);
            kt3.d dVar = this.f303633i;
            if (this.C != 5 && dVar != null) {
                this.C = 5;
                n.e(M, "startAd, CurrentPositionMs = " + this.f303630e.m());
            }
        }
        return true;
    }

    public synchronized void S(String str) {
        this.F = str;
    }

    public synchronized void T(QAdUserInfo qAdUserInfo) {
        this.D = qAdUserInfo;
        this.f303630e.L(qAdUserInfo);
    }

    public synchronized void U(j jVar) {
        this.E = jVar;
        QAdBaseVideoController qAdBaseVideoController = this.f303632h;
        if (qAdBaseVideoController != null) {
            qAdBaseVideoController.Q1(jVar);
        }
        n.a(M, "updateVideoInfo, mAdRequestParamMap: " + jVar.c());
    }

    public void V(long j3) {
        if (this.E != null) {
            this.E.s(j3);
        }
    }

    @Override // bv2.b
    public void b(int i3) {
        kt3.d dVar = this.f303633i;
        if (dVar != null) {
            n.e(M, "onFinishAd, adType = " + i3);
            dVar.b(u());
        }
    }

    @Override // bv2.a
    public j c() {
        return this.E;
    }

    @Override // bv2.a
    public int d() {
        return (int) this.f303630e.m();
    }

    @Override // kt3.b.a
    public void f(int i3, int i16) {
        L(QAdInsideAdConstance$CustomCmd.STREAM_SIZE_TRANSFER, new int[]{i3, i16});
    }

    @Override // bv2.a
    public void g() {
        kt3.d dVar = this.f303633i;
        if (dVar != null) {
            dVar.onWarnerTipClick(u());
        }
    }

    @Override // bv2.a
    public void h() {
        kt3.d dVar = this.f303633i;
        if (dVar != null) {
            n.e(M, " onSkipAdClicked");
            dVar.d(u(), this.f303630e.m(), false, this.f303632h.Q0(), this.f303632h.v0());
        }
    }

    @Override // bv2.a
    public void i(long j3) {
        A(j3);
    }

    @Override // bv2.a
    public void k(iu2.a aVar) {
        int a16 = aVar.a();
        n.b(M, "onFailed, errcode: " + aVar.a() + " msg: " + aVar.c());
        H(aVar);
        if (a16 == 101) {
            B();
        } else {
            t(aVar);
        }
    }

    @Override // bv2.a
    public void l(boolean z16) {
        if (z16) {
            n.e(M, "onForceSkipAd: skipAll");
            this.I = this.f303630e.m();
            this.f303630e.g();
            QAdBaseVideoController qAdBaseVideoController = this.f303632h;
            if (qAdBaseVideoController != null) {
                qAdBaseVideoController.J0(QAdBaseVideoView.SkipCause.FORCE_SKIP);
            }
            G(2);
            return;
        }
        n.e(M, "onForceSkipAd: skip current clip");
        this.f303630e.C();
    }

    @Override // kt3.b.a
    public void m() {
        QAdBaseVideoController qAdBaseVideoController;
        n.e(M, "call-ad, onPlayerViewStartRender, status = " + this.C);
        if ((this.C == 5 || this.C == 6) && (qAdBaseVideoController = this.f303632h) != null && this.f303630e != null) {
            qAdBaseVideoController.z(v());
        }
    }

    @Override // kt3.b.a
    public void n(int i3) {
        n.e(M, "onMediaPlayerStatusCallback, status = " + i3);
        if (this.f303633i == null) {
            return;
        }
        if (i3 != 3) {
            if (i3 != 6) {
                if (i3 == 7) {
                    J(0);
                    return;
                }
                return;
            }
            this.C = 6;
            return;
        }
        C();
    }

    @Override // bv2.a
    public synchronized void o() {
        n.e(M, "onResumeAdApplied");
        this.G = false;
        R();
    }

    @Override // kt3.b.InterfaceC10678b
    public void onEvent(int i3, int i16, int i17, Object obj) {
        n.a(M, "onPlayerEvent, what = " + i3 + ", arg1 = " + i16 + ", arg2 = " + i17 + ", obj = " + obj);
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        x(i16);
                        return;
                    }
                    return;
                }
                y(i16);
                return;
            }
            z();
            return;
        }
        w();
    }

    @Override // bv2.a
    public void p(@NonNull com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c[] cVarArr, int i3) {
        String str;
        n.e(M, " onReceiveAd");
        synchronized (this) {
            n.e(M, "onReceiveAd: isVideoAd=true");
            this.f303631f = yu2.b.f(cVarArr, true);
            this.C = 2;
        }
        if (this.E != null) {
            str = this.E.d();
        } else {
            str = "";
        }
        ArrayList<QAdVideoItem> a16 = QAdVideoHelper.a(cVarArr, str);
        kt3.d dVar = this.f303633i;
        if (dVar != null) {
            dVar.e(u(), this.f303631f, a16);
        }
        D();
        synchronized (this) {
            if (this.C == 2) {
                n.e(M, " onReceiveAd\uff0c open media player");
                this.f303630e.w(a16);
                this.C = 3;
                n.e(M, "change status preparing");
            }
        }
    }

    @Override // bv2.a
    public synchronized void q() {
        n.e(M, "onPauseAdApplied");
        M();
        this.G = true;
    }

    @Override // bv2.b
    public void r(iu2.a aVar) {
        if (aVar != null) {
            t(aVar);
        }
    }

    public void s(int i3) {
        synchronized (this) {
            n.e(M, "closeAd, reason = " + i3);
            this.f303630e.g();
            QAdBaseVideoController qAdBaseVideoController = this.f303632h;
            if (qAdBaseVideoController != null) {
                qAdBaseVideoController.J0(com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.player.a.a(i3));
            }
        }
    }

    public abstract int u();

    public ViewGroup v() {
        QAdPlayerManager qAdPlayerManager = this.f303630e;
        if (qAdPlayerManager != null) {
            return qAdPlayerManager.n();
        }
        return null;
    }

    protected void w() {
        n.e(M, "handleAdPlayerComplete");
        this.f303632h.H0();
        G(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z() {
        n.e(M, "handleAdPlayerPrepared");
        synchronized (this) {
            this.f303632h.I0();
            if (this.C == 3) {
                this.C = 4;
                n.e(M, "handleAdPlayerPrepared 1, status change to prepared");
            }
        }
        kt3.d dVar = this.f303633i;
        if (dVar != null) {
            dVar.a(u(), this.f303631f);
            n.e(M, "handleAdPlayerPrepared 2, notify ad prepared to player");
        }
    }

    protected void B() {
    }

    protected void C() {
    }

    protected void D() {
    }

    public void E() {
    }

    @Override // bv2.a
    public void a() {
    }
}
