package com.tencent.luggage.wxa.nf;

import com.tencent.luggage.wxa.ei.p;
import com.tencent.luggage.wxa.nf.b;
import com.tencent.luggage.wxa.xd.v;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b extends v implements com.tencent.luggage.wxa.ee.h {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.ee.a f135771a = new com.tencent.luggage.wxa.ee.a();

    public void a(com.tencent.luggage.wxa.xd.d dVar, String str) {
    }

    @Override // com.tencent.luggage.wxa.xd.o
    public boolean canHandleVarianceExecutable() {
        return true;
    }

    public final com.tencent.luggage.wxa.ee.a e() {
        return this.f135771a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, String str) {
        a(dVar, jSONObject, str);
    }

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
        if (!com.tencent.luggage.wxa.tn.e.f141559a) {
            return a(dVar, jSONObject, dVar.getJsRuntime());
        }
        throw new RuntimeException("Should call 3 params version!");
    }

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(final com.tencent.luggage.wxa.xd.d dVar, final JSONObject jSONObject, p pVar) {
        final String b16 = b();
        HashMap hashMap = new HashMap();
        hashMap.put(d(), b16);
        this.f135771a.a(b16, pVar);
        a(dVar, b16);
        com.tencent.luggage.wxa.dq.a asyncHandler = dVar.getAsyncHandler();
        if (asyncHandler != null) {
            asyncHandler.a(new Runnable() { // from class: k31.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.b(dVar, jSONObject, b16);
                }
            });
        } else {
            a(dVar, jSONObject, b16);
        }
        return makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a, hashMap);
    }
}
