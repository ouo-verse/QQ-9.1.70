package com.tencent.mobileqq.guild.rolegroup.fragments;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import yx1.RoleSelectItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public /* synthetic */ class SelectRoleForUserFragment$initRecyclerView$1 extends FunctionReferenceImpl implements Function3<RoleSelectItem, Integer, Boolean, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SelectRoleForUserFragment$initRecyclerView$1(Object obj) {
        super(3, obj, SelectRoleForUserFragment.class, "onItemToggleSelected", "onItemToggleSelected(Lcom/tencent/mobileqq/guild/rolegroup/adapters/roleselectlist/RoleSelectItem;IZ)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(RoleSelectItem roleSelectItem, Integer num, Boolean bool) {
        invoke(roleSelectItem, num.intValue(), bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull RoleSelectItem p06, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((SelectRoleForUserFragment) this.receiver).Qh(p06, i3, z16);
    }
}
