package com.tencent.ecommerce.base.report.service;

import com.tencent.ecommerce.base.QQEcommerceSdk;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0003B'\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R#\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/base/report/service/n;", "", "Lorg/json/JSONObject;", "a", "", "Ljava/lang/String;", "eventCode", "", "b", "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "params", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "c", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String eventCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Map<Object, Object> params;

    public n(String str, Map<Object, ? extends Object> map) {
        this.eventCode = str;
        this.params = map;
    }

    public final JSONObject a() {
        String valueOf;
        String valueOf2;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("event_code", this.eventCode);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(this.params);
        a aVar = a.f100911a;
        if (this.params.get("bus_id") == null) {
            valueOf = "";
        } else {
            valueOf = String.valueOf(this.params.get("bus_id"));
        }
        linkedHashMap.putAll(aVar.a(valueOf));
        linkedHashMap.put("event_time", Long.valueOf(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getTicket().getServerTimeMillis()));
        JSONArray jSONArray = new JSONArray();
        for (Object obj : linkedHashMap.keySet()) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("key", obj.toString());
            if (linkedHashMap.get(obj) == null) {
                valueOf2 = "";
            } else {
                valueOf2 = String.valueOf(linkedHashMap.get(obj));
            }
            jSONObject2.put("value", valueOf2);
            jSONArray.mo162put(jSONObject2);
        }
        jSONObject.put("report_kv", jSONArray);
        if (QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getRuntime().isDebug()) {
            cg0.a.b("ECTerminalRealReportModel", "[encodeParams] eventCode=" + this.eventCode + " params=" + this.params + " report_kv=" + jSONObject);
        }
        return jSONObject;
    }
}
