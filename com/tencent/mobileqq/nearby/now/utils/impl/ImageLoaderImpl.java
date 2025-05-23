package com.tencent.mobileqq.nearby.now.utils.impl;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.nearby.now.utils.IImageLoader;
import com.tencent.mobileqq.urldrawable.a;
import com.tencent.mobileqq.urldrawable.b;
import hd0.c;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ImageLoaderImpl implements IImageLoader {
    private static final String TAG = "ImageLoader";

    @Override // com.tencent.mobileqq.nearby.now.utils.IImageLoader
    public void displayImage(ImageView imageView, String str, URLDrawable.URLDrawableListener uRLDrawableListener) {
        displayImage(imageView, str, null, null, 0, 0, uRLDrawableListener, false);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IImageLoader
    public void displayImage(ImageView imageView, String str, Drawable drawable, Drawable drawable2, URLDrawable.URLDrawableListener uRLDrawableListener, boolean z16) {
        displayImage(imageView, str, drawable, drawable2, 0, 0, uRLDrawableListener, z16);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IImageLoader
    public void displayImage(ImageView imageView, String str, Drawable drawable, Drawable drawable2, URLDrawable.URLDrawableListener uRLDrawableListener) {
        displayImage(imageView, str, drawable, drawable2, 0, 0, uRLDrawableListener, false);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IImageLoader
    public void displayImage(ImageView imageView, String str, int i3, int i16, URLDrawable.URLDrawableListener uRLDrawableListener) {
        displayImage(imageView, str, null, null, i3, i16, uRLDrawableListener, false);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IImageLoader
    public void displayImage(ImageView imageView, String str, Drawable drawable, Drawable drawable2, int i3, int i16, URLDrawable.URLDrawableListener uRLDrawableListener, boolean z16) {
        if (imageView != null && !TextUtils.isEmpty(str)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            if (i3 > 0 && i16 > 0) {
                obtain.mRequestWidth = i3;
                obtain.mRequestHeight = i16;
            }
            if (drawable == null) {
                drawable = b.f306350a;
            }
            obtain.mFailedDrawable = drawable;
            if (drawable2 == null) {
                drawable2 = b.f306350a;
            }
            obtain.mLoadingDrawable = drawable2;
            obtain.mMemoryCacheKeySuffix = "now";
            obtain.mUseAutoScaleParams = false;
            URLDrawable drawable3 = URLDrawable.getDrawable(str, obtain);
            if (z16) {
                drawable3.setDecodeHandler(a.f306322b);
            }
            if (uRLDrawableListener != null) {
                if (drawable3.getStatus() == 1) {
                    c.a("ImageLoader", "URLDrawable's status is SUCCESSED.");
                    uRLDrawableListener.onLoadSuccessed(drawable3);
                } else {
                    c.a("ImageLoader", "start load URLDrawable.");
                }
                drawable3.setURLDrawableListener(uRLDrawableListener);
            }
            imageView.setImageDrawable(drawable3);
            return;
        }
        c.g("ImageLoader", "ImageView or uri is null.");
    }
}
