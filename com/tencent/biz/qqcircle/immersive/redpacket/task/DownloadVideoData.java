package com.tencent.biz.qqcircle.immersive.redpacket.task;

import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013\"\u0004\b\u0017\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/task/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lfeedcloud/FeedCloudMeta$StFeed;", "a", "Lfeedcloud/FeedCloudMeta$StFeed;", "()Lfeedcloud/FeedCloudMeta$StFeed;", "setFeed", "(Lfeedcloud/FeedCloudMeta$StFeed;)V", "feed", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "realPlayUrl", "d", "filePath", "<init>", "(Lfeedcloud/FeedCloudMeta$StFeed;Ljava/lang/String;Ljava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.qqcircle.immersive.redpacket.task.h, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class DownloadVideoData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private FeedCloudMeta$StFeed feed;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String realPlayUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String filePath;

    public DownloadVideoData(@NotNull FeedCloudMeta$StFeed feed, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        this.feed = feed;
        this.realPlayUrl = str;
        this.filePath = str2;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final FeedCloudMeta$StFeed getFeed() {
        return this.feed;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getRealPlayUrl() {
        return this.realPlayUrl;
    }

    public final void d(@Nullable String str) {
        this.filePath = str;
    }

    public final void e(@Nullable String str) {
        this.realPlayUrl = str;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadVideoData)) {
            return false;
        }
        DownloadVideoData downloadVideoData = (DownloadVideoData) other;
        if (Intrinsics.areEqual(this.feed, downloadVideoData.feed) && Intrinsics.areEqual(this.realPlayUrl, downloadVideoData.realPlayUrl) && Intrinsics.areEqual(this.filePath, downloadVideoData.filePath)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.feed.hashCode() * 31;
        String str = this.realPlayUrl;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        String str2 = this.filePath;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "DownloadVideoData(feed=" + this.feed + ", realPlayUrl=" + this.realPlayUrl + ", filePath=" + this.filePath + ")";
    }

    public /* synthetic */ DownloadVideoData(FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(feedCloudMeta$StFeed, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2);
    }
}
