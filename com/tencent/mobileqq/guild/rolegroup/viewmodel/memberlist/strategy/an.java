package com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy;

import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildRoleMemberParamData;
import com.tencent.mobileqq.qqguildsdk.data.genc.cl;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\b\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u001c\u0010\t\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0007R\u0017\u0010\r\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/memberlist/strategy/an;", "", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;", "", "keyword", "", "sourceId", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/cl;", "c", "b", "I", "a", "()I", "FETCH_MEMBER_COUNT_TYPE_OTHER_TIME", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class an {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final an f232959a = new an();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int FETCH_MEMBER_COUNT_TYPE_OTHER_TIME = (int) com.tencent.mobileqq.qqguildsdk.util.f.f268548a;

    an() {
    }

    @JvmStatic
    @NotNull
    public static final cl b(@NotNull GuildRoleMemberParamData guildRoleMemberParamData, @NotNull String keyword, int i3) {
        Intrinsics.checkNotNullParameter(guildRoleMemberParamData, "<this>");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        cl clVar = new cl();
        clVar.p(i3);
        clVar.m(keyword);
        String guildId = guildRoleMemberParamData.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "this@toPermissionSearchParam.guildId");
        clVar.l(MiscKt.l(guildId));
        String subChannelId = guildRoleMemberParamData.getSubChannelId();
        Intrinsics.checkNotNullExpressionValue(subChannelId, "this@toPermissionSearchParam.subChannelId");
        clVar.j(MiscKt.l(subChannelId));
        clVar.k(FETCH_MEMBER_COUNT_TYPE_OTHER_TIME);
        return clVar;
    }

    @JvmStatic
    @NotNull
    public static final cl c(@NotNull GuildRoleMemberParamData guildRoleMemberParamData, @NotNull String keyword, int i3) {
        Intrinsics.checkNotNullParameter(guildRoleMemberParamData, "<this>");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        cl clVar = new cl();
        clVar.p(i3);
        clVar.m(keyword);
        String guildId = guildRoleMemberParamData.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "this@toSearchParam.guildId");
        clVar.l(MiscKt.l(guildId));
        String subChannelId = guildRoleMemberParamData.getSubChannelId();
        Intrinsics.checkNotNullExpressionValue(subChannelId, "this@toSearchParam.subChannelId");
        clVar.j(MiscKt.l(subChannelId));
        String categoryId = guildRoleMemberParamData.getCategoryId();
        Intrinsics.checkNotNullExpressionValue(categoryId, "this@toSearchParam.categoryId");
        clVar.i(MiscKt.l(categoryId));
        String roleGroupId = guildRoleMemberParamData.getRoleGroupId();
        Intrinsics.checkNotNullExpressionValue(roleGroupId, "this@toSearchParam.roleGroupId");
        clVar.o(MiscKt.l(roleGroupId));
        clVar.k(FETCH_MEMBER_COUNT_TYPE_OTHER_TIME);
        return clVar;
    }

    public final int a() {
        return FETCH_MEMBER_COUNT_TYPE_OTHER_TIME;
    }
}
