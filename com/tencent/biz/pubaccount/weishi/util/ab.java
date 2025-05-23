package com.tencent.biz.pubaccount.weishi.util;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0016\u0010\u0010\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/util/ab;", "", "Landroid/content/Context;", "context", "", "f", "e", "", "d", "", "c", "b", "", "Z", "hasRegisterNetChangeReceiver", "I", "recentWifiIpAddress", "Ljava/lang/String;", "localAddress", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class ab {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean hasRegisterNetChangeReceiver;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int recentWifiIpAddress;

    /* renamed from: a, reason: collision with root package name */
    public static final ab f81687a = new ab();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static String localAddress = "";

    ab() {
    }

    private final String d() {
        String str = "";
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkMonitor.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return "";
            }
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                NetworkInterface networkInterface = nextElement instanceof NetworkInterface ? nextElement : null;
                if (networkInterface != null) {
                    Enumeration<InetAddress> inetAddresses = NetworkMonitor.getInetAddresses(networkInterface);
                    Intrinsics.checkNotNullExpressionValue(inetAddresses, "networkInterface.inetAddresses");
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        Intrinsics.checkNotNull(nextElement2, "null cannot be cast to non-null type java.net.InetAddress");
                        InetAddress inetAddress = nextElement2;
                        try {
                            if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address) && inetAddress.getHostAddress() != null && !Intrinsics.areEqual(inetAddress.getHostAddress(), "null") && InetAddress.getByName(inetAddress.getHostAddress()) != null) {
                                String hostAddress = inetAddress.getHostAddress();
                                Intrinsics.checkNotNullExpressionValue(hostAddress, "inetAddress.getHostAddress()");
                                int length = hostAddress.length() - 1;
                                int i3 = 0;
                                boolean z16 = false;
                                while (i3 <= length) {
                                    boolean z17 = Intrinsics.compare((int) hostAddress.charAt(!z16 ? i3 : length), 32) <= 0;
                                    if (z16) {
                                        if (!z17) {
                                            break;
                                        }
                                        length--;
                                    } else if (z17) {
                                        i3++;
                                    } else {
                                        z16 = true;
                                    }
                                }
                                return hostAddress.subSequence(i3, length + 1).toString();
                            }
                        } catch (UnknownHostException e16) {
                            e16.printStackTrace();
                        }
                    }
                }
            }
            return str;
        } catch (SocketException e17) {
            LogUtils.e(e17);
            return str;
        }
    }

    private final void e(Context context) {
        Object systemService = context.getApplicationContext().getSystemService("wifi");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        WifiInfo connectionInfo = LocationMonitor.getConnectionInfo((WifiManager) systemService);
        if (connectionInfo != null) {
            recentWifiIpAddress = NetworkMonitor.getIpAddress(connectionInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Context context, boolean z16) {
        x.f("WSNetHelper", "onNetChangeEvent isNetEffective:" + z16);
        if (z16) {
            f81687a.e(context);
        } else {
            recentWifiIpAddress = 0;
        }
        f81687a.d();
    }

    public final String b(Context context) {
        f(context);
        return localAddress;
    }

    public final int c(Context context) {
        f(context);
        return recentWifiIpAddress;
    }

    private final void f(final Context context) {
        if (context == null || hasRegisterNetChangeReceiver) {
            return;
        }
        hasRegisterNetChangeReceiver = true;
        AppNetConnInfo.registerNetChangeReceiver(context, new INetEventHandler() { // from class: com.tencent.biz.pubaccount.weishi.util.aa
            @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
            public final void onNetChangeEvent(boolean z16) {
                ab.g(context, z16);
            }
        });
        e(context);
        localAddress = d();
    }
}
