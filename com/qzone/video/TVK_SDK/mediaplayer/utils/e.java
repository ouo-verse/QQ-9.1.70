package com.qzone.video.TVK_SDK.mediaplayer.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes37.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static String f59899a = "N/A";

    /* renamed from: b, reason: collision with root package name */
    public static String f59900b = "";

    /* renamed from: c, reason: collision with root package name */
    public static String f59901c = "";

    /* renamed from: d, reason: collision with root package name */
    public static int f59902d = 0;

    /* renamed from: e, reason: collision with root package name */
    private static int f59903e = 0;

    /* renamed from: f, reason: collision with root package name */
    private static int f59904f = -1;

    /* renamed from: g, reason: collision with root package name */
    private static int f59905g = -1;

    /* renamed from: h, reason: collision with root package name */
    private static String f59906h;

    /* renamed from: i, reason: collision with root package name */
    private static final String f59907i = Environment.getDataDirectory() + "/data/";

    /* renamed from: j, reason: collision with root package name */
    private static int f59908j = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f59906h)) {
            return f59906h;
        }
        if (context == null) {
            return "";
        }
        try {
            String str = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
            f59906h = str;
            return str == null ? "" : str;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int b() {
        int i3 = f59905g;
        if (-1 != i3) {
            return i3;
        }
        String str = Build.CPU_ABI;
        if (str != null && (str.contains(ResourceAttributes.HostArchValues.X86) || str.contains("X86"))) {
            f59905g = 1;
        } else if (str != null && (str.contains("mips") || str.contains("Mips"))) {
            f59905g = 2;
        } else {
            if (f59902d == 0) {
                c();
            }
            if (!TextUtils.isEmpty(f59901c) && f59901c.contains("MSM8994")) {
                f59905g = 7;
                return 7;
            }
            if (!e().equals("XT882") && !e().equals("ME860") && !e().equals("MB860") && !e().equals("Lenovo P70") && !e().equals("Lenovo A60") && !e().equals("Lenovo A366t")) {
                if (!TextUtils.isEmpty(f59899a) && f59899a.contains("ARMv6")) {
                    f59905g = 4;
                    return 4;
                }
                if (!TextUtils.isEmpty(f59900b) && !f59900b.contains("neon")) {
                    f59905g = 4;
                    return 4;
                }
                int i16 = f59902d;
                if (i16 != 64) {
                    switch (i16) {
                        case 5:
                            f59905g = 3;
                            break;
                        case 6:
                            f59905g = 4;
                            break;
                        case 7:
                            f59905g = 6;
                            break;
                        case 8:
                        case 9:
                        case 10:
                            f59905g = 50;
                            break;
                        default:
                            f59905g = 0;
                            break;
                    }
                } else {
                    f59905g = 7;
                }
            } else {
                f59905g = 3;
                return 3;
            }
        }
        return f59905g;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x009e, code lost:
    
        if (r2.length() <= 1) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a0, code lost:
    
        com.qzone.video.TVK_SDK.mediaplayer.utils.e.f59902d = (int) java.lang.Long.parseLong(r2.substring(0, 1));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c() {
        BufferedReader bufferedReader;
        int indexOf;
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
                                f59902d = 64;
                            }
                            if (readLine.startsWith("Processor")) {
                                int indexOf2 = readLine.indexOf(58);
                                if (indexOf2 > 1) {
                                    String substring = readLine.substring(indexOf2 + 1, readLine.length());
                                    f59899a = substring;
                                    f59899a = substring.trim();
                                }
                            } else if (readLine.startsWith("CPU architecture")) {
                                if (f59902d == 0) {
                                    String trim = readLine.substring(readLine.indexOf(58) + 1, readLine.length()).trim();
                                    if (trim != null && trim.length() > 0 && trim.length() < 2) {
                                        f59902d = (int) Long.parseLong(trim);
                                    }
                                }
                            } else if (readLine.startsWith("Features")) {
                                int indexOf3 = readLine.indexOf(58);
                                if (indexOf3 > 1) {
                                    f59900b = readLine.substring(indexOf3 + 1, readLine.length()).trim();
                                }
                            } else if (readLine.startsWith("Hardware") && (indexOf = readLine.indexOf(58)) > 1) {
                                f59901c = readLine.substring(indexOf + 1, readLine.length()).trim();
                            }
                        } catch (Throwable unused) {
                            inputStreamReader = inputStreamReader2;
                            try {
                                f59901c = "Unknown";
                                f59902d = 0;
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
                                        b.a("VcSystemInfo", e16);
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
            b.a("VcSystemInfo", e17);
        }
    }

    public static long d() {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        IOException e16;
        FileNotFoundException e17;
        InputStreamReader inputStreamReader2 = null;
        try {
            try {
                inputStreamReader = new InputStreamReader(new FileInputStream("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"), "UTF-8");
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            inputStreamReader.close();
                            bufferedReader.close();
                            try {
                                inputStreamReader.close();
                                bufferedReader.close();
                                return 0L;
                            } catch (Throwable th5) {
                                b.a("VcSystemInfo", th5);
                                return 0L;
                            }
                        }
                        String trim = readLine.trim();
                        long parseLong = (trim == null || trim.length() <= 0) ? 0L : Long.parseLong(trim);
                        try {
                            inputStreamReader.close();
                            bufferedReader.close();
                            return parseLong;
                        } catch (Throwable th6) {
                            b.a("VcSystemInfo", th6);
                            return 0L;
                        }
                    } catch (FileNotFoundException e18) {
                        e17 = e18;
                        b.a("VcSystemInfo", e17);
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (Throwable th7) {
                                b.a("VcSystemInfo", th7);
                                return 0L;
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return 0L;
                    } catch (IOException e19) {
                        e16 = e19;
                        b.a("VcSystemInfo", e16);
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (Throwable th8) {
                                b.a("VcSystemInfo", th8);
                                return 0L;
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return 0L;
                    } catch (Throwable unused) {
                        inputStreamReader2 = inputStreamReader;
                        if (inputStreamReader2 != null) {
                            try {
                                inputStreamReader2.close();
                            } catch (Throwable th9) {
                                b.a("VcSystemInfo", th9);
                                return 0L;
                            }
                        }
                        if (bufferedReader == null) {
                            return 0L;
                        }
                        bufferedReader.close();
                        return 0L;
                    }
                } catch (FileNotFoundException e26) {
                    bufferedReader = null;
                    e17 = e26;
                } catch (IOException e27) {
                    bufferedReader = null;
                    e16 = e27;
                } catch (Throwable unused2) {
                    bufferedReader = null;
                }
            } catch (FileNotFoundException e28) {
                inputStreamReader = null;
                e17 = e28;
                bufferedReader = null;
            } catch (IOException e29) {
                inputStreamReader = null;
                e16 = e29;
                bufferedReader = null;
            } catch (Throwable unused3) {
                bufferedReader = null;
            }
        } catch (Throwable th10) {
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (Throwable th11) {
                    b.a("VcSystemInfo", th11);
                    return 0L;
                }
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th10;
        }
    }

    public static String e() {
        return DeviceInfoMonitor.getModel();
    }

    public static String f(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        String packageName = context.getPackageName();
        try {
            String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory() + "/");
            File file = new File(sDKPrivatePath + packageName + "/");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(sDKPrivatePath + packageName + "/guid");
            if (file2.exists()) {
                str = k(file2);
            }
        } catch (Throwable unused) {
        }
        return str == null ? "" : str;
    }

    public static String g(Context context) {
        if (context == null) {
            return "";
        }
        String packageName = context.getPackageName();
        String str = null;
        try {
            StringBuilder sb5 = new StringBuilder();
            String str2 = f59907i;
            sb5.append(str2);
            sb5.append(packageName);
            sb5.append("/");
            File file = new File(sb5.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(str2 + packageName + "/guid");
            if (file2.exists()) {
                str = k(file2);
            }
        } catch (Throwable unused) {
        }
        return str == null ? "" : str;
    }

    public static String h(Context context) {
        if (context == null) {
            return "";
        }
        try {
            String packageName = context.getPackageName();
            String g16 = g(context);
            try {
                if (TextUtils.isEmpty(g16)) {
                    g16 = f(context);
                    if (!TextUtils.isEmpty(g16)) {
                        l(packageName, g16);
                    }
                }
            } catch (Exception unused) {
            }
            if (g16 == null) {
                return "";
            }
            if (g16.equals("guiderror")) {
                return "";
            }
            return g16;
        } catch (Exception unused2) {
            return "";
        }
    }

    public static int i() {
        int i3 = f59904f;
        if (-1 != i3) {
            return i3;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new a());
            if (listFiles == null) {
                f59904f = 1;
                return 1;
            }
            int length = listFiles.length;
            f59904f = length;
            return length;
        } catch (Exception e16) {
            b.a("VcSystemInfo", e16);
            f59904f = 1;
            return 1;
        }
    }

    public static int j() {
        int i3 = f59903e;
        if (i3 != 0) {
            return i3;
        }
        f59903e = 11;
        if (b() < 6) {
            f59903e = 1;
        }
        if (i() == 1 && d() / 1000 <= 1000) {
            f59903e = 6;
        }
        if ((i() == 1 && d() / 1000 > 1000) || (i() == 2 && d() / 1000 < 1400)) {
            f59903e = 11;
        }
        if (i() == 2 && d() / 1000 >= 1400) {
            f59903e = 16;
        }
        if (i() >= 4) {
            f59903e = 21;
        }
        return f59903e;
    }

    private static void l(String str, String str2) {
        m(f59907i + str + "/guid", str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0035, code lost:
    
        if (r1 == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String k(File file) throws FileNotFoundException {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        r0 = null;
        r0 = null;
        String str = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e16) {
            e = e16;
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            if (file.length() <= TTL.MAX_VALUE) {
                char[] cArr = new char[(int) file.length()];
                bufferedReader.read(cArr, 0, (int) file.length());
                str = new String(cArr);
            }
        } catch (FileNotFoundException e17) {
            e = e17;
            bufferedReader2 = bufferedReader;
            try {
                throw e;
            } catch (Throwable th5) {
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th5;
            }
        } catch (Throwable unused3) {
        }
        try {
            bufferedReader.close();
        } catch (Throwable unused4) {
            return str;
        }
    }

    public static void m(String str, String str2) {
        FileWriter fileWriter = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.createNewFile();
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
                    } catch (IOException unused2) {
                    }
                }
            }
        } catch (Throwable unused3) {
        }
    }
}
