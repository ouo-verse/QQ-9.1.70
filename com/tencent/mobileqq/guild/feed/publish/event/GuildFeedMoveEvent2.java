package com.tencent.mobileqq.guild.feed.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/event/GuildFeedMoveEvent2;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "feedId", "", "guildId", "sourceChannelId", "targetChannelId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFeedId", "()Ljava/lang/String;", "getGuildId", "getSourceChannelId", "getTargetChannelId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final /* data */ class GuildFeedMoveEvent2 extends SimpleBaseEvent {

    @NotNull
    private final String feedId;

    @NotNull
    private final String guildId;

    @NotNull
    private final String sourceChannelId;

    @NotNull
    private final String targetChannelId;

    public GuildFeedMoveEvent2(@NotNull String feedId, @NotNull String guildId, @NotNull String sourceChannelId, @NotNull String targetChannelId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(sourceChannelId, "sourceChannelId");
        Intrinsics.checkNotNullParameter(targetChannelId, "targetChannelId");
        this.feedId = feedId;
        this.guildId = guildId;
        this.sourceChannelId = sourceChannelId;
        this.targetChannelId = targetChannelId;
    }

    public static /* synthetic */ GuildFeedMoveEvent2 copy$default(GuildFeedMoveEvent2 guildFeedMoveEvent2, String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = guildFeedMoveEvent2.feedId;
        }
        if ((i3 & 2) != 0) {
            str2 = guildFeedMoveEvent2.guildId;
        }
        if ((i3 & 4) != 0) {
            str3 = guildFeedMoveEvent2.sourceChannelId;
        }
        if ((i3 & 8) != 0) {
            str4 = guildFeedMoveEvent2.targetChannelId;
        }
        return guildFeedMoveEvent2.copy(str, str2, str3, str4);
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
    public final String getSourceChannelId() {
        return this.sourceChannelId;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getTargetChannelId() {
        return this.targetChannelId;
    }

    @NotNull
    public final GuildFeedMoveEvent2 copy(@NotNull String feedId, @NotNull String guildId, @NotNull String sourceChannelId, @NotNull String targetChannelId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(sourceChannelId, "sourceChannelId");
        Intrinsics.checkNotNullParameter(targetChannelId, "targetChannelId");
        return new GuildFeedMoveEvent2(feedId, guildId, sourceChannelId, targetChannelId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildFeedMoveEvent2)) {
            return false;
        }
        GuildFeedMoveEvent2 guildFeedMoveEvent2 = (GuildFeedMoveEvent2) other;
        if (Intrinsics.areEqual(this.feedId, guildFeedMoveEvent2.feedId) && Intrinsics.areEqual(this.guildId, guildFeedMoveEvent2.guildId) && Intrinsics.areEqual(this.sourceChannelId, guildFeedMoveEvent2.sourceChannelId) && Intrinsics.areEqual(this.targetChannelId, guildFeedMoveEvent2.targetChannelId)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getFeedId() {
        return this.feedId;
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    public final String getSourceChannelId() {
        return this.sourceChannelId;
    }

    @NotNull
    public final String getTargetChannelId() {
        return this.targetChannelId;
    }

    public int hashCode() {
        return (((((this.feedId.hashCode() * 31) + this.guildId.hashCode()) * 31) + this.sourceChannelId.hashCode()) * 31) + this.targetChannelId.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildFeedMoveEvent2(feedId=" + this.feedId + ", guildId=" + this.guildId + ", sourceChannelId=" + this.sourceChannelId + ", targetChannelId=" + this.targetChannelId + ")";
    }
}
