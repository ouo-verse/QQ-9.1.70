package com.tencent.qqmini.sdk.core.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DeviceUtil {
    public static final int BUFFER_SIZE = 1024;
    public static final String TAG = "DeviceUtil";
    private static long cachedTotalMemory = 0;
    private static long initial_rate = 0;
    protected static String location = null;
    public static int sCpuCoreNum = -1;
    private static long sCpuMaxFreq;

    public static long getCpuFrequency() {
        BufferedReader bufferedReader;
        long j3 = initial_rate;
        if (j3 > 0) {
            return j3;
        }
        int cpuNumber = getCpuNumber();
        int i3 = 0;
        while (initial_rate <= 0 && i3 < cpuNumber) {
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu" + i3 + "/cpufreq/cpuinfo_max_freq"), 1024);
            } catch (Exception unused) {
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    long parseLong = Long.parseLong(readLine);
                    initial_rate = parseLong;
                    initial_rate = parseLong / 1024;
                }
                bufferedReader.close();
            } catch (Exception unused2) {
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused3) {
                    }
                }
                i3++;
            } catch (Throwable th6) {
                th = th6;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getCpuFrequency = ");
        sb5.append(initial_rate);
        sb5.append("; CpuNum = ");
        sb5.append(i3 - 1);
        QMLog.d("DeviceUtil", sb5.toString());
        return initial_rate;
    }

    public static long getCpuMaxFreq() {
        if (sCpuMaxFreq == 0) {
            initCpuMaxFreq();
        }
        return sCpuMaxFreq;
    }

    public static int getCpuNumber() {
        return getNumberOfCores();
    }

    public static int getDeviceBenchmarkLevel() {
        int cpuMaxFreq;
        int systemTotalMemory;
        try {
            int cpuNumber = getCpuNumber();
            if (cpuNumber <= 0 || (cpuMaxFreq = (int) (getCpuMaxFreq() / JsonGrayBusiId.UI_RESERVE_100000_110000)) <= 0 || (systemTotalMemory = (int) (getSystemTotalMemory() / 1048576)) <= 0) {
                return -1;
            }
            int i3 = (((cpuNumber * 200) + ((cpuMaxFreq * cpuMaxFreq) * 10)) + (((systemTotalMemory / 1024) * (systemTotalMemory / 1024)) * 100)) / 400;
            if (i3 > 50) {
                i3 = 50;
            }
            QMLog.d("getDeviceBenchmarkLevel", "getDeviceBenchmarkLevel coreNum:" + cpuNumber + " cpuFreq:" + cpuMaxFreq + " ramSize:" + systemTotalMemory + " score:" + i3);
            return i3;
        } catch (Throwable th5) {
            QMLog.e("getDeviceBenchmarkLevel", "getDeviceBenchmarkLevel error", th5);
            return -1;
        }
    }

    public static String getLocation() {
        if (!TextUtils.isEmpty(location)) {
            return location;
        }
        Context context = AppLoaderFactory.g().getContext();
        if (context == null) {
            return "";
        }
        String location2 = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getLocation(context);
        location = location2;
        return location2;
    }

    private static final int getNumCoresOldPhones() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.tencent.qqmini.sdk.core.utils.DeviceUtil.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    if (Pattern.matches("cpu[0-9]+", file.getName())) {
                        return true;
                    }
                    return false;
                }
            }).length;
        } catch (Exception unused) {
            return 1;
        }
    }

    @SuppressLint({"NewApi"})
    public static final int getNumberOfCores() {
        if (sCpuCoreNum == -1) {
            sCpuCoreNum = Runtime.getRuntime().availableProcessors();
        }
        return sCpuCoreNum;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x004d, code lost:
    
        if (r4 != null) goto L11;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long getSystemTotalMemory() {
        Throwable th5;
        BufferedReader bufferedReader;
        FileReader fileReader;
        if (cachedTotalMemory == 0) {
            BufferedReader bufferedReader2 = null;
            bufferedReader2 = null;
            bufferedReader2 = null;
            bufferedReader2 = null;
            try {
                try {
                    try {
                        fileReader = new FileReader("/proc/meminfo");
                        try {
                            bufferedReader = new BufferedReader(fileReader, 1024);
                            try {
                                String readLine = bufferedReader.readLine();
                                bufferedReader2 = readLine;
                                if (readLine != null) {
                                    Long valueOf = Long.valueOf(readLine.split("\\s+")[1]);
                                    cachedTotalMemory = valueOf.longValue() * 1024;
                                    bufferedReader2 = valueOf;
                                }
                                bufferedReader.close();
                            } catch (Exception unused) {
                                bufferedReader2 = bufferedReader;
                                cachedTotalMemory = 0L;
                                if (bufferedReader2 != null) {
                                    bufferedReader2.close();
                                }
                            } catch (Throwable th6) {
                                th5 = th6;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Exception unused2) {
                                        throw th5;
                                    }
                                }
                                if (fileReader != null) {
                                    fileReader.close();
                                }
                                throw th5;
                            }
                        } catch (Exception unused3) {
                        }
                    } catch (Exception unused4) {
                        fileReader = null;
                    } catch (Throwable th7) {
                        fileReader = null;
                        th5 = th7;
                        bufferedReader = null;
                    }
                    fileReader.close();
                } catch (Exception unused5) {
                }
                if (cachedTotalMemory == 0) {
                    return 1073741824L;
                }
            } catch (Throwable th8) {
                BufferedReader bufferedReader3 = bufferedReader2;
                th5 = th8;
                bufferedReader = bufferedReader3;
            }
        }
        return cachedTotalMemory;
    }

    private static void initCpuFreq(String str) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        Exception e16;
        long j3;
        int cpuNumber = getCpuNumber();
        for (int i3 = 0; i3 < cpuNumber; i3++) {
            BufferedReader bufferedReader2 = null;
            try {
                fileReader = new FileReader("/sys/devices/system/cpu/cpu" + i3 + "/cpufreq/" + str);
                try {
                    bufferedReader = new BufferedReader(fileReader, 1024);
                } catch (Exception e17) {
                    bufferedReader = null;
                    e16 = e17;
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Exception e18) {
                bufferedReader = null;
                e16 = e18;
                fileReader = null;
            } catch (Throwable th6) {
                th = th6;
                fileReader = null;
            }
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        j3 = Long.parseLong(readLine);
                    } else {
                        j3 = 0;
                    }
                    if (sCpuMaxFreq < j3) {
                        sCpuMaxFreq = j3;
                    }
                    QMLog.d("getDeviceBenchmarkLevel", String.format(Locale.getDefault(), "initCpuFreq  [%d, %d Khz]", Integer.valueOf(i3), Long.valueOf(j3)));
                    try {
                        bufferedReader.close();
                    } catch (Exception e19) {
                        e19.printStackTrace();
                    }
                    try {
                        fileReader.close();
                    } catch (Exception e26) {
                        e26.printStackTrace();
                    }
                } catch (Exception e27) {
                    e16 = e27;
                    e16.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e28) {
                            e28.printStackTrace();
                        }
                    }
                    if (fileReader != null) {
                        fileReader.close();
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception e29) {
                        e29.printStackTrace();
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                        throw th;
                    } catch (Exception e36) {
                        e36.printStackTrace();
                        throw th;
                    }
                }
                throw th;
            }
        }
    }

    private static void initCpuMaxFreq() {
        initCpuFreq("cpuinfo_max_freq");
    }
}
