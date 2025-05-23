package com.huawei.hms.push.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class JsonUtil {
    public static void a(JSONObject jSONObject, String str, Object obj, Bundle bundle) {
        if (obj == null) {
            HMSLog.w("JsonUtil", "transfer jsonObject to bundle failed, defaultValue is null.");
            return;
        }
        String[] strArr = null;
        String str2 = null;
        int[] iArr = null;
        long[] jArr = null;
        if (obj instanceof String) {
            String str3 = (String) obj;
            if (!TextUtils.isEmpty(str3)) {
                str2 = str3;
            }
            bundle.putString(str, getString(jSONObject, str, str2));
            return;
        }
        if (obj instanceof Integer) {
            bundle.putInt(str, getInt(jSONObject, str, ((Integer) obj).intValue()));
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr2 = (int[]) obj;
            if (iArr2.length != 0) {
                iArr = iArr2;
            }
            bundle.putIntArray(str, getIntArray(jSONObject, str, iArr));
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr2 = (long[]) obj;
            if (jArr2.length != 0) {
                jArr = jArr2;
            }
            bundle.putLongArray(str, getLongArray(jSONObject, str, jArr));
            return;
        }
        if (obj instanceof String[]) {
            String[] strArr2 = (String[]) obj;
            if (strArr2.length != 0) {
                strArr = strArr2;
            }
            bundle.putStringArray(str, getStringArray(jSONObject, str, strArr));
            return;
        }
        HMSLog.w("JsonUtil", "transfer jsonObject to bundle failed, invalid data type.");
    }

    public static int getInt(JSONObject jSONObject, String str, int i3) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str)) {
                    return jSONObject.getInt(str);
                }
                return i3;
            } catch (JSONException unused) {
                HMSLog.w("JsonUtil", "JSONException: get " + str + " error.");
                return i3;
            }
        }
        return i3;
    }

    public static int[] getIntArray(JSONObject jSONObject, String str, int[] iArr) {
        int[] iArr2 = null;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    iArr2 = new int[jSONArray.length()];
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        iArr2[i3] = ((Integer) jSONArray.get(i3)).intValue();
                    }
                }
            } catch (JSONException unused) {
                HMSLog.w("JsonUtil", "JSONException: get " + str + " error.");
            }
        }
        if (iArr2 != null) {
            return iArr2;
        }
        return iArr;
    }

    public static JSONArray getIntJsonArray(int[] iArr) {
        JSONArray jSONArray = new JSONArray();
        if (iArr != null && iArr.length != 0) {
            for (int i3 : iArr) {
                jSONArray.put(i3);
            }
        }
        return jSONArray;
    }

    public static long[] getLongArray(JSONObject jSONObject, String str, long[] jArr) {
        long[] jArr2 = null;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    jArr2 = new long[jSONArray.length()];
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        jArr2[i3] = jSONArray.getLong(i3);
                    }
                }
            } catch (JSONException unused) {
                HMSLog.w("JsonUtil", "JSONException: get " + str + " error.");
            }
        }
        if (jArr2 != null) {
            return jArr2;
        }
        return jArr;
    }

    public static JSONArray getLongJsonArray(long[] jArr) {
        JSONArray jSONArray = new JSONArray();
        if (jArr != null && jArr.length != 0) {
            for (long j3 : jArr) {
                jSONArray.put(j3);
            }
        }
        return jSONArray;
    }

    public static String getString(JSONObject jSONObject, String str, String str2) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str) && jSONObject.get(str) != null) {
                    return String.valueOf(jSONObject.get(str));
                }
                return str2;
            } catch (JSONException unused) {
                HMSLog.w("JsonUtil", "JSONException: get " + str + " error.");
                return str2;
            }
        }
        return str2;
    }

    public static String[] getStringArray(JSONObject jSONObject, String str, String[] strArr) {
        String[] strArr2 = null;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    strArr2 = new String[jSONArray.length()];
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        strArr2[i3] = (String) jSONArray.get(i3);
                    }
                }
            } catch (JSONException unused) {
                HMSLog.w("JsonUtil", "JSONException: get " + str + " error.");
            }
        }
        return strArr2;
    }

    public static JSONArray getStringJsonArray(String[] strArr) {
        JSONArray jSONArray = new JSONArray();
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                jSONArray.mo162put(str);
            }
        }
        return jSONArray;
    }

    public static void transferJsonObjectToBundle(JSONObject jSONObject, Bundle bundle, HashMap<String, Object> hashMap) {
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
            a(jSONObject, entry.getKey(), entry.getValue(), bundle);
        }
    }
}
