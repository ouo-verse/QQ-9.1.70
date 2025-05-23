package com.tencent.ams.fusion.a;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class e {
    public static JSONObject a() {
        try {
            return new JSONObject();
        } catch (Throwable th5) {
            f.k(th5.getMessage());
            return null;
        }
    }

    public static JSONObject b(String str) {
        if (str != null) {
            try {
                return new JSONObject(str);
            } catch (Throwable th5) {
                f.k(th5.getMessage());
            }
        }
        return null;
    }

    public static JSONObject c(JSONObject jSONObject, String str, int i3) {
        if (d(jSONObject) && str != null) {
            try {
                jSONObject.put(str, i3);
            } catch (Throwable th5) {
                f.k(th5.getMessage());
            }
        }
        return jSONObject;
    }

    public static boolean d(JSONObject jSONObject) {
        if (jSONObject != null && !JSONObject.NULL.equals(jSONObject)) {
            return true;
        }
        return false;
    }

    public static int e(JSONObject jSONObject, String str, int i3) {
        if (d(jSONObject)) {
            try {
                return jSONObject.optInt(str, i3);
            } catch (Throwable th5) {
                f.k(th5.getMessage());
                return i3;
            }
        }
        return i3;
    }
}
