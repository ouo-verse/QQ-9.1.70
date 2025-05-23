package com.tencent.mobileqq.guild.feed.detail.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/detail/event/FindUnfinishedCommentEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "guildID", "", "channelID", "feedID", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChannelID", "()Ljava/lang/String;", "getFeedID", "getGuildID", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class FindUnfinishedCommentEvent extends SimpleBaseEvent {

    @NotNull
    private final String channelID;

    @NotNull
    private final String feedID;

    @NotNull
    private final String guildID;

    public FindUnfinishedCommentEvent(@NotNull String guildID, @NotNull String channelID, @NotNull String feedID) {
        Intrinsics.checkNotNullParameter(guildID, "guildID");
        Intrinsics.checkNotNullParameter(channelID, "channelID");
        Intrinsics.checkNotNullParameter(feedID, "feedID");
        this.guildID = guildID;
        this.channelID = channelID;
        this.feedID = feedID;
    }

    @NotNull
    public final String getChannelID() {
        return this.channelID;
    }

    @NotNull
    public final String getFeedID() {
        return this.feedID;
    }

    @NotNull
    public final String getGuildID() {
        return this.guildID;
    }
}
