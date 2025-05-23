package com.tencent.luggage.wxa.kj;

import android.view.View;
import com.tencent.luggage.wxa.xd.g;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d extends com.tencent.luggage.wxa.ic.d implements com.tencent.luggage.wxa.xd.g {
    public final /* synthetic */ com.tencent.luggage.wxa.xd.h H = new com.tencent.luggage.wxa.xd.h();

    public boolean E() {
        return this.H.a();
    }

    public void F() {
        this.H.b();
    }

    public void G() {
        this.H.c();
    }

    public void H() {
        this.H.e();
    }

    public void I() {
        this.H.f();
    }

    public void J() {
        this.H.g();
    }

    public void K() {
        View contentView = getContentView();
        if (contentView != null) {
            contentView.setVisibility(4);
        }
    }

    public void L() {
        this.H.h();
    }

    public void M() {
        View contentView = getContentView();
        if (contentView != null) {
            contentView.setVisibility(0);
        }
    }

    public void a(g.a aVar) {
        this.H.a(aVar);
    }

    @Override // com.tencent.luggage.wxa.xd.g
    public void b(g.d dVar) {
        this.H.b(dVar);
    }

    public void c(boolean z16) {
        this.H.b(z16);
    }

    public void d(Runnable runnable) {
        View contentView;
        if (runnable != null && (contentView = getContentView()) != null) {
            contentView.removeCallbacks(runnable);
        }
    }

    public final void e(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (com.tencent.luggage.wxa.tn.c0.b()) {
            runnable.run();
        } else {
            c(runnable);
        }
    }

    public abstract View getContentView();

    @Override // com.tencent.luggage.wxa.xd.g
    public void a(g.b bVar) {
        this.H.a(bVar);
    }

    @Override // com.tencent.luggage.wxa.xd.g
    public void b(g.b bVar) {
        this.H.b(bVar);
    }

    public void c(Runnable runnable) {
        View contentView;
        if (runnable == null || (contentView = getContentView()) == null) {
            return;
        }
        contentView.post(runnable);
    }

    @Override // com.tencent.luggage.wxa.xd.g
    public void a(g.c cVar) {
        this.H.a(cVar);
    }

    @Override // com.tencent.luggage.wxa.xd.g
    public void b(g.c cVar) {
        this.H.b(cVar);
    }

    public void a(g.e eVar) {
        this.H.a(eVar);
    }

    public void b(g.e eVar) {
        this.H.b(eVar);
    }

    public void a(g.f fVar) {
        this.H.a(fVar);
    }

    public void b(g.f fVar) {
        this.H.b(fVar);
    }

    @Override // com.tencent.luggage.wxa.xd.g
    public void a(g.d dVar) {
        this.H.a(dVar);
    }

    public void b(Runnable runnable, long j3) {
        View contentView;
        if (runnable == null || (contentView = getContentView()) == null) {
            return;
        }
        contentView.postDelayed(runnable, j3);
    }
}
