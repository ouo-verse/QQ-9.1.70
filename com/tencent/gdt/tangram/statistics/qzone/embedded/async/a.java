package com.tencent.gdt.tangram.statistics.qzone.embedded.async;

import com.tencent.gdt.tangram.statistics.qzone.embedded.AdReporter;
import yl0.d;

/* compiled from: P */
/* loaded from: classes31.dex */
public class a extends d {

    /* renamed from: a, reason: collision with root package name */
    private am0.a f108440a;

    /* renamed from: b, reason: collision with root package name */
    private am0.b f108441b;

    public a(am0.a aVar) {
        this.f108440a = aVar;
    }

    @Override // yl0.d
    protected void b() {
        AdReporter.b(this.f108441b);
    }

    @Override // yl0.d
    protected void c() {
        this.f108441b = b.a(this.f108440a);
    }

    @Override // yl0.d
    protected boolean e() {
        return this.f108440a.g();
    }

    @Override // yl0.d
    protected void a() {
    }
}
