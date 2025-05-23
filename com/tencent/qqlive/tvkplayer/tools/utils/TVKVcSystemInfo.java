package com.tencent.qqlive.tvkplayer.tools.utils;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.media.MediaDrm;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.SystemProperties;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.thumbplayer.libloader.TPFromApkLibraryLoader;
import cooperation.qzone.util.WiFiDash;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.util.UUID;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKVcSystemInfo {
    public static final int CHIP_ARM_AARCH64 = 7;
    public static final int CHIP_ARM_LATER = 50;
    public static final int CHIP_ARM_V5 = 3;
    public static final int CHIP_ARM_V6 = 4;
    public static final int CHIP_ARM_V7_NENO = 6;
    public static final int CHIP_ARM_V7_NO_NENO = 5;
    public static final int CHIP_MIPS = 2;
    public static final int CHIP_UNKNOW = 0;
    public static final int CHIP_X86 = 1;
    public static final int CPU_HW_HISI = 2;
    public static final int CPU_HW_MTK = 1;
    public static final int CPU_HW_OTHER = -1;
    public static final int CPU_HW_QUALCOMM = 0;
    public static final int CPU_HW_SUMSUNG = 3;
    private static final String GUID_FILE = "/guid";
    public static final int PLAYER_LEVEL_1 = 1;
    public static final int PLAYER_LEVEL_11 = 11;
    public static final int PLAYER_LEVEL_16 = 16;
    public static final int PLAYER_LEVEL_21 = 21;
    public static final int PLAYER_LEVEL_26 = 26;
    public static final int PLAYER_LEVEL_28 = 28;
    public static final int PLAYER_LEVEL_33 = 33;
    public static final int PLAYER_LEVEL_6 = 6;
    private static final String TAG = "TVKPlayer[TVKVcSystemInfo]";
    private static long sAppInstallTime;
    private static String sAppVersionName;
    private static float sDensity;
    private static Method sGetWlanMethod;
    private static int sMaxValueOfWidthHeight;
    private static int sScreenHeight;
    private static int sScreenWidth;
    private static final String MANUFACTURER = Build.MANUFACTURER;
    private static final String BRAND = Build.BRAND;
    private static final String OS_VERSION_RELEASE = Build.VERSION.RELEASE;
    private static final String GUID_PHONE_PATH = Environment.getDataDirectory() + "/data/";
    private static final String[][] sCpuPerfList = {new String[]{"MSM7227", "MSM7627", "MSM7227T", "MSM7627T", "MSM7227A", "MSM7627A", "QSD8250", "QSD8650", "MSM7230", "MSM7630", "APQ8055", "MSM8255", "MSM8655", "MSM8255T", "MSM8655T", "MSM8225", "MSM8625", "MSM8260", "MSM8660", "MSM8x25Q", "MSM8x26", "MSM8x10", "MSM8x12", "MSM8x30", "MSM8260A", "MSM8660A", "MSM8960", "MSM8208", "MSM8916", "MSM8960T", "MSM8909", "MSM8916v2", "MSM8936", "MSM8909v2", "MSM8917", "APQ8064", "APQ8064T", "MSM8920", "MSM8939", "MSM8937", "MSM8939v2", "MSM8940", "MSM8952", "MSM8974", "MSM8x74AA", "MSM8x74AB", "MSM8x74AC", "MSM8953", "APQ8084", "MSM8953Pro", "MSM8992", "MSM8956", "MSM8976", "MSM8976Pro", "SDM660", "MSM8994", "SM6115", "SM6125", "SM6150", "SDM670", "SM6225", "SM6350", "SM6375", "SM6450", "SDM710", "SDM712", "SM7125", "SM7150", "SDM730G", "SM7225", "SM7250", "SM7325", "SM7350", "SM7450", "APQ8074", "MSM8274", "MSM8674", "MSM8996", "MSM8998", "SDM845", "SDM850", "SM8150", "SM8250", "SM8350", "SM8450", "SM8475", "SM8550", "SM8650"}, new String[]{"MT6516", "MT6513", "MT6573", "MT6515M", "MT6515", "MT6575", "MT6572", "MT6577", "MT6589", "MT6582", "MT6588", "MT6591", "MT6592", "MT6595", "MT6732", "MT6735", "MT6750", "MT6752", "MT6753", "MT6755", "MT6755T", "MT6795", "MT6757", "MT675x", "MT6797", "MT6797T", "MT6833", "MT6853", "MT6873", "MT6875", "MT6877", "MT6855", "MT6883", "MT6885", "MT6889", "MT6891", "MT6893", "MT6895", "MT6896", "MT6983", "MT6985", "MT8377", "MT8317", "MT8125", "MT8389", "MT8135", "MT8382", "MT8312", "MT8121", "MT8117", "MT8392", "MT8127", "MT8732", "MT8752", "MT8163", "MT8735", "MT8173", "MT8176"}, new String[]{"K3V2", "K3V2E", "K3V2+", "Kirin910", "Kirin920", "Kirin925", "Kirin928", "Kirin620", "Kirin650", "Kirin655", "Kirin659", "Kirin930", "Kirin935", "Kirin950", "Kirin955", "Kirin710", "Kirin960", "Kirin970", "Kirin810", "Kirin980", "Kirin820", "Kirin985", "Kirin990", "Kirin990E", "Kirin9000E", "Kirin9000", "Kirin9000s", "Kirin9000L"}, new String[]{"S5L8900", "S5PC100", "Exynos3110", "Exynos3475", "Exynos4210", "Exynos4212", "SMDK4x12", "Exynos4412", "Exynos5250", "Exynos5260", "Exynos5410", "Exynos5420", "Exynos5422", "Exynos5430", "Exynos5800", "Exynos5433", "Exynos7580", "Exynos7870", "Exynos7870", "Exynos7420", "Exynos8890", "Exynos8895", "Exynos9810", "Exynos9820", "Exynos9825", "Exynos980", "Exynos990", "Exynos1080", "Exynos2100", "Exynos2200"}};
    private static String sProcessorName = WiFiDash.NOT_AVALIBLE;
    private static String sFeature = "";
    private static String sCpuHardware = "";
    private static String sCpuChipName = "";
    private static int sCpuArchitecture = 0;
    private static int sCpuHWProducer = -1;
    private static int sCpuHWProductIdx = -1;
    private static int sDeviceLevel = -1;
    private static boolean sReadMarketId = false;
    private static int sMarketId = 0;
    private static long sTotalMem = 0;
    private static String sCpuChipModel = "";
    private static String sDeviceModel = "";
    private static int sOpenGLVersion = 0;
    private static String sPackageName = "";
    private static long sMaxCpuFreq = -1;
    private static int sNumOfCores = -1;
    private static int sCpuArch = -1;
    private static long sCurrentCpuFreq = -1;
    private static int sExternalStorageMounted = -1;
    private static String sPackageABI = "";
    private static String sPackageABIFromProcess = "";

    private static boolean checkPermission(Context context, String str) {
        boolean z16 = true;
        if (!hasMarshmallow()) {
            return true;
        }
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if ("android.permission.WRITE_SETTINGS".equals(str)) {
            return Settings.System.canWrite(context);
        }
        try {
            if (context.getApplicationContext().checkSelfPermission(str) != 0) {
                z16 = false;
            }
            return z16;
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16);
            return false;
        }
    }

    public static long getAppInstallTime(Context context) {
        if (context == null) {
            return 0L;
        }
        long j3 = sAppInstallTime;
        if (0 != j3) {
            return j3;
        }
        try {
            long lastModified = new File(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir).lastModified() / 1000;
            sAppInstallTime = lastModified;
            return lastModified;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static String getAppVersionName(Context context) {
        if (!TextUtils.isEmpty(sAppVersionName)) {
            return sAppVersionName;
        }
        if (context == null) {
            return "";
        }
        try {
            String str = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
            sAppVersionName = str;
            if (str == null) {
                return "";
            }
            return str;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getBrand() {
        return BRAND;
    }

    public static int getCpuArchitecture() {
        int i3 = sCpuArch;
        if (-1 != i3) {
            return i3;
        }
        String str = Build.CPU_ABI;
        if (str != null && (str.contains(ResourceAttributes.HostArchValues.X86) || str.contains("X86"))) {
            sCpuArch = 1;
        } else if (str != null && (str.contains("mips") || str.contains("Mips"))) {
            sCpuArch = 2;
        } else {
            if (sCpuArchitecture == 0) {
                getCpuInfo();
            }
            if (!TextUtils.isEmpty(sCpuHardware) && sCpuHardware.contains("MSM8994")) {
                sCpuArch = 7;
                return 7;
            }
            if (!"XT882".equals(getDeviceModel()) && !"ME860".equals(getDeviceModel()) && !"MB860".equals(getDeviceModel()) && !"Lenovo P70".equals(getDeviceModel()) && !"Lenovo A60".equals(getDeviceModel()) && !"Lenovo A366t".equals(getDeviceModel())) {
                if (!TextUtils.isEmpty(sProcessorName) && sProcessorName.contains("ARMv6")) {
                    sCpuArch = 4;
                    return 4;
                }
                if (!TextUtils.isEmpty(sProcessorName) && sProcessorName.contains("AArch64")) {
                    sCpuArch = 7;
                    return 7;
                }
                if (sCpuArchitecture == 7 && !TextUtils.isEmpty(sFeature) && !sFeature.contains("neon")) {
                    sCpuArch = 4;
                    return 4;
                }
                int i16 = sCpuArchitecture;
                if (i16 != 64) {
                    switch (i16) {
                        case 5:
                            sCpuArch = 3;
                            break;
                        case 6:
                            sCpuArch = 4;
                            break;
                        case 7:
                            sCpuArch = 6;
                            break;
                        case 8:
                        case 9:
                        case 10:
                            break;
                        default:
                            sCpuArch = 0;
                            break;
                    }
                }
                sCpuArch = 7;
            } else {
                sCpuArch = 3;
                return 3;
            }
        }
        return sCpuArch;
    }

    public static int getCpuArchitectureFromVM() {
        int cpuArchitecture = getCpuArchitecture();
        if (!TVKMediaPlayerConfig.PlayerConfig.get_cpu_arch_from_vm) {
            return cpuArchitecture;
        }
        boolean is64Bit = VMCompat.is64Bit();
        TVKLogUtil.i(TAG, "getCpuArchitectureFromVM, is64Bit:" + is64Bit + ", cpu arch:" + cpuArchitecture);
        if (is64Bit) {
            return 7;
        }
        if (cpuArchitecture >= 7) {
            return 6;
        }
        return cpuArchitecture;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
    
        if (r0 > 7) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getCpuArchitectureName() {
        if (!TextUtils.isEmpty(sPackageABI)) {
            return sPackageABI;
        }
        int cpuArchitectureFromVM = getCpuArchitectureFromVM();
        String str = "arm64-v8a";
        switch (cpuArchitectureFromVM) {
            case 1:
                str = ResourceAttributes.HostArchValues.X86;
                break;
            case 2:
                str = "mips";
                break;
            case 3:
            case 4:
            case 5:
                str = "armeabi";
                break;
            case 6:
                str = "armeabi-v7a";
                break;
        }
        sPackageABI = str;
        return str;
    }

    public static String getCpuChipModel(Context context) {
        String str;
        try {
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16);
            str = "";
        }
        if (!TextUtils.isEmpty(sCpuChipModel)) {
            TVKLogUtil.i(TAG, "TVKLogoConfig chip=" + sCpuChipModel);
            return sCpuChipModel;
        }
        Class<?> loadClass = context.getClassLoader().loadClass(TPFromApkLibraryLoader.ANDROID_OS_SYSTEM_PROPERTIES_CLASS_NAME);
        str = (String) loadClass.getMethod("get", String.class).invoke(loadClass, "ro.board.platform");
        sCpuChipModel = str;
        return str;
    }

    public static String getCpuChipName() {
        if (TextUtils.isEmpty(sCpuChipName)) {
            sCpuChipName = getCpuChipNameInner();
        }
        return sCpuChipName;
    }

    private static String getCpuChipNameInner() {
        int i3;
        String systemProperty = getSystemProperty("ro.vendor.mediatek.platform", "");
        if (!TextUtils.isEmpty(systemProperty)) {
            return systemProperty;
        }
        String systemProperty2 = getSystemProperty("ro.mediatek.platform", "");
        if (!TextUtils.isEmpty(systemProperty2)) {
            return systemProperty2;
        }
        String systemProperty3 = getSystemProperty("ro.product.vendor.device", "");
        if (!TextUtils.isEmpty(systemProperty3) && systemProperty3.toLowerCase().contains("kirin")) {
            return systemProperty3;
        }
        String systemProperty4 = getSystemProperty(AVCoreSystemInfo.SOC_MODEL_KEY, "");
        if (!TextUtils.isEmpty(systemProperty4)) {
            return systemProperty4;
        }
        String cpuChipNameLegacy = getCpuChipNameLegacy();
        int i16 = sCpuHWProducer;
        if (i16 >= 0 && (i3 = sCpuHWProductIdx) >= 0) {
            return sCpuPerfList[i16][i3];
        }
        if (!TextUtils.isEmpty(cpuChipNameLegacy)) {
            if (cpuChipNameLegacy.lastIndexOf(" ") < 0) {
                return cpuChipNameLegacy.replaceAll("[\\s,.]", "");
            }
            return cpuChipNameLegacy.substring(cpuChipNameLegacy.lastIndexOf(" ")).trim();
        }
        return "Unknown";
    }

    private static String getCpuChipNameLegacy() {
        if (TextUtils.isEmpty(sCpuHardware)) {
            getCpuInfo();
        }
        return sCpuHardware;
    }

    private static int getCpuHWProducer(String str) {
        if (str.isEmpty()) {
            return -1;
        }
        if (!str.contains("Exynos") && !str.contains("SMDK") && !str.contains("S5L8900") && !str.contains("S5PC100")) {
            if (!str.contains("Kirin") && !str.contains("K3V")) {
                if (!str.contains("MSM") && !str.contains("APQ") && !str.contains("SM") && !str.contains("SDM") && !str.contains("QSD")) {
                    if (!str.contains("MT6") && !str.contains("MT8")) {
                        return -1;
                    }
                    return 1;
                }
                return 0;
            }
            return 2;
        }
        return 3;
    }

    public static int getCpuHWProductIndex(String str) {
        if (sCpuHWProducer < 0) {
            sCpuHWProducer = getCpuHWProducer(str);
        }
        int i3 = sCpuHWProducer;
        if (i3 >= 0 && sCpuHWProductIdx < 0) {
            String[] strArr = sCpuPerfList[i3];
            int i16 = -1;
            for (int i17 = 0; i17 < strArr.length; i17++) {
                if (str.contains(strArr[i17]) && (-1 == i16 || strArr[i17].length() > strArr[i16].length())) {
                    i16 = i17;
                }
            }
            sCpuHWProductIdx = i16;
        }
        return sCpuHWProductIdx;
    }

    public static void getCpuInfo() {
        BufferedReader bufferedReader;
        int indexOf;
        int indexOf2;
        InputStreamReader inputStreamReader = null;
        try {
            try {
                InputStreamReader inputStreamReader2 = new InputStreamReader(new FileInputStream("/proc/cpuinfo"), "UTF-8");
                try {
                    bufferedReader = new BufferedReader(inputStreamReader2);
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                inputStreamReader2.close();
                                bufferedReader.close();
                                return;
                            }
                            if (readLine.contains("aarch64") || readLine.contains("AArch64")) {
                                sCpuArchitecture = 64;
                            }
                            if (readLine.startsWith("Processor")) {
                                int indexOf3 = readLine.indexOf(58);
                                if (indexOf3 > 1) {
                                    String substring = readLine.substring(indexOf3 + 1, readLine.length());
                                    sProcessorName = substring;
                                    sProcessorName = substring.trim();
                                }
                            } else if (readLine.startsWith("CPU architecture")) {
                                if (sCpuArchitecture == 0 && (indexOf = readLine.indexOf(58)) > 1) {
                                    String trim = readLine.substring(indexOf + 1, readLine.length()).trim();
                                    if (trim.length() > 0 && trim.length() < 2) {
                                        sCpuArchitecture = (int) Long.parseLong(trim);
                                    } else if (trim.length() > 1) {
                                        sCpuArchitecture = (int) Long.parseLong(trim.substring(0, 1));
                                    }
                                }
                            } else if (readLine.startsWith("Features")) {
                                int indexOf4 = readLine.indexOf(58);
                                if (indexOf4 > 1) {
                                    sFeature = readLine.substring(indexOf4 + 1, readLine.length()).trim();
                                }
                            } else if (readLine.startsWith("Hardware") && (indexOf2 = readLine.indexOf(58)) > 1) {
                                sCpuHardware = readLine.substring(indexOf2 + 1, readLine.length()).trim();
                                TVKLogUtil.i(TAG, "hardward " + sCpuHardware);
                                getCpuHWProductIndex(sCpuHardware);
                            }
                        } catch (Throwable unused) {
                            inputStreamReader = inputStreamReader2;
                            try {
                                sCpuHardware = "Unknown";
                                sCpuArchitecture = 0;
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                    return;
                                }
                                return;
                            } catch (Throwable th5) {
                                if (inputStreamReader != null) {
                                    try {
                                        inputStreamReader.close();
                                    } catch (IOException e16) {
                                        TVKLogUtil.e(TAG, e16);
                                        throw th5;
                                    }
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                throw th5;
                            }
                        }
                    }
                } catch (Throwable unused2) {
                    bufferedReader = null;
                }
            } catch (Throwable unused3) {
                bufferedReader = null;
            }
        } catch (IOException e17) {
            TVKLogUtil.e(TAG, e17);
        }
    }

    public static long getCurrentAvailMem(Context context) {
        if (context == null) {
            return 0L;
        }
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (activityManager == null) {
                return 0L;
            }
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.availMem / 1048576;
        } catch (Throwable th5) {
            TVKLogUtil.e(TAG, th5);
            return 0L;
        }
    }

    public static long getCurrentCpuFreq() {
        InputStreamReader inputStreamReader;
        Throwable th5;
        BufferedReader bufferedReader;
        Exception e16;
        IOException e17;
        FileNotFoundException e18;
        String readLine;
        long j3 = sCurrentCpuFreq;
        if (j3 > 0) {
            return j3;
        }
        long j16 = 1024000;
        try {
            try {
                inputStreamReader = new InputStreamReader(new FileInputStream("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"), "UTF-8");
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                } catch (FileNotFoundException e19) {
                    bufferedReader = null;
                    e18 = e19;
                } catch (IOException e26) {
                    bufferedReader = null;
                    e17 = e26;
                } catch (Exception e27) {
                    bufferedReader = null;
                    e16 = e27;
                } catch (Throwable th6) {
                    bufferedReader = null;
                    th5 = th6;
                }
            } catch (FileNotFoundException e28) {
                inputStreamReader = null;
                e18 = e28;
                bufferedReader = null;
            } catch (IOException e29) {
                inputStreamReader = null;
                e17 = e29;
                bufferedReader = null;
            } catch (Exception e36) {
                inputStreamReader = null;
                e16 = e36;
                bufferedReader = null;
            } catch (Throwable th7) {
                inputStreamReader = null;
                th5 = th7;
                bufferedReader = null;
            }
            try {
                readLine = bufferedReader.readLine();
            } catch (FileNotFoundException e37) {
                e18 = e37;
                TVKLogUtil.e(TAG, e18);
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (Throwable th8) {
                        TVKLogUtil.e(TAG, th8);
                        return 0L;
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return j16;
            } catch (IOException e38) {
                e17 = e38;
                TVKLogUtil.e(TAG, e17);
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (Throwable th9) {
                        TVKLogUtil.e(TAG, th9);
                        return 0L;
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return j16;
            } catch (Exception e39) {
                e16 = e39;
                TVKLogUtil.e(TAG, e16);
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (Throwable th10) {
                        TVKLogUtil.e(TAG, th10);
                        return 0L;
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return j16;
            } catch (Throwable th11) {
                th5 = th11;
                TVKLogUtil.e(TAG, th5);
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (Throwable th12) {
                        TVKLogUtil.e(TAG, th12);
                        return 0L;
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return j16;
            }
            if (readLine == null) {
                inputStreamReader.close();
                bufferedReader.close();
                try {
                    inputStreamReader.close();
                    bufferedReader.close();
                    return 0L;
                } catch (Throwable th13) {
                    TVKLogUtil.e(TAG, th13);
                    return 0L;
                }
            }
            String trim = readLine.trim();
            if (trim.length() > 0) {
                j16 = Long.parseLong(trim);
            }
            sCurrentCpuFreq = j16;
            try {
                inputStreamReader.close();
                bufferedReader.close();
                return j16;
            } catch (Throwable th14) {
                TVKLogUtil.e(TAG, th14);
                return 0L;
            }
        } catch (Throwable th15) {
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (Throwable th16) {
                    TVKLogUtil.e(TAG, th16);
                    return 0L;
                }
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th15;
        }
    }

    public static float getDensity(Context context) {
        float f16 = sDensity;
        if (f16 != 0.0f) {
            return f16;
        }
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            sDensity = Math.round(displayMetrics.density * 100.0f) / 100.0f;
            sMaxValueOfWidthHeight = Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels);
        } catch (NullPointerException e16) {
            TVKLogUtil.e(TAG, e16);
        }
        return sDensity;
    }

    public static String getDeviceID() {
        return "";
    }

    public static String getDeviceIMEI() {
        return "";
    }

    public static String getDeviceIMSI() {
        return "";
    }

    public static String getDeviceMacAddr() {
        return "";
    }

    public static String getDeviceModel() {
        if (TextUtils.isEmpty(sDeviceModel)) {
            sDeviceModel = DeviceInfoMonitor.getModel();
        }
        return sDeviceModel;
    }

    public static String getManufacturer() {
        return MANUFACTURER;
    }

    public static int getMarketId(Context context) {
        BufferedReader bufferedReader;
        Throwable th5;
        InputStream inputStream;
        if (sReadMarketId) {
            return sMarketId;
        }
        int i3 = -1;
        if (context == null) {
            return -1;
        }
        try {
            try {
                inputStream = context.getApplicationContext().getAssets().open("channel.ini");
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                } catch (Throwable th6) {
                    bufferedReader = null;
                    th5 = th6;
                }
            } catch (Throwable th7) {
                bufferedReader = null;
                th5 = th7;
                inputStream = null;
            }
        } catch (Throwable th8) {
            TVKLogUtil.e(TAG, th8);
        }
        try {
            String readLine = bufferedReader.readLine();
            if (!TextUtils.isEmpty(readLine) && readLine.contains("CHANNEL=")) {
                String substring = readLine.substring(readLine.indexOf(ContainerUtils.KEY_VALUE_DELIMITER) + 1);
                if (!TextUtils.isEmpty(substring)) {
                    i3 = Integer.parseInt(substring.trim());
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            bufferedReader.close();
        } catch (Throwable th9) {
            th5 = th9;
            try {
                TVKLogUtil.e(TAG, th5);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                sMarketId = i3;
                sReadMarketId = true;
                return i3;
            } catch (Throwable th10) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th11) {
                        TVKLogUtil.e(TAG, th11);
                        throw th10;
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th10;
            }
        }
        sMarketId = i3;
        sReadMarketId = true;
        return i3;
    }

    public static long getMaxCpuFreq() {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        String readLine;
        long j3 = sMaxCpuFreq;
        if (-1 != j3) {
            return j3;
        }
        InputStreamReader inputStreamReader2 = null;
        long j16 = 0;
        try {
            try {
                inputStreamReader = new InputStreamReader(new FileInputStream("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"), "UTF-8");
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        readLine = bufferedReader.readLine();
                    } catch (IOException unused) {
                        inputStreamReader2 = inputStreamReader;
                        if (inputStreamReader2 != null) {
                            inputStreamReader2.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        sMaxCpuFreq = j16;
                        TVKLogUtil.i(TAG, "MaxCpuFreq " + sMaxCpuFreq);
                        return j16;
                    } catch (Throwable unused2) {
                        inputStreamReader2 = inputStreamReader;
                        if (inputStreamReader2 != null) {
                            inputStreamReader2.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        sMaxCpuFreq = j16;
                        TVKLogUtil.i(TAG, "MaxCpuFreq " + sMaxCpuFreq);
                        return j16;
                    }
                } catch (IOException unused3) {
                    bufferedReader = null;
                } catch (Throwable unused4) {
                    bufferedReader = null;
                }
            } catch (IOException unused5) {
                bufferedReader = null;
            } catch (Throwable unused6) {
                bufferedReader = null;
            }
        } catch (IOException e16) {
            TVKLogUtil.e(TAG, e16);
        }
        if (readLine == null) {
            inputStreamReader.close();
            bufferedReader.close();
            try {
                inputStreamReader.close();
                bufferedReader.close();
            } catch (IOException e17) {
                TVKLogUtil.e(TAG, e17);
            }
            return 0L;
        }
        String trim = readLine.trim();
        if (trim.length() > 0) {
            j16 = Long.parseLong(trim);
        }
        inputStreamReader.close();
        bufferedReader.close();
        sMaxCpuFreq = j16;
        TVKLogUtil.i(TAG, "MaxCpuFreq " + sMaxCpuFreq);
        return j16;
    }

    public static int getMaxValueOfScreenWH(Context context) {
        int i3 = sMaxValueOfWidthHeight;
        if (i3 != 0) {
            return i3;
        }
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            sDensity = Math.round(displayMetrics.density * 100.0f) / 100.0f;
            sMaxValueOfWidthHeight = Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels);
        } catch (NullPointerException e16) {
            TVKLogUtil.e(TAG, e16);
        }
        return sMaxValueOfWidthHeight;
    }

    public static int getNumCores() {
        int i3 = sNumOfCores;
        if (-1 != i3) {
            return i3;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]", file.getName());
                }
            });
            if (listFiles == null) {
                sNumOfCores = 1;
                return 1;
            }
            sNumOfCores = listFiles.length;
            TVKLogUtil.i(TAG, "core num " + sNumOfCores);
            return sNumOfCores;
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16);
            sNumOfCores = 1;
            return 1;
        }
    }

    public static int getOpenGLSupportVersion(Context context) {
        if (sOpenGLVersion == 0) {
            try {
                ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                if (activityManager == null) {
                    return sOpenGLVersion;
                }
                sOpenGLVersion = activityManager.getDeviceConfigurationInfo().reqGlEsVersion;
            } catch (Throwable th5) {
                TVKLogUtil.e(TAG, th5);
            }
        }
        return sOpenGLVersion;
    }

    public static String getOsVersion() {
        return OS_VERSION_RELEASE;
    }

    public static String getPackageABILegacy() {
        String str;
        if (!TextUtils.isEmpty(sPackageABIFromProcess)) {
            return sPackageABIFromProcess;
        }
        if (Process.is64Bit()) {
            String[] strArr = Build.SUPPORTED_64_BIT_ABIS;
            if (strArr.length > 0) {
                str = strArr[0];
            } else {
                str = Build.SUPPORTED_ABIS[0];
            }
        } else {
            String[] strArr2 = Build.SUPPORTED_32_BIT_ABIS;
            if (strArr2.length > 0) {
                str = strArr2[0];
            } else {
                str = Build.SUPPORTED_ABIS[0];
            }
        }
        sPackageABIFromProcess = str;
        return str;
    }

    public static String getPackageName() {
        if (!TextUtils.isEmpty(sPackageName)) {
            return sPackageName;
        }
        Context applicationContext = TVKCommParams.getApplicationContext();
        if (applicationContext != null) {
            sPackageName = applicationContext.getPackageName();
        }
        return sPackageName;
    }

    public static int getPlayerLevel() {
        int i3 = sDeviceLevel;
        if (-1 != i3) {
            return i3;
        }
        sDeviceLevel = 11;
        if (getCpuArchitecture() < 6) {
            sDeviceLevel = 1;
        }
        if (getNumCores() == 1 && getMaxCpuFreq() / 1000 <= 1000) {
            sDeviceLevel = 6;
        }
        if ((getNumCores() == 1 && getMaxCpuFreq() / 1000 > 1000) || (getNumCores() == 2 && getMaxCpuFreq() / 1000 < 1400)) {
            sDeviceLevel = 11;
        }
        if (getNumCores() == 2 && getMaxCpuFreq() / 1000 >= 1400) {
            sDeviceLevel = 16;
        }
        if (getNumCores() >= 4) {
            sDeviceLevel = 21;
        }
        return sDeviceLevel;
    }

    public static int getScreenHeight(Context context) {
        if (context == null) {
            return 0;
        }
        int i3 = sScreenHeight;
        if (i3 != 0) {
            return i3;
        }
        try {
            sScreenHeight = context.getResources().getDisplayMetrics().heightPixels;
        } catch (Throwable unused) {
            sScreenHeight = 0;
        }
        return sScreenHeight;
    }

    public static int getScreenWidth(Context context) {
        if (context == null) {
            return 0;
        }
        int i3 = sScreenWidth;
        if (i3 != 0) {
            return i3;
        }
        try {
            sScreenWidth = context.getResources().getDisplayMetrics().widthPixels;
        } catch (Throwable unused) {
            sScreenWidth = 0;
        }
        return sScreenWidth;
    }

    public static int getSystemCpuUsage(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            float f16 = -1.0f;
            try {
                String[] split = str.trim().split("\\s+");
                long systemIdleTime = getSystemIdleTime(split);
                long systemUptime = getSystemUptime(split);
                String[] split2 = str2.trim().split("\\s+");
                long systemIdleTime2 = getSystemIdleTime(split2);
                long systemUptime2 = getSystemUptime(split2);
                if (systemIdleTime >= 0 && systemUptime >= 0 && systemIdleTime2 >= 0 && systemUptime2 >= 0) {
                    long j3 = systemIdleTime2 + systemUptime2;
                    long j16 = systemIdleTime + systemUptime;
                    if (j3 > j16 && systemUptime2 >= systemUptime) {
                        f16 = (((float) (systemUptime2 - systemUptime)) / ((float) (j3 - j16))) * 100.0f;
                    }
                }
            } catch (Throwable th5) {
                TVKLogUtil.e(TAG, th5);
            }
            return (int) f16;
        }
        return -1;
    }

    public static long getSystemIdleTime(String[] strArr) {
        try {
            return Long.parseLong(strArr[4]);
        } catch (NumberFormatException e16) {
            TVKLogUtil.e(TAG, e16);
            return -1L;
        }
    }

    public static String getSystemProperty(String str, String str2) {
        try {
            String str3 = (String) SystemProperties.class.getDeclaredMethod("get", String.class).invoke(SystemProperties.class, str);
            if (str3 != null) {
                return str3;
            }
            return str2;
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, "get system property " + str + " failed:" + e16.getMessage());
            return str2;
        }
    }

    public static long getSystemUptime(String[] strArr) {
        long j3 = 0;
        for (int i3 = 1; i3 < strArr.length; i3++) {
            if (4 != i3) {
                try {
                    j3 += Long.parseLong(strArr[i3]);
                } catch (NumberFormatException unused) {
                    return -1L;
                }
            }
        }
        return j3;
    }

    @TargetApi(16)
    public static long getTotalMem(Context context) {
        if (context == null) {
            return 0L;
        }
        long j3 = sTotalMem;
        if (j3 > 0) {
            return j3;
        }
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getMemoryInfo(memoryInfo);
            long j16 = memoryInfo.totalMem / 1048576;
            sTotalMem = j16;
            return j16;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    private static String getWlanName() {
        try {
            if (sGetWlanMethod == null) {
                sGetWlanMethod = SystemProperties.class.getMethod("get", String.class, String.class);
            }
            return (String) sGetWlanMethod.invoke(null, "wifi.interface", "wlan0");
        } catch (Throwable th5) {
            TVKLogUtil.e(TAG, th5);
            return "wlan0";
        }
    }

    private static boolean hasMarshmallow() {
        return true;
    }

    public static boolean isCryptoSchemeSupported(UUID uuid) {
        return MediaDrm.isCryptoSchemeSupported(uuid);
    }

    public static boolean isExternalStorageMounted() {
        int i3;
        int i16 = sExternalStorageMounted;
        if (i16 != -1) {
            if (i16 != 1) {
                return false;
            }
            return true;
        }
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            sExternalStorageMounted = i3;
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16);
        }
        if (sExternalStorageMounted != 1) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0038 -> B:10:0x004b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String readStringFromFile(File file) throws FileNotFoundException {
        ?? r26;
        String str = null;
        try {
            try {
                r26 = new BufferedReader(new FileReader(file));
                try {
                    if (file.length() <= TTL.MAX_VALUE) {
                        char[] cArr = new char[(int) file.length()];
                        if (r26.read(cArr, 0, (int) file.length()) > 0) {
                            str = new String(cArr);
                        }
                    }
                    r26.close();
                } catch (FileNotFoundException e16) {
                    e = e16;
                    str = r26;
                    try {
                        throw e;
                    } catch (Throwable th5) {
                        th = th5;
                        r26 = str;
                        if (r26 != 0) {
                            try {
                                r26.close();
                            } catch (Throwable th6) {
                                TVKLogUtil.e(TAG, th6);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    try {
                        TVKLogUtil.e(TAG, th);
                        if (r26 != 0) {
                            r26.close();
                        }
                        return str;
                    } catch (Throwable th8) {
                        th = th8;
                        if (r26 != 0) {
                        }
                        throw th;
                    }
                }
            } catch (FileNotFoundException e17) {
                e = e17;
            } catch (Throwable th9) {
                th = th9;
                r26 = 0;
            }
        } catch (Throwable th10) {
            TVKLogUtil.e(TAG, th10);
        }
        return str;
    }

    public static String readSystemStat() {
        RandomAccessFile randomAccessFile;
        String str = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile("/proc/stat", "r");
            } catch (Throwable th5) {
                th = th5;
                randomAccessFile = null;
            }
            try {
                str = randomAccessFile.readLine();
                randomAccessFile.close();
            } catch (Throwable th6) {
                th = th6;
                try {
                    TVKLogUtil.e(TAG, th);
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    return str;
                } catch (Throwable th7) {
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable th8) {
                            TVKLogUtil.e(TAG, th8);
                        }
                    }
                    throw th7;
                }
            }
        } catch (Throwable th9) {
            TVKLogUtil.e(TAG, th9);
        }
        return str;
    }

    public static void setDeviceModel(String str) {
        sDeviceModel = str;
    }

    private static void writeStringToFile(String str, String str2) {
        FileWriter fileWriter = null;
        try {
            File file = new File(str);
            if (!file.exists() && file.createNewFile()) {
                return;
            }
            FileWriter fileWriter2 = new FileWriter(file, false);
            try {
                fileWriter2.write(str2);
                fileWriter2.flush();
                fileWriter2.close();
            } catch (Throwable unused) {
                fileWriter = fileWriter2;
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (IOException e16) {
                        TVKLogUtil.e(TAG, e16);
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }
}
