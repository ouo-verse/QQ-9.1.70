package com.tencent.qqlive.superplayer.tools.utils;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes22.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static String f345493a = "N/A";

    /* renamed from: b, reason: collision with root package name */
    private static String f345494b = "";

    /* renamed from: c, reason: collision with root package name */
    private static String f345495c = "";

    /* renamed from: d, reason: collision with root package name */
    private static int f345496d = 0;

    /* renamed from: e, reason: collision with root package name */
    private static int f345497e = -1;

    /* renamed from: f, reason: collision with root package name */
    private static int f345498f = -1;

    /* renamed from: g, reason: collision with root package name */
    private static int f345499g = -1;

    /* renamed from: h, reason: collision with root package name */
    private static String f345500h = "";

    /* renamed from: i, reason: collision with root package name */
    private static long f345501i;

    /* renamed from: p, reason: collision with root package name */
    private static String f345508p;

    /* renamed from: j, reason: collision with root package name */
    private static final String f345502j = Environment.getDataDirectory() + "/data/";

    /* renamed from: k, reason: collision with root package name */
    private static final String[][] f345503k = {new String[]{"MSM7227", "MSM7627", "MSM7227T", "MSM7627T", "MSM7227A", "MSM7627A", "QSD8250", "QSD8650", "MSM7230", "MSM7630", "APQ8055", "MSM8255", "MSM8655", "MSM8255T", "MSM8655T", "MSM8225", "MSM8625", "MSM8260", "MSM8660", "MSM8x25Q", "MSM8x26", "MSM8x10", "MSM8x12", "MSM8x30", "MSM8260A", "MSM8660A", "MSM8960", "MSM8208", "MSM8916", "MSM8960T", "MSM8909", "MSM8916v2", "MSM8936", "MSM8909v2", "MSM8917", "APQ8064", "APQ8064T", "MSM8920", "MSM8939", "MSM8937", "MSM8939v2", "MSM8940", "MSM8952", "MSM8974", "MSM8x74AA", "MSM8x74AB", "MSM8x74AC", "MSM8953", "APQ8084", "MSM8953Pro", "MSM8992", "MSM8956", "MSM8976", "MSM8976Pro", "MSM8994", "MSM8996", "MSM8996Pro"}, new String[]{"MT6516", "MT6513", "MT6573", "MT6515M", "MT6515", "MT6575", "MT6572", "MT6577", "MT6589", "MT6582", "MT6592", "MT6595", "MT6735", "MT6750", "MT6753", "MT6752", "MT6755", "MT6755", "MT6755T", "MT6795", "MT6757", "MT675x", "MT6797", "MT6797T"}, new String[]{"K3V2", "K3V2E", "K3V2+", "Kirin910", "Kirin920", "Kirin925", "Kirin928", "Kirin620", "Kirin650", "Kirin655", "Kirin930", "Kirin935", "Kirin950", "Kirin955", "Kirin960"}, new String[]{"S5L8900", "S5PC100", "Exynos3110", "Exynos3475", "Exynos4210", "Exynos4212", "SMDK4x12", "Exynos4412", "Exynos5250", "Exynos5260", "Exynos5410", "Exynos5420", "Exynos5422", "Exynos5430", "Exynos5800", "Exynos5433", "Exynos7580", "Exynos7870", "Exynos7870", "Exynos7420", "Exynos8890"}};

    /* renamed from: l, reason: collision with root package name */
    private static String f345504l = "";

    /* renamed from: m, reason: collision with root package name */
    private static long f345505m = -1;

    /* renamed from: n, reason: collision with root package name */
    private static long f345506n = -1;

    /* renamed from: o, reason: collision with root package name */
    private static int f345507o = -1;

    /* renamed from: q, reason: collision with root package name */
    private static int f345509q = -1;

    /* renamed from: r, reason: collision with root package name */
    private static int f345510r = -1;

    /* renamed from: s, reason: collision with root package name */
    private static boolean f345511s = false;

    /* renamed from: t, reason: collision with root package name */
    private static int f345512t = -1;

    /* renamed from: u, reason: collision with root package name */
    private static int f345513u = -1;

    /* renamed from: v, reason: collision with root package name */
    private static int f345514v = -1;

    /* renamed from: w, reason: collision with root package name */
    private static int f345515w = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    private static int a() {
        if (f345496d == 0) {
            g();
        }
        if (!TextUtils.isEmpty(f345495c) && f345495c.contains("MSM8994")) {
            return 7;
        }
        if (h().equals("XT882") || h().equals("ME860") || h().equals("MB860") || h().equals("Lenovo P70") || h().equals("Lenovo A60") || h().equals("Lenovo A366t")) {
            return 3;
        }
        if (!TextUtils.isEmpty(f345493a) && f345493a.contains("ARMv6")) {
            return 4;
        }
        if (!TextUtils.isEmpty(f345494b) && !f345494b.contains("neon")) {
            return 4;
        }
        int i3 = f345496d;
        if (i3 == 64) {
            return 7;
        }
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
                return 50;
            default:
                return 0;
        }
    }

    public static int b() {
        int i3 = f345509q;
        if (-1 != i3) {
            return i3;
        }
        String str = Build.CPU_ABI;
        if (str != null && (str.contains(ResourceAttributes.HostArchValues.X86) || str.contains("X86"))) {
            f345509q = 1;
        } else if (str != null && (str.contains("mips") || str.contains("Mips"))) {
            f345509q = 2;
        } else {
            f345509q = a();
        }
        return f345509q;
    }

    private static int c(String str) {
        if (str.isEmpty()) {
            return -1;
        }
        if (!str.contains("Exynos") && !str.contains("SMDK") && !str.contains("S5L8900") && !str.contains("S5PC100")) {
            if (!str.contains("Kirin") && !str.contains("K3V")) {
                if (!str.contains("MSM") && !str.contains("APQ") && !str.contains("QSD")) {
                    if (!str.contains("MT6")) {
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

    public static int d(String str) {
        if (f345497e < 0) {
            f345497e = c(str);
        }
        int i3 = f345497e;
        if (i3 >= 0 && f345498f < 0) {
            String[] strArr = f345503k[i3];
            int i16 = -1;
            for (int i17 = 0; i17 < strArr.length; i17++) {
                if (str.contains(strArr[i17]) && (-1 == i16 || strArr[i17].length() > strArr[i16].length())) {
                    i16 = i17;
                }
            }
            f345498f = i16;
        }
        return f345498f;
    }

    public static int e(String str) {
        if (f345497e < 0) {
            f345497e = c(str);
        }
        return f345497e;
    }

    public static String f() {
        if (TextUtils.isEmpty(f345495c)) {
            g();
        }
        return f345495c;
    }

    public static void g() {
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
                                f345496d = 64;
                            }
                            if (readLine.startsWith("Processor")) {
                                int indexOf3 = readLine.indexOf(58);
                                if (indexOf3 > 1) {
                                    String substring = readLine.substring(indexOf3 + 1, readLine.length());
                                    f345493a = substring;
                                    f345493a = substring.trim();
                                }
                            } else if (readLine.startsWith("CPU architecture")) {
                                if (f345496d == 0 && (indexOf = readLine.indexOf(58)) > 1) {
                                    String trim = readLine.substring(indexOf + 1, readLine.length()).trim();
                                    if (trim.length() > 0 && trim.length() < 2) {
                                        f345496d = (int) Long.parseLong(trim);
                                    } else if (trim.length() > 1) {
                                        f345496d = (int) Long.parseLong(trim.substring(0, 1));
                                    }
                                }
                            } else if (readLine.startsWith("Features")) {
                                int indexOf4 = readLine.indexOf(58);
                                if (indexOf4 > 1) {
                                    f345494b = readLine.substring(indexOf4 + 1, readLine.length()).trim();
                                }
                            } else if (readLine.startsWith("Hardware") && (indexOf2 = readLine.indexOf(58)) > 1) {
                                f345495c = readLine.substring(indexOf2 + 1, readLine.length()).trim().replace(" ", "");
                                d.d("MediaPlayerMgr[TVKVcSystemInfo.java]", "hardward " + f345495c);
                                d(f345495c);
                            }
                        } catch (Throwable unused) {
                            inputStreamReader = inputStreamReader2;
                            try {
                                f345495c = "Unknown";
                                f345496d = 0;
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
                                        d.b("MediaPlayerMgr[TVKVcSystemInfo.java]", e16);
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
            d.b("MediaPlayerMgr[TVKVcSystemInfo.java]", e17);
        }
    }

    public static String h() {
        if (TextUtils.isEmpty(f345508p)) {
            f345508p = DeviceInfoMonitor.getModel();
        }
        return f345508p;
    }

    public static String i(Context context) {
        TextUtils.isEmpty(f345500h);
        return f345500h;
    }

    public static long j() {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        String readLine;
        long j3 = f345505m;
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
                        f345505m = j16;
                        d.d("MediaPlayerMgr[TVKVcSystemInfo.java]", "MaxCpuFreq " + f345505m);
                        return j16;
                    } catch (Throwable unused2) {
                        inputStreamReader2 = inputStreamReader;
                        if (inputStreamReader2 != null) {
                            inputStreamReader2.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        f345505m = j16;
                        d.d("MediaPlayerMgr[TVKVcSystemInfo.java]", "MaxCpuFreq " + f345505m);
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
            d.b("MediaPlayerMgr[TVKVcSystemInfo.java]", e16);
        }
        if (readLine == null) {
            inputStreamReader.close();
            bufferedReader.close();
            try {
                inputStreamReader.close();
                bufferedReader.close();
            } catch (IOException e17) {
                d.b("MediaPlayerMgr[TVKVcSystemInfo.java]", e17);
            }
            return 0L;
        }
        String trim = readLine.trim();
        if (trim.length() > 0) {
            j16 = Long.parseLong(trim);
        }
        inputStreamReader.close();
        bufferedReader.close();
        f345505m = j16;
        d.d("MediaPlayerMgr[TVKVcSystemInfo.java]", "MaxCpuFreq " + f345505m);
        return j16;
    }

    public static int k(Context context) {
        NetworkInfo activeNetworkInfo;
        int i3 = f345513u;
        if (i3 != -1 && !f345511s) {
            return i3;
        }
        f345513u = 0;
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                    int type = NetworkMonitor.getType(activeNetworkInfo);
                    if (type != 0) {
                        if (type != 1) {
                            if (type != 2 && type != 3 && type != 4 && type != 5) {
                                if (type != 9) {
                                    f345513u = 4;
                                } else {
                                    f345513u = 5;
                                }
                            }
                        } else {
                            f345513u = 1;
                        }
                    }
                    f345513u = 2;
                    if (NetworkMonitor.netGetExInfo(activeNetworkInfo) != null && !"cmnet".equalsIgnoreCase(NetworkMonitor.netGetExInfo(activeNetworkInfo))) {
                        f345513u = 3;
                    }
                }
            } catch (Exception e16) {
                d.b("MediaPlayerMgr[TVKVcSystemInfo.java]", e16);
            }
        }
        return f345513u;
    }

    private static int l(int i3) {
        switch (i3) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 4;
            default:
                return 0;
        }
    }

    public static int m(Context context) {
        NetworkInfo activeNetworkInfo;
        int i3 = f345514v;
        if (i3 != -1 && !f345511s) {
            return i3;
        }
        if (context == null) {
            return 0;
        }
        f345514v = 0;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                int type = NetworkMonitor.getType(activeNetworkInfo);
                if (type != 0) {
                    if (type != 1) {
                        f345514v = 0;
                    } else {
                        f345514v = 1;
                    }
                } else {
                    f345514v = l(NetworkMonitor.getSubtype(activeNetworkInfo));
                }
            }
        } catch (Throwable th5) {
            d.b("MediaPlayerMgr[TVKVcSystemInfo.java]", th5);
            f345514v = 0;
        }
        return f345514v;
    }

    public static int n() {
        int i3 = f345507o;
        if (-1 != i3) {
            return i3;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new a());
            if (listFiles == null) {
                f345507o = 1;
                return 1;
            }
            f345507o = listFiles.length;
            d.d("MediaPlayerMgr[TVKVcSystemInfo.java]", "core num " + f345507o);
            return f345507o;
        } catch (Exception e16) {
            d.b("MediaPlayerMgr[TVKVcSystemInfo.java]", e16);
            f345507o = 1;
            return 1;
        }
    }

    public static int o() {
        int i3 = f345499g;
        if (-1 != i3) {
            return i3;
        }
        f345499g = 11;
        if (b() < 6) {
            f345499g = 1;
        }
        if (n() == 1 && j() / 1000 <= 1000) {
            f345499g = 6;
        }
        if ((n() == 1 && j() / 1000 > 1000) || (n() == 2 && j() / 1000 < 1400)) {
            f345499g = 11;
        }
        if (n() == 2 && j() / 1000 >= 1400) {
            f345499g = 16;
        }
        if (n() >= 4) {
            f345499g = 21;
        }
        return f345499g;
    }

    @TargetApi(16)
    public static long p(Context context) {
        if (context == null) {
            return 0L;
        }
        long j3 = f345501i;
        if (j3 > 0) {
            return j3;
        }
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getMemoryInfo(memoryInfo);
            long j16 = memoryInfo.totalMem / 1048576;
            f345501i = j16;
            return j16;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static boolean q(Context context) {
        int i3 = f345512t;
        if (i3 != -1 && !f345511s) {
            if (i3 != 1) {
                return false;
            }
            return true;
        }
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                if (connectivityManager == null) {
                    f345512t = 0;
                } else {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                        if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                            f345512t = 1;
                        } else {
                            f345512t = 0;
                        }
                    }
                    f345512t = 0;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        if (f345512t != 1) {
            return false;
        }
        return true;
    }

    public static boolean r(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return true;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                int type = NetworkMonitor.getType(activeNetworkInfo);
                if (type == 0 || type == 2 || type == 3 || type == 4 || type == 5) {
                    return true;
                }
                return false;
            }
        } catch (Exception e16) {
            d.b("MediaPlayerMgr[TVKVcSystemInfo.java]", e16);
        }
        return true;
    }
}
