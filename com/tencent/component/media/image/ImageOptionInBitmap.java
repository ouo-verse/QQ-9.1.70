package com.tencent.component.media.image;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.lang.ref.SoftReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ImageOptionInBitmap {
    private static Set<SoftReference<Bitmap>> mReusableBitmaps = new HashSet();
    private static boolean hasHONEYCOMB = true;

    @TargetApi(11)
    public static void addInBitmapOptions(BitmapFactory.Options options) {
        if (!hasHONEYCOMB) {
            return;
        }
        options.inMutable = true;
        Bitmap bitmapFromReusableSet = getBitmapFromReusableSet(options);
        if (bitmapFromReusableSet != null) {
            options.inBitmap = bitmapFromReusableSet;
        }
    }

    public static void addReusableBitmaps(Bitmap bitmap) {
        if (!hasHONEYCOMB) {
            return;
        }
        synchronized (mReusableBitmaps) {
            mReusableBitmaps.add(new SoftReference<>(bitmap));
        }
    }

    @SuppressLint({"NewApi"})
    private static boolean canUseForInBitmap(Bitmap bitmap, BitmapFactory.Options options) {
        int i3 = options.outWidth;
        int i16 = options.inSampleSize;
        if ((i3 / i16) * (options.outHeight / i16) * getBytesPerPixel(bitmap.getConfig()) <= bitmap.getAllocationByteCount()) {
            return true;
        }
        return false;
    }

    public static void clear() {
        synchronized (mReusableBitmaps) {
            mReusableBitmaps.clear();
        }
    }

    private static Bitmap getBitmapFromReusableSet(BitmapFactory.Options options) {
        Set<SoftReference<Bitmap>> set = mReusableBitmaps;
        Bitmap bitmap = null;
        if (set != null && !set.isEmpty()) {
            synchronized (mReusableBitmaps) {
                Iterator<SoftReference<Bitmap>> it = mReusableBitmaps.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Bitmap bitmap2 = it.next().get();
                    if (bitmap2 != null && bitmap2.isMutable()) {
                        if (canUseForInBitmap(bitmap2, options)) {
                            it.remove();
                            bitmap = bitmap2;
                            break;
                        }
                    } else {
                        it.remove();
                    }
                }
            }
        }
        return bitmap;
    }

    private static int getBytesPerPixel(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888) {
            return 4;
        }
        if (config == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444) {
            return 2;
        }
        Bitmap.Config config2 = Bitmap.Config.ALPHA_8;
        return 1;
    }
}
