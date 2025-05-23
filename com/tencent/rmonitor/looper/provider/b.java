package com.tencent.rmonitor.looper.provider;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public float f365683a = 0.1f;

    /* renamed from: b, reason: collision with root package name */
    public long f365684b = 200;

    /* renamed from: c, reason: collision with root package name */
    public long f365685c = 3000;

    /* renamed from: d, reason: collision with root package name */
    public long f365686d = 52;

    /* renamed from: e, reason: collision with root package name */
    public boolean f365687e = true;

    /* renamed from: f, reason: collision with root package name */
    public String f365688f = "msg";

    public void a(b bVar) {
        if (bVar == null) {
            return;
        }
        this.f365683a = bVar.f365683a;
        this.f365684b = bVar.f365684b;
        this.f365685c = bVar.f365685c;
        this.f365686d = bVar.f365686d;
        this.f365687e = bVar.f365687e;
        this.f365688f = bVar.f365688f;
    }

    public void b() {
        this.f365683a = 0.1f;
        this.f365684b = 200L;
        this.f365685c = 3000L;
        this.f365686d = 52L;
        this.f365687e = true;
        this.f365688f = "msg";
    }

    public String toString() {
        return "[" + this.f365683a + "," + this.f365684b + "," + this.f365686d + "," + this.f365685c + "," + this.f365687e + "," + this.f365688f + "]";
    }
}
