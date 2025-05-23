package com.qq.e.comm.plugin.base.ad.model;

/* compiled from: P */
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private String f39065a;

    /* renamed from: b, reason: collision with root package name */
    private com.qq.e.comm.plugin.base.ad.b f39066b;

    /* renamed from: c, reason: collision with root package name */
    private com.qq.e.comm.plugin.base.ad.definition.a f39067c;

    public l(String str, com.qq.e.comm.plugin.base.ad.b bVar, int i3) {
        this.f39065a = str;
        this.f39066b = bVar;
        this.f39067c = com.qq.e.comm.plugin.base.ad.a.a(bVar, i3);
    }

    public String a() {
        return this.f39065a;
    }

    public com.qq.e.comm.plugin.base.ad.b b() {
        return this.f39066b;
    }

    public int c() {
        com.qq.e.comm.plugin.base.ad.definition.a aVar = this.f39067c;
        if (aVar == null) {
            return -1;
        }
        return aVar.a();
    }

    public int d() {
        com.qq.e.comm.plugin.base.ad.definition.a aVar = this.f39067c;
        if (aVar == null) {
            return -1;
        }
        return aVar.b();
    }

    public l(String str, com.qq.e.comm.plugin.base.ad.b bVar, com.qq.e.comm.plugin.base.ad.definition.a aVar) {
        this.f39065a = str;
        this.f39066b = bVar;
        this.f39067c = aVar;
    }
}
