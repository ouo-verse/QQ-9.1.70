package com.tencent.mobileqq.guild.profile.profilecard.joined.detail;

import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0006\u0010\u0005\u001a\u00020\u0003\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/i;", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "c", "", "a", "b", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class j {
    @NotNull
    public static final String a() {
        return "profile_card";
    }

    @NotNull
    public static final String b() {
        return "channel_profile_card";
    }

    @NotNull
    public static final JumpGuildParam c(@NotNull GuildProfileJoinedData guildProfileJoinedData) {
        Intrinsics.checkNotNullParameter(guildProfileJoinedData, "<this>");
        JumpGuildParam jumpGuildParam = new JumpGuildParam(guildProfileJoinedData.getGuildId(), "", guildProfileJoinedData.getJoinGuildSig(), a(), b());
        jumpGuildParam.setReportSourceInfo(new GuildAppReportSourceInfo("channel_profile_card", ""));
        return jumpGuildParam;
    }
}
