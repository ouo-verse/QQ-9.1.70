package com.tencent.luggage.wxa.kf;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.uk.h;
import com.tencent.luggage.wxa.uk.u;
import com.tencent.luggage.wxa.xd.v;
import com.tencent.luggage.wxa.xi.a;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends v {
    public static final int CTRL_INDEX = 1184;
    public static final String NAME = "awaitLoadSubPackageTask";

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
        String str;
        com.tencent.luggage.wxa.af.c cVar;
        String optString = jSONObject.optString("loadTaskId");
        if (w0.c(optString)) {
            w.b("MicroMsg.JsApiAwaitLoadSubPackageTask", "null or nil loadTaskId");
            return makeReturnJson(com.tencent.luggage.wxa.af.e.f121315k);
        }
        int optInt = jSONObject.optInt("timeout", 10000);
        w.d("MicroMsg.JsApiAwaitLoadSubPackageTask", "await taskId: %s, timeout: %d", optString, Integer.valueOf(optInt));
        long a16 = w0.a();
        String b16 = d.b(optString);
        u a17 = h.a(dVar);
        boolean a18 = a17.a(b16, optInt);
        a.e eVar = (a.e) a17.b(b16);
        Object[] objArr = new Object[4];
        objArr[0] = optString;
        objArr[1] = Long.valueOf(w0.e(a16));
        objArr[2] = Boolean.valueOf(a18);
        if (eVar != null) {
            str = eVar.toString();
        } else {
            str = "null";
        }
        objArr[3] = str;
        w.d("MicroMsg.JsApiAwaitLoadSubPackageTask", "await taskId: %s done, using %d ms and is success %b and load result is %s", objArr);
        if (a18) {
            if (eVar == a.e.OK) {
                cVar = com.tencent.luggage.wxa.af.e.f121305a;
            } else if (eVar == a.e.CANCEL) {
                cVar = com.tencent.luggage.wxa.af.e.f121306b;
            } else {
                cVar = com.tencent.luggage.wxa.af.e.f121309e;
            }
        } else {
            cVar = com.tencent.luggage.wxa.af.e.f121310f;
        }
        return makeReturnJson(cVar);
    }
}
