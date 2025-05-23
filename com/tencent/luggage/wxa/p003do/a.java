package com.tencent.luggage.wxa.p003do;

import android.os.Build;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.luggage.wxa.tn.w;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f124400a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f124401b;

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0037, code lost:
    
        if (r0 != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a() {
        boolean equals;
        boolean equals2;
        if (f124401b == null) {
            String str = Build.BRAND;
            String str2 = Build.MANUFACTURER;
            w.d("MicroMsg.Vendor.Honor", "Build.BRAND:" + str + ", manufacture:" + str2);
            boolean z16 = true;
            equals = StringsKt__StringsJVMKt.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR, str, true);
            if (equals) {
                equals2 = StringsKt__StringsJVMKt.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR, str2, true);
            }
            z16 = false;
            f124401b = Boolean.valueOf(z16);
        }
        Boolean bool = f124401b;
        Intrinsics.checkNotNull(bool, "null cannot be cast to non-null type kotlin.Boolean");
        return bool.booleanValue();
    }
}
