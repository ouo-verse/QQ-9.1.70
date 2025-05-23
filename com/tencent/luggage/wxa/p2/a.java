package com.tencent.luggage.wxa.p2;

import com.tencent.luggage.wxa.c3.j;
import com.tencent.luggage.wxa.ic.d;
import com.tencent.luggage.wxa.v3.h;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends h {
    public static final int CTRL_INDEX = 145;
    public static final String NAME = "enterContact";

    /* renamed from: a, reason: collision with root package name */
    public final j f137133a = new j();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String a(JSONObject jSONObject, d dVar, int i3, Void r56) {
        String optString = jSONObject.optString("imageUrl", "");
        if (!optString.isEmpty()) {
            try {
                jSONObject.put("sendMessageImg", optString);
            } catch (JSONException unused) {
            }
        }
        return h.a(dVar, getName(), jSONObject, i3).f(NAME).toString();
    }

    @Override // com.tencent.luggage.wxa.v3.h
    public final com.tencent.luggage.wxa.xo.d c(final d dVar, final JSONObject jSONObject, final int i3) {
        return this.f137133a.b(dVar, jSONObject).b(new com.tencent.luggage.wxa.uo.b() { // from class: r31.a
            @Override // com.tencent.luggage.wxa.uo.b
            public final Object call(Object obj) {
                String a16;
                a16 = com.tencent.luggage.wxa.p2.a.this.a(jSONObject, dVar, i3, (Void) obj);
                return a16;
            }
        });
    }
}
