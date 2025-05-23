package com.tencent.luggage.wxa.ic;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/luggage/wxa/ic/h0;", "Lcom/tencent/luggage/wxa/ka/r;", "Lcom/tencent/luggage/wxa/l3/c;", "Lcom/tencent/luggage/wxa/va/e;", "data", "a", "<init>", "()V", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class h0 implements com.tencent.luggage.wxa.ka.r {
    @Override // com.tencent.luggage.wxa.ka.r
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.va.e invoke(com.tencent.luggage.wxa.l3.c data) {
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.luggage.wxa.z4.f a16 = com.tencent.luggage.wxa.z4.f.f146283b.a();
        int c16 = data.c();
        com.tencent.luggage.wxa.j4.d b16 = data.b();
        com.tencent.luggage.wxa.d6.b bVar = new com.tencent.luggage.wxa.d6.b();
        bVar.f124086d = data.a();
        bVar.f124090h = data.e();
        Unit unit = Unit.INSTANCE;
        a16.a(c16, b16, new com.tencent.luggage.wxa.l3.j(bVar, data.b(), data.d(), null, null, null, false, false, 248, null));
        com.tencent.luggage.wxa.va.e VOID = com.tencent.luggage.wxa.va.e.f143316a;
        Intrinsics.checkNotNullExpressionValue(VOID, "VOID");
        return VOID;
    }
}
