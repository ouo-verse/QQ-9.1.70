package com.tencent.mobileqq.guild.feed.api.impl;

import com.tencent.mobileqq.guild.feed.api.IGuildInfoManagerApi;
import com.tencent.mobileqq.guild.feed.manager.GuildInfoManager;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/GuildInfoManagerApiImpl;", "Lcom/tencent/mobileqq/guild/feed/api/IGuildInfoManagerApi;", "()V", "handlerUpdateSpeakThresholdState", "", "guildId", "", "channelId", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildInfoManagerApiImpl implements IGuildInfoManagerApi {
    @Override // com.tencent.mobileqq.guild.feed.api.IGuildInfoManagerApi
    public void handlerUpdateSpeakThresholdState(@Nullable String guildId, @Nullable String channelId) {
        GuildInfoManager.q().I(guildId, channelId);
    }
}
