package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProTransThirdVideoURLRsp {
    public long duration;
    public String playUrl = "";
    public String cover = "";

    public String getCover() {
        return this.cover;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getPlayUrl() {
        return this.playUrl;
    }

    public String toString() {
        return "GProTransThirdVideoURLRsp{playUrl=" + this.playUrl + ",cover=" + this.cover + ",duration=" + this.duration + ",}";
    }
}
