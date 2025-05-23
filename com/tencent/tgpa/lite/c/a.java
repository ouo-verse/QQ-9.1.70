package com.tencent.tgpa.lite.c;

import com.tencent.tgpa.lite.a.b;
import com.tencent.tgpa.lite.e.k;
import com.tencent.tgpa.lite.g.i;
import com.tencent.tgpa.lite.g.j;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    public static String a() {
        if (!b.a().f375868a.f375880g) {
            return "-13";
        }
        String a16 = j.a("OAID", null);
        return a16 == null ? k.c() : a16;
    }

    public static String b() {
        return "-1";
    }

    public static void a(HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            hashMap2.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
        }
        i.a(hashMap2);
    }
}
