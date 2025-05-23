package com.tencent.tencentmap.mapsdk.maps.storage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.mapsdk.internal.hs;
import com.tencent.mapsdk.internal.kt;
import java.io.File;

/* compiled from: P */
/* loaded from: classes26.dex */
public class StorageManager {
    private static final String PRIVATE_ROOT_DIR = "/tencentMapSdk/";
    private static final String ROOT_DIR = "/tencentmapsdk/";
    private static StorageManager mInstance;
    private String mAppRootDir;
    private Context mContext;
    private String mCustomCacheRootPath;
    private String mPrivateFilePath;
    private String mPrivateFileRootPath;
    private static String[] mSharedPrefNames = {"com.tencent.tencentmap.mapsdk.maps.offlinemap", "txlbs_suid", "txlbs_duid", "Tencent_MapSDK_SUB_CONFIG"};
    private static String[] mPrivateFileNames = {"frontiers.dat"};

    StorageManager(Context context, String str) {
        if (context != null) {
            this.mContext = context.getApplicationContext();
            this.mCustomCacheRootPath = str;
            updatePublicPath();
            updatePrivatePath();
            return;
        }
        throw new Error("context can not be null");
    }

    public static void clearMapCache(Context context, String str) {
        kt.f(getInstance(context, str).getCacheDir());
        kt.f(getInstance(context, str).getPrivateCacheDir());
        for (String str2 : mPrivateFileNames) {
            kt.f(getInstance(context, str).getPrivateCacheFileName(str2));
        }
        removeAllPrefs(context);
    }

    @SuppressLint({"NewApi"})
    private static long getAvailableStorageSize(String str) {
        try {
            StatFs statFs = new StatFs(str);
            return ((statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong()) / 1024) / 1024;
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static String getExternalStoragePath(Context context) {
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            return externalFilesDir.getAbsolutePath();
        }
        return context.getFilesDir().getPath();
    }

    public static StorageManager getInstance(Context context, String str) {
        if (mInstance == null) {
            mInstance = new StorageManager(context, str);
        }
        return mInstance;
    }

    private String getStorageRootPath() {
        if (!TextUtils.isEmpty(this.mCustomCacheRootPath)) {
            return this.mCustomCacheRootPath;
        }
        Context context = this.mContext;
        String externalStoragePath = getExternalStoragePath(context);
        if (getAvailableStorageSize(externalStoragePath) < 5) {
            String path = context.getFilesDir().getPath();
            if (getAvailableStorageSize(path) < 5) {
                return getExternalStoragePath(context);
            }
            return path;
        }
        return externalStoragePath;
    }

    public static void removeAllPrefs(Context context) {
        try {
            File[] listFiles = new File(context.getFilesDir().getParent() + File.separator + "shared_prefs").listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file : listFiles) {
                for (String str : mSharedPrefNames) {
                    if (file.getName().startsWith(str)) {
                        file.delete();
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void updatePrivatePath() {
        this.mPrivateFileRootPath = this.mContext.getFilesDir().getAbsolutePath();
        this.mPrivateFilePath = this.mPrivateFileRootPath + PRIVATE_ROOT_DIR;
    }

    private void updatePublicPath() {
        String storageRootPath = getStorageRootPath();
        String a16 = kt.a(this.mContext);
        if (hs.a(a16)) {
            this.mAppRootDir = storageRootPath + ROOT_DIR;
            return;
        }
        this.mAppRootDir = storageRootPath + ROOT_DIR + a16;
    }

    public File getCacheDir() {
        return new File(this.mAppRootDir);
    }

    public File getPrivateCacheDir() {
        return new File(this.mPrivateFilePath);
    }

    public File getPrivateCacheFileName(String str) {
        return new File(this.mPrivateFileRootPath + File.separator + str);
    }
}
