package com.tencent.mobileqq.troop.teamup.member.fragment;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public /* synthetic */ class TroopTeamUpMemberListFragment$initView$4 extends FunctionReferenceImpl implements Function2<View, com.tencent.mobileqq.troop.teamup.member.data.c, Unit> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TroopTeamUpMemberListFragment$initView$4(Object obj) {
        super(2, obj, TroopTeamUpMemberListFragment.class, "itemSelectClick", "itemSelectClick(Landroid/view/View;Lcom/tencent/mobileqq/troop/teamup/member/data/TroopTeamUpMemberItemData;)V", 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, obj);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(View view, com.tencent.mobileqq.troop.teamup.member.data.c cVar) {
        invoke2(view, cVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull View p06, @NotNull com.tencent.mobileqq.troop.teamup.member.data.c p16) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        Intrinsics.checkNotNullParameter(p16, "p1");
        ((TroopTeamUpMemberListFragment) this.receiver).Jh(p06, p16);
    }
}
