package com.xiaomi.push;

import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class eq implements Cloneable {
    public static String C;

    /* renamed from: d, reason: collision with root package name */
    private String f388781d;

    /* renamed from: e, reason: collision with root package name */
    private String f388782e;

    /* renamed from: f, reason: collision with root package name */
    private int f388783f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f388784h = ep.f388761s;

    /* renamed from: i, reason: collision with root package name */
    private boolean f388785i = true;

    /* renamed from: m, reason: collision with root package name */
    private String f388786m;

    public eq(Map<String, Integer> map, int i3, String str, et etVar) {
        d(map, i3, str, etVar);
    }

    public static final String b() {
        String str = C;
        if (str != null) {
            return str;
        }
        if (io.c()) {
            return "sandbox.xmpush.xiaomi.com";
        }
        if (io.d()) {
            return "10.38.162.35";
        }
        return "app.chat.xiaomi.net";
    }

    public static final void c(String str) {
        if (io.d()) {
            return;
        }
        C = str;
    }

    private void d(Map<String, Integer> map, int i3, String str, et etVar) {
        this.f388783f = i3;
        this.f388781d = str;
    }

    public int a() {
        return this.f388783f;
    }

    public void e(boolean z16) {
        this.f388784h = z16;
    }

    public boolean f() {
        return this.f388784h;
    }

    public byte[] h() {
        throw null;
    }

    public String i() {
        return this.f388786m;
    }

    public void j(String str) {
        this.f388786m = str;
    }

    public String k() {
        if (this.f388782e == null) {
            this.f388782e = b();
        }
        return this.f388782e;
    }

    public void l(String str) {
        this.f388782e = str;
    }
}
