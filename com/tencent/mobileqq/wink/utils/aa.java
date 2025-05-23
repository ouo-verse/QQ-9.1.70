package com.tencent.mobileqq.wink.utils;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.transfile.BaseURLDrawableHelper;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes21.dex */
public class aa extends BaseURLDrawableHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final Drawable f326656a = new ColorDrawable(0);

    public static URLDrawable a(URL url, int i3, int i16, Drawable drawable, Drawable drawable2, boolean z16, float f16) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = i3;
        obtain.mRequestHeight = i16;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable2;
        obtain.mPlayGifImage = z16;
        obtain.mGifRoundCorner = f16;
        return URLDrawable.getDrawable(url, obtain);
    }

    public static URLDrawable getDrawable(URL url) {
        return a(url, 0, 0, null, null, false, 0.0f);
    }

    public static URLDrawable getDrawable(URL url, Drawable drawable, Drawable drawable2) {
        return a(url, 0, 0, drawable, drawable2, false, 0.0f);
    }
}
