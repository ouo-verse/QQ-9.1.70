package com.tencent.luggage.wxa.zg;

import com.tencent.luggage.wxa.l0.q;
import com.tencent.luggage.wxa.l0.u;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class b extends q.a {

    /* renamed from: b, reason: collision with root package name */
    public final String f146622b;

    /* renamed from: c, reason: collision with root package name */
    public final u f146623c;

    /* renamed from: d, reason: collision with root package name */
    public final int f146624d;

    /* renamed from: e, reason: collision with root package name */
    public final int f146625e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f146626f;

    public b(String str, u uVar, int i3, int i16, boolean z16) {
        this.f146622b = str;
        this.f146623c = uVar;
        this.f146624d = i3;
        this.f146625e = i16;
        this.f146626f = z16;
    }

    @Override // com.tencent.luggage.wxa.l0.q.a
    public q a(q.e eVar) {
        if (c.b()) {
            return new a(this.f146622b, null, this.f146623c, this.f146624d, this.f146625e, this.f146626f, eVar);
        }
        return new com.tencent.luggage.wxa.l0.n(this.f146622b, null, this.f146623c, this.f146624d, this.f146625e, this.f146626f, eVar);
    }
}
