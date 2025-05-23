package com.tencent.rmonitor.base.config.impl;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f365329a;

    /* renamed from: b, reason: collision with root package name */
    private final b f365330b;

    /* renamed from: c, reason: collision with root package name */
    private final c f365331c;

    public a(b bVar, c cVar, boolean z16) {
        this.f365329a = z16;
        b bVar2 = new b();
        this.f365330b = bVar2;
        bVar2.d(bVar);
        c cVar2 = new c();
        this.f365331c = cVar2;
        cVar2.c(cVar);
    }

    public b a() {
        return this.f365330b;
    }

    public c b() {
        return this.f365331c;
    }

    public boolean c(b bVar) {
        if (bVar == null) {
            return true;
        }
        return this.f365330b.b(bVar);
    }

    public boolean d() {
        return this.f365329a;
    }

    public a() {
        this.f365329a = true;
        this.f365330b = new b();
        this.f365331c = new c();
    }
}
