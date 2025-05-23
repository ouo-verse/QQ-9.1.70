package com.tencent.mobileqq.guild.feed.feedsquare.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/event/GuildFeedSquareScheduleDeleteEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "guildId", "", "channelId", "scheduleIdList", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getChannelId", "()Ljava/lang/String;", "getGuildId", "getScheduleIdList", "()Ljava/util/List;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildFeedSquareScheduleDeleteEvent extends SimpleBaseEvent {

    @NotNull
    private final String channelId;

    @NotNull
    private final String guildId;

    @NotNull
    private final List<Long> scheduleIdList;

    public GuildFeedSquareScheduleDeleteEvent(@NotNull String guildId, @NotNull String channelId, @NotNull List<Long> scheduleIdList) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(scheduleIdList, "scheduleIdList");
        this.guildId = guildId;
        this.channelId = channelId;
        this.scheduleIdList = scheduleIdList;
    }

    @NotNull
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    public final List<Long> getScheduleIdList() {
        return this.scheduleIdList;
    }
}
