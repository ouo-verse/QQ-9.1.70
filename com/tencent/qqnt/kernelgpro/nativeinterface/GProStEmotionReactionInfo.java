package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStEmotionReactionInfo implements Serializable {
    public long totalLikeCount;
    long serialVersionUID = 1;
    public String idd = "";
    public ArrayList<GProStEmojiReaction> emojiReactionList = new ArrayList<>();

    public ArrayList<GProStEmojiReaction> getEmojiReactionList() {
        return this.emojiReactionList;
    }

    public String getIdd() {
        return this.idd;
    }

    public long getTotalLikeCount() {
        return this.totalLikeCount;
    }

    public String toString() {
        return "GProStEmotionReactionInfo{idd=" + this.idd + ",emojiReactionList=" + this.emojiReactionList + ",totalLikeCount=" + this.totalLikeCount + ",}";
    }
}
