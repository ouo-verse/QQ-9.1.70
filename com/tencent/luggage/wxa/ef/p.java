package com.tencent.luggage.wxa.ef;

import com.tencent.luggage.wxa.ef.o;
import com.tencent.luggage.wxa.qc.c;

/* compiled from: P */
/* loaded from: classes8.dex */
public class p extends o {
    public m E;
    public c.InterfaceC6640c F;

    public p(com.tencent.luggage.wxa.xd.d dVar) {
        super(dVar);
    }

    public void a(com.tencent.luggage.wxa.ic.g gVar) {
        if (w() != null) {
            w().a();
        }
        if (gVar != null && x() != null) {
            gVar.c0().b(x());
        }
        a((m) null);
        a((c.InterfaceC6640c) null);
        a((o.e) null);
    }

    public m w() {
        return this.E;
    }

    public c.InterfaceC6640c x() {
        return this.F;
    }

    public void a(m mVar) {
        this.E = mVar;
    }

    public void a(c.InterfaceC6640c interfaceC6640c) {
        this.F = interfaceC6640c;
    }
}
