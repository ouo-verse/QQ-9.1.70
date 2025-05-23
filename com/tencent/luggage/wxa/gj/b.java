package com.tencent.luggage.wxa.gj;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.ej.d {
    @Override // com.tencent.luggage.wxa.ej.a
    public int a() {
        return 2;
    }

    @Override // com.tencent.luggage.wxa.ej.d
    public String a(com.tencent.luggage.wxa.xa.h hVar, com.tencent.luggage.wxa.ej.c cVar) {
        com.tencent.luggage.wxa.ic.l a16 = cVar.a();
        HashMap hashMap = new HashMap();
        hashMap.put("state", Integer.valueOf(a16.getRuntime().c0().b().ordinal()));
        return cVar.b(hashMap);
    }
}
