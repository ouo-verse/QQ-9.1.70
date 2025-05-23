package com.tencent.luggage.wxa.bd;

import android.graphics.Path;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i implements a {
    @Override // com.tencent.luggage.wxa.bd.a
    public boolean a(Path path, JSONArray jSONArray) {
        if (jSONArray.length() < 4) {
            return false;
        }
        return a(path, com.tencent.luggage.wxa.tk.g.a(jSONArray, 0), com.tencent.luggage.wxa.tk.g.a(jSONArray, 1), com.tencent.luggage.wxa.tk.g.a(jSONArray, 2), com.tencent.luggage.wxa.tk.g.a(jSONArray, 3));
    }

    @Override // com.tencent.luggage.wxa.bd.a
    public String getMethod() {
        return CanvasView.ACTION_QUADRATIC_CURVETO;
    }

    public final boolean a(Path path, float f16, float f17, float f18, float f19) {
        path.quadTo(f16, f17, f18, f19);
        return true;
    }

    @Override // com.tencent.luggage.wxa.bd.a
    public boolean a(Path path, com.tencent.luggage.wxa.yc.a aVar) {
        com.tencent.luggage.wxa.yc.i iVar = (com.tencent.luggage.wxa.yc.i) com.tencent.luggage.wxa.tk.d.a(aVar);
        if (aVar == null) {
            return false;
        }
        return a(path, iVar.f145532b, iVar.f145533c, iVar.f145534d, iVar.f145535e);
    }
}
