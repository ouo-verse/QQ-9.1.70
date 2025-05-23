package com.tencent.mobileqq.profilecard.utils;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes35.dex */
public class QCircleCoverBlurCachePool {
    private static final String DIVIDE = "_";
    public static final QCircleCoverBlurCachePool INSTANCE = new QCircleCoverBlurCachePool();
    private static final int MAX_CACHE_SIZE = 6;
    private static final String TAG = "QCircleCoverBlurCachePool";
    private final ConcurrentHashMap<String, SoftReference<Bitmap>> cacheMap = new ConcurrentHashMap<>();

    QCircleCoverBlurCachePool() {
    }

    public static String getCacheKey(String str, String str2, String str3) {
        return str + "_" + str2 + "_" + str3;
    }

    public void addCache(String str, Bitmap bitmap) {
        if (this.cacheMap.size() > 6) {
            Map.Entry<String, SoftReference<Bitmap>> entry = null;
            for (Map.Entry<String, SoftReference<Bitmap>> entry2 : this.cacheMap.entrySet()) {
                if (entry == null || entry.getValue() == null || entry.getValue().get() == null || entry2.getValue().get().getAllocationByteCount() > entry.getValue().get().getAllocationByteCount()) {
                    entry = entry2;
                }
            }
            if (entry != null) {
                this.cacheMap.remove(entry.getKey());
                QLog.d(TAG, 1, "remove old cache:" + entry.getKey() + " release memory:" + entry.getValue().get().getAllocationByteCount());
            }
        }
        this.cacheMap.put(str, new SoftReference<>(bitmap));
    }

    public Bitmap getCache(String str) {
        SoftReference<Bitmap> softReference;
        if (!this.cacheMap.containsKey(str) || (softReference = this.cacheMap.get(str)) == null) {
            return null;
        }
        return softReference.get();
    }
}
