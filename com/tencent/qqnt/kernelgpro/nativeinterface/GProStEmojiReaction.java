package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProStEmojiReaction implements Serializable {
    public long cnt;
    public long emojiType;
    public boolean isClicked;
    public boolean isDefaultEmoji;
    long serialVersionUID = 1;
    public String emojiId = "";

    public long getCnt() {
        return this.cnt;
    }

    public String getEmojiId() {
        return this.emojiId;
    }

    public long getEmojiType() {
        return this.emojiType;
    }

    public boolean getIsClicked() {
        return this.isClicked;
    }

    public boolean getIsDefaultEmoji() {
        return this.isDefaultEmoji;
    }

    public String toString() {
        return "GProStEmojiReaction{emojiId=" + this.emojiId + ",emojiType=" + this.emojiType + ",cnt=" + this.cnt + ",isClicked=" + this.isClicked + ",isDefaultEmoji=" + this.isDefaultEmoji + ",}";
    }
}
