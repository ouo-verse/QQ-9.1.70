package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ee;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;
import com.tencent.rfix.loader.utils.RFixConstants;
import com.tencent.util.AudioHelperUtil;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SoLoadUtil {

    /* renamed from: a, reason: collision with root package name */
    private static Set<String> f307354a;

    /* renamed from: b, reason: collision with root package name */
    private static SimpleDateFormat f307355b;

    static {
        HashSet hashSet = new HashSet();
        f307354a = hashSet;
        hashSet.add("libamrnb.so");
        f307354a.add("libcodecsilk.so");
        f307355b = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
    }

    private static native int Decode(AssetManager assetManager, String str, String str2, String str3, String str4);

    public static boolean a(boolean z16, File file) {
        if (z16) {
            QLog.d("SoLoadUtil", 1, "load suc, escape this statement");
            return false;
        }
        if (file.exists() && !file.delete()) {
            return false;
        }
        return true;
    }

    public static boolean b(Context context, String str) {
        String str2 = AppSetting.l() + h();
        String string = context.getSharedPreferences("so_sp", 4).getString("key_so_version_" + str, "");
        boolean equals = TextUtils.equals(str2, string) ^ true;
        if (AudioHelperUtil.isLogColorOrGary() || equals) {
            QLog.w("SoLoadUtil", 1, "loadNativeLibrary, libName[" + str + "], nowVersion[" + string + "], revision[" + str2 + "], needUpdate[" + equals + "]");
        }
        return equals;
    }

    public static void c(Context context, String str, long j3, File file) {
        boolean z16;
        if (b(context, str)) {
            boolean z17 = false;
            if (file.exists()) {
                boolean delete = file.delete();
                if (delete && file.exists()) {
                    q(new ee.a().g("delete_old_so_exception").e(i(str)).a());
                } else {
                    z17 = delete;
                }
                QLog.w("SoLoadUtil", 1, "loadNativeLibrary, delete[" + z17 + "], seq[" + j3 + "]");
                z16 = z17;
                z17 = true;
            } else {
                z16 = true;
            }
            if (z17) {
                q(new ee.a().g("delete_old_so").e(i(str)).c(z16).a());
            }
            if (z16) {
                QLog.d("SoLoadUtil", 1, "loadNativeLibrary, update so version, libName[" + str + "], seq[" + j3 + "]");
                t(context, str);
            }
        }
    }

    private static final void d(HashMap<String, String> hashMap) {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "loadSo", false, 0L, 0L, hashMap, "");
    }

    private static int e(Context context, boolean z16, AssetManager assetManager, String str, String str2, String str3, String str4) {
        if (z16) {
            SoLoadUtilNew.loadSoByName(context, "lzmadecode");
        } else {
            SoLoadUtilNew.loadSoByName(context, "DecodeSo");
        }
        QLog.d("SoLoadUtil", 1, "unCompress7zSo isUseNewLoad = " + z16 + ", load so over, try to decode");
        int i3 = 0;
        for (int i16 = 0; i16 <= 1; i16++) {
            if (z16) {
                i3 = bn.a(assetManager, str, str2, str3, str4);
            } else {
                i3 = Decode(assetManager, str, str2, str3, str4);
            }
            if (i3 == 0) {
                break;
            }
        }
        return i3;
    }

    public static final void f(HashMap<String, String> hashMap, int i3, String str, long j3) {
        if (!com.tencent.mobileqq.startup.a.f289668i) {
            return;
        }
        hashMap.put("message", str);
        hashMap.put("costTime", j3 + "");
        StatisticCollector.fillFailCode(hashMap, i3);
        d(hashMap);
    }

    private static final HashMap<String, String> g(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        hashMap.put("osVersion", Build.VERSION.RELEASE);
        hashMap.put("deviceName", Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel());
        hashMap.put("time", f307355b.format(new Date(System.currentTimeMillis())));
        hashMap.put("libName", str);
        return hashMap;
    }

    public static String h() {
        return "_64";
    }

    private static String i(String str) {
        return RFixConstants.SO_PATH + str + ".so";
    }

    private static synchronized String j() {
        synchronized (SoLoadUtil.class) {
            String str = Build.CPU_ABI;
            if (str != null && str.contains("x86_64")) {
                return "x86_64";
            }
            if (str != null && str.contains("mips64")) {
                return "mips64";
            }
            if (l()) {
                return "x86_64";
            }
            return "arm64-v8a";
        }
    }

    private static synchronized String k() {
        String j3;
        synchronized (SoLoadUtil.class) {
            j3 = j();
        }
        return j3;
    }

    public static boolean l() {
        String property = System.getProperty("os.arch");
        if (Build.BRAND.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_ASUS)) {
            String str = Build.CPU_ABI2;
            Locale locale = Locale.US;
            if (str.toLowerCase(locale).contains(ResourceAttributes.HostArchValues.X86) || property.toLowerCase(locale).contains(ResourceAttributes.HostArchValues.X86) || property.toLowerCase(locale).contains("i386") || property.toLowerCase(locale).contains("i686") || property.toLowerCase(locale).contains("i586") || property.toLowerCase(locale).contains("i486")) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static synchronized boolean m(Context context, String str, int i3, boolean z16) {
        Context context2;
        HashMap<String, String> hashMap;
        long j3;
        synchronized (SoLoadUtil.class) {
            long genDebugSeq = AudioHelperUtil.genDebugSeq();
            QLog.w("SoLoadUtil", 1, "loadNativeLibrary begin, libName[" + str + "], includePrivateLib[" + z16 + "], seq[" + genDebugSeq + "]");
            long uptimeMillis = SystemClock.uptimeMillis();
            HashMap<String, String> g16 = g(str);
            ef efVar = new ef();
            String i16 = i(str);
            if (context == null) {
                context2 = BaseApplication.getContext();
            } else {
                context2 = context;
            }
            String str2 = context2.getFilesDir().getParent() + SoLoadCore.PATH_TX_LIB;
            String str3 = context2.getFilesDir().getParent() + SoLoadCore.PATH_LIB;
            QLog.d("SoLoadUtil", 1, "loadNativeLibrary, txLibPath = " + str2);
            if (z16) {
                File file = new File(str3 + i16);
                if (file.exists()) {
                    try {
                        System.load(file.getAbsolutePath());
                        efVar.f307712c = true;
                        f(g16, efVar.f307711b, efVar.f307710a, SystemClock.uptimeMillis() - uptimeMillis);
                        QLog.d("SoLoadUtil", 1, "System.load, path = " + file.getAbsolutePath() + " suc");
                        return efVar.f307712c;
                    } catch (UnsatisfiedLinkError e16) {
                        efVar.f307710a += "load app so fail, exception info : " + QLog.getStackTraceString(e16);
                        r(efVar, 2);
                        QLog.d("SoLoadUtil", 1, efVar.f307710a);
                    }
                } else {
                    efVar.f307710a += "load app so fail. lib so not exist:" + i16;
                    r(efVar, 4);
                    QLog.d("SoLoadUtil", 1, efVar.f307710a);
                }
            }
            File file2 = new File(str2 + i16);
            String str4 = "key_so_crc" + str;
            SharedPreferences sharedPreferences = context2.getSharedPreferences("so_sp", 4);
            c(context2, str, genDebugSeq, file2);
            if (file2.exists()) {
                j3 = uptimeMillis;
                hashMap = g16;
            } else {
                StringBuilder sb5 = new StringBuilder();
                hashMap = g16;
                sb5.append("txSoFile not exists, copy asset so :");
                sb5.append(i16);
                QLog.d("SoLoadUtil", 1, sb5.toString());
                int s16 = s(context2, str2, "txlib", i16);
                StringBuilder sb6 = new StringBuilder();
                j3 = uptimeMillis;
                sb6.append("loadNativeLibrary, unCompress7zSo, res[");
                sb6.append(s16);
                sb6.append("], seq[");
                sb6.append(genDebugSeq);
                sb6.append("]");
                QLog.w("SoLoadUtil", 1, sb6.toString());
                if (s16 != 0) {
                    file2.delete();
                    efVar.f307710a += "copy asset so fail. file size not match :" + str;
                    r(efVar, 8);
                    QLog.d("SoLoadUtil", 1, efVar.f307710a);
                } else {
                    sharedPreferences.edit().putLong(str4, IOUtil.getCRC32Value(file2)).commit();
                }
            }
            QLog.w("SoLoadUtil", 1, "loadNativeLibrary, libName[" + str + "], txSoFile[" + file2.exists() + "], seq[" + genDebugSeq + "]");
            n(efVar, file2, str4, sharedPreferences);
            if (a(efVar.f307712c, file2)) {
                q(new ee.a().g("recompress_so").e(i16).f(p(context2, str, efVar, str2, file2)).a());
            }
            if (!efVar.f307712c) {
                QLog.w("SoLoadUtil", 1, "loadNativeLibrary, use system way, seq[" + genDebugSeq + "]");
                try {
                    System.loadLibrary(str);
                    efVar.f307712c = true;
                    QLog.d("SoLoadUtil", 1, "System.loadLibrary, lib = " + str + " suc");
                } catch (UnsatisfiedLinkError e17) {
                    efVar.f307710a += "load system way failed, exception info : " + QLog.getStackTraceString(e17);
                    r(efVar, 64);
                    QLog.d("SoLoadUtil", 1, efVar.f307710a, e17);
                }
            }
            long uptimeMillis2 = SystemClock.uptimeMillis() - j3;
            f(hashMap, efVar.f307711b, efVar.f307710a, uptimeMillis2);
            QLog.w("SoLoadUtil", 1, "loadNativeLibrary, libName[" + str + "], cost[" + uptimeMillis2 + "], result[" + efVar.f307712c + "], seq[" + genDebugSeq + "]");
            return efVar.f307712c;
        }
    }

    private static void n(ef efVar, File file, String str, SharedPreferences sharedPreferences) {
        if (file.exists()) {
            try {
                System.load(file.getAbsolutePath());
                efVar.f307712c = true;
                QLog.d("SoLoadUtil", 1, "System.load, path = " + file.getAbsolutePath() + " suc");
            } catch (UnsatisfiedLinkError e16) {
                efVar.f307712c = false;
                long cRC32Value = IOUtil.getCRC32Value(file);
                long j3 = sharedPreferences.getLong(str, -1L);
                file.deleteOnExit();
                if (cRC32Value != -1 && cRC32Value != j3) {
                    efVar.f307710a += "load asset so fail, crc not match." + cRC32Value + ":" + j3 + " path:" + file + ", exception info : " + QLog.getStackTraceString(e16);
                    r(efVar, 128);
                    QLog.d("SoLoadUtil", 1, efVar.f307710a);
                    return;
                }
                efVar.f307710a += "load asset so fail. path:" + file + ", exception info : " + QLog.getStackTraceString(e16);
                r(efVar, 32);
                QLog.d("SoLoadUtil", 1, efVar.f307710a);
            }
        }
    }

    public static boolean o(Context context, String str) {
        if (b(context, str)) {
            t(context, str);
            return true;
        }
        return false;
    }

    private static boolean p(Context context, String str, ef efVar, String str2, File file) {
        QLog.d("SoLoadUtil", 1, "delete old so file and redo unCompress7zSo, soLibName[" + str + "]");
        if (s(context, str2, "txlib", i(str)) != 0) {
            file.delete();
            String str3 = efVar.f307710a + "crc not match, redo copy asset so fail. file size not match :" + str;
            efVar.f307710a = str3;
            QLog.d("SoLoadUtil", 1, str3);
            return false;
        }
        try {
            System.load(file.getAbsolutePath());
            efVar.f307712c = true;
            QLog.d("SoLoadUtil", 1, "crc not match, redo System.load: " + file.getAbsolutePath() + " suc");
        } catch (UnsatisfiedLinkError e16) {
            QLog.d("SoLoadUtil", 1, "crc not match, redo System.load failed, soLibName[" + str + "]", e16);
        }
        return true;
    }

    public static void q(ee eeVar) {
        String currentUin;
        HashMap hashMap = new HashMap();
        hashMap.put(TVKDataBinder.KEY_REPORT_TYPE, eeVar.f307696a);
        hashMap.put("report_lib_name", eeVar.f307697b);
        hashMap.put("mkdir_failed_retry_time", String.valueOf(eeVar.f307699d));
        hashMap.put("delete_old_so_result", String.valueOf(eeVar.f307700e));
        hashMap.put("recompress_so_result", String.valueOf(eeVar.f307701f));
        hashMap.put("decode_result", String.valueOf(eeVar.f307698c));
        hashMap.put("is_use_new_load", String.valueOf(eeVar.f307702g));
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            currentUin = "0";
        } else {
            currentUin = peekAppRuntime.getCurrentUin();
        }
        QLog.d("SoLoadUtil", 1, "reportBeacon, param: " + hashMap);
        QQBeaconReport.report(currentUin, "so_load_from_native_library", hashMap);
    }

    private static void r(ef efVar, int i3) {
        efVar.f307711b = i3 | efVar.f307711b;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x01f6 A[Catch: all -> 0x02c7, TryCatch #2 {, blocks: (B:4:0x0009, B:6:0x003c, B:7:0x0044, B:9:0x004f, B:10:0x0052, B:13:0x00bb, B:17:0x00cd, B:19:0x00d3, B:21:0x00d9, B:25:0x01f6, B:27:0x028f, B:32:0x02a6, B:39:0x023c, B:41:0x026c, B:44:0x0282, B:45:0x0275, B:47:0x0122, B:49:0x0174, B:51:0x017a, B:54:0x01c7), top: B:3:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x028f A[Catch: all -> 0x02c7, TryCatch #2 {, blocks: (B:4:0x0009, B:6:0x003c, B:7:0x0044, B:9:0x004f, B:10:0x0052, B:13:0x00bb, B:17:0x00cd, B:19:0x00d3, B:21:0x00d9, B:25:0x01f6, B:27:0x028f, B:32:0x02a6, B:39:0x023c, B:41:0x026c, B:44:0x0282, B:45:0x0275, B:47:0x0122, B:49:0x0174, B:51:0x017a, B:54:0x01c7), top: B:3:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x02a6 A[Catch: all -> 0x02c7, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0009, B:6:0x003c, B:7:0x0044, B:9:0x004f, B:10:0x0052, B:13:0x00bb, B:17:0x00cd, B:19:0x00d3, B:21:0x00d9, B:25:0x01f6, B:27:0x028f, B:32:0x02a6, B:39:0x023c, B:41:0x026c, B:44:0x0282, B:45:0x0275, B:47:0x0122, B:49:0x0174, B:51:0x017a, B:54:0x01c7), top: B:3:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x023c A[Catch: all -> 0x02c7, TryCatch #2 {, blocks: (B:4:0x0009, B:6:0x003c, B:7:0x0044, B:9:0x004f, B:10:0x0052, B:13:0x00bb, B:17:0x00cd, B:19:0x00d3, B:21:0x00d9, B:25:0x01f6, B:27:0x028f, B:32:0x02a6, B:39:0x023c, B:41:0x026c, B:44:0x0282, B:45:0x0275, B:47:0x0122, B:49:0x0174, B:51:0x017a, B:54:0x01c7), top: B:3:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized int s(Context context, String str, String str2, String str3) {
        Context context2;
        int i3;
        boolean z16;
        int i16;
        boolean z17;
        boolean z18;
        boolean c16;
        boolean z19;
        int i17;
        synchronized (SoLoadUtil.class) {
            QLog.w("SoLoadUtil", 1, "unCompress7zSo begin, pathName[" + str + "], lzmaLibName[" + str2 + "], filterLibsName[" + str3 + "]");
            if (context == null) {
                context2 = BaseApplication.getContext();
            } else {
                context2 = context;
            }
            File file = new File(str);
            if (!file.exists()) {
                file.mkdir();
            }
            String str4 = str + "tmp_" + MobileQQ.sProcessId + "_" + Thread.currentThread() + "/";
            File file2 = new File(str4);
            file2.mkdirs();
            QLog.d("SoLoadUtil", 1, "unCompress7zSo, tempDirFile[" + file2.getAbsolutePath() + "], exists[" + file2.exists() + "]");
            String k3 = k();
            AssetManager assets = context2.getAssets();
            try {
                c16 = bn.c();
            } catch (UnsatisfiedLinkError e16) {
                e = e16;
                i3 = 2;
                z16 = false;
            }
            if (c16) {
                z19 = c16;
                i3 = 2;
                try {
                    i17 = e(context2, true, assets, str2, str4, k3, str3);
                } catch (UnsatisfiedLinkError e17) {
                    e = e17;
                    z16 = z19;
                    QLog.e("SoLoadUtil", 1, "Unsatisfied Link error, abi:" + k() + ", isUseNewLoad[" + z16 + "]. ", e);
                    i16 = i3;
                    if (i16 != 0) {
                    }
                    if (i16 == 0) {
                    }
                    z18 = z17;
                    if (z18) {
                    }
                    return i16;
                }
                if (i17 == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SoLoadUtil", 2, "unCompress7zSo new decode suc, lzmaLibName[" + str2 + "], tempDir[" + str4 + "], abi[" + k3 + "], filterLibsName[" + str3 + "], isUseNewLoad[" + z19 + "]");
                    }
                    i16 = i17;
                    z16 = z19;
                    if (i16 != 0) {
                        QLog.w("SoLoadUtil", 1, "unCompress7zSo fail, res[" + i16 + "], tempDirFile[" + file2.getAbsolutePath() + "], exists[" + file2.exists() + "], isUseNewLoad[" + z16 + "]");
                        file2.delete();
                    } else {
                        File file3 = new File(str4 + str3);
                        File file4 = new File(str + str3);
                        if (!file4.exists()) {
                            if (!file3.renameTo(file4)) {
                                i16 = 256;
                            }
                        } else {
                            QLog.w("SoLoadUtil", 1, "dstFile already exists, delete the tempDirFile");
                            file2.delete();
                        }
                        ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).registerSoFile(context2, file4);
                    }
                    if (i16 == 0) {
                        z17 = true;
                        if (new Random().nextInt(100000) >= 1) {
                            z18 = false;
                            if (z18) {
                                q(new ee.a().g("decode_res").e(str3).b(i16).d(z16).a());
                            }
                        }
                    } else {
                        z17 = true;
                    }
                    z18 = z17;
                    if (z18) {
                    }
                }
            } else {
                z19 = c16;
                i3 = 2;
                i17 = 0;
            }
            QLog.w("SoLoadUtil", 1, "unCompress7zSo new decode fail, res[" + i17 + "], tempDirFile[" + file2.getAbsolutePath() + "], exists[" + file2.exists() + "], isUseNewLoad[" + z19 + "]");
            i17 = e(context2, false, assets, str2, str4, k3, str3);
            if (i17 == 0 && QLog.isColorLevel()) {
                QLog.d("SoLoadUtil", i3, "unCompress7zSo decode suc, lzmaLibName[" + str2 + "], tempDir[" + str4 + "], abi[" + k3 + "], filterLibsName[" + str3 + "], isUseNewLoad[" + z19 + "]");
            }
            i16 = i17;
            z16 = z19;
            if (i16 != 0) {
            }
            if (i16 == 0) {
            }
            z18 = z17;
            if (z18) {
            }
        }
        return i16;
    }

    public static void t(Context context, String str) {
        String str2 = AppSetting.l() + h();
        String str3 = "key_so_version_" + str;
        SharedPreferences sharedPreferences = context.getSharedPreferences("so_sp", 4);
        if (AppSetting.r()) {
            sharedPreferences.edit().putString(str3, "-1" + h()).apply();
            return;
        }
        sharedPreferences.edit().putString(str3, str2).apply();
    }
}
