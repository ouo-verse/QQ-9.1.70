package com.vivo.push.b;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class b extends c {

    /* renamed from: a, reason: collision with root package name */
    private String f387559a;

    /* renamed from: b, reason: collision with root package name */
    private String f387560b;

    /* renamed from: c, reason: collision with root package name */
    private int f387561c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f387562d;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b(boolean z16, String str) {
        super(r1, str);
        int i3;
        if (z16) {
            i3 = 2006;
        } else {
            i3 = 2007;
        }
        this.f387561c = 1;
        this.f387562d = false;
    }

    public final void a(int i3) {
        this.f387561c = i3;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("sdk_clients", this.f387559a);
        dVar.a("sdk_version", 341L);
        dVar.a("PUSH_REGID", this.f387560b);
        if (b() == 2007) {
            dVar.a("PUSH_UNBIND_SOURCE_CODE", this.f387561c);
        }
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f387559a = dVar.a("sdk_clients");
        this.f387560b = dVar.a("PUSH_REGID");
        if (b() == 2007) {
            this.f387561c = dVar.b("PUSH_UNBIND_SOURCE_CODE", 1);
        }
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final String toString() {
        return "AppCommand:" + b();
    }
}
