package com.tencent.qqmini.v8rt.engine;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class JsValueUtil {
    public static final String TAG = "Utils";

    public static Object convertJsValueString(String str) {
        if (str.startsWith("\"") && str.endsWith("\"")) {
            return str.substring(1, str.length() - 1);
        }
        if (str.startsWith("{") && str.endsWith("}")) {
            return getMapObject(str);
        }
        if (str.startsWith("[") && str.endsWith("]")) {
            return getArrayObject(str);
        }
        if (!str.equals("true") && !str.equals("false")) {
            if (str.equals("null")) {
                return null;
            }
            if (str.matches("^-?\\d+")) {
                Logger.w("Utils", "javascript number not handled");
                return Long.valueOf(Long.parseLong(str));
            }
            Logger.w("Utils", "unknown return data types");
            return null;
        }
        return Boolean.valueOf(str.equals("true"));
    }

    private static Object convertJsonToMap(JSONObject jSONObject, Map<String, Object> map) {
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            if (!putObject(jSONObject, str, map) && !putArray(jSONObject, str, map) && !putNumber(jSONObject, str, map) && !putNull(jSONObject, str, map) && !putString(jSONObject, str, map) && !putBoolean(jSONObject, str, map)) {
                Logger.w("Utils", "unrecognized property " + str);
            }
        }
        return map;
    }

    private static Object getArrayObject(String str) {
        JSONArray jSONArray;
        try {
            jSONArray = new JSONArray(str);
        } catch (JSONException unused) {
            Log.e("Utils", "unexpected json array notation " + str);
            jSONArray = null;
        }
        if (jSONArray == null) {
            return null;
        }
        return putArray(jSONArray, new ArrayList());
    }

    private static Object getMapObject(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            Log.e("Utils", "unexpected json object notation " + str);
            jSONObject = null;
        }
        if (jSONObject == null || JSONObject.NULL.equals(jSONObject)) {
            return null;
        }
        return convertJsonToMap(jSONObject, new HashMap());
    }

    private static ArrayList putArray(JSONArray jSONArray, ArrayList arrayList) {
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                Object obj = jSONArray.get(i3);
                if (JSONObject.NULL.equals(obj)) {
                    arrayList.add(null);
                } else if (obj instanceof JSONObject) {
                    arrayList.add(convertJsonToMap((JSONObject) obj, new HashMap()));
                } else if (obj instanceof JSONArray) {
                    arrayList.add(putArray((JSONArray) obj, new ArrayList()));
                } else {
                    arrayList.add(obj);
                }
            } catch (JSONException unused) {
                Logger.e("Utils", "failed get value from json array " + jSONArray);
            }
        }
        return arrayList;
    }

    private static boolean putBoolean(JSONObject jSONObject, String str, Map map) {
        try {
            map.put(str, Boolean.valueOf(jSONObject.getBoolean(str)));
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    private static boolean putNull(JSONObject jSONObject, String str, Map map) {
        if (jSONObject.isNull(str)) {
            map.put(str, null);
            return true;
        }
        return false;
    }

    private static boolean putNumber(JSONObject jSONObject, String str, Map map) {
        try {
            try {
                try {
                    map.put(str, Double.valueOf(jSONObject.getDouble(str)));
                    return true;
                } catch (JSONException unused) {
                    map.put(str, Long.valueOf(jSONObject.getLong(str)));
                    return true;
                }
            } catch (JSONException unused2) {
                map.put(str, Integer.valueOf(jSONObject.getInt(str)));
                return true;
            }
        } catch (JSONException unused3) {
            return false;
        }
    }

    private static boolean putObject(JSONObject jSONObject, String str, Map map) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            HashMap hashMap = new HashMap();
            convertJsonToMap(jSONObject2, hashMap);
            map.put(str, hashMap);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    private static boolean putString(JSONObject jSONObject, String str, Map map) {
        try {
            map.put(str, jSONObject.getString(str));
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    private static boolean putArray(JSONObject jSONObject, String str, Map map) {
        try {
            map.put(str, putArray(jSONObject.getJSONArray(str), new ArrayList()));
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }
}
