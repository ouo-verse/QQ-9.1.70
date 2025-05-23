package com.tencent.tdf.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TDFMapUtils {
    static IPatchRedirector $redirector_;

    public TDFMapUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Map<String, Object> fromJsonObject(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                Object opt = jSONObject.opt(obj);
                if (jSONObject.isNull(obj)) {
                    hashMap.put(obj, null);
                } else if (opt instanceof JSONObject) {
                    hashMap.put(obj, fromJsonObject((JSONObject) opt));
                } else if (opt instanceof JSONArray) {
                    hashMap.put(obj, TDFListUtils.fromJsonArray((JSONArray) opt));
                } else {
                    hashMap.put(obj, opt);
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return hashMap;
    }

    public static Map<String, Object> fromJsonStr(String str) {
        HashMap hashMap = new HashMap();
        if (str != null) {
            try {
                return fromJsonObject(new JSONObject(str));
            } catch (JSONException e16) {
                e16.printStackTrace();
                return hashMap;
            }
        }
        return hashMap;
    }

    public static List<Object> getArray(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        if (obj instanceof List) {
            return (List) obj;
        }
        return null;
    }

    public static boolean getBoolean(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        if (obj != null && ((Boolean) obj).booleanValue()) {
            return true;
        }
        return false;
    }

    public static double getDouble(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        return 0.0d;
    }

    public static float getFloat(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        if (obj instanceof Number) {
            return ((Number) obj).floatValue();
        }
        return 0.0f;
    }

    public static int getInt(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        return 0;
    }

    public static long getLong(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        return 0L;
    }

    public static Map<String, Object> getMap(Map<String, Object> map, String str) {
        try {
            Object obj = map.get(str);
            if (obj instanceof Map) {
                return (Map) obj;
            }
            return null;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static String getString(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        if (obj == null) {
            return null;
        }
        return String.valueOf(obj);
    }

    public static JSONObject toJSONObject(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        if (map.size() == 0) {
            return jSONObject;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            try {
                String key = entry.getKey();
                if (entry.getValue() instanceof Map) {
                    jSONObject.put(key, toJSONObject((Map) entry.getValue()));
                } else if (entry.getValue() instanceof List) {
                    jSONObject.put(key, TDFListUtils.toJSONArray((List) entry.getValue()));
                } else {
                    jSONObject.put(key, entry.getValue());
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return jSONObject;
    }
}
