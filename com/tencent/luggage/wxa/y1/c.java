package com.tencent.luggage.wxa.y1;

import com.tencent.luggage.wxa.jg.o;
import com.tencent.luggage.wxa.r4.d;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class c extends o {
    public c() {
        super(new a());
    }

    @Override // com.tencent.luggage.wxa.jg.o, com.tencent.luggage.wxa.jg.m
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map b(d dVar) {
        Map b16 = super.b((com.tencent.luggage.wxa.ic.d) dVar);
        int a16 = com.tencent.luggage.wxa.e2.a.a(dVar);
        if (a16 > 0) {
            b16.put("statusBarHeight", Integer.valueOf(a16));
        }
        return b16;
    }
}
