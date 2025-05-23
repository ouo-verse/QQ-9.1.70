package com.tencent.biz.pubaccount.weishi.download;

import UserGrowth.stReportItem;

/* loaded from: classes32.dex */
public class WSDownloadParams {
    public int mEventId;
    public int mLinkStrategyType;
    public int mScene;
    public String mScheme;
    public stReportItem mStReportItem;
    public String mTestId;

    public String toString() {
        return "WSDownloadParams{mScene=" + this.mScene + ", mLinkStrategyType=" + this.mLinkStrategyType + ", mEventId=" + this.mEventId + ", mTestId='" + this.mTestId + "'}";
    }
}
