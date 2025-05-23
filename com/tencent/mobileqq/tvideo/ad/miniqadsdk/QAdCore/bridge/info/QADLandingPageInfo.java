package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.QAdH5ReportInfo;
import com.tencent.qqlive.ona.protocol.jce.AdDownloadItem;
import java.io.Serializable;

/* loaded from: classes19.dex */
public class QADLandingPageInfo implements Serializable {
    private AdDownloadItem mDownloadItem;
    private int mFrom;
    private QAdH5ReportInfo mQAdH5ReportInfo;
    private String mUrl;

    public AdDownloadItem getDownloadItem() {
        return this.mDownloadItem;
    }

    public int getFrom() {
        return this.mFrom;
    }

    public QAdH5ReportInfo getQAdH5ReportInfo() {
        return this.mQAdH5ReportInfo;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setDownloadItem(AdDownloadItem adDownloadItem) {
        this.mDownloadItem = adDownloadItem;
    }

    public void setFrom(int i3) {
        this.mFrom = i3;
    }

    public void setQAdH5ReportInfo(QAdH5ReportInfo qAdH5ReportInfo) {
        this.mQAdH5ReportInfo = qAdH5ReportInfo;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }
}
