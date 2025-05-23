package com.tencent.luggage.wxa.w7;

import android.app.Application;
import com.tencent.luggage.wxa.ca.c;
import com.tencent.luggage.wxa.ca.j;
import com.tencent.luggage.wxa.eo.f;
import com.tencent.luggage.wxa.eo.g;
import com.tencent.luggage.wxa.o3.l;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a */
    public static final b f144108a = new b();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements com.tencent.luggage.wxa.go.a {

        /* renamed from: a */
        public static final a f144109a = new a();

        @Override // com.tencent.luggage.wxa.go.a
        public boolean a() {
            return l.f136139a.c();
        }

        @Override // com.tencent.luggage.wxa.go.a
        public boolean b() {
            return false;
        }
    }

    public static /* synthetic */ void a(b bVar, Application application, c cVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            cVar = j.INSTANCE;
        }
        bVar.a(application, cVar);
    }

    public final void a(Application app, c cVar) {
        Intrinsics.checkNotNullParameter(app, "app");
        f a16 = com.tencent.luggage.wxa.w7.a.a();
        a aVar = a.f144109a;
        g.a(app, a16, aVar);
        if (cVar != null) {
            com.tencent.luggage.wxa.ca.b.a(app, cVar, aVar);
        }
    }
}
