package com.tencent.component.media.utils;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.gif.NewGifDrawable;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.drawable.BitmapImageDrawable;
import com.tencent.component.media.image.drawable.DrawableContainer;
import com.tencent.component.media.image.drawable.NinePatchRefDrawable;
import com.tencent.component.media.image.drawable.SliceBitmapDrawable;
import com.tencent.component.media.image.image.BitmapImage;
import com.tencent.component.media.image.processor.ScaleProcessor;
import com.tencent.component.media.image.region.RegionDrawable;
import com.tencent.component.media.photogif.NewAnimationDrawable;
import com.tencent.component.media.photogif.PhotoGifDrawable;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QZoneImageDecodeUtils {
    private static final String TAG = "QZoneImageDecodeUtils";

    public static boolean drawableComputable(Drawable drawable) {
        if (drawable == null) {
            return false;
        }
        if (drawable instanceof DrawableContainer) {
            return drawableComputable(((DrawableContainer) drawable).getDrawable());
        }
        if (!(drawable instanceof PhotoGifDrawable) && !(drawable instanceof NewGifDrawable) && !(drawable instanceof BitmapDrawable) && !(drawable instanceof BitmapImageDrawable) && !(drawable instanceof SliceBitmapDrawable) && !(drawable instanceof NewAnimationDrawable) && !(drawable instanceof NinePatchRefDrawable) && !(drawable instanceof RegionDrawable)) {
            return false;
        }
        return true;
    }

    public static boolean isAvatarUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("avatar://");
    }

    public static boolean isGif(String str) {
        return "image/gif".equalsIgnoreCase(str);
    }

    public static boolean isNetworkUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            if (URLUtil.isFileUrl(str) || str.startsWith("avatar://")) {
                return false;
            }
            return URLUtil.isNetworkUrl(str);
        }
        return true;
    }

    public static boolean isPng(String str) {
        return "image/png".equalsIgnoreCase(str);
    }

    public static boolean needTryScaleDrawable(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int screenWidth = ImageManagerEnv.g().getScreenWidth() - ((int) (ImageManagerEnv.g().getDesity() * 4.0f));
        int screenHeight = ImageManagerEnv.g().getScreenHeight() - ((int) (ImageManagerEnv.g().getDesity() * 4.0f));
        ImageManagerLog.w(TAG, "super resolution. needTryScaleDrawable: width=" + intrinsicWidth + " screenWidth=" + screenWidth + " height=" + intrinsicHeight + " screenHeight=" + screenHeight);
        if (intrinsicWidth <= screenWidth && intrinsicHeight <= screenHeight) {
            return false;
        }
        return true;
    }

    public static BitmapImage processImage(BitmapReference bitmapReference, ImageLoader.Options options) {
        BitmapReference bitmapReference2 = null;
        if (bitmapReference == null) {
            return null;
        }
        if (options != null && options.processor != null) {
            int width = bitmapReference.getWidth();
            int height = bitmapReference.getHeight();
            try {
                bitmapReference2 = options.processor.doProcess(bitmapReference, true);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            if (bitmapReference2 != null && bitmapReference2 != bitmapReference) {
                BitmapImage bitmapImage = new BitmapImage(bitmapReference2);
                bitmapImage.getMetaInfo().width = width;
                bitmapImage.getMetaInfo().height = height;
                return bitmapImage;
            }
        }
        return new BitmapImage(bitmapReference);
    }

    public static Drawable scaleLargeDrawable(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int screenWidth = ImageManagerEnv.g().getScreenWidth() - ((int) (ImageManagerEnv.g().getDesity() * 4.0f));
        int screenHeight = ImageManagerEnv.g().getScreenHeight() - ((int) (ImageManagerEnv.g().getDesity() * 4.0f));
        if (intrinsicWidth > screenWidth || intrinsicHeight > screenHeight) {
            double d16 = intrinsicWidth;
            double d17 = intrinsicHeight;
            double d18 = d16 / d17;
            double d19 = screenWidth;
            double d26 = screenHeight;
            if (d18 > d19 / d26) {
                screenHeight = (int) (d19 * (d17 / d16));
            } else {
                screenWidth = (int) (d26 * d18);
            }
            Drawable process = new ScaleProcessor(screenWidth, screenHeight, true).process(drawable);
            process.setBounds(0, 0, screenWidth, screenHeight);
            return process;
        }
        return drawable;
    }
}
