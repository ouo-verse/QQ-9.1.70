package com.tencent.qqlive.module.videoreport.utils;

import com.tencent.qqlive.module.videoreport.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class JsonUtils {
    private static final String TAG = "JsonUtils";

    public static String getJsonFromMap(Map<String, Object> map) {
        try {
            return new JSONObject(map).toString();
        } catch (Throwable th5) {
            Log.e("JsonUtils", "getJsonFromMap " + th5);
            return "";
        }
    }

    public static Map<String, Object> getMapForJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                hashMap.put(str2, jSONObject.get(str2));
            }
            return hashMap;
        } catch (Throwable th5) {
            Log.e("JsonUtils", "getMapForJson " + th5);
            return null;
        }
    }
}
