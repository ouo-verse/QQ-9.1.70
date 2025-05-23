package com.tencent.tbs.one.impl.a;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class f {
    public static <T> void a(JSONObject jSONObject, String str, T t16) {
        try {
            jSONObject.put(str, t16);
        } catch (JSONException unused) {
        }
    }

    public static JSONObject a(Map map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            for (Object obj : map.keySet()) {
                a(jSONObject, obj.toString(), map.get(obj));
            }
        }
        return jSONObject;
    }
}
