package com.gcore.abase;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.gcore.abase.log.XLog;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ConnectionChangeReceiver extends BroadcastReceiver {
    private static NetworkState LastState = NetworkState.NotReachable;
    private static final String TAG = "ConnectionChangeReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            int type = NetworkMonitor.getType(activeNetworkInfo);
            if (type != 0) {
                if (type != 1) {
                    NetworkState networkState = LastState;
                    NetworkState networkState2 = NetworkState.ReachableViaOthers;
                    if (networkState != networkState2) {
                        NetworkState networkState3 = LastState;
                        NetworkState networkState4 = NetworkState.NotReachable;
                        if (networkState3 != networkState4) {
                            GCloudCore.Instance.NetworkStateChangeNotify(networkState4.ordinal());
                        }
                        XLog.i(TAG, "Network Type : Other Network Type:" + NetworkMonitor.getType(activeNetworkInfo));
                        LastState = networkState2;
                        GCloudCore.Instance.NetworkStateChangeNotify(networkState2.ordinal());
                        return;
                    }
                    return;
                }
                NetworkState networkState5 = LastState;
                NetworkState networkState6 = NetworkState.ReachableViaWiFi;
                if (networkState5 != networkState6) {
                    NetworkState networkState7 = LastState;
                    NetworkState networkState8 = NetworkState.NotReachable;
                    if (networkState7 != networkState8) {
                        GCloudCore.Instance.NetworkStateChangeNotify(networkState8.ordinal());
                    }
                    XLog.i(TAG, "Network State change to TYPE_WIFI");
                    LastState = networkState6;
                    GCloudCore.Instance.NetworkStateChangeNotify(networkState6.ordinal());
                    return;
                }
                return;
            }
            NetworkState networkState9 = LastState;
            NetworkState networkState10 = NetworkState.ReachableViaWWAN;
            if (networkState9 != networkState10) {
                NetworkState networkState11 = LastState;
                NetworkState networkState12 = NetworkState.NotReachable;
                if (networkState11 != networkState12) {
                    GCloudCore.Instance.NetworkStateChangeNotify(networkState12.ordinal());
                }
                XLog.i(TAG, "Network State change to TYPE_MOBILE");
                LastState = networkState10;
                GCloudCore.Instance.NetworkStateChangeNotify(networkState10.ordinal());
                return;
            }
            return;
        }
        NetworkState networkState13 = LastState;
        NetworkState networkState14 = NetworkState.NotReachable;
        if (networkState13 != networkState14) {
            XLog.i(TAG, "ApolloNetInfo : null or disConnected. Network State change to TYPE_None");
            LastState = networkState14;
            GCloudCore.Instance.NetworkStateChangeNotify(networkState14.ordinal());
        }
    }

    public void runNetworkStateChange(int i3) {
    }
}
