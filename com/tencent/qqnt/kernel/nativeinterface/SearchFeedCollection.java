package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchFeedCollection {
    public SearchIcon icon = new SearchIcon();
    public SearchIcon busiIcon = new SearchIcon();
    public SearchButton button = new SearchButton();
    public SearchIcon tag = new SearchIcon();
    public SearchReportInfo reportInfo = new SearchReportInfo();
    public ArrayList<SearchFeedSummary> feedSummaryList = new ArrayList<>();

    public SearchIcon getBusiIcon() {
        return this.busiIcon;
    }

    public SearchButton getButton() {
        return this.button;
    }

    public ArrayList<SearchFeedSummary> getFeedSummaryList() {
        return this.feedSummaryList;
    }

    public SearchIcon getIcon() {
        return this.icon;
    }

    public SearchReportInfo getReportInfo() {
        return this.reportInfo;
    }

    public SearchIcon getTag() {
        return this.tag;
    }

    public String toString() {
        return "SearchFeedCollection{icon=" + this.icon + ",busiIcon=" + this.busiIcon + ",button=" + this.button + ",tag=" + this.tag + ",reportInfo=" + this.reportInfo + ",feedSummaryList=" + this.feedSummaryList + ",}";
    }
}
