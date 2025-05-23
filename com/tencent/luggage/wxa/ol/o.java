package com.tencent.luggage.wxa.ol;

import com.tencent.luggage.wxa.xd.g;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class o implements g.b, g.c {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f136897a;

    public o(com.tencent.luggage.wxa.kj.v vVar) {
        this.f136897a = new WeakReference(vVar);
        vVar.a((g.b) this);
        vVar.a((g.c) this);
    }

    @Override // com.tencent.luggage.wxa.xd.g.b
    public void onBackground() {
        com.tencent.luggage.wxa.kj.v vVar = (com.tencent.luggage.wxa.kj.v) this.f136897a.get();
        if (vVar != null) {
            r.b(vVar);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.g.c
    public void onDestroy() {
        com.tencent.luggage.wxa.kj.v vVar = (com.tencent.luggage.wxa.kj.v) this.f136897a.get();
        if (vVar != null) {
            if (vVar.getContext() instanceof t0) {
                ((t0) vVar.getContext()).d();
            }
            r.b(vVar);
            r.c(vVar);
            g.a(vVar);
            vVar.b((g.b) this);
            vVar.b((g.c) this);
            if (vVar.D0() != null) {
                k.a().a(vVar);
            }
        }
    }
}
