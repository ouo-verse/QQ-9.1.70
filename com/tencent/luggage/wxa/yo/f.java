package com.tencent.luggage.wxa.yo;

import android.os.Looper;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static Map f146053a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public static Map f146054b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public static boolean f146055c = false;

    /* renamed from: d, reason: collision with root package name */
    public static ThreadLocal f146056d = new ThreadLocal();

    static {
        b();
    }

    public static void a(String str, d dVar) {
        com.tencent.luggage.wxa.er.a.a("Scheduler type is null", (Object) str);
        Locale locale = Locale.ENGLISH;
        String upperCase = str.toUpperCase(locale);
        if (f146053a.containsKey(upperCase)) {
            new IllegalStateException("Fatal error! Duplicate scheduler type " + str.toUpperCase(locale));
        }
        f146053a.put(upperCase, dVar);
        if (dVar instanceof g) {
            synchronized (f.class) {
                f146054b.put(((g) dVar).b().getThread(), dVar);
            }
        }
    }

    public static void b(String str) {
        f146053a.remove(str.toUpperCase(Locale.ENGLISH));
    }

    public static synchronized void b() {
        synchronized (f.class) {
            if (f146055c) {
                return;
            }
            com.tencent.luggage.wxa.wo.a.c("Vending.SchedulerProvider", "SchedulerProvider provided.", new Object[0]);
            f146055c = true;
            a("Vending.UI", d.f146044a);
            a("Vending.LOGIC", d.f146045b);
            a("Vending.HEAVY_WORK", d.f146046c);
        }
    }

    public static d a(String str) {
        com.tencent.luggage.wxa.er.a.a("Scheduler type is null", (Object) str);
        Map map = f146053a;
        Locale locale = Locale.ENGLISH;
        d dVar = (d) map.get(str.toUpperCase(locale));
        com.tencent.luggage.wxa.er.a.a("Scheduler type not found: " + str.toUpperCase(locale), (Object) dVar);
        return dVar;
    }

    public static d a() {
        d dVar;
        d dVar2 = (d) f146056d.get();
        if (dVar2 != null && f146054b.size() == 0) {
            return dVar2;
        }
        synchronized (f.class) {
            dVar = (d) f146054b.remove(Thread.currentThread());
        }
        if (dVar2 != null && dVar == null) {
            return dVar2;
        }
        if (dVar != null) {
            f146056d.set(dVar);
            return dVar;
        }
        if (Looper.myLooper() != null) {
            dVar = new g(Looper.myLooper(), Looper.myLooper().toString());
        } else if (dVar == null) {
            com.tencent.luggage.wxa.wo.a.d("Vending.SchedulerProvider", "This is not a handler thread! %s", Thread.currentThread());
            return new c();
        }
        f146056d.set(dVar);
        return dVar;
    }
}
