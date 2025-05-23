package com.tencent.qqlive.tvkplayer.tools.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.http.Headers;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKNetworkUtils {
    public static final int IPSTACK_TYPE_DUAL_STACK = 3;
    public static final int IPSTACK_TYPE_IPV4_ONLY = 1;
    public static final int IPSTACK_TYPE_IPV6_ONLY = 2;
    public static final int IPSTACK_TYPE_UNKNOWN = 0;
    private static final int NETWORK_CONNECT_AVAILABLE = 1;
    private static final int NETWORK_CONNECT_NOT_AVAILABLE = 0;
    private static final int NETWORK_CONNECT_UNKNOWN = -1;
    public static final int NETWORK_TYPE_2_G = 2;
    public static final int NETWORK_TYPE_3_G = 3;
    public static final int NETWORK_TYPE_4_G = 4;
    public static final int NETWORK_TYPE_5_G = 5;
    private static final int NETWORK_TYPE_NR = 20;
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    public static final int NETWORK_TYPE_WIFI = 1;
    public static final int OPERATOR_CHINA_MOBILE = 3;
    public static final int OPERATOR_CHINA_TELECOM = 1;
    public static final int OPERATOR_CHINA_UNICOM = 2;
    public static final int OPERATOR_UNKNOWN = 0;
    private static final String TAG = "TVKPlayer[TVKNetworkUtils]";
    private static int sIPStackType = 0;
    private static boolean sIsNetworkTypeMobile = true;
    private static int sMCC = 0;
    private static int sMNC = 0;
    private static int sNetWorkType = 0;
    private static int sNetworkConnectionState = -1;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface IPStackType {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface MobileOperator {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface NetworkConnectState {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface NetworkType {
    }

    private static int getCurrentNetworkIpStackType(Context context) {
        if (!isNetworkAvailable()) {
            return 0;
        }
        try {
            if (isIpv6Only(context.getApplicationContext())) {
                return 2;
            }
            if (isIpv4Only()) {
                return 1;
            }
            return 3;
        } catch (Exception e16) {
            TVKLogUtil.d(TAG, "exception: " + e16);
            return 0;
        }
    }

    public static String getHostnameFromUrl(String str) {
        try {
            return new URL(str).getHost();
        } catch (MalformedURLException e16) {
            TVKLogUtil.e(TAG, e16);
            return "";
        }
    }

    public static List<String> getHostnameFromUrls(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String hostnameFromUrl = getHostnameFromUrl(it.next());
            if (!TextUtils.isEmpty(hostnameFromUrl)) {
                arrayList.add(hostnameFromUrl);
            }
        }
        return arrayList;
    }

    public static int getIPStackType() {
        return sIPStackType;
    }

    public static int getMCC(Context context) {
        int i3 = sMCC;
        if (i3 != 0) {
            return i3;
        }
        if (context == null) {
            return 0;
        }
        try {
            Configuration configuration = context.getResources().getConfiguration();
            if (configuration != null) {
                sMCC = configuration.mcc;
                sMNC = configuration.mnc;
            }
            return sMCC;
        } catch (NullPointerException e16) {
            TVKLogUtil.e(TAG, e16);
            return 0;
        }
    }

    public static int getMNC(Context context) {
        int i3 = sMNC;
        if (i3 != 0) {
            return i3;
        }
        if (context == null) {
            return 0;
        }
        try {
            Configuration configuration = context.getResources().getConfiguration();
            if (configuration != null) {
                sMCC = configuration.mcc;
                sMNC = configuration.mnc;
            }
            return sMNC;
        } catch (NullPointerException e16) {
            TVKLogUtil.e(TAG, e16);
            return 0;
        }
    }

    public static int getMobileNetOperator(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return 0;
            }
            String networkOperator = DeviceInfoMonitor.getNetworkOperator(telephonyManager);
            if (!TextUtils.isEmpty(networkOperator)) {
                if (!"46000".equals(networkOperator) && !"46002".equals(networkOperator) && !"46007".equals(networkOperator)) {
                    if ("46001".equals(networkOperator)) {
                        return 2;
                    }
                    if ("46003".equals(networkOperator)) {
                        return 1;
                    }
                }
                return 3;
            }
            return 0;
        } catch (NullPointerException e16) {
            TVKLogUtil.e(TAG, e16);
            return 0;
        }
    }

    private static int getNetworkConnectionState(Context context) {
        NetworkInfo networkInfo;
        if (context == null) {
            return -1;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (networkInfo = connectivityManager.getNetworkInfo(connectivityManager.getActiveNetwork())) != null && networkInfo.isAvailable()) {
                if (networkInfo.isConnected()) {
                    return 1;
                }
            }
            return 0;
        } catch (NullPointerException e16) {
            TVKLogUtil.e(TAG, e16);
            return -1;
        }
    }

    private static int getNetworkType(int i3) {
        if (i3 == 20) {
            return 5;
        }
        switch (i3) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 4;
            default:
                return 0;
        }
    }

    private static int getNetworkTypeDetail(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return 0;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                int type = NetworkMonitor.getType(activeNetworkInfo);
                if (type != 0) {
                    if (type != 1) {
                        return 0;
                    }
                    return 1;
                }
                if (is5GNetworkType(context)) {
                    return 5;
                }
                return getNetworkType(NetworkMonitor.getSubtype(activeNetworkInfo));
            }
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16);
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0055 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean is5GNetworkType(Context context) {
        int i3;
        TelephonyManager telephonyManager;
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (NullPointerException e16) {
            e = e16;
            i3 = 0;
        }
        if (telephonyManager == null) {
            TVKLogUtil.d(TAG, "Detect5G TelephonyManager is null");
            return false;
        }
        if (Build.VERSION.SDK_INT < 29) {
            TVKLogUtil.d(TAG, "Detect5G less api 29");
            return false;
        }
        if (context.checkSelfPermission(DeviceInfoUtil.PERMISSION_READ_PHONE) != 0) {
            TVKLogUtil.d(TAG, "Detect5G no permission");
            return false;
        }
        int i16 = NetworkMonitor.getNetworkType(telephonyManager);
        if (i16 != 13) {
            try {
                TVKLogUtil.d(TAG, "Detect5G not NETWORK_TYPE_LTE");
            } catch (NullPointerException e17) {
                i3 = i16;
                e = e17;
                TVKLogUtil.d(TAG, e.getMessage());
                i16 = i3;
                if (i16 == 20) {
                }
            }
        }
        if (i16 == 20) {
            return false;
        }
        return true;
    }

    private static boolean isCellularIpv4Only() throws Exception {
        try {
            ArrayList<NetworkInterface> list = Collections.list(NetworkMonitor.getNetworkInterfaces());
            if (!list.isEmpty()) {
                for (NetworkInterface networkInterface : list) {
                    if (networkInterface != null && (TextUtils.isEmpty(networkInterface.getName()) || !networkInterface.getName().contains("wlan"))) {
                        for (InetAddress inetAddress : Collections.list(NetworkMonitor.getInetAddresses(networkInterface))) {
                            if (inetAddress != null && !inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress() && (inetAddress instanceof Inet6Address)) {
                                return false;
                            }
                        }
                    }
                }
                return true;
            }
            throw new Exception("fail to getNetworkInterfaces");
        } catch (SocketException e16) {
            throw e16;
        }
    }

    private static boolean isCellularIpv6Only() throws Exception {
        try {
            ArrayList<NetworkInterface> list = Collections.list(NetworkMonitor.getNetworkInterfaces());
            if (!list.isEmpty()) {
                for (NetworkInterface networkInterface : list) {
                    if (networkInterface != null && (TextUtils.isEmpty(networkInterface.getName()) || !networkInterface.getName().contains("wlan"))) {
                        for (InetAddress inetAddress : Collections.list(NetworkMonitor.getInetAddresses(networkInterface))) {
                            if (inetAddress != null && !inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress() && (inetAddress instanceof Inet4Address)) {
                                return false;
                            }
                        }
                    }
                }
                return true;
            }
            throw new Exception("fail to getNetworkInterfaces");
        } catch (SocketException e16) {
            throw e16;
        }
    }

    public static boolean isCompressedByGzip(@NonNull Map<String, List<String>> map) {
        if (map.containsKey("Content-Encoding") && map.get("Content-Encoding").contains("gzip")) {
            return true;
        }
        if (map.containsKey(Headers.CONTENT_ENCODING) && map.get(Headers.CONTENT_ENCODING).contains("gzip")) {
            return true;
        }
        return false;
    }

    @TargetApi(23)
    public static boolean isCurrentNetworkOnline(@NonNull Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities != null) {
                if (networkCapabilities.hasCapability(16)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    private static boolean isIpv4Only() throws Exception {
        if (sNetWorkType == 1) {
            return isWifiIpv4Only();
        }
        return isCellularIpv4Only();
    }

    private static boolean isIpv6Only(Context context) throws Exception {
        if (sNetWorkType == 1) {
            return isWifiIpv6Only();
        }
        return isCellularIpv6Only();
    }

    public static boolean isLocalHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String host = new URL(str).getHost();
            if (!TextUtils.isEmpty(host)) {
                if (host.contains("127.0.0.1")) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean isNetworkAvailable() {
        if (sNetworkConnectionState == 1) {
            return true;
        }
        return false;
    }

    public static boolean isNetworkTypeMobile() {
        return sIsNetworkTypeMobile;
    }

    private static boolean isWifiIpv4Only() throws Exception {
        try {
            ArrayList<NetworkInterface> list = Collections.list(NetworkMonitor.getNetworkInterfaces());
            if (!list.isEmpty()) {
                for (NetworkInterface networkInterface : list) {
                    if (networkInterface != null && (TextUtils.isEmpty(networkInterface.getName()) || networkInterface.getName().contains("wlan0"))) {
                        for (InetAddress inetAddress : Collections.list(NetworkMonitor.getInetAddresses(networkInterface))) {
                            if (inetAddress != null && !inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress() && (inetAddress instanceof Inet6Address)) {
                                return false;
                            }
                        }
                    }
                }
                return true;
            }
            throw new Exception("fail to getNetworkInterfaces");
        } catch (SocketException e16) {
            throw e16;
        }
    }

    private static boolean isWifiIpv6Only() throws Exception {
        try {
            ArrayList<NetworkInterface> list = Collections.list(NetworkMonitor.getNetworkInterfaces());
            if (!list.isEmpty()) {
                for (NetworkInterface networkInterface : list) {
                    if (networkInterface != null && (TextUtils.isEmpty(networkInterface.getName()) || networkInterface.getName().contains("wlan0"))) {
                        for (InetAddress inetAddress : Collections.list(NetworkMonitor.getInetAddresses(networkInterface))) {
                            if (inetAddress != null && !inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress() && (inetAddress instanceof Inet4Address)) {
                                return false;
                            }
                        }
                    }
                }
                return true;
            }
            throw new Exception("fail to getNetworkInterfaces");
        } catch (SocketException e16) {
            throw e16;
        }
    }

    public static String replaceHostInUrl(String str, String str2) throws MalformedURLException {
        boolean z16;
        int i3;
        if (str != null && str2 != null) {
            try {
                URL url = new URL(str);
                boolean z17 = true;
                int i16 = -1;
                if (str2.indexOf(":") != -1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    URL url2 = new URL("http://" + str2);
                    str2 = url2.getHost();
                    i3 = url2.getPort();
                } else {
                    i3 = -1;
                }
                boolean equals = url.getProtocol().equals("https");
                if ((i3 != 443 || !equals) && (i3 != 80 || equals)) {
                    z17 = false;
                }
                i16 = i3;
                return new URL(url.getProtocol(), str2, i16, url.getFile()).toString();
            } catch (MalformedURLException e16) {
                TVKLogUtil.e(TAG, "Couldn't replace host in url, originalUrl=" + str + ", newHost=" + str2);
                throw e16;
            }
        }
        return str;
    }

    public static void updateNetworkInfo(Context context) {
        sNetworkConnectionState = getNetworkConnectionState(context);
        sIsNetworkTypeMobile = isNetworkTypeMobile(context);
        sNetWorkType = getNetworkTypeDetail(context);
        sIPStackType = getCurrentNetworkIpStackType(context);
    }

    public static int getNetworkType() {
        return sNetWorkType;
    }

    private static boolean isNetworkTypeMobile(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return true;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                int type = NetworkMonitor.getType(activeNetworkInfo);
                return type == 0 || type == 2 || type == 3 || type == 4 || type == 5;
            }
        } catch (NullPointerException e16) {
            TVKLogUtil.e(TAG, e16);
        }
        return true;
    }
}
