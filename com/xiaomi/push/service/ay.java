package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.Cif;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ay implements d {

    /* renamed from: f, reason: collision with root package name */
    private static volatile ay f389680f;

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f389681a;

    /* renamed from: b, reason: collision with root package name */
    private long f389682b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f389683c = false;

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, a> f389684d = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    Context f389685e;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class a implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        String f389687d;

        /* renamed from: e, reason: collision with root package name */
        long f389688e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(String str, long j3) {
            this.f389687d = str;
            this.f389688e = j3;
        }

        abstract void a(ay ayVar);

        @Override // java.lang.Runnable
        public void run() {
            if (ay.f389680f != null) {
                Context context = ay.f389680f.f389685e;
                if (!com.xiaomi.push.au.w(context)) {
                    return;
                }
                if (System.currentTimeMillis() - ay.f389680f.f389681a.getLong(":ts-" + this.f389687d, 0L) > this.f389688e || com.xiaomi.push.e.b(context)) {
                    Cif.a(ay.f389680f.f389681a.edit().putLong(":ts-" + this.f389687d, System.currentTimeMillis()));
                    a(ay.f389680f);
                }
            }
        }
    }

    ay(Context context) {
        this.f389685e = context.getApplicationContext();
        this.f389681a = context.getSharedPreferences("sync", 0);
    }

    public static ay c(Context context) {
        if (f389680f == null) {
            synchronized (ay.class) {
                if (f389680f == null) {
                    f389680f = new ay(context);
                }
            }
        }
        return f389680f;
    }

    public String d(String str, String str2) {
        return this.f389681a.getString(str + ":" + str2, "");
    }

    public void f(a aVar) {
        if (this.f389684d.putIfAbsent(aVar.f389687d, aVar) == null) {
            com.xiaomi.push.ae.b(this.f389685e).h(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }

    public void g(String str, String str2, String str3) {
        Cif.a(f389680f.f389681a.edit().putString(str + ":" + str2, str3));
    }

    @Override // com.xiaomi.push.service.d
    public void a() {
        if (this.f389683c) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f389682b < 3600000) {
            return;
        }
        this.f389682b = currentTimeMillis;
        this.f389683c = true;
        com.xiaomi.push.ae.b(this.f389685e).h(new Runnable() { // from class: com.xiaomi.push.service.ay.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Iterator it = ay.this.f389684d.values().iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).run();
                    }
                } catch (Exception e16) {
                    jz4.c.m("Sync job exception :" + e16.getMessage());
                }
                ay.this.f389683c = false;
            }
        }, (int) (Math.random() * 10.0d));
    }
}
