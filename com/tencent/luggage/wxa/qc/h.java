package com.tencent.luggage.wxa.qc;

import android.os.Looper;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class h extends com.tencent.luggage.wxa.wn.c {
    public h(String str, Looper looper) {
        super(str, looper);
    }

    public void a(String str, Object... objArr) {
        w.b(h(), str, objArr);
    }

    @Override // com.tencent.luggage.wxa.wn.c
    public void m(String str) {
        w.b(h(), str);
    }

    public void n(String str) {
        w.d(h(), str);
    }

    public void o(String str) {
        w.e(h(), str);
    }

    public void p(String str) {
        w.f(h(), str);
    }
}
