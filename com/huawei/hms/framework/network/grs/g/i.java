package com.huawei.hms.framework.network.grs.g;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class i {
    public static String a(String str, String str2) {
        if (!str.equals(str2)) {
            return b(str, str2);
        }
        return str;
    }

    private static String b(String str, String str2) {
        HashSet hashSet = new HashSet();
        if (!TextUtils.isEmpty(str)) {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("services");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                hashSet.add(jSONArray.getString(i3));
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            JSONArray jSONArray2 = new JSONObject(str2).getJSONArray("services");
            for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
                hashSet.add(jSONArray2.getString(i16));
            }
        }
        if (hashSet.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray3 = new JSONArray();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            jSONArray3.mo162put((String) it.next());
        }
        jSONObject.put("services", jSONArray3);
        return jSONObject.toString();
    }
}
