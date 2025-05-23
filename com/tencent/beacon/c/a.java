package com.tencent.beacon.c;

import com.tencent.beacon.module.ModuleName;
import com.tencent.beacon.module.StatModule;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, Long> f77792a = new HashMap();

    public static void a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        f77792a.put(str, Long.valueOf(currentTimeMillis));
        com.tencent.beacon.base.util.c.a("[page] onPageIn cost time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public static void b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, Long> map = f77792a;
        if (map == null) {
            com.tencent.beacon.base.util.c.e("[page] please call 'onPageIn' first!", new Object[0]);
            return;
        }
        Long l3 = map.get(str);
        if (l3 == null) {
            com.tencent.beacon.base.util.c.e("[page] please call 'onPageIn' first!", new Object[0]);
            return;
        }
        ((StatModule) com.tencent.beacon.a.c.c.c().a(ModuleName.STAT)).a(str, currentTimeMillis - l3.longValue(), currentTimeMillis);
        f77792a.remove(str);
        com.tencent.beacon.base.util.c.a("[page] onPageOut cost time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }
}
