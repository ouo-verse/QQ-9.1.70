package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProBannerInfo implements Serializable {
    public long guildId;
    public String guildName;
    public String joinSig;
    long serialVersionUID;
    public String userAvatarMeta;
    public String userName;

    public GProBannerInfo() {
        this.serialVersionUID = 1L;
        this.guildName = "";
        this.userName = "";
        this.userAvatarMeta = "";
        this.joinSig = "";
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public String getJoinSig() {
        return this.joinSig;
    }

    public String getUserAvatarMeta() {
        return this.userAvatarMeta;
    }

    public String getUserName() {
        return this.userName;
    }

    public String toString() {
        return "GProBannerInfo{guildId=" + this.guildId + ",guildName=" + this.guildName + ",userName=" + this.userName + ",userAvatarMeta=" + this.userAvatarMeta + ",joinSig=" + this.joinSig + ",}";
    }

    public GProBannerInfo(long j3, String str, String str2, String str3, String str4) {
        this.serialVersionUID = 1L;
        this.guildId = j3;
        this.guildName = str;
        this.userName = str2;
        this.userAvatarMeta = str3;
        this.joinSig = str4;
    }
}
