package com.tencent.upload.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.network.base.ConnectionImpl;
import com.tencent.upload.utils.UploadLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class NetworkState extends BroadcastReceiver {
    static IPatchRedirector $redirector_ = null;
    public static final int IP_STACK_DUAL = 3;
    public static final int IP_STACK_IPV4 = 1;
    public static final int IP_STACK_IPV6 = 2;
    public static final int IP_STACK_NONE = 0;
    public static final int NETWORK_TYPE_2G = 3;
    public static final int NETWORK_TYPE_3G = 2;
    public static final int NETWORK_TYPE_4G = 6;
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    public static final int NETWORK_TYPE_WIFI = 1;
    private static final String TAG = "NetworkState";
    private static NetworkState instance;
    private static int networkType;
    private String apn;
    private Context context;
    private boolean loadProviderName;
    private List<NetworkStateListener> observers;
    private String providerName;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class APNName {
        static IPatchRedirector $redirector_ = null;
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

        public APNName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface NetworkStateListener {
        void onNetworkApnChanged(boolean z16);

        void onNetworkConnected(boolean z16);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11130);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            instance = null;
            networkType = 0;
        }
    }

    public NetworkState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.context = null;
        this.providerName = null;
        this.loadProviderName = false;
        this.apn = "none";
        this.observers = new ArrayList();
    }

    public static NetworkState getInstance() {
        if (instance == null) {
            instance = new NetworkState();
        }
        return instance;
    }

    public static int getNetworkStackType() {
        if (!ConnectionImpl.isLibraryPrepared()) {
            return 1;
        }
        return ConnectionImpl.getIpStack();
    }

    public static int getNetworkStackTypeInner() {
        if (UploadGlobalConfig.getConfig() == null || !UploadGlobalConfig.getConfig().enableV6Route()) {
            return 1;
        }
        return getNetworkStackType();
    }

    private void notifyApnChanged(boolean z16) {
        int size;
        NetworkStateListener[] networkStateListenerArr;
        synchronized (this.observers) {
            size = this.observers.size();
            networkStateListenerArr = new NetworkStateListener[size];
            this.observers.toArray(networkStateListenerArr);
        }
        for (int i3 = 0; i3 < size; i3++) {
            networkStateListenerArr[i3].onNetworkApnChanged(z16);
        }
    }

    private void notifyObservers(boolean z16) {
        int size;
        NetworkStateListener[] networkStateListenerArr;
        synchronized (this.observers) {
            size = this.observers.size();
            networkStateListenerArr = new NetworkStateListener[size];
            this.observers.toArray(networkStateListenerArr);
        }
        for (int i3 = 0; i3 < size; i3++) {
            networkStateListenerArr[i3].onNetworkConnected(z16);
        }
    }

    public void addListener(NetworkStateListener networkStateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) networkStateListener);
        } else {
            if (networkStateListener == null) {
                return;
            }
            synchronized (this.observers) {
                if (!this.observers.contains(networkStateListener)) {
                    this.observers.add(networkStateListener);
                }
            }
        }
    }

    public String getApnName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.apn;
    }

    public String getApnValue() {
        NetworkInfo networkInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        Context context = this.context;
        if (context == null) {
            return "none";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
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
                return NetworkMonitor.netGetExInfo(networkInfo).toLowerCase();
            }
            return "none";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public int getNetworkType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? networkType : ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
    }

    public boolean isNetworkAvailable() {
        NetworkInfo networkInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        Context context = this.context;
        if (context == null) {
            return true;
        }
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th5) {
            UploadLog.e(TAG, "fail to get active network info", th5);
            networkInfo = null;
        }
        if (networkInfo == null) {
            return false;
        }
        boolean isConnected = networkInfo.isConnected();
        if (!isConnected) {
            UploadLog.e(TAG, "isNetworkEnable() : FALSE with TYPE = " + NetworkMonitor.getType(networkInfo));
        }
        return isConnected;
    }

    public boolean isNetworkConnected() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        Context context = this.context;
        if (context == null) {
            return true;
        }
        return isNetworkConnected(context);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            return;
        }
        String apnValue = getApnValue();
        UploadLog.d(TAG, "NetworkStateReceiver ====== " + intent.getAction() + " apn:" + this.apn + " -> " + apnValue + " Available:" + isNetworkAvailable(context));
        if (intent.getAction() == null) {
            return;
        }
        if (intent.getAction().compareTo("android.net.conn.CONNECTIVITY_CHANGE") == 0) {
            notifyObservers(isNetworkConnected(context));
        }
        if (apnValue != null && !apnValue.equalsIgnoreCase(this.apn)) {
            notifyApnChanged(true);
        }
    }

    public void removeListener(NetworkStateListener networkStateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) networkStateListener);
            return;
        }
        synchronized (this.observers) {
            this.observers.remove(networkStateListener);
        }
    }

    public void setContext(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        context.registerReceiver(this, new IntentFilter(new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")));
        isNetworkConnected(context);
    }

    public void unregisterReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.context.unregisterReceiver(this);
        }
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
        if (context == null) {
            return false;
        }
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

    public static boolean isNetworkAvailable(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }
}
