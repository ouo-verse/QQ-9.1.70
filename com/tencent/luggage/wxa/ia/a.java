package com.tencent.luggage.wxa.ia;

import android.util.Log;
import android.util.Pair;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Map f129674a = new ConcurrentHashMap();

    public static void a(Map map, b bVar) {
        if (map != null && !map.isEmpty() && bVar != null) {
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                List<Pair> list = (List) entry.getValue();
                if (list != null) {
                    for (Pair pair : list) {
                        String str2 = str + "__HOOK__|" + ((String) pair.first) + "|" + ((String) pair.second);
                        c cVar = new c();
                        cVar.f129677c = bVar;
                        f129674a.put(str2, cVar);
                    }
                }
            }
            return;
        }
        throw new NullPointerException("HABBYGE-MALI.hellhound, registerHookCallback, exception:register arguments mayby is null !");
    }

    public static Object a(String str, String str2, String str3, String str4, String str5, String str6, Object obj, Object[] objArr) {
        b bVar;
        String str7 = str4 + "__HOOK__|" + str5 + "|" + str6;
        c cVar = (c) f129674a.get(str7);
        if (cVar != null && (bVar = cVar.f129677c) != null) {
            return bVar.a(str, str2, str3, str5, str6, obj, objArr);
        }
        Log.e("HABBYGE-MALI", "callMethodOnHook, gMethodMap is null, key=" + str7);
        return null;
    }

    public static Object a(Object obj, String str, String str2, String str3, String str4, String str5, String str6) {
        return com.tencent.luggage.wxa.fa.a.a().a(str, str2, str3, str4, str5, str6, obj, null);
    }

    public static Object a(Object obj, Object[] objArr, String str, String str2, String str3, String str4, String str5, String str6) {
        return com.tencent.luggage.wxa.fa.a.a().a(str, str2, str3, str4, str5, str6, obj, objArr);
    }
}
