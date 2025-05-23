package com.tencent.mars.comm;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes9.dex */
public class MarsPlatformComm {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MarsPlatformComm";
    private static Boolean mIsVpnUsed;

    /* loaded from: classes9.dex */
    public static class VpnNetworkCallback extends ConnectivityManager.NetworkCallback {
        static IPatchRedirector $redirector_;

        VpnNetworkCallback() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        private void updateVpnStatus() {
            boolean access$100 = MarsPlatformComm.access$100();
            if (access$100 != MarsPlatformComm.mIsVpnUsed.booleanValue()) {
                w.d(MarsPlatformComm.TAG, "vpn status from [" + MarsPlatformComm.mIsVpnUsed + "] to [" + access$100 + "]");
                Boolean unused = MarsPlatformComm.mIsVpnUsed = Boolean.valueOf(access$100);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(@NonNull Network network) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) network);
            } else {
                super.onAvailable(network);
                updateVpnStatus();
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(@NonNull Network network) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) network);
            } else {
                super.onLost(network);
                updateVpnStatus();
            }
        }

        public /* synthetic */ VpnNetworkCallback(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) anonymousClass1);
        }
    }

    public MarsPlatformComm() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ boolean access$100() {
        return getVpnStatus();
    }

    public static boolean bindSocketToCellular(int i3) {
        w.d(TAG, "bindSocketToCellular, fd:" + i3);
        return MultiNetLinkWaysUtil.INSTANCE.instance().bindSocketToMobile(i3, z.c());
    }

    private static boolean getVpnStatus() {
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) z.c().getSystemService("connectivity");
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null) {
                return NetworkMonitor.hasTransport(networkCapabilities, 4);
            }
            return false;
        } catch (Throwable th5) {
            w.b(TAG, "ex: " + th5);
            return false;
        }
    }

    public static boolean isCellularNetworkActive() {
        w.d(TAG, "active network");
        return MultiNetLinkWaysUtil.INSTANCE.instance().syncActiveMobileNetwork(z.c());
    }

    public static boolean isVpnConnected() {
        Boolean bool = mIsVpnUsed;
        if (bool != null) {
            return bool.booleanValue();
        }
        synchronized (MarsPlatformComm.class) {
            if (mIsVpnUsed == null) {
                mIsVpnUsed = Boolean.valueOf(getVpnStatus());
                w.d(TAG, "Vpn status init:" + mIsVpnUsed);
                ConnectivityManager connectivityManager = (ConnectivityManager) z.c().getSystemService("connectivity");
                if (connectivityManager != null && Build.VERSION.SDK_INT >= 30) {
                    connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().removeCapability(15).build(), new VpnNetworkCallback(null));
                    w.d(TAG, "Register vpn event");
                }
            }
        }
        return mIsVpnUsed.booleanValue();
    }

    public static String resolveHostByCellular(String str, int i3) {
        String str2;
        w.d(TAG, "resolveHostByCellular host:" + str);
        ExecutorService newFixedThreadPool = ProxyExecutors.newFixedThreadPool(1);
        Future submit = newFixedThreadPool.submit(new Callable<String>(str) { // from class: com.tencent.mars.comm.MarsPlatformComm.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$host;

            {
                this.val$host = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
                }
            }

            @Override // java.util.concurrent.Callable
            public String call() throws Exception {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? MultiNetLinkWaysUtil.INSTANCE.instance().resolveHostByCellular(this.val$host, z.c()) : (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
        });
        try {
            str2 = (String) submit.get(i3, TimeUnit.MILLISECONDS);
        } catch (Throwable th5) {
            try {
                w.b(TAG, "ex: " + th5);
                submit.cancel(true);
                str2 = "";
            } finally {
                newFixedThreadPool.shutdown();
            }
        }
        return str2;
    }
}
