package org.light.device;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Debug;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Pattern;
import org.light.device.LightDeviceProperty;
import org.light.gles.GLCapabilities;
import org.light.utils.LightLogUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightDeviceUtils {
    private static final int MIN_OPENGL_ES_VERSION = 131072;
    public static final int MIN_STORAGE_SIZE = 52428800;
    public static final int RECORD_CPU_INTERVAL = 100;
    private static final String TAG = "LightDeviceUtils";
    private static String allCpuFreqKhz = null;
    private static String allCpuParts = null;
    private static float cpuRate = 0.0f;
    public static Handler handler = null;
    public static HandlerThread handlerThread = null;
    private static Boolean isRooted = null;
    private static long lastCpuIdleTime = 0;
    private static String lastCpuPart = null;
    private static long lastCpuTotalTime = 0;
    private static boolean mIsAllUnusable = false;
    private static boolean mIsOpenGlEsValid = true;
    public static int openGLESVersion = 65536;
    private static int recordCpuCount;
    private static int sCpuCount;
    private static int sMaxCpuFreq;
    private static int sTotalMemory;
    private static String socName;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class MEMORY_CLASS {
        public static final int IN_B = 0;
        public static final int IN_KB = 1;
        public static final int IN_MB = 2;
    }

    public static boolean canWriteFile(String str, boolean z16) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if ((z16 || str.endsWith(File.separator)) && (lastIndexOf = str.lastIndexOf(File.separator)) > -1) {
            str = str.substring(0, lastIndexOf);
        }
        File file = new File(str + File.separator + "test_temp.txt");
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            file.delete();
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private static int extractValue(byte[] bArr, int i3) {
        byte b16;
        byte b17;
        while (i3 < bArr.length && (b16 = bArr[i3]) != 10) {
            if (b16 >= 48 && b16 <= 57) {
                int i16 = i3 + 1;
                while (i16 < bArr.length && (b17 = bArr[i16]) >= 48 && b17 <= 57) {
                    i16++;
                }
                return Integer.parseInt(new String(bArr, 0, i3, i16 - i3));
            }
            i3++;
        }
        return -1;
    }

    public static String getAllCpuFreqKhz() {
        if (allCpuFreqKhz == null) {
            initCpuFreq();
        }
        return allCpuFreqKhz;
    }

    public static String getAllCpuParts() {
        if (allCpuParts == null) {
            initSocModelInfo();
        }
        return allCpuParts;
    }

    public static String getAppSDCardFileDir() {
        try {
            return ((Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getExternalFilesDir(null).getAbsolutePath();
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    @RequiresApi(api = 19)
    public static int getApplicationMemory() {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        int totalPrivateClean = memoryInfo.getTotalPrivateClean();
        int totalPrivateDirty = memoryInfo.getTotalPrivateDirty();
        int totalPss = memoryInfo.getTotalPss();
        int totalSharedClean = memoryInfo.getTotalSharedClean();
        return totalPrivateClean + totalPrivateDirty + totalPss + totalSharedClean + memoryInfo.getTotalSharedDirty() + memoryInfo.getTotalSwappablePss();
    }

    @TargetApi(18)
    public static long getAvailableSize(StatFs statFs) {
        if (ApiHelper.hasJellyBeanMR2()) {
            return statFs.getAvailableBytes();
        }
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    public static String getBenchmarkStrategy() {
        return OfflineConfig.getBenchmarkStrategy();
    }

    public static String getBuildModel() {
        return LightDeviceProperty.getStringProp(1);
    }

    public static String getBuildVersionName(Context context) {
        String versionName = getVersionName(context);
        if (TextUtils.isEmpty(versionName)) {
            return "";
        }
        return versionName.substring(versionName.lastIndexOf(".") + 1);
    }

    public static String getCpuNameOnce() {
        return getSocName();
    }

    public static float getCpuRate() {
        return cpuRate;
    }

    public static String getCurrentProcessName(Context context) {
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public static File getExternalFilesDir(Context context) {
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            return externalFilesDir;
        }
        return new File(context.getExternalFilesDir(null) + ("/Android/data/" + context.getPackageName() + "/files/"));
    }

    public static String getGpuInfo() {
        return GLCapabilities.getGPUInfo();
    }

    public static float getHeapAllocatedPercent(Context context) {
        return (((float) getHeapAllocatedSizeInKb()) * 1.0f) / ((float) getHeapMaxSizeInKb(context));
    }

    public static long getHeapAllocatedSizeInKb() {
        long runtimeTotalMemory = getRuntimeTotalMemory(1) - getRuntimeFreeMemory(1);
        LightLogUtil.v(TAG, "getHeapAllocatedSizeInKb(), heapAllocated = " + (((float) runtimeTotalMemory) / 1024.0f) + "(Mb), " + runtimeTotalMemory + "(Kb)");
        return runtimeTotalMemory;
    }

    public static long getHeapMaxSizeInKb(Context context) {
        long runtimeMaxMemory = getRuntimeMaxMemory(1);
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            LightLogUtil.v(TAG, "getHeapMaxSizeInKb(), heap size(Mb) = " + activityManager.getMemoryClass());
            return activityManager.getMemoryClass() * 1024;
        } catch (Exception e16) {
            LightLogUtil.e(e16);
            return runtimeMaxMemory;
        }
    }

    public static long getHeapMaxSizeInMb(Context context) {
        long runtimeMaxMemory = getRuntimeMaxMemory(2);
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            LightLogUtil.v(TAG, "getHeapMaxSizeInMb(), heap size(Mb) = " + activityManager.getMemoryClass());
            return activityManager.getMemoryClass();
        } catch (Exception e16) {
            LightLogUtil.e(e16);
            return runtimeMaxMemory;
        }
    }

    public static long getHeapRemainSizeInKb(Context context) {
        long heapMaxSizeInKb = getHeapMaxSizeInKb(context) - getHeapAllocatedSizeInKb();
        LightLogUtil.v(TAG, "getHeapRemainSizeInKb(), remainSize = " + (((float) heapMaxSizeInKb) / 1024.0f) + "(Mb), " + heapMaxSizeInKb + "(Kb)");
        return heapMaxSizeInKb;
    }

    public static long getLargeHeapMaxSizeInKb(Context context) {
        long runtimeMaxMemory = getRuntimeMaxMemory(1);
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            LightLogUtil.v(TAG, "getLargeHeapMaxSizeInKb(), heap size(Mb) = " + activityManager.getLargeMemoryClass());
            return activityManager.getLargeMemoryClass() * 1024;
        } catch (Exception e16) {
            LightLogUtil.e(e16);
            return runtimeMaxMemory;
        }
    }

    public static long getLargeHeapRemainSizeInKb(Context context) {
        long largeHeapMaxSizeInKb = getLargeHeapMaxSizeInKb(context) - getHeapAllocatedSizeInKb();
        LightLogUtil.v(TAG, "getLargeHeapRemainSizeInKb(), remainSize = " + (((float) largeHeapMaxSizeInKb) / 1024.0f) + "(Mb), " + largeHeapMaxSizeInKb + "(Kb)");
        return largeHeapMaxSizeInKb;
    }

    public static String getLastCpuPart() {
        if (lastCpuPart == null) {
            initSocModelInfo();
        }
        return lastCpuPart;
    }

    public static String getMachineInfo() {
        return DeviceInstance.getInstance().getDeviceName();
    }

    public static int getMaxCpuFreq() {
        if (sMaxCpuFreq <= 0) {
            initCpuFreq();
        }
        return sMaxCpuFreq;
    }

    public static int getNavigationBarHeight(Activity activity) {
        if (!isNavigationBarShow(activity)) {
            return 0;
        }
        Resources resources = activity.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    public static int getNumCores() {
        int i3 = sCpuCount;
        if (i3 > 0) {
            return i3;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: org.light.device.LightDeviceUtils.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]", file.getName());
                }
            });
            if (listFiles != null) {
                sCpuCount = listFiles.length;
            } else {
                sCpuCount = 1;
            }
        } catch (Throwable th5) {
            LightLogUtil.e(th5);
            sCpuCount = 1;
        }
        LightLogUtil.v("DeviceUtils", "sCpuCount:" + sCpuCount);
        return sCpuCount;
    }

    public static String getOSVersion() {
        return LightDeviceProperty.getStringProp(8);
    }

    public static int getOpenGlEsVersion(Context context) {
        ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getDeviceConfigurationInfo();
        if (deviceConfigurationInfo != null) {
            openGLESVersion = deviceConfigurationInfo.reqGlEsVersion;
        }
        return openGLESVersion;
    }

    public static int getPhonePerfLevel(Context context) {
        return OfflineConfig.getPhonePerfLevel(context);
    }

    private static long getRuntimeFreeMemory(int i3) {
        long freeMemory;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    freeMemory = Runtime.getRuntime().freeMemory();
                } else {
                    freeMemory = (Runtime.getRuntime().freeMemory() / 1024) / 1024;
                }
            } else {
                freeMemory = Runtime.getRuntime().freeMemory() / 1024;
            }
        } else {
            freeMemory = Runtime.getRuntime().freeMemory();
        }
        LightLogUtil.v(TAG, "[getRuntimeFreeMemory] freeMemory = " + ((Runtime.getRuntime().freeMemory() / 1024) / 1024) + "(Mb), " + (Runtime.getRuntime().freeMemory() / 1024) + "(Kb)");
        return freeMemory;
    }

    private static long getRuntimeMaxMemory(int i3) {
        long maxMemory = Runtime.getRuntime().maxMemory();
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    maxMemory = (Runtime.getRuntime().maxMemory() / 1024) / 1024;
                }
            } else {
                maxMemory = Runtime.getRuntime().maxMemory() / 1024;
            }
        } else {
            maxMemory = Runtime.getRuntime().maxMemory();
        }
        LightLogUtil.v(TAG, "[getRuntimeMaxMemory] maxMemory = " + ((Runtime.getRuntime().maxMemory() / 1024) / 1024) + "(Mb), " + (Runtime.getRuntime().maxMemory() / 1024) + "(Kb)");
        return maxMemory;
    }

    public static long getRuntimeRemainSize(int i3) {
        long maxMemory = Runtime.getRuntime().maxMemory() - (getHeapAllocatedSizeInKb() * 1024);
        if (i3 != 1) {
            if (i3 == 2) {
                maxMemory /= 1048576;
            }
        } else {
            maxMemory /= 1024;
        }
        LightLogUtil.v(TAG, "[getRuntimeRemainSize] remainMemory = " + maxMemory + " " + i3);
        return maxMemory;
    }

    private static long getRuntimeTotalMemory(int i3) {
        long j3;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    j3 = Runtime.getRuntime().totalMemory();
                } else {
                    j3 = (Runtime.getRuntime().totalMemory() / 1024) / 1024;
                }
            } else {
                j3 = Runtime.getRuntime().totalMemory() / 1024;
            }
        } else {
            j3 = Runtime.getRuntime().totalMemory();
        }
        LightLogUtil.v(TAG, "[getRuntimeTotalMemory] totalMemory = " + ((Runtime.getRuntime().totalMemory() / 1024) / 1024) + "(Mb), " + (Runtime.getRuntime().totalMemory() / 1024) + "(Kb)");
        return j3;
    }

    public static int getScreenHeight(Context context) {
        if (context == null) {
            return 1;
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenHeightWithNavigationBar(Activity activity) {
        return getScreenHeight(activity) + getNavigationBarHeight(activity);
    }

    public static float getScreenRatio(Context context) {
        int screenWidth = getScreenWidth(context);
        int screenHeight = getScreenHeight(context);
        int max = Math.max(screenWidth, screenHeight);
        int min = Math.min(screenWidth, screenHeight);
        if (NotchInScreenUtils.hasNotchInScreenHw(context)) {
            max -= NotchInScreenUtils.getNotchHeightHw(context);
        }
        return (min * 1.0f) / max;
    }

    public static String getScreenSize(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return "" + displayMetrics.widthPixels + " * " + displayMetrics.heightPixels;
    }

    public static int getScreenWidth(Context context) {
        if (context == null) {
            return 1;
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static String getSocName() {
        if (socName == null) {
            initSocModelInfo();
        }
        return socName;
    }

    public static int getSystemScreenBrightness(ContentResolver contentResolver) {
        try {
            return Settings.System.getInt(contentResolver, "screen_brightness");
        } catch (Exception e16) {
            LightLogUtil.e(e16);
            return 0;
        }
    }

    public static int getSystemScreenMode(ContentResolver contentResolver) {
        try {
            return Settings.System.getInt(contentResolver, "screen_brightness_mode");
        } catch (Exception e16) {
            LightLogUtil.e(e16);
            return -1;
        }
    }

    public static String getThreadName() {
        return Thread.currentThread().getName();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    public static long getTotalRamMemory(Context context) {
        if (LightDeviceProperty.VERSION.SDK_INT >= 16 && context != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem;
        }
        long j3 = -1;
        j3 = -1;
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/meminfo");
            try {
                j3 = parseFileForValue("MemTotal", fileInputStream);
                j3 = ((long) j3) * 1024;
                fileInputStream.close();
            } catch (Throwable th5) {
                fileInputStream.close();
                throw th5;
            }
        } catch (IOException unused) {
        }
        return j3;
    }

    @TargetApi(18)
    public static long getTotalSize(StatFs statFs) {
        if (ApiHelper.hasJellyBeanMR2()) {
            return statFs.getTotalBytes();
        }
        return statFs.getBlockCount() * statFs.getBlockSize();
    }

    public static int getVersionCode(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 16384).versionCode;
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    public static String getVersionName(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static float getWindowScreenBrightness(Window window) {
        return window.getAttributes().screenBrightness;
    }

    public static void hideNavigationBar(Activity activity) {
        final View decorView = activity.getWindow().getDecorView();
        if (LightDeviceProperty.VERSION.SDK_INT >= 19) {
            decorView.setSystemUiVisibility(5894);
            decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: org.light.device.LightDeviceUtils.2
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i3) {
                    if ((i3 & 4) == 0) {
                        decorView.setSystemUiVisibility(5894);
                    }
                }
            });
        }
    }

    private static void initCpuFreq() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < getNumCores(); i3++) {
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i3 + "/cpufreq/cpuinfo_max_freq");
                if (file.exists()) {
                    byte[] bArr = new byte[128];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        int i16 = 0;
                        while (true) {
                            byte b16 = bArr[i16];
                            if (b16 < 48 || b16 > 57 || i16 >= 128) {
                                break;
                            } else {
                                i16++;
                            }
                        }
                        String str = new String(bArr, 0, i16);
                        arrayList.add(str);
                        Integer valueOf = Integer.valueOf(Integer.parseInt(str));
                        if (valueOf.intValue() > sMaxCpuFreq) {
                            sMaxCpuFreq = valueOf.intValue();
                        }
                    } catch (NumberFormatException unused) {
                    } catch (Throwable th5) {
                        fileInputStream.close();
                        throw th5;
                    }
                    fileInputStream.close();
                }
            } catch (IOException unused2) {
                sMaxCpuFreq = -1;
            }
        }
        if (sMaxCpuFreq == -1) {
            FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
            try {
                int parseFileForValue = parseFileForValue("cpu MHz", fileInputStream2) * 1000;
                arrayList.add(String.valueOf(parseFileForValue));
                if (parseFileForValue > sMaxCpuFreq) {
                    sMaxCpuFreq = parseFileForValue;
                }
                fileInputStream2.close();
            } catch (Throwable th6) {
                fileInputStream2.close();
                throw th6;
            }
        }
        allCpuFreqKhz = TextUtils.join(";", arrayList);
        LightLogUtil.v("DeviceUtils", "sMaxCpuFreq:" + sMaxCpuFreq);
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00bf: MOVE (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:192), block:B:59:0x00bf */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void initSocModelInfo() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        IOException e16;
        FileNotFoundException e17;
        String str;
        LinkedList linkedList = new LinkedList();
        BufferedReader bufferedReader3 = null;
        try {
            try {
                try {
                    bufferedReader2 = new BufferedReader(new FileReader("/proc/cpuinfo"));
                } catch (FileNotFoundException e18) {
                    bufferedReader2 = null;
                    e17 = e18;
                } catch (IOException e19) {
                    bufferedReader2 = null;
                    e16 = e19;
                } catch (Throwable th5) {
                    th = th5;
                    if (bufferedReader3 != null) {
                        try {
                            bufferedReader3.close();
                        } catch (IOException e26) {
                            e26.printStackTrace();
                        }
                    }
                    throw th;
                }
                try {
                    for (String readLine = bufferedReader2.readLine(); readLine != null; readLine = bufferedReader2.readLine()) {
                        String[] split = readLine.split(":\\s+", 2);
                        if (split.length > 1) {
                            String lowerCase = split[0].trim().toLowerCase();
                            if (lowerCase.contains("hardware")) {
                                LightLogUtil.w(TAG, "/proc/cpuinfo => hardware line = " + readLine);
                                socName = split[1].trim();
                            }
                            if (lowerCase.contains("cpu part")) {
                                linkedList.add(split[1].trim());
                            }
                        }
                    }
                    bufferedReader2.close();
                } catch (FileNotFoundException e27) {
                    e17 = e27;
                    e17.printStackTrace();
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    allCpuParts = TextUtils.join(";", linkedList);
                    if (linkedList.isEmpty()) {
                    }
                    lastCpuPart = str;
                    if (socName == null) {
                    }
                } catch (IOException e28) {
                    e16 = e28;
                    e16.printStackTrace();
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    allCpuParts = TextUtils.join(";", linkedList);
                    if (linkedList.isEmpty()) {
                    }
                    lastCpuPart = str;
                    if (socName == null) {
                    }
                }
            } catch (IOException e29) {
                e29.printStackTrace();
            }
            allCpuParts = TextUtils.join(";", linkedList);
            if (linkedList.isEmpty()) {
                str = "";
            } else {
                str = (String) linkedList.getLast();
            }
            lastCpuPart = str;
            if (socName == null) {
                socName = NotchInScreenUtils.getSystemProperties("ro.board.platform");
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedReader3 = bufferedReader;
        }
    }

    public static boolean isExternalStorageAvailable(Context context) {
        try {
            if (!"mounted".equals(Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable()) {
                return false;
            }
            new StatFs(context.getExternalFilesDir(null).getAbsolutePath());
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isExternalStorageSpaceEnough(Context context, long j3) {
        try {
            if (getAvailableSize(new StatFs(context.getExternalFilesDir(null).getAbsolutePath())) <= j3) {
                return false;
            }
            return true;
        } catch (IllegalArgumentException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static boolean isMainProcess(Context context) {
        if (context != null && context.getPackageName().equals(getCurrentProcessName(context))) {
            return true;
        }
        return false;
    }

    public static boolean isNavigationBarShow(Activity activity) {
        int i3;
        if (getBuildModel().equals("Redmi 6")) {
            if (LightDeviceProperty.VERSION.SDK_INT < 21) {
                i3 = Settings.System.getInt(activity.getContentResolver(), "force_fsg_nav_bar", 0);
            } else {
                i3 = Settings.Global.getInt(activity.getContentResolver(), "force_fsg_nav_bar", 0);
            }
            if (i3 != 1) {
                return true;
            }
            return false;
        }
        if (LightDeviceProperty.VERSION.SDK_INT >= 17) {
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            Point point = new Point();
            Point point2 = new Point();
            defaultDisplay.getSize(point);
            defaultDisplay.getRealSize(point2);
            if (point2.y != point.y) {
                return true;
            }
            return false;
        }
        boolean hasPermanentMenuKey = ViewConfiguration.get(activity).hasPermanentMenuKey();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        if (!hasPermanentMenuKey && !deviceHasKey) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
    
        org.light.device.LightDeviceUtils.isRooted = java.lang.Boolean.TRUE;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isRooted() {
        Boolean bool = isRooted;
        if (bool != null) {
            return bool.booleanValue();
        }
        isRooted = Boolean.FALSE;
        String[] strArr = {"/system/bin/su", "/system/xbin/su", "/system/sbin/su", "/sbin/su", "/vendor/bin/su"};
        int i3 = 0;
        while (true) {
            if (i3 >= 5) {
                break;
            }
            try {
                if (new File(strArr[i3]).exists()) {
                    break;
                }
                i3++;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return isRooted.booleanValue();
    }

    public static boolean isValid(Context context) {
        boolean z16;
        if (getOpenGlEsVersion(context) >= 131072) {
            z16 = true;
        } else {
            z16 = false;
        }
        mIsOpenGlEsValid = z16;
        mIsAllUnusable = false;
        if (z16) {
            return true;
        }
        return false;
    }

    private static int parseFileForValue(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int read = fileInputStream.read(bArr);
            int i3 = 0;
            while (i3 < read) {
                byte b16 = bArr[i3];
                if (b16 == 10 || i3 == 0) {
                    if (b16 == 10) {
                        i3++;
                    }
                    for (int i16 = i3; i16 < read; i16++) {
                        int i17 = i16 - i3;
                        if (bArr[i16] != str.charAt(i17)) {
                            break;
                        }
                        if (i17 == str.length() - 1) {
                            return extractValue(bArr, i16);
                        }
                    }
                }
                i3++;
            }
            return -1;
        } catch (IOException | NumberFormatException unused) {
            return -1;
        }
    }

    public static void recordCpuInfo() {
        if (LightDeviceProperty.VERSION.SDK_INT >= 26) {
            return;
        }
        if (handlerThread == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("CAL_CPU_RATE");
            handlerThread = baseHandlerThread;
            baseHandlerThread.start();
            handler = new Handler(handlerThread.getLooper());
        }
        int i3 = recordCpuCount;
        if (i3 % 100 == 0) {
            handler.post(new Runnable() { // from class: org.light.device.LightDeviceUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/stat")), 1000);
                        String readLine = bufferedReader.readLine();
                        bufferedReader.close();
                        String[] split = readLine.split(" ");
                        try {
                            long parseLong = Long.parseLong(split[2]) + Long.parseLong(split[3]) + Long.parseLong(split[4]) + Long.parseLong(split[6]) + Long.parseLong(split[5]) + Long.parseLong(split[7]) + Long.parseLong(split[8]);
                            long parseLong2 = Long.parseLong(split[5]);
                            if (LightDeviceUtils.lastCpuIdleTime > 0 && LightDeviceUtils.lastCpuTotalTime > 0 && parseLong != LightDeviceUtils.lastCpuTotalTime) {
                                float unused = LightDeviceUtils.cpuRate = 1.0f - ((((float) (parseLong2 - LightDeviceUtils.lastCpuIdleTime)) * 1.0f) / ((float) (parseLong - LightDeviceUtils.lastCpuTotalTime)));
                            }
                            long unused2 = LightDeviceUtils.lastCpuIdleTime = parseLong2;
                            long unused3 = LightDeviceUtils.lastCpuTotalTime = parseLong;
                            int unused4 = LightDeviceUtils.recordCpuCount = 1;
                        } catch (ArrayIndexOutOfBoundsException e16) {
                            LightLogUtil.e(LightDeviceUtils.TAG, "ArrayIndexOutOfBoundsException" + e16.toString());
                        }
                    } catch (IOException e17) {
                        LightLogUtil.e(LightDeviceUtils.TAG, "IOException" + e17.toString());
                    }
                }
            });
        } else {
            recordCpuCount = i3 + 1;
        }
    }

    public static void resetWindowScreenBrightness(Window window) {
        if (window == null) {
            return;
        }
        setWindowScreenBrightness(window, -1.0f);
    }

    public static void setNavigationBarColor(Activity activity, int i3) {
        int i16;
        int i17;
        Window window = activity.getWindow();
        if (LightDeviceProperty.VERSION.SDK_INT >= 21) {
            window.clearFlags(201326592);
            if (getBuildModel().equals("Pixel")) {
                i17 = 1808;
            } else {
                i17 = 1792;
            }
            window.getDecorView().setSystemUiVisibility(i17);
            window.addFlags(Integer.MIN_VALUE);
            window.setNavigationBarColor(i3);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View view = new View(activity);
        int identifier = activity.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            i16 = activity.getResources().getDimensionPixelSize(identifier);
        } else {
            i16 = 0;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, i16);
        layoutParams.gravity = 80;
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(Color.parseColor("#000000"));
        viewGroup.addView(view);
    }

    public static void setSystemScreenBrightness(ContentResolver contentResolver, int i3) {
        try {
            Settings.System.putInt(contentResolver, "screen_brightness", i3);
        } catch (Exception e16) {
            LightLogUtil.e(e16);
        }
    }

    public static void setSystemScreenMode(ContentResolver contentResolver, int i3) {
        try {
            Settings.System.putInt(contentResolver, "screen_brightness_mode", i3);
            contentResolver.notifyChange(Settings.System.getUriFor("screen_brightness_mode"), null);
        } catch (Exception e16) {
            LightLogUtil.e(e16);
        }
    }

    public static void setWindowScreenBrightness(Window window, float f16) {
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = f16;
        window.setAttributes(attributes);
    }

    public static void setWindowScreenBrightnessMax(Activity activity) {
        if (activity == null) {
            return;
        }
        if (veryLargeScreen(activity)) {
            setWindowScreenBrightness(activity.getWindow(), 0.8f);
        } else {
            setWindowScreenBrightness(activity.getWindow(), 1.0f);
        }
    }

    public static boolean veryLargeScreen(Context context) {
        if (getScreenHeight(context) * getScreenWidth(context) >= 2073600) {
            return true;
        }
        return false;
    }

    public static File getExternalFilesDir(Context context, String str) {
        File file = new File(((isExternalStorageAvailable(context) && isExternalStorageSpaceEnough(context, IPublicAccountJavascriptInterface.MAX_H5_DATA_SIZE)) ? getExternalFilesDir(context).getPath() : null) + File.separator + str);
        try {
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception unused) {
        }
        return file;
    }
}
