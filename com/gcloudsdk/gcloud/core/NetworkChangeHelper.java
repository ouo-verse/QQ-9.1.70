package com.gcloudsdk.gcloud.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.gcloudsdk.gcloud.core.NetworkStateChecker;
import com.tencent.gcloud.GCloud;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public class NetworkChangeHelper {
    public static NetworkChangeHelper Instance = new NetworkChangeHelper();
    private static final int NETWORK_STATE_AVAILABLE_MOBILE = 1;
    private static final int NETWORK_STATE_AVAILABLE_OTHER = 3;
    private static final int NETWORK_STATE_AVAILABLE_WIFI = 2;
    private static final int NETWORK_STATE_UNAVAILABLE = 0;
    private static final String TAG = "NetworkChangeHelper";
    private boolean enableCallback = true;
    private int mLastState = 0;
    private NetworkChangeReceiver mNetworkChangeReceiver = null;
    private NetworkChangeCallback mNetworkChangeCallback = null;

    /* compiled from: P */
    @RequiresApi(api = 21)
    /* loaded from: classes2.dex */
    public class NetworkChangeCallback extends ConnectivityManager.NetworkCallback {
        public NetworkChangeCallback() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            Log.d(NetworkChangeHelper.TAG, "network available");
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
            if (networkCapabilities.hasCapability(16)) {
                if (NetworkMonitor.hasTransport(networkCapabilities, 1)) {
                    Log.i(NetworkChangeHelper.TAG, "network available for wifi");
                    NetworkChangeHelper.this.handleNetworkChange(2);
                } else if (NetworkMonitor.hasTransport(networkCapabilities, 0)) {
                    Log.i(NetworkChangeHelper.TAG, "network available for mobile");
                    NetworkChangeHelper.this.handleNetworkChange(1);
                } else {
                    Log.i(NetworkChangeHelper.TAG, "network available for other");
                    NetworkChangeHelper.this.handleNetworkChange(3);
                }
            }
            if (networkCapabilities.hasCapability(12)) {
                Log.d(NetworkChangeHelper.TAG, "internet online");
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
            Log.i(NetworkChangeHelper.TAG, HttpBaseUtil.NetworkUnavailableException.ERROR_INFO);
            NetworkChangeHelper.this.handleNetworkChange(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class NetworkChangeReceiver extends BroadcastReceiver {
        public NetworkChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                NetworkChangeHelper.this.handleNetworkChange(0);
                return;
            }
            int type = NetworkMonitor.getType(activeNetworkInfo);
            if (type != 0) {
                if (type != 1) {
                    Log.i(NetworkChangeHelper.TAG, "Receive Network State, Other:" + NetworkMonitor.getType(activeNetworkInfo));
                    NetworkChangeHelper.this.handleNetworkChange(3);
                    return;
                }
                Log.i(NetworkChangeHelper.TAG, "Receive Network State TYPE_WIFI");
                NetworkChangeHelper.this.handleNetworkChange(2);
                return;
            }
            Log.i(NetworkChangeHelper.TAG, "Receive Network State TYPE_MOBILE");
            NetworkChangeHelper.this.handleNetworkChange(1);
        }
    }

    NetworkChangeHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNetworkChange(int i3) {
        int i16 = this.mLastState;
        if (i16 == i3) {
            Log.w(TAG, "Network State not change:" + i3);
            return;
        }
        if (i16 != 0) {
            GCloud.Instance.NetworkStateChangeNotify(NetworkStateChecker.NetworkState.NotReachable.ordinal());
        }
        this.mLastState = i3;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        Log.i(TAG, "Network State change to TYPE_OTHER");
                        GCloud.Instance.NetworkStateChangeNotify(NetworkStateChecker.NetworkState.ReachableViaOthers.ordinal());
                        return;
                    }
                    return;
                }
                Log.i(TAG, "Network State change to TYPE_WIFI");
                GCloud.Instance.NetworkStateChangeNotify(NetworkStateChecker.NetworkState.ReachableViaWiFi.ordinal());
                return;
            }
            Log.i(TAG, "Network State change to TYPE_MOBILE");
            GCloud.Instance.NetworkStateChangeNotify(NetworkStateChecker.NetworkState.ReachableViaWWAN.ordinal());
            return;
        }
        Log.i(TAG, "Network State change to TYPE_NONE");
    }

    private boolean hasRegistListener() {
        if (this.mNetworkChangeCallback == null && this.mNetworkChangeReceiver == null) {
            return false;
        }
        return true;
    }

    public void enableCallback(boolean z16) {
        if (hasRegistListener()) {
            Log.e(TAG, "this api need to be called before registerNetworkListener");
        } else {
            Log.i(TAG, "enableCallback");
            this.enableCallback = z16;
        }
    }

    public void registerNetworkListener(Context context) {
        if (hasRegistListener()) {
            Log.w(TAG, "NetworkCallback registered");
            return;
        }
        if (Build.VERSION.SDK_INT >= 24 && this.enableCallback) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkChangeCallback networkChangeCallback = new NetworkChangeCallback();
                this.mNetworkChangeCallback = networkChangeCallback;
                connectivityManager.registerDefaultNetworkCallback(networkChangeCallback);
                return;
            }
            return;
        }
        this.mNetworkChangeReceiver = new NetworkChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(this.mNetworkChangeReceiver, intentFilter);
    }

    public void unregisterNetworkListener(Context context) {
        ConnectivityManager connectivityManager;
        if (!hasRegistListener()) {
            Log.w(TAG, "has not RegistNetworkCallback");
            return;
        }
        if (Build.VERSION.SDK_INT >= 24 && this.enableCallback) {
            if (this.mNetworkChangeCallback != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
                connectivityManager.unregisterNetworkCallback(this.mNetworkChangeCallback);
                this.mNetworkChangeCallback = null;
                return;
            }
            return;
        }
        NetworkChangeReceiver networkChangeReceiver = this.mNetworkChangeReceiver;
        if (networkChangeReceiver != null) {
            context.unregisterReceiver(networkChangeReceiver);
            this.mNetworkChangeReceiver = null;
        }
    }
}
