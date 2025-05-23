package com.tencent.thumbplayer.report.reportv2;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.api.report.v2.ITPReportInfoGetter;
import com.tencent.thumbplayer.common.TPDynamicStatisticParams;
import com.tencent.thumbplayer.common.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.common.thread.TPThreadPool;
import com.tencent.thumbplayer.event.TPPlayerEventInfo;
import com.tencent.thumbplayer.report.reportv2.data.TPCommonParams;
import com.tencent.thumbplayer.report.reportv2.data.live.TPLiveEndParams;
import com.tencent.thumbplayer.report.reportv2.data.live.TPLiveFirstLoadParams;
import com.tencent.thumbplayer.report.reportv2.data.live.TPLivePeriodParams;
import com.tencent.thumbplayer.report.reportv2.data.live.TPLivePlayFlowParams;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes26.dex */
public class TPLiveReporter extends TPBaseReporter {
    private static final int BUFFERING_DURATION_THRESHOLD_MS = 1200;
    private static final int PERIOD_REPORT_TIME_MS = 60000;
    private static final int PLAYER_END_NO_ERROR = 0;
    private static final String TAG = "TPLiveReporter";
    private final Object mPeriodReportTimerLock = new Object();
    private boolean mIsPlayDone = true;
    private boolean mIsBuffering = false;
    private TPLiveReportParamRecord mReportParamRecord = new TPLiveReportParamRecord();
    private Future<?> mPeriodReportTimer = null;
    private Runnable mPeriodTimerRunnable = new Runnable() { // from class: com.tencent.thumbplayer.report.reportv2.TPLiveReporter.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TPLiveReporter.this.mIsPlayDone) {
                TPLiveReporter.this.periodReportEvent();
                return;
            }
            TPLogUtil.i(TPLiveReporter.TAG, "Period Timer Exit because play done.");
            TPLiveReporter.this.mPeriodReportTimer.cancel(true);
            TPLiveReporter.this.mPeriodReportTimer = null;
        }
    };

    private synchronized void destroyPeriodReportTimer() {
        TPLogUtil.i(TAG, "destroyPeriodReportTimer");
        synchronized (this.mPeriodReportTimerLock) {
            Future<?> future = this.mPeriodReportTimer;
            if (future != null) {
                future.cancel(true);
                this.mPeriodReportTimer = null;
            }
        }
    }

    private void fillGeneralPlayFlowParams(@NonNull TPLivePlayFlowParams tPLivePlayFlowParams, @NonNull TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
        tPLivePlayFlowParams.setCoreApiPrepareTimeMs(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mCoreApiPrepareTimeMs);
        tPLivePlayFlowParams.setCoreSchedulingThreadPrepareTimeMs(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mCoreSchedulingThreadPrepareTimeMs);
        tPLivePlayFlowParams.setDemuxerThreadPrepareTimeMs(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mDemuxerThreadPrepareTimeMs);
        tPLivePlayFlowParams.setDemuxerOpenFileSTimeMs(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mDemuxerOpenFileSTimeMs);
        tPLivePlayFlowParams.setDemuxerOpenFileEtimems(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mCoreApiPrepareTimeMs);
        tPLivePlayFlowParams.setInitFirstClipPositionETimeMs(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mInitFirstClipPositionETimeMs);
        tPLivePlayFlowParams.setFirstVideoPacketReadETimeMs(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mFirstVideoPacketReadETimeMs);
        tPLivePlayFlowParams.setFirstAudioPacketReadETimeMs(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mFirstAudioPacketReadETimeMs);
        tPLivePlayFlowParams.setDemuxerThreadOnPreparedTimeMs(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mDemuxerThreadOnPreparedTimeMs);
        tPLivePlayFlowParams.setCoreSchedulingThreadOnPreparedTimeMs(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mCoreSchedulingThreadOnPreparedTimeMs);
        tPLivePlayFlowParams.setVideoDecoderOpenedTimeMs(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mVideoDecoderOpenedTimeMs);
        tPLivePlayFlowParams.setFirstVideoFrameRenderETimeMs(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mFirstVideoFrameRenderETimeMs);
        tPLivePlayFlowParams.setAudioDecoderOpenedTimeMs(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mAudioDecoderOpenedTimeMs);
        tPLivePlayFlowParams.setFirstAudioFrameRenderETimeMs(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mFirstAudioFrameRenderETimeMs);
    }

    private void fillPeriodExtReportInfoToCommonParams(@NonNull TPBaseReportParamRecord tPBaseReportParamRecord) {
        ITPReportInfoGetter iTPReportInfoGetter = this.mReportInfoGetter;
        if (iTPReportInfoGetter == null) {
            return;
        }
        Map<String, String> periodExtendedReportInfo = iTPReportInfoGetter.getPeriodExtendedReportInfo();
        if (periodExtendedReportInfo == null) {
            TPLogUtil.e(TAG, "fillPeriodExtReportInfoToCommonParams fail, period ExtendReportInfo is null");
            return;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TPBaseReporter.classifyMapIntoRsvExtMapAndExtMap(periodExtendedReportInfo, hashMap, hashMap2);
        tPBaseReportParamRecord.mCommonParams.setPeriodRsvExtFields(hashMap);
        tPBaseReportParamRecord.mCommonParams.setPeriodExtFields(hashMap2);
    }

    private void fillPlayerEndConfigParams(@NonNull TPLiveEndParams tPLiveEndParams, @NonNull TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
        tPLiveEndParams.setVideoDecoderType(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mVideoDecoderType);
        tPLiveEndParams.setAudioDecoderType(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mAudioDecoderType);
        tPLiveEndParams.setVideoRenderType(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mVideoRenderType);
        tPLiveEndParams.setAudioRenderType(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mAudioRenderType);
        tPLiveEndParams.setDemuxerType(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mDemuxerType);
    }

    private TPLiveEndParams getLiveEndParams(long j3, int i3, @NonNull TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
        TPLiveEndParams tPLiveEndParams = new TPLiveEndParams();
        TPLiveReportParamRecord tPLiveReportParamRecord = this.mReportParamRecord;
        long j16 = tPLiveReportParamRecord.mRetentionDurationMs + (j3 - tPLiveReportParamRecord.mPlayerFirstStartOccurElapsedTimeMs);
        tPLiveReportParamRecord.mRetentionDurationMs = j16;
        tPLiveEndParams.setRetentionDurationMs(j16);
        tPLiveEndParams.setErrorCode(i3);
        fillPlayerEndConfigParams(tPLiveEndParams, tPGeneralPlayFlowParams);
        TPCommonParams tPCommonParams = this.mReportParamRecord.mCommonParams;
        int i16 = this.mReportEventSeq;
        this.mReportEventSeq = i16 + 1;
        tPCommonParams.setSeq(i16);
        this.mReportUtils.updateCommonParams(this.mReportParamRecord.mCommonParams);
        tPLiveEndParams.copyCommonParams(this.mReportParamRecord.mCommonParams);
        return tPLiveEndParams;
    }

    private TPLivePlayFlowParams getLiveFlowParams(@NonNull TPGeneralPlayFlowParams tPGeneralPlayFlowParams, @NonNull TPDynamicStatisticParams tPDynamicStatisticParams) {
        TPLivePlayFlowParams tPLivePlayFlowParams = new TPLivePlayFlowParams();
        tPLivePlayFlowParams.setTPSetDataSourceTimeMs(this.mReporterInitParams.mTPSetDataSourceTimeMs);
        tPLivePlayFlowParams.setConvertDataSourceETimeMs(this.mReporterInitParams.mConvertDataSourceETimeMs);
        tPLivePlayFlowParams.setTPPrepareTimeMs(this.mReporterInitParams.mTPPrepareStartOccurElapsedTimeMs);
        tPLivePlayFlowParams.setTPOnPreparedTimeMs(this.mReportParamRecord.mPrepareEndOccurElapsedTimeMs);
        fillGeneralPlayFlowParams(tPLivePlayFlowParams, tPGeneralPlayFlowParams);
        TPCommonParams tPCommonParams = this.mReportParamRecord.mCommonParams;
        int i3 = this.mReportEventSeq;
        this.mReportEventSeq = i3 + 1;
        tPCommonParams.setSeq(i3);
        this.mReportUtils.updateCommonParams(this.mReportParamRecord.mCommonParams);
        tPLivePlayFlowParams.copyCommonParams(this.mReportParamRecord.mCommonParams);
        return tPLivePlayFlowParams;
    }

    private void onAppBackground() {
        TPLogUtil.i(TAG, "onAppBackground");
        if (this.mIsPlayDone) {
            return;
        }
        cacheReport(TPReportEventId.TP_REPORT_EVENT_LIVE_FLOW, getLiveFlowParams(getGeneralPlayFlowParamsFromCore(), getDynamicStatisticParamsFromCore(false)));
        cacheReport(TPReportEventId.TP_REPORT_EVENT_LIVE_END, getLiveEndParams(SystemClock.elapsedRealtime(), 0, getGeneralPlayFlowParamsFromCore()));
    }

    private void onAppForeground() {
        TPLogUtil.i(TAG, "onAppForeground");
        removeCachedReports(this.mReportParamRecord.mCommonParams.getFlowId());
    }

    private void onBufferingEnd(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        if (!(baseEventInfo instanceof TPPlayerEventInfo.BufferingEndEventInfo)) {
            TPLogUtil.e(TAG, "onBufferingEnd fail:params is not match");
            return;
        }
        this.mIsBuffering = false;
        long eventTimeSinceBootMs = ((TPPlayerEventInfo.BufferingEndEventInfo) baseEventInfo).getEventTimeSinceBootMs();
        TPLiveReportParamRecord tPLiveReportParamRecord = this.mReportParamRecord;
        long j3 = eventTimeSinceBootMs - tPLiveReportParamRecord.mBufferingStartOccurElapsedTimeMs;
        tPLiveReportParamRecord.mPlayerStartOccurElapsedTimeMs = SystemClock.elapsedRealtime();
        TPLogUtil.i(TAG, "Live onBufferingEnd bufferingCostTimeMs:" + j3);
        if (j3 <= 1200) {
            return;
        }
        TPLiveReportParamRecord tPLiveReportParamRecord2 = this.mReportParamRecord;
        tPLiveReportParamRecord2.mPeriodBufferingCount++;
        tPLiveReportParamRecord2.mPeriodBufferingTotalDurationMs += j3;
        tPLiveReportParamRecord2.mBufferingStartOccurElapsedTimeMs = 0L;
    }

    private void onBufferingStart(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        if (!(baseEventInfo instanceof TPPlayerEventInfo.BufferingStartEventInfo)) {
            TPLogUtil.e(TAG, "onBufferingStart fail:params is not match");
            return;
        }
        this.mIsBuffering = true;
        this.mReportParamRecord.mBufferingStartOccurElapsedTimeMs = ((TPPlayerEventInfo.BufferingStartEventInfo) baseEventInfo).getEventTimeSinceBootMs();
        TPLogUtil.i(TAG, "Live onBufferingStart timeMs:" + this.mReportParamRecord.mBufferingStartOccurElapsedTimeMs);
        TPLiveReportParamRecord tPLiveReportParamRecord = this.mReportParamRecord;
        tPLiveReportParamRecord.mPeriodPlayedDurationMs = tPLiveReportParamRecord.mPeriodPlayedDurationMs + (tPLiveReportParamRecord.mBufferingStartOccurElapsedTimeMs - tPLiveReportParamRecord.mPlayerStartOccurElapsedTimeMs);
    }

    private void onDTCdnUrlUpdate(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        if (!(baseEventInfo instanceof TPPlayerEventInfo.DTCdnUrlUpdataEventInfo)) {
            TPLogUtil.e(TAG, "onDTCdnUrlUpdate fail:params is not match");
            return;
        }
        TPPlayerEventInfo.DTCdnUrlUpdataEventInfo dTCdnUrlUpdataEventInfo = (TPPlayerEventInfo.DTCdnUrlUpdataEventInfo) baseEventInfo;
        String cdnIp = dTCdnUrlUpdataEventInfo.getCdnIp();
        String userIp = dTCdnUrlUpdataEventInfo.getUserIp();
        TPLogUtil.i(TAG, "Vod onDTCdnUrlUpdate cdnIp:" + cdnIp + " uIp:" + userIp);
        TPLiveReportParamRecord tPLiveReportParamRecord = this.mReportParamRecord;
        tPLiveReportParamRecord.mDTCdnIp = cdnIp;
        tPLiveReportParamRecord.mDTUserIp = userIp;
    }

    private void onDTProcessUpdate(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        if (!(baseEventInfo instanceof TPPlayerEventInfo.DTDownloadProgressUpdataEventInfo)) {
            TPLogUtil.e(TAG, "onDTProcessUpdate fail:params is not match");
            return;
        }
        int downloadSpeedKbps = ((TPPlayerEventInfo.DTDownloadProgressUpdataEventInfo) baseEventInfo).getDownloadSpeedKbps();
        TPLogUtil.i(TAG, "Vod onDTProcessUpdate speedKbps:" + downloadSpeedKbps);
        this.mReportParamRecord.mDTSpeedKbps = downloadSpeedKbps;
    }

    private void onDTProtocolUpdate(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        if (!(baseEventInfo instanceof TPPlayerEventInfo.DTProtocalUpdateEventInfo)) {
            TPLogUtil.e(TAG, "onDTProtocolUpdate fail:params is not match");
            return;
        }
        String protocolVer = ((TPPlayerEventInfo.DTProtocalUpdateEventInfo) baseEventInfo).getProtocolVer();
        TPLogUtil.i(TAG, "Vod onDTProtocolUpdate protocolVer:" + protocolVer);
        this.mReportParamRecord.mDTProtocolVer = protocolVer;
    }

    private void onPlayerEnd(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        if (this.mIsPlayDone) {
            TPLogUtil.e(TAG, "Player has been called End");
            return;
        }
        this.mIsPlayDone = true;
        reportPlayerEndEvent(baseEventInfo.getEventTimeSinceBootMs(), 0, getGeneralPlayFlowParamsFromEventInfo(baseEventInfo), getDynamicStatisticParamsFromEventInfo(baseEventInfo));
        removeCachedReports(this.mReportParamRecord.mCommonParams.getFlowId());
    }

    private void onPlayerError(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        if (this.mIsPlayDone) {
            TPLogUtil.e(TAG, "Player has been called End");
            return;
        }
        this.mIsPlayDone = true;
        if (!(baseEventInfo instanceof TPPlayerEventInfo.PlayErrorEventInfo)) {
            TPLogUtil.e(TAG, "onPlayerError fail:params is not match");
            return;
        }
        TPPlayerEventInfo.PlayErrorEventInfo playErrorEventInfo = (TPPlayerEventInfo.PlayErrorEventInfo) baseEventInfo;
        reportPlayerEndEvent(playErrorEventInfo.getEventTimeSinceBootMs(), playErrorEventInfo.getError().getErrorCode(), getGeneralPlayFlowParamsFromEventInfo(playErrorEventInfo), getDynamicStatisticParamsFromEventInfo(playErrorEventInfo));
        removeCachedReports(this.mReportParamRecord.mCommonParams.getFlowId());
    }

    private void onPlayerStart(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        if (!(baseEventInfo instanceof TPPlayerEventInfo.PlayStartEventInfo)) {
            TPLogUtil.e(TAG, "onPlayerStart fail:params is not match");
            return;
        }
        TPPlayerEventInfo.PlayStartEventInfo playStartEventInfo = (TPPlayerEventInfo.PlayStartEventInfo) baseEventInfo;
        this.mIsPlayDone = false;
        TPLiveReportParamRecord tPLiveReportParamRecord = this.mReportParamRecord;
        if (tPLiveReportParamRecord.mPlayerFirstStartOccurElapsedTimeMs == 0) {
            tPLiveReportParamRecord.mPlayerFirstStartOccurElapsedTimeMs = playStartEventInfo.getEventTimeSinceBootMs();
        }
        this.mReportParamRecord.mPlayerStartOccurElapsedTimeMs = playStartEventInfo.getEventTimeSinceBootMs();
        TPLogUtil.i(TAG, "Live onPlayerStart FirstStartTimeMs:" + this.mReportParamRecord.mPlayerFirstStartOccurElapsedTimeMs + " mPlayerStartOccurElapsedTimeMs:" + this.mReportParamRecord.mPlayerStartOccurElapsedTimeMs);
        startPeriodReportTimer();
    }

    private void onPrepareDone(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        if (!(baseEventInfo instanceof TPPlayerEventInfo.PrepareEndEventInfo)) {
            TPLogUtil.e(TAG, "onPrepareDone fail:params is not match");
            return;
        }
        TPPlayerEventInfo.PrepareEndEventInfo prepareEndEventInfo = (TPPlayerEventInfo.PrepareEndEventInfo) baseEventInfo;
        long eventTimeSinceBootMs = prepareEndEventInfo.getEventTimeSinceBootMs() - this.mReporterInitParams.mTPPrepareStartOccurElapsedTimeMs;
        this.mReportParamRecord.mPrepareEndOccurElapsedTimeMs = prepareEndEventInfo.getEventTimeSinceBootMs();
        TPLogUtil.i(TAG, "Live onPrepareDone timeMs:" + eventTimeSinceBootMs);
        fillStreamInfoToCommonParams(this.mReportParamRecord);
        TPCommonParams tPCommonParams = this.mReportParamRecord.mCommonParams;
        int i3 = this.mReportEventSeq;
        this.mReportEventSeq = i3 + 1;
        tPCommonParams.setSeq(i3);
        this.mReportUtils.updateCommonParams(this.mReportParamRecord.mCommonParams);
        fillInitExtReportInfoToCommonParams(this.mReportParamRecord);
        TPLiveFirstLoadParams tPLiveFirstLoadParams = new TPLiveFirstLoadParams();
        tPLiveFirstLoadParams.setCostTimeMs(eventTimeSinceBootMs);
        tPLiveFirstLoadParams.copyCommonParams(this.mReportParamRecord.mCommonParams);
        Map<String, String> fillParamsToMap = tPLiveFirstLoadParams.fillParamsToMap();
        dumpMapInfo("onPrepareDone", fillParamsToMap);
        reportToBeaconIfNeed(TPReportEventId.TP_REPORT_EVENT_LIVE_FIRST_LOAD, fillParamsToMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void periodReportEvent() {
        TPLogUtil.i(TAG, "periodReportEvent enter.");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        TPLiveReportParamRecord tPLiveReportParamRecord = this.mReportParamRecord;
        tPLiveReportParamRecord.mPeriodPlayedDurationMs += elapsedRealtime - tPLiveReportParamRecord.mPlayerStartOccurElapsedTimeMs;
        tPLiveReportParamRecord.mPlayerStartOccurElapsedTimeMs = SystemClock.elapsedRealtime();
        TPLivePeriodParams tPLivePeriodParams = new TPLivePeriodParams();
        tPLivePeriodParams.setBufferingCount(this.mReportParamRecord.mPeriodBufferingCount);
        tPLivePeriodParams.setBufferingDurationMs(this.mReportParamRecord.mPeriodBufferingTotalDurationMs);
        tPLivePeriodParams.setPlayedDurationMs(this.mReportParamRecord.mPeriodPlayedDurationMs);
        TPDynamicStatisticParams dynamicStatisticParams = this.mPlayerInfoGetter.getDynamicStatisticParams(true);
        tPLivePeriodParams.setMaxStreamBitrate(dynamicStatisticParams.mMaxVideoStreamBitrate);
        tPLivePeriodParams.setAvgStreamBitrate(dynamicStatisticParams.mAvgVideoStreamBitrate);
        tPLivePeriodParams.setMinStreamBitrate(dynamicStatisticParams.mMinVideoStreamBitrate);
        tPLivePeriodParams.setMaxVideoDecodeCostTimeMs(dynamicStatisticParams.mMaxVideoDecodeCostTimeMs);
        tPLivePeriodParams.setAvgVideoDecodeCostTimeMs(dynamicStatisticParams.mAvgVideoDecodeCostTimeMs);
        tPLivePeriodParams.setMinVideoDecodeCostTimeMs(dynamicStatisticParams.mMinVideoDecodeCostTimeMs);
        tPLivePeriodParams.setMaxVideoGopSize(dynamicStatisticParams.mMaxVideoGopSize);
        tPLivePeriodParams.setAvgVideoGopSize(dynamicStatisticParams.mAvgVideoGopSize);
        tPLivePeriodParams.setMinVideoGopSize(dynamicStatisticParams.mMinVideoGopSize);
        tPLivePeriodParams.setVideoDecodeFrameCount(dynamicStatisticParams.mVideoDecodeFrameCount);
        tPLivePeriodParams.setVideoRenderFrameCount(dynamicStatisticParams.mVideoRenderFrameCount);
        tPLivePeriodParams.setVideoBufferedDurationMs(dynamicStatisticParams.mVideoBufferedDurationMs);
        tPLivePeriodParams.setAudioBufferedDurationMs(dynamicStatisticParams.mAudioBufferedDurationMs);
        fillPeriodExtReportInfoToCommonParams(this.mReportParamRecord);
        TPCommonParams tPCommonParams = this.mReportParamRecord.mCommonParams;
        int i3 = this.mReportEventSeq;
        this.mReportEventSeq = i3 + 1;
        tPCommonParams.setSeq(i3);
        this.mReportUtils.updateCommonParams(this.mReportParamRecord.mCommonParams);
        tPLivePeriodParams.copyCommonParams(this.mReportParamRecord.mCommonParams);
        Map<String, String> fillParamsToMap = tPLivePeriodParams.fillParamsToMap();
        dumpMapInfo("periodReportEvent", fillParamsToMap);
        reportToBeaconIfNeed(TPReportEventId.TP_REPORT_EVENT_LIVE_PERIOD, fillParamsToMap);
        TPLiveReportParamRecord tPLiveReportParamRecord2 = this.mReportParamRecord;
        tPLiveReportParamRecord2.mPeriodBufferingCount = 0;
        tPLiveReportParamRecord2.mPeriodBufferingTotalDurationMs = 0L;
        tPLiveReportParamRecord2.mPeriodPlayedDurationMs = 0L;
        tPLiveReportParamRecord2.mCommonParams.setPeriodRsvExtFields(null);
        this.mReportParamRecord.mCommonParams.setPeriodExtFields(null);
    }

    private void reportLiveEndEvent(long j3, int i3, @NonNull TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
        Map<String, String> fillParamsToMap = getLiveEndParams(j3, i3, tPGeneralPlayFlowParams).fillParamsToMap();
        dumpMapInfo("reportLiveEndEvent", fillParamsToMap);
        reportToBeaconIfNeed(TPReportEventId.TP_REPORT_EVENT_LIVE_END, fillParamsToMap);
    }

    private void reportLiveEndFlowEvent(@NonNull TPGeneralPlayFlowParams tPGeneralPlayFlowParams, @NonNull TPDynamicStatisticParams tPDynamicStatisticParams) {
        Map<String, String> fillParamsToMap = getLiveFlowParams(tPGeneralPlayFlowParams, tPDynamicStatisticParams).fillParamsToMap();
        dumpMapInfo("reportLiveEndFlowEvent", fillParamsToMap);
        reportToBeaconIfNeed(TPReportEventId.TP_REPORT_EVENT_LIVE_FLOW, fillParamsToMap);
    }

    private void reportPlayerEndEvent(long j3, int i3, TPGeneralPlayFlowParams tPGeneralPlayFlowParams, TPDynamicStatisticParams tPDynamicStatisticParams) {
        if (this.mIsBuffering) {
            onBufferingEnd(new TPPlayerEventInfo.BufferingEndEventInfo());
            this.mIsBuffering = false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        TPLiveReportParamRecord tPLiveReportParamRecord = this.mReportParamRecord;
        tPLiveReportParamRecord.mPeriodPlayedDurationMs += elapsedRealtime - tPLiveReportParamRecord.mPlayerStartOccurElapsedTimeMs;
        destroyPeriodReportTimer();
        TPLogUtil.i(TAG, "reportPlayerEndEvent playerStopTimeMs:" + j3 + " errorCode:" + i3);
        reportLiveEndFlowEvent(tPGeneralPlayFlowParams, tPDynamicStatisticParams);
        reportLiveEndEvent(j3, i3, tPGeneralPlayFlowParams);
    }

    private void startPeriodReportTimer() {
        TPLogUtil.i(TAG, "startPeriodReportTimer");
        synchronized (this.mPeriodReportTimerLock) {
            if (this.mPeriodReportTimer == null) {
                this.mPeriodReportTimer = TPThreadPool.getInstance().obtainScheduledExecutorService().scheduleAtFixedRate(this.mPeriodTimerRunnable, 0L, 60000L, TimeUnit.MILLISECONDS);
            }
        }
    }

    @Override // com.tencent.thumbplayer.report.reportv2.TPBaseReporter, com.tencent.thumbplayer.report.reportv2.ITPReporter
    public void init(Context context, TPReporterInitParams tPReporterInitParams) {
        super.init(context, tPReporterInitParams);
        this.mReportUtils.initDeviceParams(this.mReportParamRecord.mCommonParams);
    }

    @Override // com.tencent.thumbplayer.report.reportv2.TPBaseReporter, com.tencent.thumbplayer.report.reportv2.ITPReporter
    public void onEvent(int i3, TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 5) {
                    if (i3 != 6) {
                        if (i3 != 9) {
                            if (i3 != 10) {
                                if (i3 != 1001) {
                                    if (i3 != 1002) {
                                        switch (i3) {
                                            case 100:
                                                onDTProcessUpdate(baseEventInfo);
                                                return;
                                            case 101:
                                                onDTCdnUrlUpdate(baseEventInfo);
                                                return;
                                            case 102:
                                                onDTProtocolUpdate(baseEventInfo);
                                                return;
                                            default:
                                                return;
                                        }
                                    }
                                    onAppBackground();
                                    return;
                                }
                                onAppForeground();
                                return;
                            }
                            onBufferingEnd(baseEventInfo);
                            return;
                        }
                        onBufferingStart(baseEventInfo);
                        return;
                    }
                    onPlayerError(baseEventInfo);
                    return;
                }
                onPlayerEnd(baseEventInfo);
                return;
            }
            onPlayerStart(baseEventInfo);
            return;
        }
        onPrepareDone(baseEventInfo);
    }

    @Override // com.tencent.thumbplayer.report.reportv2.TPBaseReporter, com.tencent.thumbplayer.report.reportv2.ITPReporter
    public void reset() {
        super.reset();
        destroyPeriodReportTimer();
    }
}
