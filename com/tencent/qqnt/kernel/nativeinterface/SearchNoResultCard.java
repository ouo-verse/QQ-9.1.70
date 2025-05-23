package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchNoResultCard {
    public boolean showBackground;
    public SearchText content = new SearchText();
    public SearchRichText richText = new SearchRichText();
    public SearchEmptyPageExtraInfo emptyPageInfo = new SearchEmptyPageExtraInfo();

    public SearchText getContent() {
        return this.content;
    }

    public SearchEmptyPageExtraInfo getEmptyPageInfo() {
        return this.emptyPageInfo;
    }

    public SearchRichText getRichText() {
        return this.richText;
    }

    public boolean getShowBackground() {
        return this.showBackground;
    }

    public String toString() {
        return "SearchNoResultCard{content=" + this.content + ",richText=" + this.richText + ",showBackground=" + this.showBackground + ",emptyPageInfo=" + this.emptyPageInfo + ",}";
    }
}
