package com.tencent.luggage.wxa.xg;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.luggage.wxa.n0.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static String f144953a;

    public static String a(Context context) {
        ApplicationInfo applicationInfo;
        if (!w0.c(f144953a)) {
            return f144953a;
        }
        f144953a = context.getPackageName();
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), f144953a, 0);
            if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null && !w0.c(applicationInfo.name)) {
                f144953a = packageInfo.applicationInfo.name;
            }
        } catch (PackageManager.NameNotFoundException e16) {
            w.a("MicroMsg.AppBrand.Video.Utils", e16, "getUserAgent exception", new Object[0]);
        }
        return v.a(context, f144953a);
    }
}
