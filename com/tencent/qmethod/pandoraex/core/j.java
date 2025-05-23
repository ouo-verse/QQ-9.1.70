package com.tencent.qmethod.pandoraex.core;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f344141a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentMap<String, i> f344142b = new ConcurrentHashMap();

    private static long a(String str) {
        return f344142b.get(str).b();
    }

    private static int b(com.tencent.qmethod.pandoraex.api.c cVar, vr3.b bVar, String str) {
        if (bVar.f443257p.size() == 0) {
            return 0;
        }
        ConcurrentMap<String, i> concurrentMap = f344142b;
        i iVar = concurrentMap.get(str);
        if (iVar == null) {
            iVar = new i();
            concurrentMap.put(str, iVar);
        }
        iVar.a(bVar.f443257p.get(0).f343961a, bVar.f443257p.get(0).f343962b);
        iVar.f(cVar.f343898c);
        iVar.e(cVar.f343897b);
        return iVar.c();
    }

    private static int c(com.tencent.qmethod.pandoraex.api.c cVar, String str) {
        ConcurrentMap<String, i> concurrentMap = f344142b;
        i iVar = concurrentMap.get(str);
        if (iVar == null) {
            iVar = new i();
            concurrentMap.put(str, iVar);
        }
        iVar.f(cVar.f343898c);
        iVar.e(cVar.f343897b);
        return iVar.c();
    }

    private static List<com.tencent.qmethod.pandoraex.api.t> d(String str) {
        return f344142b.get(str).d();
    }

    public static boolean e(com.tencent.qmethod.pandoraex.api.v vVar, vr3.b bVar) {
        if (vVar.f343992c == null) {
            return false;
        }
        synchronized (f344141a) {
            String b16 = com.tencent.qmethod.pandoraex.api.b.b(bVar.f443242a, bVar.f443243b);
            if (b(vVar.f343992c, bVar, b16) < vVar.f343992c.f343897b) {
                return false;
            }
            o.a("HighFreqUtils", "matchHighFreqRule module: " + bVar.f443242a + ", systemApi: " + bVar.f443243b);
            long a16 = a(b16);
            bVar.f443244c = "high_freq";
            com.tencent.qmethod.pandoraex.api.c cVar = vVar.f343992c;
            bVar.f443255n = new com.tencent.qmethod.pandoraex.api.c(cVar.f343898c, cVar.f343897b, a16);
            bVar.f443257p.clear();
            bVar.f443257p.addAll(d(b16));
            g(b16);
            return true;
        }
    }

    public static boolean f(com.tencent.qmethod.pandoraex.api.v vVar, vr3.b bVar) {
        boolean z16 = false;
        if (vVar.f343992c == null) {
            return false;
        }
        synchronized (f344141a) {
            int c16 = c(vVar.f343992c, com.tencent.qmethod.pandoraex.api.b.b(bVar.f443242a, bVar.f443243b));
            int i3 = vVar.f343992c.f343897b;
            if (i3 <= 5) {
                return true;
            }
            if (i3 <= 15) {
                if ((c16 + 1) * 3 > i3) {
                    z16 = true;
                }
                return z16;
            }
            if (i3 <= 60) {
                if ((c16 + 1) * 2 > i3) {
                    z16 = true;
                }
                return z16;
            }
            if (c16 + 1 > i3 - 30) {
                z16 = true;
            }
            return z16;
        }
    }

    private static void g(String str) {
        f344142b.remove(str);
    }
}
