package com.tencent.luggage.wxa.zf;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class f extends a {
    public static final int CTRL_INDEX = 84;
    public static final String NAME = "showDatePickerView";

    @Override // com.tencent.luggage.wxa.zf.a, com.tencent.luggage.wxa.xd.a
    /* renamed from: a */
    public void invoke(com.tencent.luggage.wxa.xd.f fVar, JSONObject jSONObject, int i3) {
        String optString = jSONObject.optString("mode");
        if ("date".equals(optString)) {
            new b().a(this, fVar, jSONObject, i3, e());
        } else if ("time".equals(optString)) {
            new k().a(this, fVar, jSONObject, i3, e());
        } else {
            fVar.a(i3, makeReturnJson("fail:invalid data"));
        }
    }
}
