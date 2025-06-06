package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class EmojiUseInfo {
    public String emojiId;
    public int emojiType;
    public long updateTime;
    public int usedCount;

    public EmojiUseInfo() {
        this.emojiId = "";
    }

    public String getEmojiId() {
        return this.emojiId;
    }

    public int getEmojiType() {
        return this.emojiType;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public int getUsedCount() {
        return this.usedCount;
    }

    public String toString() {
        return "EmojiUseInfo{updateTime=" + this.updateTime + ",usedCount=" + this.usedCount + ",emojiType=" + this.emojiType + ",emojiId=" + this.emojiId + ",}";
    }

    public EmojiUseInfo(long j3, int i3, int i16, String str) {
        this.updateTime = j3;
        this.usedCount = i3;
        this.emojiType = i16;
        this.emojiId = str;
    }
}
