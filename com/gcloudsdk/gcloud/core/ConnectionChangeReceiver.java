package com.gcloudsdk.gcloud.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.gcloudsdk.gcloud.core.NetworkStateChecker;
import com.tencent.gcloud.GCloud;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ConnectionChangeReceiver extends BroadcastReceiver {
    private static NetworkStateChecker.NetworkState LastState = NetworkStateChecker.NetworkState.NotReachable;
    private static final String TAG = "ConnectChangeReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            int type = NetworkMonitor.getType(activeNetworkInfo);
            if (type != 0) {
                if (type != 1) {
                    NetworkStateChecker.NetworkState networkState = LastState;
                    NetworkStateChecker.NetworkState networkState2 = NetworkStateChecker.NetworkState.ReachableViaOthers;
                    if (networkState != networkState2) {
                        NetworkStateChecker.NetworkState networkState3 = LastState;
                        NetworkStateChecker.NetworkState networkState4 = NetworkStateChecker.NetworkState.NotReachable;
                        if (networkState3 != networkState4) {
                            GCloud.Instance.NetworkStateChangeNotify(networkState4.ordinal());
                        }
                        Log.i(TAG, "Network Type : Other Network Type:" + NetworkMonitor.getType(activeNetworkInfo));
                        LastState = networkState2;
                        GCloud.Instance.NetworkStateChangeNotify(networkState2.ordinal());
                        return;
                    }
                    return;
                }
                NetworkStateChecker.NetworkState networkState5 = LastState;
                NetworkStateChecker.NetworkState networkState6 = NetworkStateChecker.NetworkState.ReachableViaWiFi;
                if (networkState5 != networkState6) {
                    NetworkStateChecker.NetworkState networkState7 = LastState;
                    NetworkStateChecker.NetworkState networkState8 = NetworkStateChecker.NetworkState.NotReachable;
                    if (networkState7 != networkState8) {
                        GCloud.Instance.NetworkStateChangeNotify(networkState8.ordinal());
                    }
                    Log.i(TAG, "Network State change to TYPE_WIFI");
                    LastState = networkState6;
                    GCloud.Instance.NetworkStateChangeNotify(networkState6.ordinal());
                    return;
                }
                return;
            }
            NetworkStateChecker.NetworkState networkState9 = LastState;
            NetworkStateChecker.NetworkState networkState10 = NetworkStateChecker.NetworkState.ReachableViaWWAN;
            if (networkState9 != networkState10) {
                NetworkStateChecker.NetworkState networkState11 = LastState;
                NetworkStateChecker.NetworkState networkState12 = NetworkStateChecker.NetworkState.NotReachable;
                if (networkState11 != networkState12) {
                    GCloud.Instance.NetworkStateChangeNotify(networkState12.ordinal());
                }
                Log.i(TAG, "Network State change to TYPE_MOBILE");
                LastState = networkState10;
                GCloud.Instance.NetworkStateChangeNotify(networkState10.ordinal());
                return;
            }
            return;
        }
        NetworkStateChecker.NetworkState networkState13 = LastState;
        NetworkStateChecker.NetworkState networkState14 = NetworkStateChecker.NetworkState.NotReachable;
        if (networkState13 != networkState14) {
            Log.i(TAG, "ApolloNetInfo : null or disConnected. Network State change to TYPE_None");
            LastState = networkState14;
            GCloud.Instance.NetworkStateChangeNotify(networkState14.ordinal());
        }
    }

    public void runNetworkStateChange(int i3) {
    }
}
