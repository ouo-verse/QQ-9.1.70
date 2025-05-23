package com.tencent.ecommerce.biz.hr.module;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.opentelemtry.api.IECSpan;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001e2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n*\u00020\u0002H\u0002JI\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u000b2+\u0010\u0014\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000f\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000ej\u0004\u0018\u0001`\u0013H\u0016R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/module/g;", "Li01/e;", "Lorg/json/JSONObject;", "params", "", "d", "g", "j", "a", "c", "", "", "i", "method", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "Lcom/tencent/ecommerce/base/opentelemtry/api/IECSpan;", "Lcom/tencent/ecommerce/base/opentelemtry/api/IECSpan;", "spanProxy", "e", "Ljava/lang/String;", "serviceName", "<init>", "()V", "f", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class g extends i01.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final IECSpan spanProxy;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String serviceName;

    public g() {
        QQEcommerceSdk qQEcommerceSdk = QQEcommerceSdk.INSTANCE;
        this.spanProxy = qQEcommerceSdk.getGlobalInternalSdk().getOpenTelemetry().getSpanManager();
        this.serviceName = qQEcommerceSdk.getGlobalInternalSdk().getOpenTelemetry().getSpanManager().getServiceName();
    }

    private final void a(JSONObject params) {
        this.spanProxy.addEvent(params.optString("spanName"), params.optString(AdMetricTag.EVENT_NAME), i(params.optJSONObject("spanAttributes")));
    }

    private final void c(JSONObject params) {
        this.spanProxy.endSpan(params.optString("spanName"), params.optInt("status"));
    }

    private final void d(JSONObject params) {
        this.spanProxy.startSpan(params.optString("spanName"), this.serviceName);
    }

    private final void g(JSONObject params) {
        String optString = params.optString("spanName");
        params.optString("parentSpanContext");
        this.spanProxy.startSpan(optString, this.serviceName);
    }

    private final Map<String, String> i(JSONObject jSONObject) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            linkedHashMap.put(str, jSONObject.optString(str));
        }
        return linkedHashMap;
    }

    private final void j(JSONObject params) {
        String optString = params.optString("spanName");
        JSONObject optJSONObject = params.optJSONObject("spanAttributes");
        if (optJSONObject != null) {
            this.spanProxy.updateAttribute(optString, i(optJSONObject));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // i01.e, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        if (params != null) {
            JSONObject jSONObject = new JSONObject(params);
            switch (method.hashCode()) {
                case -2129318196:
                    if (method.equals("startSpan")) {
                        d(jSONObject);
                        break;
                    }
                    cg0.a.a("ECHROpenTelemetryModule", "call", "can not support method(" + method + ')');
                    break;
                case -1607266619:
                    if (method.equals("endSpan")) {
                        c(jSONObject);
                        break;
                    }
                    cg0.a.a("ECHROpenTelemetryModule", "call", "can not support method(" + method + ')');
                    break;
                case -805415473:
                    if (method.equals("addSpanEvent")) {
                        a(jSONObject);
                        break;
                    }
                    cg0.a.a("ECHROpenTelemetryModule", "call", "can not support method(" + method + ')');
                    break;
                case -497821334:
                    if (method.equals("updateSpanAttributes")) {
                        j(jSONObject);
                        break;
                    }
                    cg0.a.a("ECHROpenTelemetryModule", "call", "can not support method(" + method + ')');
                    break;
                case 1463512169:
                    if (method.equals("startSpanWithParentSpanContext")) {
                        g(jSONObject);
                        break;
                    }
                    cg0.a.a("ECHROpenTelemetryModule", "call", "can not support method(" + method + ')');
                    break;
                default:
                    cg0.a.a("ECHROpenTelemetryModule", "call", "can not support method(" + method + ')');
                    break;
            }
        }
        return null;
    }
}
