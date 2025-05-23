package com.tencent.luggage.wxa.uk;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class p0 implements com.tencent.luggage.wxa.cg.a {

    /* renamed from: a, reason: collision with root package name */
    public static final p0 f142776a = new p0();

    /* renamed from: b, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.cg.c f142777b = com.tencent.luggage.wxa.cg.c.NO_REFERRER;

    @Override // com.tencent.luggage.wxa.cg.a
    public String a(JSONObject data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!data.has("referrerPolicy")) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.WxaReferrerHelper", "parseReferrerPolicyStr, referrerPolicy does not exist");
            return null;
        }
        String referrerPolicyStr = data.optString("referrerPolicy");
        Intrinsics.checkNotNullExpressionValue(referrerPolicyStr, "referrerPolicyStr");
        if (!(referrerPolicyStr.length() == 0)) {
            return referrerPolicyStr;
        }
        com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrand.WxaReferrerHelper", "parseReferrerPolicyStr, referrerPolicyStr is empty");
        return null;
    }

    @Override // com.tencent.luggage.wxa.cg.a
    public com.tencent.luggage.wxa.cg.c b(com.tencent.luggage.wxa.xd.d component) {
        Intrinsics.checkNotNullParameter(component, "component");
        com.tencent.luggage.wxa.yi.a aVar = (com.tencent.luggage.wxa.yi.a) component.a(com.tencent.luggage.wxa.yi.a.class);
        if (aVar == null) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrand.WxaReferrerHelper", "parseReferrerPolicyFallback, networkConfig is null");
            return null;
        }
        return aVar.L;
    }

    @Override // com.tencent.luggage.wxa.cg.a
    public String c(com.tencent.luggage.wxa.xd.d component) {
        boolean z16;
        Intrinsics.checkNotNullParameter(component, "component");
        com.tencent.luggage.wxa.yi.a aVar = (com.tencent.luggage.wxa.yi.a) component.a(com.tencent.luggage.wxa.yi.a.class);
        if (aVar == null) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrand.WxaReferrerHelper", "provideReferrer, networkConfig is null");
            return null;
        }
        String referrer = aVar.M;
        Intrinsics.checkNotNullExpressionValue(referrer, "referrer");
        if (referrer.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrand.WxaReferrerHelper", "provideReferrer, referrer is empty");
            return null;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.WxaReferrerHelper", "provide, referrer: " + referrer);
        return referrer;
    }

    @Override // com.tencent.luggage.wxa.cg.a
    public com.tencent.luggage.wxa.cg.c e(String referrerPolicyStr) {
        com.tencent.luggage.wxa.cg.c cVar;
        Intrinsics.checkNotNullParameter(referrerPolicyStr, "referrerPolicyStr");
        if (Intrinsics.areEqual(referrerPolicyStr, TtmlNode.ATTR_TTS_ORIGIN)) {
            cVar = com.tencent.luggage.wxa.cg.c.ORIGIN;
        } else if (Intrinsics.areEqual(referrerPolicyStr, "no-referrer")) {
            cVar = com.tencent.luggage.wxa.cg.c.NO_REFERRER;
        } else {
            cVar = null;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.WxaReferrerHelper", "parseReferrerPolicy, referrerPolicy: " + cVar);
        return cVar;
    }

    @Override // com.tencent.luggage.wxa.cg.a
    public com.tencent.luggage.wxa.cg.c s() {
        return f142777b;
    }

    @Override // com.tencent.luggage.wxa.cg.a
    public com.tencent.luggage.wxa.cg.c a(JSONObject data, com.tencent.luggage.wxa.xd.d component) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(component, "component");
        String a16 = a(data);
        if (a16 == null) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.WxaReferrerHelper", "parseReferrerPolicyOrFallback, referrerPolicyStr is null");
            return b(component);
        }
        com.tencent.luggage.wxa.cg.c e16 = e(a16);
        return e16 == null ? b(component) : e16;
    }
}
