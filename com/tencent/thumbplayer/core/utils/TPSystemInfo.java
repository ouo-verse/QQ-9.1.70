package com.tencent.thumbplayer.core.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.audiofx.AudioEffect;
import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import cooperation.qzone.util.WiFiDash;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes26.dex */
public class TPSystemInfo {
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
    public static final int CPU_HW_SAMSUNG = 3;
    private static final String HAISI_CPU_NAME_SYSTEM_PROPERTY = "ro.product.vendor.device";
    private static final String MTK_CPU_NAME_SYSTEM_PROPERTY = "ro.vendor.mediatek.platform";
    private static final String MTK_CPU_NAME_SYSTEM_PROPERTY2 = "ro.mediatek.platform";
    public static final int SDK_INT;
    private static final String SOC_MODEL_SYSTEM_PROPERTY = "ro.soc.model";
    private static String TAG = "TPSystemInfo";
    private static long sAppInstallTime;
    private static int sCpuArch;
    private static final LinkedHashMap<String, String> sCpuNameSystemPropertysMap;
    private static long sCurrentCpuFreq;
    private static long sMaxCpuFreq;
    private static int sNumOfCores;
    private static int sOpenGLVersion;
    public static int sScreenHeight;
    public static int sScreenWidth;
    private static final String DEVICE_MANUFACTURER = Build.MANUFACTURER;
    private static final String DEVICE_OS_VERSION = Build.VERSION.RELEASE;
    private static final String PRODUCT_DEVICE = Build.DEVICE;
    private static final String PRODUCT_BOARD = Build.BOARD;
    private static String sProcessorName = WiFiDash.NOT_AVALIBLE;
    private static String sFeature = "";
    private static String sCpuHardware = "";
    private static String sDeviceName = "";
    private static int sCpuArchitecture = 0;
    private static int sCpuHWProducter = -1;
    private static int sCpuHWProductIdx = -1;
    private static String sAppVersionName = "";
    private static int sAudioBestSampleRate = 0;
    private static int sAudioBestFramesPerBust = 0;
    private static final String[][] sCpuPerfList = {new String[]{"MSM7227", "MSM7627", "MSM7227T", "MSM7627T", "MSM7227A", "MSM7627A", "QSD8250", "QSD8650", "MSM7230", "MSM7630", "APQ8055", "MSM8255", "MSM8655", "MSM8255T", "MSM8655T", "MSM8225", "MSM8625", "MSM8260", "MSM8660", "MSM8x25Q", "MSM8x26", "MSM8x10", "MSM8x12", "MSM8x30", "MSM8260A", "MSM8660A", "MSM8960", "MSM8208", "MSM8916", "MSM8960T", "MSM8909", "MSM8916v2", "MSM8936", "MSM8909v2", "MSM8917", "APQ8064T", "MSM8920", "MSM8939", "MSM8937", "MSM8939v2", "MSM8940", "MSM8952", "SDM439", "SDM450", "SDA450", "MSM8953", "MSM8953Pro", "MSM8x74AA", "MSM8x74AB", "MSM8x74AC", "APQ8084", "MSM8956", "MSM8976", "MSM8976SG", "MSM8976PRO", "SM4250", "SM4250-AA", "MSM8992", "MSM8976Pro", "SDM630", "SDM632", "SDM636", "SDM660", "SDA660", "SDM665", "SM6115", "SM6125", "MSM8994", "SDM670", "SDM675", "SM6150", "SM6225", "SM6350", "SDM710", "SDM712", "SM4350", "MSM8996", "SM7125", "MSM8996Pro", "SM7150", "SDM730", "SM7150AA", "SDM730G", "SM7150AB", "SM7150-AB", "MSM8998", "SM6375", "SM7225", "SDM750G", "SM4375", "SM7250", "SDM765g", "SM7250-AA", "SM7250-AB", "SM4450", "SDM768G", "SM7250-AC", "SM6450", "SDM845", "SM7325", "SDM850", "SM7350", "SM7435", "SM7435-AB", "SM8150", "SDM778G", "SM7350-AE", "SDM855plus", "SM7350-AB", "SM8150-AC", "SM7325-AF", "SM8150-AD", "SM7450", "SM7450-AB", "SM8250", "SM8250-AB", "SM8250-AC", "SM8350", "SM7550", "SM8350-AC", "SM7475", "SM8450", "SM8475", "SM8550", "SM8550-AC", "SM8550-AB", "SM8650"}, new String[]{"MT6516", "MT6513", "MT6573", "MT6515M", "MT6515", "MT6575", "MT6572", "MT6577", "MT6580", "MT6589", "MT6582", "MT6588", "MT6591", "MT6592", "MT6595", "MT6732", "MT6735", "MT6737M", "MT6737T", "MT6739", "MT6750", "MT6752", "MT6753", "MT6755", "MT6755T", "MT8173", "MT6757", "MT6795", "MT6761", "MT6762", "MT6763", "MT6763T", "MT6763V", "MT6757CD", "MT6758", "MT6762G", "MT6762R", "heliog25", "MT6765", "MT6797", "MT6797D", "MT6797T", "MT6797X", "MT6797M", "heliop40", "MT8786", "MT6771", "MT6799", "MT6833", "MT6833V", "MT6873", "MT6875", "MT6877", "MT6877T", "dimensity920", "MT6855", "dimensity930", "MT6768", "MT6771V", "MT6771T", "heliop70", "MT6769V", "MT6769V/CU", "heliog80", "MT6769T", "MT6769Z", "heliog85", "MT6779", "MT6779V", "MT6785", "MT6785T", "MT8781", "MT6789", "heliog99", "MT6853T", "MT6853V", "MT6853", "MT6833V", "MT6833P", "MT6883", "MT6885", "MT6885Z", "MT6889", "MT6889Z", "dimensity1080", "MT6891", "MT6891Z", "MT6893", "dimensity1200", "MT6893Z", "MT6886", "MT6895", "MT6895Z", "MT6895T", "MT6896", "dimensity8100", "MT6897Z", "dimensity8200", "MT6983", "dimensity9000+", "dimensity9200", "MT6985", "MT6989"}, new String[]{"K3V2", "K3V2E", "K3V2+", "Kirin910", "Kirin920", "Kirin925", "Kirin928", "Kirin620", "Kirin650", "Kirin655", "Kirin658", "Kirin659", "Kirin930", "Kirin935", "Kirin950", "Kirin955", "Kirin710", "Kirin710F", "Kirin710A", "Kirin960", "Kirin970", "Kirin810", "Kirin980", "Kirin820", "Kirin820E", "Kirin8205G", "Kirin985", "Kirin9855G", "Kirin8000", "Kirin990", "Kirin990E", "Kirin9905G", "Kirin9000E", "Kirin9000L", "Kirin9000", "Kirin9000S", "Kirin9000SL"}, new String[]{"S5L8900", "S5PC100", "Exynos3110", "Exynos3475", "Exynos4210", "Exynos4212", "SMDK4x12", "Exynos4412", "Exynos5250", "Exynos5260", "Exynos5410", "Exynos5420", "Exynos5422", "Exynos5430", "Exynos5800", "Exynos5433", "Exynos7580", "Exynos7870", "Exynos7870", "Exynos7420", "Exynos8890", "Exynos890", "Exynos9611", "Exynos8895", "Exynos880", "Exynos980", "S5E8825", "Exynos9810", "Exynos9815", "Exynos9820", "S5E8835", "Exynos9825", "Exynos990", "Exynos1080", "E1080", "S5E9815", "Exynos2100", "Exynos2200"}};

    static {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        sCpuNameSystemPropertysMap = linkedHashMap;
        linkedHashMap.put(MTK_CPU_NAME_SYSTEM_PROPERTY, "");
        linkedHashMap.put(MTK_CPU_NAME_SYSTEM_PROPERTY2, "");
        linkedHashMap.put(HAISI_CPU_NAME_SYSTEM_PROPERTY, "kirin");
        linkedHashMap.put("ro.soc.model", "");
        sMaxCpuFreq = -1L;
        sCurrentCpuFreq = -1L;
        sNumOfCores = -1;
        sCpuArch = -1;
        sOpenGLVersion = 0;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 == 25) {
            String str = Build.VERSION.CODENAME;
            if (!TextUtils.isEmpty(str) && str.charAt(0) == 'O') {
                i3 = 26;
            }
        }
        SDK_INT = i3;
    }

    public static int getApiLevel() {
        return Build.VERSION.SDK_INT;
    }

    @NonNull
    public static synchronized String getAppVersionName(@NonNull Context context) {
        String str;
        synchronized (TPSystemInfo.class) {
            if (!TextUtils.isEmpty(sAppVersionName)) {
                return sAppVersionName;
            }
            try {
                PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0);
                if (TextUtils.isEmpty(packageInfo.versionName)) {
                    str = "";
                } else {
                    str = packageInfo.versionName;
                }
                sAppVersionName = str;
            } catch (PackageManager.NameNotFoundException unused) {
                sAppVersionName = "";
            }
            return sAppVersionName;
        }
    }

    public static int getBestAudioFramesPerBust() {
        return sAudioBestFramesPerBust;
    }

    public static int getBestAudioSampleRate() {
        return sAudioBestSampleRate;
    }

    public static int getCpuArchFromId(int i3) {
        if (i3 != 64) {
            switch (i3) {
                case 5:
                    return 3;
                case 6:
                    return 4;
                case 7:
                    return 6;
                case 8:
                case 9:
                case 10:
                    break;
                default:
                    return 0;
            }
        }
        return 7;
    }

    public static int getCpuArchitecture() {
        int i3 = sCpuArch;
        if (-1 != i3) {
            return i3;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getCpuArchitecture Build.CPU_ABI: ");
        String str = Build.CPU_ABI;
        sb5.append(str);
        TPNativeLog.printLog(2, sb5.toString());
        if (str.contains("arm64-v8a")) {
            sCpuArch = 7;
            return 7;
        }
        if (str != null && (str.contains(ResourceAttributes.HostArchValues.X86) || str.contains("X86"))) {
            sCpuArch = 1;
        } else if (str != null && (str.contains("mips") || str.contains("Mips"))) {
            sCpuArch = 2;
        } else {
            if (sCpuArchitecture == 0) {
                getCpuInfo();
            }
            TPNativeLog.printLog(2, "getCpuArchitecture mCpuArchitecture:" + sCpuArchitecture);
            if (!TextUtils.isEmpty(sCpuHardware) && sCpuHardware.contains("MSM8994")) {
                sCpuArch = 7;
                return 7;
            }
            if (isARMV5Whitelist()) {
                sCpuArch = 3;
                return 3;
            }
            if (!TextUtils.isEmpty(sProcessorName) && sProcessorName.contains("ARMv6")) {
                sCpuArch = 4;
                return 4;
            }
            if (!TextUtils.isEmpty(sProcessorName) && sProcessorName.contains("AArch64")) {
                sCpuArch = 7;
                return 7;
            }
            if (sCpuArchitecture == 7 && !TextUtils.isEmpty(sFeature) && !sFeature.contains("neon") && !sFeature.contains("asimd")) {
                sCpuArch = 4;
                return 4;
            }
            sCpuArch = getCpuArchFromId(sCpuArchitecture);
        }
        return sCpuArch;
    }

    private static int getCpuHWProducer(String str) {
        if (str.isEmpty()) {
            return -1;
        }
        if (!str.contains("Exynos") && !str.contains("SMDK") && !str.contains("E1080") && !str.contains("S5E") && !str.contains("S5L8900") && !str.contains("S5PC100")) {
            if (!str.contains("Kirin") && !str.contains("K3V")) {
                if (!str.contains("MSM") && !str.contains("APQ") && !str.contains("QSD") && !str.contains("SDM") && !str.contains("SDA") && !str.contains("SM")) {
                    if (!str.contains("MT6") && !str.contains("MT8") && !str.contains("dimensity") && !str.contains("heliog")) {
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
        if (sCpuHWProducter < 0) {
            sCpuHWProducter = getCpuHWProducer(str);
        }
        int i3 = sCpuHWProducter;
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

    public static int getCpuHWProducter(String str) {
        if (sCpuHWProducter < 0) {
            sCpuHWProducter = getCpuHWProducer(str);
        }
        return sCpuHWProducter;
    }

    public static String getCpuHarewareName() {
        if (TextUtils.isEmpty(sCpuHardware)) {
            queryCpuChipName();
        }
        return sCpuHardware;
    }

    public static void getCpuInfo() {
        BufferedReader bufferedReader;
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
                            parseCpuInfoLine(readLine);
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
                                        TPNativeLog.printLog(0, e16.getMessage());
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
            TPNativeLog.printLog(0, e17.getMessage());
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
                try {
                    inputStreamReader = new InputStreamReader(new FileInputStream("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"), "UTF-8");
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                        try {
                            readLine = bufferedReader.readLine();
                        } catch (FileNotFoundException e19) {
                            e18 = e19;
                            TPNativeLog.printLog(0, e18.getMessage());
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return j16;
                        } catch (IOException e26) {
                            e17 = e26;
                            TPNativeLog.printLog(0, e17.getMessage());
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return j16;
                        } catch (Exception e27) {
                            e16 = e27;
                            TPNativeLog.printLog(0, e16.getMessage());
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return j16;
                        } catch (Throwable th6) {
                            th5 = th6;
                            TPNativeLog.printLog(0, th5.getMessage());
                            return j16;
                        }
                    } catch (FileNotFoundException e28) {
                        bufferedReader = null;
                        e18 = e28;
                    } catch (IOException e29) {
                        bufferedReader = null;
                        e17 = e29;
                    } catch (Exception e36) {
                        bufferedReader = null;
                        e16 = e36;
                    } catch (Throwable th7) {
                        bufferedReader = null;
                        th5 = th7;
                    }
                } catch (FileNotFoundException e37) {
                    inputStreamReader = null;
                    e18 = e37;
                    bufferedReader = null;
                } catch (IOException e38) {
                    inputStreamReader = null;
                    e17 = e38;
                    bufferedReader = null;
                } catch (Exception e39) {
                    inputStreamReader = null;
                    e16 = e39;
                    bufferedReader = null;
                } catch (Throwable th8) {
                    inputStreamReader = null;
                    th5 = th8;
                    bufferedReader = null;
                }
                if (readLine == null) {
                    inputStreamReader.close();
                    bufferedReader.close();
                    inputStreamReader.close();
                    bufferedReader.close();
                    return 0L;
                }
                String trim = readLine.trim();
                if (trim.length() > 0) {
                    j16 = Long.parseLong(trim);
                }
                sCurrentCpuFreq = j16;
                inputStreamReader.close();
                bufferedReader.close();
                return j16;
            } finally {
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
        } catch (Throwable th9) {
            TPNativeLog.printLog(0, th9.getMessage());
            return 0L;
        }
    }

    public static String getDeviceManufacturer() {
        return DEVICE_MANUFACTURER;
    }

    public static synchronized String getDeviceName() {
        String str;
        synchronized (TPSystemInfo.class) {
            if (TextUtils.isEmpty(sDeviceName)) {
                sDeviceName = DeviceInfoMonitor.getModel();
            }
            str = sDeviceName;
        }
        return str;
    }

    public static String getHarmonyVersion() {
        if (isHarmonyOS()) {
            return getSystemProp("hw_sc.build.platform.version", "");
        }
        return null;
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
                        TPNativeLog.printLog(2, "MaxCpuFreq " + sMaxCpuFreq);
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
                        TPNativeLog.printLog(2, "MaxCpuFreq " + sMaxCpuFreq);
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
            TPNativeLog.printLog(0, e16.getMessage());
        }
        if (readLine == null) {
            inputStreamReader.close();
            bufferedReader.close();
            try {
                inputStreamReader.close();
                bufferedReader.close();
            } catch (IOException e17) {
                TPNativeLog.printLog(0, e17.getMessage());
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
        TPNativeLog.printLog(2, "MaxCpuFreq " + sMaxCpuFreq);
        return j16;
    }

    public static int getNumCores() {
        int i3 = sNumOfCores;
        if (-1 != i3) {
            return i3;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.tencent.thumbplayer.core.utils.TPSystemInfo.1CpuFilter
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
            TPNativeLog.printLog(2, "core num " + sNumOfCores);
            return sNumOfCores;
        } catch (Exception e16) {
            TPNativeLog.printLog(0, e16.getMessage());
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
                TPNativeLog.printLog(0, th5.getMessage());
            }
        }
        return sOpenGLVersion;
    }

    public static String getOsVersion() {
        return DEVICE_OS_VERSION;
    }

    public static String getProductBoard() {
        return PRODUCT_BOARD;
    }

    public static String getProductDevice() {
        return PRODUCT_DEVICE;
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
                TPNativeLog.printLog(0, th5.getMessage());
            }
            return (int) f16;
        }
        return -1;
    }

    public static long getSystemIdleTime(String[] strArr) {
        try {
            return Long.parseLong(strArr[4]);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return -1L;
        }
    }

    public static String getSystemProp(String str, String str2) {
        try {
            String str3 = (String) SystemProperties.class.getDeclaredMethod("get", String.class).invoke(SystemProperties.class, str);
            if (str3 != null) {
                return str3;
            }
            return str2;
        } catch (Exception e16) {
            TPNativeLog.printLog(0, TAG, "get system property " + str + " failed:" + e16.getMessage());
            return str2;
        }
    }

    public static long getSystemUptime(String[] strArr) {
        long j3 = 0;
        for (int i3 = 1; i3 < strArr.length; i3++) {
            if (4 != i3) {
                try {
                    j3 += Long.parseLong(strArr[i3]);
                } catch (Throwable unused) {
                    return -1L;
                }
            }
        }
        return j3;
    }

    private static boolean hasMarshmallow() {
        return true;
    }

    public static synchronized void initAudioBestSettings(Context context) {
        synchronized (TPSystemInfo.class) {
            if (context != null) {
                if (sAudioBestSampleRate <= 0) {
                    AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                    if (audioManager == null) {
                        TPNativeLog.printLog(1, "getSystemService AUDIO_SERVICE failed");
                        return;
                    }
                    String property = audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
                    String property2 = audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
                    try {
                        sAudioBestSampleRate = Integer.parseInt(property);
                        sAudioBestFramesPerBust = Integer.parseInt(property2);
                    } catch (NumberFormatException e16) {
                        TPNativeLog.printLog(0, e16.getMessage());
                    }
                }
            }
        }
    }

    public static boolean isARMV5Whitelist() {
        if (!getDeviceName().equals("XT882") && !getDeviceName().equals("ME860") && !getDeviceName().equals("MB860") && !getDeviceName().equals("Lenovo P70") && !getDeviceName().equals("Lenovo A60") && !getDeviceName().equals("Lenovo A366t")) {
            return false;
        }
        return true;
    }

    public static boolean isCurrentDeviceInList(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            String deviceName = getDeviceName();
            for (String str : strArr) {
                if (str.equals(deviceName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCurrentManufacturerInList(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            String deviceManufacturer = getDeviceManufacturer();
            for (String str : strArr) {
                if (str.equalsIgnoreCase(deviceManufacturer)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isHarmonyOS() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            if (!cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]).toString().equalsIgnoreCase("Harmony")) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static void parseCpuInfoLine(String str) {
        int indexOf;
        int indexOf2;
        if (str.contains("aarch64") || str.contains("AArch64")) {
            sCpuArchitecture = 64;
        }
        if (str.startsWith("Processor")) {
            int indexOf3 = str.indexOf(58);
            if (indexOf3 > 1) {
                String substring = str.substring(indexOf3 + 1, str.length());
                sProcessorName = substring;
                sProcessorName = substring.trim();
                return;
            }
            return;
        }
        if (str.startsWith("CPU architecture")) {
            if (sCpuArchitecture == 0 && (indexOf2 = str.indexOf(58)) > 1) {
                String trim = str.substring(indexOf2 + 1, str.length()).trim();
                if (trim.length() > 0 && trim.length() < 2) {
                    sCpuArchitecture = (int) Long.parseLong(trim);
                    return;
                } else {
                    if (trim.length() > 1) {
                        sCpuArchitecture = (int) Long.parseLong(trim.substring(0, 1));
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (str.startsWith("Features")) {
            int indexOf4 = str.indexOf(58);
            if (indexOf4 > 1) {
                sFeature = str.substring(indexOf4 + 1, str.length()).trim();
                return;
            }
            return;
        }
        if (str.startsWith("Hardware") && (indexOf = str.indexOf(58)) > 1) {
            sCpuHardware = str.substring(indexOf + 1, str.length()).trim().replace(" ", "");
            TPNativeLog.printLog(2, "hardware " + sCpuHardware);
            getCpuHWProductIndex(sCpuHardware);
        }
    }

    public static void queryCpuChipName() {
        for (Map.Entry<String, String> entry : sCpuNameSystemPropertysMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            String systemProp = getSystemProp(key, "");
            if (!systemProp.isEmpty() && (value.isEmpty() || systemProp.toLowerCase().contains(value))) {
                sCpuHardware = systemProp;
                return;
            }
        }
        getCpuInfo();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0035 -> B:9:0x0048). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String readStringFromFile(File file) throws FileNotFoundException {
        ?? r16;
        String str = null;
        try {
            try {
                r16 = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e16) {
                e = e16;
            } catch (Throwable th5) {
                th = th5;
                r16 = 0;
            }
            try {
                if (file.length() <= TTL.MAX_VALUE) {
                    char[] cArr = new char[(int) file.length()];
                    if (r16.read(cArr, 0, (int) file.length()) > 0) {
                        str = new String(cArr);
                    }
                }
                r16.close();
            } catch (FileNotFoundException e17) {
                e = e17;
                str = r16;
                try {
                    throw e;
                } catch (Throwable th6) {
                    th = th6;
                    r16 = str;
                    if (r16 != 0) {
                    }
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                try {
                    th.printStackTrace();
                    if (r16 != 0) {
                        r16.close();
                    }
                    return str;
                } catch (Throwable th8) {
                    th = th8;
                    if (r16 != 0) {
                        try {
                            r16.close();
                        } catch (Throwable th9) {
                            th9.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th10) {
            th10.printStackTrace();
        }
        return str;
    }

    public static String readSystemStat() {
        RandomAccessFile randomAccessFile;
        String str = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile("/proc/stat", "r");
                try {
                    str = randomAccessFile.readLine();
                    randomAccessFile.close();
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        th.printStackTrace();
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        return str;
                    } catch (Throwable th6) {
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Throwable th7) {
                                TPNativeLog.printLog(0, th7.getMessage());
                            }
                        }
                        throw th6;
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                randomAccessFile = null;
            }
        } catch (Throwable th9) {
            TPNativeLog.printLog(0, th9.getMessage());
        }
        return str;
    }

    public static synchronized void setDeviceName(String str) {
        synchronized (TPSystemInfo.class) {
            sDeviceName = str;
        }
    }

    public static boolean supportInDeviceDolbyAudioEffect() {
        boolean z16;
        try {
            z16 = false;
            for (AudioEffect.Descriptor descriptor : AudioEffect.queryEffects()) {
                try {
                    if (descriptor.implementor.contains("Dolby Laboratories")) {
                        z16 = true;
                    }
                } catch (Exception e16) {
                    e = e16;
                    TPNativeLog.printLog(0, e.getMessage());
                    return z16;
                }
            }
        } catch (Exception e17) {
            e = e17;
            z16 = false;
        }
        return z16;
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
                        e16.printStackTrace();
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public static int getCpuHWProductIndex(int i3, String str) {
        if (i3 >= 0) {
            String[][] strArr = sCpuPerfList;
            if (i3 >= strArr.length || TextUtils.isEmpty(str)) {
                return -1;
            }
            String[] strArr2 = strArr[i3];
            for (int i16 = 0; i16 < strArr2.length; i16++) {
                if (TextUtils.equals(str, strArr2[i16])) {
                    return i16;
                }
            }
        }
        return -1;
    }
}
