package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsSearchTemplateResp {
    public UfsSearchImage image = new UfsSearchImage();
    public UfsSearchHeaderColumn header = new UfsSearchHeaderColumn();
    public ArrayList<UfsSearchIconItem> icons = new ArrayList<>();
    public UfsReportInfo reportInfo = new UfsReportInfo();

    public UfsSearchHeaderColumn getHeader() {
        return this.header;
    }

    public ArrayList<UfsSearchIconItem> getIcons() {
        return this.icons;
    }

    public UfsSearchImage getImage() {
        return this.image;
    }

    public UfsReportInfo getReportInfo() {
        return this.reportInfo;
    }

    public String toString() {
        return "UfsSearchTemplateResp{image=" + this.image + ",header=" + this.header + ",icons=" + this.icons + ",reportInfo=" + this.reportInfo + ",}";
    }
}
