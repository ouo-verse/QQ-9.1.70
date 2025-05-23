package com.tencent.luggage.wxa.xd;

import com.eclipsesource.mmv8.snapshot.Utils;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.luggage.wxa.fd.n0;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class l0 extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 927;

    @NotNull
    public static final String NAME = "getAppContact";

    /* renamed from: a, reason: collision with root package name */
    public static final a f144862a = new a(null);

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v21, types: [java.lang.String] */
    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.l lVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.fd.n0 a16;
        List split$default;
        if (lVar == null || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("username");
        String optString2 = jSONObject.optString("appid");
        if (Utils.isNullOrEmpty(optString) && Utils.isNullOrEmpty(optString2)) {
            String keyPath = jSONObject.optString("keyPath");
            com.tencent.luggage.wxa.tn.w.d("JsApiGetAppContact", "keyPath=" + keyPath);
            com.tencent.luggage.wxa.fd.n0 a17 = com.tencent.luggage.wxa.fd.o0.a().a(lVar.getAppId(), new String[0]);
            if (a17 != null) {
                Intrinsics.checkNotNullExpressionValue(keyPath, "keyPath");
                split$default = StringsKt__StringsKt.split$default((CharSequence) keyPath, new String[]{"."}, false, 0, 6, (Object) null);
                try {
                    JSONObject jSONObject2 = new JSONObject(a17.i());
                    Iterator it = split$default.iterator();
                    HashMap hashMap = null;
                    while (true) {
                        if (!it.hasNext()) {
                            r5 = hashMap;
                            break;
                        }
                        String str = (String) it.next();
                        if (jSONObject2 == null) {
                            break;
                        }
                        if (jSONObject2.has(str)) {
                            ?? opt = jSONObject2.opt(str);
                            if (opt == 0) {
                                hashMap = "";
                            } else {
                                Intrinsics.checkNotNullExpressionValue(opt, "json.opt(key) ?: \"\"");
                                hashMap = opt;
                            }
                        } else {
                            hashMap = null;
                        }
                        jSONObject2 = hashMap instanceof JSONObject ? (JSONObject) hashMap : null;
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("next=");
                    sb5.append(com.tencent.luggage.wxa.h6.d.b(r5) ? "is null" : String.valueOf(r5));
                    com.tencent.luggage.wxa.tn.w.d("JsApiGetAppContact", sb5.toString());
                    if (r5 == null) {
                        lVar.a(i3, makeReturnJson("fail: keyPath not found"));
                        return;
                    }
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("data", r5);
                    Unit unit = Unit.INSTANCE;
                    lVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap2));
                    return;
                } catch (JSONException e16) {
                    com.tencent.luggage.wxa.tn.w.b("JsApiGetAppContact", e16.getMessage());
                    lVar.a(i3, makeReturnJson("fail:internal error"));
                    return;
                }
            }
            return;
        }
        if (!Utils.isNullOrEmpty(optString)) {
            a16 = com.tencent.luggage.wxa.fd.o0.a().b(optString, new String[0]);
        } else {
            a16 = com.tencent.luggage.wxa.fd.o0.a().a(optString2, new String[0]);
        }
        HashMap hashMap3 = new HashMap();
        hashMap3.put(PM.BASE, a16 != null ? a(a16, lVar) : null);
        Unit unit2 = Unit.INSTANCE;
        lVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap3));
    }

    public final HashMap a(com.tencent.luggage.wxa.fd.n0 n0Var, com.tencent.luggage.wxa.ic.l lVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("nickName", n0Var.f138469h);
        hashMap.put("iconUrl", n0Var.f138473l);
        hashMap.put("appId", n0Var.f138467f);
        hashMap.put("username", n0Var.f138465d);
        n0.g h16 = n0Var.h();
        hashMap.put("weappVersion", h16 != null ? Integer.valueOf(h16.f125920a) : null);
        hashMap.put("signature", n0Var.f138481t);
        hashMap.put("debugMode", Integer.valueOf(lVar.getRuntime().S().f125811d));
        hashMap.put("appBrandInfo", a(n0Var.f(), n0Var.g()));
        com.tencent.luggage.wxa.tn.w.d("JsApiGetAppContact", "get contact from profile, nickName=%s, iconUrl=%s, appId=%s, username=%s, weappVersion=%s, signature=%s, debugMode=%d", n0Var.f138469h, n0Var.f138473l, n0Var.f138467f, n0Var.f138465d, n0Var.B, n0Var.f138481t, Integer.valueOf(lVar.getRuntime().S().f125811d));
        return hashMap;
    }

    public final HashMap a(n0.b bVar, n0.d dVar) {
        n0.d.a aVar;
        HashMap hashMap = new HashMap();
        hashMap.put("originalRedirectUrl", bVar != null ? bVar.f125878p : null);
        hashMap.put("appServiceType", bVar != null ? Integer.valueOf(bVar.f125867e) : null);
        hashMap.put("originalFlag", bVar != null ? Integer.valueOf(bVar.f125877o) : null);
        hashMap.put("brandOfficialFlag", (dVar == null || (aVar = dVar.f125894a) == null) ? null : Integer.valueOf(aVar.P));
        hashMap.put("relievedBuyFlag", bVar != null ? Integer.valueOf(bVar.f125880r) : null);
        hashMap.put("flagshipFlag", bVar != null ? Integer.valueOf(bVar.f125881s) : null);
        try {
            hashMap.put("gameIconFlagList", new JSONArray(bVar != null ? bVar.f125879q : null));
        } catch (JSONException e16) {
            com.tencent.luggage.wxa.tn.w.b("JsApiGetAppContact", "gameIconFlagList Failed to parse JSON: " + e16.getMessage());
        }
        hashMap.put("tagsInfo", com.tencent.luggage.wxa.qn.a.a(com.tencent.luggage.wxa.fd.f0.f125713a.a()));
        return hashMap;
    }
}
