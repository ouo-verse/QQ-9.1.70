package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchMiniAppConditonFilter {
    public int selected;
    public int type;
    public String paramKey = "";
    public String paramValue = "";
    public String reportId = "";
    public String title = "";

    public String getParamKey() {
        return this.paramKey;
    }

    public String getParamValue() {
        return this.paramValue;
    }

    public String getReportId() {
        return this.reportId;
    }

    public int getSelected() {
        return this.selected;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "SearchMiniAppConditonFilter{paramKey=" + this.paramKey + ",paramValue=" + this.paramValue + ",reportId=" + this.reportId + ",selected=" + this.selected + ",title=" + this.title + ",type=" + this.type + ",}";
    }
}
