package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class EmojiHotPicHotWordsItem {
    public int itemType;
    public Integer searchNum;
    public String word;

    public EmojiHotPicHotWordsItem() {
    }

    public int getItemType() {
        return this.itemType;
    }

    public Integer getSearchNum() {
        return this.searchNum;
    }

    public String getWord() {
        return this.word;
    }

    public EmojiHotPicHotWordsItem(String str, Integer num, int i3) {
        this.word = str;
        this.searchNum = num;
        this.itemType = i3;
    }
}
