package com.tencent.luggage.wxa.c3;

import com.tencent.luggage.wxa.tn.w;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.v3.h {
    public static final int CTRL_INDEX = 73;
    public static final String NAME = "shareAppMessage";

    /* renamed from: a, reason: collision with root package name */
    public final j f123258a = new j();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f123259b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.r4.d f123260c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f123261d;

        public a(JSONObject jSONObject, com.tencent.luggage.wxa.r4.d dVar, int i3) {
            this.f123259b = jSONObject;
            this.f123260c = dVar;
            this.f123261d = i3;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call(Void r56) {
            try {
                this.f123259b.put("sdk_isFromMenu", true);
            } catch (JSONException unused) {
            }
            String iVar = com.tencent.luggage.wxa.v3.h.a(this.f123260c, d.this.getName(), this.f123259b, this.f123261d).f(e.NAME).toString();
            w.b("Luggage.JsApiShareAppMessage", "params:%s", iVar);
            return iVar;
        }
    }

    @Override // com.tencent.luggage.wxa.v3.h
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final com.tencent.luggage.wxa.xo.d c(com.tencent.luggage.wxa.r4.d dVar, JSONObject jSONObject, int i3) {
        return this.f123258a.b(dVar, jSONObject).b(new a(jSONObject, dVar, i3));
    }

    @Override // com.tencent.luggage.wxa.v3.h
    public String b(String str) {
        String replace = str.replace(e.NAME, NAME);
        w.a("Luggage.JsApiShareAppMessage", "result:%s", replace);
        return replace;
    }

    @Override // com.tencent.luggage.wxa.v3.h
    public boolean e() {
        return true;
    }
}
