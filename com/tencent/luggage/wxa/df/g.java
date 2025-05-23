package com.tencent.luggage.wxa.df;

import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.ol.r;
import com.tencent.luggage.wxa.xd.o1;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 77;
    private static final String NAME = "setKeyboardValue";

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
        Integer num;
        v a16 = o1.a(dVar);
        if (a16 != null && a16.isRunning()) {
            try {
                String string = jSONObject.getString("value");
                try {
                    num = Integer.valueOf(jSONObject.getInt("cursor"));
                } catch (Exception unused) {
                    num = null;
                }
                r.a(a16, string, num);
                dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
                return;
            } catch (Exception unused2) {
                dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121315k));
                return;
            }
        }
        dVar.a(i3, makeReturnJson("fail current page not available"));
    }
}
