package com.tencent.luggage.wxa.a8;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class w implements j {

    /* renamed from: a, reason: collision with root package name */
    public Map f120963a = new ConcurrentHashMap();

    @Override // com.tencent.luggage.wxa.a8.j
    public k getAddOn(Class cls) {
        k kVar = (k) this.f120963a.get(cls);
        if (kVar != null && cls.isInstance(kVar)) {
            return kVar;
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.a8.j
    public String getName() {
        return "VideoPlayer#Stub";
    }

    @Override // com.tencent.luggage.wxa.a8.j
    public void setAddOn(Class cls, k kVar) {
        if (kVar == null) {
            this.f120963a.remove(cls);
        } else {
            this.f120963a.put(cls, kVar);
        }
    }
}
