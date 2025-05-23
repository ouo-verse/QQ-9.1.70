package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsSearchTextItem {
    public String text = "";
    public String scheme = "";
    public String schemeAnd = "";
    public String schemeIos = "";
    public UfsReportInfo reportInfo = new UfsReportInfo();

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

    public String getText() {
        return this.text;
    }

    public String toString() {
        return "UfsSearchTextItem{text=" + this.text + ",scheme=" + this.scheme + ",schemeAnd=" + this.schemeAnd + ",schemeIos=" + this.schemeIos + ",reportInfo=" + this.reportInfo + ",}";
    }
}
