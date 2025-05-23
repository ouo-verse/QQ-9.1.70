package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MsgEmojiLikes {
    public String emojiId;
    public long emojiType;
    public boolean isClicked;
    public long likesCnt;

    public MsgEmojiLikes() {
        this.emojiId = "";
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

    public long getLikesCnt() {
        return this.likesCnt;
    }

    public String toString() {
        return "MsgEmojiLikes{emojiId=" + this.emojiId + ",emojiType=" + this.emojiType + ",likesCnt=" + this.likesCnt + ",isClicked=" + this.isClicked + ",}";
    }

    public MsgEmojiLikes(String str, long j3, long j16, boolean z16) {
        this.emojiId = str;
        this.emojiType = j3;
        this.likesCnt = j16;
        this.isClicked = z16;
    }
}
