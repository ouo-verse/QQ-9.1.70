package com.tencent.qqnt.kernelpublic.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class EmojiReplyElement implements Serializable {
    public int emojiId;
    public int emojiType;
    public long msgId;
    public long msgSeq;
    long serialVersionUID = 1;
    public long tinyId;

    public EmojiReplyElement() {
    }

    public int getEmojiId() {
        return this.emojiId;
    }

    public int getEmojiType() {
        return this.emojiType;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "EmojiReplyElement{tinyId=" + this.tinyId + ",msgSeq=" + this.msgSeq + ",msgId=" + this.msgId + ",emojiId=" + this.emojiId + ",emojiType=" + this.emojiType + ",}";
    }

    public EmojiReplyElement(long j3, long j16, long j17, int i3, int i16) {
        this.tinyId = j3;
        this.msgSeq = j16;
        this.msgId = j17;
        this.emojiId = i3;
        this.emojiType = i16;
    }
}
