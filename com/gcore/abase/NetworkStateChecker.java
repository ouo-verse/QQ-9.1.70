package com.gcore.abase;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import androidx.core.content.ContextCompat;
import com.gcore.abase.log.XLog;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes2.dex */
public class NetworkStateChecker {
    private static final String tag = "NetworkStateChecker";

    public int CheckNetworkState(Context context) {
        NetworkState networkState = NetworkState.NotReachable;
        networkState.ordinal();
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return networkState.ordinal();
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                int type = NetworkMonitor.getType(activeNetworkInfo);
                if (type != 0) {
                    if (type != 1) {
                        return NetworkState.ReachableViaOthers.ordinal();
                    }
                    return NetworkState.ReachableViaWiFi.ordinal();
                }
                return NetworkState.ReachableViaWWAN.ordinal();
            }
            return networkState.ordinal();
        } catch (Exception e16) {
            XLog.e(tag, "check Get exception:" + e16.toString());
            return NetworkState.NotReachable.ordinal();
        }
    }

    public String GetBSSID(Context context) {
        return "None";
    }

    public String GetCurrentAPN(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
            int type = NetworkMonitor.getType(activeNetworkInfo);
            if (type == 1) {
                String netGetExInfo = NetworkMonitor.netGetExInfo(activeNetworkInfo);
                if (netGetExInfo == null) {
                    XLog.e("getExtraInfo is null");
                    return "";
                }
                return netGetExInfo;
            }
            if (type == 0) {
                String netGetExInfo2 = NetworkMonitor.netGetExInfo(activeNetworkInfo);
                if (netGetExInfo2 == null) {
                    XLog.e("Error", "getExtraInfo is null");
                    return "";
                }
                Locale locale = Locale.ENGLISH;
                String lowerCase = netGetExInfo2.toLowerCase(locale);
                if (lowerCase.startsWith("cmwap")) {
                    return "CMWAP";
                }
                if (lowerCase.startsWith("cmnet")) {
                    return "CMNET";
                }
                if (lowerCase.startsWith("uniwap")) {
                    return "UNIWAP";
                }
                if (lowerCase.startsWith("uninet")) {
                    return "UNINET";
                }
                if (lowerCase.startsWith("wap")) {
                    return "WAP";
                }
                if (lowerCase.startsWith("net")) {
                    return "NET";
                }
                if (lowerCase.startsWith("ctwap")) {
                    return "CTWAP";
                }
                if (lowerCase.startsWith("ctnet")) {
                    return "CTNET";
                }
                if (lowerCase.startsWith("3gwap")) {
                    return "3GWAP";
                }
                if (lowerCase.startsWith("3gnet")) {
                    return "3GNET";
                }
                return lowerCase.toUpperCase(locale);
            }
        }
        return "";
    }

    public int GetCurrentCarrier(String str, String str2) {
        Carrier carrier;
        Carrier carrier2;
        if (!str.equals("46000") && !str.equals("46002") && !str.equals("46007")) {
            if (!str.equals("46001") && !str.equals("46006")) {
                if (!str.equals("46003") && !str.equals("46005")) {
                    if (str.equals("46004")) {
                        carrier = Carrier.StateSpacecom;
                    } else {
                        carrier = Carrier.Unknown;
                    }
                } else {
                    carrier = Carrier.StateTelecom;
                }
            } else {
                carrier = Carrier.StateUnicom;
            }
        } else {
            carrier = Carrier.StateMobile;
        }
        if (str2.equals("")) {
            carrier2 = Carrier.None;
        } else if (!str2.equals("CMWAP") && !str2.equals("CMNET")) {
            if (!str2.equals("UNIWAP") && !str2.equals("UNINET") && !str2.equals("3GWAP") && !str2.equals("3GNET")) {
                if (!str2.equals("CTWAP") && !str2.equals("CTNET")) {
                    carrier2 = Carrier.Unknown;
                } else {
                    carrier2 = Carrier.StateTelecom;
                }
            } else {
                carrier2 = Carrier.StateUnicom;
            }
        } else {
            carrier2 = Carrier.StateMobile;
        }
        if (!carrier2.equals(Carrier.None) && !carrier2.equals(Carrier.Unknown) && !carrier2.equals(carrier)) {
            return carrier2.ordinal();
        }
        return carrier.ordinal();
    }

    public String GetCurrentCarrierCode(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null && 5 == telephonyManager.getSimState()) {
            return DeviceInfoMonitor.getSimOperator(telephonyManager);
        }
        return "";
    }

    public int GetDetailNetworkState(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                XLog.w(tag, "NetworkStateChecker connManager is null");
                return DetailNetworkState.NotReachable.ordinal();
            }
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") != 0) {
                XLog.w(tag, "GetDetailNetworkState has not ACCESS_NETWORK_STATE permission");
                return DetailNetworkState.NotReachable.ordinal();
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (1 == NetworkMonitor.getType(activeNetworkInfo)) {
                    return DetailNetworkState.ReachableViaWiFi.ordinal();
                }
                if (NetworkMonitor.getType(activeNetworkInfo) == 0) {
                    int subtype = NetworkMonitor.getSubtype(activeNetworkInfo);
                    if (subtype != 20) {
                        switch (subtype) {
                            case 1:
                            case 2:
                            case 4:
                            case 7:
                            case 11:
                                return DetailNetworkState.ReachableViaWWAN_2G.ordinal();
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 14:
                            case 15:
                                return DetailNetworkState.ReachableViaWWAN_3G.ordinal();
                            case 13:
                                return DetailNetworkState.ReachableViaWWAN_4G.ordinal();
                            default:
                                return DetailNetworkState.ReachableViaWWAN_UNKNOWN.ordinal();
                        }
                    }
                    return DetailNetworkState.ReachableViaWWAN_5G.ordinal();
                }
                return DetailNetworkState.ReachableViaOthers.ordinal();
            }
            XLog.w(tag, "NetworkStateChecker ApolloNetInfo is null");
            return DetailNetworkState.NotReachable.ordinal();
        } catch (Exception e16) {
            XLog.w(tag, "check Get exception:" + e16.toString());
            return DetailNetworkState.NotReachable.ordinal();
        }
    }

    public String GetSSID(Context context) {
        return "None";
    }
}
