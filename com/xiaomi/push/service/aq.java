package com.xiaomi.push.service;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class aq {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, Long> f389642a = new HashMap();

    private static void a() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Map<String, Long> map = f389642a;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            if (elapsedRealtime - entry.getValue().longValue() > 60000) {
                arrayList.add(entry.getKey());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            f389642a.remove((String) it.next());
        }
    }

    public static boolean b(byte[] bArr, String str) {
        boolean z16 = false;
        if (bArr != null && bArr.length > 0 && !TextUtils.isEmpty(str)) {
            String f16 = com.xiaomi.push.ag.f(bArr);
            if (!TextUtils.isEmpty(f16)) {
                Map<String, Long> map = f389642a;
                synchronized (map) {
                    if (map.get(f16 + str) != null) {
                        z16 = true;
                    } else {
                        map.put(f16 + str, Long.valueOf(SystemClock.elapsedRealtime()));
                    }
                    a();
                }
            }
        }
        return z16;
    }
}
