package com.qq.e.comm.util;

import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class JSONUtilStub {
    public static JSONObject getJSONObject(JSONArray jSONArray, int i3) {
        if (isJSONArrayEmpty(jSONArray) || i3 > jSONArray.length() - 1) {
            return null;
        }
        try {
            return jSONArray.getJSONObject(i3);
        } catch (Throwable th5) {
            GDTLogger.w(th5.getMessage());
            return null;
        }
    }

    public static boolean isJSONArrayEmpty(JSONArray jSONArray) {
        if (jSONArray != null && !JSONObject.NULL.equals(jSONArray) && jSONArray.length() > 0) {
            return false;
        }
        return true;
    }

    public static JSONObject newJSONObject() {
        try {
            return new JSONObject();
        } catch (Throwable th5) {
            GDTLogger.w(th5.getMessage());
            return null;
        }
    }

    public static boolean notNull(JSONObject jSONObject) {
        if (jSONObject != null && !JSONObject.NULL.equals(jSONObject)) {
            return true;
        }
        return false;
    }

    public static int optInt(JSONObject jSONObject, String str) {
        if (notNull(jSONObject)) {
            try {
                return jSONObject.optInt(str);
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return 0;
    }

    public static JSONArray optJSONArray(JSONObject jSONObject, String str) {
        if (notNull(jSONObject)) {
            try {
                return jSONObject.optJSONArray(str);
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return null;
    }

    public static JSONObject optJSONObject(JSONObject jSONObject, String str) {
        if (notNull(jSONObject)) {
            try {
                return jSONObject.optJSONObject(str);
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return null;
    }

    public static String optString(JSONArray jSONArray, int i3) {
        if (!isJSONArrayEmpty(jSONArray)) {
            try {
                return jSONArray.optString(i3);
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return null;
    }

    public static JSONObject put(JSONObject jSONObject, String str, Object obj) {
        if (notNull(jSONObject) && str != null) {
            try {
                jSONObject.put(str, obj);
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return jSONObject;
    }

    public static String toString(JSONObject jSONObject) {
        if (notNull(jSONObject)) {
            try {
                return jSONObject.toString();
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return null;
    }

    public static JSONObject newJSONObject(String str) {
        if (str != null) {
            try {
                return new JSONObject(str);
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return null;
    }

    public static String optString(JSONObject jSONObject, String str, String str2) {
        if (!notNull(jSONObject)) {
            return str2;
        }
        try {
            return jSONObject.optString(str, str2);
        } catch (Throwable th5) {
            GDTLogger.w(th5.getMessage());
            return str2;
        }
    }

    public static JSONObject newJSONObject(Map map) {
        if (map != null) {
            try {
                return new JSONObject(map);
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return null;
    }
}
