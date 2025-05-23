package com.tencent.luggage.wxa.f0;

import android.util.SparseArray;
import com.tencent.luggage.wxa.n0.s;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f125180a = new SparseArray();

    public s a(int i3) {
        s sVar = (s) this.f125180a.get(i3);
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(Long.MAX_VALUE);
        this.f125180a.put(i3, sVar2);
        return sVar2;
    }

    public void a() {
        this.f125180a.clear();
    }
}
