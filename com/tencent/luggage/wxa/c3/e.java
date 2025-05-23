package com.tencent.luggage.wxa.c3;

import com.tencent.luggage.wxa.kj.n;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends com.tencent.luggage.wxa.v3.h {
    public static final int CTRL_INDEX = 240;
    public static final String NAME = "shareAppMessageDirectly";

    /* renamed from: a, reason: collision with root package name */
    public final j f123263a = new j();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f123264b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f123265c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f123266d;

        public a(JSONObject jSONObject, com.tencent.luggage.wxa.ic.d dVar, int i3) {
            this.f123264b = jSONObject;
            this.f123265c = dVar;
            this.f123266d = i3;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call(Void r46) {
            com.tencent.luggage.wxa.ui.a b16;
            String str;
            try {
                this.f123264b.put("sdk_isFromMenu", false);
                n currentPage = this.f123265c.getRuntime().Y().getCurrentPage();
                if (currentPage != null && (b16 = currentPage.getCurrentPageView().b(com.tencent.luggage.wxa.ui.b.ShareAppMsg.ordinal())) != null) {
                    JSONObject jSONObject = this.f123264b;
                    if (b16.c().c("enable_share_with_share_ticket")) {
                        str = "withShareTicket";
                    } else {
                        str = "common";
                    }
                    jSONObject.put("mode", str);
                }
            } catch (JSONException unused) {
            }
            return com.tencent.luggage.wxa.v3.h.a(this.f123265c, e.this.getName(), this.f123264b, this.f123266d).toString();
        }
    }

    @Override // com.tencent.luggage.wxa.v3.h
    public final com.tencent.luggage.wxa.xo.d c(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
        return this.f123263a.b(dVar, jSONObject).b(new a(jSONObject, dVar, i3));
    }

    @Override // com.tencent.luggage.wxa.v3.h
    public boolean e() {
        return true;
    }
}
