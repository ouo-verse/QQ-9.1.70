package com.qq.e.comm.plugin.tangramsplash.interactive.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.base.ad.model.ExtraCreativeElement;
import com.qq.e.comm.plugin.base.ad.model.InteractiveInfo;
import com.qq.e.comm.plugin.base.ad.model.k;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.base.ad.model.v;
import com.qq.e.comm.plugin.k.aa;
import com.qq.e.comm.plugin.k.ak;
import com.qq.e.comm.plugin.k.g;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.plugin.tangramsplash.d.f;
import com.qq.e.comm.plugin.tangramsplash.interactive.a.d;
import com.qq.e.comm.plugin.tangramsplash.interactive.c;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ams.fusion.widget.olympic2024.GalleryItem;
import com.tencent.ams.fusion.widget.olympic2024.OlympicCarouselView;
import com.tencent.ams.fusion.widget.olympic2024.OlympicGalleryListener;
import com.tencent.ams.fusion.widget.olympic2024.OlympicSlideView;
import com.tencent.ams.fusion.widget.slideinteractive.SlideInteractiveListener;
import com.tencent.biz.common.util.WebViewConstants;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends d {

    /* renamed from: ah, reason: collision with root package name */
    protected volatile boolean f40232ah;

    /* renamed from: ai, reason: collision with root package name */
    protected int f40233ai;

    /* renamed from: aj, reason: collision with root package name */
    protected int f40234aj;

    /* renamed from: ak, reason: collision with root package name */
    protected boolean f40235ak;

    /* renamed from: al, reason: collision with root package name */
    protected long f40236al;

    /* renamed from: am, reason: collision with root package name */
    protected volatile boolean f40237am;

    /* renamed from: an, reason: collision with root package name */
    protected int f40238an;

    /* renamed from: ao, reason: collision with root package name */
    private OlympicSlideView f40239ao;

    /* renamed from: ap, reason: collision with root package name */
    private Boolean f40240ap;

    /* renamed from: aq, reason: collision with root package name */
    private boolean f40241aq;

    /* renamed from: ar, reason: collision with root package name */
    private final Runnable f40242ar;

    /* renamed from: as, reason: collision with root package name */
    private final Runnable f40243as;

    public a(r rVar, c cVar) {
        super(rVar, cVar);
        this.f40233ai = 0;
        this.f40234aj = 3;
        this.f40240ap = null;
        this.f40235ak = false;
        this.f40241aq = false;
        this.f40236al = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        this.f40238an = -1;
        this.f40242ar = new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.e.a.1
            @Override // java.lang.Runnable
            public void run() {
                GDTLogger.i("GallerySlideView Interactive View enable show");
                a.this.h();
                OlympicSlideView olympicSlideView = a.this.f40239ao;
                if (olympicSlideView != null) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    com.qq.e.comm.plugin.tangramsplash.interactive.b bVar = ((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).Z;
                    if (bVar != null) {
                        try {
                            bVar.a(olympicSlideView, layoutParams);
                        } catch (Throwable th5) {
                            GDTLogger.e("GallerySlideView show slideView error:", th5);
                        }
                    }
                    olympicSlideView.start();
                }
                a.this.f40236al = System.currentTimeMillis();
            }
        };
        this.f40243as = new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.e.a.2
            @Override // java.lang.Runnable
            public void run() {
                OlympicSlideView olympicSlideView = a.this.f40239ao;
                if (olympicSlideView != null) {
                    olympicSlideView.setEnabled(false);
                    olympicSlideView.stop();
                    olympicSlideView.setVisibility(8);
                }
                GDTLogger.i("GallerySlideView Interactive View Task wo not enable");
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<GalleryItem> B() {
        Context appContext = GDTADManager.getInstance().getAppContext();
        r rVar = this.X;
        InteractiveInfo interactiveInfo = this.f40115aa;
        if (appContext != null && rVar != null && interactiveInfo != null) {
            ExtraCreativeElement bL = rVar.bL();
            k bK = rVar.bK();
            if (bL != null && bK != null) {
                List<ExtraCreativeElement.b> b16 = bL.b();
                if (g.b(b16)) {
                    GDTLogger.e("GallerySlideView groupList invalid");
                    this.f40238an = -4;
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < b16.size(); i3++) {
                    ExtraCreativeElement.b bVar = b16.get(i3);
                    if (bVar != null) {
                        GalleryItem galleryItem = new GalleryItem();
                        String b17 = b(bVar, rVar);
                        if (!TextUtils.isEmpty(b17)) {
                            galleryItem.setVideoPath(b17);
                        }
                        Bitmap a16 = a(bVar, rVar);
                        if (a16 != null) {
                            galleryItem.setImage(a16);
                            galleryItem.setItemCenterYOffsetRatio(bK.j());
                            arrayList.add(galleryItem);
                        } else {
                            GDTLogger.e("GallerySlideView bitmap decode error," + i3);
                            this.f40238an = -5;
                            return null;
                        }
                    }
                }
                return arrayList;
            }
            GDTLogger.e("GallerySlideView creative card info invalid");
            this.f40238an = -3;
            return null;
        }
        GDTLogger.e("GallerySlideView ad info invalid");
        this.f40238an = -2;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C() {
        OlympicSlideView olympicSlideView = this.f40239ao;
        if (olympicSlideView != null) {
            olympicSlideView.setEnabled(false);
        }
        if (this.Z != null) {
            this.Z.a(true);
        }
    }

    protected void D() {
        InteractiveInfo interactiveInfo = this.f40115aa;
        if (interactiveInfo != null) {
            if (interactiveInfo.a() == 0) {
                this.f40242ar.run();
            } else {
                GDTLogger.i("GallerySlideView : enable draw in " + this.f40115aa.a() + "s later");
                aa.a(this.f40242ar, ((long) this.f40115aa.a()) * 1000);
            }
            if (this.f40115aa.b() > 0) {
                aa.a(this.f40243as, this.f40115aa.b() * 1000);
            }
            GDTLogger.i("GallerySlideView : disable draw in " + this.f40115aa.b() + "s later");
        }
    }

    protected void E() {
        int i3;
        int n3;
        if (this.X != null) {
            com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
            bVar.a(this.X.s());
            bVar.b(this.X.f());
            bVar.c(this.X.y());
            com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
            if (this.X.bJ() != null && (n3 = this.X.bJ().n()) != Integer.MIN_VALUE) {
                cVar.a("error_code", String.valueOf(n3));
            }
            c cVar2 = this.Y;
            if (cVar2 != null) {
                cVar.a("startMode", com.qq.e.comm.plugin.tangramsplash.d.a.a(cVar2.f40183b));
            }
            if (this.f40232ah) {
                i3 = this.f40233ai - 1;
            } else {
                i3 = this.f40233ai;
            }
            cVar.a("autoScrollCount", Integer.valueOf(i3));
            cVar.a("scrollCount", Integer.valueOf(this.f40233ai));
            Boolean bool = this.f40240ap;
            if (bool != null && bool.booleanValue()) {
                if (this.f40241aq) {
                    cVar.a("videoItemDisplayCount", 1);
                } else if (this.f40235ak) {
                    cVar.a("videoItemDisplayCount", 0);
                }
            }
            cVar.a("interactiveCode", Integer.valueOf(this.f40234aj));
            if (this.f40236al != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
                cVar.a("cost_time", Long.valueOf(System.currentTimeMillis() - this.f40236al));
            }
            StatTracer.trackEvent(1310394, 0, bVar, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    public boolean a() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void p() {
        this.f40237am = true;
        final OlympicSlideView olympicSlideView = this.f40239ao;
        if (olympicSlideView != null) {
            olympicSlideView.post(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.e.a.5
                @Override // java.lang.Runnable
                public void run() {
                    olympicSlideView.stopInteractive();
                }
            });
            olympicSlideView.postDelayed(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.e.a.6
                @Override // java.lang.Runnable
                public void run() {
                    olympicSlideView.stop();
                    olympicSlideView.setVisibility(8);
                }
            }, com.qq.e.comm.plugin.j.c.a("splashInteractiveViewDismissDelay", 100));
        }
        E();
        super.p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void q() {
        GDTLogger.i("GallerySlideView  clearFromOutSide :" + Thread.currentThread());
        try {
            OlympicSlideView olympicSlideView = this.f40239ao;
            if (olympicSlideView != null) {
                olympicSlideView.stopInteractive();
                olympicSlideView.stop();
            }
        } catch (Throwable th5) {
            GDTLogger.e("GallerySlideView  clearFromOutSide error :", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void r() {
        super.r();
        this.f40234aj = 4;
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
        OlympicSlideView olympicSlideView = this.f40239ao;
        if (olympicSlideView != null && z16) {
            olympicSlideView.pause();
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
        OlympicSlideView olympicSlideView = this.f40239ao;
        if (olympicSlideView != null && z16) {
            olympicSlideView.resume();
        }
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    protected void b() {
        try {
            OlympicSlideView a16 = a(B());
            this.f40239ao = a16;
            if (a16 == null && this.Z != null) {
                this.Z.a(this.f40238an, "widget create failed");
                return;
            }
        } catch (Throwable th5) {
            GDTLogger.e("build olympic slide view error :", th5);
            if (this.Z != null) {
                this.Z.a(this.f40238an, "widget create failed");
                return;
            }
        }
        D();
    }

    private Bitmap a(ExtraCreativeElement.b bVar, r rVar) {
        ExtraCreativeElement.a a16;
        if (bVar == null || rVar == null || rVar.bL() == null || (a16 = bVar.a()) == null) {
            return null;
        }
        return a16.a();
    }

    private OlympicSlideView a(List<GalleryItem> list) {
        if (g.b(list)) {
            GDTLogger.e("GallerySlideView galleryItems invalid");
            return null;
        }
        Context appContext = GDTADManager.getInstance().getAppContext();
        r rVar = this.X;
        InteractiveInfo interactiveInfo = this.f40115aa;
        if (appContext != null && rVar != null && interactiveInfo != null) {
            ExtraCreativeElement bL = rVar.bL();
            k bK = rVar.bK();
            if (bL != null && bK != null) {
                OlympicSlideView olympicSlideView = new OlympicSlideView(appContext, bK.k() == 1 ? 0 : 1);
                this.f40239ao = olympicSlideView;
                olympicSlideView.setSlideInteractiveListener(new SlideInteractiveListener() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.e.a.3
                    @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideInteractiveListener
                    public void onEndAnimationFinish() {
                        GDTLogger.i("GallerySlideView onEndAnimationFinish:");
                    }

                    @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideInteractiveListener
                    public void onGestureResult(boolean z16, View view, float f16, float f17) {
                        GDTLogger.i("GallerySlideView onGestureResult:" + z16 + " xOffset :" + f16);
                        a.this.b(z16);
                    }

                    @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideInteractiveListener
                    public void onGestureStart() {
                        GDTLogger.i("GallerySlideView onGestureStart:");
                        a.this.e();
                    }

                    @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideInteractiveListener
                    public void onTouch(View view, MotionEvent motionEvent) {
                    }
                });
                this.f40239ao.setOlympicGalleryListener(new OlympicGalleryListener() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.e.a.4
                    @Override // com.tencent.ams.fusion.widget.olympic2024.OlympicGalleryListener
                    public void onEndCardAnimFinish() {
                        GDTLogger.i("GallerySlideView onEndCardAnimFinish");
                        if (!a.this.f40237am) {
                            aa.a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.e.a.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.C();
                                }
                            });
                        }
                    }

                    @Override // com.tencent.ams.fusion.widget.olympic2024.OlympicGalleryListener
                    public void onEndCardAnimStart() {
                        GDTLogger.i("GallerySlideView onEndCardAnimStart");
                        if (((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).Z != null) {
                            ((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).Z.a();
                        }
                    }

                    @Override // com.tencent.ams.fusion.widget.olympic2024.OlympicGalleryListener
                    public void onItemSwitch(int i3) {
                        GDTLogger.i("GallerySlideView onItemSwitch:" + i3);
                        a.this.f40233ai = i3;
                    }

                    @Override // com.tencent.ams.fusion.widget.olympic2024.OlympicGalleryListener
                    public void onVideoItemComplete(int i3) {
                        GDTLogger.i("GallerySlideView onVideoItemComplete:" + i3);
                    }

                    @Override // com.tencent.ams.fusion.widget.olympic2024.OlympicGalleryListener
                    public void onVideoItemError(int i3, int i16) {
                        GDTLogger.e("GallerySlideView onVideoItemError:" + i3 + " error :" + i16);
                    }

                    @Override // com.tencent.ams.fusion.widget.olympic2024.OlympicGalleryListener
                    public void onVideoItemPause(int i3) {
                        GDTLogger.i("GallerySlideView onVideoItemPause:" + i3);
                    }

                    @Override // com.tencent.ams.fusion.widget.olympic2024.OlympicGalleryListener
                    public void onVideoItemPlayUpdate(int i3, long j3) {
                        GDTLogger.i("GallerySlideView onVideoItemPlayUpdate:" + i3);
                    }

                    @Override // com.tencent.ams.fusion.widget.olympic2024.OlympicGalleryListener
                    public void onVideoItemResume(int i3) {
                        GDTLogger.i("GallerySlideView onVideoItemResume:" + i3);
                    }

                    @Override // com.tencent.ams.fusion.widget.olympic2024.OlympicGalleryListener
                    public void onVideoItemStart(int i3, long j3) {
                        GDTLogger.i("GallerySlideView onVideoItemStart:" + i3);
                        a.this.f40235ak = true;
                    }
                });
                this.f40239ao.setItems(list);
                InteractiveInfo interactiveInfo2 = this.f40115aa;
                if (interactiveInfo2 != null && this.X != null) {
                    this.f40239ao.setTitle(TextUtils.isEmpty(interactiveInfo2.j()) ? "\u5411\u5de6\u6ed1\u52a8" : this.f40115aa.j());
                    this.f40239ao.setSubTitle(TextUtils.isEmpty(this.f40115aa.k()) ? "\u8df3\u8f6c\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528" : this.f40115aa.k());
                    v H = this.X.H(4);
                    if (H != null) {
                        int c16 = ak.c(appContext, H.c());
                        int c17 = ak.c(appContext, H.d());
                        int c18 = ak.c(appContext, H.e());
                        int a16 = ak.a((ak.b(appContext) - c16) - c17, H.f());
                        OlympicSlideView olympicSlideView2 = this.f40239ao;
                        if (a16 == 0) {
                            a16 = -1;
                        }
                        olympicSlideView2.setGestureHotArea(c16, c17, c18, a16);
                    }
                    this.f40239ao.setGestureSlideValidHeightDp(this.X.bU());
                    if (!TextUtils.isEmpty(this.f40115aa.d())) {
                        this.f40239ao.setGestureColor(this.f40115aa.d());
                    }
                    if (this.f40115aa.z() > 0) {
                        this.f40239ao.setGestureStrokeWidthDp(this.f40115aa.z());
                    }
                    this.f40239ao.setGestureVisible(this.f40115aa.y());
                    this.f40239ao.setGestureSlideDirection(this.f40115aa.m());
                } else {
                    this.f40239ao.setTitle("\u5411\u5de6\u6ed1\u52a8");
                    this.f40239ao.setSubTitle("\u8df3\u8f6c\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528");
                }
                a(bL.b(), rVar, this.f40239ao);
                return this.f40239ao;
            }
            GDTLogger.e("GallerySlideView creative card info invalid");
            return null;
        }
        GDTLogger.e("GallerySlideView ad info invalid");
        return null;
    }

    private String b(ExtraCreativeElement.b bVar, r rVar) {
        ExtraCreativeElement.a b16;
        if (bVar == null || rVar == null || rVar.bL() == null || (b16 = bVar.b()) == null) {
            return null;
        }
        String e16 = b16.e();
        if (this.f40240ap == null) {
            this.f40240ap = Boolean.TRUE;
            if (TextUtils.isEmpty(e16)) {
                this.f40241aq = true;
            }
        }
        return e16;
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
            OlympicSlideView olympicSlideView = this.f40239ao;
            if (olympicSlideView != null) {
                olympicSlideView.setEnabled(false);
            }
            f();
            return;
        }
        this.f40234aj = 1;
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(List<ExtraCreativeElement.b> list, r rVar, OlympicCarouselView olympicCarouselView) {
        ExtraCreativeElement.b bVar;
        if (g.b(list) || rVar == null || olympicCarouselView == null || (bVar = list.get(0)) == null) {
            return;
        }
        ExtraCreativeElement.b.a[] c16 = bVar.c();
        if (g.b(c16)) {
            return;
        }
        String str = null;
        String str2 = null;
        for (ExtraCreativeElement.b.a aVar : c16) {
            if (aVar != null) {
                int b16 = aVar.b();
                if (1 == b16) {
                    String c17 = aVar.c();
                    if (!TextUtils.isEmpty(c17)) {
                        GDTLogger.i("GallerySlideView setMovableImagePath:" + c17);
                        olympicCarouselView.setMovableImagePath(c17);
                    }
                } else if (2 == b16) {
                    str = aVar.c();
                    GDTLogger.i("GallerySlideView leftIcon:" + str);
                } else if (3 == b16) {
                    str2 = aVar.c();
                    GDTLogger.i("GallerySlideView rightIcon:" + str2);
                }
            }
        }
        olympicCarouselView.setUnMovableImagePaths(str, str2);
    }
}
