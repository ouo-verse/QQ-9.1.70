package com.tencent.magicbrush;

import android.content.Context;
import android.content.res.AssetManager;
import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.api.IImageDecodeService;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.b;
import com.tencent.magicbrush.handler.fs.IMBFileSystem;
import com.tencent.magicbrush.handler.glfont.IMBFontHandler;
import com.tencent.magicbrush.ui.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class d {
    static IPatchRedirector $redirector_;
    public static final /* synthetic */ KProperty[] H;
    public final a A;
    public final a B;
    public final a C;
    public final a D;
    public final a E;
    public final a F;
    public final MBRuntime.MBParams G;

    /* renamed from: a, reason: collision with root package name */
    public Context f147379a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.r8.a f147380b;

    /* renamed from: c, reason: collision with root package name */
    public Function0 f147381c;

    /* renamed from: d, reason: collision with root package name */
    public final a f147382d;

    /* renamed from: e, reason: collision with root package name */
    public final a f147383e;

    /* renamed from: f, reason: collision with root package name */
    public final a f147384f;

    /* renamed from: g, reason: collision with root package name */
    public final a f147385g;

    /* renamed from: h, reason: collision with root package name */
    public final a f147386h;

    /* renamed from: i, reason: collision with root package name */
    public final b f147387i;

    /* renamed from: j, reason: collision with root package name */
    public IMBFontHandler f147388j;

    /* renamed from: k, reason: collision with root package name */
    public b.e f147389k;

    /* renamed from: l, reason: collision with root package name */
    public final a f147390l;

    /* renamed from: m, reason: collision with root package name */
    public final a f147391m;

    /* renamed from: n, reason: collision with root package name */
    public final a f147392n;

    /* renamed from: o, reason: collision with root package name */
    public final a f147393o;

    /* renamed from: p, reason: collision with root package name */
    public final a f147394p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f147395q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f147396r;

    /* renamed from: s, reason: collision with root package name */
    public final a f147397s;

    /* renamed from: t, reason: collision with root package name */
    public final a f147398t;

    /* renamed from: u, reason: collision with root package name */
    public final a f147399u;

    /* renamed from: v, reason: collision with root package name */
    public final a f147400v;

    /* renamed from: w, reason: collision with root package name */
    public final a f147401w;

    /* renamed from: x, reason: collision with root package name */
    public final a f147402x;

    /* renamed from: y, reason: collision with root package name */
    public final a f147403y;

    /* renamed from: z, reason: collision with root package name */
    public final a f147404z;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public final class a extends com.tencent.luggage.wxa.w8.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d f147405d;

        /* compiled from: P */
        /* renamed from: com.tencent.magicbrush.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C7011a extends Lambda implements Function0 {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f147406a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C7011a(d dVar) {
                super(0);
                this.f147406a = dVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final MBRuntime.MBParams invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (MBRuntime.MBParams) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.f147406a.o();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, KMutableProperty1 k3) {
            super(new C7011a(dVar), k3);
            Intrinsics.checkNotNullParameter(k3, "k");
            this.f147405d = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar, (Object) k3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f147407a;

        /* renamed from: b, reason: collision with root package name */
        public List f147408b;

        /* renamed from: c, reason: collision with root package name */
        public com.tencent.luggage.wxa.h.d f147409c;

        /* renamed from: d, reason: collision with root package name */
        public IImageDecodeService.a f147410d;

        /* renamed from: e, reason: collision with root package name */
        public BaseImageDecodeService f147411e;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f147407a = true;
                this.f147408b = new ArrayList();
            }
        }

        public final void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                this.f147407a = z16;
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            }
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.f147407a;
        }

        public final List c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (List) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f147408b;
        }

        public final BaseImageDecodeService d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (BaseImageDecodeService) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.f147411e;
        }

        public final com.tencent.luggage.wxa.h.d e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (com.tencent.luggage.wxa.h.d) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.f147409c;
        }

        public final void a(com.tencent.luggage.wxa.h.d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                this.f147409c = dVar;
            } else {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) dVar);
            }
        }

        public final IImageDecodeService.a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? this.f147410d : (IImageDecodeService.a) iPatchRedirector.redirect((short) 7, (Object) this);
        }

        public final void a(IImageDecodeService.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                this.f147410d = aVar;
            } else {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
            }
        }

        public final void a(BaseImageDecodeService baseImageDecodeService) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
                this.f147411e = baseImageDecodeService;
            } else {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) baseImageDecodeService);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58408);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            H = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(d.class, "devicePixelRatio", "getDevicePixelRatio()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(d.class, "canvasWidth", "getCanvasWidth()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(d.class, "canvasHeight", "getCanvasHeight()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(d.class, "fileSystem", "getFileSystem()Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(d.class, "assetManager", "getAssetManager()Landroid/content/res/AssetManager;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(d.class, "animationFrameHandlerStrategy", "getAnimationFrameHandlerStrategy()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(d.class, "enableAntialias", "getEnableAntialias()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(d.class, "enableGfx", "getEnableGfx()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(d.class, "gcFactor", "getGcFactor()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(d.class, "enableWindowAttributesAlpha", "getEnableWindowAttributesAlpha()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(d.class, "sdcardPath", "getSdcardPath()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(d.class, "syncSurfaceDestroy", "getSyncSurfaceDestroy()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(d.class, "enableGpuUnwrap", "getEnableGpuUnwrap()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(d.class, "renderThreadName", "getRenderThreadName()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(d.class, "appBrandRuntime", "getAppBrandRuntime()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(d.class, "enableAngleTranslator", "getEnableAngleTranslator()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(d.class, "maxAvailableFPS", "getMaxAvailableFPS()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(d.class, "enableProgramBinary", "getEnableProgramBinary()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(d.class, "programBinaryPath", "getProgramBinaryPath()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(d.class, "suspendRafWhenNoWindow", "getSuspendRafWhenNoWindow()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(d.class, "fetchFpsByPeriod", "getFetchFpsByPeriod()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(d.class, "enableSkiaFontHandler", "getEnableSkiaFontHandler()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(d.class, "resDelegate", "getResDelegate()Lcom/tencent/magicbrush/delegate/MagicBrushResDelegate;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(d.class, "enableParallelShaderCompile", "getEnableParallelShaderCompile()I", 0))};
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f147382d = new a(this, h.f147417a);
        this.f147383e = new a(this, g.f147416a);
        this.f147384f = new a(this, f.f147415a);
        this.f147385g = new a(this, r.f147427a);
        this.f147386h = new a(this, e.f147414a);
        this.f147387i = new b();
        this.f147390l = new a(this, c.f147412a);
        this.f147391m = new a(this, j.f147419a);
        this.f147392n = new a(this, k.f147420a);
        this.f147393o = new a(this, s.f147428a);
        this.f147394p = new a(this, p.f147425a);
        this.f147395q = true;
        this.f147396r = true;
        this.f147397s = new a(this, x.f147433a);
        this.f147398t = new a(this, z.f147435a);
        this.f147399u = new a(this, l.f147421a);
        this.f147400v = new a(this, v.f147431a);
        this.f147401w = new a(this, C7012d.f147413a);
        this.f147402x = new a(this, i.f147418a);
        this.f147403y = new a(this, t.f147429a);
        this.f147404z = new a(this, n.f147423a);
        this.A = new a(this, u.f147430a);
        this.B = new a(this, y.f147434a);
        this.C = new a(this, q.f147426a);
        this.D = new a(this, o.f147424a);
        this.E = new a(this, w.f147432a);
        this.F = new a(this, m.f147422a);
        this.G = new MBRuntime.MBParams();
    }

    public final void a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f147379a = context;
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
    }

    public final void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            this.f147383e.a(this, H[1], Integer.valueOf(i3));
        } else {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        }
    }

    public final AssetManager c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) ? (AssetManager) this.f147386h.a(this, H[4]) : (AssetManager) iPatchRedirector.redirect((short) 17, (Object) this);
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) ? ((Number) this.f147384f.a(this, H[2])).intValue() : ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return ((Number) this.f147383e.a(this, H[1])).intValue();
    }

    public final Context f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Context) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f147379a;
    }

    public final float g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Float) iPatchRedirector.redirect((short) 9, (Object) this)).floatValue();
        }
        return ((Number) this.f147382d.a(this, H[0])).floatValue();
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this)).booleanValue();
        }
        return this.f147396r;
    }

    public final IMBFileSystem i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (IMBFileSystem) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return (IMBFileSystem) this.f147385g.a(this, H[3]);
    }

    public final IMBFontHandler j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (IMBFontHandler) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.f147388j;
    }

    public final float k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Float) iPatchRedirector.redirect((short) 29, (Object) this)).floatValue();
        }
        return ((Number) this.f147393o.a(this, H[8])).floatValue();
    }

    public final BaseImageDecodeService l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (BaseImageDecodeService) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.f147387i.d();
    }

    public final b m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (b) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.f147387i;
    }

    public final com.tencent.luggage.wxa.r8.a n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.luggage.wxa.r8.a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f147380b;
    }

    public final MBRuntime.MBParams o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (MBRuntime.MBParams) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return this.G;
    }

    public final b.e p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (b.e) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.f147389k;
    }

    public final Function0 q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Function0) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f147381c;
    }

    public final void a(com.tencent.luggage.wxa.r8.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            this.f147380b = aVar;
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
        }
    }

    public final a.b b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (a.b) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        Object a16 = this.f147390l.a(this, H[5]);
        Intrinsics.checkNotNullExpressionValue(a16, "<get-animationFrameHandlerStrategy>(...)");
        return (a.b) a16;
    }

    public final void c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 30)) {
            this.f147394p.a(this, H[9], Boolean.valueOf(z16));
        } else {
            iPatchRedirector.redirect((short) 30, (Object) this, z16);
        }
    }

    public final void d(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 34)) {
            this.f147398t.a(this, H[11], Boolean.valueOf(z16));
        } else {
            iPatchRedirector.redirect((short) 34, (Object) this, z16);
        }
    }

    public final void a(Function0 function0) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            this.f147381c = function0;
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) function0);
        }
    }

    public final void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 36)) {
            this.D.a(this, H[21], Boolean.valueOf(z16));
        } else {
            iPatchRedirector.redirect((short) 36, (Object) this, z16);
        }
    }

    public final void a(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            this.f147382d.a(this, H[0], Float.valueOf(f16));
        } else {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16));
        }
    }

    public final void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            this.f147384f.a(this, H[2], Integer.valueOf(i3));
        } else {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        }
    }

    public final void a(IMBFileSystem iMBFileSystem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            this.f147385g.a(this, H[3], iMBFileSystem);
        } else {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) iMBFileSystem);
        }
    }

    public final void a(AssetManager assetManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            this.f147386h.a(this, H[4], assetManager);
        } else {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) assetManager);
        }
    }

    public final void a(Function1 dls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) dls);
        } else {
            Intrinsics.checkNotNullParameter(dls, "dls");
            dls.invoke(this.f147387i);
        }
    }

    public final void a(IMBFontHandler iMBFontHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) {
            this.f147388j = iMBFontHandler;
        } else {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) iMBFontHandler);
        }
    }

    public final void a(b.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 25)) {
            this.f147389k = eVar;
        } else {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) eVar);
        }
    }

    public final void a(a.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) bVar);
        } else {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.f147390l.a(this, H[5], bVar);
        }
    }

    public final void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 28)) {
            this.f147392n.a(this, H[7], Boolean.valueOf(z16));
        } else {
            iPatchRedirector.redirect((short) 28, (Object) this, z16);
        }
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 31)) ? this.f147395q : ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this)).booleanValue();
    }

    public final void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.f147397s.a(this, H[10], str);
        }
    }

    public final void a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 35)) {
            this.f147401w.a(this, H[14], Long.valueOf(j3));
        } else {
            iPatchRedirector.redirect((short) 35, (Object) this, j3);
        }
    }
}
