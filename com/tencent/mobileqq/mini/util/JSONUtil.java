package com.tencent.mobileqq.mini.util;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class JSONUtil {
    private static final String TAG = "JSONUtil";

    public static JSONObject append(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put(str, obj);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
        return jSONObject;
    }

    public static JSONArray concatArray(JSONArray jSONArray, JSONArray jSONArray2) throws JSONException {
        JSONArray jSONArray3 = new JSONArray();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            jSONArray3.mo162put(jSONArray.get(i3));
        }
        for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
            jSONArray3.mo162put(jSONArray2.get(i16));
        }
        return jSONArray3;
    }

    public static String escapeStr(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replace("\\t", "").replace(RedTouch.NEWLINE_CHAR, "").replace("\\\"", "");
    }

    public static JSONObject headerToJson(Map<String, List<String>> map) {
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            try {
                jSONObject.put(str, headerValueToString(map.get(str)));
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    private static String headerValueToString(List<String> list) {
        if (list != null && list.size() != 0) {
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < list.size(); i3++) {
                String str = list.get(i3);
                if (!TextUtils.isEmpty(str)) {
                    if (i3 > 0) {
                        sb5.append(";");
                    }
                    sb5.append(str);
                }
            }
            return sb5.toString();
        }
        return "";
    }

    public static boolean isJson(String str) {
        try {
            new JSONObject(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String json2Params(JSONObject jSONObject) {
        StringBuilder sb5 = new StringBuilder();
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                String string = jSONObject.getString(str);
                sb5.append(str);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(string);
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
            if (sb5.length() > 0) {
                sb5.deleteCharAt(sb5.length() - 1);
            }
            return sb5.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static int[] jsonArrayToIntArray(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = jSONArray.optInt(i3);
        }
        return iArr;
    }

    public static String[][] jsonArrayToMutiStringArray(JSONObject jSONObject, String str) {
        String[][] strArr = null;
        try {
            if (jSONObject.has(str)) {
                JSONArray jSONArray = jSONObject.getJSONArray(str);
                strArr = new String[jSONArray.length()];
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONArray jSONArray2 = jSONArray.getJSONArray(i3);
                    strArr[i3] = new String[jSONArray2.length()];
                    for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
                        strArr[i3][i16] = jSONArray2.getString(i16);
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "jsonArrayToMutiStringArray, exception: " + Log.getStackTraceString(e16));
        }
        return strArr;
    }

    public static String[] jsonArrayToStringArray(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i3 = 0; i3 < length; i3++) {
            strArr[i3] = jSONArray.optString(i3);
        }
        return strArr;
    }

    public static JSONObject listmapTojsonString(Map<String, List<String>> map) {
        return toJson(map);
    }

    public static JSONObject mapTojsonString(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            try {
                jSONObject.put(str, map.get(str));
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    public static JSONObject toJson(Map<String, List<String>> map) {
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            try {
                jSONObject.put(str, toJson(map.get(str)));
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    public static JSONArray toJson(List<Object> list) {
        JSONArray jSONArray = new JSONArray();
        for (Object obj : list) {
            if (obj instanceof Map) {
                jSONArray.mo162put(toJson((Map<String, List<String>>) obj));
            } else if (obj instanceof List) {
                jSONArray.mo162put(toJson((List<Object>) obj));
            } else {
                jSONArray.mo162put(obj);
            }
        }
        return jSONArray;
    }
}
