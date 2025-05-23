package com.tencent.qqnt.kernelpublic.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ChannelStateElement implements Serializable {
    public ArrayList<ChannStateItemInfo> channStateList;
    public long channelId;
    public int channelState;
    public long channelStateReq;
    public String firstMemberDisplayName;
    public long firstMemberTinyid;
    public long guildId;
    public int guildState;
    public int memberCount;
    public int memberMax;
    public long roomId;
    public String roomTitle;
    long serialVersionUID;
    public long updateTime;

    public ChannelStateElement() {
        this.serialVersionUID = 1L;
        this.firstMemberDisplayName = "";
        this.roomTitle = "";
        this.channStateList = new ArrayList<>();
    }

    public ArrayList<ChannStateItemInfo> getChannStateList() {
        return this.channStateList;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getChannelState() {
        return this.channelState;
    }

    public long getChannelStateReq() {
        return this.channelStateReq;
    }

    public String getFirstMemberDisplayName() {
        return this.firstMemberDisplayName;
    }

    public long getFirstMemberTinyid() {
        return this.firstMemberTinyid;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getGuildState() {
        return this.guildState;
    }

    public int getMemberCount() {
        return this.memberCount;
    }

    public int getMemberMax() {
        return this.memberMax;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public String getRoomTitle() {
        return this.roomTitle;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public String toString() {
        return "ChannelStateElement{guildId=" + this.guildId + ",channelId=" + this.channelId + ",memberCount=" + this.memberCount + ",memberMax=" + this.memberMax + ",firstMemberTinyid=" + this.firstMemberTinyid + ",firstMemberDisplayName=" + this.firstMemberDisplayName + ",guildState=" + this.guildState + ",channelState=" + this.channelState + ",channelStateReq=" + this.channelStateReq + ",updateTime=" + this.updateTime + ",roomId=" + this.roomId + ",roomTitle=" + this.roomTitle + ",channStateList=" + this.channStateList + ",}";
    }

    public ChannelStateElement(long j3, long j16, int i3, int i16, long j17, String str, int i17, int i18, long j18, long j19, long j26, String str2, ArrayList<ChannStateItemInfo> arrayList) {
        this.serialVersionUID = 1L;
        this.firstMemberDisplayName = "";
        this.roomTitle = "";
        new ArrayList();
        this.guildId = j3;
        this.channelId = j16;
        this.memberCount = i3;
        this.memberMax = i16;
        this.firstMemberTinyid = j17;
        this.firstMemberDisplayName = str;
        this.guildState = i17;
        this.channelState = i18;
        this.channelStateReq = j18;
        this.updateTime = j19;
        this.roomId = j26;
        this.roomTitle = str2;
        this.channStateList = arrayList;
    }
}
