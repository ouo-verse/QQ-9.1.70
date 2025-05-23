package com.tencent.mobileqq.msf.core.net;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
@TargetApi(21)
/* loaded from: classes15.dex */
public class m {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final String f248791a = "NetworkChannelManager";

    /* renamed from: b, reason: collision with root package name */
    public static final int f248792b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static final int f248793c = 1;

    /* renamed from: d, reason: collision with root package name */
    private static AtomicInteger f248794d;

    /* renamed from: e, reason: collision with root package name */
    private static a f248795e;

    /* renamed from: f, reason: collision with root package name */
    private static final a f248796f;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a extends ConnectivityManager.NetworkCallback {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, i3);
            } else if (QLog.isColorLevel()) {
                QLog.d(m.f248791a, 2, "onRequestNetwork " + i3);
            }
        }

        public void b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, i3);
            } else if (QLog.isColorLevel()) {
                QLog.d(m.f248791a, 2, "onUnregisterNetwork " + i3);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) network);
                return;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) BaseApplication.getContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                return;
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onAvailable network: ");
                sb5.append(network.toString());
                sb5.append(" ");
                if (networkInfo != null) {
                    str = networkInfo.toString();
                } else {
                    str = "netInfo is null";
                }
                sb5.append(str);
                QLog.d(m.f248791a, 2, sb5.toString());
            }
            if (m.f248795e != null) {
                try {
                    m.f248795e.onAvailable(network);
                } catch (Exception e16) {
                    QLog.w(m.f248791a, 1, e16.getMessage(), e16);
                }
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) network, (Object) networkCapabilities);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(m.f248791a, 2, "onCapabilitiesChanged " + network.toString() + " " + networkCapabilities.toString());
            }
            if (m.f248795e != null) {
                try {
                    m.f248795e.onCapabilitiesChanged(network, networkCapabilities);
                } catch (Exception e16) {
                    QLog.w(m.f248791a, 1, e16.getMessage(), e16);
                }
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) network, (Object) linkProperties);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(m.f248791a, 2, "onLinkPropertiesChanged " + network.toString() + " " + linkProperties.toString());
            }
            if (m.f248795e != null) {
                try {
                    m.f248795e.onLinkPropertiesChanged(network, linkProperties);
                } catch (Exception e16) {
                    QLog.w(m.f248791a, 1, e16.getMessage(), e16);
                }
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) network, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(m.f248791a, 2, "onLosing " + network.toString() + " " + i3);
            }
            if (m.f248795e != null) {
                try {
                    m.f248795e.onLosing(network, i3);
                } catch (Exception e16) {
                    QLog.w(m.f248791a, 1, e16.getMessage(), e16);
                }
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) network);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(m.f248791a, 2, "onLost " + network.toString());
            }
            if (m.f248795e != null) {
                try {
                    m.f248795e.onLost(network);
                } catch (Exception e16) {
                    QLog.w(m.f248791a, 1, e16.getMessage(), e16);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9647);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f248794d = new AtomicInteger(0);
        f248795e = null;
        f248796f = new a();
    }

    m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void b(Context context) {
        ConnectivityManager connectivityManager;
        if (com.tencent.mobileqq.msf.core.quicksend.b.e() && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
            try {
                if (f248794d.compareAndSet(0, 1)) {
                    NetworkRequest.Builder builder = new NetworkRequest.Builder();
                    builder.addCapability(12);
                    builder.addTransportType(0);
                    NetworkRequest build = builder.build();
                    a aVar = f248796f;
                    connectivityManager.requestNetwork(build, aVar);
                    if (QLog.isColorLevel()) {
                        QLog.d(f248791a, 2, "requestMobileNetworkIfNot refCount=" + f248794d.get() + " mobileCallbackObj=" + Integer.toHexString(aVar.hashCode()));
                    }
                    a aVar2 = f248795e;
                    if (aVar2 != null) {
                        aVar2.a(0);
                    }
                }
            } catch (Throwable th5) {
                f248794d.set(0);
                QLog.i(f248791a, 1, th5.getMessage(), th5);
                th5.printStackTrace();
            }
        }
    }

    public static void c(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (f248794d.compareAndSet(1, 0)) {
                a aVar = f248796f;
                connectivityManager.unregisterNetworkCallback(aVar);
                a aVar2 = f248795e;
                if (aVar2 != null) {
                    aVar2.b(0);
                }
                if (QLog.isColorLevel()) {
                    QLog.i(f248791a, 2, "unregisterMobileNetworkCallback refCount=" + f248794d.get() + " mobileCallbackObj=" + Integer.toHexString(aVar.hashCode()));
                }
            }
        } catch (Throwable th5) {
            f248794d.set(0);
            QLog.i(f248791a, 1, th5.getMessage(), th5);
            th5.printStackTrace();
        }
    }

    public static void a(a aVar) {
        f248795e = aVar;
    }

    public static NetworkInfo a(Context context, Network network) {
        if (!com.tencent.mobileqq.msf.core.quicksend.b.e() || network == null) {
            return null;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                return connectivityManager.getNetworkInfo(network);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return null;
    }

    public static Network a(Context context) {
        Network[] allNetworks;
        if (!com.tencent.mobileqq.msf.core.quicksend.b.e()) {
            return null;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (allNetworks = connectivityManager.getAllNetworks()) != null && allNetworks.length > 0) {
                return allNetworks[0];
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return null;
    }

    public static NetworkInfo a(Context context, int i3) {
        Network[] allNetworks;
        if (!com.tencent.mobileqq.msf.core.quicksend.b.e()) {
            return null;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (allNetworks = connectivityManager.getAllNetworks()) != null) {
                for (Network network : allNetworks) {
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
                    if (networkCapabilities != null && NetworkMonitor.hasTransport(networkCapabilities, i3)) {
                        return connectivityManager.getNetworkInfo(network);
                    }
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return null;
    }

    public static Network b(Context context, int i3) {
        Network[] allNetworks;
        if (!com.tencent.mobileqq.msf.core.quicksend.b.e()) {
            return null;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (allNetworks = connectivityManager.getAllNetworks()) != null) {
                for (Network network : allNetworks) {
                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
                    if (a(context, network, i3) && networkInfo.isConnected()) {
                        return network;
                    }
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return null;
    }

    public static boolean a(Context context, Network network, int i3) {
        ConnectivityManager connectivityManager;
        NetworkCapabilities networkCapabilities;
        if (network == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(network)) == null) {
            return false;
        }
        return NetworkMonitor.hasTransport(networkCapabilities, i3);
    }
}
