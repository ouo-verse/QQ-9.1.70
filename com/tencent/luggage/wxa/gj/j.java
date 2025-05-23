package com.tencent.luggage.wxa.gj;

import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j extends com.tencent.luggage.wxa.ej.b {
    @Override // com.tencent.luggage.wxa.ej.a
    public int a() {
        return 4;
    }

    @Override // com.tencent.luggage.wxa.ej.b
    public void a(com.tencent.luggage.wxa.xa.h hVar, com.tencent.luggage.wxa.ej.c cVar) {
        try {
            int i3 = hVar.getInt("level");
            String optString = hVar.optString("message");
            if (i3 == 2) {
                w.d("MicroMsg.NodeJs", optString);
                return;
            }
            if (i3 == 3) {
                w.f("MicroMsg.NodeJs", optString);
            } else if (i3 != 4) {
                w.a("MicroMsg.NodeJs", optString);
            } else {
                w.b("MicroMsg.NodeJs", optString);
            }
        } catch (com.tencent.luggage.wxa.xa.f e16) {
            w.b("MicroMsg.NodeToXLog", "execute exception : %s", e16);
            cVar.a(2);
        }
    }
}
