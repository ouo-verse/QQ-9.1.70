package com.tencent.thumbplayer.report.reportv2;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.report.v2.ITPReportInfoGetter;
import com.tencent.thumbplayer.api.report.v2.TPReportExtendedCommonKey;
import com.tencent.thumbplayer.common.TPDynamicStatisticParams;
import com.tencent.thumbplayer.common.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.common.TPVersion;
import com.tencent.thumbplayer.common.cache.TPLocalCacheReaderWriter;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.event.TPPlayerEventInfo;
import com.tencent.thumbplayer.report.TPBeaconReportWrapper;
import com.tencent.thumbplayer.report.reportv2.data.TPCommonParams;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes26.dex */
public class TPBaseReporter implements ITPReporter {
    protected static final String CONFIG_NAME_BUFFER_MAX_DURATION = "buffermaxtotaldurationms";
    protected static final String CONFIG_NAME_BUFFER_MIN_DURATION = "buffermintotaldurationms";
    protected static final String CONFIG_NAME_BUFFER_TYPE = "buffertype";
    protected static final String CONFIG_NAME_MAX_BUFFERING_TIME = "maxbufferingtimems";
    protected static final String CONFIG_NAME_MIN_BUFFERING_DURATION = "minbufferingdurationms";
    protected static final String CONFIG_NAME_MIN_BUFFERING_TIME = "minbufferingtimems";
    protected static final String CONFIG_NAME_PRELOAD_DURATION = "preloadtotaldurationms";
    protected static final String CONFIG_NAME_REDUCE_LATENCY_ACTION = "reducelatencyaction";
    protected static final String CONFIG_NAME_REDUCE_LATENCY_SPEED = "reducelatencyspeed";
    private static final String REPORT_CACHE_NAME = "TPReporterCache";
    private static final String TAG = "TPBaseReporter";
    private static TPLocalCacheReaderWriter mCache;
    protected Context mContext;
    protected ITPPlayerInfoGetter mPlayerInfoGetter;
    protected ITPReportInfoGetter mReportInfoGetter;
    protected TPReporterInitParams mReporterInitParams;
    protected TPReportUtils mReportUtils = null;
    protected int mReportEventSeq = 0;
    protected Map<String, Object> mPlayerConfigKeyValueMap = new HashMap();

    private static String analyseReportIdFromCacheKey(@NonNull String str) {
        for (Field field : TPReportEventId.class.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.getType() == String.class) {
                try {
                    String str2 = (String) field.get(TPReportEventId.class);
                    if (str2 != null && str.endsWith(str2)) {
                        return str2;
                    }
                } catch (IllegalAccessException unused) {
                    TPLogUtil.w(TAG, "fail to get value of field(" + field.getName() + ") in TPReportEventId.class)");
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void classifyMapIntoRsvExtMapAndExtMap(@NonNull Map<String, String> map, @NonNull Map<String, String> map2, @NonNull Map<String, String> map3) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (isValidRsvExtKey(entry.getKey())) {
                map2.put(entry.getKey(), entry.getValue());
            } else if (isValidExtKey(entry.getKey())) {
                map3.put(entry.getKey(), entry.getValue());
            } else {
                TPLogUtil.e(TAG, "invalid extend info <" + entry.getKey() + ", " + entry.getValue() + "> from ITPReportInfoGetter, key valid!");
            }
        }
    }

    private synchronized void createLocalCache(@NonNull Context context, @NonNull String str) {
        if (mCache != null) {
            return;
        }
        mCache = new TPLocalCacheReaderWriter(this.mContext, str);
    }

    protected static boolean isValidExtKey(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("ext_");
    }

    protected static boolean isValidRsvExtKey(String str) {
        if (str == null) {
            return false;
        }
        for (Field field : TPReportExtendedCommonKey.class.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                String str2 = (String) field.get(TPReportExtendedCommonKey.class);
                if (str2 != null && str2.equals(str)) {
                    return true;
                }
            } catch (IllegalAccessException e16) {
                TPLogUtil.e(TAG, e16);
            }
        }
        return false;
    }

    private synchronized void reportAndClearCache() {
        TPLocalCacheReaderWriter tPLocalCacheReaderWriter = mCache;
        if (tPLocalCacheReaderWriter == null) {
            return;
        }
        Iterator<String> it = tPLocalCacheReaderWriter.getKeyList().iterator();
        while (it.hasNext()) {
            String next = it.next();
            String analyseReportIdFromCacheKey = analyseReportIdFromCacheKey(next);
            TPCommonParams tPCommonParams = (TPCommonParams) mCache.read(next);
            if (analyseReportIdFromCacheKey != null && tPCommonParams != null) {
                TPBeaconReportWrapper.trackCustomKVEvent(analyseReportIdFromCacheKey, tPCommonParams.fillParamsToMap());
                TPLogUtil.i(TAG, "report cached reportEvent, key:" + next);
            }
        }
        mCache.clearAll();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void cacheReport(@NonNull String str, @NonNull TPCommonParams tPCommonParams) {
        if (mCache != null && this.mReporterInitParams.mNeedReportToBeacon.booleanValue()) {
            mCache.write(tPCommonParams.getFlowId() + str, tPCommonParams);
            TPLogUtil.i(TAG, "write cache, flowid:" + tPCommonParams.getFlowId() + ", reportId:" + str);
            return;
        }
        TPLogUtil.i(TAG, "mCache is null or does not need to report to beacon, no caching!");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dumpMapInfo(String str, @NonNull Map<String, String> map) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append(":{");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb5.append(key);
            sb5.append(":");
            sb5.append(value);
            sb5.append(",");
        }
        sb5.append("}");
        TPLogUtil.i(TAG, sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fillInitExtReportInfoToCommonParams(@NonNull TPBaseReportParamRecord tPBaseReportParamRecord) {
        ITPReportInfoGetter iTPReportInfoGetter = this.mReportInfoGetter;
        if (iTPReportInfoGetter == null) {
            return;
        }
        Map<String, String> initExtendedReportInfo = iTPReportInfoGetter.getInitExtendedReportInfo();
        if (initExtendedReportInfo == null) {
            TPLogUtil.e(TAG, "fillInitExtReportInfoToCommonParams fail, initExtendReportInfo is null");
            return;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        classifyMapIntoRsvExtMapAndExtMap(initExtendedReportInfo, hashMap, hashMap2);
        tPBaseReportParamRecord.mCommonParams.setInitRsvExtFields(hashMap);
        tPBaseReportParamRecord.mCommonParams.setInitExtFields(hashMap2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fillStreamInfoToCommonParams(TPBaseReportParamRecord tPBaseReportParamRecord) {
        ITPPlayerInfoGetter iTPPlayerInfoGetter = this.mPlayerInfoGetter;
        if (iTPPlayerInfoGetter == null) {
            TPLogUtil.e(TAG, "fillStreamInfoToCommonParams fail, not set mPlayerInfoGetter");
            return;
        }
        TPGeneralPlayFlowParams generalPlayFlowParams = iTPPlayerInfoGetter.getGeneralPlayFlowParams();
        tPBaseReportParamRecord.mCommonParams.setFlowId(this.mReporterInitParams.mPlayFlowId);
        tPBaseReportParamRecord.mCommonParams.setDurationMs(generalPlayFlowParams.mPlayerBaseMediaParams.mDurationMs);
        tPBaseReportParamRecord.mCommonParams.setHlsSourceType(generalPlayFlowParams.mPlayerBaseMediaParams.mHlsSourceType);
        tPBaseReportParamRecord.mCommonParams.setPlayerType(this.mReporterInitParams.mPlayerType);
        tPBaseReportParamRecord.mCommonParams.setUrlProtocol(this.mReporterInitParams.mUrlProtocol);
        tPBaseReportParamRecord.mCommonParams.setContainerFormat(generalPlayFlowParams.mPlayerBaseMediaParams.mFormatContainer);
        tPBaseReportParamRecord.mCommonParams.setVideoEncodeFmt(generalPlayFlowParams.mPlayerBaseMediaParams.mVideoEncodeFormat);
        tPBaseReportParamRecord.mCommonParams.setAudioEncodeFmt(generalPlayFlowParams.mPlayerBaseMediaParams.mAudioEncodeFormat);
        tPBaseReportParamRecord.mCommonParams.setSubtitleEncodeFmt(generalPlayFlowParams.mPlayerBaseMediaParams.mSubtitleEncodeFormat);
        tPBaseReportParamRecord.mCommonParams.setStreamBitrateKbps(generalPlayFlowParams.mPlayerBaseMediaParams.mVideoStreamBitrateKbps);
        tPBaseReportParamRecord.mCommonParams.setVideoFrameRate(generalPlayFlowParams.mPlayerBaseMediaParams.mVideoFrameRate);
        tPBaseReportParamRecord.mCommonParams.setUrl(this.mReporterInitParams.mOriginalUrl);
        tPBaseReportParamRecord.mCommonParams.setResolution("" + generalPlayFlowParams.mPlayerBaseMediaParams.mVideoWidth + "*" + generalPlayFlowParams.mPlayerBaseMediaParams.mVideoHeight);
        tPBaseReportParamRecord.mCommonParams.setDataTransportVer(TPVersion.getDataTransportVersion());
        tPBaseReportParamRecord.mCommonParams.setSpeedKbps(tPBaseReportParamRecord.mDTSpeedKbps);
        tPBaseReportParamRecord.mCommonParams.setDataTransportProtocolVer(tPBaseReportParamRecord.mDTProtocolVer);
        tPBaseReportParamRecord.mCommonParams.setCdnUip(tPBaseReportParamRecord.mDTUserIp);
        tPBaseReportParamRecord.mCommonParams.setCdnIp(tPBaseReportParamRecord.mDTCdnIp);
        tPBaseReportParamRecord.mCommonParams.setUseDataTransport(this.mReporterInitParams.mIsUseProxy);
        this.mPlayerConfigKeyValueMap.put(CONFIG_NAME_BUFFER_MIN_DURATION, Long.valueOf(generalPlayFlowParams.mPlayerConfigParams.mBufferMinTotalDurationMs));
        this.mPlayerConfigKeyValueMap.put(CONFIG_NAME_BUFFER_MAX_DURATION, Long.valueOf(generalPlayFlowParams.mPlayerConfigParams.mBufferMaxTotalDurationMs));
        this.mPlayerConfigKeyValueMap.put(CONFIG_NAME_PRELOAD_DURATION, Long.valueOf(generalPlayFlowParams.mPlayerConfigParams.mPreloadTotalDurationMs));
        this.mPlayerConfigKeyValueMap.put(CONFIG_NAME_MIN_BUFFERING_DURATION, Long.valueOf(generalPlayFlowParams.mPlayerConfigParams.mMinBufferingDurationMs));
        this.mPlayerConfigKeyValueMap.put(CONFIG_NAME_MIN_BUFFERING_TIME, Long.valueOf(generalPlayFlowParams.mPlayerConfigParams.mMinBufferingTimeMs));
        this.mPlayerConfigKeyValueMap.put(CONFIG_NAME_MAX_BUFFERING_TIME, Long.valueOf(generalPlayFlowParams.mPlayerConfigParams.mMaxBufferingTimeMs));
        this.mPlayerConfigKeyValueMap.put(CONFIG_NAME_REDUCE_LATENCY_ACTION, Integer.valueOf(generalPlayFlowParams.mPlayerConfigParams.mReduceLatencyAction));
        this.mPlayerConfigKeyValueMap.put(CONFIG_NAME_REDUCE_LATENCY_SPEED, Float.valueOf(generalPlayFlowParams.mPlayerConfigParams.mReduceLatencyPlaySpeed));
        this.mPlayerConfigKeyValueMap.put(CONFIG_NAME_BUFFER_TYPE, Integer.valueOf(generalPlayFlowParams.mPlayerConfigParams.mBufferType));
        try {
            tPBaseReportParamRecord.mCommonParams.setPlayerConfig(new JSONObject(this.mPlayerConfigKeyValueMap).toString());
        } catch (NullPointerException e16) {
            TPLogUtil.e(TAG, e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public TPDynamicStatisticParams getDynamicStatisticParamsFromCore(boolean z16) {
        ITPPlayerInfoGetter iTPPlayerInfoGetter = this.mPlayerInfoGetter;
        if (iTPPlayerInfoGetter == null) {
            TPLogUtil.e(TAG, "getDynamicStatParamsFromCore failed, mPlayerInfoGetter is null, return default value");
            return new TPDynamicStatisticParams();
        }
        return iTPPlayerInfoGetter.getDynamicStatisticParams(z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public TPDynamicStatisticParams getDynamicStatisticParamsFromEventInfo(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        TPDynamicStatisticParams tPDynamicStatisticParams;
        if (baseEventInfo instanceof TPPlayerEventInfo.PlayStopEventInfo) {
            tPDynamicStatisticParams = ((TPPlayerEventInfo.PlayStopEventInfo) baseEventInfo).getDynamicStatisticParams();
        } else if (baseEventInfo instanceof TPPlayerEventInfo.PlayResetEventInfo) {
            tPDynamicStatisticParams = ((TPPlayerEventInfo.PlayResetEventInfo) baseEventInfo).getDynamicStatisticParams();
        } else if (baseEventInfo instanceof TPPlayerEventInfo.PlayErrorEventInfo) {
            tPDynamicStatisticParams = ((TPPlayerEventInfo.PlayErrorEventInfo) baseEventInfo).getDynamicStatisticParams();
        } else {
            TPLogUtil.e(TAG, "event info do not have dynamicStatisticParams");
            tPDynamicStatisticParams = null;
        }
        if (tPDynamicStatisticParams == null) {
            return new TPDynamicStatisticParams();
        }
        return tPDynamicStatisticParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public TPGeneralPlayFlowParams getGeneralPlayFlowParamsFromCore() {
        ITPPlayerInfoGetter iTPPlayerInfoGetter = this.mPlayerInfoGetter;
        if (iTPPlayerInfoGetter == null) {
            TPLogUtil.e(TAG, "getGeneralPlayFlowParams failed, mPlayerInfoGetter is null, return default value");
            return new TPGeneralPlayFlowParams();
        }
        return iTPPlayerInfoGetter.getGeneralPlayFlowParams();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public TPGeneralPlayFlowParams getGeneralPlayFlowParamsFromEventInfo(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        TPGeneralPlayFlowParams tPGeneralPlayFlowParams;
        if (baseEventInfo instanceof TPPlayerEventInfo.PlayStopEventInfo) {
            tPGeneralPlayFlowParams = ((TPPlayerEventInfo.PlayStopEventInfo) baseEventInfo).getGeneralPlayFlowParams();
        } else if (baseEventInfo instanceof TPPlayerEventInfo.PlayResetEventInfo) {
            tPGeneralPlayFlowParams = ((TPPlayerEventInfo.PlayResetEventInfo) baseEventInfo).getGeneralPlayFlowParams();
        } else if (baseEventInfo instanceof TPPlayerEventInfo.PlayErrorEventInfo) {
            tPGeneralPlayFlowParams = ((TPPlayerEventInfo.PlayErrorEventInfo) baseEventInfo).getGeneralPlayFlowParams();
        } else {
            TPLogUtil.e(TAG, "event info do not have generalPlayFlowParams");
            tPGeneralPlayFlowParams = null;
        }
        if (tPGeneralPlayFlowParams == null) {
            return new TPGeneralPlayFlowParams();
        }
        return tPGeneralPlayFlowParams;
    }

    @Override // com.tencent.thumbplayer.report.reportv2.ITPReporter
    public void init(@NonNull Context context, @NonNull TPReporterInitParams tPReporterInitParams) {
        this.mContext = context;
        this.mReporterInitParams = tPReporterInitParams;
        this.mReportUtils = new TPReportUtils(context);
        createLocalCache(context, REPORT_CACHE_NAME);
        reportAndClearCache();
    }

    protected synchronized void removeCachedReport(@NonNull String str, @NonNull String str2) {
        TPLocalCacheReaderWriter tPLocalCacheReaderWriter = mCache;
        if (tPLocalCacheReaderWriter == null) {
            return;
        }
        tPLocalCacheReaderWriter.remove(str + str2);
        TPLogUtil.i(TAG, "remove cache, flowid:" + str + ", reportId:" + str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void removeCachedReports(@NonNull String str) {
        TPLocalCacheReaderWriter tPLocalCacheReaderWriter = mCache;
        if (tPLocalCacheReaderWriter == null) {
            return;
        }
        Iterator<String> it = tPLocalCacheReaderWriter.getKeyList().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.startsWith(str)) {
                mCache.remove(next);
                TPLogUtil.i(TAG, "remove cache, key:" + next);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportToBeaconIfNeed(String str, Map<String, String> map) {
        if (!this.mReporterInitParams.mNeedReportToBeacon.booleanValue()) {
            TPLogUtil.i(TAG, "eventId:" + str + ", no need to report to beacon because of sampling");
            return;
        }
        TPBeaconReportWrapper.trackCustomKVEvent(str, map);
    }

    @Override // com.tencent.thumbplayer.report.reportv2.ITPReporter
    public void setPlayerInfoGetter(@Nullable ITPPlayerInfoGetter iTPPlayerInfoGetter) {
        this.mPlayerInfoGetter = iTPPlayerInfoGetter;
    }

    @Override // com.tencent.thumbplayer.report.reportv2.ITPReporter
    public void setReportInfoGetter(@Nullable ITPReportInfoGetter iTPReportInfoGetter) {
        this.mReportInfoGetter = iTPReportInfoGetter;
    }

    @Override // com.tencent.thumbplayer.report.reportv2.ITPReporter
    public void reset() {
    }

    @Override // com.tencent.thumbplayer.report.reportv2.ITPReporter
    public void onEvent(int i3, TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
    }
}
