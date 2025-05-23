package com.tencent.aelight.camera.ae.flashshow.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes32.dex */
public class v {
    public static int a(Context context, float f16) {
        return (int) ((f16 * b(context)) + 0.5f);
    }

    public static void c(ImageView imageView, String str, int i3, int i16, Drawable drawable, String str2) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        if (TextUtils.isEmpty(str)) {
            imageView.setImageDrawable(drawable);
            return;
        }
        try {
            URL url = new URL(str);
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            obtain.mUseAutoScaleParams = false;
            obtain.mRequestWidth = i3;
            obtain.mRequestHeight = i16;
            if (!TextUtils.isEmpty(str2)) {
                obtain.mMemoryCacheKeySuffix = str2;
            }
            URLDrawable drawable2 = URLDrawable.getDrawable(url, obtain);
            if (drawable2.getStatus() == 2 || drawable2.getStatus() == 3) {
                ms.a.i("UIUtils", "drawable restartDownload");
                drawable2.restartDownload();
            }
            imageView.setImageDrawable(drawable2);
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
            ms.a.c("UIUtils", e16.getMessage());
            imageView.setImageDrawable(drawable);
        }
    }

    public static float b(Context context) {
        if (context == null) {
            return 0.0f;
        }
        return context.getResources().getDisplayMetrics().density;
    }
}
