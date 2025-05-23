package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProStChannelShareInfo implements Serializable {
    public long feedPublishAt;
    public long updateDurationMs;
    long serialVersionUID = 1;
    public String feedID = "";
    public String posterID = "";
    public GProStChannelSign channelSign = new GProStChannelSign();
    public GProStChannelShareSign sign = new GProStChannelShareSign();

    public GProStChannelSign getChannelSign() {
        return this.channelSign;
    }

    public String getFeedID() {
        return this.feedID;
    }

    public long getFeedPublishAt() {
        return this.feedPublishAt;
    }

    public String getPosterID() {
        return this.posterID;
    }

    public GProStChannelShareSign getSign() {
        return this.sign;
    }

    public long getUpdateDurationMs() {
        return this.updateDurationMs;
    }

    public String toString() {
        return "GProStChannelShareInfo{feedID=" + this.feedID + ",posterID=" + this.posterID + ",feedPublishAt=" + this.feedPublishAt + ",channelSign=" + this.channelSign + ",updateDurationMs=" + this.updateDurationMs + ",sign=" + this.sign + ",}";
    }
}
