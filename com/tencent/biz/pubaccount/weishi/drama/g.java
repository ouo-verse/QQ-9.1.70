package com.tencent.biz.pubaccount.weishi.drama;

import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes32.dex */
public class g implements com.tencent.biz.pubaccount.weishi.player.a {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<qz.c> f80690a;

    /* renamed from: b, reason: collision with root package name */
    private final WeakReference<pz.b> f80691b;

    public g(pz.b bVar) {
        this.f80691b = new WeakReference<>(bVar);
        this.f80690a = new WeakReference<>(a(bVar));
    }

    private qz.c a(pz.b bVar) {
        pz.c r16 = r(bVar);
        if (r16 != null) {
            return r16.i();
        }
        return null;
    }

    private void s() {
        c d16;
        pz.b bVar = this.f80691b.get();
        if (bVar == null || (d16 = bVar.d()) == null) {
            return;
        }
        d16.hideLoading();
    }

    private void t() {
        c d16;
        pz.b bVar = this.f80691b.get();
        if (bVar == null || (d16 = bVar.d()) == null) {
            return;
        }
        d16.showLoading();
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void b(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        qz.c cVar = this.f80690a.get();
        if (cVar != null) {
            cVar.C();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void c(com.tencent.biz.pubaccount.weishi.player.e eVar, int i3, int i16, String str) {
        qz.c cVar = this.f80690a.get();
        if (cVar != null) {
            cVar.E(str);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void e(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        qz.c cVar = this.f80690a.get();
        if (cVar != null) {
            cVar.y(8, 400);
            cVar.C();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void g(com.tencent.biz.pubaccount.weishi.player.e eVar, boolean z16, boolean z17) {
        qz.c cVar = this.f80690a.get();
        if (cVar != null && z16 && z17) {
            cVar.y(8, 400);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void h(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        qz.c cVar = this.f80690a.get();
        if (cVar != null) {
            cVar.y(0, 100);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void j(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        qz.c cVar = this.f80690a.get();
        if (cVar != null) {
            cVar.y(8, 400);
            cVar.C();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public boolean k(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void o(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        qz.c cVar = this.f80690a.get();
        if (cVar != null) {
            cVar.y(0, 100);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void p(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        s();
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void q(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        t();
    }

    private pz.c r(pz.b bVar) {
        if (bVar == null) {
            return null;
        }
        com.tencent.biz.pubaccount.weishi.baseui.c<mz.d> cVar = bVar.f428077e;
        if (cVar instanceof pz.c) {
            return (pz.c) cVar;
        }
        return null;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void d(com.tencent.biz.pubaccount.weishi.player.e eVar) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void f(com.tencent.biz.pubaccount.weishi.player.e eVar) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void n(com.tencent.biz.pubaccount.weishi.player.e eVar) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void l(com.tencent.biz.pubaccount.weishi.player.e eVar, boolean z16) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void i(com.tencent.biz.pubaccount.weishi.player.e eVar, int i3, boolean z16) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void m(com.tencent.biz.pubaccount.weishi.player.e eVar, long j3, long j16) {
    }
}
