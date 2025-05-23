package com.tencent.ams.xsad.rewarded.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static Map<String, String> a(JSONObject jSONObject) {
        String str;
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            Object opt = jSONObject.opt(str2);
            if (opt instanceof JSONObject) {
                str = ((JSONObject) opt).toString();
            } else if (opt != null) {
                str = opt + "";
            } else {
                str = null;
            }
            hashMap.put(str2, str);
        }
        return hashMap;
    }
}
