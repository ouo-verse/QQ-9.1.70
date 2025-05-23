package com.tencent.luggage.wxa.cg;

import com.tencent.luggage.wxa.h1.e;
import com.tencent.luggage.wxa.tn.w;
import java.util.Collections;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {
    public static final String a(com.tencent.luggage.wxa.xd.d dVar, b referrerPolicyContainer, JSONObject data) {
        Intrinsics.checkNotNullParameter(referrerPolicyContainer, "referrerPolicyContainer");
        Intrinsics.checkNotNullParameter(data, "data");
        if (dVar == null) {
            w.f("MicroMsg.AppBrand.Referrers", "updateReferrers, component is null");
            return null;
        }
        a aVar = (a) e.a(a.class);
        if (aVar == null) {
            w.f("MicroMsg.AppBrand.Referrers", "updateReferrers, referrerHelper is null");
            return null;
        }
        if (referrerPolicyContainer.getReferrerPolicy() == null) {
            referrerPolicyContainer.setReferrerPolicy(aVar.s());
        }
        c a16 = aVar.a(data, dVar);
        if (a16 != null) {
            referrerPolicyContainer.setReferrerPolicy(a16);
        }
        w.d("MicroMsg.AppBrand.Referrers", "updateReferrers, referrerPolicy: " + referrerPolicyContainer.getReferrerPolicy());
        if (c.NO_REFERRER == referrerPolicyContainer.getReferrerPolicy()) {
            return null;
        }
        String c16 = aVar.c(dVar);
        w.d("MicroMsg.AppBrand.Referrers", "updateReferrers, mReferrer: " + c16);
        return c16;
    }

    public static final Map a(String str) {
        if (str != null) {
            return Collections.singletonMap("Referer", str);
        }
        return null;
    }
}
