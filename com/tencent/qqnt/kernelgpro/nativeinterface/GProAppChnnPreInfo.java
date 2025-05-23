package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProAppChnnPreInfo {
    public long appid;
    public long channelId;
    public long guildId;
    public int jumpType;
    public int nextTimeStamp;
    public int result;
    public String jumpUrl = "";
    public String text = "";
    public ArrayList<GProChannelPresenceInfo> chnnPreList = new ArrayList<>();
    public String chnnPreSeq = "";
    public GProJoinCondition joinCondition = new GProJoinCondition();

    public long getAppid() {
        return this.appid;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public ArrayList<GProChannelPresenceInfo> getChnnPreList() {
        return this.chnnPreList;
    }

    public String getChnnPreSeq() {
        return this.chnnPreSeq;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public GProJoinCondition getJoinCondition() {
        return this.joinCondition;
    }

    public int getJumpType() {
        return this.jumpType;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public int getNextTimeStamp() {
        return this.nextTimeStamp;
    }

    public int getResult() {
        return this.result;
    }

    public String getText() {
        return this.text;
    }

    public String toString() {
        return "GProAppChnnPreInfo{guildId=" + this.guildId + ",channelId=" + this.channelId + ",appid=" + this.appid + ",result=" + this.result + ",jumpUrl=" + this.jumpUrl + ",jumpType=" + this.jumpType + ",text=" + this.text + ",chnnPreList=" + this.chnnPreList + ",chnnPreSeq=" + this.chnnPreSeq + ",nextTimeStamp=" + this.nextTimeStamp + ",joinCondition=" + this.joinCondition + ",}";
    }
}
