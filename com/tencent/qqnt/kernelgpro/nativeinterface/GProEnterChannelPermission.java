package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProEnterChannelPermission implements Serializable {
    public boolean allowEnter;
    public boolean allowLive;
    public int liveType;
    public long msgSeq;
    long serialVersionUID = 1;
    public String disallowReason = "";
    public String disallowLiveReason = "";
    public String liveUrl = "";

    public boolean getAllowEnter() {
        return this.allowEnter;
    }

    public boolean getAllowLive() {
        return this.allowLive;
    }

    public String getDisallowLiveReason() {
        return this.disallowLiveReason;
    }

    public String getDisallowReason() {
        return this.disallowReason;
    }

    public int getLiveType() {
        return this.liveType;
    }

    public String getLiveUrl() {
        return this.liveUrl;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public String toString() {
        return "GProEnterChannelPermission{allowEnter=" + this.allowEnter + ",disallowReason=" + this.disallowReason + ",allowLive=" + this.allowLive + ",disallowLiveReason=" + this.disallowLiveReason + ",liveUrl=" + this.liveUrl + ",liveType=" + this.liveType + ",msgSeq=" + this.msgSeq + ",}";
    }
}
