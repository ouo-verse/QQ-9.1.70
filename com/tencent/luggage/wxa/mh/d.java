package com.tencent.luggage.wxa.mh;

import android.content.Context;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.mh.a;
import com.tencent.luggage.wxa.nh.a;
import com.tencent.luggage.wxa.nh.g;
import com.tencent.luggage.wxa.tn.w;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 314;
    public static final String NAME = "startWifi";

    /* renamed from: a, reason: collision with root package name */
    public static boolean f134588a = false;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f134591a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f134592b;

        public b(Context context, com.tencent.luggage.wxa.xd.d dVar) {
            this.f134591a = context;
            this.f134592b = dVar;
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onDestroy() {
            com.tencent.luggage.wxa.nh.a.a(this.f134591a);
            d.f134588a = false;
            com.tencent.luggage.wxa.ic.e.b(this.f134592b.getAppId(), this);
        }
    }

    public final void b(com.tencent.luggage.wxa.xd.d dVar) {
        try {
            a.c cVar = new a.c();
            HashMap hashMap = new HashMap();
            hashMap.put("wifi", new com.tencent.luggage.wxa.nh.e().b());
            cVar.setContext(dVar, 0).setData(hashMap).dispatch();
        } catch (JSONException e16) {
            w.b("MicroMsg.JsApiStartWifi", "mWiFiEventReceiver is error");
            w.a("MicroMsg.JsApiStartWifi", e16, "", new Object[0]);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        w.d("MicroMsg.JsApiStartWifi", "invoke startWifi");
        Context a16 = com.tencent.luggage.wxa.ye.c.a(dVar.getContext());
        if (a16 == null) {
            w.b("MicroMsg.JsApiStartWifi", "mContext is null, invoke fail!");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 12010);
            dVar.a(i3, makeReturnJson("fail:context is null", com.tencent.luggage.wxa.af.e.f121309e, hashMap));
            return;
        }
        g.a(a16);
        if (!f134588a) {
            com.tencent.luggage.wxa.nh.a.b(a16);
            com.tencent.luggage.wxa.nh.a.a(new a(dVar));
            f134588a = true;
        }
        com.tencent.luggage.wxa.ic.e.a(dVar.getAppId(), new b(a16, dVar));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("errCode", 0);
        dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a, hashMap2));
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements a.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f134589a;

        public a(com.tencent.luggage.wxa.xd.d dVar) {
            this.f134589a = dVar;
        }

        @Override // com.tencent.luggage.wxa.nh.a.b
        public void a(com.tencent.luggage.wxa.nh.e eVar) {
            if (!eVar.a()) {
                w.f("MicroMsg.JsApiStartWifi", "onConnectAcceptIncomplete, wifiItem is invalid");
                return;
            }
            try {
                a.d dVar = new a.d();
                HashMap hashMap = new HashMap();
                hashMap.put("wifi", eVar.b());
                dVar.setContext(this.f134589a, 0).setData(hashMap).dispatch();
            } catch (JSONException e16) {
                w.b("MicroMsg.JsApiStartWifi", "onConnectAcceptIncomplete error");
                w.a("MicroMsg.JsApiStartWifi", e16, "", new Object[0]);
            }
        }

        @Override // com.tencent.luggage.wxa.nh.a.b
        public void b(com.tencent.luggage.wxa.nh.e eVar) {
            if (!eVar.a()) {
                w.f("MicroMsg.JsApiStartWifi", "onConnect, wifiItem is invalid");
                return;
            }
            try {
                a.c cVar = new a.c();
                HashMap hashMap = new HashMap();
                hashMap.put("wifi", eVar.b());
                cVar.setContext(this.f134589a, 0).setData(hashMap).dispatch();
            } catch (JSONException e16) {
                w.b("MicroMsg.JsApiStartWifi", "onConnect error");
                w.a("MicroMsg.JsApiStartWifi", e16, "", new Object[0]);
            }
        }

        @Override // com.tencent.luggage.wxa.nh.a.b
        public void a() {
            d.this.b(this.f134589a);
        }
    }
}
