package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProChannelUserChangeInfo implements Serializable {
    public ArrayList<GProUser> changeUserList;
    public long channelId;
    public GProChannelUserNum channelUserNum;
    public long guildId;
    long serialVersionUID;

    public GProChannelUserChangeInfo() {
        this.serialVersionUID = 1L;
        this.changeUserList = new ArrayList<>();
        this.channelUserNum = new GProChannelUserNum();
    }

    public ArrayList<GProUser> getChangeUserList() {
        return this.changeUserList;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public GProChannelUserNum getChannelUserNum() {
        return this.channelUserNum;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProChannelUserChangeInfo{guildId=" + this.guildId + ",channelId=" + this.channelId + ",changeUserList=" + this.changeUserList + ",channelUserNum=" + this.channelUserNum + ",}";
    }

    public GProChannelUserChangeInfo(long j3, long j16, ArrayList<GProUser> arrayList, GProChannelUserNum gProChannelUserNum) {
        this.serialVersionUID = 1L;
        this.changeUserList = new ArrayList<>();
        new GProChannelUserNum();
        this.guildId = j3;
        this.channelId = j16;
        this.changeUserList = arrayList;
        this.channelUserNum = gProChannelUserNum;
    }
}
