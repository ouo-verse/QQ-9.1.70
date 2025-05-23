package com.tencent.luggage.wxa.wc;

import android.graphics.Canvas;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes8.dex */
public class u implements d {
    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            return false;
        }
        try {
            return a(dVar, jSONArray.getString(0));
        } catch (JSONException unused) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.SetFontWeight", "get 'fontWeight' error.");
            return false;
        }
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public String getMethod() {
        return CanvasView.ACTION_SET_FONT_WEIGHT;
    }

    public final boolean a(com.tencent.luggage.wxa.vc.d dVar, String str) {
        str.hashCode();
        if (str.equals("normal")) {
            dVar.f().setFakeBoldText(false);
            dVar.d().setFakeBoldText(false);
        } else if (str.equals("bold")) {
            dVar.f().setFakeBoldText(true);
            dVar.d().setFakeBoldText(true);
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, com.tencent.luggage.wxa.xc.c cVar) {
        com.tencent.luggage.wxa.xc.s sVar = (com.tencent.luggage.wxa.xc.s) com.tencent.luggage.wxa.tk.d.a(cVar);
        if (sVar == null) {
            return false;
        }
        return a(dVar, sVar.f144720b);
    }
}
