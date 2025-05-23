package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProBlackUserInfo {
    public String avatarUrl;
    public String nickName;
    public long tinyId;

    public GProBlackUserInfo() {
        this.nickName = "";
        this.avatarUrl = "";
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public String getNickName() {
        return this.nickName;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProBlackUserInfo{tinyId=" + this.tinyId + ",nickName=" + this.nickName + ",avatarUrl=" + this.avatarUrl + ",}";
    }

    public GProBlackUserInfo(long j3, String str, String str2) {
        this.tinyId = j3;
        this.nickName = str;
        this.avatarUrl = str2;
    }
}
