package com.tencent.mobileqq.guild.feed.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/event/GuildFeedUpdateChannelInfoEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "feedId", "", "guildId", "channelId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "getFeedId", "getGuildId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final /* data */ class GuildFeedUpdateChannelInfoEvent extends SimpleBaseEvent {

    @NotNull
    private final String channelId;

    @NotNull
    private final String feedId;

    @NotNull
    private final String guildId;

    public GuildFeedUpdateChannelInfoEvent(@NotNull String feedId, @NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.feedId = feedId;
        this.guildId = guildId;
        this.channelId = channelId;
    }

    public static /* synthetic */ GuildFeedUpdateChannelInfoEvent copy$default(GuildFeedUpdateChannelInfoEvent guildFeedUpdateChannelInfoEvent, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = guildFeedUpdateChannelInfoEvent.feedId;
        }
        if ((i3 & 2) != 0) {
            str2 = guildFeedUpdateChannelInfoEvent.guildId;
        }
        if ((i3 & 4) != 0) {
            str3 = guildFeedUpdateChannelInfoEvent.channelId;
        }
        return guildFeedUpdateChannelInfoEvent.copy(str, str2, str3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    public final GuildFeedUpdateChannelInfoEvent copy(@NotNull String feedId, @NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        return new GuildFeedUpdateChannelInfoEvent(feedId, guildId, channelId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildFeedUpdateChannelInfoEvent)) {
            return false;
        }
        GuildFeedUpdateChannelInfoEvent guildFeedUpdateChannelInfoEvent = (GuildFeedUpdateChannelInfoEvent) other;
        if (Intrinsics.areEqual(this.feedId, guildFeedUpdateChannelInfoEvent.feedId) && Intrinsics.areEqual(this.guildId, guildFeedUpdateChannelInfoEvent.guildId) && Intrinsics.areEqual(this.channelId, guildFeedUpdateChannelInfoEvent.channelId)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    public final String getFeedId() {
        return this.feedId;
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }

    public int hashCode() {
        return (((this.feedId.hashCode() * 31) + this.guildId.hashCode()) * 31) + this.channelId.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildFeedUpdateChannelInfoEvent(feedId=" + this.feedId + ", guildId=" + this.guildId + ", channelId=" + this.channelId + ")";
    }
}
