package com.tencent.thumbplayer.report.reportv2;

import android.content.Context;
import com.tencent.thumbplayer.common.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.common.TPVersion;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.event.TPPlayerEventInfo;
import com.tencent.thumbplayer.report.reportv2.data.TPPrepareFailParams;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes26.dex */
public class TPPrepareFailReporter extends TPBaseReporter {
    private static final String TAG = "TPPrepareFailReporter";
    private static final int UN_USE_PROXY = 0;
    private static final int USE_PROXY = 1;
    private TPBaseReportParamRecord mReportParamRecord = new TPBaseReportParamRecord();

    private void fillStreamInfoToCommonParams() {
        if (this.mPlayerInfoGetter == null) {
            TPLogUtil.e(TAG, "fillStreamInfoToCommonParams fail, not set mPlayerInfoGetter");
            return;
        }
        this.mReportParamRecord.mCommonParams.setFlowId(this.mReporterInitParams.mPlayFlowId);
        this.mReportParamRecord.mCommonParams.setPlayerType(this.mReporterInitParams.mPlayerType);
        this.mReportParamRecord.mCommonParams.setUrl(this.mReporterInitParams.mOriginalUrl);
        this.mReportParamRecord.mCommonParams.setDataTransportVer(TPVersion.getDataTransportVersion());
        TPBaseReportParamRecord tPBaseReportParamRecord = this.mReportParamRecord;
        tPBaseReportParamRecord.mCommonParams.setSpeedKbps(tPBaseReportParamRecord.mDTSpeedKbps);
        TPBaseReportParamRecord tPBaseReportParamRecord2 = this.mReportParamRecord;
        tPBaseReportParamRecord2.mCommonParams.setDataTransportProtocolVer(tPBaseReportParamRecord2.mDTProtocolVer);
        TPBaseReportParamRecord tPBaseReportParamRecord3 = this.mReportParamRecord;
        tPBaseReportParamRecord3.mCommonParams.setCdnUip(tPBaseReportParamRecord3.mDTUserIp);
        TPBaseReportParamRecord tPBaseReportParamRecord4 = this.mReportParamRecord;
        tPBaseReportParamRecord4.mCommonParams.setCdnIp(tPBaseReportParamRecord4.mDTCdnIp);
        this.mReportParamRecord.mCommonParams.setUseDataTransport(this.mReporterInitParams.mIsUseProxy);
        TPGeneralPlayFlowParams generalPlayFlowParams = this.mPlayerInfoGetter.getGeneralPlayFlowParams();
        this.mPlayerConfigKeyValueMap.put("buffermintotaldurationms", Long.valueOf(generalPlayFlowParams.mPlayerConfigParams.mBufferMinTotalDurationMs));
        this.mPlayerConfigKeyValueMap.put("buffermaxtotaldurationms", Long.valueOf(generalPlayFlowParams.mPlayerConfigParams.mBufferMaxTotalDurationMs));
        this.mPlayerConfigKeyValueMap.put("preloadtotaldurationms", Long.valueOf(generalPlayFlowParams.mPlayerConfigParams.mPreloadTotalDurationMs));
        this.mPlayerConfigKeyValueMap.put("minbufferingdurationms", Long.valueOf(generalPlayFlowParams.mPlayerConfigParams.mMinBufferingDurationMs));
        this.mPlayerConfigKeyValueMap.put("minbufferingtimems", Long.valueOf(generalPlayFlowParams.mPlayerConfigParams.mMinBufferingTimeMs));
        this.mPlayerConfigKeyValueMap.put("maxbufferingtimems", Long.valueOf(generalPlayFlowParams.mPlayerConfigParams.mMaxBufferingTimeMs));
        this.mPlayerConfigKeyValueMap.put("reducelatencyaction", Integer.valueOf(generalPlayFlowParams.mPlayerConfigParams.mReduceLatencyAction));
        this.mPlayerConfigKeyValueMap.put("reducelatencyspeed", Float.valueOf(generalPlayFlowParams.mPlayerConfigParams.mReduceLatencyPlaySpeed));
        this.mPlayerConfigKeyValueMap.put("buffertype", Integer.valueOf(generalPlayFlowParams.mPlayerConfigParams.mBufferType));
        try {
            this.mReportParamRecord.mCommonParams.setPlayerConfig(new JSONObject(this.mPlayerConfigKeyValueMap).toString());
        } catch (NullPointerException e16) {
            TPLogUtil.e(TAG, e16);
        }
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
        TPBaseReportParamRecord tPBaseReportParamRecord = this.mReportParamRecord;
        tPBaseReportParamRecord.mDTCdnIp = cdnIp;
        tPBaseReportParamRecord.mDTUserIp = userIp;
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

    private void onPrepareError(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        if (!(baseEventInfo instanceof TPPlayerEventInfo.PlayErrorEventInfo)) {
            TPLogUtil.e(TAG, "onPrepareError fail:params is not match");
            return;
        }
        TPPlayerEventInfo.PlayErrorEventInfo playErrorEventInfo = (TPPlayerEventInfo.PlayErrorEventInfo) baseEventInfo;
        int errorType = playErrorEventInfo.getError().getErrorType();
        int errorCode = playErrorEventInfo.getError().getErrorCode();
        TPLogUtil.i(TAG, "onPrepareError errorType:" + errorType + " errorCode:" + errorCode);
        TPPrepareFailParams tPPrepareFailParams = new TPPrepareFailParams();
        tPPrepareFailParams.setErrorCode(errorCode);
        fillStreamInfoToCommonParams();
        fillInitExtReportInfoToCommonParams(this.mReportParamRecord);
        this.mReportUtils.updateCommonParams(this.mReportParamRecord.mCommonParams);
        tPPrepareFailParams.copyCommonParams(this.mReportParamRecord.mCommonParams);
        Map<String, String> fillParamsToMap = tPPrepareFailParams.fillParamsToMap();
        dumpMapInfo("onPrepareError", fillParamsToMap);
        reportToBeaconIfNeed(TPReportEventId.TP_REPORT_EVENT_PREPARE_FAIL, fillParamsToMap);
    }

    @Override // com.tencent.thumbplayer.report.reportv2.TPBaseReporter, com.tencent.thumbplayer.report.reportv2.ITPReporter
    public void init(Context context, TPReporterInitParams tPReporterInitParams) {
        super.init(context, tPReporterInitParams);
        this.mReportUtils.initDeviceParams(this.mReportParamRecord.mCommonParams);
    }

    @Override // com.tencent.thumbplayer.report.reportv2.TPBaseReporter, com.tencent.thumbplayer.report.reportv2.ITPReporter
    public void onEvent(int i3, TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        if (i3 != 6) {
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
        onPrepareError(baseEventInfo);
    }

    @Override // com.tencent.thumbplayer.report.reportv2.TPBaseReporter, com.tencent.thumbplayer.report.reportv2.ITPReporter
    public void reset() {
        super.reset();
    }
}
