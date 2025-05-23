package com.qq.e.comm.plugin.tangramsplash.interactive.d;

import android.content.Context;
import android.widget.FrameLayout;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.base.ad.model.InteractiveInfo;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.k.aa;
import com.qq.e.comm.plugin.k.ak;
import com.qq.e.comm.plugin.k.at;
import com.qq.e.comm.plugin.k.au;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.plugin.tangramsplash.d.f;
import com.qq.e.comm.plugin.tangramsplash.interactive.a.d;
import com.qq.e.comm.plugin.tangramsplash.interactive.b;
import com.qq.e.comm.plugin.tangramsplash.interactive.c;
import com.qq.e.comm.plugin.tangramsplash.interactive.e;
import com.qq.e.comm.plugin.tangramsplash.interactive.f;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ams.fusion.widget.olympicshake.OlympicShakeListener;
import com.tencent.ams.fusion.widget.olympicshake.OlympicShakeView;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends d {

    /* renamed from: ah, reason: collision with root package name */
    private OlympicShakeView f40222ah;

    /* renamed from: ai, reason: collision with root package name */
    private int f40223ai;

    /* renamed from: aj, reason: collision with root package name */
    private double f40224aj;

    /* renamed from: ak, reason: collision with root package name */
    private volatile boolean f40225ak;

    public a(r rVar, c cVar) {
        super(rVar, cVar);
        this.f40223ai = -1;
        this.f40224aj = -1.0d;
        this.f40225ak = false;
    }

    private float a(int i3, int i16) {
        if (i3 <= 0 || i3 > 10000) {
            i3 = i16;
        }
        return i3 / 1000.0f;
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void w() {
        boolean z16;
        OlympicShakeView olympicShakeView = this.f40222ah;
        r rVar = this.X;
        if (rVar != null && rVar.ca()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (olympicShakeView != null && z16) {
            olympicShakeView.pause();
        }
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void x() {
        boolean z16;
        OlympicShakeView olympicShakeView = this.f40222ah;
        r rVar = this.X;
        if (rVar != null && rVar.ca()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (olympicShakeView != null && z16) {
            olympicShakeView.resume();
        }
    }

    /* compiled from: P */
    /* renamed from: com.qq.e.comm.plugin.tangramsplash.interactive.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    protected class C0291a implements OlympicShakeListener {
        protected C0291a() {
        }

        private void a(long j3, boolean z16) {
            a(z16);
            aa.a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.d.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        b bVar = ((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).Z;
                        if (bVar != null) {
                            InteractiveInfo interactiveInfo = ((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).f40115aa;
                            if (interactiveInfo != null && interactiveInfo.r()) {
                                f.a(500L);
                            }
                            bVar.a(true);
                            a.this.f();
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            }, j3);
        }

        @Override // com.tencent.ams.fusion.widget.olympicshake.OnShakeListener
        public void onShakeComplete(double d16) {
            long j3;
            GDTLogger.i("GDT-shakingView-OlympicShakeView --- success!!! shakeValue = " + d16);
            if (((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).f40115aa == null) {
                return;
            }
            if (d16 > a.this.f40224aj) {
                a.this.f40224aj = d16;
            }
            a aVar = a.this;
            aVar.f40223ai = ((com.qq.e.comm.plugin.tangramsplash.interactive.a) aVar).f40115aa.q();
            if (((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).f40115aa.n() == com.qq.e.comm.plugin.tangramsplash.interactive.a.f40093e) {
                j3 = 500;
            } else {
                j3 = 100;
            }
            a(j3, false);
        }

        @Override // com.tencent.ams.fusion.widget.olympicshake.OlympicShakeListener
        public void onShakeIconClick() {
            if (a.this.o()) {
                GDTLogger.e("AccelerateShakingAd onShakeIconClick isMultiClick return.");
            } else {
                a(0L, true);
            }
        }

        @Override // com.tencent.ams.fusion.widget.olympicshake.OnShakeListener
        public void onShaking(double d16, int i3) {
            GDTLogger.d("GDT-shakingView-OlympicShakeView --- shakeValue = " + d16);
            GDTLogger.d("GDT-shakingView-OlympicShakeView --- shakenCount = " + i3);
            if (d16 > a.this.f40224aj) {
                a.this.f40224aj = d16;
            }
            if (i3 > a.this.f40223ai) {
                a.this.f40223ai = i3;
            }
            if (!a.this.f40225ak) {
                a.this.f40225ak = true;
                a.this.e();
            }
        }

        protected void a(boolean z16) {
            int i3 = z16 ? 1310605 : 1310606;
            if (((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).X == null || ((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).Y == null) {
                return;
            }
            com.qq.e.comm.plugin.tangramsplash.report.c.b(i3, ((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).X.s(), ((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).X, ((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).X.bJ().n(), ((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).Y.f40183b);
        }
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    protected void b() {
        GDTLogger.d("\u5965\u8fd0\u6447\u4e00\u6447\u8f7b\u4e92\u52a8\u5e7f\u544a\u5f00\u59cb\u7ed8\u5236");
        OlympicShakeView olympicShakeView = new OlympicShakeView(GDTADManager.getInstance().getAppContext());
        this.f40222ah = olympicShakeView;
        try {
            olympicShakeView.setOnShakeListener((OlympicShakeListener) new C0291a());
            InteractiveInfo interactiveInfo = this.f40115aa;
            int i3 = 1;
            if (interactiveInfo != null) {
                if (interactiveInfo.s() != 1) {
                    olympicShakeView.setShakeCircleBgShowAlways(true);
                    olympicShakeView.setShakeCircleBgRadiusDp(42.0f);
                    olympicShakeView.setShakeIconSizeDp(60.0f, 60.0f);
                }
                olympicShakeView.setShakeCircleBgColor(this.f40115aa.o());
                olympicShakeView.setTitle(this.f40115aa.j());
                olympicShakeView.setSubTitle(this.f40115aa.k());
                olympicShakeView.setShakeValue(this.f40115aa.p() / 100.0f, this.f40115aa.q());
                float a16 = a(this.f40115aa.w(), 1000);
                float a17 = a(this.f40115aa.x(), 1000);
                float a18 = a(this.f40115aa.A(), 500);
                GDTLogger.d("shake factor: x = " + a16 + ", y = " + a17 + ", fz = " + a18);
                olympicShakeView.setShakeFactor(a16, a17, a18);
                olympicShakeView.setShakeDirectCombine(this.f40115aa.G());
                olympicShakeView.setShakeSampleRate(this.f40115aa.H());
                olympicShakeView.setShakeTimeDuration(this.f40115aa.I());
                r rVar = this.X;
                int bW = rVar != null ? rVar.bW() : 0;
                r rVar2 = this.X;
                int bX = rVar2 != null ? rVar2.bX() : 0;
                r rVar3 = this.X;
                int bY = rVar3 != null ? rVar3.bY() : 0;
                Context appContext = GDTADManager.getInstance().getAppContext();
                if (bW != 0) {
                    int i16 = 36;
                    if (bW >= 36) {
                        i16 = 54;
                        if (bW > 54) {
                        }
                        olympicShakeView.setTitleTextSizeDp(ak.b(appContext, ak.a(appContext, 750, bW)));
                    }
                    bW = i16;
                    olympicShakeView.setTitleTextSizeDp(ak.b(appContext, ak.a(appContext, 750, bW)));
                }
                if (bX != 0) {
                    int i17 = 28;
                    if (bX >= 28) {
                        i17 = 42;
                        if (bX > 42) {
                        }
                        olympicShakeView.setSubTitleTextSizeDp(ak.b(appContext, ak.a(appContext, 750, bX)));
                    }
                    bX = i17;
                    olympicShakeView.setSubTitleTextSizeDp(ak.b(appContext, ak.a(appContext, 750, bX)));
                }
                if (bY != 0) {
                    int i18 = 71;
                    if (bY >= 71) {
                        i18 = 149;
                        if (bY > 149) {
                        }
                        olympicShakeView.setBottomPaddingDp(ak.b(appContext, (ak.c(appContext) * bY) / 1000));
                    }
                    bY = i18;
                    olympicShakeView.setBottomPaddingDp(ak.b(appContext, (ak.c(appContext) * bY) / 1000));
                }
            }
            InteractiveInfo interactiveInfo2 = this.f40115aa;
            au.a(interactiveInfo2 != null ? interactiveInfo2.n() : -1, 1);
            InteractiveInfo interactiveInfo3 = this.f40115aa;
            if (interactiveInfo3 != null && interactiveInfo3.t() == 3) {
                i3 = 3;
            }
            olympicShakeView.setInteractiveMode(i3);
            a(a(olympicShakeView));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void p() {
        super.p();
        b(true);
        this.f40222ah = null;
        a(this.f40223ai, this.f40224aj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void q() {
        GDTLogger.i("AccelerateShakingAd clearFromOutSide :" + Thread.currentThread());
        b(false);
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    protected boolean a() {
        InteractiveInfo interactiveInfo = this.f40115aa;
        if (interactiveInfo != null && interactiveInfo.n() == com.qq.e.comm.plugin.tangramsplash.interactive.a.f40093e) {
            GDTLogger.d("\u6447\u4e00\u6447\u65e0\u5f69\u86cb\u9875--\u7ade\u4ef7\u5e7f\u544a");
            return true;
        }
        File b16 = at.b(this.X.s(), e.d(this.X));
        if (b16 != null && b16.exists()) {
            b(b16.getAbsolutePath());
        } else {
            String s16 = this.X.s();
            r rVar = this.X;
            com.qq.e.comm.plugin.tangramsplash.report.c.b(1310370, s16, rVar, rVar.bJ().n(), this.Y.f40183b);
        }
        return true;
    }

    f.a a(final OlympicShakeView olympicShakeView) {
        return new f.a() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.d.a.1
            @Override // com.qq.e.comm.plugin.tangramsplash.interactive.f.a
            public void a(boolean z16) {
                GDTLogger.d("startEnableDrawAfterAdShow\uff1aenable " + z16);
                if (z16) {
                    a.this.h();
                    if (((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).Z != null && olympicShakeView != null) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        b bVar = ((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).Z;
                        if (bVar != null) {
                            try {
                                bVar.a(olympicShakeView, layoutParams);
                            } catch (Exception e16) {
                                e16.printStackTrace();
                            }
                        }
                        olympicShakeView.start();
                    }
                }
            }
        };
    }

    protected void a(int i3, double d16) {
        if (this.X != null) {
            com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
            bVar.a(this.X.s());
            bVar.b(this.X.f());
            bVar.c(this.X.y());
            com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
            if (this.X.bJ() != null) {
                int n3 = this.X.bJ().n();
                if (n3 != Integer.MIN_VALUE) {
                    cVar.a("error_code", String.valueOf(n3));
                }
                cVar.a("shakeCountLimit", Integer.valueOf(this.X.bJ().q()));
                cVar.a("shakeValueLimit", Float.valueOf(this.X.bJ().p() / 100.0f));
            }
            cVar.a("startMode", com.qq.e.comm.plugin.tangramsplash.d.a.a(this.Y.f40183b));
            cVar.a("shakeMaxCount", Integer.valueOf(i3));
            cVar.a("shakeMaxValue", Double.valueOf(Math.round(d16 * 100.0d) / 100.0d));
            StatTracer.trackEvent(1310394, 0, bVar, cVar);
        }
    }

    private void b(boolean z16) {
        try {
            final OlympicShakeView olympicShakeView = this.f40222ah;
            GDTLogger.d("AccelerateShakingAd interactive ad clear wo called 3");
            if (olympicShakeView != null) {
                if (z16) {
                    olympicShakeView.post(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.d.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            GDTLogger.d("AccelerateShakingAd interactive ad clear wo called 4");
                            olympicShakeView.setVisibility(8);
                        }
                    });
                }
                olympicShakeView.stop();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
