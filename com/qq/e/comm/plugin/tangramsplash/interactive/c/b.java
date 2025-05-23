package com.qq.e.comm.plugin.tangramsplash.interactive.c;

import android.text.TextUtils;
import android.widget.FrameLayout;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.base.ad.model.InteractiveInfo;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.base.ad.model.v;
import com.qq.e.comm.plugin.k.aa;
import com.qq.e.comm.plugin.k.ak;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.plugin.tangramsplash.interactive.a.d;
import com.qq.e.comm.plugin.tangramsplash.interactive.c;
import com.qq.e.comm.plugin.tangramsplash.interactive.f;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ams.fusion.widget.flip.FlipView;
import com.tencent.ams.fusion.widget.flip.IFlipInteractiveListener;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends d {

    /* renamed from: ah, reason: collision with root package name */
    private volatile FlipView f40212ah;

    /* renamed from: ai, reason: collision with root package name */
    private float f40213ai;

    /* renamed from: aj, reason: collision with root package name */
    private int f40214aj;

    public b(r rVar, c cVar) {
        super(rVar, cVar);
        this.f40214aj = Integer.MIN_VALUE;
    }

    private void D() {
        a(new f.a() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.c.b.1
            @Override // com.qq.e.comm.plugin.tangramsplash.interactive.f.a
            public void a(boolean z16) {
                GDTLogger.i("IconFlipAd drawInteractiveView enable:" + z16);
                FlipView flipView = b.this.f40212ah;
                if (flipView == null) {
                    GDTLogger.e("IconFlipAd flipView view null");
                    return;
                }
                if (z16) {
                    b.this.h();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    com.qq.e.comm.plugin.tangramsplash.interactive.b bVar = ((com.qq.e.comm.plugin.tangramsplash.interactive.a) b.this).Z;
                    if (bVar != null) {
                        try {
                            bVar.a(flipView, layoutParams);
                            flipView.start();
                            return;
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                flipView.setEnabled(false);
                flipView.stop();
                flipView.setVisibility(8);
                b bVar2 = b.this;
                bVar2.a(((d) bVar2).f40158ag);
                GDTLogger.i("InterativeViewTask flipView not enable");
            }
        });
    }

    private void E() {
        String j3;
        String k3;
        r rVar = this.X;
        InteractiveInfo interactiveInfo = this.f40115aa;
        if (rVar != null && interactiveInfo != null) {
            this.f40212ah = new FlipView(GDTADManager.getInstance().getAppContext());
            this.f40212ah.setInteractiveListener(new IFlipInteractiveListener() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.c.b.2
                @Override // com.tencent.ams.fusion.widget.flip.IFlipInteractiveListener
                public void onBackInteractProgress(float f16) {
                    GDTLogger.i("IconFlipAd onBackInteractProgress :" + f16);
                }

                @Override // com.tencent.ams.fusion.widget.flip.IFlipInteractiveListener
                public void onInteractProgress(float f16) {
                    GDTLogger.d("IconFlipAd onInteractProgress :" + f16);
                    if (Math.abs(f16) >= b.this.f40213ai) {
                        b.this.f40213ai = f16;
                    }
                }

                @Override // com.tencent.ams.fusion.widget.flip.IFlipInteractiveListener
                public void onInteractResult(int i3, boolean z16) {
                    GDTLogger.i("IconFlipAd onInteractResult :" + z16 + " i:" + i3);
                    b.this.f40214aj = i3;
                    if (z16) {
                        b.this.f();
                        b.this.B();
                    } else {
                        b.this.g();
                    }
                }

                @Override // com.tencent.ams.fusion.widget.flip.IFlipInteractiveListener
                public void onInteractStart(int i3) {
                    GDTLogger.i("IconFlipAd onInteractStart");
                    b.this.e();
                }
            });
            if (TextUtils.isEmpty(interactiveInfo.j())) {
                j3 = "\u7ffb\u8f6c\u624b\u673a";
            } else {
                j3 = interactiveInfo.j();
            }
            this.f40212ah.setTitleText(j3);
            if (TextUtils.isEmpty(interactiveInfo.k())) {
                k3 = "\u8df3\u8f6c\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528";
            } else {
                k3 = interactiveInfo.k();
            }
            this.f40212ah.setSubTitleText(k3);
            this.f40212ah.setTargetRotationThreshold(interactiveInfo.C());
            this.f40212ah.setReverseRotationThreshold(interactiveInfo.D());
            v H = rVar.H(2);
            if (H != null) {
                int c16 = ak.c(GDTADManager.getInstance().getAppContext(), H.c());
                int c17 = ak.c(GDTADManager.getInstance().getAppContext(), H.d());
                int d16 = ak.d(GDTADManager.getInstance().getAppContext(), H.e());
                int a16 = ak.a((ak.b(GDTADManager.getInstance().getAppContext()) - c16) - c17, H.f());
                GDTLogger.i("IconFlipAd setClickHotArea leftMargin:" + c16 + " rightMargin:" + c17 + " bottomMargin:" + d16 + " height:" + a16);
                this.f40212ah.setClickHotArea(0, (float) c16, (float) c17, (float) d16, (float) a16);
                return;
            }
            return;
        }
        GDTLogger.e("IconFlipAd buildWidget error, adInfo or interactiveInfo null");
    }

    protected void B() {
        aa.a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.c.b.3
            @Override // java.lang.Runnable
            public void run() {
                com.qq.e.comm.plugin.tangramsplash.interactive.b bVar = ((com.qq.e.comm.plugin.tangramsplash.interactive.a) b.this).Z;
                try {
                    if (((com.qq.e.comm.plugin.tangramsplash.interactive.a) b.this).f40115aa != null) {
                        if (((com.qq.e.comm.plugin.tangramsplash.interactive.a) b.this).f40115aa.r()) {
                            com.qq.e.comm.plugin.tangramsplash.d.f.a(500L);
                        }
                        if (bVar != null) {
                            bVar.a(true);
                        }
                    }
                } catch (Throwable unused) {
                    GDTLogger.e("IconFlipAd clickTrigger");
                }
            }
        });
    }

    protected void C() {
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
            cVar.a("angle", Integer.valueOf((int) this.f40213ai));
        }
        int i3 = this.f40214aj;
        if (i3 != Integer.MIN_VALUE) {
            cVar.a("interactiveCode", Integer.valueOf(i3));
        }
        StatTracer.trackEvent(1310394, 0, bVar, cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void p() {
        try {
            final FlipView flipView = this.f40212ah;
            if (flipView != null) {
                flipView.post(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.c.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        flipView.stop();
                        flipView.setVisibility(8);
                    }
                });
            }
        } catch (Throwable th5) {
            GDTLogger.e("FlipCardView clear error:", th5);
        }
        C();
        super.p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void q() {
        GDTLogger.i("IconFlipAd  clearFromOutSide :" + Thread.currentThread());
        try {
            FlipView flipView = this.f40212ah;
            if (flipView != null) {
                flipView.stop();
            }
        } catch (Throwable th5) {
            GDTLogger.e("IconFlipAd  clearFromOutSide error :", th5);
        }
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
        FlipView flipView = this.f40212ah;
        if (flipView != null && z16) {
            flipView.pause();
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
        FlipView flipView = this.f40212ah;
        if (flipView != null && z16) {
            flipView.resume();
        }
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void b() {
        E();
        D();
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    protected boolean a() {
        if (this.X != null && this.f40115aa != null) {
            return true;
        }
        GDTLogger.e("IconFlipAd mAdInfo or mInteractiveInfo is null");
        return false;
    }
}
