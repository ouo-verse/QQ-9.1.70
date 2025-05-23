package com.tencent.component.media.image;

import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.region.RegionImageUtil;
import com.tencent.component.media.utils.ImageManagerLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ImageOptionSampleSize {
    private static final int DEFAULT_BYTES_PER_PIXEL = 4;
    private static final float HEIGHER_IMGE_FACTOR = 1.5f;
    private static final float IMAGE_UPPER_SIZE_FACTOR = 0.2f;
    private static final int IMAGE_UPPER_SIZE_MIN = 10485760;
    private static final int MEGABYTE = 1048576;
    private static final float PREFER_QUALITY_LOWER_SCALE_RATIO = 1.2f;
    private static final float PREFER_QUALITY_UPPER_SIZE_FACTOR = 0.0625f;
    private static final int PREFER_QUALITY_UPPER_SIZE_MIN = 2097152;
    private static int mImageUpperSize;
    private static int mMemcachesize;
    private static int mPreferQualityUpperSize;

    private static boolean checkImageSize(int i3, int i16, float f16, int i17) {
        if (i17 <= 0) {
            return true;
        }
        if (f16 < 1.0f) {
            f16 = 1.0f;
        }
        if (((int) ((i3 * i16) / f16)) * 4 <= Math.min(mMemcachesize, i17)) {
            return true;
        }
        return false;
    }

    public static int computeSampleSize(ImageLoader.Options options, int i3, int i16) {
        int i17;
        int panoramaComputeSampleSize;
        if (i3 <= 0 || i16 <= 0) {
            return 1;
        }
        if (options != null && (((i17 = options.mImageType) == 3 || i17 == 4) && (panoramaComputeSampleSize = ImageManagerEnv.g().panoramaComputeSampleSize(options, i3, i16)) != -1)) {
            return panoramaComputeSampleSize;
        }
        if (options != null && options.isNeedPieceLoad && RegionImageUtil.isNeedPieceLoad(i3, i16)) {
            ImageManagerLog.i("zehong", " computeSampleSize:  outWidth = " + i3 + " outHeight = " + i16);
            int regionDecodeComputeSampleSize = regionDecodeComputeSampleSize(i3, i16);
            if (regionDecodeComputeSampleSize != -1) {
                return regionDecodeComputeSampleSize;
            }
        }
        return computeSampleSize(options == null ? -1 : options.clipWidth, options != null ? options.clipHeight : -1, i3, i16, options == null ? false : options.preferQuality);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x003a, code lost:
    
        if ((1.5f * r1) >= r0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0042, code lost:
    
        if ((1.5f * r0) >= r1) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x004c, code lost:
    
        if (r0 < (1.5f * r1)) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int regionDecodeComputeSampleSize(int i3, int i16) {
        float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        int screenWidth = ImageManagerEnv.g().getScreenWidth();
        int screenHeight = ImageManagerEnv.g().getScreenHeight();
        if (i3 <= screenWidth && i16 <= screenHeight) {
            return -1;
        }
        int i17 = (i16 * screenWidth) / i3;
        if (i3 >= screenWidth) {
            if (i16 < i17) {
                f17 = screenHeight;
                if (1.5f * f17 >= i17) {
                    f16 = i16;
                    f18 = f17 / f16;
                }
            }
            f26 = screenWidth;
            f19 = i3;
            f18 = f26 / f19;
        } else if (i16 < screenHeight) {
            if (i16 >= i17) {
                f19 = i3;
                f26 = screenWidth;
            } else {
                f16 = i16;
                f17 = screenHeight;
            }
            f18 = 1.0f;
        } else {
            if (i16 > screenHeight) {
                f16 = i16;
                f17 = screenHeight;
            }
            f18 = 1.0f;
        }
        int ceil = (int) Math.ceil(1.0f / f18);
        int i18 = 1;
        if (ceil <= 1) {
            return 1;
        }
        int i19 = 64;
        if (ceil > 64) {
            i18 = 64;
        }
        while (true) {
            if (i19 == 0) {
                break;
            }
            int i26 = ceil & i19;
            if (i26 != 0) {
                i18 = i26;
                break;
            }
            i19 >>= 1;
        }
        while (true) {
            if (i16 / i18 <= 2048 && i3 / i18 <= 2048) {
                return i18;
            }
            i18 <<= 1;
        }
    }

    public static void setSize(int i3, int i16) {
        mMemcachesize = i16;
        float f16 = i3 * 1048576;
        mImageUpperSize = (int) Math.max(0.2f * f16, 1.048576E7f);
        mPreferQualityUpperSize = (int) Math.max(f16 * PREFER_QUALITY_UPPER_SIZE_FACTOR, 2097152.0f);
    }

    public static int computeSampleSize(int i3, int i16, int i17, int i18) {
        return computeSampleSize(i3, i16, i17, i18, false);
    }

    private static int computeSampleSize(int i3, int i16, int i17, int i18, boolean z16) {
        float f16;
        float f17;
        float f18;
        if (i3 <= 0) {
            i3 = ImageManagerEnv.g().getScreenWidth();
        }
        if (i16 <= 0) {
            i16 = ImageManagerEnv.g().getScreenHeight();
        }
        float f19 = 1.0f;
        if (i3 < i17 || i16 < i18) {
            if (i3 * i18 > i16 * i17) {
                f16 = i17 / i3;
                f17 = i18 / i16;
            } else {
                f16 = i18 / i16;
                f17 = i17 / i3;
            }
            if (!z16) {
                f16 = (float) Math.sqrt(f16 * f17);
            }
            if (f16 >= 1.0f) {
                f19 = f16;
            }
        }
        int i19 = 0;
        while (true) {
            f18 = 1 << i19;
            if (f19 <= f18) {
                break;
            }
            i19++;
        }
        if (i19 > 0 && f18 / f19 > PREFER_QUALITY_LOWER_SCALE_RATIO && checkImageSize(i17, i18, f18, mPreferQualityUpperSize)) {
            i19--;
        }
        while (true) {
            int i26 = 1 << i19;
            if (checkImageSize(i17, i18, i26, mImageUpperSize)) {
                return i26;
            }
            i19++;
        }
    }
}
