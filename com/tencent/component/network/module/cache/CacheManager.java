package com.tencent.component.network.module.cache;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.cache.file.FileCacheService;
import com.tencent.component.network.module.cache.file.FileStorageHandler;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.component.network.utils.PlatformUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CacheManager {
    public static final int AUDIO_EXTERNAL_CAPACITY = 100;
    public static final String AUDIO_FILE_CACHE_NAME = "audio";
    public static final int AUDIO_INTERNAL_CAPACITY = 100;
    private static final String BLOB_DIR = "blob";
    private static final boolean FILE_CLEAR_PERSIST = false;
    private static final int FILE_VERSION = 1;
    public static final int IMAGE_EXTERNAL_CAPACITY = 3000;
    public static final String IMAGE_FILE_CACHE_NAME = "image";
    public static final int IMAGE_INTERNAL_CAPACITY = 800;
    private static final String PREFERENCE_FILE = "_cache_file";
    private static final String PREFERENCE_FILE_VERSION = "_version";
    public static final int TMP_EXTERNAL_CAPACITY = 500;
    public static final String TMP_FILE_CACHE_NAME = "tmp";
    public static final int TMP_INTERNAL_CAPACITY = 200;
    private static final HashMap<String, FileCacheService> sFileCacheService = new HashMap<>();
    private static final FileStorageHandler sStorageHandler = new FileStorageHandler(new FileStorageHandler.Collector() { // from class: com.tencent.component.network.module.cache.CacheManager.1
        @Override // com.tencent.component.network.module.cache.file.FileStorageHandler.Collector
        public Collection<FileCacheService> collect() {
            ArrayList arrayList;
            synchronized (CacheManager.sFileCacheService) {
                if (CacheManager.sFileCacheService.size() <= 0) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(CacheManager.sFileCacheService.values());
                }
            }
            return arrayList;
        }
    });

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class InnerEnvironment {
        private static final String EXTEND_SUFFIX = "-ext";
        private static final File EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY = new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data");
        private static final String TAG = "InnerEnvironment";

        InnerEnvironment() {
        }

        public static File getExternalCacheDir(Context context, boolean z16) {
            String str;
            if (!z16 && PlatformUtil.version() >= 8) {
                return context.getExternalCacheDir();
            }
            synchronized (InnerEnvironment.class) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(context.getPackageName());
                if (z16) {
                    str = EXTEND_SUFFIX;
                } else {
                    str = "";
                }
                sb5.append(str);
                File externalStorageAppCacheDirectory = getExternalStorageAppCacheDirectory(sb5.toString());
                if (!externalStorageAppCacheDirectory.exists()) {
                    try {
                        new File(getExternalStorageAndroidDataDir(), ".nomedia").createNewFile();
                    } catch (IOException e16) {
                        QDLog.e(TAG, "", e16);
                    }
                    if (!externalStorageAppCacheDirectory.mkdirs()) {
                        QDLog.w(TAG, "Unable to create external cache directory");
                        return null;
                    }
                }
                return externalStorageAppCacheDirectory;
            }
        }

        public static File getExternalFilesDir(Context context, String str, boolean z16) {
            String str2;
            if (!z16 && PlatformUtil.version() >= 8) {
                return context.getExternalFilesDir(str);
            }
            synchronized (InnerEnvironment.class) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(context.getPackageName());
                if (z16) {
                    str2 = EXTEND_SUFFIX;
                } else {
                    str2 = "";
                }
                sb5.append(str2);
                File externalStorageAppFilesDirectory = getExternalStorageAppFilesDirectory(sb5.toString());
                if (!externalStorageAppFilesDirectory.exists()) {
                    try {
                        new File(getExternalStorageAndroidDataDir(), ".nomedia").createNewFile();
                    } catch (IOException unused) {
                    }
                    if (!externalStorageAppFilesDirectory.mkdirs()) {
                        Log.w(TAG, "Unable to create external files directory");
                        return null;
                    }
                }
                if (str == null) {
                    return externalStorageAppFilesDirectory;
                }
                File file = new File(externalStorageAppFilesDirectory, str);
                if (!file.exists() && !file.mkdirs()) {
                    Log.w(TAG, "Unable to create external media directory " + file);
                    return null;
                }
                return file;
            }
        }

        public static File getExternalStorageAndroidDataDir() {
            return EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY;
        }

        public static File getExternalStorageAppCacheDirectory(String str) {
            return new File(new File(EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY, str), "cache");
        }

        public static File getExternalStorageAppFilesDirectory(String str) {
            return new File(new File(EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY, str), "files");
        }
    }

    CacheManager() {
    }

    public static synchronized void clear(Context context) {
        synchronized (CacheManager.class) {
            clear(context, 0L);
        }
    }

    private static void clearFiles(Context context) {
        String externalCacheDir = getExternalCacheDir(context, false);
        if (externalCacheDir != null) {
            FileUtils.delete(externalCacheDir, true);
        }
        String externalCacheDirExt = getExternalCacheDirExt(context, false);
        if (externalCacheDir != null) {
            FileUtils.delete(externalCacheDirExt, true);
        }
        String internalCacheDir = getInternalCacheDir(context, false);
        if (internalCacheDir != null) {
            FileUtils.delete(internalCacheDir, true);
        }
    }

    public static String getExternalCacheDir(Context context, String str, boolean z16) {
        String externalCacheDir = getExternalCacheDir(context, z16);
        if (externalCacheDir == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return externalCacheDir;
        }
        File file = new File(externalCacheDir + File.separator + str);
        synchronized (CacheManager.class) {
            if (file.isFile()) {
                FileUtils.delete(file);
            }
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return file.getAbsolutePath();
    }

    public static String getExternalCacheDirExt(Context context, String str, boolean z16) {
        String externalCacheDirExt = getExternalCacheDirExt(context, z16);
        if (externalCacheDirExt == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return externalCacheDirExt;
        }
        File file = new File(externalCacheDirExt + File.separator + str);
        synchronized (CacheManager.class) {
            if (file.isFile()) {
                FileUtils.delete(file);
            }
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return file.getAbsolutePath();
    }

    public static FileCacheService getFileCacheService(Context context, String str, int i3, int i16) {
        return getFileCacheService(context, str, i3, i16, false);
    }

    public static String getInternalCacheDir(Context context, String str, boolean z16) {
        String internalCacheDir = getInternalCacheDir(context, z16);
        if (TextUtils.isEmpty(str)) {
            return internalCacheDir;
        }
        File file = new File(internalCacheDir + File.separator + str);
        if (file.isFile()) {
            FileUtils.delete(file);
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static FileCacheService getTmpFileCacheService(Context context) {
        int lastIndexOf;
        String currentProcessName = Utils.getCurrentProcessName(context);
        String str = "tmp";
        if (currentProcessName != null && currentProcessName.contains(":") && (lastIndexOf = currentProcessName.lastIndexOf(":")) > 0) {
            str = "tmp_" + currentProcessName.substring(lastIndexOf + 1);
        }
        return getFileCacheService(context, str, 500, 200);
    }

    public static boolean isExternalAvailable() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e16) {
            QDLog.e(cooperation.qzone.cache.CacheManager.TAG, "Downloader ", e16);
            return false;
        }
    }

    public static FileCacheService getFileCacheService(Context context, String str, int i3, int i16, boolean z16) {
        FileCacheService fileCacheService;
        AssertUtil.assertTrue(!TextUtils.isEmpty(str));
        HashMap<String, FileCacheService> hashMap = sFileCacheService;
        synchronized (hashMap) {
            fileCacheService = hashMap.get(str);
            if (fileCacheService == null) {
                fileCacheService = new FileCacheService(context, str, i3, i16, z16);
                fileCacheService.setStorageHandler(sStorageHandler);
                hashMap.put(str, fileCacheService);
            }
        }
        return fileCacheService;
    }

    public static synchronized void clear(Context context, long j3) {
        synchronized (CacheManager.class) {
            clearFiles(context);
        }
    }

    public static FileCacheService getTmpFileCacheService(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getFileCacheService(context, str, 500, 200);
    }

    public static String getInternalCacheDir(Context context, boolean z16) {
        if (!z16) {
            return context.getCacheDir().getAbsolutePath();
        }
        return context.getFilesDir().getAbsolutePath() + File.separator + "cache";
    }

    private static String getExternalCacheDir(Context context, boolean z16) {
        File externalFilesDir;
        if (!isExternalAvailable()) {
            return null;
        }
        if (!z16) {
            externalFilesDir = InnerEnvironment.getExternalCacheDir(context, false);
        } else {
            externalFilesDir = InnerEnvironment.getExternalFilesDir(context, "cache", false);
        }
        if (externalFilesDir == null) {
            return null;
        }
        return externalFilesDir.getAbsolutePath();
    }

    private static String getExternalCacheDirExt(Context context, boolean z16) {
        File externalFilesDir;
        if (!isExternalAvailable()) {
            return null;
        }
        if (!z16) {
            externalFilesDir = InnerEnvironment.getExternalCacheDir(context, true);
        } else {
            externalFilesDir = InnerEnvironment.getExternalFilesDir(context, "cache", true);
        }
        if (externalFilesDir == null) {
            return null;
        }
        return externalFilesDir.getAbsolutePath();
    }
}
