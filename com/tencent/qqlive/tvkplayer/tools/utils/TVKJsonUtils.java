package com.tencent.qqlive.tvkplayer.tools.utils;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKJsonUtils {
    @NonNull
    public static HashMap<String, String> convertJsonObjectToHashMap(JSONObject jSONObject) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            hashMap.put(str, jSONObject.opt(str).toString());
        }
        return hashMap;
    }

    public static float optFloat(JSONObject jSONObject, String str, float f16) {
        if (jSONObject != null) {
            return (float) jSONObject.optDouble(str, f16);
        }
        return f16;
    }

    public static int optInt(JSONObject jSONObject, String str, int i3) {
        if (jSONObject != null) {
            return jSONObject.optInt(str, i3);
        }
        return i3;
    }

    public static long optLong(JSONObject jSONObject, String str, long j3) {
        if (jSONObject != null) {
            return jSONObject.optLong(str, j3);
        }
        return j3;
    }

    public static String optString(JSONObject jSONObject, String str, String str2) {
        if (jSONObject != null) {
            return jSONObject.optString(str, str2);
        }
        return str2;
    }
}
