package com.tencent.luggage.wxa.ar;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.xweb.CommandCfg;
import com.tencent.xweb.WebDebugCfg;
import com.tencent.xweb.xwalk.plugin.XWalkPluginManager;
import java.io.File;
import java.util.HashSet;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class q0 {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f121767a = false;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f121768a;

        public a(Context context) {
            this.f121768a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            x0.d("XWebCleaner", "tryClean start");
            q0.a(this.f121768a, false);
            q0.b(this.f121768a, false);
            q0.b(false);
            q0.a(this.f121768a);
            boolean unused = q0.f121767a = false;
            x0.d("XWebCleaner", "tryClean finished");
        }
    }

    public static boolean b() {
        x0.d("XWebCleaner", "isBusy:" + f121767a);
        return f121767a;
    }

    public static boolean c(int i3) {
        String g16 = u0.g(i3);
        File file = new File(g16);
        if (!file.exists()) {
            if (XWalkEnvironment.isTestVersion(i3) || i3 < 362) {
                x0.f("XWebCleaner", "doCheckResFiles, resConfigFile not exist, maybe test runtime or old runtime, path:" + g16);
                return true;
            }
            n0.a(79L, 1);
            x0.d("XWebCleaner", "doCheckResFiles, resConfigFile not exist, path:" + g16);
            if (!"true".equalsIgnoreCase(CommandCfg.getInstance().getCmd("dis_res_config_file_check", "tools"))) {
                return false;
            }
            x0.f("XWebCleaner", "doCheckResFiles, resConfigFile not exist and dis_res_config_file_check");
            return true;
        }
        return v.b(i3, file);
    }

    public static void d(Context context) {
        com.tencent.luggage.wxa.lq.d.a(new a(context));
        f121767a = true;
    }

    public static void e(int i3) {
        if (!new File(u0.e(i3)).exists()) {
            x0.f("XWebCleaner", "tryCleanDownloadedZip, base.apk file not exist");
            return;
        }
        if (!new File(u0.j(i3)).exists()) {
            x0.f("XWebCleaner", "tryCleanDownloadedZip, extracted_core directory not exist");
            return;
        }
        String i16 = u0.i(i3);
        x0.d("XWebCleaner", "tryCleanDownloadedZip, delete result:" + w.b(i16) + ", path:" + i16);
    }

    public static void f(int i3) {
        x0.d("XWebCleaner", "tryCleanUselessFiles, version:" + i3);
        File file = new File(u0.q(i3));
        if (file.exists() && file.isDirectory()) {
            File file2 = new File(file, "BrowserMetrics");
            if (file2.exists() && file2.isDirectory()) {
                x0.d("XWebCleaner", "tryCleanUselessFiles, delete BrowserMetrics");
                w.a(file2.getAbsolutePath());
            }
            e(i3);
            return;
        }
        x0.f("XWebCleaner", "tryCleanUselessFiles, version dir not exist");
    }

    public static void g(int i3) {
        x0.d("XWebCleaner", "tryCleanVersionCache, version:" + i3);
        String p16 = u0.p(i3);
        if (p16 == null) {
            x0.f("XWebCleaner", "tryCleanVersionCache, cacheDir is null");
            return;
        }
        File file = new File(p16);
        if (file.exists() && file.isDirectory()) {
            x0.d("XWebCleaner", "tryCleanVersionCache, delete cacheDir:" + file.getAbsolutePath());
            w.a(file.getAbsolutePath());
        }
    }

    public static void a(Context context) {
        if (!WebDebugCfg.getInst().getEnableCheckStorage() && !CommandCfg.getInstance().getEnableCheckStorage()) {
            x0.d("XWebCleaner", "checkStorage, disabled by command");
            return;
        }
        File[] listFiles = new File(context.getApplicationInfo().dataDir).listFiles();
        if (listFiles == null) {
            x0.c("XWebCleaner", "checkStorage failed, files is null");
            return;
        }
        com.tencent.luggage.wxa.wq.c cVar = new com.tencent.luggage.wxa.wq.c();
        long j3 = 0;
        for (File file : listFiles) {
            String name = file.getName();
            if (name.startsWith("app_xwalk_") && file.isDirectory()) {
                j3 += a(cVar, file, name);
            } else if (name.equals("app_xweb_data") && file.isDirectory()) {
                File[] listFiles2 = file.listFiles();
                if (listFiles2 != null) {
                    for (File file2 : listFiles2) {
                        if (file2.getName().startsWith("xweb_") && file2.isDirectory()) {
                            j3 += a(cVar, file2, file2.getName());
                        }
                    }
                }
            } else if (name.startsWith("app_xwalkconfig") && file.isDirectory()) {
                long a16 = w.a(file, true);
                j3 += a16;
                x0.d("XWebCleaner", "checkStorage, config dir:" + name + ", size:" + w.a(a16));
                cVar.b(a16);
            } else if (name.startsWith("app_xwalkplugin") && file.isDirectory()) {
                a(cVar, file);
            }
        }
        if (j3 > 0) {
            x0.d("XWebCleaner", "checkStorage, xweb total size:" + w.a(j3));
            cVar.a(j3);
            cVar.a();
        }
    }

    public static void b(boolean z16) {
        boolean z17;
        int availableVersion = XWalkEnvironment.getAvailableVersion();
        if (availableVersion > 0 && !XWalkEnvironment.isTestVersion(availableVersion)) {
            boolean t16 = u0.t(availableVersion);
            boolean s16 = u0.s(availableVersion);
            if (!t16 && !s16) {
                x0.d("XWebCleaner", "checkFiles, skip for no version data dir, version:" + availableVersion);
                return;
            }
            if (!z16 && !x.a("CHECK_FILES_MD5_TIME_KEY", 7200000L)) {
                x0.d("XWebCleaner", "checkFiles, skip check");
                return;
            }
            SharedPreferences o16 = y0.o();
            if (o16 == null) {
                x0.d("XWebCleaner", "checkFiles, invalid shared preferences");
                return;
            }
            com.tencent.luggage.wxa.wq.a.a();
            x0.d("XWebCleaner", "checkFiles, start check res files, version:" + availableVersion);
            boolean c16 = c(availableVersion);
            if (!c16) {
                int i3 = o16.getInt("lastCheckResVersion", -1);
                o16.edit().putInt("lastCheckResVersion", -1).commit();
                if (i3 != availableVersion) {
                    n0.a(77L, 1);
                    x0.d("XWebCleaner", "checkFiles, some res files corrupted at first time");
                } else {
                    x0.d("XWebCleaner", "checkFiles, some res files corrupted");
                }
                n0.a(76L, 1);
            }
            x0.d("XWebCleaner", "checkFiles, start check installed files, version:" + availableVersion);
            boolean b16 = b(availableVersion);
            if (!b16) {
                int i16 = o16.getInt("lastCheckVersion", -1);
                o16.edit().putInt("lastCheckVersion", -1).commit();
                if (i16 != availableVersion) {
                    n0.a(64L, 1);
                    x0.d("XWebCleaner", "checkFiles, some installed files corrupted at first time");
                } else {
                    x0.d("XWebCleaner", "checkFiles, some installed files corrupted");
                }
                n0.a(63L, 1);
            }
            if ("true".equalsIgnoreCase(CommandCfg.getInstance().getCmd("disable_res_check", "tools"))) {
                x0.d("XWebCleaner", "checkFiles, ignore res files check");
                z17 = b16;
            } else {
                z17 = b16 & c16;
            }
            if (!z17) {
                com.tencent.luggage.wxa.wq.a.a(c16, b16, false);
                x0.c("XWebCleaner", "checkFiles, check failed");
                XWalkEnvironment.setCoreVersionInfo(-1, null, b.b());
                return;
            } else {
                o16.edit().putInt("lastCheckVersion", availableVersion).commit();
                x0.d("XWebCleaner", "checkFiles success");
                return;
            }
        }
        x0.d("XWebCleaner", "checkFiles, invalid available version, version:" + availableVersion);
    }

    public static File d(int i3) {
        try {
            String m3 = u0.m(i3);
            File file = new File(m3);
            if (file.exists()) {
                x0.d("XWebCleaner", "getFileListConfigFile, path:" + m3);
                return file;
            }
            String h16 = u0.h(i3);
            File file2 = new File(h16);
            if (!file2.exists()) {
                return null;
            }
            x0.d("XWebCleaner", "getFileListConfigFile, path:" + h16);
            return file2;
        } catch (Throwable th5) {
            x0.a("XWebCleaner", "getFileListConfigFile error", th5);
            return null;
        }
    }

    public static void c(Context context) {
        if (context == null) {
            x0.c("XWebCleaner", "clearOldVersion failed, invalid context");
            return;
        }
        File file = new File(context.getApplicationInfo().dataDir);
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            x0.c("XWebCleaner", "clearOldVersion failed, files is null");
            return;
        }
        int availableVersion = XWalkEnvironment.getAvailableVersion();
        int a16 = a(listFiles, availableVersion);
        File[] listFiles2 = new File(file, "app_xweb_data").listFiles();
        if (listFiles2 == null) {
            x0.f("XWebCleaner", "clearOldVersion, filesNew is null");
        } else {
            a16 = Math.max(a(listFiles2, availableVersion), a16);
        }
        int installedNewstVersion = XWalkEnvironment.getInstalledNewstVersion("armeabi-v7a");
        int installedNewstVersion2 = XWalkEnvironment.getInstalledNewstVersion("arm64-v8a");
        x0.d("XWebCleaner", "clearOldVersion, availableVersion:" + availableVersion + ", newstVersion:" + a16 + ", newstVerForArm32:" + installedNewstVersion + ", newstVerForArm64:" + installedNewstVersion2);
        HashSet a17 = a();
        a(listFiles, a17, a16, installedNewstVersion, installedNewstVersion2);
        if (listFiles2 != null) {
            a(listFiles2, a17, a16, installedNewstVersion, installedNewstVersion2);
        }
    }

    public static long a(com.tencent.luggage.wxa.wq.c cVar, File file) {
        long j3;
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            j3 = 0;
            for (File file2 : listFiles) {
                long a16 = w.a(file2, !"cache".equalsIgnoreCase(file2.getName()));
                if (a16 > 0) {
                    j3 += a16;
                    x0.d("XWebCleaner", ">>>> getTotalPluginSize, plugin dir:" + file2.getName() + ", size:" + w.a(a16));
                    XWalkPluginManager.PluginInfo pluginInfoFromDir = XWalkPluginManager.getPluginInfoFromDir(file2);
                    if (pluginInfoFromDir != null) {
                        cVar.a(pluginInfoFromDir.pluginName, pluginInfoFromDir.pluginVersion, a16);
                    }
                }
            }
        } else {
            j3 = 0;
        }
        if (j3 > 0) {
            x0.d("XWebCleaner", ">> getTotalPluginSize, plugin total size:" + w.a(j3));
            cVar.c(j3);
        }
        return j3;
    }

    public static boolean b(int i3) {
        File d16 = d(i3);
        if (d16 == null) {
            if (XWalkEnvironment.isTestVersion(i3)) {
                x0.f("XWebCleaner", "doCheckFiles, configFile not exist, maybe test runtime or old runtime");
                return true;
            }
            x0.f("XWebCleaner", "doCheckFiles, no config file");
            n0.a(78L, 1);
            if (!"true".equalsIgnoreCase(CommandCfg.getInstance().getCmd("dis_config_file_check", "tools"))) {
                return false;
            }
            x0.d("XWebCleaner", "doCheckFiles, dis_config_file_check is true");
            return true;
        }
        return v.a(i3, d16);
    }

    public static long a(com.tencent.luggage.wxa.wq.c cVar, File file, String str) {
        long a16 = w.a(file, false);
        long j3 = 0;
        if (a16 > 0) {
            j3 = 0 + a16;
            x0.d("XWebCleaner", ">>>> getTotalCoreSize, xweb dir:" + str + ", size:" + w.a(a16));
            int a17 = a(file);
            if (a17 > 0) {
                cVar.a(a17, a16);
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    x0.d("XWebCleaner", ">>>> getTotalCoreSize, xweb sub dir:" + file2.getName() + ", size:" + w.a(w.a(file2, true)));
                }
            }
        }
        return j3;
    }

    public static void b(Context context, boolean z16) {
        if (z16 || x.a("clear_test_settings", 2592000000L)) {
            x0.d("XWebCleaner", "tryClearTestSetting");
            try {
                WebDebugCfg.getInst().cleanTestSetting();
            } catch (Throwable th5) {
                x0.a("XWebCleaner", "tryClearTestSetting error", th5);
            }
        }
    }

    public static void b(Context context) {
        if (context != null && context.getApplicationInfo() != null && context.getApplicationInfo().dataDir != null) {
            File file = new File(context.getApplicationInfo().dataDir);
            if (!file.exists()) {
                x0.c("XWebCleaner", "clearAllVersion failed, dataDir not exist");
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                x0.c("XWebCleaner", "clearAllVersion failed, files is null");
                return;
            }
            for (File file2 : listFiles) {
                String name = file2.getName();
                if (name.startsWith("app_xwalk_") && file2.isDirectory()) {
                    x0.d("XWebCleaner", "clearAllVersion, version:" + name);
                    int a16 = a(file2);
                    if (a16 > 0) {
                        g(a16);
                    }
                    w.a(file2.getAbsolutePath());
                }
                if (name.equals("app_xweb_data") && file2.isDirectory()) {
                    File[] listFiles2 = file2.listFiles();
                    if (listFiles2 == null) {
                        x0.c("XWebCleaner", "clearAllVersion, subFiles is null");
                    } else {
                        for (File file3 : listFiles2) {
                            String name2 = file3.getName();
                            if (name2.startsWith("xweb_") && file3.isDirectory()) {
                                x0.d("XWebCleaner", "clearAllVersion, version:" + name2);
                                int a17 = a(file3);
                                if (a17 > 0) {
                                    g(a17);
                                }
                                w.a(file3.getAbsolutePath());
                            }
                        }
                    }
                }
            }
            XWalkEnvironment.setCoreVersionInfo(-1, null, "armeabi-v7a");
            XWalkEnvironment.setCoreVersionInfo(-1, null, "arm64-v8a");
            return;
        }
        x0.c("XWebCleaner", "clearAllVersion failed, context is null");
    }

    public static void a(Context context, boolean z16) {
        if (!z16 && !x.a("CLEAR_OLD_APK", 86400000L)) {
            x0.d("XWebCleaner", "tryClearOldVersion, time not up");
        } else {
            c(context);
        }
    }

    public static void a(File[] fileArr, HashSet hashSet, int i3, int i16, int i17) {
        for (File file : fileArr) {
            int a16 = a(file);
            if (a16 < 0) {
                x0.d("XWebCleaner", "clearOldVersion, ignore file:" + file.getName());
            } else {
                if (hashSet.contains("" + a16)) {
                    x0.d("XWebCleaner", "clearOldVersion, version in keep list:" + a16);
                } else {
                    boolean cmdAsBoolean = CommandCfg.getInstance().getCmdAsBoolean("keep_nearest_version", "tools", false);
                    if (XWalkEnvironment.getBuildConfigThirdPartyRelease() || !cmdAsBoolean ? !(a16 <= 0 || a16 > i3 || a16 == XWalkEnvironment.getAvailableVersion() || a16 == i16 || a16 == i17) : !(a16 <= 0 || a16 >= i3 || a16 == XWalkEnvironment.getAvailableVersion() || a16 == i16 || a16 == i17)) {
                        try {
                            if (s0.a(a16)) {
                                x0.d("XWebCleaner", "clearOldVersion, keep version:" + a16 + ", core using, shouldKeepNearestVersion:" + cmdAsBoolean);
                            } else {
                                g(a16);
                                w.a(file.getAbsolutePath());
                                x0.d("XWebCleaner", "clearOldVersion, clear version:" + a16 + ", core not using, shouldKeepNearestVersion:" + cmdAsBoolean);
                                n0.a(577L, 65L, 1L);
                            }
                        } catch (Throwable th5) {
                            x0.d("XWebCleaner", "clearOldVersion failed, error:" + th5);
                            n0.a(577L, 66L, 1L);
                        }
                    } else {
                        x0.d("XWebCleaner", "clearOldVersion, keep version:" + a16 + ", shouldKeepNearestVersion:" + cmdAsBoolean);
                        f(a16);
                    }
                }
            }
        }
    }

    public static int a(File[] fileArr, int i3) {
        int i16 = 0;
        for (File file : fileArr) {
            int a16 = a(file);
            if (a16 >= 0 && a16 != i3 && a16 >= i16) {
                i16 = a16;
            }
        }
        return i16;
    }

    public static HashSet a() {
        String cmd = CommandCfg.getInstance().getCmd("KEEP_XWEB_CORE_LIST", "tools");
        x0.d("XWebCleaner", "getKeepVersionSet, KEEP_XWEB_CORE_LIST:" + cmd);
        HashSet hashSet = new HashSet();
        if (!TextUtils.isEmpty(cmd)) {
            String[] split = cmd.split(";");
            if (split.length > 0) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.trim())) {
                        hashSet.add(str.trim());
                    }
                }
            }
        }
        return hashSet;
    }

    public static boolean a(int i3) {
        x0.d("XWebCleaner", "clearVersion start, version:" + i3);
        if (i3 <= 0) {
            x0.f("XWebCleaner", "clearVersion failed, version is not valid");
            return false;
        }
        Context applicationContext = XWalkEnvironment.getApplicationContext();
        if (applicationContext != null && applicationContext.getApplicationInfo() != null && applicationContext.getApplicationInfo().dataDir != null) {
            File file = new File(applicationContext.getApplicationInfo().dataDir);
            if (!file.exists()) {
                x0.f("XWebCleaner", "clearVersion failed, dataDir not exist");
                return false;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                x0.f("XWebCleaner", "clearVersion failed, files is null");
                return false;
            }
            for (File file2 : listFiles) {
                int a16 = a(file2);
                if (a16 > 0 && a16 == i3 && w.a(file2.getAbsolutePath())) {
                    x0.d("XWebCleaner", "clearVersion, version:" + a16);
                    g(i3);
                    return true;
                }
                if (file2.getName().equals("app_xweb_data") && file2.isDirectory()) {
                    File[] listFiles2 = file2.listFiles();
                    if (listFiles2 == null) {
                        x0.c("XWebCleaner", "clearVersion, subFiles is null");
                    } else {
                        for (File file3 : listFiles2) {
                            int a17 = a(file3);
                            if (a17 > 0 && a17 == i3 && w.a(file2.getAbsolutePath())) {
                                x0.d("XWebCleaner", "clearVersion, version:" + a17);
                                g(a17);
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
        x0.f("XWebCleaner", "clearVersion failed, context is null");
        return false;
    }

    public static int a(File file) {
        if (file == null) {
            return -1;
        }
        String name = file.getName();
        if (name.startsWith("app_xwalk_") && file.isDirectory()) {
            try {
                return Integer.parseInt(name.substring(10));
            } catch (Throwable th5) {
                x0.a("XWebCleaner", "getApkVersion error, strFileName:" + name + ", error", th5);
            }
        } else if (name.startsWith("xweb_") && file.isDirectory()) {
            try {
                return Integer.parseInt(name.substring(5));
            } catch (Throwable th6) {
                x0.a("XWebCleaner", "getApkVersion error, strFileName:" + name + ", error", th6);
            }
        }
        return -1;
    }
}
