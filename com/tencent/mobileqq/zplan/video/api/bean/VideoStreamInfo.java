package com.tencent.mobileqq.zplan.video.api.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/video/api/bean/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "mediaUrl", "I", "()I", "mediaLevel", "<init>", "(Ljava/lang/String;I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.video.api.bean.f, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class VideoStreamInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String mediaUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int mediaLevel;

    public VideoStreamInfo(String mediaUrl, int i3) {
        Intrinsics.checkNotNullParameter(mediaUrl, "mediaUrl");
        this.mediaUrl = mediaUrl;
        this.mediaLevel = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getMediaLevel() {
        return this.mediaLevel;
    }

    /* renamed from: b, reason: from getter */
    public final String getMediaUrl() {
        return this.mediaUrl;
    }

    public int hashCode() {
        return (this.mediaUrl.hashCode() * 31) + this.mediaLevel;
    }

    public String toString() {
        return "VideoStreamInfo(mediaUrl=" + this.mediaUrl + ", mediaLevel=" + this.mediaLevel + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoStreamInfo)) {
            return false;
        }
        VideoStreamInfo videoStreamInfo = (VideoStreamInfo) other;
        return Intrinsics.areEqual(this.mediaUrl, videoStreamInfo.mediaUrl) && this.mediaLevel == videoStreamInfo.mediaLevel;
    }
}
