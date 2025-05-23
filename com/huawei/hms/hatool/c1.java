package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c1 {
    public static Map<String, List<b1>> a(Context context, String str) {
        if (context == null) {
            return null;
        }
        Map<String, ?> a16 = d.a(context, str);
        b(a16);
        return a(a16);
    }

    public static Map<String, List<b1>> b(Context context, String str, String str2) {
        String a16 = d.a(context, str, str2, "");
        HashMap hashMap = new HashMap();
        a(str2, a16, hashMap);
        return hashMap;
    }

    public static Map<String, List<b1>> a(Context context, String str, String str2) {
        Map<String, List<b1>> a16;
        Map<String, List<b1>> a17;
        if ("alltype".equals(str2) || TextUtils.isEmpty(str)) {
            v.c("hmsSdk", "read all event records");
            a16 = a(context, "stat_v2_1");
            a17 = a(context, "cached_v2_1");
        } else {
            String a18 = n1.a(str, str2);
            a16 = b(context, "stat_v2_1", a18);
            a17 = b(context, "cached_v2_1", a18);
        }
        return a(a16, a17);
    }

    private static void b(Map<String, ?> map) {
        Iterator<Map.Entry<String, ?>> it = map.entrySet().iterator();
        Set<String> a16 = n1.a(q0.b());
        while (it.hasNext()) {
            if (!a16.contains(it.next().getKey())) {
                it.remove();
            }
        }
    }

    private static Map<String, List<b1>> a(Map<String, ?> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue() instanceof String) {
                a(key, (String) entry.getValue(), hashMap);
            }
        }
        return hashMap;
    }

    private static Map<String, List<b1>> a(Map<String, List<b1>> map, Map<String, List<b1>> map2) {
        if (map.size() == 0 && map2.size() == 0) {
            return new HashMap();
        }
        if (map.size() == 0) {
            return map2;
        }
        if (map2.size() == 0) {
            return map;
        }
        HashMap hashMap = new HashMap(map);
        hashMap.putAll(map2);
        return hashMap;
    }

    private static void a(String str, String str2, Map<String, List<b1>> map) {
        ArrayList arrayList = new ArrayList();
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str2);
            if (jSONArray.length() == 0) {
                return;
            }
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                b1 b1Var = new b1();
                try {
                    b1Var.a(jSONArray.getJSONObject(i3));
                    arrayList.add(b1Var);
                } catch (JSONException unused) {
                    v.e("hmsSdk", "JSON Exception happened when create data for report - readDataToRecord");
                }
            }
            map.put(str, arrayList);
        } catch (JSONException unused2) {
            v.e("hmsSdk", "When events turn to JSONArray,JSON Exception has happened");
        }
    }
}
