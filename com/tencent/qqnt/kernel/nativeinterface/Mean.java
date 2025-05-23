package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class Mean {
    public int flag;
    public String words;

    public Mean() {
        this.words = "";
    }

    public int getFlag() {
        return this.flag;
    }

    public String getWords() {
        return this.words;
    }

    public String toString() {
        return "Mean{words=" + this.words + ",flag=" + this.flag + ",}";
    }

    public Mean(String str, int i3) {
        this.words = str;
        this.flag = i3;
    }
}
