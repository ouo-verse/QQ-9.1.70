package com.tencent.mobileqq.highway.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes9.dex */
public class HwNetworkUtil {
    static IPatchRedirector $redirector_ = null;
    public static final int CARRIER_OPERATOR_TYPE_CHINAMOBILE = 2;
    public static final int CARRIER_OPERATOR_TYPE_CHINATELECOM = 4;
    public static final int CARRIER_OPERATOR_TYPE_CHINAUNICOM = 3;
    public static final int CARRIER_OPERATOR_TYPE_UNKOWN = 1;
    public static final String TAG = "HwNetworkUtil";

    public HwNetworkUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static int getCarrierOperatorType(Context context) {
        String simOperator;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null || telephonyManager.getSimState() == 1 || (simOperator = DeviceInfoMonitor.getSimOperator(telephonyManager)) == null) {
            return 1;
        }
        if (!simOperator.startsWith("46000") && !simOperator.startsWith("46002") && !simOperator.startsWith("46007") && !simOperator.startsWith("46008")) {
            if (!simOperator.startsWith("46001") && !simOperator.startsWith("46006") && !simOperator.startsWith("46009")) {
                if (!simOperator.startsWith("46003") && !simOperator.startsWith("46005") && !simOperator.startsWith("46011")) {
                    return 1;
                }
                return 4;
            }
            return 3;
        }
        return 2;
    }

    public static int getCellId(Context context) {
        GsmCellLocation gsmCellLocation;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return -1;
        }
        try {
            CellLocation cellLocation = LocationMonitor.getCellLocation(telephonyManager);
            if (cellLocation instanceof CdmaCellLocation) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) LocationMonitor.getCellLocation(telephonyManager);
                if (cdmaCellLocation != null) {
                    return LocationMonitor.getBaseStationId(cdmaCellLocation);
                }
            } else if ((cellLocation instanceof GsmCellLocation) && (gsmCellLocation = (GsmCellLocation) LocationMonitor.getCellLocation(telephonyManager)) != null) {
                return LocationMonitor.getCid(gsmCellLocation);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getCellId() error " + e16, e16);
            }
        }
        return -1;
    }

    public static String getCurrentApn(Context context) {
        return AppNetConnInfo.getCurrentAPN();
    }

    public static String getNetworkName(Context context) {
        int systemNetwork = getSystemNetwork(context);
        if (systemNetwork != 1) {
            if (systemNetwork != 2 && systemNetwork != 3 && systemNetwork != 4) {
                return "UNKOWN";
            }
            return BdhUtils.getApnType(context);
        }
        return "Wi-Fi";
    }

    public static int getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            return NetworkMonitor.getType(activeNetworkInfo);
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getSystemNetwork(Context context) {
        NetworkInfo networkInfo;
        if (context == null) {
            return 0;
        }
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e16) {
            e16.printStackTrace();
            networkInfo = null;
            return networkInfo != null ? 0 : 0;
        } catch (Throwable th5) {
            th5.printStackTrace();
            networkInfo = null;
            if (networkInfo != null) {
            }
        }
        if (networkInfo != null && networkInfo.isAvailable()) {
            switch (NetworkMonitor.getType(networkInfo)) {
                case 0:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                    int mobileInfo = AppNetConnInfo.getMobileInfo();
                    if (mobileInfo == 2) {
                        return 3;
                    }
                    if (mobileInfo != 3 && mobileInfo != 4) {
                        return 2;
                    }
                    return 4;
                case 1:
                case 6:
                    return 1;
                case 8:
                default:
                    return 0;
                case 9:
                    return 5;
            }
        }
    }

    public static String getWifiSubNet(Context context) {
        DhcpInfo dhcpInfo;
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager != null && (dhcpInfo = NetworkMonitor.getDhcpInfo(wifiManager)) != null) {
            BdhLogUtil.LogEvent("N", "HwNetworkUtilgetWifiKey, dhcpInfo = " + dhcpInfo);
            int i3 = dhcpInfo.ipAddress;
            int i16 = dhcpInfo.netmask;
            if (i3 != 0 && i16 != 0) {
                return String.valueOf(Integer.valueOf(i16).intValue() & Integer.valueOf(i3).intValue());
            }
        }
        return null;
    }

    public static boolean is3Gor4G(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            int networkType = NetworkMonitor.getNetworkType((TelephonyManager) context.getSystemService("phone"));
            if (QLog.isColorLevel()) {
                QLog.d("is3Gor4G", 2, "type:" + networkType);
            }
            if (networkType == 0 && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected() && NetworkMonitor.getType(activeNetworkInfo) == 0) {
                networkType = NetworkMonitor.getSubtype(activeNetworkInfo);
            }
            if (networkType == 8 || networkType == 13 || networkType == 3 || networkType == 15 || networkType == 10 || networkType == 5 || networkType == 14 || networkType == 6 || networkType == 9 || networkType == 12) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isAirplaneModeOn(Context context) {
        if (Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 0) {
            return false;
        }
        return true;
    }

    public static boolean isMobileNetWork(Context context) {
        try {
            return isMobileNetworkInfo(((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo());
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isMobileNetworkInfo(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return false;
        }
        if (NetworkMonitor.getType(networkInfo) != 0 && 50 != NetworkMonitor.getType(networkInfo)) {
            return false;
        }
        return true;
    }

    public static boolean isNetSupport(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        try {
            NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
            if (allNetworkInfo != null) {
                for (NetworkInfo networkInfo : allNetworkInfo) {
                    if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return false;
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || NetworkMonitor.getType(activeNetworkInfo) != 1) {
            return false;
        }
        return true;
    }

    public static boolean isWifiEnabled(Context context) {
        if (!NetworkMonitor.getTypeName(((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()).toLowerCase().equals("wifi")) {
            return false;
        }
        return true;
    }
}
