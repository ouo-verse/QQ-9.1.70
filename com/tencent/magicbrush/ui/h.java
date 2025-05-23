package com.tencent.magicbrush.ui;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.magicbrush.ui.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class h implements g.c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.tencent.magicbrush.ui.g f147529a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a extends Lambda implements Function1 {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f147530a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f147531b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f147532c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Object obj, int i3, int i16) {
            super(1);
            this.f147530a = obj;
            this.f147531b = i3;
            this.f147532c = i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, obj, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        public final void a(g.c it) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                return;
            }
            Intrinsics.checkNotNullParameter(it, "it");
            if (it instanceof g.e) {
                ((g.e) it).c(this.f147530a, this.f147531b, this.f147532c);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((g.c) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b extends Lambda implements Function1 {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f147533a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f147534b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f147535c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Object obj, int i3, int i16) {
            super(1);
            this.f147533a = obj;
            this.f147534b = i3;
            this.f147535c = i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, obj, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        public final void a(g.c it) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
            } else {
                Intrinsics.checkNotNullParameter(it, "it");
                g.c.a.a(it, this.f147533a, this.f147534b, this.f147535c, false, false, 16, null);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((g.c) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c extends Lambda implements Function1 {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final c f147536a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58694);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f147536a = new c();
            }
        }

        public c() {
            super(1);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final void a(g.f it) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) it);
            } else {
                Intrinsics.checkNotNullParameter(it, "it");
                it.a();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((g.f) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class d extends Lambda implements Function1 {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f147537a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Object obj) {
            super(1);
            this.f147537a = obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, obj);
            }
        }

        public final void a(g.c it) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                return;
            }
            Intrinsics.checkNotNullParameter(it, "it");
            if (it instanceof g.e) {
                ((g.e) it).a(this.f147537a);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((g.c) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class e extends Lambda implements Function1 {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f147538a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Object obj) {
            super(1);
            this.f147538a = obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, obj);
            }
        }

        public final void a(g.c it) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
            } else {
                Intrinsics.checkNotNullParameter(it, "it");
                it.a(this.f147538a, false);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((g.c) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class f extends Lambda implements Function1 {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f147539a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f147540b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f147541c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Object obj, int i3, int i16) {
            super(1);
            this.f147539a = obj;
            this.f147540b = i3;
            this.f147541c = i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, obj, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        public final void a(g.c it) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                return;
            }
            Intrinsics.checkNotNullParameter(it, "it");
            if (it instanceof g.e) {
                ((g.e) it).b(this.f147539a, this.f147540b, this.f147541c);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((g.c) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class g extends Lambda implements Function1 {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f147542a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f147543b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f147544c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Object obj, int i3, int i16) {
            super(1);
            this.f147542a = obj;
            this.f147543b = i3;
            this.f147544c = i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, obj, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        public final void a(g.c it) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
            } else {
                Intrinsics.checkNotNullParameter(it, "it");
                it.a(this.f147542a, this.f147543b, this.f147544c);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((g.c) obj);
            return Unit.INSTANCE;
        }
    }

    public h(com.tencent.magicbrush.ui.g gVar) {
        this.f147529a = gVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) gVar);
        }
    }

    @Override // com.tencent.magicbrush.ui.g.c
    public void a(Object surface, int i3, int i16, boolean z16, boolean z17) {
        com.tencent.magicbrush.b bVar;
        com.tencent.magicbrush.b bVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, surface, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        Intrinsics.checkNotNullParameter(surface, "surface");
        com.tencent.luggage.wxa.p8.f.c("MagicBrushView", "onSurfaceAvailable %s, %d, %d", surface, Integer.valueOf(i3), Integer.valueOf(i16));
        this.f147529a.getSurfaceListener().b((Function1) new a(surface, i3, i16));
        try {
            com.tencent.magicbrush.b bVar3 = null;
            if (surface instanceof Surface) {
                bVar2 = this.f147529a.f147518i;
                if (bVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("magicbrush");
                } else {
                    bVar3 = bVar2;
                }
                bVar3.a(this.f147529a.getVirtualElementId(), (Surface) surface, i3, i16, z17);
            } else if (surface instanceof SurfaceTexture) {
                bVar = this.f147529a.f147518i;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("magicbrush");
                } else {
                    bVar3 = bVar;
                }
                bVar3.a(this.f147529a.getVirtualElementId(), (SurfaceTexture) surface, i3, i16, z16);
            } else {
                String format = String.format("SurfaceType invalid. [%s]", Arrays.copyOf(new Object[]{surface}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                throw new RuntimeException(format);
            }
        } finally {
            this.f147529a.getSurfaceListener().b((Function1) new b(surface, i3, i16));
            this.f147529a.f147512c = true;
            this.f147529a.getPreparedListeners().b((Function1) c.f147536a);
            this.f147529a.getPreparedListeners().a();
        }
    }

    @Override // com.tencent.magicbrush.ui.g.c
    public void a(Object surface, int i3, int i16) {
        com.tencent.magicbrush.b bVar;
        com.tencent.magicbrush.b bVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, surface, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Intrinsics.checkNotNullParameter(surface, "surface");
        com.tencent.luggage.wxa.p8.f.c("MagicBrushView", "onSurfaceSizeChanged %s, %d, %d", surface, Integer.valueOf(i3), Integer.valueOf(i16));
        this.f147529a.getSurfaceListener().b((Function1) new f(surface, i3, i16));
        try {
            com.tencent.magicbrush.b bVar3 = null;
            if (surface instanceof Surface) {
                bVar2 = this.f147529a.f147518i;
                if (bVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("magicbrush");
                } else {
                    bVar3 = bVar2;
                }
                bVar3.a(this.f147529a.getVirtualElementId(), (Surface) surface, i3, i16);
            } else if (surface instanceof SurfaceTexture) {
                bVar = this.f147529a.f147518i;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("magicbrush");
                } else {
                    bVar3 = bVar;
                }
                bVar3.a(this.f147529a.getVirtualElementId(), (SurfaceTexture) surface, i3, i16);
            } else {
                String format = String.format("SurfaceType invalid. [%s]", Arrays.copyOf(new Object[]{surface}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                throw new RuntimeException(format);
            }
        } finally {
            this.f147529a.getSurfaceListener().b((Function1) new g(surface, i3, i16));
        }
    }

    @Override // com.tencent.magicbrush.ui.g.c
    public void a(Object surface, boolean z16) {
        com.tencent.magicbrush.b bVar;
        com.tencent.magicbrush.b bVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, surface, Boolean.valueOf(z16));
            return;
        }
        Intrinsics.checkNotNullParameter(surface, "surface");
        com.tencent.luggage.wxa.p8.f.c("MagicBrushView", "onSurfaceDestroyed %s, %d, %d", surface, Integer.valueOf(this.f147529a.getWidth()), Integer.valueOf(this.f147529a.getHeight()));
        this.f147529a.getSurfaceListener().b((Function1) new d(surface));
        try {
            com.tencent.magicbrush.b bVar3 = null;
            if (surface instanceof Surface) {
                bVar2 = this.f147529a.f147518i;
                if (bVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("magicbrush");
                } else {
                    bVar3 = bVar2;
                }
                bVar3.a(this.f147529a.getVirtualElementId(), (Surface) surface, z16);
            } else if (surface instanceof SurfaceTexture) {
                bVar = this.f147529a.f147518i;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("magicbrush");
                } else {
                    bVar3 = bVar;
                }
                bVar3.a(this.f147529a.getVirtualElementId(), (SurfaceTexture) surface, true);
            } else {
                String format = String.format("SurfaceType invalid. [%s]", Arrays.copyOf(new Object[]{surface}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                throw new RuntimeException(format);
            }
        } finally {
            this.f147529a.getSurfaceListener().b((Function1) new e(surface));
        }
    }
}
