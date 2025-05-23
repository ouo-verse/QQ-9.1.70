package com.tencent.luggage.wxa.aa;

import android.os.Build;
import androidx.exifinterface.media.ExifInterface;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class j {
    public static int a(int i3) {
        if (Build.VERSION.SDK_INT < 31 && !ExifInterface.LATITUDE_SOUTH.equalsIgnoreCase(Build.VERSION.CODENAME)) {
            return i3;
        }
        return i3 | 67108864;
    }
}
