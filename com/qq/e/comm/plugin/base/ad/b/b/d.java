package com.qq.e.comm.plugin.base.ad.b.b;

import android.annotation.SuppressLint;
import android.content.Intent;
import com.qq.e.comm.plugin.base.ad.b.b.a;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ams.pcad.landingpage.DynamicAd;

/* compiled from: P */
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes3.dex */
public class d extends a {

    /* renamed from: w, reason: collision with root package name */
    private DynamicAd f38460w;

    public d(a.b bVar) {
        super(bVar);
    }

    @Override // com.qq.e.comm.plugin.base.ad.b.b.a
    public void b() {
        if (!a()) {
            a.InterfaceC0278a interfaceC0278a = this.f38386b;
            if (interfaceC0278a != null) {
                interfaceC0278a.b();
                return;
            }
            return;
        }
        super.b();
        this.f38386b.b();
    }

    @Override // com.qq.e.comm.plugin.base.ad.b.b.a
    public boolean f() {
        return false;
    }

    @Override // com.qq.e.comm.plugin.base.ad.b.b.a
    public void g() {
        if (!this.f38406v && this.f38401q) {
            com.qq.e.comm.plugin.base.ad.clickcomponent.d.d.a(this.f38393i, this.f38394j, this.f38391g, this.f38397m);
        }
    }

    @Override // com.qq.e.comm.plugin.base.ad.b.b.a
    public int h() {
        return 3;
    }

    @Override // com.qq.e.comm.plugin.base.ad.b.b.a
    public void i() {
        GDTLogger.d("HippyLandingPageView onResume");
        DynamicAd dynamicAd = this.f38460w;
        if (dynamicAd != null) {
            dynamicAd.resumeAd();
        }
    }

    @Override // com.qq.e.comm.plugin.base.ad.b.b.a
    public void j() {
        GDTLogger.d("HippyLandingPageView onPause");
        DynamicAd dynamicAd = this.f38460w;
        if (dynamicAd != null) {
            dynamicAd.pauseAd();
        }
    }

    @Override // com.qq.e.comm.plugin.base.ad.b.b.a
    public void k() {
        GDTLogger.d("HippyLandingPageView onDestroy");
        DynamicAd dynamicAd = this.f38460w;
        if (dynamicAd != null) {
            dynamicAd.clear();
        }
    }

    @Override // com.qq.e.comm.plugin.base.ad.b.b.a
    public void e() {
    }

    @Override // com.qq.e.comm.plugin.base.ad.b.b.a
    public void a(int i3, int i16, Intent intent) {
    }
}
