package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class JsonUtils {
    public static Map<String, Object> covertJsonObjectToMap(Object obj) {
        if (!(obj instanceof JSONObject)) {
            return null;
        }
        JSONObject jSONObject = (JSONObject) obj;
        HashMap hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object opt = jSONObject.opt(str);
            if (opt != null) {
                hashMap.put(str, opt);
            }
        }
        return hashMap;
    }

    public static int getDynamicRateSize(double[] dArr, Object obj) {
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            if (jSONArray.length() >= 2) {
                try {
                    double parseDouble = Double.parseDouble(jSONArray.get(0).toString());
                    String obj2 = jSONArray.get(1).toString();
                    if (!TextUtils.isEmpty(obj2) && parseDouble > 0.0d) {
                        if ("YES".equalsIgnoreCase(obj2)) {
                            dArr[0] = parseDouble;
                            return 1;
                        }
                        if ("NO".equalsIgnoreCase(obj2)) {
                            dArr[0] = parseDouble;
                            return 2;
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
        return 0;
    }

    public static Object getObjectFromJsonArray(Object obj, int i3) {
        if (!(obj instanceof JSONArray)) {
            return null;
        }
        JSONArray jSONArray = (JSONArray) obj;
        if (jSONArray.length() > i3) {
            try {
                return jSONArray.get(i3);
            } catch (Exception e16) {
                LogUtil.QLog.i(com.tencent.autotemplate.utils.JsonUtils.TAG, 2, "parse json error", e16);
            }
        }
        return null;
    }

    public static String getStringValue(Object obj, int i3) {
        Object obj2;
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            if (jSONArray.length() <= i3) {
                return null;
            }
            try {
                obj2 = jSONArray.get(i3);
            } catch (JSONException e16) {
                e16.printStackTrace();
                obj2 = null;
            }
            if (!(obj2 instanceof String)) {
                return null;
            }
            return (String) obj2;
        }
        if (!(obj instanceof String)) {
            return null;
        }
        return (String) obj;
    }
}
