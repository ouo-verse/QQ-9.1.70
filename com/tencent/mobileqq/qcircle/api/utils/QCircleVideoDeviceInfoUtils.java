package com.tencent.mobileqq.qcircle.api.utils;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import org.light.device.OfflineConfig;
import uq3.o;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleVideoDeviceInfoUtils {
    private static final int DEF_STRATEGY_CORE_NUM = 8;
    private static final long DEF_STRATEGY_LOW_RAM_MEMORY = 3758096384L;
    public static final String STRATEGY_DEVICE_MODEL = "DeviceModel";
    private static final String TAG = "QCir\u00d8cleVideoDeviceInfoUtils";
    private static String mPrintBenchmarkStrategy = "";
    private static int mPrintCurrentLowDeviceLevel = -1;
    private static int mPrintStrategyDeviceLevel = -1;
    private static int sCpuCoresNumPrint;
    private static long sSystemTotalMemoryPrint;

    private static int formatBenchmarkStrategyLowLevel(int i3) {
        if (i3 == getVideoLowDeviceStrategyLevel()) {
            return 1;
        }
        int numberOfCores = QCircleDeviceInfoUtils.getNumberOfCores();
        long systemTotalMemory = QCircleDeviceInfoUtils.getSystemTotalMemory();
        String str = numberOfCores + " | systemTotalMemory: " + systemTotalMemory;
        if (numberOfCores != sCpuCoresNumPrint || sSystemTotalMemoryPrint != systemTotalMemory) {
            QLog.d(TAG, 1, "[formatBenchmarkStrategyLowLevel] cpu cores num: " + str);
            sCpuCoresNumPrint = numberOfCores;
            sSystemTotalMemoryPrint = systemTotalMemory;
        }
        long videoLowDeviceRamMemory = getVideoLowDeviceRamMemory();
        int videoLowDeviceCoreNum = getVideoLowDeviceCoreNum();
        if (systemTotalMemory < videoLowDeviceRamMemory || numberOfCores < videoLowDeviceCoreNum) {
            return 1;
        }
        return 2;
    }

    private static int getMediumDeviceLevel() {
        if (!isEnabledMediumDeviceFix()) {
            return 2;
        }
        int level = QCircleDeviceInfoUtils.getLevel();
        if (level == 3) {
            return 3;
        }
        if (level != 4) {
            return 2;
        }
        return 4;
    }

    public static int getVideoDeviceLevel() {
        int i3;
        if (!isEnabledBenchmarkLevel()) {
            return QCircleDeviceInfoUtils.getLevel();
        }
        if (isEnabledVideoDistinctSubsection() && QCircleDeviceInfoUtils.isLowDevice()) {
            return getVideoDistinctLowDeviceLevel();
        }
        if (isEnabledExperimentBenchmarkHighLevel()) {
            String benchmarkStrategy = OfflineConfig.getBenchmarkStrategy();
            try {
                i3 = OfflineConfig.getPhonePerfLevel(MobileQQ.sMobileQQ);
            } catch (Throwable th5) {
                RFWLog.d(TAG, RFWLog.USR, "[getVideoDeviceLevel] error: ", th5);
                i3 = 3;
            }
            if (!TextUtils.equals(STRATEGY_DEVICE_MODEL, benchmarkStrategy)) {
                return QCircleDeviceInfoUtils.getLevel();
            }
            if (i3 == 5) {
                return 4;
            }
            if (i3 == 4) {
                return 3;
            }
            if (i3 != 3) {
                return 1;
            }
            return getMediumDeviceLevel();
        }
        return QCircleDeviceInfoUtils.getLevel();
    }

    private static int getVideoDistinctLowDeviceLevel() {
        int i3;
        int i16;
        String benchmarkStrategy = OfflineConfig.getBenchmarkStrategy();
        try {
            i3 = OfflineConfig.getPhonePerfLevel(MobileQQ.sMobileQQ);
        } catch (Throwable th5) {
            RFWLog.d(TAG, RFWLog.USR, "[getVideoDistinctLowDeviceLevel] ex: ", th5);
            i3 = 3;
        }
        if (TextUtils.equals(STRATEGY_DEVICE_MODEL, benchmarkStrategy)) {
            i16 = formatBenchmarkStrategyLowLevel(i3);
        } else {
            i16 = 1;
        }
        if (!TextUtils.equals(mPrintBenchmarkStrategy, benchmarkStrategy) || mPrintStrategyDeviceLevel != i3 || mPrintCurrentLowDeviceLevel != i16) {
            QLog.d(TAG, 1, "[getVideoDistinctLowDeviceLevel] benchmarkStrategy: " + benchmarkStrategy + " | strategyDeviceLevel: " + i3 + " | currentLowDeviceLevel: " + i16);
            mPrintBenchmarkStrategy = benchmarkStrategy;
            mPrintStrategyDeviceLevel = i3;
            mPrintCurrentLowDeviceLevel = i16;
        }
        return i16;
    }

    private static int getVideoLowDeviceCoreNum() {
        return uq3.c.X0("qqcircle", "qqcircle_video_low_device_ram_memory", 8).intValue();
    }

    private static long getVideoLowDeviceRamMemory() {
        return uq3.c.Z0("qqcircle", "qqcircle_video_low_device_ram_memory", Long.valueOf(DEF_STRATEGY_LOW_RAM_MEMORY)).longValue();
    }

    private static int getVideoLowDeviceStrategyLevel() {
        return uq3.c.X0("qqcircle", "qqcircle_video_low_device_strategy_level", 1).intValue();
    }

    private static boolean isEnabledBenchmarkLevel() {
        if (uq3.c.Y0("qqcircle", "qcircle_enabled_benchmark_level", 1, false).intValue() == 1) {
            return true;
        }
        return false;
    }

    private static boolean isEnabledExperimentBenchmarkHighLevel() {
        if (uq3.c.Y0("qqcircle", "qcircle_enabled_experiment_benchmark_high_level", 1, false).intValue() == 1) {
            return true;
        }
        return false;
    }

    private static boolean isEnabledMediumDeviceFix() {
        return o.q1();
    }

    private static boolean isEnabledVideoDistinctSubsection() {
        if (uq3.c.Y0("qqcircle", "qqcircle_video_distinct_subsection_enabled", 1, false).intValue() == 1) {
            return true;
        }
        return false;
    }

    public static boolean isLowDevice() {
        if (getVideoDeviceLevel() == 1) {
            return true;
        }
        return false;
    }
}
