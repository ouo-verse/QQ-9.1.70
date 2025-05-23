package com.tencent.mobileqq.qqaudio;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f262216a;

    /* renamed from: b, reason: collision with root package name */
    public static String f262217b;

    /* renamed from: c, reason: collision with root package name */
    public static String f262218c;

    /* renamed from: d, reason: collision with root package name */
    public static String f262219d;

    /* renamed from: e, reason: collision with root package name */
    public static int f262220e;

    /* renamed from: f, reason: collision with root package name */
    public static long f262221f;

    /* renamed from: g, reason: collision with root package name */
    public static int f262222g;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f262223h;

    /* renamed from: i, reason: collision with root package name */
    public static long f262224i;

    /* renamed from: j, reason: collision with root package name */
    private static String f262225j;

    /* renamed from: k, reason: collision with root package name */
    public static boolean f262226k;

    /* renamed from: l, reason: collision with root package name */
    public static int f262227l;

    /* renamed from: m, reason: collision with root package name */
    public static int f262228m;

    /* renamed from: n, reason: collision with root package name */
    public static boolean f262229n;

    /* renamed from: o, reason: collision with root package name */
    public static boolean f262230o;

    /* renamed from: p, reason: collision with root package name */
    public static boolean f262231p;

    /* renamed from: q, reason: collision with root package name */
    static int f262232q;

    /* renamed from: r, reason: collision with root package name */
    static long f262233r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements FileFilter {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file)).booleanValue();
            }
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36803);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f262216a = "";
        f262217b = "";
        f262218c = null;
        f262219d = null;
        f262220e = 5;
        f262221f = 0L;
        f262222g = 1;
        f262223h = false;
        f262224i = 0L;
        f262226k = false;
        f262227l = 2;
        f262228m = 1;
        f262229n = true;
        f262230o = true;
        f262231p = false;
        d();
        f262232q = 0;
        f262233r = 0L;
    }

    protected static long a(long j3, String str) {
        int indexOf = str.indexOf(58);
        if (indexOf > 1) {
            try {
                long parseLong = Long.parseLong(str.substring(indexOf + 1, str.length()).trim());
                if (parseLong >= 0) {
                    long j16 = parseLong + 1;
                    if (j16 > j3) {
                        return j16;
                    }
                    return j3;
                }
                return j3;
            } catch (NumberFormatException unused) {
                return j3;
            }
        }
        return j3;
    }

    protected static float b(float f16, String str) {
        int indexOf = str.indexOf(58);
        if (indexOf > 1) {
            try {
                float parseFloat = Float.parseFloat(str.substring(indexOf + 1, str.length()).trim());
                if (parseFloat > f16) {
                    return parseFloat;
                }
                return f16;
            } catch (NumberFormatException unused) {
                return f16;
            }
        }
        return f16;
    }

    public static int c() {
        d();
        return f262228m;
    }

    public static void d() {
        if (!f262223h) {
            StringBuilder sb5 = new StringBuilder(1024);
            BufferedReader bufferedReader = null;
            long j3 = -1;
            float f16 = -1.0f;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/cpuinfo"));
                while (true) {
                    try {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            if (readLine.startsWith("Hardware")) {
                                h(readLine);
                            } else if (readLine.startsWith("Processor")) {
                                n(sb5, readLine);
                            } else if (!readLine.startsWith("CPU architecture")) {
                                if (readLine.startsWith("Features")) {
                                    int indexOf = readLine.indexOf(58);
                                    if (indexOf > 1) {
                                        f262217b = readLine.substring(indexOf + 1, readLine.length()).trim();
                                    }
                                    if (QLog.isColorLevel()) {
                                        sb5.append("[CpuInfo] mFeature=");
                                        sb5.append(f262217b);
                                        sb5.append(APLogFileUtil.SEPARATOR_LOG);
                                        sb5.append(readLine);
                                        sb5.append("\n");
                                    }
                                } else if (readLine.startsWith("vendor_id")) {
                                    int indexOf2 = readLine.indexOf(58);
                                    if (indexOf2 > 1) {
                                        f262218c = readLine.substring(indexOf2 + 1, readLine.length()).trim();
                                    }
                                    if (QLog.isColorLevel()) {
                                        sb5.append("[CpuInfo] mVendorId=");
                                        sb5.append(f262218c);
                                        sb5.append(APLogFileUtil.SEPARATOR_LOG);
                                        sb5.append(readLine);
                                        sb5.append("\n");
                                    }
                                } else if (readLine.startsWith("Hardware")) {
                                    f262219d = readLine.trim();
                                    if (readLine.contains("PXA")) {
                                        f262231p = true;
                                    }
                                    if (QLog.isColorLevel()) {
                                        sb5.append("[CpuInfo] mIsMarvell=");
                                        sb5.append(f262231p);
                                        sb5.append(APLogFileUtil.SEPARATOR_LOG);
                                        sb5.append(readLine);
                                        sb5.append("\n");
                                    }
                                } else if (readLine.startsWith("processor")) {
                                    j3 = a(j3, readLine);
                                } else if (readLine.startsWith("BogoMIPS")) {
                                    f16 = b(f16, readLine);
                                }
                            } else {
                                m(sb5, readLine);
                            }
                        } catch (FileNotFoundException | IOException | NumberFormatException unused) {
                            bufferedReader = bufferedReader2;
                            o(bufferedReader);
                            g(j3, f16, sb5);
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedReader = bufferedReader2;
                        o(bufferedReader);
                        throw th;
                    }
                }
                f262223h = true;
                o(bufferedReader2);
            } catch (FileNotFoundException | IOException | NumberFormatException unused2) {
            } catch (Throwable th6) {
                th = th6;
            }
            g(j3, f16, sb5);
        }
    }

    public static long e() {
        d();
        if (QLog.isColorLevel()) {
            QLog.i("QQAudioSystemInfo", 2, "getMaxCpuFreq: " + Build.BRAND + "|" + DeviceInfoMonitor.getModel() + "|" + f262221f);
        }
        return f262221f;
    }

    public static int f() {
        d();
        return f262222g;
    }

    protected static void g(long j3, float f16, StringBuilder sb5) {
        int l3 = l();
        if (l3 > 0) {
            f262222g = l3;
            if (QLog.isColorLevel()) {
                sb5.append("[CpuInfo] mCoreNumber=");
                sb5.append(f262222g);
                sb5.append("\n");
            }
        } else if (j3 > 0) {
            f262222g = (int) j3;
            if (QLog.isColorLevel()) {
                sb5.append("[CpuInfo] mCoreNumber(bogoCoreNum)=");
                sb5.append(f262222g);
                sb5.append("\n");
            }
        }
        long j16 = j();
        if (j16 > 0) {
            f262221f = j16;
            if (QLog.isColorLevel()) {
                sb5.append("[CpuInfo] mMaxCpuFreq=");
                sb5.append(f262221f);
                sb5.append("\n");
            }
        } else if (f16 > 0.0f) {
            if (f16 < 1200.0f) {
                f262221f = (long) (f16 * 1.2d * 1000.0d);
            } else if (f16 > 2000.0f) {
                f262221f = (long) ((f16 / 1.8d) * 1000.0d);
            } else {
                f262221f = f16 * 1000.0f;
            }
            if (QLog.isColorLevel()) {
                sb5.append("[CpuInfo] mMaxCpuFreq(bogoMIPS)=");
                sb5.append(f262221f);
                sb5.append("\n");
            }
        }
        if (f262222g > 0 && f262221f > 0) {
            f262223h = true;
        } else {
            if (QLog.isColorLevel()) {
                sb5.append("[CpuInfo] read cpu info fail because of coreNumber= ");
                sb5.append(f262222g);
                sb5.append(" or maxCpuFreq=");
                sb5.append(f262221f);
                sb5.append("\n");
            }
            f262223h = false;
        }
        f262228m = i();
        if (QLog.isColorLevel()) {
            sb5.append("[CpuInfo] Chip=");
            sb5.append(f262228m);
            sb5.append(", Video=");
            sb5.append(f262230o);
            sb5.append(", Audio=");
            sb5.append(f262229n);
            sb5.append("\n");
            QLog.i("QQAudioSystemInfo", 2, "QQAudioSystemInfo: " + sb5.toString());
        }
    }

    protected static void h(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf > 1) {
            f262225j = str.substring(indexOf + 1, str.length()).trim().replace(" ", "");
        }
    }

    static int i() {
        if (f262216a.contains("ARMv6")) {
            return 2;
        }
        String str = Build.CPU_ABI;
        if (str.equalsIgnoreCase("armeabi-v7a")) {
            return 4;
        }
        if (str.equalsIgnoreCase("armeabi")) {
            return 2;
        }
        if (f262220e == 7 && f262217b.indexOf("neon") < 0) {
            long e16 = e();
            int f16 = f();
            if (e16 < 1100000 || f16 < 2) {
                return 3;
            }
        }
        if (str.equalsIgnoreCase(ResourceAttributes.HostArchValues.X86)) {
            return 7;
        }
        int i3 = f262220e;
        if (i3 != 5) {
            if (i3 == 6) {
                return 2;
            }
            if (i3 == 7) {
                return 4;
            }
            if (i3 == 8) {
                return 5;
            }
            String str2 = f262218c;
            if (str2 != null && (str2.equalsIgnoreCase("AuthenticAMD") || f262218c.equalsIgnoreCase("GenuineIntel"))) {
                return 7;
            }
            return 0;
        }
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static long j() {
        if (f262222g < 1) {
            if (QLog.isColorLevel()) {
                QLog.i("QQAudioSystemInfo", 2, "QQAudioSystemInfo [CpuInfo] Use default core number 8");
            }
            f262222g = 8;
        }
        boolean z16 = false;
        long j3 = 0;
        long j16 = 0;
        for (int i3 = 0; i3 < f262222g; i3++) {
            BufferedReader bufferedReader = null;
            try {
                try {
                    String str = "";
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu" + i3 + "/cpufreq/cpuinfo_max_freq"));
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (!TextUtils.isEmpty(readLine)) {
                            str = readLine.trim();
                        }
                        if (str != null && str.length() > 0) {
                            j3 = Long.parseLong(str);
                        }
                        try {
                            bufferedReader2.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                    } catch (Exception e17) {
                        e = e17;
                        bufferedReader = bufferedReader2;
                        QLog.e("QQAudioSystemInfo", 2, "getMaxCpuFreq of cup" + i3 + " failed.\n" + e.toString());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        z16 = true;
                        j3 = 0;
                        if (j3 > j16) {
                        }
                        if (!QLog.isColorLevel()) {
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e19) {
                                e19.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e26) {
                    e = e26;
                }
                if (j3 > j16) {
                    j16 = j3;
                }
                if (!QLog.isColorLevel()) {
                    QLog.i("QQAudioSystemInfo", 2, "[CpuInfo] readMaxCpuFreq core " + i3 + "  maxFreq  " + j3 + "  thisMaxFreq  " + j16);
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
        if (z16) {
            long k3 = k();
            if (k3 > j3) {
                j16 = k3;
            }
        }
        QLog.i("QQAudioSystemInfo", 2, "[CpuInfo] readMaxCpuFreq end. thisMaxFreq  " + j16);
        return j16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x004c -> B:28:0x0075). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static long k() {
        BufferedReader bufferedReader;
        Exception e16;
        String str;
        int indexOf;
        long j3 = 0;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpufreq/all_time_in_state"));
                do {
                    try {
                        try {
                            str = bufferedReader2;
                            bufferedReader2 = bufferedReader.readLine();
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedReader2 = bufferedReader;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e17) {
                                    e17.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e18) {
                        e16 = e18;
                        QLog.e("QQAudioSystemInfo", 2, "readMaxCpuFreqFromState failed.\n" + e16.toString());
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        QLog.i("QQAudioSystemInfo", 2, "[CpuInfo] readMaxCpuFreqFromState. maxFreq=" + j3);
                        return j3;
                    }
                } while (bufferedReader2 != null);
                if (str == 0) {
                    indexOf = -1;
                } else {
                    indexOf = str.indexOf(9);
                }
                if (indexOf != -1) {
                    if (str == 0) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                        return 0L;
                    }
                    String substring = str.substring(0, indexOf);
                    if (substring != null && substring.length() > 0) {
                        j3 = Long.parseLong(substring);
                    }
                }
                bufferedReader.close();
            } catch (Exception e26) {
                bufferedReader = null;
                e16 = e26;
            } catch (Throwable th6) {
                th = th6;
                if (bufferedReader2 != null) {
                }
                throw th;
            }
        } catch (IOException e27) {
            e27.printStackTrace();
        }
        QLog.i("QQAudioSystemInfo", 2, "[CpuInfo] readMaxCpuFreqFromState. maxFreq=" + j3);
        return j3;
    }

    static int l() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new a());
            if (listFiles == null) {
                QLog.e("QQAudioSystemInfo", 1, "readNumCores files is null");
                return 0;
            }
            return listFiles.length;
        } catch (Exception unused) {
            return 0;
        }
    }

    protected static void m(StringBuilder sb5, String str) {
        String trim;
        int indexOf = str.indexOf(58);
        if (indexOf > 1 && (trim = str.substring(indexOf + 1, str.length()).trim()) != null && trim.length() > 0) {
            if (trim.equalsIgnoreCase("aarch64")) {
                f262220e = 8;
            } else {
                try {
                    f262220e = (int) Long.parseLong(trim);
                } catch (NumberFormatException unused) {
                    for (int i3 = 1; i3 < trim.length(); i3++) {
                        try {
                            f262220e = (int) Long.parseLong(trim.substring(0, trim.length() - i3));
                            break;
                        } catch (NumberFormatException unused2) {
                        }
                    }
                }
            }
        }
        if (str.contains("5TE")) {
            f262220e = 5;
        }
        if (QLog.isColorLevel()) {
            sb5.append("[CpuInfo] mCpuArchitecture=");
            sb5.append(f262220e);
            sb5.append(APLogFileUtil.SEPARATOR_LOG);
            sb5.append(str);
            sb5.append("\n");
        }
    }

    protected static void n(StringBuilder sb5, String str) {
        int indexOf = str.indexOf(58);
        if (indexOf > 1) {
            String substring = str.substring(indexOf + 1, str.length());
            f262216a = substring;
            f262216a = substring.trim();
            if (QLog.isColorLevel()) {
                sb5.append("[CpuInfo] mProcessorName=");
                sb5.append(f262216a);
                sb5.append(APLogFileUtil.SEPARATOR_LOG);
                sb5.append(str);
                sb5.append("\n");
            }
        }
    }

    protected static void o(BufferedReader bufferedReader) {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }
}
