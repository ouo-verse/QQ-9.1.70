package com.tenpay.bank;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
/* synthetic */ class BindBankEntryFragment$onActivityResult$1 extends FunctionReferenceImpl implements Function4<Boolean, String, String, String, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BindBankEntryFragment$onActivityResult$1(Object obj) {
        super(4, obj, BindBankEntryFragment.class, "startQuickBankUrl", "startQuickBankUrl(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str, String str2, String str3) {
        invoke(bool.booleanValue(), str, str2, str3);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z16, @NotNull String p16, @NotNull String p26, @NotNull String p36) {
        Intrinsics.checkNotNullParameter(p16, "p1");
        Intrinsics.checkNotNullParameter(p26, "p2");
        Intrinsics.checkNotNullParameter(p36, "p3");
        ((BindBankEntryFragment) this.receiver).startQuickBankUrl(z16, p16, p26, p36);
    }
}
