package com.tencent.luggage.wxa.d2;

import android.graphics.Rect;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.ok.n;
import com.tencent.luggage.wxa.ok.r;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends r {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(g rt5) {
        super(rt5);
        Intrinsics.checkNotNullParameter(rt5, "rt");
    }

    @Override // com.tencent.luggage.wxa.ok.r, com.tencent.luggage.wxa.ok.n
    public n.a W() {
        n.a W = super.W();
        return new n.a(W.b(), W.d() + a(b(), R.dimen.c1z), a(b(), R.dimen.c1e) + a(b(), R.dimen.c1y), W.a());
    }

    @Override // com.tencent.luggage.wxa.ok.r, com.tencent.luggage.wxa.ok.n
    public int a(l service) {
        int i3;
        Intrinsics.checkNotNullParameter(service, "service");
        int a16 = super.a(service);
        if (a16 <= 0) {
            Rect safeAreaInsets = service.D().getSafeAreaInsets();
            if (safeAreaInsets != null) {
                i3 = safeAreaInsets.top;
            } else {
                i3 = 0;
            }
            return Math.max(a16, i3);
        }
        return a16;
    }
}
