package com.tencent.mobileqq.guild.message.utils.impl;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.message.utils.IGuildDirectMsgUtilApi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.visitor.GuildVisitorUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import su1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/message/utils/impl/GuildDirectMsgUtilApiImpl;", "Lcom/tencent/mobileqq/guild/message/utils/IGuildDirectMsgUtilApi;", "Lcom/tencent/mobileqq/activity/aio/p;", "sessionInfo", "", "isDirectMsg", "", "channelId", "hasDirectMsgFlag", "", "getGuildId", "getSourceGuildId", "guildId", "isGuest", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildDirectMsgUtilApiImpl implements IGuildDirectMsgUtilApi {
    @Override // com.tencent.mobileqq.guild.message.utils.IGuildDirectMsgUtilApi
    public long getGuildId(@NotNull String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        return b.a(channelId);
    }

    @Override // com.tencent.mobileqq.guild.message.utils.IGuildDirectMsgUtilApi
    public long getSourceGuildId(@NotNull String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        return b.b(channelId);
    }

    @Override // com.tencent.mobileqq.guild.message.utils.IGuildDirectMsgUtilApi
    public boolean hasDirectMsgFlag(@NotNull String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        return b.c(channelId);
    }

    @Override // com.tencent.mobileqq.guild.message.utils.IGuildDirectMsgUtilApi
    public boolean isDirectMsg(@NotNull p sessionInfo) {
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        return b.d(sessionInfo);
    }

    @Override // com.tencent.mobileqq.guild.message.utils.IGuildDirectMsgUtilApi
    public boolean isGuest(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        if (ch.j0(guildId)) {
            GuildVisitorUtils guildVisitorUtils = GuildVisitorUtils.f235701a;
            String qqStr = HardCodeUtil.qqStr(R.string.f147290wh);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_join_unlock_message_tips)");
            guildVisitorUtils.c(guildId, qqStr, 2);
            return true;
        }
        return false;
    }
}
