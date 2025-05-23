package com.vivo.push.b;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class n extends s {

    /* renamed from: a, reason: collision with root package name */
    private String f387584a;

    /* renamed from: b, reason: collision with root package name */
    private int f387585b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f387586c;

    public n() {
        super(7);
        this.f387585b = 0;
        this.f387586c = false;
    }

    public final void a(int i3) {
        this.f387585b = i3;
    }

    public final void b(String str) {
        this.f387584a = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("content", this.f387584a);
        dVar.a("log_level", this.f387585b);
        dVar.a("is_server_log", this.f387586c);
    }

    public final String d() {
        return this.f387584a;
    }

    public final int e() {
        return this.f387585b;
    }

    public final boolean f() {
        return this.f387586c;
    }

    public final void g() {
        this.f387586c = false;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnLogCommand";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f387584a = dVar.a("content");
        this.f387585b = dVar.b("log_level", 0);
        this.f387586c = dVar.e("is_server_log");
    }
}
