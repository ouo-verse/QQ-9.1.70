package com.tencent.ad.tangram.json;

import android.support.annotation.Nullable;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdJSONUtil {
    private static final String TAG = "AdJSONUtil";

    public static boolean isJSONObjectNull(@Nullable JSONObject jSONObject) {
        if (jSONObject != null && !JSONObject.NULL.equals(jSONObject)) {
            return false;
        }
        return true;
    }

    public static boolean isObjectNull(@Nullable Object obj) {
        if (obj != null && !JSONObject.NULL.equals(obj)) {
            return false;
        }
        return true;
    }

    public static JSONObject newJSONObject() {
        try {
            return new JSONObject();
        } catch (Throwable th5) {
            AdLog.e(TAG, "[newJSONObject]", th5);
            return null;
        }
    }

    public static boolean optBoolean(JSONObject jSONObject, String str, boolean z16) {
        if (!isJSONObjectNull(jSONObject)) {
            try {
                return jSONObject.optBoolean(str, z16);
            } catch (Throwable th5) {
                AdLog.e(TAG, "[optBoolean]", th5);
                return z16;
            }
        }
        return z16;
    }

    public static int optInt(JSONObject jSONObject, String str, int i3) {
        if (!isJSONObjectNull(jSONObject)) {
            try {
                return jSONObject.optInt(str);
            } catch (Throwable th5) {
                AdLog.e(TAG, "[optInt]", th5);
                return i3;
            }
        }
        return i3;
    }

    public static JSONArray optJSONArray(JSONObject jSONObject, String str) {
        if (!isJSONObjectNull(jSONObject)) {
            try {
                return jSONObject.optJSONArray(str);
            } catch (Throwable th5) {
                AdLog.e(TAG, "[optJSONArray]", th5);
            }
        }
        return null;
    }

    public static JSONObject optJSONObject(JSONObject jSONObject, String str) {
        if (!isJSONObjectNull(jSONObject)) {
            try {
                return jSONObject.optJSONObject(str);
            } catch (Throwable th5) {
                AdLog.e(TAG, "[optJSonObject]", th5);
            }
        }
        return null;
    }

    public static long optLong(JSONObject jSONObject, String str, long j3) {
        if (!isJSONObjectNull(jSONObject)) {
            try {
                return jSONObject.optLong(str);
            } catch (Throwable th5) {
                AdLog.e(TAG, "[optLong]", th5);
                return j3;
            }
        }
        return j3;
    }

    public static String optString(JSONObject jSONObject, String str, String str2) {
        if (!isJSONObjectNull(jSONObject)) {
            try {
                return jSONObject.optString(str, str2);
            } catch (Throwable th5) {
                AdLog.e(TAG, "[optString]", th5);
                return str2;
            }
        }
        return str2;
    }

    public static JSONObject put(JSONObject jSONObject, String str, Object obj) {
        if (!isJSONObjectNull(jSONObject) && str != null) {
            try {
                jSONObject.put(str, obj);
            } catch (Throwable th5) {
                AdLog.e(TAG, "[put] Object", th5);
            }
        }
        return jSONObject;
    }

    public static String toString(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                return jSONObject.toString();
            } catch (Throwable th5) {
                AdLog.e(TAG, "[toString]", th5);
            }
        }
        return null;
    }

    public static JSONObject newJSONObject(String str) {
        try {
            return new JSONObject(str);
        } catch (Throwable th5) {
            AdLog.e(TAG, "[newJSONObject]", th5);
            return null;
        }
    }
}
