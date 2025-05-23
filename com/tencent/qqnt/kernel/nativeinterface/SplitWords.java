package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SplitWords {
    public String keyWords;
    public ArrayList<String> splitWord;

    public SplitWords() {
        this.keyWords = "";
        this.splitWord = new ArrayList<>();
    }

    public String getKeyWords() {
        return this.keyWords;
    }

    public ArrayList<String> getSplitWord() {
        return this.splitWord;
    }

    public String toString() {
        return "SplitWords{keyWords=" + this.keyWords + ",splitWord=" + this.splitWord + ",}";
    }

    public SplitWords(String str, ArrayList<String> arrayList) {
        this.keyWords = "";
        new ArrayList();
        this.keyWords = str;
        this.splitWord = arrayList;
    }
}
