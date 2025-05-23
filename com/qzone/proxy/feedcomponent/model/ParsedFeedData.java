package com.qzone.proxy.feedcomponent.model;

import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\u0006\u0010(\u001a\u00020\u0002\u0012\u0006\u0010*\u001a\u00020\u0007\u0012\u0006\u0010,\u001a\u00020\u0002\u0012\b\u00101\u001a\u0004\u0018\u00010-\u0012\u0006\u00102\u001a\u00020\u0004\u0012\u0006\u00103\u001a\u00020\u0004\u0012\u0006\u00105\u001a\u00020\u0002\u0012\u0006\u00107\u001a\u00020\u000e\u00a2\u0006\u0004\b8\u00109J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001d\u0010\fR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\n\u001a\u0004\b\u000f\u0010\f\"\u0004\b \u0010!R\u0017\u0010$\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010&\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b%\u0010\fR\u0017\u0010(\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b'\u0010\fR\u0017\u0010*\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010,\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\n\u001a\u0004\b#\u0010\fR\u0019\u00101\u001a\u0004\u0018\u00010-8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b.\u00100R\u0017\u00102\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u0017\u00103\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u0018\u001a\u0004\b\u0014\u0010\u001aR\u0017\u00105\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b4\u0010\n\u001a\u0004\b\u0017\u0010\fR\u0017\u00107\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b6\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012\u00a8\u0006:"}, d2 = {"Lcom/qzone/proxy/feedcomponent/model/o;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/lang/String;", "title", "", "b", "J", "i", "()J", "posterId", "c", "j", "posterName", "d", "I", tl.h.F, "()I", MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_LIKE_COUNT, "e", "k", "recommendReason", "f", "setClipedRecommendReason", "(Ljava/lang/String;)V", "clipedRecommendReason", "g", PhotoCategorySummaryInfo.AVATAR_URL, DomainData.DOMAIN_NAME, "videoActionUrl", "getAvatarActionUrl", "avatarActionUrl", "Z", "isLiked", "()Z", "feedId", "Lcom/qzone/proxy/feedcomponent/model/d;", "l", "Lcom/qzone/proxy/feedcomponent/model/d;", "()Lcom/qzone/proxy/feedcomponent/model/d;", "reportData", "coverWidth", "coverHeight", "o", "coverUrl", "p", "duration", "<init>", "(Ljava/lang/String;JLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/qzone/proxy/feedcomponent/model/d;IILjava/lang/String;J)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.qzone.proxy.feedcomponent.model.o, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class ParsedFeedData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long posterId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String posterName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int likeCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String recommendReason;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private String clipedRecommendReason;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final String avatarUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final String videoActionUrl;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final String avatarActionUrl;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isLiked;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private final String feedId;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private final CircleReportData reportData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private final int coverWidth;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    private final int coverHeight;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    private final String coverUrl;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    private final long duration;

    /* renamed from: a, reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    /* renamed from: b, reason: from getter */
    public final String getClipedRecommendReason() {
        return this.clipedRecommendReason;
    }

    /* renamed from: c, reason: from getter */
    public final int getCoverHeight() {
        return this.coverHeight;
    }

    /* renamed from: d, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    /* renamed from: e, reason: from getter */
    public final int getCoverWidth() {
        return this.coverWidth;
    }

    /* renamed from: f, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    /* renamed from: g, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    /* renamed from: h, reason: from getter */
    public final int getLikeCount() {
        return this.likeCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((((((this.title.hashCode() * 31) + n.a(this.posterId)) * 31) + this.posterName.hashCode()) * 31) + this.likeCount) * 31) + this.recommendReason.hashCode()) * 31) + this.clipedRecommendReason.hashCode()) * 31) + this.avatarUrl.hashCode()) * 31) + this.videoActionUrl.hashCode()) * 31) + this.avatarActionUrl.hashCode()) * 31;
        boolean z16 = this.isLiked;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int hashCode2 = (((hashCode + i3) * 31) + this.feedId.hashCode()) * 31;
        CircleReportData circleReportData = this.reportData;
        return ((((((((hashCode2 + (circleReportData == null ? 0 : circleReportData.hashCode())) * 31) + this.coverWidth) * 31) + this.coverHeight) * 31) + this.coverUrl.hashCode()) * 31) + n.a(this.duration);
    }

    /* renamed from: i, reason: from getter */
    public final long getPosterId() {
        return this.posterId;
    }

    /* renamed from: j, reason: from getter */
    public final String getPosterName() {
        return this.posterName;
    }

    /* renamed from: k, reason: from getter */
    public final String getRecommendReason() {
        return this.recommendReason;
    }

    /* renamed from: l, reason: from getter */
    public final CircleReportData getReportData() {
        return this.reportData;
    }

    /* renamed from: m, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: n, reason: from getter */
    public final String getVideoActionUrl() {
        return this.videoActionUrl;
    }

    public String toString() {
        return "ParsedFeedData(title=" + this.title + ", posterId=" + this.posterId + ", posterName=" + this.posterName + ", likeCount=" + this.likeCount + ", recommendReason=" + this.recommendReason + ", clipedRecommendReason=" + this.clipedRecommendReason + ", avatarUrl=" + this.avatarUrl + ", videoActionUrl=" + this.videoActionUrl + ", avatarActionUrl=" + this.avatarActionUrl + ", isLiked=" + this.isLiked + ", feedId=" + this.feedId + ", reportData=" + this.reportData + ", coverWidth=" + this.coverWidth + ", coverHeight=" + this.coverHeight + ", coverUrl=" + this.coverUrl + ", duration=" + this.duration + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParsedFeedData)) {
            return false;
        }
        ParsedFeedData parsedFeedData = (ParsedFeedData) other;
        return Intrinsics.areEqual(this.title, parsedFeedData.title) && this.posterId == parsedFeedData.posterId && Intrinsics.areEqual(this.posterName, parsedFeedData.posterName) && this.likeCount == parsedFeedData.likeCount && Intrinsics.areEqual(this.recommendReason, parsedFeedData.recommendReason) && Intrinsics.areEqual(this.clipedRecommendReason, parsedFeedData.clipedRecommendReason) && Intrinsics.areEqual(this.avatarUrl, parsedFeedData.avatarUrl) && Intrinsics.areEqual(this.videoActionUrl, parsedFeedData.videoActionUrl) && Intrinsics.areEqual(this.avatarActionUrl, parsedFeedData.avatarActionUrl) && this.isLiked == parsedFeedData.isLiked && Intrinsics.areEqual(this.feedId, parsedFeedData.feedId) && Intrinsics.areEqual(this.reportData, parsedFeedData.reportData) && this.coverWidth == parsedFeedData.coverWidth && this.coverHeight == parsedFeedData.coverHeight && Intrinsics.areEqual(this.coverUrl, parsedFeedData.coverUrl) && this.duration == parsedFeedData.duration;
    }

    public ParsedFeedData(String title, long j3, String posterName, int i3, String recommendReason, String clipedRecommendReason, String avatarUrl, String videoActionUrl, String avatarActionUrl, boolean z16, String feedId, CircleReportData circleReportData, int i16, int i17, String coverUrl, long j16) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(posterName, "posterName");
        Intrinsics.checkNotNullParameter(recommendReason, "recommendReason");
        Intrinsics.checkNotNullParameter(clipedRecommendReason, "clipedRecommendReason");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(videoActionUrl, "videoActionUrl");
        Intrinsics.checkNotNullParameter(avatarActionUrl, "avatarActionUrl");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        this.title = title;
        this.posterId = j3;
        this.posterName = posterName;
        this.likeCount = i3;
        this.recommendReason = recommendReason;
        this.clipedRecommendReason = clipedRecommendReason;
        this.avatarUrl = avatarUrl;
        this.videoActionUrl = videoActionUrl;
        this.avatarActionUrl = avatarActionUrl;
        this.isLiked = z16;
        this.feedId = feedId;
        this.reportData = circleReportData;
        this.coverWidth = i16;
        this.coverHeight = i17;
        this.coverUrl = coverUrl;
        this.duration = j16;
    }
}
