package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdAction extends JceStruct {
    static int cache_actionType;
    public AdActionItem actionItem;
    public AdActionReport actionReport;
    public int actionType;
    public AdHalfPageItem adHalfPageItem;
    public int autoOpenPageType;
    public boolean isAutoOpenPage;
    public int pageType;
    static AdActionItem cache_actionItem = new AdActionItem();
    static AdActionReport cache_actionReport = new AdActionReport();
    static AdHalfPageItem cache_adHalfPageItem = new AdHalfPageItem();
    static int cache_autoOpenPageType = 0;

    public AdAction() {
        this.actionType = 0;
        this.actionItem = null;
        this.actionReport = null;
        this.pageType = 0;
        this.adHalfPageItem = null;
        this.isAutoOpenPage = false;
        this.autoOpenPageType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.actionType = jceInputStream.read(this.actionType, 0, true);
        this.actionItem = (AdActionItem) jceInputStream.read((JceStruct) cache_actionItem, 1, false);
        this.actionReport = (AdActionReport) jceInputStream.read((JceStruct) cache_actionReport, 2, false);
        this.pageType = jceInputStream.read(this.pageType, 3, false);
        this.adHalfPageItem = (AdHalfPageItem) jceInputStream.read((JceStruct) cache_adHalfPageItem, 4, false);
        this.isAutoOpenPage = jceInputStream.read(this.isAutoOpenPage, 5, false);
        this.autoOpenPageType = jceInputStream.read(this.autoOpenPageType, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.actionType, 0);
        AdActionItem adActionItem = this.actionItem;
        if (adActionItem != null) {
            jceOutputStream.write((JceStruct) adActionItem, 1);
        }
        AdActionReport adActionReport = this.actionReport;
        if (adActionReport != null) {
            jceOutputStream.write((JceStruct) adActionReport, 2);
        }
        jceOutputStream.write(this.pageType, 3);
        AdHalfPageItem adHalfPageItem = this.adHalfPageItem;
        if (adHalfPageItem != null) {
            jceOutputStream.write((JceStruct) adHalfPageItem, 4);
        }
        jceOutputStream.write(this.isAutoOpenPage, 5);
        jceOutputStream.write(this.autoOpenPageType, 6);
    }

    public AdAction(int i3, AdActionItem adActionItem, AdActionReport adActionReport, int i16, AdHalfPageItem adHalfPageItem, boolean z16, int i17) {
        this.actionType = i3;
        this.actionItem = adActionItem;
        this.actionReport = adActionReport;
        this.pageType = i16;
        this.adHalfPageItem = adHalfPageItem;
        this.isAutoOpenPage = z16;
        this.autoOpenPageType = i17;
    }
}
