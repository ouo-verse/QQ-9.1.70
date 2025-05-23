package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProFetchJoinGuildOptionReq {
    public long guildId;
    public String inviteCode = "";
    public String contentId = "";

    public GProFetchJoinGuildOptionReq() {
    }

    public String getContentId() {
        return this.contentId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getInviteCode() {
        return this.inviteCode;
    }

    public void setContentId(String str) {
        this.contentId = str;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setInviteCode(String str) {
        this.inviteCode = str;
    }

    public String toString() {
        return "GProFetchJoinGuildOptionReq{guildId=" + this.guildId + ",inviteCode=" + this.inviteCode + ",contentId=" + this.contentId + ",}";
    }

    public GProFetchJoinGuildOptionReq(long j3) {
        this.guildId = j3;
    }
}
