package com.tencent.thumbplayer.api.report.v1;

/* loaded from: classes26.dex */
public class TPVodReportInfo extends TPDefaultReportInfo {
    public int bizId;
    public int clipCount;
    public int currentPlayState;
    public boolean hasSubtitles;
    public int optimizedPlay;
    public int videoStatus;

    @Override // com.tencent.thumbplayer.api.report.v1.TPDefaultReportInfo
    public int getPlayType() {
        return 0;
    }
}
