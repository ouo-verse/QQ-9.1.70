package com.tencent.biz.qqcircle.immersive.feed.event;

/* compiled from: P */
/* loaded from: classes4.dex */
public class an extends h {

    /* renamed from: a, reason: collision with root package name */
    private int f86150a;

    /* renamed from: b, reason: collision with root package name */
    private int f86151b;

    /* renamed from: c, reason: collision with root package name */
    private int f86152c;

    /* renamed from: d, reason: collision with root package name */
    private int f86153d;

    /* renamed from: e, reason: collision with root package name */
    private String f86154e;

    public String a() {
        return this.f86154e;
    }

    public float b() {
        int i3 = this.f86151b;
        if (i3 > 0) {
            return (this.f86150a * 100.0f) / i3;
        }
        return 0.0f;
    }

    public int c() {
        return this.f86151b;
    }

    public int d() {
        return this.f86152c;
    }

    public int e() {
        return this.f86150a;
    }

    public int f() {
        return this.f86153d;
    }

    public an g(String str) {
        this.f86154e = str;
        return this;
    }

    public an h(int i3) {
        this.f86151b = i3;
        return this;
    }

    public void i(int i3) {
        this.f86152c = i3;
    }

    public an j(int i3) {
        this.f86150a = i3;
        w20.a.j().p(i3);
        return this;
    }

    public an k(int i3) {
        this.f86153d = i3;
        return this;
    }
}
