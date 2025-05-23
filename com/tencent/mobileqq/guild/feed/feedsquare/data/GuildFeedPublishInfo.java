package com.tencent.mobileqq.guild.feed.feedsquare.data;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedPublishInfo;", "Ljava/io/Serializable;", "mainStatus", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedPublishState;", "mainTaskId", "", "isLocalFeed", "", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedPublishState;Ljava/lang/String;Z)V", "()Z", "getMainStatus", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedPublishState;", "getMainTaskId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final /* data */ class GuildFeedPublishInfo implements Serializable {
    private final boolean isLocalFeed;

    @NotNull
    private final GuildFeedPublishState mainStatus;

    @NotNull
    private final String mainTaskId;

    public GuildFeedPublishInfo() {
        this(null, null, false, 7, null);
    }

    public static /* synthetic */ GuildFeedPublishInfo copy$default(GuildFeedPublishInfo guildFeedPublishInfo, GuildFeedPublishState guildFeedPublishState, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            guildFeedPublishState = guildFeedPublishInfo.mainStatus;
        }
        if ((i3 & 2) != 0) {
            str = guildFeedPublishInfo.mainTaskId;
        }
        if ((i3 & 4) != 0) {
            z16 = guildFeedPublishInfo.isLocalFeed;
        }
        return guildFeedPublishInfo.copy(guildFeedPublishState, str, z16);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final GuildFeedPublishState getMainStatus() {
        return this.mainStatus;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getMainTaskId() {
        return this.mainTaskId;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsLocalFeed() {
        return this.isLocalFeed;
    }

    @NotNull
    public final GuildFeedPublishInfo copy(@NotNull GuildFeedPublishState mainStatus, @NotNull String mainTaskId, boolean isLocalFeed) {
        Intrinsics.checkNotNullParameter(mainStatus, "mainStatus");
        Intrinsics.checkNotNullParameter(mainTaskId, "mainTaskId");
        return new GuildFeedPublishInfo(mainStatus, mainTaskId, isLocalFeed);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildFeedPublishInfo)) {
            return false;
        }
        GuildFeedPublishInfo guildFeedPublishInfo = (GuildFeedPublishInfo) other;
        if (this.mainStatus == guildFeedPublishInfo.mainStatus && Intrinsics.areEqual(this.mainTaskId, guildFeedPublishInfo.mainTaskId) && this.isLocalFeed == guildFeedPublishInfo.isLocalFeed) {
            return true;
        }
        return false;
    }

    @NotNull
    public final GuildFeedPublishState getMainStatus() {
        return this.mainStatus;
    }

    @NotNull
    public final String getMainTaskId() {
        return this.mainTaskId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.mainStatus.hashCode() * 31) + this.mainTaskId.hashCode()) * 31;
        boolean z16 = this.isLocalFeed;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public final boolean isLocalFeed() {
        return this.isLocalFeed;
    }

    @NotNull
    public String toString() {
        return "GuildFeedPublishInfo(mainStatus=" + this.mainStatus + ", mainTaskId=" + this.mainTaskId + ", isLocalFeed=" + this.isLocalFeed + ")";
    }

    public GuildFeedPublishInfo(@NotNull GuildFeedPublishState mainStatus, @NotNull String mainTaskId, boolean z16) {
        Intrinsics.checkNotNullParameter(mainStatus, "mainStatus");
        Intrinsics.checkNotNullParameter(mainTaskId, "mainTaskId");
        this.mainStatus = mainStatus;
        this.mainTaskId = mainTaskId;
        this.isLocalFeed = z16;
    }

    public /* synthetic */ GuildFeedPublishInfo(GuildFeedPublishState guildFeedPublishState, String str, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? GuildFeedPublishState.STATE_SUCCESS : guildFeedPublishState, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? false : z16);
    }
}
