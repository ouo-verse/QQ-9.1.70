package com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy;

import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildRoleMemberParamData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildMemberSearchSourceId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/memberlist/strategy/am;", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/memberlist/strategy/ah;", "", "r", "Ljy1/a;", "viewModel", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;", "param", "<init>", "(Ljy1/a;Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class am extends ah {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(@NotNull jy1.a viewModel, @NotNull GuildRoleMemberParamData param) {
        super(viewModel, param);
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(param, "param");
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.ah, com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.GuildBaseBindPermissionMemberStrategy
    public int r() {
        return GProGuildMemberSearchSourceId.GUILD_GLOBAL_SPEAK_LIST.ordinal();
    }
}
