package com.tencent.mobileqq.vasgift.view.anim;

import android.view.View;
import com.tencent.mobileqq.vasgift.mvvm.business.banner.BannerResManager;
import org.libpag.PAGFile;
import org.libpag.PAGView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a extends BaseComboPagAnimation {

    /* renamed from: c, reason: collision with root package name */
    private PAGFile f312088c;

    public a(View view) {
        super(view);
    }

    @Override // com.tencent.mobileqq.vasgift.view.anim.BaseComboPagAnimation
    void d() {
        BannerResManager x16;
        if (this.f312088c == null && (x16 = BannerResManager.x()) != null) {
            PAGFile q16 = x16.q();
            this.f312088c = q16;
            this.f312084b.setComposition(q16);
        }
    }

    public void e() {
        PAGView pAGView;
        if (this.f312088c != null && (pAGView = this.f312084b) != null) {
            pAGView.setProgress(0.0d);
            this.f312084b.play();
        }
    }
}
