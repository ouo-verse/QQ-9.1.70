package com.tencent.magicbrush;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.annotation.AnyThread;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.api.IImageDecodeService;
import com.tencent.magicbrush.b;
import com.tencent.magicbrush.ext_texture.MBExternalTextureMgr;
import com.tencent.magicbrush.handler.JsTouchEventHandler;
import com.tencent.magicbrush.handler.fs.IMBFileSystem;
import com.tencent.magicbrush.handler.glfont.IMBFontHandler;
import com.tencent.magicbrush.internal.EventDispatcher;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashSet;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class MBRuntime {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public volatile long f147291a;

    /* renamed from: b, reason: collision with root package name */
    public MBParams f147292b;

    /* renamed from: c, reason: collision with root package name */
    public final HashSet f147293c;

    /* renamed from: d, reason: collision with root package name */
    public p f147294d;

    /* renamed from: e, reason: collision with root package name */
    public IMBFileSystem f147295e;

    /* renamed from: f, reason: collision with root package name */
    public BaseImageDecodeService f147296f;

    /* renamed from: g, reason: collision with root package name */
    public IMBFontHandler f147297g;

    /* renamed from: h, reason: collision with root package name */
    public volatile com.tencent.luggage.wxa.r8.b f147298h;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.magicbrush.ui.a f147299i;

    /* renamed from: j, reason: collision with root package name */
    public com.tencent.luggage.wxa.o8.b f147300j;

    /* compiled from: P */
    @Keep
    /* loaded from: classes9.dex */
    public static class MBParams {
        static IPatchRedirector $redirector_;
        public boolean allow_antialias_;
        public a.b animationFrameHandlerStrategy;
        public long app_brand_runtime;
        AssetManager asset_manager;
        public float device_pixel_ratio_;
        public boolean enable_angle_translator;
        public boolean enable_gfx;
        public boolean enable_gpu_unwrap;
        public int enable_parallel_shader_compile;
        public boolean enable_program_binary;
        public boolean enable_skia_font_handler;
        public boolean enable_window_attributes_alpha;
        public boolean fetch_fps_by_period;
        public IMBFileSystem file_system_;
        public float gc_factor;
        public float max_available_fps;
        public String program_binary_path;
        public String render_thread_name;
        public boolean render_thread_profiler;
        public com.tencent.luggage.wxa.p8.g resDelegate;
        public int screen_height_;
        public int screen_width_;
        public String sdcard_path;
        public boolean suspend_raf_when_no_window;
        public boolean sync_surface_destroy;

        public MBParams() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.allow_antialias_ = false;
            this.device_pixel_ratio_ = -1.0f;
            this.screen_width_ = -1;
            this.screen_height_ = -1;
            this.enable_gfx = true;
            this.gc_factor = 0.0f;
            this.enable_window_attributes_alpha = false;
            this.render_thread_profiler = false;
            this.animationFrameHandlerStrategy = a.b.f147484a;
            this.file_system_ = null;
            this.sync_surface_destroy = true;
            this.enable_gpu_unwrap = false;
            this.app_brand_runtime = 0L;
            this.enable_angle_translator = false;
            this.max_available_fps = 60.0f;
            this.enable_program_binary = false;
            this.suspend_raf_when_no_window = true;
            this.fetch_fps_by_period = true;
            this.enable_skia_font_handler = false;
            this.enable_parallel_shader_compile = 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Surface f147301a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f147302b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f147303c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f147304d;

        public a(Surface surface, int i3, int i16, int i17) {
            this.f147301a = surface;
            this.f147302b = i3;
            this.f147303c = i16;
            this.f147304d = i17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MBRuntime.this, surface, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Surface surface = this.f147301a;
            if (surface == null) {
                com.tencent.luggage.wxa.p8.f.a("MicroMsg.MagicBrush.MBRuntime", new RuntimeException("Stub here!"), "hy: text is null, do not notifyWindowChanged. maybe released by other module", new Object[0]);
            } else if (!MBRuntime.this.a(surface)) {
                com.tencent.luggage.wxa.p8.f.b("MicroMsg.MagicBrush.MBRuntime", "window change for invalid surface %d", Integer.valueOf(this.f147302b));
            } else {
                MBRuntime mBRuntime = MBRuntime.this;
                mBRuntime.nativeNotifyWindowChangedForSurface(mBRuntime.f147291a, this.f147302b, this.f147301a, this.f147303c, this.f147304d);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f147306a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SurfaceTexture f147307b;

        public b(int i3, SurfaceTexture surfaceTexture) {
            this.f147306a = i3;
            this.f147307b = surfaceTexture;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MBRuntime.this, Integer.valueOf(i3), surfaceTexture);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (MBRuntime.this.f147291a == 0) {
                return;
            }
            MBRuntime mBRuntime = MBRuntime.this;
            mBRuntime.nativeNotifyWindowDestroyed(mBRuntime.f147291a, this.f147306a);
            SurfaceTexture surfaceTexture = this.f147307b;
            if (surfaceTexture == null) {
                com.tencent.luggage.wxa.p8.f.a("MicroMsg.MagicBrush.MBRuntime", new RuntimeException("Stub here!"), "hy: text is null, do not release. maybe released by other module", new Object[0]);
            } else {
                surfaceTexture.release();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f147309a;

        public c(int i3) {
            this.f147309a = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MBRuntime.this, i3);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                MBRuntime mBRuntime = MBRuntime.this;
                mBRuntime.nativeNotifyWindowDestroyed(mBRuntime.f147291a, this.f147309a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JsTouchEventHandler.a f147311a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f147312b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f147313c;

        public d(JsTouchEventHandler.a aVar, long j3, int i3) {
            this.f147311a = aVar;
            this.f147312b = j3;
            this.f147313c = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MBRuntime.this, aVar, Long.valueOf(j3), Integer.valueOf(i3));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (MBRuntime.this.f147291a == 0) {
                this.f147311a.a(this.f147312b);
            } else {
                MBRuntime mBRuntime = MBRuntime.this;
                mBRuntime.nativeNotifyTouchEvent(mBRuntime.f147291a, this.f147313c, this.f147312b);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IImageDecodeService.c f147315a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f147316b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f147317c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ImageDecodeConfig f147318d;

        public e(IImageDecodeService.c cVar, String str, Object obj, ImageDecodeConfig imageDecodeConfig) {
            this.f147315a = cVar;
            this.f147316b = str;
            this.f147317c = obj;
            this.f147318d = imageDecodeConfig;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MBRuntime.this, cVar, str, obj, imageDecodeConfig);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (MBRuntime.this.f147291a == 0) {
                this.f147315a.a(this.f147316b, this.f147317c);
            } else {
                MBRuntime mBRuntime = MBRuntime.this;
                mBRuntime.nativeNotifyImageDecoded(mBRuntime.f147291a, this.f147316b, this.f147317c, this.f147318d);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f147320a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f147321b;

        public f(int i3, boolean z16) {
            this.f147320a = i3;
            this.f147321b = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MBRuntime.this, Integer.valueOf(i3), Boolean.valueOf(z16));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.magicbrush.ui.g findOrNull = MBRuntime.this.r().findOrNull(this.f147320a);
            if (findOrNull != null) {
                findOrNull.setOpaque(!this.f147321b);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f147323a;

        public g(int i3) {
            this.f147323a = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MBRuntime.this, i3);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.luggage.wxa.p8.f.c("MicroMsg.MagicBrush.MBRuntime", "switchToJsThread Runnable taskId: " + this.f147323a, new Object[0]);
            MBRuntime mBRuntime = MBRuntime.this;
            mBRuntime.nativeRunOnJsThread(mBRuntime.f147291a, this.f147323a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class h implements Runnable {
        static IPatchRedirector $redirector_;

        public h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MBRuntime.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                MBRuntime mBRuntime = MBRuntime.this;
                mBRuntime.nativeInit(mBRuntime.f147291a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class i implements Runnable {
        static IPatchRedirector $redirector_;

        public i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MBRuntime.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            MBRuntime mBRuntime = MBRuntime.this;
            mBRuntime.nativeResume(mBRuntime.f147291a);
            MBRuntime.this.f147299i.m();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class j implements Runnable {
        static IPatchRedirector $redirector_;

        public j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MBRuntime.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            MBRuntime.this.f147299i.l();
            MBRuntime mBRuntime = MBRuntime.this;
            mBRuntime.nativePause(mBRuntime.f147291a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class k implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SurfaceTexture f147328a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f147329b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f147330c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f147331d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f147332e;

        public k(SurfaceTexture surfaceTexture, int i3, int i16, int i17, boolean z16) {
            this.f147328a = surfaceTexture;
            this.f147329b = i3;
            this.f147330c = i16;
            this.f147331d = i17;
            this.f147332e = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MBRuntime.this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (this.f147328a == null) {
                com.tencent.luggage.wxa.p8.f.a("MicroMsg.MagicBrush.MBRuntime", new RuntimeException("Stub here!"), "hy: text is null, do not notifyWindowAvailable. maybe released by other module", new Object[0]);
            } else {
                MBRuntime mBRuntime = MBRuntime.this;
                mBRuntime.nativeNotifyWindowAvailable(mBRuntime.f147291a, this.f147329b, this.f147328a, this.f147330c, this.f147331d, this.f147332e);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class l implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f147334a;

        public l(Runnable runnable) {
            this.f147334a = runnable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MBRuntime.this, (Object) runnable);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                if (MBRuntime.this.f147291a == 0) {
                    return;
                }
                this.f147334a.run();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class m implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f147336a;

        public m(Runnable runnable) {
            this.f147336a = runnable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MBRuntime.this, (Object) runnable);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                if (MBRuntime.this.f147291a == 0) {
                    return;
                }
                this.f147336a.run();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class n implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Surface f147338a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f147339b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f147340c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f147341d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f147342e;

        public n(Surface surface, int i3, int i16, int i17, boolean z16) {
            this.f147338a = surface;
            this.f147339b = i3;
            this.f147340c = i16;
            this.f147341d = i17;
            this.f147342e = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MBRuntime.this, surface, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (!MBRuntime.this.a(this.f147338a)) {
                com.tencent.luggage.wxa.p8.f.b("MicroMsg.MagicBrush.MBRuntime", "create for invalid surface %d", Integer.valueOf(this.f147339b));
            } else {
                MBRuntime mBRuntime = MBRuntime.this;
                mBRuntime.nativeNotifyWindowAvailableForSurface(mBRuntime.f147291a, this.f147339b, this.f147338a, this.f147340c, this.f147341d, this.f147342e);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class o implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SurfaceTexture f147344a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f147345b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f147346c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f147347d;

        public o(SurfaceTexture surfaceTexture, int i3, int i16, int i17) {
            this.f147344a = surfaceTexture;
            this.f147345b = i3;
            this.f147346c = i16;
            this.f147347d = i17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MBRuntime.this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (this.f147344a == null) {
                com.tencent.luggage.wxa.p8.f.a("MicroMsg.MagicBrush.MBRuntime", new RuntimeException("Stub here!"), "hy: text is null, do not notifyWindowChanged. maybe released by other module", new Object[0]);
            } else {
                MBRuntime mBRuntime = MBRuntime.this;
                mBRuntime.nativeNotifyWindowChanged(mBRuntime.f147291a, this.f147345b, this.f147344a, this.f147346c, this.f147347d);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface p {
        void a(boolean z16);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58026);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            com.tencent.luggage.wxa.p8.f.c("MicroMsg.MagicBrush.MBRuntime", "enter static block", new Object[0]);
            com.tencent.luggage.wxa.p8.b.a();
        }
    }

    public MBRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f147293c = new HashSet();
        this.f147294d = null;
        this.f147295e = null;
        this.f147296f = null;
        this.f147297g = null;
        this.f147300j = new com.tencent.luggage.wxa.o8.b(this);
    }

    private native void nativeMarkNeedCallbackBeforeSwapThisFrame(long j3);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeRunOnJsThread(long j3, int i3);

    public static boolean q() {
        return false;
    }

    public abstract com.tencent.magicbrush.a a();

    @AnyThread
    @Keep
    public void applyWindowAttributes(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            com.tencent.luggage.wxa.w8.g.a(new f(i3, z16));
        }
    }

    @Keep
    public void beforeSwap(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, (Object) this, z16);
            return;
        }
        com.tencent.luggage.wxa.p8.f.c("MicroMsg.MagicBrush.MBRuntime", "hy: beforeSwap! %b", Boolean.valueOf(z16));
        p pVar = this.f147294d;
        if (pVar != null) {
            pVar.a(z16);
        }
    }

    @Nullable
    @Keep
    public Bitmap captureScreen(int i3, int i16, int i17, @Nullable Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            return (Bitmap) iPatchRedirector.redirect((short) 73, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), bitmap);
        }
        return a().a(i3, i16, i17, bitmap);
    }

    public void d(final int i3, final String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3, (Object) str);
        } else {
            if (this.f147291a == 0) {
                return;
            }
            a(new Runnable() { // from class: com.tencent.magicbrush.e
                @Override // java.lang.Runnable
                public final void run() {
                    MBRuntime.this.b(i3, str);
                }
            });
        }
    }

    @Keep
    public boolean doInnerLoopTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            return ((Boolean) iPatchRedirector.redirect((short) 83, (Object) this)).booleanValue();
        }
        if (this.f147298h != null) {
            return this.f147298h.c();
        }
        return true;
    }

    public IMBFontHandler e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (IMBFontHandler) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return this.f147297g;
    }

    public BaseImageDecodeService f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (BaseImageDecodeService) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return this.f147296f;
    }

    public com.tencent.luggage.wxa.o8.b g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (com.tencent.luggage.wxa.o8.b) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        return this.f147300j;
    }

    public com.tencent.luggage.wxa.r8.b h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (com.tencent.luggage.wxa.r8.b) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        return this.f147298h;
    }

    public MBParams i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (MBParams) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        return this.f147292b;
    }

    @Keep
    public int insertElement(float f16, float f17, float f18, float f19, int i3, int i16) {
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            return ((Integer) iPatchRedirector.redirect((short) 79, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        try {
            i17 = a(f16, f17, f18, f19, i3, i16);
            try {
                com.tencent.luggage.wxa.p8.f.c("MicroMsg.MagicBrush.MBRuntime", "dl: ScreenCanvas: insertElement a ScreenCanvas [%f, %f, %f, %f, %d]...done", Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Integer.valueOf(i3));
            } catch (Exception e16) {
                e = e16;
                com.tencent.luggage.wxa.p8.f.a("MicroMsg.MagicBrush.MBRuntime", e, "dl: ScreenCanvas: insertElement failed", new Object[0]);
                com.tencent.luggage.wxa.p8.f.c("MicroMsg.MagicBrush.MBRuntime", "dl: ScreenCanvas: insertElement a ScreenCanvas, result = [%d]", Integer.valueOf(i17));
                return i17;
            }
        } catch (Exception e17) {
            e = e17;
            i17 = -1;
        }
        com.tencent.luggage.wxa.p8.f.c("MicroMsg.MagicBrush.MBRuntime", "dl: ScreenCanvas: insertElement a ScreenCanvas, result = [%d]", Integer.valueOf(i17));
        return i17;
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.f147299i = com.tencent.magicbrush.ui.a.a(this, this.f147298h, i().animationFrameHandlerStrategy);
        if (this.f147297g == null) {
            this.f147297g = new com.tencent.luggage.wxa.s8.i();
            nativeSetFontHandler(this.f147291a, this.f147297g);
        }
        if (this.f147298h != null) {
            if (this.f147296f != null) {
                if (this.f147297g != null) {
                    if (this.f147291a == 0) {
                        com.tencent.luggage.wxa.p8.f.c("MicroMsg.MagicBrush.MBRuntime", "init. mNativeInst == 0", new Object[0]);
                        return;
                    } else {
                        a(new h());
                        return;
                    }
                }
                throw new IllegalStateException("[MBRuntime] FontHandler not registered.");
            }
            throw new IllegalStateException("[MBRuntime] ImageHandler not registered.");
        }
        throw new IllegalStateException("[MBRuntime] JsThreadHandler not registered.");
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            if (this.f147291a == 0) {
                return;
            }
            nativeNotifyAnimationFrameLooper(this.f147291a);
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        com.tencent.luggage.wxa.p8.f.c("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.pause ", new Object[0]);
        this.f147300j.l();
        b(new j());
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        com.tencent.luggage.wxa.p8.f.c("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.resume ", new Object[0]);
        if (this.f147292b.fetch_fps_by_period) {
            this.f147300j.j();
        }
        b(new i());
    }

    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f147296f = null;
            this.f147297g = null;
        }
    }

    @AnyThread
    public native void nativeBindExtTextureManager(long j3, MBExternalTextureMgr mBExternalTextureMgr);

    public native void nativeBindTo(long j3, long j16, long j17, long j18);

    public native Bitmap nativeCaptureCanvas(long j3, int i3);

    public native Bitmap nativeCaptureScreen(long j3, int i3);

    public native long nativeCreate(@NonNull MBParams mBParams);

    public native void nativeDestroy(long j3);

    @AnyThread
    public native float[] nativeGetCurrentFps(long j3);

    @AnyThread
    public native float nativeGetCurrentFpsVariance(long j3);

    @AnyThread
    public native int nativeGetDrawCalls(long j3);

    @AnyThread
    public native int nativeGetFrameCounter(long j3);

    @AnyThread
    public native int nativeGetTriangles(long j3);

    @AnyThread
    public native int nativeGetVertexes(long j3);

    public native void nativeInit(long j3);

    public native void nativeLazyLoadBox2D(long j3, String str);

    public native void nativeLazyLoadPhysx(long j3, String str);

    public native void nativeNotifyAnimationFrame(long j3, double d16);

    public native void nativeNotifyAnimationFrameLooper(long j3);

    @AnyThread
    public native void nativeNotifyBeforeWindowDestroyed(long j3, int i3);

    public native void nativeNotifyExtSurfaceFrameAvailable(long j3, int i3, String str);

    public native void nativeNotifyImageDecoded(long j3, String str, Object obj, ImageDecodeConfig imageDecodeConfig);

    public native void nativeNotifyTouchEvent(long j3, int i3, long j16);

    public native void nativeNotifyWindowAvailable(long j3, int i3, @NonNull SurfaceTexture surfaceTexture, int i16, int i17, boolean z16);

    public native void nativeNotifyWindowAvailableForSurface(long j3, int i3, @NonNull Surface surface, int i16, int i17, boolean z16);

    public native void nativeNotifyWindowChanged(long j3, int i3, @NonNull SurfaceTexture surfaceTexture, int i16, int i17);

    public native void nativeNotifyWindowChangedForSurface(long j3, int i3, @NonNull Surface surface, int i16, int i17);

    public native void nativeNotifyWindowDestroyed(long j3, int i3);

    public native void nativePause(long j3);

    public native void nativeRegisterExtSurface(long j3, int i3, String str, int i16, int i17, Surface surface);

    public native void nativeResume(long j3);

    public native void nativeSetEventListener(long j3, EventDispatcher eventDispatcher);

    public native void nativeSetFontHandler(long j3, @NonNull IMBFontHandler iMBFontHandler);

    public native void nativeSetImageHandler(long j3, @NonNull IImageDecodeService iImageDecodeService);

    public native void nativeStopAnimationFrameLooper(long j3);

    public native void nativeUnregisterExtSurface(long j3, int i3, String str);

    public abstract b.e o();

    @Keep
    public void onFrameCaptureGenerated(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, (Object) this, (Object) str);
        } else {
            com.tencent.luggage.wxa.p8.f.c("MicroMsg.MagicBrush.MBRuntime", "frame capture file generated %s", str);
            this.f147292b.getClass();
        }
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            if (this.f147291a == 0) {
                return;
            }
            nativeStopAnimationFrameLooper(this.f147291a);
        }
    }

    public abstract MBViewManager r();

    @Keep
    public void removeElement(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, (Object) this, i3);
            return;
        }
        try {
            com.tencent.magicbrush.ui.g findOrNull = r().findOrNull(i3);
            if (findOrNull == null) {
                com.tencent.luggage.wxa.p8.f.b("MicroMsg.MagicBrush.MBRuntime", "dl: ScreenCanvas: removeElement window_id = [%d] not found!", Integer.valueOf(i3));
                return;
            }
            b.e o16 = o();
            Objects.requireNonNull(o16);
            o16.a(findOrNull);
            com.tencent.luggage.wxa.p8.f.c("MicroMsg.MagicBrush.MBRuntime", "dl: ScreenCanvas: removeElement a ScreenCanvas window_id = [%d]...done", Integer.valueOf(i3));
        } catch (Exception e16) {
            com.tencent.luggage.wxa.p8.f.a("MicroMsg.MagicBrush.MBRuntime", e16, "dl: ScreenCanvas: removeElement failed", new Object[0]);
        }
    }

    @Keep
    public void resumeLoopTasks() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            iPatchRedirector.redirect((short) 78, (Object) this);
        } else if (this.f147298h != null) {
            this.f147298h.b();
        }
    }

    @Keep
    public void setTouchableRectList(int i3, float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, this, Integer.valueOf(i3), fArr, fArr2, fArr3, fArr4);
            return;
        }
        try {
            com.tencent.magicbrush.ui.g findOrNull = r().findOrNull(i3);
            if (findOrNull == null) {
                com.tencent.luggage.wxa.p8.f.b("MicroMsg.MagicBrush.MBRuntime", "ScreenCanvas: setTouchableRectList window_id = [%d] not found!", Integer.valueOf(i3));
                return;
            }
            float f16 = this.f147292b.device_pixel_ratio_;
            for (int i16 = 0; i16 < fArr.length; i16++) {
                fArr[i16] = fArr[i16] * f16;
                fArr2[i16] = fArr2[i16] * f16;
                fArr3[i16] = fArr3[i16] * f16;
                fArr4[i16] = fArr4[i16] * f16;
            }
            b.e o16 = o();
            Objects.requireNonNull(o16);
            o16.a(findOrNull, fArr, fArr2, fArr3, fArr4);
            com.tencent.luggage.wxa.p8.f.c("MicroMsg.MagicBrush.MBRuntime", "ScreenCanvas: setTouchableRectList for window_id = [%d]...done", Integer.valueOf(i3));
        } catch (Exception e16) {
            com.tencent.luggage.wxa.p8.f.a("MicroMsg.MagicBrush.MBRuntime", e16, "ScreenCanvas: setTouchableRect failed", new Object[0]);
        }
    }

    @AnyThread
    @Keep
    public void switchToJsThread(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, (Object) this, i3);
            return;
        }
        com.tencent.luggage.wxa.p8.f.c("MicroMsg.MagicBrush.MBRuntime", "switchToJsThread taskId: " + i3, new Object[0]);
        if (this.f147298h != null) {
            try {
                this.f147298h.b(new g(i3));
                return;
            } catch (Throwable th5) {
                com.tencent.luggage.wxa.p8.f.a("MicroMsg.MagicBrush.MBRuntime", th5, "hy: switchToJsThread crash!", new Object[0]);
                throw th5;
            }
        }
        com.tencent.luggage.wxa.p8.f.b("MicroMsg.MagicBrush.MBRuntime", "hy: switchToJsThread no js thread handler", new Object[0]);
    }

    @Keep
    public void updateElement(int i3, float f16, float f17, float f18, float f19, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, this, Integer.valueOf(i3), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Integer.valueOf(i16));
            return;
        }
        try {
            com.tencent.magicbrush.ui.g findOrNull = r().findOrNull(i3);
            if (findOrNull == null) {
                com.tencent.luggage.wxa.p8.f.b("MicroMsg.MagicBrush.MBRuntime", "dl: ScreenCanvas: updateElement window_id = [%d] not found!", Integer.valueOf(i3));
                return;
            }
            b();
            float f26 = this.f147292b.device_pixel_ratio_;
            b.e o16 = o();
            Objects.requireNonNull(o16);
            o16.a(findOrNull, Math.round(f16 * f26), Math.round(f17 * f26), Math.round(f18 * f26), Math.round(f26 * f19), i16);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.p8.f.a("MicroMsg.MagicBrush.MBRuntime", e16, "dl: ScreenCanvas: updateElement failed", new Object[0]);
        }
    }

    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 77)) {
            return;
        }
        iPatchRedirector.redirect((short) 77, (Object) this, i3);
    }

    public void c(final int i3, final String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3, (Object) str);
        } else {
            if (this.f147291a == 0) {
                return;
            }
            a(new Runnable() { // from class: com.tencent.magicbrush.g
                @Override // java.lang.Runnable
                public final void run() {
                    MBRuntime.this.a(i3, str);
                }
            });
        }
    }

    public boolean b(Runnable runnable) {
        com.tencent.luggage.wxa.r8.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) runnable)).booleanValue();
        }
        if (runnable == null || this.f147291a == 0 || (bVar = this.f147298h) == null) {
            return false;
        }
        bVar.a(new m(runnable), true);
        return true;
    }

    public com.tencent.luggage.wxa.o8.a d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 34)) ? g().d() : (com.tencent.luggage.wxa.o8.a) iPatchRedirector.redirect((short) 34, (Object) this);
    }

    public void a(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Double.valueOf(d16));
        } else {
            if (this.f147291a == 0) {
                return;
            }
            nativeNotifyAnimationFrame(this.f147291a, d16);
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        com.tencent.luggage.wxa.p8.f.c("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.destroy", new Object[0]);
        this.f147300j.l();
        if (this.f147291a == 0) {
            com.tencent.luggage.wxa.p8.f.c("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.destroy skip outside", new Object[0]);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            if (this.f147291a == 0) {
                com.tencent.luggage.wxa.p8.f.c("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.destroy skip inside, lock [%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return;
            }
            this.f147299i.b();
            nativeDestroy(this.f147291a);
            this.f147298h = null;
            n();
            this.f147291a = 0L;
        }
    }

    public void a(int i3, SurfaceTexture surfaceTexture, int i16, int i17, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), surfaceTexture, Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16));
            return;
        }
        com.tencent.luggage.wxa.p8.f.c("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.notifyWindowAvailable windowId:%d %s", Integer.valueOf(i3), surfaceTexture);
        if (i3 >= 0) {
            b(new k(surfaceTexture, i3, i16, i17, z16));
            return;
        }
        throw new IllegalArgumentException("windowId < 0");
    }

    public void b(final int i3, final String str, final int i16, final int i17, final Surface surface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17), surface);
        } else {
            if (this.f147291a == 0) {
                return;
            }
            a(new Runnable() { // from class: com.tencent.magicbrush.f
                @Override // java.lang.Runnable
                public final void run() {
                    MBRuntime.this.a(i3, str, i16, i17, surface);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(int i3, String str) {
        nativeUnregisterExtSurface(this.f147291a, i3, str);
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else if (this.f147292b.device_pixel_ratio_ <= 0.0f) {
            throw new IllegalStateException("device pixel ratio is null");
        }
    }

    public boolean a(Runnable runnable) {
        com.tencent.luggage.wxa.r8.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) runnable)).booleanValue();
        }
        if (runnable == null || this.f147291a == 0 || (bVar = this.f147298h) == null) {
            return false;
        }
        bVar.a(new l(runnable));
        return true;
    }

    public final boolean a(Runnable runnable, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, runnable, Long.valueOf(j3))).booleanValue();
        }
        if (runnable == null) {
            return false;
        }
        com.tencent.luggage.wxa.w8.f fVar = new com.tencent.luggage.wxa.w8.f(runnable);
        if (!b(fVar)) {
            return false;
        }
        fVar.a(j3);
        return fVar.b();
    }

    public final void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else if (i3 < 0) {
            throw new IllegalArgumentException("windowId < 0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i3, String str, int i16, int i17, Surface surface) {
        nativeRegisterExtSurface(this.f147291a, i3, str, i16, i17, surface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i3, String str) {
        nativeNotifyExtSurfaceFrameAvailable(this.f147291a, i3, str);
    }

    public final boolean a(Surface surface) {
        boolean contains;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) surface)).booleanValue();
        }
        synchronized (this) {
            contains = this.f147293c.contains(surface);
        }
        return contains;
    }

    public void a(int i3, Surface surface, int i16, int i17, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), surface, Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16));
            return;
        }
        com.tencent.luggage.wxa.p8.f.c("MicroMsg.MagicBrush.MBRuntime", "hy: notifyWindowAvailable: %d, %d, %d %s", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), surface);
        if (surface != null) {
            synchronized (this) {
                this.f147293c.add(surface);
            }
            b(new n(surface, i3, i16, i17, z16));
            return;
        }
        throw new RuntimeException("surface == null");
    }

    public void a(int i3, SurfaceTexture surfaceTexture, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), surfaceTexture, Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        com.tencent.luggage.wxa.p8.f.c("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.notifyWindowChanged ", new Object[0]);
        a(i3);
        b(new o(surfaceTexture, i3, i16, i17));
    }

    public void a(int i3, Surface surface, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Integer.valueOf(i3), surface, Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        com.tencent.luggage.wxa.p8.f.c("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.notifyWindowChanged Surface[%s] %d, %d", surface, Integer.valueOf(i16), Integer.valueOf(i17));
        a(i3);
        b(new a(surface, i3, i16, i17));
    }

    public void a(int i3, SurfaceTexture surfaceTexture, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Integer.valueOf(i3), surfaceTexture, Boolean.valueOf(z16));
            return;
        }
        com.tencent.luggage.wxa.p8.f.c("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.notifyWindowDestroyed shouldDestroySync: %b", Boolean.valueOf(z16));
        if (this.f147291a == 0) {
            return;
        }
        a(i3);
        b bVar = new b(i3, surfaceTexture);
        if (z16) {
            boolean z17 = this.f147292b.sync_surface_destroy;
            com.tencent.luggage.wxa.p8.f.c("MicroMsg.MagicBrush.MBRuntime", "[surface] destroy window(surfacetexture) param:true windowId:%d sync?%b %s", Integer.valueOf(i3), Boolean.valueOf(z17), surfaceTexture);
            if (z17) {
                a(bVar, 3000L);
            } else {
                b(bVar);
            }
            com.tencent.luggage.wxa.p8.f.c("MicroMsg.MagicBrush.MBRuntime", "[surface] destroy window(surfacetexture) done. windowId:%d", Integer.valueOf(i3));
            return;
        }
        com.tencent.luggage.wxa.p8.f.c("MicroMsg.MagicBrush.MBRuntime", "[surface] destroy window(surfacetexture) runOnJsThreadIgnorePause windowId:%d %s", Integer.valueOf(i3), surfaceTexture);
        b(bVar);
    }

    public void a(int i3, Surface surface, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Integer.valueOf(i3), surface, Boolean.valueOf(z16));
            return;
        }
        com.tencent.luggage.wxa.p8.f.c("MicroMsg.MagicBrush.MBRuntime", "hy: notifyWindowDestroyed: %d", Integer.valueOf(i3));
        if (this.f147291a == 0) {
            return;
        }
        a(i3);
        synchronized (this) {
            if (this.f147291a != 0) {
                nativeNotifyBeforeWindowDestroyed(this.f147291a, i3);
            }
            this.f147293c.remove(surface);
        }
        boolean z17 = this.f147292b.sync_surface_destroy || z16;
        c cVar = new c(i3);
        com.tencent.luggage.wxa.p8.f.c("MicroMsg.MagicBrush.MBRuntime", "[surface] destroy window(surface) windowId:%d sync?%b", Integer.valueOf(i3), Boolean.valueOf(z17));
        if (z17) {
            com.tencent.luggage.wxa.r8.b bVar = this.f147298h;
            if (a(cVar, 3000L)) {
                return;
            }
            Object[] objArr = new Object[1];
            objArr[0] = bVar != null ? bVar.d() : "unknown";
            com.tencent.luggage.wxa.p8.f.b("MicroMsg.MagicBrush.MBRuntime", "notifyWindowDestroyed, but await fail. [deadlock]:    %s", objArr);
            return;
        }
        b(cVar);
    }

    public Bitmap a(int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (Bitmap) iPatchRedirector.redirect((short) 26, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
        }
        if (this.f147291a == 0) {
            return null;
        }
        if (z16) {
            return nativeCaptureScreen(this.f147291a, i3);
        }
        return nativeCaptureCanvas(this.f147291a, i16);
    }

    public void a(p pVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) pVar);
        } else {
            this.f147294d = pVar;
            nativeMarkNeedCallbackBeforeSwapThisFrame(this.f147291a);
        }
    }

    public void a(BaseImageDecodeService baseImageDecodeService) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) baseImageDecodeService);
        } else {
            this.f147296f = baseImageDecodeService;
            nativeSetImageHandler(this.f147291a, baseImageDecodeService);
        }
    }

    public void a(IMBFontHandler iMBFontHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) iMBFontHandler);
        } else {
            this.f147297g = iMBFontHandler;
            nativeSetFontHandler(this.f147291a, iMBFontHandler);
        }
    }

    public void a(int i3, long j3, JsTouchEventHandler.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, Integer.valueOf(i3), Long.valueOf(j3), aVar);
            return;
        }
        if (this.f147291a == 0) {
            aVar.a(j3);
            return;
        }
        com.tencent.luggage.wxa.r8.b bVar = this.f147298h;
        if (bVar == null) {
            aVar.a(j3);
        } else {
            bVar.a(new d(aVar, j3, i3));
        }
    }

    public void a(String str, Object obj, IImageDecodeService.c cVar, ImageDecodeConfig imageDecodeConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, str, obj, cVar, imageDecodeConfig);
            return;
        }
        if (this.f147291a == 0) {
            cVar.a(str, obj);
            return;
        }
        com.tencent.luggage.wxa.r8.b bVar = this.f147298h;
        if (bVar == null) {
            cVar.a(str, obj);
        } else {
            bVar.a(new e(cVar, str, obj, imageDecodeConfig));
        }
    }

    public void a(com.tencent.luggage.wxa.r8.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) aVar);
            return;
        }
        com.tencent.luggage.wxa.p8.f.c("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.set_jsthread_handler ", new Object[0]);
        if (this.f147298h != null) {
            com.tencent.luggage.wxa.p8.f.b("MicroMsg.MagicBrush.MBRuntime", "Why you set_jsthread_handler twice, unexpected behaviour.", new Object[0]);
        } else {
            this.f147298h = new com.tencent.luggage.wxa.r8.b(this.f147291a, aVar);
        }
    }

    public final int a(float f16, float f17, float f18, float f19, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        b.e o16 = o();
        Objects.requireNonNull(o16);
        com.tencent.magicbrush.ui.g a16 = o16.a();
        b();
        float f26 = this.f147292b.device_pixel_ratio_;
        a16.setCanvasId(i16);
        b.e o17 = o();
        Objects.requireNonNull(o17);
        o17.b(a16, Math.round(f16 * f26), Math.round(f17 * f26), Math.round(f18 * f26), Math.round(f19 * f26), i3);
        return a16.getVirtualElementId();
    }
}
