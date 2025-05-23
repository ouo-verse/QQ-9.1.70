package com.qq.e.comm.plugin.tangramsplash.interactive.c;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.base.ad.model.InteractiveInfo;
import com.qq.e.comm.plugin.base.ad.model.k;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.base.ad.model.v;
import com.qq.e.comm.plugin.k.aa;
import com.qq.e.comm.plugin.k.ak;
import com.qq.e.comm.plugin.k.at;
import com.qq.e.comm.plugin.k.h;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.plugin.tangramsplash.interactive.a.d;
import com.qq.e.comm.plugin.tangramsplash.interactive.c;
import com.qq.e.comm.plugin.tangramsplash.interactive.f;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ams.fusion.widget.flipcard.FlipCardInfo;
import com.tencent.ams.fusion.widget.flipcard.FlipCardInteractiveListener;
import com.tencent.ams.fusion.widget.flipcard.FlipCardView;
import com.tencent.ams.fusion.widget.flipcard.IFlipCardView;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends d {
    private static int aA = 2;
    private static int aB = 3;
    private static int aC = 4;

    /* renamed from: au, reason: collision with root package name */
    private static int f40186au = 1000;

    /* renamed from: av, reason: collision with root package name */
    private static int f40187av = 1001;

    /* renamed from: aw, reason: collision with root package name */
    private static int f40188aw = 1002;

    /* renamed from: ax, reason: collision with root package name */
    private static int f40189ax = 1003;

    /* renamed from: ay, reason: collision with root package name */
    private static int f40190ay = 0;

    /* renamed from: az, reason: collision with root package name */
    private static int f40191az = 1;
    private final Runnable aD;

    /* renamed from: ah, reason: collision with root package name */
    protected volatile float f40192ah;

    /* renamed from: ai, reason: collision with root package name */
    protected volatile float f40193ai;

    /* renamed from: aj, reason: collision with root package name */
    protected volatile float f40194aj;

    /* renamed from: ak, reason: collision with root package name */
    protected volatile float f40195ak;

    /* renamed from: al, reason: collision with root package name */
    protected volatile float f40196al;

    /* renamed from: am, reason: collision with root package name */
    protected volatile float f40197am;

    /* renamed from: an, reason: collision with root package name */
    protected volatile float f40198an;

    /* renamed from: ao, reason: collision with root package name */
    protected volatile boolean f40199ao;

    /* renamed from: ap, reason: collision with root package name */
    private volatile FlipCardView f40200ap;

    /* renamed from: aq, reason: collision with root package name */
    private volatile int f40201aq;

    /* renamed from: ar, reason: collision with root package name */
    private volatile boolean f40202ar;

    /* renamed from: as, reason: collision with root package name */
    private volatile int f40203as;

    /* renamed from: at, reason: collision with root package name */
    private volatile float f40204at;

    public a(r rVar, c cVar) {
        super(rVar, cVar);
        this.f40200ap = null;
        this.f40201aq = -1;
        this.f40203as = f40190ay;
        this.aD = new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.c.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (((d) a.this).f40156ae != null) {
                    GDTLogger.d("FlipCardAdend card animation finished auto jump");
                    a.this.n();
                    ((d) a.this).f40156ae.b();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C() {
        InteractiveInfo interactiveInfo = this.f40115aa;
        if (interactiveInfo != null && interactiveInfo.n() == com.qq.e.comm.plugin.tangramsplash.interactive.a.M) {
            return true;
        }
        return false;
    }

    private void D() {
        File file;
        File file2;
        int i3;
        int i16;
        int i17;
        r rVar = this.X;
        InteractiveInfo interactiveInfo = this.f40115aa;
        if (rVar != null && interactiveInfo != null) {
            k bK = rVar.bK();
            if (bK == null) {
                GDTLogger.e("buildFlipWidget error, extraCardInfo or easterEggInfo null");
                return;
            }
            v H = rVar.H(3);
            if (H == null) {
                GDTLogger.e("buildFlipWidget error, splashAreaInfo null");
                return;
            }
            InteractiveInfo.a f16 = interactiveInfo.f();
            if (f16 != null && f16.a()) {
                File a16 = at.a(1, rVar.s(), f16.f38880a);
                File a17 = at.a(1, rVar.s(), f16.f38888i);
                if (a16.exists() && a17.exists()) {
                    file2 = a17;
                    file = a16;
                } else {
                    a(f40187av, "\u5f69\u86cb\u9875\u7d20\u6750\u672a\u4e0b\u8f7d\u5b8c\u6210");
                    return;
                }
            } else {
                file = null;
                file2 = null;
            }
            int c16 = ak.c(GDTADManager.getInstance().getAppContext(), H.c());
            int c17 = ak.c(GDTADManager.getInstance().getAppContext(), H.d());
            int d16 = ak.d(GDTADManager.getInstance().getAppContext(), H.e());
            int a18 = ak.a((ak.b(GDTADManager.getInstance().getAppContext()) - c16) - c17, H.f());
            int z16 = interactiveInfo.z();
            if (interactiveInfo.y()) {
                if (z16 <= 0) {
                    z16 = 8;
                }
                try {
                    i16 = z16;
                    i3 = Color.parseColor(interactiveInfo.d());
                } catch (Throwable th5) {
                    GDTLogger.e("FlipCardAdtrack color error", th5);
                }
                this.f40200ap = new FlipCardView(GDTADManager.getInstance().getAppContext());
                a(rVar, interactiveInfo, bK, f16, file, file2, c16, c17, d16, a18, i16, i3);
                if (f16 != null && ((i17 = f16.f38890k) == 2 || i17 == 3)) {
                    this.f40200ap.setBonusPageClickListener(new IFlipCardView.BonusPageClickListener() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.c.a.2
                        @Override // com.tencent.ams.fusion.widget.flipcard.IFlipCardView.BonusPageClickListener
                        public void onClick(float f17, float f18) {
                            GDTLogger.d("FlipCardAdend card clicked remove auto jump task and jump now");
                            a.this.m();
                            a.this.f40200ap.removeCallbacks(a.this.aD);
                            if (((d) a.this).f40156ae != null) {
                                ((d) a.this).f40156ae.b();
                            }
                        }
                    });
                }
                this.f40200ap.setInteractiveListener(new FlipCardInteractiveListener() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.c.a.3
                    @Override // com.tencent.ams.fusion.widget.flipcard.FlipCardInteractiveListener
                    public void onEndAnimationFinish() {
                        InteractiveInfo.a aVar;
                        GDTLogger.d("FlipCardAd[onEndAnimationFinish] ");
                        a.this.k();
                        if (!a.this.f40202ar) {
                            FlipCardView flipCardView = a.this.f40200ap;
                            if (((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).f40115aa != null) {
                                aVar = ((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).f40115aa.f();
                            } else {
                                aVar = null;
                            }
                            if (aVar != null) {
                                int i18 = aVar.f38890k;
                                if (flipCardView != null) {
                                    if (i18 == 1 || i18 == 3) {
                                        flipCardView.postDelayed(a.this.aD, aVar.f38891l);
                                    }
                                }
                            }
                        }
                    }

                    @Override // com.tencent.ams.fusion.widget.flipcard.FlipCardInteractiveListener
                    public void onEndAnimationStart() {
                        GDTLogger.d("FlipCardAd[onEndAnimationStart] ");
                        com.qq.e.comm.plugin.tangramsplash.interactive.b bVar = ((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).Z;
                        if (bVar != null) {
                            bVar.b();
                        }
                        a.this.i();
                    }

                    @Override // com.tencent.ams.fusion.widget.flipcard.FlipCardInteractiveListener
                    public void onInteractFinish(int i18, boolean z17, Point point) {
                        GDTLogger.d("FlipCardAd[onInteractFinish] " + z17);
                        if (point != null && i18 == 2) {
                            float abs = Math.abs(point.y - a.this.f40193ai);
                            if (abs > a.this.f40194aj) {
                                a.this.f40194aj = abs;
                                a aVar = a.this;
                                aVar.f40195ak = aVar.f40192ah;
                                a aVar2 = a.this;
                                aVar2.f40196al = aVar2.f40193ai;
                                a.this.f40197am = point.x;
                                a.this.f40198an = point.y;
                            }
                        }
                    }

                    @Override // com.tencent.ams.fusion.widget.flipcard.FlipCardInteractiveListener
                    public void onInteractProgress(float f17) {
                        GDTLogger.d("FlipCardAd[onInteractProgress] " + f17);
                    }

                    @Override // com.tencent.ams.fusion.widget.flipcard.FlipCardInteractiveListener
                    public void onInteractResult(int i18, boolean z17, int i19, Point point, float f17) {
                        a.this.a(i18, z17, i19, f17);
                    }

                    @Override // com.tencent.ams.fusion.widget.flipcard.FlipCardInteractiveListener
                    public void onInteractStart(int i18, Point point) {
                        GDTLogger.d("FlipCardAd[onInteractStart]");
                        if (point != null && i18 == 2) {
                            a.this.f40192ah = point.x;
                            a.this.f40193ai = point.y;
                        }
                        if (!a.this.f40199ao) {
                            a.this.f40199ao = true;
                            a.this.e();
                        }
                    }

                    @Override // com.tencent.ams.fusion.widget.flipcard.FlipCardInteractiveListener
                    public void onSensorError() {
                        GDTLogger.e("FlipCardAd[onSensorError] ");
                        a.this.a(a.f40188aw, "\u4f20\u611f\u5668\u5f02\u5e38");
                    }

                    @Override // com.tencent.ams.fusion.widget.flipcard.FlipCardInteractiveListener
                    public void onBackInteractProgress(float f17) {
                    }
                });
                return;
            }
            i3 = -1;
            i16 = z16;
            this.f40200ap = new FlipCardView(GDTADManager.getInstance().getAppContext());
            a(rVar, interactiveInfo, bK, f16, file, file2, c16, c17, d16, a18, i16, i3);
            if (f16 != null) {
                this.f40200ap.setBonusPageClickListener(new IFlipCardView.BonusPageClickListener() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.c.a.2
                    @Override // com.tencent.ams.fusion.widget.flipcard.IFlipCardView.BonusPageClickListener
                    public void onClick(float f17, float f18) {
                        GDTLogger.d("FlipCardAdend card clicked remove auto jump task and jump now");
                        a.this.m();
                        a.this.f40200ap.removeCallbacks(a.this.aD);
                        if (((d) a.this).f40156ae != null) {
                            ((d) a.this).f40156ae.b();
                        }
                    }
                });
            }
            this.f40200ap.setInteractiveListener(new FlipCardInteractiveListener() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.c.a.3
                @Override // com.tencent.ams.fusion.widget.flipcard.FlipCardInteractiveListener
                public void onEndAnimationFinish() {
                    InteractiveInfo.a aVar;
                    GDTLogger.d("FlipCardAd[onEndAnimationFinish] ");
                    a.this.k();
                    if (!a.this.f40202ar) {
                        FlipCardView flipCardView = a.this.f40200ap;
                        if (((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).f40115aa != null) {
                            aVar = ((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).f40115aa.f();
                        } else {
                            aVar = null;
                        }
                        if (aVar != null) {
                            int i18 = aVar.f38890k;
                            if (flipCardView != null) {
                                if (i18 == 1 || i18 == 3) {
                                    flipCardView.postDelayed(a.this.aD, aVar.f38891l);
                                }
                            }
                        }
                    }
                }

                @Override // com.tencent.ams.fusion.widget.flipcard.FlipCardInteractiveListener
                public void onEndAnimationStart() {
                    GDTLogger.d("FlipCardAd[onEndAnimationStart] ");
                    com.qq.e.comm.plugin.tangramsplash.interactive.b bVar = ((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).Z;
                    if (bVar != null) {
                        bVar.b();
                    }
                    a.this.i();
                }

                @Override // com.tencent.ams.fusion.widget.flipcard.FlipCardInteractiveListener
                public void onInteractFinish(int i18, boolean z17, Point point) {
                    GDTLogger.d("FlipCardAd[onInteractFinish] " + z17);
                    if (point != null && i18 == 2) {
                        float abs = Math.abs(point.y - a.this.f40193ai);
                        if (abs > a.this.f40194aj) {
                            a.this.f40194aj = abs;
                            a aVar = a.this;
                            aVar.f40195ak = aVar.f40192ah;
                            a aVar2 = a.this;
                            aVar2.f40196al = aVar2.f40193ai;
                            a.this.f40197am = point.x;
                            a.this.f40198an = point.y;
                        }
                    }
                }

                @Override // com.tencent.ams.fusion.widget.flipcard.FlipCardInteractiveListener
                public void onInteractProgress(float f17) {
                    GDTLogger.d("FlipCardAd[onInteractProgress] " + f17);
                }

                @Override // com.tencent.ams.fusion.widget.flipcard.FlipCardInteractiveListener
                public void onInteractResult(int i18, boolean z17, int i19, Point point, float f17) {
                    a.this.a(i18, z17, i19, f17);
                }

                @Override // com.tencent.ams.fusion.widget.flipcard.FlipCardInteractiveListener
                public void onInteractStart(int i18, Point point) {
                    GDTLogger.d("FlipCardAd[onInteractStart]");
                    if (point != null && i18 == 2) {
                        a.this.f40192ah = point.x;
                        a.this.f40193ai = point.y;
                    }
                    if (!a.this.f40199ao) {
                        a.this.f40199ao = true;
                        a.this.e();
                    }
                }

                @Override // com.tencent.ams.fusion.widget.flipcard.FlipCardInteractiveListener
                public void onSensorError() {
                    GDTLogger.e("FlipCardAd[onSensorError] ");
                    a.this.a(a.f40188aw, "\u4f20\u611f\u5668\u5f02\u5e38");
                }

                @Override // com.tencent.ams.fusion.widget.flipcard.FlipCardInteractiveListener
                public void onBackInteractProgress(float f17) {
                }
            });
            return;
        }
        GDTLogger.e("buildFlipWidget error, adInfo or interactiveInfo null");
    }

    private void E() {
        FlipCardView flipCardView = this.f40200ap;
        if (flipCardView != null) {
            flipCardView.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void s() {
        if (this.f40200ap != null) {
            this.f40200ap.removeCallbacks(this.aD);
        }
        j();
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void w() {
        boolean z16;
        super.w();
        r rVar = this.X;
        if (rVar != null && rVar.ca()) {
            z16 = true;
        } else {
            z16 = false;
        }
        FlipCardView flipCardView = this.f40200ap;
        if (flipCardView != null && z16) {
            flipCardView.pause();
        }
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void x() {
        boolean z16;
        super.x();
        r rVar = this.X;
        if (rVar != null && rVar.ca()) {
            z16 = true;
        } else {
            z16 = false;
        }
        FlipCardView flipCardView = this.f40200ap;
        if (flipCardView != null && z16) {
            flipCardView.resume();
        }
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    protected void b() {
        D();
        a(new f.a() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.c.a.1
            @Override // com.qq.e.comm.plugin.tangramsplash.interactive.f.a
            public void a(boolean z16) {
                GDTLogger.d("FlipCardAddrawInteractiveView enable:" + z16);
                FlipCardView flipCardView = a.this.f40200ap;
                if (flipCardView == null) {
                    GDTLogger.e("FlipCardAdflipCardView view null");
                    return;
                }
                if (z16) {
                    a.this.h();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    com.qq.e.comm.plugin.tangramsplash.interactive.b bVar = ((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).Z;
                    if (bVar != null) {
                        try {
                            bVar.a(flipCardView, layoutParams);
                            flipCardView.start();
                            return;
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                flipCardView.setEnabled(false);
                flipCardView.stop();
                flipCardView.setVisibility(8);
                flipCardView.setInteractiveListener(null);
                a aVar = a.this;
                aVar.a(((d) aVar).f40158ag);
                GDTLogger.d("InterativeViewTask cardWidget not enable");
            }
        });
    }

    protected void c(int i3) {
        r rVar = this.X;
        if (rVar == null) {
            return;
        }
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.a(rVar.s());
        bVar.b(rVar.f());
        bVar.c(rVar.y());
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        c cVar2 = this.Y;
        if (cVar2 != null) {
            cVar.a("startMode", com.qq.e.comm.plugin.tangramsplash.d.a.a(cVar2.f40183b));
        }
        if (this.X.bJ() != null) {
            int n3 = this.X.bJ().n();
            if (n3 != Integer.MIN_VALUE) {
                cVar.a("error_code", String.valueOf(n3));
            }
            if (this.f40203as != Integer.MIN_VALUE) {
                cVar.a("code", String.valueOf(this.f40203as));
            }
            cVar.a("startX", Integer.valueOf((int) this.f40195ak));
            cVar.a("startY", Integer.valueOf((int) this.f40196al));
            cVar.a("endX", Integer.valueOf((int) this.f40197am));
            cVar.a("endY", Integer.valueOf((int) this.f40198an));
            cVar.a("angle", Integer.valueOf((int) this.f40204at));
        }
        if (i3 != -1) {
            cVar.a("httpErrorCode", Integer.valueOf(i3));
        }
        StatTracer.trackEvent(1310394, 0, bVar, cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void p() {
        this.f40202ar = true;
        try {
            E();
            final FlipCardView flipCardView = this.f40200ap;
            if (flipCardView != null) {
                flipCardView.removeCallbacks(this.aD);
                flipCardView.post(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.c.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        flipCardView.setVisibility(8);
                    }
                });
                flipCardView.setInteractiveListener(null);
            }
        } catch (Throwable th5) {
            GDTLogger.e("FlipCardView clear error:", th5);
        }
        this.f40200ap = null;
        c(this.f40201aq);
        super.p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void q() {
        try {
            E();
        } catch (Throwable th5) {
            GDTLogger.e("FlipCardView clearFromOutSide error:", th5);
        }
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    protected boolean a() {
        if (this.X != null && this.f40115aa != null) {
            if (C()) {
                GDTLogger.d("\u7ffb\u8f6c\u65e0\u5f69\u86cb\u9875");
                return true;
            }
            z();
            return true;
        }
        GDTLogger.e("mAdInfo or mInteractiveInfo is null");
        return false;
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

    private void a(r rVar, InteractiveInfo interactiveInfo, k kVar, InteractiveInfo.a aVar, File file, File file2, int i3, int i16, int i17, int i18, int i19, int i26) {
        if (rVar != null && interactiveInfo != null && kVar != null) {
            Context appContext = GDTADManager.getInstance().getAppContext();
            FlipCardInfo build = new FlipCardInfo.Builder().setTitleText(kVar.i()).setSubTitleText(interactiveInfo.k()).setStyleType(kVar.a()).setThemeColor(kVar.e()).setBeginTime(kVar.b()).setLogoBitmap(h.a(at.a(1, rVar.s(), kVar.f()), (ImageView) null)).setProductBitmap(h.a(at.a(1, rVar.s(), kVar.g()), (ImageView) null)).setCountdownTipsText(kVar.c()).setNoCountdownTipsText(kVar.d()).setProductSlogan(kVar.h()).setInteractiveMode(interactiveInfo.J()).setRotationThreshold(interactiveInfo.C()).setSlideHotAreaDp(ak.b(appContext, i3), ak.b(appContext, i16), ak.b(appContext, i17), ak.b(appContext, i18)).setSlideThresholdDp(rVar.bU()).setStorkColor(i26).setStrokeWidthDp(i19).setEnableShowStroke(interactiveInfo.y()).setEnableBonusPage(aVar != null && aVar.a()).setBonusCardBitmap(h.a(file2, (ImageView) null)).setBonusPageText(aVar != null ? aVar.f38889j : "").setDetailBitmap(h.a(file, (ImageView) null)).build();
            if (this.f40200ap != null) {
                this.f40200ap.setFlipCardInfo(build);
                return;
            }
            return;
        }
        GDTLogger.e("FlipCardAdbuildCardInfo invalid params");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3, boolean z16, int i16, float f16) {
        this.f40204at = f16;
        GDTLogger.d("FlipCardAd[onInteractResult]:" + i3 + " result\uff1a" + z16 + " reason\uff1a" + i16);
        if (z16) {
            f();
            if (i3 == 2) {
                this.f40203as = aB;
            } else if (i3 == 3) {
                this.f40203as = f40191az;
            }
            a(i3);
            return;
        }
        this.f40201aq = i16;
        if (i3 == 2) {
            this.f40203as = aC;
        } else if (i3 == 3) {
            this.f40203as = aA;
        }
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3, String str) {
        GDTLogger.e("FlipCardAd handleError :" + i3 + " message :" + str);
        com.qq.e.comm.plugin.tangramsplash.interactive.b bVar = this.Z;
        if (bVar != null) {
            bVar.a(i3, str);
        }
    }

    protected void a(int i3) {
        b(i3);
        aa.a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.c.a.5
            @Override // java.lang.Runnable
            public void run() {
                com.qq.e.comm.plugin.tangramsplash.interactive.b bVar = ((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).Z;
                try {
                    if (((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).f40115aa != null) {
                        if (((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).f40115aa.r()) {
                            com.qq.e.comm.plugin.tangramsplash.d.f.a(500L);
                        }
                        if (!a.this.C() && ((d) a.this).f40156ae != null && ((d) a.this).f40156ae.a() && bVar != null) {
                            GDTLogger.i("FlipCardAd clickTrigger no jump");
                            bVar.a(false);
                        } else if (bVar != null) {
                            GDTLogger.i("FlipCardAd clickTrigger jump");
                            bVar.a(true);
                        }
                    }
                } catch (Throwable unused) {
                    GDTLogger.e("FlipCardAdclickTrigger");
                }
            }
        });
    }
}
