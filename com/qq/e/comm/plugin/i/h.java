package com.qq.e.comm.plugin.i;

import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public int f39560a;

    /* renamed from: b, reason: collision with root package name */
    private String f39561b;

    /* renamed from: c, reason: collision with root package name */
    private File f39562c;

    /* renamed from: d, reason: collision with root package name */
    private String f39563d;

    /* renamed from: e, reason: collision with root package name */
    private String f39564e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f39565f;

    /* renamed from: g, reason: collision with root package name */
    private double f39566g;

    /* renamed from: h, reason: collision with root package name */
    private long f39567h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f39568i;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f39569a;

        /* renamed from: b, reason: collision with root package name */
        private File f39570b;

        /* renamed from: c, reason: collision with root package name */
        private String f39571c;

        /* renamed from: d, reason: collision with root package name */
        private String f39572d;

        /* renamed from: f, reason: collision with root package name */
        private double f39574f;

        /* renamed from: g, reason: collision with root package name */
        private long f39575g;

        /* renamed from: e, reason: collision with root package name */
        private boolean f39573e = true;

        /* renamed from: h, reason: collision with root package name */
        private boolean f39576h = true;

        public a a(File file) {
            this.f39570b = file;
            return this;
        }

        public a b(String str) {
            this.f39572d = str;
            return this;
        }

        public a c(String str) {
            this.f39569a = str;
            return this;
        }

        public a a(String str) {
            this.f39571c = str;
            return this;
        }

        public a a(boolean z16) {
            this.f39573e = z16;
            return this;
        }

        public h a() {
            return new h(this.f39570b, this.f39571c, this.f39569a, this.f39573e, this.f39574f, this.f39575g, this.f39576h, this.f39572d);
        }
    }

    public File a() {
        return this.f39562c;
    }

    public String b() {
        return this.f39563d;
    }

    public String c() {
        return this.f39561b;
    }

    public boolean d() {
        return this.f39565f;
    }

    public double e() {
        return this.f39566g;
    }

    public long f() {
        return this.f39567h;
    }

    public boolean g() {
        return this.f39568i;
    }

    public String h() {
        return this.f39564e;
    }

    h() {
    }

    h(File file, String str, String str2, boolean z16, double d16, long j3, boolean z17, String str3) {
        this.f39562c = file;
        this.f39563d = str;
        this.f39561b = str2;
        this.f39565f = z16;
        this.f39566g = d16;
        this.f39567h = j3;
        this.f39568i = z17;
        this.f39564e = str3;
    }
}
