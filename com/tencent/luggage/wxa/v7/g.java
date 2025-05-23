package com.tencent.luggage.wxa.v7;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.luggage.ui.WxaSimpleWebViewActivity;
import com.tencent.luggage.wxa.h6.p;
import com.tencent.luggage.wxa.i1.a;
import com.tencent.luggage.wxa.n4.a;
import com.tencent.luggage.wxa.ok.o;
import com.tencent.luggage.wxa.q7.e0;
import com.tencent.luggage.wxa.q7.x;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.x7.i;
import com.tencent.luggage.wxa.xd.d0;
import java.util.concurrent.Future;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g extends com.tencent.luggage.wxa.v7.a {

    /* renamed from: b, reason: collision with root package name */
    public static final g f143305b = new g();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements z.a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f143306a = new a();

        @Override // com.tencent.luggage.wxa.tn.z.a
        public final AssetManager a(AssetManager manager) {
            x xVar = x.f138214a;
            Context c16 = z.c();
            Intrinsics.checkNotNullExpressionValue(c16, "getContext()");
            Intrinsics.checkNotNullExpressionValue(manager, "manager");
            return xVar.a(c16, manager);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends com.tencent.luggage.wxa.w5.b {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements d0 {

            /* renamed from: a, reason: collision with root package name */
            public static final a f143307a = new a();

            @Override // com.tencent.luggage.wxa.xd.d0
            public final void a(Context context, String str, String str2, d0.a aVar) {
                WxaSimpleWebViewActivity.INSTANCE.a(context, str);
            }
        }

        public b(Application application) {
            super(application);
        }

        @Override // com.tencent.luggage.wxa.w5.b, com.tencent.luggage.wxa.h4.b, com.tencent.luggage.wxa.h4.c, com.tencent.luggage.wxa.j1.a, com.tencent.luggage.wxa.i1.a.c
        public void a(a.d initializer) {
            Intrinsics.checkNotNullParameter(initializer, "initializer");
            super.a(initializer);
            com.tencent.luggage.wxa.h1.e.a(o.class, com.tencent.luggage.wxa.k7.f.f131770a);
            com.tencent.luggage.wxa.h1.e.a(d0.class, a.f143307a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements com.tencent.luggage.wxa.cc.b {

        /* renamed from: a, reason: collision with root package name */
        public static final c f143308a = new c();

        @Override // com.tencent.luggage.wxa.cc.b
        public final Future a(Runnable runnable, long j3, long j16) {
            return com.tencent.luggage.wxa.zp.h.f146825d.a(runnable, j3, j16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements com.tencent.luggage.wxa.n4.b {
        @Override // com.tencent.luggage.wxa.n4.b
        public JSONObject a(String str) {
            return new JSONObject();
        }

        @Override // com.tencent.luggage.wxa.n4.b
        public String b(String str) {
            return com.tencent.luggage.wxa.im.a.b().a(str, "", true, true);
        }
    }

    @Override // com.tencent.luggage.wxa.v7.a, com.tencent.luggage.wxa.v7.e
    public void a(Context context) {
        Application application;
        Intrinsics.checkNotNullParameter(context, "context");
        super.a(context);
        if (context instanceof Application) {
            application = (Application) context;
        } else {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
            application = (Application) applicationContext;
        }
        z.a(a.f143306a);
        com.tencent.luggage.wxa.e7.a.f124576a.a(application);
        com.tencent.luggage.wxa.i1.a.a(new b(application));
        com.tencent.luggage.wxa.t6.e.f140872a.a(application);
        String i3 = z.i();
        Intrinsics.checkNotNullExpressionValue(i3, "getProcessName()");
        new com.tencent.luggage.wxa.b5.b(i3).b();
        i.f144642a.a();
        com.tencent.luggage.wxa.u7.c.f142142a.a();
        com.tencent.luggage.wxa.vk.a.INST.init(application);
        com.tencent.luggage.wxa.t6.h.f140879a.a(application);
        com.tencent.luggage.wxa.b6.c.a();
        com.tencent.luggage.wxa.f7.g.f125459c.c();
        com.tencent.luggage.wxa.ec.a.a(c.f143308a);
        com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.bi.b.class, new p());
        e0.f137956a.a();
        a.b.f135289a.a(new d());
    }
}
