package com.tencent.luggage.wxa.kq;

import android.os.Looper;
import com.tencent.luggage.wxa.kq.b;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f132700d = new ThreadLocal();

    /* renamed from: e, reason: collision with root package name */
    public static a f132701e = null;

    /* renamed from: f, reason: collision with root package name */
    public static final ConcurrentHashMap f132702f = new ConcurrentHashMap();

    /* renamed from: g, reason: collision with root package name */
    public static final AtomicLong f132703g = new AtomicLong(0);

    /* renamed from: a, reason: collision with root package name */
    public final String f132704a;

    /* renamed from: c, reason: collision with root package name */
    public int f132706c = 0;

    /* renamed from: b, reason: collision with root package name */
    public final d f132705b = new d(new b(new C6407a()));

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.kq.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6407a implements b.a {
        public C6407a() {
        }
    }

    public a(String str) {
        this.f132704a = str;
        f132702f.put(str, this);
    }

    public static a a(String str) {
        return new a(str + "@" + f132703g.getAndIncrement());
    }

    public static a b(Looper looper) {
        String a16 = a(looper);
        a aVar = (a) f132702f.get(a16);
        return aVar == null ? new a(a16) : aVar;
    }

    public static a d() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return a();
        }
        return (a) f132700d.get();
    }

    public static String e() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return a().c();
        }
        a aVar = (a) f132700d.get();
        if (aVar == null) {
            return null;
        }
        return aVar.c();
    }

    public String c() {
        return this.f132704a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).c().equals(c());
        }
        return false;
    }

    public void f() {
        b().f();
    }

    public int hashCode() {
        return this.f132704a.hashCode();
    }

    public String toString() {
        return "[" + this.f132704a + "]";
    }

    public static void a(a aVar) {
        f132700d.set(aVar);
    }

    public static synchronized a c(String str) {
        a aVar;
        synchronized (a.class) {
            aVar = (a) f132702f.get(str);
            if (aVar == null) {
                aVar = new a(str);
            }
        }
        return aVar;
    }

    public static String a(Looper looper) {
        if (looper == null) {
            return null;
        }
        Thread thread = looper.getThread();
        return thread.getName() + "@" + thread.getId();
    }

    public d b() {
        return this.f132705b;
    }

    public static a a() {
        if (f132701e == null) {
            f132701e = b(Looper.getMainLooper());
        }
        return f132701e;
    }

    public static a b(String str) {
        return (a) f132702f.get(str);
    }
}
