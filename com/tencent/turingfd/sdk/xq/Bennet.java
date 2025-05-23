package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.net.InetAddress;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Bennet {

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.Bennet$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static class Cdo extends ConnectivityManager.NetworkCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public volatile Object f382586a;

        /* renamed from: b, reason: collision with root package name */
        public final int f382587b;

        /* renamed from: c, reason: collision with root package name */
        public final long f382588c;

        public Cdo(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
                return;
            }
            this.f382586a = null;
            this.f382588c = SystemClock.elapsedRealtime();
            this.f382587b = i3;
        }

        public void a() {
            Context context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            synchronized (Celse.class) {
                context = Celse.f383328a;
            }
            ((ConnectivityManager) context.getSystemService("connectivity")).unregisterNetworkCallback(this);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) network);
                return;
            }
            super.onAvailable(network);
            synchronized (this) {
                this.f382586a = network;
                notifyAll();
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            super.onUnavailable();
            synchronized (this) {
                this.f382586a = this;
                notifyAll();
            }
        }
    }

    public static byte a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTING || activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED)) {
                if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
                    return (byte) 0;
                }
                if (NetworkMonitor.getType(activeNetworkInfo) != 0) {
                    return (byte) 3;
                }
                if (Proxy.getDefaultHost() == null) {
                    return Proxy.getHost(context) != null ? (byte) 2 : (byte) 1;
                }
                return (byte) 2;
            }
            return (byte) -1;
        } catch (Throwable th5) {
            String message = th5.getMessage();
            return message != null && message.contains("ACCESS_NETWORK_STATE") ? (byte) 0 : (byte) -1;
        }
    }

    public static byte b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTING || activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
                        return (byte) 0;
                    }
                    if (NetworkMonitor.getType(activeNetworkInfo) == 0) {
                        if (Proxy.getDefaultHost() == null) {
                            if (Proxy.getHost(context) == null) {
                                return (byte) 1;
                            }
                            return (byte) 2;
                        }
                        return (byte) 2;
                    }
                    return (byte) 3;
                }
                return (byte) -1;
            }
            return (byte) -1;
        } catch (Throwable th5) {
            String message = th5.getMessage();
            if (message != null && message.contains("ACCESS_NETWORK_STATE")) {
                return (byte) -2;
            }
            return (byte) -3;
        }
    }

    public static boolean c(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th5) {
            String message = th5.getMessage();
            if (message != null && message.contains("ACCESS_NETWORK_STATE")) {
                return true;
            }
            return false;
        }
    }

    public static String a(Network network) {
        Context context;
        if (network == null) {
            return null;
        }
        try {
            synchronized (Celse.class) {
                context = Celse.f383328a;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
            if (networkCapabilities == null) {
                return null;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(Chestnut.a(networkCapabilities.getClass(), "mTransportTypes", networkCapabilities));
            sb5.append(",");
            sb5.append(Chestnut.a(networkCapabilities.getClass(), "mNetworkCapabilities", networkCapabilities));
            LinkProperties linkProperties = connectivityManager.getLinkProperties(network);
            if (linkProperties == null) {
                return sb5.toString();
            }
            String interfaceName = linkProperties.getInterfaceName();
            int i3 = Plum.f383026a;
            if (interfaceName == null) {
                interfaceName = "";
            }
            String replace = interfaceName.replace(",", "").replace(";", "");
            sb5.append(",");
            sb5.append(replace);
            sb5.append(",");
            List<LinkAddress> linkAddresses = linkProperties.getLinkAddresses();
            if (!Creturn.a(linkAddresses)) {
                for (int i16 = 0; i16 < linkAddresses.size(); i16++) {
                    sb5.append(linkAddresses.get(i16).getAddress().getHostAddress());
                    if (i16 != linkAddresses.size() - 1) {
                        sb5.append(";");
                    }
                }
            }
            sb5.append(",");
            List<InetAddress> dnsServers = linkProperties.getDnsServers();
            if (!Creturn.a(dnsServers)) {
                for (int i17 = 0; i17 < dnsServers.size(); i17++) {
                    sb5.append(dnsServers.get(i17).getHostAddress());
                    if (i17 != dnsServers.size() - 1) {
                        sb5.append(";");
                    }
                }
            }
            return sb5.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
