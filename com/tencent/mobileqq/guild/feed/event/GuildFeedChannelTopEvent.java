package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/event/GuildFeedChannelTopEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "feedId", "", "channelId", "", "guildId", "topState", "", "(Ljava/lang/String;JJZ)V", "getChannelId", "()J", "getFeedId", "()Ljava/lang/String;", "getGuildId", "getTopState", "()Z", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildFeedChannelTopEvent extends SimpleBaseEvent {
    private final long channelId;

    @NotNull
    private final String feedId;
    private final long guildId;
    private final boolean topState;

    public GuildFeedChannelTopEvent(@NotNull String feedId, long j3, long j16, boolean z16) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        this.feedId = feedId;
        this.channelId = j3;
        this.guildId = j16;
        this.topState = z16;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    @NotNull
    public final String getFeedId() {
        return this.feedId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final boolean getTopState() {
        return this.topState;
    }
}
