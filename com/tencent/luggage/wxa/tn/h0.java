package com.tencent.luggage.wxa.tn;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class h0 {
    public static boolean a(int i3) {
        return i3 == 2 || i3 == 5 || i3 == 7 || i3 == 3;
    }

    public static boolean b(int i3) {
        return i3 == 0;
    }

    public static String c(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return "";
            }
            w.a("MicroMsg.NetStatusUtil", "getISPName ISPName=%s", telephonyManager.getSimOperatorName());
            if (telephonyManager.getSimOperatorName().length() <= 100) {
                return telephonyManager.getSimOperatorName();
            }
            return telephonyManager.getSimOperatorName().substring(0, 100);
        } catch (Exception unused) {
            return "";
        }
    }

    public static int d(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if ((context != null && context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) || (connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return -1;
        }
        return a(activeNetworkInfo);
    }

    public static String e(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context != null && context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return "NON_NETWORK";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return "NON_NETWORK";
            }
            if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
                return Global.TRACKING_WIFI;
            }
            w.a("MicroMsg.NetStatusUtil", "activeNetInfo extra=%s, type=%d", NetworkMonitor.netGetExInfo(activeNetworkInfo), Integer.valueOf(NetworkMonitor.getType(activeNetworkInfo)));
            if (NetworkMonitor.netGetExInfo(activeNetworkInfo) != null) {
                return NetworkMonitor.netGetExInfo(activeNetworkInfo);
            }
            return "MOBILE";
        } catch (Exception e16) {
            w.a("MicroMsg.NetStatusUtil", e16, "", new Object[0]);
            return "NON_NETWORK";
        }
    }

    public static boolean f(Context context) {
        if (context != null && context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null || NetworkMonitor.getType(activeNetworkInfo) == 1) {
                    return false;
                }
                w.a("MicroMsg.NetStatusUtil", "is2G subtype %d", Integer.valueOf(NetworkMonitor.getSubtype(activeNetworkInfo)));
                if (NetworkMonitor.getSubtype(activeNetworkInfo) != 2 && NetworkMonitor.getSubtype(activeNetworkInfo) != 1 && NetworkMonitor.getSubtype(activeNetworkInfo) != 4 && NetworkMonitor.getSubtype(activeNetworkInfo) != 16 && NetworkMonitor.getSubtype(activeNetworkInfo) != 7) {
                    if (NetworkMonitor.getSubtype(activeNetworkInfo) == 11) {
                    }
                }
                return true;
            } catch (Exception e16) {
                w.a("MicroMsg.NetStatusUtil", e16, "", new Object[0]);
            }
        }
        return false;
    }

    public static boolean g(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context != null && context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return false;
        }
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e16) {
            w.a("MicroMsg.NetStatusUtil", e16, "", new Object[0]);
        }
        if (activeNetworkInfo == null || NetworkMonitor.getType(activeNetworkInfo) == 1) {
            return false;
        }
        w.a("MicroMsg.NetStatusUtil", "is3G subtype %d", Integer.valueOf(NetworkMonitor.getSubtype(activeNetworkInfo)));
        if (NetworkMonitor.getSubtype(activeNetworkInfo) >= 5) {
            if (NetworkMonitor.getSubtype(activeNetworkInfo) < 13) {
                return true;
            }
        }
        return false;
    }

    public static boolean h(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context != null && context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return false;
        }
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e16) {
            w.a("MicroMsg.NetStatusUtil", e16, "", new Object[0]);
        }
        if (activeNetworkInfo == null || NetworkMonitor.getType(activeNetworkInfo) == 1) {
            return false;
        }
        w.a("MicroMsg.NetStatusUtil", "is4G subtype %d", Integer.valueOf(NetworkMonitor.getSubtype(activeNetworkInfo)));
        if (NetworkMonitor.getSubtype(activeNetworkInfo) >= 13) {
            if (NetworkMonitor.getSubtype(activeNetworkInfo) < 20) {
                return true;
            }
        }
        return false;
    }

    public static boolean i(Context context) {
        if (context != null) {
            try {
                if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
                    return false;
                }
            } catch (Exception e16) {
                w.a("MicroMsg.NetStatusUtil", e16, "", new Object[0]);
            }
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || NetworkMonitor.getType(activeNetworkInfo) == 1) {
            return false;
        }
        w.a("MicroMsg.NetStatusUtil", "is5G subtype %d", Integer.valueOf(NetworkMonitor.getSubtype(activeNetworkInfo)));
        if (NetworkMonitor.getSubtype(activeNetworkInfo) < 20) {
            return false;
        }
        return true;
    }

    public static boolean j(Context context) {
        ConnectivityManager connectivityManager;
        if ((context != null && context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) || (connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            return connectivityManager.getActiveNetworkInfo().isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean k(Context context) {
        return j(context);
    }

    public static boolean l(Context context) {
        return b(d(context));
    }

    public static boolean m(Context context) {
        int d16 = d(context);
        if (d16 != 0 && d16 != 10) {
            w.a("MicroMsg.NetStatusUtil", "[cpan] is mobile network");
            return false;
        }
        w.a("MicroMsg.NetStatusUtil", "[cpan] is wifi or 4g network");
        return true;
    }

    public static String a(Context context) {
        return f(context) ? "2G" : g(context) ? "3G" : h(context) ? "4G" : i(context) ? "5G" : l(context) ? Global.TRACKING_WIFI : e(context);
    }

    public static int b(Context context) {
        String simOperator;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null && (simOperator = DeviceInfoMonitor.getSimOperator(telephonyManager)) != null && simOperator.length() >= 5) {
            StringBuilder sb5 = new StringBuilder();
            try {
                int length = simOperator.length();
                if (length > 6) {
                    length = 6;
                }
                for (int i3 = 0; i3 < length; i3++) {
                    if (!Character.isDigit(simOperator.charAt(i3))) {
                        if (sb5.length() > 0) {
                            break;
                        }
                    } else {
                        sb5.append(simOperator.charAt(i3));
                    }
                }
                return Integer.valueOf(sb5.toString()).intValue();
            } catch (Exception e16) {
                w.a("MicroMsg.NetStatusUtil", e16, "", new Object[0]);
            }
        }
        return 0;
    }

    public static int a(NetworkInfo networkInfo) {
        if (NetworkMonitor.getType(networkInfo) == 1) {
            return 0;
        }
        w.a("MicroMsg.NetStatusUtil", "activeNetInfo extra=%s, type=%d", NetworkMonitor.netGetExInfo(networkInfo), Integer.valueOf(NetworkMonitor.getType(networkInfo)));
        if (NetworkMonitor.netGetExInfo(networkInfo) == null) {
            return 9;
        }
        if (NetworkMonitor.netGetExInfo(networkInfo).equalsIgnoreCase("uninet")) {
            return 1;
        }
        if (NetworkMonitor.netGetExInfo(networkInfo).equalsIgnoreCase("uniwap")) {
            return 2;
        }
        if (NetworkMonitor.netGetExInfo(networkInfo).equalsIgnoreCase("3gwap")) {
            return 3;
        }
        if (NetworkMonitor.netGetExInfo(networkInfo).equalsIgnoreCase("3gnet")) {
            return 4;
        }
        if (NetworkMonitor.netGetExInfo(networkInfo).equalsIgnoreCase("cmwap")) {
            return 5;
        }
        if (NetworkMonitor.netGetExInfo(networkInfo).equalsIgnoreCase("cmnet")) {
            return 6;
        }
        if (NetworkMonitor.netGetExInfo(networkInfo).equalsIgnoreCase("ctwap")) {
            return 7;
        }
        if (NetworkMonitor.netGetExInfo(networkInfo).equalsIgnoreCase("ctnet")) {
            return 8;
        }
        return NetworkMonitor.netGetExInfo(networkInfo).equalsIgnoreCase("LTE") ? 10 : 9;
    }
}
