package com.tencent.mobileqq.avifcodec.util;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.avifcodec.api.IAvifCodecApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class b {
    static IPatchRedirector $redirector_;

    public static AvifImageHeaderParser$AvifImageType a(@NonNull String str) {
        return ((IAvifCodecApi) QRoute.api(IAvifCodecApi.class)).getType(str);
    }

    public static boolean b(@NonNull String str) {
        if (a(str) != AvifImageHeaderParser$AvifImageType.UNKNOWN) {
            return true;
        }
        return false;
    }
}
