package com.tencent.mobileqq.ar.arengine;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: P */
/* loaded from: classes11.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private static int f198278a = -1;

    /* renamed from: b, reason: collision with root package name */
    private static int f198279b = -1;

    /* renamed from: c, reason: collision with root package name */
    private static long f198280c = -1;

    /* renamed from: d, reason: collision with root package name */
    private static int f198281d = -1;

    /* renamed from: e, reason: collision with root package name */
    private static final FileFilter f198282e = new a();

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements FileFilter {
        a() {
        }

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
    }

    private static int a(byte[] bArr, int i3) {
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

    public static int b() {
        int i3 = f198279b;
        if (i3 != -1) {
            return i3;
        }
        if (DeviceInfoMonitor.getModel().equalsIgnoreCase("Nexus 5X")) {
            f198279b = 1824;
            return 1824;
        }
        int i16 = 0;
        boolean z16 = false;
        int i17 = -1;
        while (true) {
            boolean z17 = true;
            if (i16 < h()) {
                String str = "/sys/devices/system/cpu/cpu" + i16 + "/cpufreq/cpuinfo_max_freq";
                QLog.i("AREngine_ARDeviceInfo", 1, "getCPUMaxFreq From cpuinfo_max_freq. filename = " + str);
                try {
                    File file = new File(str);
                    if (file.exists()) {
                        byte[] bArr = new byte[128];
                        FileInputStream fileInputStream = new FileInputStream(file);
                        try {
                            try {
                                fileInputStream.read(bArr);
                                int i18 = 0;
                                while (Character.isDigit(bArr[i18]) && i18 < 128) {
                                    i18++;
                                }
                                int parseInt = Integer.parseInt(new String(bArr, 0, i18)) / 1000;
                                QLog.i("AREngine_ARDeviceInfo", 1, "getCPUMaxFreq From cpuinfo_max_freq. freqBound = " + parseInt);
                                if (parseInt > i17) {
                                    i17 = parseInt;
                                }
                                fileInputStream.close();
                            } catch (Throwable th5) {
                                fileInputStream.close();
                                throw th5;
                                break;
                            }
                        } catch (Exception e16) {
                            QLog.i("AREngine_ARDeviceInfo", 1, "getMaxCpuFreq From cpuinfo_max_freq failed." + e16.toString());
                            fileInputStream.close();
                            z16 = true;
                        }
                        z17 = z16;
                    } else {
                        QLog.i("AREngine_ARDeviceInfo", 1, "getMaxCpuFreq From cpuinfo_max_freq failed. !cpuInfoMaxFreqFile.exists.");
                    }
                } catch (Exception e17) {
                    QLog.i("AREngine_ARDeviceInfo", 1, "getMaxCpuFreq From cpuinfo_max_freq failed2." + e17.toString());
                }
                z16 = z17;
                i16++;
            } else {
                if (z16) {
                    int c16 = c();
                    QLog.i("AREngine_ARDeviceInfo", 1, "getCPUMaxFreq From State. freqBound = " + c16);
                    if (c16 == -1) {
                        try {
                            FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
                            try {
                                try {
                                    c16 = j("cpu MHz", fileInputStream2);
                                    QLog.i("AREngine_ARDeviceInfo", 1, "getCPUMaxFreq From cpuinfo. freqBound = " + c16);
                                    if (c16 > i17) {
                                        i17 = c16;
                                    }
                                } catch (Exception e18) {
                                    QLog.i("AREngine_ARDeviceInfo", 1, "getCPUMaxFreq From cpuinfo. failed." + e18.toString());
                                }
                            } finally {
                                fileInputStream2.close();
                            }
                        } catch (Exception e19) {
                            QLog.i("AREngine_ARDeviceInfo", 1, "getCPUMaxFreq From cpuinfo. failed2." + e19.toString());
                        }
                    }
                    int i19 = i17;
                    i17 = c16;
                    if (i17 <= i19) {
                        i17 = i19;
                    }
                }
                f198279b = i17;
                return i17;
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00b3: MOVE (r3 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:180), block:B:46:0x00b3 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0088 -> B:21:0x00b1). Please report as a decompilation issue!!! */
    private static int c() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        Exception e16;
        String str;
        int indexOf;
        int i3 = -1;
        BufferedReader bufferedReader3 = null;
        String str2 = null;
        try {
            try {
                try {
                    bufferedReader2 = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpufreq/all_time_in_state"));
                } catch (Exception e17) {
                    bufferedReader2 = null;
                    e16 = e17;
                } catch (Throwable th5) {
                    th = th5;
                    if (bufferedReader3 != null) {
                        try {
                            bufferedReader3.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    throw th;
                }
                try {
                    String readLine = bufferedReader2.readLine();
                    while (true) {
                        String str3 = readLine;
                        str = str2;
                        str2 = str3;
                        if (str2 == null) {
                            break;
                        }
                        QLog.i("AREngine_ARDeviceInfo", 1, "getCPUMaxFreq From all_time_in_state. lastText = " + str2);
                        readLine = bufferedReader2.readLine();
                    }
                    if (str == null) {
                        indexOf = -1;
                    } else {
                        indexOf = str.indexOf(9);
                    }
                    if (indexOf != -1) {
                        String substring = str.substring(0, indexOf);
                        if (substring != null && substring.length() > 0) {
                            int parseInt = Integer.parseInt(substring) / 1000;
                            QLog.i("AREngine_ARDeviceInfo", 1, "getCPUMaxFreq From all_time_in_state. freqBound = " + parseInt);
                            if (parseInt > -1) {
                                i3 = parseInt;
                            }
                        }
                    } else {
                        QLog.i("AREngine_ARDeviceInfo", 1, "getCPUMaxFreq From all_time_in_state failed. index = " + indexOf);
                    }
                    bufferedReader2.close();
                } catch (Exception e19) {
                    e16 = e19;
                    QLog.i("AREngine_ARDeviceInfo", 1, "getCPUMaxFreq From all_time_in_state failed." + e16.toString());
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    return i3;
                }
            } catch (IOException e26) {
                e26.printStackTrace();
            }
            return i3;
        } catch (Throwable th6) {
            th = th6;
            bufferedReader3 = bufferedReader;
        }
    }

    private static int d() {
        return new File("/sys/devices/system/cpu/").listFiles(f198282e).length;
    }

    private static int e(String str) {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream2));
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                int f16 = f(readLine);
                try {
                    fileInputStream2.close();
                } catch (IOException unused) {
                }
                return f16;
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

    static int f(String str) {
        if (str != null && str.matches("0-[\\d]+$")) {
            return Integer.valueOf(str.substring(2)).intValue() + 1;
        }
        return -1;
    }

    public static int g() {
        int i3 = f198281d;
        if (i3 != -1) {
            return i3;
        }
        f198278a = h();
        f198279b = b();
        long i16 = i(BaseApplicationImpl.getApplication().getApplicationContext());
        f198280c = i16;
        int i17 = f198278a;
        if (i17 < 8 && (i17 < 4 || f198279b <= 2355.2d || i16 <= 2048)) {
            if (i17 > 2 && f198279b >= 1331.2d && i16 > 1024) {
                f198281d = 1;
            } else {
                f198281d = 2;
            }
        } else {
            f198281d = 0;
            if (DeviceInfoMonitor.getModel().equalsIgnoreCase("MI NOTE LTE") || DeviceInfoMonitor.getModel().equalsIgnoreCase("vivo Y37A") || DeviceInfoMonitor.getModel().equalsIgnoreCase("Nexus 6") || DeviceInfoMonitor.getModel().equalsIgnoreCase("ATH-AL00")) {
                f198281d = 1;
            }
        }
        QLog.i("AREngine_ARDeviceInfo", 1, "getDeviceCapability. Build.MODEL = " + DeviceInfoMonitor.getModel() + ", deviceCapability = " + f198281d + ", numberOfCPUCores = " + f198278a + ", cpuMaxFreqMHz = " + f198279b + ", totalMemoryMB = " + f198280c);
        return f198281d;
    }

    public static int h() {
        int i3 = f198278a;
        int i16 = -1;
        if (i3 != -1) {
            return i3;
        }
        try {
            int e16 = e("/sys/devices/system/cpu/possible");
            if (e16 == -1) {
                e16 = e("/sys/devices/system/cpu/present");
            }
            if (e16 == -1) {
                e16 = d();
            }
            i16 = e16;
        } catch (NullPointerException | SecurityException unused) {
        }
        f198278a = i16;
        return i16;
    }

    @TargetApi(16)
    public static long i(Context context) {
        long j3 = f198280c;
        if (j3 != -1) {
            return j3;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getMemoryInfo(memoryInfo);
        long j16 = memoryInfo.totalMem / 1048576;
        f198280c = j16;
        return j16;
    }

    private static int j(String str, FileInputStream fileInputStream) {
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
                            return a(bArr, i16);
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
}
