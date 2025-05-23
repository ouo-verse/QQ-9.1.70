package com.qq.e.comm.plugin.k;

import android.text.TextUtils;
import com.qq.e.comm.util.GDTLogger;
import java.util.Collection;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class w {
    public static boolean a(JSONArray jSONArray) {
        return jSONArray == null || JSONObject.NULL.equals(jSONArray);
    }

    public static boolean b(JSONArray jSONArray) {
        return a(jSONArray) || d(jSONArray) <= 0;
    }

    public static JSONArray c(JSONArray jSONArray) {
        try {
            return new JSONArray(jSONArray.toString());
        } catch (Throwable th5) {
            GDTLogger.w(th5.getMessage());
            return null;
        }
    }

    public static int d(JSONArray jSONArray) {
        if (!a(jSONArray)) {
            try {
                return jSONArray.length();
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return 0;
    }

    public static String e(JSONArray jSONArray) {
        if (!a(jSONArray)) {
            try {
                return jSONArray.toString();
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return null;
    }

    public static String[] f(JSONArray jSONArray) {
        if (b(jSONArray)) {
            return null;
        }
        String[] strArr = new String[jSONArray.length()];
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            strArr[i3] = a(jSONArray, i3, "");
        }
        return strArr;
    }

    public static JSONArray a() {
        try {
            return new JSONArray();
        } catch (Throwable th5) {
            GDTLogger.w(th5.getMessage());
            return null;
        }
    }

    public static Object b(JSONArray jSONArray, int i3) {
        if (!a(jSONArray)) {
            try {
                return jSONArray.opt(i3);
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return null;
    }

    public static JSONObject c(JSONArray jSONArray, int i3) {
        if (!a(jSONArray)) {
            try {
                return jSONArray.optJSONObject(i3);
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return null;
    }

    public static JSONArray a(Collection collection) {
        try {
            return new JSONArray(collection);
        } catch (Throwable th5) {
            GDTLogger.w(th5.getMessage());
            return null;
        }
    }

    public static void b(JSONArray jSONArray, JSONArray jSONArray2) {
        if (a(jSONArray) || b(jSONArray2)) {
            return;
        }
        for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
            a(jSONArray, b(jSONArray2, i3));
        }
    }

    public static JSONArray a(JSONArray jSONArray, int i3) {
        if (!a(jSONArray)) {
            try {
                jSONArray.put(i3);
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return jSONArray;
    }

    public static JSONArray a(JSONArray jSONArray, Object obj) {
        if (!a(jSONArray)) {
            try {
                jSONArray.mo162put(obj);
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return jSONArray;
    }

    public static JSONArray a(JSONArray jSONArray, int i3, Object obj) {
        if (!a(jSONArray)) {
            try {
                jSONArray.put(i3, obj);
            } catch (Throwable th5) {
                GDTLogger.w(th5.getMessage());
            }
        }
        return jSONArray;
    }

    public static String a(JSONArray jSONArray, int i3, String str) {
        if (a(jSONArray)) {
            return str;
        }
        try {
            return jSONArray.optString(i3, str);
        } catch (Throwable th5) {
            GDTLogger.w(th5.getMessage());
            return str;
        }
    }

    public static JSONArray a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (b(jSONArray)) {
            jSONArray = a();
        }
        if (!b(jSONArray2)) {
            for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                a(jSONArray, a(jSONArray2, i3, ""));
            }
        }
        return jSONArray;
    }

    public static JSONArray a(String[] strArr, JSONArray jSONArray, HashSet<String> hashSet) {
        if (hashSet == null) {
            return null;
        }
        if (g.a(strArr)) {
            return jSONArray;
        }
        if (jSONArray == null) {
            jSONArray = a();
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str) && hashSet.contains(str)) {
                a(jSONArray, str);
            }
        }
        return jSONArray;
    }
}
