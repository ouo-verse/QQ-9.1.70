package com.tencent.qqmini.sdk.report;

import android.os.Debug;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.monitor.common.ProcessStats;
import com.tencent.qqmini.sdk.statistics.AverageStatistics;
import com.tencent.qqmini.sdk.statistics.MaxStatistics;
import com.tencent.qqmini.sdk.statistics.VarianceStatistics;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes23.dex */
public class MiniGamePerformanceStatics {
    private static final String EVENT_FILE_API_TIME_COST = "mini_game_file_api_time_cost";
    private static final String KEY_API_NAME = "apiName";
    private static final String KEY_APP_ID = "appId";
    private static final String KEY_IS_SDK = "isSdk";
    private static final String KEY_IS_SUCCESS = "isSuccess";
    private static final String KEY_QUA = "qua";
    private static final String KEY_WAITING_TIME = "waitingTime";
    private static final String KEY_WORKING_TIME = "workingTime";
    private static final long STATICS_INTERVAL_MS = 10000;
    private static final String TAG = "MiniGamePerformanceStat";
    private static volatile MiniGamePerformanceStatics instance;
    public static int sLaunchCost;
    public static int sPkgDownloadCost;
    private String jsVersion;
    private long mStartCpuTime;
    private float mStartMemory;
    private long mStartTimeMillis;
    private MiniAppInfo miniAppInfo;
    private String tritonVersion;
    private final AverageStatistics mAverageMemory = new AverageStatistics();
    private final MaxStatistics mMaxMemory = new MaxStatistics();
    private final AverageStatistics mAverageFps = new AverageStatistics();
    private final VarianceStatistics mFpsVariance = new VarianceStatistics(200);
    private final Debug.MemoryInfo mMemoryInfo = new Debug.MemoryInfo();
    private final Runnable mStaticsRunnable = new Runnable() { // from class: com.tencent.qqmini.sdk.report.MiniGamePerformanceStatics.1
        @Override // java.lang.Runnable
        public void run() {
            float processPssMemory = MiniGamePerformanceStatics.this.getProcessPssMemory();
            MiniGamePerformanceStatics.this.mAverageMemory.addSample(processPssMemory);
            MiniGamePerformanceStatics.this.mMaxMemory.addSample(processPssMemory);
            ThreadManager.getSubThreadHandler().postDelayed(this, 10000L);
        }
    };
    private ConcurrentHashMap<String, Integer> fileApiSuccessCountMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Integer> fileApiFailCountMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Double> fileApiWaitingTimeMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Double> fileApiSuccessTimeCostMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Double> fileApiFailTimeCostMap = new ConcurrentHashMap<>();
    private final ou3.a mJankStatistics = new ou3.a();

    MiniGamePerformanceStatics() {
    }

    private void doReport() {
        final MiniAppInfo miniAppInfo = this.miniAppInfo;
        if (miniAppInfo == null) {
            reset();
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.mStartTimeMillis;
        if (uptimeMillis < 10000) {
            reset();
            return;
        }
        final HashMap hashMap = new HashMap();
        hashMap.put("startCpuTime", String.valueOf(this.mStartCpuTime));
        hashMap.put("avgMemory", String.valueOf(this.mAverageMemory.calculate()));
        hashMap.put("memoryGrowth", String.valueOf(this.mMaxMemory.calculate() - this.mStartMemory));
        hashMap.put("avgFps", String.valueOf(this.mAverageFps.calculate()));
        hashMap.put("fpsVariance", String.valueOf(this.mFpsVariance.calculate()));
        hashMap.put("duration", String.valueOf(uptimeMillis));
        hashMap.put("jsVersion", this.jsVersion);
        hashMap.put("tritonVersion", this.tritonVersion);
        ThreadManager.runNetTask(new Runnable() { // from class: com.tencent.qqmini.sdk.report.MiniGamePerformanceStatics.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MiniGamePerformanceStatics.doReportInNetThread(miniAppInfo, hashMap);
                } catch (Exception e16) {
                    QMLog.e(MiniGamePerformanceStatics.TAG, "doReportInNetThread failed.", e16);
                }
            }
        });
        reportFileApiTimeCost();
        reset();
    }

    private void doReportFileApiTimeCost(boolean z16) {
        ConcurrentHashMap<String, Double> concurrentHashMap;
        int i3;
        double d16;
        MiniAppInfo miniAppInfo = this.miniAppInfo;
        if (miniAppInfo == null) {
            return;
        }
        String str = miniAppInfo.appId;
        if (z16) {
            concurrentHashMap = this.fileApiSuccessTimeCostMap;
        } else {
            concurrentHashMap = this.fileApiFailTimeCostMap;
        }
        for (String str2 : concurrentHashMap.keySet()) {
            HashMap hashMap = new HashMap();
            hashMap.put("appId", str);
            hashMap.put("qua", QUAUtil.getPlatformQUA());
            hashMap.put("apiName", str2);
            hashMap.put(KEY_IS_SDK, String.valueOf(1));
            hashMap.put("isSuccess", String.valueOf(z16 ? 1 : 0));
            int fileApiCount = getFileApiCount(str2, true);
            int fileApiCount2 = getFileApiCount(str2, false);
            Double d17 = concurrentHashMap.get(str2);
            double d18 = 0.0d;
            if (d17 == null) {
                d16 = 0.0d;
            } else {
                double doubleValue = d17.doubleValue();
                if (z16) {
                    i3 = fileApiCount;
                } else {
                    i3 = fileApiCount2;
                }
                d16 = doubleValue / i3;
            }
            hashMap.put(KEY_WORKING_TIME, String.valueOf(d16));
            Double d19 = this.fileApiWaitingTimeMap.get(str2);
            if (d19 != null) {
                d18 = d19.doubleValue() / (fileApiCount + fileApiCount2);
            }
            hashMap.put(KEY_WAITING_TIME, String.valueOf(d18));
            report(EVENT_FILE_API_TIME_COST, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doReportInNetThread(MiniAppInfo miniAppInfo, Map<String, String> map) {
        long parseLong = Long.parseLong(map.get("duration"));
        float collectCpuUsage = ((float) (ProcessStats.collectCpuUsage("-1") - Long.parseLong(map.get("startCpuTime")))) / (((float) parseLong) / 1000.0f);
        String str = map.get("avgMemory");
        String str2 = map.get("memoryGrowth");
        String str3 = map.get("avgFps");
        String str4 = map.get("fpsVariance");
        String str5 = map.get("jsVersion");
        String str6 = map.get("tritonVersion");
        if (miniAppInfo.isReportTypeMiniGame()) {
            MiniReportManager.reportEventType(miniAppInfo, 629, toString(collectCpuUsage), "1");
            MiniReportManager.reportEventType(miniAppInfo, 631, str, "1");
            MiniReportManager.reportEventType(miniAppInfo, 643, str2, "1");
            MiniReportManager.reportEventType(miniAppInfo, 630, str3, "1");
            MiniReportManager.reportEventType(miniAppInfo, 642, str4, "1");
            MiniProgramLpReportDC04902.reportGameEnd(Float.parseFloat(str3), Float.parseFloat(str4), str5, str6);
            return;
        }
        MiniReportManager.reportEventType(miniAppInfo, 629, toString(collectCpuUsage), MiniReportManager.getAppType(miniAppInfo));
        MiniReportManager.reportEventType(miniAppInfo, 631, str, MiniReportManager.getAppType(miniAppInfo));
        MiniReportManager.reportEventType(miniAppInfo, 643, str2, MiniReportManager.getAppType(miniAppInfo));
    }

    private int getFileApiCount(String str, boolean z16) {
        ConcurrentHashMap<String, Integer> concurrentHashMap;
        if (z16) {
            concurrentHashMap = this.fileApiSuccessCountMap;
        } else {
            concurrentHashMap = this.fileApiFailCountMap;
        }
        Integer num = concurrentHashMap.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static MiniGamePerformanceStatics getInstance() {
        if (instance == null) {
            synchronized (MiniGamePerformanceStatics.class) {
                if (instance == null) {
                    instance = new MiniGamePerformanceStatics();
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getProcessPssMemory() {
        Debug.getMemoryInfo(this.mMemoryInfo);
        return this.mMemoryInfo.getTotalPss() / 1024.0f;
    }

    private void report(String str, Map<String, String> map) {
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        if (channelProxy != null) {
            channelProxy.reportBeacon(ChannelProxy.BeaconReportCategory.MINI_GAME, str, map);
        }
    }

    private void reportFileApiTimeCost() {
        doReportFileApiTimeCost(true);
        doReportFileApiTimeCost(false);
    }

    private void reset() {
        this.mAverageMemory.reset();
        this.mAverageFps.reset();
        this.mFpsVariance.reset();
        this.mStartCpuTime = ProcessStats.collectCpuUsage("-1");
        this.mStartTimeMillis = SystemClock.uptimeMillis();
        this.fileApiSuccessCountMap.clear();
        this.fileApiFailCountMap.clear();
        this.fileApiWaitingTimeMap.clear();
        this.fileApiSuccessTimeCostMap.clear();
        this.fileApiFailTimeCostMap.clear();
    }

    private static String toString(float f16) {
        return String.format(Locale.US, "%.1f", Float.valueOf(f16));
    }

    private void updateWaitingTime(String str, long j3) {
        Double d16 = this.fileApiWaitingTimeMap.get(str);
        if (d16 == null) {
            this.fileApiWaitingTimeMap.put(str, Double.valueOf(j3 * 1.0d));
        } else {
            this.fileApiWaitingTimeMap.put(str, Double.valueOf(d16.doubleValue() + j3));
        }
    }

    private void updateWorkingTime(String str, boolean z16, long j3) {
        ConcurrentHashMap<String, Integer> concurrentHashMap;
        ConcurrentHashMap<String, Double> concurrentHashMap2;
        if (z16) {
            concurrentHashMap = this.fileApiSuccessCountMap;
        } else {
            concurrentHashMap = this.fileApiFailCountMap;
        }
        if (z16) {
            concurrentHashMap2 = this.fileApiSuccessTimeCostMap;
        } else {
            concurrentHashMap2 = this.fileApiFailTimeCostMap;
        }
        concurrentHashMap.put(str, Integer.valueOf(getFileApiCount(str, z16) + 1));
        Double d16 = concurrentHashMap2.get(str);
        if (d16 == null) {
            concurrentHashMap2.put(str, Double.valueOf(j3 * 1.0d));
        } else {
            concurrentHashMap2.put(str, Double.valueOf(d16.doubleValue() + j3));
        }
    }

    @NonNull
    public ou3.a getJankStatistics() {
        return this.mJankStatistics;
    }

    public void onGamePaused() {
        ThreadManager.getSubThreadHandler().removeCallbacks(this.mStaticsRunnable);
        MiniProgramLpReportDC04902.onGamePaused();
        doReport();
    }

    public void onGameResumed() {
        reset();
        Handler subThreadHandler = ThreadManager.getSubThreadHandler();
        subThreadHandler.removeCallbacks(this.mStaticsRunnable);
        subThreadHandler.postDelayed(this.mStaticsRunnable, 10000L);
        MiniProgramLpReportDC04902.onGameResumed();
    }

    public void onGetFps(float f16) {
        this.mFpsVariance.addSample(f16);
        this.mAverageFps.addSample(f16);
    }

    public synchronized void recordFileApiTimeCost(String str, boolean z16, long j3, long j16) {
        updateWaitingTime(str, j3);
        updateWorkingTime(str, z16, j16);
    }

    public void recordInitialMemory() {
        ThreadManager.runComputationTask(new Runnable() { // from class: com.tencent.qqmini.sdk.report.MiniGamePerformanceStatics.2
            @Override // java.lang.Runnable
            public void run() {
                MiniGamePerformanceStatics miniGamePerformanceStatics = MiniGamePerformanceStatics.this;
                miniGamePerformanceStatics.mStartMemory = miniGamePerformanceStatics.getProcessPssMemory();
            }
        });
    }

    public void setMiniAppInfo(MiniAppInfo miniAppInfo) {
        this.miniAppInfo = miniAppInfo;
    }

    public void setVersion(String str, String str2) {
        this.jsVersion = str;
        this.tritonVersion = str2;
    }
}
