package com.tencent.mobileqq.guild.feed.feedsquare.data;

import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001f\u00a2\u0006\u0004\b%\u0010&B\u0019\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010(\u001a\u00020'\u00a2\u0006\u0004\b%\u0010)J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u0010\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\"\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001dR.\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010 \u001a\u0004\b\u0012\u0010!\"\u0004\b\"\u0010#\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/data/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setGuildId", "(Ljava/lang/String;)V", "guildId", "g", "channelId", "c", "d", "setRoomId", "roomId", "f", tl.h.F, "roomTitle", "e", "I", "()I", "setRoomState", "(I)V", "roomState", "Ljava/util/HashMap;", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "setRoomIcons", "(Ljava/util/HashMap;)V", "roomIcons", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/HashMap;)V", "Lcom/tencent/mobileqq/qqguildsdk/data/ILiveRoomInfo;", "info", "(Ljava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/ILiveRoomInfo;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.feed.feedsquare.data.j, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildFeedSquareLiveRoomItemData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String roomId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String roomTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int roomState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private HashMap<String, String> roomIcons;

    public GuildFeedSquareLiveRoomItemData(@NotNull String guildId, @NotNull String channelId, @NotNull String roomId, @NotNull String roomTitle, int i3, @NotNull HashMap<String, String> roomIcons) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(roomTitle, "roomTitle");
        Intrinsics.checkNotNullParameter(roomIcons, "roomIcons");
        this.guildId = guildId;
        this.channelId = channelId;
        this.roomId = roomId;
        this.roomTitle = roomTitle;
        this.roomState = i3;
        this.roomIcons = roomIcons;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    public final HashMap<String, String> c() {
        return this.roomIcons;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    /* renamed from: e, reason: from getter */
    public final int getRoomState() {
        return this.roomState;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildFeedSquareLiveRoomItemData)) {
            return false;
        }
        GuildFeedSquareLiveRoomItemData guildFeedSquareLiveRoomItemData = (GuildFeedSquareLiveRoomItemData) other;
        if (Intrinsics.areEqual(this.guildId, guildFeedSquareLiveRoomItemData.guildId) && Intrinsics.areEqual(this.channelId, guildFeedSquareLiveRoomItemData.channelId) && Intrinsics.areEqual(this.roomId, guildFeedSquareLiveRoomItemData.roomId) && Intrinsics.areEqual(this.roomTitle, guildFeedSquareLiveRoomItemData.roomTitle) && this.roomState == guildFeedSquareLiveRoomItemData.roomState && Intrinsics.areEqual(this.roomIcons, guildFeedSquareLiveRoomItemData.roomIcons)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getRoomTitle() {
        return this.roomTitle;
    }

    public final void g(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.channelId = str;
    }

    public final void h(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.roomTitle = str;
    }

    public int hashCode() {
        return (((((((((this.guildId.hashCode() * 31) + this.channelId.hashCode()) * 31) + this.roomId.hashCode()) * 31) + this.roomTitle.hashCode()) * 31) + this.roomState) * 31) + this.roomIcons.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildFeedSquareLiveRoomItemData(guildId=" + this.guildId + ", channelId=" + this.channelId + ", roomId=" + this.roomId + ", roomTitle=" + this.roomTitle + ", roomState=" + this.roomState + ", roomIcons=" + this.roomIcons + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GuildFeedSquareLiveRoomItemData(@NotNull String guildId, @NotNull ILiveRoomInfo info) {
        this(guildId, r3, r4, r5, r6, r7);
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(info, "info");
        String channelId = info.getChannelId();
        Intrinsics.checkNotNullExpressionValue(channelId, "info.channelId");
        String roomId = info.getRoomId();
        Intrinsics.checkNotNullExpressionValue(roomId, "info.roomId");
        String roomTitle = info.getRoomTitle();
        Intrinsics.checkNotNullExpressionValue(roomTitle, "info.roomTitle");
        int roomState = info.getRoomState();
        HashMap<String, String> roomIcons = info.getRoomIcons();
        Intrinsics.checkNotNullExpressionValue(roomIcons, "info.roomIcons");
    }
}
