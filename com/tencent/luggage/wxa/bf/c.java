package com.tencent.luggage.wxa.bf;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c extends com.tencent.luggage.wxa.xd.v {

    /* renamed from: a, reason: collision with root package name */
    public final d f122531a;

    public c(d dVar) {
        this.f122531a = dVar;
        dVar.a(this);
    }

    @Override // com.tencent.luggage.wxa.xd.v
    public final String a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
        return a(dVar, jSONObject, dVar.getJsRuntime());
    }

    @Override // com.tencent.luggage.wxa.xd.o
    public boolean canHandleVarianceExecutable() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, com.tencent.luggage.wxa.ei.p pVar) {
        f a16 = this.f122531a.a(dVar, pVar, jSONObject);
        return makeReturnJsonWithNativeBuffer(dVar, a16.f144873b, a16.f144872a);
    }
}
