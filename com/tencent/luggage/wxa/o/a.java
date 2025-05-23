package com.tencent.luggage.wxa.o;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public int f135935a;

    public void a() {
        this.f135935a = 0;
    }

    public final boolean b() {
        return b(Integer.MIN_VALUE);
    }

    public final boolean c() {
        return b(4);
    }

    public final boolean d() {
        return b(1);
    }

    public final void a(int i3) {
        this.f135935a = i3 | this.f135935a;
    }

    public final boolean b(int i3) {
        return (this.f135935a & i3) == i3;
    }

    public final void c(int i3) {
        this.f135935a = i3;
    }
}
