package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class HitEmotions {
    public ArrayList<DownloadRelateEmojiResultInfo> emotionsInfo;
    public boolean isOver;
    public String words;

    public HitEmotions() {
        this.words = "";
        this.emotionsInfo = new ArrayList<>();
    }

    public ArrayList<DownloadRelateEmojiResultInfo> getEmotionsInfo() {
        return this.emotionsInfo;
    }

    public boolean getIsOver() {
        return this.isOver;
    }

    public String getWords() {
        return this.words;
    }

    public String toString() {
        return "HitEmotions{words=" + this.words + ",isOver=" + this.isOver + ",emotionsInfo=" + this.emotionsInfo + ",}";
    }

    public HitEmotions(String str, boolean z16, ArrayList<DownloadRelateEmojiResultInfo> arrayList) {
        this.words = "";
        new ArrayList();
        this.words = str;
        this.isOver = z16;
        this.emotionsInfo = arrayList;
    }
}
