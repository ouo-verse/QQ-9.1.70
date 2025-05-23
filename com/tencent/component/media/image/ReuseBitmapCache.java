package com.tencent.component.media.image;

import android.graphics.Bitmap;
import com.tencent.component.media.ImageManagerEnv;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ReuseBitmapCache {
    public static final String TAG = "AdvanceBitmapPool";
    private static ReuseBitmapCache instance;
    ReuseBitmapPool bigBitmapBucket;
    ReuseBitmapPool smallBitmapBucket;

    ReuseBitmapCache(int i3) {
        boolean z16;
        String processName = ImageManagerEnv.g().getProcessName(ImageManagerEnv.getAppContext());
        int i16 = 1;
        if (processName != null && processName.contains(":picture")) {
            z16 = true;
        } else {
            z16 = false;
        }
        int screenWidth = ImageDefaultConfig.getScreenWidth(ImageManagerEnv.getAppContext());
        int screenHeight = ImageDefaultConfig.getScreenHeight(ImageManagerEnv.getAppContext());
        if (z16) {
            int i17 = i3 >> 1;
            int i18 = screenWidth * screenWidth;
            int i19 = screenWidth * 4 * screenHeight;
            int i26 = screenWidth * screenHeight * 4;
            this.smallBitmapBucket = new ReuseBitmapPool(i3 - i17, i18, i26);
            this.bigBitmapBucket = new ReuseBitmapPool(i17, i19, i26 * 2);
            return;
        }
        int i27 = i3 >> 2;
        int i28 = i3 - i27;
        int i29 = screenWidth * screenWidth;
        int i36 = screenWidth * 4 * screenWidth;
        if (i27 > i29) {
            i16 = i27;
            i3 = i28;
        }
        int i37 = screenWidth * screenHeight * 4;
        this.smallBitmapBucket = new ReuseBitmapPool(i3, i29, i37);
        this.bigBitmapBucket = new ReuseBitmapPool(i16, i36, i37);
    }

    public static ReuseBitmapCache getInstance(int i3) {
        if (instance == null) {
            synchronized (ReuseBitmapCache.class) {
                if (instance == null) {
                    ImageManagerEnv.getLogger().d(TAG, "maxSize:" + i3);
                    instance = new ReuseBitmapCache(i3);
                }
            }
        }
        return instance;
    }

    public synchronized boolean addBitMapIntoPool(Bitmap bitmap) {
        if (!this.smallBitmapBucket.addBitMapIntoPool(bitmap)) {
            return this.bigBitmapBucket.addBitMapIntoPool(bitmap);
        }
        return true;
    }

    public synchronized Bitmap getBitmapFromPool(int i3) {
        Bitmap bitmapFromPool;
        bitmapFromPool = this.smallBitmapBucket.getBitmapFromPool(i3);
        if (bitmapFromPool == null) {
            bitmapFromPool = this.bigBitmapBucket.getBitmapFromPool(i3);
        }
        return bitmapFromPool;
    }

    public void resiezeCache(float f16) {
        ReuseBitmapPool reuseBitmapPool = this.smallBitmapBucket;
        if (reuseBitmapPool != null) {
            reuseBitmapPool.resizeCahce(f16);
        }
        ReuseBitmapPool reuseBitmapPool2 = this.bigBitmapBucket;
        if (reuseBitmapPool2 != null) {
            reuseBitmapPool2.resizeCahce(f16);
        }
    }

    public void trimToSize(float f16) {
        ReuseBitmapPool reuseBitmapPool = this.smallBitmapBucket;
        if (reuseBitmapPool != null) {
            reuseBitmapPool.trimToSize(f16);
        }
        ReuseBitmapPool reuseBitmapPool2 = this.bigBitmapBucket;
        if (reuseBitmapPool2 != null) {
            reuseBitmapPool2.trimToSize(f16);
        }
    }
}
