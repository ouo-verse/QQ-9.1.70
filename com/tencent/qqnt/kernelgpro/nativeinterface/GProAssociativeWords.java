package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProAssociativeWords {
    public String term = "";
    public GProRecallInfo recallInfo = new GProRecallInfo();

    public GProRecallInfo getRecallInfo() {
        return this.recallInfo;
    }

    public String getTerm() {
        return this.term;
    }

    public String toString() {
        return "GProAssociativeWords{term=" + this.term + ",recallInfo=" + this.recallInfo + ",}";
    }
}
