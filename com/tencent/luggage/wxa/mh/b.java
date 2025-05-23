package com.tencent.luggage.wxa.mh;

import NS_COMM.COMM;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.tencent.luggage.wxa.h6.k;
import com.tencent.luggage.wxa.nh.g;
import com.tencent.luggage.wxa.tn.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 318;
    public static final String NAME = "getConnectedWifi";

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        boolean z16;
        Context context = dVar.getContext();
        if (context == null) {
            w.b("MicroMsg.JsApiGetConnectedWifi", "mContext is null, invoke fail!");
            Map<String, ? extends Object> hashMap = new HashMap<>();
            hashMap.put("errCode", 12010);
            dVar.a(i3, makeReturnJson("fail:context is null", com.tencent.luggage.wxa.af.e.f121309e, hashMap));
            return;
        }
        if (!d.f134588a) {
            w.b("MicroMsg.JsApiGetConnectedWifi", "not invoke startWifi");
            Map<String, ? extends Object> hashMap2 = new HashMap<>();
            hashMap2.put("errCode", 12000);
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.b.B, hashMap2));
            return;
        }
        g.a(context);
        if (!com.tencent.luggage.wxa.oh.d.e()) {
            w.b("MicroMsg.JsApiGetConnectedWifi", "wifi is disable,invoke fail!");
            Map<String, ? extends Object> hashMap3 = new HashMap<>();
            hashMap3.put("errCode", 12005);
            dVar.a(i3, makeReturnJson("fail:wifi is disable", com.tencent.luggage.wxa.af.b.C, hashMap3));
            return;
        }
        com.tencent.luggage.wxa.nh.b bVar = com.tencent.luggage.wxa.nh.b.f135819a;
        boolean a16 = bVar.a();
        if (jSONObject != null) {
            a16 = jSONObject.optBoolean("acceptIncompleteWiFiInfo", a16);
        }
        com.tencent.luggage.wxa.nh.e a17 = bVar.a(a16);
        if (a17 != null && a17.a()) {
            ConnectivityManager connectivityManager = (ConnectivityManager) z.c().getSystemService("connectivity");
            if (connectivityManager == null) {
                w.b("MicroMsg.JsApiGetConnectedWifi", "ConnectivityManager is null");
                Map<String, ? extends Object> hashMap4 = new HashMap<>();
                hashMap4.put("errCode", 12010);
                dVar.a(i3, makeReturnJson("fail:connectivityManager is null", com.tencent.luggage.wxa.af.e.f121309e, hashMap4));
                return;
            }
            if (jSONObject != null) {
                z16 = jSONObject.optBoolean("checkNetInfo");
            } else {
                z16 = false;
            }
            w.d("MicroMsg.JsApiGetConnectedWifi", "checkNetInfo: " + z16);
            if (z16 || context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    w.b("MicroMsg.JsApiGetConnectedWifi", "netInfo is null");
                    Map<String, ? extends Object> hashMap5 = new HashMap<>();
                    hashMap5.put("errCode", 12010);
                    dVar.a(i3, makeReturnJson("fail:netInfo is null", com.tencent.luggage.wxa.af.b.U, hashMap5));
                    return;
                }
                if (activeNetworkInfo.getDetailedState() != NetworkInfo.DetailedState.CONNECTED) {
                    w.b("MicroMsg.JsApiGetConnectedWifi", "ConnectivityManager is null, detailState:%s", activeNetworkInfo.getDetailedState());
                    Map<String, ? extends Object> hashMap6 = new HashMap<>();
                    hashMap6.put("errCode", 12010);
                    dVar.a(i3, makeReturnJson("fail:detailState is not connected", com.tencent.luggage.wxa.af.b.U, hashMap6));
                    return;
                }
            }
            w.d("MicroMsg.JsApiGetConnectedWifi", "[invoke]currentWifi:%s", a17);
            try {
                HashMap hashMap7 = new HashMap();
                hashMap7.put("wifi", a17.b());
                hashMap7.put("errCode", 0);
                dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a, hashMap7));
                return;
            } catch (JSONException e16) {
                w.a("MicroMsg.JsApiGetConnectedWifi", e16, "", new Object[0]);
                Map<String, ? extends Object> hashMap8 = new HashMap<>();
                hashMap8.put("errCode", 12010);
                dVar.a(i3, makeReturnJson("fail:parse json err", com.tencent.luggage.wxa.af.e.f121309e, hashMap8));
                return;
            }
        }
        if (!com.tencent.luggage.wxa.p003do.d.a() && !v.a()) {
            Map<String, ? extends Object> hashMap9 = new HashMap<>();
            hashMap9.put("errCode", Integer.valueOf(COMM.mini_app_qzone_recommend));
            dVar.a(i3, makeReturnJson("fail:may be not open GPS", com.tencent.luggage.wxa.af.b.D, hashMap9));
            w.b("MicroMsg.JsApiGetConnectedWifi", "wifiList is empty, may be not open GPS");
            return;
        }
        boolean a18 = k.a((Activity) context, dVar, "android.permission.ACCESS_FINE_LOCATION");
        w.d("MicroMsg.JsApiGetConnectedWifi", "checkLocation:%b", Boolean.valueOf(a18));
        if (!a18) {
            Map<String, ? extends Object> hashMap10 = new HashMap<>();
            hashMap10.put("errCode", 12012);
            dVar.a(i3, makeReturnJson("fail:may be not obtain GPS Perrmission", com.tencent.luggage.wxa.af.b.E, hashMap10));
            w.b("MicroMsg.JsApiGetConnectedWifi", "wifiList is empty, may be not obtain GPS Perrmission");
            return;
        }
        if (a17 == null) {
            w.b("MicroMsg.JsApiGetConnectedWifi", "currentWifi is null");
            Map<String, ? extends Object> hashMap11 = new HashMap<>();
            hashMap11.put("errCode", 12010);
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.b.F, hashMap11));
            return;
        }
        w.b("MicroMsg.JsApiGetConnectedWifi", "currentWifi is invalid");
        dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.b.G));
    }
}
