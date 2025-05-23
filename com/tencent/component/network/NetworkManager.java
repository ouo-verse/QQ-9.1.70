package com.tencent.component.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.component.network.downloader.GlobalHandlerThread;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.common.DnsService;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class NetworkManager {
    public static final int Operator_CMCC = 1;
    public static final int Operator_CMCT = 3;
    public static final int Operator_Unicom = 2;
    public static final int Operator_Unknown = 0;
    public static final int Operator_WIFI = 4;
    private static Context mContext;
    private static NetworkChangeReceiver sNetworkChangeReceiver;
    private static Object LOCK_NETLSTENER = new Object();
    private static List<WeakReference<NetStatusListener>> mNetworkListener = Collections.synchronizedList(new ArrayList());

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class APNName {
        public static final String NAME_3GNET = "3gnet";
        public static final String NAME_3GWAP = "3gwap";
        public static final String NAME_777 = "#777";
        public static final String NAME_CMCC = "cmcc";
        public static final String NAME_CMCT = "cmct";
        public static final String NAME_CMNET = "cmnet";
        public static final String NAME_CMWAP = "cmwap";
        public static final String NAME_CTNET = "ctnet";
        public static final String NAME_CTWAP = "ctwap";
        public static final String NAME_NONE = "none";
        public static final String NAME_UNICOM = "unicom";
        public static final String NAME_UNINET = "uninet";
        public static final String NAME_UNIWAP = "uniwap";
        public static final String NAME_UNKNOWN = "unknown";
        public static final String NAME_WIFI = "wifi";
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface NetStatusListener {
        void onNetworkChanged(String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class NetworkChangeReceiver extends BroadcastReceiver {
        private String mApn = "none";
        private Context mContext;

        public NetworkChangeReceiver(Context context) {
            this.mContext = context;
        }

        public String getApn() {
            return this.mApn;
        }

        public String getApnValue() {
            NetworkInfo networkInfo;
            String str = "unknown";
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
                if (connectivityManager != null) {
                    networkInfo = connectivityManager.getActiveNetworkInfo();
                } else {
                    networkInfo = null;
                }
                if (networkInfo != null && networkInfo.isConnected()) {
                    if (1 == NetworkMonitor.getType(networkInfo)) {
                        return "wifi";
                    }
                    if (NetworkMonitor.netGetExInfo(networkInfo) == null) {
                        return "unknown";
                    }
                    str = NetworkMonitor.netGetExInfo(networkInfo).toLowerCase();
                    return str;
                }
                return "none";
            } catch (Throwable unused) {
                return str;
            }
        }

        public Context getContext() {
            return this.mContext;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                GlobalHandlerThread.getInstance(context).getHandler().post(new Runnable() { // from class: com.tencent.component.network.NetworkManager.NetworkChangeReceiver.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String apnValue = NetworkChangeReceiver.this.getApnValue();
                        if (NetworkManager.isNetworkAvailable() && !apnValue.equals(NetworkChangeReceiver.this.mApn)) {
                            DnsService.getInstance().reset();
                            DownloadGlobalStrategy.getInstance(Global.getContext()).onNetworkChanged(NetworkChangeReceiver.this.mApn, apnValue);
                        }
                        if (!apnValue.equals(NetworkChangeReceiver.this.mApn)) {
                            synchronized (NetworkManager.LOCK_NETLSTENER) {
                                Iterator it = NetworkManager.mNetworkListener.iterator();
                                while (it.hasNext()) {
                                    NetStatusListener netStatusListener = (NetStatusListener) ((WeakReference) it.next()).get();
                                    if (netStatusListener != null) {
                                        netStatusListener.onNetworkChanged(NetworkChangeReceiver.this.mApn, apnValue);
                                    }
                                }
                            }
                        }
                        NetworkChangeReceiver.this.mApn = apnValue;
                    }
                });
            }
        }

        public void setApn(String str) {
            this.mApn = str;
        }
    }

    NetworkManager() {
    }

    public static String getApnValue() {
        NetworkChangeReceiver networkChangeReceiver = sNetworkChangeReceiver;
        if (networkChangeReceiver == null) {
            return "none";
        }
        return networkChangeReceiver.getApnValue();
    }

    public static String getBSSID() {
        WifiInfo connectionInfo;
        try {
            if (Config.disableBssid() || (connectionInfo = LocationMonitor.getConnectionInfo((WifiManager) mContext.getSystemService("wifi"))) == null) {
                return null;
            }
            return NetworkMonitor.getBSSID(connectionInfo);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int getISPType(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (!str.contains("cmnet") && !str.contains("cmwap") && !str.contains("cmcc")) {
            if (!str.contains("uninet") && !str.contains("uniwap") && !str.contains("unicom") && !str.contains("3gnet") && !str.contains("3gwap")) {
                if (!str.contains("ctwap") && !str.contains("ctnet") && !str.contains("cmct") && !str.contains("#777")) {
                    return getOperator();
                }
                return 3;
            }
            return 2;
        }
        return 1;
    }

    public static int getIspType() {
        return getISPType(getApnValue());
    }

    private static int getOperator() {
        return Config.getOperator();
    }

    public static void init(Context context) {
        if (mContext != null) {
            return;
        }
        mContext = context;
        try {
            sNetworkChangeReceiver = new NetworkChangeReceiver(context);
            context.registerReceiver(sNetworkChangeReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Exception e16) {
            QDLog.e("NetworkManager", "downloader register NetworkChangeReceiver failed!", e16);
        }
    }

    public static boolean isMobile() {
        NetworkInfo networkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService("connectivity");
            if (connectivityManager != null) {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } else {
                networkInfo = null;
            }
            if (networkInfo != null && networkInfo.isConnected()) {
                if (NetworkMonitor.getType(networkInfo) != 0) {
                    return false;
                }
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isNetworkAvailable() {
        NetworkInfo networkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService("connectivity");
            if (connectivityManager != null) {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } else {
                networkInfo = null;
            }
            if (networkInfo != null) {
                if (networkInfo.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean isWap() {
        String apnValue = getApnValue();
        if (TextUtils.isEmpty(apnValue)) {
            return false;
        }
        if (!apnValue.contains("cmwap") && !apnValue.contains("uniwap") && !apnValue.contains("3gwap") && !apnValue.contains("ctwap")) {
            return false;
        }
        return true;
    }

    public static boolean isWifi() {
        NetworkInfo networkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService("connectivity");
            if (connectivityManager != null) {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } else {
                networkInfo = null;
            }
            if (networkInfo != null && networkInfo.isConnected()) {
                if (1 != NetworkMonitor.getType(networkInfo)) {
                    return false;
                }
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void registNetStatusListener(NetStatusListener netStatusListener) {
        WeakReference<NetStatusListener> weakReference = new WeakReference<>(netStatusListener);
        synchronized (LOCK_NETLSTENER) {
            mNetworkListener.add(weakReference);
        }
    }

    public static void unregistNetStatusListener(NetStatusListener netStatusListener) {
        synchronized (LOCK_NETLSTENER) {
            Iterator it = new ArrayList(mNetworkListener).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WeakReference weakReference = (WeakReference) it.next();
                if (((NetStatusListener) weakReference.get()) == netStatusListener) {
                    mNetworkListener.remove(weakReference);
                    break;
                }
            }
        }
    }
}
