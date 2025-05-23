package c.t.m.g;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import c.t.m.g.h3;
import c.t.m.g.l2;
import c.t.m.g.m2;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.map.geolocation.TencentDirectionListener;
import com.tencent.map.geolocation.TencentDistanceAnalysis;
import com.tencent.map.geolocation.TencentDistanceListener;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManagerOptions;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.TencentPedestrianData;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes.dex */
public class g2 {
    public static SparseArray<String> V;
    public TencentLocation C;
    public TencentDistanceListener D;
    public h3 H;
    public double I;
    public double J;
    public h3 K;
    public final boolean M;
    public boolean N;
    public long O;
    public long P;
    public long Q;
    public String R;
    public boolean S;
    public long T;
    public l2 U;

    /* renamed from: b, reason: collision with root package name */
    public d f29664b;

    /* renamed from: c, reason: collision with root package name */
    public final b2 f29665c;

    /* renamed from: d, reason: collision with root package name */
    public final j2 f29666d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f29667e;

    /* renamed from: f, reason: collision with root package name */
    public final f2 f29668f;

    /* renamed from: g, reason: collision with root package name */
    public final p2 f29669g;

    /* renamed from: h, reason: collision with root package name */
    public final d2 f29670h;

    /* renamed from: j, reason: collision with root package name */
    public final i2 f29672j;

    /* renamed from: k, reason: collision with root package name */
    public final m2 f29673k;

    /* renamed from: l, reason: collision with root package name */
    public c.t.m.g.b f29674l;

    /* renamed from: n, reason: collision with root package name */
    public HandlerThread f29676n;

    /* renamed from: q, reason: collision with root package name */
    public t2 f29679q;

    /* renamed from: r, reason: collision with root package name */
    public x2 f29680r;

    /* renamed from: s, reason: collision with root package name */
    public u2 f29681s;

    /* renamed from: t, reason: collision with root package name */
    public v2 f29682t;

    /* renamed from: u, reason: collision with root package name */
    public final n1 f29683u;

    /* renamed from: v, reason: collision with root package name */
    public TencentLocationListener f29684v;

    /* renamed from: a, reason: collision with root package name */
    public int f29663a = 1;

    /* renamed from: m, reason: collision with root package name */
    public volatile boolean f29675m = false;

    /* renamed from: o, reason: collision with root package name */
    public int f29677o = 0;

    /* renamed from: w, reason: collision with root package name */
    public String f29685w = "stop";

    /* renamed from: x, reason: collision with root package name */
    public boolean f29686x = false;

    /* renamed from: y, reason: collision with root package name */
    public double f29687y = 0.0d;

    /* renamed from: z, reason: collision with root package name */
    public int f29688z = 0;
    public int A = 0;
    public int B = 0;
    public boolean E = false;
    public final Object F = new Object();
    public final TencentLocationRequest G = TencentLocationRequest.create();
    public int L = 404;

    /* renamed from: p, reason: collision with root package name */
    public n2 f29678p = new n2(10, 4);

    /* renamed from: i, reason: collision with root package name */
    public final h2 f29671i = h2.a();

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a implements TencentPedestrianData {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f29689a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f29690b;

        public a(g2 g2Var, float f16, long j3) {
            this.f29689a = f16;
            this.f29690b = j3;
        }

        @Override // com.tencent.map.geolocation.TencentPedestrianData
        public long getLastUpdateTimeStamp() {
            return this.f29690b;
        }

        @Override // com.tencent.map.geolocation.TencentPedestrianData
        public float getPedestrianCount() {
            return this.f29689a;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class c implements l2.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f29691a;

        public c(long j3) {
            this.f29691a = j3;
        }

        @Override // c.t.m.g.l2.d
        public void a(String str, v2 v2Var) {
            try {
                if (g2.this.L == 0 && g2.this.H != null && this.f29691a < 30000) {
                    return;
                }
                k3.a("NLP", "" + str);
                if (v2Var != null && str != null) {
                    y0.b(g2.this.f29664b, 3899, 0, 0, new Pair(str, v2Var));
                    return;
                }
                y0.b(g2.this.f29664b, 3899, 0, 0, null);
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class d extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public int f29693a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f29694b;

        public d(Looper looper) {
            super(looper);
            this.f29693a = 0;
            this.f29694b = true;
        }

        public void a() {
            removeCallbacksAndMessages(null);
            this.f29694b = true;
            this.f29693a = 0;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z16;
            int i3;
            boolean z17;
            synchronized (g2.this.F) {
                if (g2.this.f29684v != null) {
                    TencentLocationListener tencentLocationListener = g2.this.f29684v;
                    TencentLocationRequest tencentLocationRequest = g2.this.G;
                    int requestLevel = tencentLocationRequest.getRequestLevel();
                    long interval = tencentLocationRequest.getInterval();
                    boolean z18 = tencentLocationRequest.getExtras().getBoolean("daemon");
                    int i16 = message.what;
                    if (i16 == 555) {
                        g2.this.f29680r = null;
                        sendEmptyMessage(BuddySource.DEFAULT);
                        return;
                    }
                    boolean z19 = true;
                    if (i16 != 3899) {
                        if (i16 != 7999) {
                            if (i16 == 3998) {
                                v2 k3 = g2.this.k();
                                if (k3 == null) {
                                    o3.a("TxLocationManagerImpl", "last known info2 is null ,so we return");
                                    return;
                                }
                                String a16 = k3.a(requestLevel, g2.this.R, g2.this.f29683u, true, false, false);
                                if (!t3.a(a16)) {
                                    o3.a("TxLocationManagerImpl", "handleMessage: bad json2 " + a16);
                                    return;
                                }
                                g2.this.f29673k.b(a16, k3, g2.this.f29663a, k3.f30086d);
                                sendEmptyMessageDelayed(3998, g2.this.G.getCheckInterval());
                                return;
                            }
                            if (i16 != 3999) {
                                if (i16 != 11998) {
                                    if (i16 != 11999) {
                                        switch (i16) {
                                            case 4996:
                                                int i17 = this.f29693a + 1;
                                                this.f29693a = i17;
                                                if (i17 == 3) {
                                                    tencentLocationListener.onLocationChanged(h3.f29737p, 5, (String) g2.V.get(5));
                                                    this.f29693a = 0;
                                                    return;
                                                }
                                                return;
                                            case 4997:
                                                Pair pair = (Pair) message.obj;
                                                String obj = pair.first.toString();
                                                m2.b bVar = (m2.b) pair.second;
                                                v2 v2Var = (v2) bVar.f29866d;
                                                String str = bVar.f29868f;
                                                this.f29693a = 0;
                                                try {
                                                    h3 a17 = new h3.b().a(obj).a(requestLevel).a();
                                                    a17.getExtra().putString("resp_json", obj);
                                                    h3.d(a17);
                                                    if (a17.getAccuracy() != 20.0d || !g2.this.S) {
                                                        z19 = false;
                                                    }
                                                    h3.a(a17, g2.this.f29679q, z19, bVar.f29870h);
                                                    TencentExtraKeys.setRawQuery(a17, str);
                                                    if (v2Var.b() != null) {
                                                        i3 = v2Var.b().f30056d;
                                                    } else {
                                                        i3 = 0;
                                                    }
                                                    a17.getExtra().putInt("sat_num", i3);
                                                    if (a17.getVerifyKey() != null && !a17.getVerifyKey().equalsIgnoreCase("0")) {
                                                        if (str != null) {
                                                            try {
                                                                JSONObject jSONObject = new JSONObject(str);
                                                                jSONObject.remove("attribute");
                                                                jSONObject.remove(QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN);
                                                                jSONObject.remove("app_label");
                                                                jSONObject.remove("detectgps");
                                                                jSONObject.remove("control");
                                                                jSONObject.remove("app_name");
                                                                jSONObject.remove("version");
                                                                jSONObject.remove("address");
                                                                jSONObject.remove("source");
                                                                jSONObject.remove("bearing");
                                                                jSONObject.remove("pstat");
                                                                jSONObject.put("motion", g2.this.f29671i.b());
                                                                a17.getExtra().putString("wifi_data", jSONObject.toString());
                                                            } catch (Exception e16) {
                                                                e16.printStackTrace();
                                                            }
                                                        }
                                                        try {
                                                            a17.getExtra().putString("motion", g2.this.f29671i.b());
                                                            a17.getExtra().putAll(g2.this.G.getExtras());
                                                        } catch (Exception unused) {
                                                        }
                                                        g2.this.K = a17;
                                                        tencentLocationListener.onLocationChanged(a17, 0, (String) g2.V.get(0));
                                                        return;
                                                    }
                                                    return;
                                                } catch (JSONException unused2) {
                                                    o3.a("TxLocationManagerImpl", "handleMessage: location failed");
                                                    if (g2.this.b()) {
                                                        k3.a("update", "update 9,");
                                                        g2.this.a(2, h3.f29737p);
                                                        return;
                                                    }
                                                    return;
                                                }
                                            case 4998:
                                                g2.this.E = false;
                                                if (!g2.this.p()) {
                                                    k3.a("update", "update 10,");
                                                    g2.this.a(1, h3.f29737p);
                                                    return;
                                                }
                                                return;
                                            case 4999:
                                                removeMessages(4998);
                                                if (g2.this.G.getExtras().getBoolean("daemon")) {
                                                    g2.this.E = true;
                                                    return;
                                                }
                                                Pair pair2 = (Pair) message.obj;
                                                String obj2 = pair2.first.toString();
                                                m2.b bVar2 = (m2.b) pair2.second;
                                                v2 v2Var2 = (v2) bVar2.f29866d;
                                                g2.this.f29682t = v2Var2;
                                                String str2 = bVar2.f29868f;
                                                try {
                                                    h3 a18 = new h3.b().a(obj2).a(requestLevel).a();
                                                    a18.getExtra().putString("resp_json", obj2);
                                                    h3.d(a18);
                                                    h3.a(a18, g2.this.f29679q, false, bVar2.f29870h);
                                                    TencentExtraKeys.setRawQuery(a18, str2);
                                                    if (v2Var2.b() != null) {
                                                        int i18 = v2Var2.b().f30056d;
                                                    }
                                                    a18.getExtra().putLong("req_cost", message.arg1);
                                                    if (TencentExtraKeys.COMPHTTPIO) {
                                                        a18.getExtra().putLong("urlC_cost", message.arg2);
                                                    }
                                                    this.f29694b = false;
                                                    if (a18.getVerifyKey() != null && !a18.getVerifyKey().equalsIgnoreCase("0")) {
                                                        if (str2 != null) {
                                                            try {
                                                                JSONObject jSONObject2 = new JSONObject(str2);
                                                                jSONObject2.remove("attribute");
                                                                jSONObject2.remove(QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN);
                                                                jSONObject2.remove("app_label");
                                                                jSONObject2.remove("detectgps");
                                                                jSONObject2.remove("control");
                                                                jSONObject2.remove("app_name");
                                                                jSONObject2.remove("version");
                                                                jSONObject2.remove("address");
                                                                jSONObject2.remove("source");
                                                                jSONObject2.remove("bearing");
                                                                jSONObject2.remove("pstat");
                                                                a18.getExtra().putString("wifi_data", jSONObject2.toString());
                                                            } catch (Exception e17) {
                                                                o3.a("TxLocationManagerImpl", e17.toString());
                                                            }
                                                        }
                                                        try {
                                                            a18.getExtra().putString("motion", g2.this.f29671i.b());
                                                            a18.getExtra().putAll(g2.this.G.getExtras());
                                                        } catch (Exception unused3) {
                                                        }
                                                        if (a18.getAccuracy() == 20.0d && g2.this.S) {
                                                            z17 = true;
                                                        } else {
                                                            z17 = false;
                                                        }
                                                        h3.a(a18, g2.this.f29679q, z17, bVar2.f29870h);
                                                        k3.a("callback", "rsp," + a18.getAccuracy() + "," + a18.getFakeReason());
                                                        tencentLocationListener.onLocationChanged(a18, 0, (String) g2.V.get(0));
                                                    }
                                                    g2.this.E = true;
                                                    if (!g2.this.p()) {
                                                        a18.a();
                                                        a18.getExtra().putString("wifi_data", "");
                                                        k3.a("update", "update 9," + a18.getAccuracy() + "," + a18.getSpeed() + "," + a18.getFakeReason());
                                                        g2.this.a(0, a18);
                                                        StringBuilder sb5 = new StringBuilder();
                                                        sb5.append("respCallback:");
                                                        sb5.append(System.currentTimeMillis() - g2.this.T);
                                                        o3.b("TxLocationManagerImpl", sb5.toString());
                                                    }
                                                    if (g2.this.N) {
                                                        try {
                                                            Bundle extra = a18.getExtra();
                                                            if (extra != null) {
                                                                int i19 = extra.getInt("icontrol", -1);
                                                                SharedPreferences c16 = g2.this.f29683u.c();
                                                                o3.a("TxLocationManagerImpl", "start icontrol:" + i19);
                                                                c16.edit().putInt("control", i19).apply();
                                                            }
                                                        } catch (Error unused4) {
                                                        } catch (Exception e18) {
                                                            o3.a("TxLocationManagerImpl", "sp:" + e18);
                                                        }
                                                        g2.this.N = false;
                                                    }
                                                    g2.this.K = a18;
                                                    if (!g2.this.f29675m) {
                                                        g2.this.f29675m = true;
                                                        return;
                                                    }
                                                    return;
                                                } catch (JSONException unused5) {
                                                    o3.a("TxLocationManagerImpl", "handleMessage: location failed");
                                                    if (g2.this.b()) {
                                                        k3.a("update", "update 8,");
                                                        g2.this.a(2, h3.f29737p);
                                                        return;
                                                    }
                                                    return;
                                                }
                                            default:
                                                return;
                                        }
                                    }
                                    if (g2.this.H != null && tencentLocationRequest.getInterval() > 0 && g2.this.f29685w != null && g2.this.f29685w.equalsIgnoreCase("start")) {
                                        g2 g2Var = g2.this;
                                        g2Var.a(g2Var.H);
                                        o3.a("TxLocationManagerImpl", "time_callback" + g2.this.H.getLatitude() + "," + g2.this.H.getLongitude());
                                        tencentLocationListener.onLocationChanged(g2.this.H, g2.this.L, (String) g2.V.get(g2.this.L));
                                        if (g2.this.f29686x && g2.this.D != null) {
                                            g2.this.D.onDistanceChanged(g2.this.H, t3.a(g2.this.f29687y / 1000.0d, 2), g2.this.L, (String) g2.V.get(g2.this.L));
                                        }
                                    }
                                    if (interval > 0 && !z18) {
                                        sendEmptyMessageDelayed(11999, interval);
                                    }
                                    boolean p16 = g2.this.p();
                                    g2.this.f29669g.a(p16);
                                    if (p16 && interval > 5000) {
                                        sendEmptyMessageDelayed(BuddySource.DEFAULT, interval - 1500);
                                        return;
                                    }
                                    return;
                                }
                                if (g2.this.H != null) {
                                    g2 g2Var2 = g2.this;
                                    g2Var2.a(g2Var2.H);
                                    k3.a("callback", g2.this.L + "");
                                    tencentLocationListener.onLocationChanged(g2.this.H, g2.this.L, (String) g2.V.get(g2.this.L));
                                    if (g2.this.f29686x && g2.this.D != null) {
                                        g2.this.D.onDistanceChanged(g2.this.H, t3.a(g2.this.f29687y / 1000.0d, 2), g2.this.L, (String) g2.V.get(g2.this.L));
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        } else if (g2.this.b()) {
                            return;
                        } else {
                            o3.b("TxLocationManagerImpl", "network connected --> prepare json");
                        }
                        o3.b("TxLocationManagerImpl", "MSG_ID_PREPARE_JSON preCallback:" + (System.currentTimeMillis() - g2.this.T));
                        if (!z18) {
                            boolean p17 = g2.this.p();
                            g2.this.f29669g.a(p17);
                            if (p17 && interval > 5000) {
                                long currentTimeMillis = System.currentTimeMillis();
                                if (currentTimeMillis - g2.this.Q >= interval - 1500) {
                                    g2.this.Q = currentTimeMillis;
                                } else {
                                    o3.b("TxLocationManagerImpl", "ignore PREPARE_JSON");
                                    return;
                                }
                            }
                        } else {
                            o3.a("TxLocationManagerImpl", "the daemonLocation,so we delay long time upload:" + g2.this.O + "," + System.currentTimeMillis() + "," + g2.this.P);
                            if (System.currentTimeMillis() - g2.this.P >= g2.this.O) {
                                g2.this.P = System.currentTimeMillis();
                            } else {
                                return;
                            }
                        }
                        if (message.obj != null) {
                            o3.a("TxLocationManagerImpl", "wifi error." + message.obj.toString());
                        }
                        int i26 = g2.this.f29663a;
                        v2 k16 = g2.this.k();
                        if (k16 != null) {
                            String str3 = g2.this.R;
                            n1 n1Var = g2.this.f29683u;
                            if (this.f29694b && !z18) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            String a19 = k16.a(requestLevel, str3, n1Var, z16, g2.this.N, z18);
                            o3.b("TxLocationManagerImpl", "requestjson:" + a19);
                            if (!t3.a(a19)) {
                                boolean p18 = g2.this.p();
                                k3.a("LMG", "bad json," + p18);
                                o3.a("TxLocationManagerImpl", "handleMessage: gpsValid : " + p18 + ",bad json : " + a19);
                                if (!p18) {
                                    g2.this.o();
                                    return;
                                }
                                return;
                            }
                            if (!z18 && TencentExtraKeys.isRequestRawData(tencentLocationRequest)) {
                                h3 a26 = new h3.b().a((h3) null).a(requestLevel).a();
                                TencentExtraKeys.setRawData(a26, a19.getBytes());
                                g2.this.a(a26);
                                tencentLocationListener.onLocationChanged(a26, 0, (String) g2.V.get(0));
                                return;
                            }
                            o3.b("TxLocationManagerImpl", "postCallback:" + (System.currentTimeMillis() - g2.this.T));
                            int a27 = k16.a(g2.this.f29682t);
                            h3 h3Var = g2.this.H;
                            if (g2.this.L == 0 && h3Var != null && (a27 == 1 || (a27 >= 2 && h3Var.getAccuracy() < 80.0f))) {
                                k3.a("update", "update 3," + h3Var.getAccuracy() + "," + h3Var.getSpeed() + "," + h3Var.getFakeReason());
                                g2.this.a(0, h3Var);
                                return;
                            }
                            g2.this.f29673k.a(a19, k16, i26, k16.f30086d);
                            return;
                        }
                        o3.a("TxLocationManagerImpl", "last known info is null ,so we return");
                        return;
                    }
                    Pair pair3 = (Pair) message.obj;
                    if (pair3 == null) {
                        k3.a("update", "update 4,");
                        g2.this.a(2, h3.f29737p);
                        return;
                    }
                    String str4 = (String) pair3.first;
                    v2 v2Var3 = (v2) pair3.second;
                    if (str4 == null) {
                        k3.a("update", "update 5,");
                        g2.this.a(2, h3.f29737p);
                    } else if (!t3.a(str4)) {
                        k3.a("update", "update 6,");
                        g2.this.a(2, h3.f29737p);
                    } else if (v2Var3 == null) {
                        k3.a("update", "update 7,");
                        g2.this.a(2, h3.f29737p);
                    } else {
                        g2.this.f29673k.a(str4, v2Var3, g2.this.f29663a, v2Var3.f30086d);
                    }
                }
            }
        }
    }

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        V = sparseArray;
        sparseArray.put(0, "OK");
        V.put(1, "ERROR_NETWORK");
        V.put(2, "BAD_JSON");
        V.put(4, "DEFLECT_FAILED");
        V.put(5, "VERIFYKEY_ERROR_NETWORK");
        p.a(s3.a());
    }

    public g2(n1 n1Var) {
        this.f29683u = n1Var;
        this.f29672j = new i2(n1Var);
        this.f29673k = new m2(n1Var);
        this.f29670h = d2.a(n1Var.f29875a);
        boolean c16 = c();
        this.f29667e = c16;
        if (c16) {
            this.f29665c = null;
            p2 h16 = h();
            this.f29669g = h16;
            j2 g16 = g();
            this.f29666d = g16;
            f2 f16 = f();
            this.f29668f = f16;
            this.M = q3.a(h16, g16, f16);
        } else {
            this.f29666d = null;
            p2 h17 = h();
            this.f29669g = h17;
            b2 e16 = e();
            this.f29665c = e16;
            f2 f17 = f();
            this.f29668f = f17;
            this.M = q3.a(h17, e16, f17);
        }
        n1Var.b(this);
        try {
            p.a(n1Var.f29875a, "txsdk", n1Var.a().p());
        } catch (Throwable unused) {
        }
        k3.a("LMG", "init");
    }

    public final boolean c() {
        return true;
    }

    public void onCellInfoEvent(t2 t2Var) {
        o3.a("TxLocationManagerImpl", "cellCallback:" + (System.currentTimeMillis() - this.T));
        a(t2Var);
        if (this.f29674l != null) {
            c.t.m.g.d dVar = new c.t.m.g.d(t2Var.f30003b, t2Var.f30004c, t2Var.f30005d, t2Var.f30007f, t2Var.f30006e, t2Var.f30002a.ordinal());
            ArrayList arrayList = new ArrayList();
            arrayList.add(dVar);
            for (t2 t2Var2 : t2Var.c()) {
                arrayList.add(new c.t.m.g.d(t2Var2.f30003b, t2Var2.f30004c, t2Var2.f30005d, t2Var2.f30007f, t2Var2.f30006e, t2Var2.f30002a.ordinal()));
            }
            this.f29674l.a(dVar, arrayList);
        }
    }

    public void onGpsInfoEvent(u2 u2Var) {
        a(u2Var);
        c.t.m.g.b bVar = this.f29674l;
        if (bVar != null) {
            bVar.a(u2Var.f30053a);
        }
    }

    public void onNetworkEvent(Integer num) {
        String b16 = p3.b(this.f29683u.f29875a);
        int intValue = num.intValue();
        if (intValue != -1) {
            if (intValue != 0) {
                if (intValue == 1) {
                    o3.b("TxLocationManagerImpl", "onNetworkEvent: " + b16 + " connected");
                    a(7999, 1000L);
                    return;
                }
                return;
            }
            o3.b("TxLocationManagerImpl", "onNetworkEvent: " + b16 + " disconnected");
            return;
        }
        o3.b("TxLocationManagerImpl", "onNetworkEvent: networks not found");
    }

    public void onStatusEvent(Message message) {
        a(message.what, message.arg1, message.arg2);
    }

    public void onWifiInfoEvent(x2 x2Var) {
        o3.a("TxLocationManagerImpl", "wifiCallback:" + (System.currentTimeMillis() - this.T));
        a(x2Var);
        c.t.m.g.b bVar = this.f29674l;
        if (bVar != null) {
            bVar.a(x2Var.a());
        }
    }

    public int d() {
        float f16;
        long j3;
        try {
            SharedPreferences c16 = this.f29683u.c();
            String string = c16.getString("stepStr", "");
            if (TextUtils.isEmpty(string)) {
                f16 = 0.0f;
                j3 = 0;
            } else {
                String[] split = string.split(",");
                f16 = Float.valueOf(split[0]).floatValue();
                j3 = Long.valueOf(split[1]).longValue();
            }
            c16.edit().putString("stepStr", f16 + "," + j3 + ",0").apply();
            return 0;
        } catch (Throwable unused) {
            return -1;
        }
    }

    @Nullable
    public final b2 e() {
        if (!this.f29683u.h()) {
            o3.a("TxLocationManagerImpl", "createCellProvider: failed");
            return null;
        }
        return new b2(this.f29683u);
    }

    @Nullable
    public final f2 f() {
        if (!this.f29683u.g()) {
            o3.a("TxLocationManagerImpl", "createGpsProvider: failed");
            return null;
        }
        return new f2(this.f29683u);
    }

    @Nullable
    public final j2 g() {
        if (!this.f29683u.h()) {
            o3.a("TxLocationManagerImpl", "createNewCellProvider: failed");
            return null;
        }
        return new j2(this.f29683u);
    }

    @Nullable
    public final p2 h() {
        if (!this.f29683u.i()) {
            o3.a("TxLocationManagerImpl", "createWifiProvider: failed");
            return null;
        }
        return new p2(this.f29683u);
    }

    public final c.t.m.g.c i() {
        try {
            o1 a16 = this.f29683u.a();
            return new c.t.m.g.c(a16.c(), a16.p(), a16.a());
        } catch (Throwable th5) {
            o3.a("TxLocationManagerImpl", "getAppInfo error.", th5);
            return new c.t.m.g.c("unknown", "unknown", "unknown");
        }
    }

    public int j() {
        return this.f29663a;
    }

    public final v2 k() {
        x2 x2Var = this.f29680r;
        t2 t2Var = this.f29679q;
        u2 u2Var = this.f29681s;
        t2 t2Var2 = null;
        if (u2Var != null && !p()) {
            u2Var = null;
        }
        if (t2Var == null) {
            t2Var = t2.a(this.f29683u);
        }
        if (x2Var != null && !x2Var.a(System.currentTimeMillis(), 60000L)) {
            x2Var = null;
        }
        if (t2Var != null && u2Var != null) {
            int i3 = t2Var.f30005d;
            long j3 = t2Var.f30007f;
            Location location = u2Var.f30053a;
            Bundle bundle = new Bundle();
            bundle.putInt("lac", i3);
            bundle.putLong("cid", j3);
            bundle.putParcelable("location", location);
            if (!this.f29683u.a("cell").a(bundle)) {
                o3.b("TxLocationManagerImpl", "getFromLastKnownInfo: discard bad cell(" + i3 + "," + j3 + ")");
                return new v2(x2Var, t2Var2, u2Var, false);
            }
        }
        t2Var2 = t2Var;
        return new v2(x2Var, t2Var2, u2Var, false);
    }

    public TencentLocation l() {
        if (this.L != 0) {
            return null;
        }
        a(this.H);
        return this.H;
    }

    public int m() {
        h2 h2Var = this.f29671i;
        if (h2Var != null) {
            return h2Var.c();
        }
        return -1;
    }

    public TencentPedestrianData n() {
        float f16;
        long j3;
        float f17;
        SharedPreferences c16 = this.f29683u.c();
        if (c16 == null) {
            return null;
        }
        try {
            String string = c16.getString("stepStr", "");
            if (TextUtils.isEmpty(string)) {
                f16 = 0.0f;
                j3 = 0;
                f17 = 0.0f;
            } else {
                String[] split = string.split(",");
                f16 = Float.valueOf(split[0]).floatValue();
                j3 = Long.valueOf(split[1]).longValue();
                f17 = Float.valueOf(split[2]).floatValue();
            }
            c16.edit().putString("stepStr", f16 + "," + j3 + "," + f17).apply();
            return new a(this, f17, j3);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void o() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            h3 h3Var = this.H;
            long time = h3Var != null ? currentTimeMillis - h3Var.getTime() : 0L;
            if (this.L != 0 || this.H == null || time >= 30000) {
                if (this.U == null) {
                    this.U = new l2(this.f29683u);
                }
                this.U.a(this.f29663a, this.G.getRequestLevel(), this.R, false, false, false);
                this.U.a(this.f29664b.getLooper(), new c(time));
            }
        } catch (Exception unused) {
        }
    }

    public final boolean p() {
        f2 f2Var = this.f29668f;
        boolean z16 = false;
        if (f2Var != null && f2Var.b() && this.f29668f.a()) {
            z16 = true;
        }
        if (!z16) {
            o3.a("TxLocationManagerImpl", "isGpsValid: provider=" + z16);
        }
        return z16;
    }

    @TargetApi(19)
    public boolean q() {
        try {
            return SensorMonitor.getDefaultSensor((SensorManager) this.f29683u.f29875a.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR), 19) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public void r() {
        d2 d2Var = this.f29670h;
        if (d2Var != null) {
            d2Var.c();
        }
    }

    public final void s() {
        this.H = null;
        this.L = 404;
        this.f29680r = null;
        this.f29679q = null;
        this.f29681s = null;
        this.E = false;
        this.S = false;
        v2.f30082e = 0L;
        this.f29683u.a("cell").a();
    }

    public final int t() {
        p2 p2Var = this.f29669g;
        int c16 = p2Var != null ? p2Var.c() : 1;
        if (c16 != 0) {
            this.f29680r = null;
        }
        return c16;
    }

    public final void u() {
        i3.f29764a = false;
        this.f29672j.a();
        this.f29673k.b();
        this.f29678p.b();
        if (q3.b(this.f29669g)) {
            this.f29669g.d();
        }
        if (this.f29667e) {
            if (q3.b(this.f29666d)) {
                this.f29666d.b();
            }
        } else if (q3.b(this.f29665c)) {
            this.f29665c.f();
        }
        if (q3.b(this.f29668f)) {
            this.f29668f.e();
        }
        if (this.G.isAllowDirection() && !this.f29670h.b()) {
            this.f29670h.c();
        }
        if (!this.G.getExtras().getBoolean("daemon") && q3.b(this.f29671i)) {
            this.f29671i.e();
        }
        if (this.f29675m) {
            this.f29675m = false;
        }
        c.t.m.g.b bVar = this.f29674l;
        if (bVar != null) {
            bVar.e();
        }
        l2 l2Var = this.U;
        if (l2Var != null) {
            l2Var.a();
        }
    }

    public final void v() {
        if (this.f29677o == 0) {
            if (!q.b().b("start_daemon")) {
                o3.a("TxLocationManagerImpl", "cloud daemon is false");
                return;
            }
            long d16 = q.b().d("up_daemon_delay");
            this.O = d16;
            if (d16 < 120000) {
                this.O = 120000L;
            }
            try {
                if (x3.a(this.f29683u).equalsIgnoreCase("{}")) {
                    TencentLocationRequest requestLevel = TencentLocationRequest.create().setInterval(this.O).setRequestLevel(0);
                    requestLevel.getExtras().putBoolean("daemon", true);
                    b bVar = new b(this);
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread("daemonthread");
                    this.f29676n = baseHandlerThread;
                    baseHandlerThread.start();
                    a(requestLevel, bVar, this.f29676n.getLooper());
                    this.f29677o = 1;
                    this.P = System.currentTimeMillis();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final void w() {
        if (this.G.getInterval() <= 0 || this.G.getExtras().getBoolean("daemon")) {
            return;
        }
        a(11999, this.G.getInterval());
        if (this.G.getCheckInterval() != -1) {
            a(3998, this.G.getCheckInterval());
        }
    }

    public final void x() {
        long currentTimeMillis = System.currentTimeMillis();
        o3.b("TxLocationManagerImpl", "registercost:" + (System.currentTimeMillis() - currentTimeMillis));
        boolean z16 = z();
        boolean z17 = this.G.getExtras().getBoolean("daemon");
        d dVar = this.f29664b;
        this.f29672j.b(dVar);
        this.f29673k.b(dVar);
        o3.b("TxLocationManagerImpl", "sendercost:" + (System.currentTimeMillis() - currentTimeMillis));
        o3.b("TxLocationManagerImpl", "postlistcost:" + (System.currentTimeMillis() - currentTimeMillis));
        if (this.f29667e) {
            if (z16 && q3.b(this.f29666d)) {
                this.f29666d.a(dVar, z17);
            }
        } else if (z16 && q3.b(this.f29665c)) {
            this.f29665c.a(dVar);
        }
        o3.b("TxLocationManagerImpl", "cellcost:" + (System.currentTimeMillis() - currentTimeMillis));
        if (z16 && q3.b(this.f29669g)) {
            this.f29669g.a(dVar, z17);
        }
        o3.b("TxLocationManagerImpl", "wificost:" + (System.currentTimeMillis() - currentTimeMillis));
        if (!z17) {
            this.N = true;
        }
        if (q3.b(this.f29668f) && this.G.isAllowGPS()) {
            this.f29668f.b(this.f29663a == 1);
            this.f29668f.a(this.G.getInterval(), z17);
        }
        o3.b("TxLocationManagerImpl", "gpscost:" + (System.currentTimeMillis() - currentTimeMillis));
        if (this.G.isAllowDirection() && !this.f29670h.b()) {
            this.f29670h.a(dVar, null);
        }
        if (!z17 && this.G.isAllowPedometer()) {
            this.f29671i.a(this.f29683u.f29875a);
        }
        int c16 = q.b().c("f_coll_item");
        if ((c16 == 1 || c16 == 2) && this.f29674l == null) {
            this.f29674l = new c.t.m.g.b(this.f29683u.f29875a);
        }
        if (this.f29674l == null || dVar == null) {
            return;
        }
        o3.b("TxLocationManagerImpl", "fc,set:" + c16 + ",daemon:" + z17 + ",version:" + c.t.m.g.b.a());
        if (c16 == 2 || (c16 == 1 && !z17)) {
            this.f29674l.a(i());
            this.f29674l.a("D_UP_NET", q.b().e("f_coll_up_net"));
            this.f29674l.a("D_WRITE_MAC", "false");
            this.f29674l.a(dVar.getLooper());
        }
    }

    public final void y() {
        a((TencentLocationListener) null);
        HandlerThread handlerThread = this.f29676n;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f29676n = null;
        }
        this.f29677o = 0;
    }

    public final boolean z() {
        return this.G.getExtras().getBoolean("use_network", true);
    }

    public TencentDistanceAnalysis b(TencentDistanceListener tencentDistanceListener) {
        this.D = null;
        this.f29687y = 0.0d;
        this.f29686x = false;
        this.C = null;
        c3 c3Var = new c3();
        c3Var.a(t3.a((this.f29688z + 1) / (this.B + 1), 4) * 100.0d);
        c3Var.a(this.f29688z);
        c3Var.b(this.A);
        this.f29688z = 0;
        this.A = 0;
        this.B = 0;
        return c3Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0029 A[Catch: UnsatisfiedLinkError -> 0x0037, TryCatch #0 {UnsatisfiedLinkError -> 0x0037, blocks: (B:4:0x000c, B:6:0x0013, B:8:0x0017, B:10:0x001b, B:12:0x001f, B:16:0x0029, B:21:0x002c, B:23:0x0032), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a(String str) {
        boolean z16;
        String str2;
        String str3;
        try {
            if (str.contains(",")) {
                String[] split = str.split(",");
                if (split != null) {
                    z16 = true;
                    if (split.length > 1 && (str2 = split[0]) != null && (str3 = split[1]) != null && com.tencent.tencentmap.lbssdk.service.e.w(str2, str3) > 0) {
                        return !z16 ? split[0] : "";
                    }
                }
                z16 = false;
                if (!z16) {
                }
            } else {
                int v3 = com.tencent.tencentmap.lbssdk.service.e.v(str);
                return v3 >= 0 ? Integer.toString(v3) : "";
            }
        } catch (UnsatisfiedLinkError unused) {
            return null;
        }
    }

    public int a(TencentDistanceListener tencentDistanceListener) {
        if (this.f29684v == null) {
            return 1;
        }
        if (this.f29686x) {
            return 2;
        }
        this.f29686x = true;
        this.D = tencentDistanceListener;
        return 0;
    }

    public final boolean b() {
        return this.L == 404;
    }

    public void b(int i3) {
        if (this.f29663a == i3) {
            return;
        }
        this.f29663a = i3;
    }

    public int a(TencentDirectionListener tencentDirectionListener, Looper looper) {
        if (tencentDirectionListener == null || looper == null) {
            return -1;
        }
        d2 d2Var = this.f29670h;
        if (d2Var == null) {
            return -2;
        }
        d2Var.c();
        int a16 = this.f29670h.a(new Handler(looper), tencentDirectionListener);
        if (a16 == 0) {
            this.f29670h.a(true);
        }
        return a16;
    }

    public int a(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper) {
        if (this.f29677o == 1) {
            y();
        }
        if (TencentLocationManagerOptions.isLoadLibraryEnabled()) {
            try {
                System.loadLibrary("c++_shared");
            } catch (Throwable th5) {
                k3.a("LMG", "req,load c++_shared so error," + th5);
            }
            try {
                System.loadLibrary("tencentloc");
            } catch (Throwable th6) {
                o3.a("TencentLocationSDK", "load library tencentloc error.", th6);
                k3.a("LMG", "req,load tencentloc so error," + th6);
                return 3;
            }
        }
        n1 n1Var = this.f29683u;
        o1 a16 = n1Var.a();
        if (a16 != null && a16.e().equals(a16.f()) && a16.e().equals(a16.n())) {
            n1Var.k();
        }
        String h16 = a16.h();
        this.R = a(h16);
        k3.a("LMG", "req,lockey," + this.R);
        if (TextUtils.isEmpty(this.R)) {
            o3.a("TxLocationManagerImpl", "requestLocationUpdates: illegal key [" + h16 + "]");
            k3.a("LMG", "req,key error");
            return 2;
        }
        if (this.M) {
            k3.a("LMG", "req,provider error");
            return 1;
        }
        s();
        synchronized (this.F) {
            this.f29684v = tencentLocationListener;
        }
        TencentLocationRequest.copy(this.G, tencentLocationRequest);
        k3.a("LMG", "state," + l1.i() + ",req," + tencentLocationRequest);
        a16.f(tencentLocationRequest.getQQ());
        if (TextUtils.isEmpty(a16.i())) {
            a16.d(tencentLocationRequest.getPhoneNumber());
        }
        a16.a(tencentLocationRequest.getInterval() == 0 ? 8000L : tencentLocationRequest.getInterval());
        a(looper);
        u();
        x();
        this.f29685w = "start";
        p.a(this.R);
        try {
            k3.a("LMG", "pstate," + n3.a().a(n1Var.f29875a));
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public final void a(Looper looper) {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        if (q3.a(this.f29664b)) {
            this.f29664b = new d(looper);
            return;
        }
        this.f29664b.removeCallbacksAndMessages(null);
        if (this.f29664b.getLooper() != looper) {
            this.f29664b = new d(looper);
        }
    }

    public final void a(h3 h3Var) {
        if (h3Var != null) {
            try {
                if (this.G.isAllowDirection()) {
                    h3Var.getExtra().putDouble("direction", this.f29670h.a());
                }
                h3Var.getExtra().putString("motion", this.f29671i.b());
                h3Var.getExtra().putAll(this.G.getExtras());
            } catch (Throwable unused) {
            }
        }
    }

    public void a(TencentLocationListener tencentLocationListener) {
        o3.a("TxLocationManagerImpl", "shutdown");
        u();
        if (q3.b(this.f29664b)) {
            this.f29664b.a();
        }
        synchronized (this.F) {
            this.f29684v = null;
        }
        s();
        this.f29685w = "stop";
        v();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0179 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(int i3, h3 h3Var) {
        int i16;
        int i17;
        int i18;
        h3 h3Var2;
        if (h3Var == null) {
            return;
        }
        int i19 = 0;
        if (i3 == 0 && h3Var.getLatitude() != 0.0d && h3Var.getLongitude() != 0.0d) {
            h3.b(h3Var, (this.f29663a == 1 && j3.a(h3Var.getLatitude(), h3Var.getLongitude())) ? 1 : 0);
        }
        if (b()) {
            boolean z16 = this.L != 0 && i3 == 0;
            this.L = i3;
            this.H = h3Var;
            if (h3Var.getAccuracy() < 500.0f && h3Var.getAccuracy() > 0.0f) {
                this.f29678p.a((TencentLocation) h3Var);
                if (this.f29686x) {
                    this.C = h3Var;
                }
            }
            this.I = h3Var.getLatitude();
            this.J = h3Var.getLongitude();
            if (q3.b(this.f29684v)) {
                w();
            }
            if (z16) {
                a(11998);
            }
        } else if (i3 == 0 && h3Var.getLatitude() != 0.0d && h3Var.getLongitude() != 0.0d && Math.abs(h3Var.getLatitude() - this.I) >= 1.0E-7d) {
            if (Math.abs(h3Var.getLongitude() - this.J) >= 1.0E-7d) {
                if (!this.f29678p.a(h3Var, this.f29683u)) {
                    o3.b("TxLocationManagerImpl", "discard " + h3Var);
                    return;
                }
                this.I = h3Var.getLatitude();
                this.J = h3Var.getLongitude();
                if (h3Var.getAccuracy() < 500.0f && h3Var.getAccuracy() > 0.0f) {
                    this.f29678p.a(h3Var);
                    this.f29678p.a((TencentLocation) h3Var);
                    if (this.f29686x) {
                        TencentLocation tencentLocation = this.C;
                        if (tencentLocation != null) {
                            double a16 = t3.a(tencentLocation.getLatitude(), this.C.getLongitude(), h3Var.getLatitude(), h3Var.getLongitude());
                            if ((h3Var.getProvider().equalsIgnoreCase("network") && a16 > 10.0d) || (h3Var.getProvider().equalsIgnoreCase("gps") && a16 > 3.0d)) {
                                this.f29687y += a16;
                                if (h3Var.getProvider().equalsIgnoreCase("network")) {
                                    i16 = 1;
                                    this.A++;
                                } else {
                                    i16 = 1;
                                    this.f29688z++;
                                }
                                this.B += i16;
                                this.C = h3Var;
                            }
                        } else {
                            i16 = 1;
                            this.C = h3Var;
                        }
                        i17 = this.L;
                        if (i17 != 0 && i3 == 0) {
                            i19 = i16;
                        }
                        i18 = (i17 != 0 && (h3Var2 = this.H) != null && h3Var2.getProvider().equals("network") && i3 == 0 && h3Var.getProvider().equals("gps")) ? i16 : i19;
                        this.L = i3;
                        this.H = h3Var;
                        o3.a("TxLocationManagerImpl", "updateLast" + h3Var.getLatitude() + "," + h3Var.getLongitude());
                        if (this.G.getInterval() == 0 && q3.b(this.f29684v)) {
                            a(11998);
                        }
                        if (i18 == 0 || !q3.b(this.f29684v)) {
                            return;
                        }
                        a(11998);
                        return;
                    }
                }
            }
            i16 = 1;
            i17 = this.L;
            if (i17 != 0) {
                i19 = i16;
            }
            if (i17 != 0) {
            }
            this.L = i3;
            this.H = h3Var;
            o3.a("TxLocationManagerImpl", "updateLast" + h3Var.getLatitude() + "," + h3Var.getLongitude());
            if (this.G.getInterval() == 0) {
                a(11998);
            }
            if (i18 == 0) {
                return;
            } else {
                return;
            }
        }
        i16 = 1;
        i17 = this.L;
        if (i17 != 0) {
        }
        if (i17 != 0) {
        }
        this.L = i3;
        this.H = h3Var;
        o3.a("TxLocationManagerImpl", "updateLast" + h3Var.getLatitude() + "," + h3Var.getLongitude());
        if (this.G.getInterval() == 0) {
        }
        if (i18 == 0) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class b implements TencentLocationListener {
        public b(g2 g2Var) {
        }

        @Override // com.tencent.map.geolocation.TencentLocationListener
        public void onLocationChanged(TencentLocation tencentLocation, int i3, String str) {
        }

        @Override // com.tencent.map.geolocation.TencentLocationListener
        public void onStatusUpdate(String str, int i3, String str2) {
        }
    }

    public final void a(int i3) {
        d dVar = this.f29664b;
        if (dVar != null) {
            dVar.sendEmptyMessage(i3);
        } else {
            o3.a("TxLocationManagerImpl", "mHandler is null");
        }
    }

    public final void a(int i3, long j3) {
        d dVar = this.f29664b;
        if (dVar != null) {
            dVar.removeMessages(i3);
            dVar.sendEmptyMessageDelayed(i3, j3);
        }
    }

    public final void a(x2 x2Var) {
        d dVar = this.f29664b;
        if (dVar != null) {
            dVar.removeMessages(BuddySource.DEFAULT, "wifi_not_received");
        }
        k3.a(Global.TRACKING_WIFI, "wifi size:" + x2Var.a().size());
        if (this.f29680r == null || !this.E || x2Var.a().size() < 3 || !this.f29680r.a(x2Var)) {
            o3.b("TxLocationManagerImpl", "onWifiChanged: --> prepare json");
            a(BuddySource.DEFAULT);
        }
        this.f29680r = x2Var;
    }

    public final void a(t2 t2Var) {
        x2 x2Var;
        long j3 = t2Var.f30007f;
        this.f29679q = t2Var;
        int t16 = t();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onCellChanged,");
        sb5.append(t16);
        sb5.append(",");
        sb5.append(this.f29680r == null);
        k3.a("CELL", sb5.toString());
        if (t16 == 0 && ((x2Var = this.f29680r) == null || x2Var.a(System.currentTimeMillis(), 30000L))) {
            d dVar = this.f29664b;
            if (dVar != null) {
                this.f29664b.sendMessageDelayed(dVar.obtainMessage(BuddySource.DEFAULT, "wifi_not_received"), 2000L);
                return;
            }
            return;
        }
        a(BuddySource.DEFAULT);
    }

    public final void a(u2 u2Var) {
        double d16;
        double d17;
        int i3;
        double d18;
        double d19;
        int i16;
        if (u2Var.f30053a == c2.f29518a) {
            return;
        }
        this.f29681s = u2Var;
        if (this.G.getExtras().getBoolean("daemon")) {
            return;
        }
        int b16 = e2.d().b(u2Var);
        int i17 = this.f29663a;
        int requestLevel = this.G.getRequestLevel();
        h3 h3Var = this.K;
        Location location = new Location(u2Var.f30053a);
        Bundle extras = location.getExtras();
        if (extras != null) {
            d16 = extras.getDouble(QCircleSchemeAttr.Polymerize.LAT);
            d17 = extras.getDouble("lng");
            i3 = extras.getInt("fakeCode");
        } else {
            d16 = 0.0d;
            d17 = 0.0d;
            i3 = 0;
        }
        if (i3 != 0) {
            this.S = true;
            d18 = d16;
            d19 = d17;
            i16 = (int) (4 + Math.pow(2.0d, i3 + 3));
        } else {
            d18 = d16;
            d19 = d17;
            i16 = 0;
        }
        if (b16 == -1) {
            this.S = true;
            i16 += 2;
        }
        if (t3.a(i17)) {
            h3 a16 = new h3.b().a(h3Var).b("gps").c(this.S ? "fake" : "gps").a(requestLevel).a(new Location(u2Var.f30053a)).a();
            location.setLatitude(d18);
            location.setLongitude(d19);
            a16.b(location);
            a16.a(i16);
            k3.a("update", "update 1," + a16.getAccuracy() + "," + a16.getSpeed() + "," + a16.getFakeReason());
            a(0, a16);
            return;
        }
        double d26 = d18;
        double d27 = d19;
        if (b()) {
            a(BuddySource.DEFAULT);
        }
        h3 a17 = new h3.b().a(h3Var).b("gps").c(this.S ? "fake" : "gps").a(requestLevel).a(new Location(u2Var.f30053a)).a();
        location.setLatitude(d26);
        location.setLongitude(d27);
        a17.b(location);
        o3.a("TxLocationManagerImpl", "updateLastLocation");
        a17.a(i16);
        k3.a("update", "update 2," + a17.getAccuracy() + "," + a17.getSpeed() + "," + a17.getFakeReason());
        a(0, a17);
        a(12999, 12004, 3);
    }

    public final void a(int i3, int i16, int i17) {
        String str;
        String str2;
        switch (i16) {
            case 12001:
                if (i17 == 0) {
                    str = "wifi disabled";
                } else if (i17 == 1) {
                    str = "wifi enabled";
                } else if (i17 != 5) {
                    str = "unknown";
                } else {
                    a(BuddySource.DEFAULT);
                    str = "location service switch is off";
                }
                if (i17 != 5 && x3.f30103a) {
                    str = "location permission denied";
                    i17 = 2;
                }
                str2 = "wifi";
                break;
            case 12002:
                str2 = "gps";
                if (i17 == 0) {
                    str = "gps disabled";
                    break;
                } else if (i17 == 1) {
                    str = "gps enabled";
                    break;
                } else if (i17 == 5) {
                    a(BuddySource.DEFAULT);
                    str = "location permission denied";
                    break;
                } else {
                    str = "unknown";
                    break;
                }
            case 12003:
                String str3 = i17 == 1 ? "cell enabled" : i17 == 0 ? "cell disabled" : "unknown";
                if (!i3.f29764a) {
                    str2 = "cell";
                    str = str3;
                    break;
                } else {
                    a(BuddySource.DEFAULT);
                    str = "location permission denied";
                    i17 = 2;
                    str2 = "cell";
                    break;
                }
            case 12004:
                str2 = "gps";
                if (i17 == 3) {
                    str = "gps available";
                    break;
                } else if (i17 == 4) {
                    str = "gps unavailable";
                    break;
                } else {
                    str = "unknown";
                    break;
                }
            default:
                str2 = null;
                str = null;
                break;
        }
        o3.b("TxLocationManagerImpl", "onStatusChanged: " + str);
        if (i16 != 12004) {
            k3.a("status", str);
        }
        synchronized (this.F) {
            TencentLocationListener tencentLocationListener = this.f29684v;
            if (tencentLocationListener != null) {
                tencentLocationListener.onStatusUpdate(str2, i17, str);
            }
        }
    }
}
