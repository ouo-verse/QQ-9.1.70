package com.tencent.luggage.wxa.ah;

import com.tencent.luggage.wxa.l0.g;
import com.tencent.luggage.wxa.mg.i;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements i {

    /* renamed from: b, reason: collision with root package name */
    public static final a f121405b = new a();

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f121406a;

    public a() {
        i h16;
        if (b.a()) {
            h16 = e.f121422f;
        } else {
            h16 = d.h();
            Intrinsics.checkNotNullExpressionValue(h16, "getInstance()");
        }
        this.f121406a = h16;
    }

    @Override // com.tencent.luggage.wxa.mg.i
    public long a(String str, long j3, long j16) {
        return this.f121406a.a(str, j3, j16);
    }

    @Override // com.tencent.luggage.wxa.mg.i
    public void d(String str) {
        this.f121406a.d(str);
    }

    @Override // com.tencent.luggage.wxa.mg.i
    public String j(String str) {
        return this.f121406a.j(str);
    }

    @Override // com.tencent.luggage.wxa.mg.i
    public g.a n() {
        return this.f121406a.n();
    }

    @Override // com.tencent.luggage.wxa.mg.i
    public g.a y() {
        return this.f121406a.y();
    }
}
