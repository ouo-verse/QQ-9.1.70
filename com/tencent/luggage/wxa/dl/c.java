package com.tencent.luggage.wxa.dl;

import com.tencent.luggage.wxa.dl.a;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends b {
    @Override // com.tencent.luggage.wxa.dl.b, com.tencent.luggage.wxa.dl.a
    public a.b a(com.tencent.luggage.wxa.gl.a aVar) {
        if (b.b(aVar) == 13) {
            return a.b.MATCHED;
        }
        return a.b.NOT_MATCHED;
    }

    @Override // com.tencent.luggage.wxa.dl.b, com.tencent.luggage.wxa.dl.a
    public com.tencent.luggage.wxa.gl.b a(com.tencent.luggage.wxa.gl.b bVar) {
        super.a(bVar);
        bVar.a("Sec-WebSocket-Version", "13");
        return bVar;
    }

    @Override // com.tencent.luggage.wxa.dl.b, com.tencent.luggage.wxa.dl.a
    public a a() {
        return new c();
    }
}
