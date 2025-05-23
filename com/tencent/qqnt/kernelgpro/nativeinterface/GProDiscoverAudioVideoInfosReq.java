package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProDiscoverAudioVideoInfosReq {
    public String cookies;
    public GProBottomTabSourceInfo source;

    public GProDiscoverAudioVideoInfosReq() {
        this.source = new GProBottomTabSourceInfo();
        this.cookies = "";
    }

    public String getCookies() {
        return this.cookies;
    }

    public GProBottomTabSourceInfo getSource() {
        return this.source;
    }

    public String toString() {
        return "GProDiscoverAudioVideoInfosReq{source=" + this.source + ",cookies=" + this.cookies + ",}";
    }

    public GProDiscoverAudioVideoInfosReq(GProBottomTabSourceInfo gProBottomTabSourceInfo, String str) {
        new GProBottomTabSourceInfo();
        this.source = gProBottomTabSourceInfo;
        this.cookies = str;
    }
}
