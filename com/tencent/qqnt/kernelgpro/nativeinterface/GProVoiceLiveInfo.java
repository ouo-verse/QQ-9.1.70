package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProVoiceLiveInfo implements Serializable {
    public long channelId;
    public int channelType;
    public long guildId;
    long serialVersionUID = 1;
    public byte[] channelName = new byte[0];
    public String mainSource = "";
    public String subSource = "";
    public byte[] joinGuildSig = new byte[0];
    public ArrayList<GProFeedChannelStateInfo> channelStatusList = new ArrayList<>();

    public long getChannelId() {
        return this.channelId;
    }

    public byte[] getChannelName() {
        return this.channelName;
    }

    public ArrayList<GProFeedChannelStateInfo> getChannelStatusList() {
        return this.channelStatusList;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public byte[] getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public String getMainSource() {
        return this.mainSource;
    }

    public String getSubSource() {
        return this.subSource;
    }

    public String toString() {
        return "GProVoiceLiveInfo{guildId=" + this.guildId + ",channelId=" + this.channelId + ",channelType=" + this.channelType + ",channelName=" + this.channelName + ",mainSource=" + this.mainSource + ",subSource=" + this.subSource + ",joinGuildSig=" + this.joinGuildSig + ",channelStatusList=" + this.channelStatusList + ",}";
    }
}
