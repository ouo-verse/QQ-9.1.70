package com.tencent.luggage.wxa.xd;

import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class p extends k0 {
    @Override // com.tencent.luggage.wxa.xd.k0
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public p setContext(d dVar, int i3) {
        super.setContext(dVar, i3);
        return this;
    }

    @Override // com.tencent.luggage.wxa.xd.k0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public p setContext(d dVar) {
        super.setContext(dVar);
        return this;
    }

    public boolean e() {
        dispatch();
        return true;
    }

    @Override // com.tencent.luggage.wxa.xd.k0
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public p setData(Map map) {
        super.setData((Map<String, Object>) map);
        return this;
    }

    @Override // com.tencent.luggage.wxa.xd.k0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public p setData(String str) {
        super.setData(str);
        return this;
    }
}
