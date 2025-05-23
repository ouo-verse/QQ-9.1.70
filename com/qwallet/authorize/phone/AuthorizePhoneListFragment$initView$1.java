package com.qwallet.authorize.phone;

import com.qwallet.authorize.AuthorizePhoneData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public /* synthetic */ class AuthorizePhoneListFragment$initView$1 extends FunctionReferenceImpl implements Function1<AuthorizePhoneData, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AuthorizePhoneListFragment$initView$1(Object obj) {
        super(1, obj, AuthorizePhoneListFragment.class, "onDeletePhone", "onDeletePhone(Lcom/qwallet/authorize/AuthorizePhoneData;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AuthorizePhoneData authorizePhoneData) {
        invoke2(authorizePhoneData);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull AuthorizePhoneData p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((AuthorizePhoneListFragment) this.receiver).Ah(p06);
    }
}
