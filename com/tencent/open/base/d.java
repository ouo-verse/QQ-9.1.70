package com.tencent.open.base;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import com.tencent.open.base.img.ImageCache;
import java.io.ByteArrayOutputStream;
import java.io.File;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d {
    @TargetApi(8)
    public static String a(Drawable drawable) {
        Bitmap b16 = b(drawable);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b16.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    public static Bitmap b(Drawable drawable) {
        Bitmap.Config config;
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (drawable.getOpacity() != -1) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static Bitmap c(String str) {
        String d16 = d(str, 100);
        String e16 = ImageCache.e("app", d16);
        f.e("ImageUtil", "100_url:" + d16 + " icon_path=" + e16);
        if (new File(e16).exists()) {
            return b.d(e16, 72, 72, false);
        }
        String d17 = d(str, 75);
        String e17 = ImageCache.e("app", d17);
        f.e("ImageUtil", "75_url:" + d17 + " icon_path=" + e17);
        if (new File(e17).exists()) {
            return b.d(e17, 72, 72, false);
        }
        return null;
    }

    public static String d(String str, int i3) {
        if (str == null) {
            return "";
        }
        String str2 = "00000000" + str;
        String substring = str2.substring(str2.length() - 8);
        String format = String.format("https://open.gtimg.cn/open/app_icon/%s/%s/%s/%s/%s_%d_m.png", substring.substring(0, 2), substring.substring(2, 4), substring.substring(4, 6), substring.substring(6, 8), str, Integer.valueOf(i3));
        f.e("opensdk", ">>iconUrl=" + format);
        return format;
    }

    public static Bitmap e(Drawable drawable) {
        return b(drawable);
    }
}
