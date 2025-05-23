package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class q implements j {

    /* renamed from: f, reason: collision with root package name */
    private static volatile q f389475f;

    /* renamed from: a, reason: collision with root package name */
    private j f389476a;

    /* renamed from: b, reason: collision with root package name */
    private int f389477b = p.f389471a;

    /* renamed from: c, reason: collision with root package name */
    private Context f389478c;

    /* renamed from: d, reason: collision with root package name */
    private String f389479d;

    /* renamed from: e, reason: collision with root package name */
    private long f389480e;

    q(Context context) {
        this.f389478c = context.getApplicationContext();
        this.f389476a = p.a(context);
        jz4.c.m("create id manager is: " + this.f389477b);
    }

    public static q a(Context context) {
        if (f389475f == null) {
            synchronized (q.class) {
                if (f389475f == null) {
                    f389475f = new q(context.getApplicationContext());
                }
            }
        }
        return f389475f;
    }

    private String b(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public void d(Map<String, String> map) {
        if (map == null) {
            return;
        }
        String e16 = e();
        if (!TextUtils.isEmpty(e16)) {
            map.put("udid", e16);
        }
        String a16 = a();
        if (!TextUtils.isEmpty(a16)) {
            map.put("oaid", a16);
        }
        String f16 = f();
        if (!TextUtils.isEmpty(f16)) {
            map.put("vaid", f16);
        }
        String g16 = g();
        if (!TextUtils.isEmpty(g16)) {
            map.put("aaid", g16);
        }
        map.put("oaid_type", String.valueOf(this.f389477b));
    }

    public String e() {
        return null;
    }

    public String f() {
        return null;
    }

    public String g() {
        return null;
    }

    @Override // com.xiaomi.push.j
    /* renamed from: a */
    public boolean mo299a() {
        return this.f389476a.mo299a();
    }

    @Override // com.xiaomi.push.j
    public String a() {
        if (hz.j(this.f389478c)) {
            return b(this.f389476a.a());
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.f389480e) > 86400000) {
            this.f389480e = currentTimeMillis;
            String b16 = b(this.f389476a.a());
            this.f389479d = b16;
            return b16;
        }
        return b(this.f389479d);
    }

    public void c() {
    }
}
