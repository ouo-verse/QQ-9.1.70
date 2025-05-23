package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.internal.ni;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class ng<T extends ni> {

    /* renamed from: a, reason: collision with root package name */
    protected int f149451a;

    /* renamed from: b, reason: collision with root package name */
    protected long f149452b;

    /* renamed from: c, reason: collision with root package name */
    protected nh<T> f149453c;

    /* renamed from: d, reason: collision with root package name */
    public T f149454d;

    /* JADX INFO: Access modifiers changed from: protected */
    public ng(nh<T> nhVar, T t16) {
        this.f149453c = nhVar;
        this.f149454d = t16;
    }

    private T c() {
        return this.f149454d;
    }

    public final void a(T t16) {
        nh<T> nhVar = this.f149453c;
        if (nhVar == null || t16 == null) {
            return;
        }
        this.f149454d = t16;
        nhVar.a(this);
    }

    public final int b() {
        return this.f149451a;
    }

    public final long e_() {
        return this.f149452b;
    }

    public String getId() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f149451a);
        return sb5.toString();
    }

    public void remove() {
        nh<T> nhVar = this.f149453c;
        if (nhVar == null) {
            return;
        }
        nhVar.b(this);
    }

    public void a(long j3) {
        this.f149452b = j3;
    }
}
