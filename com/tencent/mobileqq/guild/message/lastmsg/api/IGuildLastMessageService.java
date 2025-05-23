package com.tencent.mobileqq.guild.message.lastmsg.api;

import com.tencent.mobileqq.guild.message.lastmsg.LastMessage;
import com.tencent.mobileqq.qroute.annotation.Service;
import fu1.b;
import java.util.List;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH&J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/message/lastmsg/api/IGuildLastMessageService;", "Lmqq/app/api/IRuntimeService;", "", "guildId", "channelId", "", "isDirect", "Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage;", "getLastMessageInfo", "getLastMessageFromCache", "", "channelIds", "", "batchFetchLastMessageInfo", "Lfu1/b;", "callback", "registerLastMessageCallback", "unRegisterLastMessageCallback", "removeLastMessageCache", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface IGuildLastMessageService extends IRuntimeService {
    void batchFetchLastMessageInfo(@NotNull String guildId, @NotNull List<String> channelIds);

    @Nullable
    LastMessage getLastMessageFromCache(@NotNull String guildId, @NotNull String channelId);

    @Nullable
    LastMessage getLastMessageInfo(@NotNull String guildId, @NotNull String channelId, boolean isDirect);

    void registerLastMessageCallback(@NotNull b callback);

    void removeLastMessageCache(@NotNull String guildId, @NotNull String channelId);

    void unRegisterLastMessageCallback(@NotNull b callback);
}
