package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProUserGuideBubble {
    public String iconUrl;
    public String title;

    public GProUserGuideBubble() {
        this.title = "";
        this.iconUrl = "";
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProUserGuideBubble{title=" + this.title + ",iconUrl=" + this.iconUrl + ",}";
    }

    public GProUserGuideBubble(String str, String str2) {
        this.title = str;
        this.iconUrl = str2;
    }
}
