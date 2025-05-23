package com.tencent.magicbrush;

import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.api.IImageDecodeService;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.ext_texture.MBExternalTextureMgr;
import com.tencent.magicbrush.internal.EventDispatcher;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class b extends MBRuntime {
    static IPatchRedirector $redirector_;

    /* renamed from: r, reason: collision with root package name */
    public static final a f147361r;

    /* renamed from: s, reason: collision with root package name */
    public static final String f147362s;

    /* renamed from: t, reason: collision with root package name */
    public static final String f147363t;

    /* renamed from: k, reason: collision with root package name */
    public final com.tencent.magicbrush.d f147364k;

    /* renamed from: l, reason: collision with root package name */
    public final com.tencent.luggage.wxa.w8.c f147365l;

    /* renamed from: m, reason: collision with root package name */
    public final com.tencent.luggage.wxa.w8.c f147366m;

    /* renamed from: n, reason: collision with root package name */
    public final MBViewManager f147367n;

    /* renamed from: o, reason: collision with root package name */
    public final MBExternalTextureMgr f147368o;

    /* renamed from: p, reason: collision with root package name */
    public final com.tencent.magicbrush.a f147369p;

    /* renamed from: q, reason: collision with root package name */
    public final e f147370q;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public final b a(com.tencent.magicbrush.c builder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) builder);
            }
            Intrinsics.checkNotNullParameter(builder, "builder");
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (!com.tencent.luggage.wxa.u8.a.a(builder)) {
                return null;
            }
            return new b(builder, defaultConstructorMarker);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.magicbrush.b$b, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC7010b {
        void a(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public final class c implements IImageDecodeService.b {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.github.henryye.nativeiv.api.IImageDecodeService.b
        public void a(String path, IImageDecodeService.b.a event, com.tencent.luggage.wxa.e.a decodeInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, path, event, decodeInfo);
                return;
            }
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(decodeInfo, "decodeInfo");
        }

        @Override // com.github.henryye.nativeiv.api.IImageDecodeService.b
        public void a(String path, Object obj, IImageDecodeService.c recycleHandler, ImageDecodeConfig config) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, path, obj, recycleHandler, config);
                return;
            }
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(recycleHandler, "recycleHandler");
            Intrinsics.checkNotNullParameter(config, "config");
            b.this.a(path, obj, recycleHandler, config);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface d {
        void a(String str);

        void a(String str, String str2, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface e {

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class a {
            public static void a(e eVar, com.tencent.magicbrush.ui.g view, float[] left, float[] top, float[] width, float[] height) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(left, "left");
                Intrinsics.checkNotNullParameter(top, "top");
                Intrinsics.checkNotNullParameter(width, "width");
                Intrinsics.checkNotNullParameter(height, "height");
            }
        }

        com.tencent.magicbrush.ui.g a();

        void a(com.tencent.magicbrush.ui.g gVar);

        void a(com.tencent.magicbrush.ui.g gVar, int i3, int i16, int i17, int i18, int i19);

        void a(com.tencent.magicbrush.ui.g gVar, float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4);

        void b(com.tencent.magicbrush.ui.g gVar, int i3, int i16, int i17, int i18, int i19);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class f extends Lambda implements Function0 {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f147372a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f147373b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f147374c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(long j3, long j16, long j17) {
            super(0);
            this.f147372a = j3;
            this.f147373b = j16;
            this.f147374c = j17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
            }
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.o8.c invoke() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.luggage.wxa.o8.c) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new com.tencent.luggage.wxa.o8.c(this.f147372a, this.f147373b, this.f147374c);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58051);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f147361r = new a(null);
        f147362s = "mmbox2d";
        f147363t = "mmphysx";
    }

    public /* synthetic */ b(com.tencent.magicbrush.c cVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(cVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar, (Object) defaultConstructorMarker);
    }

    public static final void a(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.nativeBindExtTextureManager(this$0.f147291a, this$0.f147368o);
    }

    @Override // com.tencent.magicbrush.MBRuntime
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        com.tencent.luggage.wxa.p8.f.c("MagicBrush", "MagicBrush is destroying...", new Object[0]);
        super.c();
        this.f147367n.clear$lib_magicbrush_nano_release();
        this.f147365l.a();
        this.f147366m.a();
        com.tencent.luggage.wxa.p8.f.c("MagicBrush", "MagicBrush is destroying...[done]", new Object[0]);
    }

    @Override // com.tencent.magicbrush.MBRuntime
    public e o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (e) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.f147370q;
    }

    @Override // com.tencent.magicbrush.MBRuntime
    public MBViewManager r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (MBViewManager) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.f147367n;
    }

    public final com.tencent.magicbrush.a s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.magicbrush.a) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f147369p;
    }

    public final com.tencent.magicbrush.d t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.magicbrush.d) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f147364k;
    }

    public final MBExternalTextureMgr u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (MBExternalTextureMgr) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f147368o;
    }

    public final com.tencent.luggage.wxa.w8.c v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.luggage.wxa.w8.c) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f147366m;
    }

    public final com.tencent.luggage.wxa.w8.c w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.luggage.wxa.w8.c) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f147365l;
    }

    public final MBViewManager x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MBViewManager) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f147367n;
    }

    public b(com.tencent.magicbrush.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
            return;
        }
        this.f147364k = cVar;
        this.f147365l = new com.tencent.luggage.wxa.w8.c();
        this.f147366m = new com.tencent.luggage.wxa.w8.c();
        this.f147367n = new MBViewManager();
        MBExternalTextureMgr mBExternalTextureMgr = new MBExternalTextureMgr();
        mBExternalTextureMgr.a("video", new com.tencent.luggage.wxa.q8.b(this, "video"));
        mBExternalTextureMgr.a("camera", new com.tencent.luggage.wxa.q8.b(this, "camera"));
        this.f147368o = mBExternalTextureMgr;
        this.f147369p = new com.tencent.magicbrush.a(this);
        MBRuntime.MBParams o16 = cVar.o();
        this.f147292b = o16;
        this.f147291a = nativeCreate(o16);
        nativeSetEventListener(this.f147291a, new EventDispatcher(this));
        com.tencent.luggage.wxa.r8.a n3 = cVar.n();
        Intrinsics.checkNotNull(n3);
        a(n3);
        BaseImageDecodeService l3 = cVar.l();
        if (l3 != null) {
            l3.addDecodeEventListener(new c());
        }
        a(l3);
        a(cVar.j());
        this.f147370q = cVar.p();
        j();
        Function0 q16 = cVar.q();
        Intrinsics.checkNotNull(q16);
        a(q16);
        a(new Runnable() { // from class: com.tencent.magicbrush.k
            @Override // java.lang.Runnable
            public final void run() {
                b.a(b.this);
            }
        });
    }

    public final void a(final Function0 fn5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) fn5);
        } else {
            Intrinsics.checkNotNullParameter(fn5, "fn");
            a(new Runnable() { // from class: com.tencent.magicbrush.j
                @Override // java.lang.Runnable
                public final void run() {
                    b.a(Function0.this, this);
                }
            });
        }
    }

    public static final void a(Function0 fn5, b this$0) {
        Intrinsics.checkNotNullParameter(fn5, "$fn");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.luggage.wxa.o8.c cVar = (com.tencent.luggage.wxa.o8.c) fn5.invoke();
        this$0.nativeBindTo(this$0.f147291a, cVar.b(), cVar.a(), cVar.c());
    }

    public final void a(long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            a(new f(j3, j16, j17));
        } else {
            iPatchRedirector.redirect((short) 11, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
        }
    }

    public final void a(String name) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) name);
            return;
        }
        Intrinsics.checkNotNullParameter(name, "name");
        com.tencent.luggage.wxa.p8.f.c("MagicBrush", "hy: trigger load " + name, new Object[0]);
        com.tencent.luggage.wxa.p8.b.b(name);
        String a16 = com.tencent.luggage.wxa.p8.b.a(name);
        if (a16 != null) {
            if (!(a16.length() == 0)) {
                if (Intrinsics.areEqual(name, f147362s)) {
                    nativeLazyLoadBox2D(this.f147291a, a16);
                    return;
                } else if (Intrinsics.areEqual(name, f147363t)) {
                    nativeLazyLoadPhysx(this.f147291a, a16);
                    return;
                } else {
                    com.tencent.luggage.wxa.p8.f.b("MagicBrush", "hy: not support", new Object[0]);
                    return;
                }
            }
        }
        com.tencent.luggage.wxa.p8.f.b("MagicBrush", "hy: can not find " + name + " path", new Object[0]);
    }

    @Override // com.tencent.magicbrush.MBRuntime
    public com.tencent.magicbrush.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) ? this.f147369p : (com.tencent.magicbrush.a) iPatchRedirector.redirect((short) 14, (Object) this);
    }
}
