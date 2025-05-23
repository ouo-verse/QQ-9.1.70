package com.google.android.material.internal;

import android.os.Build;
import androidx.annotation.RestrictTo;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import java.util.Locale;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class f {
    public static boolean a() {
        if (!b() && !d()) {
            return false;
        }
        return true;
    }

    public static boolean b() {
        return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("lge");
    }

    public static boolean c() {
        return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("meizu");
    }

    public static boolean d() {
        return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING);
    }
}
