package com.tencent.gathererga.core.internal.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class g {
    static IPatchRedirector $redirector_;

    public static JSONObject a(Map<Integer, Integer> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            Iterator<Integer> it = map.keySet().iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                jSONObject.putOpt(String.valueOf(intValue), map.get(Integer.valueOf(intValue)));
            }
        } catch (Exception e16) {
            d.b(e16.getMessage());
        }
        return jSONObject;
    }

    public static JSONObject b(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : map.keySet()) {
                jSONObject.putOpt(str, map.get(str));
            }
        } catch (Exception e16) {
            d.b(e16.getMessage());
        }
        return jSONObject;
    }

    public static Map<Integer, Integer> c(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        try {
            if (!JSONObject.NULL.equals(jSONObject)) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    hashMap.put(Integer.valueOf(str), Integer.valueOf(jSONObject.optInt(str)));
                }
            }
        } catch (Exception e16) {
            d.b(e16.getMessage());
        }
        return hashMap;
    }

    public static Map<String, String> d(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        try {
            if (!JSONObject.NULL.equals(jSONObject)) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    hashMap.put(str, jSONObject.optString(str));
                }
            }
        } catch (Exception e16) {
            d.b(e16.getMessage());
        }
        return hashMap;
    }
}
