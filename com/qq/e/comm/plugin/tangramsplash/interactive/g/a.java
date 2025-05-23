package com.qq.e.comm.plugin.tangramsplash.interactive.g;

import android.widget.FrameLayout;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.k.aa;
import com.qq.e.comm.plugin.tangramsplash.d.f;
import com.qq.e.comm.plugin.tangramsplash.interactive.a.d;
import com.qq.e.comm.plugin.tangramsplash.interactive.b;
import com.qq.e.comm.plugin.tangramsplash.interactive.c;
import com.qq.e.comm.plugin.tangramsplash.interactive.f;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ams.fusion.widget.twist.TwistView;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends d {

    /* renamed from: ah, reason: collision with root package name */
    private TwistView f40290ah;

    public a(r rVar, c cVar) {
        super(rVar, cVar);
    }

    private void C() {
        if (this.X != null && this.f40115aa != null) {
            TwistView twistView = new TwistView(GDTADManager.getInstance().getAppContext());
            this.f40290ah = twistView;
            twistView.setTitle(this.f40115aa.j());
            this.f40290ah.setSubTitle(this.f40115aa.k());
            int i3 = 1;
            if (this.f40115aa.m() != 1) {
                i3 = 2;
                if (this.f40115aa.m() == 2) {
                    i3 = 0;
                } else {
                    this.f40115aa.m();
                }
            }
            this.f40290ah.setDirection(i3);
            this.f40290ah.setTargetAngle(this.f40115aa.l());
            this.f40290ah.setReverseAngle(this.f40115aa.B());
            this.f40290ah.setTextBottomMarginDp(48);
            this.f40290ah.setTwistInteractListener(new TwistView.ITwistInteractListener() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.g.a.2
                @Override // com.tencent.ams.fusion.widget.twist.TwistView.ITwistInteractListener
                public void onInteractProgress(float f16, int i16) {
                    GDTLogger.d("TwistAd[onInteractProgress] " + f16);
                }

                @Override // com.tencent.ams.fusion.widget.twist.TwistView.ITwistInteractListener
                public void onInteractResult(boolean z16) {
                    GDTLogger.i("TwistAd[onInteractResult] " + z16);
                    if (z16) {
                        a.this.f();
                        a.this.B();
                    }
                }

                @Override // com.tencent.ams.fusion.widget.twist.TwistView.ITwistInteractListener
                public void onInteractStart() {
                    GDTLogger.d("TwistAd[onInteractStart]");
                    a.this.e();
                }

                @Override // com.tencent.ams.fusion.widget.twist.TwistView.ITwistInteractListener
                public void onBackInteractProgress(float f16, int i16) {
                }
            });
            return;
        }
        GDTLogger.e("mAdInfo or mInteractiveInfo is null");
    }

    protected void B() {
        aa.a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.g.a.3
            @Override // java.lang.Runnable
            public void run() {
                b bVar = ((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).Z;
                try {
                    if (((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).f40115aa != null) {
                        if (((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).f40115aa.r()) {
                            f.a(500L);
                        }
                        if (bVar != null) {
                            bVar.a(true);
                        }
                    }
                } catch (Throwable unused) {
                    GDTLogger.e("TwistAdclickTrigger");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void p() {
        try {
            final TwistView twistView = this.f40290ah;
            if (twistView != null) {
                twistView.post(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.g.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        twistView.stop();
                        twistView.setVisibility(8);
                        twistView.setTwistInteractListener(null);
                    }
                });
            }
        } catch (Throwable th5) {
            GDTLogger.e("FlipCardView clear error:", th5);
        }
        this.f40290ah = null;
        super.p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void q() {
        GDTLogger.i("TwistAd clearFromOutSide :" + Thread.currentThread());
        try {
            TwistView twistView = this.f40290ah;
            if (twistView != null) {
                twistView.stop();
            }
        } catch (Throwable th5) {
            GDTLogger.e("TwistAd clearFromOutSide error :", th5);
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
        TwistView twistView = this.f40290ah;
        if (twistView != null && z16) {
            twistView.pause();
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
        TwistView twistView = this.f40290ah;
        if (twistView != null && z16) {
            twistView.resume();
        }
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    protected boolean a() {
        if (this.X != null && this.f40115aa != null) {
            return true;
        }
        GDTLogger.e("mAdInfo or mInteractiveInfo is null");
        return false;
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    protected void b() {
        C();
        a(new f.a() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.g.a.1
            @Override // com.qq.e.comm.plugin.tangramsplash.interactive.f.a
            public void a(boolean z16) {
                GDTLogger.d("TwistAddrawInteractiveView enable:" + z16);
                TwistView twistView = a.this.f40290ah;
                if (twistView == null) {
                    GDTLogger.e("TwistAdtwistView view null");
                    return;
                }
                if (z16) {
                    a.this.h();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    b bVar = ((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).Z;
                    if (bVar != null) {
                        try {
                            bVar.a(twistView, layoutParams);
                            twistView.start();
                            return;
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                twistView.setEnabled(false);
                twistView.stop();
                twistView.setVisibility(8);
                twistView.setTwistInteractListener(null);
                a aVar = a.this;
                aVar.a(((d) aVar).f40158ag);
                GDTLogger.d("InterativeViewTask twistView not enable");
            }
        });
    }
}
