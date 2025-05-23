package com.tencent.mobileqq.vasgift.mvvm.business.banner;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGView;

/* compiled from: P */
/* loaded from: classes20.dex */
class a extends BaseBannerView implements PAGView.PAGViewListener {
    private PAGView H;
    private boolean I;
    private boolean J;

    public a(Context context, BannerResManager bannerResManager) {
        super(context, bannerResManager);
        this.I = false;
        this.J = false;
    }

    private void p() {
        if (this.H.getComposition() != null) {
            this.H.setProgress(0.0d);
            this.H.play();
        } else {
            QLog.e("Gift_Banner_BannerView", 1, "playPag but file is null");
            this.J = true;
        }
    }

    private void q(String str, com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        PAGFile Load = PagViewMonitor.Load(str);
        if (Load == null) {
            QLog.e("Gift_Banner_BannerView", 1, "showPag but pagFile is null path:" + str);
            return;
        }
        this.H.setComposition(Load);
        this.D.J(aVar.f264922m, new C8936a(aVar, Load));
        this.D.J(aVar.f264923n, new b(aVar, Load));
        this.H.setProgress(0.0d);
    }

    private void r() {
        if (this.H.isPlaying()) {
            this.H.stop();
        }
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.BaseBannerView, com.tencent.mobileqq.vasgift.mvvm.business.banner.e
    public void f() {
        super.f();
        this.I = false;
        if (QLog.isColorLevel()) {
            QLog.i("Gift_Banner_BannerView", 1, "onHitStart");
        }
        com.tencent.mobileqq.vasgift.mvvm.business.banner.b bVar = this.C;
        if (bVar != null) {
            bVar.h(this.f311744m);
        }
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.e
    public void h() {
        if (QLog.isColorLevel()) {
            QLog.i("Gift_Banner_BannerView", 1, "onHitEnd isPagOver:" + this.J);
        }
        this.I = true;
        if (this.J) {
            m();
        }
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.BaseBannerView
    public void i(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar, String str) {
        super.i(aVar, str);
        q(str, aVar);
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.BaseBannerView
    int k() {
        return R.layout.h8q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.BaseBannerView
    public void l() {
        super.l();
        PAGView pAGView = (PAGView) findViewById(R.id.f219302c);
        this.H = pAGView;
        pAGView.addListener(this);
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.BaseBannerView
    public void n(int i3) {
        QLog.i("Gift_Banner_BannerView", 1, "play targetNum is " + i3);
        if (!this.F) {
            this.I = false;
            this.J = false;
            p();
        }
        super.n(i3);
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.BaseBannerView
    public void o() {
        QLog.i("Gift_Banner_BannerView", 1, "stop");
        super.o();
        r();
        this.I = false;
        this.J = false;
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public void onAnimationCancel(PAGView pAGView) {
        if (QLog.isColorLevel()) {
            QLog.i("Gift_Banner_BannerView", 1, "onAnimationCancel");
        }
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public void onAnimationEnd(PAGView pAGView) {
        if (QLog.isColorLevel()) {
            QLog.i("Gift_Banner_BannerView", 1, "onAnimationEnd isHitOver:" + this.I);
        }
        if (!this.F) {
            return;
        }
        this.J = true;
        if (this.I) {
            m();
        }
        p();
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public void onAnimationRepeat(PAGView pAGView) {
        if (QLog.isColorLevel()) {
            QLog.i("Gift_Banner_BannerView", 1, "onAnimationEnd isHitOver:" + this.I);
        }
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public void onAnimationStart(PAGView pAGView) {
        if (QLog.isColorLevel()) {
            QLog.i("Gift_Banner_BannerView", 1, "onPagAnimationStart");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.vasgift.mvvm.business.banner.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public class C8936a implements f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqgift.mvvm.business.anim.a f311792a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ PAGFile f311793b;

        C8936a(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar, PAGFile pAGFile) {
            this.f311792a = aVar;
            this.f311793b = pAGFile;
        }

        @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.f
        public void a(Bitmap bitmap) {
            if (a.this.f311744m != this.f311792a) {
                QLog.e("Gift_Banner_BannerView", 1, "head onLoadSuccess but not match");
            } else {
                this.f311793b.replaceImage(1, PAGImage.FromBitmap(bitmap));
            }
        }

        @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.f
        public void onLoadFailed() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqgift.mvvm.business.anim.a f311795a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ PAGFile f311796b;

        b(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar, PAGFile pAGFile) {
            this.f311795a = aVar;
            this.f311796b = pAGFile;
        }

        @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.f
        public void a(Bitmap bitmap) {
            if (a.this.f311744m != this.f311795a) {
                QLog.e("Gift_Banner_BannerView", 1, "head onLoadSuccess but not match");
            } else {
                this.f311796b.replaceImage(0, PAGImage.FromBitmap(bitmap));
            }
        }

        @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.f
        public void onLoadFailed() {
        }
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.e
    public void a() {
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public void onAnimationUpdate(PAGView pAGView) {
    }
}
