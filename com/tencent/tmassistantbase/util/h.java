package com.tencent.tmassistantbase.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;

/* compiled from: P */
/* loaded from: classes26.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static com.tencent.tmassistantbase.common.b f380474a = new com.tencent.tmassistantbase.common.b();

    public static com.tencent.tmassistantbase.common.b a() {
        if (f380474a.f380422a == com.tencent.tmassistantbase.common.a.UN_DETECT) {
            c();
        }
        return f380474a;
    }

    public static boolean b() {
        return !TextUtils.isEmpty(Proxy.getDefaultHost());
    }

    public static void c() {
        if (GlobalUtil.getInstance().getContext() != null) {
            f380474a = c(GlobalUtil.getInstance().getContext());
        }
    }

    private static com.tencent.tmassistantbase.common.b b(Context context) {
        boolean b16;
        int networkType;
        int a16;
        com.tencent.tmassistantbase.common.b bVar = new com.tencent.tmassistantbase.common.b();
        try {
            b16 = b();
            bVar.f380425d = b16;
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            String networkOperator = DeviceInfoMonitor.getNetworkOperator(telephonyManager);
            bVar.f380423b = networkOperator;
            networkType = NetworkMonitor.getNetworkType(telephonyManager);
            bVar.f380424c = networkType;
            a16 = a(networkOperator);
        } catch (Exception unused) {
        }
        if (a16 == 0) {
            if (networkType == 1 || networkType == 2) {
                if (b16) {
                    bVar.f380422a = com.tencent.tmassistantbase.common.a.CMWAP;
                } else {
                    bVar.f380422a = com.tencent.tmassistantbase.common.a.CMNET;
                }
                return bVar;
            }
            if (networkType == 13) {
                if (b16) {
                    bVar.f380422a = com.tencent.tmassistantbase.common.a.WAP4G;
                } else {
                    bVar.f380422a = com.tencent.tmassistantbase.common.a.NET4G;
                }
                return bVar;
            }
            if (networkType != 16) {
                if (b16) {
                    bVar.f380422a = com.tencent.tmassistantbase.common.a.UNKNOW_WAP;
                } else {
                    bVar.f380422a = com.tencent.tmassistantbase.common.a.UNKNOWN;
                }
                return bVar;
            }
            if (b16) {
                bVar.f380422a = com.tencent.tmassistantbase.common.a.CMWAP;
            } else {
                bVar.f380422a = com.tencent.tmassistantbase.common.a.CMNET;
            }
            return bVar;
        }
        if (a16 != 1) {
            if (a16 != 2) {
                if (b16) {
                    bVar.f380422a = com.tencent.tmassistantbase.common.a.UNKNOW_WAP;
                } else {
                    bVar.f380422a = com.tencent.tmassistantbase.common.a.UNKNOWN;
                }
                return bVar;
            }
            if (networkType != 13) {
                if (b16) {
                    bVar.f380422a = com.tencent.tmassistantbase.common.a.CTWAP;
                } else {
                    bVar.f380422a = com.tencent.tmassistantbase.common.a.CTNET;
                }
                return bVar;
            }
            if (b16) {
                bVar.f380422a = com.tencent.tmassistantbase.common.a.WAP4G;
            } else {
                bVar.f380422a = com.tencent.tmassistantbase.common.a.NET4G;
            }
            return bVar;
        }
        if (networkType == 1 || networkType == 2) {
            if (b16) {
                bVar.f380422a = com.tencent.tmassistantbase.common.a.UNIWAP;
            } else {
                bVar.f380422a = com.tencent.tmassistantbase.common.a.UNINET;
            }
            return bVar;
        }
        if (networkType != 3 && networkType != 8 && networkType != 10) {
            if (networkType == 13) {
                if (b16) {
                    bVar.f380422a = com.tencent.tmassistantbase.common.a.WAP4G;
                } else {
                    bVar.f380422a = com.tencent.tmassistantbase.common.a.NET4G;
                }
                return bVar;
            }
            if (networkType != 15) {
                if (b16) {
                    bVar.f380422a = com.tencent.tmassistantbase.common.a.UNKNOW_WAP;
                } else {
                    bVar.f380422a = com.tencent.tmassistantbase.common.a.UNKNOWN;
                }
                return bVar;
            }
        }
        if (b16) {
            bVar.f380422a = com.tencent.tmassistantbase.common.a.WAP3G;
        } else {
            bVar.f380422a = com.tencent.tmassistantbase.common.a.NET3G;
        }
        return bVar;
    }

    private static com.tencent.tmassistantbase.common.b c(Context context) {
        com.tencent.tmassistantbase.common.b bVar = new com.tencent.tmassistantbase.common.b();
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            r1 = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (r1 == null || !r1.isAvailable()) {
                bVar.f380422a = com.tencent.tmassistantbase.common.a.NO_NETWORK;
                return bVar;
            }
        } catch (Throwable unused) {
        }
        if (r1 != null && NetworkMonitor.getType(r1) == 1) {
            bVar.f380422a = com.tencent.tmassistantbase.common.a.WIFI;
            WifiManager wifiManager = (WifiManager) GlobalUtil.getInstance().getContext().getSystemService("wifi");
            if (wifiManager != null) {
                try {
                    LocationMonitor.getConnectionInfo(wifiManager);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
            return bVar;
        }
        return b(context);
    }

    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (str.equals("46000") || str.equals("46002") || str.equals("46007")) {
            return 0;
        }
        if (str.equals("46001")) {
            return 1;
        }
        return str.equals("46003") ? 2 : -1;
    }

    public static boolean a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }
}
