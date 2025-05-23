package com.qq.e.comm.plugin.base.ad.b.b;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.qq.e.comm.plugin.base.ad.b.b.a;
import com.qq.e.comm.plugin.k.au;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends a {

    /* renamed from: w, reason: collision with root package name */
    private View f38443w;

    public b(a.b bVar) {
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
        boolean booleanExtra = this.f38385a.getIntent().getBooleanExtra(WadlProxyConsts.VIA_AUTO_DOWNLOAD, false);
        Context applicationContext = this.f38385a.getApplicationContext();
        if (this.f38390f.isAppAd() && com.qq.e.comm.plugin.c.a.a() && com.qq.e.comm.plugin.c.a.b().isCanvas(this.f38390f.v()) && com.qq.e.comm.plugin.c.a.b().dealCanvasAd(applicationContext, this.f38390f.v(), booleanExtra)) {
            StatTracer.trackEvent(4003050, 0, this.f38391g);
            if (com.qq.e.comm.plugin.c.a.c()) {
                StatTracer.trackEvent(133019, 0, (com.qq.e.comm.plugin.stat.b) null);
            } else {
                com.qq.e.comm.plugin.c.a.b().initForCanvas(applicationContext, this.f38390f.v(), this.f38394j, booleanExtra);
                this.f38443w = com.qq.e.comm.plugin.c.a.b().getCanvasView(this.f38385a, this.f38390f.v(), booleanExtra, this.f38400p);
            }
        }
        if (this.f38443w == null) {
            this.f38386b.b();
            return;
        }
        if (this.f38401q) {
            com.qq.e.comm.plugin.base.ad.clickcomponent.d.d.a(this.f38393i, this.f38394j, this.f38391g, this.f38397m);
        }
        this.f38387c.addView(this.f38443w);
        this.f38386b.a(this.f38387c);
        au.a(1320044);
    }

    @Override // com.qq.e.comm.plugin.base.ad.b.b.a
    public boolean f() {
        com.qq.e.comm.plugin.c.a.b().onBackPressed(this.f38443w);
        return false;
    }

    @Override // com.qq.e.comm.plugin.base.ad.b.b.a
    public int h() {
        return 2;
    }

    @Override // com.qq.e.comm.plugin.base.ad.b.b.a
    public void i() {
        com.qq.e.comm.plugin.c.a.b().onActivityResume(this.f38443w);
    }

    @Override // com.qq.e.comm.plugin.base.ad.b.b.a
    public void j() {
        com.qq.e.comm.plugin.c.a.b().onActivityPause(this.f38443w);
    }

    @Override // com.qq.e.comm.plugin.base.ad.b.b.a
    public void k() {
        com.qq.e.comm.plugin.c.a.b().onActivityDestroy(this.f38443w);
    }

    @Override // com.qq.e.comm.plugin.base.ad.b.b.a
    public void e() {
    }

    @Override // com.qq.e.comm.plugin.base.ad.b.b.a
    public void g() {
    }

    @Override // com.qq.e.comm.plugin.base.ad.b.b.a
    public void a(int i3, int i16, Intent intent) {
    }
}
