package com.qq.e.comm.plugin.k;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class h {
    public static Bitmap a(File file, ImageView imageView) {
        if (file == null || !file.exists()) {
            return null;
        }
        return a(file.getAbsolutePath(), imageView);
    }

    private static int b(ImageView imageView) {
        Context appContext = GDTADManager.getInstance().getAppContext();
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int height = imageView.getHeight();
        if (height <= 0) {
            if (layoutParams != null) {
                height = layoutParams.height;
            } else {
                height = 0;
            }
        }
        if (height <= 0) {
            return ak.c(appContext);
        }
        return height;
    }

    private static Bitmap a(String str, ImageView imageView) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        boolean z16 = true;
        options.inPreferredConfig = com.qq.e.comm.plugin.j.c.a("bitmapDecodeByARGB888", 1, 1) ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        options.inSampleSize = a(options, imageView);
        options.inJustDecodeBounds = false;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("decodeBitmapFromFile cost time :");
            sb5.append(System.currentTimeMillis() - currentTimeMillis);
            sb5.append(" is main thread :");
            if (Looper.myLooper() != Looper.getMainLooper()) {
                z16 = false;
            }
            sb5.append(z16);
            GDTLogger.d(sb5.toString());
            a(options);
            return decodeFile;
        } catch (OutOfMemoryError e16) {
            GDTLogger.e("BitmapUtil##bitmap too big", e16);
            return null;
        }
    }

    private static void a(BitmapFactory.Options options) {
        if (options == null) {
            return;
        }
        GDTLogger.i("BitmapOutMimeType : " + options.outMimeType);
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("error_code", options.outMimeType);
        cVar.a("httpErrorCode", Integer.valueOf(bc.a() ? 1 : 0));
        StatTracer.trackEvent(1330002, 0, (com.qq.e.comm.plugin.stat.b) null, cVar);
    }

    private static int a(BitmapFactory.Options options, ImageView imageView) {
        if (imageView == null) {
            return 1;
        }
        int i3 = options.outWidth;
        int i16 = options.outHeight;
        int a16 = a(imageView);
        int b16 = b(imageView);
        if (i3 > a16 || i16 > b16) {
            return Math.max(Math.round((i3 * 1.0f) / a16), Math.round((i16 * 1.0f) / b16));
        }
        return 1;
    }

    private static int a(ImageView imageView) {
        Context appContext = GDTADManager.getInstance().getAppContext();
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int width = imageView.getWidth();
        if (width <= 0) {
            width = layoutParams != null ? layoutParams.width : 0;
        }
        return width <= 0 ? ak.b(appContext) : width;
    }
}
