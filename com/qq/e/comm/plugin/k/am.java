package com.qq.e.comm.plugin.k;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;

/* compiled from: P */
/* loaded from: classes3.dex */
public class am {
    public static Bitmap a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                byte[] decode = Base64.decode(str, 0);
                if (decode != null && decode.length > 0) {
                    return BitmapFactory.decodeByteArray(decode, 0, decode.length);
                }
                return null;
            } catch (Throwable th5) {
                th5.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
