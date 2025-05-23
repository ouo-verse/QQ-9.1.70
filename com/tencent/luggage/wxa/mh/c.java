package com.tencent.luggage.wxa.mh;

import NS_COMM.COMM;
import android.content.Context;
import android.os.Looper;
import com.tencent.luggage.wxa.h6.k;
import com.tencent.luggage.wxa.nh.f;
import com.tencent.luggage.wxa.nh.g;
import com.tencent.luggage.wxa.tn.e0;
import com.tencent.luggage.wxa.tn.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 317;
    public static final String NAME = "getWifiList";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements e0.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f134577a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f134578b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f134579c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f134580d;

        public a(AtomicBoolean atomicBoolean, com.tencent.luggage.wxa.xd.d dVar, int i3, Context context) {
            this.f134577a = atomicBoolean;
            this.f134578b = dVar;
            this.f134579c = i3;
            this.f134580d = context;
        }

        @Override // com.tencent.luggage.wxa.tn.e0.a
        public boolean a() {
            w.d("MicroMsg.JsApiGetWifiList", "onTimerExpired");
            g.d();
            if (!this.f134577a.get()) {
                c.this.a(this.f134578b, this.f134579c, this.f134580d, g.c());
                this.f134577a.set(true);
                return false;
            }
            w.d("MicroMsg.JsApiGetWifiList", "onTimerExpired, hasCallback");
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements com.tencent.luggage.wxa.nh.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e0 f134582a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f134583b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f134584c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f134585d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Context f134586e;

        public b(e0 e0Var, AtomicBoolean atomicBoolean, com.tencent.luggage.wxa.xd.d dVar, int i3, Context context) {
            this.f134582a = e0Var;
            this.f134583b = atomicBoolean;
            this.f134584c = dVar;
            this.f134585d = i3;
            this.f134586e = context;
        }

        @Override // com.tencent.luggage.wxa.nh.d
        public void a(f fVar) {
            w.d("MicroMsg.JsApiGetWifiList", "onGetWiFiList");
            this.f134582a.f();
            g.d();
            if (!this.f134583b.get()) {
                c.this.a(this.f134584c, this.f134585d, this.f134586e, fVar);
                this.f134583b.set(true);
            } else {
                w.d("MicroMsg.JsApiGetWifiList", "onGetWiFiList, hasCallback");
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.mh.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6477c extends k0 {
        private static final int CTRL_INDEX = 321;
        private static final String NAME = "onGetWifiList";
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        Context context = dVar.getContext();
        if (context == null) {
            w.b("MicroMsg.JsApiGetWifiList", "mContext is null, invoke fail!");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 12010);
            dVar.a(i3, makeReturnJson("fail:context is null", com.tencent.luggage.wxa.af.e.f121309e, hashMap));
            return;
        }
        if (!d.f134588a) {
            w.b("MicroMsg.JsApiGetWifiList", "not invoke startWifi");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 12000);
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.b.B, hashMap2));
            return;
        }
        g.a(context);
        if (!com.tencent.luggage.wxa.oh.d.e()) {
            w.b("MicroMsg.JsApiGetWifiList", "wifi is disable,invoke fail!");
            HashMap hashMap3 = new HashMap();
            hashMap3.put("errCode", 12005);
            dVar.a(i3, makeReturnJson("fail:wifi is disable", com.tencent.luggage.wxa.af.b.C, hashMap3));
            return;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        e0 e0Var = new e0(Looper.getMainLooper(), (e0.a) new a(atomicBoolean, dVar, i3, context), false);
        g.a(new b(e0Var, atomicBoolean, dVar, i3, context));
        long j3 = 10000;
        if (jSONObject != null) {
            j3 = jSONObject.optLong("timeout", 10000L);
        }
        w.d("MicroMsg.JsApiGetWifiList", "invoke, getWifiListAsyncTimeoutMills: " + j3);
        e0Var.a(j3);
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, int i3, Context context, f fVar) {
        if (fVar.f135829a.equals(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS)) {
            try {
                w.d("MicroMsg.JsApiGetWifiList", "onGetWifiList size:%d", Integer.valueOf(fVar.f135830b.size()));
                if (fVar.f135830b.size() == 0) {
                    if (!v.a()) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("errCode", Integer.valueOf(COMM.mini_app_qzone_recommend));
                        dVar.a(i3, makeReturnJson("fail:may be not open GPS", com.tencent.luggage.wxa.af.b.D, hashMap));
                        w.b("MicroMsg.JsApiGetWifiList", "wifiList is empty, may be not open GPS");
                        return;
                    }
                    boolean a16 = k.a(context, dVar, "android.permission.ACCESS_FINE_LOCATION");
                    w.d("MicroMsg.JsApiGetWifiList", "checkLocation:%b", Boolean.valueOf(a16));
                    if (!a16) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("errCode", 12012);
                        dVar.a(i3, makeReturnJson("fail:may be not obtain GPS Perrmission", com.tencent.luggage.wxa.af.b.E, hashMap2));
                        w.b("MicroMsg.JsApiGetWifiList", "wifiList is empty, may be not obtain GPS Perrmission");
                        return;
                    }
                }
                HashMap hashMap3 = new HashMap();
                hashMap3.put("errCode", 0);
                dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a, hashMap3));
                w.a("MicroMsg.JsApiGetWifiList", "onGetWifiList %s", fVar);
                C6477c c6477c = new C6477c();
                HashMap hashMap4 = new HashMap();
                hashMap4.put("wifiList", fVar.a());
                c6477c.setContext(dVar, 0).setData(hashMap4).dispatch();
                return;
            } catch (JSONException e16) {
                w.a("MicroMsg.JsApiGetWifiList", e16, "", new Object[0]);
                HashMap hashMap5 = new HashMap();
                hashMap5.put("errCode", 12010);
                dVar.a(i3, makeReturnJson("fail:parse json err", com.tencent.luggage.wxa.af.e.f121309e, hashMap5));
                return;
            }
        }
        w.b("MicroMsg.JsApiGetWifiList", "error, mErrorMsg:%s", fVar.f135829a);
        HashMap hashMap6 = new HashMap();
        hashMap6.put("errCode", 12010);
        dVar.a(i3, makeReturnJson("fail:" + fVar.f135829a, com.tencent.luggage.wxa.af.e.f121309e, hashMap6));
    }
}
