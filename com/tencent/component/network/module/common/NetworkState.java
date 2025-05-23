package com.tencent.component.network.module.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.component.network.downloader.GlobalHandlerThread;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class NetworkState extends BroadcastReceiver {
    public static final int NETWORK_TYPE_2G = 3;
    public static final int NETWORK_TYPE_3G = 2;
    public static final int NETWORK_TYPE_4G = 6;
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    public static final int NETWORK_TYPE_WIFI = 1;
    private static final String TAG = "com.tencent.component.network.module.common.NetworkState";
    private static NetworkState instance;
    private static int networkType;
    private Context context = null;
    private String providerName = null;
    private boolean loadProviderName = false;
    private List<NetworkStateListener> observers = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface NetworkStateListener {
        void onNetworkConnect(boolean z16);
    }

    public static NetworkState g() {
        if (instance == null) {
            instance = new NetworkState();
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyObservers(boolean z16) {
        int size;
        NetworkStateListener[] networkStateListenerArr;
        synchronized (this.observers) {
            size = this.observers.size();
            networkStateListenerArr = new NetworkStateListener[size];
            this.observers.toArray(networkStateListenerArr);
        }
        for (int i3 = 0; i3 < size; i3++) {
            networkStateListenerArr[i3].onNetworkConnect(z16);
        }
    }

    public void addListener(NetworkStateListener networkStateListener) {
        if (networkStateListener == null) {
            return;
        }
        synchronized (this.observers) {
            if (!this.observers.contains(networkStateListener)) {
                this.observers.add(networkStateListener);
            }
        }
    }

    public int getNetworkType() {
        return networkType;
    }

    public boolean isNetworkAvailable() {
        Context context = this.context;
        if (context == null) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        boolean isConnected = activeNetworkInfo.isConnected();
        if (!isConnected) {
            QDLog.e(TAG, "isNetworkEnable() : FALSE with TYPE = " + NetworkMonitor.getType(activeNetworkInfo));
        }
        return isConnected;
    }

    public boolean isNetworkConnected() {
        Context context = this.context;
        if (context == null) {
            return true;
        }
        return isNetworkConnected(context);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        QDLog.e(TAG, "NetworkStateReceiver ====== " + intent.getAction());
        if (intent.getAction() != null && intent.getAction().compareTo("android.net.conn.CONNECTIVITY_CHANGE") == 0) {
            GlobalHandlerThread.getInstance(context).getHandler().post(new Runnable() { // from class: com.tencent.component.network.module.common.NetworkState.1
                @Override // java.lang.Runnable
                public void run() {
                    NetworkState.this.notifyObservers(NetworkState.isNetworkConnected(context));
                }
            });
        }
    }

    public void removeListener(NetworkStateListener networkStateListener) {
        synchronized (this.observers) {
            this.observers.remove(networkStateListener);
        }
    }

    public void setContext(Context context) {
        this.context = context;
        context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        isNetworkConnected(context);
    }

    public void unregisterReceiver() {
        this.context.unregisterReceiver(this);
    }

    private static int getNetworkType(NetworkInfo networkInfo) {
        int type = NetworkMonitor.getType(networkInfo);
        if (type == 0) {
            switch (NetworkMonitor.getSubtype(networkInfo)) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    networkType = 3;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    networkType = 2;
                    break;
                case 13:
                    networkType = 6;
                    break;
            }
        } else if (type != 1) {
            networkType = 0;
        } else {
            networkType = 1;
        }
        return networkType;
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo[] allNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
                for (NetworkInfo networkInfo : allNetworkInfo) {
                    if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                        getNetworkType(networkInfo);
                        return true;
                    }
                }
            }
        } catch (SecurityException unused) {
            return true;
        } catch (Throwable unused2) {
        }
        return false;
    }
}
