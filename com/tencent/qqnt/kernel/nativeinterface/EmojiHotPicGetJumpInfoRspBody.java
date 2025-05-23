package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class EmojiHotPicGetJumpInfoRspBody {
    public String emojiName;
    public String jumpDesc;
    public String jumpIcon;
    public int jumpId;
    public String jumpUrl;

    public EmojiHotPicGetJumpInfoRspBody() {
    }

    public String getEmojiName() {
        return this.emojiName;
    }

    public String getJumpDesc() {
        return this.jumpDesc;
    }

    public String getJumpIcon() {
        return this.jumpIcon;
    }

    public int getJumpId() {
        return this.jumpId;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public EmojiHotPicGetJumpInfoRspBody(int i3, String str, String str2, String str3, String str4) {
        this.jumpId = i3;
        this.jumpDesc = str;
        this.jumpUrl = str2;
        this.jumpIcon = str3;
        this.emojiName = str4;
    }
}
