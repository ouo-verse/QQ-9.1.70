package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProDirectMsgDetailSession {
    public long channelId;
    public long createTime;
    public long guildId;
    public long lastCntSeq;
    public long lastCntTime;
    public long lastMsgSeq;
    public long lastMsgTime;
    public long msgEventTime;
    public int msgNotifyType;
    public long myReadCntSeq;
    public long myReadCntTime;
    public long myReadMsgSeq;
    public long myReadMsgTime;
    public long srcGuildId;
    public int srcMemberType;
    public long srcTinyId;
    public String srcGuildName = "";
    public String srcMemberName = "";
    public String srcNickName = "";

    public long getChannelId() {
        return this.channelId;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getLastCntSeq() {
        return this.lastCntSeq;
    }

    public long getLastCntTime() {
        return this.lastCntTime;
    }

    public long getLastMsgSeq() {
        return this.lastMsgSeq;
    }

    public long getLastMsgTime() {
        return this.lastMsgTime;
    }

    public long getMsgEventTime() {
        return this.msgEventTime;
    }

    public int getMsgNotifyType() {
        return this.msgNotifyType;
    }

    public long getMyReadCntSeq() {
        return this.myReadCntSeq;
    }

    public long getMyReadCntTime() {
        return this.myReadCntTime;
    }

    public long getMyReadMsgSeq() {
        return this.myReadMsgSeq;
    }

    public long getMyReadMsgTime() {
        return this.myReadMsgTime;
    }

    public long getSrcGuildId() {
        return this.srcGuildId;
    }

    public String getSrcGuildName() {
        return this.srcGuildName;
    }

    public String getSrcMemberName() {
        return this.srcMemberName;
    }

    public int getSrcMemberType() {
        return this.srcMemberType;
    }

    public String getSrcNickName() {
        return this.srcNickName;
    }

    public long getSrcTinyId() {
        return this.srcTinyId;
    }

    public String toString() {
        return "GProDirectMsgDetailSession{guildId=" + this.guildId + ",channelId=" + this.channelId + ",msgNotifyType=" + this.msgNotifyType + ",myReadMsgSeq=" + this.myReadMsgSeq + ",myReadMsgTime=" + this.myReadMsgTime + ",myReadCntSeq=" + this.myReadCntSeq + ",myReadCntTime=" + this.myReadCntTime + ",lastMsgSeq=" + this.lastMsgSeq + ",lastMsgTime=" + this.lastMsgTime + ",lastCntSeq=" + this.lastCntSeq + ",lastCntTime=" + this.lastCntTime + ",srcTinyId=" + this.srcTinyId + ",srcGuildId=" + this.srcGuildId + ",srcGuildName=" + this.srcGuildName + ",srcMemberName=" + this.srcMemberName + ",srcNickName=" + this.srcNickName + ",srcMemberType=" + this.srcMemberType + ",msgEventTime=" + this.msgEventTime + ",createTime=" + this.createTime + ",}";
    }
}
