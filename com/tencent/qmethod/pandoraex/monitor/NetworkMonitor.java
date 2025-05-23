package com.tencent.qmethod.pandoraex.monitor;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.net.DhcpInfo;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qmethod.pandoraex.core.MonitorReporter;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import vr3.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class NetworkMonitor {
    private static final String SYSTEM_CALL_NETWORK = "call system api:Network.";
    public static final String TAG = "NetworkMonitor";
    private static String lastBssid = "";
    private static String lastHardwareAddress = "";
    private static String lastMacAddress = "";
    private static int lastNetworkType = 0;
    private static String lastNetworkTypeName = null;
    private static String lastSsid = "";
    private static Map<Integer, Integer> lastNetworkTypeMap = new HashMap();
    private static int lastDataNetworkType = 0;
    private static Map<Integer, Integer> lastDataNetworkTypeMap = new HashMap();
    private static Map<Integer, String> lastNetworkTypeNameMap = new HashMap();
    private static int lastType = 0;
    private static int lastSubtype = 0;
    private static String lastTypeName = "";
    private static Map<Integer, Boolean> lastHasTransportMap = new ConcurrentHashMap();
    private static String lastAddress = "";
    public static List<ScanResult> lastScanResults = new ArrayList();
    private static List<WifiConfiguration> LastConfiguredNetworks = new ArrayList();
    private static Object lockMacAddress = new Object();
    private static Object lockHardwareAddress = new Object();
    public static Object lockGetScanResults = new Object();
    private static ReentrantLock getExtraInfoLock = new ReentrantLock();
    private static Enumeration<NetworkInterface> lastNetworkInterfaces = new Enumeration<NetworkInterface>() { // from class: com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.1
        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return false;
        }

        @Override // java.util.Enumeration
        public NetworkInterface nextElement() {
            return null;
        }
    };

    public static void clearNetworkMemoryCache() {
        lastSsid = "";
        lastBssid = "";
        lastMacAddress = "";
        lastHardwareAddress = "";
        lastTypeName = "";
        lastAddress = "";
    }

    @SuppressLint({"MissingPermission"})
    public static String getAddress(BluetoothAdapter bluetoothAdapter) {
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("network", "BA#G_ADDR", new a.C11438a().b("ban").b("cache_only").b("memory").d(), null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            try {
                lastAddress = bluetoothAdapter.getAddress();
                com.tencent.qmethod.pandoraex.api.r.p(com.tencent.qmethod.pandoraex.api.q.b(), "BA#G_ADDR", lastAddress);
                com.tencent.qmethod.pandoraex.core.e.d("BA#G_ADDR", strategyAndReport.f343902c);
            } catch (Exception e16) {
                com.tencent.qmethod.pandoraex.core.o.d(TAG, "BluetoothAdapter getAddress exception is ", e16);
            }
            return lastAddress;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            if (!"memory".equals(strategyAndReport.f343900a) && TextUtils.isEmpty(lastAddress)) {
                String j3 = com.tencent.qmethod.pandoraex.api.r.j(com.tencent.qmethod.pandoraex.api.q.b(), "BA#G_ADDR");
                lastAddress = j3;
                return j3;
            }
            return lastAddress;
        }
        return GlobalUtil.DEFAULT_MAC_ADDRESS;
    }

    public static String getBSSID(WifiInfo wifiInfo) {
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("network", "WI#G_BSSID", new a.C11438a().b("ban").b("cache_only").b("memory").b(QQPermissionConstants.Permission.STORAGE_GROUP).d(), null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            lastBssid = wifiInfo.getBSSID();
            if (QQPermissionConstants.Permission.STORAGE_GROUP.equals(strategyAndReport.f343900a)) {
                com.tencent.qmethod.pandoraex.core.o.c(TAG, "WI#G_BSSID is Really Call System API");
                com.tencent.qmethod.pandoraex.api.r.p(com.tencent.qmethod.pandoraex.api.q.b(), "WI#G_BSSID", lastBssid);
                com.tencent.qmethod.pandoraex.core.e.d("WI#G_BSSID", strategyAndReport.f343902c);
            }
            if (!"normal".equals(strategyAndReport.f343900a) && com.tencent.qmethod.pandoraex.core.d.b("WI#G_BSSID")) {
                com.tencent.qmethod.pandoraex.api.r.m(com.tencent.qmethod.pandoraex.api.q.b(), "WI#G_BSSID_network_state", Boolean.FALSE);
            }
            return lastBssid;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            if ("cache_only".equals(strategyAndReport.f343900a) && !TextUtils.isEmpty(lastBssid)) {
                return lastBssid;
            }
            String j3 = com.tencent.qmethod.pandoraex.api.r.j(com.tencent.qmethod.pandoraex.api.q.b(), "WI#G_BSSID");
            lastBssid = j3;
            return j3;
        }
        return "";
    }

    @SuppressLint({"MissingPermission"})
    public static List<WifiConfiguration> getConfigureNetworks(WifiManager wifiManager) {
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("network", "WM#G_CON_NET", new a.C11438a().b("ban").b("cache_only").b("memory").d(), null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            List<WifiConfiguration> configuredNetworks = wifiManager.getConfiguredNetworks();
            LastConfiguredNetworks = configuredNetworks;
            return configuredNetworks;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            return LastConfiguredNetworks;
        }
        return new ArrayList();
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public static int getDataNetworkType(TelephonyManager telephonyManager) {
        int dataNetworkType;
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("network", "TM#G_DA_NET_TYPE", new a.C11438a().b("ban").b("cache_only").b("memory").d(), null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            dataNetworkType = telephonyManager.getDataNetworkType();
            lastDataNetworkType = dataNetworkType;
            return dataNetworkType;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            return lastDataNetworkType;
        }
        return 0;
    }

    public static DhcpInfo getDhcpInfo(final WifiManager wifiManager) throws Throwable {
        return (DhcpInfo) a.C11438a.n(new com.tencent.qmethod.pandoraex.core.k<DhcpInfo>() { // from class: com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.qmethod.pandoraex.core.k
            public DhcpInfo call() {
                return wifiManager.getDhcpInfo();
            }
        }).f("network").c("WM#G_D_INFO").j(null).e();
    }

    public static byte[] getHardwareAddress(NetworkInterface networkInterface) throws SocketException {
        synchronized (lockHardwareAddress) {
            com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("network", "NI#G_HW_ADDR", null, null);
            if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
                try {
                    lastHardwareAddress = getMacByAPI(networkInterface);
                    com.tencent.qmethod.pandoraex.core.o.c(TAG, "NI#G_HW_ADDR is Really Call System API");
                } catch (Exception e16) {
                    lastHardwareAddress = GlobalUtil.DEFAULT_MAC_ADDRESS;
                    com.tencent.qmethod.pandoraex.core.o.d(TAG, "WifiManager get mac_address exception is ", e16);
                }
                com.tencent.qmethod.pandoraex.api.r.p(com.tencent.qmethod.pandoraex.api.q.b(), "NI#G_HW_ADDR", lastHardwareAddress);
                com.tencent.qmethod.pandoraex.core.e.d("NI#G_HW_ADDR", strategyAndReport.f343902c);
                MonitorReporter.handleEventReport("NI#G_HW_ADDR", lastHardwareAddress);
                return com.tencent.qmethod.pandoraex.core.x.h(lastHardwareAddress);
            }
            if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
                if (!"memory".equals(strategyAndReport.f343900a) && TextUtils.isEmpty(lastHardwareAddress)) {
                    String j3 = com.tencent.qmethod.pandoraex.api.r.j(com.tencent.qmethod.pandoraex.api.q.b(), "NI#G_HW_ADDR");
                    lastHardwareAddress = j3;
                    return com.tencent.qmethod.pandoraex.core.x.h(j3);
                }
                return com.tencent.qmethod.pandoraex.core.x.h(lastHardwareAddress);
            }
            if (com.tencent.qmethod.pandoraex.api.e.f() != null) {
                return com.tencent.qmethod.pandoraex.api.e.f();
            }
            return com.tencent.qmethod.pandoraex.core.x.h(GlobalUtil.DEFAULT_MAC_ADDRESS);
        }
    }

    public static String getHostAddress(final InetAddress inetAddress) throws Throwable {
        return (String) a.C11438a.n(new com.tencent.qmethod.pandoraex.core.k<String>() { // from class: com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.8
            @Override // com.tencent.qmethod.pandoraex.core.k
            public String call() {
                return inetAddress.getHostAddress();
            }
        }).f("network").c("IA#GET_H_A").j(null).m(String.class).e();
    }

    public static Enumeration<InetAddress> getInetAddresses(final NetworkInterface networkInterface) throws Throwable {
        return (Enumeration) a.C11438a.o(new com.tencent.qmethod.pandoraex.core.k<Enumeration<InetAddress>>() { // from class: com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.7
            @Override // com.tencent.qmethod.pandoraex.core.k
            public Enumeration<InetAddress> call() {
                return networkInterface.getInetAddresses();
            }
        }).f("network").c("NI#G_INET_ADDR").j(new Enumeration<InetAddress>() { // from class: com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.6
            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return false;
            }

            @Override // java.util.Enumeration
            public InetAddress nextElement() {
                return null;
            }
        }).e();
    }

    public static List<InterfaceAddress> getInterfaceAddresses(final NetworkInterface networkInterface) throws Throwable {
        return (List) a.C11438a.o(new com.tencent.qmethod.pandoraex.core.k<List<InterfaceAddress>>() { // from class: com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.5
            @Override // com.tencent.qmethod.pandoraex.core.k
            public List<InterfaceAddress> call() {
                return networkInterface.getInterfaceAddresses();
            }
        }).f("network").c("NI#G_IF_ADDR").j(new ArrayList()).e();
    }

    public static int getIpAddress(final WifiInfo wifiInfo) throws Throwable {
        return ((Integer) a.C11438a.p(new com.tencent.qmethod.pandoraex.core.k<Integer>() { // from class: com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.qmethod.pandoraex.core.k
            public Integer call() {
                return Integer.valueOf(wifiInfo.getIpAddress());
            }
        }).f("network").c("WI#G_IP_ADDR").j(0).e()).intValue();
    }

    @SuppressLint({"HardwareIds"})
    public static String getMacAddress(WifiInfo wifiInfo) {
        synchronized (lockMacAddress) {
            com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("network", "WI#G_MA_ADDR", null, null);
            if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
                try {
                    lastMacAddress = wifiInfo.getMacAddress();
                    com.tencent.qmethod.pandoraex.core.o.c(TAG, "WI#G_MA_ADDR is Really Call System API");
                } catch (Exception e16) {
                    lastMacAddress = GlobalUtil.DEFAULT_MAC_ADDRESS;
                    com.tencent.qmethod.pandoraex.core.o.d(TAG, "WifiManager get mac_address exception is ", e16);
                }
                com.tencent.qmethod.pandoraex.api.r.p(com.tencent.qmethod.pandoraex.api.q.b(), "WI#G_MA_ADDR", lastMacAddress);
                com.tencent.qmethod.pandoraex.core.e.d("WI#G_MA_ADDR", strategyAndReport.f343902c);
                MonitorReporter.handleEventReport("WI#G_MA_ADDR", lastMacAddress);
                return lastMacAddress;
            }
            if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
                if (!"memory".equals(strategyAndReport.f343900a) && TextUtils.isEmpty(lastMacAddress)) {
                    String j3 = com.tencent.qmethod.pandoraex.api.r.j(com.tencent.qmethod.pandoraex.api.q.b(), "WI#G_MA_ADDR");
                    lastMacAddress = j3;
                    return j3;
                }
                return lastMacAddress;
            }
            if (com.tencent.qmethod.pandoraex.api.e.k() != null) {
                return com.tencent.qmethod.pandoraex.api.e.k();
            }
            return GlobalUtil.DEFAULT_MAC_ADDRESS;
        }
    }

    private static String getMacByAPI(NetworkInterface networkInterface) {
        try {
            byte[] hardwareAddress = networkInterface.getHardwareAddress();
            if (hardwareAddress == null) {
                return "";
            }
            StringBuilder sb5 = new StringBuilder();
            for (byte b16 : hardwareAddress) {
                sb5.append(String.format("%02x:", Byte.valueOf(b16)));
            }
            if (sb5.length() > 0) {
                sb5.deleteCharAt(sb5.length() - 1);
            }
            return sb5.toString();
        } catch (Throwable th5) {
            com.tencent.qmethod.pandoraex.core.o.d(TAG, "getMacByAPI exception: ", th5);
            return "";
        }
    }

    public static Enumeration<NetworkInterface> getNetworkInterfaces() throws SocketException {
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("network", "NI#G_NET_INT", new a.C11438a().b("ban").b("cache_only").b("memory").d(), null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            lastNetworkInterfaces = networkInterfaces;
            return networkInterfaces;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            return lastNetworkInterfaces;
        }
        return new Enumeration<NetworkInterface>() { // from class: com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.2
            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return false;
            }

            @Override // java.util.Enumeration
            public NetworkInterface nextElement() {
                return null;
            }
        };
    }

    @SuppressLint({"MissingPermission"})
    public static int getNetworkType(TelephonyManager telephonyManager) {
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("network", "TM#G_NET_TYPE", new a.C11438a().b("ban").b("cache_only").b("memory").d(), null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            int networkType = telephonyManager.getNetworkType();
            lastNetworkType = networkType;
            return networkType;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            return lastNetworkType;
        }
        return 0;
    }

    @SuppressLint({"MissingPermission"})
    public static String getNetworkTypeName(TelephonyManager telephonyManager) {
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("network", "TM#G_NET_TYPE", new a.C11438a().b("ban").b("cache_only").b("memory").d(), null);
        if (!com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            return com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport) ? lastNetworkTypeName : "UNKNOWN";
        }
        try {
            lastNetworkTypeName = (String) telephonyManager.getClass().getMethod("getNetworkTypeName", new Class[0]).invoke(telephonyManager, new Object[0]);
        } catch (IllegalAccessException e16) {
            com.tencent.qmethod.pandoraex.core.o.d(TAG, "getNetworkTypeName IllegalAccessException", e16);
        } catch (NoSuchMethodException e17) {
            com.tencent.qmethod.pandoraex.core.o.d(TAG, "getNetworkTypeName NoSuchMethodException", e17);
        } catch (InvocationTargetException e18) {
            com.tencent.qmethod.pandoraex.core.o.d(TAG, "getNetworkTypeName InvocationTargetException", e18);
        }
        return lastNetworkTypeName;
    }

    public static String getSSID(WifiInfo wifiInfo) {
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("network", "WI#G_SSID", new a.C11438a().b("ban").b("cache_only").b("memory").b(QQPermissionConstants.Permission.STORAGE_GROUP).d(), null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            try {
                lastSsid = wifiInfo.getSSID();
            } catch (Throwable unused) {
                lastSsid = "";
            }
            if (QQPermissionConstants.Permission.STORAGE_GROUP.equals(strategyAndReport.f343900a)) {
                com.tencent.qmethod.pandoraex.core.o.c(TAG, "WI#G_SSID is Really Call System API");
                com.tencent.qmethod.pandoraex.api.r.p(com.tencent.qmethod.pandoraex.api.q.b(), "WI#G_SSID", lastSsid);
                com.tencent.qmethod.pandoraex.core.e.d("WI#G_SSID", strategyAndReport.f343902c);
            }
            if (!"normal".equals(strategyAndReport.f343900a) && com.tencent.qmethod.pandoraex.core.d.b("WI#G_SSID")) {
                com.tencent.qmethod.pandoraex.api.r.m(com.tencent.qmethod.pandoraex.api.q.b(), "WI#G_SSID_network_state", Boolean.FALSE);
            }
            return lastSsid;
        }
        if (!com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            return "";
        }
        if ("cache_only".equals(strategyAndReport.f343900a) && !TextUtils.isEmpty(lastSsid)) {
            return lastSsid;
        }
        String j3 = com.tencent.qmethod.pandoraex.api.r.j(com.tencent.qmethod.pandoraex.api.q.b(), "WI#G_SSID");
        lastSsid = j3;
        return j3;
    }

    @SuppressLint({"MissingPermission"})
    public static List<ScanResult> getScanResults(WifiManager wifiManager) {
        List<ScanResult> list;
        synchronized (lockGetScanResults) {
            com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("network", "WM#G_SC_RES", new a.C11438a().b("ban").b("cache_only").b("memory").b(QQPermissionConstants.Permission.STORAGE_GROUP).a("android.permission.ACCESS_COARSE_LOCATION").a("android.permission.ACCESS_FINE_LOCATION").d(), null);
            if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
                lastScanResults = wifiManager.getScanResults();
                if (QQPermissionConstants.Permission.STORAGE_GROUP.equals(strategyAndReport.f343900a)) {
                    com.tencent.qmethod.pandoraex.core.o.c(TAG, "WM#G_SC_RES is Really Call System API");
                    List<ScanResult> list2 = lastScanResults;
                    if (list2 != null && list2.size() > 0) {
                        com.tencent.qmethod.pandoraex.api.r.q(com.tencent.qmethod.pandoraex.api.q.b(), "WM#G_SC_RES", lastScanResults);
                    }
                    com.tencent.qmethod.pandoraex.core.e.d("WM#G_SC_RES", strategyAndReport.f343902c);
                }
                return lastScanResults;
            }
            if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
                if (!"memory".equals(strategyAndReport.f343900a) && ((list = lastScanResults) == null || list.size() == 0)) {
                    List<ScanResult> f16 = com.tencent.qmethod.pandoraex.api.r.f(com.tencent.qmethod.pandoraex.api.q.b(), "WM#G_SC_RES", ScanResult.class);
                    if (f16 != null) {
                        lastScanResults = f16;
                    }
                    return lastScanResults;
                }
                return lastScanResults;
            }
            return new ArrayList();
        }
    }

    public static int getSubtype(NetworkInfo networkInfo) {
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("network", "NI#G_SUB_TYPE", new a.C11438a().b("ban").b("cache_only").b("memory").d(), null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            int subtype = networkInfo.getSubtype();
            lastSubtype = subtype;
            return subtype;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            return lastSubtype;
        }
        return -1;
    }

    public static int getType(NetworkInfo networkInfo) {
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("network", "NI#G_TYPE", new a.C11438a().b("ban").b("cache_only").b("memory").d(), null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            int type = networkInfo.getType();
            lastType = type;
            return type;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            return lastType;
        }
        return -1;
    }

    public static String getTypeName(NetworkInfo networkInfo) {
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("network", "NI#G_TY_NAME", new a.C11438a().b("ban").b("cache_only").b("memory").d(), null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            String typeName = networkInfo.getTypeName();
            lastTypeName = typeName;
            return typeName;
        }
        if (!com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            return null;
        }
        return lastTypeName;
    }

    @RequiresApi(api = 21)
    public static boolean hasTransport(NetworkCapabilities networkCapabilities, int i3) {
        Boolean bool;
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("network", "NC#HAS_TRANS", new a.C11438a().b("ban").b("cache_only").b("memory").d(), null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            lastHasTransportMap.put(Integer.valueOf(i3), Boolean.valueOf(networkCapabilities.hasTransport(i3)));
            if (lastHasTransportMap.get(Integer.valueOf(i3)) == null) {
                return true;
            }
            return lastHasTransportMap.get(Integer.valueOf(i3)).booleanValue();
        }
        if (!com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport) || !lastHasTransportMap.containsKey(Integer.valueOf(i3)) || (bool = lastHasTransportMap.get(Integer.valueOf(i3))) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public static String netGetExInfo(final NetworkInfo networkInfo) throws Throwable {
        return (String) a.C11438a.p(new com.tencent.qmethod.pandoraex.core.k<String>() { // from class: com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.9
            @Override // com.tencent.qmethod.pandoraex.core.k
            public String call() {
                return networkInfo.getExtraInfo();
            }
        }).f("network").c("NI#GET_EXT_INFO").m(String.class).h(getExtraInfoLock).g(100L).j("").e();
    }

    public static boolean startScan(WifiManager wifiManager) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("network", "WM#STRT_SC", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            return wifiManager.startScan();
        }
        return false;
    }

    public static String wifiToStr(final WifiInfo wifiInfo) throws Throwable {
        return (String) a.C11438a.p(new com.tencent.qmethod.pandoraex.core.k<String>() { // from class: com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.10
            @Override // com.tencent.qmethod.pandoraex.core.k
            public String call() {
                try {
                    return wifiInfo.toString();
                } catch (Throwable unused) {
                    return "";
                }
            }
        }).f("network").c("WI#TO_STR").j("").e();
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public static int getDataNetworkType(TelephonyManager telephonyManager, int i3) {
        Integer num;
        int dataNetworkType;
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("network", "TM#G_DA_NET_TYPE#I", new a.C11438a().b("ban").b("cache_only").b("memory").d(), null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            Map<Integer, Integer> map = lastDataNetworkTypeMap;
            Integer valueOf = Integer.valueOf(i3);
            dataNetworkType = telephonyManager.getDataNetworkType();
            map.put(valueOf, Integer.valueOf(dataNetworkType));
            return lastDataNetworkTypeMap.get(Integer.valueOf(i3)).intValue();
        }
        if (!com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport) || (num = lastDataNetworkTypeMap.get(Integer.valueOf(i3))) == null) {
            return 0;
        }
        return num.intValue();
    }

    @SuppressLint({"MissingPermission"})
    public static int getNetworkType(TelephonyManager telephonyManager, int i3) {
        Integer num;
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("network", "TM#G_NET_TYPE#I", new a.C11438a().b("ban").b("cache_only").b("memory").d(), null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            lastNetworkTypeMap.put(Integer.valueOf(i3), Integer.valueOf(telephonyManager.getNetworkType()));
            return lastNetworkTypeMap.get(Integer.valueOf(i3)).intValue();
        }
        if (!com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport) || (num = lastNetworkTypeMap.get(Integer.valueOf(i3))) == null) {
            return 0;
        }
        return num.intValue();
    }

    @SuppressLint({"MissingPermission"})
    public static String getNetworkTypeName(TelephonyManager telephonyManager, int i3) {
        String str;
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("network", "TM#G_NET_TYPE", new a.C11438a().b("ban").b("cache_only").b("memory").d(), null);
        if (!com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            return (!com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport) || (str = lastNetworkTypeNameMap.get(Integer.valueOf(i3))) == null) ? "unknown" : str;
        }
        try {
            lastNetworkTypeNameMap.put(Integer.valueOf(i3), (String) telephonyManager.getClass().getMethod("getNetworkTypeName", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(i3)));
        } catch (IllegalAccessException e16) {
            com.tencent.qmethod.pandoraex.core.o.d(TAG, "getNetworkTypeName IllegalAccessException", e16);
        } catch (NoSuchMethodException e17) {
            com.tencent.qmethod.pandoraex.core.o.d(TAG, "getNetworkTypeName NoSuchMethodException", e17);
        } catch (InvocationTargetException e18) {
            com.tencent.qmethod.pandoraex.core.o.d(TAG, "getNetworkTypeName InvocationTargetException", e18);
        }
        return lastNetworkTypeNameMap.get(Integer.valueOf(i3));
    }
}
