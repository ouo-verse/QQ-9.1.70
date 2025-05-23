package com.tencent.thumbplayer.api.report.v1;

/* loaded from: classes26.dex */
public class TPLiveReportInfo extends TPDefaultReportInfo {
    public int adPlayLength;
    public String cdnServer;
    public int contentId;
    public boolean isLookBack;
    public boolean isUserPay;
    public int liveDelay;
    public int liveType;
    public int playTime;
    public int programId;
    public int streamId;

    @Override // com.tencent.thumbplayer.api.report.v1.TPDefaultReportInfo
    public int getPlayType() {
        return 1;
    }
}
