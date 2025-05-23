package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchFeedSummary {
    public SearchIcon icon = new SearchIcon();
    public SearchText title = new SearchText();
    public SearchText text = new SearchText();
    public ArrayList<SearchPicture> picList = new ArrayList<>();
    public SearchRichText richText = new SearchRichText();
    public SearchReportInfo reportInfo = new SearchReportInfo();
    public SearchJump jumpLink = new SearchJump();

    public SearchIcon getIcon() {
        return this.icon;
    }

    public SearchJump getJumpLink() {
        return this.jumpLink;
    }

    public ArrayList<SearchPicture> getPicList() {
        return this.picList;
    }

    public SearchReportInfo getReportInfo() {
        return this.reportInfo;
    }

    public SearchRichText getRichText() {
        return this.richText;
    }

    public SearchText getText() {
        return this.text;
    }

    public SearchText getTitle() {
        return this.title;
    }

    public String toString() {
        return "SearchFeedSummary{icon=" + this.icon + ",title=" + this.title + ",text=" + this.text + ",picList=" + this.picList + ",richText=" + this.richText + ",reportInfo=" + this.reportInfo + ",jumpLink=" + this.jumpLink + ",}";
    }
}
