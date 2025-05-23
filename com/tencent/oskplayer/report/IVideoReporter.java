package com.tencent.oskplayer.report;

import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IVideoReporter {
    public static final String SALT_LIVEVIDEO = "liveVideo";

    void addVideoPlayTimeRange(String str, long j3);

    void addVideoVisibilityEvent(Map<String, String> map);

    void bufferingBegin(String str, boolean z16);

    void bufferingEnd(String str, boolean z16);

    void cancelPlayVideo(String str);

    void completePlayVideo(String str);

    void downloadResult(String str, long j3, Map<String, Object> map);

    void downloadServerCost(String str, long j3, long j16, long j17);

    void downloadServerIp(String str, String str2);

    void downloadSizeAndDuration(String str, long j3, long j16, long j17, long j18);

    void failPlayVideo(String str, int i3, long j3, int i16, String str2);

    long getLocalStoreTotalCountLimit();

    ReportState getReportState(String str);

    void getSafeUrlOccurred(long j3);

    void justReportVideoEventToDc00321(String str, long j3);

    void loopPlayVideo(String str);

    void mediaPlayerOnInfo(String str, int i3, int i16);

    void preLoadOccurred(String str, long j3);

    void prepareAdvVideoReportInfo(String str, int i3);

    void prepareReportForDc00321(Object obj);

    void progressBarSeekingBegin(String str, long j3, boolean z16);

    void progressBarSeekingEnd(String str, long j3);

    void realPlayVideo(String str, boolean z16);

    void reportDecreaseRate(String str, int i3);

    void reportFirstRender(String str);

    void reportPreloadOccured(String str, boolean z16);

    void reportVideoDecodeScore(int i3);

    void setExtraData(String str, String str2, Object obj);

    void setVideoDurationAndStartPlayPosition(String str, long j3, long j16);

    void setVideoResolution(String str, long j3, long j16);

    void setVideoUuid(String str);

    void startPlayVideo(String str, String str2, long j3, long j16, boolean z16, String str3, int i3, boolean z17, boolean z18);

    void startPlayVideo(String str, String str2, long j3, long j16, boolean z16, String str3, int i3, boolean z17, boolean z18, int i16);

    void startPlayVideo(String str, String str2, long j3, long j16, boolean z16, String str3, int i3, boolean z17, boolean z18, int i16, boolean z19);

    void stopPlayVideo(String str, long j3, int i3);

    void updatePlayScreenState(String str, boolean z16);

    void urlRedirectOccurred(String str, String str2, long j3, long j16);

    void vKeyUpdateOccurred(String str, long j3);
}
