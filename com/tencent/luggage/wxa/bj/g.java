package com.tencent.luggage.wxa.bj;

import com.tencent.luggage.wxa.ic.l;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g implements d, com.tencent.luggage.wxa.ya.b {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ic.g f122920a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedDeque f122921b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements e {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.bj.e
        public final void a() {
            com.tencent.luggage.wxa.jg.a.c(g.this.b().h0());
        }
    }

    public g(com.tencent.luggage.wxa.ic.g rt5) {
        Intrinsics.checkNotNullParameter(rt5, "rt");
        this.f122920a = rt5;
        this.f122921b = new ConcurrentLinkedDeque();
    }

    public void G() {
        this.f122921b.clear();
    }

    @Override // com.tencent.luggage.wxa.bj.d
    public void a(e eVar) {
        if (eVar != null) {
            this.f122921b.add(eVar);
        }
    }

    public final com.tencent.luggage.wxa.ic.g b() {
        return this.f122920a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
    
        if (r0.isRunning() == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c() {
        boolean z16;
        l h06 = this.f122920a.h0();
        if (h06 != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            Iterator it = this.f122921b.iterator();
            while (it.hasNext()) {
                ((e) it.next()).a();
            }
        }
    }

    public void e() {
        a(new a());
    }
}
