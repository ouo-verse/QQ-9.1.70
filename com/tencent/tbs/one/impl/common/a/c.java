package com.tencent.tbs.one.impl.common.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.tbs.one.impl.a.e;
import com.tencent.tbs.one.impl.a.g;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class c {
    public static int a(Context context) {
        boolean z16;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                    return 0;
                }
                int type = NetworkMonitor.getType(activeNetworkInfo);
                if (type == 0) {
                    switch (NetworkMonitor.getSubtype(activeNetworkInfo)) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return 1;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return 2;
                        case 13:
                            return 4;
                        default:
                            return 0;
                    }
                }
                if (type != 1) {
                    return 0;
                }
                return 3;
            }
            g.b("Require \"ACCESS_NETWORK_STATE\" permission for reading apn type!", new Object[0]);
            return 0;
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Deprecated
    public static String b() {
        return "";
    }

    public static String c(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (Exception e16) {
            e16.printStackTrace();
            g.c("Get app version name exception!", e16);
            return null;
        }
    }

    public static int d(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionCode;
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    public static String e(Context context) {
        return e.b(context);
    }
}
