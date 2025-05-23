package com.tencent.mobileqq.statistics.cpu;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AbiUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: o, reason: collision with root package name */
    public static int f289958o;

    /* renamed from: p, reason: collision with root package name */
    public static int f289959p;

    /* renamed from: q, reason: collision with root package name */
    public static int f289960q;

    /* renamed from: r, reason: collision with root package name */
    public static int f289961r;

    /* renamed from: s, reason: collision with root package name */
    public static int f289962s;

    /* renamed from: a, reason: collision with root package name */
    int f289963a;

    /* renamed from: b, reason: collision with root package name */
    String f289964b;

    /* renamed from: c, reason: collision with root package name */
    String f289965c;

    /* renamed from: d, reason: collision with root package name */
    int f289966d;

    /* renamed from: e, reason: collision with root package name */
    int f289967e;

    /* renamed from: f, reason: collision with root package name */
    int f289968f;

    /* renamed from: g, reason: collision with root package name */
    String f289969g;

    /* renamed from: h, reason: collision with root package name */
    int f289970h;

    /* renamed from: i, reason: collision with root package name */
    String f289971i;

    /* renamed from: j, reason: collision with root package name */
    String f289972j;

    /* renamed from: k, reason: collision with root package name */
    String f289973k;

    /* renamed from: l, reason: collision with root package name */
    int f289974l;

    /* renamed from: m, reason: collision with root package name */
    long f289975m;

    /* renamed from: n, reason: collision with root package name */
    boolean f289976n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.statistics.cpu.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public class C8616a implements FileFilter {
        static IPatchRedirector $redirector_;

        C8616a() {
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
            if (Pattern.matches("cpu[0-9]", file.getName())) {
                return true;
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75440);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f289958o = 1;
        f289959p = 2;
        f289960q = 4;
        f289961r = 8;
        f289962s = 16;
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f289963a = 0;
        this.f289969g = "";
        this.f289971i = "";
        this.f289972j = "";
        this.f289973k = "";
    }

    public static boolean b() {
        int i3;
        int i16;
        int i17;
        int i18;
        int d16 = d(Build.CPU_ABI);
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr != null) {
            i3 = 0;
            for (String str : strArr) {
                i3 |= d(str);
            }
        } else {
            i3 = 0;
        }
        int i19 = f289961r;
        if (d16 == i19 || (i3 & i19) == i19 || d16 == (i16 = f289962s) || (i3 & i16) == i16) {
            return false;
        }
        int i26 = f289960q;
        if (d16 != i26 && (i3 & i26) != i26 && d16 != (i17 = f289959p) && (i3 & i17) != i17 && d16 != (i18 = f289958o) && (i3 & i18) != i18) {
            return false;
        }
        return true;
    }

    private static int d(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if ("arm64-v8a".equalsIgnoreCase(str)) {
            return f289960q;
        }
        if ("armeabi-v7a".equalsIgnoreCase(str)) {
            return f289959p;
        }
        if (!"armeabi".equalsIgnoreCase(str) && str.indexOf(AbiUtil.ARM) < 0) {
            if (!ResourceAttributes.HostArchValues.X86.equalsIgnoreCase(str) && str.indexOf(ResourceAttributes.HostArchValues.X86) < 0) {
                if (!"mips".equalsIgnoreCase(str) && str.indexOf("mips") < 0) {
                    return 0;
                }
                return f289962s;
            }
            return f289961r;
        }
        return f289958o;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x01a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void e() {
        String trim;
        int indexOf;
        if (this.f289976n) {
            return;
        }
        BufferedReader bufferedReader = null;
        long j3 = -1;
        float f16 = -1.0f;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/cpuinfo"));
                while (true) {
                    try {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            if (readLine.startsWith("Processor")) {
                                int indexOf2 = readLine.indexOf(58);
                                if (indexOf2 > 1) {
                                    String substring = readLine.substring(indexOf2 + 1, readLine.length());
                                    this.f289969g = substring;
                                    String trim2 = substring.trim();
                                    this.f289969g = trim2;
                                    this.f289969g = trim2.toLowerCase(Locale.US);
                                }
                            } else if (readLine.startsWith("CPU architecture")) {
                                int indexOf3 = readLine.indexOf(58);
                                if (indexOf3 > 1 && (trim = readLine.substring(indexOf3 + 1, readLine.length()).trim()) != null && trim.length() > 0) {
                                    if (trim.equalsIgnoreCase("aarch64")) {
                                        this.f289970h = 8;
                                    } else {
                                        try {
                                            this.f289970h = (int) Long.parseLong(trim);
                                        } catch (NumberFormatException unused) {
                                            for (int i3 = 1; i3 < trim.length(); i3++) {
                                                try {
                                                    this.f289970h = (int) Long.parseLong(trim.substring(0, trim.length() - i3));
                                                    break;
                                                } catch (NumberFormatException unused2) {
                                                }
                                            }
                                        }
                                    }
                                }
                                if (readLine.contains("5TE")) {
                                    this.f289970h = 5;
                                }
                            } else if (readLine.startsWith("Features")) {
                                int indexOf4 = readLine.indexOf(58);
                                if (indexOf4 > 1) {
                                    String trim3 = readLine.substring(indexOf4 + 1, readLine.length()).trim();
                                    this.f289971i = trim3;
                                    this.f289971i = trim3.toLowerCase(Locale.US);
                                }
                            } else if (readLine.startsWith("vendor_id")) {
                                int indexOf5 = readLine.indexOf(58);
                                if (indexOf5 > 1) {
                                    this.f289972j = readLine.substring(indexOf5 + 1, readLine.length()).trim();
                                }
                            } else if (readLine.startsWith("Hardware")) {
                                this.f289973k = readLine.trim();
                            } else if (readLine.startsWith("processor")) {
                                int indexOf6 = readLine.indexOf(58);
                                if (indexOf6 > 1) {
                                    try {
                                        long parseLong = Long.parseLong(readLine.substring(indexOf6 + 1, readLine.length()).trim());
                                        if (parseLong >= 0) {
                                            long j16 = parseLong + 1;
                                            if (j16 > j3) {
                                                j3 = j16;
                                            }
                                        }
                                    } catch (NumberFormatException unused3) {
                                    }
                                }
                            } else if (readLine.startsWith("BogoMIPS") && (indexOf = readLine.indexOf(58)) > 1) {
                                float parseFloat = Float.parseFloat(readLine.substring(indexOf + 1, readLine.length()).trim());
                                if (parseFloat > f16) {
                                    f16 = parseFloat;
                                }
                            }
                        } catch (FileNotFoundException unused4) {
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (this.f289976n) {
                            }
                        } catch (IOException unused5) {
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (this.f289976n) {
                            }
                        } catch (Exception unused6) {
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (this.f289976n) {
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e16) {
                                    e16.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (NumberFormatException unused7) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (this.f289976n) {
                        }
                    }
                }
                this.f289976n = true;
                bufferedReader2.close();
            } catch (FileNotFoundException unused8) {
            } catch (IOException unused9) {
            } catch (NumberFormatException unused10) {
            } catch (Exception unused11) {
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e17) {
            e17.printStackTrace();
        }
        if (this.f289976n) {
            try {
                int h16 = h();
                if (h16 > 0) {
                    this.f289974l = h16;
                } else if (j3 > 0) {
                    this.f289974l = (int) j3;
                }
                long f17 = f();
                if (f17 > 0) {
                    this.f289975m = f17;
                    return;
                }
                if (f16 > 0.0f) {
                    if (f16 < 1200.0f) {
                        this.f289975m = (long) (f16 * 1.2d * 1000.0d);
                    } else if (f16 > 2000.0f) {
                        this.f289975m = (long) ((f16 / 1.8d) * 1000.0d);
                    } else {
                        this.f289975m = f16 * 1000.0f;
                    }
                }
            } catch (Exception e18) {
                e18.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long f() {
        if (this.f289974l < 1) {
            if (QLog.isColorLevel()) {
                QLog.d("CPUReport", 2, "[CpuInfo] Use default core number 8");
            }
            this.f289974l = 8;
        }
        boolean z16 = false;
        long j3 = 0;
        long j16 = 0;
        for (int i3 = 0; i3 < this.f289974l; i3++) {
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
                        QLog.e("CPUReport", 1, "getMaxCpuFreq of cup" + i3 + " failed.\n" + e.toString());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        z16 = true;
                        j3 = 0;
                        if (j3 <= j16) {
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
                if (j3 <= j16) {
                    j16 = j3;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
        if (z16) {
            long g16 = g();
            if (g16 > j3) {
                return g16;
            }
            return j16;
        }
        return j16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0041 -> B:20:0x006e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static long g() {
        BufferedReader bufferedReader;
        Exception e16;
        String str;
        int indexOf;
        String substring;
        long j3 = 0;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpufreq/all_time_in_state"));
            } catch (Exception e17) {
                bufferedReader = null;
                e16 = e17;
            } catch (Throwable th5) {
                th = th5;
                if (bufferedReader2 != null) {
                }
                throw th;
            }
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    while (true) {
                        String str2 = readLine;
                        str = bufferedReader2;
                        bufferedReader2 = str2;
                        if (bufferedReader2 == null) {
                            break;
                        }
                        readLine = bufferedReader.readLine();
                    }
                    if (str == 0) {
                        indexOf = -1;
                    } else {
                        indexOf = str.indexOf(9);
                    }
                    if (indexOf != -1 && (substring = str.substring(0, indexOf)) != null && substring.length() > 0) {
                        j3 = Long.parseLong(substring);
                    }
                    bufferedReader.close();
                } catch (Throwable th6) {
                    th = th6;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e19) {
                e16 = e19;
                QLog.e("CPUReport", 1, "readMaxCpuFreqFromState failed.\n" + e16.toString());
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return j3;
            }
        } catch (IOException e26) {
            e26.printStackTrace();
        }
        return j3;
    }

    static int h() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new C8616a()).length;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x00a9, code lost:
    
        if ((r2 & r3) != r3) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder(1024);
        this.f289966d = d(Build.CPU_ABI);
        this.f289967e = d(Build.CPU_ABI2);
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr != null) {
            for (String str : strArr) {
                this.f289968f = d(str) | this.f289968f;
            }
        }
        String str2 = Build.BRAND;
        String str3 = "";
        if (str2 == null) {
            str2 = "";
        }
        this.f289964b = str2;
        if (DeviceInfoMonitor.getModel() != null) {
            str3 = Build.BOARD;
        }
        this.f289965c = str3;
        int i3 = this.f289966d;
        int i16 = f289961r;
        if (i3 != i16) {
            int i17 = this.f289968f;
            if ((i17 & i16) != i16) {
                int i18 = f289960q;
                if (i3 != i18 && (i17 & i18) != i18) {
                    int i19 = f289959p;
                    if (i3 != i19 && (i17 & i19) != i19) {
                        int i26 = f289958o;
                        if (i3 != i26 && (i17 & i26) != i26) {
                            int i27 = f289962s;
                            if (i3 == i27 || (i17 & i27) == i27) {
                                this.f289963a = 6;
                            }
                        } else {
                            this.f289963a = 1;
                        }
                    } else {
                        this.f289963a = 4;
                    }
                } else {
                    this.f289963a = 5;
                }
                e();
                if (this.f289976n) {
                    if (QLog.isColorLevel()) {
                        QLog.i("CPUReport", 2, "getCpuArch not found in android.Build infoArchId:" + this.f289970h + " vendorId:" + this.f289972j);
                    }
                    if (this.f289963a == 0) {
                        int i28 = this.f289970h;
                        if (i28 != 5) {
                            if (i28 != 6) {
                                if (i28 != 7) {
                                    if (i28 != 8) {
                                        String str4 = this.f289972j;
                                        if (str4 != null && (str4.equalsIgnoreCase("AuthenticAMD") || this.f289972j.equalsIgnoreCase("GenuineIntel"))) {
                                            this.f289963a = 7;
                                        }
                                    } else {
                                        this.f289963a = 5;
                                    }
                                } else {
                                    this.f289963a = 4;
                                }
                            } else {
                                this.f289963a = 2;
                            }
                        } else {
                            this.f289963a = 1;
                        }
                    }
                    if (this.f289963a == 4 && this.f289969g.contains("aarch64")) {
                        this.f289963a = 5;
                    } else if (this.f289963a == 1 && this.f289969g.contains("armv6")) {
                        this.f289963a = 2;
                    }
                    if (this.f289963a == 4 && !this.f289971i.contains("neon")) {
                        this.f289963a = 3;
                        if (QLog.isColorLevel()) {
                            QLog.i("CPUReport", 2, "getCpuArch armv7a neon not supported " + this.f289964b + " " + this.f289965c);
                        }
                    } else if (this.f289963a == 8 && this.f289971i.contains("neon")) {
                        this.f289963a = 9;
                        if (QLog.isColorLevel()) {
                            QLog.i("CPUReport", 2, "getCpuArch x86 neon supported " + this.f289964b + " " + this.f289965c);
                        }
                    }
                }
                if (QLog.isColorLevel()) {
                    sb5.append("cpuArch");
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(this.f289963a);
                    sb5.append('\n');
                    sb5.append("CPU_ABI");
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(this.f289966d);
                    sb5.append('\n');
                    sb5.append("CPU_ABI2");
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(this.f289967e);
                    sb5.append('\n');
                    sb5.append("SUPPORTED_ABIS");
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(this.f289968f);
                    sb5.append('\n');
                    sb5.append("brand");
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(this.f289964b);
                    sb5.append('\n');
                    sb5.append("model");
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(this.f289965c);
                    sb5.append('\n');
                    sb5.append("infoProcessorName");
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(this.f289969g);
                    sb5.append('\n');
                    sb5.append("infoArchitectureId");
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(this.f289970h);
                    sb5.append('\n');
                    sb5.append("infoVendorId");
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(this.f289972j);
                    sb5.append('\n');
                    sb5.append("infoHardware");
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(this.f289973k);
                    sb5.append('\n');
                    sb5.append("infoCoreNum");
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(this.f289974l);
                    sb5.append('\n');
                    sb5.append("infoMaxCoreFreq");
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(this.f289975m);
                    sb5.append('\n');
                    sb5.append("doneReadCpuInfo");
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(this.f289976n);
                    sb5.append('\n');
                    QLog.i("CPUReport", 2, sb5.toString());
                }
                return sb5.toString();
            }
        }
        this.f289963a = 7;
        int i29 = this.f289967e;
        int i36 = f289959p;
        if (i29 != i36 && i29 != f289958o) {
            int i37 = this.f289968f;
            if ((i37 & i36) != i36) {
            }
        }
        this.f289963a = 8;
        e();
        if (this.f289976n) {
        }
        if (QLog.isColorLevel()) {
        }
        return sb5.toString();
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        int i3 = this.f289963a;
        if (i3 != 5 && i3 != 4 && i3 != 9) {
            return false;
        }
        return true;
    }
}
