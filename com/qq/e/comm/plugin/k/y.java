package com.qq.e.comm.plugin.k;

import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class y {
    public static boolean a(JSONObject jSONObject) {
        return (jSONObject == null || JSONObject.NULL.equals(jSONObject)) ? false : true;
    }

    public static boolean b(JSONObject jSONObject, String str, boolean z16) {
        if (!a(jSONObject)) {
            return z16;
        }
        try {
            return jSONObject.optBoolean(str, z16);
        } catch (Throwable th5) {
            GDTLogger.w(th5.getMessage());
            return z16;
        }
    }

    public static int c(JSONObject jSONObject, String str) {
        if (a(jSONObject)) {
            try {
                return jSONObject.optInt(str);
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return 0;
    }

    public static long d(JSONObject jSONObject, String str) {
        if (a(jSONObject)) {
            try {
                return jSONObject.optLong(str);
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return 0L;
    }

    public static String e(JSONObject jSONObject, String str) {
        if (a(jSONObject)) {
            try {
                return jSONObject.optString(str);
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return null;
    }

    public static JSONArray f(JSONObject jSONObject, String str) {
        if (a(jSONObject)) {
            try {
                return jSONObject.optJSONArray(str);
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return null;
    }

    public static JSONObject g(JSONObject jSONObject, String str) {
        if (a(jSONObject)) {
            try {
                return jSONObject.optJSONObject(str);
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return null;
    }

    public static boolean a(JSONArray jSONArray) {
        return jSONArray == null || JSONObject.NULL.equals(jSONArray) || jSONArray.length() <= 0;
    }

    public static JSONObject a() {
        try {
            return new JSONObject();
        } catch (Throwable th5) {
            GDTLogger.w(th5.getMessage());
            return null;
        }
    }

    public static double b(JSONObject jSONObject, String str) {
        if (a(jSONObject)) {
            try {
                return jSONObject.optDouble(str);
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return 0.0d;
    }

    public static String c(JSONArray jSONArray, int i3) {
        if (!a(jSONArray)) {
            try {
                return jSONArray.optString(i3);
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return null;
    }

    public static JSONObject a(Map map) {
        if (map != null) {
            try {
                return new JSONObject(map);
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return null;
    }

    public static JSONObject a(String str) {
        if (str != null) {
            try {
                return new JSONObject(str);
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return null;
    }

    public static int b(JSONObject jSONObject, String str, int i3) {
        if (!a(jSONObject)) {
            return i3;
        }
        try {
            return jSONObject.optInt(str, i3);
        } catch (Throwable th5) {
            GDTLogger.w(th5.getMessage());
            return i3;
        }
    }

    public static JSONObject a(JSONArray jSONArray, int i3) {
        if (a(jSONArray) || i3 > jSONArray.length() - 1) {
            return null;
        }
        try {
            return jSONArray.getJSONObject(i3);
        } catch (Throwable th5) {
            GDTLogger.w(th5.getMessage());
            return null;
        }
    }

    public static int b(JSONArray jSONArray, int i3) {
        if (!a(jSONArray)) {
            try {
                return jSONArray.optInt(i3);
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return 0;
    }

    public static JSONObject a(JSONObject jSONObject, String str, boolean z16) {
        if (a(jSONObject) && str != null) {
            try {
                jSONObject.put(str, z16);
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return jSONObject;
    }

    public static String b(JSONObject jSONObject) {
        if (a(jSONObject)) {
            try {
                return jSONObject.toString();
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return null;
    }

    public static JSONObject a(JSONObject jSONObject, String str, int i3) {
        if (a(jSONObject) && str != null) {
            try {
                jSONObject.put(str, i3);
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return jSONObject;
    }

    public static JSONObject a(JSONObject jSONObject, String str, long j3) {
        if (a(jSONObject) && str != null) {
            try {
                jSONObject.put(str, j3);
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return jSONObject;
    }

    public static JSONObject a(JSONObject jSONObject, String str, Object obj) {
        if (a(jSONObject) && str != null) {
            try {
                jSONObject.put(str, obj);
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return jSONObject;
    }

    public static boolean a(JSONObject jSONObject, String str) {
        if (a(jSONObject)) {
            try {
                return jSONObject.optBoolean(str);
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return false;
    }

    public static int a(JSONArray jSONArray, int i3, int i16) {
        if (a(jSONArray)) {
            return i16;
        }
        try {
            return jSONArray.optInt(i3, i16);
        } catch (Throwable th5) {
            GDTLogger.w(th5.getMessage());
            return i16;
        }
    }
}
