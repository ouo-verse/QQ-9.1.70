package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProMVPChannelContent implements Serializable {
    public long channelId;
    public String channelName;
    public long guildId;
    long serialVersionUID;

    public GProMVPChannelContent() {
        this.serialVersionUID = 1L;
        this.channelName = "";
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProMVPChannelContent{guildId=" + this.guildId + ",channelId=" + this.channelId + ",channelName=" + this.channelName + ",}";
    }

    public GProMVPChannelContent(long j3, long j16, String str) {
        this.serialVersionUID = 1L;
        this.guildId = j3;
        this.channelId = j16;
        this.channelName = str;
    }
}
