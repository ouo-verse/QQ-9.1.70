package h40;

import com.tencent.mobileqq.winkpublish.TaskInfo;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00102\u00020\u0001:\u0001\tBE\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u000e\u0010\u001bR\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\t\u0010\u001eR\u0017\u0010 \u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0019\u0010\f\u00a8\u0006#"}, d2 = {"Lh40/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "itemType", "b", "e", "g", "(I)V", "progress", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "f", "()Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "taskInfo", "Lfeedcloud/FeedCloudMeta$StFeed;", "d", "Lfeedcloud/FeedCloudMeta$StFeed;", "()Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "Ljava/lang/String;", "()Ljava/lang/String;", "coverUrl", "playCount", "<init>", "(IILcom/tencent/mobileqq/winkpublish/TaskInfo;Lfeedcloud/FeedCloudMeta$StFeed;Ljava/lang/String;I)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: h40.a, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class QFSPersonalCoverFeedInfo {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int itemType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int progress;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final TaskInfo taskInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final FeedCloudMeta$StFeed feed;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String coverUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int playCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u000e"}, d2 = {"Lh40/a$a;", "", "Lh40/a;", "c", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "taskInfo", "e", "d", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "b", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: h40.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final QFSPersonalCoverFeedInfo a(@NotNull FeedCloudMeta$StFeed feed) {
            Intrinsics.checkNotNullParameter(feed, "feed");
            String str = feed.cover.picUrl.get();
            Intrinsics.checkNotNullExpressionValue(str, "feed.cover.picUrl.get()");
            return new QFSPersonalCoverFeedInfo(100001, 0, null, feed, str, feed.visitorInfo.viewCount.get(), 6, null);
        }

        @NotNull
        public final QFSPersonalCoverFeedInfo b(@NotNull FeedCloudMeta$StFeed feed) {
            Intrinsics.checkNotNullParameter(feed, "feed");
            String str = feed.cover.picUrl.get();
            Intrinsics.checkNotNullExpressionValue(str, "feed.cover.picUrl.get()");
            return new QFSPersonalCoverFeedInfo(100002, 0, null, feed, str, feed.visitorInfo.viewCount.get(), 6, null);
        }

        @NotNull
        public final QFSPersonalCoverFeedInfo c() {
            return new QFSPersonalCoverFeedInfo(100003, 0, null, null, null, 0, 62, null);
        }

        @NotNull
        public final QFSPersonalCoverFeedInfo d(@NotNull TaskInfo taskInfo) {
            Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
            return new QFSPersonalCoverFeedInfo(100005, taskInfo.getUploadProgress(), taskInfo, null, taskInfo.getCoverUrl(), 0, 40, null);
        }

        @NotNull
        public final QFSPersonalCoverFeedInfo e(@NotNull TaskInfo taskInfo) {
            Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
            return new QFSPersonalCoverFeedInfo(100004, taskInfo.getUploadProgress(), taskInfo, null, taskInfo.getCoverUrl(), 0, 40, null);
        }

        Companion() {
        }
    }

    public QFSPersonalCoverFeedInfo(int i3, int i16, @Nullable TaskInfo taskInfo, @Nullable FeedCloudMeta$StFeed feedCloudMeta$StFeed, @NotNull String coverUrl, int i17) {
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        this.itemType = i3;
        this.progress = i16;
        this.taskInfo = taskInfo;
        this.feed = feedCloudMeta$StFeed;
        this.coverUrl = coverUrl;
        this.playCount = i17;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final FeedCloudMeta$StFeed getFeed() {
        return this.feed;
    }

    /* renamed from: c, reason: from getter */
    public final int getItemType() {
        return this.itemType;
    }

    /* renamed from: d, reason: from getter */
    public final int getPlayCount() {
        return this.playCount;
    }

    /* renamed from: e, reason: from getter */
    public final int getProgress() {
        return this.progress;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QFSPersonalCoverFeedInfo)) {
            return false;
        }
        QFSPersonalCoverFeedInfo qFSPersonalCoverFeedInfo = (QFSPersonalCoverFeedInfo) other;
        if (this.itemType == qFSPersonalCoverFeedInfo.itemType && this.progress == qFSPersonalCoverFeedInfo.progress && Intrinsics.areEqual(this.taskInfo, qFSPersonalCoverFeedInfo.taskInfo) && Intrinsics.areEqual(this.feed, qFSPersonalCoverFeedInfo.feed) && Intrinsics.areEqual(this.coverUrl, qFSPersonalCoverFeedInfo.coverUrl) && this.playCount == qFSPersonalCoverFeedInfo.playCount) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final TaskInfo getTaskInfo() {
        return this.taskInfo;
    }

    public final void g(int i3) {
        this.progress = i3;
    }

    public int hashCode() {
        int hashCode;
        int i3 = ((this.itemType * 31) + this.progress) * 31;
        TaskInfo taskInfo = this.taskInfo;
        int i16 = 0;
        if (taskInfo == null) {
            hashCode = 0;
        } else {
            hashCode = taskInfo.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feed;
        if (feedCloudMeta$StFeed != null) {
            i16 = feedCloudMeta$StFeed.hashCode();
        }
        return ((((i17 + i16) * 31) + this.coverUrl.hashCode()) * 31) + this.playCount;
    }

    @NotNull
    public String toString() {
        return "QFSPersonalCoverFeedInfo(itemType=" + this.itemType + ", progress=" + this.progress + ", taskInfo=" + this.taskInfo + ", feed=" + this.feed + ", coverUrl=" + this.coverUrl + ", playCount=" + this.playCount + ")";
    }

    public /* synthetic */ QFSPersonalCoverFeedInfo(int i3, int i16, TaskInfo taskInfo, FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i18 & 2) != 0 ? 0 : i16, (i18 & 4) != 0 ? null : taskInfo, (i18 & 8) == 0 ? feedCloudMeta$StFeed : null, (i18 & 16) != 0 ? "" : str, (i18 & 32) == 0 ? i17 : 0);
    }
}
