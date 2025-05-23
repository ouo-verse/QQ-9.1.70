package com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.a8.z;
import com.tencent.luggage.wxa.ag.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes9.dex */
public final class b extends com.tencent.luggage.wxa.a8.c {

    /* renamed from: c, reason: collision with root package name */
    private i.a f146907c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final LivePlayerPluginHandler f146908d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.a f146909e;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements i.a {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.ag.i.a
        @NonNull
        public com.tencent.luggage.wxa.ag.i a(@NonNull com.tencent.luggage.wxa.uh.c cVar) {
            return new C7002a(b.this.f146908d, cVar);
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C7002a extends z {

            /* renamed from: f, reason: collision with root package name */
            private com.tencent.luggage.wxa.ag.i f146911f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ com.tencent.luggage.wxa.uh.c f146912g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C7002a(com.tencent.luggage.wxa.a8.j jVar, com.tencent.luggage.wxa.uh.c cVar) {
                super(jVar);
                this.f146912g = cVar;
                this.f146911f = null;
            }

            @NonNull
            private com.tencent.luggage.wxa.ag.i c() {
                if (this.f146911f == null) {
                    this.f146911f = com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.a.f146900d.a(this.f146912g);
                }
                return this.f146911f;
            }

            @Override // com.tencent.luggage.wxa.a8.z, com.tencent.luggage.wxa.ag.i
            @NonNull
            public View a(@NonNull Context context) {
                if (!this.f146912g.d()) {
                    return c().a(context);
                }
                return super.a(context);
            }

            @Override // com.tencent.luggage.wxa.a8.z, com.tencent.luggage.wxa.ag.i
            public void b(@NonNull View view, @Nullable Runnable runnable) {
                if (!this.f146912g.d()) {
                    if (!(view instanceof com.tencent.luggage.wxa.i8.c)) {
                        com.tencent.luggage.wxa.tn.w.f(this.f120967a, "transferFrom, view is not instanceof TextureImageViewLikeImpl");
                        if (runnable != null) {
                            com.tencent.luggage.wxa.tn.w.d(this.f120967a, "transferFrom, run afterTransferFromTask when view is not instanceof TextureImageViewLikeImpl");
                            runnable.run();
                            return;
                        }
                        return;
                    }
                    c().b((com.tencent.luggage.wxa.i8.c) view, runnable);
                    return;
                }
                super.b(view, runnable);
            }

            @Override // com.tencent.luggage.wxa.a8.z, com.tencent.luggage.wxa.ag.i
            public void a(@NonNull View view) {
                if (!this.f146912g.d()) {
                    if (view instanceof com.tencent.luggage.wxa.i8.c) {
                        c().a((com.tencent.luggage.wxa.i8.c) view);
                        return;
                    } else {
                        com.tencent.luggage.wxa.tn.w.f(this.f120967a, "recycleVideoContainerView, view is not instanceof TextureImageViewLikeImpl");
                        return;
                    }
                }
                super.a(view);
            }

            @Override // com.tencent.luggage.wxa.a8.z, com.tencent.luggage.wxa.ag.i
            public void b(@NonNull View view) {
                if (!this.f146912g.d()) {
                    if (!(view instanceof com.tencent.luggage.wxa.i8.c)) {
                        com.tencent.luggage.wxa.tn.w.f(this.f120967a, "onPlayEndWorkaround, view is not instanceof TextureImageViewLikeImpl");
                        return;
                    } else {
                        c().b((com.tencent.luggage.wxa.i8.c) view);
                        return;
                    }
                }
                super.b(view);
            }

            @Override // com.tencent.luggage.wxa.a8.z, com.tencent.luggage.wxa.ag.i
            @NonNull
            public com.tencent.luggage.wxa.ag.e a() {
                if (!this.f146912g.d()) {
                    return c().a();
                }
                return super.a();
            }

            @Override // com.tencent.luggage.wxa.a8.z, com.tencent.luggage.wxa.ag.i
            public void a(@NonNull View view, @Nullable Runnable runnable) {
                if (!this.f146912g.d()) {
                    if (!(view instanceof com.tencent.luggage.wxa.i8.c)) {
                        com.tencent.luggage.wxa.tn.w.f(this.f120967a, "transferTo, view is not instanceof TextureImageViewLikeImpl");
                        if (runnable != null) {
                            com.tencent.luggage.wxa.tn.w.d(this.f120967a, "transferTo, run afterTransferToTask when view is not instanceof TextureImageViewLikeImpl");
                            runnable.run();
                            return;
                        }
                        return;
                    }
                    c().a((com.tencent.luggage.wxa.i8.c) view, runnable);
                    return;
                }
                super.a(view, runnable);
            }
        }
    }

    public b(@NonNull LivePlayerPluginHandler livePlayerPluginHandler) {
        super(livePlayerPluginHandler);
        this.f146907c = new a();
        this.f146908d = livePlayerPluginHandler;
        this.f146909e = new com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.a(livePlayerPluginHandler);
    }

    @Override // com.tencent.luggage.wxa.a8.q
    @NonNull
    public com.tencent.luggage.wxa.ag.h b() {
        return this.f146909e.b();
    }

    @Override // com.tencent.luggage.wxa.a8.q
    @NonNull
    public i.a c() {
        return this.f146907c;
    }

    @Override // com.tencent.luggage.wxa.a8.q
    @NonNull
    public com.tencent.luggage.wxa.ag.d a() {
        return this.f146909e.a();
    }
}
