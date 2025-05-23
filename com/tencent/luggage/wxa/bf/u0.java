package com.tencent.luggage.wxa.bf;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class u0 extends h1 {
    @Override // com.tencent.luggage.wxa.bf.h1, com.tencent.luggage.wxa.bf.d
    public f a(com.tencent.luggage.wxa.xd.d dVar, String str, JSONObject jSONObject) {
        try {
            jSONObject.put("append", true);
            return super.a(dVar, str, jSONObject);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.UnitAppendFile", "call with path(%s), put append fail ex = %s", str, e16);
            return new f("fail " + com.tencent.luggage.wxa.rc.l.ERR_OP_FAIL.name(), new Object[0]);
        }
    }
}
