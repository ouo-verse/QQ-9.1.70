package com.tencent.luggage.wxa.ui;

import com.tencent.luggage.wxa.nb.a;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f142409a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f142410b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f142411c;

    /* renamed from: d, reason: collision with root package name */
    public final a.c f142412d;

    /* renamed from: e, reason: collision with root package name */
    public final com.tencent.luggage.wxa.vi.a f142413e;

    public a(com.tencent.luggage.wxa.vi.a aVar) {
        this(aVar.a(), aVar);
    }

    public void a(boolean z16) {
        this.f142411c = z16;
    }

    public int b() {
        return this.f142409a;
    }

    public a.c c() {
        return this.f142412d;
    }

    public boolean d() {
        return this.f142411c;
    }

    public boolean e() {
        return this.f142410b;
    }

    public a(int i3, com.tencent.luggage.wxa.vi.a aVar) {
        this(i3, true, aVar);
    }

    public com.tencent.luggage.wxa.vi.a a() {
        return this.f142413e;
    }

    public a(int i3, boolean z16, com.tencent.luggage.wxa.vi.a aVar) {
        this.f142412d = new a.c();
        this.f142409a = i3;
        this.f142410b = z16;
        this.f142413e = aVar;
    }
}
