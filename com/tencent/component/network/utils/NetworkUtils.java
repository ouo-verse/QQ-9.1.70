package com.tencent.component.network.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class NetworkUtils {
    public static final String APN_NAME_WIFI = "wifi";
    private static final Uri PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");
    private static final String TAG = "NetworkUtil";
    private static final HashMap<String, Proxy> sAPNProxies;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class DNS {
        public String primary;
        public String secondary;

        DNS() {
        }

        public String toString() {
            return this.primary + "," + this.secondary;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class NetworkProxy implements Cloneable {
        public final String host;
        public final int port;

        NetworkProxy(String str, int i3) {
            this.host = str;
            this.port = i3;
        }

        final NetworkProxy copy() {
            try {
                return (NetworkProxy) clone();
            } catch (CloneNotSupportedException e16) {
                e16.printStackTrace();
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && (obj instanceof NetworkProxy)) {
                NetworkProxy networkProxy = (NetworkProxy) obj;
                if (TextUtils.equals(this.host, networkProxy.host) && this.port == networkProxy.port) {
                    return true;
                }
                return false;
            }
            return false;
        }

        public String toString() {
            return this.host + ":" + this.port;
        }
    }

    static {
        HashMap<String, Proxy> hashMap = new HashMap<>();
        sAPNProxies = hashMap;
        hashMap.put("cmwap", new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80)));
        hashMap.put("3gwap", new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80)));
        hashMap.put("uniwap", new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80)));
        hashMap.put("ctwap", new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80)));
    }

    NetworkUtils() {
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getAPN(Context context) {
        String str;
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        String str2 = null;
        str2 = null;
        Cursor cursor = null;
        str2 = null;
        if (activeNetworkInfo == null) {
            return null;
        }
        if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
            str2 = "wifi";
        } else if (NetworkMonitor.getType(activeNetworkInfo) == 0) {
            if (PlatformUtil.version() < 17) {
                try {
                    Cursor query = ContactsMonitor.query(context.getContentResolver(), PREFERRED_APN_URI, null, null, null, null);
                    while (query != null) {
                        try {
                            if (!query.moveToNext()) {
                                break;
                            }
                            str2 = query.getString(query.getColumnIndex("apn"));
                        } catch (Throwable th5) {
                            th = th5;
                            String str3 = str2;
                            cursor = query;
                            str = str3;
                            try {
                                th.printStackTrace();
                                str2 = str;
                                if (TextUtils.isEmpty(str2)) {
                                }
                                if (str2 == null) {
                                }
                            } finally {
                                if (cursor != null) {
                                    cursor.close();
                                }
                            }
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (Throwable th6) {
                    th = th6;
                    str = null;
                }
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = NetworkMonitor.netGetExInfo(activeNetworkInfo);
            }
        }
        if (str2 == null) {
            return str2.toLowerCase();
        }
        return str2;
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th5) {
            QDLog.e("NetworkUtil", "fail to get active network info", th5);
            return null;
        }
    }

    public static DNS getDNS(Context context) {
        DhcpInfo dhcpInfo;
        DNS dns = new DNS();
        if (context != null && isWifiConnected(context) && (dhcpInfo = NetworkMonitor.getDhcpInfo((WifiManager) context.getSystemService("wifi"))) != null) {
            dns.primary = int32ToIPStr(dhcpInfo.dns1);
            dns.secondary = int32ToIPStr(dhcpInfo.dns2);
        }
        if (dns.primary == null && dns.secondary == null) {
            dns.primary = PropertyUtil.get(PropertyUtil.PROPERTY_DNS_PRIMARY, null);
            dns.secondary = PropertyUtil.get(PropertyUtil.PROPERTY_DNS_SECNDARY, null);
        }
        return dns;
    }

    public static Proxy getProxy(Context context, boolean z16) {
        return !z16 ? getProxy(context) : getProxyByAPN(context);
    }

    public static Proxy getProxyByAPN(Context context) {
        if (!isMobileConnected(context)) {
            return null;
        }
        Proxy proxy = sAPNProxies.get(getAPN(context));
        if (proxy == null) {
            return null;
        }
        return proxy;
    }

    private static String getProxyHost(Context context) {
        return System.getProperty("http.proxyHost");
    }

    private static int getProxyPort(Context context) {
        int parseInt;
        String property = System.getProperty("http.proxyPort");
        if (!isEmpty(property)) {
            try {
                parseInt = Integer.parseInt(property);
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
            }
            if (parseInt < 0 && parseInt <= 65535) {
                return parseInt;
            }
        }
        parseInt = -1;
        return parseInt < 0 ? -1 : -1;
    }

    private static String int32ToIPStr(int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i3 & 255);
        stringBuffer.append(".");
        stringBuffer.append((i3 >> 8) & 255);
        stringBuffer.append(".");
        stringBuffer.append((i3 >> 16) & 255);
        stringBuffer.append(".");
        stringBuffer.append((i3 >> 24) & 255);
        return stringBuffer.toString();
    }

    private static boolean isEmpty(String str) {
        if (str != null && str.length() != 0) {
            return false;
        }
        return true;
    }

    public static boolean isMobileConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = getActiveNetworkInfo(context)) == null) {
            return false;
        }
        if (NetworkMonitor.getType(activeNetworkInfo) != 0 && NetworkMonitor.getType(activeNetworkInfo) + 50 != 0) {
            return false;
        }
        return true;
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public static boolean isNetworkUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            if (URLUtil.isFileUrl(str)) {
                return false;
            }
            return URLUtil.isNetworkUrl(str);
        }
        return true;
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = getActiveNetworkInfo(context)) == null || NetworkMonitor.getType(activeNetworkInfo) != 1) {
            return false;
        }
        return true;
    }

    public static Proxy getProxy(Context context) {
        if (!isMobileConnected(context)) {
            return null;
        }
        String proxyHost = getProxyHost(context);
        int proxyPort = getProxyPort(context);
        if (isEmpty(proxyHost) || proxyPort < 0) {
            return null;
        }
        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
    }
}
