package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProCommThirdVideoInfo implements Serializable {
    public long duration;
    long serialVersionUID = 1;
    public String cover = "";
    public String jumpUrl = "";
    public String pcJumpUrl = "";

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

    public String toString() {
        return "GProCommThirdVideoInfo{cover=" + this.cover + ",duration=" + this.duration + ",jumpUrl=" + this.jumpUrl + ",pcJumpUrl=" + this.pcJumpUrl + ",}";
    }
}
