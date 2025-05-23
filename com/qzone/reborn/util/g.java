package com.qzone.reborn.util;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes37.dex */
public class g {

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends TypeToken<HashMap<String, String>> {
        a() {
        }
    }

    public static Map<String, Object> a(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                hashMap.put(str2, jSONObject.get(str2));
            }
        } catch (JSONException e16) {
            QLog.e("QZoneJsonUtil", 1, "json2Map  e = " + e16);
        }
        return hashMap;
    }

    public static HashMap<String, String> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (HashMap) new Gson().fromJson(str, new a().getType());
        } catch (JsonSyntaxException e16) {
            QLog.e("QZoneJsonUtil", 1, "jsonToMap  e = " + e16 + " , json = " + str);
            return null;
        }
    }

    public static String c(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return null;
        }
        try {
            return new Gson().toJson(hashMap);
        } catch (Exception e16) {
            QLog.e("QZoneJsonUtil", 1, "mapToJson  e = " + e16);
            return null;
        }
    }
}
