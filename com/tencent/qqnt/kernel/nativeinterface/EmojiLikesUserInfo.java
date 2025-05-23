package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class EmojiLikesUserInfo {
    public String headUrl;
    public String nickName;
    public long tinyId;

    public EmojiLikesUserInfo() {
        this.nickName = "";
        this.headUrl = "";
    }

    public String getHeadUrl() {
        return this.headUrl;
    }

    public String getNickName() {
        return this.nickName;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "EmojiLikesUserInfo{tinyId=" + this.tinyId + ",nickName=" + this.nickName + ",headUrl=" + this.headUrl + ",}";
    }

    public EmojiLikesUserInfo(long j3, String str, String str2) {
        this.tinyId = j3;
        this.nickName = str;
        this.headUrl = str2;
    }
}
