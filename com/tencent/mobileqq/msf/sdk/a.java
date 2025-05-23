package com.tencent.mobileqq.msf.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
@Deprecated
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_ = null;
    private static boolean A = false;
    private static long B = 0;
    public static boolean C = false;
    public static int D = 0;
    public static String E = null;
    public static String F = null;
    public static String G = null;
    private static Uri H = null;
    static BroadcastReceiver I = null;
    private static final byte J = 0;
    private static final byte K = 1;
    private static final byte L = 2;

    /* renamed from: a, reason: collision with root package name */
    private static String f250477a = "MSF.D.AppNetInfoImpl";

    /* renamed from: b, reason: collision with root package name */
    private static final String f250478b = "https://3gimg.qq.com/ping.html";

    /* renamed from: c, reason: collision with root package name */
    private static int f250479c = 0;

    /* renamed from: d, reason: collision with root package name */
    private static AtomicBoolean f250480d = null;

    /* renamed from: e, reason: collision with root package name */
    static List<INetInfoHandler> f250481e = null;

    /* renamed from: f, reason: collision with root package name */
    static List<INetEventHandler> f250482f = null;

    /* renamed from: g, reason: collision with root package name */
    static volatile boolean f250483g = false;

    /* renamed from: h, reason: collision with root package name */
    static b f250484h = null;

    /* renamed from: i, reason: collision with root package name */
    private static final int f250485i = 1;

    /* renamed from: j, reason: collision with root package name */
    private static final int f250486j = 2;

    /* renamed from: k, reason: collision with root package name */
    private static final int f250487k = 3;

    /* renamed from: l, reason: collision with root package name */
    private static final int f250488l = 4;

    /* renamed from: m, reason: collision with root package name */
    private static final int f250489m = 5;

    /* renamed from: n, reason: collision with root package name */
    static Handler f250490n = null;

    /* renamed from: o, reason: collision with root package name */
    static NetworkInfo f250491o = null;

    /* renamed from: p, reason: collision with root package name */
    private static final int f250492p = 16;

    /* renamed from: q, reason: collision with root package name */
    private static final int f250493q = 17;

    /* renamed from: r, reason: collision with root package name */
    private static final int f250494r = 18;

    /* renamed from: s, reason: collision with root package name */
    private static final int f250495s = 19;

    /* renamed from: t, reason: collision with root package name */
    public static final int f250496t = 20;

    /* renamed from: u, reason: collision with root package name */
    private static final int f250497u = 10;

    /* renamed from: v, reason: collision with root package name */
    private static final int f250498v = 11;

    /* renamed from: w, reason: collision with root package name */
    private static final int f250499w = 12;

    /* renamed from: x, reason: collision with root package name */
    private static final int f250500x = 14;

    /* renamed from: y, reason: collision with root package name */
    private static final int f250501y = 15;

    /* renamed from: z, reason: collision with root package name */
    private static int f250502z;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.sdk.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class C8102a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.msf.sdk.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        class RunnableC8103a implements Runnable {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Intent f250503a;

            RunnableC8103a(Intent intent) {
                this.f250503a = intent;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) C8102a.this, (Object) intent);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    try {
                        QLog.d(a.f250477a, 1, "receive broadcast " + this.f250503a);
                        a.a(BaseApplication.getContext(), (NetworkInfo) this.f250503a.getParcelableExtra("networkInfo"));
                        a.f250490n.sendEmptyMessage(3);
                        return;
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d(a.f250477a, 2, e16.toString(), e16);
                            return;
                        }
                        return;
                    }
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        C8102a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            } else {
                a.a(new RunnableC8103a(intent));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b extends BaseHandlerThread implements Handler.Callback {
        static IPatchRedirector $redirector_;

        public b(String str) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            int i3 = message.what;
            try {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            int i16 = a.f250502z;
                            if (i16 == -1) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(a.f250477a, 2, "no change in connectivity");
                                }
                                return false;
                            }
                            if (a.m()) {
                                a.f();
                            } else if (a.o()) {
                                a.i();
                            }
                            for (INetInfoHandler iNetInfoHandler : a.f250481e) {
                                if (iNetInfoHandler != null) {
                                    if (i16 != 0 && i16 != 6) {
                                        if (i16 == 1) {
                                            iNetInfoHandler.onNetWifi2Mobile(a.E);
                                        } else {
                                            if (i16 != 2 && i16 != 7) {
                                                if (i16 == 3) {
                                                    iNetInfoHandler.onNetMobile2Wifi(a.G);
                                                } else if (i16 == 4) {
                                                    iNetInfoHandler.onNetMobile2None();
                                                } else if (i16 == 5) {
                                                    iNetInfoHandler.onNetWifi2None();
                                                }
                                            }
                                            iNetInfoHandler.onNetNone2Wifi(a.G);
                                        }
                                    }
                                    iNetInfoHandler.onNetNone2Mobile(a.E);
                                }
                            }
                            for (INetEventHandler iNetEventHandler : a.f250482f) {
                                if (iNetEventHandler != null) {
                                    if (i16 != 4 && i16 != 5 && i16 != 11) {
                                        z16 = true;
                                        iNetEventHandler.onNetChangeEvent(z16);
                                    }
                                    z16 = false;
                                    iNetEventHandler.onNetChangeEvent(z16);
                                }
                            }
                            if (a.m()) {
                                NetworkInfo networkInfo = a.f250491o;
                                if (networkInfo != null && networkInfo.isAvailable()) {
                                    int type = NetworkMonitor.getType(a.f250491o);
                                    if (type != 0 && type != 2 && type != 3 && type != 4 && type != 5 && type != 14 && type != 15) {
                                        switch (type) {
                                            case 10:
                                            case 11:
                                            case 12:
                                                break;
                                            default:
                                                a.D = -1;
                                                QLog.d(a.f250477a, 1, "Unexcepted Mobile Type:" + type);
                                                break;
                                        }
                                    }
                                    TelephonyManager telephonyManager = (TelephonyManager) BaseApplication.getContext().getSystemService("phone");
                                    int a16 = c.a(telephonyManager, a.f250491o);
                                    switch (a16) {
                                        case 0:
                                        case 1:
                                        case 2:
                                        case 4:
                                        case 7:
                                        case 11:
                                        case 16:
                                            a.D = 1;
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
                                        case 17:
                                            a.D = 2;
                                            break;
                                        case 13:
                                        case 18:
                                        case 19:
                                            a.D = 3;
                                            break;
                                        case 20:
                                            a.D = 4;
                                            break;
                                        default:
                                            a.D = c.a(telephonyManager, a16);
                                            QLog.d(a.f250477a, 1, "Unexcepted networkType:" + a16 + " ,mobileInfo:" + a.D);
                                            break;
                                    }
                                } else {
                                    a.D = 0;
                                }
                            }
                        } else if (i3 != 4) {
                            if (i3 == 5) {
                                INetEventHandler iNetEventHandler2 = (INetEventHandler) message.obj;
                                if (iNetEventHandler2 != null) {
                                    Iterator<INetEventHandler> it = a.f250482f.iterator();
                                    while (it.hasNext()) {
                                        INetEventHandler next = it.next();
                                        if (next == iNetEventHandler2) {
                                            QLog.i(a.f250477a, 1, "unRegister netEvent " + next);
                                            it.remove();
                                        }
                                    }
                                }
                                QLog.d(a.f250477a, 1, "unRegister netEvent remain=" + a.f250482f.size());
                                if (a.A) {
                                    for (INetEventHandler iNetEventHandler3 : a.f250482f) {
                                        QLog.i(a.f250477a, 1, "netEvent " + iNetEventHandler3);
                                    }
                                }
                            }
                        } else {
                            INetInfoHandler iNetInfoHandler2 = (INetInfoHandler) message.obj;
                            if (iNetInfoHandler2 != null) {
                                Iterator<INetInfoHandler> it5 = a.f250481e.iterator();
                                while (it5.hasNext()) {
                                    INetInfoHandler next2 = it5.next();
                                    if (next2 == iNetInfoHandler2) {
                                        QLog.i(a.f250477a, 1, "unRegister netInfo " + next2);
                                        it5.remove();
                                    }
                                }
                            }
                            QLog.d(a.f250477a, 1, "unRegister netInfo remain=" + a.f250481e.size());
                            if (a.A) {
                                for (INetInfoHandler iNetInfoHandler3 : a.f250481e) {
                                    QLog.i(a.f250477a, 1, "netInfo " + iNetInfoHandler3);
                                }
                            }
                        }
                    } else {
                        INetEventHandler iNetEventHandler4 = (INetEventHandler) message.obj;
                        if (iNetEventHandler4 != null) {
                            if (!a.f250482f.contains(iNetEventHandler4)) {
                                a.f250482f.add(iNetEventHandler4);
                                QLog.d(a.f250477a, 1, "register netEvent " + iNetEventHandler4 + ", total=" + a.f250482f.size());
                            } else {
                                QLog.w(a.f250477a, 1, "register netEvent " + iNetEventHandler4 + " duplication, total=" + a.f250482f.size());
                            }
                        }
                    }
                } else {
                    INetInfoHandler iNetInfoHandler4 = (INetInfoHandler) message.obj;
                    if (iNetInfoHandler4 != null) {
                        if (!a.f250481e.contains(iNetInfoHandler4)) {
                            a.f250481e.add(iNetInfoHandler4);
                            QLog.d(a.f250477a, 1, "register netInfo " + iNetInfoHandler4 + ", total=" + a.f250481e.size());
                        } else {
                            QLog.w(a.f250477a, 1, "register netInfo " + iNetInfoHandler4 + " duplication, total=" + a.f250481e.size());
                        }
                    }
                }
            } catch (Exception unused) {
                QLog.d(a.f250477a, 1, "failed to handle msg " + i3);
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18441);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f250480d = new AtomicBoolean(false);
        f250481e = new LinkedList();
        f250482f = new LinkedList();
        f250483g = false;
        f250484h = new b("nethandlerthread");
        f250490n = null;
        f250491o = null;
        f250502z = -1;
        A = true;
        B = 0L;
        D = 0;
        E = "";
        F = "";
        G = "";
        H = Uri.parse("content://telephony/carriers/preferapn");
        I = new C8102a();
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static String a(int i3) {
        return i3 != 0 ? i3 != 1 ? (i3 == 2 || i3 == 3) ? "WiFi" : "UNKNOWN" : "MOBILE" : "NONE";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Finally extract failed */
    public static void f() {
        NetworkInfo networkInfo = ((ConnectivityManager) BaseApplication.getContext().getSystemService("connectivity")).getNetworkInfo(0);
        try {
            if (networkInfo != null) {
                E = NetworkMonitor.netGetExInfo(networkInfo);
                return;
            }
            Cursor cursor = null;
            try {
                cursor = ContactsMonitor.query(BaseApplication.getContext().getContentResolver(), H, null, null, null, null);
                while (cursor != null) {
                    if (!cursor.moveToNext()) {
                        break;
                    } else {
                        E = cursor.getString(cursor.getColumnIndex("apn"));
                    }
                }
                if (cursor == null) {
                    return;
                }
            } catch (Throwable th5) {
                try {
                    th5.printStackTrace();
                    if (cursor == null) {
                        return;
                    }
                } catch (Throwable th6) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th6;
                }
            }
            cursor.close();
        } catch (Exception e16) {
            QLog.d(f250477a, 1, "get currentAPN error " + e16);
        }
    }

    private static void g() {
        try {
            if (f250490n == null) {
                synchronized (f250484h) {
                    if (f250490n == null) {
                        if (!f250484h.isAlive()) {
                            QLog.d(f250477a, 1, "PID=" + Process.myPid() + " tid=" + Thread.currentThread().getId() + " AppNetInfoImpl checkInitHandler. looper=" + Looper.myLooper());
                            f250484h.start();
                        }
                        f250490n = new Handler(f250484h.getLooper(), f250484h);
                    }
                }
            }
        } catch (Exception e16) {
            QLog.d(f250477a, 1, "initHandler exception " + e16.toString());
        }
    }

    public static void h() {
        try {
            g();
            synchronized (f250484h) {
                if (!f250483g && BaseApplication.getContext() != null) {
                    BaseApplication.getContext().registerReceiver(I, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    a(false);
                    f250483g = true;
                } else if (f250483g && !n()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - B >= 5000) {
                        B = currentTimeMillis;
                        a(true);
                    }
                }
            }
        } catch (Exception e16) {
            QLog.d(f250477a, 1, "failed to check init ops " + e16.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i() {
        if (com.tencent.mobileqq.msf.core.x.d.F().booleanValue()) {
            return;
        }
        try {
            WifiInfo connectionInfo = LocationMonitor.getConnectionInfo((WifiManager) BaseApplication.getContext().getSystemService("wifi"));
            if (connectionInfo != null) {
                G = NetworkMonitor.getSSID(connectionInfo);
                QLog.d(f250477a, 1, "checknetinfo get wifi ssid " + G);
            }
        } catch (Exception unused) {
            QLog.d(f250477a, 1, "failed to get wifi ssid");
        }
    }

    public static int j() {
        if (o()) {
            if (C) {
                return 3;
            }
            return 2;
        }
        if (m()) {
            return 1;
        }
        return 0;
    }

    public static int k() {
        return D;
    }

    public static NetworkInfo l() {
        return f250491o;
    }

    public static boolean m() {
        if (f250479c == 1) {
            return true;
        }
        return false;
    }

    public static boolean n() {
        return f250480d.get();
    }

    public static boolean o() {
        int i3 = f250479c;
        if (i3 != 2 && i3 != 3) {
            return false;
        }
        return true;
    }

    private static void p() {
        b(f250479c | 1);
    }

    private static void q() {
        b(f250479c & (-2));
    }

    public static void r() throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(f250478b).openConnection();
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.connect();
        byte[] bArr = new byte[8];
        httpURLConnection.getInputStream().read(bArr);
        httpURLConnection.getInputStream().close();
        httpURLConnection.disconnect();
        String str = new String(bArr);
        if ("Poduct3G".equals(str)) {
            b(true);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f250477a, 2, "wifi ping resp content is " + str);
        }
        C = true;
    }

    private static void s() {
        b(f250479c | 4);
    }

    private static void t() {
        b(f250479c & (-5));
    }

    private static void u() {
        b(f250479c | 2);
    }

    private static void v() {
        b(f250479c & (-3));
    }

    private static synchronized void b(int i3) {
        synchronized (a.class) {
            if (f250479c == i3) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250477a, 2, "found repeat net event , now is " + n() + " now:" + i3 + " last:" + f250479c);
                }
                return;
            }
            if (i3 > 0) {
                b(true);
            } else {
                b(false);
            }
            QLog.d(f250477a, 1, "netchange " + a(f250479c) + " to " + a(i3));
            f250502z = -1;
            if (i3 == 1) {
                int i16 = f250479c;
                if (i16 != 0 && i16 != -2) {
                    if (i16 != 2 && i16 != 3) {
                        if (i16 <= 7) {
                            f250502z = 6;
                        }
                    }
                    f250502z = 1;
                }
                f250502z = 0;
            } else {
                if (i3 != 2 && i3 != 3) {
                    if (i3 > 3 && i3 <= 7) {
                        int i17 = f250479c;
                        if (i17 != 0 && i17 != -2) {
                            if (i17 == 1) {
                                f250502z = 9;
                            } else if (i17 == 2 || i3 == 3) {
                                f250502z = 10;
                            }
                        }
                        f250502z = 8;
                    } else {
                        int i18 = f250479c;
                        if (i18 == 1) {
                            f250502z = 4;
                        } else {
                            if (i18 != 2 && i18 != 3) {
                                if (i18 <= 7) {
                                    f250502z = 11;
                                }
                            }
                            f250502z = 5;
                        }
                    }
                }
                int i19 = f250479c;
                if (i19 != 0 && i19 != -2) {
                    if (i19 == 1) {
                        f250502z = 3;
                    } else if (i19 <= 7) {
                        f250502z = 7;
                    }
                }
                f250502z = 2;
            }
            f250479c = i3;
        }
    }

    public static void a(Context context, INetInfoHandler iNetInfoHandler) {
        Handler handler;
        if (iNetInfoHandler == null) {
            QLog.w(f250477a, 1, Thread.currentThread().getName() + " registerConnectionChangeReceiver null");
        }
        h();
        if (!f250483g || (handler = f250490n) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = iNetInfoHandler;
        f250490n.sendMessage(obtainMessage);
    }

    public static void a(Context context, INetEventHandler iNetEventHandler) {
        Handler handler;
        if (iNetEventHandler == null) {
            QLog.w(f250477a, 1, Thread.currentThread().getName() + " registerNetChangeReceiver null");
        }
        h();
        if (!f250483g || (handler = f250490n) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = 2;
        obtainMessage.obj = iNetEventHandler;
        f250490n.sendMessage(obtainMessage);
    }

    public static boolean a(INetInfoHandler iNetInfoHandler) {
        Handler handler;
        if (iNetInfoHandler == null) {
            QLog.w(f250477a, 1, Thread.currentThread().getName() + " unregisterNetInfoHandler null");
            return false;
        }
        h();
        if (f250483g && (handler = f250490n) != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = 4;
            obtainMessage.obj = iNetInfoHandler;
            f250490n.sendMessage(obtainMessage);
            return true;
        }
        QLog.w(f250477a, 1, Thread.currentThread().getName() + " unregisterNetInfoHandler initHandler=" + f250483g + " handler=" + f250490n);
        return false;
    }

    public static boolean a(INetEventHandler iNetEventHandler) {
        Handler handler;
        if (iNetEventHandler == null) {
            QLog.w(f250477a, 1, Thread.currentThread().getName() + " unregisterNetEventHandler null");
            return false;
        }
        h();
        if (!f250483g || (handler = f250490n) == null) {
            return false;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = iNetEventHandler;
        f250490n.sendMessage(obtainMessage);
        return true;
    }

    private static void b(boolean z16) {
        f250480d.set(z16);
    }

    public static void a(Context context, NetworkInfo networkInfo) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo2 != null) {
            try {
                E = NetworkMonitor.netGetExInfo(networkInfo2);
            } catch (Exception e16) {
                QLog.d(f250477a, 1, "get currentAPN error " + e16);
            }
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        f250491o = activeNetworkInfo;
        a(activeNetworkInfo, networkInfo);
    }

    public static void a(NetworkInfo networkInfo, NetworkInfo networkInfo2) {
        if (networkInfo == null) {
            if (networkInfo2 != null) {
                QLog.d(f250477a, 1, "currentAPN:" + E + ". ActiveNetInfo: " + networkInfo + ". ExtraNetInfo: " + networkInfo2);
                if (networkInfo2.getDetailedState() == NetworkInfo.DetailedState.DISCONNECTED || networkInfo2.getDetailedState() == NetworkInfo.DetailedState.FAILED || networkInfo2.getDetailedState() == NetworkInfo.DetailedState.IDLE || networkInfo2.getDetailedState() == NetworkInfo.DetailedState.SUSPENDED) {
                    if (1 == NetworkMonitor.getType(networkInfo2)) {
                        q();
                        v();
                        return;
                    } else {
                        if (a(networkInfo2)) {
                            q();
                            return;
                        }
                        q();
                        v();
                        t();
                        return;
                    }
                }
                return;
            }
            return;
        }
        String typeName = NetworkMonitor.getTypeName(networkInfo);
        try {
            F = networkInfo.getSubtypeName();
        } catch (Exception e16) {
            QLog.d(f250477a, 1, "get subtypeName error " + e16);
        }
        if (typeName.toLowerCase().contains("mobile_mms")) {
            QLog.d(f250477a, 1, "checkConnInfo current typeName: mobile_mms ignore.");
            return;
        }
        QLog.d(f250477a, 1, "currentAPN:" + E + ". received networkInfo: " + networkInfo.getDetailedState() + " :" + networkInfo + ". ExtraNetInfo: " + networkInfo2);
        if (networkInfo.getDetailedState() == NetworkInfo.DetailedState.CONNECTED) {
            if (1 == NetworkMonitor.getType(networkInfo)) {
                t();
                u();
                return;
            }
            if (a(networkInfo)) {
                t();
                v();
                p();
                return;
            } else {
                s();
                QLog.d(f250477a, 1, "Unexcepted activeNetInfo type:" + NetworkMonitor.getType(networkInfo));
                return;
            }
        }
        if (networkInfo.getDetailedState() == NetworkInfo.DetailedState.DISCONNECTED || networkInfo.getDetailedState() == NetworkInfo.DetailedState.FAILED || networkInfo.getDetailedState() == NetworkInfo.DetailedState.IDLE || networkInfo.getDetailedState() == NetworkInfo.DetailedState.SUSPENDED) {
            if (1 == NetworkMonitor.getType(networkInfo)) {
                v();
            } else if (a(networkInfo)) {
                q();
            } else {
                t();
            }
        }
    }

    public static void a(boolean z16) {
        NetworkInfo networkInfo;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            f250491o = activeNetworkInfo;
            a(activeNetworkInfo, (NetworkInfo) null);
            if (f250490n != null && (!f250483g || f250491o != null)) {
                f250490n.sendEmptyMessage(3);
            }
            if (z16 && (networkInfo = f250491o) != null && networkInfo.getDetailedState() == NetworkInfo.DetailedState.CONNECTED) {
                HashMap hashMap = new HashMap();
                hashMap.put("processName", MsfServiceSdk.get().processName);
                hashMap.put("netType", String.valueOf(NetworkMonitor.getType(f250491o)));
                RdmReq rdmReq = new RdmReq();
                rdmReq.eventName = "CheckNetIsValid";
                rdmReq.elapse = System.currentTimeMillis() - currentTimeMillis;
                rdmReq.isSucceed = true;
                rdmReq.isRealTime = true;
                rdmReq.params = hashMap;
                try {
                    MsfServiceSdk.get().sendMsg(MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), rdmReq));
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.d(f250477a, 2, e17.toString(), e17);
            }
        }
    }

    public static boolean a(NetworkInfo networkInfo) {
        return NetworkMonitor.getType(networkInfo) == 0 || 50 == NetworkMonitor.getType(networkInfo);
    }

    public static boolean a(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        g();
        return f250490n.post(runnable);
    }
}
