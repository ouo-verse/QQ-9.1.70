package com.tencent.luggage.wxa.ud;

import android.content.Context;
import com.tencent.luggage.wxa.r4.d;
import com.tencent.magicbrush.b;
import com.tencent.magicbrush.ui.g;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a implements b.e {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.w1.a f142285a;

    public a(com.tencent.luggage.wxa.w1.a logicImpl) {
        Intrinsics.checkNotNullParameter(logicImpl, "logicImpl");
        this.f142285a = logicImpl;
    }

    @Override // com.tencent.magicbrush.b.e
    public void a(g gVar, float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4) {
        b.e.a.a(this, gVar, fArr, fArr2, fArr3, fArr4);
    }

    public final com.tencent.luggage.wxa.w1.a b() {
        return this.f142285a;
    }

    @Override // com.tencent.magicbrush.b.e
    public g a() {
        d dVar = (d) this.f142285a.t();
        Context context = dVar != null ? dVar.getContext() : null;
        Intrinsics.checkNotNull(context);
        g gVar = new g(context, g.h.f147524b);
        gVar.setContentDescription("ScreenCanvasMagicBrushView");
        com.tencent.magicbrush.b n3 = this.f142285a.n();
        Intrinsics.checkNotNullExpressionValue(n3, "logicImpl.magicBrush");
        gVar.setMagicBrush(n3);
        gVar.setUseRawAxisTouchEvent(true);
        return gVar;
    }
}
