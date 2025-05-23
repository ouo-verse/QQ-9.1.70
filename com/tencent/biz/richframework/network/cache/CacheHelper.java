package com.tencent.biz.richframework.network.cache;

import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CacheHelper {
    private static final String TAG = "com.tencent.biz.richframework.network.cache.CacheHelper";
    private static String mAppCacheDir;
    private static volatile Cache mFileCache;
    private static String mPackgeName;

    public static Cache fileCache() {
        if (mFileCache == null) {
            synchronized (CacheHelper.class) {
                if (mFileCache == null) {
                    if (mPackgeName == null) {
                        mPackgeName = RFWApplication.getApplication().getPackageName();
                    }
                    if (mAppCacheDir == null) {
                        mAppCacheDir = RFWApplication.getApplication().getCacheDir().getAbsolutePath();
                    }
                    mFileCache = new DiskCache(mPackgeName, mAppCacheDir);
                }
                RFWLog.d(TAG, RFWLog.DEV, "init FileCache");
            }
        }
        return mFileCache;
    }
}
