package com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.commentfeed;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000e\u0010\u0015R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0013\u0010\fR\"\u0010\u001d\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/commentfeed/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "feedId", "b", "e", "guildId", "channelId", "", "d", "J", "()J", "feedCreateTime", "feedPosterTinyId", "f", "Z", "()Z", "g", "(Z)V", "needSyncToGroup", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.commentfeed.c, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class CommentFeedRequestArgs {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String feedId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String channelId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long feedCreateTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String feedPosterTinyId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean needSyncToGroup;

    public CommentFeedRequestArgs(@NotNull String feedId, @NotNull String guildId, @NotNull String channelId, long j3, @NotNull String feedPosterTinyId, boolean z16) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(feedPosterTinyId, "feedPosterTinyId");
        this.feedId = feedId;
        this.guildId = guildId;
        this.channelId = channelId;
        this.feedCreateTime = j3;
        this.feedPosterTinyId = feedPosterTinyId;
        this.needSyncToGroup = z16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    /* renamed from: b, reason: from getter */
    public final long getFeedCreateTime() {
        return this.feedCreateTime;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getFeedPosterTinyId() {
        return this.feedPosterTinyId;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommentFeedRequestArgs)) {
            return false;
        }
        CommentFeedRequestArgs commentFeedRequestArgs = (CommentFeedRequestArgs) other;
        if (Intrinsics.areEqual(this.feedId, commentFeedRequestArgs.feedId) && Intrinsics.areEqual(this.guildId, commentFeedRequestArgs.guildId) && Intrinsics.areEqual(this.channelId, commentFeedRequestArgs.channelId) && this.feedCreateTime == commentFeedRequestArgs.feedCreateTime && Intrinsics.areEqual(this.feedPosterTinyId, commentFeedRequestArgs.feedPosterTinyId) && this.needSyncToGroup == commentFeedRequestArgs.needSyncToGroup) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getNeedSyncToGroup() {
        return this.needSyncToGroup;
    }

    public final void g(boolean z16) {
        this.needSyncToGroup = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((this.feedId.hashCode() * 31) + this.guildId.hashCode()) * 31) + this.channelId.hashCode()) * 31) + androidx.fragment.app.a.a(this.feedCreateTime)) * 31) + this.feedPosterTinyId.hashCode()) * 31;
        boolean z16 = this.needSyncToGroup;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "CommentFeedRequestArgs(feedId=" + this.feedId + ", guildId=" + this.guildId + ", channelId=" + this.channelId + ", feedCreateTime=" + this.feedCreateTime + ", feedPosterTinyId=" + this.feedPosterTinyId + ", needSyncToGroup=" + this.needSyncToGroup + ")";
    }

    public /* synthetic */ CommentFeedRequestArgs(String str, String str2, String str3, long j3, String str4, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, j3, str4, (i3 & 32) != 0 ? false : z16);
    }
}
