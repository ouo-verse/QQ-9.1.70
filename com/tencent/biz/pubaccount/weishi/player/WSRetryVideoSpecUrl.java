package com.tencent.biz.pubaccount.weishi.player;

import com.tencent.mobileqq.app.AppConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0018\u0010\u0010R\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u0015\u0010\u0010\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/player/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", AppConstants.Key.KEY_QZONE_VIDEO_URL, "b", "I", "()I", "fileSize", "c", "f", "width", "d", "height", "decodeStrategyType", "getVideoQuality", "videoQuality", "g", "selectedVideoSpecReason", "<init>", "(Ljava/lang/String;IIIIII)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.pubaccount.weishi.player.k, reason: from toString */
/* loaded from: classes32.dex */
public final /* data */ class WSRetryVideoSpecUrl {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String videoUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int fileSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int width;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int height;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int decodeStrategyType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int videoQuality;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final int selectedVideoSpecReason;

    public WSRetryVideoSpecUrl(String videoUrl, int i3, int i16, int i17, int i18, int i19, int i26) {
        Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
        this.videoUrl = videoUrl;
        this.fileSize = i3;
        this.width = i16;
        this.height = i17;
        this.decodeStrategyType = i18;
        this.videoQuality = i19;
        this.selectedVideoSpecReason = i26;
    }

    /* renamed from: a, reason: from getter */
    public final int getDecodeStrategyType() {
        return this.decodeStrategyType;
    }

    /* renamed from: b, reason: from getter */
    public final int getFileSize() {
        return this.fileSize;
    }

    /* renamed from: c, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: d, reason: from getter */
    public final int getSelectedVideoSpecReason() {
        return this.selectedVideoSpecReason;
    }

    /* renamed from: e, reason: from getter */
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    /* renamed from: f, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((((((((((this.videoUrl.hashCode() * 31) + this.fileSize) * 31) + this.width) * 31) + this.height) * 31) + this.decodeStrategyType) * 31) + this.videoQuality) * 31) + this.selectedVideoSpecReason;
    }

    public String toString() {
        return "WSRetryVideoSpecUrl(videoUrl=" + this.videoUrl + ", fileSize=" + this.fileSize + ", width=" + this.width + ", height=" + this.height + ", decodeStrategyType=" + this.decodeStrategyType + ", videoQuality=" + this.videoQuality + ", selectedVideoSpecReason=" + this.selectedVideoSpecReason + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WSRetryVideoSpecUrl)) {
            return false;
        }
        WSRetryVideoSpecUrl wSRetryVideoSpecUrl = (WSRetryVideoSpecUrl) other;
        return Intrinsics.areEqual(this.videoUrl, wSRetryVideoSpecUrl.videoUrl) && this.fileSize == wSRetryVideoSpecUrl.fileSize && this.width == wSRetryVideoSpecUrl.width && this.height == wSRetryVideoSpecUrl.height && this.decodeStrategyType == wSRetryVideoSpecUrl.decodeStrategyType && this.videoQuality == wSRetryVideoSpecUrl.videoQuality && this.selectedVideoSpecReason == wSRetryVideoSpecUrl.selectedVideoSpecReason;
    }
}
