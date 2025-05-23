package com.tencent.qqnt.contacts.ui;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public /* synthetic */ class BuddyFragment$initViewModel$1 extends FunctionReferenceImpl implements Function1<com.tencent.qqnt.contacts.data.d, Unit> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BuddyFragment$initViewModel$1(Object obj) {
        super(1, obj, BuddyFragment.class, "handleUiState", "handleUiState(Lcom/tencent/qqnt/contacts/data/BuddyUiState;)V", 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, obj);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.contacts.data.d dVar) {
        invoke2(dVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull com.tencent.qqnt.contacts.data.d p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((BuddyFragment) this.receiver).xh(p06);
    }
}
