package com.tencent.qqnt.contacts.ui;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public /* synthetic */ class BuddyGroupFragment$initViewModel$2 extends FunctionReferenceImpl implements Function1<com.tencent.qqnt.contacts.data.b, Unit> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BuddyGroupFragment$initViewModel$2(Object obj) {
        super(1, obj, BuddyGroupFragment.class, "handleUiState", "handleUiState(Lcom/tencent/qqnt/contacts/data/BuddyGroupUiState;)V", 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, obj);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.contacts.data.b bVar) {
        invoke2(bVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable com.tencent.qqnt.contacts.data.b bVar) {
        ((BuddyGroupFragment) this.receiver).uh(bVar);
    }
}
