package com.tencent.gamecenter.wadl.sdk.common.d;

/* compiled from: P */
/* loaded from: classes6.dex */
public class g implements d, c {

    /* renamed from: d, reason: collision with root package name */
    private static g f107119d = new g();

    /* renamed from: a, reason: collision with root package name */
    private d f107120a;

    /* renamed from: b, reason: collision with root package name */
    private c f107121b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f107122c = false;

    g() {
    }

    public static g e() {
        return f107119d;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.d
    public synchronized void a() {
        if (this.f107122c) {
            return;
        }
        com.tencent.gamecenter.wadl.sdk.common.d.k.b.c d16 = com.tencent.gamecenter.wadl.sdk.common.d.k.b.c.d();
        this.f107120a = d16;
        if (d16 != null) {
            d16.a(this);
            this.f107120a.a();
        }
        this.f107122c = true;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.a
    public void b() {
        this.f107120a.b();
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.a
    public void c() {
        this.f107120a.c();
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.c
    public void d() {
        this.f107121b.d();
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.a
    public void a(int i3) {
        this.f107120a.a(i3);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.d
    public void a(c cVar) {
        this.f107121b = cVar;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.b
    public void a(String str, String str2) {
        this.f107121b.a(str, str2);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.b
    public void a(String str, byte[] bArr, String str2) {
        this.f107121b.a(str, bArr, str2);
    }
}
