package com.tencent.biz.pubaccount.weishi.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    private static int f81793a = -1;

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, String> f81794b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private static final FileFilter f81795c = new a();

    /* compiled from: P */
    /* loaded from: classes32.dex */
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

    public static String c() {
        return Build.BRAND;
    }

    public static String g(Context context) {
        String jSONObject;
        Map<String, String> map = f81794b;
        synchronized (map) {
            if (map.isEmpty()) {
                map.put("model", i());
                map.put("brand", c());
                map.put("cpuMaxFreqMHz", String.valueOf(d() / 1000));
                map.put("cpuCoreNumber", String.valueOf(j()));
                map.put("cpuName", h());
                map.put("ram", String.valueOf(k(context)));
            }
            map.put("availRam", String.valueOf(b(context)));
            jSONObject = new JSONObject(map).toString();
        }
        return jSONObject;
    }

    public static String i() {
        return DeviceInfoMonitor.getModel();
    }

    private static int l() {
        int d16 = d() / 1000;
        if (d16 <= 1600) {
            return 0;
        }
        if (d16 <= 2000) {
            return 1;
        }
        return d16 <= 2500 ? 2 : 3;
    }

    private static int n(Context context) {
        long k3 = k(context) / 1048576;
        if (k3 <= 2000) {
            return 0;
        }
        if (k3 <= 3000) {
            return 1;
        }
        if (k3 <= 4000) {
            return 2;
        }
        return k3 <= 6000 ? 3 : 4;
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
                if (fileInputStream == null) {
                    return -1;
                }
                try {
                    fileInputStream.close();
                    return -1;
                } catch (IOException unused3) {
                    return -1;
                }
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

    public static String h() {
        FileReader fileReader;
        Exception e16;
        String str;
        Reader reader = null;
        try {
            try {
                try {
                    fileReader = new FileReader("/proc/cpuinfo");
                } catch (Exception e17) {
                    fileReader = null;
                    e16 = e17;
                } catch (Throwable th5) {
                    th = th5;
                    if (0 != 0) {
                        try {
                            reader.close();
                        } catch (Exception e18) {
                            e18.printStackTrace();
                        }
                    }
                    throw th;
                }
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
                } catch (Exception e19) {
                    e16 = e19;
                    e16.printStackTrace();
                    if (fileReader != null) {
                        fileReader.close();
                    }
                    return Build.HARDWARE;
                }
            } catch (Exception e26) {
                e26.printStackTrace();
            }
            if (str.contains("Hardware")) {
                String str2 = str.split(":\\s+", 2)[1];
                try {
                    fileReader.close();
                } catch (Exception e27) {
                    e27.printStackTrace();
                }
                return str2;
            }
            fileReader.close();
            return Build.HARDWARE;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static int j() {
        File[] listFiles;
        try {
            int e16 = e("/sys/devices/system/cpu/possible");
            if (e16 == -1) {
                e16 = e("/sys/devices/system/cpu/present");
            }
            if (e16 == -1) {
                File file = new File("/sys/devices/system/cpu/");
                if (file.exists() && (listFiles = file.listFiles(f81795c)) != null) {
                    return listFiles.length;
                }
            }
            return e16;
        } catch (NullPointerException | SecurityException unused) {
            return -1;
        }
    }

    private static int f(String str) {
        if (str == null || !str.matches("0-[\\d]+$")) {
            return -1;
        }
        return Integer.parseInt(str.substring(2)) + 1;
    }

    private static int o(String str, FileInputStream fileInputStream) {
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
        } catch (IOException unused) {
            return -1;
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    public static int d() {
        int i3 = -1;
        for (int i16 = 0; i16 < j(); i16++) {
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
                        int parseInt = Integer.parseInt(new String(bArr, 0, i17));
                        if (parseInt > i3) {
                            i3 = parseInt;
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
                int o16 = o("cpu MHz", fileInputStream2) * 1000;
                if (o16 > i3) {
                    i3 = o16;
                }
                fileInputStream2.close();
            } catch (Throwable th6) {
                fileInputStream2.close();
                throw th6;
            }
        }
        return i3;
    }

    public static int m(Context context) {
        if (context == null) {
            return -1;
        }
        int i3 = f81793a;
        if (i3 != -1) {
            return i3;
        }
        int n3 = n(context);
        int l3 = l();
        int i16 = 1;
        if (n3 < 1 && l3 == 0) {
            i16 = -2;
        } else if (n3 >= 2 && l3 != 0) {
            if (n3 != 2 || l3 < 1) {
                if (n3 > 2) {
                    if (l3 > 1) {
                        i16 = 3;
                    }
                }
            }
            i16 = 2;
        }
        f81793a = i16;
        return i16;
    }

    public static long b(Context context) {
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

    public static long k(Context context) {
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
}
