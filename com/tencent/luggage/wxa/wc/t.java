package com.tencent.luggage.wxa.wc;

import android.graphics.Canvas;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes8.dex */
public class t implements d {
    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            return false;
        }
        try {
            return a(dVar, jSONArray.getString(0));
        } catch (JSONException unused) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.SetFontStyle", "get 'fontStyle' error.");
            return false;
        }
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public String getMethod() {
        return CanvasView.ACTION_SET_FONT_STYLE;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0062, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(com.tencent.luggage.wxa.vc.d dVar, String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1657669071:
                if (str.equals("oblique")) {
                    c16 = 0;
                    break;
                }
                break;
            case -1178781136:
                if (str.equals("italic")) {
                    c16 = 1;
                    break;
                }
                break;
            case -1039745817:
                if (str.equals("normal")) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                dVar.f().a(2);
                dVar.d().a(2);
                break;
            case 1:
                dVar.f().a(2);
                dVar.d().a(2);
                break;
            case 2:
                dVar.f().a(0);
                dVar.d().a(0);
                break;
        }
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, com.tencent.luggage.wxa.xc.c cVar) {
        com.tencent.luggage.wxa.xc.r rVar = (com.tencent.luggage.wxa.xc.r) com.tencent.luggage.wxa.tk.d.a(cVar);
        if (rVar == null) {
            return false;
        }
        return a(dVar, rVar.f144719b);
    }
}
