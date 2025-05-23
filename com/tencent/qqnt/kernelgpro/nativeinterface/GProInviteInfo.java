package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProInviteInfo {
    public long chnId;
    public long guildId;
    public String name = "";
    public String base64Avatar = "";
    public String joinSig = "";
    public String nickName = "";
    public String inviteUrl = "";

    public String getBase64Avatar() {
        return this.base64Avatar;
    }

    public long getChnId() {
        return this.chnId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getInviteUrl() {
        return this.inviteUrl;
    }

    public String getJoinSig() {
        return this.joinSig;
    }

    public String getName() {
        return this.name;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String toString() {
        return "GProInviteInfo{guildId=" + this.guildId + ",chnId=" + this.chnId + ",name=" + this.name + ",base64Avatar=" + this.base64Avatar + ",joinSig=" + this.joinSig + ",nickName=" + this.nickName + ",inviteUrl=" + this.inviteUrl + ",}";
    }
}
