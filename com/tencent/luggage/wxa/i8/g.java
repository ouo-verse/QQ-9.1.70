package com.tencent.luggage.wxa.i8;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.wxa.a8.j;
import com.tencent.luggage.wxa.a8.z;
import com.tencent.luggage.wxa.ag.h;
import com.tencent.luggage.wxa.ag.i;
import com.tencent.luggage.wxa.ai.k;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g extends com.tencent.luggage.wxa.a8.c {

    /* renamed from: c, reason: collision with root package name */
    public i.a f129613c;

    /* renamed from: d, reason: collision with root package name */
    public final e f129614d;

    /* renamed from: e, reason: collision with root package name */
    public final f f129615e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements i.a {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.ag.i.a
        public i a(k kVar) {
            return new C6291a(g.this.f129614d, kVar);
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.i8.g$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6291a extends z {

            /* renamed from: f, reason: collision with root package name */
            public i f129617f;

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ k f129618g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C6291a(j jVar, k kVar) {
                super(jVar);
                this.f129618g = kVar;
                this.f129617f = null;
            }

            @Override // com.tencent.luggage.wxa.a8.z, com.tencent.luggage.wxa.ag.i
            public View a(Context context) {
                if (!this.f129618g.g()) {
                    return c().a(context);
                }
                return super.a(context);
            }

            @Override // com.tencent.luggage.wxa.a8.z, com.tencent.luggage.wxa.ag.i
            public void b(View view, Runnable runnable) {
                if (!this.f129618g.g()) {
                    if (!(view instanceof c)) {
                        w.f(this.f120967a, "transferFrom, view is not instanceof TextureImageViewLikeImpl");
                        if (runnable != null) {
                            w.d(this.f120967a, "transferFrom, run afterTransferFromTask when view is not instanceof TextureImageViewLikeImpl");
                            runnable.run();
                            return;
                        }
                        return;
                    }
                    c().b((c) view, runnable);
                    return;
                }
                super.b(view, runnable);
            }

            public final i c() {
                if (this.f129617f == null) {
                    this.f129617f = f.f129606d.a(this.f129618g);
                }
                return this.f129617f;
            }

            @Override // com.tencent.luggage.wxa.a8.z, com.tencent.luggage.wxa.ag.i
            public void a(View view) {
                if (!this.f129618g.g()) {
                    if (view instanceof c) {
                        c().a((c) view);
                        return;
                    } else {
                        w.f(this.f120967a, "recycleVideoContainerView, view is not instanceof TextureImageViewLikeImpl");
                        return;
                    }
                }
                super.a(view);
            }

            @Override // com.tencent.luggage.wxa.a8.z, com.tencent.luggage.wxa.ag.i
            public void b(View view) {
                if (!this.f129618g.g()) {
                    if (!(view instanceof c)) {
                        w.f(this.f120967a, "onPlayEndWorkaround, view is not instanceof TextureImageViewLikeImpl");
                        return;
                    } else {
                        c().b((c) view);
                        return;
                    }
                }
                super.b(view);
            }

            @Override // com.tencent.luggage.wxa.a8.z, com.tencent.luggage.wxa.ag.i
            public com.tencent.luggage.wxa.ag.e a() {
                if (!this.f129618g.g()) {
                    return c().a();
                }
                return super.a();
            }

            @Override // com.tencent.luggage.wxa.a8.z, com.tencent.luggage.wxa.ag.i
            public void a(View view, Runnable runnable) {
                if (!this.f129618g.g()) {
                    if (!(view instanceof c)) {
                        w.f(this.f120967a, "transferTo, view is not instanceof TextureImageViewLikeImpl");
                        if (runnable != null) {
                            w.d(this.f120967a, "transferTo, run afterTransferToTask when view is not instanceof TextureImageViewLikeImpl");
                            runnable.run();
                            return;
                        }
                        return;
                    }
                    c().a((c) view, runnable);
                    return;
                }
                super.a(view, runnable);
            }
        }
    }

    public g(e eVar) {
        super(eVar);
        this.f129613c = new a();
        this.f129614d = eVar;
        this.f129615e = new f(eVar);
    }

    @Override // com.tencent.luggage.wxa.a8.q
    public h b() {
        return this.f129615e.b();
    }

    @Override // com.tencent.luggage.wxa.a8.q
    public i.a c() {
        return this.f129613c;
    }

    @Override // com.tencent.luggage.wxa.a8.q
    public com.tencent.luggage.wxa.ag.d a() {
        return this.f129615e.a();
    }
}
