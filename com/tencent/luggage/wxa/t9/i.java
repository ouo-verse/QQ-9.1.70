package com.tencent.luggage.wxa.t9;

import android.os.Build;
import com.tencent.ams.mosaic.jsengine.animation.group.GroupAnimation;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static Map f141060a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            if (Pattern.matches("cpu[0-9]", file.getName())) {
                return true;
            }
            return false;
        }
    }

    public static boolean a(char c16) {
        return c16 >= '0' && c16 <= '9';
    }

    public static String b() {
        if (f141060a == null) {
            f141060a = a();
        }
        return a(f141060a, "Hardware");
    }

    public static String c() {
        if (f141060a == null) {
            f141060a = a();
        }
        return MsgSummary.STR_COLON + a(f141060a, "Features") + MsgSummary.STR_COLON + a(f141060a, "Processor") + MsgSummary.STR_COLON + a(f141060a, "CPU architecture") + MsgSummary.STR_COLON + a(f141060a, "Hardware") + MsgSummary.STR_COLON + a(f141060a, GroupAnimation.PlayBackOrder.SERIAL);
    }

    public static int d() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new a()).length;
        } catch (Exception unused) {
            return 1;
        }
    }

    public static boolean e() {
        if (f141060a == null) {
            f141060a = a();
        }
        Map map = f141060a;
        if (map != null) {
            String a16 = a(map, "Features");
            if (a16 != null && a16.contains("neon")) {
                return true;
            }
            if (a16 != null && a16.contains("asimd")) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean f() {
        if (f141060a == null) {
            f141060a = a();
        }
        Map map = f141060a;
        if (map != null) {
            String a16 = a(map, "CPU architecture");
            com.tencent.luggage.wxa.tn.w.a("CpuFeatures", "arch " + a16);
            if (a16 != null) {
                try {
                    if (a16.length() > 0) {
                        int a17 = w0.a(a(b(a16)), 0);
                        com.tencent.luggage.wxa.tn.w.a("CpuFeatures", "armarch " + a17);
                        if (a17 >= 6) {
                            return true;
                        }
                    }
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.tn.w.a("CpuFeatures", e16, "", new Object[0]);
                }
            }
        }
        return false;
    }

    public static boolean g() {
        try {
            if (!a(4)) {
                return false;
            }
            if (!e()) {
                return false;
            }
            return true;
        } catch (IncompatibleClassChangeError e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.Crash", e16, "May cause dvmFindCatchBlock crash!", new Object[0]);
            throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e16));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(int i3) {
        return Build.VERSION.SDK_INT >= i3;
    }

    public static String a(String str) {
        int i3;
        int i16 = 0;
        while (true) {
            i3 = i16 + 1;
            try {
                if (!a(str.charAt(i16)) || str.length() <= i3) {
                    break;
                }
                i16 = i3;
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.a("CpuFeatures", e16, "", new Object[0]);
                return str;
            }
        }
        int i17 = i3 - 1;
        return (str.length() <= i17 + 1 || i17 <= 0) ? str : str.substring(0, i17);
    }

    public static String b(String str) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    while (!a(str.charAt(0))) {
                        if (str.length() == 1) {
                            return null;
                        }
                        str = str.substring(1);
                    }
                }
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.a("CpuFeatures", e16, "", new Object[0]);
            }
        }
        return str;
    }

    public static String a(Map map, String str) {
        return (String) map.get(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static HashMap a() {
        String readLine;
        HashMap hashMap = new HashMap();
        BufferedReader bufferedReader = null;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/cpuinfo"), "UTF-8"));
                while (true) {
                    try {
                        readLine = bufferedReader3.readLine();
                        if (readLine == 0) {
                            break;
                        }
                        String[] split = readLine.split(":", 2);
                        if (split != null && split.length >= 2) {
                            String trim = split[0].trim();
                            String trim2 = split[1].trim();
                            if (hashMap.get(trim) == null) {
                                hashMap.put(trim, trim2);
                            }
                        }
                    } catch (IOException e16) {
                        e = e16;
                        bufferedReader2 = bufferedReader3;
                        com.tencent.luggage.wxa.tn.w.a("CpuFeatures", e, "getCpu() failed.", new Object[0]);
                        w0.a((Closeable) bufferedReader2);
                        bufferedReader = bufferedReader2;
                        return hashMap;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedReader = bufferedReader3;
                        w0.a((Closeable) bufferedReader);
                        throw th;
                    }
                }
                w0.a((Closeable) bufferedReader3);
                bufferedReader = readLine;
            } catch (IOException e17) {
                e = e17;
            }
            return hashMap;
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
