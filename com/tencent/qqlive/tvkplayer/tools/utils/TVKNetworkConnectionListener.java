package com.tencent.qqlive.tvkplayer.tools.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKNetworkConnectionListener {
    private static final String TAG = "TVKNetworkConnectionListener";
    private static final TVKNetworkConnectionListener sInstance = new TVKNetworkConnectionListener();
    private ConnectivityManager mConnectivityManager;
    private Network mCurrentCellularNetwork;
    private ConnectivityManager.NetworkCallback mNetworkCallback;

    TVKNetworkConnectionListener() {
    }

    public static TVKNetworkConnectionListener getInstance() {
        return sInstance;
    }

    @Nullable
    public Network getAvailableCellularNetwork() {
        return this.mCurrentCellularNetwork;
    }

    @Nullable
    public NetworkInfo getCellularNetworkInfo() {
        ConnectivityManager connectivityManager = this.mConnectivityManager;
        if (connectivityManager == null) {
            return null;
        }
        return connectivityManager.getNetworkInfo(this.mCurrentCellularNetwork);
    }

    public synchronized void registerNetworkConnectivity(Context context) {
        if (context == null) {
            TVKLogUtil.w(TAG, "context is null, cannot registerNetworkConnectivity");
            return;
        }
        int i3 = Build.VERSION.SDK_INT;
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        builder.addCapability(12);
        builder.addTransportType(0);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.mConnectivityManager = connectivityManager;
        if (connectivityManager == null) {
            TVKLogUtil.w(TAG, "connectivityManager is null, cannot set network callback");
            return;
        }
        NetworkRequest build = builder.build();
        ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.tencent.qqlive.tvkplayer.tools.utils.TVKNetworkConnectionListener.1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                super.onAvailable(network);
                TVKLogUtil.i(TVKNetworkConnectionListener.TAG, "onAvailable");
                TVKNetworkConnectionListener.this.mCurrentCellularNetwork = network;
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                super.onLost(network);
                TVKLogUtil.i(TVKNetworkConnectionListener.TAG, "onLost");
                TVKNetworkConnectionListener.this.mCurrentCellularNetwork = null;
            }
        };
        this.mNetworkCallback = networkCallback;
        try {
            if (i3 >= 26) {
                this.mConnectivityManager.requestNetwork(build, networkCallback, new Handler(TVKThreadPool.getInstance().obtainSharedHandlerThread().getLooper()));
            } else {
                this.mConnectivityManager.requestNetwork(build, networkCallback);
            }
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, "connectivityManager requestNetwork has exception:" + e16);
        }
    }

    public synchronized void unregisterNetworkConnectivity() {
        ConnectivityManager connectivityManager = this.mConnectivityManager;
        if (connectivityManager == null) {
            return;
        }
        connectivityManager.unregisterNetworkCallback(this.mNetworkCallback);
    }
}
