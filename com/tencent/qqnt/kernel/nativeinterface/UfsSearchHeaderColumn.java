package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsSearchHeaderColumn {
    public String icon = "";
    public String title = "";
    public String gameDescription = "";
    public UfsSearchTextItem button = new UfsSearchTextItem();
    public String scheme = "";
    public String schemeAnd = "";
    public String schemeIos = "";
    public UfsReportInfo reportInfo = new UfsReportInfo();

    public UfsSearchTextItem getButton() {
        return this.button;
    }

    public String getGameDescription() {
        return this.gameDescription;
    }

    public String getIcon() {
        return this.icon;
    }

    public UfsReportInfo getReportInfo() {
        return this.reportInfo;
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getSchemeAnd() {
        return this.schemeAnd;
    }

    public String getSchemeIos() {
        return this.schemeIos;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "UfsSearchHeaderColumn{icon=" + this.icon + ",title=" + this.title + ",gameDescription=" + this.gameDescription + ",button=" + this.button + ",scheme=" + this.scheme + ",schemeAnd=" + this.schemeAnd + ",schemeIos=" + this.schemeIos + ",reportInfo=" + this.reportInfo + ",}";
    }
}
