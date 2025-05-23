package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.guild.api.IGuildNewUserMsgNoticeApi;
import com.tencent.mobileqq.guild.util.bw;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildNewUserMsgNoticeApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildNewUserMsgNoticeApi;", "()V", "setNewUserStayOrWriteInChannel", "", "guildId", "", "channelId", "type", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class GuildNewUserMsgNoticeApiImpl implements IGuildNewUserMsgNoticeApi {
    @Override // com.tencent.mobileqq.guild.api.IGuildNewUserMsgNoticeApi
    public void setNewUserStayOrWriteInChannel(@NotNull String guildId, @NotNull String channelId, int type) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        xr1.a.f448428a.a(guildId, channelId);
        bw.E1(guildId, channelId);
    }
}
