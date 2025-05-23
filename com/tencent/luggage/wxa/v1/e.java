package com.tencent.luggage.wxa.v1;

import com.tencent.luggage.wxa.bf.f;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.xd.v;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends v {
    public static final int CTRL_INDEX = 401;
    public static final String NAME = "canvasToTempFilePathSync";

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(l lVar, JSONObject jSONObject) {
        com.tencent.luggage.wxa.kj.v J = lVar.J();
        if (((com.tencent.luggage.wxa.z1.d) J.f(com.tencent.luggage.wxa.z1.d.class)) == null) {
            return makeReturnJson("fail");
        }
        f a16 = d.a(J, jSONObject, true);
        return makeReturnJson(a16.f144873b, a16.f144872a);
    }
}
