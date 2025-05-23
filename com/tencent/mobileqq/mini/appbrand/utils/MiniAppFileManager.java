package com.tencent.mobileqq.mini.appbrand.utils;

import android.app.Activity;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.ApkgBaseInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.mobileqq.minigame.manager.MiniGameStorageExceedManager;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduleUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppFileManager {
    public static final String APP_ROOT = "/data/data/com.tencent.mobileqq/";
    public static final String FILE_PREFIX_PRE_CACHE = "precache";
    public static final String FILE_PREFIX_STORE = "store";
    public static final String FILE_PREFIX_TMP = "tmp";
    public static final String FILE_PREFIX_USR = "usr";
    public static final int FILE_TYPE_PRE_CACHE = 4;
    public static final int FILE_TYPE_STORE = 1;
    public static final int FILE_TYPE_TMP = 0;
    public static final int FILE_TYPE_UNKOWN = 9999;
    public static final int FILE_TYPE_USR = 2;
    private static final long MINI_APP_STORAGE_MAX_SIZE = 10485760;
    private static final String MINI_FILE_ROOT_NAME = "/tencent/mini/";
    public static final String MINI_FILE_ROOT_PATH;
    public static final String MINI_FILE_SAVE_PATH;
    private static final String MINI_FILE_SUB_NAME = "files/";
    private static final long MINI_GAME_STORAGE_MAX_SIZE = 52428800;
    private static final String MINI_LOADING_AD_NAME = "adcache";
    private static final String TAG = "MiniAppFileManager";
    public static final String WXFILE_PREFIX_PRE_CACHE;
    public static final String WXFILE_PREFIX_STORE;
    public static final String WXFILE_PREFIX_TMP;
    public static final String WXFILE_PREFIX_USR;
    private static String currentAppId;
    private static String currentAppSdcardDir;
    private static String currentUin;
    private static boolean hasCheckUsrDir;
    private static boolean isNoMediaCreated;
    private static volatile MiniAppFileManager sInstance;
    private WeakReference<Activity> activityWeakReference;
    private ApkgBaseInfo apkgInfo;
    private String curMiniAppId;
    private ConcurrentHashMap<String, String> curWxFileToLocalMap;
    private CountDownLatch initStoreCountDown;
    private CountDownLatch initUsrCountDown;
    private ArrayList<String> mTmpFileNeed2DeleteAsync = new ArrayList<>();
    private String currentAppSdcardPath = "";
    private AtomicLong storeFolderSize = new AtomicLong(0);
    private AtomicLong usrFolderSize = new AtomicLong(0);
    private AtomicInteger storeUpdateCount = new AtomicInteger(0);
    private AtomicInteger usrUpdateCount = new AtomicInteger(0);

    static {
        StringBuilder sb5 = new StringBuilder();
        String str = MiniAppGlobal.STR_WXFILE;
        sb5.append(str);
        sb5.append("tmp_");
        WXFILE_PREFIX_TMP = sb5.toString();
        WXFILE_PREFIX_STORE = str + "store_";
        WXFILE_PREFIX_USR = str + "usr";
        WXFILE_PREFIX_PRE_CACHE = str + "precache";
        String str2 = getExternalPath() + MINI_FILE_ROOT_NAME;
        MINI_FILE_ROOT_PATH = str2;
        MINI_FILE_SAVE_PATH = str2 + MINI_FILE_SUB_NAME;
        isNoMediaCreated = false;
    }

    private static void checkUsrDir(String str) {
        if (hasCheckUsrDir) {
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        hasCheckUsrDir = true;
    }

    private static synchronized void createNoMediaInMiniPath() {
        synchronized (MiniAppFileManager.class) {
            if (isNoMediaCreated) {
                return;
            }
            File file = new File(MINI_FILE_SAVE_PATH, ".nomedia");
            try {
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                isNoMediaCreated = true;
            } catch (IOException e16) {
                QLog.e("[mini] ", 1, "exception in create .nomedia of mini files", e16);
            }
        }
    }

    private static String getCurAppSdcardDir(String str) {
        String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        if (!TextUtils.isEmpty(account) && !TextUtils.isEmpty(str)) {
            if (account.equals(currentUin) && str.equals(currentAppId) && !TextUtils.isEmpty(currentAppSdcardDir)) {
                return currentAppSdcardDir;
            }
            currentAppId = str;
            currentUin = account;
            String str2 = MINI_FILE_SAVE_PATH + MD5Utils.toMD5(str) + "/" + MD5Utils.toMD5(account);
            currentAppSdcardDir = str2;
            return str2;
        }
        QLog.e(TAG, 1, "getCurAppSdcardDir error. curMiniAppId : " + str);
        return MINI_FILE_SAVE_PATH;
    }

    private String getFileName(String str) {
        String str2 = WXFILE_PREFIX_TMP;
        if (str.startsWith(str2)) {
            return str.replace(str2, "");
        }
        String str3 = WXFILE_PREFIX_STORE;
        if (str.startsWith(str3)) {
            return str.replace(str3, "");
        }
        String str4 = WXFILE_PREFIX_USR;
        if (!str.startsWith(str4)) {
            return "";
        }
        return new File(str.replace(str4, "")).getName();
    }

    public static String getFileSuffix(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf < 0) {
            return "";
        }
        return name.substring(lastIndexOf + 1);
    }

    public static MiniAppFileManager getInstance() {
        if (sInstance == null) {
            synchronized (MiniAppFileManager.class) {
                if (sInstance == null) {
                    sInstance = new MiniAppFileManager();
                }
            }
        }
        return sInstance;
    }

    public static String getLoadingAdCacheFilePath(String str, String str2) {
        return getLoadingAdCacheFolder() + MD5Utils.toMD5(str) + "_" + MD5Utils.toMD5(str2);
    }

    public static String getLoadingAdCacheFolder() {
        return PreDownloadScheduleUtil.getPreDownloadPathStatic(MINI_LOADING_AD_NAME, PreDownloadConstants.DEPARTMENT_VAS, false) + "/";
    }

    public static String getLocalPathSuffix(String str) {
        int length;
        char charAt;
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || (length = str.length()) == 0 || (charAt = str.charAt(length - 1)) == '/' || charAt == '\\' || charAt == '.' || (lastIndexOf = str.lastIndexOf(46)) <= Math.max(str.lastIndexOf(47), str.lastIndexOf(92))) {
            return "";
        }
        return str.substring(lastIndexOf + 1).toLowerCase();
    }

    private static String getMiniFolderPath(int i3, String str) {
        String str2 = "tmp";
        if (i3 != 0) {
            if (i3 == 1) {
                str2 = "store";
            } else if (i3 == 2) {
                str2 = "usr";
            } else if (i3 == 4) {
                str2 = "precache";
            }
        }
        createNoMediaInMiniPath();
        String str3 = getCurAppSdcardDir(str) + "/" + str2;
        if (i3 == 2) {
            checkUsrDir(str3);
        }
        return str3;
    }

    public static String getPreCacheFilePath(String str, String str2) {
        return getPreCacheFilePath(str, null, str2);
    }

    private String getRandomFileName() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(Thread.currentThread().getId());
        sb5.append(System.nanoTime());
        return MD5.toMD5(sb5.toString());
    }

    private static String getSuffixByPath(String str) {
        if (URLUtil.isNetworkUrl(str)) {
            return getUrlPathSuffix(str);
        }
        return getLocalPathSuffix(str);
    }

    private static String getUrlPathSuffix(String str) {
        int lastIndexOf;
        int i3;
        try {
            str = new URL(str).getPath();
        } catch (Throwable th5) {
            QMLog.e(TAG, "getSuffixByPath error", th5);
        }
        if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(".")) != -1 && (i3 = lastIndexOf + 1) < str.length()) {
            return str.substring(i3);
        }
        return "";
    }

    private void initFileSize() {
        this.initUsrCountDown = new CountDownLatch(1);
        ThreadPools.getDiskIOThreadPool().execute(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MiniAppFileManager.this.usrFolderSize.set(com.tencent.mobileqq.utils.FileUtils.getFileOrFolderSize(MiniAppFileManager.this.getMiniFolderPath(2)));
                } catch (Throwable unused) {
                }
                MiniAppFileManager.this.initUsrCountDown.countDown();
            }
        });
        this.initStoreCountDown = new CountDownLatch(1);
        ThreadPools.getDiskIOThreadPool().execute(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MiniAppFileManager.this.storeFolderSize.set(com.tencent.mobileqq.utils.FileUtils.getFileOrFolderSize(MiniAppFileManager.this.getMiniFolderPath(1)));
                } catch (Throwable unused) {
                }
                MiniAppFileManager.this.initStoreCountDown.countDown();
            }
        });
    }

    public void clearAllCache() {
        com.tencent.mobileqq.utils.FileUtils.delete(MiniAppGlobal.getMiniCacheFilePath(), false);
        this.usrFolderSize.set(0L);
        this.storeFolderSize.set(0L);
        hasCheckUsrDir = false;
    }

    public void clearFileCache(String str) {
        String str2 = MiniAppGlobal.getMiniCacheFilePath() + MD5.toMD5(str);
        if (new File(str2).exists()) {
            com.tencent.mobileqq.utils.FileUtils.delete(str2, false);
            this.usrFolderSize.set(0L);
            this.storeFolderSize.set(0L);
        }
        hasCheckUsrDir = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String copyTmpFile(String str) {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        File file = new File(str);
        boolean z16 = false;
        if (file.getParentFile().getPath().equals(new File(getMiniFolderPath(0)).getPath())) {
            QLog.e(TAG, 1, "copyTmpFile same parent : " + str);
            return str;
        }
        File file2 = new File(getTmpPath(getFileSuffix(file)));
        byte[] bArr = new byte[8192];
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                while (true) {
                    try {
                        try {
                            int read = bufferedInputStream.read(bArr);
                            if (read <= -1) {
                                break;
                            }
                            bufferedOutputStream.write(bArr, 0, read);
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedOutputStream2 = bufferedOutputStream;
                            if (bufferedOutputStream2 != null) {
                                try {
                                    bufferedOutputStream2.close();
                                } catch (IOException unused) {
                                }
                            }
                            if (bufferedInputStream == null) {
                                try {
                                    bufferedInputStream.close();
                                    throw th;
                                } catch (IOException unused2) {
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e16) {
                        e = e16;
                        Log.e(TAG, "copyTmpFile: ", e);
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                        if (z16) {
                        }
                    }
                }
                bufferedOutputStream.flush();
                try {
                    bufferedOutputStream.close();
                } catch (IOException unused5) {
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException unused6) {
                }
                z16 = true;
            } catch (IOException e17) {
                e = e17;
                bufferedOutputStream = null;
            } catch (Throwable th6) {
                th = th6;
                if (bufferedOutputStream2 != null) {
                }
                if (bufferedInputStream == null) {
                }
            }
        } catch (IOException e18) {
            e = e18;
            bufferedOutputStream = null;
            bufferedInputStream = null;
        } catch (Throwable th7) {
            th = th7;
            bufferedInputStream = null;
        }
        if (z16) {
            return null;
        }
        return file2.getAbsolutePath();
    }

    public void deleteTmpFileNeed2DeleteAsync() {
        ArrayList<String> arrayList = this.mTmpFileNeed2DeleteAsync;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        synchronized (this.mTmpFileNeed2DeleteAsync) {
            arrayList2.addAll(this.mTmpFileNeed2DeleteAsync);
            this.mTmpFileNeed2DeleteAsync.clear();
        }
        for (int size = arrayList2.size() - 1; size >= 0; size--) {
            if (arrayList2.get(size) != null) {
                com.tencent.mobileqq.utils.FileUtils.delete((String) arrayList2.get(size), false);
                arrayList2.remove(size);
            }
        }
    }

    public String getAbsolutePath(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (!str.toLowerCase().startsWith("http://") && !str.toLowerCase().startsWith("https://")) {
                ConcurrentHashMap<String, String> concurrentHashMap = this.curWxFileToLocalMap;
                if (concurrentHashMap != null) {
                    String str2 = concurrentHashMap.get(str);
                    if (!TextUtils.isEmpty(str2)) {
                        return str2;
                    }
                }
                String str3 = MiniAppGlobal.STR_WXFILE;
                if (!str.startsWith(str3)) {
                    if (str.startsWith("wxfile://")) {
                        str = str.replace("wxfile://", str3);
                    } else if (str.startsWith("qqfile://")) {
                        str = str.replace("qqfile://", str3);
                    }
                }
                String str4 = WXFILE_PREFIX_TMP;
                if (str.startsWith(str4)) {
                    File file = new File(getMiniFolderPath(0), str.replace(str4, ""));
                    if (file.exists() && file.getCanonicalPath().startsWith(getCurAppSdcardDir())) {
                        return file.getAbsolutePath();
                    }
                } else {
                    String str5 = WXFILE_PREFIX_STORE;
                    if (str.startsWith(str5)) {
                        File file2 = new File(getMiniFolderPath(1), str.replace(str5, ""));
                        if (file2.exists() && file2.getCanonicalPath().startsWith(getCurAppSdcardDir())) {
                            return file2.getAbsolutePath();
                        }
                    } else {
                        String str6 = WXFILE_PREFIX_USR;
                        if (str.startsWith(str6)) {
                            File file3 = new File(getMiniFolderPath(2), str.replace(str6, ""));
                            if (file3.exists() && file3.getCanonicalPath().startsWith(getCurAppSdcardDir())) {
                                return file3.getAbsolutePath();
                            }
                        } else {
                            String str7 = WXFILE_PREFIX_PRE_CACHE;
                            if (str.startsWith(str7)) {
                                File file4 = new File(getMiniFolderPath(4), str.replace(str7, ""));
                                if (file4.exists() && file4.getCanonicalPath().startsWith(getCurAppSdcardDir())) {
                                    return file4.getAbsolutePath();
                                }
                            } else {
                                File file5 = new File(this.apkgInfo.getFilePath(str));
                                if (file5.exists() && file5.getCanonicalPath().startsWith(new File(this.apkgInfo.getApkgFolderPath()).getCanonicalPath())) {
                                    return this.apkgInfo.getFilePath(str);
                                }
                            }
                        }
                    }
                }
                return "";
            }
            return str;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getAbsolutePath error.", th5);
            return "";
        }
    }

    public String getRootFileDir() {
        return MINI_FILE_ROOT_PATH;
    }

    public File[] getSaveFileList() {
        File file = new File(getMiniFolderPath(1));
        try {
            if (file.getCanonicalPath().startsWith(getCurAppSdcardDir())) {
                return file.listFiles();
            }
            return null;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getSaveFileList error", th5);
            return null;
        }
    }

    public String getSaveStorePath(String str) {
        if (TextUtils.isEmpty(str) || !new File(getAbsolutePath(str)).exists()) {
            return null;
        }
        String fileName = getFileName(str);
        if (TextUtils.isEmpty(fileName)) {
            return null;
        }
        return new File(getMiniFolderPath(1), fileName).getAbsolutePath();
    }

    public String getTmpPath(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = "." + str;
        }
        String str3 = getRandomFileName() + str2;
        File file = new File(getMiniFolderPath(0));
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str3).getAbsolutePath();
    }

    public String getTmpPathByUrl(String str) {
        return getTmpPath(getSuffixByPath(str));
    }

    public String getTmpPathFromOut(String str, String str2) {
        int lastIndexOf;
        if (str == null || (lastIndexOf = str.lastIndexOf(".")) < 0 || str.length() - 1 < lastIndexOf) {
            return "";
        }
        return getInstance().getTmpPath(str2, str.substring(lastIndexOf + 1));
    }

    public String getUsrPath(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = WXFILE_PREFIX_USR;
            if (str.startsWith(str2)) {
                File file = new File(getMiniFolderPath(2), str.replace(str2, ""));
                try {
                    if (file.getCanonicalPath().startsWith(getCurAppSdcardDir())) {
                        return file.getAbsolutePath();
                    }
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, "getUsrPath error", th5);
                }
            }
        }
        return null;
    }

    public String getWxFilePath(String str) {
        String str2 = "store";
        try {
            File file = new File(str);
            String absolutePath = file.getParentFile().getAbsolutePath();
            if (!getMiniFolderPath(0).equals(absolutePath) && !getMiniFolderPath(1).equals(absolutePath)) {
                if (absolutePath.startsWith(getMiniFolderPath(2))) {
                    return WXFILE_PREFIX_USR + file.getAbsolutePath().replace(getMiniFolderPath(2), "");
                }
                if (absolutePath.startsWith(getMiniFolderPath(4))) {
                    return WXFILE_PREFIX_PRE_CACHE + file.getAbsolutePath().replace(getMiniFolderPath(4), "");
                }
                if (!new File(str).exists()) {
                    return "";
                }
                return getWxFilePathByExistLocalPath(str);
            }
            if (!file.getParentFile().getName().equals("store")) {
                str2 = "tmp";
            }
            String name = new File(str).getName();
            StringBuffer stringBuffer = new StringBuffer(MiniAppGlobal.STR_WXFILE);
            stringBuffer.append(str2);
            stringBuffer.append("_");
            stringBuffer.append(name);
            return stringBuffer.toString();
        } catch (Throwable th5) {
            th5.printStackTrace();
            return "";
        }
    }

    public String getWxFilePathByExistLocalPath(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String suffixByPath = getSuffixByPath(str);
        if (!TextUtils.isEmpty(suffixByPath)) {
            str2 = "." + suffixByPath;
        }
        StringBuffer stringBuffer = new StringBuffer(MiniAppGlobal.STR_WXFILE);
        stringBuffer.append("tmp");
        stringBuffer.append("_");
        stringBuffer.append(getRandomFileName());
        stringBuffer.append(str2);
        String stringBuffer2 = stringBuffer.toString();
        this.curWxFileToLocalMap.put(stringBuffer2, str);
        return stringBuffer2;
    }

    public String getWxFileTmpPath(String str) {
        int lastIndexOf;
        if (str == null || (lastIndexOf = str.lastIndexOf(".")) < 0 || str.length() - 1 < lastIndexOf) {
            return "";
        }
        return getTmpPath(str.substring(lastIndexOf + 1));
    }

    public int getWxFileType(String str) {
        if (str.startsWith(WXFILE_PREFIX_TMP)) {
            return 0;
        }
        if (str.startsWith(WXFILE_PREFIX_STORE)) {
            return 1;
        }
        if (str.startsWith(WXFILE_PREFIX_PRE_CACHE)) {
            return 4;
        }
        return str.startsWith(WXFILE_PREFIX_USR) ? 2 : 9999;
    }

    public void initFileManager(ApkgBaseInfo apkgBaseInfo, boolean z16) {
        updateCurApkgInfo(apkgBaseInfo);
        if (z16) {
            renameTmpFolder();
        } else {
            deleteTmpFolder();
        }
        this.currentAppSdcardPath = null;
        this.currentAppSdcardPath = getCurAppSdcardDir();
        initFileSize();
    }

    public String savePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(WXFILE_PREFIX_STORE)) {
            return str;
        }
        String absolutePath = getAbsolutePath(str);
        if (new File(absolutePath).exists()) {
            String fileName = getFileName(str);
            if (!TextUtils.isEmpty(fileName) && com.tencent.mobileqq.utils.FileUtils.copyFile(absolutePath, new File(getMiniFolderPath(1), fileName).getAbsolutePath())) {
                StringBuffer stringBuffer = new StringBuffer(MiniAppGlobal.STR_WXFILE);
                stringBuffer.append("store");
                stringBuffer.append("_");
                stringBuffer.append(fileName);
                return stringBuffer.toString();
            }
        }
        return null;
    }

    public void setBaseActivity(Activity activity) {
        this.activityWeakReference = new WeakReference<>(activity);
    }

    public void updateCurApkgInfo(ApkgBaseInfo apkgBaseInfo) {
        this.curMiniAppId = apkgBaseInfo.appId;
        this.apkgInfo = apkgBaseInfo;
        if (this.curWxFileToLocalMap == null) {
            this.curWxFileToLocalMap = new ConcurrentHashMap<>();
        }
        this.curWxFileToLocalMap.clear();
    }

    public void updateFolderSize(int i3, long j3) {
        if (i3 == 1) {
            CountDownLatch countDownLatch = this.initStoreCountDown;
            if (countDownLatch != null) {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
            }
            if (this.storeUpdateCount.incrementAndGet() % 100 == 0) {
                long fileOrFolderSize = com.tencent.mobileqq.utils.FileUtils.getFileOrFolderSize(getMiniFolderPath(1));
                this.storeFolderSize.set(fileOrFolderSize);
                QLog.i(TAG, 1, "updateFolderSize fileType=store realSize=" + fileOrFolderSize);
                return;
            }
            QLog.i(TAG, 1, "updateFolderSize fileType=store delta=" + j3 + " size=" + this.storeFolderSize.addAndGet(j3));
            return;
        }
        if (i3 == 2) {
            CountDownLatch countDownLatch2 = this.initUsrCountDown;
            if (countDownLatch2 != null) {
                try {
                    countDownLatch2.await();
                } catch (InterruptedException e17) {
                    e17.printStackTrace();
                }
            }
            if (this.usrUpdateCount.incrementAndGet() % 100 == 0) {
                long fileOrFolderSize2 = com.tencent.mobileqq.utils.FileUtils.getFileOrFolderSize(getMiniFolderPath(2));
                this.usrFolderSize.set(fileOrFolderSize2);
                QLog.i(TAG, 1, "updateFolderSize fileType=usr realSize=" + fileOrFolderSize2);
                return;
            }
            QLog.i(TAG, 1, "updateFolderSize fileType=usr delta=" + j3 + " size=" + this.usrFolderSize.addAndGet(j3));
        }
    }

    private void deleteTmpFolder() {
        com.tencent.mobileqq.utils.FileUtils.delete(getMiniFolderPath(0), false);
    }

    private static String getExternalPath() {
        File file;
        try {
            file = BaseApplication.getContext().getExternalCacheDir();
        } catch (Throwable unused) {
            file = null;
        }
        if (file != null) {
            QLog.e(TAG, 1, "getExternalPath : " + file.getParent());
            return file.getParent();
        }
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return null;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            QLog.e(TAG, 1, "getExternalPath1 : " + externalStorageDirectory.getPath() + "/Android/data/com.tencent.mobileqq/");
            return externalStorageDirectory.getPath() + "/Android/data/com.tencent.mobileqq/";
        }
        File filesDir = BaseApplication.getContext().getFilesDir();
        if (filesDir != null) {
            QLog.e(TAG, 1, "getExternalPath2 : " + filesDir.getParent());
            return filesDir.getParent();
        }
        QLog.e(TAG, 1, "getExternalPath3 : /data/data/com.tencent.mobileqq/");
        return "/data/data/com.tencent.mobileqq/";
    }

    public static String getPreCacheFilePath(String str, String str2, String str3) {
        String miniFolderPath = getMiniFolderPath(4, str);
        if (!TextUtils.isEmpty(str2)) {
            miniFolderPath = miniFolderPath + File.separator + str2;
        }
        File file = new File(miniFolderPath, str3);
        try {
            if (file.getCanonicalPath().startsWith(getCurAppSdcardDir(str))) {
                return file.getAbsolutePath();
            }
            return null;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getUsrPath error", th5);
            return null;
        }
    }

    private void renameTmpFolder() {
        String miniFolderPath = getMiniFolderPath(0);
        String str = miniFolderPath + "_del_";
        com.tencent.mobileqq.utils.FileUtils.rename(miniFolderPath, str);
        this.mTmpFileNeed2DeleteAsync.add(str);
    }

    public boolean isPackageRelativePath(String str) {
        try {
            File file = new File(this.apkgInfo.getFilePath(str));
            if (file.exists()) {
                if (file.getCanonicalPath().startsWith(new File(this.apkgInfo.getApkgFolderPath()).getCanonicalPath())) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getMiniFolderPath(int i3) {
        String str = "tmp";
        if (i3 != 0) {
            if (i3 == 1) {
                str = "store";
            } else if (i3 == 2) {
                str = "usr";
            } else if (i3 == 4) {
                str = "precache";
            }
        }
        createNoMediaInMiniPath();
        String str2 = getCurAppSdcardDir() + "/" + str;
        if (i3 == 2) {
            checkUsrDir(str2);
        }
        return str2;
    }

    public boolean isFolderCanWrite(int i3, long j3) {
        MiniAppConfig miniAppConfig;
        AtomicLong atomicLong;
        long currentTimeMillis = System.currentTimeMillis();
        ApkgBaseInfo apkgBaseInfo = this.apkgInfo;
        if (apkgBaseInfo != null && (miniAppConfig = apkgBaseInfo.appConfig) != null && miniAppConfig.config != null) {
            if (j3 > 0) {
                if (i3 == 1) {
                    atomicLong = this.storeFolderSize;
                } else {
                    atomicLong = this.usrFolderSize;
                }
                long j16 = atomicLong.get();
                long j17 = this.apkgInfo.isEngineTypeMiniGame() ? 52428800L : MINI_APP_STORAGE_MAX_SIZE;
                if (i3 == 2) {
                    long j18 = this.apkgInfo.appConfig.config.usrFileSizeLimit;
                    if (j18 > 0) {
                        j17 = j18;
                    }
                }
                QLog.d(TAG, 1, "isFolderCanWrite usrFileSizeLimit : " + j17 + " size used : " + j16);
                if (j16 + j3 > j17) {
                    if (this.apkgInfo.isEngineTypeMiniGame()) {
                        MiniGameStorageExceedManager.showStorageExceedDialog(this.activityWeakReference, BaseApplicationImpl.getApplication().getRuntime().getAccount(), this.apkgInfo.appConfig.config);
                    }
                    QLog.i(TAG, 1, "isFolderCanWrite [minigame timecost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms ]");
                    return false;
                }
            }
            QLog.i(TAG, 1, "isFolderCanWrite [minigame timecost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms ]");
            return true;
        }
        QLog.w("[mini] ", 1, "check isFolderCanWrite on null apkgInfo or  null apkgInfo.appConfig or null apkgInfo.appConfig.config");
        return false;
    }

    public String getTmpPath(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            str3 = "";
        } else {
            str3 = "." + str2;
        }
        File file = new File(getMiniFolderPath(0, str), getRandomFileName() + str3);
        try {
            if (file.getCanonicalPath().toLowerCase().startsWith(getCurAppSdcardDir(str).toLowerCase())) {
                return file.getAbsolutePath();
            }
            return null;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getTmpPath error", th5);
            return null;
        }
    }

    private String getCurAppSdcardDir() {
        if (!TextUtils.isEmpty(this.currentAppSdcardPath)) {
            return this.currentAppSdcardPath;
        }
        String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        if (!TextUtils.isEmpty(account) && !TextUtils.isEmpty(this.curMiniAppId)) {
            return MINI_FILE_SAVE_PATH + MD5Utils.toMD5(this.curMiniAppId) + "/" + MD5Utils.toMD5(account);
        }
        QLog.e(TAG, 1, "getCurAppSdcardDir error. curMiniAppId : " + this.curMiniAppId);
        return MINI_FILE_SAVE_PATH;
    }
}
