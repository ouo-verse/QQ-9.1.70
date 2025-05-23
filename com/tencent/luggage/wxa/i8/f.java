package com.tencent.luggage.wxa.i8;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.View;
import com.tencent.luggage.wxa.a8.d;
import com.tencent.luggage.wxa.ag.h;
import com.tencent.luggage.wxa.ag.i;
import com.tencent.luggage.wxa.ai.k;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f extends com.tencent.luggage.wxa.a8.c {

    /* renamed from: d, reason: collision with root package name */
    public static i.a f129606d = new a();

    /* renamed from: e, reason: collision with root package name */
    public static com.tencent.luggage.wxa.ag.d f129607e = new b();

    /* renamed from: c, reason: collision with root package name */
    public final h f129608c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements i.a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.i8.f$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6289a extends com.tencent.luggage.wxa.a8.d {

            /* renamed from: h, reason: collision with root package name */
            public final /* synthetic */ k f129609h;

            public C6289a(k kVar) {
                this.f129609h = kVar;
            }

            @Override // com.tencent.luggage.wxa.ag.i
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public c a(Context context) {
                w.a(this.f120909a, "createVideoContainerView");
                c cVar = new c(context);
                k kVar = this.f129609h;
                kVar.a(new d(kVar, cVar));
                return cVar;
            }

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.i8.f$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class C6290a extends d.e {

                /* renamed from: e, reason: collision with root package name */
                public Surface f129611e;

                public C6290a(c cVar, Runnable runnable) {
                    super(cVar, runnable);
                    this.f129611e = null;
                }

                @Override // com.tencent.luggage.wxa.a8.d.e
                public boolean a(Surface surface, int i3, int i16) {
                    Surface surface2 = this.f129611e;
                    if (surface2 != null && surface2 == surface) {
                        return true;
                    }
                    try {
                        boolean a16 = C6289a.this.f129609h.a(surface);
                        if (a16) {
                            this.f129611e = surface;
                        }
                        return a16;
                    } catch (Exception unused) {
                        return false;
                    }
                }

                @Override // com.tencent.luggage.wxa.a8.d.e
                public void a() {
                    C6289a.this.a((Runnable) null);
                }
            }

            @Override // com.tencent.luggage.wxa.a8.d
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d.e c(c cVar, Runnable runnable) {
                return new C6290a(cVar, runnable);
            }

            public final void a(Runnable runnable) {
                Surface c16 = this.f129609h.c();
                if (c16 != null && c16.isValid()) {
                    try {
                        this.f129609h.a(c16);
                        if (runnable != null) {
                            SurfaceTexture d16 = this.f129609h.d();
                            if (d16 != null) {
                                a(runnable, d16);
                            } else {
                                w.d(this.f120909a, "transferFrom, run afterTransferFromTask when originSurfaceTexture is null");
                                runnable.run();
                            }
                        }
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                }
                w.f(this.f120909a, "transferFrom, originSurface is invalid");
                if (runnable != null) {
                    w.d(this.f120909a, "transferFrom, run afterTransferFromTask when originSurface is invalid");
                    runnable.run();
                }
            }

            @Override // com.tencent.luggage.wxa.a8.d, com.tencent.luggage.wxa.ag.i
            public void b(c cVar, Runnable runnable) {
                w.d(this.f120909a, "transferFrom, textureView: " + cVar);
                super.b((View) cVar, runnable);
                a(runnable);
            }
        }

        @Override // com.tencent.luggage.wxa.ag.i.a
        public i a(k kVar) {
            return new C6289a(kVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements com.tencent.luggage.wxa.ag.d {
        @Override // com.tencent.luggage.wxa.ag.d
        public com.tencent.luggage.wxa.ag.a a(int i3) {
            com.tencent.luggage.wxa.ci.b bVar = new com.tencent.luggage.wxa.ci.b();
            bVar.setData("videoPlayerId", Integer.valueOf(i3));
            return bVar;
        }

        @Override // com.tencent.luggage.wxa.ag.d
        public com.tencent.luggage.wxa.ag.a b(int i3) {
            com.tencent.luggage.wxa.ci.a aVar = new com.tencent.luggage.wxa.ci.a();
            aVar.setData("videoPlayerId", Integer.valueOf(i3));
            return aVar;
        }
    }

    public f(e eVar) {
        super(eVar);
        this.f129608c = new k(eVar);
    }

    @Override // com.tencent.luggage.wxa.a8.q
    public com.tencent.luggage.wxa.ag.d a() {
        return f129607e;
    }

    @Override // com.tencent.luggage.wxa.a8.q
    public h b() {
        return this.f129608c;
    }

    @Override // com.tencent.luggage.wxa.a8.q
    public i.a c() {
        return f129606d;
    }
}
