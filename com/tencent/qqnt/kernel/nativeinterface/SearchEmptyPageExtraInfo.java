package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class SearchEmptyPageExtraInfo {
    public String text = "";
    public String jumpUrl = "";
    public SearchEmptyPageRichText richText = new SearchEmptyPageRichText();
    public String title = "";

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public SearchEmptyPageRichText getRichText() {
        return this.richText;
    }

    public String getText() {
        return this.text;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "SearchEmptyPageExtraInfo{text=" + this.text + ",jumpUrl=" + this.jumpUrl + ",richText=" + this.richText + ",title=" + this.title + ",}";
    }
}
