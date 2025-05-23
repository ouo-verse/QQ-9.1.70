package com.tencent.luggage.wxa.hh;

import com.tencent.luggage.wxa.tn.w;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a extends com.tencent.luggage.wxa.xd.a {
    public abstract void a(c cVar, com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3);

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        if (jSONObject == null) {
            w.b("MicroMsg.BaseRecordJsApi", "%s invalid data", getName());
            dVar.a(i3, makeReturnJson("fail:invalid data"));
            return;
        }
        c cVar = (c) dVar.b(c.class);
        if (cVar == null) {
            w.b("MicroMsg.BaseRecordJsApi", "%s voicePlayer is null, err", getName());
            dVar.a(i3, String.format("fail:internal error %s", "player is null"));
        } else {
            a(cVar, dVar, jSONObject, i3);
        }
    }
}
