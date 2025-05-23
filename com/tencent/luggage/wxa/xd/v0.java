package com.tencent.luggage.wxa.xd;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class v0 extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 430;
    public static final String NAME = "pageNotFoundCallback";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.m4.b f144886a;

        public a(com.tencent.luggage.wxa.m4.b bVar) {
            this.f144886a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f144886a.l(true);
            this.f144886a.A1();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.r4.d dVar, JSONObject jSONObject, int i3) {
        if (jSONObject == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiPageNotFoundCallback", "data is null, do nothing");
            dVar.a(i3, makeReturnJson("fail"));
            return;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiPageNotFoundCallback", "pageNotFoundCallback data:%s", jSONObject);
        boolean optBoolean = jSONObject.optBoolean("hasHandler", false);
        int optInt = jSONObject.optInt("webviewId", -1);
        com.tencent.luggage.wxa.m4.b J = dVar.J();
        if (optBoolean) {
            if (J != null) {
                J.l(true);
                if (J.c0() != optInt) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiPageNotFoundCallback", "appBrandPageView.getCurrentPageId():%d, webviewId:%d, mismatch", Integer.valueOf(J.c0()), Integer.valueOf(optInt));
                }
            } else {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiPageNotFoundCallback", "appBrandPageView is null");
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiPageNotFoundCallback", "already handler, ignore");
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
            return;
        }
        if (J != null && J.c0() == optInt) {
            J.a(new a(J));
        }
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiPageNotFoundCallback", "currentPageView is null, return");
        dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
    }
}
