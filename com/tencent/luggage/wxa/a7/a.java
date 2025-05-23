package com.tencent.luggage.wxa.a7;

import com.tencent.luggage.wxa.c3.d;
import com.tencent.luggage.wxa.q7.q;
import com.tencent.luggage.wxaapi.WxaAppCustomActionSheetDelegate;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends d {
    @Override // com.tencent.luggage.wxa.v3.h, com.tencent.luggage.wxa.xd.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.r4.d dVar, JSONObject jSONObject, int i3) {
        if (q.f138021a.a(WxaAppCustomActionSheetDelegate.ActionType.onShareAPPMessage, this, dVar, jSONObject, i3)) {
            return;
        }
        super.invoke((com.tencent.luggage.wxa.ic.d) dVar, jSONObject, i3);
    }
}
