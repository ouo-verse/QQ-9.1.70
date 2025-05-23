package com.tencent.mobileqq.vasgift.view.anim;

import android.view.View;
import com.tencent.mobileqq.vasgift.mvvm.business.banner.BannerResManager;
import org.libpag.PAGFile;

/* compiled from: P */
/* loaded from: classes20.dex */
public class f extends BaseComboPagAnimation {

    /* renamed from: c, reason: collision with root package name */
    private int f312108c;

    public f(View view) {
        super(view);
        this.f312108c = 1;
    }

    @Override // com.tencent.mobileqq.vasgift.view.anim.BaseComboPagAnimation
    void d() {
        e(this.f312108c);
    }

    public void e(int i3) {
        BannerResManager x16;
        PAGFile u16;
        this.f312108c = i3;
        if (this.f312084b == null || (x16 = BannerResManager.x()) == null || (u16 = x16.u(i3)) == null) {
            return;
        }
        this.f312084b.setComposition(u16);
        this.f312084b.setRepeatCount(Integer.MAX_VALUE);
        this.f312084b.setScaleMode(3);
        this.f312084b.play();
    }
}
