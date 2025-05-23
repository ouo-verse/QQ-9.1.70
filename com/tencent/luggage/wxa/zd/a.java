package com.tencent.luggage.wxa.zd;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class a implements f, Runnable {

    /* renamed from: a, reason: collision with root package name */
    public long f146487a = 0;

    /* renamed from: b, reason: collision with root package name */
    public long f146488b = 0;

    public void b() {
        String name = getClass().getName();
        if (name.contains("$")) {
            name.substring(name.lastIndexOf("$") + 1);
            System.currentTimeMillis();
            System.currentTimeMillis();
            this.f146488b = 0L;
            this.f146487a = 0L;
        }
    }

    public void c() {
        this.f146487a = System.currentTimeMillis();
        b.a(this);
    }

    public void d() {
        this.f146487a = System.currentTimeMillis();
        a();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f146488b = System.currentTimeMillis();
        a();
    }
}
