package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.guild.api.IRecentGuildApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/RecentGuildApiImpl;", "Lcom/tencent/mobileqq/guild/api/IRecentGuildApi;", "()V", "addRecentVisitGuildsListSync", "", "guildId", "", "from", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class RecentGuildApiImpl implements IRecentGuildApi {
    @Override // com.tencent.mobileqq.guild.api.IRecentGuildApi
    public void addRecentVisitGuildsListSync(@NotNull String guildId, @NotNull String from) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(from, "from");
        vh1.k.INSTANCE.b(guildId, from);
    }
}
