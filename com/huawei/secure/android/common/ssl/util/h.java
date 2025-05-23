package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37987a = "h";

    public static String a(String str) {
        Context a16 = c.a();
        if (a16 == null) {
            return "";
        }
        try {
            return InstalledAppListMonitor.getPackageInfo(a16.getPackageManager(), str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e16) {
            g.b(f37987a, "getVersion NameNotFoundException : " + e16.getMessage());
            return "";
        } catch (Exception e17) {
            g.b(f37987a, "getVersion: " + e17.getMessage());
            return "";
        } catch (Throwable unused) {
            g.b(f37987a, "throwable");
            return "";
        }
    }

    public static int b(String str) {
        Context a16 = c.a();
        if (a16 == null) {
            return 0;
        }
        try {
            return InstalledAppListMonitor.getPackageInfo(a16.getPackageManager(), str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            g.b(f37987a, "getVersion NameNotFoundException");
            return 0;
        } catch (Exception e16) {
            g.b(f37987a, "getVersion: " + e16.getMessage());
            return 0;
        }
    }
}
