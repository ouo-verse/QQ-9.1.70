package com.tencent.opentelemetry.otlp.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.AttributeKey;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.context.internal.shaded.WeakConcurrentMap;
import com.tencent.opentelemetry.sdk.resources.Resource;
import java.util.function.BiConsumer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class JsonResourceAdapter {
    static IPatchRedirector $redirector_;
    private static final WeakConcurrentMap<Resource, JSONObject> RESOURCE_PROTO_CACHE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9409);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            RESOURCE_PROTO_CACHE = new WeakConcurrentMap.WithInlinedExpunction();
        }
    }

    JsonResourceAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toProtoResource$0(JSONArray jSONArray, AttributeKey attributeKey, Object obj) {
        try {
            jSONArray.mo162put(JsonCommonAdapter.toJsonAttribute(attributeKey, obj));
        } catch (JSONException unused) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.e("JsonResourceAdapter", "toProtoResource error");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject toProtoResource(Resource resource) throws JSONException {
        WeakConcurrentMap<Resource, JSONObject> weakConcurrentMap = RESOURCE_PROTO_CACHE;
        JSONObject jSONObject = (JSONObject) weakConcurrentMap.get(resource);
        if (jSONObject == null) {
            JSONObject jSONObject2 = new JSONObject();
            final JSONArray jSONArray = new JSONArray();
            resource.getAttributes().forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.otlp.common.m
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    JsonResourceAdapter.lambda$toProtoResource$0(JSONArray.this, (AttributeKey) obj, obj2);
                }
            });
            jSONObject2.put("attributes", jSONArray);
            weakConcurrentMap.put(resource, jSONObject2);
            return jSONObject2;
        }
        return jSONObject;
    }
}
