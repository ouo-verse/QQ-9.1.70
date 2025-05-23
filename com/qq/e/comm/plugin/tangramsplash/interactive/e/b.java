package com.qq.e.comm.plugin.tangramsplash.interactive.e;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.base.ad.model.ExtraCreativeElement;
import com.qq.e.comm.plugin.base.ad.model.InteractiveInfo;
import com.qq.e.comm.plugin.base.ad.model.k;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.k.aa;
import com.qq.e.comm.plugin.k.g;
import com.qq.e.comm.plugin.tangramsplash.d.f;
import com.qq.e.comm.plugin.tangramsplash.interactive.c;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ams.fusion.widget.olympic2024.GalleryItem;
import com.tencent.ams.fusion.widget.olympic2024.OlympicGalleryListener;
import com.tencent.ams.fusion.widget.olympic2024.OlympicTwistView;
import com.tencent.ams.fusion.widget.twist.TwistView;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends a {

    /* renamed from: ao, reason: collision with root package name */
    private OlympicTwistView f40253ao;

    /* renamed from: ap, reason: collision with root package name */
    private final Runnable f40254ap;

    /* renamed from: aq, reason: collision with root package name */
    private final Runnable f40255aq;

    public b(r rVar, c cVar) {
        super(rVar, cVar);
        this.f40254ap = new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.e.b.1
            @Override // java.lang.Runnable
            public void run() {
                GDTLogger.i("GalleryTwistView Interactive View enable show");
                b.this.h();
                OlympicTwistView olympicTwistView = b.this.f40253ao;
                if (olympicTwistView != null) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    com.qq.e.comm.plugin.tangramsplash.interactive.b bVar = ((com.qq.e.comm.plugin.tangramsplash.interactive.a) b.this).Z;
                    if (bVar != null) {
                        try {
                            bVar.a(olympicTwistView, layoutParams);
                        } catch (Throwable th5) {
                            GDTLogger.e("GalleryTwistView show slideView error:", th5);
                        }
                    }
                    olympicTwistView.start();
                }
                b.this.f40236al = System.currentTimeMillis();
            }
        };
        this.f40255aq = new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.e.b.2
            @Override // java.lang.Runnable
            public void run() {
                OlympicTwistView olympicTwistView = b.this.f40253ao;
                if (olympicTwistView != null) {
                    olympicTwistView.setEnabled(false);
                    olympicTwistView.stop();
                    olympicTwistView.setVisibility(8);
                }
                GDTLogger.i("Interactive View Task wo not enable");
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.e.a
    public void C() {
        OlympicTwistView olympicTwistView = this.f40253ao;
        if (olympicTwistView != null) {
            olympicTwistView.stopInteractive();
        }
        super.C();
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.e.a
    protected void D() {
        InteractiveInfo interactiveInfo = this.f40115aa;
        if (interactiveInfo != null) {
            if (interactiveInfo.a() == 0) {
                this.f40254ap.run();
            } else {
                GDTLogger.i("GalleryTwistView : enable draw in " + this.f40115aa.a() + "s later");
                aa.a(this.f40254ap, ((long) this.f40115aa.a()) * 1000);
            }
            if (this.f40115aa.b() > 0) {
                aa.a(this.f40255aq, this.f40115aa.b() * 1000);
            }
            GDTLogger.i("GalleryTwistView : disable draw in " + this.f40115aa.b() + "s later");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.e.a, com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void p() {
        final OlympicTwistView olympicTwistView = this.f40253ao;
        if (olympicTwistView != null) {
            olympicTwistView.post(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.e.b.5
                @Override // java.lang.Runnable
                public void run() {
                    olympicTwistView.stopInteractive();
                }
            });
            olympicTwistView.postDelayed(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.e.b.6
                @Override // java.lang.Runnable
                public void run() {
                    olympicTwistView.stop();
                    olympicTwistView.setVisibility(8);
                }
            }, com.qq.e.comm.plugin.j.c.a("splashInteractiveViewDismissDelay", 100));
        }
        super.p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.e.a, com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void q() {
        GDTLogger.i("GalleryTwistView  clearFromOutSide :" + Thread.currentThread());
        try {
            OlympicTwistView olympicTwistView = this.f40253ao;
            if (olympicTwistView != null) {
                olympicTwistView.stopInteractive();
                olympicTwistView.stop();
            }
        } catch (Throwable th5) {
            GDTLogger.e("GalleryTwistView  clearFromOutSide error :", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.e.a, com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void r() {
        super.r();
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.e.a, com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void w() {
        boolean z16;
        super.w();
        r rVar = this.X;
        if (rVar != null && rVar.ca()) {
            z16 = true;
        } else {
            z16 = false;
        }
        OlympicTwistView olympicTwistView = this.f40253ao;
        if (olympicTwistView != null && z16) {
            olympicTwistView.pause();
        }
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.e.a, com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void x() {
        boolean z16;
        super.x();
        r rVar = this.X;
        if (rVar != null && rVar.ca()) {
            z16 = true;
        } else {
            z16 = false;
        }
        OlympicTwistView olympicTwistView = this.f40253ao;
        if (olympicTwistView != null && z16) {
            olympicTwistView.resume();
        }
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.e.a, com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    protected void b() {
        try {
            OlympicTwistView a16 = a(B());
            this.f40253ao = a16;
            if (a16 == null && this.Z != null) {
                this.Z.a(this.f40238an, "widget create failed");
                return;
            }
        } catch (Throwable th5) {
            GDTLogger.e("build olympic twist view error :", th5);
            if (this.Z != null) {
                this.Z.a(this.f40238an, "widget create failed");
                return;
            }
        }
        D();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.e.a, com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    public boolean a() {
        return super.a();
    }

    private OlympicTwistView a(List<GalleryItem> list) {
        if (g.b(list)) {
            GDTLogger.e("GalleryTwistView galleryItems invalid");
            return null;
        }
        Context appContext = GDTADManager.getInstance().getAppContext();
        r rVar = this.X;
        InteractiveInfo interactiveInfo = this.f40115aa;
        if (appContext != null && rVar != null && interactiveInfo != null) {
            ExtraCreativeElement bL = rVar.bL();
            k bK = rVar.bK();
            if (bL != null && bK != null) {
                int k3 = bK.k();
                int i3 = 0;
                OlympicTwistView olympicTwistView = new OlympicTwistView(appContext, k3 == 1 ? 0 : 1);
                this.f40253ao = olympicTwistView;
                olympicTwistView.setOlympicGalleryListener(new OlympicGalleryListener() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.e.b.3
                    @Override // com.tencent.ams.fusion.widget.olympic2024.OlympicGalleryListener
                    public void onEndCardAnimFinish() {
                        GDTLogger.i("GalleryTwistView onEndCardAnimFinish");
                        if (!b.this.f40237am) {
                            aa.a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.e.b.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.C();
                                }
                            });
                        }
                    }

                    @Override // com.tencent.ams.fusion.widget.olympic2024.OlympicGalleryListener
                    public void onEndCardAnimStart() {
                        GDTLogger.i("GalleryTwistView onEndCardAnimStart");
                        if (((com.qq.e.comm.plugin.tangramsplash.interactive.a) b.this).Z != null) {
                            ((com.qq.e.comm.plugin.tangramsplash.interactive.a) b.this).Z.a();
                        }
                    }

                    @Override // com.tencent.ams.fusion.widget.olympic2024.OlympicGalleryListener
                    public void onItemSwitch(int i16) {
                        GDTLogger.i("GalleryTwistView onItemSwitch:" + i16);
                        b.this.f40233ai = i16;
                    }

                    @Override // com.tencent.ams.fusion.widget.olympic2024.OlympicGalleryListener
                    public void onVideoItemComplete(int i16) {
                        GDTLogger.i("GalleryTwistView onVideoItemComplete:" + i16);
                    }

                    @Override // com.tencent.ams.fusion.widget.olympic2024.OlympicGalleryListener
                    public void onVideoItemError(int i16, int i17) {
                        GDTLogger.e("GalleryTwistView onVideoItemError:" + i16 + " error :" + i17);
                    }

                    @Override // com.tencent.ams.fusion.widget.olympic2024.OlympicGalleryListener
                    public void onVideoItemPause(int i16) {
                        GDTLogger.i("GalleryTwistView onVideoItemPause:" + i16);
                    }

                    @Override // com.tencent.ams.fusion.widget.olympic2024.OlympicGalleryListener
                    public void onVideoItemPlayUpdate(int i16, long j3) {
                        GDTLogger.i("GalleryTwistView onVideoItemPlayUpdate:" + i16);
                    }

                    @Override // com.tencent.ams.fusion.widget.olympic2024.OlympicGalleryListener
                    public void onVideoItemResume(int i16) {
                        GDTLogger.i("GalleryTwistView onVideoItemResume:" + i16);
                    }

                    @Override // com.tencent.ams.fusion.widget.olympic2024.OlympicGalleryListener
                    public void onVideoItemStart(int i16, long j3) {
                        GDTLogger.i("GalleryTwistView onVideoItemStart:" + i16);
                        b.this.f40235ak = true;
                    }
                });
                this.f40253ao.setTwistInteractListener(new TwistView.ITwistInteractListener() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.e.b.4
                    @Override // com.tencent.ams.fusion.widget.twist.TwistView.ITwistInteractListener
                    public void onInteractResult(boolean z16) {
                        b.this.b(z16);
                    }

                    @Override // com.tencent.ams.fusion.widget.twist.TwistView.ITwistInteractListener
                    public void onInteractStart() {
                        GDTLogger.i("GalleryTwistView onGestureStart:");
                        b.this.e();
                    }

                    @Override // com.tencent.ams.fusion.widget.twist.TwistView.ITwistInteractListener
                    public void onBackInteractProgress(float f16, int i16) {
                    }

                    @Override // com.tencent.ams.fusion.widget.twist.TwistView.ITwistInteractListener
                    public void onInteractProgress(float f16, int i16) {
                    }
                });
                this.f40253ao.setItems(list);
                InteractiveInfo interactiveInfo2 = this.f40115aa;
                if (interactiveInfo2 != null && this.X != null) {
                    this.f40253ao.setTitle(TextUtils.isEmpty(interactiveInfo2.j()) ? "\u626d\u52a8\u624b\u673a" : this.f40115aa.j());
                    this.f40253ao.setSubTitle(TextUtils.isEmpty(this.f40115aa.k()) ? "\u8df3\u8f6c\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528" : this.f40115aa.k());
                    if (this.f40115aa.m() == 1) {
                        i3 = 1;
                    } else if (this.f40115aa.m() != 2) {
                        this.f40115aa.m();
                        i3 = 2;
                    }
                    this.f40253ao.setDirection(i3);
                    this.f40253ao.setTargetAngle(this.f40115aa.l());
                    this.f40253ao.setReverseAngle(this.f40115aa.B());
                } else {
                    this.f40253ao.setTitle("\u626d\u52a8\u624b\u673a");
                    this.f40253ao.setSubTitle("\u8df3\u8f6c\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528");
                }
                a(bL.b(), rVar, this.f40253ao);
                return this.f40253ao;
            }
            GDTLogger.e("GalleryTwistView creative card info invalid");
            return null;
        }
        GDTLogger.e("GalleryTwistView ad info invalid");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z16) {
        if (this.f40232ah) {
            return;
        }
        if (z16) {
            this.f40232ah = true;
            this.f40234aj = 0;
            InteractiveInfo interactiveInfo = this.f40115aa;
            if (interactiveInfo != null && interactiveInfo.r()) {
                f.a(500L);
            }
            OlympicTwistView olympicTwistView = this.f40253ao;
            if (olympicTwistView != null) {
                olympicTwistView.stopInteractive();
            }
            f();
            return;
        }
        this.f40234aj = 2;
        g();
    }
}
