package com.tencent.biz.subscribe.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.Pair;
import android.widget.ImageView;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.BaseImageUtil;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(String str, ImageView imageView) {
        try {
            Bitmap f16 = ImageCacheHelper.f98636a.f(str);
            if (f16 != null) {
                g(f16, imageView);
                return;
            }
            URLConnection openConnection = new URL(str).openConnection();
            int contentLength = ((HttpURLConnection) openConnection).getContentLength();
            openConnection.connect();
            InputStream inputStream = openConnection.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, contentLength);
            Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream);
            bufferedInputStream.close();
            inputStream.close();
            f(str, decodeStream, imageView);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(Bitmap bitmap, ImageView imageView) {
        if (bitmap != null && imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public static void e(final String str, final ImageView imageView) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.subscribe.utils.d
            @Override // java.lang.Runnable
            public final void run() {
                f.c(str, imageView);
            }
        }, 5, null, false);
    }

    private static void f(String str, Bitmap bitmap, ImageView imageView) {
        Bitmap gaussionBlur;
        Bitmap copy;
        if (bitmap != null && (gaussionBlur = BaseImageUtil.gaussionBlur(imageView.getContext(), bitmap, 0.25f, 20.0f)) != null) {
            Canvas canvas = new Canvas();
            if (gaussionBlur.isMutable()) {
                copy = gaussionBlur;
            } else {
                copy = gaussionBlur.copy(gaussionBlur.getConfig(), true);
            }
            canvas.setBitmap(copy);
            canvas.drawColor(Color.parseColor("#3F000000"), PorterDuff.Mode.SRC_OVER);
            Pair<Integer, Integer> b16 = com.tencent.biz.qqstory.utils.k.b(bitmap.getWidth(), bitmap.getHeight(), imageView.getWidth(), imageView.getHeight());
            Bitmap l3 = com.tencent.biz.qqstory.utils.b.l(com.tencent.biz.qqstory.utils.b.n(gaussionBlur, ((Integer) b16.first).intValue(), ((Integer) b16.second).intValue(), true), bitmap);
            g(l3, imageView);
            ImageCacheHelper.f98636a.i(str, l3, Business.Conversation);
        }
    }

    private static void g(final Bitmap bitmap, final ImageView imageView) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.subscribe.utils.e
            @Override // java.lang.Runnable
            public final void run() {
                f.d(bitmap, imageView);
            }
        });
    }
}
