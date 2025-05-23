package com.tencent.luggage.wxa.bd;

import android.graphics.Path;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d implements a {
    @Override // com.tencent.luggage.wxa.bd.a
    public boolean a(Path path, JSONArray jSONArray) {
        if (jSONArray.length() < 6) {
            return false;
        }
        return a(path, com.tencent.luggage.wxa.tk.g.a(jSONArray, 0), com.tencent.luggage.wxa.tk.g.a(jSONArray, 1), com.tencent.luggage.wxa.tk.g.a(jSONArray, 2), com.tencent.luggage.wxa.tk.g.a(jSONArray, 3), com.tencent.luggage.wxa.tk.g.a(jSONArray, 4), com.tencent.luggage.wxa.tk.g.a(jSONArray, 5));
    }

    @Override // com.tencent.luggage.wxa.bd.a
    public String getMethod() {
        return CanvasView.ACTION_QBEZIER_CURVETO;
    }

    public final boolean a(Path path, float f16, float f17, float f18, float f19, float f26, float f27) {
        path.cubicTo(f16, f17, f18, f19, f26, f27);
        return true;
    }

    @Override // com.tencent.luggage.wxa.bd.a
    public boolean a(Path path, com.tencent.luggage.wxa.yc.a aVar) {
        com.tencent.luggage.wxa.yc.f fVar = (com.tencent.luggage.wxa.yc.f) com.tencent.luggage.wxa.tk.d.a(aVar);
        if (fVar == null) {
            return false;
        }
        return a(path, fVar.f145522b, fVar.f145523c, fVar.f145524d, fVar.f145525e, fVar.f145526f, fVar.f145527g);
    }
}
