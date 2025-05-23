package com.tencent.mobileqq.guild.rolegroup.fragments;

import com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public /* synthetic */ class GuildRoleListFragment$initUi$2 extends FunctionReferenceImpl implements Function2<r, Integer, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildRoleListFragment$initUi$2(Object obj) {
        super(2, obj, GuildRoleListFragment.class, "onItemStartDrag", "onItemStartDrag(Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/RoleGroupUiItem;I)Z", 0);
    }

    @NotNull
    public final Boolean invoke(@NotNull r p06, int i3) {
        boolean Uh;
        Intrinsics.checkNotNullParameter(p06, "p0");
        Uh = ((GuildRoleListFragment) this.receiver).Uh(p06, i3);
        return Boolean.valueOf(Uh);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(r rVar, Integer num) {
        return invoke(rVar, num.intValue());
    }
}
