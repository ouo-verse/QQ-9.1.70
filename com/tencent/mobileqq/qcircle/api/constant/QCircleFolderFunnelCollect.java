package com.tencent.mobileqq.qcircle.api.constant;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qcircle.api.IQCircleConfigApi;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import org.light.device.OfflineConfig;
import uq3.c;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleFolderFunnelCollect {
    public static final String EXTRA_0VV_POST_AT_FRONT_STRATEGY = "0vv_post_at_front_strategy";
    public static final String EXTRA_ADAPTER_CRASH = "enter_adapter_crash";
    public static final String EXTRA_BENCHMARK_STRATEGY = "benchmark_strategy";
    public static final String EXTRA_CPU_CORES_NUM = "cpu_cores_num";
    public static final String EXTRA_DEVICE_LEVEL = "device_level";
    public static final String EXTRA_ENTER_BACKGROUND = "enter_background";
    public static final String EXTRA_ENTER_FOREGROUND = "enter_foreground";
    private static final String EXTRA_ENTER_MAIN_FRAGMENT_HIDDEN = "enter_main_fragment_hidden";
    private static final String EXTRA_ENTER_VIDEO_DOWNLOAD_SO_STATUS = "enter_download_so_status";
    public static final String EXTRA_ENTER_VIDEO_SDK_STATUS = "enter_sdk_status";
    private static final String EXTRA_ENTER_VIDEO_TP_CORE_SO_STATUS = "enter_tp_core_so_status";
    private static final String EXTRA_EXIT_VIDEO_DOWNLOAD_SO_STATUS = "exit_download_so_status";
    private static final String EXTRA_EXIT_VIDEO_TP_CORE_SO_STATUS = "exit_tp_core_so_status";
    public static final String EXTRA_FEED_ID = "feed_id";
    public static final String EXTRA_FEED_TYPE = "feed_type";
    public static final String EXTRA_FIRST_VIDEO_DOWNLOAD_STATUS = "first_video_download_status";
    public static final String EXTRA_FIRST_VIDEO_PRE_RENDER_STATUS = "first_video_pre_render_status";
    public static final String EXTRA_HIT_CONTENT_PRELOAD = "hit_content_preload";
    private static final String EXTRA_HIT_FAST_PLAY = "hit_fast_play";
    public static final String EXTRA_INVALID_SLIP_COUNT_BEFORE_LOAD_MORE = "invalid_slip_count_before_load_more";
    public static final String EXTRA_SLIP_COUNT_AFTER_LOAD_MORE = "slip_count_after_load_more";
    public static final String EXTRA_SYSTEM_TOTAL_MEMORY = "system_total_memory";
    public static final String EXTRA_VIDEO_PLAY_INTERCEPT_COUNT = "video_play_intercept_count";
    public static final String EXTRA_VIDEO_PLAY_NOT_INTERCEPT_COUNT = "video_play_not_intercept_count";
    public static final String EXTRA_VIDEO_SECOND_BUFFER_COUNT = "video_second_buffer_count";
    public static final String EXTRA_VIDEO_URL = "video_url";
    public static final String EXTRA_VIEW_FEED_COUNT = "view_feed_count";
    public static final String EXT_GET_NETWORK_FEED_RSP_INFO = "get_network_feed_rsp_info";
    public static final String KEY_LAUNCH_FIRST_PLAY_EVENT = "first_play";
    public static final String LAUNCH_TYPE_COLD = "cold_boot";
    public static final String LAUNCH_TYPE_HOT = "hot_boot";
    public static final String LAUNCH_TYPE_REUSE = "reuse";
    public static final String PERIOD_ENTER_CIRCLE = "enter_circle";
    public static final String PERIOD_EXIT_CIRCLE = "exit_circle";
    public static final String PERIOD_FOLDER_CONTENT_EXPOSE = "page_content_expose";
    public static final String PERIOD_FOLDER_HIDDEN = "folder_hidden";
    public static final String PERIOD_FOLDER_PAGE_DISAPPEAR = "page_disappear";
    public static final String PERIOD_FOLDER_PAGE_EXPOSE = "page_appear";
    public static final String PERIOD_FOLDER_PAGE_ON_PAUSE = "page_on_pause";
    public static final String PERIOD_FOLDER_VIDEO_AUTO_PLAY = "video_auto_play";
    public static final String PERIOD_FOLDER_VIDEO_FIRST_RENDER = "video_first_render";
    public static final String PERIOD_FOLDER_VIDEO_PLAY_BUT_NOT_RESUME = "video_play_but_not_resume";
    public static final String PERIOD_FOLDER_VIDEO_PREPARED = "video_prepared";
    public static final String PERIOD_FOLDER_VIDEO_SET_VIDEO_PATH = "video_prepare";
    public static final String PERIOD_FOLDER_VIDEO_START_PLAY = "video_start_play";
    public static final String PERIOD_HAVE_MORE_FEED_TIME = "have_more_feed_time";
    public static final String PERIOD_INIT_FOLDER_PAGE = "page_init";
    public static final String PERIOD_PRE_LOAD_FEED_RECEIVE = "preload_feed_receive";
    public static final String PERIOD_VIDEO_SDK_SUCCEED = "video_sdk_succeed";
    public static final String REFER_BOTTOM_TAB = "1";
    public static final String REFER_OTHER = "2";
    private static final String TAG = "QCircleFolderFunnelCollect";
    private static final String VAL_FAILED = "0";
    private static final String VAL_SUCCEED = "1";
    private static final String VAL_UNKNOWN = "-1";
    private static String sEnterDownloadSoLoadStatus;
    private static boolean sEnterMainFragmentHidden;
    private static String sEnterTpCoreLoadStatus;
    private static String sEnterVideoSdkStatus;
    private static String sExitDownloadSoLoadStatus;
    private static String sExitTpCoreLoadStatus;
    private static boolean sExpContentPreload;
    private static boolean sExpFastPlay;
    private static String sFeedId;
    private static int sFeedType;
    private static int sInterceptPlayCount;
    private static String sLoadFeedInfo;
    private static int sNotInterceptPlayCount;
    private static String sPerloadVideoPreRenderStatus;
    private static String sPreloadVideoDownloadStatus;
    private static String sUrl;
    private static final LinkedHashMap<String, FunnelPoint> PERIOD_LIST = new LinkedHashMap<>();
    private static final List<FunnelExtraPoint> EXTRA_PERIOD_LIST = Collections.synchronizedList(new ArrayList());
    private static boolean sEnableCollect = false;
    private static String sRefer = "";
    private static String sType = "";
    private static String sState = "";
    private static int sRecordTimes = 0;
    private static int sPlayCount = 0;
    private static long sStartTimeStamp = 0;
    private static String sRedInfo = "";
    private static int sVideoSecondBufferCount = 0;
    private static int sViewFeedCount = 0;
    private static int sInvalidSlipCountBeforeLoadMore = 0;
    private static int sSlipCountAfterLoadMore = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class FunnelPoint {
        private String period;
        private long timeCost;
        private long timeStamp;

        FunnelPoint() {
        }

        public static FunnelPoint obtain(String str, long j3) {
            FunnelPoint funnelPoint = new FunnelPoint();
            funnelPoint.period = str;
            long currentTimeMillis = System.currentTimeMillis();
            funnelPoint.timeStamp = currentTimeMillis;
            funnelPoint.timeCost = currentTimeMillis - j3;
            return funnelPoint;
        }
    }

    static {
        initEnableFunnelCollect();
    }

    private static void calcEnterStatus() {
        sEnterVideoSdkStatus = getVideoSdkStatus();
        QLog.d(TAG, 1, "calcEnterStatus sEnterVideoSdkStatus\uff1a" + sEnterVideoSdkStatus + "\uff0csEnterTpCoreLoadStatus\uff1a" + sEnterTpCoreLoadStatus + "\uff0csEnterDownloadSoLoadStatus\uff1a" + sEnterDownloadSoLoadStatus);
    }

    private static void clear() {
        PERIOD_LIST.clear();
        EXTRA_PERIOD_LIST.clear();
        sFeedId = "";
        sFeedType = 0;
        sUrl = "";
    }

    private static void doRecordInner(String str) {
        if (PERIOD_ENTER_CIRCLE.equals(str)) {
            sStartTimeStamp = System.currentTimeMillis();
            calcEnterStatus();
            QLog.d(TAG, 1, "doRecordInner enter_qcircle,sEnterVideoSdkStatus:" + sEnterVideoSdkStatus);
        }
        if (PERIOD_FOLDER_VIDEO_START_PLAY.equals(str)) {
            sPlayCount++;
        }
        LinkedHashMap<String, FunnelPoint> linkedHashMap = PERIOD_LIST;
        if (linkedHashMap.containsKey(str)) {
            return;
        }
        FunnelPoint obtain = FunnelPoint.obtain(str, sStartTimeStamp);
        linkedHashMap.put(str, obtain);
        if (PERIOD_FOLDER_VIDEO_FIRST_RENDER.equals(str)) {
            reportFirstPlayEvent(obtain);
        }
    }

    public static void flushPeriodReport() {
        String str;
        if (pass() || sStartTimeStamp == 0) {
            return;
        }
        recordPlayerInfo();
        long currentTimeMillis = System.currentTimeMillis() - sStartTimeStamp;
        String periodStr = getPeriodStr();
        String extraStr = getExtraStr();
        if (QQVideoPlaySDKManager.isSDKReady()) {
            str = "1";
        } else {
            str = "0";
        }
        QLog.d(TAG, 1, "flushPeriodReport ", "duration: ", Long.valueOf(currentTimeMillis), "ms", ",type: ", sType, ",state: ", sState, ",refer: ", sRefer, ",count: ", Integer.valueOf(sPlayCount), ",info: ", getInfo(), ",redInfo: ", sRedInfo, ",sdkState: ", str, ",attachInfo: ", periodStr, ",extraInfo: ", extraStr);
        ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).reportFolderFunnelPeriodEvent(new QCircleAlphaUserReportDataBuilder().setType(sType).setState(sState).setRefer(sRefer).setCount(sPlayCount).setTimeCost(currentTimeMillis).setInfo(getInfo()).setFeedId(sFeedId).setUrl(sUrl).setAttachInfo(periodStr).setExtraInfo(extraStr).setExt1(sRedInfo).setExt5(str));
        clear();
        sRecordTimes++;
    }

    private static String getDownloadSoStatus() {
        if (SoLoadManager.getInstance().isExist(SoLoadConstants.SONAME_DOWNLOADPROXY)) {
            return "1";
        }
        return "0";
    }

    public static String getExtraStr() {
        JSONObject jSONObject = new JSONObject();
        List<FunnelExtraPoint> list = EXTRA_PERIOD_LIST;
        synchronized (list) {
            for (FunnelExtraPoint funnelExtraPoint : list) {
                if (funnelExtraPoint != null) {
                    try {
                        jSONObject.put(funnelExtraPoint.key, funnelExtraPoint.value);
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                }
            }
        }
        return jSONObject.toString();
    }

    private static String getInfo() {
        if (sRecordTimes == 0) {
            return LAUNCH_TYPE_COLD;
        }
        if (!PERIOD_LIST.containsKey(PERIOD_INIT_FOLDER_PAGE)) {
            return LAUNCH_TYPE_REUSE;
        }
        return LAUNCH_TYPE_HOT;
    }

    public static String getPeriodStr() {
        JSONObject jSONObject = new JSONObject();
        for (FunnelPoint funnelPoint : PERIOD_LIST.values()) {
            if (funnelPoint != null) {
                try {
                    jSONObject.put(funnelPoint.period, funnelPoint.timeCost);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }
        return jSONObject.toString();
    }

    private static String getTpCoreSoStatus() {
        if (SoLoadManager.getInstance().isExist(SoLoadConstants.SONAME_TPCORE_MASTER)) {
            return "1";
        }
        return "0";
    }

    private static String getVideoSdkStatus() {
        if (QQVideoPlaySDKManager.isSDKReady()) {
            return "1";
        }
        return "0";
    }

    private static void initEnableFunnelCollect() {
        String str;
        sEnableCollect = c.n1();
        if (((IQCircleConfigApi) QRoute.api(IQCircleConfigApi.class)).isShowQQCircleMainTabEntrance()) {
            str = "1";
        } else {
            str = "2";
        }
        sRefer = str;
        QLog.d(TAG, 1, "initEnablePeriodCollect value:" + sEnableCollect);
    }

    public static void onPlayIntercept(boolean z16) {
        if (z16) {
            sInterceptPlayCount++;
        } else {
            sNotInterceptPlayCount++;
        }
    }

    private static boolean pass() {
        return !sEnableCollect;
    }

    public static void record(@NonNull String str) {
        if (pass()) {
            return;
        }
        if (PERIOD_ENTER_CIRCLE.equals(str)) {
            reset();
        }
        doRecordInner(str);
        if (PERIOD_EXIT_CIRCLE.equals(str)) {
            if (!PERIOD_LIST.containsKey(PERIOD_ENTER_CIRCLE)) {
                clear();
            } else {
                flushPeriodReport();
            }
        }
    }

    public static void recordCrashInfo(String str, Exception exc) {
        if (exc == null || pass()) {
            return;
        }
        List<FunnelExtraPoint> list = EXTRA_PERIOD_LIST;
        synchronized (list) {
            for (FunnelExtraPoint funnelExtraPoint : list) {
                if (funnelExtraPoint != null && TextUtils.equals(funnelExtraPoint.key, str)) {
                    return;
                }
            }
            EXTRA_PERIOD_LIST.add(FunnelExtraPoint.obtain(str, exc.toString()));
            QLog.d(TAG, 1, "recordCrashInfo key:" + str + ",value :" + exc);
        }
    }

    public static void recordExtra(@NonNull String str) {
        if (pass()) {
            return;
        }
        if (EXTRA_ENTER_FOREGROUND.equals(str) || EXTRA_ENTER_BACKGROUND.equals(str)) {
            record(str);
        }
        FunnelExtraPoint obtain = FunnelExtraPoint.obtain(str, sStartTimeStamp);
        EXTRA_PERIOD_LIST.add(obtain);
        QLog.d(TAG, 4, "recordExtra period:" + str + ",start :" + obtain.key + ",cost:" + obtain.value + "ms");
    }

    public static void recordInvalidSlipBeforeLoadMore() {
        sInvalidSlipCountBeforeLoadMore++;
    }

    public static void recordNetWorkSpeedInfo(Map<String, String> map) {
        if (map == null) {
            return;
        }
        QLog.d(TAG, 1, "[recordNetWorkSpeedInfo]");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            recordExtra(entry.getKey(), entry.getValue());
        }
    }

    private static void recordPlayerInfo() {
        String benchmarkStrategy = OfflineConfig.getBenchmarkStrategy();
        int phonePerfLevel = OfflineConfig.getPhonePerfLevel(MobileQQ.sMobileQQ);
        int numberOfCores = QCircleDeviceInfoUtils.getNumberOfCores();
        long systemTotalMemory = QCircleDeviceInfoUtils.getSystemTotalMemory();
        recordExtra("device_level", String.valueOf(phonePerfLevel));
        recordExtra(EXTRA_BENCHMARK_STRATEGY, benchmarkStrategy);
        recordExtra(EXTRA_CPU_CORES_NUM, String.valueOf(numberOfCores));
        recordExtra(EXTRA_SYSTEM_TOTAL_MEMORY, String.valueOf(systemTotalMemory));
        recordExtra(EXTRA_VIDEO_SECOND_BUFFER_COUNT, String.valueOf(sVideoSecondBufferCount));
        recordExtra(EXTRA_INVALID_SLIP_COUNT_BEFORE_LOAD_MORE, String.valueOf(sInvalidSlipCountBeforeLoadMore));
        recordExtra(EXTRA_SLIP_COUNT_AFTER_LOAD_MORE, String.valueOf(sSlipCountAfterLoadMore));
        recordExtra(EXTRA_VIEW_FEED_COUNT, String.valueOf(sViewFeedCount));
        recordExtra(EXTRA_FIRST_VIDEO_PRE_RENDER_STATUS, sPerloadVideoPreRenderStatus);
        recordExtra(EXTRA_FIRST_VIDEO_DOWNLOAD_STATUS, sPreloadVideoDownloadStatus);
        recordExtra(EXTRA_VIDEO_PLAY_NOT_INTERCEPT_COUNT, sNotInterceptPlayCount + "");
        recordExtra(EXTRA_VIDEO_PLAY_INTERCEPT_COUNT, sInterceptPlayCount + "");
        recordExtra(EXTRA_ENTER_VIDEO_SDK_STATUS, sEnterVideoSdkStatus + "");
        recordExtra(EXTRA_ENTER_VIDEO_DOWNLOAD_SO_STATUS, sEnterDownloadSoLoadStatus + "");
        recordExtra(EXTRA_ENTER_VIDEO_TP_CORE_SO_STATUS, sEnterTpCoreLoadStatus + "");
        recordExtra(EXTRA_ENTER_MAIN_FRAGMENT_HIDDEN, sEnterMainFragmentHidden + "");
        recordExtra(EXTRA_EXIT_VIDEO_DOWNLOAD_SO_STATUS, sExitDownloadSoLoadStatus + "");
        recordExtra(EXTRA_EXIT_VIDEO_TP_CORE_SO_STATUS, sExitTpCoreLoadStatus + "");
        recordExtra(EXT_GET_NETWORK_FEED_RSP_INFO, sLoadFeedInfo + "");
        recordExtra(EXTRA_HIT_CONTENT_PRELOAD, sExpContentPreload + "");
        recordExtra(EXTRA_HIT_FAST_PLAY, sExpFastPlay + "");
    }

    public static void recordSlipAfterLoadMore() {
        sSlipCountAfterLoadMore++;
    }

    public static void recordVideoPreloadInfo(boolean z16, boolean z17) {
        String str;
        String str2 = "1";
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        sPreloadVideoDownloadStatus = str;
        if (!z17) {
            str2 = "0";
        }
        sPerloadVideoPreRenderStatus = str2;
        QLog.d(TAG, 1, "[recordVideoPreloadInfo] sPreloadVideoDownloadStatus:" + sPreloadVideoDownloadStatus + ",sPerloadVideoPreRenderStatus:" + sPerloadVideoPreRenderStatus);
    }

    private static void reportFirstPlayEvent(FunnelPoint funnelPoint) {
        if (LAUNCH_TYPE_COLD.equals(getInfo()) && sStartTimeStamp != 0 && PERIOD_LIST.containsKey(PERIOD_ENTER_CIRCLE)) {
            String periodStr = getPeriodStr();
            String extraStr = getExtraStr();
            String videoSdkStatus = getVideoSdkStatus();
            ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).reportLog(KEY_LAUNCH_FIRST_PLAY_EVENT, new QCircleAlphaUserReportDataBuilder().setType(sType).setState(sState).setRefer(sRefer).setCount(sPlayCount).setTimeCost(funnelPoint.timeCost).setInfo(getInfo()).setFeedId(sFeedId).setUrl(sUrl).setAttachInfo(periodStr).setExtraInfo(extraStr).setExt1(sRedInfo).setExt2("3").setExt5(videoSdkStatus));
            QLog.d(TAG, 1, "reportFirstPlayEvent ", "duration: ", Long.valueOf(funnelPoint.timeCost), "ms", ",type: ", sType, ",state: ", sState, ",refer: ", sRefer, ",count: ", Integer.valueOf(sPlayCount), ",info: ", getInfo(), ",redInfo: ", sRedInfo, ",sdkState: ", videoSdkStatus, ",attachInfo: ", periodStr, ",extraInfo: ", extraStr);
        }
    }

    private static void reset() {
        String str;
        if (((IQCircleConfigApi) QRoute.api(IQCircleConfigApi.class)).isShowQQCircleMainTabEntrance()) {
            str = "1";
        } else {
            str = "2";
        }
        sRefer = str;
        sType = "";
        sState = "";
        sPlayCount = 0;
        sRedInfo = "";
        sVideoSecondBufferCount = 0;
        sViewFeedCount = 0;
        sInvalidSlipCountBeforeLoadMore = 0;
        sSlipCountAfterLoadMore = 0;
        sPreloadVideoDownloadStatus = "-1";
        sPerloadVideoPreRenderStatus = "-1";
        sInterceptPlayCount = 0;
        sNotInterceptPlayCount = 0;
        sExitTpCoreLoadStatus = "-1";
        sExitDownloadSoLoadStatus = "-1";
        sEnterVideoSdkStatus = "-1";
        sEnterTpCoreLoadStatus = "-1";
        sEnterMainFragmentHidden = false;
        sEnterDownloadSoLoadStatus = "-1";
        sLoadFeedInfo = "";
        clear();
    }

    public static void setEnterMainFragmentHidden(boolean z16) {
        QLog.d(TAG, 1, "[setEnterMainFragmentHidden] " + z16);
        sEnterMainFragmentHidden = z16;
    }

    public static void setExpContentPreload(boolean z16) {
        QLog.d(TAG, 1, "[setExpContentPreload] " + z16);
        sExpContentPreload = z16;
    }

    public static void setExpFastPlay(boolean z16) {
        QLog.d(TAG, 1, "[setExpFastPlay] " + z16);
        sExpFastPlay = z16;
    }

    public static void setFeedInfo(String str, int i3, String str2) {
        if (!TextUtils.equals(sFeedId, str)) {
            sViewFeedCount++;
        }
        sFeedId = str;
        sFeedType = i3;
        sUrl = str2;
        recordExtra("feed_id", str);
        recordExtra(EXTRA_FEED_TYPE, String.valueOf(sFeedType));
        recordExtra("video_url", sUrl);
    }

    public static void setLoadFeedInfo(String str) {
        if (!TextUtils.isEmpty(sLoadFeedInfo)) {
            return;
        }
        sLoadFeedInfo = str;
    }

    public static void setPrimaryState(String str) {
        if (pass()) {
            return;
        }
        sType = str;
        QLog.d(TAG, 1, "setPrimaryState type: ", str);
    }

    public static void setRedInfo(boolean z16) {
        String str;
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        sRedInfo = str;
    }

    public static void setState(String str, String str2) {
        if (pass() || !sType.equals(str) || !TextUtils.isEmpty(sState)) {
            return;
        }
        sState = str2;
        QLog.d(TAG, 1, "setState type: ", sType, ",state: ", str2);
    }

    public static void setVideoSecondBufferCount(int i3) {
        sVideoSecondBufferCount = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class FunnelExtraPoint {
        private String key;
        private String value;

        FunnelExtraPoint() {
        }

        public static FunnelExtraPoint obtain(String str, long j3) {
            FunnelExtraPoint funnelExtraPoint = new FunnelExtraPoint();
            funnelExtraPoint.key = str;
            funnelExtraPoint.value = String.valueOf(System.currentTimeMillis() - j3);
            return funnelExtraPoint;
        }

        public static FunnelExtraPoint obtain(String str, String str2) {
            FunnelExtraPoint funnelExtraPoint = new FunnelExtraPoint();
            funnelExtraPoint.key = str;
            funnelExtraPoint.value = str2;
            return funnelExtraPoint;
        }
    }

    public static void record(String str, long j3) {
        if (!pass() && sStartTimeStamp > 0) {
            LinkedHashMap<String, FunnelPoint> linkedHashMap = PERIOD_LIST;
            if (linkedHashMap.containsKey(str)) {
                QLog.d(TAG, 1, "record duplicate period:", str);
                return;
            }
            FunnelPoint funnelPoint = new FunnelPoint();
            funnelPoint.period = str;
            funnelPoint.timeStamp = j3;
            funnelPoint.timeCost = j3 - sStartTimeStamp;
            linkedHashMap.put(str, funnelPoint);
            QLog.d(TAG, 4, "record period:" + str + ",start :" + funnelPoint.timeStamp + ",cost:" + funnelPoint.timeCost + "ms");
        }
    }

    public static void recordExtra(String str, String str2) {
        if (pass()) {
            return;
        }
        EXTRA_PERIOD_LIST.add(FunnelExtraPoint.obtain(str, str2));
        QLog.d(TAG, 4, "recordExtra key:" + str + ",value :" + str2);
    }
}
