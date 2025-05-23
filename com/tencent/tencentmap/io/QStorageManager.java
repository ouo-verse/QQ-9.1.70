package com.tencent.tencentmap.io;

import android.content.Context;
import java.io.File;

/* compiled from: P */
/* loaded from: classes26.dex */
public class QStorageManager {
    public static final String DATA = "data/";
    private static QStorageManager mInstance;

    QStorageManager(Context context) {
    }

    public static QStorageManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new QStorageManager(context);
        }
        return mInstance;
    }

    public String getAssetsDynamicPath() {
        return null;
    }

    public String getAssetsLoadPath(String str) {
        return null;
    }

    public File getCacheDir() {
        return null;
    }

    public String getConfigPath(String str) {
        return null;
    }

    public String getConfigTempPath(String str) {
        return null;
    }

    public File getDataDir() {
        return null;
    }

    public String getMapPath() {
        return null;
    }

    public String getRouteBlockPath() {
        return null;
    }

    public String getSatPath() {
        return null;
    }

    public void clearOldConfig(Context context, String str) {
    }
}
