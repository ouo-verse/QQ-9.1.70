package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;
import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProStChannelSign implements Serializable {
    public long channelId;
    public int channelType;
    public long groupId;
    public long guildId;
    long serialVersionUID = 1;
    public String url = "";
    public String joinGuildSig = "";

    public long getChannelId() {
        return this.channelId;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProStChannelSign{guildId=" + this.guildId + ",channelId=" + this.channelId + JefsClass.INDEX_URL + this.url + ",joinGuildSig=" + this.joinGuildSig + ",groupId=" + this.groupId + ",channelType=" + this.channelType + ",}";
    }
}
