package com.tencent.luggage.wxa.q7;

import android.text.TextUtils;
import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.fd.o0;
import com.tencent.luggage.wxa.tn.w0;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum d0 {
    INSTANCE;

    public com.tencent.luggage.wxaapi.r a(String str) {
        com.tencent.luggage.wxaapi.r rVar = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        n0 a16 = o0.a().a(str, "appId", "nickname", "signature", "brandIconURL", "smallHeadURL", "dynamicInfo", "versionInfo", "appInfo", "registerSource", "bindWxaInfo");
        if (a16 != null) {
            rVar = new com.tencent.luggage.wxaapi.r();
            rVar.f146894a = str;
            rVar.f146895b = a16.f138469h;
            rVar.f146897d = a16.f138481t;
            rVar.f146896c = !TextUtils.isEmpty(a16.f138479r) ? a16.f138479r : a16.f138473l;
            rVar.f146898e = a16.g().f125895b;
            try {
                rVar.f146899f = w0.c(a16.f138485x) ? "" : new JSONObject(a16.f138485x).optString("RegisterBody", "");
            } catch (Exception unused) {
            }
        }
        return rVar;
    }
}
