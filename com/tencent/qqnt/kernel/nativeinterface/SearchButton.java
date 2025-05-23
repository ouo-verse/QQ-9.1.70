package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchButton {
    public int buttonType;
    public String title = "";
    public SearchJump jumpLink = new SearchJump();
    public SearchReportInfo reportInfo = new SearchReportInfo();
    public SearchReportInfo backendReportInfo = new SearchReportInfo();

    public SearchReportInfo getBackendReportInfo() {
        return this.backendReportInfo;
    }

    public int getButtonType() {
        return this.buttonType;
    }

    public SearchJump getJumpLink() {
        return this.jumpLink;
    }

    public SearchReportInfo getReportInfo() {
        return this.reportInfo;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "SearchButton{title=" + this.title + ",jumpLink=" + this.jumpLink + ",reportInfo=" + this.reportInfo + ",buttonType=" + this.buttonType + ",backendReportInfo=" + this.backendReportInfo + ",}";
    }
}
