package com.tencent.luggage.wxa.v3;

import android.content.pm.PackageInfo;
import android.os.Build;
import com.tencent.luggage.wxa.tn.r0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static Long f143071a;

    public static boolean a() {
        boolean z16;
        boolean z17 = r0.f141702c;
        boolean b16 = f.b();
        if (b16 && f.c()) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean c16 = c();
        if (z17 && b16 && z16 && c16) {
            return true;
        }
        w.b("Luggage.OpenSDKApiUtil", "canInvokeByOpenSdk returns false, buildConfigOpen:%b, wxApiInitialized:%b, wxInstalled:%b, wxSupported:%b", Boolean.valueOf(z17), Boolean.valueOf(b16), Boolean.valueOf(z16), Boolean.valueOf(c16));
        return false;
    }

    public static long b() {
        long longVersionCode;
        if (f143071a == null) {
            try {
                PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(z.c().getPackageManager(), "com.tencent.mm", 64);
                if (Build.VERSION.SDK_INT >= 28) {
                    longVersionCode = packageInfo.getLongVersionCode();
                    f143071a = Long.valueOf(longVersionCode);
                } else {
                    f143071a = Long.valueOf(packageInfo.versionCode);
                }
            } catch (Exception e16) {
                w.b("Luggage.OpenSDKApiUtil", "getWechatVersionCode exception = %s", e16);
            }
        }
        Long l3 = f143071a;
        if (l3 != null) {
            return l3.longValue();
        }
        return 0L;
    }

    public static boolean c() {
        boolean z16;
        long b16 = b();
        if (b16 > 1341) {
            z16 = true;
        } else {
            z16 = false;
        }
        w.a("Luggage.OpenSDKApiUtil", "curWechatVersionCode:%d, canRunOpensdkJsApi:%b", Long.valueOf(b16), Boolean.valueOf(z16));
        return z16;
    }
}
