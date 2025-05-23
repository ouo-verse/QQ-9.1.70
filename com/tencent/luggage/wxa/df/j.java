package com.tencent.luggage.wxa.df;

import com.tencent.luggage.wxa.kj.v;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j extends i {
    private static final int CTRL_INDEX = 111;
    private static final String NAME = "updateTextArea";

    @Override // com.tencent.luggage.wxa.df.i, com.tencent.luggage.wxa.xd.a
    /* renamed from: a */
    public void invoke(v vVar, JSONObject jSONObject, int i3) {
        super.invoke(vVar, jSONObject, i3);
    }

    @Override // com.tencent.luggage.wxa.df.a
    public boolean a(com.tencent.luggage.wxa.vl.i iVar, JSONObject jSONObject, v vVar, int i3) {
        boolean a16 = super.a((com.tencent.luggage.wxa.vl.g) iVar, jSONObject, vVar, i3);
        iVar.f143683u = Boolean.TRUE;
        Object opt = jSONObject.opt(MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM);
        iVar.f143684v = opt == null ? null : com.tencent.luggage.wxa.h6.f.a(opt);
        if (jSONObject.has("adjustKeyboardTo")) {
            iVar.C = jSONObject.optString("adjustKeyboardTo", "cursor");
        }
        return a16;
    }
}
