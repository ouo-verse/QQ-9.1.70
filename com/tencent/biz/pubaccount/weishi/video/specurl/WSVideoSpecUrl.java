package com.tencent.biz.pubaccount.weishi.video.specurl;

import NS_KING_SOCIALIZE_META.VideoSpecUrl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/video/specurl/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "LNS_KING_SOCIALIZE_META/VideoSpecUrl;", "a", "LNS_KING_SOCIALIZE_META/VideoSpecUrl;", "c", "()LNS_KING_SOCIALIZE_META/VideoSpecUrl;", "videoSpecUrl", "b", "I", "()I", "decodeStrategyType", "selectedSpecReason", "<init>", "(LNS_KING_SOCIALIZE_META/VideoSpecUrl;II)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.pubaccount.weishi.video.specurl.c, reason: from toString */
/* loaded from: classes32.dex */
public final /* data */ class WSVideoSpecUrl {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final VideoSpecUrl videoSpecUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int decodeStrategyType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int selectedSpecReason;

    public WSVideoSpecUrl(VideoSpecUrl videoSpecUrl, int i3, int i16) {
        Intrinsics.checkNotNullParameter(videoSpecUrl, "videoSpecUrl");
        this.videoSpecUrl = videoSpecUrl;
        this.decodeStrategyType = i3;
        this.selectedSpecReason = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getDecodeStrategyType() {
        return this.decodeStrategyType;
    }

    /* renamed from: b, reason: from getter */
    public final int getSelectedSpecReason() {
        return this.selectedSpecReason;
    }

    /* renamed from: c, reason: from getter */
    public final VideoSpecUrl getVideoSpecUrl() {
        return this.videoSpecUrl;
    }

    public int hashCode() {
        return (((this.videoSpecUrl.hashCode() * 31) + this.decodeStrategyType) * 31) + this.selectedSpecReason;
    }

    public String toString() {
        return "WSVideoSpecUrl(videoSpecUrl=" + this.videoSpecUrl + ", decodeStrategyType=" + this.decodeStrategyType + ", selectedSpecReason=" + this.selectedSpecReason + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WSVideoSpecUrl)) {
            return false;
        }
        WSVideoSpecUrl wSVideoSpecUrl = (WSVideoSpecUrl) other;
        return Intrinsics.areEqual(this.videoSpecUrl, wSVideoSpecUrl.videoSpecUrl) && this.decodeStrategyType == wSVideoSpecUrl.decodeStrategyType && this.selectedSpecReason == wSVideoSpecUrl.selectedSpecReason;
    }
}
