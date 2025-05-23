package com.tenpay.bank.quick;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public /* synthetic */ class BindBankQuickVC$bankItemAdapter$1 extends FunctionReferenceImpl implements Function1<BankItemData, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BindBankQuickVC$bankItemAdapter$1(Object obj) {
        super(1, obj, BindBankQuickVC.class, "itemClickListener", "itemClickListener(Lcom/tenpay/bank/quick/BankItemData;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(BankItemData bankItemData) {
        invoke2(bankItemData);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull BankItemData p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((BindBankQuickVC) this.receiver).itemClickListener(p06);
    }
}
