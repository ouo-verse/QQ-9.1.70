package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class EmojiHotPicSearchBoundingBox {
    public EmojiHotPicSearchPoint bottomRight;
    public EmojiHotPicSearchPoint topLeft;

    public EmojiHotPicSearchBoundingBox() {
    }

    public EmojiHotPicSearchPoint getBottomRight() {
        return this.bottomRight;
    }

    public EmojiHotPicSearchPoint getTopLeft() {
        return this.topLeft;
    }

    public EmojiHotPicSearchBoundingBox(EmojiHotPicSearchPoint emojiHotPicSearchPoint, EmojiHotPicSearchPoint emojiHotPicSearchPoint2) {
        this.topLeft = emojiHotPicSearchPoint;
        this.bottomRight = emojiHotPicSearchPoint2;
    }
}
