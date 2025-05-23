package com.tencent.luggage.wxa.wc;

import android.graphics.Canvas;
import android.graphics.Path;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements d {
    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, JSONArray jSONArray) {
        return a(canvas, com.tencent.luggage.wxa.bd.e.a().a(jSONArray));
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public String getMethod() {
        return "clip";
    }

    public final boolean a(Canvas canvas, Path path) {
        canvas.clipPath(path);
        return true;
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, com.tencent.luggage.wxa.xc.c cVar) {
        return a(canvas, com.tencent.luggage.wxa.bd.e.a().a((com.tencent.luggage.wxa.yc.c) com.tencent.luggage.wxa.tk.d.a(cVar)));
    }
}
