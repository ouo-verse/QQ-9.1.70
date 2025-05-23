package com.xiaomi.push;

import android.content.Context;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes28.dex */
public class bp implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private String f388308d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<Context> f388309e;

    public bp(String str, WeakReference<Context> weakReference) {
        this.f388308d = str;
        this.f388309e = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        WeakReference<Context> weakReference = this.f388309e;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        if (av.a(this.f388308d) > aq.f388204b) {
            bs m3 = bs.m(this.f388308d);
            br o16 = br.o(this.f388308d);
            m3.k(o16);
            o16.k(bq.n(context, this.f388308d, 1000));
            bw.b(context).e(m3);
            return;
        }
        jz4.c.w("=====> do not need clean db");
    }
}
