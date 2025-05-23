package com.tencent.mobileqq.vasgift.business.dt;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import oh2.c;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasGift04586Report$rechargeGoldClick$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ VasGift04586Report this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasGift04586Report$rechargeGoldClick$1(VasGift04586Report vasGift04586Report) {
        super(0);
        this.this$0 = vasGift04586Report;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VasGift04586Report this$0, boolean z16, int i3, String str) {
        JSONObject jSONObject;
        String str2;
        int L0;
        String str3;
        String str4;
        long j3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        jSONObject = this$0.busiInfoJson;
        str2 = this$0.USER_AUTH_STATUS;
        L0 = this$0.L0(i3);
        jSONObject.put(str2, L0);
        str3 = this$0.SUB_MODULE_ID_RECHARGE;
        str4 = this$0.ITEM_ID_RECHARGE_GOLD;
        j3 = this$0.currentBalance;
        VasGift04586Report.I0(this$0, null, null, str3, str4, null, null, 102, (int) j3, 0, null, null, null, 3891, null);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        oh2.c e16;
        nh2.c H2 = this.this$0.getViewModel().H2();
        if (H2 == null || (e16 = H2.e()) == null) {
            return;
        }
        final VasGift04586Report vasGift04586Report = this.this$0;
        e16.m(null, false, new c.a() { // from class: com.tencent.mobileqq.vasgift.business.dt.c
            @Override // oh2.c.a
            public final void a(boolean z16, int i3, String str) {
                VasGift04586Report$rechargeGoldClick$1.b(VasGift04586Report.this, z16, i3, str);
            }
        });
    }
}
