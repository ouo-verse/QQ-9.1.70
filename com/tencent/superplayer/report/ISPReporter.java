package com.tencent.superplayer.report;

import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.player.MediaInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg;
import com.tencent.thumbplayer.api.common.TPDownloadProgressInfo;
import com.tencent.thumbplayer.api.common.TPMediaCodecExceptionInfo;
import com.tencent.thumbplayer.api.common.TPMediaCodecReadyInfo;
import java.util.Map;

/* loaded from: classes26.dex */
public interface ISPReporter extends ISPReportProvider {
    void addConfigExt(String str, Object obj);

    void addExtReportData(String str, String str2);

    void addExtReportData(Map<String, String> map);

    void init(ISuperPlayer iSuperPlayer, int i3);

    void onCDNInfoUpdate(TPPlayerMsg.TPCDNURLInfo tPCDNURLInfo);

    void onCodecReuseInfo(TPMediaCodecReadyInfo tPMediaCodecReadyInfo);

    void onCodecReuseInfoException(TPMediaCodecExceptionInfo tPMediaCodecExceptionInfo);

    void onCurrentLoopEnd();

    void onDownloadProgressUpdate(TPDownloadProgressInfo tPDownloadProgressInfo);

    void onDropFrame(float f16, SuperPlayerOption superPlayerOption);

    void onError(String str, String str2);

    void onFirstAudioFrameRendered();

    void onFirstVideoFrameRendered();

    void onMediaInfoReady(MediaInfo mediaInfo);

    void onOpenMediaPlayer(SuperPlayerVideoInfo superPlayerVideoInfo, long j3, SuperPlayerOption superPlayerOption);

    void onOpenTVKPlayer(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo, String str, long j3);

    void onOpenTVKPlayerByUrl(String str, long j3);

    void onPcdnDownloadFailed(String str);

    void onPlayerTypeChanged(long j3);

    void onPrePlayViewShow();

    void onPrepared();

    void onQuicInfoUpdate(String str);

    void onRelease();

    void onSeek(long j3, long j16);

    void onSeekComplete();

    void onStart();

    void onStop();

    void onVideoBufferEnd();

    void onVideoBufferStart();

    void onVideoDecoderTypeChanged(long j3);

    void onVideoFrameCheckResult(int i3);

    void reset();
}
