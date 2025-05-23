package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TofuActionButton {
    public int emojiId;
    public int emojiType;
    public String text = "";

    public int getEmojiId() {
        return this.emojiId;
    }

    public int getEmojiType() {
        return this.emojiType;
    }

    public String getText() {
        return this.text;
    }

    public String toString() {
        return "TofuActionButton{emojiType=" + this.emojiType + ",emojiId=" + this.emojiId + ",text=" + this.text + ",}";
    }
}
