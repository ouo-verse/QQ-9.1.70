package com.tencent.luggage.wxa.ic;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002*\u0010\u0005\u001a&\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0012\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/tencent/luggage/wxa/ic/p;", "kotlin.jvm.PlatformType", "data", "Lcom/tencent/luggage/wxa/ka/i;", "Lcom/tencent/luggage/wxa/ic/q;", "callback", "", "a", "(Lcom/tencent/luggage/wxa/ic/p;Lcom/tencent/luggage/wxa/ka/i;)V"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes8.dex */
final class a0<InputType, ResultType> implements com.tencent.luggage.wxa.ka.f {

    /* renamed from: a, reason: collision with root package name */
    public static final a0 f129682a = new a0();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements com.tencent.luggage.wxa.kc.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ka.i f129683a;

        public a(com.tencent.luggage.wxa.ka.i iVar) {
            this.f129683a = iVar;
        }

        @Override // com.tencent.luggage.wxa.kc.a
        public void a(int i3, String str) {
            com.tencent.luggage.wxa.ka.i iVar = this.f129683a;
            if (iVar != null) {
                iVar.a(new q(i3, str));
            }
        }

        @Override // com.tencent.luggage.wxa.kc.a
        public void onSuccess() {
            com.tencent.luggage.wxa.ka.i iVar = this.f129683a;
            if (iVar != null) {
                iVar.a(new q(0, null, 2, null));
            }
        }
    }

    @Override // com.tencent.luggage.wxa.ka.f
    public final void a(p data, com.tencent.luggage.wxa.ka.i iVar) {
        if (data == null && iVar != null) {
            iVar.a(new q(-4, null, 2, null));
            Unit unit = Unit.INSTANCE;
        }
        Intrinsics.checkNotNullExpressionValue(data, "data");
        new i0(data, new a(iVar)).run();
    }
}
