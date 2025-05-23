package com.tencent.mobileqq.msf.sdk;

import android.content.Context;
import android.net.NetworkInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes15.dex */
public class AppNetConnInfo {
    static IPatchRedirector $redirector_ = null;
    public static final int IPV4 = 1;
    public static final int IPV4V6 = 3;
    public static final int IPV6 = 2;
    public static final int IP_NONE = 0;
    public static final int MOBILE_2G = 1;
    public static final int MOBILE_3G = 2;
    public static final int MOBILE_4G = 3;
    public static final int MOBILE_5G = 4;
    public static final int MOBILE_NONE = -1;
    public static final int MOBILE_UNKNOWN = 0;
    public static final int NET_MOBILE = 0;
    public static final int NET_NONE = -1;
    public static final int NET_WIFI = 1;
    public static final int NET_WIFI_NEEDAUTH = 2;
    public static final int WEAK_NET_REASON_BN_BC = 4;
    public static final int WEAK_NET_REASON_MOBILE_CONN = 64;
    public static final int WEAK_NET_REASON_PING = 2;
    public static final int WEAK_NET_REASON_QUICK_SEND = 32;
    public static final int WEAK_NET_REASON_RTTM = 8;
    public static final int WEAK_NET_REASON_WIFI_CONN = 1;
    public static final int WEAK_NET_REASON_WIFI_SIGNAL = 16;
    private static b impl;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13648);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            impl = new b();
        }
    }

    public AppNetConnInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void checkNetEvent() {
        impl.a((NetworkInfo) null, false);
    }

    public static int getConnInfo() {
        impl.k();
        return impl.b() - 1;
    }

    public static String getCurrentAPN() {
        impl.k();
        return impl.c();
    }

    public static b getImpl() {
        return impl;
    }

    public static int getMobileInfo() {
        impl.k();
        return impl.d();
    }

    public static NetworkInfo getRecentNetworkInfo() {
        impl.k();
        return impl.f();
    }

    public static String getSubtypeName() {
        impl.k();
        return impl.e().k();
    }

    public static int getSystemNetworkType() {
        impl.k();
        return impl.g();
    }

    public static boolean isMobileConn() {
        impl.k();
        return impl.h();
    }

    public static boolean isNetSupport() {
        impl.k();
        return impl.i();
    }

    public static boolean isWifiConn() {
        impl.k();
        return impl.j();
    }

    public static void registerConnectionChangeReceiver(Context context, INetInfoHandler iNetInfoHandler) {
        impl.k();
        impl.a(context, iNetInfoHandler);
    }

    public static void registerNetChangeReceiver(Context context, INetEventHandler iNetEventHandler) {
        impl.k();
        impl.a(context, iNetEventHandler);
    }

    public static void registerWeakNetStatusHandler(Context context, IWeakNetStatusHandler iWeakNetStatusHandler) {
        impl.a(context, iWeakNetStatusHandler);
    }

    public static boolean unRegisterWeakNetStatusHandler(IWeakNetStatusHandler iWeakNetStatusHandler) {
        return impl.a(iWeakNetStatusHandler);
    }

    public static boolean unregisterNetEventHandler(INetEventHandler iNetEventHandler) {
        impl.k();
        return impl.a(iNetEventHandler);
    }

    public static boolean unregisterNetInfoHandler(INetInfoHandler iNetInfoHandler) {
        impl.k();
        return impl.a(iNetInfoHandler);
    }
}
