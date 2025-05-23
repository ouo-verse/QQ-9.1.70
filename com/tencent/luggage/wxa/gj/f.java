package com.tencent.luggage.wxa.gj;

import com.tencent.luggage.wxa.yi.q;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f extends com.tencent.luggage.wxa.ej.d {
    @Override // com.tencent.luggage.wxa.ej.a
    public int a() {
        return 6;
    }

    @Override // com.tencent.luggage.wxa.ej.d
    public String a(com.tencent.luggage.wxa.xa.h hVar, com.tencent.luggage.wxa.ej.c cVar) {
        String str = (String) q.f(hVar.optString("url")).get("host");
        HashMap hashMap = new HashMap();
        hashMap.put("isLANIp", Boolean.valueOf(q.e(str) == 2));
        return cVar.b(hashMap);
    }
}
