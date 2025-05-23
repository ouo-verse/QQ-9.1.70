package com.tencent.luggage.wxa.le;

import com.tencent.luggage.wxa.ne.k;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends com.tencent.luggage.wxa.ne.a {
    @Override // com.tencent.luggage.wxa.ne.a
    public void c() {
        if (this.f135710a.a() == null) {
            com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "connection is not open.", new Object[0]);
            b(k.f135752l);
            d();
        } else {
            this.f135710a.a(true);
            b(k.f135745e);
            d();
        }
    }

    @Override // com.tencent.luggage.wxa.ne.a
    public String e() {
        return "CloseAction";
    }
}
