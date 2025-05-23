package com.tencent.mobileqq.guild.api;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0010\u0012\b\b\u0002\u0010$\u001a\u00020\u0010\u00a2\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\t\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u001b\u0010\u000eR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\n\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u000eR\"\u0010\"\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0011\u0010\u0014\"\u0004\b!\u0010\u0016R\"\u0010$\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b#\u0010\u0016\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/api/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "title", "", "b", "J", "d", "()J", "setGuildId", "(J)V", "guildId", "c", "setChannelId", "channelId", "setFeedId", "feedId", "e", "g", "setUserId", "userId", "setCreateTime", WadlProxyConsts.CREATE_TIME, "setLastModified", "lastModified", "<init>", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;JJ)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.api.b, reason: from toString */
/* loaded from: classes12.dex */
public final /* data */ class FeedPreloadInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private long guildId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private long channelId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String feedId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String userId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private long createTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private long lastModified;

    public FeedPreloadInfo() {
        this(null, 0L, 0L, null, null, 0L, 0L, 127, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* renamed from: b, reason: from getter */
    public final long getCreateTime() {
        return this.createTime;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    /* renamed from: d, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: e, reason: from getter */
    public final long getLastModified() {
        return this.lastModified;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedPreloadInfo)) {
            return false;
        }
        FeedPreloadInfo feedPreloadInfo = (FeedPreloadInfo) other;
        if (Intrinsics.areEqual(this.title, feedPreloadInfo.title) && this.guildId == feedPreloadInfo.guildId && this.channelId == feedPreloadInfo.channelId && Intrinsics.areEqual(this.feedId, feedPreloadInfo.feedId) && Intrinsics.areEqual(this.userId, feedPreloadInfo.userId) && this.createTime == feedPreloadInfo.createTime && this.lastModified == feedPreloadInfo.lastModified) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return (((((((((((this.title.hashCode() * 31) + androidx.fragment.app.a.a(this.guildId)) * 31) + androidx.fragment.app.a.a(this.channelId)) * 31) + this.feedId.hashCode()) * 31) + this.userId.hashCode()) * 31) + androidx.fragment.app.a.a(this.createTime)) * 31) + androidx.fragment.app.a.a(this.lastModified);
    }

    @NotNull
    public String toString() {
        return "FeedPreloadInfo(title=" + this.title + ", guildId=" + this.guildId + ", channelId=" + this.channelId + ", feedId=" + this.feedId + ", userId=" + this.userId + ", createTime=" + this.createTime + ", lastModified=" + this.lastModified + ')';
    }

    public FeedPreloadInfo(@NotNull String title, long j3, long j16, @NotNull String feedId, @NotNull String userId, long j17, long j18) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        this.title = title;
        this.guildId = j3;
        this.channelId = j16;
        this.feedId = feedId;
        this.userId = userId;
        this.createTime = j17;
        this.lastModified = j18;
    }

    public /* synthetic */ FeedPreloadInfo(String str, long j3, long j16, String str2, String str3, long j17, long j18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0L : j3, (i3 & 4) != 0 ? 0L : j16, (i3 & 8) != 0 ? "" : str2, (i3 & 16) == 0 ? str3 : "", (i3 & 32) != 0 ? 0L : j17, (i3 & 64) == 0 ? j18 : 0L);
    }
}
