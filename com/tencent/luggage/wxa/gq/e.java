package com.tencent.luggage.wxa.gq;

import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends b {
    public e(int i3, int i16) {
        super(i3, i16);
    }

    @Override // com.tencent.luggage.wxa.hq.b
    public long a(g gVar, TimeUnit timeUnit) {
        long a16 = gVar.a("INCREMENT", 1L);
        long a17 = gVar.a("LAST_INCREMENT", 0L) + a16;
        gVar.b("LAST_INCREMENT", a16);
        gVar.b("INCREMENT", a17);
        return timeUnit.convert(a17, TimeUnit.MILLISECONDS);
    }
}
