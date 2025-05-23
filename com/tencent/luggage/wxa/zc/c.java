package com.tencent.luggage.wxa.zc;

import android.graphics.Paint;
import com.tencent.luggage.wxa.tk.g;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c extends a {

    /* renamed from: b, reason: collision with root package name */
    public static final c f146486b = new c();

    public static c c() {
        return f146486b;
    }

    @Override // com.tencent.luggage.wxa.zc.a
    public void a(com.tencent.luggage.wxa.ad.a aVar) {
        aVar.reset();
        aVar.e();
        aVar.setStyle(Paint.Style.STROKE);
        aVar.setAntiAlias(true);
        aVar.setStrokeWidth(g.a(1));
        super.a(aVar);
    }

    @Override // com.tencent.luggage.wxa.zc.a
    public com.tencent.luggage.wxa.ad.a b() {
        com.tencent.luggage.wxa.ad.a aVar = new com.tencent.luggage.wxa.ad.a();
        aVar.setStyle(Paint.Style.STROKE);
        aVar.setAntiAlias(true);
        aVar.setStrokeWidth(g.a(1));
        return aVar;
    }
}
