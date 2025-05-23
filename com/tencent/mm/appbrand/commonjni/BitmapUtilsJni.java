package com.tencent.mm.appbrand.commonjni;

import android.graphics.Bitmap;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.a9.b;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class BitmapUtilsJni {
    static {
        b.a("wxa-runtime-binding");
    }

    public static native int nativeCheckBitmapIsBlank(Bitmap bitmap, float f16, @Nullable CheckBitmapIsBlankResultDetails checkBitmapIsBlankResultDetails);
}
