package com.nostra13.universalimageloader.utils;

import android.opengl.GLES10;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class ImageSizeUtils {
    private static final int DEFAULT_MAX_BITMAP_DIMENSION = 2048;
    private static ImageSize maxBitmapSize;

    /* compiled from: P */
    /* renamed from: com.nostra13.universalimageloader.utils.ImageSizeUtils$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$nostra13$universalimageloader$core$assist$ViewScaleType;

        static {
            int[] iArr = new int[ViewScaleType.values().length];
            $SwitchMap$com$nostra13$universalimageloader$core$assist$ViewScaleType = iArr;
            try {
                iArr[ViewScaleType.FIT_INSIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$nostra13$universalimageloader$core$assist$ViewScaleType[ViewScaleType.CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int max = Math.max(iArr[0], 2048);
        maxBitmapSize = new ImageSize(max, max);
    }

    ImageSizeUtils() {
    }

    public static int computeImageSampleSize(ImageSize imageSize, ImageSize imageSize2, ViewScaleType viewScaleType, boolean z16) {
        int max;
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        int width2 = imageSize2.getWidth();
        int height2 = imageSize2.getHeight();
        int i3 = AnonymousClass1.$SwitchMap$com$nostra13$universalimageloader$core$assist$ViewScaleType[viewScaleType.ordinal()];
        int i16 = 1;
        if (i3 != 1) {
            if (i3 != 2) {
                max = 1;
            } else if (z16) {
                int i17 = width / 2;
                int i18 = height / 2;
                max = 1;
                while (i17 / max > width2 && i18 / max > height2) {
                    max *= 2;
                }
            } else {
                max = Math.min(width / width2, height / height2);
            }
        } else if (z16) {
            int i19 = width / 2;
            int i26 = height / 2;
            max = 1;
            while (true) {
                if (i19 / max <= width2 && i26 / max <= height2) {
                    break;
                }
                max *= 2;
            }
        } else {
            max = Math.max(width / width2, height / height2);
        }
        if (max >= 1) {
            i16 = max;
        }
        return considerMaxTextureSize(width, height, i16, z16);
    }

    public static float computeImageScale(ImageSize imageSize, ImageSize imageSize2, ViewScaleType viewScaleType, boolean z16) {
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        int width2 = imageSize2.getWidth();
        int height2 = imageSize2.getHeight();
        float f16 = width;
        float f17 = f16 / width2;
        float f18 = height;
        float f19 = f18 / height2;
        if ((viewScaleType == ViewScaleType.FIT_INSIDE && f17 >= f19) || (viewScaleType == ViewScaleType.CROP && f17 < f19)) {
            height2 = (int) (f18 / f17);
        } else {
            width2 = (int) (f16 / f19);
        }
        if ((!z16 && width2 < width && height2 < height) || (z16 && width2 != width && height2 != height)) {
            return width2 / f16;
        }
        return 1.0f;
    }

    public static int computeMinImageSampleSize(ImageSize imageSize) {
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        return Math.max((int) Math.ceil(width / maxBitmapSize.getWidth()), (int) Math.ceil(height / maxBitmapSize.getHeight()));
    }

    private static int considerMaxTextureSize(int i3, int i16, int i17, boolean z16) {
        int width = maxBitmapSize.getWidth();
        int height = maxBitmapSize.getHeight();
        while (true) {
            if (i3 / i17 <= width && i16 / i17 <= height) {
                return i17;
            }
            if (z16) {
                i17 *= 2;
            } else {
                i17++;
            }
        }
    }

    public static ImageSize defineTargetSizeForView(ImageAware imageAware, ImageSize imageSize) {
        int min;
        int min2;
        int width = imageAware.getWidth();
        if (width <= 0) {
            min = imageSize.getWidth();
        } else {
            min = Math.min(width, imageSize.getWidth());
        }
        int height = imageAware.getHeight();
        if (height <= 0) {
            min2 = imageSize.getHeight();
        } else {
            min2 = Math.min(height, imageSize.getHeight());
        }
        return new ImageSize(min, min2);
    }
}
