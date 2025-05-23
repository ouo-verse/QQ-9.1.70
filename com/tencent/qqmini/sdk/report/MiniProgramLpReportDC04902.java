package com.tencent.qqmini.sdk.report;

import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Process;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes23.dex */
public class MiniProgramLpReportDC04902 {
    private static final String BEACON_EVENT_CODE = "mini_game_jank";
    private static String DC_TABLE_VALUE_APPID = "appid";
    private static final long INTERVAL_CPU_MEM_TASK = 1000;
    private static final String KEY_APP_ID = "appId";
    private static final String KEY_AVG_CPU = "avgCpu";
    private static final String KEY_AVG_FPS = "avgFps";
    private static final String KEY_AVG_MEM = "avgMem";
    private static final String KEY_BASE_LIB_VERSION = "baseLibVersion";
    private static final String KEY_BIG_JANK = "bigJank";
    private static final String KEY_IS_SDK = "isSdk";
    private static final String KEY_JANK = "jank";
    private static final String KEY_LEVEL = "level";
    private static final String KEY_OS_VERSION = "osVersion";
    private static final String KEY_PHONE_MODEL = "phoneModel";
    private static final String KEY_QUA = "qua";
    private static final String KEY_TRITON_VERSION = "tritonVersion";
    public static String PERF_LEVEL = null;
    private static final String TAG = "MiniProgramLpReportDC04902";
    private static String DC_TABLE_VALUE_QUA = QUAUtil.getPlatformQUA();
    private static String DC_TABLE_VALUE_START_TIME = currentTimeString();
    private static String DC_TABLE_VALUE_END_TIME = currentTimeString();
    private static long DC_TABLE_VALUE_F_20 = 0;
    private static long DC_TABLE_VALUE_F_33 = 0;
    private static long DC_TABLE_VALUE_F_50 = 0;
    private static long DC_TABLE_VALUE_F_100 = 0;
    private static long DC_TABLE_VALUE_F_LONG = 0;
    private static long DC_TABLE_VALUE_AVG_MEM = 0;
    private static long DC_TABLE_VALUE_MAX_MEM = 0;
    private static long DC_TABLE_VALUE_AVG_CPU = 0;
    private static long DC_TABLE_VALUE_MAX_CPU = 0;
    private static final Runnable PERIODICALLY_COLLECT_CPU_MEM_RUNNABLE = new Runnable() { // from class: com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04902.1
        @Override // java.lang.Runnable
        public void run() {
            Debug.MemoryInfo processMemory = DeviceInfoUtil.getProcessMemory(Process.myPid());
            if (processMemory != null) {
                long totalPss = processMemory.getTotalPss() / 1024;
                long unused = MiniProgramLpReportDC04902.DC_TABLE_VALUE_AVG_MEM = (MiniProgramLpReportDC04902.DC_TABLE_VALUE_AVG_MEM + totalPss) / 2;
                if (totalPss > MiniProgramLpReportDC04902.DC_TABLE_VALUE_MAX_MEM) {
                    long unused2 = MiniProgramLpReportDC04902.DC_TABLE_VALUE_MAX_MEM = totalPss;
                }
                long j3 = processMemory.nativePss / 1024;
                long j16 = processMemory.otherPss / 1024;
                if (MiniProgramLpReportDC04902.DC_TABLE_VALUE_AVG_CPU != 0) {
                    j3 = (MiniProgramLpReportDC04902.DC_TABLE_VALUE_AVG_CPU + j3) / 2;
                }
                long unused3 = MiniProgramLpReportDC04902.DC_TABLE_VALUE_AVG_CPU = j3;
                if (MiniProgramLpReportDC04902.DC_TABLE_VALUE_MAX_CPU != 0) {
                    j16 = (MiniProgramLpReportDC04902.DC_TABLE_VALUE_MAX_CPU + j16) / 2;
                }
                long unused4 = MiniProgramLpReportDC04902.DC_TABLE_VALUE_MAX_CPU = j16;
            }
            if (MiniProgramLpReportDC04902.sIsGameForeground) {
                MiniProgramLpReportDC04902.scheduleCpuMenCollectTask();
            }
        }
    };
    private static String DC_TABLE_VALUE_ATTACH_INFO = null;
    private static long DC_TABLE_VALUE_F_MAX_TIME_MILLIS = 0;
    private static long DC_TABLE_VALUE_F_MAX = 0;
    private static String DC_TABLE_VALUE_TEXTURE_OFFLINE = null;
    private static String DC_TABLE_VALUE_NETWORK_GATEWAY_IP = null;
    private static String DC_TABLE_VALUE_PLATFORM = "android";
    private static boolean hasReportStart = false;
    private static volatile boolean sIsGameForeground = false;

    MiniProgramLpReportDC04902() {
    }

    public static void accumulateDrawFrameDuration(long j3) {
        if (j3 <= 20) {
            DC_TABLE_VALUE_F_20 += j3;
        } else if (j3 <= 33) {
            DC_TABLE_VALUE_F_33 += j3;
        } else if (j3 <= 50) {
            DC_TABLE_VALUE_F_50 += j3;
        } else if (j3 <= 100) {
            DC_TABLE_VALUE_F_100 += j3;
        } else {
            DC_TABLE_VALUE_F_LONG += j3;
        }
        if (j3 > DC_TABLE_VALUE_F_MAX) {
            DC_TABLE_VALUE_F_MAX = j3;
            DC_TABLE_VALUE_F_MAX_TIME_MILLIS = System.currentTimeMillis();
        }
    }

    private static void cancelCpuMenCollectTask() {
        ThreadManager.getSubThreadHandler().removeCallbacks(PERIODICALLY_COLLECT_CPU_MEM_RUNNABLE);
    }

    private static String currentTimeString() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
    }

    public static void onGamePaused() {
        sIsGameForeground = false;
        cancelCpuMenCollectTask();
    }

    public static void onGameResumed() {
        sIsGameForeground = true;
        scheduleCpuMenCollectTask();
    }

    private static void report(String str, Map<String, String> map) {
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        if (channelProxy != null) {
            channelProxy.reportBeacon(ChannelProxy.BeaconReportCategory.MINI_GAME, str, map);
        }
    }

    public static void reportGameEnd(float f16, float f17, String str, String str2) {
        boolean z16;
        double jankCount;
        String str3;
        DC_TABLE_VALUE_END_TIME = currentTimeString();
        cancelCpuMenCollectTask();
        ou3.a jankStatistics = MiniGamePerformanceStatics.getInstance().getJankStatistics();
        double b16 = (((float) jankStatistics.b()) / 1000.0f) / 60.0f;
        if (b16 < 0.01d) {
            z16 = true;
        } else {
            z16 = false;
        }
        double d16 = 0.0d;
        if (z16) {
            jankCount = 0.0d;
        } else {
            jankCount = jankStatistics.getJankCount() / b16;
        }
        if (!z16) {
            d16 = jankStatistics.getBigJankCount() / b16;
        }
        QMLog.d(TAG, "reportGameEnd: minuteFromStart=" + b16 + " jankCount=" + jankStatistics.getJankCount() + " bigJankCount=" + jankStatistics.getBigJankCount());
        StringBuilder sb5 = new StringBuilder();
        sb5.append(DC_TABLE_VALUE_APPID);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(DC_TABLE_VALUE_QUA);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(DC_TABLE_VALUE_START_TIME);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(DC_TABLE_VALUE_END_TIME);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(DC_TABLE_VALUE_F_20);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(DC_TABLE_VALUE_F_33);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(DC_TABLE_VALUE_F_50);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(DC_TABLE_VALUE_F_100);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(DC_TABLE_VALUE_F_LONG);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(DC_TABLE_VALUE_AVG_MEM);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(DC_TABLE_VALUE_MAX_MEM);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(DC_TABLE_VALUE_AVG_CPU);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(DC_TABLE_VALUE_MAX_CPU);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(DC_TABLE_VALUE_ATTACH_INFO);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(DC_TABLE_VALUE_F_MAX_TIME_MILLIS);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(DC_TABLE_VALUE_F_MAX);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append((int) f17);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append((int) f16);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(DC_TABLE_VALUE_TEXTURE_OFFLINE);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(MiniProgramReportHelper.getNetworkType());
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(DC_TABLE_VALUE_NETWORK_GATEWAY_IP);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(DC_TABLE_VALUE_PLATFORM);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(DeviceInfoUtil.getPhoneModel());
        sb5.append(QbAddrData.DATA_SPLITER);
        String str4 = Build.VERSION.RELEASE;
        sb5.append(str4);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(jankCount);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(d16);
        String sb6 = sb5.toString();
        if (!QUAUtil.isQQApp()) {
            sb6 = sb6 + QbAddrData.DATA_SPLITER + QUAUtil.getQUA() + QbAddrData.DATA_SPLITER + ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getPlatformId() + QbAddrData.DATA_SPLITER + ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAppVersion() + QbAddrData.DATA_SPLITER + QUAUtil.getLoginType();
        }
        Bundle bundle = new Bundle();
        bundle.putStringArray("data", new String[]{sb6});
        if (QUAUtil.isQQApp()) {
            str3 = "dc04902";
        } else {
            str3 = "dc05389";
        }
        bundle.putString("log_key", str3);
        QMLog.d(TAG, "reportGameEnd " + sb6);
        AppBrandCmdProxy.g().sendCmd("cmd_dc_report_log_key_data", bundle, null);
        hasReportStart = false;
        if (PERF_LEVEL == null) {
            PERF_LEVEL = String.valueOf(DeviceInfoUtil.getPerfLevel());
        }
        HashMap hashMap = new HashMap();
        hashMap.put("appId", DC_TABLE_VALUE_APPID);
        hashMap.put("qua", DC_TABLE_VALUE_QUA);
        hashMap.put("osVersion", str4);
        hashMap.put(KEY_BASE_LIB_VERSION, str);
        hashMap.put(KEY_TRITON_VERSION, str2);
        hashMap.put(KEY_IS_SDK, String.valueOf(1));
        hashMap.put(KEY_JANK, String.valueOf(jankCount));
        hashMap.put(KEY_BIG_JANK, String.valueOf(d16));
        hashMap.put("level", PERF_LEVEL);
        hashMap.put(KEY_AVG_FPS, String.valueOf(f16));
        hashMap.put(KEY_AVG_MEM, String.valueOf(DC_TABLE_VALUE_AVG_MEM));
        hashMap.put(KEY_AVG_CPU, String.valueOf(DC_TABLE_VALUE_AVG_CPU));
        report(BEACON_EVENT_CODE, hashMap);
    }

    public static void reportGameStart(String str) {
        if (!hasReportStart) {
            hasReportStart = true;
            DC_TABLE_VALUE_APPID = str;
            DC_TABLE_VALUE_START_TIME = currentTimeString();
            scheduleCpuMenCollectTask();
        }
    }

    public static void reportToServer(Bundle bundle) {
        if (bundle != null && bundle.containsKey("data")) {
            ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).httpReport(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void scheduleCpuMenCollectTask() {
        synchronized (MiniProgramLpReportDC04902.class) {
            Handler subThreadHandler = ThreadManager.getSubThreadHandler();
            Runnable runnable = PERIODICALLY_COLLECT_CPU_MEM_RUNNABLE;
            subThreadHandler.removeCallbacks(runnable);
            ThreadManager.getSubThreadHandler().postDelayed(runnable, 1000L);
        }
    }
}
