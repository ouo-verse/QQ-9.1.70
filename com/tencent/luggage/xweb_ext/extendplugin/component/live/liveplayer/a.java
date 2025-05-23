package com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ag.i;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes9.dex */
public final class a extends com.tencent.luggage.wxa.a8.c {

    /* renamed from: d, reason: collision with root package name */
    protected static i.a f146900d = new C6999a();

    /* renamed from: e, reason: collision with root package name */
    private static com.tencent.luggage.wxa.ag.d f146901e = new b();

    /* renamed from: c, reason: collision with root package name */
    private final com.tencent.luggage.wxa.ag.h f146902c;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C6999a implements i.a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C7000a extends com.tencent.luggage.wxa.a8.d {

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ com.tencent.luggage.wxa.uh.c f146903h;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.a$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public class C7001a extends com.tencent.luggage.wxa.a8.d.e {

                /* renamed from: e, reason: collision with root package name */
                @Nullable
                private Surface f146905e;

                public C7001a(com.tencent.luggage.wxa.i8.c cVar, @NonNull Runnable runnable) {
                    super(cVar, runnable);
                    this.f146905e = null;
                }

                public void a() {
                }

                public boolean a(@NonNull Surface surface, int i3, int i16) {
                    boolean z16;
                    try {
                        Surface surface2 = this.f146905e;
                        if (surface2 != null && surface2 == surface) {
                            surface = null;
                        }
                        if (surface != null) {
                            z16 = C7000a.this.f146903h.a(surface);
                            if (z16) {
                                this.f146905e = surface;
                            }
                        } else {
                            z16 = true;
                        }
                        if (z16) {
                            C7000a.this.f146903h.a(i3, i16);
                        }
                        return z16;
                    } catch (Exception unused) {
                        return false;
                    }
                }
            }

            public C7000a(com.tencent.luggage.wxa.uh.c cVar) {
                this.f146903h = cVar;
            }

            @Override // com.tencent.luggage.wxa.a8.d
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.tencent.luggage.wxa.a8.d.e c(@NonNull com.tencent.luggage.wxa.i8.c cVar, @Nullable Runnable runnable) {
                return new C7001a(cVar, runnable);
            }

            @Override // com.tencent.luggage.wxa.ag.i
            @NonNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public com.tencent.luggage.wxa.i8.c a(@NonNull Context context) {
                com.tencent.luggage.wxa.tn.w.a(this.f120909a, "createVideoContainerView");
                return new com.tencent.luggage.wxa.i8.c(context);
            }

            @Override // com.tencent.luggage.wxa.a8.d, com.tencent.luggage.wxa.ag.i
            public void b(@NonNull com.tencent.luggage.wxa.i8.c cVar, @Nullable Runnable runnable) {
                com.tencent.luggage.wxa.tn.w.d(this.f120909a, "transferFrom, textureView: " + cVar);
                super.b((View) cVar, runnable);
                Surface b16 = this.f146903h.b();
                if (b16 != null && b16.isValid()) {
                    try {
                        if (this.f146903h.a(b16)) {
                            com.tencent.luggage.wxa.uh.c cVar2 = this.f146903h;
                            cVar2.a(cVar2.i(), this.f146903h.k());
                        }
                        if (runnable != null) {
                            SurfaceTexture c16 = this.f146903h.c();
                            if (c16 != null) {
                                a(runnable, c16);
                                return;
                            } else {
                                com.tencent.luggage.wxa.tn.w.d(this.f120909a, "transferFrom, run afterTransferFromTask when originSurfaceTexture is null");
                                runnable.run();
                                return;
                            }
                        }
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                }
                com.tencent.luggage.wxa.tn.w.f(this.f120909a, "transferFrom, originSurface is invalid");
                if (runnable != null) {
                    com.tencent.luggage.wxa.tn.w.d(this.f120909a, "transferFrom, run afterTransferFromTask when originSurface is invalid");
                    runnable.run();
                }
            }
        }

        @Override // com.tencent.luggage.wxa.ag.i.a
        @NonNull
        public com.tencent.luggage.wxa.ag.i a(@NonNull com.tencent.luggage.wxa.uh.c cVar) {
            com.tencent.luggage.wxa.d8.a a16 = cVar.a();
            if (a16 != null) {
                a16.setSurface(null);
            }
            return new C7000a(cVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements com.tencent.luggage.wxa.ag.d {
        @Override // com.tencent.luggage.wxa.ag.d
        @NotNull
        public com.tencent.luggage.wxa.ag.a a(int i3) {
            com.tencent.luggage.wxa.wh.c cVar = new com.tencent.luggage.wxa.wh.c();
            cVar.setData("livePlayerId", Integer.valueOf(i3));
            return cVar;
        }

        @Override // com.tencent.luggage.wxa.ag.d
        @NotNull
        public com.tencent.luggage.wxa.ag.a b(int i3) {
            com.tencent.luggage.wxa.wh.b bVar = new com.tencent.luggage.wxa.wh.b();
            bVar.setData("livePlayerId", Integer.valueOf(i3));
            return bVar;
        }
    }

    public a(@NonNull LivePlayerPluginHandler livePlayerPluginHandler) {
        super(livePlayerPluginHandler);
        this.f146902c = new com.tencent.luggage.wxa.uh.c(livePlayerPluginHandler);
    }

    @Override // com.tencent.luggage.wxa.a8.q
    @NonNull
    public com.tencent.luggage.wxa.ag.d a() {
        return f146901e;
    }

    @Override // com.tencent.luggage.wxa.a8.q
    @NonNull
    public com.tencent.luggage.wxa.ag.h b() {
        return this.f146902c;
    }

    @Override // com.tencent.luggage.wxa.a8.q
    @NonNull
    public i.a c() {
        return f146900d;
    }
}
