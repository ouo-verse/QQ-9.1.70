package com.tencent.open.appstore.report;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    protected String f340943a;

    /* renamed from: b, reason: collision with root package name */
    protected String f340944b;

    /* renamed from: c, reason: collision with root package name */
    protected String f340945c;

    /* renamed from: d, reason: collision with root package name */
    protected String f340946d;

    /* renamed from: e, reason: collision with root package name */
    protected String f340947e;

    /* renamed from: f, reason: collision with root package name */
    protected String f340948f;

    /* renamed from: g, reason: collision with root package name */
    protected String f340949g;

    /* renamed from: h, reason: collision with root package name */
    protected int f340950h;

    /* renamed from: i, reason: collision with root package name */
    protected String f340951i;

    /* renamed from: j, reason: collision with root package name */
    protected String f340952j;

    /* renamed from: k, reason: collision with root package name */
    protected String f340953k;

    /* renamed from: l, reason: collision with root package name */
    protected String f340954l;

    /* renamed from: m, reason: collision with root package name */
    protected String f340955m;

    /* renamed from: n, reason: collision with root package name */
    protected String f340956n;

    private static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replace("|", "");
    }

    public static c f() {
        return new c();
    }

    public final String a() {
        return e(this.f340948f) + "|" + e(this.f340949g) + "|" + this.f340950h + "|" + e(this.f340951i) + "|" + e(this.f340952j) + "|" + e(this.f340953k) + "|" + e(this.f340954l) + "|" + e(this.f340955m) + "|" + e(this.f340956n);
    }

    public final String b() {
        return " | | | | | | | | ";
    }

    public final String c() {
        return e(this.f340943a) + "|" + e(this.f340944b) + "|" + e(this.f340945c) + "|" + e(this.f340946d) + "|" + com.tencent.open.adapter.a.f().l() + "|" + com.tencent.open.adapter.a.f().d() + "|" + System.currentTimeMillis() + "|" + e(this.f340947e);
    }

    public String d() {
        return "";
    }

    public final c g(String str) {
        this.f340952j = str;
        return this;
    }

    public final c h(String str) {
        this.f340951i = str;
        return this;
    }

    public final c i(String str) {
        this.f340948f = str;
        return this;
    }

    public final c j(String str) {
        this.f340954l = str;
        return this;
    }

    public final c k(String str) {
        this.f340947e = str;
        return this;
    }

    public final c l(String str) {
        this.f340944b = str;
        return this;
    }

    public final c m(String str) {
        this.f340949g = str;
        return this;
    }

    public final c n(String str) {
        this.f340943a = str;
        return this;
    }

    public final c o(String str) {
        this.f340945c = str;
        return this;
    }

    public final c p(String str) {
        this.f340956n = str;
        return this;
    }

    public final c q(String str) {
        this.f340953k = str;
        return this;
    }

    public final c r(String str) {
        this.f340955m = str;
        return this;
    }

    public final c s(int i3) {
        this.f340950h = i3;
        return this;
    }

    public final c t(String str) {
        this.f340946d = str;
        return this;
    }
}
