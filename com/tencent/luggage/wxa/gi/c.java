package com.tencent.luggage.wxa.gi;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final a f126764a = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Map f126765a = new ConcurrentHashMap();

        public final String a(String str, String str2, com.tencent.luggage.wxa.hi.b bVar) {
            return String.format("%s#%s#%s", str, str2, bVar.name());
        }

        public long b(String str, String str2, com.tencent.luggage.wxa.hi.b bVar) {
            Long l3;
            String a16 = a(str, str2, bVar);
            if (!this.f126765a.containsKey(a16) || (l3 = (Long) this.f126765a.get(a16)) == null) {
                return -1L;
            }
            long currentTimeMillis = System.currentTimeMillis() - l3.longValue();
            this.f126765a.remove(a16);
            return currentTimeMillis;
        }

        public void c(String str, String str2, com.tencent.luggage.wxa.hi.b bVar) {
            this.f126765a.put(a(str, str2, bVar), Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static void a(String str, String str2) {
        com.tencent.luggage.wxa.gi.a.a().a(str, str2);
    }

    public static void b(String str, String str2) {
        com.tencent.luggage.wxa.gi.a.a().b(str, str2);
    }

    public static void a(String str, com.tencent.luggage.wxa.hi.b bVar) {
        f126764a.c(bVar.d(), str, bVar);
        com.tencent.luggage.wxa.gi.a.a().a(bVar.d(), str, bVar);
    }

    public static void a(String str, com.tencent.luggage.wxa.hi.b bVar, String str2, String str3) {
        com.tencent.luggage.wxa.gi.a.a().a(bVar.d(), str, bVar, f126764a.b(bVar.d(), str, bVar));
    }

    public static void a(String str, com.tencent.luggage.wxa.hi.b bVar, String str2) {
        com.tencent.luggage.wxa.gi.a.a().b(bVar.d(), str, bVar, f126764a.b(bVar.d(), str, bVar));
    }

    public static void a(String str, com.tencent.luggage.wxa.hi.b bVar, String str2, long j3) {
        com.tencent.luggage.wxa.gi.a.a().b(bVar.d(), str, bVar, j3);
    }

    public static void a(String str, com.tencent.luggage.wxa.hi.c cVar) {
        com.tencent.luggage.wxa.gi.a.a().a(str, cVar);
    }
}
