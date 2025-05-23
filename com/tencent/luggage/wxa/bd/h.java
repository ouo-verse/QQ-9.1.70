package com.tencent.luggage.wxa.bd;

import android.graphics.Path;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h implements a {
    @Override // com.tencent.luggage.wxa.bd.a
    public boolean a(Path path, JSONArray jSONArray) {
        if (jSONArray.length() < 2) {
            return false;
        }
        return a(path, com.tencent.luggage.wxa.tk.g.a(jSONArray, 0), com.tencent.luggage.wxa.tk.g.a(jSONArray, 1));
    }

    @Override // com.tencent.luggage.wxa.bd.a
    public String getMethod() {
        return CanvasView.ACTION_MOVETO;
    }

    public final boolean a(Path path, float f16, float f17) {
        path.moveTo(f16, f17);
        return true;
    }

    @Override // com.tencent.luggage.wxa.bd.a
    public boolean a(Path path, com.tencent.luggage.wxa.yc.a aVar) {
        com.tencent.luggage.wxa.yc.h hVar = (com.tencent.luggage.wxa.yc.h) com.tencent.luggage.wxa.tk.d.a(aVar);
        if (hVar == null) {
            return false;
        }
        return a(path, hVar.f145530b, hVar.f145531c);
    }
}
