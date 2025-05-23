package com.qq.e.tg.splash.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class BitmapUtil {
    /* JADX WARN: Removed duplicated region for block: B:12:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap a(String str, ImageView imageView) {
        int max;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        boolean z16 = true;
        try {
            if (imageView != null) {
                int i3 = options.outWidth;
                int i16 = options.outHeight;
                Context appContext = GDTADManager.getInstance().getAppContext();
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                int width = imageView.getWidth();
                if (width <= 0) {
                    if (layoutParams != null) {
                        width = layoutParams.width;
                    } else {
                        width = 0;
                    }
                }
                if (width <= 0) {
                    width = PxUtil.getDeviceWidthInPixel(appContext);
                }
                Context appContext2 = GDTADManager.getInstance().getAppContext();
                ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                int height = imageView.getHeight();
                if (height <= 0) {
                    if (layoutParams2 != null) {
                        height = layoutParams2.height;
                    } else {
                        height = 0;
                    }
                }
                if (height <= 0) {
                    height = PxUtil.getDeviceHeightInPixel(appContext2);
                }
                if (i3 > width || i16 > height) {
                    max = Math.max(Math.round(i3 / width), Math.round(i16 / height));
                    options.inSampleSize = max;
                    options.inJustDecodeBounds = false;
                    long currentTimeMillis = System.currentTimeMillis();
                    Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                    StringBuilder sb5 = new StringBuilder("decodeBitmapFromFile cost time :");
                    sb5.append(System.currentTimeMillis() - currentTimeMillis);
                    sb5.append(" is main thread :");
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        z16 = false;
                    }
                    sb5.append(z16);
                    GDTLogger.d(sb5.toString());
                    return decodeFile;
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            Bitmap decodeFile2 = BitmapFactory.decodeFile(str, options);
            StringBuilder sb52 = new StringBuilder("decodeBitmapFromFile cost time :");
            sb52.append(System.currentTimeMillis() - currentTimeMillis2);
            sb52.append(" is main thread :");
            if (Looper.myLooper() == Looper.getMainLooper()) {
            }
            sb52.append(z16);
            GDTLogger.d(sb52.toString());
            return decodeFile2;
        } catch (OutOfMemoryError e16) {
            GDTLogger.e("BitmapUtil##bitmap too big", e16);
            return null;
        }
        max = 1;
        options.inSampleSize = max;
        options.inJustDecodeBounds = false;
    }

    public static Bitmap decodeBitmapFromFile(File file, ImageView imageView) {
        if (file != null && file.exists()) {
            return a(file.getAbsolutePath(), imageView);
        }
        return null;
    }
}
