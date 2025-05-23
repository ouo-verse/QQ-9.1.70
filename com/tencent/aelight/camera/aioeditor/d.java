package com.tencent.aelight.camera.aioeditor;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d extends fr.e {

    /* renamed from: d, reason: collision with root package name */
    private boolean f67361d = false;

    /* renamed from: e, reason: collision with root package name */
    private int f67362e = 1;

    /* renamed from: f, reason: collision with root package name */
    private String[] f67363f = new String[2];

    /* renamed from: h, reason: collision with root package name */
    private String[] f67364h = new String[2];

    /* renamed from: i, reason: collision with root package name */
    private int f67365i = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f67366m = 2;

    public void f(int i3) {
        this.f67363f[i3] = null;
        this.f67364h[i3] = null;
    }

    public String[] g() {
        return this.f67364h;
    }

    public String[] h() {
        return this.f67363f;
    }

    public int i() {
        return this.f67362e;
    }

    public boolean k() {
        return this.f67366m == 14;
    }

    public void l(int i3) {
        this.f67366m = i3;
    }

    public void m(String str) {
        this.f67364h[this.f67365i] = str;
    }

    public void n(String str) {
        this.f67363f[this.f67365i] = str;
    }

    public void p(int i3) {
        this.f67362e = i3;
    }

    public boolean j(int i3) {
        return i3 == 1 || (i3 & this.f67362e) != 0;
    }

    public void o(int i3) {
        if (i3 <= -1 || i3 >= 2) {
            return;
        }
        this.f67365i = i3;
    }

    @Override // fr.e
    public void d() {
    }

    @Override // fr.e
    public void e() {
    }
}
