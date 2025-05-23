package com.qq.e.comm.plugin.tangramsplash.interactive.f;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.base.ad.model.InteractiveInfo;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.base.ad.model.v;
import com.qq.e.comm.plugin.k.aa;
import com.qq.e.comm.plugin.k.ak;
import com.qq.e.comm.plugin.k.at;
import com.qq.e.comm.plugin.k.au;
import com.qq.e.comm.plugin.k.h;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.plugin.tangramsplash.interactive.a.d;
import com.qq.e.comm.plugin.tangramsplash.interactive.c;
import com.qq.e.comm.plugin.tangramsplash.interactive.e;
import com.qq.e.comm.plugin.tangramsplash.interactive.f;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends d {

    /* renamed from: ah, reason: collision with root package name */
    protected volatile float f40266ah;

    /* renamed from: ai, reason: collision with root package name */
    protected volatile float f40267ai;

    /* renamed from: aj, reason: collision with root package name */
    protected volatile float f40268aj;

    /* renamed from: ak, reason: collision with root package name */
    protected volatile float f40269ak;

    /* renamed from: al, reason: collision with root package name */
    protected volatile float f40270al;

    /* renamed from: am, reason: collision with root package name */
    protected volatile float f40271am;

    /* renamed from: an, reason: collision with root package name */
    protected volatile float f40272an;

    /* renamed from: ao, reason: collision with root package name */
    protected volatile boolean f40273ao;

    /* renamed from: ap, reason: collision with root package name */
    protected volatile int f40274ap;

    /* renamed from: aq, reason: collision with root package name */
    protected volatile float f40275aq;

    /* renamed from: ar, reason: collision with root package name */
    protected volatile boolean f40276ar;

    /* renamed from: as, reason: collision with root package name */
    protected volatile boolean f40277as;

    /* renamed from: at, reason: collision with root package name */
    protected int f40278at;

    /* renamed from: au, reason: collision with root package name */
    private SlopeSlideView f40279au;

    public a(r rVar, c cVar) {
        super(rVar, cVar);
    }

    private boolean C() {
        InteractiveInfo interactiveInfo = this.f40115aa;
        if (interactiveInfo != null && interactiveInfo.n() == com.qq.e.comm.plugin.tangramsplash.interactive.a.C) {
            return true;
        }
        return false;
    }

    private void D() {
        r rVar = this.X;
        InteractiveInfo interactiveInfo = this.f40115aa;
        if (rVar != null && interactiveInfo != null) {
            v H = rVar.H(10);
            Context appContext = GDTADManager.getInstance().getAppContext();
            if (H != null && appContext != null) {
                SlopeSlideView slopeSlideView = new SlopeSlideView(appContext);
                slopeSlideView.setTitle(interactiveInfo.j());
                slopeSlideView.setSubTitle(interactiveInfo.k());
                slopeSlideView.setIconBitmap(h.a(at.a(1, rVar.s(), interactiveInfo.u()), (ImageView) null));
                if (a(H)) {
                    a(appContext, H, slopeSlideView);
                } else {
                    StatTracer.trackEvent(1310485, 0, (com.qq.e.comm.plugin.stat.b) null);
                }
                slopeSlideView.setSlideThreshold(1, rVar.bU());
                if (interactiveInfo.y()) {
                    float z16 = interactiveInfo.z();
                    if (z16 > 0.0f) {
                        slopeSlideView.setStrokeWidthDp(z16);
                    }
                    try {
                        slopeSlideView.setStrokeColor(Color.parseColor(interactiveInfo.d()));
                    } catch (Throwable th5) {
                        GDTLogger.e("LeanForwardAd track color error", th5);
                    }
                } else {
                    slopeSlideView.setEnableShowStroke(false);
                }
                slopeSlideView.setCheckGestureMatchWhenTouchDown(false);
                boolean a16 = a(interactiveInfo);
                GDTLogger.i("LeanForwardAd  enableClick :" + a16);
                slopeSlideView.setEnableClick(a16);
                slopeSlideView.setRotationThreshold((float) interactiveInfo.E());
                slopeSlideView.setOnSlopeSlideInteractListener(new C0292a());
                this.f40279au = slopeSlideView;
                return;
            }
            GDTLogger.e("buildSlidView error, splashAreaInfo or context null");
            return;
        }
        GDTLogger.e("buildSlidView error, adInfo or interactiveInfo null");
    }

    private void E() {
        a(new f.a() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.f.a.3
            @Override // com.qq.e.comm.plugin.tangramsplash.interactive.f.a
            public void a(boolean z16) {
                GDTLogger.d("startEnableDrawAfterAdShow\uff1aenable " + z16);
                SlopeSlideView slopeSlideView = a.this.f40279au;
                if (z16) {
                    a.this.h();
                    if (((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).Z != null && slopeSlideView != null) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        com.qq.e.comm.plugin.tangramsplash.interactive.b bVar = ((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).Z;
                        if (bVar != null) {
                            try {
                                bVar.a(slopeSlideView, layoutParams);
                            } catch (Throwable th5) {
                                GDTLogger.e("LeanForwardAd ", th5);
                                return;
                            }
                        }
                        slopeSlideView.start();
                    }
                }
            }
        });
    }

    protected void B() {
        if (this.X != null && this.Y != null) {
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
                if (this.f40274ap != Integer.MIN_VALUE) {
                    cVar.a("code", String.valueOf(this.f40274ap));
                }
                cVar.a("startX", Integer.valueOf((int) this.f40269ak));
                cVar.a("startY", Integer.valueOf((int) this.f40270al));
                cVar.a("endX", Integer.valueOf((int) this.f40271am));
                cVar.a("endY", Integer.valueOf((int) this.f40272an));
                cVar.a("angle", Integer.valueOf((int) this.f40275aq));
            }
            cVar.a("startMode", com.qq.e.comm.plugin.tangramsplash.d.a.a(this.Y.f40183b));
            StatTracer.trackEvent(1310394, 0, bVar, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void p() {
        super.p();
        final SlopeSlideView slopeSlideView = this.f40279au;
        this.f40277as = true;
        if (slopeSlideView != null) {
            GDTLogger.d("LeanForwardAd clear");
            slopeSlideView.post(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.f.a.1
                @Override // java.lang.Runnable
                public void run() {
                    GDTLogger.d("interactive ad clear wo called 4");
                    slopeSlideView.setEnabled(false);
                    slopeSlideView.setVisibility(8);
                    slopeSlideView.stopAnimation();
                    slopeSlideView.setOnSlopeSlideInteractListener(null);
                }
            });
            if (this.f40276ar) {
                B();
            }
            this.f40279au = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void q() {
        GDTLogger.i("LeanForwardAd  clearFromOutSide :" + Thread.currentThread());
        try {
            SlopeSlideView slopeSlideView = this.f40279au;
            if (slopeSlideView != null) {
                slopeSlideView.stopAnimation();
            }
        } catch (Throwable th5) {
            GDTLogger.e("LeanForwardAd  clearFromOutSide error :", th5);
        }
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void w() {
        boolean z16;
        SlopeSlideView slopeSlideView = this.f40279au;
        r rVar = this.X;
        if (rVar != null && rVar.ca()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (slopeSlideView != null && z16) {
            slopeSlideView.pauseAnimation();
        }
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void x() {
        boolean z16;
        SlopeSlideView slopeSlideView = this.f40279au;
        r rVar = this.X;
        if (rVar != null && rVar.ca()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (slopeSlideView != null && z16) {
            slopeSlideView.resumeAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d
    public void y() {
        com.qq.e.comm.plugin.tangramsplash.interactive.a.b bVar = this.f40157af;
        if (bVar != null) {
            bVar.setVisibility(8);
        }
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    protected boolean a() {
        if (this.X != null && this.f40115aa != null) {
            if (C()) {
                GDTLogger.d("\u65e0\u5f69\u86cb\u9875");
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
        GDTLogger.e("mAdInfo or mInteractiveInfo is null");
        return false;
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    protected void b() {
        D();
        E();
    }

    protected void b(int i3) {
        r rVar = this.X;
        if (rVar == null || this.Y == null || rVar.bJ() == null) {
            return;
        }
        String s16 = this.X.s();
        r rVar2 = this.X;
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310482, i3, s16, rVar2, rVar2.bJ().n(), this.Y.f40183b);
    }

    private boolean a(v vVar) {
        if (vVar == null) {
            return false;
        }
        int f16 = vVar.f();
        GDTLogger.i("LeanForwardAd  getAspectRadio:" + f16);
        return f16 != 0;
    }

    private static void a(Context context, v vVar, SlopeSlideView slopeSlideView) {
        if (context == null || vVar == null || slopeSlideView == null) {
            return;
        }
        int c16 = ak.c(context, vVar.c());
        int c17 = ak.c(context, vVar.d());
        int b16 = ak.b(context);
        int c18 = ak.c(context);
        int i3 = (b16 - c16) - c17;
        if (i3 <= 0) {
            GDTLogger.i("LeanForwardAd margin too large");
        } else {
            b16 = i3;
        }
        int a16 = ak.a(b16, vVar.f());
        int d16 = ak.d(context, vVar.e());
        if (d16 >= c18) {
            GDTLogger.i("LeanForwardAd bottomMargin invalid");
            d16 = 0;
        }
        slopeSlideView.setHotArea(0, c16, c17, d16, a16);
    }

    private boolean a(InteractiveInfo interactiveInfo) {
        if (interactiveInfo == null) {
            GDTLogger.e("LeanForwardAd  containClickMode interactiveInfo == null");
            return false;
        }
        int[] J = interactiveInfo.J();
        if (J != null && J.length != 0) {
            for (int i3 : J) {
                if (i3 == 1) {
                    return true;
                }
            }
            GDTLogger.e("LeanForwardAd  not containClickMode");
            return false;
        }
        GDTLogger.e("LeanForwardAd  containClickMode modeList empty");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* renamed from: com.qq.e.comm.plugin.tangramsplash.interactive.f.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0292a implements SlopeSlideView.OnSlopSlideInteractListener {
        protected C0292a() {
        }

        @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView.OnSlopSlideInteractListener
        public void onAnimatorFinish() {
            if (!a.this.f40277as) {
                a aVar = a.this;
                aVar.a(aVar.f40278at);
            }
            GDTLogger.d("LeanForwardAd onAnimatorFinish");
        }

        @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView.OnSlopSlideInteractListener
        public void onAnimatorStart() {
            com.qq.e.comm.plugin.tangramsplash.interactive.b bVar = ((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).Z;
            if (bVar != null) {
                bVar.a();
            }
            GDTLogger.d("LeanForwardAd onAnimatorStart");
        }

        @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView.OnSlopSlideInteractListener
        public void onInteractFinish(int i3, boolean z16, Point point) {
            if (point != null && i3 == 2) {
                float abs = Math.abs(point.y - a.this.f40267ai);
                if (abs > a.this.f40268aj) {
                    a.this.f40268aj = abs;
                    a aVar = a.this;
                    aVar.f40269ak = aVar.f40266ah;
                    a aVar2 = a.this;
                    aVar2.f40270al = aVar2.f40267ai;
                    a.this.f40271am = point.x;
                    a.this.f40272an = point.y;
                }
            }
            GDTLogger.d("LeanForwardAd onInteractFinish:" + i3 + "result:" + z16);
        }

        @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView.OnSlopSlideInteractListener
        public void onInteractResult(int i3, boolean z16, int i16, Point point, float f16) {
            a.this.f40275aq = f16;
            GDTLogger.d("LeanForwardAd onInteractResult:" + i3 + " result\uff1a" + z16 + " reason\uff1a" + i16);
            a.this.f40276ar = z16;
            if (z16) {
                a aVar = a.this;
                aVar.f40278at = i3;
                if (i3 == 1) {
                    aVar.f40274ap = 1;
                } else if (i3 == 2) {
                    aVar.f40274ap = 3;
                } else if (i3 == 3) {
                    aVar.f40274ap = 5;
                }
                a.this.f();
                return;
            }
            if (i3 == 1) {
                a.this.f40274ap = 2;
            } else if (i3 == 2) {
                a.this.f40274ap = 4;
            } else if (i3 == 3) {
                if (i16 == 5) {
                    a.this.f40274ap = 6;
                } else if (i16 == 6) {
                    a.this.f40274ap = 7;
                }
            }
            a.this.g();
            a.this.B();
        }

        @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView.OnSlopSlideInteractListener
        public void onInteractStart(int i3, Point point) {
            if (point != null && i3 == 2) {
                a.this.f40266ah = point.x;
                a.this.f40267ai = point.y;
            }
            GDTLogger.d("LeanForwardAd onInteractStart" + i3);
            if (!a.this.f40273ao) {
                a.this.f40273ao = true;
                a.this.e();
            }
        }

        @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView.OnSlopSlideInteractListener
        public void onSensorError() {
            int i3;
            if (((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).f40115aa != null) {
                i3 = ((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).f40115aa.n();
            } else {
                i3 = -1;
            }
            au.a(i3, 4);
            GDTLogger.d("LeanForwardAd onSensorError");
        }

        @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView.OnSlopSlideInteractListener
        public void onInteractProgress(float f16) {
        }
    }

    protected void a(int i3) {
        b(i3);
        aa.a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.f.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.qq.e.comm.plugin.tangramsplash.interactive.b bVar = ((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).Z;
                try {
                    if (((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).f40115aa != null) {
                        if (((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).f40115aa.r()) {
                            com.qq.e.comm.plugin.tangramsplash.d.f.a(500L);
                        }
                        if (bVar != null) {
                            bVar.a(true);
                        }
                    }
                } catch (Throwable unused) {
                    GDTLogger.e("LeanForwardAd clickTrigger");
                }
            }
        });
    }
}
