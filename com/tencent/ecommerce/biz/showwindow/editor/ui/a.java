package com.tencent.ecommerce.biz.showwindow.editor.ui;

import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0000\u00a8\u0006\u0006"}, d2 = {"Lorg/json/JSONObject;", "a", "Lorg/json/JSONArray;", "b", "", "c", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a {
    public static final JSONObject a(JSONObject jSONObject) {
        return jSONObject.optJSONObject("product");
    }

    public static final JSONArray b(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("main_pics");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        JSONArray jSONArray = new JSONArray();
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            jSONArray.mo162put(optJSONArray.optJSONObject(i3).optString("url"));
        }
        return jSONArray;
    }

    public static final String c(JSONObject jSONObject) {
        String optString = jSONObject.optString("title");
        return optString != null ? optString : "";
    }
}
