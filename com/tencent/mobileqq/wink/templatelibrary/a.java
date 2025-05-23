package com.tencent.mobileqq.wink.templatelibrary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, Set<String>> f326419a = new HashMap();

    public static void a(String str, String str2) {
        Map<String, Set<String>> map = f326419a;
        if (!map.containsKey(str)) {
            map.put(str, new HashSet());
        }
        map.get(str).add(str2);
    }

    public static Map<String, Set<String>> b() {
        return f326419a;
    }
}
