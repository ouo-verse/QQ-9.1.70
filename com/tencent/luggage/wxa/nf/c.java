package com.tencent.luggage.wxa.nf;

import com.tencent.luggage.wxa.ei.p;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c extends com.tencent.luggage.wxa.xd.a implements com.tencent.luggage.wxa.ee.h {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.ee.a f135772a = new com.tencent.luggage.wxa.ee.a();

    @Override // com.tencent.luggage.wxa.xd.o
    public boolean canHandleVarianceExecutable() {
        return true;
    }

    public com.tencent.luggage.wxa.ee.a e() {
        return this.f135772a;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        if (!com.tencent.luggage.wxa.tn.e.f141559a) {
            invoke(dVar, jSONObject, i3, dVar.getJsRuntime());
            return;
        }
        throw new RuntimeException("Should call 3 params version!");
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3, p pVar) {
        String b16 = b();
        HashMap hashMap = new HashMap();
        hashMap.put(d(), b16);
        this.f135772a.a(b16, pVar);
        dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a, hashMap));
        a(dVar, jSONObject, b16);
    }
}
