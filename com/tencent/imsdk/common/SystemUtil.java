package com.tencent.imsdk.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Debug;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes7.dex */
public class SystemUtil {
    private static final String DEVICE_ID = "DeviceID";
    private static final String DEVICE_INFO = "DeviceInfo";
    private static final String TAG = "SystemUtil";
    private static final int TIME_INTERVAL = 15000;
    private static String buildBrand = "";
    private static String buildManufacturer = "";
    private static String buildModel = "";
    private static String buildVersionRelease = "";
    private static int buildVersionSDKInt = 0;
    private static float lastAppCpu = 0.0f;
    private static long lastAppCpuTime = 0;
    private static long lastMemCheckTimeStamps = 0;
    private static int lastMemUsage = 0;
    private static float lastSysCpu = 0.0f;
    private static long lastSysCpuTime = 0;
    private static boolean mFirstTimeRun = true;
    private static CpuUsageMeasurer sCpuUsageMeasurer = null;
    private static boolean sIsLoadLibrarySuccess = false;
    private static boolean sRunningMemCheck = false;

    public static float getAppCpuUsage() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastAppCpuTime < 15000) {
            return lastAppCpu;
        }
        float f16 = (getProcessCPURate()[0] / 10) / 100.0f;
        lastAppCpu = f16;
        lastAppCpuTime = currentTimeMillis;
        return f16;
    }

    public static float getAppMemory() {
        int i3;
        final long currentTimeMillis = System.currentTimeMillis();
        if (!sRunningMemCheck) {
            long j3 = lastMemCheckTimeStamps;
            if (j3 == 0 || currentTimeMillis - j3 >= 15000) {
                sRunningMemCheck = true;
                AsyncTask.execute(new Runnable() { // from class: com.tencent.imsdk.common.SystemUtil.1
                    @Override // java.lang.Runnable
                    public void run() {
                        System.currentTimeMillis();
                        boolean unused = SystemUtil.sRunningMemCheck = false;
                        try {
                            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
                            Debug.getMemoryInfo(memoryInfo);
                            int totalPss = memoryInfo.getTotalPss();
                            long unused2 = SystemUtil.lastMemCheckTimeStamps = currentTimeMillis;
                            int unused3 = SystemUtil.lastMemUsage = totalPss / 1024;
                        } catch (Exception unused4) {
                        }
                    }
                });
                i3 = lastMemUsage;
                return i3;
            }
        }
        i3 = lastMemUsage;
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getDeviceID() {
        String string;
        Context applicationContext = IMContext.getInstance().getApplicationContext();
        if (applicationContext == null) {
            return "";
        }
        boolean z16 = false;
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(DEVICE_INFO, 0);
        if (!sharedPreferences.contains(DEVICE_ID)) {
            string = UUID.randomUUID().toString();
        } else {
            string = sharedPreferences.getString(DEVICE_ID, "");
            if (!Pattern.matches("\\w{8}(-\\w{4}){3}-\\w{12}", string) || TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
            }
            if (z16) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(DEVICE_ID, string);
                edit.apply();
            }
            return string;
        }
        z16 = true;
        if (z16) {
        }
        return string;
    }

    public static String getDeviceType() {
        if (TextUtils.isEmpty(buildModel)) {
            return DeviceInfoMonitor.getModel();
        }
        return buildModel;
    }

    public static int getInstanceType() {
        if (isBrandXiaoMi()) {
            return 2000;
        }
        if (isBrandHuawei()) {
            return 2001;
        }
        if (isBrandMeizu()) {
            return 2003;
        }
        if (isBrandOppo()) {
            return 2004;
        }
        if (isBrandVivo()) {
            return 2005;
        }
        return 2002;
    }

    static int[] getProcessCPURate() {
        if (sCpuUsageMeasurer == null) {
            sCpuUsageMeasurer = new CpuUsageMeasurer();
        }
        if (mFirstTimeRun) {
            mFirstTimeRun = false;
            sCpuUsageMeasurer.getCpuUsage();
            return new int[]{0, 0};
        }
        return sCpuUsageMeasurer.getCpuUsage();
    }

    public static String getSDKInitPath() {
        Context applicationContext = IMContext.getInstance().getApplicationContext();
        if (applicationContext == null) {
            return "";
        }
        String file = applicationContext.getFilesDir().toString();
        IMLog.v(TAG, "SDK Init Path: " + file);
        return file;
    }

    public static String getSDKLogPath() {
        String sb5;
        Context applicationContext = IMContext.getInstance().getApplicationContext();
        if (applicationContext == null) {
            return "";
        }
        File externalFilesDir = applicationContext.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            sb5 = "/sdcard/Android/data/" + applicationContext.getPackageName() + "/log/tencent/imsdk";
        } else {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(externalFilesDir.getAbsolutePath());
            String str = File.separator;
            sb6.append(str);
            sb6.append("log");
            sb6.append(str);
            sb6.append("tencent");
            sb6.append(str);
            sb6.append("imsdk");
            sb5 = sb6.toString();
        }
        File file = new File(sb5);
        if (!file.exists() && !file.mkdirs()) {
            file = applicationContext.getFilesDir();
            IMLog.e(TAG, "create log folder failed");
        }
        String str2 = file.getAbsolutePath() + "/";
        IMLog.v(TAG, "SDK LOG Path: " + str2);
        return str2;
    }

    public static int getSDKVersion() {
        int i3 = buildVersionSDKInt;
        if (i3 == 0) {
            return Build.VERSION.SDK_INT;
        }
        return i3;
    }

    public static float getSysCpuUsage() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastSysCpuTime < 15000) {
            return lastSysCpu;
        }
        float f16 = (getProcessCPURate()[1] / 10) / 100.0f;
        lastSysCpu = f16;
        lastSysCpuTime = currentTimeMillis;
        return f16;
    }

    public static String getSystemVersion() {
        if (TextUtils.isEmpty(buildVersionRelease)) {
            return Build.VERSION.RELEASE;
        }
        return buildVersionRelease;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isBrandHuawei() {
        if (TextUtils.isEmpty(buildBrand) && TextUtils.isEmpty(buildManufacturer)) {
            if (!CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI.equalsIgnoreCase(Build.BRAND) && !CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI.equalsIgnoreCase(Build.MANUFACTURER)) {
                return false;
            }
            return true;
        }
        if (!CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI.equalsIgnoreCase(buildBrand) && !CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI.equalsIgnoreCase(buildBrand)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isBrandMeizu() {
        if (TextUtils.isEmpty(buildBrand) && TextUtils.isEmpty(buildManufacturer)) {
            String str = Build.BRAND;
            if (!"meizu".equalsIgnoreCase(str) && !"meizu".equalsIgnoreCase(Build.MANUFACTURER) && !"22c4185e".equalsIgnoreCase(str)) {
                return false;
            }
            return true;
        }
        if (!"meizu".equalsIgnoreCase(buildBrand) && !"meizu".equalsIgnoreCase(buildManufacturer) && !"22c4185e".equalsIgnoreCase(buildBrand)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isBrandOppo() {
        if (TextUtils.isEmpty(buildBrand) && TextUtils.isEmpty(buildManufacturer)) {
            if (!"oppo".equalsIgnoreCase(Build.BRAND) && !"oppo".equalsIgnoreCase(Build.MANUFACTURER)) {
                return false;
            }
            return true;
        }
        if (!"oppo".equalsIgnoreCase(buildBrand) && !"oppo".equalsIgnoreCase(buildManufacturer)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isBrandVivo() {
        if (TextUtils.isEmpty(buildBrand) && TextUtils.isEmpty(buildManufacturer)) {
            if (!CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO.equalsIgnoreCase(Build.BRAND) && !CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO.equalsIgnoreCase(Build.MANUFACTURER)) {
                return false;
            }
            return true;
        }
        if (!CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO.equalsIgnoreCase(buildBrand) && !CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO.equalsIgnoreCase(buildManufacturer)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isBrandXiaoMi() {
        if (TextUtils.isEmpty(buildBrand) && TextUtils.isEmpty(buildManufacturer)) {
            if (!"xiaomi".equalsIgnoreCase(Build.BRAND) && !"xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) {
                return false;
            }
            return true;
        }
        if (!"xiaomi".equalsIgnoreCase(buildBrand) && !"xiaomi".equalsIgnoreCase(buildManufacturer)) {
            return false;
        }
        return true;
    }

    public static boolean isLibraryLoaded() {
        return sIsLoadLibrarySuccess;
    }

    public static boolean loadIMLibrary() {
        return loadIMLibrary(null);
    }

    public static String md5(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String str2 = "";
            for (byte b16 : MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(str.getBytes())) {
                String hexString = Integer.toHexString(b16 & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                str2 = str2 + hexString;
            }
            return str2;
        } catch (NoSuchAlgorithmException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static void setBuildBrand(String str) {
        buildBrand = str;
    }

    public static void setBuildManufacturer(String str) {
        buildManufacturer = str;
    }

    public static void setBuildModel(String str) {
        buildModel = str;
    }

    public static void setBuildVersionRelease(String str) {
        buildVersionRelease = str;
    }

    public static void setBuildVersionSDKInt(int i3) {
        buildVersionSDKInt = i3;
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public static boolean loadIMLibrary(String str) {
        if (sIsLoadLibrarySuccess) {
            return true;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                String str2 = str + File.separator + "libImSDK.so";
                System.load(str2);
                sIsLoadLibrarySuccess = true;
                Log.i(TAG, "system load so library success: " + str2);
            } else {
                System.loadLibrary(SoLoadConstants.SONAME_IMSDK);
                sIsLoadLibrarySuccess = true;
                Log.i(TAG, "system load so library success, libImSDK.so");
            }
        } catch (Exception e16) {
            sIsLoadLibrarySuccess = false;
            Log.e(TAG, "system load so library failed, " + e16.getMessage());
        } catch (UnsatisfiedLinkError e17) {
            sIsLoadLibrarySuccess = false;
            Log.e(TAG, "system load so library failed, " + e17.getMessage());
        }
        return sIsLoadLibrarySuccess;
    }
}
