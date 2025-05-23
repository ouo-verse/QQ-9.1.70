package com.tencent.mobileqq.guild.message.draft.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yt1.DraftInfo;
import zt1.a;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/message/draft/api/IGuildDraftService;", "Lmqq/app/api/IRuntimeService;", "", "guildId", "channelId", "Lyt1/a;", "getDraftInfo", "Lzt1/a;", "callback", "", "registerChannelDraftCallback", "unRegisterChannelDraftCallback", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface IGuildDraftService extends IRuntimeService {
    @Nullable
    DraftInfo getDraftInfo(@NotNull String guildId, @NotNull String channelId);

    void registerChannelDraftCallback(@NotNull a callback);

    void unRegisterChannelDraftCallback(@NotNull a callback);
}
