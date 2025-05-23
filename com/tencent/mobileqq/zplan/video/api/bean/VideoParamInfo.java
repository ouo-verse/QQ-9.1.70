package com.tencent.mobileqq.zplan.video.api.bean;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u000f\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zplan/video/api/bean/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "cidUrl", "b", "c", "f", "vidUrl", "I", "()I", "e", "(I)V", WidgetCacheConstellationData.INTERVAL, "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.video.api.bean.d, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class VideoParamInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private String cidUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String vidUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int interval;

    public VideoParamInfo(String cidUrl, String vidUrl, int i3) {
        Intrinsics.checkNotNullParameter(cidUrl, "cidUrl");
        Intrinsics.checkNotNullParameter(vidUrl, "vidUrl");
        this.cidUrl = cidUrl;
        this.vidUrl = vidUrl;
        this.interval = i3;
    }

    /* renamed from: a, reason: from getter */
    public final String getCidUrl() {
        return this.cidUrl;
    }

    /* renamed from: b, reason: from getter */
    public final int getInterval() {
        return this.interval;
    }

    /* renamed from: c, reason: from getter */
    public final String getVidUrl() {
        return this.vidUrl;
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cidUrl = str;
    }

    public final void e(int i3) {
        this.interval = i3;
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.vidUrl = str;
    }

    public int hashCode() {
        return (((this.cidUrl.hashCode() * 31) + this.vidUrl.hashCode()) * 31) + this.interval;
    }

    public String toString() {
        return "VideoParamInfo(cidUrl=" + this.cidUrl + ", vidUrl=" + this.vidUrl + ", interval=" + this.interval + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoParamInfo)) {
            return false;
        }
        VideoParamInfo videoParamInfo = (VideoParamInfo) other;
        return Intrinsics.areEqual(this.cidUrl, videoParamInfo.cidUrl) && Intrinsics.areEqual(this.vidUrl, videoParamInfo.vidUrl) && this.interval == videoParamInfo.interval;
    }
}
