package com.tencent.qqmini.sdk.launcher.core.utils;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class ApiUtil {
    private static final String TAG = "ApiUtil";

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface OnLocationFinish {
        void onLocationFinishCallback(JSONObject jSONObject);
    }

    public static JSONObject wrapCallbackCancel(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            if (jSONObject == null) {
                return new JSONObject();
            }
            return jSONObject;
        }
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception unused) {
            }
        }
        jSONObject.put("errMsg", str + ":cancel cancel");
        return jSONObject;
    }

    public static JSONObject wrapCallbackFail(String str, JSONObject jSONObject) {
        return wrapCallbackFail(str, jSONObject, null);
    }

    public static JSONObject wrapCallbackOk(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            if (jSONObject == null) {
                return new JSONObject();
            }
            return jSONObject;
        }
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception unused) {
            }
        }
        jSONObject.put("errMsg", str + ":ok");
        return jSONObject;
    }

    public static JSONObject wrapCallbackFail(String str, JSONObject jSONObject, String str2) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            return jSONObject == null ? new JSONObject() : jSONObject;
        }
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception unused) {
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append(":fail");
        if (TextUtils.isEmpty(str2)) {
            str3 = "";
        } else {
            str3 = " " + str2;
        }
        sb5.append(str3);
        jSONObject.put("errMsg", sb5.toString());
        return jSONObject;
    }
}
