package com.tencent.luggage.wxa.qh;

import android.graphics.Point;
import com.tencent.luggage.wxa.lo.f;
import com.tencent.luggage.wxa.re.d;
import com.tencent.luggage.wxa.uk.n0;
import com.tencent.luggage.wxa.xd.i;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements d {
    @Override // com.tencent.luggage.wxa.re.d
    public int[] a(com.tencent.luggage.wxa.xd.d dVar) {
        if (dVar == null) {
            return new int[2];
        }
        if (dVar instanceof i) {
            return n0.a((i) dVar);
        }
        Point a16 = f.a(dVar.getContext());
        if (a16 == null) {
            return new int[2];
        }
        return new int[]{a16.x, a16.y};
    }
}
