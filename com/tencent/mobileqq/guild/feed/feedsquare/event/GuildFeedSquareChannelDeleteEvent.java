package com.tencent.mobileqq.guild.feed.feedsquare.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u00c6\u0003J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/event/GuildFeedSquareChannelDeleteEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "guildId", "", "channelIds", "", "(Ljava/lang/String;Ljava/util/List;)V", "getChannelIds", "()Ljava/util/List;", "getGuildId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final /* data */ class GuildFeedSquareChannelDeleteEvent extends SimpleBaseEvent {

    @NotNull
    private final List<String> channelIds;

    @NotNull
    private final String guildId;

    public GuildFeedSquareChannelDeleteEvent(@NotNull String guildId, @NotNull List<String> channelIds) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelIds, "channelIds");
        this.guildId = guildId;
        this.channelIds = channelIds;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildFeedSquareChannelDeleteEvent copy$default(GuildFeedSquareChannelDeleteEvent guildFeedSquareChannelDeleteEvent, String str, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = guildFeedSquareChannelDeleteEvent.guildId;
        }
        if ((i3 & 2) != 0) {
            list = guildFeedSquareChannelDeleteEvent.channelIds;
        }
        return guildFeedSquareChannelDeleteEvent.copy(str, list);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    public final List<String> component2() {
        return this.channelIds;
    }

    @NotNull
    public final GuildFeedSquareChannelDeleteEvent copy(@NotNull String guildId, @NotNull List<String> channelIds) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelIds, "channelIds");
        return new GuildFeedSquareChannelDeleteEvent(guildId, channelIds);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildFeedSquareChannelDeleteEvent)) {
            return false;
        }
        GuildFeedSquareChannelDeleteEvent guildFeedSquareChannelDeleteEvent = (GuildFeedSquareChannelDeleteEvent) other;
        if (Intrinsics.areEqual(this.guildId, guildFeedSquareChannelDeleteEvent.guildId) && Intrinsics.areEqual(this.channelIds, guildFeedSquareChannelDeleteEvent.channelIds)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<String> getChannelIds() {
        return this.channelIds;
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }

    public int hashCode() {
        return (this.guildId.hashCode() * 31) + this.channelIds.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildFeedSquareChannelDeleteEvent(guildId=" + this.guildId + ", channelIds=" + this.channelIds + ")";
    }
}
