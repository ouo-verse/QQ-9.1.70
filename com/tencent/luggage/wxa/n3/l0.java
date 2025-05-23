package com.tencent.luggage.wxa.n3;

import com.tencent.luggage.wxa.hn.h6;
import com.tencent.luggage.wxa.hn.k1;
import com.tencent.luggage.wxa.hn.qe;
import com.tencent.luggage.wxa.hn.t8;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes8.dex */
public class l0 implements com.tencent.luggage.wxa.bj.c {

    /* renamed from: b, reason: collision with root package name */
    public static final l0 f135214b = new l0();

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.bj.c f135215a = com.tencent.luggage.wxa.p3.k.f137201a;

    public boolean a(com.tencent.luggage.wxa.bj.c cVar) {
        if (cVar == null) {
            return false;
        }
        this.f135215a = cVar;
        return true;
    }

    @Override // com.tencent.luggage.wxa.bj.c
    public com.tencent.luggage.wxa.xo.d b(String str, String str2, com.tencent.luggage.wxa.fn.b bVar, Class cls) {
        a(bVar);
        Iterator it = j0.a().iterator();
        if (!it.hasNext()) {
            return this.f135215a.b(str, str2, bVar, cls);
        }
        com.tencent.luggage.wxa.k0.d.a(it.next());
        throw null;
    }

    @Override // com.tencent.luggage.wxa.bj.c
    public t8 a(String str, String str2, com.tencent.luggage.wxa.fn.b bVar, Class cls) {
        a(bVar);
        Iterator it = j0.a().iterator();
        if (!it.hasNext()) {
            return this.f135215a.a(str, str2, bVar, cls);
        }
        com.tencent.luggage.wxa.k0.d.a(it.next());
        throw null;
    }

    public final void a(com.tencent.luggage.wxa.fn.b bVar) {
        k1 k1Var;
        if (bVar == null) {
            return;
        }
        if (com.tencent.luggage.wxa.p3.g.a() == 3 || com.tencent.luggage.wxa.p3.g.a() == 2) {
            if (bVar instanceof qe) {
                k1Var = ((qe) bVar).f128530j;
            } else if (bVar instanceof h6) {
                k1Var = ((h6) bVar).f127777u;
            } else {
                k1Var = bVar instanceof com.tencent.luggage.wxa.hn.i0 ? ((com.tencent.luggage.wxa.hn.i0) bVar).f127826g : null;
            }
            if (k1Var != null) {
                k1Var.f127980h = 1;
            }
        }
    }
}
