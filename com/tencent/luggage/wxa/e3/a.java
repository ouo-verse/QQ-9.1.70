package com.tencent.luggage.wxa.e3;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.luggage.wxa.bk.e;
import com.tencent.luggage.wxa.ic.d;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.ic.n0;
import com.tencent.luggage.wxa.ii.b;
import com.tencent.luggage.wxa.r6.e;
import com.tencent.luggage.wxa.tn.h0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.v4.i;
import com.tencent.luggage.wxa.z4.k;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends com.tencent.luggage.wxa.xd.a {

    @Deprecated
    public static final int CTRL_INDEX = 359;

    @Deprecated
    @NotNull
    public static final String NAME = "updateApp";

    /* renamed from: a, reason: collision with root package name */
    public static final C6147a f124472a = new C6147a(null);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.e3.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6147a {
        public C6147a() {
        }

        public /* synthetic */ C6147a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f124473a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f124474b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f124475c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f124476d;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.e3.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class DialogInterfaceOnClickListenerC6148a implements DialogInterface.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f124477a;

            public DialogInterfaceOnClickListenerC6148a(g gVar) {
                this.f124477a = gVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                this.f124477a.d1();
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.e3.a$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class DialogInterfaceOnClickListenerC6149b implements DialogInterface.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f124478a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f124479b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ a f124480c;

            public DialogInterfaceOnClickListenerC6149b(d dVar, int i3, a aVar) {
                this.f124478a = dVar;
                this.f124479b = i3;
                this.f124480c = aVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                d dVar = this.f124478a;
                if (dVar != null) {
                    dVar.a(this.f124479b, this.f124480c.makeReturnJson("fail user canceled updateApp"));
                }
            }
        }

        public b(g gVar, a aVar, d dVar, int i3) {
            this.f124473a = gVar;
            this.f124474b = aVar;
            this.f124475c = dVar;
            this.f124476d = i3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i3;
            Context L = this.f124473a.L();
            if (L == null) {
                L = this.f124473a.F();
            }
            com.tencent.luggage.wxa.ml.b bVar = new com.tencent.luggage.wxa.ml.b(L);
            g gVar = this.f124473a;
            a aVar = this.f124474b;
            d dVar = this.f124475c;
            int i16 = this.f124476d;
            bVar.setCanceledOnTouchOutside(false);
            bVar.setCancelable(false);
            Context L2 = gVar.L();
            if (L2 == null) {
                L2 = gVar.F();
            }
            if (aVar.a(gVar)) {
                i3 = R.string.yzc;
            } else {
                i3 = R.string.yzd;
            }
            bVar.setMessage(L2.getString(i3, gVar.S().f125809b));
            bVar.setPositiveButton(R.string.yzb, new DialogInterfaceOnClickListenerC6148a(gVar));
            bVar.setNegativeButton(R.string.yza, new DialogInterfaceOnClickListenerC6149b(dVar, i16, aVar));
            this.f124473a.N().a(bVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f124481a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.j4.d f124482b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f124483c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f124484d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ a f124485e;

        public c(g gVar, com.tencent.luggage.wxa.j4.d dVar, d dVar2, int i3, a aVar) {
            this.f124481a = gVar;
            this.f124482b = dVar;
            this.f124483c = dVar2;
            this.f124484d = i3;
            this.f124485e = aVar;
        }

        @Override // com.tencent.luggage.wxa.ii.b.a
        public final void a(com.tencent.luggage.wxa.j4.d dVar, e eVar, int i3) {
            if (dVar == null) {
                d dVar2 = this.f124483c;
                int i16 = this.f124484d;
                a aVar = this.f124485e;
                if (dVar2 != null) {
                    dVar2.a(i16, aVar.makeReturnJson("fail sync error"));
                    return;
                }
                return;
            }
            com.tencent.luggage.wxa.j4.d dVar3 = this.f124482b;
            dVar3.f125809b = dVar.f125809b;
            dVar3.f125810c = dVar.f125810c;
            dVar3.V = dVar.V;
            dVar3.X = dVar.X;
            dVar3.f125812e = dVar.f125812e;
            dVar3.P = dVar.P;
            dVar3.G0 = i.LEGACY;
            String str = dVar.f125808a;
            Intrinsics.checkNotNullExpressionValue(str, "newConfig.appId");
            com.tencent.luggage.wxa.dk.b a16 = com.tencent.luggage.wxa.r6.b.a(str);
            if (a16 != null) {
                String str2 = a16.f124303a;
                Intrinsics.checkNotNullExpressionValue(str2, "it.instanceId");
                dVar.J0 = new com.tencent.luggage.wxa.li.b(str2, "updateApp");
            }
            n0.a(this.f124481a, this.f124482b);
        }
    }

    public final boolean a(g gVar) {
        com.tencent.luggage.wxa.fd.i S = gVar.S();
        com.tencent.luggage.wxa.j4.d dVar = S instanceof com.tencent.luggage.wxa.j4.d ? (com.tencent.luggage.wxa.j4.d) S : null;
        return dVar != null && dVar.I == 4;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(d dVar, JSONObject jSONObject, int i3) {
        g runtime = dVar != null ? dVar.getRuntime() : null;
        if (!(runtime != null && runtime.l0() == 0)) {
            if (runtime != null) {
                runtime.e(new b(runtime, this, dVar, i3));
                return;
            }
            return;
        }
        com.tencent.luggage.wxa.fd.i S = runtime.S();
        com.tencent.luggage.wxa.j4.d dVar2 = S instanceof com.tencent.luggage.wxa.j4.d ? (com.tencent.luggage.wxa.j4.d) S : null;
        if (dVar2 == null) {
            if (dVar != null) {
                dVar.a(i3, makeReturnJson("fail:internal error"));
                return;
            }
            return;
        }
        com.tencent.luggage.wxa.gi.b.b(com.tencent.luggage.wxa.ik.a.class, dVar2.f125808a);
        com.tencent.luggage.wxa.gi.b.a(com.tencent.luggage.wxa.ik.a.class, dVar2.f125808a, "Network:" + h0.e(z.c()));
        com.tencent.luggage.wxa.ki.a aVar = new com.tencent.luggage.wxa.ki.a();
        aVar.f132018b = runtime.getAppId();
        aVar.f132020c = -1;
        aVar.f132022d = runtime.l0();
        aVar.f132026f = runtime.O();
        aVar.f132032i = dVar2.i();
        aVar.f132034j = dVar2.N;
        e.a.a(com.tencent.luggage.wxa.r6.e.f139295y, aVar, k.CREATE_NEW, null, 4, null);
        runtime.d(new com.tencent.luggage.wxa.ii.b(aVar, new c(runtime, dVar2, dVar, i3, this)));
    }
}
