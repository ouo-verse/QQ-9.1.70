package com.tencent.xweb.xwalk.plugin;

import android.content.SharedPreferences;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.luggage.wxa.ar.b0;
import com.tencent.luggage.wxa.ar.j0;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.u0;
import com.tencent.luggage.wxa.ar.w;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.y;
import com.tencent.luggage.wxa.ar.y0;
import com.tencent.luggage.wxa.wq.b;
import com.tencent.xweb.xwalk.plugin.XWalkPluginPatchConfigParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.xwalk.core.XWalkEnvironment;

/* loaded from: classes27.dex */
public abstract class XWalkPlugin {
    public static final String EXTRACTED_DIR_NAME = "extracted";
    public static final String FILELIST_CONFIG_NAME = "filelist.config";
    public static final int INSTALL_ERROR_CODE_CONFIG_ERROR = -1;
    public static final int INSTALL_ERROR_CODE_DO_PATCH_ERROR = -3;
    public static final int INSTALL_ERROR_CODE_EMBED_COPY_ERROR = -6;
    public static final int INSTALL_ERROR_CODE_EMBED_INFO_ERROR = -5;
    public static final int INSTALL_ERROR_CODE_EXCEPTION = -4;
    public static final int INSTALL_ERROR_CODE_NONE = 0;
    public static final int INSTALL_ERROR_CODE_UNZIP_AND_CHECK_ERROR = -2;
    public static final String PATCH_CONFIG_NAME = "patch.config";
    public static final String PATCH_DIR_NAME = "patch_temp";
    public static final String PRIVATE_CACHE_DIR_NAME = "cache";

    /* renamed from: a, reason: collision with root package name */
    public int f385143a = -1;

    /* renamed from: b, reason: collision with root package name */
    public String f385144b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f385145c = "";

    /* renamed from: d, reason: collision with root package name */
    public int f385146d = -1;

    public XWalkPlugin() {
        a();
    }

    public final void a() {
        if (XWalkEnvironment.getApplicationContext() == null) {
            x0.c(getPluginName(), "loadVer, context is null");
            return;
        }
        SharedPreferences e16 = y0.e(getPluginName());
        if (e16 == null) {
            x0.c(getPluginName(), "loadVer, sp is null");
            return;
        }
        int i3 = this.f385146d;
        int i16 = e16.getInt("availableVersion", -1);
        this.f385146d = i16;
        if (i16 != i3) {
            if (i3 == -1) {
                x0.d(getPluginName(), "loadVer, version = " + this.f385146d);
                return;
            }
            x0.d(getPluginName(), "loadVer, old version = " + i3 + ", new version = " + this.f385146d);
        }
    }

    public boolean b(j0 j0Var) {
        File file;
        x0.d(getPluginName(), "unZipAndCheck version " + j0Var.f121684l);
        File file2 = new File(j0Var.f121697y);
        ZipFile zipFile = null;
        try {
            if (!y.a(j0Var.f121697y, j0Var.f121676d)) {
                x0.d(getPluginName(), "unZipAndCheck failed, zip md5 not match");
                return false;
            }
            ZipFile zipFile2 = new ZipFile(j0Var.f121697y);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    String encode = URLEncoder.encode(nextElement.getName(), "UTF-8");
                    if (!encode.contains("../") && !encode.contains("..\\") && !nextElement.isDirectory()) {
                        InputStream inputStream = zipFile2.getInputStream(nextElement);
                        if (j0Var.f121678f) {
                            file = new File(getPatchFile(j0Var.f121684l, encode));
                        } else {
                            file = new File(getExtractFile(j0Var.f121684l, encode));
                        }
                        if (!w.a(inputStream, file)) {
                            x0.c(getPluginName(), "unZipAndCheck error, return");
                            w.a(zipFile2);
                            if (file2.exists()) {
                                file2.delete();
                            }
                            return false;
                        }
                    }
                }
                if (!j0Var.f121696x && !j0Var.f121678f) {
                    if (checkFileListConfig(j0Var.f121684l, false) != 0) {
                        x0.c(getPluginName(), "unZipAndCheck md5 check failed");
                        w.a(zipFile2);
                        if (file2.exists()) {
                            file2.delete();
                        }
                        return false;
                    }
                    w.a(zipFile2);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    return true;
                }
                w.a(zipFile2);
                if (file2.exists()) {
                    file2.delete();
                }
                return true;
            } catch (Throwable th5) {
                th = th5;
                zipFile = zipFile2;
                try {
                    x0.c(getPluginName(), "unZipAndCheck error: " + th);
                    w.a(zipFile);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    return false;
                } finally {
                    w.a(zipFile);
                    if (file2.exists()) {
                        file2.delete();
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public boolean canDownloadPatch(int i3) {
        if (XWalkEnvironment.getApplicationContext() == null) {
            x0.c(getPluginName(), "canDownloadPatch, context is null");
            return false;
        }
        SharedPreferences e16 = y0.e(getPluginName());
        if (e16 == null) {
            x0.c(getPluginName(), "canDownloadPatch, sp is null");
            return false;
        }
        if (e16.getInt("patchDownloadCount_" + i3, 0) <= 1) {
            x0.d(getPluginName(), "canDownloadPatch, ret = true");
            return true;
        }
        x0.d(getPluginName(), "canDownloadPatch, ret = false");
        return false;
    }

    public int checkFileListConfig(int i3, boolean z16) {
        return checkFileListConfig(i3, z16, null);
    }

    public abstract void checkFiles();

    public void checkKeyFiles(int i3) {
        String str;
        String versionDir;
        int availableVersion = getAvailableVersion(true);
        if (availableVersion > 0) {
            List<String> keyFilesPath = getKeyFilesPath(availableVersion);
            if (keyFilesPath == null) {
                b.a(i3, getPluginName(), availableVersion, 7, "keyFilesList");
                return;
            }
            for (int i16 = 0; i16 < keyFilesPath.size(); i16++) {
                if (keyFilesPath.get(i16) != null) {
                    File file = new File(keyFilesPath.get(i16));
                    if (!file.exists() || !file.isFile()) {
                        x0.c(getPluginName(), "apk file in version = (" + availableVersion + ") missed");
                        if (keyFilesPath.get(i16) != null && !keyFilesPath.get(i16).isEmpty()) {
                            String[] split = keyFilesPath.get(i16).split(File.separator);
                            if (split.length > 0) {
                                str = split[split.length - 1];
                                b.a(i3, getPluginName(), availableVersion, 2, str);
                                setAvailableVersion(-1, true);
                                versionDir = getVersionDir(availableVersion);
                                if (versionDir == null && !versionDir.isEmpty()) {
                                    w.a(versionDir);
                                    return;
                                }
                                return;
                            }
                        }
                        str = "";
                        b.a(i3, getPluginName(), availableVersion, 2, str);
                        setAvailableVersion(-1, true);
                        versionDir = getVersionDir(availableVersion);
                        if (versionDir == null) {
                            return;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    public boolean clearPatchDownloadInfo() {
        if (XWalkEnvironment.getApplicationContext() == null) {
            x0.c(getPluginName(), "clearPatchDownloadInfo, context is null");
            return false;
        }
        SharedPreferences e16 = y0.e(getPluginName());
        if (e16 == null) {
            x0.c(getPluginName(), "clearPatchDownloadInfo, sp is null");
            return false;
        }
        Map<String, ?> all = e16.getAll();
        if (all != null && all.size() != 0) {
            SharedPreferences.Editor edit = e16.edit();
            for (String str : all.keySet()) {
                if (str != null && str.startsWith("patchDownloadCount_")) {
                    x0.d(getPluginName(), "clearPatchDownloadInfo, remove key " + str);
                    edit.remove(str);
                }
            }
            return edit.commit();
        }
        return true;
    }

    public int getAvailableVersion() {
        return this.f385146d;
    }

    public abstract String getDownloadFullPath(int i3, boolean z16);

    public String getEmbedFileMD5() {
        return this.f385145c;
    }

    public String getEmbedFileName() {
        return this.f385144b;
    }

    public int getEmbedVersion() {
        return this.f385143a;
    }

    public String getExtractDir(int i3) {
        String versionDir = getVersionDir(i3);
        if (versionDir.isEmpty()) {
            x0.c(getPluginName(), "getExtractDir, versionDir is empty");
            return "";
        }
        String str = versionDir + File.separator + EXTRACTED_DIR_NAME;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public String getExtractFile(int i3, String str) {
        if (str != null && !str.isEmpty()) {
            String extractDir = getExtractDir(i3);
            if (extractDir.isEmpty()) {
                x0.c(getPluginName(), "getExtractFile, extractDir is empty");
                return "";
            }
            return extractDir + File.separator + str;
        }
        x0.c(getPluginName(), "getExtractFile, fileName is empty");
        return "";
    }

    public abstract List<String> getKeyFilesPath(int i3);

    public String getPatchDir(int i3) {
        String versionDir = getVersionDir(i3);
        if (versionDir.isEmpty()) {
            x0.c(getPluginName(), "getPatchDir, versionDir is empty");
            return "";
        }
        String str = versionDir + File.separator + PATCH_DIR_NAME;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public String getPatchFile(int i3, String str) {
        if (str != null && !str.isEmpty()) {
            String patchDir = getPatchDir(i3);
            if (patchDir.isEmpty()) {
                x0.c(getPluginName(), "getPatchFile, patchDir is null");
                return "";
            }
            return patchDir + File.separator + str;
        }
        x0.c(getPluginName(), "getPatchFile, fileName is empty");
        return "";
    }

    public abstract String getPluginName();

    public String getPrivateCacheDir(int i3) {
        String versionDir = getVersionDir(i3);
        if (versionDir != null && !versionDir.isEmpty()) {
            String str = versionDir + File.separator + "cache";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            return str;
        }
        x0.c(getPluginName(), "getPrivateCacheDir, versionDir is empty");
        return "";
    }

    public String getVersionDir(int i3) {
        if (XWalkEnvironment.getApplicationContext() == null) {
            x0.c(getPluginName(), "getVersionDir, context is null");
            return "";
        }
        String b16 = u0.b();
        if (b16.isEmpty()) {
            x0.c(getPluginName(), "getVersionDir, pluginBaseDir is null");
            return "";
        }
        String str = b16 + File.separator + getPluginName() + "_" + i3;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public boolean hasEmbed() {
        String str;
        String str2;
        if (this.f385143a > 0 && (str = this.f385144b) != null && !str.isEmpty() && (str2 = this.f385145c) != null && !str2.isEmpty()) {
            return true;
        }
        return false;
    }

    public abstract boolean isDownloadImmediately();

    public abstract boolean isIgnoreForbidDownloadCode();

    public abstract int performInstall(j0 j0Var);

    public boolean recordPatchDownloadInfo(int i3) {
        if (XWalkEnvironment.getApplicationContext() == null) {
            x0.c(getPluginName(), "recordPatchDownloadInfo, context is null");
            return false;
        }
        SharedPreferences e16 = y0.e(getPluginName());
        if (e16 == null) {
            x0.c(getPluginName(), "recordPatchDownloadInfo, sp is null");
            return false;
        }
        String str = "patchDownloadCount_" + i3;
        int i16 = e16.getInt(str, 0);
        SharedPreferences.Editor edit = e16.edit();
        edit.putInt(str, i16 + 1);
        return edit.commit();
    }

    public void reportUsingVersion(int i3, int i16, int i17, int i18) {
        if (i3 <= 0) {
            x0.c(getPluginName(), "reportUsingVersion, reportVersion invalid");
            return;
        }
        SharedPreferences e16 = y0.e(getPluginName());
        if (e16 == null) {
            x0.c(getPluginName(), "reportUsingVersion, sp is null");
            return;
        }
        int i19 = e16.getInt("lastReportVersion", -1);
        String string = e16.getString("lastReportDate", "");
        try {
            String format = new SimpleDateFormat(DateUtil.DATE_FORMAT_8).format(new Date());
            if (i19 != i3 || !string.equals(format)) {
                int i26 = i17 + (i3 % (i18 - i17));
                x0.b(getPluginName(), "reportUsingVersion, id:" + i16 + ", key:" + i26);
                n0.a((long) i16, (long) i26, 1L);
                SharedPreferences.Editor edit = e16.edit();
                if (edit != null) {
                    edit.putInt("lastReportVersion", i3);
                    edit.putString("lastReportDate", format);
                    edit.commit();
                    return;
                }
                x0.c(getPluginName(), "reportUsingVersion, editor is null");
            }
        } catch (Throwable th5) {
            x0.c(getPluginName(), "reportUsingVersion, get cur date error: " + th5);
        }
    }

    public boolean setAvailableVersion(int i3, boolean z16) {
        if (XWalkEnvironment.getApplicationContext() == null) {
            x0.c(getPluginName(), "setVer, context is null");
            return false;
        }
        SharedPreferences e16 = y0.e(getPluginName());
        if (e16 == null) {
            x0.c(getPluginName(), "setVer, sp is null");
            return false;
        }
        SharedPreferences.Editor edit = e16.edit();
        edit.putInt("availableVersion", i3);
        boolean commit = edit.commit();
        if (commit && z16) {
            this.f385146d = i3;
        }
        x0.d(getPluginName(), "setVer, version = " + i3 + ", isNow = " + z16 + ", ret = " + commit);
        return commit;
    }

    public void setEmbedInfo(int i3, String str, String str2) {
        this.f385143a = i3;
        this.f385144b = str;
        this.f385145c = str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00d1, code lost:
    
        return 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int checkFileListConfig(int i3, boolean z16, String str) {
        BufferedReader bufferedReader;
        String str2;
        String str3;
        x0.d(getPluginName(), "checkFileListConfig, version = " + i3);
        if (i3 < 0) {
            x0.d(getPluginName(), "checkFileListConfig, version invalid");
            return 1;
        }
        File file = new File(getExtractFile(i3, FILELIST_CONFIG_NAME));
        if (!file.exists()) {
            if (z16) {
                x0.d(getPluginName(), "checkFileListConfig, no filelist.config, skip");
                return 0;
            }
            x0.c(getPluginName(), "checkFileListConfig, no filelist.config, return");
            return 4;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (!readLine.isEmpty()) {
                            String[] split = readLine.split(":");
                            if (split.length == 2 && (str2 = split[0]) != null && !str2.isEmpty() && (str3 = split[1]) != null && !str3.isEmpty()) {
                                String str4 = split[0];
                                String str5 = split[1];
                                String extractFile = getExtractFile(i3, str4);
                                if (extractFile == null) {
                                    w.a(bufferedReader);
                                    return 3;
                                }
                                File file2 = new File(extractFile);
                                if (!file2.exists() || !file2.isFile()) {
                                    break;
                                }
                                if (!y.a(extractFile, str5)) {
                                    x0.c(getPluginName(), "checkFileListConfig, md5 not match: " + str4);
                                    w.a(bufferedReader);
                                    return 5;
                                }
                            }
                        }
                    } else {
                        x0.d(getPluginName(), "checkFileListConfig success");
                        return 0;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        x0.c(getPluginName(), "checkFileListConfig error: " + th);
                        w.a(bufferedReader);
                        return 6;
                    } finally {
                        w.a(bufferedReader);
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedReader = null;
        }
    }

    public int getAvailableVersion(boolean z16) {
        if (z16) {
            a();
        }
        return this.f385146d;
    }

    public boolean a(j0 j0Var) {
        int availableVersion = getAvailableVersion();
        x0.d(getPluginName(), "doPatch current version = " + availableVersion + ", new version = " + j0Var.f121684l);
        if (availableVersion < 0) {
            x0.c(getPluginName(), "doPatch, current version invalid");
            return false;
        }
        if (!j0Var.f121678f) {
            x0.c(getPluginName(), "doPatch, current download config is not patch");
            return false;
        }
        File file = new File(getPatchFile(j0Var.f121684l, PATCH_CONFIG_NAME));
        if (!file.exists()) {
            x0.c(getPluginName(), "doPatch, can not find patch config file");
            return false;
        }
        List<XWalkPluginPatchConfigParser.PluginPatchConfig> pluginPatchConfigList = XWalkPluginPatchConfigParser.getPluginPatchConfigList(file);
        if (pluginPatchConfigList != null && pluginPatchConfigList.size() != 0) {
            if (!w.a(getExtractDir(availableVersion), getExtractDir(j0Var.f121684l), false)) {
                x0.c(getPluginName(), "doPatch, copy files failed");
                return false;
            }
            for (XWalkPluginPatchConfigParser.PluginPatchConfig pluginPatchConfig : pluginPatchConfigList) {
                if (pluginPatchConfig.isTypeAdd()) {
                    if (!w.a(getPatchFile(j0Var.f121684l, pluginPatchConfig.originalFileName), getExtractFile(j0Var.f121684l, pluginPatchConfig.originalFileName))) {
                        x0.c(getPluginName(), "doPatch, add file error: " + pluginPatchConfig);
                        return false;
                    }
                    x0.d(getPluginName(), "doPatch, add file:" + pluginPatchConfig);
                } else if (pluginPatchConfig.isTypeRemove()) {
                    if (!w.b(getExtractFile(j0Var.f121684l, pluginPatchConfig.originalFileName))) {
                        x0.c(getPluginName(), "doPatch, delete file error:" + pluginPatchConfig);
                    } else {
                        x0.d(getPluginName(), "doPatch, delete file:" + pluginPatchConfig);
                    }
                } else if (pluginPatchConfig.isTypeModify()) {
                    if (b0.a(1).a(getExtractFile(j0Var.f121684l, pluginPatchConfig.originalFileName), getPatchFile(j0Var.f121684l, pluginPatchConfig.patchFileName), getExtractFile(j0Var.f121684l, pluginPatchConfig.originalFileName)) < 0) {
                        x0.c(getPluginName(), "doPatch, patch file error:" + pluginPatchConfig);
                        return false;
                    }
                    x0.d(getPluginName(), "doPatch, patch file:" + pluginPatchConfig);
                } else {
                    x0.c(getPluginName(), "doPatch, unknown op" + pluginPatchConfig);
                    return false;
                }
            }
            w.b(getExtractFile(j0Var.f121684l, FILELIST_CONFIG_NAME));
            if (!w.a(getPatchFile(j0Var.f121684l, FILELIST_CONFIG_NAME), getExtractFile(j0Var.f121684l, FILELIST_CONFIG_NAME))) {
                x0.c(getPluginName(), "doPatch, copy filelist.config error");
                return false;
            }
            if (checkFileListConfig(j0Var.f121684l, false) != 0) {
                x0.c(getPluginName(), "doPatch, check md5 failed");
                return false;
            }
            String patchDir = getPatchDir(j0Var.f121684l);
            if (!patchDir.isEmpty()) {
                w.a(patchDir);
            }
            return true;
        }
        x0.c(getPluginName(), "doPatch, patchConfigList = null");
        return false;
    }
}
