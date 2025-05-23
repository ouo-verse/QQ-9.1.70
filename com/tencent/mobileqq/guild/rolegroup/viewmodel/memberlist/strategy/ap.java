package com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy;

import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildRoleMemberParamData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildMemberSearchSourceId;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/memberlist/strategy/ap;", "", "Ljy1/a;", "viewModel", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;", "param", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/memberlist/strategy/as;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ap {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ap f232962a = new ap();

    ap() {
    }

    @JvmStatic
    @NotNull
    public static final as a(@NotNull jy1.a viewModel, @NotNull GuildRoleMemberParamData param) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(param, "param");
        switch (param.getFetchType()) {
            case 0:
                return new as(viewModel, param);
            case 1:
                return new GuildSelectFromAllMemberStrategy(viewModel, param);
            case 2:
                return new al(viewModel, param);
            case 3:
                return new ab(viewModel, param);
            case 4:
                return new o(viewModel, param);
            case 5:
                return new j(viewModel, param, GProGuildMemberSearchSourceId.ADD_GUILD_ROLE_MEMBER.ordinal());
            case 6:
                return new j(viewModel, param, GProGuildMemberSearchSourceId.ADD_CHANNEL_ADMIN_MEMBER.ordinal());
            case 7:
                return new j(viewModel, param, GProGuildMemberSearchSourceId.ADD_CATEGORY_ADMIN_MEMBER.ordinal());
            case 8:
                return new ar(viewModel, param);
            case 9:
                return new aj(viewModel, param);
            case 10:
                return new d(viewModel, param);
            case 11:
                return new ah(viewModel, param);
            case 12:
                return new h(viewModel, param);
            case 13:
                return new af(viewModel, param);
            case 14:
                return new f(viewModel, param);
            case 15:
                return new ad(viewModel, param);
            case 16:
                return new b(viewModel, param);
            case 17:
                return new GuildAudioLiveChannelUserListStrategy(viewModel, param);
            case 18:
            default:
                throw new IllegalArgumentException("Invalid Fetch Type " + param);
            case 19:
                return new v(viewModel, param, true);
            case 20:
                return new v(viewModel, param, false);
            case 21:
                return new am(viewModel, param);
            case 22:
                return new k(viewModel, param);
        }
    }
}
