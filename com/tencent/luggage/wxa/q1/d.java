package com.tencent.luggage.wxa.q1;

import android.content.Context;
import com.github.henryye.nativeiv.api.IImageDecodeService;
import com.tencent.luggage.wxa.ei.j;
import com.tencent.luggage.wxa.ei.n;
import com.tencent.luggage.wxa.ei.q;
import com.tencent.luggage.wxa.ei.v;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.s1.b;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.w8.f;
import com.tencent.magicbrush.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f137778a;

    /* renamed from: b, reason: collision with root package name */
    public final j f137779b;

    /* renamed from: c, reason: collision with root package name */
    public volatile com.tencent.magicbrush.b f137780c;

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.magicbrush.c f137781d;

    /* renamed from: e, reason: collision with root package name */
    public final a f137782e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends f implements n.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(final Function0 fn5) {
            super(new Runnable() { // from class: com.tencent.luggage.wxa.q1.e
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Function0.this.invoke();
                }
            });
            Intrinsics.checkNotNullParameter(fn5, "fn");
        }

        @Override // com.tencent.luggage.wxa.ei.n.a
        public void onDestroy() {
            run();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function0 {
        public b() {
            super(0);
        }

        public final void a() {
            d dVar = d.this;
            synchronized (dVar) {
                if (dVar.f137780c != null) {
                    com.tencent.magicbrush.b bVar = dVar.f137780c;
                    Intrinsics.checkNotNull(bVar);
                    bVar.c();
                    dVar.f137780c = null;
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f137784a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(v vVar) {
            super(0);
            this.f137784a = vVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.o8.c invoke() {
            return new com.tencent.luggage.wxa.o8.c(this.f137784a.f(), this.f137784a.B(), this.f137784a.j());
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.q1.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6614d extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final C6614d f137785a = new C6614d();

        public C6614d() {
            super(1);
        }

        public final void a(d.b imageHandler) {
            Intrinsics.checkNotNullParameter(imageHandler, "$this$imageHandler");
            imageHandler.a(true);
            imageHandler.a(new b.c(14883));
            imageHandler.a((IImageDecodeService.a) null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((d.b) obj);
            return Unit.INSTANCE;
        }
    }

    public d(Context androidContext, j jsRuntime) {
        Intrinsics.checkNotNullParameter(androidContext, "androidContext");
        Intrinsics.checkNotNullParameter(jsRuntime, "jsRuntime");
        this.f137778a = androidContext;
        this.f137779b = jsRuntime;
        this.f137781d = new com.tencent.magicbrush.c();
        this.f137782e = new a(new b());
    }

    public void a(com.tencent.magicbrush.b magicbrush, long j3) {
        Intrinsics.checkNotNullParameter(magicbrush, "magicbrush");
    }

    public void b(g runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        com.tencent.luggage.wxa.s1.b.f139992e.a(this.f137780c, runtime, true);
    }

    public final void c() {
        w.d("MicroMsg.MagicBrush", "destroy");
        ((n) this.f137779b.a(n.class)).b(this.f137782e);
    }

    public final com.tencent.magicbrush.b d() {
        com.tencent.magicbrush.b bVar = this.f137780c;
        Intrinsics.checkNotNull(bVar);
        return bVar;
    }

    public final com.tencent.magicbrush.b b() {
        long a16 = w0.a();
        a(this.f137781d);
        com.tencent.magicbrush.b r16 = this.f137781d.r();
        Intrinsics.checkNotNull(r16);
        synchronized (this) {
            if (this.f137780c == null) {
                this.f137780c = r16;
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        a(r16, w0.e(a16));
        return r16;
    }

    public void a(com.tencent.magicbrush.c builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.a(this.f137778a);
        builder.a(com.tencent.luggage.wxa.tk.g.a(builder.f()));
        builder.a(b(this.f137779b));
        builder.a(a(this.f137779b));
        builder.a(C6614d.f137785a);
        String e16 = com.tencent.luggage.wxa.db.a.e();
        Intrinsics.checkNotNullExpressionValue(e16, "DATAROOT_SDCARD_PATH()");
        builder.a(e16);
    }

    public final void a(g runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        b(runtime);
    }

    public final void a() {
        w.d("MicroMsg.MagicBrush", "awaitDestroyDone");
        if (!this.f137782e.a(5000L) && com.tencent.luggage.wxa.tn.e.f141559a) {
            throw new IllegalStateException("WAGame destroy timeout");
        }
    }

    public final Function0 b(j jVar) {
        return new c((v) jVar.a(v.class));
    }

    public final com.tencent.luggage.wxa.r8.a a(j jVar) {
        q qVar = (q) jVar.a(q.class);
        if (qVar != null) {
            return new com.tencent.luggage.wxa.q1.a(qVar);
        }
        throw new IllegalStateException("JsRuntime don't support JsThread addon".toString());
    }
}
