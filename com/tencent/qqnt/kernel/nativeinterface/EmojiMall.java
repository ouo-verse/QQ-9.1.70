package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class EmojiMall {
    public int emojiId;
    public int packageId;

    public EmojiMall() {
    }

    public int getEmojiId() {
        return this.emojiId;
    }

    public int getPackageId() {
        return this.packageId;
    }

    public String toString() {
        return "EmojiMall{packageId=" + this.packageId + ",emojiId=" + this.emojiId + ",}";
    }

    public EmojiMall(int i3, int i16) {
        this.packageId = i3;
        this.emojiId = i16;
    }
}
