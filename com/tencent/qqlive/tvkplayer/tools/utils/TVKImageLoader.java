package com.tencent.qqlive.tvkplayer.tools.utils;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.util.LruCache;

/* compiled from: P */
@TargetApi(12)
/* loaded from: classes23.dex */
public class TVKImageLoader {
    private static LruCache<String, Bitmap> mMemoryCache;
    private static TVKImageLoader mTVKImageLoader;

    TVKImageLoader() {
        mMemoryCache = new LruCache<String, Bitmap>(((int) Runtime.getRuntime().maxMemory()) / 8) { // from class: com.tencent.qqlive.tvkplayer.tools.utils.TVKImageLoader.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            public int sizeOf(String str, Bitmap bitmap) {
                return bitmap.getByteCount();
            }
        };
    }

    public static TVKImageLoader getInstance() {
        if (mTVKImageLoader == null) {
            mTVKImageLoader = new TVKImageLoader();
        }
        return mTVKImageLoader;
    }

    public void addBitmapToMemoryCache(String str, Bitmap bitmap) {
        if (mMemoryCache != null && getBitmapFromMemoryCache(str) == null) {
            mMemoryCache.put(str, bitmap);
        }
    }

    public Bitmap getBitmapFromMemoryCache(String str) {
        LruCache<String, Bitmap> lruCache = mMemoryCache;
        if (lruCache != null) {
            return lruCache.get(str);
        }
        return null;
    }
}
