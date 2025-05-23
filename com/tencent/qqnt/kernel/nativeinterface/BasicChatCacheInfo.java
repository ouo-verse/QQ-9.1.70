package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BasicChatCacheInfo {
    public long chatSize;
    public long chatTime;
    public String nickName;
    public String remarkName;
    public String uid;
    public long uin;

    public BasicChatCacheInfo() {
        this.uid = "";
        this.remarkName = "";
        this.nickName = "";
    }

    public long getChatSize() {
        return this.chatSize;
    }

    public long getChatTime() {
        return this.chatTime;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getRemarkName() {
        return this.remarkName;
    }

    public String getUid() {
        return this.uid;
    }

    public long getUin() {
        return this.uin;
    }

    public BasicChatCacheInfo(long j3, long j16, String str, long j17, String str2, String str3) {
        this.chatSize = j3;
        this.chatTime = j16;
        this.uid = str;
        this.uin = j17;
        this.remarkName = str2;
        this.nickName = str3;
    }
}
