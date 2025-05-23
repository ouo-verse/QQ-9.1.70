package com.tencent.turingcam;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.net.InetAddress;
import java.util.List;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes27.dex */
public class kWj12 {
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

    public static String a() {
        Context context;
        Context context2;
        Long valueOf;
        Long valueOf2;
        synchronized (eh5ma.class) {
            context = eh5ma.f382207a;
        }
        Network activeNetwork = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetwork();
        if (activeNetwork != null) {
            try {
                synchronized (eh5ma.class) {
                    context2 = eh5ma.f382207a;
                }
                ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                if (networkCapabilities != null) {
                    StringBuilder sb5 = new StringBuilder();
                    Object a16 = A0PGF.a(networkCapabilities.getClass(), "mTransportTypes", networkCapabilities);
                    long j3 = 0;
                    if (a16 instanceof Long) {
                        valueOf = (Long) a16;
                    } else {
                        long j16 = 0;
                        for (int i3 = 0; i3 < 64; i3++) {
                            if (NetworkMonitor.hasTransport(networkCapabilities, i3)) {
                                j16 |= 1 << i3;
                            }
                        }
                        valueOf = Long.valueOf(j16);
                    }
                    sb5.append(valueOf);
                    sb5.append(",");
                    Object a17 = A0PGF.a(networkCapabilities.getClass(), "mNetworkCapabilities", networkCapabilities);
                    if (a17 instanceof Long) {
                        valueOf2 = (Long) a17;
                    } else {
                        for (int i16 = 0; i16 < 64; i16++) {
                            if (networkCapabilities.hasCapability(i16)) {
                                j3 |= 1 << i16;
                            }
                        }
                        valueOf2 = Long.valueOf(j3);
                    }
                    sb5.append(valueOf2);
                    LinkProperties linkProperties = connectivityManager.getLinkProperties(activeNetwork);
                    if (linkProperties == null) {
                        return sb5.toString();
                    }
                    String interfaceName = linkProperties.getInterfaceName();
                    Random random = Ckq8l.f381753a;
                    if (interfaceName == null) {
                        interfaceName = "";
                    }
                    String replace = interfaceName.replace(",", "").replace(";", "");
                    sb5.append(",");
                    sb5.append(replace);
                    sb5.append(",");
                    List<LinkAddress> linkAddresses = linkProperties.getLinkAddresses();
                    if (!v0KaV.a(linkAddresses)) {
                        for (int i17 = 0; i17 < linkAddresses.size(); i17++) {
                            sb5.append(linkAddresses.get(i17).getAddress().getHostAddress());
                            if (i17 != linkAddresses.size() - 1) {
                                sb5.append(";");
                            }
                        }
                    }
                    sb5.append(",");
                    List<InetAddress> dnsServers = linkProperties.getDnsServers();
                    if (!v0KaV.a(dnsServers)) {
                        for (int i18 = 0; i18 < dnsServers.size(); i18++) {
                            sb5.append(dnsServers.get(i18).getHostAddress());
                            if (i18 != dnsServers.size() - 1) {
                                sb5.append(";");
                            }
                        }
                    }
                    return sb5.toString();
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
