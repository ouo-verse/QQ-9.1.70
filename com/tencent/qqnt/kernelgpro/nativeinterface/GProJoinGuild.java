package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProJoinGuild implements Serializable {
    public long channelId;
    public long faceSeq;
    public long guildId;
    public int status;
    public long timeStamp;
    long serialVersionUID = 1;
    public String guildName = "";

    public long getChannelId() {
        return this.channelId;
    }

    public long getFaceSeq() {
        return this.faceSeq;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public int getStatus() {
        return this.status;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setChannelId(long j3) {
        this.channelId = j3;
    }

    public void setFaceSeq(long j3) {
        this.faceSeq = j3;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setGuildName(String str) {
        this.guildName = str;
    }

    public void setStatus(int i3) {
        this.status = i3;
    }

    public void setTimeStamp(long j3) {
        this.timeStamp = j3;
    }

    public String toString() {
        return "GProJoinGuild{guildId=" + this.guildId + ",guildName=" + this.guildName + ",faceSeq=" + this.faceSeq + ",status=" + this.status + ",timeStamp=" + this.timeStamp + ",channelId=" + this.channelId + ",}";
    }
}
