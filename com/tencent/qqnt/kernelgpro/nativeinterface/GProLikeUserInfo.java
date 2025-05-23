package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProLikeUserInfo {
    public long idd;
    public String nick = "";
    public String avatar = "";
    public String avatarPendant = "";

    public String getAvatar() {
        return this.avatar;
    }

    public String getAvatarPendant() {
        return this.avatarPendant;
    }

    public long getIdd() {
        return this.idd;
    }

    public String getNick() {
        return this.nick;
    }

    public String toString() {
        return "GProLikeUserInfo{idd=" + this.idd + ",nick=" + this.nick + ",avatar=" + this.avatar + ",avatarPendant=" + this.avatarPendant + ",}";
    }
}
