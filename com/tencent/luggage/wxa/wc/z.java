package com.tencent.luggage.wxa.wc;

import android.graphics.Canvas;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes8.dex */
public class z implements d {
    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, com.tencent.luggage.wxa.xc.c cVar) {
        return false;
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public String getMethod() {
        return "setLineHeight";
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            return false;
        }
        try {
            com.tencent.luggage.wxa.tk.g.d(jSONArray, 0);
        } catch (JSONException unused) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.SetLineHeight", "get 'lineHeight' error");
        }
        return false;
    }
}
