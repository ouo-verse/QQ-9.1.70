package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AiGenAvatarReq {
    public int avatarNum;
    public String avatarPrompt = "";
    public MyBotInfo myBotInfo = new MyBotInfo();

    public int getAvatarNum() {
        return this.avatarNum;
    }

    public String getAvatarPrompt() {
        return this.avatarPrompt;
    }

    public MyBotInfo getMyBotInfo() {
        return this.myBotInfo;
    }

    public String toString() {
        return "AiGenAvatarReq{avatarPrompt=" + this.avatarPrompt + ",avatarNum=" + this.avatarNum + ",myBotInfo=" + this.myBotInfo + ",}";
    }
}
