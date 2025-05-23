package com.tencent.luggage.wxa.ig;

import com.tencent.luggage.wxa.rc.p;
import com.tencent.luggage.wxa.tn.w0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f130261a = new a();

    public final String a(com.tencent.luggage.wxa.xd.o jsapi, com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
        String str;
        Intrinsics.checkNotNullParameter(jsapi, "jsapi");
        if (dVar == null) {
            return "";
        }
        if (jSONObject == null) {
            String makeReturnJson = jsapi.makeReturnJson(com.tencent.luggage.wxa.af.e.f121315k);
            Intrinsics.checkNotNullExpressionValue(makeReturnJson, "jsapi.makeReturnJson(App\u2026ral.INVALID_REQUEST_DATA)");
            return makeReturnJson;
        }
        int optInt = jSONObject.optInt("storageId");
        if (com.tencent.luggage.wxa.rc.v.a(optInt)) {
            String makeReturnJson2 = jsapi.makeReturnJson(com.tencent.luggage.wxa.af.k.f121386b);
            Intrinsics.checkNotNullExpressionValue(makeReturnJson2, "jsapi.makeReturnJson(App\u2026ONEXISTENT_STORAGE_SPACE)");
            return makeReturnJson2;
        }
        String appId = dVar.getAppId();
        Intrinsics.checkNotNullExpressionValue(appId, "env.appId");
        if (w0.c(appId)) {
            String makeReturnJson3 = jsapi.makeReturnJson("fail:appID is empty");
            Intrinsics.checkNotNullExpressionValue(makeReturnJson3, "jsapi.makeReturnJson(App\u2026yncJsApi.API_APPID_EMPTY)");
            return makeReturnJson3;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("keyList");
        if (optJSONArray == null) {
            String makeReturnJson4 = jsapi.makeReturnJson(com.tencent.luggage.wxa.af.e.f121315k);
            Intrinsics.checkNotNullExpressionValue(makeReturnJson4, "jsapi.makeReturnJson(App\u2026ral.INVALID_REQUEST_DATA)");
            return makeReturnJson4;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            String string = optJSONArray.getString(i3);
            Intrinsics.checkNotNullExpressionValue(string, "keyJSonArray.getString(index)");
            arrayList2.add(string);
        }
        com.tencent.luggage.wxa.fd.q qVar = (com.tencent.luggage.wxa.fd.q) dVar.a(com.tencent.luggage.wxa.fd.q.class);
        if (qVar == null) {
            String makeReturnJson5 = jsapi.makeReturnJson(com.tencent.luggage.wxa.af.e.f121315k);
            Intrinsics.checkNotNullExpressionValue(makeReturnJson5, "jsapi.makeReturnJson(App\u2026ral.INVALID_REQUEST_DATA)");
            return makeReturnJson5;
        }
        for (Object[] objArr : ((com.tencent.luggage.wxa.k4.a) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.k4.a.class)).a(dVar.getAppId(), qVar.f125967m, qVar.D).b(optInt, appId, arrayList2)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Object obj = objArr[0];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appstorage.IAppBrandKVStorage.ErrorType");
            p.a aVar = (p.a) obj;
            p.a aVar2 = p.a.NONE;
            if (aVar != aVar2) {
                str = "";
            } else {
                Object obj2 = objArr[1];
                if (obj2 == null) {
                    obj2 = "";
                }
                str = (String) obj2;
            }
            linkedHashMap.put("data", str);
            Object obj3 = "Null";
            if (aVar == aVar2) {
                Object obj4 = objArr[2];
                if (obj4 != null) {
                    obj3 = obj4;
                }
                obj3 = (String) obj3;
            }
            linkedHashMap.put("dataType", obj3);
            arrayList.add(linkedHashMap);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("dataList", arrayList);
        String makeReturnJson6 = jsapi.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a, hashMap);
        Intrinsics.checkNotNullExpressionValue(makeReturnJson6, "jsapi.makeReturnJson(App\u2026dErrors.General.OK, this)");
        return makeReturnJson6;
    }

    public final String b(com.tencent.luggage.wxa.xd.o jsapi, com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jsapi, "jsapi");
        if (dVar == null) {
            return "";
        }
        if (jSONObject == null) {
            String makeReturnJson = jsapi.makeReturnJson(com.tencent.luggage.wxa.af.e.f121315k);
            Intrinsics.checkNotNullExpressionValue(makeReturnJson, "jsapi.makeReturnJson(App\u2026ral.INVALID_REQUEST_DATA)");
            return makeReturnJson;
        }
        int optInt = jSONObject.optInt("storageId");
        if (com.tencent.luggage.wxa.rc.v.a(optInt)) {
            String makeReturnJson2 = jsapi.makeReturnJson(com.tencent.luggage.wxa.af.k.f121386b);
            Intrinsics.checkNotNullExpressionValue(makeReturnJson2, "jsapi.makeReturnJson(App\u2026ONEXISTENT_STORAGE_SPACE)");
            return makeReturnJson2;
        }
        String appId = dVar.getAppId();
        Intrinsics.checkNotNullExpressionValue(appId, "env.appId");
        if (w0.c(appId)) {
            String makeReturnJson3 = jsapi.makeReturnJson(com.tencent.luggage.wxa.af.e.B);
            Intrinsics.checkNotNullExpressionValue(makeReturnJson3, "jsapi.makeReturnJson(App\u2026API_SERVER_INVALID_APPID)");
            return makeReturnJson3;
        }
        com.tencent.luggage.wxa.fd.q qVar = (com.tencent.luggage.wxa.fd.q) dVar.a(com.tencent.luggage.wxa.fd.q.class);
        if (qVar == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandBatchStorageApiOp", "invoke with appId[%s] , NULL sysConfig", dVar.getAppId());
            String makeReturnJson4 = jsapi.makeReturnJson(com.tencent.luggage.wxa.af.e.f121309e);
            Intrinsics.checkNotNullExpressionValue(makeReturnJson4, "jsapi.makeReturnJson(App\u2026s.General.INTERNAL_ERROR)");
            return makeReturnJson4;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("kvList");
        if (optJSONArray == null) {
            String makeReturnJson5 = jsapi.makeReturnJson(com.tencent.luggage.wxa.af.e.f121315k);
            Intrinsics.checkNotNullExpressionValue(makeReturnJson5, "jsapi.makeReturnJson(App\u2026ral.INVALID_REQUEST_DATA)");
            return makeReturnJson5;
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
            String optString = jSONObject2.optString("key");
            String optString2 = jSONObject2.optString("data");
            String optString3 = jSONObject2.optString("dataType");
            if (optString == null) {
                optString = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(optString, "key ?: \"\"");
            }
            if (optString2 == null) {
                optString2 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(optString2, "data ?: \"\"");
            }
            if (optString3 == null) {
                optString3 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(optString3, "dataType ?: \"\"");
            }
            arrayList.add(new p.b(optString, optString2, optString3));
        }
        String makeReturnJson6 = jsapi.makeReturnJson(a0.a(((com.tencent.luggage.wxa.k4.a) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.k4.a.class)).a(dVar.getAppId(), qVar.f125967m, qVar.D).a(optInt, appId, arrayList)));
        Intrinsics.checkNotNullExpressionValue(makeReturnJson6, "jsapi.makeReturnJson(result)");
        return makeReturnJson6;
    }
}
