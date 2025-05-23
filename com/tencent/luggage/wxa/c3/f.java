package com.tencent.luggage.wxa.c3;

import com.tencent.luggage.wxa.tn.w;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f extends com.tencent.luggage.wxa.v3.h {
    public static final int CTRL_INDEX = 589;
    public static final String NAME = "shareAppMessageForFakeNative";

    /* renamed from: a, reason: collision with root package name */
    public final j f123268a = new j();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f123269b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.r4.d f123270c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f123271d;

        public a(JSONObject jSONObject, com.tencent.luggage.wxa.r4.d dVar, int i3) {
            this.f123269b = jSONObject;
            this.f123270c = dVar;
            this.f123271d = i3;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call(Void r56) {
            try {
                this.f123269b.put("sdk_isFromMenu", true);
            } catch (JSONException unused) {
            }
            String iVar = com.tencent.luggage.wxa.v3.h.a(this.f123270c, f.this.getName(), this.f123269b, this.f123271d).f(e.NAME).toString();
            w.b("Luggage.JsApiShareAppMessageForFakeNative", "params:%s", iVar);
            return iVar;
        }
    }

    @Override // com.tencent.luggage.wxa.v3.h
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final com.tencent.luggage.wxa.xo.d c(com.tencent.luggage.wxa.r4.d dVar, JSONObject jSONObject, int i3) {
        return this.f123268a.b(dVar, jSONObject).b(new a(jSONObject, dVar, i3));
    }

    @Override // com.tencent.luggage.wxa.v3.h
    public String b(String str) {
        String replace = str.replace(e.NAME, NAME);
        w.a("Luggage.JsApiShareAppMessageForFakeNative", "result:%s", replace);
        return replace;
    }

    @Override // com.tencent.luggage.wxa.v3.h
    public boolean e() {
        return true;
    }
}
