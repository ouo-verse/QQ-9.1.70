package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchLabel {
    public int layout;
    public int textLayout;
    public SearchText text = new SearchText();
    public SearchIcon icon = new SearchIcon();
    public SearchMargin margin = new SearchMargin();
    public SearchReportInfo reportInfo = new SearchReportInfo();
    public SearchReportInfo backendReportInfo = new SearchReportInfo();

    public SearchReportInfo getBackendReportInfo() {
        return this.backendReportInfo;
    }

    public SearchIcon getIcon() {
        return this.icon;
    }

    public int getLayout() {
        return this.layout;
    }

    public SearchMargin getMargin() {
        return this.margin;
    }

    public SearchReportInfo getReportInfo() {
        return this.reportInfo;
    }

    public SearchText getText() {
        return this.text;
    }

    public int getTextLayout() {
        return this.textLayout;
    }

    public String toString() {
        return "SearchLabel{text=" + this.text + ",icon=" + this.icon + ",layout=" + this.layout + ",margin=" + this.margin + ",reportInfo=" + this.reportInfo + ",textLayout=" + this.textLayout + ",backendReportInfo=" + this.backendReportInfo + ",}";
    }
}
