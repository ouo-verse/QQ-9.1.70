package com.tencent.rmonitor.base.config.impl;

import com.tencent.rmonitor.base.config.data.k;
import com.tencent.rmonitor.base.config.data.l;
import com.tencent.rmonitor.common.logger.Logger;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes25.dex */
public class e implements h {
    private void b(l lVar, String str, JSONObject jSONObject) throws JSONException {
        k b16 = lVar.b(str);
        if (b16 != null) {
            b16.parsePluginConfig(jSONObject);
        }
    }

    private boolean c(JSONObject jSONObject, @NotNull l lVar) {
        try {
            if (jSONObject.has(k.SAMPLE_RATION_KEY)) {
                lVar.f365318a = (float) jSONObject.getDouble(k.SAMPLE_RATION_KEY);
            }
            if (jSONObject.has(k.ATTA_CONFIG_KEY)) {
                b(lVar, k.ATTA_CONFIG_KEY, jSONObject.getJSONObject(k.ATTA_CONFIG_KEY));
            }
            if (jSONObject.has("crash")) {
                b(lVar, "crash", jSONObject.getJSONObject("crash"));
            }
            if (jSONObject.has(k.FEATURES_KEY)) {
                JSONArray jSONArray = jSONObject.getJSONArray(k.FEATURES_KEY);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    k b16 = lVar.b(jSONObject2.optString("name"));
                    if (b16 != null) {
                        b16.parsePluginConfig(jSONObject2);
                    }
                }
            }
            return true;
        } catch (Throwable th5) {
            Logger.f365497g.b("RMonitor_config_ParserV7", "parseConfig", th5);
            return false;
        }
    }

    @Override // com.tencent.rmonitor.base.config.impl.h
    public boolean a(JSONObject jSONObject, @NotNull l lVar) {
        if (jSONObject == null) {
            return false;
        }
        return c(jSONObject, lVar);
    }
}
