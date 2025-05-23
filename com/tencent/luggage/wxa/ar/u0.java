package com.tencent.luggage.wxa.ar;

import android.content.Context;
import com.tencent.rfix.loader.utils.RFixConstants;
import com.tencent.xweb.CommandCfg;
import com.tencent.xweb.xwalk.plugin.XWalkPlugin;
import java.io.File;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class u0 {
    public static String a() {
        if (XWalkEnvironment.getApplicationContext() == null || XWalkEnvironment.getApplicationContext().getCacheDir() == null) {
            return null;
        }
        String str = XWalkEnvironment.getApplicationContext().getCacheDir() + File.separator + "xweb_cache";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String b() {
        return XWalkEnvironment.getApplicationContext().getDir("xwalkplugin", 0).getAbsolutePath();
    }

    public static String c() {
        String b16 = b();
        if (b16.isEmpty()) {
            x0.c("XWebFileUtil", "getPluginTempDir error, baseDir is empty");
            return "";
        }
        String str = b16 + File.separator + "plugintemp";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String d() {
        return e() + File.separator + "pluginUpdateConfig.xml";
    }

    public static String e() {
        return XWalkEnvironment.getApplicationContext().getDir("xwalkconfig", 0).getAbsolutePath();
    }

    public static String f() {
        return e() + File.separator + "updateConfig.xml";
    }

    public static String g() {
        return e() + File.separator + "updateConfg.xml";
    }

    public static String h(int i3) {
        return a(i3, XWalkPlugin.FILELIST_CONFIG_NAME);
    }

    public static String i(int i3) {
        String str;
        if (t(i3)) {
            str = q(i3) + File.separator + "zip";
        } else if (a(i3)) {
            x0.d("XWebFileUtil", "getDownloadZipPath, version:" + i3 + ", use new data dir");
            str = r(i3) + File.separator + "zip";
        } else {
            str = q(i3) + File.separator + "zip";
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str + File.separator + "base.zip";
    }

    public static String j(int i3) {
        String str = q(i3) + File.separator + "extracted_xwalkcore";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String k(int i3) {
        String str = q(i3) + File.separator + "dex";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String l(int i3) {
        return b(i3, XWalkPlugin.PATCH_CONFIG_NAME);
    }

    public static String m(int i3) {
        return b(i3, XWalkPlugin.FILELIST_CONFIG_NAME);
    }

    public static String n(int i3) {
        return b(i3, "patch.xml");
    }

    public static String o(int i3) {
        String str = q(i3) + File.separator + "patch_temp_decompress";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String p(int i3) {
        String a16 = a();
        if (a16 == null) {
            return null;
        }
        String str = a16 + File.separator + "xweb_" + i3;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String q(int i3) {
        if (i3 <= 0) {
            x0.f("XWebFileUtil", "getVersionDataDir, version <= 0, version:" + i3);
            return "";
        }
        if (s(i3)) {
            return r(i3);
        }
        String absolutePath = XWalkEnvironment.getApplicationContext().getDir("xwalk_" + i3, 0).getAbsolutePath();
        File file = new File(absolutePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return absolutePath;
    }

    public static String r(int i3) {
        String str = XWalkEnvironment.getApplicationContext().getDir("xweb_data", 0).getAbsolutePath() + File.separator + "xweb_" + i3;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static boolean s(int i3) {
        String str = XWalkEnvironment.getApplicationContext().getApplicationInfo().dataDir;
        if (str != null) {
            File file = new File(str);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(file.getAbsolutePath());
            String str2 = File.separator;
            sb5.append(str2);
            sb5.append("app_xweb_data");
            sb5.append(str2);
            sb5.append("xweb_");
            sb5.append(i3);
            File file2 = new File(sb5.toString());
            if (file2.exists()) {
                File file3 = new File(file2.getAbsolutePath() + str2 + "zip");
                if (file3.exists() && file3.isDirectory()) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static boolean t(int i3) {
        String str = XWalkEnvironment.getApplicationContext().getApplicationInfo().dataDir;
        if (str != null) {
            File file = new File(str);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(file.getAbsolutePath());
            String str2 = File.separator;
            sb5.append(str2);
            sb5.append("app_xwalk_");
            sb5.append(i3);
            File file2 = new File(sb5.toString());
            if (file2.exists()) {
                File file3 = new File(file2.getAbsolutePath() + str2 + RFixConstants.APK_PATH + str2 + "base.apk");
                if (file3.exists() && file3.isFile()) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static boolean u(int i3) {
        File file = new File(e(i3));
        if (file.exists() && file.isFile()) {
            return true;
        }
        return false;
    }

    public static String d(int i3) {
        String str = q(i3) + File.separator + RFixConstants.APK_PATH;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String f(int i3) {
        return a(i3, "child_process.apk");
    }

    public static String g(int i3) {
        return a(i3, "reslist.config");
    }

    public static String b(int i3) {
        String str = j(i3) + File.separator + "child_process_dex";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String e(int i3) {
        return d(i3) + File.separator + "base.apk";
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d(Context context, int i3) {
        boolean z16;
        if (context == null) {
            x0.c("XWebFileUtil", "getVersionDir with context, context is null");
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(context.getDir("xweb_data", 0).getAbsolutePath());
        String str = File.separator;
        sb5.append(str);
        sb5.append("xweb_");
        sb5.append(i3);
        String sb6 = sb5.toString();
        File file = new File(sb6);
        if (file.exists()) {
            File file2 = new File(file.getAbsolutePath() + str + "zip");
            if (file2.exists() && file2.isDirectory()) {
                z16 = true;
                if (!z16) {
                    return sb6;
                }
                return context.getDir("xwalk_" + i3, 0).getAbsolutePath();
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    public static String a(int i3, String str) {
        return j(i3) + File.separator + str;
    }

    public static String b(int i3, String str) {
        return o(i3) + File.separator + str;
    }

    public static boolean a(int i3) {
        int minApkVersionForNewDataDir = CommandCfg.getInstance().getMinApkVersionForNewDataDir();
        if (minApkVersionForNewDataDir == -1) {
            return false;
        }
        return i3 >= minApkVersionForNewDataDir && !CommandCfg.getInstance().isVersionInMinApkVersionIgnoreList(i3);
    }

    public static String b(Context context) {
        if (context == null) {
            x0.c("XWebFileUtil", "getNewestVersionDir with context, context is null");
            return "";
        }
        XWalkEnvironment.ensureInitEnvironment(context);
        int installedNewstVersionForCurAbi = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
        x0.d("XWebFileUtil", "getNewestVersionDir, version:" + installedNewstVersionForCurAbi);
        return d(context, installedNewstVersionForCurAbi);
    }

    public static String c(int i3) {
        return j(i3) + File.separator + "classes.dex";
    }

    public static String c(Context context) {
        if (context == null) {
            x0.c("XWebFileUtil", "getPredownloadVersionDir with context, context is null");
            return "";
        }
        XWalkEnvironment.ensureInitEnvironment(context);
        int installedNewstVersionForPredownAbi = XWalkEnvironment.getInstalledNewstVersionForPredownAbi();
        x0.d("XWebFileUtil", "getPredownloadVersionDir, version:" + installedNewstVersionForPredownAbi);
        return d(context, installedNewstVersionForPredownAbi);
    }

    public static String a(int i3, int i16) {
        String str;
        if (t(i3)) {
            str = q(i3) + File.separator + "zip";
        } else if (a(i3)) {
            x0.d("XWebFileUtil", "getDownloadPatchPath, version:" + i3 + ", use new data dir");
            str = r(i3) + File.separator + "zip";
        } else {
            str = q(i3) + File.separator + "zip";
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (i16 == 1) {
            return str + File.separator + "patch.zip";
        }
        if (i16 == 2) {
            return str + File.separator + "hpatch.zip";
        }
        x0.c("XWebFileUtil", "invalid patchType in updateConfig");
        return "";
    }

    public static String b(Context context, int i3, String str) {
        if (context == null) {
            x0.c("XWebFileUtil", "getPatchZipTempDecompressFilePath with context, context is null");
            return "";
        }
        String d16 = d(context, i3);
        if (d16.isEmpty()) {
            x0.c("XWebFileUtil", "getPatchZipTempDecompressFilePath with context, versionDir is empty");
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(d16);
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append("patch_temp_decompress");
        sb5.append(str2);
        sb5.append(str);
        return sb5.toString();
    }

    public static String c(Context context, int i3) {
        return b(context, i3, XWalkPlugin.FILELIST_CONFIG_NAME);
    }

    public static boolean c(int i3, String str) {
        File file = new File(j(i3) + File.separator + str);
        return file.exists() && file.isFile();
    }

    public static String b(Context context, int i3) {
        return a(context, i3, XWalkPlugin.FILELIST_CONFIG_NAME);
    }

    public static String a(Context context) {
        if (context == null) {
            x0.c("XWebFileUtil", "getCurrentVersionDir with context, context is null");
            return "";
        }
        XWalkEnvironment.ensureInitEnvironment(context);
        int availableVersion = XWalkEnvironment.getAvailableVersion();
        x0.d("XWebFileUtil", "getCurrentVersionDir, version:" + availableVersion);
        return d(context, availableVersion);
    }

    public static String a(Context context, int i3) {
        if (context == null) {
            x0.c("XWebFileUtil", "getDownloadApkPath with context, context is null");
            return "";
        }
        String d16 = d(context, i3);
        if (d16.isEmpty()) {
            x0.c("XWebFileUtil", "getDownloadApkPath with context, versionDir is empty");
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(d16);
        String str = File.separator;
        sb5.append(str);
        sb5.append(RFixConstants.APK_PATH);
        sb5.append(str);
        sb5.append("base.apk");
        return sb5.toString();
    }

    public static String a(Context context, int i3, String str) {
        if (context == null) {
            x0.c("XWebFileUtil", "getExtractedCoreFile with context, context is null");
            return "";
        }
        String d16 = d(context, i3);
        if (d16.isEmpty()) {
            x0.c("XWebFileUtil", "getExtractedCoreFile with context, versionDir is empty");
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(d16);
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append("extracted_xwalkcore");
        sb5.append(str2);
        sb5.append(str);
        return sb5.toString();
    }
}
