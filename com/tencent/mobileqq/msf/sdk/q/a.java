package com.tencent.mobileqq.msf.sdk.q;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.msf.core.e0.i;
import com.tencent.mobileqq.msf.core.net.k;
import com.tencent.mobileqq.msf.core.p;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.msf.sdk.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: t, reason: collision with root package name */
    private static String f250657t = "MSF.D.NetworkProvider";

    /* renamed from: u, reason: collision with root package name */
    private static final Uri f250658u;

    /* renamed from: v, reason: collision with root package name */
    private static final byte f250659v = 0;

    /* renamed from: w, reason: collision with root package name */
    private static final byte f250660w = 1;

    /* renamed from: x, reason: collision with root package name */
    private static final byte f250661x = 2;

    /* renamed from: a, reason: collision with root package name */
    private volatile String f250662a;

    /* renamed from: b, reason: collision with root package name */
    private volatile String f250663b;

    /* renamed from: c, reason: collision with root package name */
    private volatile String f250664c;

    /* renamed from: d, reason: collision with root package name */
    private volatile String f250665d;

    /* renamed from: e, reason: collision with root package name */
    private volatile String f250666e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f250667f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f250668g;

    /* renamed from: h, reason: collision with root package name */
    private int f250669h;

    /* renamed from: i, reason: collision with root package name */
    private volatile int f250670i;

    /* renamed from: j, reason: collision with root package name */
    private volatile int f250671j;

    /* renamed from: k, reason: collision with root package name */
    private volatile int f250672k;

    /* renamed from: l, reason: collision with root package name */
    private volatile int f250673l;

    /* renamed from: m, reason: collision with root package name */
    private AtomicBoolean f250674m;

    /* renamed from: n, reason: collision with root package name */
    private NetworkInfo f250675n;

    /* renamed from: o, reason: collision with root package name */
    private INetInfoHandler f250676o;

    /* renamed from: p, reason: collision with root package name */
    private INetEventHandler f250677p;

    /* renamed from: q, reason: collision with root package name */
    private c f250678q;

    /* renamed from: r, reason: collision with root package name */
    private b f250679r;

    /* renamed from: s, reason: collision with root package name */
    private final String[] f250680s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.sdk.q.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class RunnableC8107a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f250681a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f250682b;

        RunnableC8107a(int i3, int i16) {
            this.f250681a = i3;
            this.f250682b = i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                try {
                    a.this.a(this.f250681a, this.f250682b);
                    return;
                } catch (Throwable th5) {
                    long id5 = Thread.currentThread().getId();
                    com.tencent.mobileqq.msf.sdk.b.a(id5, Thread.currentThread().getName(), th5);
                    QLog.e(a.f250657t, 1, Thread.currentThread().getName() + "(" + id5 + ") notifyNetChanged error, ", th5);
                    return;
                }
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface c {
        void a();

        void a(int i3);

        void a(String str, String str2);

        void b();

        void b(String str, String str2);

        void c();

        void d();

        void e();

        void f();

        void g();
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class d implements c {
        static IPatchRedirector $redirector_;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.q.a.c
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this);
        }

        @Override // com.tencent.mobileqq.msf.sdk.q.a.c
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                return;
            }
            iPatchRedirector.redirect((short) 9, (Object) this);
        }

        @Override // com.tencent.mobileqq.msf.sdk.q.a.c
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.q.a.c
        public void d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.q.a.c
        public void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.q.a.c
        public void f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.q.a.c
        public void g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.q.a.c
        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }

        @Override // com.tencent.mobileqq.msf.sdk.q.a.c
        public void b(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return;
            }
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
        }

        @Override // com.tencent.mobileqq.msf.sdk.q.a.c
        public void a(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15068);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f250658u = Uri.parse("content://telephony/carriers/preferapn");
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f250662a = "";
        this.f250663b = "";
        this.f250664c = "";
        this.f250665d = "";
        this.f250666e = "";
        this.f250668g = null;
        this.f250669h = -1;
        this.f250670i = 0;
        this.f250671j = 0;
        this.f250672k = 0;
        this.f250673l = 0;
        this.f250674m = new AtomicBoolean(false);
        this.f250675n = null;
        this.f250676o = null;
        this.f250677p = null;
        this.f250678q = null;
        this.f250679r = null;
        this.f250680s = new String[]{"80000967", "23066699", "9948938", "56928460"};
    }

    public static String a(int i3) {
        return i3 != 0 ? i3 != 1 ? (i3 == 2 || i3 == 3) ? "WiFi" : "UNKNOWN" : "MOBILE" : "NONE";
    }

    private void d(boolean z16) {
        this.f250674m.set(z16);
    }

    private void o() {
        int i3 = this.f250671j;
        NetworkInfo networkInfo = this.f250675n;
        if (networkInfo != null) {
            i3 = NetworkMonitor.getSubtype(networkInfo);
        } else {
            try {
                i3 = NetworkMonitor.getNetworkType((TelephonyManager) BaseApplication.getContext().getSystemService("phone"));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        this.f250671j = m.c(i3);
        b(this.f250672k | 1);
    }

    private void p() {
        b(this.f250672k & (-2));
    }

    private void q() {
        b(this.f250672k | 4);
    }

    private void r() {
        b(this.f250672k & (-5));
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0093, code lost:
    
        if (r0 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009c, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009a, code lost:
    
        if (r0 == null) goto L33;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void s() {
        if (!p.a()) {
            QLog.d(f250657t, 1, "updateAPN not allowed");
            return;
        }
        long id5 = Thread.currentThread().getId();
        QLog.d(f250657t, 1, Thread.currentThread().getName() + "(" + id5 + ") start updateAPN");
        this.f250663b = this.f250662a;
        ConnectivityManager connectivityManager = (ConnectivityManager) BaseApplication.getContext().getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
        if (networkInfo == null) {
            try {
                networkInfo = connectivityManager.getNetworkInfo(50);
            } catch (Exception e16) {
                QLog.d(f250657t, 1, "get currentAPN error " + e16);
            }
        }
        if (networkInfo != null) {
            this.f250662a = NetworkMonitor.netGetExInfo(networkInfo);
        } else {
            Cursor cursor = null;
            try {
                cursor = ContactsMonitor.query(BaseApplication.getContext().getContentResolver(), f250658u, null, null, null, null);
                while (cursor != null) {
                    if (!cursor.moveToNext()) {
                        break;
                    } else {
                        this.f250662a = cursor.getString(cursor.getColumnIndex("apn"));
                    }
                }
            } catch (Throwable th5) {
                try {
                    th5.printStackTrace();
                } catch (Throwable th6) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th6;
                }
            }
        }
        QLog.d(f250657t, 1, Thread.currentThread().getName() + "(" + id5 + ") updateAPN end, currentApn = " + this.f250662a);
    }

    private void t() {
        this.f250670i = k.a(this.f250675n);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void u() {
        int i3;
        InetAddress inetAddress;
        if (QLog.isColorLevel()) {
            QLog.d(f250657t, 2, "updateNetIpFamily cur activeNetIpFamily=" + this.f250673l);
        }
        int i16 = 0;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) BaseApplication.getContext().getSystemService("connectivity");
            LinkProperties linkProperties = connectivityManager.getLinkProperties(connectivityManager.getActiveNetwork());
            if (linkProperties != null) {
                i3 = 0;
                for (LinkAddress linkAddress : linkProperties.getLinkAddresses()) {
                    try {
                        if (linkAddress != null) {
                            inetAddress = linkAddress.getAddress();
                        } else {
                            inetAddress = null;
                        }
                        i3 |= a(inetAddress);
                    } catch (Throwable unused) {
                        i16 = i3;
                        i3 = i16;
                        i16 = 1;
                        if (i16 != 0) {
                        }
                    }
                }
            } else {
                i3 = 0;
            }
        } catch (Throwable unused2) {
        }
        if (i16 != 0) {
            if (this.f250673l != i3) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250657t, 2, "updateNetIpFamily new1 activeNetIpFamily=" + i3);
                }
                this.f250673l = i3;
                return;
            }
            return;
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkMonitor.getNetworkInterfaces();
            while (networkInterfaces != null) {
                if (!networkInterfaces.hasMoreElements()) {
                    break;
                }
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement != null && nextElement.isUp()) {
                    Enumeration<InetAddress> inetAddresses = NetworkMonitor.getInetAddresses(nextElement);
                    while (inetAddresses != null && inetAddresses.hasMoreElements()) {
                        i3 |= a(inetAddresses.nextElement());
                    }
                }
            }
        } catch (SocketException unused3) {
        }
        if (this.f250673l != i3) {
            if (QLog.isColorLevel()) {
                QLog.d(f250657t, 2, "updateNetIpFamily new2 activeNetIpFamily=" + i3);
            }
            this.f250673l = i3;
        }
    }

    private void v() {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        if (!p.a()) {
            QLog.d(f250657t, 1, "updateSSID not allowed");
            return;
        }
        if (com.tencent.mobileqq.msf.core.x.d.F().booleanValue()) {
            return;
        }
        this.f250665d = this.f250666e;
        long id5 = Thread.currentThread().getId();
        QLog.d(f250657t, 1, Thread.currentThread().getName() + "(" + id5 + ") start updateSSID");
        String str = null;
        if (Build.VERSION.SDK_INT == 27) {
            try {
                connectivityManager = (ConnectivityManager) BaseApplication.getContext().getSystemService("connectivity");
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250657t, 2, th5, new Object[0]);
                }
                connectivityManager = null;
            }
            if (connectivityManager != null && (networkInfo = connectivityManager.getNetworkInfo(1)) != null && NetworkMonitor.netGetExInfo(networkInfo) != null) {
                str = NetworkMonitor.netGetExInfo(networkInfo).replace("\"", "");
            }
        } else {
            try {
                wifiManager = (WifiManager) BaseApplication.getContext().getApplicationContext().getSystemService("wifi");
            } catch (Throwable th6) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250657t, 2, th6, new Object[0]);
                }
                wifiManager = null;
            }
            if (wifiManager != null && (connectionInfo = LocationMonitor.getConnectionInfo(wifiManager)) != null && NetworkMonitor.getSSID(connectionInfo) != null) {
                str = NetworkMonitor.getSSID(connectionInfo).replace("\"", "");
            }
        }
        if (str != null) {
            this.f250666e = str;
        }
        QLog.d(f250657t, 1, Thread.currentThread().getName() + "(" + id5 + ") checknetinfo wifi get ssid=" + str + ", current ssid=" + this.f250666e);
    }

    private void w() {
        b(this.f250672k | 2);
    }

    private void x() {
        b(this.f250672k & (-3));
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) ? this.f250672k : ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? n() ? this.f250667f ? 3 : 2 : l() ? 1 : 0 : ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
    }

    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.f250666e;
    }

    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.f250663b;
    }

    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.f250665d;
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.f250670i;
    }

    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.f250671j;
    }

    public NetworkInfo j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (NetworkInfo) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.f250675n;
    }

    public String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.f250664c;
    }

    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (this.f250672k == 1) {
            return true;
        }
        return false;
    }

    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.f250674m.get();
    }

    public boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.f250672k != 2 && this.f250672k != 3) {
            return false;
        }
        return true;
    }

    public String b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this, z16);
        }
        if (z16) {
            s();
        }
        return this.f250662a;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) ? this.f250662a : (String) iPatchRedirector.redirect((short) 21, (Object) this);
    }

    private void b(int i3) {
        if (this.f250672k == i3) {
            return;
        }
        if (i3 > 0) {
            d(true);
        } else {
            d(false);
        }
        QLog.d(f250657t, 1, "netchange " + a(this.f250672k) + " to " + a(i3));
        this.f250669h = -1;
        if (i3 == 1) {
            if (this.f250672k != 0 && this.f250672k != -2) {
                if (this.f250672k != 2 && this.f250672k != 3) {
                    if (this.f250672k <= 7) {
                        this.f250669h = 6;
                    }
                } else {
                    this.f250669h = 1;
                }
            } else {
                this.f250669h = 0;
            }
        } else if (i3 == 2 || i3 == 3) {
            if (this.f250672k != 0 && this.f250672k != -2) {
                if (this.f250672k == 1) {
                    this.f250669h = 3;
                } else if (this.f250672k <= 7) {
                    this.f250669h = 7;
                }
            } else {
                this.f250669h = 2;
            }
        } else if (i3 > 3 && i3 <= 7) {
            if (this.f250672k != 0 && this.f250672k != -2) {
                if (this.f250672k == 1) {
                    this.f250669h = 9;
                } else if (this.f250672k == 2 || this.f250672k == 3) {
                    this.f250669h = 10;
                }
            } else {
                this.f250669h = 8;
            }
        } else if (this.f250672k == 1) {
            this.f250669h = 4;
        } else if (this.f250672k != 2 && this.f250672k != 3) {
            if (this.f250672k <= 7) {
                this.f250669h = 11;
            }
        } else {
            this.f250669h = 5;
        }
        this.f250672k = i3;
    }

    public void a(INetInfoHandler iNetInfoHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.f250676o = iNetInfoHandler;
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iNetInfoHandler);
        }
    }

    public String c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this, z16);
        }
        if (z16) {
            v();
        }
        return this.f250666e;
    }

    public void a(INetEventHandler iNetEventHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f250677p = iNetEventHandler;
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iNetEventHandler);
        }
    }

    public void a(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.f250678q = cVar;
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar);
        }
    }

    public void a(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            this.f250679r = bVar;
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar);
        }
    }

    public void a(Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            this.f250668g = handler;
        } else {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) handler);
        }
    }

    public int a(boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this, z16)).intValue();
        }
        if (z16) {
            u();
        }
        try {
            String i3 = i.i();
            if (!TextUtils.isEmpty(i3)) {
                z17 = false;
                for (String str : this.f250680s) {
                    if (i3.equals(str)) {
                        break;
                    }
                }
            }
        } catch (RuntimeException e16) {
            QLog.d(f250657t, 2, "getActiveNetIpFamily " + e16);
        }
        z17 = true;
        if (z17) {
            return this.f250673l;
        }
        return 1;
    }

    public synchronized void a(Context context, NetworkInfo networkInfo) {
        NetworkInfo networkInfo2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) context, (Object) networkInfo);
            return;
        }
        try {
            networkInfo2 = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e16) {
            QLog.w(f250657t, 1, e16.getMessage(), e16.getCause());
            networkInfo2 = null;
        }
        a(context, networkInfo2, networkInfo);
    }

    private void a(Context context, NetworkInfo networkInfo, NetworkInfo networkInfo2) {
        c cVar = this.f250678q;
        if (cVar != null) {
            cVar.c();
        }
        this.f250675n = networkInfo;
        int i3 = this.f250672k;
        a(this.f250675n, networkInfo2);
        int i16 = this.f250669h;
        this.f250669h = -1;
        Handler handler = this.f250668g;
        if (handler == null) {
            a(i16, i3);
        } else if (i16 != -1) {
            handler.post(new RunnableC8107a(i16, i3));
        }
        c cVar2 = this.f250678q;
        if (cVar2 != null) {
            cVar2.g();
        }
    }

    private String a(NetworkInfo networkInfo) {
        String sb5;
        if (networkInfo != null) {
            synchronized (networkInfo) {
                try {
                    try {
                        StringBuilder sb6 = new StringBuilder("NetworkInfo: ");
                        sb6.append("type: ");
                        sb6.append(NetworkMonitor.getTypeName(networkInfo));
                        sb6.append("[");
                        sb6.append(networkInfo.getSubtypeName());
                        sb6.append("], state: ");
                        sb6.append(networkInfo.getState());
                        sb6.append("/");
                        sb6.append(networkInfo.getDetailedState());
                        sb6.append(", reason: ");
                        sb6.append(networkInfo.getReason() == null ? "(unspecified)" : networkInfo.getReason());
                        sb6.append(", roaming: ");
                        sb6.append(networkInfo.isRoaming());
                        sb6.append(", failover: ");
                        sb6.append(networkInfo.isFailover());
                        sb6.append(", isAvailable: ");
                        sb6.append(networkInfo.isAvailable());
                        sb6.append(", isConnectedToProvisioningNetwork: ");
                        sb6.append(networkInfo.isConnectedOrConnecting());
                        sb5 = sb6.toString();
                    } catch (Exception e16) {
                        QLog.d(f250657t, 1, "buildLogString error, ", e16);
                    }
                } catch (Throwable th5) {
                    throw th5;
                }
            }
            return sb5;
        }
        return "";
    }

    public boolean b(NetworkInfo networkInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 25)) ? NetworkMonitor.getType(networkInfo) == 0 || 50 == NetworkMonitor.getType(networkInfo) : ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) networkInfo)).booleanValue();
    }

    private void a(NetworkInfo networkInfo, NetworkInfo networkInfo2) {
        MsfCore msfCore;
        j jVar;
        j.e eVar;
        if (networkInfo == null) {
            if (networkInfo2 != null) {
                QLog.d(f250657t, 1, "currentAPN:" + this.f250662a + ". ActiveNetInfo: " + networkInfo + ". ExtraNetInfo: " + networkInfo2);
                if (networkInfo2.getDetailedState() == NetworkInfo.DetailedState.DISCONNECTED || networkInfo2.getDetailedState() == NetworkInfo.DetailedState.FAILED || networkInfo2.getDetailedState() == NetworkInfo.DetailedState.IDLE || networkInfo2.getDetailedState() == NetworkInfo.DetailedState.SUSPENDED) {
                    if (1 == NetworkMonitor.getType(networkInfo2)) {
                        p();
                        x();
                        return;
                    } else {
                        if (b(networkInfo2)) {
                            p();
                            return;
                        }
                        p();
                        x();
                        r();
                        return;
                    }
                }
                return;
            }
            return;
        }
        String typeName = NetworkMonitor.getTypeName(networkInfo);
        try {
            this.f250664c = networkInfo.getSubtypeName();
        } catch (Exception e16) {
            QLog.d(f250657t, 1, "get subtypeName error " + e16);
        }
        if (typeName == null) {
            QLog.d(f250657t, 1, "subtype name is null, igonre");
            return;
        }
        if (typeName.toLowerCase().contains("mobile_mms")) {
            QLog.d(f250657t, 1, "checkConnInfo current typeName: mobile_mms ignore.");
            return;
        }
        QLog.i(f250657t, 1, "refresh currentAPN:" + this.f250662a + ". received networkInfo: " + networkInfo.getDetailedState() + " :" + a(networkInfo) + ". ExtraNetInfo: " + a(networkInfo2));
        if (networkInfo.getDetailedState() == NetworkInfo.DetailedState.CONNECTED) {
            if (1 == NetworkMonitor.getType(networkInfo)) {
                r();
                w();
                return;
            }
            if (b(networkInfo)) {
                r();
                x();
                o();
                return;
            } else {
                q();
                QLog.d(f250657t, 1, "Unexcepted activeNetInfo type:" + NetworkMonitor.getType(networkInfo));
                return;
            }
        }
        if (networkInfo.getDetailedState() != NetworkInfo.DetailedState.DISCONNECTED && networkInfo.getDetailedState() != NetworkInfo.DetailedState.FAILED && networkInfo.getDetailedState() != NetworkInfo.DetailedState.IDLE && networkInfo.getDetailedState() != NetworkInfo.DetailedState.SUSPENDED) {
            if (networkInfo.getDetailedState() != NetworkInfo.DetailedState.BLOCKED || (msfCore = MsfCore.sCore) == null || (jVar = msfCore.statReporter) == null || (eVar = jVar.f247848b) == null || eVar.f247866g != 0) {
                return;
            }
            eVar.f247866g = System.currentTimeMillis();
            QLog.d(f250657t, 1, "MSF_Alive_Log on netWork refresh netWorkFailTime =", Long.valueOf(System.currentTimeMillis()));
            return;
        }
        if (1 == NetworkMonitor.getType(networkInfo)) {
            x();
        } else if (b(networkInfo)) {
            p();
        } else {
            r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3, int i16) {
        c cVar;
        c cVar2;
        if (i3 == -1) {
            return;
        }
        try {
            if (n()) {
                v();
                if (!a(this.f250665d, this.f250666e) && (cVar2 = this.f250678q) != null) {
                    cVar2.b(this.f250665d, this.f250666e);
                }
                c cVar3 = this.f250678q;
                if (cVar3 != null) {
                    cVar3.a(i16);
                }
            } else if (l()) {
                t();
                s();
                if (!a(this.f250663b, this.f250662a) && (cVar = this.f250678q) != null) {
                    cVar.a(this.f250663b, this.f250662a);
                }
                c cVar4 = this.f250678q;
                if (cVar4 != null) {
                    cVar4.d();
                }
            } else {
                c cVar5 = this.f250678q;
                if (cVar5 != null) {
                    cVar5.f();
                }
            }
        } catch (Throwable th5) {
            QLog.w(f250657t, 1, th5.getMessage(), th5);
            th5.printStackTrace();
        }
        try {
            INetInfoHandler iNetInfoHandler = this.f250676o;
            if (iNetInfoHandler != null) {
                if (i3 != 0 && i3 != 6) {
                    if (i3 == 1) {
                        iNetInfoHandler.onNetWifi2Mobile(this.f250662a);
                    } else {
                        if (i3 != 2 && i3 != 7) {
                            if (i3 == 3) {
                                iNetInfoHandler.onNetMobile2Wifi(this.f250666e);
                            } else if (i3 == 4) {
                                iNetInfoHandler.onNetMobile2None();
                            } else if (i3 == 5) {
                                iNetInfoHandler.onNetWifi2None();
                            }
                        }
                        iNetInfoHandler.onNetNone2Wifi(this.f250666e);
                    }
                }
                iNetInfoHandler.onNetNone2Mobile(this.f250662a);
            }
            INetEventHandler iNetEventHandler = this.f250677p;
            if (iNetEventHandler != null) {
                if (i3 != 4 && i3 != 5 && i3 != 11) {
                    iNetEventHandler.onNetChangeEvent(true);
                }
                iNetEventHandler.onNetChangeEvent(false);
            }
        } catch (Exception e16) {
            QLog.w(f250657t, 1, e16.getMessage(), e16);
            e16.printStackTrace();
        }
        u();
    }

    public static boolean a(String str, String str2) {
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 != null) {
            return str2.equals(str);
        }
        return str == null && str2 == null;
    }

    private int a(InetAddress inetAddress) {
        if (inetAddress == null || inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress()) {
            return 0;
        }
        if (inetAddress instanceof Inet6Address) {
            return 2;
        }
        return inetAddress instanceof Inet4Address ? 1 : 0;
    }
}
