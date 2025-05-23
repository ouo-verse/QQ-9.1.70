package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ChatCacheDeleteInfo {
    public long chatSize;
    public int chatType;
    public String uid;

    public ChatCacheDeleteInfo() {
        this.uid = "";
    }

    public long getChatSize() {
        return this.chatSize;
    }

    public int getChatType() {
        return this.chatType;
    }

    public String getUid() {
        return this.uid;
    }

    public ChatCacheDeleteInfo(int i3, long j3, String str) {
        this.chatType = i3;
        this.chatSize = j3;
        this.uid = str;
    }
}
