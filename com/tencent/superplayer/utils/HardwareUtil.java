package com.tencent.superplayer.utils;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class HardwareUtil {
    public static final int CPU_LEVEL_HIGH = 3;
    public static final int CPU_LEVEL_LOW = 0;
    public static final int CPU_LEVEL_MIDDLE = 2;
    public static final int CPU_LEVEL_MIDDLE_LOW = 1;
    public static final int DEVICE_LEVEL_BOTTOM_LOW = -2;
    public static final int DEVICE_LEVEL_HIGH = 3;
    public static final int DEVICE_LEVEL_LOW = 1;
    public static final int DEVICE_LEVEL_MID = 2;
    public static final int RAM_LEVEL_BOTTOM_LOW = 0;
    public static final int RAM_LEVEL_HIGH = 3;
    public static final int RAM_LEVEL_LOW = 1;
    public static final int RAM_LEVEL_MIDDLE = 2;
    public static final int RAM_LEVEL_TOP_HIGH = 4;
    public static final String TAG = "HardwareUtil";
    public static final int UNKNOWN = -1;
    private static int sCacheDeviceLevel = -1;
    private static String sDeviceName;
    private static final Map<String, String> sDeviceInfoJsonMap = new HashMap();
    private static final FileFilter CPU_FILTER = new FileFilter() { // from class: com.tencent.superplayer.utils.HardwareUtil.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i3 = 3; i3 < name.length(); i3++) {
                if (!Character.isDigit(name.charAt(i3))) {
                    return false;
                }
            }
            return true;
        }
    };

    private static int extractValue(byte[] bArr, int i3) {
        byte b16;
        while (i3 < bArr.length && (b16 = bArr[i3]) != 10) {
            if (Character.isDigit(b16)) {
                int i16 = i3 + 1;
                while (i16 < bArr.length && Character.isDigit(bArr[i16])) {
                    i16++;
                }
                return Integer.parseInt(new String(bArr, 0, i3, i16 - i3));
            }
            i3++;
        }
        return -1;
    }

    public static long getAvailMemory(Context context) {
        if (context == null) {
            return -1L;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager == null) {
            return -1L;
        }
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static String getBrand() {
        return Build.BRAND;
    }

    public static int getCPUMaxFreqKHz() {
        int i3 = -1;
        for (int i16 = 0; i16 < getNumberOfCPUCores(); i16++) {
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i16 + "/cpufreq/cpuinfo_max_freq");
                if (file.exists() && file.canRead()) {
                    byte[] bArr = new byte[128];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        int i17 = 0;
                        while (Character.isDigit(bArr[i17]) && i17 < 128) {
                            i17++;
                        }
                        Integer valueOf = Integer.valueOf(Integer.parseInt(new String(bArr, 0, i17)));
                        if (valueOf.intValue() > i3) {
                            i3 = valueOf.intValue();
                        }
                    } catch (NumberFormatException unused) {
                    } catch (Throwable th5) {
                        fileInputStream.close();
                        throw th5;
                    }
                    fileInputStream.close();
                }
            } catch (IOException unused2) {
                return -1;
            }
        }
        if (i3 == -1) {
            FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
            try {
                int parseFileForValue = parseFileForValue("cpu MHz", fileInputStream2) * 1000;
                if (parseFileForValue > i3) {
                    i3 = parseFileForValue;
                }
                fileInputStream2.close();
            } catch (Throwable th6) {
                fileInputStream2.close();
                throw th6;
            }
        }
        return i3;
    }

    private static int getCoresFromFileInfo(String str) {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream2));
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                int coresFromFileString = getCoresFromFileString(readLine);
                try {
                    fileInputStream2.close();
                } catch (IOException unused) {
                }
                return coresFromFileString;
            } catch (IOException unused2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                        return -1;
                    } catch (IOException unused3) {
                        return -1;
                    }
                }
                return -1;
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (IOException unused5) {
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private static int getCoresFromFileString(String str) {
        if (str != null && str.matches("0-[\\d]+$")) {
            return Integer.valueOf(str.substring(2)).intValue() + 1;
        }
        return -1;
    }

    public static String getDeviceInfoJson() {
        String jSONObject;
        Map<String, String> map = sDeviceInfoJsonMap;
        synchronized (map) {
            if (map.isEmpty()) {
                map.put("model", getDeviceName());
                map.put("brand", getBrand());
                map.put("cpuMaxFreqMHz", String.valueOf(getCPUMaxFreqKHz() / 1000));
                map.put("cpuCoreNumber", String.valueOf(getNumberOfCPUCores()));
                map.put("cpuName", getHardWare());
                map.put("ram", String.valueOf(getTotalMemory(SuperPlayerSDKMgr.getContext())));
            }
            map.put("availRam", String.valueOf(getAvailMemory(SuperPlayerSDKMgr.getContext())));
            jSONObject = new JSONObject(map).toString();
        }
        return jSONObject;
    }

    public static String getDeviceName() {
        if (TextUtils.isEmpty(sDeviceName)) {
            sDeviceName = DeviceInfoMonitor.getModel();
        }
        return sDeviceName;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getHardWare() {
        FileReader fileReader;
        Throwable th5;
        Exception e16;
        String str;
        try {
            try {
                fileReader = new FileReader("/proc/cpuinfo");
            } catch (Exception e17) {
                fileReader = null;
                e16 = e17;
            } catch (Throwable th6) {
                fileReader = null;
                th5 = th6;
                if (fileReader != null) {
                }
                throw th5;
            }
        } catch (Exception e18) {
            LogUtil.e(TAG, "getHardWare error when close,", e18);
        }
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                str = "";
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    str = readLine;
                }
            } catch (Throwable th7) {
                th5 = th7;
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Exception e19) {
                        LogUtil.e(TAG, "getHardWare error when close,", e19);
                    }
                }
                throw th5;
            }
        } catch (Exception e26) {
            e16 = e26;
            LogUtil.e(TAG, "getHardWare error,", e16);
            if (fileReader != null) {
                fileReader.close();
            }
            return Build.HARDWARE;
        }
        if (str.contains("Hardware")) {
            String str2 = str.split(":\\s+", 2)[1];
            try {
                fileReader.close();
            } catch (Exception e27) {
                LogUtil.e(TAG, "getHardWare error when close,", e27);
            }
            return str2;
        }
        fileReader.close();
        return Build.HARDWARE;
    }

    public static int getNumberOfCPUCores() {
        File[] listFiles;
        try {
            int coresFromFileInfo = getCoresFromFileInfo("/sys/devices/system/cpu/possible");
            if (coresFromFileInfo == -1) {
                coresFromFileInfo = getCoresFromFileInfo("/sys/devices/system/cpu/present");
            }
            if (coresFromFileInfo == -1) {
                File file = new File("/sys/devices/system/cpu/");
                if (file.exists() && (listFiles = file.listFiles(CPU_FILTER)) != null) {
                    return listFiles.length;
                }
            }
            return coresFromFileInfo;
        } catch (NullPointerException | SecurityException unused) {
            return -1;
        }
    }

    @TargetApi(16)
    public static long getTotalMemory(Context context) {
        if (context == null) {
            return -1L;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
        }
        return memoryInfo.totalMem;
    }

    private static int judgeCPU() {
        int cPUMaxFreqKHz = getCPUMaxFreqKHz() / 1000;
        if (cPUMaxFreqKHz <= 1600) {
            return 0;
        }
        if (cPUMaxFreqKHz <= 2000) {
            return 1;
        }
        if (cPUMaxFreqKHz <= 2500) {
            return 2;
        }
        return 3;
    }

    public static int judgeDeviceLevel(Context context) {
        int i3 = -1;
        if (context == null) {
            return -1;
        }
        int i16 = sCacheDeviceLevel;
        if (i16 != -1) {
            return i16;
        }
        int judgeMemory = judgeMemory(context);
        int judgeCPU = judgeCPU();
        if (judgeMemory < 1 && judgeCPU == 0) {
            i3 = -2;
        } else if (judgeMemory >= 2 && judgeCPU != 0) {
            if (judgeMemory != 2 || judgeCPU < 1) {
                if (judgeMemory > 2) {
                    if (judgeCPU > 1) {
                        i3 = 3;
                    }
                }
            }
            i3 = 2;
        } else {
            i3 = 1;
        }
        sCacheDeviceLevel = i3;
        return i3;
    }

    private static int judgeMemory(Context context) {
        long totalMemory = getTotalMemory(context) / 1048576;
        if (totalMemory <= 2000) {
            return 0;
        }
        if (totalMemory <= 3000) {
            return 1;
        }
        if (totalMemory <= 4000) {
            return 2;
        }
        if (totalMemory <= 6000) {
            return 3;
        }
        return 4;
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
        } catch (IOException unused) {
            return -1;
        } catch (NumberFormatException e16) {
            LogUtil.e(TAG, "parseFileForValue failed.", e16);
            return -1;
        }
    }

    public static void setDeviceName(String str) {
        sDeviceName = str;
    }
}
