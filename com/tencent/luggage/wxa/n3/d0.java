package com.tencent.luggage.wxa.n3;

import android.widget.Toast;
import com.tencent.luggage.wxa.n3.q;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    public static final d0 f135160a = new d0();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.hn.h f135161a;

        public a(com.tencent.luggage.wxa.hn.h hVar) {
            this.f135161a = hVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Toast.makeText(com.tencent.luggage.wxa.tn.z.c(), this.f135161a.f127730e, 1).show();
        }
    }

    public final void a(com.tencent.luggage.wxa.hn.h hVar) {
        Intrinsics.checkNotNullParameter(hVar, "<this>");
        q qVar = (q) com.tencent.luggage.wxa.eo.g.a(q.class);
        Unit unit = null;
        if (qVar != null) {
            qVar.a(null, new q.a(hVar.f127729d, hVar.f127730e));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            com.tencent.luggage.wxa.tn.c0.a(new a(hVar));
        }
    }
}
