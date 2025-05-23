package com.tencent.luggage.wxa.wc;

import android.graphics.Canvas;
import com.tencent.luggage.wxa.ad.a;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h0 implements d {
    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 1) {
            return false;
        }
        return a(dVar, jSONArray.optString(0));
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public String getMethod() {
        return CanvasView.ACTION_SET_BASELINE;
    }

    public final boolean a(com.tencent.luggage.wxa.vc.d dVar, String str) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.SetTextBaselineAction", "SetTextBaselineAction, align:%s", str);
        if ("top".equalsIgnoreCase(str)) {
            com.tencent.luggage.wxa.ad.a f16 = dVar.f();
            a.EnumC5993a enumC5993a = a.EnumC5993a.TOP;
            f16.a(enumC5993a);
            dVar.d().a(enumC5993a);
        } else if ("middle".equalsIgnoreCase(str)) {
            com.tencent.luggage.wxa.ad.a f17 = dVar.f();
            a.EnumC5993a enumC5993a2 = a.EnumC5993a.MIDDLE;
            f17.a(enumC5993a2);
            dVar.d().a(enumC5993a2);
        } else if ("bottom".equalsIgnoreCase(str)) {
            com.tencent.luggage.wxa.ad.a f18 = dVar.f();
            a.EnumC5993a enumC5993a3 = a.EnumC5993a.BOTTOM;
            f18.a(enumC5993a3);
            dVar.d().a(enumC5993a3);
        } else if ("normal".equalsIgnoreCase(str)) {
            com.tencent.luggage.wxa.ad.a f19 = dVar.f();
            a.EnumC5993a enumC5993a4 = a.EnumC5993a.NORMAL;
            f19.a(enumC5993a4);
            dVar.d().a(enumC5993a4);
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, com.tencent.luggage.wxa.xc.c cVar) {
        com.tencent.luggage.wxa.xc.d0 d0Var = (com.tencent.luggage.wxa.xc.d0) com.tencent.luggage.wxa.tk.d.a(cVar);
        if (d0Var == null) {
            return false;
        }
        return a(dVar, d0Var.f144676b);
    }
}
