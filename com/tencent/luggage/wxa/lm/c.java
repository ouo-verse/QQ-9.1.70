package com.tencent.luggage.wxa.lm;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.h9.a {
    @Override // com.tencent.luggage.wxa.h9.a
    public com.tencent.luggage.wxa.l9.c a(com.tencent.luggage.wxa.qb.b bVar) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        String str = bVar.f138586w;
        if (str != null) {
            concurrentHashMap.put(bVar.f138565b, str);
        }
        return new d(new com.tencent.luggage.wxa.vm.a(concurrentHashMap), bVar);
    }
}
