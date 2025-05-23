package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RecentUsedFace {
    public String emojiStr;
    public int faceIndex;
    public boolean isEmojiFace;

    public RecentUsedFace() {
        this.emojiStr = "";
    }

    public String getEmojiStr() {
        return this.emojiStr;
    }

    public int getFaceIndex() {
        return this.faceIndex;
    }

    public boolean getIsEmojiFace() {
        return this.isEmojiFace;
    }

    public String toString() {
        return "RecentUsedFace{isEmojiFace=" + this.isEmojiFace + ",faceIndex=" + this.faceIndex + ",emojiStr=" + this.emojiStr + ",}";
    }

    public RecentUsedFace(boolean z16, int i3, String str) {
        this.isEmojiFace = z16;
        this.faceIndex = i3;
        this.emojiStr = str;
    }
}
