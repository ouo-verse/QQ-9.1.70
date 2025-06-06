package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class GetBaseEmojiPathReq {
    public String emojiId = "";
    public BaseEmojiType type = BaseEmojiType.values()[0];

    public String getEmojiId() {
        return this.emojiId;
    }

    public BaseEmojiType getType() {
        return this.type;
    }

    public String toString() {
        return "GetBaseEmojiPathReq{emojiId=" + this.emojiId + ",type=" + this.type + ",}";
    }
}
