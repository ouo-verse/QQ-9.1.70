package com.tencent.mobileqq.nearby.now.utils;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IImageLoader extends QRouteApi {
    void displayImage(ImageView imageView, String str, int i3, int i16, URLDrawable.URLDrawableListener uRLDrawableListener);

    void displayImage(ImageView imageView, String str, Drawable drawable, Drawable drawable2, int i3, int i16, URLDrawable.URLDrawableListener uRLDrawableListener, boolean z16);

    void displayImage(ImageView imageView, String str, Drawable drawable, Drawable drawable2, URLDrawable.URLDrawableListener uRLDrawableListener);

    void displayImage(ImageView imageView, String str, Drawable drawable, Drawable drawable2, URLDrawable.URLDrawableListener uRLDrawableListener, boolean z16);

    void displayImage(ImageView imageView, String str, URLDrawable.URLDrawableListener uRLDrawableListener);
}
