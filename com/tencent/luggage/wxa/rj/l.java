package com.tencent.luggage.wxa.rj;

import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.uk.l0;

/* compiled from: P */
/* loaded from: classes8.dex */
public class l implements j {
    @Override // com.tencent.luggage.wxa.rj.j
    public void b(com.tencent.luggage.wxa.xd.d dVar, final String str) {
        l0.a(new Runnable() { // from class: com.tencent.luggage.wxa.rj.x
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.luggage.wxa.y9.a.makeText(z.c(), String.format("jsapi banned %s", str), 0).show();
            }
        });
    }
}
