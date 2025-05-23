package com.tencent.mobileqq.troop.teamup.member.fragment;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public /* synthetic */ class TroopTeamUpMemberListFragment$initView$5 extends FunctionReferenceImpl implements Function0<Unit> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TroopTeamUpMemberListFragment$initView$5(Object obj) {
        super(0, obj, TroopTeamUpMemberListFragment.class, "itemReloadDataClick", "itemReloadDataClick()V", 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, obj);
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((TroopTeamUpMemberListFragment) this.receiver).Ih();
    }
}
