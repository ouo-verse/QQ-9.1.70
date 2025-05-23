package com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data;

import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b\u00a2\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R2\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/j;", "", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/b;", "a", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/b;", "()Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/b;", "setGroup", "(Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/b;)V", VipFunCallConstants.KEY_GROUP, "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/f;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "setMemberList", "(Ljava/util/ArrayList;)V", "memberList", "<init>", "(Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/b;Ljava/util/ArrayList;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildRiskGroupData group;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<GuildRiskMemberData> memberList;

    public j(@NotNull GuildRiskGroupData group, @NotNull ArrayList<GuildRiskMemberData> memberList) {
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(memberList, "memberList");
        this.group = group;
        this.memberList = memberList;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final GuildRiskGroupData getGroup() {
        return this.group;
    }

    @NotNull
    public final ArrayList<GuildRiskMemberData> b() {
        return this.memberList;
    }
}
