package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProHotSearchWord {
    public String icon;
    public String link;
    public int type;
    public String word;

    public GProHotSearchWord() {
        this.word = "";
        this.icon = "";
        this.link = "";
    }

    public String getIcon() {
        return this.icon;
    }

    public String getLink() {
        return this.link;
    }

    public int getType() {
        return this.type;
    }

    public String getWord() {
        return this.word;
    }

    public String toString() {
        return "GProHotSearchWord{type=" + this.type + ",word=" + this.word + ",icon=" + this.icon + ",link=" + this.link + ",}";
    }

    public GProHotSearchWord(int i3, String str, String str2, String str3) {
        this.type = i3;
        this.word = str;
        this.icon = str2;
        this.link = str3;
    }
}
