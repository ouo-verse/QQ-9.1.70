package org.tencwebrtc;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.wifi.WifiInfo;
import android.net.wifi.p2p.WifiP2pGroup;
import android.support.annotation.Nullable;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes29.dex */
public class NetworkMonitorAutoDetect extends BroadcastReceiver {
    static final long INVALID_NET_ID = -1;
    private static final String TAG = "NetworkMonitorAutoDetect";

    @Nullable
    private final ConnectivityManager.NetworkCallback allNetworkCallback;
    private ConnectionType connectionType;
    private ConnectivityManagerDelegate connectivityManagerDelegate;
    private final Context context;
    private final IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    private boolean isRegistered;

    @Nullable
    private final ConnectivityManager.NetworkCallback mobileNetworkCallback;
    private final Observer observer;
    private WifiDirectManagerDelegate wifiDirectManagerDelegate;
    private WifiManagerDelegate wifiManagerDelegate;
    private String wifiSSID;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum ConnectionType {
        CONNECTION_UNKNOWN,
        CONNECTION_ETHERNET,
        CONNECTION_WIFI,
        CONNECTION_4G,
        CONNECTION_3G,
        CONNECTION_2G,
        CONNECTION_UNKNOWN_CELLULAR,
        CONNECTION_BLUETOOTH,
        CONNECTION_VPN,
        CONNECTION_NONE
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class IPAddress {
        public final byte[] address;

        public IPAddress(byte[] bArr) {
            this.address = bArr;
        }

        @CalledByNative("IPAddress")
        private byte[] getAddress() {
            return this.address;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class NetworkInformation {
        public final long handle;
        public final IPAddress[] ipAddresses;
        public final String name;
        public final ConnectionType type;
        public final ConnectionType underlyingTypeForVpn;

        public NetworkInformation(String str, ConnectionType connectionType, ConnectionType connectionType2, long j3, IPAddress[] iPAddressArr) {
            this.name = str;
            this.type = connectionType;
            this.underlyingTypeForVpn = connectionType2;
            this.handle = j3;
            this.ipAddresses = iPAddressArr;
        }

        @CalledByNative("NetworkInformation")
        private ConnectionType getConnectionType() {
            return this.type;
        }

        @CalledByNative("NetworkInformation")
        private long getHandle() {
            return this.handle;
        }

        @CalledByNative("NetworkInformation")
        private IPAddress[] getIpAddresses() {
            return this.ipAddresses;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @CalledByNative("NetworkInformation")
        public String getName() {
            return this.name;
        }

        @CalledByNative("NetworkInformation")
        private ConnectionType getUnderlyingConnectionTypeForVpn() {
            return this.underlyingTypeForVpn;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class NetworkState {
        private final boolean connected;
        private final int subtype;
        private final int type;
        private final int underlyingNetworkSubtypeForVpn;
        private final int underlyingNetworkTypeForVpn;

        public NetworkState(boolean z16, int i3, int i16, int i17, int i18) {
            this.connected = z16;
            this.type = i3;
            this.subtype = i16;
            this.underlyingNetworkTypeForVpn = i17;
            this.underlyingNetworkSubtypeForVpn = i18;
        }

        public int getNetworkSubType() {
            return this.subtype;
        }

        public int getNetworkType() {
            return this.type;
        }

        public int getUnderlyingNetworkSubtypeForVpn() {
            return this.underlyingNetworkSubtypeForVpn;
        }

        public int getUnderlyingNetworkTypeForVpn() {
            return this.underlyingNetworkTypeForVpn;
        }

        public boolean isConnected() {
            return this.connected;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface Observer {
        void onConnectionTypeChanged(ConnectionType connectionType);

        void onNetworkConnect(NetworkInformation networkInformation);

        void onNetworkDisconnect(long j3);
    }

    /* compiled from: P */
    @SuppressLint({"NewApi"})
    /* loaded from: classes29.dex */
    private class SimpleNetworkCallback extends ConnectivityManager.NetworkCallback {
        SimpleNetworkCallback() {
        }

        private void onNetworkChanged(Network network) {
            NetworkInformation networkToInfo = NetworkMonitorAutoDetect.this.connectivityManagerDelegate.networkToInfo(network);
            if (networkToInfo != null) {
                Logging.d(NetworkMonitorAutoDetect.TAG, "onNetworkChanged, IpAddress=" + Arrays.toString(networkToInfo.ipAddresses) + ", name=" + networkToInfo.getName() + ", type=" + networkToInfo.type + ", handle=" + networkToInfo.handle);
                NetworkMonitorAutoDetect.this.observer.onNetworkConnect(networkToInfo);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            Logging.d(NetworkMonitorAutoDetect.TAG, "Network becomes available: " + network.toString());
            onNetworkChanged(network);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            Logging.d(NetworkMonitorAutoDetect.TAG, "capabilities changed: " + networkCapabilities.toString());
            onNetworkChanged(network);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            Logging.d(NetworkMonitorAutoDetect.TAG, "link properties changed: " + linkProperties.toString());
            onNetworkChanged(network);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int i3) {
            Logging.d(NetworkMonitorAutoDetect.TAG, "Network " + network.toString() + " is about to lose in " + i3 + "ms");
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            Logging.d(NetworkMonitorAutoDetect.TAG, "Network " + network.toString() + " is disconnected");
            NetworkMonitorAutoDetect.this.observer.onNetworkDisconnect(NetworkMonitorAutoDetect.networkToNetId(network));
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static class WifiDirectManagerDelegate extends BroadcastReceiver {
        private static final int WIFI_P2P_NETWORK_HANDLE = 0;
        private final Context context;
        private final Observer observer;

        @Nullable
        private NetworkInformation wifiP2pNetworkInfo;

        WifiDirectManagerDelegate(Observer observer, Context context) {
            this.context = context;
            this.observer = observer;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.p2p.STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.p2p.CONNECTION_STATE_CHANGE");
            context.registerReceiver(this, intentFilter);
        }

        private void onWifiP2pGroupChange(@Nullable WifiP2pGroup wifiP2pGroup) {
            if (wifiP2pGroup != null && wifiP2pGroup.getInterface() != null) {
                try {
                    ArrayList list = Collections.list(com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.getInetAddresses(NetworkInterface.getByName(wifiP2pGroup.getInterface())));
                    IPAddress[] iPAddressArr = new IPAddress[list.size()];
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        iPAddressArr[i3] = new IPAddress(((InetAddress) list.get(i3)).getAddress());
                    }
                    NetworkInformation networkInformation = new NetworkInformation(wifiP2pGroup.getInterface(), ConnectionType.CONNECTION_WIFI, ConnectionType.CONNECTION_NONE, 0L, iPAddressArr);
                    this.wifiP2pNetworkInfo = networkInformation;
                    this.observer.onNetworkConnect(networkInformation);
                } catch (SocketException e16) {
                    Logging.e(NetworkMonitorAutoDetect.TAG, "Unable to get WifiP2p network interface", e16);
                }
            }
        }

        private void onWifiP2pStateChange(int i3) {
            if (i3 == 1) {
                this.wifiP2pNetworkInfo = null;
                this.observer.onNetworkDisconnect(0L);
            }
        }

        public List<NetworkInformation> getActiveNetworkList() {
            NetworkInformation networkInformation = this.wifiP2pNetworkInfo;
            if (networkInformation != null) {
                return Collections.singletonList(networkInformation);
            }
            return Collections.emptyList();
        }

        @Override // android.content.BroadcastReceiver
        @SuppressLint({"InlinedApi"})
        public void onReceive(Context context, Intent intent) {
            if ("android.net.wifi.p2p.CONNECTION_STATE_CHANGE".equals(intent.getAction())) {
                onWifiP2pGroupChange((WifiP2pGroup) intent.getParcelableExtra("p2pGroupInfo"));
            } else if ("android.net.wifi.p2p.STATE_CHANGED".equals(intent.getAction())) {
                onWifiP2pStateChange(intent.getIntExtra("wifi_p2p_state", 0));
            }
        }

        public void release() {
            this.context.unregisterReceiver(this);
        }
    }

    @SuppressLint({"NewApi"})
    public NetworkMonitorAutoDetect(Observer observer, Context context) {
        this.observer = observer;
        this.context = context;
        this.connectivityManagerDelegate = new ConnectivityManagerDelegate(context);
        this.wifiManagerDelegate = new WifiManagerDelegate(context);
        this.connectionType = getConnectionType(this.connectivityManagerDelegate.getNetworkState());
        if (PeerConnectionFactory.fieldTrialsFindFullName("IncludeWifiDirect").equals(PeerConnectionFactory.TRIAL_ENABLED)) {
            this.wifiDirectManagerDelegate = new WifiDirectManagerDelegate(observer, context);
        }
        registerReceiver();
        if (this.connectivityManagerDelegate.supportNetworkCallback()) {
            ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback();
            try {
                this.connectivityManagerDelegate.requestMobileNetwork(networkCallback);
            } catch (Exception e16) {
                Logging.w(TAG, "Failed to requestMobileNetwork: " + e16);
                networkCallback = null;
            }
            this.mobileNetworkCallback = networkCallback;
            SimpleNetworkCallback simpleNetworkCallback = new SimpleNetworkCallback();
            this.allNetworkCallback = simpleNetworkCallback;
            this.connectivityManagerDelegate.registerNetworkCallback(simpleNetworkCallback);
            return;
        }
        this.mobileNetworkCallback = null;
        this.allNetworkCallback = null;
    }

    private void connectionTypeChanged(NetworkState networkState) {
        ConnectionType connectionType = getConnectionType(networkState);
        if (connectionType == this.connectionType) {
            return;
        }
        this.connectionType = connectionType;
        Logging.d(TAG, "Network connectivity changed, type is: " + this.connectionType);
        this.observer.onConnectionTypeChanged(connectionType);
    }

    private static ConnectionType getConnectionType(boolean z16, int i3, int i16) {
        if (!z16) {
            return ConnectionType.CONNECTION_NONE;
        }
        if (i3 == 0) {
            switch (i16) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return ConnectionType.CONNECTION_2G;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return ConnectionType.CONNECTION_3G;
                case 13:
                    return ConnectionType.CONNECTION_4G;
                default:
                    return ConnectionType.CONNECTION_UNKNOWN_CELLULAR;
            }
        }
        if (i3 == 1) {
            return ConnectionType.CONNECTION_WIFI;
        }
        if (i3 == 6) {
            return ConnectionType.CONNECTION_4G;
        }
        if (i3 == 7) {
            return ConnectionType.CONNECTION_BLUETOOTH;
        }
        if (i3 == 9) {
            return ConnectionType.CONNECTION_ETHERNET;
        }
        if (i3 != 17) {
            return ConnectionType.CONNECTION_UNKNOWN;
        }
        return ConnectionType.CONNECTION_VPN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ConnectionType getUnderlyingConnectionTypeForVpn(NetworkState networkState) {
        if (networkState.getNetworkType() != 17) {
            return ConnectionType.CONNECTION_NONE;
        }
        return getConnectionType(networkState.isConnected(), networkState.getUnderlyingNetworkTypeForVpn(), networkState.getUnderlyingNetworkSubtypeForVpn());
    }

    private String getWifiSSID(NetworkState networkState) {
        if (getConnectionType(networkState) != ConnectionType.CONNECTION_WIFI) {
            return "";
        }
        return this.wifiManagerDelegate.getWifiSSID();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public static long networkToNetId(Network network) {
        return network.getNetworkHandle();
    }

    private void registerReceiver() {
        if (this.isRegistered) {
            return;
        }
        this.isRegistered = true;
        this.context.registerReceiver(this, this.intentFilter);
    }

    private void unregisterReceiver() {
        if (!this.isRegistered) {
            return;
        }
        this.isRegistered = false;
        this.context.unregisterReceiver(this);
    }

    public void destroy() {
        ConnectivityManager.NetworkCallback networkCallback = this.allNetworkCallback;
        if (networkCallback != null) {
            this.connectivityManagerDelegate.releaseCallback(networkCallback);
        }
        ConnectivityManager.NetworkCallback networkCallback2 = this.mobileNetworkCallback;
        if (networkCallback2 != null) {
            this.connectivityManagerDelegate.releaseCallback(networkCallback2);
        }
        WifiDirectManagerDelegate wifiDirectManagerDelegate = this.wifiDirectManagerDelegate;
        if (wifiDirectManagerDelegate != null) {
            wifiDirectManagerDelegate.release();
        }
        unregisterReceiver();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public List<NetworkInformation> getActiveNetworkList() {
        List<NetworkInformation> activeNetworkList = this.connectivityManagerDelegate.getActiveNetworkList();
        if (activeNetworkList == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(activeNetworkList);
        WifiDirectManagerDelegate wifiDirectManagerDelegate = this.wifiDirectManagerDelegate;
        if (wifiDirectManagerDelegate != null) {
            arrayList.addAll(wifiDirectManagerDelegate.getActiveNetworkList());
        }
        return arrayList;
    }

    public NetworkState getCurrentNetworkState() {
        return this.connectivityManagerDelegate.getNetworkState();
    }

    public long getDefaultNetId() {
        return this.connectivityManagerDelegate.getDefaultNetId();
    }

    boolean isReceiverRegisteredForTesting() {
        return this.isRegistered;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        NetworkState currentNetworkState = getCurrentNetworkState();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            connectionTypeChanged(currentNetworkState);
        }
    }

    void setConnectivityManagerDelegateForTests(ConnectivityManagerDelegate connectivityManagerDelegate) {
        this.connectivityManagerDelegate = connectivityManagerDelegate;
    }

    void setWifiManagerDelegateForTests(WifiManagerDelegate wifiManagerDelegate) {
        this.wifiManagerDelegate = wifiManagerDelegate;
    }

    public boolean supportNetworkCallback() {
        return this.connectivityManagerDelegate.supportNetworkCallback();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class ConnectivityManagerDelegate {

        @Nullable
        private final ConnectivityManager connectivityManager;

        ConnectivityManagerDelegate(Context context) {
            this.connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        }

        /* JADX INFO: Access modifiers changed from: private */
        @SuppressLint({"NewApi"})
        @Nullable
        public NetworkInformation networkToInfo(@Nullable Network network) {
            boolean z16;
            if (network != null && this.connectivityManager != null) {
                Logging.d(NetworkMonitorAutoDetect.TAG, "networkToInfo entry, Network " + network.toString());
                LinkProperties linkProperties = this.connectivityManager.getLinkProperties(network);
                if (linkProperties == null) {
                    Logging.w(NetworkMonitorAutoDetect.TAG, "Detected unknown network: " + network.toString());
                    return null;
                }
                if (linkProperties.getInterfaceName() == null) {
                    Logging.w(NetworkMonitorAutoDetect.TAG, "Null interface name for network " + network.toString());
                    return null;
                }
                NetworkState networkState = getNetworkState(network);
                ConnectionType connectionType = NetworkMonitorAutoDetect.getConnectionType(networkState);
                if (connectionType == ConnectionType.CONNECTION_NONE) {
                    Logging.d(NetworkMonitorAutoDetect.TAG, "Network " + network.toString() + " is disconnected");
                    return null;
                }
                if (connectionType == ConnectionType.CONNECTION_UNKNOWN || connectionType == ConnectionType.CONNECTION_UNKNOWN_CELLULAR) {
                    Logging.w(NetworkMonitorAutoDetect.TAG, "Network " + network.toString() + " connection type is " + connectionType + " because it has type " + networkState.getNetworkType() + " and subtype " + networkState.getNetworkSubType());
                }
                NetworkInformation networkInformation = new NetworkInformation(linkProperties.getInterfaceName(), connectionType, NetworkMonitorAutoDetect.getUnderlyingConnectionTypeForVpn(networkState), NetworkMonitorAutoDetect.networkToNetId(network), getIPAddresses(linkProperties));
                IPAddress[] iPAddresses = getIPAddresses(linkProperties);
                Logging.w(NetworkMonitorAutoDetect.TAG, "Network " + network.toString() + " connection type is " + connectionType + " handle=" + networkInformation.handle);
                for (int i3 = 0; i3 < iPAddresses.length; i3++) {
                    Logging.d(NetworkMonitorAutoDetect.TAG, "Network IP address " + i3 + " is " + Arrays.toString(iPAddresses[i3].address));
                }
                return networkInformation;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("network == null ? ");
            boolean z17 = true;
            if (network == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append("\uff0c connectivityManager == null ? ");
            if (this.connectivityManager != null) {
                z17 = false;
            }
            sb5.append(z17);
            Logging.w(NetworkMonitorAutoDetect.TAG, sb5.toString());
            return null;
        }

        @Nullable
        List<NetworkInformation> getActiveNetworkList() {
            if (!supportNetworkCallback()) {
                Logging.w(NetworkMonitorAutoDetect.TAG, "getActiveNetworkList !supportNetworkCallback");
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Network network : getAllNetworks()) {
                NetworkInformation networkToInfo = networkToInfo(network);
                if (networkToInfo != null) {
                    Logging.d(NetworkMonitorAutoDetect.TAG, "getActiveNetworkList added 1 info");
                    arrayList.add(networkToInfo);
                } else {
                    Logging.w(NetworkMonitorAutoDetect.TAG, "getActiveNetworkList get info == null");
                }
            }
            return arrayList;
        }

        @SuppressLint({"NewApi"})
        Network[] getAllNetworks() {
            ConnectivityManager connectivityManager = this.connectivityManager;
            if (connectivityManager == null) {
                return new Network[0];
            }
            return connectivityManager.getAllNetworks();
        }

        @SuppressLint({"NewApi"})
        long getDefaultNetId() {
            NetworkInfo activeNetworkInfo;
            NetworkInfo networkInfo;
            if (!supportNetworkCallback() || (activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo()) == null) {
                return -1L;
            }
            long j3 = -1;
            for (Network network : getAllNetworks()) {
                if (hasInternetCapability(network) && (networkInfo = this.connectivityManager.getNetworkInfo(network)) != null && com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.getType(networkInfo) == com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.getType(activeNetworkInfo)) {
                    if (j3 == -1) {
                        j3 = NetworkMonitorAutoDetect.networkToNetId(network);
                    } else {
                        throw new RuntimeException("Multiple connected networks of same type are not supported.");
                    }
                }
            }
            return j3;
        }

        @SuppressLint({"NewApi"})
        IPAddress[] getIPAddresses(LinkProperties linkProperties) {
            IPAddress[] iPAddressArr = new IPAddress[linkProperties.getLinkAddresses().size()];
            Iterator<LinkAddress> it = linkProperties.getLinkAddresses().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                iPAddressArr[i3] = new IPAddress(it.next().getAddress().getAddress());
                i3++;
            }
            return iPAddressArr;
        }

        NetworkState getNetworkState() {
            ConnectivityManager connectivityManager = this.connectivityManager;
            if (connectivityManager == null) {
                return new NetworkState(false, -1, -1, -1, -1);
            }
            return getNetworkState(connectivityManager.getActiveNetworkInfo());
        }

        @SuppressLint({"NewApi"})
        boolean hasInternetCapability(Network network) {
            NetworkCapabilities networkCapabilities;
            ConnectivityManager connectivityManager = this.connectivityManager;
            if (connectivityManager == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(network)) == null || !networkCapabilities.hasCapability(12)) {
                return false;
            }
            return true;
        }

        @SuppressLint({"NewApi"})
        public void registerNetworkCallback(ConnectivityManager.NetworkCallback networkCallback) {
            this.connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), networkCallback);
        }

        @SuppressLint({"NewApi"})
        public void releaseCallback(ConnectivityManager.NetworkCallback networkCallback) {
            if (supportNetworkCallback()) {
                Logging.d(NetworkMonitorAutoDetect.TAG, "Unregister network callback");
                this.connectivityManager.unregisterNetworkCallback(networkCallback);
            }
        }

        @SuppressLint({"NewApi"})
        public void requestMobileNetwork(ConnectivityManager.NetworkCallback networkCallback) {
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addCapability(12).addTransportType(0);
            Logging.w(NetworkMonitorAutoDetect.TAG, "Try to requestNetwork");
            this.connectivityManager.requestNetwork(builder.build(), networkCallback);
        }

        public boolean supportNetworkCallback() {
            if (this.connectivityManager != null) {
                return true;
            }
            return false;
        }

        ConnectivityManagerDelegate() {
            this.connectivityManager = null;
        }

        @SuppressLint({"NewApi"})
        NetworkState getNetworkState(@Nullable Network network) {
            ConnectivityManager connectivityManager;
            NetworkInfo activeNetworkInfo;
            if (network != null && (connectivityManager = this.connectivityManager) != null) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
                if (networkInfo == null) {
                    Logging.w(NetworkMonitorAutoDetect.TAG, "Couldn't retrieve information from network " + network.toString());
                    return new NetworkState(false, -1, -1, -1, -1);
                }
                if (com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.getType(networkInfo) != 17) {
                    NetworkCapabilities networkCapabilities = this.connectivityManager.getNetworkCapabilities(network);
                    if (networkCapabilities != null && com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.hasTransport(networkCapabilities, 4)) {
                        return new NetworkState(networkInfo.isConnected(), 17, -1, com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.getType(networkInfo), com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.getSubtype(networkInfo));
                    }
                    return getNetworkState(networkInfo);
                }
                if (com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.getType(networkInfo) == 17) {
                    if (network.equals(this.connectivityManager.getActiveNetwork()) && (activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo()) != null && com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.getType(activeNetworkInfo) != 17) {
                        return new NetworkState(networkInfo.isConnected(), 17, -1, com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.getType(activeNetworkInfo), com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.getSubtype(activeNetworkInfo));
                    }
                    return new NetworkState(networkInfo.isConnected(), 17, -1, -1, -1);
                }
                return getNetworkState(networkInfo);
            }
            return new NetworkState(false, -1, -1, -1, -1);
        }

        private NetworkState getNetworkState(@Nullable NetworkInfo networkInfo) {
            if (networkInfo != null && networkInfo.isConnected()) {
                return new NetworkState(true, com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.getType(networkInfo), com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.getSubtype(networkInfo), -1, -1);
            }
            return new NetworkState(false, -1, -1, -1, -1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static class WifiManagerDelegate {

        @Nullable
        private final Context context;

        WifiManagerDelegate(Context context) {
            this.context = context;
        }

        String getWifiSSID() {
            WifiInfo wifiInfo;
            String ssid;
            Intent registerReceiver = this.context.registerReceiver(null, new IntentFilter("android.net.wifi.STATE_CHANGE"));
            if (registerReceiver != null && (wifiInfo = (WifiInfo) registerReceiver.getParcelableExtra("wifiInfo")) != null && (ssid = com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.getSSID(wifiInfo)) != null) {
                return ssid;
            }
            return "";
        }

        WifiManagerDelegate() {
            this.context = null;
        }
    }

    public static ConnectionType getConnectionType(NetworkState networkState) {
        return getConnectionType(networkState.isConnected(), networkState.getNetworkType(), networkState.getNetworkSubType());
    }
}
