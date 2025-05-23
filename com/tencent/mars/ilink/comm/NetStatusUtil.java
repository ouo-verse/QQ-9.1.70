package com.tencent.mars.ilink.comm;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mars.ilink.xlog.Log;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.rfix.loader.utils.RFixConstants;

/* compiled from: P */
/* loaded from: classes9.dex */
public class NetStatusUtil {
    public static final int CMNET = 6;
    public static final int CMWAP = 5;
    public static final int CTNET = 8;
    public static final int CTWAP = 7;
    public static final int LTE = 10;
    public static final int MOBILE = 9;
    public static final int NETTYPE_NOT_WIFI = 0;
    public static final int NETTYPE_WIFI = 1;
    public static final int NET_3G = 4;
    public static final int NON_NETWORK = -1;
    public static final int NO_SIM_OPERATOR = 0;
    public static final int POLICY_NONE = 0;
    public static final int POLICY_REJECT_METERED_BACKGROUND = 1;
    private static final String TAG = "MicroMsg.NetStatusUtil";
    public static final int TBACKGROUND_DATA_LIMITED = 2;
    public static final int TBACKGROUND_NOT_LIMITED = 0;
    public static final int TBACKGROUND_PROCESS_LIMITED = 1;
    public static final int TBACKGROUND_WIFI_LIMITED = 3;
    public static final int UNINET = 1;
    public static final int UNIWAP = 2;
    public static final int UNKNOW_TYPE = 999;
    public static final int WAP_3G = 3;
    public static final int WIFI = 0;
    private static int nowStrength = 30;

    public static void dumpNetStatus(Context context) {
        try {
            Log.i(TAG, ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().toString());
        } catch (Exception e16) {
            Log.e(TAG, "", e16);
        }
    }

    public static int getBackgroundLimitType(Context context) {
        int wifiSleeepPolicy;
        try {
            Class<?> cls = Class.forName("android.app.ActivityManagerNative");
            Object invoke = cls.getMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
            if (((Integer) invoke.getClass().getMethod("getProcessLimit", new Class[0]).invoke(invoke, new Object[0])).intValue() == 0) {
                return 1;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        try {
            wifiSleeepPolicy = getWifiSleeepPolicy(context);
        } catch (Exception e17) {
            e17.printStackTrace();
        }
        if (wifiSleeepPolicy != 2) {
            if (getNetType(context) == 0) {
                if (wifiSleeepPolicy != 1 && wifiSleeepPolicy != 0) {
                    return 0;
                }
                return 3;
            }
        }
        return 0;
    }

    public static int getISPCode(Context context) {
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
                e16.printStackTrace();
            }
        }
        return 0;
    }

    public static String getISPName(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        if (telephonyManager.getSimOperatorName().length() <= 100) {
            return telephonyManager.getSimOperatorName();
        }
        return telephonyManager.getSimOperatorName().substring(0, 100);
    }

    public static int getNetType(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return -1;
        }
        if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
            return 0;
        }
        if (NetworkMonitor.netGetExInfo(activeNetworkInfo) != null) {
            if (NetworkMonitor.netGetExInfo(activeNetworkInfo).equalsIgnoreCase("uninet")) {
                return 1;
            }
            if (NetworkMonitor.netGetExInfo(activeNetworkInfo).equalsIgnoreCase("uniwap")) {
                return 2;
            }
            if (NetworkMonitor.netGetExInfo(activeNetworkInfo).equalsIgnoreCase("3gwap")) {
                return 3;
            }
            if (NetworkMonitor.netGetExInfo(activeNetworkInfo).equalsIgnoreCase("3gnet")) {
                return 4;
            }
            if (NetworkMonitor.netGetExInfo(activeNetworkInfo).equalsIgnoreCase("cmwap")) {
                return 5;
            }
            if (NetworkMonitor.netGetExInfo(activeNetworkInfo).equalsIgnoreCase("cmnet")) {
                return 6;
            }
            if (NetworkMonitor.netGetExInfo(activeNetworkInfo).equalsIgnoreCase("ctwap")) {
                return 7;
            }
            if (NetworkMonitor.netGetExInfo(activeNetworkInfo).equalsIgnoreCase("ctnet")) {
                return 8;
            }
            if (NetworkMonitor.netGetExInfo(activeNetworkInfo).equalsIgnoreCase("LTE")) {
                return 10;
            }
            return 9;
        }
        return 9;
    }

    public static int getNetTypeForStat(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return 999;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return 999;
            }
            if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
                return 1;
            }
            int subtype = NetworkMonitor.getSubtype(activeNetworkInfo);
            if (subtype == 0) {
                return 999;
            }
            return subtype * 1000;
        } catch (Exception e16) {
            e16.printStackTrace();
            return 999;
        }
    }

    public static String getNetTypeString(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return "NON_NETWORK";
        }
        if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
            return Global.TRACKING_WIFI;
        }
        if (NetworkMonitor.netGetExInfo(activeNetworkInfo) != null) {
            return NetworkMonitor.netGetExInfo(activeNetworkInfo);
        }
        return "MOBILE";
    }

    public static int getNetWorkType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return NetworkMonitor.getType(activeNetworkInfo);
            }
            return -1;
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    public static int getProxyInfo(Context context, StringBuffer stringBuffer) {
        int i3;
        try {
            String defaultHost = Proxy.getDefaultHost();
            int defaultPort = Proxy.getDefaultPort();
            if (defaultHost != null && defaultHost.length() > 0 && defaultPort > 0) {
                stringBuffer.append(defaultHost);
                return defaultPort;
            }
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (property2 != null && property2.length() > 0) {
                i3 = Integer.parseInt(property2);
            } else {
                i3 = 80;
            }
            if (property != null && property.length() > 0) {
                stringBuffer.append(property);
                return i3;
            }
            return 0;
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    public static int getStrength(Context context) {
        if (context == null) {
            return 0;
        }
        return nowStrength;
    }

    public static int getWifiSleeepPolicy(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "wifi_sleep_policy", 2);
    }

    public static int guessNetSpeed(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
            return RFixConstants.MD5_FILE_BUF_LENGTH;
        }
        int subtype = NetworkMonitor.getSubtype(activeNetworkInfo);
        if (subtype != 1) {
            if (subtype != 2) {
                return RFixConstants.MD5_FILE_BUF_LENGTH;
            }
            return 8192;
        }
        return 4096;
    }

    public static boolean is2G(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
            return false;
        }
        if (NetworkMonitor.getSubtype(activeNetworkInfo) != 2 && NetworkMonitor.getSubtype(activeNetworkInfo) != 1) {
            if (NetworkMonitor.getSubtype(activeNetworkInfo) != 4) {
                return false;
            }
        }
        return true;
    }

    public static boolean is3G(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (NetworkMonitor.getType(activeNetworkInfo) != 1 && NetworkMonitor.getSubtype(activeNetworkInfo) >= 5) {
                if (NetworkMonitor.getSubtype(activeNetworkInfo) < 13) {
                    return true;
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return false;
    }

    public static boolean is4G(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
            return false;
        }
        if (NetworkMonitor.getSubtype(activeNetworkInfo) < 13) {
            return false;
        }
        return true;
    }

    public static boolean isConnected(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isImmediatelyDestroyActivities(Context context) {
        if (Settings.System.getInt(context.getContentResolver(), "always_finish_activities", 0) == 0) {
            return false;
        }
        return true;
    }

    public static boolean isKnownDirectNet(Context context) {
        int netType = getNetType(context);
        if (6 == netType || 1 == netType || 4 == netType || 8 == netType || 10 == netType || netType == 0) {
            return true;
        }
        return false;
    }

    public static boolean isLimited(int i3) {
        if (i3 == 2 || i3 == 1 || i3 == 3) {
            return true;
        }
        return false;
    }

    public static boolean isMobile(Context context) {
        try {
            if (NetworkMonitor.getType(((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == 1) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || activeNetworkInfo.getState() != NetworkInfo.State.CONNECTED) {
            return false;
        }
        return true;
    }

    public static boolean isWap(int i3) {
        return i3 == 2 || i3 == 5 || i3 == 7 || i3 == 3;
    }

    public static boolean isWifi(int i3) {
        return i3 == 0;
    }

    public static boolean isWap(Context context) {
        return isWap(getNetType(context));
    }

    public static boolean isWifi(Context context) {
        return isWifi(getNetType(context));
    }
}
