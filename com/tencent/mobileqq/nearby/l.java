package com.tencent.mobileqq.nearby;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.nearby.widget.api.INearbyUtilsDelegate;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private static INearbyUtilsDelegate f252637a = (INearbyUtilsDelegate) QRoute.api(INearbyUtilsDelegate.class);

    public static boolean a(Context context) {
        return f252637a.isNetworkConnected(context);
    }

    public static void b(String str, Object... objArr) {
        f252637a.printColorLevelLog(str, objArr);
    }

    public static void c(String str, String str2, Object... objArr) {
        f252637a.printLog(str, str2, objArr);
    }

    public static void d(Activity activity, int i3) {
        f252637a.startBindPhonePageForResult(activity, i3);
    }
}
