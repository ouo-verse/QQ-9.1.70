package cooperation.qzone.patch;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzonePatchApi;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHelper;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes38.dex */
public class QZonePatchService {
    public static final String PATCH_MERGE_DIR = "patchs_merge";
    public static final String PATCH_O_DEX_DIR = "dex";
    public static final String PATCH_SUFFIX = ".jar";
    public static final String PATCH_SUFFIX_DEX = ".dex";
    public static final int RET_PATCH_DEL_SUCCEED = 11;
    public static final int RET_PATCH_DOWNLOAD_SUCCEED = 10;
    public static final int RET_PATCH_VERIFY_FAILED = 12;
    public static final String SP_MERGE_LENGTH = "p_merge_len";
    public static final String SP_MERGE_ODEX_LENGTH = "p_merge_odex_len";
    public static final String SP_QZONE_LENGTH = "p_qzone_len";
    public static final String SP_VERSION = "p_ver";
    public static final String TAG = "qz_patch";
    private static volatile boolean bPatchUpdating = false;
    private static String curPatchMd5;
    private static Object lock = new Object();
    private static QZonePatchService mInstance;
    private static int sPatchVersion;

    QZonePatchService() {
    }

    public static void cachePatchVersion(String str) {
        int patchVersion = getPatchVersion(str);
        sPatchVersion = patchVersion;
        resetPatchVersion(patchVersion);
    }

    private static void deleteMergeAndOdexFiles() {
        deleteMergedFiles();
        deleteMergedOdexFiles();
    }

    private static void deleteMergedFiles() {
        if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        File dir = BaseApplication.getContext().getDir(PATCH_MERGE_DIR, 0);
        if (dir.exists()) {
            for (File file : dir.listFiles()) {
                if (!file.isDirectory()) {
                    file.delete();
                }
            }
        }
        saveConfigPatchMergeFileLength(0L);
    }

    private static void deleteMergedOdexFiles() {
        if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        File dir = BaseApplication.getContext().getDir("dex", 0);
        if (dir.exists()) {
            for (File file : dir.listFiles()) {
                if (!file.isDirectory()) {
                    file.delete();
                }
            }
        }
        saveConfigPatchMergeOdexFileLength(0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ac A[Catch: Error -> 0x019a, TryCatch #2 {Error -> 0x019a, blocks: (B:5:0x0024, B:7:0x004f, B:9:0x0056, B:14:0x0060, B:18:0x007d, B:21:0x0085, B:22:0x00a6, B:24:0x00ac, B:26:0x0163, B:30:0x009f, B:33:0x0192), top: B:4:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0163 A[Catch: Error -> 0x019a, TryCatch #2 {Error -> 0x019a, blocks: (B:5:0x0024, B:7:0x004f, B:9:0x0056, B:14:0x0060, B:18:0x007d, B:21:0x0085, B:22:0x00a6, B:24:0x00ac, B:26:0x0163, B:30:0x009f, B:33:0x0192), top: B:4:0x0024 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void downloadPatchAndClear(String str, String str2) {
        String str3;
        String patchPath = getPatchPath(str);
        if (HttpDownloadUtil.download((AppInterface) BaseApplicationImpl.getApplication().getRuntime(), str2, new File(patchPath))) {
            int i3 = 1;
            try {
                log(HardCodeUtil.qqStr(R.string.s1i) + patchPath);
                int i16 = 0;
                File dir = BaseApplication.getContext().getDir(IQzonePatchApi.PATCH_DIR, 0);
                if (dir.exists()) {
                    File[] listFiles = dir.listFiles();
                    int length = listFiles.length;
                    while (i16 < length) {
                        File file = listFiles[i16];
                        if (!file.isDirectory()) {
                            if ((str + PATCH_SUFFIX).endsWith(file.getName())) {
                                try {
                                    str3 = PluginStatic.encodeFile(file.getAbsolutePath());
                                    try {
                                        log("\u8865\u4e01\u5305\u6587\u4ef6md5\u503c\uff1a" + str3);
                                    } catch (Exception e16) {
                                        e = e16;
                                        QLog.w("qz_patch", i3, QLog.getStackTraceString(e));
                                        if (!str.equalsIgnoreCase(str3)) {
                                        }
                                        i16++;
                                        i3 = 1;
                                    }
                                } catch (Exception e17) {
                                    e = e17;
                                    str3 = null;
                                }
                                if (!str.equalsIgnoreCase(str3)) {
                                    log("\u8865\u4e01\u5305md5\u548c\u7f51\u7edcmd5\u76f8\u540c");
                                    String str4 = QUA.getQUA3() + IQzonePatchApi.SP_LENGTH;
                                    long length2 = file.length();
                                    log(str4 + " = " + length2);
                                    LocalMultiProcConfig.putLong(str4, length2);
                                    QLog.d("qz_patch", 2, "download patch success. md5=" + str + ";len=" + length2);
                                    cachePatchVersion(str2);
                                    QZoneHelper.preloadQZoneForHaboReport((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), "qz_patch", getPatchResultCode(10, null), "md5=" + str + ";len=" + length2, 1, System.currentTimeMillis());
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("report [qz_patch] succeed download : ");
                                    sb5.append(getPatchResultCode(10, null));
                                    QLog.d("qz_patch", 1, sb5.toString());
                                    processPatchForAboveAndroidN(BaseApplication.getContext(), file.getAbsolutePath(), str);
                                } else {
                                    log("\u8865\u4e01\u5305md5\u548c\u7f51\u7edcmd5\u4e0d\u76f8\u540c");
                                    QLog.d("qz_patch", 1, "file md5: " + str3 + "but server md5 is: " + str + " please check the server patch md5 configuration.");
                                    file.delete();
                                }
                            } else {
                                file.delete();
                            }
                        }
                        i16++;
                        i3 = 1;
                    }
                }
            } catch (Error e18) {
                QLog.w("qz_patch", 1, QLog.getStackTraceString(e18));
            }
        }
    }

    private static long getConfigPatchMergeFileLength() {
        return LocalMultiProcConfig.getLong(QUA.getQUA3() + SP_MERGE_LENGTH, 0L);
    }

    private static long getConfigPatchMergeOdexFileLength() {
        return LocalMultiProcConfig.getLong(QUA.getQUA3() + SP_MERGE_ODEX_LENGTH, 0L);
    }

    private static long getConfigQZonePatchFileLength() {
        return LocalMultiProcConfig.getLong(QUA.getQUA3() + IQzonePatchApi.SP_LENGTH, 0L);
    }

    private static long getFileLength(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.length();
        }
        return 0L;
    }

    public static QZonePatchService getInstance() {
        if (mInstance == null) {
            synchronized (lock) {
                if (mInstance == null) {
                    mInstance = new QZonePatchService();
                }
            }
        }
        return mInstance;
    }

    private static String getPatchMergeOdexPath(String str) {
        return BaseApplication.getContext().getDir("dex", 0).getAbsolutePath() + File.separator + (str + PATCH_SUFFIX_DEX);
    }

    private static String getPatchMergePath(String str) {
        return BaseApplication.getContext().getDir(PATCH_MERGE_DIR, 0).getAbsolutePath() + File.separator + (str + PATCH_SUFFIX);
    }

    private static String getPatchPath(String str) {
        return BaseApplication.getContext().getDir(IQzonePatchApi.PATCH_DIR, 0).getAbsolutePath() + File.separator + (str + PATCH_SUFFIX);
    }

    private static int getPatchVersion(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        if (TextUtils.isEmpty(lastPathSegment)) {
            return 0;
        }
        Matcher matcher = Pattern.compile("_r(\\d+)").matcher(lastPathSegment);
        if (matcher.find()) {
            try {
                return Integer.parseInt(matcher.group(1));
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    private static String getQZonePluginPath() {
        File installedPluginPath = PluginUtils.getInstalledPluginPath(BaseApplicationImpl.sApplication, "qzone_plugin.apk");
        if (installedPluginPath != null) {
            return installedPluginPath.getAbsolutePath();
        }
        return null;
    }

    public static void log(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("qz_patch", 2, str);
        }
    }

    private static DexClassLoader preCompileMergePatch(Context context, String str, ClassLoader classLoader) {
        try {
            return new DexClassLoader(str, context.getDir("dex", 0).getAbsolutePath(), str, classLoader);
        } catch (Exception e16) {
            log("preCompileMergePatch failed :" + e16.getMessage() + "  stacktrace: " + Log.getStackTraceString(e16));
            return null;
        }
    }

    private static void processPatchForAboveAndroidN(Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT >= 24) {
            log("start to merge...");
            if (getConfigQZonePatchFileLength() == 0 || getConfigPatchMergeFileLength() == 0) {
                deleteMergeAndOdexFiles();
            }
            if (getConfigPatchMergeOdexFileLength() == 0) {
                deleteMergedOdexFiles();
            }
            String qZonePluginPath = getQZonePluginPath();
            if (qZonePluginPath != null) {
                if (getConfigQZonePatchFileLength() != 0 && getConfigQZonePatchFileLength() != getFileLength(str)) {
                    deleteMergeAndOdexFiles();
                    saveConfigQZonePatchFileLength(getFileLength(str));
                }
                String patchMergePath = getPatchMergePath(str2);
                if (getConfigPatchMergeFileLength() != 0 && getConfigPatchMergeFileLength() == getFileLength(patchMergePath)) {
                    log("---> merge : not merge share_pref len:" + getConfigPatchMergeFileLength() + "  file len:" + getFileLength(patchMergePath));
                } else {
                    deleteMergeAndOdexFiles();
                    log("---> merge :" + patchMergePath);
                    if (PatchMergeUtils.MergeApk(qZonePluginPath, str, patchMergePath)) {
                        saveConfigPatchMergeFileLength(getFileLength(patchMergePath));
                    } else {
                        deleteMergeAndOdexFiles();
                        return;
                    }
                }
                String patchMergeOdexPath = getPatchMergeOdexPath(str2);
                if (getConfigPatchMergeOdexFileLength() != 0 && getConfigPatchMergeOdexFileLength() == getFileLength(patchMergeOdexPath)) {
                    log("---> merge : not compile share_pref len:" + getConfigPatchMergeOdexFileLength() + " file len:" + getFileLength(patchMergeOdexPath));
                } else {
                    deleteMergedOdexFiles();
                    log("---> compile :" + patchMergeOdexPath);
                    if (preCompileMergePatch(context, patchMergePath, context.getClassLoader()) != null) {
                        saveConfigPatchMergeOdexFileLength(getFileLength(patchMergeOdexPath));
                        log("---> succeed to merge and compile, merge len:" + getFileLength(patchMergePath) + "   odex len:" + getFileLength(patchMergeOdexPath));
                    }
                }
            }
            log("end to merge...");
            return;
        }
        log("not need to merge...");
    }

    private static void resetPatchVersion(int i3) {
        LocalMultiProcConfig.putInt(AppSetting.d() + SP_VERSION, i3);
    }

    private static void saveConfigPatchMergeFileLength(long j3) {
        LocalMultiProcConfig.putLong(QUA.getQUA3() + SP_MERGE_LENGTH, j3);
    }

    private static void saveConfigPatchMergeOdexFileLength(long j3) {
        LocalMultiProcConfig.putLong(QUA.getQUA3() + SP_MERGE_ODEX_LENGTH, j3);
    }

    private static void saveConfigQZonePatchFileLength(long j3) {
        LocalMultiProcConfig.putLong(QUA.getQUA3() + SP_QZONE_LENGTH, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void verifyPatchFile() {
        String str;
        log(HardCodeUtil.qqStr(R.string.s1l));
        curPatchMd5 = null;
        File dir = BaseApplication.getContext().getDir(IQzonePatchApi.PATCH_DIR, 0);
        if (dir.exists()) {
            String str2 = QUA.getQUA3() + IQzonePatchApi.SP_LENGTH;
            long j3 = LocalMultiProcConfig.getLong(str2, 0L);
            log(str2 + " = " + j3);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(HardCodeUtil.qqStr(R.string.s1g));
            sb5.append(j3);
            log(sb5.toString());
            File[] listFiles = dir.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                int length = listFiles.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    File file = listFiles[i3];
                    if (file != null && !file.isDirectory()) {
                        if (j3 != file.length()) {
                            file.delete();
                        } else {
                            try {
                                str = PluginStatic.encodeFile(file.getAbsolutePath()).toLowerCase();
                            } catch (Exception e16) {
                                QLog.w("qz_patch", 1, QLog.getStackTraceString(e16));
                                str = null;
                            }
                            String name = file.getName();
                            String substring = name.substring(0, name.length() - 4);
                            if ((str + PATCH_SUFFIX).endsWith(name.toLowerCase())) {
                                curPatchMd5 = substring;
                                break;
                            }
                            file.delete();
                            deleteMergeAndOdexFiles();
                            QZoneHelper.preloadQZoneForHaboReport((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), "qz_patch", 12, "patch verify failed: file md5: " + str + " but expected md5: " + substring, 1, System.currentTimeMillis());
                            QLog.d("qz_patch", 1, "report [qz_patch] patch verify failed: file md5: " + str + " but expected md5: " + substring);
                            curPatchMd5 = null;
                        }
                    }
                    i3++;
                }
            }
        }
        if (TextUtils.isEmpty(curPatchMd5)) {
            log(HardCodeUtil.qqStr(R.string.s1f));
            return;
        }
        log("\u5f53\u524d\u8865\u4e01\u5305\u7684md5\u662f" + curPatchMd5);
    }

    public void onPatchResponse(final String str, final String str2) {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.IS_PATCH_ENABLE, 1) == 0) {
            return;
        }
        ThreadManagerV2.postDownLoadTask(new Runnable() { // from class: cooperation.qzone.patch.QZonePatchService.1
            @Override // java.lang.Runnable
            public void run() {
                QZonePatchService.log(HardCodeUtil.qqStr(R.string.s1m));
                QZonePatchService.log(HardCodeUtil.qqStr(R.string.s1n));
                QZonePatchService.verifyPatchFile();
                QZonePatchService.updatePatchDex(str, str2);
            }
        }, 8, null, false);
    }

    public static int getPatchResultCode(int i3, String str) {
        return str == null ? (sPatchVersion * 10000) + i3 : i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updatePatchDex(String str, String str2) {
        log(HardCodeUtil.qqStr(R.string.s1j));
        if (TextUtils.isEmpty(str)) {
            log(HardCodeUtil.qqStr(R.string.s1o));
            return;
        }
        if (bPatchUpdating) {
            return;
        }
        bPatchUpdating = true;
        if (curPatchMd5 == null) {
            QLog.d("qz_patch", 1, "\u672c\u5730\u6ca1\u6709\u8865\u4e01\u5305");
            if (!"del".equals(str) && str2 != null && !TextUtils.isEmpty(str2)) {
                downloadPatchAndClear(str, str2);
                curPatchMd5 = str;
            }
        } else {
            QLog.d("qz_patch", 1, "\u672c\u5730\u6709\u8865\u4e01\u5305");
            if (curPatchMd5.equals(str)) {
                log(HardCodeUtil.qqStr(R.string.s1k));
                processPatchForAboveAndroidN(BaseApplication.getContext(), getPatchPath(str), str);
            } else if (!str.equals("del") && !str.equals("delete")) {
                log(HardCodeUtil.qqStr(R.string.s1h));
                deleteMergeAndOdexFiles();
                if (str2 != null && !TextUtils.isEmpty(str2)) {
                    downloadPatchAndClear(str, str2);
                    curPatchMd5 = str;
                }
            } else {
                QLog.d("qz_patch", 1, "md5\u662fdel\uff0c\u76f4\u63a5\u5220\u9664\u65e7\u7684Patch");
                try {
                    File dir = BaseApplication.getContext().getDir(IQzonePatchApi.PATCH_DIR, 0);
                    if (dir.exists()) {
                        for (File file : dir.listFiles()) {
                            if (!file.isDirectory()) {
                                file.delete();
                            }
                        }
                    }
                    LocalMultiProcConfig.putLong(QUA.getQUA3() + IQzonePatchApi.SP_LENGTH, 0L);
                    curPatchMd5 = null;
                    deleteMergeAndOdexFiles();
                } catch (Throwable th5) {
                    QLog.w("qz_patch", 1, QLog.getStackTraceString(th5));
                }
                QZoneHelper.preloadQZoneForHaboReport((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), "qz_patch", 11, "clear patch:" + curPatchMd5, 1, System.currentTimeMillis());
                QLog.d("qz_patch", 1, "report [qz_patch] clear patch:" + curPatchMd5);
            }
        }
        bPatchUpdating = false;
    }
}
