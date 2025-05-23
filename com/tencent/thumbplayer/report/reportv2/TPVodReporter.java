package com.tencent.thumbplayer.report.reportv2;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.api.common.TPTrackInfo;
import com.tencent.thumbplayer.common.TPDynamicStatisticParams;
import com.tencent.thumbplayer.common.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.event.TPPlayerEventInfo;
import com.tencent.thumbplayer.report.reportv2.TPVodReportParamRecord;
import com.tencent.thumbplayer.report.reportv2.data.TPCommonParams;
import com.tencent.thumbplayer.report.reportv2.data.vod.TPVodBufferingParams;
import com.tencent.thumbplayer.report.reportv2.data.vod.TPVodDrmParams;
import com.tencent.thumbplayer.report.reportv2.data.vod.TPVodEndParams;
import com.tencent.thumbplayer.report.reportv2.data.vod.TPVodFirstLoadParams;
import com.tencent.thumbplayer.report.reportv2.data.vod.TPVodPlayFlowParams;
import com.tencent.thumbplayer.report.reportv2.data.vod.TPVodSelectTrackParams;
import java.util.Map;

/* loaded from: classes26.dex */
public class TPVodReporter extends TPBaseReporter {
    private static final int BUFFERING_DURATION_THRESHOLD_MS = 1200;
    private static final int PLAYER_END_NO_ERROR = 0;
    private static final String TAG = "TPVodReporter";
    private boolean mIsPlayDone = true;
    private boolean mIsSeeking = false;
    private boolean mIsBuffering = false;
    private boolean mIsPausing = false;
    private TPVodReportParamRecord mReportParamRecord = new TPVodReportParamRecord();

    private void fillDynamicStatisticFlowParams(@NonNull TPVodPlayFlowParams tPVodPlayFlowParams, @NonNull TPDynamicStatisticParams tPDynamicStatisticParams) {
        tPVodPlayFlowParams.setMaxStreamBitrateKbps(tPDynamicStatisticParams.mMaxVideoStreamBitrate);
        tPVodPlayFlowParams.setAvgStreamBitrateKbps(tPDynamicStatisticParams.mAvgVideoStreamBitrate);
        tPVodPlayFlowParams.setMinStreamBitrateKbps(tPDynamicStatisticParams.mMinVideoStreamBitrate);
        tPVodPlayFlowParams.setMaxVideoDecodeCostTimeMs(tPDynamicStatisticParams.mMaxVideoDecodeCostTimeMs);
        tPVodPlayFlowParams.setAvgVideoDecodeCostTimeMs(tPDynamicStatisticParams.mAvgVideoDecodeCostTimeMs);
        tPVodPlayFlowParams.setMinVideoDecodeCostTimeMs(tPDynamicStatisticParams.mMinVideoDecodeCostTimeMs);
        tPVodPlayFlowParams.setVideoDecodeFrameTotalCount(tPDynamicStatisticParams.mVideoDecodeFrameCount);
        tPVodPlayFlowParams.setVideoRenderFrameTotalCount(tPDynamicStatisticParams.mVideoRenderFrameCount);
    }

    private void fillGeneralPlayFlowParams(@NonNull TPVodPlayFlowParams tPVodPlayFlowParams, @NonNull TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
        tPVodPlayFlowParams.setCoreApiPrepareTimeMs(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mCoreApiPrepareTimeMs);
        tPVodPlayFlowParams.setCoreSchedulingThreadPrepareTimeMs(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mCoreSchedulingThreadPrepareTimeMs);
        tPVodPlayFlowParams.setDemuxerThreadPrepareTimeMs(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mDemuxerThreadPrepareTimeMs);
        tPVodPlayFlowParams.setDemuxerOpenFileSTimeMs(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mDemuxerOpenFileSTimeMs);
        tPVodPlayFlowParams.setDemuxerOpenFileEtimems(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mCoreApiPrepareTimeMs);
        tPVodPlayFlowParams.setInitFirstClipPositionETimeMs(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mInitFirstClipPositionETimeMs);
        tPVodPlayFlowParams.setFirstVideoPacketReadETimeMs(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mFirstVideoPacketReadETimeMs);
        tPVodPlayFlowParams.setFirstAudioPacketReadETimeMs(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mFirstAudioPacketReadETimeMs);
        tPVodPlayFlowParams.setDemuxerThreadOnPreparedTimeMs(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mDemuxerThreadOnPreparedTimeMs);
        tPVodPlayFlowParams.setCoreSchedulingThreadOnPreparedTimeMs(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mCoreSchedulingThreadOnPreparedTimeMs);
        tPVodPlayFlowParams.setVideoDecoderOpenedTimeMs(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mVideoDecoderOpenedTimeMs);
        tPVodPlayFlowParams.setFirstVideoFrameRenderETimeMs(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mFirstVideoFrameRenderETimeMs);
        tPVodPlayFlowParams.setAudioDecoderOpenedTimeMs(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mAudioDecoderOpenedTimeMs);
        tPVodPlayFlowParams.setFirstAudioFrameRenderETimeMs(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mFirstAudioFrameRenderETimeMs);
    }

    private void fillPlayerEndConfigParams(@NonNull TPVodEndParams tPVodEndParams, @NonNull TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
        tPVodEndParams.setVideoDecoderType(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mVideoDecoderType);
        tPVodEndParams.setAudioDecoderType(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mAudioDecoderType);
        tPVodEndParams.setVideoRenderType(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mVideoRenderType);
        tPVodEndParams.setAudioRenderType(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mAudioRenderType);
        tPVodEndParams.setDemuxerType(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mDemuxerType);
    }

    private TPVodDrmParams getVodDrmParams(@NonNull TPGeneralPlayFlowParams.TPPlayerDrmParams tPPlayerDrmParams) {
        TPVodDrmParams tPVodDrmParams = new TPVodDrmParams();
        tPVodDrmParams.setSupportSecureDecoder(tPPlayerDrmParams.mSupportSecureDecoder);
        tPVodDrmParams.setSupportSecureDecrypt(tPPlayerDrmParams.mSupportSecureDecrypt);
        tPVodDrmParams.setSecureLevel(tPPlayerDrmParams.mSecureLevel);
        tPVodDrmParams.setComponentName(tPPlayerDrmParams.mComponentName);
        tPVodDrmParams.setDrmType(tPPlayerDrmParams.mDrmType);
        tPVodDrmParams.setPrepareSTimeMs(tPPlayerDrmParams.mPrepareSTimeMs);
        tPVodDrmParams.setPrepareETimeMs(tPPlayerDrmParams.mPrepareETimeMs);
        tPVodDrmParams.setOpenSessionSTimeMs(tPPlayerDrmParams.mOpenSessionSTimeMs);
        tPVodDrmParams.setOpenSessionETimeMs(tPPlayerDrmParams.mOpenSessionETimeMs);
        tPVodDrmParams.setGetProvisionReqSTimeMs(tPPlayerDrmParams.mGetProvisionReqSTimeMs);
        tPVodDrmParams.setGetProvisionReqETimeMs(tPPlayerDrmParams.mGetProvisionReqETimeMs);
        tPVodDrmParams.setSendProvisionReqTimeMs(tPPlayerDrmParams.mSendProvisionReqTimeMs);
        tPVodDrmParams.setRecvProvisionRespTimeMs(tPPlayerDrmParams.mRecvProvisionRespTimeMs);
        tPVodDrmParams.setProvideProvisionRespSTimeMs(tPPlayerDrmParams.mProvideProvisionRespSTimeMs);
        tPVodDrmParams.setProvideProvisionRespETimeMs(tPPlayerDrmParams.mProvideProvisionRespETimeMs);
        tPVodDrmParams.setGetKeyReqSTimeMs(tPPlayerDrmParams.mGetKeyReqSTimeMs);
        tPVodDrmParams.setGetKeyReqETimeMs(tPPlayerDrmParams.mGetKeyReqETimeMs);
        tPVodDrmParams.setSendKeyReqTimeMs(tPPlayerDrmParams.mSendKeyReqTimeMs);
        tPVodDrmParams.setRecvKeyRespTimeMs(tPPlayerDrmParams.mRecvKeyRespTimeMs);
        tPVodDrmParams.setProvideKeyRespSTimeMs(tPPlayerDrmParams.mProvideKeyRespSTimeMs);
        tPVodDrmParams.setProvideKeyRespETimeMs(tPPlayerDrmParams.mProvideKeyRespETimeMs);
        this.mReportUtils.updateCommonParams(this.mReportParamRecord.mCommonParams);
        TPCommonParams tPCommonParams = this.mReportParamRecord.mCommonParams;
        int i3 = this.mReportEventSeq;
        this.mReportEventSeq = i3 + 1;
        tPCommonParams.setSeq(i3);
        tPVodDrmParams.copyCommonParams(this.mReportParamRecord.mCommonParams);
        return tPVodDrmParams;
    }

    private TPVodEndParams getVodEndParams(long j3, int i3, @NonNull TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
        TPVodEndParams tPVodEndParams = new TPVodEndParams();
        TPVodReportParamRecord tPVodReportParamRecord = this.mReportParamRecord;
        long j16 = j3 - tPVodReportParamRecord.mPlayerFirstStartOccurElapsedTimeMs;
        tPVodReportParamRecord.mRetentionDurationMs = j16;
        tPVodEndParams.setRetentionDurationMs(j16);
        tPVodEndParams.setErrorCode(i3);
        tPVodEndParams.setTSeekCount(this.mReportParamRecord.mSeekTotalCount);
        tPVodEndParams.setTSeekBufferingCount(this.mReportParamRecord.mSeekBufferingTotalCount);
        tPVodEndParams.setTSeekBufferingDurationMs(this.mReportParamRecord.mSeekBufferingTotalDurationMs);
        tPVodEndParams.setTSecondBufferingCount(this.mReportParamRecord.mBufferingTotalCount);
        tPVodEndParams.setTSecondBufferingDurationMs(this.mReportParamRecord.mBufferingTotalDurationMs);
        fillPlayerEndConfigParams(tPVodEndParams, tPGeneralPlayFlowParams);
        TPCommonParams tPCommonParams = this.mReportParamRecord.mCommonParams;
        int i16 = this.mReportEventSeq;
        this.mReportEventSeq = i16 + 1;
        tPCommonParams.setSeq(i16);
        this.mReportUtils.updateCommonParams(this.mReportParamRecord.mCommonParams);
        tPVodEndParams.copyCommonParams(this.mReportParamRecord.mCommonParams);
        return tPVodEndParams;
    }

    private TPVodPlayFlowParams getVodPlayFlowParams(@NonNull TPGeneralPlayFlowParams tPGeneralPlayFlowParams, @NonNull TPDynamicStatisticParams tPDynamicStatisticParams) {
        TPVodPlayFlowParams tPVodPlayFlowParams = new TPVodPlayFlowParams();
        tPVodPlayFlowParams.setTPSetDataSourceTimeMs(this.mReporterInitParams.mTPSetDataSourceTimeMs);
        tPVodPlayFlowParams.setConvertDataSourceETimeMs(this.mReporterInitParams.mConvertDataSourceETimeMs);
        tPVodPlayFlowParams.setTPPrepareTimeMs(this.mReporterInitParams.mTPPrepareStartOccurElapsedTimeMs);
        tPVodPlayFlowParams.setTPOnPreparedTimeMs(this.mReportParamRecord.mPrepareEndOccurElapsedTimeMs);
        fillGeneralPlayFlowParams(tPVodPlayFlowParams, tPGeneralPlayFlowParams);
        fillDynamicStatisticFlowParams(tPVodPlayFlowParams, tPDynamicStatisticParams);
        this.mReportUtils.updateCommonParams(this.mReportParamRecord.mCommonParams);
        TPCommonParams tPCommonParams = this.mReportParamRecord.mCommonParams;
        int i3 = this.mReportEventSeq;
        this.mReportEventSeq = i3 + 1;
        tPCommonParams.setSeq(i3);
        tPVodPlayFlowParams.copyCommonParams(this.mReportParamRecord.mCommonParams);
        return tPVodPlayFlowParams;
    }

    private void onAppBackground() {
        TPLogUtil.i(TAG, "onAppBackground");
        if (this.mIsPlayDone) {
            return;
        }
        cacheReport(TPReportEventId.TP_REPORT_EVENT_VOD_FLOW, getVodPlayFlowParams(getGeneralPlayFlowParamsFromCore(), getDynamicStatisticParamsFromCore(false)));
        cacheReport(TPReportEventId.TP_REPORT_EVENT_VOD_END, getVodEndParams(SystemClock.elapsedRealtime(), 0, getGeneralPlayFlowParamsFromCore()));
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
        TPPlayerEventInfo.BufferingEndEventInfo bufferingEndEventInfo = (TPPlayerEventInfo.BufferingEndEventInfo) baseEventInfo;
        this.mIsBuffering = false;
        if (this.mIsSeeking) {
            return;
        }
        long eventTimeSinceBootMs = bufferingEndEventInfo.getEventTimeSinceBootMs() - this.mReportParamRecord.mBufferingStartOccurElapsedTimeMs;
        TPLogUtil.i(TAG, "Vod onBufferingEnd bufferingCostTimeMs:" + eventTimeSinceBootMs);
        if (eventTimeSinceBootMs <= 1200) {
            return;
        }
        TPVodReportParamRecord tPVodReportParamRecord = this.mReportParamRecord;
        tPVodReportParamRecord.mBufferingTotalCount++;
        tPVodReportParamRecord.mBufferingTotalDurationMs = (int) (tPVodReportParamRecord.mBufferingTotalDurationMs + eventTimeSinceBootMs);
        TPVodBufferingParams tPVodBufferingParams = new TPVodBufferingParams();
        tPVodBufferingParams.setPlaySpeed(this.mReportParamRecord.mPlaySpeed);
        tPVodBufferingParams.setCostTimeMs(eventTimeSinceBootMs);
        this.mReportUtils.updateCommonParams(this.mReportParamRecord.mCommonParams);
        TPCommonParams tPCommonParams = this.mReportParamRecord.mCommonParams;
        int i3 = this.mReportEventSeq;
        this.mReportEventSeq = i3 + 1;
        tPCommonParams.setSeq(i3);
        tPVodBufferingParams.copyCommonParams(this.mReportParamRecord.mCommonParams);
        Map<String, String> fillParamsToMap = tPVodBufferingParams.fillParamsToMap();
        dumpMapInfo("onBufferingEnd", fillParamsToMap);
        reportToBeaconIfNeed(TPReportEventId.TP_REPORT_EVENT_VOD_BUFFERING, fillParamsToMap);
    }

    private void onBufferingStart(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        if (!(baseEventInfo instanceof TPPlayerEventInfo.BufferingStartEventInfo)) {
            TPLogUtil.e(TAG, "onBufferingStart fail:params is not match");
            return;
        }
        TPPlayerEventInfo.BufferingStartEventInfo bufferingStartEventInfo = (TPPlayerEventInfo.BufferingStartEventInfo) baseEventInfo;
        this.mIsBuffering = true;
        if (this.mIsSeeking) {
            return;
        }
        this.mReportParamRecord.mBufferingStartOccurElapsedTimeMs = bufferingStartEventInfo.getEventTimeSinceBootMs();
        TPLogUtil.i(TAG, "Vod onBufferingStart timeMs:" + this.mReportParamRecord.mBufferingStartOccurElapsedTimeMs);
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
        TPVodReportParamRecord tPVodReportParamRecord = this.mReportParamRecord;
        tPVodReportParamRecord.mDTCdnIp = cdnIp;
        tPVodReportParamRecord.mDTUserIp = userIp;
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

    private void onDrmInfo(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        if (!(baseEventInfo instanceof TPPlayerEventInfo.DrmEventInfo)) {
            TPLogUtil.e(TAG, "onDrmInfo fail:params is not match");
        } else {
            reportVodDrmInfoEvent(((TPPlayerEventInfo.DrmEventInfo) baseEventInfo).getDrmPlayFlow());
        }
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

    private void onPlayerPause(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        if (!(baseEventInfo instanceof TPPlayerEventInfo.PlayPauseEventInfo)) {
            TPLogUtil.e(TAG, "onPlayerPause fail:params is not match");
            return;
        }
        TPPlayerEventInfo.PlayPauseEventInfo playPauseEventInfo = (TPPlayerEventInfo.PlayPauseEventInfo) baseEventInfo;
        if (this.mIsPausing) {
            TPLogUtil.e(TAG, "onPlayerPause has been called");
            return;
        }
        this.mIsPausing = true;
        this.mReportParamRecord.mPauseStartOccurElapsedTimeMs = playPauseEventInfo.getEventTimeSinceBootMs();
        TPLogUtil.i(TAG, "Vod onPlayerPause timeMs:" + this.mReportParamRecord.mPauseStartOccurElapsedTimeMs);
    }

    private void onPlayerStart(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        if (!(baseEventInfo instanceof TPPlayerEventInfo.PlayStartEventInfo)) {
            TPLogUtil.e(TAG, "onPlayerStart fail:params is not match");
            return;
        }
        TPPlayerEventInfo.PlayStartEventInfo playStartEventInfo = (TPPlayerEventInfo.PlayStartEventInfo) baseEventInfo;
        this.mIsPlayDone = false;
        this.mIsPausing = false;
        TPVodReportParamRecord tPVodReportParamRecord = this.mReportParamRecord;
        if (tPVodReportParamRecord.mPlayerFirstStartOccurElapsedTimeMs == 0) {
            tPVodReportParamRecord.mPlayerFirstStartOccurElapsedTimeMs = playStartEventInfo.getEventTimeSinceBootMs();
        }
        this.mReportParamRecord.mPlayerStartOccurElapsedTimeMs = playStartEventInfo.getEventTimeSinceBootMs();
        TPLogUtil.i(TAG, "Vod onPlayerStart timeMs:" + this.mReportParamRecord.mPlayerStartOccurElapsedTimeMs);
        TPVodReportParamRecord tPVodReportParamRecord2 = this.mReportParamRecord;
        if (tPVodReportParamRecord2.mPauseStartOccurElapsedTimeMs > 0) {
            long j3 = tPVodReportParamRecord2.mPauseTotalDurationMs;
            long eventTimeSinceBootMs = playStartEventInfo.getEventTimeSinceBootMs();
            TPVodReportParamRecord tPVodReportParamRecord3 = this.mReportParamRecord;
            tPVodReportParamRecord2.mPauseTotalDurationMs = j3 + (eventTimeSinceBootMs - tPVodReportParamRecord3.mPauseStartOccurElapsedTimeMs);
            tPVodReportParamRecord3.mPauseStartOccurElapsedTimeMs = 0L;
        }
    }

    private void onPrepareDone(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        if (!(baseEventInfo instanceof TPPlayerEventInfo.PrepareEndEventInfo)) {
            TPLogUtil.e(TAG, "onPrepareDone fail:params is not match");
            return;
        }
        TPPlayerEventInfo.PrepareEndEventInfo prepareEndEventInfo = (TPPlayerEventInfo.PrepareEndEventInfo) baseEventInfo;
        long eventTimeSinceBootMs = prepareEndEventInfo.getEventTimeSinceBootMs() - this.mReporterInitParams.mTPPrepareStartOccurElapsedTimeMs;
        this.mReportParamRecord.mPrepareEndOccurElapsedTimeMs = prepareEndEventInfo.getEventTimeSinceBootMs();
        TPLogUtil.i(TAG, "Vod onPrepareDone timeMs:" + eventTimeSinceBootMs);
        fillStreamInfoToCommonParams(this.mReportParamRecord);
        TPCommonParams tPCommonParams = this.mReportParamRecord.mCommonParams;
        int i3 = this.mReportEventSeq;
        this.mReportEventSeq = i3 + 1;
        tPCommonParams.setSeq(i3);
        this.mReportUtils.updateCommonParams(this.mReportParamRecord.mCommonParams);
        fillInitExtReportInfoToCommonParams(this.mReportParamRecord);
        TPVodFirstLoadParams tPVodFirstLoadParams = new TPVodFirstLoadParams();
        tPVodFirstLoadParams.setCostTimeMs(eventTimeSinceBootMs);
        tPVodFirstLoadParams.copyCommonParams(this.mReportParamRecord.mCommonParams);
        Map<String, String> fillParamsToMap = tPVodFirstLoadParams.fillParamsToMap();
        dumpMapInfo("onPrepareDone", fillParamsToMap);
        reportToBeaconIfNeed(TPReportEventId.TP_REPORT_EVENT_VOD_FIRST_LOAD, fillParamsToMap);
    }

    private void onSeekEnd(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        if (!(baseEventInfo instanceof TPPlayerEventInfo.SeekEndEventInfo)) {
            TPLogUtil.e(TAG, "onSeekEnd fail:params is not match");
            return;
        }
        this.mIsSeeking = false;
        long eventTimeSinceBootMs = ((TPPlayerEventInfo.SeekEndEventInfo) baseEventInfo).getEventTimeSinceBootMs();
        TPVodReportParamRecord tPVodReportParamRecord = this.mReportParamRecord;
        long j3 = eventTimeSinceBootMs - tPVodReportParamRecord.mSeekStartOccurElapsedTimeMs;
        if (j3 > 1200) {
            tPVodReportParamRecord.mSeekBufferingTotalCount++;
            tPVodReportParamRecord.mSeekBufferingTotalDurationMs = (int) (tPVodReportParamRecord.mSeekBufferingTotalDurationMs + j3);
        }
        tPVodReportParamRecord.mSeekTotalCount++;
        TPLogUtil.i(TAG, "Vod onSeekEnd seekCostTimeMs:" + j3 + " mSeekTotalCount:" + this.mReportParamRecord.mSeekTotalCount + " mSeekBufferingTotalCount:" + this.mReportParamRecord.mSeekBufferingTotalCount + " mSeekBufferingTotalDurationMs:" + this.mReportParamRecord.mSeekBufferingTotalDurationMs);
    }

    private void onSeekStart(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        if (!(baseEventInfo instanceof TPPlayerEventInfo.SeekStartEventInfo)) {
            TPLogUtil.e(TAG, "onSeekStart fail:params is not match");
            return;
        }
        if (this.mIsBuffering) {
            onBufferingEnd(new TPPlayerEventInfo.BufferingEndEventInfo());
        }
        if (this.mIsSeeking) {
            onSeekEnd(new TPPlayerEventInfo.SeekEndEventInfo());
        }
        this.mIsSeeking = true;
        this.mReportParamRecord.mSeekStartOccurElapsedTimeMs = ((TPPlayerEventInfo.SeekStartEventInfo) baseEventInfo).getEventTimeSinceBootMs();
        TPLogUtil.i(TAG, "Vod onSeekStart timeMs:" + this.mReportParamRecord.mSeekStartOccurElapsedTimeMs);
    }

    private void onSelectTrackEnd(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        if (!(baseEventInfo instanceof TPPlayerEventInfo.SelectTrackEndEventInfo)) {
            TPLogUtil.e(TAG, "onSelectTrackEnd fail:params is not match");
            return;
        }
        TPPlayerEventInfo.SelectTrackEndEventInfo selectTrackEndEventInfo = (TPPlayerEventInfo.SelectTrackEndEventInfo) baseEventInfo;
        int errorCode = selectTrackEndEventInfo.getError().getErrorCode();
        long opaque = selectTrackEndEventInfo.getOpaque();
        TPLogUtil.i(TAG, "Vod onSelectTrackEnd errorCode:" + errorCode + " trackUniqueIndex:" + opaque);
        reportSelectTrackEndEvent(opaque, selectTrackEndEventInfo.getEventTimeSinceBootMs(), errorCode);
    }

    private void onSelectTrackStart(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        if (!(baseEventInfo instanceof TPPlayerEventInfo.SelectTrackStartEventInfo)) {
            TPLogUtil.e(TAG, "onSelectTrackStart fail:params is not match");
            return;
        }
        TPPlayerEventInfo.SelectTrackStartEventInfo selectTrackStartEventInfo = (TPPlayerEventInfo.SelectTrackStartEventInfo) baseEventInfo;
        int trackIndex = selectTrackStartEventInfo.getTrackIndex();
        long opaque = selectTrackStartEventInfo.getOpaque();
        TPLogUtil.i(TAG, "Vod onSelectTrackStart trackId:" + trackIndex + " trackUniqueIndex:" + opaque);
        if (this.mReportParamRecord.mSelectTrackInfoList.containsKey(Long.valueOf(opaque))) {
            return;
        }
        TPVodReportParamRecord.TPSelectTrackInfo tPSelectTrackInfo = new TPVodReportParamRecord.TPSelectTrackInfo();
        tPSelectTrackInfo.mSelectTrackId = trackIndex;
        tPSelectTrackInfo.mTrackInfo = selectTrackStartEventInfo.getTrackInfo();
        tPSelectTrackInfo.mSelectTrackStartOccurElapsedTimeMs = selectTrackStartEventInfo.getEventTimeSinceBootMs();
        this.mReportParamRecord.mSelectTrackInfoList.put(Long.valueOf(selectTrackStartEventInfo.getOpaque()), tPSelectTrackInfo);
    }

    private void onSetPlaySpeed(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        if (!(baseEventInfo instanceof TPPlayerEventInfo.SetPlaySpeedEventInfo)) {
            TPLogUtil.e(TAG, "onSetPlaySpeed fail:params is not match");
            return;
        }
        this.mReportParamRecord.mPlaySpeed = ((TPPlayerEventInfo.SetPlaySpeedEventInfo) baseEventInfo).getPlaySpeedRatio();
        TPLogUtil.i(TAG, "Vod onSetPlaySpeed mPlaySpeed:" + this.mReportParamRecord.mPlaySpeed);
    }

    private void reportPlayerEndEvent(long j3, int i3, @NonNull TPGeneralPlayFlowParams tPGeneralPlayFlowParams, @NonNull TPDynamicStatisticParams tPDynamicStatisticParams) {
        if (this.mIsBuffering) {
            onBufferingEnd(new TPPlayerEventInfo.BufferingEndEventInfo());
            this.mIsBuffering = false;
        }
        if (this.mIsSeeking) {
            onSeekEnd(new TPPlayerEventInfo.SeekEndEventInfo());
            this.mIsSeeking = false;
        }
        if (this.mIsPausing) {
            TPVodReportParamRecord tPVodReportParamRecord = this.mReportParamRecord;
            if (tPVodReportParamRecord.mPauseStartOccurElapsedTimeMs > 0) {
                long j16 = tPVodReportParamRecord.mPauseTotalDurationMs;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                TPVodReportParamRecord tPVodReportParamRecord2 = this.mReportParamRecord;
                tPVodReportParamRecord.mPauseTotalDurationMs = j16 + (elapsedRealtime - tPVodReportParamRecord2.mPauseStartOccurElapsedTimeMs);
                tPVodReportParamRecord2.mPauseStartOccurElapsedTimeMs = 0L;
            }
            this.mIsPausing = false;
        }
        TPLogUtil.i(TAG, "reportPlayerEndEvent playerStopTimeMs:" + j3 + " errorCode:" + i3);
        reportVodEndFlowEvent(tPGeneralPlayFlowParams, tPDynamicStatisticParams);
        reportVodEndEvent(j3, i3, tPGeneralPlayFlowParams);
    }

    private void reportSelectTrackEndEvent(long j3, long j16, int i3) {
        if (!this.mReportParamRecord.mSelectTrackInfoList.containsKey(Long.valueOf(j3))) {
            TPLogUtil.e(TAG, "reportSelectTrackEndEvent mSelectTrackInfoList is not contain key:" + j3);
            return;
        }
        TPVodReportParamRecord.TPSelectTrackInfo tPSelectTrackInfo = this.mReportParamRecord.mSelectTrackInfoList.get(Long.valueOf(j3));
        long j17 = j16 - tPSelectTrackInfo.mSelectTrackStartOccurElapsedTimeMs;
        TPLogUtil.i(TAG, "reportSelectTrackEndEvent trackUniqueIndex:" + j3 + " costTimeMs:" + j17 + " trackId:" + tPSelectTrackInfo.mSelectTrackId);
        TPVodSelectTrackParams tPVodSelectTrackParams = new TPVodSelectTrackParams();
        tPVodSelectTrackParams.setErrorCode(i3);
        tPVodSelectTrackParams.setCostTimeMs(j17);
        TPTrackInfo tPTrackInfo = tPSelectTrackInfo.mTrackInfo;
        if (tPTrackInfo != null) {
            tPVodSelectTrackParams.setMediaType(tPTrackInfo.getMediaType());
            tPVodSelectTrackParams.setAttachFormat(tPSelectTrackInfo.mTrackInfo.isInternal() ? 1 : 0);
        }
        this.mReportUtils.updateCommonParams(this.mReportParamRecord.mCommonParams);
        TPCommonParams tPCommonParams = this.mReportParamRecord.mCommonParams;
        int i16 = this.mReportEventSeq;
        this.mReportEventSeq = i16 + 1;
        tPCommonParams.setSeq(i16);
        tPVodSelectTrackParams.copyCommonParams(this.mReportParamRecord.mCommonParams);
        Map<String, String> fillParamsToMap = tPVodSelectTrackParams.fillParamsToMap();
        dumpMapInfo("onSelectTrackEnd", fillParamsToMap);
        reportToBeaconIfNeed(TPReportEventId.TP_REPORT_EVENT_VOD_SELECT_TRACK, fillParamsToMap);
        this.mReportParamRecord.mSelectTrackInfoList.remove(Long.valueOf(j3));
    }

    private void reportVodDrmInfoEvent(@NonNull TPGeneralPlayFlowParams.TPPlayerDrmParams tPPlayerDrmParams) {
        Map<String, String> fillParamsToMap = getVodDrmParams(tPPlayerDrmParams).fillParamsToMap();
        dumpMapInfo("reportPlayerDrmInfoEvent", fillParamsToMap);
        reportToBeaconIfNeed(TPReportEventId.TP_REPORT_EVENT_VOD_DRM, fillParamsToMap);
    }

    private void reportVodEndEvent(long j3, int i3, @NonNull TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
        Map<String, String> fillParamsToMap = getVodEndParams(j3, i3, tPGeneralPlayFlowParams).fillParamsToMap();
        dumpMapInfo("reportVodEndEvent", fillParamsToMap);
        reportToBeaconIfNeed(TPReportEventId.TP_REPORT_EVENT_VOD_END, fillParamsToMap);
    }

    private void reportVodEndFlowEvent(@NonNull TPGeneralPlayFlowParams tPGeneralPlayFlowParams, @NonNull TPDynamicStatisticParams tPDynamicStatisticParams) {
        Map<String, String> fillParamsToMap = getVodPlayFlowParams(tPGeneralPlayFlowParams, tPDynamicStatisticParams).fillParamsToMap();
        dumpMapInfo("reportVodEndFlowEvent", fillParamsToMap);
        reportToBeaconIfNeed(TPReportEventId.TP_REPORT_EVENT_VOD_FLOW, fillParamsToMap);
    }

    @Override // com.tencent.thumbplayer.report.reportv2.TPBaseReporter, com.tencent.thumbplayer.report.reportv2.ITPReporter
    public void init(@NonNull Context context, @NonNull TPReporterInitParams tPReporterInitParams) {
        super.init(context, tPReporterInitParams);
        this.mReportUtils.initDeviceParams(this.mReportParamRecord.mCommonParams);
    }

    @Override // com.tencent.thumbplayer.report.reportv2.TPBaseReporter, com.tencent.thumbplayer.report.reportv2.ITPReporter
    public void onEvent(int i3, TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        if (i3 != 1001) {
            if (i3 != 1002) {
                switch (i3) {
                    case 2:
                        onPrepareDone(baseEventInfo);
                        return;
                    case 3:
                        onPlayerStart(baseEventInfo);
                        return;
                    case 4:
                        onPlayerPause(baseEventInfo);
                        return;
                    case 5:
                        onPlayerEnd(baseEventInfo);
                        return;
                    case 6:
                        onPlayerError(baseEventInfo);
                        return;
                    case 7:
                        onSeekStart(baseEventInfo);
                        return;
                    case 8:
                        onSeekEnd(baseEventInfo);
                        return;
                    case 9:
                        onBufferingStart(baseEventInfo);
                        return;
                    case 10:
                        onBufferingEnd(baseEventInfo);
                        return;
                    case 11:
                        onSelectTrackStart(baseEventInfo);
                        return;
                    case 12:
                        onSelectTrackEnd(baseEventInfo);
                        return;
                    case 13:
                        onSetPlaySpeed(baseEventInfo);
                        return;
                    case 14:
                        onDrmInfo(baseEventInfo);
                        return;
                    default:
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
            }
            onAppBackground();
            return;
        }
        onAppForeground();
    }

    @Override // com.tencent.thumbplayer.report.reportv2.TPBaseReporter, com.tencent.thumbplayer.report.reportv2.ITPReporter
    public void reset() {
        super.reset();
    }
}
