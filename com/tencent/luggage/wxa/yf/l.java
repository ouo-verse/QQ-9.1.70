package com.tencent.luggage.wxa.yf;

import com.tencent.luggage.wxa.xd.o1;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class l extends com.tencent.luggage.wxa.xd.v {

    /* renamed from: a, reason: collision with root package name */
    public final Class f145724a;

    public l(Class cls) {
        this.f145724a = cls;
    }

    @Override // com.tencent.luggage.wxa.xd.v
    public final String a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
        com.tencent.luggage.wxa.kj.v a16 = o1.a(dVar);
        if (a16 == null) {
            return makeReturnJson("fail:page don't exist");
        }
        if (jSONObject == null) {
            return makeReturnJson("fail:invalid data");
        }
        Object f16 = a16.f(this.f145724a);
        if (f16 != null) {
            return a(dVar, jSONObject, f16);
        }
        if (!a16.isRunning()) {
            return makeReturnJson("fail:interrupted");
        }
        if (!a16.b()) {
            return makeReturnJson("fail:not supported");
        }
        throw new IllegalAccessError(String.format("%s Not Found", this.f145724a.getName()));
    }

    public abstract String a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, Object obj);
}
