package com.tencent.luggage.wxa.ig;

import com.tencent.luggage.wxa.tn.w0;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class y extends com.tencent.luggage.wxa.xd.v {
    public static final int CTRL_INDEX = 16;
    public static final String NAME = "setStorageSync";

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
        String a16;
        String optString = jSONObject.optString("key");
        String optString2 = jSONObject.optString("data");
        String optString3 = jSONObject.optString("dataType");
        int optInt = jSONObject.optInt("storageId", 0);
        if (w0.c(optString)) {
            return makeReturnJson(com.tencent.luggage.wxa.af.k.f121388d);
        }
        if (com.tencent.luggage.wxa.rc.v.a(optInt)) {
            return makeReturnJson(com.tencent.luggage.wxa.af.k.f121386b);
        }
        if (w0.c(dVar.getAppId())) {
            return makeReturnJson("fail:appID is empty");
        }
        com.tencent.luggage.wxa.fd.q qVar = (com.tencent.luggage.wxa.fd.q) dVar.a(com.tencent.luggage.wxa.fd.q.class);
        if (optString.length() + (optString2 != null ? optString2.length() : 0) > (qVar instanceof com.tencent.luggage.wxa.j4.g ? ((com.tencent.luggage.wxa.j4.g) qVar).f130831g0.f125737f : 1048576)) {
            return makeReturnJson("fail:entry size limit reached");
        }
        int i3 = qVar.f125967m;
        if (com.tencent.luggage.wxa.fd.q.a(i3)) {
            a16 = b(dVar, optString, optString2, optString3, optInt);
        } else if (i3 == 3) {
            String b16 = b(dVar, optString, optString2, optString3, optInt);
            a(dVar, optString, optString2, optString3, optInt);
            a16 = b16;
        } else {
            a16 = a(dVar, optString, optString2, optString3, optInt);
        }
        return makeReturnJson(a16);
    }

    public final String b(com.tencent.luggage.wxa.xd.d dVar, String str, String str2, String str3, int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.luggage.wxa.fd.q qVar = (com.tencent.luggage.wxa.fd.q) dVar.a(com.tencent.luggage.wxa.fd.q.class);
        try {
            return a0.b(((com.tencent.luggage.wxa.k4.a) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.k4.a.class)).a(dVar.getAppId(), qVar.f125967m, qVar.D).a(i3, dVar.getAppId(), str, str2, str3));
        } finally {
            com.tencent.luggage.wxa.rc.u.a(2, 1, com.tencent.luggage.wxa.rc.v.a(str, str2), 1, System.currentTimeMillis() - currentTimeMillis, qVar);
        }
    }

    public final String a(com.tencent.luggage.wxa.xd.d dVar, String str, String str2, String str3, int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.luggage.wxa.fd.q qVar = (com.tencent.luggage.wxa.fd.q) dVar.a(com.tencent.luggage.wxa.fd.q.class);
        try {
            z zVar = new z();
            zVar.f130349c = dVar.getAppId();
            zVar.f130350d = i3;
            zVar.a(str, str2, str3);
            if (zVar.c()) {
                return zVar.C;
            }
            com.tencent.luggage.wxa.tn.w.b("Luggage.FULL.JsApiSetStorageSync", "invokeWithDB appId[%s] key[%s] execSync failed", dVar.getAppId(), str);
            return "fail";
        } finally {
            com.tencent.luggage.wxa.rc.u.a(1, 1, com.tencent.luggage.wxa.rc.v.a(str, str2), 1, System.currentTimeMillis() - currentTimeMillis, qVar);
        }
    }
}
