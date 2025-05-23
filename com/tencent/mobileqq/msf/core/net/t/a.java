package com.tencent.mobileqq.msf.core.net.t;

import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static final int f249133a = 16;

    /* renamed from: b, reason: collision with root package name */
    private static final int f249134b = 2;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.core.net.t.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C8089a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f249135a;

        /* renamed from: b, reason: collision with root package name */
        public String f249136b;

        public C8089a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "AddrAndMask{addr='" + this.f249135a + "', mask='" + this.f249136b + "'}";
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static LinkAddress a(LinkProperties linkProperties, List<LinkAddress> list) {
        LinkAddress linkAddress = null;
        if (linkProperties == null || list == null) {
            return null;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        Iterator<LinkAddress> it = linkProperties.getLinkAddresses().iterator();
        while (it.hasNext()) {
            LinkAddress next = it.next();
            InetAddress address = next != null ? next.getAddress() : null;
            if (((address instanceof Inet6Address) && MsfCore.isIpv6()) || ((address instanceof Inet4Address) && !MsfCore.isIpv6())) {
                linkAddress = next;
                break;
            }
        }
        return linkAddress == null ? list.get(0) : linkAddress;
    }

    public static C8089a b() {
        List<LinkAddress> linkAddresses;
        LinkAddress a16;
        C8089a c8089a = new C8089a();
        try {
            LinkProperties a17 = a();
            if (a17 != null && (linkAddresses = a17.getLinkAddresses()) != null && linkAddresses.size() > 0 && (a16 = a(a17, linkAddresses)) != null) {
                InetAddress address = a16.getAddress();
                String hostAddress = a16.getAddress().getHostAddress();
                String valueOf = String.valueOf(a16.getPrefixLength());
                if (address instanceof Inet4Address) {
                    byte[] address2 = address.getAddress();
                    byte[] bArr = new byte[16];
                    if (address2.length < 16) {
                        for (int i3 = 0; i3 < address2.length; i3++) {
                            bArr[15 - i3] = address2[(address2.length - 1) - i3];
                        }
                    }
                    hostAddress = a(bArr);
                    QLog.d("MSF.C.QualityTestManager", 1, "ConvertV4ToV6: " + hostAddress);
                }
                c8089a.f249135a = hostAddress;
                c8089a.f249136b = valueOf;
                QLog.d("MSF.C.QualityTestManager", 1, "[obtainAddrAndMask] addr: ", hostAddress, ", mask: ", valueOf, ", originIp: ", a16.getAddress().getHostAddress());
            }
        } catch (Exception e16) {
            QLog.e("MSF.C.QualityTestManager", 1, "err:", e16);
        }
        QLog.d("MSF.C.QualityTestManager", 1, "[obtainAddrAndMask] ", c8089a);
        return c8089a;
    }

    private static LinkProperties a() {
        ConnectivityManager connectivityManager = (ConnectivityManager) BaseApplication.getContext().getApplicationContext().getSystemService("connectivity");
        try {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (NetworkMonitor.getType(connectivityManager.getNetworkInfo(activeNetwork)) == 1) {
                return connectivityManager.getLinkProperties(activeNetwork);
            }
        } catch (Exception e16) {
            QLog.e("MSF.C.QualityTestManager", 1, "[getLinkProperties] err1: ", e16);
        }
        return null;
    }

    static String a(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder(39);
        for (int i3 = 0; i3 < 8; i3++) {
            int i16 = i3 << 1;
            sb5.append(Integer.toHexString(((bArr[i16] << 8) & 65280) | (bArr[i16 + 1] & 255)));
            if (i3 < 7) {
                sb5.append(":");
            }
        }
        return sb5.toString();
    }
}
