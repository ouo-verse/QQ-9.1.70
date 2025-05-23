package com.tencent.mobileqq.qzoneplayer.video;

import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.oskplayer.datasource.DownloadListener;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes35.dex */
public class j implements DownloadListener {
    @Override // com.tencent.oskplayer.datasource.DownloadListener
    public void onEnd(String str) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("status", "end");
        hashMap.put("error_code", "0");
        FeedVideoEnv.externalFunc.reportMTA(FeedVideoEnv.MtaReportConfig.MTA_REPORT_KEY_PRELOAD, hashMap);
    }

    @Override // com.tencent.oskplayer.datasource.DownloadListener
    public void onError(String str, int i3) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("status", "error");
        hashMap.put("error_code", String.valueOf(i3));
        FeedVideoEnv.externalFunc.reportMTA(FeedVideoEnv.MtaReportConfig.MTA_REPORT_KEY_PRELOAD, hashMap);
    }

    @Override // com.tencent.oskplayer.datasource.DownloadListener
    public void onStart(String str) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("status", "start");
        FeedVideoEnv.externalFunc.reportMTA(FeedVideoEnv.MtaReportConfig.MTA_REPORT_KEY_PRELOAD, hashMap);
    }

    @Override // com.tencent.oskplayer.datasource.DownloadListener
    public void onTransfer(String str, int i3) {
    }
}
