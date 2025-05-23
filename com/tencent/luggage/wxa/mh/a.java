package com.tencent.luggage.wxa.mh;

import NS_COMM.COMM;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.tencent.luggage.wxa.h6.k;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.nh.g;
import com.tencent.luggage.wxa.tn.j;
import com.tencent.luggage.wxa.tn.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 316;
    public static final String NAME = "connectWifi";

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.mh.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6476a implements com.tencent.luggage.wxa.nh.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f134570a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f134571b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f134572c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f134573d;

        public C6476a(boolean z16, Context context, com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f134570a = z16;
            this.f134571b = context;
            this.f134572c = dVar;
            this.f134573d = i3;
        }

        @Override // com.tencent.luggage.wxa.nh.c
        public void a(String str, String str2, String str3, boolean z16) {
            com.tencent.luggage.wxa.af.c cVar;
            String str4;
            g.a((com.tencent.luggage.wxa.nh.c) null);
            if (str3.equals(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS)) {
                if (z16) {
                    w.d("MicroMsg.JsApiConnectWifi", "[IConnectWiFiCallback] connect success, refresh ConnectivityCompat cache");
                    j.a aVar = j.f141599a;
                    aVar.b();
                    aVar.a(true);
                }
                com.tencent.luggage.wxa.nh.e a16 = com.tencent.luggage.wxa.nh.b.f135819a.a(this.f134570a);
                w.d("MicroMsg.JsApiConnectWifi", "[IConnectWiFiCallback]currentWifi:%s", a16);
                if (a16 != null && a16.a()) {
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put("wifi", a16.b());
                        hashMap.put("errCode", 0);
                        this.f134572c.a(this.f134573d, a.this.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a, hashMap));
                        return;
                    } catch (JSONException e16) {
                        w.b("MicroMsg.JsApiConnectWifi", "IConnectWiFiCallback is error");
                        w.a("MicroMsg.JsApiConnectWifi", e16, "", new Object[0]);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("errCode", 12010);
                        this.f134572c.a(this.f134573d, a.this.makeReturnJson("fail:parse json err", com.tencent.luggage.wxa.af.e.f121309e, hashMap2));
                        return;
                    }
                }
                w.b("MicroMsg.JsApiConnectWifi", "[IConnectWiFiCallback]currentWIfi is null or invalid");
                HashMap hashMap3 = new HashMap();
                Pair a17 = a.this.a(this.f134571b, this.f134572c, hashMap3, z16);
                if (a17 == null) {
                    if (a16 == null) {
                        a17 = new Pair("fail:can't gain current wifi", com.tencent.luggage.wxa.af.b.F);
                    } else {
                        com.tencent.luggage.wxa.af.c cVar2 = com.tencent.luggage.wxa.af.b.G;
                        a17 = new Pair(cVar2.f121278b, cVar2);
                    }
                }
                this.f134572c.a(this.f134573d, a.this.makeReturnJson((String) a17.first, (com.tencent.luggage.wxa.af.c) a17.second, hashMap3));
                return;
            }
            HashMap hashMap4 = new HashMap();
            if (str3.equals("duplicated request")) {
                hashMap4.put("errCode", 12004);
                cVar = com.tencent.luggage.wxa.af.b.K;
                str4 = cVar.f121278b;
            } else if (str3.equals("password error")) {
                hashMap4.put("errCode", 12002);
                cVar = com.tencent.luggage.wxa.af.b.L;
                str4 = cVar.f121278b;
            } else if (str3.equals("wifi config may be expired")) {
                hashMap4.put("errCode", 12013);
                cVar = com.tencent.luggage.wxa.af.b.M;
                str4 = cVar.f121278b;
            } else if (!str3.equals("fail to connect wifi:time out")) {
                Pair a18 = a.this.a(this.f134571b, this.f134572c, hashMap4, z16);
                if (a18 != null) {
                    com.tencent.luggage.wxa.af.c cVar3 = (com.tencent.luggage.wxa.af.c) a18.second;
                    str4 = (String) a18.first;
                    cVar = cVar3;
                } else {
                    cVar = com.tencent.luggage.wxa.af.b.H;
                    str4 = cVar.f121278b;
                }
            } else {
                hashMap4.put("errCode", 12003);
                cVar = com.tencent.luggage.wxa.af.b.N;
                str4 = cVar.f121278b;
            }
            w.b("MicroMsg.JsApiConnectWifi", "[IConnectWiFiCallback]errCode:%d, errMsg:%s", hashMap4.get("errCode"), str4);
            this.f134572c.a(this.f134573d, a.this.makeReturnJson(str4, cVar, hashMap4));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f134575a;

        public b(com.tencent.luggage.wxa.xd.d dVar) {
            this.f134575a = dVar;
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onDestroy() {
            w.a("MicroMsg.JsApiConnectWifi", "remove listener");
            g.a((com.tencent.luggage.wxa.nh.c) null);
            com.tencent.luggage.wxa.ic.e.b(this.f134575a.getAppId(), this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c extends k0 {
        private static final int CTRL_INDEX = 322;
        private static final String NAME = "onWifiConnected";
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class d extends k0 {
        private static final int CTRL_INDEX = 322;
        private static final String NAME = "onWifiConnectedWithPartialInfo";
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        boolean z16;
        Context context = dVar.getContext();
        if (context == null) {
            w.b("MicroMsg.JsApiConnectWifi", "mContext is null, invoke fail!");
            Map<String, ? extends Object> hashMap = new HashMap<>();
            hashMap.put("errCode", 12010);
            dVar.a(i3, makeReturnJson("fail:context is null", com.tencent.luggage.wxa.af.e.f121309e, hashMap));
            return;
        }
        if (!com.tencent.luggage.wxa.mh.d.f134588a) {
            w.b("MicroMsg.JsApiConnectWifi", "not invoke startWifi");
            Map<String, ? extends Object> hashMap2 = new HashMap<>();
            hashMap2.put("errCode", 12000);
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.b.B, hashMap2));
            return;
        }
        g.a(context);
        if (dVar.getAppState() != com.tencent.luggage.wxa.qc.b.FOREGROUND) {
            w.b("MicroMsg.JsApiConnectWifi", "current state :%s isn't foreground", dVar.getAppState());
            Map<String, ? extends Object> hashMap3 = new HashMap<>();
            hashMap3.put("errCode", 12011);
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.b.I, hashMap3));
            return;
        }
        if (jSONObject != null) {
            z16 = jSONObject.optBoolean("maunal", false);
        } else {
            z16 = false;
        }
        if (z16) {
            Intent intent = new Intent("android.settings.WIFI_SETTINGS");
            if (w0.a(context, intent, true)) {
                w.d("MicroMsg.JsApiConnectWifi", "use manual");
                try {
                    com.tencent.luggage.wxa.fa.b.a(context, intent);
                    context.startActivity(intent);
                    HashMap hashMap4 = new HashMap();
                    hashMap4.put("errCode", 0);
                    dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a, hashMap4));
                    return;
                } catch (Exception e16) {
                    w.a("MicroMsg.JsApiConnectWifi", e16, "", new Object[0]);
                    Map<String, ? extends Object> hashMap5 = new HashMap<>();
                    hashMap5.put("errCode", 12010);
                    dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.b.J, hashMap5));
                    return;
                }
            }
            w.f("MicroMsg.JsApiConnectWifi", "jump2SysWifiSettingsIntent is unavailable");
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.b.J));
            return;
        }
        if (!com.tencent.luggage.wxa.oh.d.e()) {
            w.b("MicroMsg.JsApiConnectWifi", "wifi is disable");
            Map<String, ? extends Object> hashMap6 = new HashMap<>();
            hashMap6.put("errCode", 12005);
            dVar.a(i3, makeReturnJson("fail:wifi is disable", com.tencent.luggage.wxa.af.b.C, hashMap6));
            return;
        }
        if (jSONObject != null && jSONObject.has("SSID")) {
            g.a(new C6476a(jSONObject.optBoolean("acceptIncompleteWiFiInfo", com.tencent.luggage.wxa.nh.b.f135819a.a()), context, dVar, i3));
            com.tencent.luggage.wxa.ic.e.a(dVar.getAppId(), new b(dVar));
            String optString = jSONObject.optString("SSID");
            String optString2 = jSONObject.optString("BSSID");
            String optString3 = jSONObject.optString(NotificationActivity.PASSWORD);
            long optLong = jSONObject.optLong("timeout", -1L);
            boolean optBoolean = jSONObject.optBoolean("forceNewApi", false);
            if (optString.equals("")) {
                w.b("MicroMsg.JsApiConnectWifi", "params is invalid");
                Map<String, ? extends Object> hashMap7 = new HashMap<>();
                hashMap7.put("errCode", 12008);
                dVar.a(i3, makeReturnJson("fail:invalid data", com.tencent.luggage.wxa.af.e.f121315k, hashMap7));
                return;
            }
            w.d("MicroMsg.JsApiConnectWifi", "ssid:%s, bSsid:%s timeoutMs: %d, forceNewApi: %b is connecting", optString, optString2, Long.valueOf(optLong), Boolean.valueOf(optBoolean));
            g.a(optString, optString2, optString3, optLong, optBoolean);
            return;
        }
        w.b("MicroMsg.JsApiConnectWifi", "params is invalid");
        Map<String, ? extends Object> hashMap8 = new HashMap<>();
        hashMap8.put("errCode", 12010);
        dVar.a(i3, makeReturnJson("fail:invalid data", com.tencent.luggage.wxa.af.e.f121315k, hashMap8));
    }

    public final Pair a(Context context, com.tencent.luggage.wxa.xd.d dVar, Map map, boolean z16) {
        if (!z16) {
            if (!v.a()) {
                map.put("errCode", Integer.valueOf(COMM.mini_app_qzone_recommend));
                w.b("MicroMsg.JsApiConnectWifi", "fixErrInfo, may be not open GPS");
                return new Pair("fail:may be not open GPS", com.tencent.luggage.wxa.af.b.D);
            }
            boolean a16 = k.a((Activity) context, dVar, "android.permission.ACCESS_FINE_LOCATION");
            w.d("MicroMsg.JsApiConnectWifi", "fixErrInfo, checkLocation:%b", Boolean.valueOf(a16));
            if (!a16) {
                map.put("errCode", 12012);
                w.b("MicroMsg.JsApiConnectWifi", "fixErrInfo, may be not obtain GPS Perrmission");
                return new Pair("fail:may be not obtain GPS Perrmission", com.tencent.luggage.wxa.af.b.E);
            }
        }
        map.put("errCode", 12010);
        return null;
    }
}
