package com.sina.weibo.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.c.a;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f61219a = false;

    /* renamed from: b, reason: collision with root package name */
    private static AuthInfo f61220b;

    public static void a(Context context, AuthInfo authInfo) {
        if (f61219a) {
            return;
        }
        if (authInfo != null) {
            f61220b = authInfo;
            com.sina.weibo.sdk.a.a.b().b(context, authInfo.getAppKey());
            f61219a = true;
            return;
        }
        throw new RuntimeException("authInfo must not be null.");
    }

    public static boolean b(Context context) {
        a.C0511a c16;
        if (!a(context) || (c16 = com.sina.weibo.sdk.c.a.c(context)) == null || c16.f61248an < 10772) {
            return false;
        }
        return true;
    }

    public static boolean a(Context context) {
        List<ResolveInfo> queryIntentServices;
        Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
        intent.addCategory("android.intent.category.DEFAULT");
        return (context == null || (queryIntentServices = InstalledAppListMonitor.queryIntentServices(context.getPackageManager(), intent, 0)) == null || queryIntentServices.isEmpty()) ? false : true;
    }

    public static AuthInfo a() {
        if (f61219a) {
            return f61220b;
        }
        throw new RuntimeException("please init sdk before use it. Wb.install()");
    }
}
