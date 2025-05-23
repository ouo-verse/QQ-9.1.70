package com.nostra13.universalimageloader.utils;

import com.nostra13.universalimageloader.cache.disc.DiskCache;
import java.io.File;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class DiskCacheUtils {
    DiskCacheUtils() {
    }

    public static File findInCache(String str, DiskCache diskCache) {
        File file = diskCache.get(str);
        if (file == null || !file.exists()) {
            return null;
        }
        return file;
    }

    public static boolean removeFromCache(String str, DiskCache diskCache) {
        File file = diskCache.get(str);
        if (file != null && file.exists() && file.delete()) {
            return true;
        }
        return false;
    }
}
