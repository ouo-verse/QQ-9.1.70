package com.tencent.luggage.wxa.bd;

import android.graphics.Path;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j implements a {
    @Override // com.tencent.luggage.wxa.bd.a
    public boolean a(Path path, JSONArray jSONArray) {
        if (jSONArray.length() < 4) {
            return false;
        }
        return a(path, com.tencent.luggage.wxa.tk.g.a(jSONArray, 0), com.tencent.luggage.wxa.tk.g.a(jSONArray, 1), com.tencent.luggage.wxa.tk.g.a(jSONArray, 2), com.tencent.luggage.wxa.tk.g.a(jSONArray, 3));
    }

    @Override // com.tencent.luggage.wxa.bd.a
    public String getMethod() {
        return CanvasView.ACTION_RECT;
    }

    public final boolean a(Path path, float f16, float f17, float f18, float f19) {
        path.addRect(f16, f17, f16 + f18, f17 + f19, Path.Direction.CW);
        return true;
    }

    @Override // com.tencent.luggage.wxa.bd.a
    public boolean a(Path path, com.tencent.luggage.wxa.yc.a aVar) {
        com.tencent.luggage.wxa.yc.j jVar = (com.tencent.luggage.wxa.yc.j) com.tencent.luggage.wxa.tk.d.a(aVar);
        if (jVar == null) {
            return false;
        }
        return a(path, jVar.f145536b, jVar.f145537c, jVar.f145538d, jVar.f145539e);
    }
}
