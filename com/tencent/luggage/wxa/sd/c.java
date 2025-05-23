package com.tencent.luggage.wxa.sd;

import com.tencent.luggage.wxa.af.e;
import com.tencent.luggage.wxa.ei.j;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.plugin.appbrand.extendplugin.AppBrandInvokeContext;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c extends com.tencent.luggage.wxa.xd.a {
    public boolean a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        return false;
    }

    public abstract String e();

    public int getViewId(JSONObject jSONObject) {
        if (jSONObject == null) {
            return -1;
        }
        return jSONObject.optInt("viewId", -1);
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        j jVar;
        v J;
        if (dVar == null) {
            w.f("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "component is null");
            return;
        }
        int viewId = getViewId(jSONObject);
        if (viewId == -1) {
            w.f("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "no viewId in data");
            dVar.a(i3, makeReturnJson("fail:no viewId in data", e.f121309e));
            return;
        }
        com.tencent.luggage.wxa.z7.d dVar2 = null;
        if (dVar instanceof v) {
            jVar = dVar.getJsRuntime();
        } else if ((dVar instanceof l) && (J = ((l) dVar).J()) != null) {
            jVar = J.getJsRuntime();
        } else {
            jVar = null;
        }
        if (a(dVar, jSONObject, i3)) {
            return;
        }
        if (jVar != null) {
            dVar2 = (com.tencent.luggage.wxa.z7.d) jVar.a(com.tencent.luggage.wxa.z7.d.class);
        }
        if (dVar2 == null) {
            w.f("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "invalid js runtime");
            dVar.a(i3, makeReturnJson("fail:invalid runtime", e.f121309e));
            return;
        }
        com.tencent.luggage.wxa.m8.c webViewPluginClientProxy = dVar2.getWebViewPluginClientProxy();
        if (webViewPluginClientProxy == null) {
            w.f("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "webview has no plugin client");
            dVar.a(i3, makeReturnJson("fail:webview has no plugin client", e.f121309e));
        } else {
            webViewPluginClientProxy.a(e(), viewId, new AppBrandInvokeContext(i3, jSONObject, dVar, this));
        }
    }
}
