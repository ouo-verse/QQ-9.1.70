package com.tencent.luggage.wxa.xa;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class i {
    public static JsonObject a(Map map) {
        JsonObject jsonObject = new JsonObject();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.keySet()) {
                a(jsonObject, (String) obj, map.get(obj));
            }
        }
        return jsonObject;
    }

    public static JsonObject a(c cVar) {
        JsonObject jsonObject = new JsonObject();
        if (cVar == null) {
            return jsonObject;
        }
        try {
            Iterator keys = cVar.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                a(jsonObject, str, cVar.get(str));
            }
        } catch (f unused) {
        }
        return jsonObject;
    }

    public static JsonArray a(a aVar) {
        JsonArray jsonArray = new JsonArray();
        if (aVar == null) {
            return jsonArray;
        }
        for (int i3 = 0; i3 < aVar.length(); i3++) {
            try {
                a(jsonArray, aVar.get(i3));
            } catch (f unused) {
            }
        }
        return jsonArray;
    }

    public static void a(JsonArray jsonArray, Object obj) {
        if (obj instanceof c) {
            jsonArray.add(a((c) obj));
            return;
        }
        if (obj instanceof a) {
            jsonArray.add(a((a) obj));
            return;
        }
        boolean z16 = obj instanceof Integer;
        if (z16) {
            jsonArray.add(((Integer) obj).intValue());
            return;
        }
        if (obj instanceof String) {
            jsonArray.add((String) obj);
            return;
        }
        if (obj instanceof Boolean) {
            jsonArray.add(((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof Long) {
            jsonArray.add(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Float) {
            jsonArray.add(((Float) obj).floatValue());
            return;
        }
        if (z16) {
            jsonArray.add(((Integer) obj).intValue());
        } else if (obj instanceof Double) {
            jsonArray.add(((Double) obj).doubleValue());
        } else if (obj instanceof JsonValue) {
            jsonArray.add((JsonValue) obj);
        }
    }

    public static void a(JsonArray jsonArray, int i3, Object obj) {
        if (obj instanceof c) {
            jsonArray.set(i3, a((c) obj));
            return;
        }
        if (obj instanceof a) {
            jsonArray.set(i3, a((a) obj));
            return;
        }
        boolean z16 = obj instanceof Integer;
        if (z16) {
            jsonArray.set(i3, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof String) {
            jsonArray.set(i3, (String) obj);
            return;
        }
        if (obj instanceof Boolean) {
            jsonArray.set(i3, ((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof Long) {
            jsonArray.set(i3, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Float) {
            jsonArray.set(i3, ((Float) obj).floatValue());
            return;
        }
        if (z16) {
            jsonArray.set(i3, ((Integer) obj).intValue());
        } else if (obj instanceof Double) {
            jsonArray.set(i3, ((Double) obj).doubleValue());
        } else if (obj instanceof JsonValue) {
            jsonArray.set(i3, (JsonValue) obj);
        }
    }

    public static void a(JsonObject jsonObject, String str, Object obj) {
        if (obj instanceof c) {
            jsonObject.set(str, a((c) obj));
            return;
        }
        if (obj instanceof a) {
            jsonObject.set(str, a((a) obj));
            return;
        }
        if (obj instanceof Integer) {
            jsonObject.set(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof String) {
            jsonObject.set(str, (String) obj);
            return;
        }
        if (obj instanceof Boolean) {
            jsonObject.set(str, ((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof Long) {
            jsonObject.set(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Float) {
            jsonObject.set(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            jsonObject.set(str, ((Double) obj).doubleValue());
        } else if (obj instanceof JsonValue) {
            jsonObject.set(str, (JsonValue) obj);
        }
    }
}
