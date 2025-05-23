package com.tencent.qqmini.sdk.core.manager;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.utils.FastClickUtils;
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.manager.MiniGameStorageExceedManager;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import com.tencent.qqmini.sdk.utils.ProcessUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniAppFileManager implements IMiniAppFileManager {
    public static final String DEFAULT_MINIAPP_FILE_STR = "wxfile://";
    public static final String FILE_PREFIX_PRE_CACHE = "precache";
    public static final String FILE_PREFIX_STORE = "store";
    public static final String FILE_PREFIX_TMP = "tmp";
    public static final String FILE_PREFIX_USR = "usr";
    public static final int FILE_TYPE_PRE_CACHE = 4;
    public static final int FILE_TYPE_STORE = 1;
    public static final int FILE_TYPE_TMP = 0;
    public static final int FILE_TYPE_UNKOWN = 9999;
    public static final int FILE_TYPE_USR = 2;
    private static final int MINI_APP_FILE_SIZE = 5;
    private static final long MINI_APP_STORAGE_MAX_SIZE = 10485760;
    private static final long MINI_GAME_STORAGE_MAX_SIZE = 209715200;
    private static final String TAG = "MiniAppFileManager";
    public static final String WXFILE_PREFIX_PRE_CACHE = "wxfile://precache";
    public static final String WXFILE_PREFIX_STORE = "wxfile://store_";
    public static final String WXFILE_PREFIX_TMP = "wxfile://tmp_";
    public static final String WXFILE_PREFIX_USR = "wxfile://usr";
    private static MiniAppFileManager currInstance = null;
    private static String currentAppId = null;
    private static String currentAppSdcardDir = null;
    private static String currentUin = null;
    private static boolean hasCheckUsrDir = false;
    private static boolean isNoMediaCreated = false;
    private static final Map<String, MiniAppFileManager> mapMiniAppFileManager = new LinkedHashMap<String, MiniAppFileManager>(5, 0.75f, true) { // from class: com.tencent.qqmini.sdk.core.manager.MiniAppFileManager.1
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, MiniAppFileManager> entry) {
            if (size() > 5) {
                return true;
            }
            return false;
        }
    };
    private Map<String, String> curWxFileToLocalMap;
    private String currentAppSdcardPath;
    private CountDownLatch initStoreCountDown;
    private CountDownLatch initUsrCountDown;
    private ApkgBaseInfo mApkgBaseInfo;
    private long storageLimit;
    private AtomicLong storeFolderSize = new AtomicLong(0);
    private AtomicLong usrFolderSize = new AtomicLong(0);
    private AtomicInteger storeUpdateCount = new AtomicInteger(0);
    private AtomicInteger usrUpdateCount = new AtomicInteger(0);

    private boolean checkPathPrefixValid(@NonNull File file) throws IOException {
        String curAppSdcardDir = getCurAppSdcardDir();
        if (TextUtils.isEmpty(curAppSdcardDir)) {
            QMLog.e(TAG, "checkPathPrefix: curAppDir is empty");
            return false;
        }
        return file.getCanonicalPath().toLowerCase().startsWith(curAppSdcardDir.toLowerCase());
    }

    private static void checkUsrDir(String str) {
        if (hasCheckUsrDir) {
            QMLog.i(TAG, "checkUsrDir hasCheckUsrDir is true, path:" + str);
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        hasCheckUsrDir = true;
    }

    private void createApkgResFolder(String str) {
        try {
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf != -1) {
                str = str.substring(0, lastIndexOf);
            }
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "createApkgResFolder error.", th5);
        }
    }

    private static synchronized void createNoMediaInMiniPath() {
        synchronized (MiniAppFileManager.class) {
            if (isNoMediaCreated) {
                return;
            }
            File file = new File(MiniSDKConst.getMiniCacheFilePath(), ".nomedia");
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
                QMLog.e(TAG, "exception in create .nomedia of mini files", e16);
            }
        }
    }

    private void deleteTmpFolder() {
        ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.core.manager.MiniAppFileManager.2
            @Override // java.lang.Runnable
            public void run() {
                FileUtils.delete(MiniAppFileManager.this.getMiniFolderPath(0), false);
            }
        });
    }

    private String getAbsoluteRealPath(String str) throws IOException {
        if (str.startsWith(WXFILE_PREFIX_TMP)) {
            File file = new File(getMiniFolderPath(0), str.replace(WXFILE_PREFIX_TMP, ""));
            if (file.exists() && checkPathPrefixValid(file)) {
                return file.getAbsolutePath();
            }
            if (!file.exists()) {
                QMLog.e(TAG, "wxfile url point to a non-exist file.");
            } else {
                QMLog.e(TAG, "Current file canonical path: " + file.getCanonicalPath() + "doesn't start with " + getCurAppSdcardDir());
            }
        } else if (str.startsWith(WXFILE_PREFIX_STORE)) {
            File file2 = new File(getMiniFolderPath(1), str.replace(WXFILE_PREFIX_STORE, ""));
            if (file2.exists() && checkPathPrefixValid(file2)) {
                return file2.getAbsolutePath();
            }
        } else if (str.startsWith(WXFILE_PREFIX_USR)) {
            File file3 = new File(getMiniFolderPath(2), str.replace(WXFILE_PREFIX_USR, ""));
            if (file3.exists() && checkPathPrefixValid(file3)) {
                return file3.getAbsolutePath();
            }
        } else if (str.startsWith(WXFILE_PREFIX_PRE_CACHE)) {
            File file4 = new File(getMiniFolderPath(4), str.replace(WXFILE_PREFIX_PRE_CACHE, ""));
            if (file4.exists() && checkPathPrefixValid(file4)) {
                return file4.getAbsolutePath();
            }
        } else {
            File file5 = new File(this.mApkgBaseInfo.getChildFileAbsolutePath(str));
            if (file5.exists() && file5.getCanonicalPath().startsWith(new File(this.mApkgBaseInfo.getApkgFolderPath()).getCanonicalPath())) {
                return this.mApkgBaseInfo.getChildFileAbsolutePath(str);
            }
            ApkgBaseInfo apkgBaseInfo = this.mApkgBaseInfo;
            if (apkgBaseInfo instanceof ApkgInfo) {
                ByteArrayInputStream readApkgToStream = ((ApkgInfo) apkgBaseInfo).readApkgToStream(str);
                if (readApkgToStream == null) {
                    return "";
                }
                createApkgResFolder(this.mApkgBaseInfo.getChildFileAbsolutePath(str));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = readApkgToStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        File file6 = new File(this.mApkgBaseInfo.getChildFileAbsolutePath(str));
                        file6.setWritable(true);
                        FileOutputStream fileOutputStream = new FileOutputStream(file6);
                        fileOutputStream.write(byteArrayOutputStream.toByteArray());
                        fileOutputStream.close();
                        byteArrayOutputStream.close();
                        readApkgToStream.close();
                        return file6.getAbsolutePath();
                    }
                }
            }
        }
        QMLog.e(TAG, "unexpected wxFilePath: " + str);
        return "";
    }

    public static String getContainerPreCacheFilePath(String str, String str2, String str3, String str4) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(getMiniFolderPath(str, 4));
        String str5 = File.separator;
        sb5.append(str5);
        sb5.append(ParseCommon.CONTAINER);
        return sb5.toString() + str5 + (str2 + "_" + str3).hashCode() + str4;
    }

    private String getCurAppSdcardDir() {
        ApkgBaseInfo apkgBaseInfo = this.mApkgBaseInfo;
        return getCurAppSdcardDir(apkgBaseInfo != null ? apkgBaseInfo.appId : null);
    }

    private String getFileName(String str) {
        if (str.startsWith(WXFILE_PREFIX_TMP)) {
            return str.replace(WXFILE_PREFIX_TMP, "");
        }
        if (str.startsWith(WXFILE_PREFIX_STORE)) {
            return str.replace(WXFILE_PREFIX_STORE, "");
        }
        if (!str.startsWith(WXFILE_PREFIX_USR)) {
            return "";
        }
        return new File(str.replace(WXFILE_PREFIX_USR, "")).getName();
    }

    public static String getFileSuffix(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf < 0) {
            return "";
        }
        return name.substring(lastIndexOf + 1);
    }

    @Deprecated
    public static MiniAppFileManager getInstance() {
        return currInstance;
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

    public static MiniAppFileManager getMiniAppFileManager(ApkgBaseInfo apkgBaseInfo) {
        if (apkgBaseInfo == null) {
            return null;
        }
        if (QMLog.isColorLevel() && AppLoaderFactory.g().getContext() != null) {
            QMLog.i(TAG, "getMiniAppFileManager get apkgInfo:" + apkgBaseInfo.apkgName + " ProcessName:" + ProcessUtil.getCurrentProcessName(AppLoaderFactory.g().getContext()));
        }
        return mapMiniAppFileManager.get(apkgBaseInfo.appId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getMiniFolderPath(int i3) {
        ApkgBaseInfo apkgBaseInfo = this.mApkgBaseInfo;
        return getMiniFolderPath(apkgBaseInfo != null ? apkgBaseInfo.appId : null, i3);
    }

    public static String getPreCacheFilePath(String str, String str2) {
        return getPreCacheFilePath(str, null, str2);
    }

    private String getRandomFileName() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(Thread.currentThread().getId());
        sb5.append(System.nanoTime());
        return MD5Utils.toMD5(sb5.toString());
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
        ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.core.manager.MiniAppFileManager.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MiniAppFileManager.this.usrFolderSize.set(FileUtils.getFileOrFolderSize(MiniAppFileManager.this.getMiniFolderPath(2)));
                } catch (Throwable unused) {
                }
                MiniAppFileManager.this.initUsrCountDown.countDown();
            }
        });
        this.initStoreCountDown = new CountDownLatch(1);
        ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.core.manager.MiniAppFileManager.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MiniAppFileManager.this.storeFolderSize.set(FileUtils.getFileOrFolderSize(MiniAppFileManager.this.getMiniFolderPath(1)));
                } catch (Throwable unused) {
                }
                MiniAppFileManager.this.initStoreCountDown.countDown();
            }
        });
    }

    private void renameTmpFolderAndDelete() {
        String miniFolderPath = getMiniFolderPath(0);
        final String str = miniFolderPath + "_del_";
        if (!FileUtils.rename(miniFolderPath, str)) {
            return;
        }
        ThreadManager.runIOTask(new Runnable() { // from class: com.tencent.qqmini.sdk.core.manager.MiniAppFileManager.3
            @Override // java.lang.Runnable
            public void run() {
                if (Build.VERSION.SDK_INT >= 26) {
                    FileUtils.deleteV2(str);
                } else {
                    FileUtils.delete(str, false);
                }
            }
        });
    }

    public void clearAllCache() {
        FileUtils.delete(MiniSDKConst.getMiniCacheFilePath(), false);
        this.usrFolderSize.set(0L);
        this.storeFolderSize.set(0L);
        hasCheckUsrDir = false;
    }

    public void clearFileCache(String str) {
        String str2 = MiniSDKConst.getMiniCacheFilePath() + MD5Utils.toMD5(str);
        if (new File(str2).exists()) {
            FileUtils.delete(str2, false);
            this.usrFolderSize.set(0L);
            this.storeFolderSize.set(0L);
        }
        hasCheckUsrDir = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String copyTmpFile(String str) {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        File file = new File(str);
        boolean z16 = false;
        if (file.getParentFile().equals(new File(getMiniFolderPath(0)))) {
            return str;
        }
        File file2 = new File(getTmpPath(getFileSuffix(file)));
        byte[] bArr = new byte[8192];
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        } catch (IOException e16) {
            e = e16;
            bufferedOutputStream = null;
            bufferedInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedInputStream = null;
        }
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
                    } catch (Throwable th6) {
                        th = th6;
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
                } catch (IOException e17) {
                    e = e17;
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
        } catch (IOException e18) {
            e = e18;
            bufferedOutputStream = null;
        } catch (Throwable th7) {
            th = th7;
            if (bufferedOutputStream2 != null) {
            }
            if (bufferedInputStream == null) {
            }
        }
        if (z16) {
            return null;
        }
        return file2.getAbsolutePath();
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager
    public String getAbsolutePath(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                QMLog.e(TAG, "getAbsolutePath: IllegalArgument: wxFilePath is empty");
                return "";
            }
            if (!str.toLowerCase().startsWith("http://") && !str.toLowerCase().startsWith("https://")) {
                Map<String, String> map = this.curWxFileToLocalMap;
                if (map != null) {
                    String str2 = map.get(str);
                    if (!TextUtils.isEmpty(str2)) {
                        return str2;
                    }
                }
                if (!str.startsWith("wxfile://")) {
                    if (str.startsWith("wxfile://")) {
                        str = str.replace("wxfile://", "wxfile://");
                    } else if (str.startsWith("qqfile://")) {
                        str = str.replace("qqfile://", "wxfile://");
                    }
                }
                return getAbsoluteRealPath(str);
            }
            return str;
        } catch (Throwable th5) {
            QMLog.e(TAG, "getAbsolutePath error.", th5);
            return "";
        }
    }

    public File[] getSaveFileList() throws IOException {
        File file = new File(getMiniFolderPath(1));
        if (checkPathPrefixValid(file)) {
            return file.listFiles();
        }
        return null;
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

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager
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

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager
    public String getTmpPathByWxFilePath(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith(WXFILE_PREFIX_TMP)) {
            String replace = str.replace(WXFILE_PREFIX_TMP, "");
            String miniFolderPath = getMiniFolderPath(this.mApkgBaseInfo.appId, 0);
            if (TextUtils.isEmpty(miniFolderPath)) {
                QMLog.e(TAG, "getMiniFolderPath is empty.");
                return null;
            }
            File file = new File(miniFolderPath, replace);
            try {
                if (!checkPathPrefixValid(file)) {
                    return null;
                }
                return file.getAbsolutePath();
            } catch (Throwable th5) {
                QMLog.e(TAG, "getTmpPathFromWx error", th5);
            }
        }
        return null;
    }

    public String getUsrPath(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith(WXFILE_PREFIX_USR)) {
            File file = new File(getMiniFolderPath(this.mApkgBaseInfo.appId, 2), str.replace(WXFILE_PREFIX_USR, ""));
            try {
                if (checkPathPrefixValid(file)) {
                    return file.getAbsolutePath();
                }
            } catch (Throwable th5) {
                QMLog.e(TAG, "getUsrPath error", th5);
            }
        }
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager
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
            StringBuffer stringBuffer = new StringBuffer("wxfile://");
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
        StringBuffer stringBuffer = new StringBuffer("wxfile://");
        stringBuffer.append("tmp");
        stringBuffer.append("_");
        stringBuffer.append(getRandomFileName());
        stringBuffer.append(str2);
        String stringBuffer2 = stringBuffer.toString();
        this.curWxFileToLocalMap.put(stringBuffer2, str);
        return stringBuffer2;
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
        if (str.startsWith(WXFILE_PREFIX_USR)) {
            return 2;
        }
        return 9999;
    }

    public void initFileManager(ApkgBaseInfo apkgBaseInfo, boolean z16) {
        if (apkgBaseInfo != null) {
            mapMiniAppFileManager.put(apkgBaseInfo.appId, this);
        }
        currInstance = this;
        updateCurApkgInfo(apkgBaseInfo);
        if (z16) {
            renameTmpFolderAndDelete();
        } else {
            deleteTmpFolder();
        }
        this.currentAppSdcardPath = null;
        this.currentAppSdcardPath = getCurAppSdcardDir();
        initFileSize();
        if (QMLog.isColorLevel() && apkgBaseInfo != null && AppLoaderFactory.g().getContext() != null) {
            QMLog.i(TAG, "initFileManager put apkgInfo:" + apkgBaseInfo.apkgName + " ProcessName:" + ProcessUtil.getCurrentProcessName(AppLoaderFactory.g().getContext()));
        }
    }

    public boolean isFolderCanWrite(int i3, long j3, boolean z16, MiniAppInfo miniAppInfo, Activity activity, IMiniAppContext iMiniAppContext) {
        AtomicLong atomicLong;
        long j16;
        if ((i3 != 2 && i3 != 1) || j3 <= 0) {
            return true;
        }
        if (i3 == 1) {
            atomicLong = this.storeFolderSize;
        } else {
            atomicLong = this.usrFolderSize;
        }
        long j17 = atomicLong.get();
        if (z16) {
            j16 = MINI_GAME_STORAGE_MAX_SIZE;
        } else {
            j16 = MINI_APP_STORAGE_MAX_SIZE;
        }
        if (i3 == 2) {
            long j18 = this.storageLimit;
            if (j18 > 0) {
                j16 = j18;
            }
        }
        if (j17 + j3 <= j16) {
            return true;
        }
        if (z16) {
            MiniGameStorageExceedManager.showStorageExceedDialog(new WeakReference(activity), LoginManager.getInstance().getAccount(), miniAppInfo, iMiniAppContext);
        }
        QMLog.w(TAG, "isFolderCanWrite: exceed, maxSize=" + j16 + ", size=" + j17 + ", saveSize=" + j3);
        return false;
    }

    public boolean isPackageFile(String str) {
        if (this.mApkgBaseInfo == null) {
            return false;
        }
        try {
            return new File(this.mApkgBaseInfo.getRootPath(), str).exists();
        } catch (Exception e16) {
            QMLog.e(TAG, "isPackageFile failed, path=" + str, e16);
            return false;
        }
    }

    public boolean isPackageRelativePath(String str) {
        try {
            File file = new File(this.mApkgBaseInfo.getChildFileAbsolutePath(str));
            if (file.exists()) {
                if (file.getCanonicalPath().startsWith(new File(this.mApkgBaseInfo.getApkgFolderPath()).getCanonicalPath())) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
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
            if (!TextUtils.isEmpty(fileName) && FileUtils.copyFile(absolutePath, new File(getMiniFolderPath(1), fileName).getAbsolutePath())) {
                StringBuffer stringBuffer = new StringBuffer("wxfile://");
                stringBuffer.append("store");
                stringBuffer.append("_");
                stringBuffer.append(fileName);
                return stringBuffer.toString();
            }
        }
        return null;
    }

    public void setStorageLimit(long j3) {
        this.storageLimit = j3;
        if (!FastClickUtils.isFastDoubleClick(TAG, 200L)) {
            QMLog.i(TAG, "init usr file limit=" + ((j3 / 1024) / 1024));
        }
    }

    public void updateCurApkgInfo(ApkgBaseInfo apkgBaseInfo) {
        this.mApkgBaseInfo = apkgBaseInfo;
        if (this.curWxFileToLocalMap == null) {
            this.curWxFileToLocalMap = new HashMap();
        }
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
                long fileOrFolderSize = FileUtils.getFileOrFolderSize(getMiniFolderPath(1));
                this.storeFolderSize.set(fileOrFolderSize);
                QMLog.i(TAG, "updateFolderSize fileType=store realSize=" + fileOrFolderSize);
                return;
            }
            QMLog.i(TAG, "updateFolderSize fileType=store delta=" + j3 + " size=" + this.storeFolderSize.addAndGet(j3));
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
                long fileOrFolderSize2 = FileUtils.getFileOrFolderSize(getMiniFolderPath(2));
                this.usrFolderSize.set(fileOrFolderSize2);
                QMLog.i(TAG, "updateFolderSize fileType=usr realSize=" + fileOrFolderSize2);
                return;
            }
            QMLog.i(TAG, "updateFolderSize fileType=usr delta=" + j3 + " size=" + this.usrFolderSize.addAndGet(j3));
        }
    }

    private static String getCurAppSdcardDir(String str) {
        String account = LoginManager.getInstance().getAccount() != null ? LoginManager.getInstance().getAccount() : "";
        if (!TextUtils.isEmpty(account) && !TextUtils.isEmpty(str)) {
            if (account.equals(currentUin) && str.equals(currentAppId) && !TextUtils.isEmpty(currentAppSdcardDir)) {
                return currentAppSdcardDir;
            }
            currentAppId = str;
            currentUin = account;
            String str2 = MiniSDKConst.getMiniCacheFilePath() + MD5Utils.toMD5(str) + "/" + MD5Utils.toMD5(account);
            currentAppSdcardDir = str2;
            return str2;
        }
        QMLog.e(TAG, "getCurAppSdcardDir error. uin : " + account + "; curMiniAppId : " + str);
        return MiniSDKConst.getMiniCacheFilePath();
    }

    private static String getMiniFolderPath(String str, int i3) {
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

    public static String getPreCacheFilePath(String str, String str2, String str3) {
        String miniFolderPath = getMiniFolderPath(str, 4);
        if (!TextUtils.isEmpty(str2)) {
            miniFolderPath = miniFolderPath + File.separator + str2;
        }
        return miniFolderPath + File.separator + str3;
    }

    public static MiniAppFileManager getMiniAppFileManager(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (QMLog.isColorLevel() && AppLoaderFactory.g().getContext() != null) {
            QMLog.i(TAG, "getMiniAppFileManager get apkgInfo by appid:" + str + " ProcessName:" + ProcessUtil.getCurrentProcessName(AppLoaderFactory.g().getContext()));
        }
        for (Map.Entry<String, MiniAppFileManager> entry : mapMiniAppFileManager.entrySet()) {
            if (str.equals(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }
}
