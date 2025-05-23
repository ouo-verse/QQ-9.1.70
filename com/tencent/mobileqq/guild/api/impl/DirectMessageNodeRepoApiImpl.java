package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.guild.api.IDirectMessageNodeRepoApi;
import com.tencent.mobileqq.guild.message.directmessage.model.data.DirectMessageNode;
import com.tencent.mobileqq.guild.message.directmessage.model.data.MessageSource;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/DirectMessageNodeRepoApiImpl;", "Lcom/tencent/mobileqq/guild/api/IDirectMessageNodeRepoApi;", "", "guildId", "findNodeByGuildId", "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class DirectMessageNodeRepoApiImpl implements IDirectMessageNodeRepoApi {

    @NotNull
    private static final String TAG = "GuildDataApiImpl";

    @Override // com.tencent.mobileqq.guild.api.IDirectMessageNodeRepoApi
    @NotNull
    public String findNodeByGuildId(@NotNull String guildId) {
        MessageSource source;
        String guildId2;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        DirectMessageNode D = DirectMessageNodeRepository.D(guildId);
        if (D == null || (source = D.getSource()) == null || (guildId2 = source.getGuildId()) == null) {
            return "";
        }
        return guildId2;
    }
}
