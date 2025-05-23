package com.tencent.mobileqq.qcircle.api.utils;

import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.gathererga.core.HardwareInfoProvider;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.m;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import uq3.k;
import uq3.o;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleDeviceInfoUtils {
    private static final long DEF_HIGH_FREQ_KHZ = 0;
    private static final int DEF_HIGH_PUC_CORE_NUM = 8;
    private static final long DEF_HIGH_RAM_MEMORY = 8589934592L;
    private static final int DEF_LOCAL_READ_DEVICE_INFO_INTERVAL = 600000;
    private static final long DEF_LOW_FREQ_KHZ = 0;
    private static final int DEF_LOW_PUC_CORE_NUM = 6;
    private static final long DEF_LOW_RAM_MEMORY = 4294967296L;
    public static final int DEV_LEVEL_HIGH = 3;
    private static final String DEV_LEVEL_KEY = "new_dev_level_key";
    public static final int DEV_LEVEL_LOW = 1;
    public static final int DEV_LEVEL_MEDIUM = 2;
    public static final int DEV_LEVEL_SUPER_HIGH = 4;
    private static final String DEV_LEVEL_V2_KEY = "new_dev_level_key_v2";
    private static final String LEVEL_LOW_FLAG = "level_low";
    private static final String LEVEL_MEDIUM_FLAG = "level_medium";
    private static final String LEVEL_NONE_FLAG = "level_none_none";
    private static final String LEVE_HIGH_FLAG = "level_high";
    private static final String TAG = "RFDeviceInfoUtils";
    private static final long UPGRADE_HIGH_RAM_MEMORY = 7000000000L;
    private static long mCurrentSystemTime;
    private static final Map<Integer, String> mDeviceLevelMap;
    private static int mDeviceLevelPrintVal;
    private static String mHarmonyBuildOsVersion;
    private static final Object mInitLock;
    private static boolean mIsHarmonyOs;
    private static boolean mIsInit;
    private static String sCpuHardWard;
    private static String sManufacturer;
    private static String sMobileModel;
    private static final DeviceInfoEntity mLowDeviceInfo = new DeviceInfoEntity(6, 0, 4294967296L);
    private static final DeviceInfoEntity mHighDeviceInfo = new DeviceInfoEntity(8, 0, 8589934592L);
    public static int DEV_LEVEL_NONE = 0;
    private static int sDeviceLevel = 0;
    private static int sCoreNum = -1;
    private static long sRawMem = -1;
    private static long sCpuFreq = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class DeviceInfoEntity {
        private int mCpuCoreNum;
        private long mFreqKHz;
        private long mRamMemory;

        public DeviceInfoEntity(int i3, long j3, long j16) {
            this.mCpuCoreNum = i3;
            this.mFreqKHz = j3;
            this.mRamMemory = j16;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        mDeviceLevelMap = hashMap;
        mIsHarmonyOs = false;
        mHarmonyBuildOsVersion = "";
        mInitLock = new Object();
        mDeviceLevelPrintVal = DEV_LEVEL_NONE;
        mCurrentSystemTime = 0L;
        hashMap.put(1, LEVEL_LOW_FLAG);
        hashMap.put(2, LEVEL_MEDIUM_FLAG);
        hashMap.put(3, LEVE_HIGH_FLAG);
    }

    private static void checkHarmonyInfo() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            mIsHarmonyOs = HardwareInfoProvider.HARMONY_OS.equalsIgnoreCase(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]).toString());
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "Phone is HarmonyOS:" + mIsHarmonyOs);
            }
            mHarmonyBuildOsVersion = (String) SystemProperties.class.getDeclaredMethod("get", String.class).invoke(SystemProperties.class, "hw_sc.build.platform.version");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getHarmonyBuildOsVersion value: " + mHarmonyBuildOsVersion);
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "check Harmony info failed!!!", th5);
            }
        }
    }

    public static long getCpuFrequency() {
        if (sCpuFreq == -1) {
            sCpuFreq = ah.l();
        }
        return sCpuFreq;
    }

    public static String getCupHardWARE() {
        if (TextUtils.isEmpty(sCpuHardWard)) {
            sCpuHardWard = Build.HARDWARE;
        }
        return sCpuHardWard;
    }

    public static int getCupNum() {
        return ah.n();
    }

    private static int getDeviceLevel() {
        if (o.u1()) {
            return getNewDeviceLevel();
        }
        int i3 = sDeviceLevel;
        if (i3 != DEV_LEVEL_NONE) {
            return i3;
        }
        int prefDeviceLevel = getPrefDeviceLevel(DEV_LEVEL_KEY);
        sDeviceLevel = prefDeviceLevel;
        if (prefDeviceLevel != DEV_LEVEL_NONE) {
            if (mDeviceLevelPrintVal != prefDeviceLevel) {
                RFWLog.d(TAG, RFWLog.USR, "[getDeviceLevel] device level: " + sDeviceLevel);
                mDeviceLevelPrintVal = sDeviceLevel;
            }
            return sDeviceLevel;
        }
        updateSystemDeviceLevel(DEV_LEVEL_KEY);
        return sDeviceLevel;
    }

    public static String getDeviceLevelFlag() {
        String str = mDeviceLevelMap.get(Integer.valueOf(sDeviceLevel));
        if (TextUtils.isEmpty(str)) {
            return LEVEL_NONE_FLAG;
        }
        return str;
    }

    public static String getHarmonyBuildOsVersion() {
        String str;
        synchronized (mInitLock) {
            if (!mIsInit) {
                init();
            }
            str = mHarmonyBuildOsVersion;
        }
        return str;
    }

    public static int getLevel() {
        return getDeviceLevel();
    }

    public static String getManufacturer() {
        if (TextUtils.isEmpty(sManufacturer)) {
            sManufacturer = Build.MANUFACTURER;
        }
        return sManufacturer;
    }

    public static String getMobileModel() {
        if (TextUtils.isEmpty(sMobileModel)) {
            sMobileModel = DeviceInfoMonitor.getModel();
        }
        return sMobileModel;
    }

    private static int getNewDeviceLevel() {
        int X = o.X(600000);
        if (mCurrentSystemTime != 0 && System.currentTimeMillis() - mCurrentSystemTime < X) {
            if (sDeviceLevel == DEV_LEVEL_NONE) {
                sDeviceLevel = 2;
            }
            if (mDeviceLevelPrintVal != sDeviceLevel) {
                RFWLog.d(TAG, RFWLog.USR, "[getNewDeviceLevel] device level: " + sDeviceLevel);
                mDeviceLevelPrintVal = sDeviceLevel;
            }
            return sDeviceLevel;
        }
        updateDeviceLevelV2();
        if (sDeviceLevel == DEV_LEVEL_NONE) {
            sDeviceLevel = getPrefDeviceLevel(DEV_LEVEL_V2_KEY);
            RFWLog.d(TAG, RFWLog.USR, "[getNewDeviceLevel] load pref, device level: " + sDeviceLevel);
        }
        mCurrentSystemTime = System.currentTimeMillis();
        if (sDeviceLevel == DEV_LEVEL_NONE) {
            updateSystemDeviceLevel(DEV_LEVEL_V2_KEY);
            RFWLog.d(TAG, RFWLog.USR, "[getNewDeviceLevel] get system info, device level: " + sDeviceLevel);
        }
        return sDeviceLevel;
    }

    public static int getNumberOfCores() {
        if (sCoreNum == -1) {
            sCoreNum = ah.J();
        }
        return sCoreNum;
    }

    private static int getPrefDeviceLevel(String str) {
        try {
            int e16 = k.a().e(str, DEV_LEVEL_NONE);
            sDeviceLevel = e16;
            return e16;
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "[getPrefDeviceLevel] error: ", th5);
            return DEV_LEVEL_NONE;
        }
    }

    public static int getQQPerfDeviceLevel() {
        return com.tencent.qqperf.tools.d.f363413a.a();
    }

    private static int getSystemDeviceLevel() {
        int J = ah.J();
        long m3 = ah.m();
        long c16 = m.c();
        DeviceInfoEntity deviceInfoEntity = mHighDeviceInfo;
        if (J >= deviceInfoEntity.mCpuCoreNum && m3 >= deviceInfoEntity.mFreqKHz && (c16 > deviceInfoEntity.mRamMemory || isUpgradeHighDevice(deviceInfoEntity.mRamMemory))) {
            sDeviceLevel = 3;
        } else {
            DeviceInfoEntity deviceInfoEntity2 = mLowDeviceInfo;
            if (J > deviceInfoEntity2.mCpuCoreNum && c16 > deviceInfoEntity2.mRamMemory) {
                sDeviceLevel = 2;
            } else {
                sDeviceLevel = 1;
            }
        }
        return sDeviceLevel;
    }

    public static long getSystemTotalMemory() {
        if (sRawMem == -1) {
            sRawMem = m.c();
        }
        return sRawMem;
    }

    private static boolean hasWnsConfigLowDevice() {
        String U0 = uq3.c.U0();
        boolean z16 = false;
        if (TextUtils.isEmpty(U0)) {
            return false;
        }
        String[] split = U0.split("\\|");
        if (split != null && split.length != 0) {
            String F = ah.F();
            if (TextUtils.isEmpty(F)) {
                return false;
            }
            if (Arrays.asList(split).indexOf(F) != -1) {
                z16 = true;
            }
            QLog.d(TAG, 1, "[hasWnsConfigLowDevice] isConfigLowDevice: " + z16 + " | deviceModel: " + F + " | configLowLevelDevices: " + U0);
        }
        return z16;
    }

    private static void init() {
        checkHarmonyInfo();
        mIsInit = true;
    }

    public static boolean isHarmonyOs() {
        boolean z16;
        synchronized (mInitLock) {
            if (!mIsInit) {
                init();
            }
            z16 = mIsHarmonyOs;
        }
        return z16;
    }

    public static boolean isHighDevice() {
        if (getDeviceLevel() == 3) {
            return true;
        }
        return false;
    }

    public static boolean isLowDevice() {
        if (getDeviceLevel() == 1) {
            return true;
        }
        return false;
    }

    public static boolean isMediumDevice() {
        if (getDeviceLevel() == 2) {
            return true;
        }
        return false;
    }

    private static boolean isUpgradeHighDevice(long j3) {
        if (!o.U1() || j3 < UPGRADE_HIGH_RAM_MEMORY) {
            return false;
        }
        return true;
    }

    public static void updateDeviceLevelV2() {
        if (!o.u1()) {
            return;
        }
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils.1
            @Override // java.lang.Runnable
            public void run() {
                QCircleDeviceInfoUtils.updateSystemDeviceLevel(QCircleDeviceInfoUtils.DEV_LEVEL_V2_KEY);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateSystemDeviceLevel(String str) {
        int systemDeviceLevel;
        if (hasWnsConfigLowDevice()) {
            systemDeviceLevel = 1;
        } else {
            systemDeviceLevel = getSystemDeviceLevel();
        }
        sDeviceLevel = systemDeviceLevel;
        k.a().m(str, sDeviceLevel);
        QLog.d(TAG, 1, "[updateSystemDeviceLevel] device level: " + getDeviceLevelFlag());
    }
}
