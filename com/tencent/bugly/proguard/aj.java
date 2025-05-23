package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.bugly.common.utils.ContextUtil;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.ROMUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class aj {

    /* renamed from: a, reason: collision with root package name */
    private static final ArrayList<a> f98039a = new ArrayList<a>() { // from class: com.tencent.bugly.proguard.aj.1
        {
            byte b16 = 0;
            add(new l(b16));
            add(new f(b16));
            add(new g(b16));
            add(new m(b16));
            add(new h(b16));
            add(new i(b16));
            add(new k(b16));
            add(new e(b16));
            add(new j(b16));
            add(new b(b16));
            add(new d(b16));
            add(new c(b16));
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private static final Map<Integer, String> f98040b = new HashMap<Integer, String>() { // from class: com.tencent.bugly.proguard.aj.2
        {
            put(1, "GPRS");
            put(2, "EDGE");
            put(3, "UMTS");
            put(8, "HSDPA");
            put(9, "HSUPA");
            put(10, "HSPA");
            put(4, "CDMA");
            put(5, "EVDO_0");
            put(6, "EVDO_A");
            put(7, "1xRTT");
            put(11, "iDen");
            put(12, "EVDO_B");
            put(13, "LTE");
            put(14, "eHRPD");
            put(15, "HSPA+");
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f98041c = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static abstract class a {
        a() {
        }

        /* synthetic */ a(byte b16) {
            this();
        }

        public abstract String a();
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static class b extends a {
        b() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.aj.a
        public final String a() {
            String a16 = ba.a("ro.gn.gnromvernumber");
            if (!ba.b(a16) && !a16.equals("fail")) {
                return "amigo/" + a16 + "/" + ba.a("ro.build.display.id");
            }
            return null;
        }

        /* synthetic */ b(byte b16) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static class c extends a {
        c() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.aj.a
        public final String a() {
            return ba.a("ro.build.fingerprint") + "/" + ba.a("ro.build.rom.id");
        }

        /* synthetic */ c(byte b16) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static class d extends a {
        d() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.aj.a
        public final String a() {
            String a16 = ba.a("ro.build.tyd.kbstyle_version");
            if (!ba.b(a16) && !a16.equals("fail")) {
                return "dido/".concat(a16);
            }
            return null;
        }

        /* synthetic */ d(byte b16) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static class e extends a {
        e() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.aj.a
        public final String a() {
            String a16 = ba.a("ro.aa.romver");
            if (!ba.b(a16) && !a16.equals("fail")) {
                return "htc/" + a16 + "/" + ba.a(ROMUtil.KEY_BUILD_DESCRIPTION);
            }
            return null;
        }

        /* synthetic */ e(byte b16) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static class f extends a {
        f() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.aj.a
        public final String a() {
            String a16 = ba.a("ro.build.version.emui");
            if (!ba.b(a16) && !a16.equals("fail")) {
                return "HuaWei/EMOTION/".concat(a16);
            }
            return null;
        }

        /* synthetic */ f(byte b16) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static class g extends a {
        g() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.aj.a
        public final String a() {
            String a16 = ba.a("ro.lenovo.series");
            if (!ba.b(a16) && !a16.equals("fail")) {
                return "Lenovo/VIBE/".concat(String.valueOf(ba.a("ro.build.version.incremental")));
            }
            return null;
        }

        /* synthetic */ g(byte b16) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static class h extends a {
        h() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.aj.a
        public final String a() {
            String a16 = ba.a("ro.meizu.product.model");
            if (!ba.b(a16) && !a16.equals("fail")) {
                return "Meizu/FLYME/" + ba.a("ro.build.display.id");
            }
            return null;
        }

        /* synthetic */ h(byte b16) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static class i extends a {
        i() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.aj.a
        public final String a() {
            String a16 = ba.a("ro.build.version.opporom");
            if (!ba.b(a16) && !a16.equals("fail")) {
                return "Oppo/COLOROS/".concat(a16);
            }
            return null;
        }

        /* synthetic */ i(byte b16) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static class j extends a {
        j() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.aj.a
        public final String a() {
            String a16 = ba.a("ro.lewa.version");
            if (!ba.b(a16) && !a16.equals("fail")) {
                return "tcl/" + a16 + "/" + ba.a("ro.build.display.id");
            }
            return null;
        }

        /* synthetic */ j(byte b16) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static class k extends a {
        k() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.aj.a
        public final String a() {
            String a16 = ba.a("ro.vivo.os.build.display.id");
            if (!ba.b(a16) && !a16.equals("fail")) {
                return "vivo/FUNTOUCH/".concat(a16);
            }
            return null;
        }

        /* synthetic */ k(byte b16) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static class l extends a {
        l() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.aj.a
        public final String a() {
            String a16 = ba.a("ro.miui.ui.version.name");
            if (!ba.b(a16) && !a16.equals("fail")) {
                return "XiaoMi/MIUI/".concat(a16);
            }
            return null;
        }

        /* synthetic */ l(byte b16) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static class m extends a {
        m() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.aj.a
        public final String a() {
            String a16 = ba.a("ro.build.nubia.rom.name");
            if (!ba.b(a16) && !a16.equals("fail")) {
                return "Zte/NUBIA/" + a16 + "_" + ba.a("ro.build.nubia.rom.code");
            }
            return null;
        }

        /* synthetic */ m(byte b16) {
            this();
        }
    }

    public static String a() {
        try {
            return DeviceInfoMonitor.getModel();
        } catch (Throwable th5) {
            if (av.a(th5)) {
                return "fail";
            }
            th5.printStackTrace();
            return "fail";
        }
    }

    public static String b() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th5) {
            if (av.a(th5)) {
                return "fail";
            }
            th5.printStackTrace();
            return "fail";
        }
    }

    public static int c() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable th5) {
            if (!av.a(th5)) {
                th5.printStackTrace();
                return -1;
            }
            return -1;
        }
    }

    public static String d() {
        try {
            return String.valueOf(System.getProperty("os.arch"));
        } catch (Throwable th5) {
            if (!av.a(th5)) {
                th5.printStackTrace();
                return "fail";
            }
            return "fail";
        }
    }

    public static long e() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th5) {
            if (!av.a(th5)) {
                th5.printStackTrace();
            }
            return -1L;
        }
    }

    public static long f() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th5) {
            if (!av.a(th5)) {
                th5.printStackTrace();
            }
            return -1L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        r0 = java.lang.Long.parseLong(r2.replaceAll("[^\\d]", ""));
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0038 -> B:13:0x004a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long g() {
        BufferedReader bufferedReader;
        Throwable th5;
        long j3 = 0;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/self/status"));
            } catch (Throwable th6) {
                bufferedReader = null;
                th5 = th6;
            }
            try {
                String readLine = bufferedReader.readLine();
                while (true) {
                    if (readLine == null) {
                        break;
                    }
                    if (readLine.startsWith("VmSize")) {
                        break;
                    }
                    readLine = bufferedReader.readLine();
                }
                bufferedReader.close();
            } catch (Throwable th7) {
                th5 = th7;
                try {
                    av.a(th5);
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return j3 * 1024;
                } catch (Throwable th8) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th9) {
                            th9.printStackTrace();
                        }
                    }
                    throw th8;
                }
            }
        } catch (Throwable th10) {
            th10.printStackTrace();
        }
        return j3 * 1024;
    }

    public static long h() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public static long i() {
        return Runtime.getRuntime().maxMemory();
    }

    public static long j() {
        return Runtime.getRuntime().totalMemory();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0028, code lost:
    
        r1 = java.lang.Long.parseLong(r1.split("\\s+")[1]) * 1024;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long k() {
        long j3;
        BufferedReader bufferedReader = null;
        try {
            try {
                bufferedReader = ba.b("/proc", "meminfo");
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (readLine.startsWith("MemTotal:")) {
                            break;
                        }
                    } else {
                        j3 = 0;
                        break;
                    }
                }
                try {
                    bufferedReader.close();
                } catch (IOException e16) {
                    if (!av.a(e16)) {
                        e16.printStackTrace();
                    }
                }
                return j3;
            } catch (Throwable th5) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e17) {
                        if (!av.a(e17)) {
                            e17.printStackTrace();
                        }
                    }
                }
                throw th5;
            }
        } catch (Exception e18) {
            av.b(e18);
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                    return -2L;
                } catch (IOException e19) {
                    if (!av.a(e19)) {
                        e19.printStackTrace();
                        return -2L;
                    }
                    return -2L;
                }
            }
            return -2L;
        }
    }

    public static long l() {
        BufferedReader bufferedReader = null;
        try {
            try {
                bufferedReader = ba.b("/proc", "meminfo");
                long j3 = 0;
                long j16 = 0;
                long j17 = 0;
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null || !(j3 == 0 || j16 == 0 || j17 == 0)) {
                        break;
                    }
                    if (readLine.startsWith("MemFree:")) {
                        j3 = Long.parseLong(readLine.split("\\s+")[1]) * 1024;
                    } else if (readLine.startsWith("Buffers:")) {
                        j16 = Long.parseLong(readLine.split("\\s+")[1]) * 1024;
                    } else if (readLine.startsWith("Cached:")) {
                        j17 = Long.parseLong(readLine.split("\\s+")[1]) * 1024;
                    }
                }
                long j18 = j3 + j16 + j17;
                try {
                    bufferedReader.close();
                } catch (IOException e16) {
                    if (!av.a(e16)) {
                        e16.printStackTrace();
                    }
                }
                return j18;
            } catch (Throwable th5) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e17) {
                        if (!av.a(e17)) {
                            e17.printStackTrace();
                        }
                    }
                }
                throw th5;
            }
        } catch (Exception e18) {
            av.b(e18);
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                    return -2L;
                } catch (IOException e19) {
                    if (!av.a(e19)) {
                        e19.printStackTrace();
                        return -2L;
                    }
                    return -2L;
                }
            }
            return -2L;
        }
    }

    public static long m() {
        if (!u()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(ContextUtil.getGlobalContext().getExternalCacheDir().getAbsolutePath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th5) {
            if (!av.a(th5)) {
                th5.printStackTrace();
                return -2L;
            }
            return -2L;
        }
    }

    public static long n() {
        if (!u()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(ContextUtil.getGlobalContext().getExternalCacheDir().getAbsolutePath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th5) {
            if (!av.a(th5)) {
                th5.printStackTrace();
                return -2L;
            }
            return -2L;
        }
    }

    public static String o() {
        return "";
    }

    public static String p() {
        Iterator<a> it = f98039a.iterator();
        while (it.hasNext()) {
            String a16 = it.next().a();
            if (!TextUtils.isEmpty(a16)) {
                return a16;
            }
        }
        return null;
    }

    public static boolean q() {
        if (TextUtils.isEmpty(new i((byte) 0).a())) {
            return false;
        }
        return true;
    }

    public static boolean r() {
        if (TextUtils.isEmpty(new k((byte) 0).a())) {
            return false;
        }
        return true;
    }

    public static boolean s() {
        boolean z16;
        boolean z17;
        String[] strArr = f98041c;
        int length = strArr.length;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                if (new File(strArr[i3]).exists()) {
                    z16 = true;
                    break;
                }
                i3++;
            } else {
                z16 = false;
                break;
            }
        }
        String str = Build.TAGS;
        if (str != null && str.contains("test-keys")) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17 && !z16) {
            return false;
        }
        return true;
    }

    public static boolean t() {
        float maxMemory = (float) ((Runtime.getRuntime().maxMemory() * 1.0d) / 1048576.0d);
        float f16 = (float) ((Runtime.getRuntime().totalMemory() * 1.0d) / 1048576.0d);
        float f17 = maxMemory - f16;
        av.c("maxMemory : %f", Float.valueOf(maxMemory));
        av.c("totalMemory : %f", Float.valueOf(f16));
        av.c("freeMemory : %f", Float.valueOf(f17));
        if (f17 < 10.0f) {
            return true;
        }
        return false;
    }

    private static boolean u() {
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                return true;
            }
            return false;
        } catch (Throwable th5) {
            if (!av.a(th5)) {
                th5.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public static long a(Context context) {
        long pss;
        ActivityManager activityManager;
        try {
            activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        } catch (Throwable unused) {
            pss = SystemMethodProxy.getPss();
        }
        if (activityManager == null) {
            return 0L;
        }
        pss = SystemMethodProxy.getProcessMemoryInfo(activityManager, new int[]{Process.myPid()})[0].getTotalPss();
        return pss * 1024;
    }

    public static String b(Context context) {
        NetworkInfo activeNetworkInfo;
        TelephonyManager telephonyManager;
        int i3;
        String str;
        String str2 = "unknown";
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e16) {
            e = e16;
        }
        if (activeNetworkInfo == null) {
            return null;
        }
        if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
            return Global.TRACKING_WIFI;
        }
        if (NetworkMonitor.getType(activeNetworkInfo) == 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            if (DeviceInfoUtil.hasPermission(context, DeviceInfoUtil.PERMISSION_READ_PHONE)) {
                i3 = NetworkMonitor.getNetworkType(telephonyManager);
                str = f98040b.get(Integer.valueOf(i3));
            } else {
                i3 = 0;
                str = "unknown";
            }
            if (str != null) {
                try {
                    if (!str.equals("unknown")) {
                        str2 = str;
                    }
                } catch (Exception e17) {
                    e = e17;
                    str2 = str;
                    if (!av.a(e)) {
                        e.printStackTrace();
                    }
                    return str2;
                }
            }
            str2 = "MOBILE(" + i3 + ")";
        }
        return str2;
    }
}
