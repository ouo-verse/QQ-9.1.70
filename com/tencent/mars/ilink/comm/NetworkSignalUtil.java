package com.tencent.mars.ilink.comm;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.tencent.luggage.wxa.ia.a;
import com.tencent.mars.ilink.xlog.Log;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class NetworkSignalUtil {
    private static final String INVALID_WIFI_BSSID = "02:00:00:00:00:00";
    private static final String INVALID_WIFI_SSID = "<unknown ssid>";
    private static final String TAG = "MicroMsg.NetworkSignalUtil";
    private static Receiver connectivereceiver = null;
    private static Context context = null;
    private static MarsWifiInfo curwifiinfo = new MarsWifiInfo();
    private static boolean isinited = false;
    private static NetworkCallbackImpl24 netcallback = null;
    private static long strength = 10000;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class MarsWifiInfo {
        public String ssid = "<unknown ssid>";
        public String bssid = "02:00:00:00:00:00";
        private int rssi = 0;
        public int networkId = 0;
        public int ipaddr = 0;
        public int sig = 0;

        public void fill(int i3, String str, String str2, int i16, int i17) {
            this.rssi = i3;
            this.bssid = str;
            this.ssid = str2;
            this.networkId = i16;
            this.ipaddr = i17;
            int calculateSignalLevel = WifiManager.calculateSignalLevel(i3, 10);
            if (calculateSignalLevel > 10) {
                calculateSignalLevel = 10;
            }
            if (calculateSignalLevel < 0) {
                calculateSignalLevel = 0;
            }
            this.sig = calculateSignalLevel * 10;
        }

        public void reset() {
            this.ssid = "<unknown ssid>";
            this.bssid = "02:00:00:00:00:00";
            this.rssi = 0;
            this.networkId = 0;
            this.ipaddr = 0;
            this.sig = 0;
        }

        public void updateRssi(int i3) {
            this.rssi = i3;
            int calculateSignalLevel = WifiManager.calculateSignalLevel(i3, 10);
            if (calculateSignalLevel > 10) {
                calculateSignalLevel = 10;
            }
            if (calculateSignalLevel < 0) {
                calculateSignalLevel = 0;
            }
            this.sig = calculateSignalLevel * 10;
        }
    }

    /* compiled from: P */
    @SuppressLint({"NewApi"})
    /* loaded from: classes9.dex */
    public static class NetworkCallbackImpl24 extends ConnectivityManager.NetworkCallback {
        NetworkCallbackImpl24() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            Log.i("MicroMsg.NetworkSignalUtil", "network available (from network callback)");
            NetworkSignalUtil.access$300();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class Receiver extends BroadcastReceiver {
        Receiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            action.hashCode();
            char c16 = '\uffff';
            switch (action.hashCode()) {
                case -1172645946:
                    if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                        c16 = 0;
                        break;
                    }
                    break;
                case -385684331:
                    if (action.equals("android.net.wifi.RSSI_CHANGED")) {
                        c16 = 1;
                        break;
                    }
                    break;
                case 1878357501:
                    if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                        c16 = 2;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    Log.d("MicroMsg.NetworkSignalUtil", "ConnectivityManager.CONNECTIVITY_ACTION going to update wifiinfo");
                    NetworkSignalUtil.access$300();
                    return;
                case 1:
                    Log.d("MicroMsg.NetworkSignalUtil", "WifiManager.RSSI_CHANGED_ACTION");
                    NetworkSignalUtil.curwifiinfo.updateRssi(intent.getIntExtra("newRssi", 0));
                    return;
                case 2:
                    Log.d("MicroMsg.NetworkSignalUtil", "WifiManager.SCAN_RESULTS_AVAILABLE_ACTION");
                    return;
                default:
                    return;
            }
        }
    }

    public static void InitNetworkSignalUtil(Context context2) {
        if (isinited) {
            return;
        }
        context = context2;
        if (Build.VERSION.SDK_INT >= 24) {
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addTransportType(0);
            builder.addTransportType(1);
            netcallback = new NetworkCallbackImpl24();
            try {
                ((ConnectivityManager) context.getSystemService("connectivity")).registerNetworkCallback(builder.build(), netcallback);
            } catch (Exception e16) {
                Log.printErrStackTrace("MicroMsg.NetworkSignalUtil", e16, "registerNetworkCallback exception", new Object[0]);
            }
        }
        connectivereceiver = new Receiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        intentFilter.addAction("android.net.wifi.RSSI_CHANGED");
        if (Build.VERSION.SDK_INT < 24) {
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
        context.registerReceiver(connectivereceiver, intentFilter);
        a.a(new Object(), "com/tencent/mars/ilink/comm/NetworkSignalUtil", "InitNetworkSignalUtil", "(Landroid/content/Context;)V", "com/tencent/mars/ilink/comm/NetworkSignalUtil", "updateWiFiInfo", "()V");
        isinited = true;
    }

    public static /* synthetic */ void access$300() {
        a.a(new Object(), "com/tencent/mars/ilink/comm/NetworkSignalUtil", "access$300", "()V", "com/tencent/mars/ilink/comm/NetworkSignalUtil", "updateWiFiInfo", "()V");
    }

    public static String getBSSID() {
        return curwifiinfo.bssid;
    }

    public static long getGSMSignalStrength() {
        return strength;
    }

    public static long getNetworkSignalStrength(boolean z16) {
        return 0L;
    }

    public static String getSSID() {
        return curwifiinfo.ssid;
    }

    public static long getWifiSignalStrength() {
        return curwifiinfo.sig;
    }

    private static void updateWiFiInfo() {
        Log.d("MicroMsg.NetworkSignalUtil", "update wifiinfo!");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            curwifiinfo.reset();
            return;
        }
        if (NetworkMonitor.getType(activeNetworkInfo) != 1) {
            curwifiinfo.reset();
            return;
        }
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager == null) {
            curwifiinfo.reset();
            return;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29 && context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
            Log.e("MicroMsg.NetworkSignalUtil", "access_fine_location perm not granted.");
            return;
        }
        if (i3 >= 27) {
            try {
                if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    WifiInfo wifiInfo = (WifiInfo) a.a(wifiManager, "com/tencent/mars/ilink/comm/NetworkSignalUtil", "updateWiFiInfo", "()V", "android/net/wifi/WifiManager", "getConnectionInfo", "()Landroid/net/wifi/WifiInfo;");
                    curwifiinfo.fill(wifiInfo.getRssi(), NetworkMonitor.getBSSID(wifiInfo), NetworkMonitor.getSSID(wifiInfo), wifiInfo.getNetworkId(), NetworkMonitor.getIpAddress(wifiInfo));
                    return;
                }
            } catch (Throwable th5) {
                Log.printErrStackTrace("MicroMsg.NetworkSignalUtil", th5, "get wifi info failed directly", new Object[0]);
            }
            try {
                List list = (List) a.a(wifiManager, "com/tencent/mars/ilink/comm/NetworkSignalUtil", "updateWiFiInfo", "()V", "android/net/wifi/WifiManager", "getConfiguredNetworks", "()Ljava/util/List;");
                WifiInfo wifiInfo2 = (WifiInfo) a.a(wifiManager, "com/tencent/mars/ilink/comm/NetworkSignalUtil", "updateWiFiInfo", "()V", "android/net/wifi/WifiManager", "getConnectionInfo", "()Landroid/net/wifi/WifiInfo;");
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((WifiConfiguration) it.next()).networkId == wifiInfo2.getNetworkId()) {
                        curwifiinfo.fill(wifiInfo2.getRssi(), NetworkMonitor.getBSSID(wifiInfo2), NetworkMonitor.getSSID(wifiInfo2), wifiInfo2.getNetworkId(), NetworkMonitor.getIpAddress(wifiInfo2));
                        return;
                    }
                }
                return;
            } catch (Throwable th6) {
                Log.printErrStackTrace("MicroMsg.NetworkSignalUtil", th6, "get wifi info failed from configurations", new Object[0]);
                return;
            }
        }
        WifiInfo wifiInfo3 = (WifiInfo) a.a(wifiManager, "com/tencent/mars/ilink/comm/NetworkSignalUtil", "updateWiFiInfo", "()V", "android/net/wifi/WifiManager", "getConnectionInfo", "()Landroid/net/wifi/WifiInfo;");
        if (wifiInfo3 != null) {
            curwifiinfo.fill(wifiInfo3.getRssi(), NetworkMonitor.getBSSID(wifiInfo3), NetworkMonitor.getSSID(wifiInfo3), wifiInfo3.getNetworkId(), NetworkMonitor.getIpAddress(wifiInfo3));
        }
    }
}
