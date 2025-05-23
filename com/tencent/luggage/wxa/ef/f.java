package com.tencent.luggage.wxa.ef;

import android.os.Bundle;
import com.tencent.luggage.wxa.ef.o;
import com.tencent.luggage.wxa.qc.c;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f extends e {
    private static final int CTRL_INDEX = 586;
    public static final String NAME = "enableLocationUpdateBackground";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements o.e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f124679a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.l f124680b;

        public a(p pVar, com.tencent.luggage.wxa.ic.l lVar) {
            this.f124679a = pVar;
            this.f124680b = lVar;
        }

        @Override // com.tencent.luggage.wxa.ef.o.e
        public void a(String str) {
            char c16;
            int hashCode = str.hashCode();
            if (hashCode != -1562453447) {
                if (hashCode != -1514425717) {
                    if (hashCode == 1073716042 && str.equals("StateListening")) {
                        c16 = 0;
                    }
                    c16 = '\uffff';
                } else {
                    if (str.equals("StateSuspend")) {
                        c16 = 2;
                    }
                    c16 = '\uffff';
                }
            } else {
                if (str.equals("StateNotListening")) {
                    c16 = 1;
                }
                c16 = '\uffff';
            }
            if (c16 != 0) {
                if (c16 == 1) {
                    w.d("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "STATE_NOT_LISTENING, stop blink");
                    if (this.f124679a.w() != null) {
                        this.f124679a.w().b(this.f124680b.getRuntime());
                        return;
                    }
                    return;
                }
                return;
            }
            w.d("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "STATE_LISTENING, start blink");
            if (this.f124679a.w() != null) {
                this.f124679a.w().a(this.f124680b.getRuntime());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements c.InterfaceC6640c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f124682a;

        public b(p pVar) {
            this.f124682a = pVar;
        }

        @Override // com.tencent.luggage.wxa.qc.c.InterfaceC6640c
        public void a(String str, com.tencent.luggage.wxa.qc.b bVar) {
            if (bVar == com.tencent.luggage.wxa.qc.b.DESTROYED) {
                w.d("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.DESTROYED, uninit");
                this.f124682a.v();
                return;
            }
            if (bVar == com.tencent.luggage.wxa.qc.b.SUSPEND) {
                w.d("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.SUSPEND, suspendListening");
                this.f124682a.u();
                return;
            }
            if (bVar == com.tencent.luggage.wxa.qc.b.FOREGROUND) {
                w.d("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.FOREGROUND, resumeListening");
                this.f124682a.r();
            } else if (bVar == com.tencent.luggage.wxa.qc.b.BACKGROUND) {
                if (!this.f124682a.p()) {
                    w.d("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.BACKGROUND, stopListening");
                    this.f124682a.t();
                } else {
                    w.d("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.BACKGROUND, do nothing");
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.ef.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public o c(com.tencent.luggage.wxa.ic.l lVar) {
        return new p(lVar);
    }

    @Override // com.tencent.luggage.wxa.ef.e, com.tencent.luggage.wxa.ef.a
    public void a(com.tencent.luggage.wxa.ic.l lVar, JSONObject jSONObject, int i3) {
        super.a((com.tencent.luggage.wxa.xd.d) lVar, jSONObject, i3);
        o oVar = this.f124678b;
        if (!(oVar instanceof p)) {
            w.f("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "state manager not RuntimeLocationUpdateStateManagerWxa");
            lVar.a(i3, makeReturnJson("fail:system error"));
            return;
        }
        p pVar = (p) oVar;
        m w3 = pVar.w();
        if (w3 != null) {
            w3.a();
        }
        if (w3 == null || !pVar.p()) {
            w3 = new m();
        }
        pVar.a(w3);
        w3.a(lVar.getRuntime());
        pVar.a(new a(pVar, lVar));
        c.InterfaceC6640c x16 = pVar.x();
        if (x16 != null) {
            lVar.getRuntime().c0().b(x16);
        }
        if (x16 == null || !pVar.p()) {
            x16 = new b(pVar);
        }
        lVar.getRuntime().c0().a(x16);
        pVar.a(x16);
        pVar.b(true);
    }

    @Override // com.tencent.luggage.wxa.ef.e
    public Bundle a(com.tencent.luggage.wxa.ic.l lVar, JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        String optString = jSONObject.optString("subKey", "");
        String appId = lVar.getAppId();
        if (!w0.c(optString)) {
            bundle.putString("smallAppKey", optString + "#" + appId + ";");
        }
        bundle.putBoolean("enableIndoor", jSONObject.optBoolean("enableIndoor", false));
        if (lVar.getRuntime() != null && lVar.getRuntime().j0() != null) {
            bundle.putString("openId", ((com.tencent.luggage.wxa.j4.g) lVar.getRuntime().j0()).f130834j0);
        }
        w.g("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "enableLocationUpdate %s", jSONObject);
        return bundle;
    }
}
