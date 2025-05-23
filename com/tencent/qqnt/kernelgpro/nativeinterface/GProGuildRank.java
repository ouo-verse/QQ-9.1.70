package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildRank {
    public String iconUrl;
    public String text;

    public GProGuildRank() {
        this.iconUrl = "";
        this.text = "";
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getText() {
        return this.text;
    }

    public String toString() {
        return "GProGuildRank{iconUrl=" + this.iconUrl + ",text=" + this.text + ",}";
    }

    public GProGuildRank(String str, String str2) {
        this.iconUrl = str;
        this.text = str2;
    }
}
