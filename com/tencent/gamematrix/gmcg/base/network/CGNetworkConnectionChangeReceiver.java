package com.tencent.gamematrix.gmcg.base.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGNetworkConnectionChangeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected() && NetworkMonitor.getType(activeNetworkInfo) != 0) {
            NetworkMonitor.getType(activeNetworkInfo);
        }
    }
}
