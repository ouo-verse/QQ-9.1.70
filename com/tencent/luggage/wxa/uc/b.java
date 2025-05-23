package com.tencent.luggage.wxa.uc;

import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
class b implements com.tencent.luggage.wxa.ka.f {
    b() {
    }

    @Override // com.tencent.luggage.wxa.ka.f
    public void a(c cVar, com.tencent.luggage.wxa.ka.i iVar) {
        if (cVar == null) {
            w.f("MicroMsg.AppBrandBackgroundRunningManagerService", "sendOperation(MM process), data is null");
            iVar.a(new com.tencent.luggage.wxa.va.a(false));
        } else if (com.tencent.luggage.wxa.h1.e.a(e.class) == null) {
            iVar.a(new com.tencent.luggage.wxa.va.a(false));
        } else {
            com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.h1.e.a(e.class));
            throw null;
        }
    }
}
