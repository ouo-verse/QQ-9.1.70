package com.tencent.mobileqq.guild.message.unread.api;

import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H&J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u000fH&J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u000fH&J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0012H&J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0012H&J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0017H&J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0017H&J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H&J&\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH&J\u0010\u0010 \u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001e\u0010\"\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH&\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/message/unread/api/IGuildUnreadService;", "Lmqq/app/api/IRuntimeService;", "", "guildId", "channelId", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo;", "getChannelUnreadInfo", "getChannelUnreadInfoFromCache", "Lcom/tencent/mobileqq/guild/message/unread/api/b;", "callback", "", "registerChannelUnreadCallback", "unRegisterChannelUnreadCallback", "categoryId", "getCategoryUnreadInfo", "Lcom/tencent/mobileqq/guild/message/unread/api/a;", "registerCategoryUnreadCallback", "unRegisterCategoryUnreadCallback", "Lcom/tencent/mobileqq/guild/message/unread/api/c;", "registerGuildFeedsUnreadCallback", "unRegisterGuildFeedUnreadCallback", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "getGuildUnreadCount", "Lcom/tencent/mobileqq/guild/message/unread/api/e;", "registerGuildUnreadCallback", "unRegisterGuildUnreadCallback", "setGuildRead", "", "channelIds", "", "isDirect", "setChannelRead", "getGuildFeedsUnreadCount", "refreshGuildUnread", "batchFetchChannelUnreadInfo", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface IGuildUnreadService extends IRuntimeService {
    void batchFetchChannelUnreadInfo(@NotNull String guildId, @NotNull List<String> channelIds);

    @Nullable
    UnreadInfo getCategoryUnreadInfo(@NotNull String guildId, @NotNull String categoryId);

    @Nullable
    UnreadInfo getChannelUnreadInfo(@NotNull String guildId, @NotNull String channelId);

    @Nullable
    UnreadInfo getChannelUnreadInfoFromCache(@NotNull String guildId, @NotNull String channelId);

    @NotNull
    UnreadInfo.a getGuildFeedsUnreadCount(@NotNull String guildId);

    @NotNull
    UnreadInfo.a getGuildUnreadCount(@NotNull String guildId);

    void refreshGuildUnread(@NotNull String guildId);

    void registerCategoryUnreadCallback(@NotNull a callback);

    void registerChannelUnreadCallback(@NotNull b callback);

    void registerGuildFeedsUnreadCallback(@NotNull c callback);

    void registerGuildUnreadCallback(@NotNull e callback);

    void setChannelRead(@NotNull String guildId, @NotNull List<String> channelIds, boolean isDirect);

    void setGuildRead(@NotNull String guildId);

    void unRegisterCategoryUnreadCallback(@NotNull a callback);

    void unRegisterChannelUnreadCallback(@NotNull b callback);

    void unRegisterGuildFeedUnreadCallback(@NotNull c callback);

    void unRegisterGuildUnreadCallback(@NotNull e callback);
}
