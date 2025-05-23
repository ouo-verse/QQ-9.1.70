package com.qq.e.comm.plugin.tangramsplash.interactive.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.base.ad.model.InteractiveInfo;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.base.ad.model.v;
import com.qq.e.comm.plugin.k.aa;
import com.qq.e.comm.plugin.k.ak;
import com.qq.e.comm.plugin.k.at;
import com.qq.e.comm.plugin.k.h;
import com.qq.e.comm.plugin.tangramsplash.interactive.a.d;
import com.qq.e.comm.plugin.tangramsplash.interactive.c;
import com.qq.e.comm.plugin.tangramsplash.interactive.e;
import com.qq.e.comm.plugin.tangramsplash.interactive.f;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ams.fusion.widget.slideinteractive.SlideInteractiveListener;
import com.tencent.ams.fusion.widget.slideinteractive.SlideInteractiveView;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends d {

    /* renamed from: ah, reason: collision with root package name */
    private SlideInteractiveView f40285ah;

    public b(r rVar, c cVar) {
        super(rVar, cVar);
    }

    private void B() {
        a(new f.a() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.f.b.2
            @Override // com.qq.e.comm.plugin.tangramsplash.interactive.f.a
            public void a(boolean z16) {
                GDTLogger.d("startEnableDrawAfterAdShow\uff1aenable " + z16);
                if (z16) {
                    b.this.h();
                    if (((com.qq.e.comm.plugin.tangramsplash.interactive.a) b.this).Z != null && b.this.f40285ah != null) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        com.qq.e.comm.plugin.tangramsplash.interactive.b bVar = ((com.qq.e.comm.plugin.tangramsplash.interactive.a) b.this).Z;
                        if (bVar != null) {
                            try {
                                bVar.a(b.this.f40285ah, layoutParams);
                            } catch (Exception e16) {
                                e16.printStackTrace();
                                return;
                            }
                        }
                        b.this.f40285ah.start();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        this.f40285ah.setEnabled(false);
        if (this.Z != null) {
            this.Z.a(true);
        }
        f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void p() {
        super.p();
        SlideInteractiveView slideInteractiveView = this.f40285ah;
        if (slideInteractiveView != null) {
            slideInteractiveView.post(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.f.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.f40285ah.setEnabled(false);
                    b.this.f40285ah.stop();
                    b.this.f40285ah.setVisibility(8);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void q() {
        GDTLogger.i("SlideAd clearFromOutSide :" + Thread.currentThread());
        try {
            SlideInteractiveView slideInteractiveView = this.f40285ah;
            if (slideInteractiveView != null) {
                slideInteractiveView.setEnabled(false);
                slideInteractiveView.stop();
            }
        } catch (Throwable th5) {
            GDTLogger.e("SlideAd clearFromOutSide error :", th5);
        }
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    protected boolean a() {
        InteractiveInfo interactiveInfo = this.f40115aa;
        if (interactiveInfo != null && interactiveInfo.n() == com.qq.e.comm.plugin.tangramsplash.interactive.a.f40099k) {
            return true;
        }
        r rVar = this.X;
        if (rVar == null) {
            return false;
        }
        File b16 = at.b(rVar.s(), e.d(this.X));
        if (b16 != null && b16.exists()) {
            b(b16.getAbsolutePath());
        } else if (this.Y != null && this.f40115aa != null) {
            com.qq.e.comm.plugin.tangramsplash.report.c.b(1310370, this.X.s(), this.X, this.f40115aa.n(), this.Y.f40183b);
        }
        return true;
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    protected void b() {
        SlideInteractiveView slideInteractiveView = new SlideInteractiveView(GDTADManager.getInstance().getAppContext());
        this.f40285ah = slideInteractiveView;
        slideInteractiveView.setSlideInteractiveListener(new SlideInteractiveListener() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.f.b.1
            @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideInteractiveListener
            public void onEndAnimationFinish() {
                GDTLogger.d("SlideAd onEndAnimationFinish ");
                aa.a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.f.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.C();
                    }
                });
            }

            @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideInteractiveListener
            public void onGestureResult(boolean z16, View view, float f16, float f17) {
                GDTLogger.d("SlideAd onGestureResult  success :" + z16 + " xOffset :" + f16 + " yOffset :" + f17);
                if (z16) {
                    if (((com.qq.e.comm.plugin.tangramsplash.interactive.a) b.this).f40115aa != null && ((com.qq.e.comm.plugin.tangramsplash.interactive.a) b.this).f40115aa.r()) {
                        com.qq.e.comm.plugin.tangramsplash.d.f.a(500L);
                    }
                    if (b.this.f40285ah != null) {
                        b.this.f40285ah.setEnabled(false);
                    }
                    b.this.f();
                    return;
                }
                b.this.g();
            }

            @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideInteractiveListener
            public void onGestureStart() {
                GDTLogger.d("SlideAd onGestureStart ");
                b.this.e();
            }

            @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideInteractiveListener
            public void onTouch(View view, MotionEvent motionEvent) {
            }
        });
        InteractiveInfo interactiveInfo = this.f40115aa;
        if (interactiveInfo != null && this.X != null) {
            this.f40285ah.setGestureVisible(interactiveInfo.y());
            Context appContext = GDTADManager.getInstance().getAppContext();
            this.f40285ah.setTitle(this.f40115aa.j());
            this.f40285ah.setSubTitle(this.f40115aa.k());
            File a16 = at.a(1, this.X.s(), this.f40115aa.u());
            if (a16.exists()) {
                this.f40285ah.setSlideIconBitmap(h.a(a16, (ImageView) null));
            }
            if (!TextUtils.isEmpty(this.f40115aa.d())) {
                this.f40285ah.setGestureColor(this.f40115aa.d());
            }
            if (this.f40115aa.z() > 0) {
                this.f40285ah.setGestureStrokeWidthDp(this.f40115aa.z());
            }
            this.f40285ah.setGestureSlideValidHeightDp(this.X.bU());
            v H = this.X.H(4);
            if (H != null) {
                int c16 = ak.c(appContext, H.c());
                int c17 = ak.c(appContext, H.d());
                int c18 = ak.c(appContext, H.e());
                int a17 = ak.a((ak.b(appContext) - c16) - c17, H.f());
                SlideInteractiveView slideInteractiveView2 = this.f40285ah;
                if (a17 == 0) {
                    a17 = -1;
                }
                slideInteractiveView2.setGestureHotArea(c16, c17, c18, a17);
            }
        }
        B();
    }
}
