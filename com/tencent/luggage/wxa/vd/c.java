package com.tencent.luggage.wxa.vd;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.luggage.wxa.cp.v;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {
    public static int a(InputStream inputStream) {
        if (inputStream == null) {
            return 0;
        }
        try {
            return new ExifInterface(inputStream).getAttributeInt("Orientation", 1);
        } catch (Error | Exception unused) {
            return 0;
        }
    }

    public static void a(String str, String str2) {
        if (a(str) && a(str2)) {
            ExifInterface exifInterface = new ExifInterface(str2);
            b.a(new ExifInterface(str), exifInterface);
            exifInterface.setAttribute("Orientation", null);
            exifInterface.setAttribute("ImageWidth", null);
            exifInterface.setAttribute("ThumbnailImageWidth", null);
            exifInterface.saveAttributes();
        }
    }

    public static void a(InputStream inputStream, String str) {
        if (inputStream == null || !a(str)) {
            return;
        }
        ExifInterface exifInterface = new ExifInterface(str);
        b.a(new ExifInterface(inputStream), exifInterface);
        exifInterface.setAttribute("Orientation", null);
        exifInterface.setAttribute("ImageWidth", null);
        exifInterface.setAttribute("ThumbnailImageWidth", null);
        exifInterface.saveAttributes();
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && new v(str).e();
    }
}
