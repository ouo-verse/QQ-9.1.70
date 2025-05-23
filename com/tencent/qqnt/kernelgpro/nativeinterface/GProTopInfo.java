package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProTopInfo implements Serializable {
    public long channelTopOperatorTinyid;
    public long channelTopTimestamp;
    public long operatorTinyidNew;
    long serialVersionUID = 1;
    public long topTimestamp;

    public long getChannelTopOperatorTinyid() {
        return this.channelTopOperatorTinyid;
    }

    public long getChannelTopTimestamp() {
        return this.channelTopTimestamp;
    }

    public long getOperatorTinyidNew() {
        return this.operatorTinyidNew;
    }

    public long getTopTimestamp() {
        return this.topTimestamp;
    }

    public String toString() {
        return "GProTopInfo{topTimestamp=" + this.topTimestamp + ",operatorTinyidNew=" + this.operatorTinyidNew + ",channelTopTimestamp=" + this.channelTopTimestamp + ",channelTopOperatorTinyid=" + this.channelTopOperatorTinyid + ",}";
    }
}
