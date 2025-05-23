package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchText {
    public String text = "";
    public SearchJump jumpLink = new SearchJump();
    public SearchReportInfo reportInfo = new SearchReportInfo();
    public String color = "";
    public String colorToken = "";
    public SearchReportInfo backendReportInfo = new SearchReportInfo();

    public SearchReportInfo getBackendReportInfo() {
        return this.backendReportInfo;
    }

    public String getColor() {
        return this.color;
    }

    public String getColorToken() {
        return this.colorToken;
    }

    public SearchJump getJumpLink() {
        return this.jumpLink;
    }

    public SearchReportInfo getReportInfo() {
        return this.reportInfo;
    }

    public String getText() {
        return this.text;
    }

    public String toString() {
        return "SearchText{text=" + this.text + ",jumpLink=" + this.jumpLink + ",reportInfo=" + this.reportInfo + ",color=" + this.color + ",colorToken=" + this.colorToken + ",backendReportInfo=" + this.backendReportInfo + ",}";
    }
}
