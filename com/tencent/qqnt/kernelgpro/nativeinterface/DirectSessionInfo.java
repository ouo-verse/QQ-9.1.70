package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class DirectSessionInfo {
    public String channelId;
    public String guildId;
    public boolean informationFull;
    public String memberName;
    public int memberType;
    public MsgAbstract msgAbstract;
    public long msgSeq;
    public long msgTime;
    public String nickName;
    public int notifyType;
    public int sendStatus;
    public long srcGuildId;
    public String srcGuildName;
    public long tinyId;

    public DirectSessionInfo() {
        this.guildId = "";
        this.channelId = "";
        this.msgAbstract = new MsgAbstract();
        this.srcGuildName = "";
        this.nickName = "";
        this.memberName = "";
    }

    public String getChannelId() {
        return this.channelId;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public boolean getInformationFull() {
        return this.informationFull;
    }

    public String getMemberName() {
        return this.memberName;
    }

    public int getMemberType() {
        return this.memberType;
    }

    public MsgAbstract getMsgAbstract() {
        return this.msgAbstract;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public long getMsgTime() {
        return this.msgTime;
    }

    public String getNickName() {
        return this.nickName;
    }

    public int getNotifyType() {
        return this.notifyType;
    }

    public int getSendStatus() {
        return this.sendStatus;
    }

    public long getSrcGuildId() {
        return this.srcGuildId;
    }

    public String getSrcGuildName() {
        return this.srcGuildName;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "DirectSessionInfo{guildId=" + this.guildId + ",channelId=" + this.channelId + ",msgTime=" + this.msgTime + ",msgSeq=" + this.msgSeq + ",sendStatus=" + this.sendStatus + ",msgAbstract=" + this.msgAbstract + ",tinyId=" + this.tinyId + ",srcGuildId=" + this.srcGuildId + ",srcGuildName=" + this.srcGuildName + ",nickName=" + this.nickName + ",memberName=" + this.memberName + ",notifyType=" + this.notifyType + ",memberType=" + this.memberType + ",informationFull=" + this.informationFull + ",}";
    }

    public DirectSessionInfo(String str, String str2, long j3, long j16, int i3, MsgAbstract msgAbstract, long j17, long j18, String str3, String str4, String str5, int i16, int i17, boolean z16) {
        this.guildId = "";
        this.channelId = "";
        new MsgAbstract();
        this.guildId = str;
        this.channelId = str2;
        this.msgTime = j3;
        this.msgSeq = j16;
        this.sendStatus = i3;
        this.msgAbstract = msgAbstract;
        this.tinyId = j17;
        this.srcGuildId = j18;
        this.srcGuildName = str3;
        this.nickName = str4;
        this.memberName = str5;
        this.notifyType = i16;
        this.memberType = i17;
        this.informationFull = z16;
    }
}
