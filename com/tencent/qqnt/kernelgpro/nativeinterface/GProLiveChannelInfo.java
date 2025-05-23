package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProLiveChannelInfo implements Serializable {
    public long anchorTinyId;
    public long roomId;
    long serialVersionUID = 1;
    public String name = "";

    public long getAnchorTinyId() {
        return this.anchorTinyId;
    }

    public String getName() {
        return this.name;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public String toString() {
        return "GProLiveChannelInfo{roomId=" + this.roomId + ",anchorTinyId=" + this.anchorTinyId + ",name=" + this.name + ",}";
    }
}
