package com.tencent.luggage.wxa.oh;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.luggage.wxa.oh.c;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.upload.report.UploadQualityReportBuilder;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.nh.c f136477a;

    /* renamed from: b, reason: collision with root package name */
    public Context f136478b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f136479c;

    /* renamed from: i, reason: collision with root package name */
    public ConnectivityManager f136485i;

    /* renamed from: l, reason: collision with root package name */
    public String f136488l;

    /* renamed from: m, reason: collision with root package name */
    public String f136489m;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f136491o;

    /* renamed from: d, reason: collision with root package name */
    public d f136480d = null;

    /* renamed from: e, reason: collision with root package name */
    public e f136481e = null;

    /* renamed from: f, reason: collision with root package name */
    public WifiConfiguration f136482f = null;

    /* renamed from: g, reason: collision with root package name */
    public boolean f136483g = false;

    /* renamed from: h, reason: collision with root package name */
    public BroadcastReceiver f136484h = null;

    /* renamed from: j, reason: collision with root package name */
    public int f136486j = 0;

    /* renamed from: k, reason: collision with root package name */
    public long f136487k = 13000;

    /* renamed from: n, reason: collision with root package name */
    public boolean f136490n = false;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.oh.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class HandlerC6550a extends Handler {
        public HandlerC6550a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1) {
                w.d("MicroMsg.WiFiConnector", "MSG_TIME_OUT");
                if (!a.this.a()) {
                    a.this.a("fail to connect wifi:time out");
                    w.d("MicroMsg.wifi_event", "MSG_TIME_OUT FAIL.");
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String str;
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if (TextUtils.isEmpty(action)) {
                return;
            }
            w.d("MicroMsg.WiFiConnector", "startMonitorWiFiEvent, action: " + action);
            if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action) && !"android.net.wifi.STATE_CHANGE".equals(action)) {
                if ("android.net.wifi.supplicant.STATE_CHANGE".equals(action)) {
                    int i3 = -1;
                    try {
                        i3 = intent.getIntExtra("supplicantError", -1);
                    } catch (Exception e16) {
                        w.b("MicroMsg.WiFiConnector", e16.getMessage());
                    }
                    if (i3 == 1) {
                        w.b("MicroMsg.WiFiConnector", "ERROR_AUTHENTICATING");
                        w.d("MicroMsg.wifi_event", "ERROR_AUTHENTICATING FAIL.");
                        a aVar = a.this;
                        if (aVar.f136490n) {
                            str = "wifi config may be expired";
                        } else {
                            str = "password error";
                        }
                        aVar.a(false, str);
                        return;
                    }
                    return;
                }
                return;
            }
            NetworkInfo activeNetworkInfo = a.this.f136485i.getActiveNetworkInfo();
            WifiInfo b16 = com.tencent.luggage.wxa.oh.d.b();
            if (activeNetworkInfo != null && b16 != null && NetworkMonitor.getType(activeNetworkInfo) == 1 && activeNetworkInfo.getDetailedState() == NetworkInfo.DetailedState.CONNECTED && b16.getNetworkId() == a.this.f136482f.networkId) {
                a.this.a(true, "");
                w.d("MicroMsg.wifi_event", "CONNECTIVITY_ACTION CONNECTED.");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements c.a {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.oh.c.a
        public void a() {
            w.d("MicroMsg.WiFiConnector", "connect, onConnectSuccess");
            a.this.a(true, "");
        }

        @Override // com.tencent.luggage.wxa.oh.c.a
        public void b() {
            w.d("MicroMsg.WiFiConnector", "connect, onConnectFailure");
            a.this.a(false, "");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        public final WifiConfiguration f136495a;

        public d(WifiConfiguration wifiConfiguration) {
            this.f136495a = wifiConfiguration;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method.getName().compareTo("onSuccess") == 0) {
                w.d("MicroMsg.WiFiConnector", "connectWifi use ActionListener success");
                return null;
            }
            if (method.getName().compareTo("onFailure") == 0) {
                w.f("MicroMsg.WiFiConnector", "connectWifi use ActionListener fail, fallback to enableNetwork");
                com.tencent.luggage.wxa.oh.d.a(this.f136495a.networkId, true);
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements InvocationHandler {
        public e() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            w.d("MicroMsg.WiFiConnector", "Method:" + method + " getName:" + method.getName() + " ,Args:" + objArr);
            return null;
        }
    }

    public a(com.tencent.luggage.wxa.nh.c cVar, Context context, boolean z16) {
        this.f136479c = null;
        this.f136477a = cVar;
        this.f136478b = context;
        try {
            this.f136485i = (ConnectivityManager) z.c().getSystemService("connectivity");
        } catch (Exception e16) {
            w.a("MicroMsg.WiFiConnector", e16, "can not retrieve ConnectivityManager", new Object[0]);
        }
        this.f136479c = new HandlerC6550a(context.getMainLooper());
        if ((z16 || !com.tencent.luggage.wxa.v9.a.a(this.f136478b)) && this.f136478b.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29) {
            this.f136491o = true;
        } else {
            this.f136491o = false;
        }
    }

    public static String a(int i3) {
        return i3 != 0 ? i3 != 1 ? i3 != 2 ? i3 != 3 ? "UnknowState" : "STATE_FAIL" : "STATE_CONNECTED" : "STATE_CONNECTING" : "STATE_NONE";
    }

    public final void b() {
        if (this.f136483g) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.setPriority(Integer.MAX_VALUE);
        b bVar = new b();
        this.f136484h = bVar;
        this.f136478b.registerReceiver(bVar, intentFilter);
        this.f136483g = true;
        w.d("MicroMsg.WiFiConnector", "startMonitorWiFiEvent");
    }

    public final void c() {
        if (this.f136483g) {
            this.f136478b.unregisterReceiver(this.f136484h);
            this.f136483g = false;
            w.d("MicroMsg.WiFiConnector", "stopMonitorWiFiEvent");
        }
    }

    public Object a(d dVar, String str) {
        Class<?> cls = Class.forName(str);
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, dVar);
    }

    public final boolean a(WifiConfiguration wifiConfiguration) {
        if (wifiConfiguration == null || wifiConfiguration.networkId == com.tencent.luggage.wxa.oh.e.f136525a || this.f136485i == null) {
            return false;
        }
        try {
            Class<?> cls = Class.forName("android.net.wifi.WifiManager");
            if (Build.VERSION.SDK_INT >= 29) {
                return b(wifiConfiguration);
            }
            if (this.f136480d == null) {
                this.f136480d = new d(wifiConfiguration);
            }
            cls.getMethod(UploadQualityReportBuilder.STATE_CONNECT, Integer.TYPE, Class.forName("android.net.wifi.WifiManager$ActionListener")).invoke(com.tencent.luggage.wxa.oh.d.d(), Integer.valueOf(wifiConfiguration.networkId), a(this.f136480d, "android.net.wifi.WifiManager$ActionListener"));
            return true;
        } catch (Exception e16) {
            w.f("MicroMsg.WiFiConnector", "connectWifi fail since " + e16.toString() + ", try fallback");
            return b(wifiConfiguration);
        }
    }

    public final boolean b(WifiConfiguration wifiConfiguration) {
        w.d("MicroMsg.WiFiConnector", "doConnectWifiFallbackLogic");
        return com.tencent.luggage.wxa.oh.d.a(wifiConfiguration.networkId, true);
    }

    public final void b(int i3) {
        if (this.f136486j != i3) {
            this.f136486j = i3;
            w.d("MicroMsg.WiFiConnector", "switchState:" + a(this.f136486j));
        }
    }

    public void a(String str, String str2, String str3, long j3) {
        w.d("MicroMsg.WiFiConnector", "ssid:" + str + " bssid:" + str2);
        this.f136488l = str;
        this.f136489m = str2;
        if (-1 != j3) {
            this.f136487k = j3;
        }
        if (this.f136491o) {
            w.d("MicroMsg.WiFiConnector", "connect, use WifiConnector29Impl");
            com.tencent.luggage.wxa.oh.c.f136498a.a(this.f136478b, str, str2, str3, j3, new c());
            return;
        }
        int i3 = TextUtils.isEmpty(str3) ? 0 : 2;
        WifiConfiguration a16 = com.tencent.luggage.wxa.oh.b.a(str, i3, str3);
        WifiConfiguration b16 = com.tencent.luggage.wxa.oh.b.b(str, i3);
        w.d("MicroMsg.WiFiConnector", "connect, config exists: %b, oldConfig exists: %b", a16, b16);
        if (a16 != null) {
            if (b16 != null && !com.tencent.luggage.wxa.oh.b.a(str, i3)) {
                w.d("MicroMsg.WiFiConnector", "connect, forgotWifi fail");
                int a17 = com.tencent.luggage.wxa.oh.b.a(a16);
                a16.networkId = a17;
                if (a17 == com.tencent.luggage.wxa.oh.e.f136525a) {
                    w.d("MicroMsg.WiFiConnector", "connect, addConfig fail, use oldConfig");
                    this.f136490n = true;
                    a16 = b16;
                }
            }
            if (a16.networkId == com.tencent.luggage.wxa.oh.e.f136525a) {
                a16.networkId = com.tencent.luggage.wxa.oh.b.a(a16);
            }
            if (a16.networkId != com.tencent.luggage.wxa.oh.e.f136525a) {
                if (a(a16)) {
                    w.d("MicroMsg.wifi_event", com.tencent.tmdownloader.a.CONNTECTSTATE_CONNECTING);
                    b(1);
                    this.f136482f = a16;
                    b();
                    this.f136479c.sendEmptyMessageDelayed(1, this.f136487k);
                    return;
                }
                w.d("MicroMsg.WiFiConnector", "connect, connectWifi fail");
            } else {
                w.d("MicroMsg.WiFiConnector", "connect, addConfig fail");
            }
        }
        a(false, "fail to connect wifi:invalid network id");
        w.d("MicroMsg.wifi_event", "connect args wrong FAIL.");
    }

    public boolean a() {
        int i3 = this.f136486j;
        return i3 == 3 || i3 == 2;
    }

    public void a(String str) {
        WifiConfiguration wifiConfiguration = this.f136482f;
        if (wifiConfiguration != null) {
            com.tencent.luggage.wxa.oh.b.a(wifiConfiguration.networkId);
            a(false, str);
            w.d("MicroMsg.wifi_event", "cancelConnect, " + com.tencent.luggage.wxa.oh.e.a(this.f136482f.SSID) + " networkId:" + this.f136482f.networkId);
            w.d("MicroMsg.WiFiConnector", "cancelConnect");
        }
    }

    public final void a(boolean z16, String str) {
        WifiConfiguration wifiConfiguration;
        w.d("MicroMsg.WiFiConnector", "finishConnectTask success:" + z16);
        if (a()) {
            return;
        }
        com.tencent.luggage.wxa.nh.c cVar = this.f136477a;
        if (cVar != null) {
            String str2 = this.f136488l;
            String str3 = this.f136489m;
            if (z16) {
                str = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
            }
            cVar.a(str2, str3, str, this.f136491o);
        }
        this.f136479c.removeMessages(1);
        c();
        b(z16 ? 2 : 3);
        if (z16 || (wifiConfiguration = this.f136482f) == null) {
            return;
        }
        com.tencent.luggage.wxa.oh.b.a(wifiConfiguration.networkId);
    }
}
