package com.tencent.mobileqq.mini.util;

import android.text.TextUtils;
import android.util.Base64;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NativeBuffersUtil {
    public static byte[] getBytesFromNativeBuffers(JSONArray jSONArray) {
        JSONObject optJSONObject;
        if (jSONArray == null || jSONArray.length() <= 0 || (optJSONObject = jSONArray.optJSONObject(0)) == null) {
            return null;
        }
        String optString = optJSONObject.optString("base64");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return Base64.decode(optString, 0);
    }
}
