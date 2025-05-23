package com.tencent.qqmini.sdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.DeviceUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.PrivacyProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;
import java.io.FileFilter;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DeviceInfoUtil {
    private static final int LEVEL_HIGH = 1;
    private static final int LEVEL_LOW = 3;
    private static final int LEVEL_MEDIUM = 2;
    private static final int LEVEL_UNKNOWN = 0;
    public static final String PERF_CONFIG_FILE = "perf_config";
    private static String sdkVersion;
    private static final FileFilter CPU_FILTER = new FileFilter() { // from class: com.tencent.qqmini.sdk.utils.DeviceInfoUtil.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i3 = 3; i3 < name.length(); i3++) {
                if (name.charAt(i3) < '0' || name.charAt(i3) > '9') {
                    return false;
                }
            }
            return true;
        }
    };
    public static float density = 1.0f;
    public static int densityDpi = 0;
    private static int sPerfLevelRemote = 0;
    private static int sPerfLevelLocal = 0;
    private static long screenWidth = 0;
    private static long screenHeight = 0;
    private static int orientation = 0;
    private static int sCPUCoreNumber = -1;
    private static String imei = null;
    private static String androidId = null;
    private static String phoneModel = null;
    private static MiniAppProxy.DeviceType deviceType = null;

    public static String getAndroidID() {
        if (androidId == null) {
            androidId = ((PrivacyProxy) ProxyManager.get(PrivacyProxy.class)).getAndroidId();
        }
        return androidId;
    }

    public static long getHeight() {
        int i3;
        long min;
        initDispalyParams();
        int i16 = orientation;
        if (i16 == 1) {
            min = Math.max(screenWidth, screenHeight);
        } else if (i16 == 2) {
            min = Math.min(screenWidth, screenHeight);
        } else {
            i3 = 0;
            return i3;
        }
        i3 = (int) min;
        return i3;
    }

    public static String getIMEI() {
        if (imei == null) {
            imei = ((PrivacyProxy) ProxyManager.get(PrivacyProxy.class)).getIMEI();
        }
        return imei;
    }

    public static SharedPreferences getLowDeviceSp() {
        return AppLoaderFactory.g().getContext().getSharedPreferences(PERF_CONFIG_FILE, 4);
    }

    public static int getNumberOfCPUCores() {
        int i3;
        int i16 = sCPUCoreNumber;
        if (i16 > 0) {
            return i16;
        }
        try {
            i3 = new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
        } catch (Throwable unused) {
            i3 = -1;
        }
        sCPUCoreNumber = i3;
        return i3;
    }

    public static int getPerfLevel() {
        if (sPerfLevelLocal == 0) {
            sPerfLevelLocal = getPerfLevelLocal();
        }
        return sPerfLevelLocal;
    }

    private static int getPerfLevelLocal() {
        int i3 = getLowDeviceSp().getInt("localLevel", 0);
        if (i3 == 0) {
            int cpuNumber = DeviceUtil.getCpuNumber();
            long cpuMaxFreq = DeviceUtil.getCpuMaxFreq();
            long systemTotalMemory = DeviceUtil.getSystemTotalMemory();
            if (cpuNumber >= 8 && cpuMaxFreq >= 2000000 && systemTotalMemory > 8589934592L) {
                i3 = 1;
            } else if (cpuNumber > 6 && systemTotalMemory > 4294967296L) {
                i3 = 2;
            } else {
                i3 = 3;
            }
        }
        getLowDeviceSp().edit().putInt("localLevel", i3).apply();
        return i3;
    }

    public static String getPhoneModel() {
        if (phoneModel == null) {
            phoneModel = ((PrivacyProxy) ProxyManager.get(PrivacyProxy.class)).getPhoneModel();
        }
        return phoneModel;
    }

    public static Debug.MemoryInfo getProcessMemory(int i3) {
        ActivityManager activityManager;
        Debug.MemoryInfo[] processMemoryInfo;
        Debug.MemoryInfo memoryInfo = null;
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                Context context = AppLoaderFactory.g().getContext();
                if (context != null) {
                    activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                } else {
                    activityManager = null;
                }
                if (activityManager != null && (processMemoryInfo = SystemMethodProxy.getProcessMemoryInfo(activityManager, new int[]{i3})) != null && processMemoryInfo.length > 0) {
                    memoryInfo = processMemoryInfo[0];
                }
            }
            if (memoryInfo == null) {
                Debug.MemoryInfo memoryInfo2 = new Debug.MemoryInfo();
                try {
                    Debug.getMemoryInfo(memoryInfo2);
                    return memoryInfo2;
                } catch (Throwable th5) {
                    memoryInfo = memoryInfo2;
                    th = th5;
                    QMLog.e("DeviceInfoUtil", "getProcessMemory exception", th);
                    return memoryInfo;
                }
            }
            return memoryInfo;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static long[] getSDCardMemory() {
        try {
            long[] jArr = new long[2];
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                long blockSize = statFs.getBlockSize();
                long blockCount = statFs.getBlockCount();
                long availableBlocks = statFs.getAvailableBlocks();
                jArr[0] = (blockCount * blockSize) / 1048576;
                jArr[1] = (blockSize * availableBlocks) / 1048576;
            }
            return jArr;
        } catch (Exception e16) {
            e16.printStackTrace();
            return new long[]{-1, -1};
        }
    }

    public static String getSDKVersion() {
        if (!TextUtils.isEmpty(sdkVersion)) {
            return sdkVersion;
        }
        try {
            Context context = AppLoaderFactory.g().getContext();
            sdkVersion = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            sdkVersion = "getVersionException";
        }
        return sdkVersion;
    }

    public static long getWidth() {
        int i3;
        long max;
        initDispalyParams();
        int i16 = orientation;
        if (i16 == 1) {
            max = Math.min(screenWidth, screenHeight);
        } else if (i16 == 2) {
            max = Math.max(screenWidth, screenHeight);
        } else {
            i3 = 0;
            return i3;
        }
        i3 = (int) max;
        return i3;
    }

    private static void initDispalyParams() {
        initDispalyParams(false);
    }

    public static boolean isFoldDevice() {
        if (deviceType == null) {
            deviceType = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getDeviceType();
        }
        if (deviceType == MiniAppProxy.DeviceType.FOLD) {
            return true;
        }
        return false;
    }

    public static boolean isScreenOn(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isScreenOn();
        } catch (Throwable th5) {
            QMLog.e("DeviceInfoUtil", "", th5);
            return true;
        }
    }

    private static void initDispalyParams(boolean z16) {
        if (screenWidth == 0 || screenHeight == 0 || z16) {
            Context context = AppLoaderFactory.g().getContext();
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            screenWidth = displayMetrics.widthPixels;
            screenHeight = displayMetrics.heightPixels;
            density = displayMetrics.density;
            densityDpi = displayMetrics.densityDpi;
            Configuration configuration = context.getResources().getConfiguration();
            if (configuration != null) {
                orientation = configuration.orientation;
                if (QMLog.isColorLevel()) {
                    QMLog.i("DeviceInfoUtil", "initDispalyParams, [" + orientation + "," + screenWidth + "," + screenHeight + "]");
                }
            }
        }
    }
}
