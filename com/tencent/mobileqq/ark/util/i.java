package com.tencent.mobileqq.ark.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class i {
    public static List<Object> a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            Object obj = jSONArray.get(i3);
            if (obj instanceof JSONArray) {
                obj = a((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = b((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    public static Map<String, Object> b(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = jSONObject.get(str);
            if (obj instanceof JSONArray) {
                obj = a((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = b((JSONObject) obj);
            }
            hashMap.put(str, obj);
        }
        return hashMap;
    }
}
