package com.tencent.mobileqq.vasgift.mvvm.business.banner;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
class c extends BaseBannerView {
    private RoundImageView H;
    private RoundImageView I;

    public c(Context context, BannerResManager bannerResManager) {
        super(context, bannerResManager);
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.BaseBannerView, com.tencent.mobileqq.vasgift.mvvm.business.banner.e
    public void f() {
        super.f();
        QLog.i("Gift_Banner_DBannerView", 1, "onHitStart");
        b bVar = this.C;
        if (bVar != null) {
            bVar.h(this.f311744m);
        }
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.e
    public void h() {
        QLog.i("Gift_Banner_DBannerView", 1, "onHitEnd");
        m();
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.BaseBannerView
    public void i(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar, String str) {
        super.i(aVar, str);
        if (!TextUtils.isEmpty(aVar.f264922m)) {
            this.H.setImageDrawable(com.tencent.mobileqq.vasgift.utils.d.a(aVar.f264922m, null, null));
        }
        if (!TextUtils.isEmpty(aVar.f264923n)) {
            this.I.setImageDrawable(com.tencent.mobileqq.vasgift.utils.d.a(aVar.f264923n, null, null));
        }
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.BaseBannerView
    int k() {
        return R.layout.h8r;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.BaseBannerView
    public void l() {
        super.l();
        this.H = (RoundImageView) findViewById(R.id.x85);
        this.I = (RoundImageView) findViewById(R.id.f165680x84);
        this.H.setmRadius(ImmersiveUtils.dpToPx(20.0f), false);
        this.I.setmRadius(ImmersiveUtils.dpToPx(14.0f), false);
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.e
    public void a() {
    }
}
