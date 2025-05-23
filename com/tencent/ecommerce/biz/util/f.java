package com.tencent.ecommerce.biz.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u001a&\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006*\u00020\u0000\u00a8\u0006\b"}, d2 = {"Lorg/json/JSONObject;", "", "", "a", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "b", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class f {
    public static final Map<Object, Object> a(JSONObject jSONObject) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object opt = jSONObject.opt(str);
            if (opt instanceof JSONObject) {
                linkedHashMap.put(str, a((JSONObject) opt));
            } else if (opt instanceof JSONArray) {
                linkedHashMap.put(str, opt.toString());
            } else if (opt != null) {
                linkedHashMap.put(str, opt);
            }
        }
        return linkedHashMap;
    }

    public static final HashMap<String, String> b(JSONObject jSONObject) {
        String obj;
        HashMap<String, String> hashMap = new HashMap<>();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object opt = jSONObject.opt(str);
            if (opt != null && (obj = opt.toString()) != null) {
                hashMap.put(str, obj);
            }
        }
        return hashMap;
    }
}
