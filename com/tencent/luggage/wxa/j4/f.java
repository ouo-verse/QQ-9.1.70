package com.tencent.luggage.wxa.j4;

import com.tencent.luggage.wxa.mc.q0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0006\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/luggage/wxa/j4/f;", "Lcom/tencent/luggage/wxa/xd/l;", "", "appId", "", "a", "Lcom/tencent/luggage/wxa/c5/e;", "Lcom/tencent/luggage/wxa/c5/e;", "rt", "Lorg/json/JSONArray;", "b", "Lorg/json/JSONArray;", "call_plugin_info", "<init>", "(Lcom/tencent/luggage/wxa/c5/e;)V", "c", "luggage-wechat-full-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class f implements com.tencent.luggage.wxa.xd.l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final com.tencent.luggage.wxa.c5.e rt;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public JSONArray call_plugin_info;

    public f(com.tencent.luggage.wxa.c5.e rt5) {
        Intrinsics.checkNotNullParameter(rt5, "rt");
        this.rt = rt5;
    }

    public final int a(String appId) {
        boolean z16;
        JSONArray optJSONArray;
        com.tencent.mm.plugin.appbrand.appcache.a aVar;
        q0 q0Var;
        WxaPluginPkgInfo a16;
        boolean z17 = true;
        if (appId != null && appId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return 0;
        }
        g j06 = this.rt.j0();
        if (j06 != null && (aVar = j06.f125966l) != null && (q0Var = aVar.f151866f) != null && (a16 = q0Var.a(appId)) != null) {
            return a16.getPkgAppVersion();
        }
        if (this.call_plugin_info == null) {
            String g16 = this.rt.S().g();
            if (g16 != null && g16.length() != 0) {
                z17 = false;
            }
            if (z17) {
                optJSONArray = new JSONArray();
            } else {
                try {
                    optJSONArray = new JSONObject(g16).optJSONArray("call_plugin_info");
                    Intrinsics.checkNotNullExpressionValue(optJSONArray, "{\n                try {\n\u2026          }\n            }");
                } catch (JSONException e16) {
                    w.b("MicroMsg.AppBrandRuntimePluginInfoConfig", "getPluginInnerVersion(appId:" + appId + ") parse call_plugin_info get exception:" + e16);
                    return 0;
                }
            }
            this.call_plugin_info = optJSONArray;
        }
        JSONArray jSONArray = this.call_plugin_info;
        if (jSONArray == null) {
            Intrinsics.throwUninitializedPropertyAccessException("call_plugin_info");
            jSONArray = null;
        }
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONArray jSONArray2 = this.call_plugin_info;
            if (jSONArray2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("call_plugin_info");
                jSONArray2 = null;
            }
            JSONObject optJSONObject = jSONArray2.optJSONObject(i3);
            if (Intrinsics.areEqual(appId, optJSONObject.optString("plugin_id"))) {
                return optJSONObject.optInt("inner_version");
            }
        }
        return 0;
    }
}
