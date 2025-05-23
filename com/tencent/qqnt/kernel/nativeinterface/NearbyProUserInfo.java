package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class NearbyProUserInfo {
    public String avatarUrl;
    public String nick;
    public long tinyId;

    public NearbyProUserInfo() {
        this.nick = "";
        this.avatarUrl = "";
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public String getNick() {
        return this.nick;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "NearbyProUserInfo{tinyId=" + this.tinyId + ",nick=" + this.nick + ",avatarUrl=" + this.avatarUrl + ",}";
    }

    public NearbyProUserInfo(long j3, String str, String str2) {
        this.tinyId = j3;
        this.nick = str;
        this.avatarUrl = str2;
    }
}
