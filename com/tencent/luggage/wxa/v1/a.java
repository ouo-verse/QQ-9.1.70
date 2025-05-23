package com.tencent.luggage.wxa.v1;

import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.tn.w;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "logInJava";

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(l lVar, JSONObject jSONObject, int i3) {
        try {
            int i16 = jSONObject.getInt("level");
            String string = jSONObject.getString("logs");
            if (i16 != 0) {
                if (i16 != 1) {
                    if (i16 != 2) {
                        if (i16 != 3) {
                            w.a("MicroMsg.JsApiLogInJava", string);
                        } else {
                            w.b("MicroMsg.JsApiLogInJava", string);
                        }
                    } else {
                        w.f("MicroMsg.JsApiLogInJava", string);
                    }
                } else {
                    w.d("MicroMsg.JsApiLogInJava", string);
                }
            } else {
                w.a("MicroMsg.JsApiLogInJava", string);
            }
        } catch (Exception e16) {
            w.b("MicroMsg.JsApiLogInJava", e16.toString());
        }
    }
}
