package com.google.zxing.client.android.wifi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    private static final Pattern f35978e = Pattern.compile("[0-9A-Fa-f]+");

    /* renamed from: a, reason: collision with root package name */
    private final WifiManager f35979a;

    /* renamed from: b, reason: collision with root package name */
    protected final String f35980b = "WEP";

    /* renamed from: c, reason: collision with root package name */
    protected final String f35981c = "WPA";

    /* renamed from: d, reason: collision with root package name */
    protected final String f35982d = "nopass";

    public a(WifiManager wifiManager) {
        this.f35979a = wifiManager;
    }

    static WifiConfiguration a(c cVar) {
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.allowedAuthAlgorithms.clear();
        wifiConfiguration.allowedGroupCiphers.clear();
        wifiConfiguration.allowedKeyManagement.clear();
        wifiConfiguration.allowedPairwiseCiphers.clear();
        wifiConfiguration.allowedProtocols.clear();
        wifiConfiguration.SSID = i(cVar.e(), new int[0]);
        wifiConfiguration.hiddenSSID = cVar.f();
        return wifiConfiguration;
    }

    static boolean b(WifiManager wifiManager, c cVar) {
        WifiConfiguration a16 = a(cVar);
        a16.allowedKeyManagement.set(0);
        return j(wifiManager, a16);
    }

    static boolean c(WifiManager wifiManager, c cVar) {
        WifiConfiguration a16 = a(cVar);
        a16.wepKeys[0] = i(cVar.d(), 10, 26, 58);
        a16.wepTxKeyIndex = 0;
        a16.allowedAuthAlgorithms.set(1);
        a16.allowedKeyManagement.set(0);
        a16.allowedGroupCiphers.set(2);
        a16.allowedGroupCiphers.set(3);
        a16.allowedGroupCiphers.set(0);
        a16.allowedGroupCiphers.set(1);
        return j(wifiManager, a16);
    }

    static boolean d(WifiManager wifiManager, c cVar) {
        WifiConfiguration a16 = a(cVar);
        a16.preSharedKey = i(cVar.d(), 64);
        a16.allowedAuthAlgorithms.set(0);
        a16.allowedProtocols.set(0);
        a16.allowedProtocols.set(1);
        a16.allowedKeyManagement.set(1);
        a16.allowedKeyManagement.set(2);
        a16.allowedPairwiseCiphers.set(1);
        a16.allowedPairwiseCiphers.set(2);
        a16.allowedGroupCiphers.set(2);
        a16.allowedGroupCiphers.set(3);
        return j(wifiManager, a16);
    }

    public static String e(Context context) {
        NetworkInfo[] allNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
            for (int i3 = 0; i3 < allNetworkInfo.length; i3++) {
                if (NetworkMonitor.getTypeName(allNetworkInfo[i3]).equals(Global.TRACKING_WIFI) && allNetworkInfo[i3].isAvailable() && allNetworkInfo[i3].isConnected()) {
                    return NetworkMonitor.getSSID(LocationMonitor.getConnectionInfo((WifiManager) context.getSystemService("wifi")));
                }
            }
            return null;
        }
        return null;
    }

    static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '\"' && str.charAt(str.length() - 1) == '\"') {
            return str;
        }
        return '\"' + str + '\"';
    }

    static Integer g(WifiManager wifiManager, String str) {
        List<WifiConfiguration> configureNetworks = NetworkMonitor.getConfigureNetworks(wifiManager);
        if (configureNetworks == null) {
            return null;
        }
        for (WifiConfiguration wifiConfiguration : configureNetworks) {
            if (wifiConfiguration.SSID.equals(str)) {
                return Integer.valueOf(wifiConfiguration.networkId);
            }
        }
        return null;
    }

    static boolean h(CharSequence charSequence, int... iArr) {
        if (charSequence != null && f35978e.matcher(charSequence).matches()) {
            if (iArr.length == 0) {
                return true;
            }
            for (int i3 : iArr) {
                if (charSequence.length() == i3) {
                    return true;
                }
            }
        }
        return false;
    }

    static String i(String str, int... iArr) {
        if (!h(str, iArr)) {
            return f(str);
        }
        return str;
    }

    static boolean j(WifiManager wifiManager, WifiConfiguration wifiConfiguration) {
        Integer g16 = g(wifiManager, wifiConfiguration.SSID);
        if (g16 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("BizWifiConfigManager", 2, "Removing old configuration for network " + wifiConfiguration.SSID);
            }
            wifiManager.removeNetwork(g16.intValue());
            if (!wifiManager.saveConfiguration()) {
                return false;
            }
        }
        int addNetwork = wifiManager.addNetwork(wifiConfiguration);
        if (addNetwork >= 0) {
            if (wifiManager.enableNetwork(addNetwork, true)) {
                if (QLog.isColorLevel()) {
                    QLog.d("BizWifiConfigManager", 2, "Associating to network " + wifiConfiguration.SSID);
                }
                if (wifiManager.saveConfiguration()) {
                    return true;
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("BizWifiConfigManager", 2, "Failed to enable network " + wifiConfiguration.SSID);
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("BizWifiConfigManager", 2, "Unable to add network " + wifiConfiguration.SSID);
        }
        return false;
    }

    public boolean k(c cVar) {
        if (!this.f35979a.isWifiEnabled()) {
            if (QLog.isColorLevel()) {
                QLog.d("BizWifiConfigManager", 2, "Enabling wi-fi...");
            }
            if (this.f35979a.setWifiEnabled(true)) {
                if (QLog.isColorLevel()) {
                    QLog.d("BizWifiConfigManager", 2, "Wi-fi enabled");
                }
                int i3 = 0;
                while (!this.f35979a.isWifiEnabled()) {
                    if (i3 >= 10) {
                        if (QLog.isColorLevel()) {
                            QLog.d("BizWifiConfigManager", 2, "Took too long to enable wi-fi, quitting");
                        }
                        return false;
                    }
                    try {
                        LockMethodProxy.sleep(1000L);
                    } catch (InterruptedException unused) {
                    }
                    i3++;
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("BizWifiConfigManager", 2, "Wi-fi could not be enabled!");
                }
                return false;
            }
        }
        String c16 = cVar.c();
        if (!TextUtils.isEmpty(c16) && !c16.equals("nopass")) {
            if (!TextUtils.isEmpty(cVar.d())) {
                if ("WEP".equals(c16)) {
                    return c(this.f35979a, cVar);
                }
                if ("WPA".equals(c16)) {
                    return d(this.f35979a, cVar);
                }
            }
            return false;
        }
        return b(this.f35979a, cVar);
    }
}
