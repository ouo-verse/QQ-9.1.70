package com.tencent.luggage.wxa.g2;

import android.graphics.BitmapFactory;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.vd.c;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static String a(int i3) {
        switch (i3) {
            case 2:
                return "up-mirrored";
            case 3:
                return "down";
            case 4:
                return "down-mirrored";
            case 5:
                return "left-mirrored";
            case 6:
                return "right";
            case 7:
                return "right-mirrored";
            case 8:
                return "left";
            default:
                return "up";
        }
    }

    public static boolean b(BitmapFactory.Options options) {
        String str;
        if (options == null || (str = options.outMimeType) == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.indexOf("jpg") < 0 && lowerCase.indexOf(MimeHelper.IMAGE_SUBTYPE_JPEG) < 0) {
            return false;
        }
        return true;
    }

    public static int a(InputStream inputStream) {
        try {
            return c.a(inputStream);
        } catch (Exception e16) {
            w.b("Luggage.ImageInfoUtils", "getExifOrientation with stream, e = %s", e16);
            return 0;
        }
    }

    public static int a(String str) {
        if (!x.d(str)) {
            w.b("Luggage.ImageInfoUtils", "getExifOrientation err ");
            return 0;
        }
        try {
            InputStream n3 = x.n(str);
            try {
                int a16 = c.a(n3);
                if (n3 != null) {
                    n3.close();
                }
                return a16;
            } finally {
            }
        } catch (Exception e16) {
            w.b("Luggage.ImageInfoUtils", "getExifOrientation, path = %s, e = %s", str, e16);
            return 0;
        }
    }

    public static String a(BitmapFactory.Options options) {
        String str;
        if (options == null || (str = options.outMimeType) == null) {
            return "unknown";
        }
        String lowerCase = str.toLowerCase();
        return (lowerCase.indexOf("jpg") < 0 && lowerCase.indexOf(MimeHelper.IMAGE_SUBTYPE_JPEG) < 0) ? lowerCase.indexOf("png") >= 0 ? "png" : lowerCase.indexOf("gif") >= 0 ? "gif" : "unknown" : MimeHelper.IMAGE_SUBTYPE_JPEG;
    }
}
