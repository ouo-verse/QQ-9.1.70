package com.tencent.luggage.wxa.jg;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.luggage.wxa.jg.j;
import com.tencent.luggage.wxa.tn.h0;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADNetStatus;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 39;
    public static final String NAME = "getNetworkType";

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f131077a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    public Method f131078b = null;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f131079c = Integer.MAX_VALUE;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f131080d = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    public final f f131081e = new f(this, null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements e {

        /* renamed from: a, reason: collision with root package name */
        public Future f131082a = com.tencent.luggage.wxa.zp.h.f146825d.c(new Runnable() { // from class: x21.a
            @Override // java.lang.Runnable
            public final void run() {
                j.a.this.a();
            }
        }, 3000);

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f131083b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f131084c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f131085d;

        public a(Map map, com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f131083b = map;
            this.f131084c = dVar;
            this.f131085d = i3;
        }

        public final void b(int i3) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetNetworkType", "onGetSignalStrengthInternal, dbm: " + i3);
            if (Integer.MAX_VALUE != i3) {
                this.f131083b.put("signalStrength", Integer.valueOf(i3));
            }
            this.f131084c.a(this.f131085d, j.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, this.f131083b));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetNetworkType", "getMobileSignalStrength, timeout");
            b(Integer.MAX_VALUE);
        }

        @Override // com.tencent.luggage.wxa.jg.j.e
        public void a(int i3) {
            if (this.f131082a.isDone()) {
                com.tencent.luggage.wxa.tn.w.h("MicroMsg.JsApiGetNetworkType", "onGetSignalStrength, dbm: %d, fallbackFuture done too early", Integer.valueOf(i3));
            } else {
                this.f131082a.cancel(false);
                b(i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f131087a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f131088b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f131089c;

        public b(Map map, com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f131087a = map;
            this.f131088b = dVar;
            this.f131089c = i3;
        }

        @Override // com.tencent.luggage.wxa.jg.j.e
        public void a(int i3) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetNetworkType", "onGetSignalStrength, dbm: " + i3);
            if (Integer.MAX_VALUE != i3) {
                this.f131087a.put("signalStrength", Integer.valueOf(i3));
            }
            this.f131088b.a(this.f131089c, j.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, this.f131087a));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f131091a;

        public c(com.tencent.luggage.wxa.xd.d dVar) {
            this.f131091a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                LocationMonitor.listen((TelephonyManager) this.f131091a.getContext().getApplicationContext().getSystemService("phone"), j.this.f131081e.a(), 256);
            } catch (RuntimeException e16) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.JsApiGetNetworkType", e16, "", new Object[0]);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f131093a;

        static {
            int[] iArr = new int[g.values().length];
            f131093a = iArr;
            try {
                iArr[g.Mobile_2g.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f131093a[g.Mobile_3g.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f131093a[g.Mobile_4g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f131093a[g.Mobile_5g.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f131093a[g.Wifi.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f131093a[g.None.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f131093a[g.Unknown.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface e {
        void a(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f {

        /* renamed from: a, reason: collision with root package name */
        public PhoneStateListener f131094a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f131095b;

        /* renamed from: c, reason: collision with root package name */
        public List f131096c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a extends PhoneStateListener {
            public a() {
            }

            @Override // android.telephony.PhoneStateListener
            public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                super.onSignalStrengthsChanged(signalStrength);
                int a16 = j.this.a(signalStrength);
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetNetworkType", "onSignalStrengthsChanged, dbm: " + a16);
                j.this.f131079c = a16;
                synchronized (f.this) {
                    if (!f.this.f131095b) {
                        f.this.f131095b = true;
                        if (f.this.f131096c != null) {
                            Iterator it = f.this.f131096c.iterator();
                            while (it.hasNext()) {
                                ((e) it.next()).a(a16);
                            }
                            f.this.f131096c.clear();
                            f.this.f131096c = null;
                        }
                    }
                }
            }
        }

        public f() {
            this.f131094a = null;
            this.f131095b = false;
            this.f131096c = null;
        }

        public synchronized boolean b() {
            return this.f131095b;
        }

        public synchronized PhoneStateListener a() {
            if (this.f131094a == null) {
                this.f131094a = new a();
            }
            return this.f131094a;
        }

        public /* synthetic */ f(j jVar, a aVar) {
            this();
        }

        public synchronized void a(e eVar) {
            if (this.f131096c == null) {
                this.f131096c = new ArrayList();
            }
            this.f131096c.add(eVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum g {
        None("none"),
        Mobile_2g(QADNetStatus.G_2),
        Mobile_3g(QADNetStatus.G_3),
        Mobile_4g(QADNetStatus.G_4),
        Mobile_5g(QADNetStatus.G_5),
        Wifi("wifi"),
        Unknown("unknown");


        /* renamed from: a, reason: collision with root package name */
        public final String f131107a;

        g(String str) {
            this.f131107a = str;
        }
    }

    public g b(com.tencent.luggage.wxa.xd.d dVar) {
        return a(dVar.getContext());
    }

    public final int c(SignalStrength signalStrength) {
        int gsmSignalStrength = signalStrength.getGsmSignalStrength();
        if (gsmSignalStrength == 99) {
            gsmSignalStrength = -1;
        }
        if (gsmSignalStrength == -1) {
            return -1;
        }
        return (gsmSignalStrength * 2) - 113;
    }

    public final Method e() {
        if (!this.f131077a.getAndSet(true)) {
            try {
                this.f131078b = SignalStrength.class.getMethod("getDbm", new Class[0]);
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.f("MicroMsg.JsApiGetNetworkType", "getGetDbmMethod, reflect getDbm fail since " + e16);
                this.f131078b = null;
            }
        }
        return this.f131078b;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public final void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        HashMap hashMap = new HashMap();
        g b16 = b(dVar);
        String property = System.getProperty("http.proxyHost");
        String property2 = System.getProperty("https.proxyHost");
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetNetworkType", "invoke appId:%s, networkType:%s,httpProxyHost:%s,httpsProxyHost:%s", dVar.getAppId(), b16, property, property2);
        hashMap.put(DKEngine.GlobalKey.NET_WORK_TYPE, b16.f131107a);
        if (w0.c(property) && w0.c(property2)) {
            hashMap.put("hasSystemProxy", Boolean.FALSE);
        } else {
            hashMap.put("hasSystemProxy", Boolean.TRUE);
        }
        switch (d.f131093a[b16.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                a(dVar, new a(hashMap, dVar, i3));
                return;
            case 5:
                b(dVar, new b(hashMap, dVar, i3));
                return;
            case 6:
            case 7:
                dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
                return;
            default:
                return;
        }
    }

    public final void b(com.tencent.luggage.wxa.xd.d dVar, e eVar) {
        if (h0.l(com.tencent.luggage.wxa.tn.z.c())) {
            eVar.a(com.tencent.luggage.wxa.tn.j.f141599a.g());
        } else {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.JsApiGetNetworkType", "getWifiSignalStrength, getConnectionInfo is invalid");
            eVar.a(Integer.MAX_VALUE);
        }
    }

    public static g a(Context context) {
        ConnectivityManager connectivityManager;
        try {
            connectivityManager = (ConnectivityManager) com.tencent.luggage.wxa.tn.z.c().getSystemService("connectivity");
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.JsApiGetNetworkType", e16, "", new Object[0]);
        }
        if (connectivityManager == null) {
            return g.Unknown;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
                return g.Wifi;
            }
            if (NetworkMonitor.getSubtype(activeNetworkInfo) != 2 && NetworkMonitor.getSubtype(activeNetworkInfo) != 1 && NetworkMonitor.getSubtype(activeNetworkInfo) != 4) {
                if (NetworkMonitor.getSubtype(activeNetworkInfo) >= 5 && NetworkMonitor.getSubtype(activeNetworkInfo) < 13) {
                    return g.Mobile_3g;
                }
                if (NetworkMonitor.getSubtype(activeNetworkInfo) >= 13 && NetworkMonitor.getSubtype(activeNetworkInfo) < 20) {
                    return g.Mobile_4g;
                }
                if (NetworkMonitor.getSubtype(activeNetworkInfo) >= 20) {
                    return g.Mobile_5g;
                }
                return g.Unknown;
            }
            return g.Mobile_2g;
        }
        return g.None;
    }

    public final int b(SignalStrength signalStrength) {
        int cdmaDbm;
        if (signalStrength.isGsm()) {
            cdmaDbm = c(signalStrength);
        } else {
            cdmaDbm = signalStrength.getCdmaDbm();
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetNetworkType", "getDbmFallback, dBm: " + cdmaDbm);
        return cdmaDbm;
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, e eVar) {
        if (!this.f131080d.getAndSet(true)) {
            com.tencent.luggage.wxa.zp.h.f146825d.a(new c(dVar));
        }
        if (this.f131081e.b()) {
            eVar.a(this.f131079c);
        } else {
            this.f131081e.a(eVar);
        }
    }

    public final int a(SignalStrength signalStrength) {
        Method e16 = e();
        if (e16 == null) {
            return b(signalStrength);
        }
        try {
            return ((Integer) e16.invoke(signalStrength, new Object[0])).intValue();
        } catch (Exception e17) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.JsApiGetNetworkType", "getDbm, reflect getDbm fail since " + e17);
            return b(signalStrength);
        }
    }
}
