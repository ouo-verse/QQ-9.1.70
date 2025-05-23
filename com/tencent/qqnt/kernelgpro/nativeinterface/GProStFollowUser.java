package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProStFollowUser {
    public String nick = "";
    public long uid;

    public String getNick() {
        return this.nick;
    }

    public long getUid() {
        return this.uid;
    }

    public String toString() {
        return "GProStFollowUser{uid=" + this.uid + ",nick=" + this.nick + ",}";
    }
}
