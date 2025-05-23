package com.tencent.beacon.a.c;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.beacon.a.d.a;
import com.tencent.beacon.base.net.b.e;
import com.tencent.gathererga.core.HardwareInfoProvider;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.qqmini.miniapp.util.logmonitor.LogCmdOptions;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes2.dex */
public class e implements e.a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile e f77655a;

    /* renamed from: b, reason: collision with root package name */
    private String f77656b = "";

    /* renamed from: c, reason: collision with root package name */
    private String f77657c = "";

    /* renamed from: d, reason: collision with root package name */
    private String f77658d = "";

    /* renamed from: e, reason: collision with root package name */
    private String f77659e = "";

    /* renamed from: f, reason: collision with root package name */
    private String f77660f = "";

    /* renamed from: g, reason: collision with root package name */
    private boolean f77661g = true;

    /* renamed from: h, reason: collision with root package name */
    private String f77662h = "";

    e() {
    }

    private void H() {
        I();
        this.f77661g = com.tencent.beacon.base.net.b.d.d();
        this.f77662h = com.tencent.beacon.base.net.b.d.c();
    }

    private void I() {
        this.f77659e = J();
    }

    private String J() {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        TelephonyManager telephonyManager;
        Context b16 = c.c().b();
        if (b16 == null) {
            return "";
        }
        String str = "unknown";
        try {
            connectivityManager = (ConnectivityManager) b16.getSystemService("connectivity");
        } catch (Exception e16) {
            com.tencent.beacon.base.util.c.a(e16);
        }
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return "unknown";
        }
        if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
            str = "wifi";
        } else if (NetworkMonitor.getType(activeNetworkInfo) == 0 && (telephonyManager = (TelephonyManager) b16.getSystemService("phone")) != null) {
            int networkType = NetworkMonitor.getNetworkType(telephonyManager);
            if (networkType != 20) {
                switch (networkType) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        str = "2G";
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        str = "3G";
                        break;
                    case 13:
                        str = "4G";
                        break;
                    default:
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("unknown_");
                        sb5.append(NetworkMonitor.getNetworkType(telephonyManager));
                        str = sb5.toString();
                        break;
                }
            } else {
                str = "5G";
            }
        }
        com.tencent.beacon.base.util.c.a("[DeviceInfo] NetWork Type:" + str, new Object[0]);
        return str;
    }

    public static e l() {
        if (f77655a == null) {
            synchronized (e.class) {
                if (f77655a == null) {
                    f77655a = new e();
                }
            }
        }
        return f77655a;
    }

    public String A() {
        return "";
    }

    public String B() {
        return "";
    }

    public void C() {
        Context b16 = c.c().b();
        if (b16 == null) {
            return;
        }
        com.tencent.beacon.base.net.b.e.a(b16, this);
        H();
        D();
    }

    public void D() {
        String string = com.tencent.beacon.a.d.a.a().getString("BEACON_ANDROID_ID_DENGTA", "");
        this.f77656b = string;
        if (TextUtils.isEmpty(string)) {
            this.f77656b = com.tencent.beacon.base.util.b.a();
            a.SharedPreferencesEditorC0784a edit = com.tencent.beacon.a.d.a.a().edit();
            if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                edit.putString("BEACON_ANDROID_ID_DENGTA", this.f77656b);
            }
        }
    }

    public boolean E() {
        BufferedReader bufferedReader;
        boolean z16;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(RuntimeMonitor.exec(Runtime.getRuntime(), new String[]{"/system/bin/cat", "/proc/cpuinfo"}).getInputStream(), Charset.defaultCharset()));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (-1 != readLine.toLowerCase().indexOf("armv7")) {
                            z16 = true;
                            break;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        com.tencent.beacon.base.util.c.a(th);
                        com.tencent.beacon.base.util.b.a(bufferedReader);
                        return false;
                    } catch (Throwable th6) {
                        com.tencent.beacon.base.util.b.a(bufferedReader);
                        throw th6;
                    }
                }
            }
            com.tencent.beacon.base.util.b.a(bufferedReader);
            return z16;
        } catch (Throwable th7) {
            th = th7;
            bufferedReader = null;
        }
    }

    public String F() {
        String str;
        if (TextUtils.isEmpty(this.f77660f)) {
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                if (!HardwareInfoProvider.HARMONY_OS.equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]))) {
                    str = "N";
                } else {
                    str = "Y";
                }
                this.f77660f = str;
                return str;
            } catch (Throwable unused) {
                this.f77660f = "N";
            }
        }
        return this.f77660f;
    }

    public boolean G() {
        return this.f77661g;
    }

    public String a(Context context) {
        try {
            if (Integer.parseInt(Build.VERSION.SDK) < 9) {
                com.tencent.beacon.base.util.c.b("Api level < 9;return null!", new Object[0]);
                return "";
            }
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("get app_last_updated_time:");
            sb5.append(String.valueOf(packageInfo.lastUpdateTime));
            com.tencent.beacon.base.util.c.a(sb5.toString(), new Object[0]);
            return String.valueOf(packageInfo.lastUpdateTime);
        } catch (Throwable th5) {
            com.tencent.beacon.base.util.c.a(th5);
            com.tencent.beacon.base.util.c.b("get app_last_updated_time failed!", new Object[0]);
            return "";
        }
    }

    @Override // com.tencent.beacon.base.net.b.e.a
    public void b() {
        H();
    }

    public boolean c() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public String d() {
        return this.f77656b;
    }

    public int e() {
        BufferedReader bufferedReader;
        int i3;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(RuntimeMonitor.exec(Runtime.getRuntime(), new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"}).getInputStream(), Charset.forName("UTF-8")));
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                i3 = Integer.parseInt(readLine.trim()) / 1000;
            } else {
                i3 = 0;
            }
            com.tencent.beacon.base.util.b.a(bufferedReader);
            return i3;
        } catch (Throwable th6) {
            th = th6;
            try {
                com.tencent.beacon.base.util.c.a(th);
                com.tencent.beacon.base.util.b.a(bufferedReader);
                return 0;
            } catch (Throwable th7) {
                com.tencent.beacon.base.util.b.a(bufferedReader);
                throw th7;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003e, code lost:
    
        r0 = r1.substring(r1.indexOf(":") + 1).trim();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String f() {
        BufferedReader bufferedReader;
        String str = "";
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(RuntimeMonitor.exec(Runtime.getRuntime(), new String[]{"/system/bin/cat", "/proc/cpuinfo"}).getInputStream(), Charset.forName("UTF-8")));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (readLine.contains("Processor")) {
                        break;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        com.tencent.beacon.base.util.c.a(th);
                        com.tencent.beacon.base.util.b.a(bufferedReader);
                        return str;
                    } catch (Throwable th6) {
                        com.tencent.beacon.base.util.b.a(bufferedReader);
                        throw th6;
                    }
                }
            }
            com.tencent.beacon.base.util.b.a(bufferedReader);
        } catch (Throwable th7) {
            th = th7;
            bufferedReader = null;
        }
        return str;
    }

    public String g() {
        return Locale.getDefault().getCountry();
    }

    public String h() {
        return Build.HARDWARE;
    }

    public DisplayMetrics i() {
        Context b16 = c.c().b();
        if (b16 == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) b16.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    public long j() {
        Context b16 = c.c().b();
        if (b16 == null) {
            return -1L;
        }
        ActivityManager activityManager = (ActivityManager) b16.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager == null) {
            return -1L;
        }
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public String k() {
        long j3 = j();
        if (j3 > 0) {
            return ((j3 / 1024) / 1024) + "";
        }
        return "0";
    }

    public boolean m() {
        return com.tencent.beacon.base.util.d.d();
    }

    public String n() {
        return Locale.getDefault().getLanguage();
    }

    public String o() {
        return Build.MANUFACTURER;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:1|2|3|4|5|(8:(3:6|7|8)|16|17|19|20|21|22|23)|9|10|11|12|13|14|15|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(4:2|3|4|5)|(5:(8:(3:6|7|8)|16|17|19|20|21|22|23)|12|13|14|15)|9|10|11|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(8:(3:6|7|8)|16|17|19|20|21|22|23) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0099, code lost:
    
        r4 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009a, code lost:
    
        com.tencent.beacon.base.util.c.a("getNandInfo error", new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009f, code lost:
    
        com.tencent.beacon.base.util.b.a((java.io.Closeable[]) new java.io.Closeable[]{r4});
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0096, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0097, code lost:
    
        r4 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c3, code lost:
    
        r1 = new java.io.Closeable[r2];
        r1[0] = r4;
        com.tencent.beacon.base.util.b.a((java.io.Closeable[]) r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ca, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0066, code lost:
    
        com.tencent.beacon.base.util.c.a("getNandInfo error", new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006b, code lost:
    
        com.tencent.beacon.base.util.b.a((java.io.Closeable[]) new java.io.Closeable[]{r7});
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0065, code lost:
    
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0063, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String p() {
        ?? r56;
        ?? r75;
        StringBuilder sb5 = new StringBuilder();
        int i3 = 1;
        i3 = 1;
        String str = null;
        try {
            r56 = new BufferedReader(new FileReader(new File("/sys/block/mmcblk0/device/type")));
        } catch (Exception unused) {
            r56 = 0;
        } catch (Throwable th5) {
            th = th5;
            com.tencent.beacon.base.util.b.a((Closeable[]) new Closeable[]{str});
            throw th;
        }
        try {
            try {
                try {
                    try {
                        sb5.append(r56.readLine());
                        com.tencent.beacon.base.util.b.a((Closeable[]) new Closeable[]{r56});
                    } catch (Throwable th6) {
                        th = th6;
                        str = r56;
                        com.tencent.beacon.base.util.b.a((Closeable[]) new Closeable[]{str});
                        throw th;
                    }
                } catch (Exception unused2) {
                    com.tencent.beacon.base.util.c.a("getNandInfo error", new Object[0]);
                    com.tencent.beacon.base.util.b.a((Closeable[]) new Closeable[]{r56});
                    sb5.append(",");
                    r75 = new BufferedReader(new FileReader(new File("/sys/block/mmcblk0/device/name")));
                    sb5.append(r75.readLine());
                    com.tencent.beacon.base.util.b.a((Closeable[]) new Closeable[]{r75});
                    sb5.append(",");
                    ?? bufferedReader = new BufferedReader(new FileReader(new File("/sys/block/mmcblk0/device/cid")));
                    str = bufferedReader.readLine();
                    sb5.append(str);
                    com.tencent.beacon.base.util.b.a((Closeable[]) new Closeable[]{bufferedReader});
                    String sb6 = sb5.toString();
                    i3 = new Object[0];
                    com.tencent.beacon.base.util.c.a("[DeviceInfo] Nand Info:" + sb6, (Object[]) i3);
                    return sb6;
                }
                ?? bufferedReader2 = new BufferedReader(new FileReader(new File("/sys/block/mmcblk0/device/cid")));
                str = bufferedReader2.readLine();
                sb5.append(str);
                com.tencent.beacon.base.util.b.a((Closeable[]) new Closeable[]{bufferedReader2});
                String sb62 = sb5.toString();
                i3 = new Object[0];
                com.tencent.beacon.base.util.c.a("[DeviceInfo] Nand Info:" + sb62, (Object[]) i3);
                return sb62;
            } catch (Throwable th7) {
                th = th7;
            }
            sb5.append(r75.readLine());
            com.tencent.beacon.base.util.b.a((Closeable[]) new Closeable[]{r75});
            sb5.append(",");
        } catch (Throwable th8) {
            th = th8;
            str = r75;
            com.tencent.beacon.base.util.b.a((Closeable[]) new Closeable[]{str});
            throw th;
        }
        sb5.append(",");
        r75 = new BufferedReader(new FileReader(new File("/sys/block/mmcblk0/device/name")));
    }

    public String q() {
        return this.f77659e;
    }

    public String r() {
        return this.f77662h;
    }

    public int s() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new d(this));
            if (listFiles == null) {
                return 1;
            }
            return listFiles.length;
        } catch (Exception e16) {
            com.tencent.beacon.base.util.c.b("[model] CPU Count: Failed.", new Object[0]);
            com.tencent.beacon.base.util.c.a(e16);
            return 1;
        }
    }

    public String t() {
        if (!TextUtils.isEmpty(this.f77657c)) {
            return this.f77657c;
        }
        String str = "Android " + Build.VERSION.RELEASE + ",level " + Build.VERSION.SDK;
        this.f77657c = str;
        com.tencent.beacon.base.util.c.a("[DeviceInfo] os version: %s", str);
        return this.f77657c;
    }

    public String u() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String readLine;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
                try {
                    readLine = bufferedReader.readLine();
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        com.tencent.beacon.base.util.c.b("[model] get free RAM error!", new Object[0]);
                        com.tencent.beacon.base.util.c.a(th);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th6) {
                                com.tencent.beacon.base.util.c.b("[model] IO close error!", new Object[0]);
                                com.tencent.beacon.base.util.c.a(th6);
                            }
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        return null;
                    } catch (Throwable th7) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th8) {
                                com.tencent.beacon.base.util.c.b("[model] IO close error!", new Object[0]);
                                com.tencent.beacon.base.util.c.a(th8);
                                throw th7;
                            }
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        throw th7;
                    }
                }
            } catch (Throwable th9) {
                th = th9;
                bufferedReader = null;
            }
        } catch (Throwable th10) {
            th = th10;
            bufferedReader = null;
            fileReader = null;
        }
        if (readLine != null) {
            String str = (Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) / 1024) + "";
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (Throwable th11) {
                com.tencent.beacon.base.util.c.b("[model] IO close error!", new Object[0]);
                com.tencent.beacon.base.util.c.a(th11);
            }
            return str;
        }
        try {
            bufferedReader.close();
            fileReader.close();
        } catch (Throwable th12) {
            com.tencent.beacon.base.util.c.b("[model] IO close error!", new Object[0]);
            com.tencent.beacon.base.util.c.a(th12);
        }
        return null;
    }

    public String v() {
        DisplayMetrics i3 = i();
        if (i3 == null) {
            return "";
        }
        return i3.widthPixels + "*" + i3.heightPixels;
    }

    public String w() {
        ArrayList<String> a16 = com.tencent.beacon.base.util.b.a(new String[]{"/system/bin/sh", LogCmdOptions.CLEAR, "getprop ro.build.fingerprint"});
        if (a16 != null && a16.size() > 0) {
            return a16.get(0);
        }
        return "";
    }

    public String x() {
        if (!TextUtils.isEmpty(this.f77658d)) {
            return this.f77658d;
        }
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockSize = statFs.getBlockSize();
        this.f77658d = (((statFs.getBlockCount() * blockSize) / 1024) / 1024) + "";
        com.tencent.beacon.base.util.c.a("[DeviceInfo] Rom Size:" + this.f77658d, new Object[0]);
        return this.f77658d;
    }

    public long y() {
        if (!c()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((statFs.getBlockCount() * statFs.getBlockSize()) / 1024) / 1024;
        } catch (Throwable th5) {
            com.tencent.beacon.base.util.c.a(th5);
            return 0L;
        }
    }

    public int z() {
        Context b16 = c.c().b();
        if (b16 == null) {
            return -1;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) b16.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            double d16 = displayMetrics.density;
            if (d16 - 0.75d <= 1.0E-6d) {
                return 120;
            }
            if (d16 - 1.5d <= 1.0E-6d) {
                return 240;
            }
            if (d16 - 2.0d <= 1.0E-6d) {
                return 320;
            }
            if (d16 - 3.0d <= 1.0E-6d) {
                return 480;
            }
        }
        return 160;
    }

    @Override // com.tencent.beacon.base.net.b.e.a
    public void a() {
        H();
    }
}
