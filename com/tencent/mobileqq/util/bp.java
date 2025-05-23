package com.tencent.mobileqq.util;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bp {
    public static URLDrawable a(ImageView imageView, String str, Drawable drawable) {
        return b(imageView, str, co.f306666a, drawable, drawable);
    }

    public static URLDrawable b(ImageView imageView, String str, DownloadParams.DecodeHandler decodeHandler, Drawable drawable, Drawable drawable2) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        if (imageView.getLayoutParams() != null) {
            obtain.mRequestWidth = imageView.getLayoutParams().width;
            obtain.mRequestHeight = imageView.getLayoutParams().height;
        }
        if (obtain.mRequestWidth <= 0 || obtain.mRequestHeight <= 0) {
            obtain.mRequestWidth = Math.max(imageView.getWidth(), 0);
            obtain.mRequestHeight = Math.max(imageView.getHeight(), 0);
        }
        obtain.mFailedDrawable = drawable2;
        obtain.mLoadingDrawable = drawable;
        if (decodeHandler != null) {
            obtain.mMemoryCacheKeySuffix = decodeHandler.toString();
        }
        URLDrawable drawable3 = URLDrawable.getDrawable(str, obtain);
        drawable3.setDecodeHandler(decodeHandler);
        imageView.setImageDrawable(drawable3);
        return drawable3;
    }
}
