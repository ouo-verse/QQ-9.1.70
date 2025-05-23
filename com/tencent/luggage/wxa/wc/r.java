package com.tencent.luggage.wxa.wc;

import android.graphics.Canvas;
import android.text.TextUtils;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes8.dex */
public class r implements d {
    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            return false;
        }
        try {
            return a(dVar, jSONArray.getString(0));
        } catch (JSONException unused) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.SetFontFamily", "get 'fontFamily' error.");
            return false;
        }
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public String getMethod() {
        return CanvasView.ACTION_SET_FONT_FAMILY;
    }

    public final boolean a(com.tencent.luggage.wxa.vc.d dVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        dVar.f().a(str);
        dVar.d().a(str);
        return true;
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, com.tencent.luggage.wxa.xc.c cVar) {
        com.tencent.luggage.wxa.xc.p pVar = (com.tencent.luggage.wxa.xc.p) com.tencent.luggage.wxa.tk.d.a(cVar);
        if (pVar == null) {
            return false;
        }
        return a(dVar, pVar.f144717b);
    }
}
