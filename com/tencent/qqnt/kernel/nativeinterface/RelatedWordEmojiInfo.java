package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RelatedWordEmojiInfo {
    public HashMap<String, DownloadRelateEmojiResultInfo> EmojiResultInfo;
    public ArrayList<String> emojiMd5s;
    public boolean isOver;
    public String word;

    public RelatedWordEmojiInfo() {
        this.word = "";
        this.emojiMd5s = new ArrayList<>();
        this.EmojiResultInfo = new HashMap<>();
    }

    public ArrayList<String> getEmojiMd5s() {
        return this.emojiMd5s;
    }

    public HashMap<String, DownloadRelateEmojiResultInfo> getEmojiResultInfo() {
        return this.EmojiResultInfo;
    }

    public boolean getIsOver() {
        return this.isOver;
    }

    public String getWord() {
        return this.word;
    }

    public String toString() {
        return "RelatedWordEmojiInfo{word=" + this.word + ",emojiMd5s=" + this.emojiMd5s + ",isOver=" + this.isOver + ",EmojiResultInfo=" + this.EmojiResultInfo + ",}";
    }

    public RelatedWordEmojiInfo(String str, ArrayList<String> arrayList, boolean z16, HashMap<String, DownloadRelateEmojiResultInfo> hashMap) {
        this.word = "";
        this.emojiMd5s = new ArrayList<>();
        new HashMap();
        this.word = str;
        this.emojiMd5s = arrayList;
        this.isOver = z16;
        this.EmojiResultInfo = hashMap;
    }
}
