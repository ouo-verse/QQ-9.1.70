package com.tencent.bugly.proguard;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class x extends com.tencent.rmonitor.base.config.data.k {

    /* renamed from: a, reason: collision with root package name */
    public String f98580a = null;

    /* renamed from: b, reason: collision with root package name */
    public String f98581b = null;

    private static String a(JSONArray jSONArray) {
        StringBuilder sb5 = new StringBuilder();
        if (jSONArray != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    sb5.append(jSONArray.get(i3).toString());
                    if (i3 != jSONArray.length() - 1) {
                        sb5.append("%");
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }
        return sb5.toString();
    }

    private static String b(JSONArray jSONArray) {
        StringBuilder sb5 = new StringBuilder();
        if (jSONArray != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    sb5.append(jSONObject.optString("path"));
                    JSONArray jSONArray2 = jSONObject.getJSONArray("feature");
                    for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
                        sb5.append(",");
                        sb5.append(jSONArray2.get(i16).toString());
                    }
                    if (i3 != jSONArray.length() - 1) {
                        sb5.append("%");
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }
        return sb5.toString();
    }

    @Override // com.tencent.rmonitor.base.config.data.k
    public final String getName() {
        return "emulator";
    }

    @Override // com.tencent.rmonitor.base.config.h
    public final void parsePluginConfig(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("emulator_model_feature")) {
            this.f98580a = a(jSONObject.getJSONArray("emulator_model_feature"));
        }
        if (jSONObject.has("emulator_files_feature")) {
            this.f98581b = b(jSONObject.getJSONArray("emulator_files_feature"));
        }
    }
}
