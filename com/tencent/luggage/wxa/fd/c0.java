package com.tencent.luggage.wxa.fd;

import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum c0 {
    ;

    public static c0 valueOf(String str) {
        com.tencent.luggage.wxa.k0.d.a(Enum.valueOf(c0.class, str));
        return null;
    }

    public static void a(com.tencent.luggage.wxa.j4.g gVar, String str) {
        gVar.f125959e = true;
        gVar.f125960f = true;
        gVar.f125961g = true;
        if (w0.c(str)) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrandSysConfigUtil", "operationInfo nil");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("bgKeepAlive");
            gVar.f125959e = jSONObject.optInt("music", 1) == 1;
            gVar.f125960f = jSONObject.optInt("location", 1) == 1;
            gVar.f125961g = jSONObject.optInt(QQPermissionConstants.Permission.BLUE_TOOTH_GROUP, 1) == 1;
        } catch (JSONException e16) {
            com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandSysConfigUtil", "assembleBgKeepAliveConfigByOperationInfo operationInfo:%s", str);
            com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandSysConfigUtil", "assembleBgKeepAliveConfigByOperationInfo exp:%s", e16);
        }
    }
}
