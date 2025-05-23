package com.qzone.module.covercomponent.utils;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.image.URLDrawable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CoverURLDrawableHelper {
    private static URLDrawable.URLDrawableOptions b(String str, ImageLoader.Options options) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        if (options != null) {
            obtain.mPlayGifImage = options.needShowGifAnimation;
            if (options.priority) {
                obtain.mPriority = (byte) 2;
            }
            if (!TextUtils.isEmpty(options.type)) {
                str.contains("&mType=");
            }
            if (options.preferQuality) {
                obtain.mUseAutoScaleParams = false;
            }
        }
        return obtain;
    }

    public static Drawable getCoverDrawable(String str, ImageLoader.Options options, ImageLoader.ImageLoadListener imageLoadListener) {
        ImageProcessor imageProcessor;
        URLDrawable.URLDrawableOptions b16 = b(str, options);
        URLDrawable.URLDrawableListener a16 = a(str, options, imageLoadListener);
        URLDrawable drawable = URLDrawable.getDrawable(str, b16);
        if (drawable != null) {
            drawable.setURLDrawableListener(a16);
            if (options != null && (imageProcessor = options.extraProcessor) != null) {
                imageProcessor.process(drawable);
            }
        }
        return drawable;
    }

    private static URLDrawable.URLDrawableListener a(final String str, final ImageLoader.Options options, final ImageLoader.ImageLoadListener imageLoadListener) {
        if (imageLoadListener != null) {
            return new URLDrawable.URLDrawableListener() { // from class: com.qzone.module.covercomponent.utils.CoverURLDrawableHelper.1
                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadCanceled(URLDrawable uRLDrawable) {
                    imageLoadListener.onImageCanceled(str, ImageLoader.Options.this);
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
                    imageLoadListener.onImageFailed(str, ImageLoader.Options.this);
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
                    imageLoadListener.onImageProgress(str, i3, ImageLoader.Options.this);
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadSuccessed(URLDrawable uRLDrawable) {
                    ImageLoader.Options options2;
                    ImageProcessor imageProcessor;
                    if (uRLDrawable != null && (options2 = ImageLoader.Options.this) != null && (imageProcessor = options2.extraProcessor) != null) {
                        imageProcessor.process(uRLDrawable);
                    }
                    imageLoadListener.onImageLoaded(str, uRLDrawable, ImageLoader.Options.this);
                }
            };
        }
        return null;
    }
}
