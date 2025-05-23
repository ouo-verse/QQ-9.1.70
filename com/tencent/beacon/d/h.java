package com.tencent.beacon.d;

import android.content.Context;
import android.util.Base64;

/* compiled from: P */
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static volatile h f77856a;

    /* renamed from: d, reason: collision with root package name */
    private d f77859d;

    /* renamed from: j, reason: collision with root package name */
    private String f77865j;

    /* renamed from: b, reason: collision with root package name */
    private final String f77857b = "sid";

    /* renamed from: e, reason: collision with root package name */
    private String f77860e = "";

    /* renamed from: f, reason: collision with root package name */
    private boolean f77861f = true;

    /* renamed from: g, reason: collision with root package name */
    private int f77862g = 8081;

    /* renamed from: h, reason: collision with root package name */
    private String f77863h = "";

    /* renamed from: i, reason: collision with root package name */
    private String f77864i = "";

    /* renamed from: c, reason: collision with root package name */
    private final Context f77858c = com.tencent.beacon.a.c.c.c().b();

    h() {
        com.tencent.beacon.a.b.a.a().a(new f(this));
    }

    public static h c() {
        if (f77856a == null) {
            synchronized (h.class) {
                if (f77856a == null) {
                    f77856a = new h();
                }
            }
        }
        return f77856a;
    }

    public synchronized void b(String str) {
        this.f77860e = str;
    }

    public synchronized String d() {
        return this.f77860e;
    }

    public synchronized String e() {
        return this.f77863h;
    }

    public void a(d dVar) {
        this.f77859d = dVar;
    }

    public String b() {
        return this.f77865j;
    }

    public synchronized void a(Context context) {
        a(com.tencent.beacon.a.d.a.a().getString("ias_cookie", ""));
        a(context, com.tencent.beacon.base.util.b.b());
    }

    synchronized void a(Context context, String str) {
        this.f77864i = str;
        byte[] a16 = com.tencent.beacon.base.net.b.c.a(context, str);
        if (a16 != null) {
            this.f77863h = Base64.encodeToString(a16, 2);
        }
    }

    public void c(String str) {
        if (str == null || str.equals(this.f77865j)) {
            return;
        }
        this.f77865j = str;
        com.tencent.beacon.a.b.a.a().a(new g(this, str));
    }

    public synchronized String a() {
        return this.f77864i;
    }

    public void a(String str) {
        this.f77865j = str;
    }
}
