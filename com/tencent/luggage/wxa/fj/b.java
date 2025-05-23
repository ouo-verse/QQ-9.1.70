package com.tencent.luggage.wxa.fj;

import com.tencent.luggage.wxa.h6.f;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.rc.c0;
import com.tencent.luggage.wxa.rc.o;
import com.tencent.luggage.wxa.rc.r;
import com.tencent.luggage.wxa.rc.y;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.c0;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static a f126194a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a(g gVar, JSONObject jSONObject);
    }

    public static int a() {
        return 0;
    }

    public static void b(g gVar, JSONObject jSONObject) {
        r P = gVar.P();
        if (P == null) {
            return;
        }
        if (P instanceof y) {
            JSONObject jSONObject2 = new JSONObject();
            LinkedList<r> b16 = ((y) P).b();
            for (int i3 = 0; i3 < b16.size(); i3++) {
                r rVar = (r) b16.get(i3);
                if (rVar instanceof c0) {
                    c0 c0Var = (c0) rVar;
                    String i16 = c0Var.i();
                    String e16 = c0Var.e();
                    long f16 = c0Var.f();
                    w.d("MicroMsg.PrepareDataForNodeHelper", "prepareFSData rootPath:%s pathPrefix:%s quota:%d", i16, e16, Long.valueOf(f16));
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("type", 1);
                        jSONObject3.put("rootPath", i16);
                        jSONObject3.put("quota", f16);
                        jSONObject2.put(e16, jSONObject3);
                    } catch (JSONException e17) {
                        w.b("MicroMsg.PrepareDataForNodeHelper", "prepareFSData e:%s", e17);
                    }
                }
            }
            for (r rVar2 : b16) {
                if (rVar2 instanceof o) {
                    o oVar = (o) rVar2;
                    String e18 = oVar.e();
                    String c16 = oVar.c();
                    try {
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("type", 0);
                        jSONObject4.put("rootPath", e18);
                        jSONObject2.put(c16, jSONObject4);
                    } catch (JSONException e19) {
                        w.b("MicroMsg.PrepareDataForNodeHelper", "prepareFSData e:%s", e19);
                    }
                }
            }
            try {
                jSONObject.put("fsData", jSONObject2);
                return;
            } catch (JSONException e26) {
                w.b("MicroMsg.PrepareDataForNodeHelper", "prepareFSData e:%s", e26);
                return;
            }
        }
        throw new IllegalStateException("getFileSystem not LuggageFileSystemRegistry");
    }

    public static void c(g gVar, JSONObject jSONObject) {
        c0.a aVar = (c0.a) gVar.a(c0.a.class);
        if (aVar == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("nativeBufferSizeLimitByte", aVar.f142666e);
            jSONObject2.put("itemBase64", aVar.f142665d);
            jSONObject2.put("itemID", aVar.f142664c);
            jSONObject2.put("itemKey", aVar.f142663b);
            jSONObject2.put("outKey", aVar.f142662a);
            jSONObject.put("nativeBufferConfig", jSONObject2);
        } catch (JSONException e16) {
            w.b("MicroMsg.PrepareDataForNodeHelper", "prepareNativeBufferConfigData e:%s", e16);
        }
    }

    public static void d(g gVar, JSONObject jSONObject) {
        com.tencent.luggage.wxa.yi.a aVar = (com.tencent.luggage.wxa.yi.a) gVar.a(com.tencent.luggage.wxa.yi.a.class);
        if (aVar == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("maxWebsocketConcurrent", aVar.f145798h);
            jSONObject2.put("socketDomains", f.a((List) aVar.f145802l));
            jSONObject2.put("websocketSkipPortCheck", aVar.J);
            jSONObject2.put("websocketTimeoutMS", aVar.f145794d);
            jSONObject2.put("headerFilterMode", aVar.N);
            jSONObject2.put("blacklistHeaders", f.a((List) aVar.F));
            jSONObject2.put("whitelistHeaders", f.a((List) aVar.G));
            jSONObject2.put(ISchemeApi.KEY_REFERER, aVar.M);
            jSONObject2.put("canSkipCheckDomainsByArg", aVar.f145791a);
            jSONObject2.put("shouldCheckDomains", aVar.f145792b);
            jSONObject2.put("userAgentString", aVar.K);
            jSONObject.put("networkConfig", jSONObject2);
        } catch (JSONException e16) {
            w.b("MicroMsg.PrepareDataForNodeHelper", "prepareNetworkConfigData e:%s", e16);
        }
    }

    public static void a(a aVar) {
        f126194a = aVar;
    }

    public static JSONObject a(g gVar) {
        JSONObject jSONObject = new JSONObject();
        a(gVar, jSONObject);
        d(gVar, jSONObject);
        c(gVar, jSONObject);
        b(gVar, jSONObject);
        a aVar = f126194a;
        if (aVar != null) {
            aVar.a(gVar, jSONObject);
        }
        w.g("MicroMsg.PrepareDataForNodeHelper", "prepareDataForNode :%s", jSONObject.toString());
        return jSONObject;
    }

    public static void a(g gVar, JSONObject jSONObject) {
        try {
            jSONObject.put("appId", gVar.getAppId());
            jSONObject.put("appversion", gVar.j0() == null ? 0 : gVar.j0().f125966l.pkgVersion);
            jSONObject.put("appstate", gVar.j0() == null ? 0 : gVar.j0().a() + 1);
        } catch (JSONException e16) {
            w.b("MicroMsg.PrepareDataForNodeHelper", "prepareCommonData e:%s", e16);
        }
    }
}
