package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProMVPThirdVideoInfo implements Serializable {
    public String cover;
    public long duration;
    public String jumpUrl;
    public String pcJumpUrl;
    public String playUrl;
    long serialVersionUID;

    public GProMVPThirdVideoInfo() {
        this.serialVersionUID = 1L;
        this.cover = "";
        this.playUrl = "";
        this.jumpUrl = "";
        this.pcJumpUrl = "";
    }

    public String getCover() {
        return this.cover;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getPcJumpUrl() {
        return this.pcJumpUrl;
    }

    public String getPlayUrl() {
        return this.playUrl;
    }

    public String toString() {
        return "GProMVPThirdVideoInfo{cover=" + this.cover + ",duration=" + this.duration + ",playUrl=" + this.playUrl + ",jumpUrl=" + this.jumpUrl + ",pcJumpUrl=" + this.pcJumpUrl + ",}";
    }

    public GProMVPThirdVideoInfo(String str, long j3, String str2) {
        this.serialVersionUID = 1L;
        this.jumpUrl = "";
        this.pcJumpUrl = "";
        this.cover = str;
        this.duration = j3;
        this.playUrl = str2;
    }
}
