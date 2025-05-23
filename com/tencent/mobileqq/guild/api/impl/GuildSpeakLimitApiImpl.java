package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.guild.api.IGuildSpeakLimitApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildSpeakLimitApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildSpeakLimitApi;", "()V", "getSpeakLimitStatus", "", "guildId", "", "channelId", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class GuildSpeakLimitApiImpl implements IGuildSpeakLimitApi {
    @Override // com.tencent.mobileqq.guild.api.IGuildSpeakLimitApi
    public int getSpeakLimitStatus(@NotNull String guildId, @Nullable String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        return p02.a.b(guildId, channelId);
    }
}
