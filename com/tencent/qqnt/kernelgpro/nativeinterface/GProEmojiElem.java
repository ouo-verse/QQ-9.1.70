package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProEmojiElem implements Serializable {
    long serialVersionUID = 1;
    public GProStRichTextEmojiContent emojiContent = new GProStRichTextEmojiContent();

    public GProStRichTextEmojiContent getEmojiContent() {
        return this.emojiContent;
    }

    public String toString() {
        return "GProEmojiElem{emojiContent=" + this.emojiContent + ",}";
    }
}
