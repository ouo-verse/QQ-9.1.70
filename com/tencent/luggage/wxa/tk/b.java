package com.tencent.luggage.wxa.tk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {
    public static PackageInfo a(Context context, String str) {
        if (str == null) {
            w.b("Luggage.AndroidPackageUtil", "getPackageInfo fail, packageName is null");
            return null;
        }
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 0);
        } catch (PackageManager.NameNotFoundException e16) {
            w.f("Luggage.AndroidPackageUtil", e16.getMessage());
            return null;
        }
    }
}
