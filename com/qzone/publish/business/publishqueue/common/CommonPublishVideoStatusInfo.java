package com.qzone.publish.business.publishqueue.common;

import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/publish/business/publishqueue/common/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "c", "()Z", "isSingleVideo", "b", "I", "()I", "videoFeedStatus", "Lcom/qzone/proxy/feedcomponent/model/VideoInfo;", "Lcom/qzone/proxy/feedcomponent/model/VideoInfo;", "()Lcom/qzone/proxy/feedcomponent/model/VideoInfo;", QCircleScheme.AttrDetail.VIDEO_INFO, "<init>", "(ZILcom/qzone/proxy/feedcomponent/model/VideoInfo;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.qzone.publish.business.publishqueue.common.g, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class CommonPublishVideoStatusInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSingleVideo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int videoFeedStatus;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final VideoInfo videoInfo;

    public CommonPublishVideoStatusInfo(boolean z16, int i3, VideoInfo videoInfo) {
        this.isSingleVideo = z16;
        this.videoFeedStatus = i3;
        this.videoInfo = videoInfo;
    }

    /* renamed from: a, reason: from getter */
    public final int getVideoFeedStatus() {
        return this.videoFeedStatus;
    }

    /* renamed from: b, reason: from getter */
    public final VideoInfo getVideoInfo() {
        return this.videoInfo;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsSingleVideo() {
        return this.isSingleVideo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.isSingleVideo;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = ((r06 * 31) + this.videoFeedStatus) * 31;
        VideoInfo videoInfo = this.videoInfo;
        return i3 + (videoInfo == null ? 0 : videoInfo.hashCode());
    }

    public String toString() {
        return "CommonPublishVideoStatusInfo(isSingleVideo=" + this.isSingleVideo + ", videoFeedStatus=" + this.videoFeedStatus + ", videoInfo=" + this.videoInfo + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonPublishVideoStatusInfo)) {
            return false;
        }
        CommonPublishVideoStatusInfo commonPublishVideoStatusInfo = (CommonPublishVideoStatusInfo) other;
        return this.isSingleVideo == commonPublishVideoStatusInfo.isSingleVideo && this.videoFeedStatus == commonPublishVideoStatusInfo.videoFeedStatus && Intrinsics.areEqual(this.videoInfo, commonPublishVideoStatusInfo.videoInfo);
    }
}
