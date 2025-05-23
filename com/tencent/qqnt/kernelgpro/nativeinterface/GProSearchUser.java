package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProSearchUser {
    public long tinyId;
    public String nick = "";
    public String avatar = "";

    public String getAvatar() {
        return this.avatar;
    }

    public String getNick() {
        return this.nick;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProSearchUser{nick=" + this.nick + ",tinyId=" + this.tinyId + ",avatar=" + this.avatar + ",}";
    }
}
