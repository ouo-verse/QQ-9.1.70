package com.tencent.luggage.wxa.r4;

import com.tencent.luggage.wxa.mc.k0;
import com.tencent.luggage.wxa.mc.q0;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name */
    public static final a f139211b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f139212a;

    public h(String moduleName) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        this.f139212a = moduleName;
    }

    public static final JSONObject a(com.tencent.luggage.wxa.xd.d dVar, String str, JSONObject jSONObject) {
        return f139211b.a(dVar, str, jSONObject);
    }

    public final void a(com.tencent.luggage.wxa.ic.l service) {
        Intrinsics.checkNotNullParameter(service, "service");
        try {
            JSONObject jSONObject = new JSONObject();
            com.tencent.luggage.wxa.ic.g runtime = service.getRuntime();
            if (runtime != null) {
                Intrinsics.checkNotNullExpressionValue(runtime, "runtime");
                if (k0.a(runtime, "common.app.js")) {
                    jSONObject.put("isLazyLoad", true);
                }
                if ((runtime instanceof com.tencent.luggage.wxa.c5.e) && ((com.tencent.luggage.wxa.c5.e) runtime).W1()) {
                    jSONObject.put("exportBaseMethods", true);
                }
            }
            jSONObject.put("moduleName", this.f139212a);
            f139211b.a(service, this.f139212a, jSONObject);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "try {\n            JSONOb\u2026         return\n        }");
            com.tencent.luggage.wxa.tn.w.d("Luggage.FULL.EventOnSubPackageReady", "dispatch appId(" + service.getAppId() + ") onSubPackageReady(" + jSONObject2 + ')');
            service.a("onSubPackageReady", jSONObject2);
        } catch (JSONException unused) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.FULL.EventOnSubPackageReady", "dispatch with service(" + service.getAppId() + "), create data failed");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final JSONObject a(com.tencent.luggage.wxa.xd.d service, String moduleName, JSONObject data) {
            com.tencent.mm.plugin.appbrand.appcache.a aVar;
            q0 q0Var;
            List b16;
            Intrinsics.checkNotNullParameter(service, "service");
            Intrinsics.checkNotNullParameter(moduleName, "moduleName");
            Intrinsics.checkNotNullParameter(data, "data");
            com.tencent.luggage.wxa.j4.g gVar = (com.tencent.luggage.wxa.j4.g) service.a(com.tencent.luggage.wxa.j4.g.class);
            if (gVar != null && (aVar = gVar.f125966l) != null && (q0Var = aVar.f151866f) != null && (b16 = q0Var.b(moduleName)) != null) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = b16.iterator();
                while (it.hasNext()) {
                    jSONArray.mo162put(h.f139211b.a((WxaPluginPkgInfo) it.next()));
                }
                data.put("separatedPlugins", jSONArray);
            }
            return data;
        }

        public final JSONObject a(WxaPluginPkgInfo wxaPluginPkgInfo) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("plugin_id", wxaPluginPkgInfo.provider);
            jSONObject.put("custom_version", wxaPluginPkgInfo.stringVersion);
            jSONObject.put("prefix_path", wxaPluginPkgInfo.prefixPath);
            jSONObject.put("inner_version", wxaPluginPkgInfo.version);
            return jSONObject;
        }
    }
}
