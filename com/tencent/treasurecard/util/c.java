package com.tencent.treasurecard.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static List<Map<String, Object>> a(String str) {
        Exception e16;
        ArrayList arrayList;
        try {
            JSONArray jSONArray = new JSONArray(str);
            arrayList = new ArrayList();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    arrayList.add(b(jSONArray.getJSONObject(i3).toString()));
                } catch (Exception e17) {
                    e16 = e17;
                    e16.printStackTrace();
                    return arrayList;
                }
            }
        } catch (Exception e18) {
            e16 = e18;
            arrayList = null;
        }
        return arrayList;
    }

    public static Map<String, Object> b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                hashMap.put(str2, jSONObject.get(str2));
            }
            return hashMap;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
