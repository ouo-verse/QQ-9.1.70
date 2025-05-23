package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsStIconDecorate {
    public long endTime;
    public String mainpageUrl = "";
    public String layerUrl = "";

    /* renamed from: id, reason: collision with root package name */
    public String f359233id = "";
    public String commentUrl = "";
    public UfsDecorateJumpInfo jumpInfo = new UfsDecorateJumpInfo();

    public String getCommentUrl() {
        return this.commentUrl;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public String getId() {
        return this.f359233id;
    }

    public UfsDecorateJumpInfo getJumpInfo() {
        return this.jumpInfo;
    }

    public String getLayerUrl() {
        return this.layerUrl;
    }

    public String getMainpageUrl() {
        return this.mainpageUrl;
    }

    public String toString() {
        return "UfsStIconDecorate{mainpageUrl=" + this.mainpageUrl + ",layerUrl=" + this.layerUrl + ",endTime=" + this.endTime + ",id=" + this.f359233id + ",commentUrl=" + this.commentUrl + ",jumpInfo=" + this.jumpInfo + ",}";
    }
}
