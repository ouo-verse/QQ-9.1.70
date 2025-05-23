package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class EmojiHotPicGetJumpInfoReqBody {
    public String emojiMd5;
    public int jumpId;
    public int srcType;

    public EmojiHotPicGetJumpInfoReqBody() {
        this.emojiMd5 = "";
    }

    public String getEmojiMd5() {
        return this.emojiMd5;
    }

    public int getJumpId() {
        return this.jumpId;
    }

    public int getSrcType() {
        return this.srcType;
    }

    public EmojiHotPicGetJumpInfoReqBody(int i3, String str, int i16) {
        this.jumpId = i3;
        this.emojiMd5 = str;
        this.srcType = i16;
    }
}
