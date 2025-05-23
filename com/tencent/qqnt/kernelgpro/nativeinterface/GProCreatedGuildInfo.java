package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProCreatedGuildInfo {
    public long createTime;
    public long guildId;
    public long guildOwnerUin;
    public long memberNum;
    public String guildName = "";
    public String faceUrl = "";

    public long getCreateTime() {
        return this.createTime;
    }

    public String getFaceUrl() {
        return this.faceUrl;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public long getGuildOwnerUin() {
        return this.guildOwnerUin;
    }

    public long getMemberNum() {
        return this.memberNum;
    }

    public String toString() {
        return "GProCreatedGuildInfo{guildOwnerUin=" + this.guildOwnerUin + ",guildId=" + this.guildId + ",guildName=" + this.guildName + ",createTime=" + this.createTime + ",memberNum=" + this.memberNum + ",faceUrl=" + this.faceUrl + ",}";
    }
}
