package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchHotTopic {
    public boolean isMulImg;
    public SearchIcon avatar = new SearchIcon();
    public String title = "";
    public String content = "";
    public SearchRichText richText = new SearchRichText();
    public SearchIcon feedImg = new SearchIcon();

    public SearchIcon getAvatar() {
        return this.avatar;
    }

    public String getContent() {
        return this.content;
    }

    public SearchIcon getFeedImg() {
        return this.feedImg;
    }

    public boolean getIsMulImg() {
        return this.isMulImg;
    }

    public SearchRichText getRichText() {
        return this.richText;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "SearchHotTopic{avatar=" + this.avatar + ",title=" + this.title + ",content=" + this.content + ",richText=" + this.richText + ",feedImg=" + this.feedImg + ",isMulImg=" + this.isMulImg + ",}";
    }
}
