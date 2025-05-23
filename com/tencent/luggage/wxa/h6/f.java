package com.tencent.luggage.wxa.h6;

import android.os.PersistableBundle;
import android.text.TextUtils;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f {
    public static JSONArray a(List list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && !list.isEmpty()) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                jSONArray.mo162put(list.get(i3));
            }
        }
        return jSONArray;
    }

    public static void a(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if ((key instanceof String) && (value instanceof Map)) {
                Map map2 = (Map) value;
                a(map2);
                map.put(key, new JSONObject(map2));
            }
        }
    }

    public static Boolean a(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (!(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        if ("true".equalsIgnoreCase(str)) {
            return Boolean.TRUE;
        }
        if ("false".equalsIgnoreCase(str)) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static JSONObject a(PersistableBundle persistableBundle) {
        if (persistableBundle == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : persistableBundle.keySet()) {
            Object obj = persistableBundle.get(str);
            if (obj instanceof PersistableBundle) {
                jSONObject.put(str, a((PersistableBundle) obj));
            } else {
                jSONObject.put(str, obj);
            }
        }
        return jSONObject;
    }

    public static float a(JSONObject jSONObject, String str, float f16) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return f16;
        }
        double optDouble = jSONObject.optDouble(str, f16);
        if (Double.isNaN(optDouble)) {
            return Float.NaN;
        }
        return (float) optDouble;
    }
}
