package com.tencent.ams.mosaic.utils.vid2url;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import cooperation.qzone.util.WiFiDash;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f71589a;

    /* renamed from: b, reason: collision with root package name */
    public static String f71590b;

    /* renamed from: c, reason: collision with root package name */
    public static String f71591c;

    /* renamed from: d, reason: collision with root package name */
    public static int f71592d;

    /* renamed from: e, reason: collision with root package name */
    private static int f71593e;

    /* renamed from: f, reason: collision with root package name */
    private static int f71594f;

    /* renamed from: g, reason: collision with root package name */
    private static String f71595g;

    /* renamed from: h, reason: collision with root package name */
    private static int f71596h;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f71597i;

    /* renamed from: j, reason: collision with root package name */
    private static int f71598j;

    /* renamed from: k, reason: collision with root package name */
    private static long f71599k;

    /* renamed from: l, reason: collision with root package name */
    private static int f71600l;

    /* renamed from: m, reason: collision with root package name */
    private static int f71601m;

    /* renamed from: n, reason: collision with root package name */
    private static int f71602n;

    /* renamed from: o, reason: collision with root package name */
    private static boolean f71603o;

    /* renamed from: p, reason: collision with root package name */
    private static int f71604p;

    /* renamed from: q, reason: collision with root package name */
    private static int f71605q;

    /* renamed from: r, reason: collision with root package name */
    private static final String f71606r;

    /* renamed from: s, reason: collision with root package name */
    private static final String f71607s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
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
            if (Pattern.matches("cpu[0-9]", file.getName())) {
                return true;
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59261);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f71589a = WiFiDash.NOT_AVALIBLE;
        f71590b = "";
        f71591c = "";
        f71592d = 0;
        f71593e = 0;
        f71594f = 0;
        f71595g = "";
        f71596h = 0;
        f71597i = false;
        f71598j = 0;
        f71599k = -1L;
        f71600l = -1;
        f71601m = -1;
        f71602n = 0;
        f71603o = false;
        f71604p = -1;
        f71605q = -1;
        f71606r = Environment.getDataDirectory() + "/data/";
        f71607s = Environment.getExternalStorageDirectory() + "/";
    }

    public static int a() {
        int i3 = f71601m;
        if (-1 != i3) {
            return i3;
        }
        String str = Build.CPU_ABI;
        if (!str.contains(ResourceAttributes.HostArchValues.X86) && !str.contains("X86")) {
            if (!str.contains("mips") && !str.contains("Mips")) {
                if (f71592d == 0) {
                    b();
                }
                if (!d().equals("XT882") && !d().equals("ME860") && !d().equals("MB860") && !d().equals("Lenovo P70") && !d().equals("Lenovo A60") && !d().equals("Lenovo A366t")) {
                    if (!TextUtils.isEmpty(f71589a) && f71589a.contains("ARMv6")) {
                        f71601m = 4;
                        return 4;
                    }
                    if (!TextUtils.isEmpty(f71590b) && !f71590b.contains("neon")) {
                        f71601m = 4;
                        return 4;
                    }
                    switch (f71592d) {
                        case 5:
                            f71601m = 3;
                            break;
                        case 6:
                            f71601m = 4;
                            break;
                        case 7:
                            f71601m = 6;
                            break;
                        case 8:
                        case 9:
                        case 10:
                            f71601m = 50;
                            break;
                        default:
                            f71601m = 0;
                            break;
                    }
                } else {
                    f71601m = 3;
                    return 3;
                }
            } else {
                f71601m = 2;
            }
        } else {
            f71601m = 1;
        }
        return f71601m;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0087, code lost:
    
        if (r2.length() <= 1) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0089, code lost:
    
        com.tencent.ams.mosaic.utils.vid2url.d.f71592d = (int) java.lang.Long.parseLong(r2.substring(0, 1));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b() {
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
                            if (readLine.startsWith("Processor")) {
                                int indexOf2 = readLine.indexOf(58);
                                if (indexOf2 > 1) {
                                    String substring = readLine.substring(indexOf2 + 1, readLine.length());
                                    f71589a = substring;
                                    f71589a = substring.trim();
                                }
                            } else if (readLine.startsWith("CPU architecture")) {
                                int indexOf3 = readLine.indexOf(58);
                                if (indexOf3 > 1) {
                                    String trim = readLine.substring(indexOf3 + 1, readLine.length()).trim();
                                    if (trim != null && trim.length() > 0 && trim.length() < 2) {
                                        f71592d = (int) Long.parseLong(trim);
                                    }
                                }
                            } else if (readLine.startsWith("Features")) {
                                int indexOf4 = readLine.indexOf(58);
                                if (indexOf4 > 1) {
                                    f71590b = readLine.substring(indexOf4 + 1, readLine.length()).trim();
                                }
                            } else if (readLine.startsWith("Hardware") && (indexOf = readLine.indexOf(58)) > 1) {
                                f71591c = readLine.substring(indexOf + 1, readLine.length()).trim();
                            }
                        } catch (Throwable unused) {
                            inputStreamReader = inputStreamReader2;
                            try {
                                f71591c = "Unknown";
                                f71592d = 0;
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
                                        com.tencent.ams.mosaic.utils.f.d("VcSystemInfo", e16);
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
            com.tencent.ams.mosaic.utils.f.d("VcSystemInfo", e17);
        }
    }

    public static long c() {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        IOException e16;
        FileNotFoundException e17;
        long j3;
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
                                com.tencent.ams.mosaic.utils.f.d("VcSystemInfo", th5);
                                return 0L;
                            }
                        }
                        String trim = readLine.trim();
                        if (trim != null && trim.length() > 0) {
                            j3 = Long.parseLong(trim);
                        } else {
                            j3 = 0;
                        }
                        try {
                            inputStreamReader.close();
                            bufferedReader.close();
                            return j3;
                        } catch (Throwable th6) {
                            com.tencent.ams.mosaic.utils.f.d("VcSystemInfo", th6);
                            return 0L;
                        }
                    } catch (FileNotFoundException e18) {
                        e17 = e18;
                        com.tencent.ams.mosaic.utils.f.d("VcSystemInfo", e17);
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (Throwable th7) {
                                com.tencent.ams.mosaic.utils.f.d("VcSystemInfo", th7);
                                return 0L;
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return 0L;
                    } catch (IOException e19) {
                        e16 = e19;
                        com.tencent.ams.mosaic.utils.f.d("VcSystemInfo", e16);
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (Throwable th8) {
                                com.tencent.ams.mosaic.utils.f.d("VcSystemInfo", th8);
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
                                com.tencent.ams.mosaic.utils.f.d("VcSystemInfo", th9);
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
                    com.tencent.ams.mosaic.utils.f.d("VcSystemInfo", th11);
                    return 0L;
                }
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th10;
        }
    }

    public static String d() {
        return DeviceInfoMonitor.getModel();
    }

    public static int e() {
        int i3 = f71600l;
        if (-1 != i3) {
            return i3;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new a());
            if (listFiles == null) {
                f71600l = 1;
                return 1;
            }
            int length = listFiles.length;
            f71600l = length;
            return length;
        } catch (Exception e16) {
            com.tencent.ams.mosaic.utils.f.d("VcSystemInfo", e16);
            f71600l = 1;
            return 1;
        }
    }

    public static int f() {
        int i3 = f71596h;
        if (i3 != 0) {
            return i3;
        }
        f71596h = 11;
        if (a() != 6) {
            f71596h = 1;
        }
        if (e() == 1 && c() / 1000 <= 1000) {
            f71596h = 6;
        }
        if ((e() == 1 && c() / 1000 > 1000) || (e() == 2 && c() / 1000 < 1400)) {
            f71596h = 11;
        }
        if (e() == 2 && c() / 1000 >= 1400) {
            f71596h = 16;
        }
        if (e() >= 4) {
            f71596h = 21;
        }
        return f71596h;
    }
}
