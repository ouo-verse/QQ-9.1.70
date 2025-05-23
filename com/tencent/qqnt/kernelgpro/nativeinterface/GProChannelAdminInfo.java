package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProChannelAdminInfo {
    public long channelAdminNum;
    public long channelId;
    public String channelName = "";
    public int channelType;

    public long getChannelAdminNum() {
        return this.channelAdminNum;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public String toString() {
        return "GProChannelAdminInfo{channelId=" + this.channelId + ",channelName=" + this.channelName + ",channelType=" + this.channelType + ",channelAdminNum=" + this.channelAdminNum + ",}";
    }
}
