package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.v1;

import android.text.TextUtils;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qqlive.module.videoreport.Log;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
class JsBridgeCall {
    public static final int STATE_CODE_INTERNAL_ERROR = 500;
    private static final int STATE_CODE_OK = 200;
    private static final String TAG = "jsbridge.JsBridgeCall";

    JsBridgeCall() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String call(Object obj, String str, String str2) {
        String str3;
        Log.d(TAG, "call(), jscall, jsonStr:" + str + " url:" + str2);
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("method");
                JSONArray jSONArray = jSONObject.getJSONArray("types");
                JSONArray jSONArray2 = jSONObject.getJSONArray("args");
                int length = jSONArray.length();
                Class<?>[] clsArr = new Class[length];
                Object[] objArr = new Object[length];
                for (int i3 = 0; i3 < length; i3++) {
                    parseArgsAndValue(jSONArray2, clsArr, objArr, jSONArray.optString(i3), i3);
                }
                return getResponse(200, obj.getClass().getMethod(string, clsArr).invoke(obj, objArr));
            } catch (Exception e16) {
                if (e16.getCause() != null) {
                    str3 = "method execute error:" + e16.getCause().getMessage();
                } else {
                    str3 = "method execute error:" + e16.getMessage();
                }
                return getResponse(500, str3);
            }
        }
        return getResponse(500, "call data empty");
    }

    public static String getResponse(int i3, Object obj) {
        HashMap hashMap = new HashMap();
        hashMap.put("code", Integer.valueOf(i3));
        hashMap.put("result", obj);
        return new JSONObject(hashMap).toString();
    }

    private static void parseArgsAndValue(JSONArray jSONArray, Class<?>[] clsArr, Object[] objArr, String str, int i3) throws JSONException {
        String str2 = null;
        if (HippyControllerProps.STRING.equals(str)) {
            clsArr[i3] = String.class;
            if (!jSONArray.isNull(i3)) {
                str2 = jSONArray.getString(i3);
            }
            objArr[i3] = str2;
            return;
        }
        if ("number".equals(str)) {
            clsArr[i3] = Integer.TYPE;
            objArr[i3] = Integer.valueOf(jSONArray.getInt(i3));
            return;
        }
        if (HippyControllerProps.BOOLEAN.equals(str)) {
            clsArr[i3] = Boolean.TYPE;
            objArr[i3] = Boolean.valueOf(jSONArray.getBoolean(i3));
        } else if ("object".equals(str)) {
            if (!jSONArray.isNull(i3)) {
                str2 = jSONArray.getString(i3);
            }
            objArr[i3] = str2;
            if (str2 != null) {
                objArr[i3] = new JSONObject((String) objArr[i3]);
            }
            clsArr[i3] = JSONObject.class;
        }
    }
}
