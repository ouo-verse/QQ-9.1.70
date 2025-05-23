package com.tencent.luggage.wxa.i8;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Looper;
import android.util.Size;
import android.view.Surface;
import androidx.core.util.Supplier;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ark.EGLContextHolder;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippy.qq.view.video.constants.HVideoConstants;
import com.tencent.luggage.wxa.a8.h;
import com.tencent.luggage.wxa.ag.j;
import com.tencent.luggage.wxa.i8.e;
import com.tencent.luggage.wxa.j8.c;
import com.tencent.luggage.wxa.p004if.p;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.d;
import com.tencent.luggage.wxa.xg.g;
import com.tencent.luggage.wxa.z7.c;
import com.tencent.luggage.wxa.zg.j;
import com.tencent.mm.plugin.appbrand.extendplugin.AppBrandInvokeContext;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import kotlin.jvm.functions.Function0;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends com.tencent.luggage.wxa.k8.a implements com.tencent.luggage.wxa.a8.j {
    public static Runnable M0;
    public static Supplier N0;
    public static h.a O0 = com.tencent.luggage.wxa.a8.t.a(com.tencent.luggage.wxa.a8.u.Video);
    public com.tencent.luggage.wxa.i8.b A0;
    public com.tencent.luggage.wxa.a8.x B0;
    public c.a C;
    public float C0;
    public boolean D;
    public float D0;
    public boolean E;
    public boolean E0;
    public boolean F;
    public boolean F0;
    public boolean G;
    public com.tencent.luggage.wxa.a8.j G0;
    public long H;
    public AtomicBoolean H0;
    public boolean I;
    public volatile String I0;
    public boolean J;
    public volatile String J0;
    public boolean K;
    public volatile com.tencent.luggage.wxa.a8.g K0;
    public volatile boolean L;
    public volatile Bitmap L0;
    public boolean M;
    public boolean N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public String W;
    public String X;
    public boolean Y;
    public boolean Z;

    /* renamed from: a, reason: collision with root package name */
    public Surface f129510a;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f129511a0;

    /* renamed from: b, reason: collision with root package name */
    public volatile SurfaceTexture f129512b;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f129513b0;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f129514c;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f129515c0;

    /* renamed from: d, reason: collision with root package name */
    public volatile int f129516d;

    /* renamed from: d0, reason: collision with root package name */
    public AtomicBoolean f129517d0;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.xg.g f129518e;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f129519e0;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.j8.d f129520f;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f129521f0;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.luggage.wxa.j8.a f129522g;

    /* renamed from: g0, reason: collision with root package name */
    public final boolean f129523g0;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.j8.c f129524h;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f129525h0;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.luggage.wxa.j8.e f129526i;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f129527i0;

    /* renamed from: j, reason: collision with root package name */
    public com.tencent.luggage.wxa.j8.f f129528j;

    /* renamed from: j0, reason: collision with root package name */
    public String f129529j0;

    /* renamed from: k, reason: collision with root package name */
    public com.tencent.luggage.wxa.j8.b f129530k;

    /* renamed from: k0, reason: collision with root package name */
    public String f129531k0;

    /* renamed from: l, reason: collision with root package name */
    public volatile com.tencent.luggage.wxa.ai.b f129532l;

    /* renamed from: l0, reason: collision with root package name */
    public final ConcurrentLinkedQueue f129533l0;

    /* renamed from: m, reason: collision with root package name */
    public com.tencent.luggage.wxa.z7.c f129534m;

    /* renamed from: m0, reason: collision with root package name */
    public final com.tencent.luggage.wxa.a8.h f129535m0;

    /* renamed from: n0, reason: collision with root package name */
    public final com.tencent.luggage.wxa.dq.a f129536n0;

    /* renamed from: o0, reason: collision with root package name */
    public volatile com.tencent.luggage.wxa.z7.c f129537o0;

    /* renamed from: p0, reason: collision with root package name */
    public com.tencent.luggage.wxa.cg.c f129538p0;

    /* renamed from: q0, reason: collision with root package name */
    public String f129539q0;

    /* renamed from: r0, reason: collision with root package name */
    public Surface f129540r0;

    /* renamed from: s0, reason: collision with root package name */
    public final com.tencent.luggage.wxa.i8.a f129541s0;

    /* renamed from: t0, reason: collision with root package name */
    public final com.tencent.luggage.wxa.p004if.b0 f129542t0;

    /* renamed from: u0, reason: collision with root package name */
    public m0 f129543u0;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f129544v0;

    /* renamed from: w0, reason: collision with root package name */
    public com.tencent.luggage.wxa.xd.t f129545w0;

    /* renamed from: x0, reason: collision with root package name */
    public com.tencent.luggage.wxa.a8.a f129546x0;

    /* renamed from: y0, reason: collision with root package name */
    public com.tencent.luggage.wxa.a8.b f129547y0;

    /* renamed from: z0, reason: collision with root package name */
    public n0 f129548z0;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.v();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a0 implements com.tencent.luggage.wxa.a8.n {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.i8.e$a0$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC6287a implements Runnable {
                public RunnableC6287a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.H0.get() && e.this.f129518e != null) {
                        e.this.f129518e.setSurface(null);
                        if (!e.this.f129518e.isPlaying()) {
                            e.this.e(false);
                        }
                    }
                }
            }

            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.a(new RunnableC6287a());
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!e.this.H0.get() && e.this.f129518e != null) {
                    e.this.f129518e.setSurface(e.this.f129510a);
                    if (!e.this.f129518e.isPlaying()) {
                        e.this.e(false);
                    }
                }
            }
        }

        public a0() {
        }

        @Override // com.tencent.luggage.wxa.a8.n
        public void playAudio() {
            com.tencent.luggage.wxa.tn.w.a(e.this.getLogTag(), "playAudio");
            if (!e.this.H0.getAndSet(true)) {
                e.this.tryCacheSnapshotBeforePlayAudio(new a());
            }
        }

        @Override // com.tencent.luggage.wxa.a8.n
        public void playVideo() {
            com.tencent.luggage.wxa.tn.w.a(e.this.getLogTag(), "playVideo");
            if (e.this.H0.getAndSet(false)) {
                e.this.a(new b());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.x();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b0 implements com.tencent.luggage.wxa.a8.o {
        public b0() {
        }

        @Override // com.tencent.luggage.wxa.a8.o
        public boolean isPlaying() {
            return e.this.isPlaying();
        }

        @Override // com.tencent.luggage.wxa.a8.o
        public void onBackgroundPlaybackChange(boolean z16) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.SameLayer.VideoPluginHandler", "onBackgroundPlaybackChange playInBackground:%b", Boolean.valueOf(z16));
            if (e.this.f129520f != null) {
                e.this.f129520f.onBackgroundPlaybackChange(z16);
            }
        }

        @Override // com.tencent.luggage.wxa.a8.o
        public void pause() {
            com.tencent.luggage.wxa.ph.a a16;
            com.tencent.luggage.wxa.tn.w.d(e.this.getLogTag(), "pause");
            e.this.pauseExternal();
            if (e.this.f129534m != null && (a16 = com.tencent.luggage.wxa.a8.e.a(e.this.f129534m)) != null && a16.j()) {
                com.tencent.luggage.wxa.tn.w.d(e.this.getLogTag(), "setPlayingWhenEnterBackground");
                e.this.setPlayingWhenEnterBackground(null);
            }
        }

        @Override // com.tencent.luggage.wxa.a8.o
        public void start() {
            com.tencent.luggage.wxa.tn.w.d(e.this.getLogTag(), "start");
            e.this.f129521f0 = true;
            e.this.playExternal();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f129556a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f129557b;

        public c(int i3, int i16) {
            this.f129556a = i3;
            this.f129557b = i16;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.b(this.f129556a, this.f129557b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c0 implements com.tencent.luggage.wxa.a8.m {
        public c0() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f129560a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f129561b;

        public d(int i3, int i16) {
            this.f129560a = i3;
            this.f129561b = i16;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.d(this.f129560a, this.f129561b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d0 implements com.tencent.luggage.wxa.a8.g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f129563a;

        public d0(Runnable runnable) {
            this.f129563a = runnable;
        }

        @Override // com.tencent.luggage.wxa.a8.g
        public void onSnapshotGot(Bitmap bitmap) {
            e.this.L0 = bitmap;
            this.f129563a.run();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.i8.e$e, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6288e implements c.a {
        public C6288e() {
        }

        @Override // com.tencent.luggage.wxa.z7.c.a
        public void onBackground(int i3) {
            com.tencent.luggage.wxa.tn.w.d(e.this.getLogTag(), "onBackground, type: " + i3);
            e.this.handleWebViewBackground(i3);
        }

        @Override // com.tencent.luggage.wxa.z7.c.a
        public void onDestroy() {
            e.this.handleWebViewDestroy();
        }

        @Override // com.tencent.luggage.wxa.z7.c.a
        public void onForeground() {
            com.tencent.luggage.wxa.tn.w.d(e.this.getLogTag(), "onForeground");
            e.this.handleWebViewForeground();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e0 implements com.tencent.luggage.wxa.a8.l {
        public e0() {
        }

        @Override // com.tencent.luggage.wxa.a8.l
        public Bitmap getSnapshotCached() {
            return e.this.L0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.handleWebViewForegroundInternal();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Surface f129568a;

        public f0(Surface surface) {
            this.f129568a = surface;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.c(this.f129568a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f129570a;

        public g(boolean z16) {
            this.f129570a = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f129518e != null && e.this.J && this.f129570a) {
                com.tencent.luggage.wxa.tn.w.d(e.this.getLogTag(), "handleWebViewForeground runnable, video playing when enter background");
                e.this.a(false, false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g0 implements Runnable {
        public g0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.handlePluginDestroyInternal();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f129573a;

        public h(int i3) {
            this.f129573a = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.handleWebViewBackgroundInternal(this.f129573a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.z7.c f129575a;

        public h0(com.tencent.luggage.wxa.z7.c cVar) {
            this.f129575a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.handleJsApiInternal(this.f129575a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f129577a;

        public i(int i3) {
            this.f129577a = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.xd.d e16;
            com.tencent.luggage.wxa.tn.w.d(e.this.getLogTag(), "handleWebViewBackground, type:%s, autoPauseIfNative:%s, autoPauseIfNavigate:%s, isRuntimeInBackground:%s, isPlayingWhenEnterBackground:%s", Integer.valueOf(this.f129577a), Boolean.valueOf(e.this.Z), Boolean.valueOf(e.this.Y), Boolean.valueOf(e.this.f129515c0), e.this.getPlayingWhenEnterBackground());
            com.tencent.luggage.wxa.p004if.r a16 = com.tencent.luggage.wxa.p004if.g.f130201b.a(e.this.Y, e.this.Z);
            com.tencent.luggage.wxa.tn.w.d(e.this.getLogTag(), "handleWebViewBackground, autoPauseStrategy: %s", a16);
            com.tencent.luggage.wxa.z7.c cVar = e.this.f129534m;
            if (cVar == null) {
                e16 = null;
            } else {
                e16 = cVar.e();
            }
            if (!a16.a(e16, com.tencent.luggage.wxa.ph.b.a(this.f129577a))) {
                if (e.this.j()) {
                    com.tencent.luggage.wxa.tn.w.d(e.this.getLogTag(), "handleWebViewBackground, video not auto pause, try resume, type:%s", Integer.valueOf(this.f129577a));
                    e.this.e(false);
                    return;
                }
                com.tencent.luggage.wxa.tn.w.d(e.this.getLogTag(), "handleWebViewBackground, video not auto pause, ignore resume, type:%s", Integer.valueOf(this.f129577a));
                if (e.this.f129518e != null && e.this.J && e.this.getPlayingWhenEnterBackground() == null) {
                    boolean isPlaying = e.this.f129518e.isPlaying();
                    e.this.setPlayingWhenEnterBackground(new AtomicBoolean(isPlaying));
                    com.tencent.luggage.wxa.tn.w.d(e.this.getLogTag(), "handleWebViewBackground runnable, video playing state when enter background:%s", Boolean.valueOf(isPlaying));
                    return;
                }
                return;
            }
            if (e.this.f129518e != null && e.this.J && e.this.getPlayingWhenEnterBackground() == null) {
                boolean isPlaying2 = e.this.f129518e.isPlaying();
                e.this.setPlayingWhenEnterBackground(new AtomicBoolean(isPlaying2));
                com.tencent.luggage.wxa.tn.w.d(e.this.getLogTag(), "handleWebViewBackground runnable, video playing state when enter background:%s", Boolean.valueOf(isPlaying2));
                if (e.this.F0 && 1 != this.f129577a && e.this.amIBackgroundAudioPlayer()) {
                    com.tencent.luggage.wxa.tn.w.d(e.this.getLogTag(), "handleWebViewBackground runnable, background play audio is enabled, do not pause");
                } else if (!e.this.amIPipPlayer()) {
                    e.this.D();
                } else {
                    com.tencent.luggage.wxa.tn.w.d(e.this.getLogTag(), "handleWebViewBackground runnable, i am pip player, do not pause");
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class i0 implements c.a {
        public i0() {
        }

        @Override // com.tencent.luggage.wxa.j8.c.a
        public void a(String str, int i3, int i16) {
            com.tencent.luggage.wxa.tn.w.h(e.this.getLogTag(), "send video error event, what:%d, extra:%d", Integer.valueOf(i3), Integer.valueOf(i16));
            if (e.this.shouldNotifyEvent()) {
                e.this.f129520f.a(str, i3, i16);
            }
            if (e.this.f129530k != null) {
                e.this.f129530k.a(e.this.f129534m, e.this.f129518e, i3, i16, str);
            }
            if (e.this.f129526i != null) {
                if (com.tencent.luggage.wxa.mg.n.c(e.this.f129518e)) {
                    if (i3 == -1024) {
                        e.this.f129526i.a(-i16, 1L, false);
                        e.this.f129526i.a(0L, 1L, false);
                    } else {
                        e.this.f129526i.a(41L, 1L, false);
                    }
                } else {
                    e.this.f129526i.a(42L, 1L, false);
                }
            }
            e.this.J();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.handleWebViewDestroyInternal();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class j0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f129581a;

        public j0(int i3) {
            this.f129581a = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.b(this.f129581a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class k implements p.a {
        public k() {
        }

        @Override // com.tencent.luggage.wxa.if.p.a
        public void onPause() {
            com.tencent.luggage.wxa.tn.w.d(e.this.getLogTag(), MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
            e.this.d(true);
        }

        @Override // com.tencent.luggage.wxa.if.p.a
        public void onResume() {
            com.tencent.luggage.wxa.tn.w.d(e.this.getLogTag(), "onResume");
            e.this.playExternal();
        }

        @Override // com.tencent.luggage.wxa.if.p.a
        public void onStop() {
            com.tencent.luggage.wxa.tn.w.d(e.this.getLogTag(), DKHippyEvent.EVENT_STOP);
            e.this.stopExternal();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class k0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f129584a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f129585b;

        public k0(int i3, int i16) {
            this.f129584a = i3;
            this.f129585b = i16;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f(this.f129584a, this.f129585b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.onRuntimeEnterForegroundInternal();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class l0 implements Runnable {
        public l0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.z();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.C();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface m0 {
        void a(boolean z16, float f16, float f17);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f129518e != null && !e.this.f129518e.isPlaying()) {
                e.this.e(false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface n0 {
        void a(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.release();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class p implements g.e {
        public p() {
        }

        @Override // com.tencent.luggage.wxa.xg.g.e
        public boolean a(com.tencent.luggage.wxa.xg.g gVar, int i3, int i16) {
            return e.this.c(i3, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class q implements g.d {
        public q() {
        }

        @Override // com.tencent.luggage.wxa.xg.g.d
        public boolean a(com.tencent.luggage.wxa.xg.g gVar, int i3, int i16) {
            return e.this.a(i3, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class r implements g.f {
        public r() {
        }

        @Override // com.tencent.luggage.wxa.xg.g.f
        public void a(com.tencent.luggage.wxa.xg.g gVar) {
            e.this.w();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class s implements g.b {
        public s() {
        }

        @Override // com.tencent.luggage.wxa.xg.g.b
        public void a(com.tencent.luggage.wxa.xg.g gVar) {
            e.this.u();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class t implements g.InterfaceC6908g {
        public t() {
        }

        @Override // com.tencent.luggage.wxa.xg.g.InterfaceC6908g
        public void a(com.tencent.luggage.wxa.xg.g gVar) {
            e.this.y();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class u implements g.i {
        public u() {
        }

        @Override // com.tencent.luggage.wxa.xg.g.i
        public void a(com.tencent.luggage.wxa.xg.g gVar, int i3, int i16) {
            e.this.e(i3, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class v implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Surface f129598a;

        public v(Surface surface) {
            this.f129598a = surface;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.handlePluginReadyInternal(this.f129598a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class w implements g.a {
        public w() {
        }

        @Override // com.tencent.luggage.wxa.xg.g.a
        public void a(com.tencent.luggage.wxa.xg.g gVar, int i3) {
            e.this.a(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class x implements com.tencent.luggage.wxa.xd.t {

        /* renamed from: a, reason: collision with root package name */
        public com.tencent.luggage.wxa.xd.s f129601a = new com.tencent.luggage.wxa.ci.c();

        public x() {
        }

        @Override // com.tencent.luggage.wxa.xd.t
        public com.tencent.luggage.wxa.xd.s createAppBrandOnVideoOrientationChanged() {
            return this.f129601a;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class y extends com.tencent.luggage.wxa.a8.a {
        public y(com.tencent.luggage.wxa.k8.a aVar, com.tencent.luggage.wxa.xd.t tVar) {
            super(aVar, tVar);
        }

        @Override // com.tencent.luggage.wxa.a8.a
        public void handleJsApi(String str, com.tencent.luggage.wxa.z7.c cVar) {
            setPageView(cVar);
            JSONObject a16 = cVar.a();
            if (!str.contains("insert") && !str.contains("update")) {
                if (str.contains("operate")) {
                    String optString = a16.optString("type");
                    if (!w0.c(optString) && optString.equalsIgnoreCase("play")) {
                        this.mIsNeedNotify = true;
                    }
                } else if (str.contains("remove")) {
                    this.mIsNeedNotify = false;
                }
            } else {
                if (a16.has("autoplay")) {
                    this.mIsNeedNotify = a16.optBoolean("autoplay");
                }
                Boolean a17 = com.tencent.luggage.wxa.xd.w.a(a16);
                if (a17 != null) {
                    this.mIsAutoRotationEnabled = a17.booleanValue();
                }
            }
            com.tencent.luggage.wxa.tn.w.a(e.this.getLogTag(), "mAutoRotationPluginHandlerCommons.handleJsApi, mIsNeedNotify: " + this.mIsNeedNotify + ", mIsAutoRotationEnabled: " + this.mIsAutoRotationEnabled);
        }

        @Override // com.tencent.luggage.wxa.a8.a
        public boolean isInForeground() {
            return !e.this.f129513b0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class z extends com.tencent.luggage.wxa.a8.b {

        /* renamed from: a, reason: collision with root package name */
        public com.tencent.luggage.wxa.i8.g f129604a = null;

        public z() {
        }

        @Override // com.tencent.luggage.wxa.a8.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.i8.g getPipInfoProvider() {
            if (this.f129604a == null) {
                this.f129604a = new com.tencent.luggage.wxa.i8.g(e.this);
            }
            return this.f129604a;
        }

        @Override // com.tencent.luggage.wxa.a8.b
        public int getId() {
            return e.this.getId();
        }

        @Override // com.tencent.luggage.wxa.a8.b
        public String getKey() {
            return e.this.getKey();
        }

        @Override // com.tencent.luggage.wxa.a8.b
        public String getLogTag() {
            return e.this.getLogTag();
        }

        @Override // com.tencent.luggage.wxa.a8.b
        public j.b getType() {
            return j.b.Video;
        }
    }

    public e() {
        this(false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ com.tencent.luggage.wxa.xd.d lambda$new$0() {
        com.tencent.luggage.wxa.z7.c cVar = this.f129534m;
        if (cVar != null) {
            return cVar.e();
        }
        return null;
    }

    public final boolean J() {
        com.tencent.luggage.wxa.xg.g gVar = this.f129518e;
        if (gVar == null) {
            return false;
        }
        com.tencent.luggage.wxa.j8.b bVar = this.f129530k;
        if (bVar != null) {
            bVar.a(this.f129534m, gVar);
        }
        if (!this.J) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "video stop, video not prepared yet, stop video when prepared");
            this.G = false;
            return true;
        }
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "video stop");
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "video stop, mWebViewInBackground: %b, isRuntimeInBackground: %b", Boolean.valueOf(this.f129513b0), Boolean.valueOf(this.f129515c0));
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "video stop, abandonFocus");
        this.f129542t0.a();
        this.f129518e.stop();
        if (shouldNotifyEvent()) {
            this.f129520f.b(true);
        }
        return true;
    }

    public final void K() {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "takeScreenshot");
        com.tencent.luggage.wxa.z7.f.a(getPluginClientProxy(), getType(), getId());
    }

    public final void a(String str) {
    }

    public final boolean amIBackgroundAudioPlayer() {
        com.tencent.luggage.wxa.z7.c cVar = this.f129534m;
        if (cVar == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "amIBackgroundAudioPlayer, mInsertInvokeContext is null");
            return false;
        }
        com.tencent.luggage.wxa.ph.a a16 = com.tencent.luggage.wxa.a8.e.a(cVar);
        if (a16 == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "amIBackgroundAudioPlayer, audioOfVideoBackgroundPlayManager is null");
            return false;
        }
        return a16.a(this);
    }

    public final boolean amIPipPlayer() {
        return this.f129547y0.amIPipPlayer(this.f129534m);
    }

    public final void clearSurface() {
        com.tencent.luggage.wxa.i8.a aVar = this.f129541s0;
        if (aVar != null) {
            aVar.a();
        }
        Surface surface = this.f129510a;
        if (surface != null) {
            surface.release();
            this.f129510a = null;
        }
    }

    public final boolean disableBackgroundPlayAudioInternal(com.tencent.luggage.wxa.z7.c cVar) {
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "disableBackgroundPlayAudioInternal");
        if (cVar == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "disableBackgroundPlayAudioInternal, invokeContext is null");
            return false;
        }
        com.tencent.luggage.wxa.ph.a a16 = com.tencent.luggage.wxa.a8.e.a(cVar);
        if (a16 == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "disableBackgroundPlayAudio, audioOfVideoBackgroundPlayManager is null");
            return false;
        }
        a16.b(this);
        return true;
    }

    public final boolean enableBackgroundPlayAudioInternal(com.tencent.luggage.wxa.z7.c cVar) {
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "enableBackgroundPlayAudioInternal");
        if (cVar == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "enableBackgroundPlayAudioInternal, invokeContext is null");
            return false;
        }
        com.tencent.luggage.wxa.ph.a a16 = com.tencent.luggage.wxa.a8.e.a(cVar);
        if (a16 == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "enableBackgroundPlayAudioInternal, audioOfVideoBackgroundPlayManager is null");
            return false;
        }
        return a16.a((com.tencent.luggage.wxa.a8.j) this, true);
    }

    @Override // com.tencent.luggage.wxa.a8.j
    public com.tencent.luggage.wxa.a8.k getAddOn(Class cls) {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "getAddOn for " + cls.getSimpleName());
        return this.G0.getAddOn(cls);
    }

    public String getKey() {
        return key() + "@" + hashCode();
    }

    public String getLogTag() {
        return String.format("%s(%s)", "MicroMsg.SameLayer.VideoPluginHandler", key());
    }

    @Override // com.tencent.luggage.wxa.a8.j
    public String getName() {
        return getKey();
    }

    public Integer getOriginPageViewId() {
        com.tencent.luggage.wxa.z7.c cVar = this.f129534m;
        if (cVar == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "getOriginPageViewId, invokeContext is null");
            return null;
        }
        com.tencent.luggage.wxa.kj.v pageView = com.tencent.luggage.wxa.a8.b.getPageView(cVar);
        if (pageView == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "getOriginPageViewId, pageView is null");
            return null;
        }
        return Integer.valueOf(pageView.hashCode());
    }

    public AtomicBoolean getPlayingWhenEnterBackground() {
        return this.f129517d0;
    }

    public final void getSnapshotAsync(com.tencent.luggage.wxa.a8.g gVar) {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "getSnapshotAsync");
        this.K0 = gVar;
        K();
    }

    public Surface getSurface() {
        return this.f129510a;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.f129512b;
    }

    public int getVideoPositionX() {
        int i3 = (int) (this.Q + (((1.0f - this.C0) * this.O) / 2.0f));
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "getVideoPositionX, videoPosX: " + i3);
        return i3;
    }

    public int getVideoPositionY() {
        int i3 = (int) (this.R + (((1.0f - this.D0) * this.P) / 2.0f));
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "getVideoPositionY, videoPosY: " + i3);
        return i3;
    }

    @Override // com.tencent.luggage.wxa.k8.b
    public String handleJsApi(com.tencent.luggage.wxa.z7.c cVar) {
        a(new h0(cVar));
        return null;
    }

    public final void handleJsApiInternal(com.tencent.luggage.wxa.z7.c cVar) {
        String c16 = cVar.c();
        if (w0.c(c16)) {
            return;
        }
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "*** handler(%s) handleJsApi(%s), data:%s", key(), c16, cVar.a().toString());
        if (c16.contains("insert")) {
            insert(cVar);
        } else if (c16.contains("update")) {
            update(cVar);
        } else if (c16.contains("operate") && c16.contains("Background")) {
            operateBackground(cVar);
        } else if (c16.contains("operate")) {
            operate(cVar);
        } else if (c16.contains("remove")) {
            remove(cVar);
        }
        this.f129546x0.handleJsApi(c16, cVar);
        String str = this.W;
        if (str == null) {
            str = "";
        }
        this.f129547y0.handlePipInfo(cVar, str);
    }

    @Override // com.tencent.luggage.wxa.k8.a, com.tencent.luggage.wxa.k8.b
    public void handlePluginDestroy() {
        this.f129512b = null;
        a(new g0());
    }

    public final void handlePluginDestroyInternal() {
        super.handlePluginDestroy();
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "*** handler(%s) handlePluginDestroy", key());
        if (!this.f129523g0) {
            J();
        } else if (isPlaying() && D()) {
            this.f129519e0 = true;
            this.f129544v0 = true;
        }
        clearSurface();
    }

    @Override // com.tencent.luggage.wxa.k8.b
    public void handlePluginReady(SurfaceTexture surfaceTexture) {
        handlePluginReadyForGPUProcess(new Surface(surfaceTexture));
    }

    @Override // com.tencent.luggage.wxa.k8.a, com.tencent.luggage.wxa.k8.b
    public void handlePluginReadyForGPUProcess(Surface surface) {
        super.handlePluginReadyForGPUProcess(surface);
        a(new v(surface));
    }

    public final void handlePluginReadyInternal(Surface surface) {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "*** handler(%s) handlePluginReady", key());
        H();
        this.f129510a = surface;
        if (this.f129518e != null) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "handlePluginReady, setSurface:%s", surface);
            this.f129518e.setSurface(this.f129510a);
            if (this.f129519e0) {
                e(true);
                this.f129544v0 = false;
                this.f129519e0 = false;
            }
        }
        com.tencent.luggage.wxa.i8.a aVar = this.f129541s0;
        if (aVar != null) {
            aVar.a(surface);
        }
        g();
    }

    @Override // com.tencent.luggage.wxa.k8.a, com.tencent.luggage.wxa.k8.b
    public void handlePluginScreenshotTaken(Bitmap bitmap) {
        super.handlePluginScreenshotTaken(bitmap);
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "*** handler(%s) handlePluginScreenshotTaken", key());
        if (!a(bitmap)) {
            b(bitmap);
        }
    }

    public final void handleWebViewBackground(int i3) {
        a(new h(i3));
    }

    public final void handleWebViewBackgroundInternal(int i3) {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "*** handler(%s) handleWebViewBackground, type:%d", key(), Integer.valueOf(i3));
        this.f129513b0 = true;
        i iVar = new i(i3);
        if (!isPluginReady(null)) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "handleWebViewBackground, plugin is not ready, add to pending tasks");
            this.f129533l0.add(iVar);
        } else {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "handleWebViewBackground, abandonFocus");
            this.f129542t0.a();
            iVar.run();
        }
    }

    public final void handleWebViewDestroy() {
        a(new j());
    }

    public final void handleWebViewDestroyInternal() {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "*** handler(%s) handleWebViewDestroy", key());
        release();
    }

    public final void handleWebViewForeground() {
        a(new f());
    }

    public final void handleWebViewForegroundInternal() {
        boolean z16 = false;
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "*** handler(%s) handleWebViewForeground", key());
        this.f129513b0 = false;
        if (!this.f129515c0) {
            z16 = j();
            setPlayingWhenEnterBackground(null);
        }
        g gVar = new g(z16);
        if (!isPluginReady(null)) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "handleWebViewForeground, plugin is not ready, add to pending tasks");
            this.f129533l0.add(gVar);
            return;
        }
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "handleWebViewForeground, isRuntimeInBackground: " + this.f129515c0);
        if (!this.f129515c0 && isPlaying() && !this.N) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "handleWebViewForeground, requestFocus");
            this.f129542t0.b();
        }
        if (!e()) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "handleWebViewForeground, resume playing");
            gVar.run();
        }
    }

    public final void insert(com.tencent.luggage.wxa.z7.c cVar) {
        String str;
        JSONObject optJSONObject;
        com.tencent.luggage.wxa.j8.d dVar;
        this.f129534m = cVar;
        com.tencent.luggage.wxa.i8.a aVar = this.f129541s0;
        if (aVar != null) {
            aVar.a(cVar.e());
        }
        if (this.f129518e == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "insert, media player is null");
            b(this.f129534m);
        }
        registerLifecycleListener(cVar);
        com.tencent.luggage.wxa.j8.b bVar = this.f129530k;
        if (bVar != null) {
            bVar.a(cVar);
        }
        if (this.f129510a != null && this.f129518e != null) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "insert, setSurface");
            this.f129518e.setSurface(this.f129510a);
        }
        JSONObject a16 = cVar.a();
        this.I = a16.optBoolean("autoplay", false);
        this.H = (long) (a16.optDouble("initialTime", 0.0d) * 1000.0d);
        this.M = a16.optBoolean("loop", false);
        boolean optBoolean = a16.optBoolean("muted", false);
        this.N = optBoolean;
        this.f129518e.setMute(optBoolean);
        this.Y = a16.optBoolean("autoPauseIfNavigate", true);
        this.Z = a16.optBoolean("autoPauseIfOpenNative", true);
        boolean optBoolean2 = a16.optBoolean("needEvent", false);
        this.K = optBoolean2;
        if (optBoolean2 && (dVar = this.f129520f) != null) {
            dVar.a(cVar);
            String optString = a16.optString("data", "");
            this.f129520f.a(optString);
            com.tencent.luggage.wxa.j8.a aVar2 = this.f129522g;
            if (aVar2 != null) {
                aVar2.a(cVar);
                this.f129522g.a(optString);
            }
        }
        if (a16.has("position") && (optJSONObject = a16.optJSONObject("position")) != null) {
            this.O = com.tencent.luggage.wxa.tk.g.a(optJSONObject.optInt("width", 0));
            this.P = com.tencent.luggage.wxa.tk.g.a(optJSONObject.optInt("height", 0));
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "insert, size:[%d, %d]", Integer.valueOf(this.O), Integer.valueOf(this.P));
        }
        String optString2 = a16.optString("objectFit", HVideoConstants.ResizeType.RESIZE_CONTAIN);
        this.X = optString2;
        if (w0.c(optString2)) {
            this.X = HVideoConstants.ResizeType.RESIZE_CONTAIN;
        }
        a(true);
        updateReferrers(cVar, a16);
        a(this.f129518e, a16);
        this.W = a16.optString("filePath");
        this.f129525h0 = a16.optBoolean("isDrm", this.f129525h0);
        this.f129527i0 = a16.optBoolean("isLive", this.f129527i0);
        this.f129529j0 = a16.optString("provisionUrl", this.f129529j0);
        this.f129531k0 = a16.optString("licenseUrl", this.f129531k0);
        if (!w0.c(this.W)) {
            com.tencent.luggage.wxa.j8.b bVar2 = this.f129530k;
            if (bVar2 != null) {
                bVar2.a(this.f129534m, this.f129518e, this.W);
            }
            String a17 = a(cVar, this.W);
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "insert, path:%s, proxy:%s", this.W, a17);
            if (!w0.c(a17)) {
                if (this.f129525h0) {
                    String str2 = null;
                    if (w0.c(this.f129529j0)) {
                        str = null;
                    } else {
                        str = this.f129529j0;
                    }
                    if (!w0.c(this.f129531k0)) {
                        str2 = this.f129531k0;
                    }
                    boolean z16 = this.f129527i0;
                    com.tencent.luggage.wxa.tn.w.d(getLogTag(), "insert, isDrm, provisionUrl:%s, licenseUrl:%s, isLive: %b", str, str2, Boolean.valueOf(z16));
                    this.f129518e.a(a17, str, str2, z16);
                } else {
                    this.f129518e.a(a17, this.f129539q0);
                }
                a(a17);
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "insert, media player prepare async");
                E();
            }
        }
        this.I0 = a16.optString("title", this.I0);
        this.J0 = a16.optString(com.tencent.luggage.wxa.c8.c.f123407y0, this.J0);
        a(cVar, a16);
        cVar.a(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
    }

    public boolean isAutoPauseIfNavigate() {
        return this.Y;
    }

    public boolean isAutoPauseIfOpenNative() {
        return this.Z;
    }

    public boolean isBackgroundPlayAudioEnabled() {
        return this.F0;
    }

    public boolean isJustPlayAudio() {
        return this.H0.get();
    }

    public boolean isPlaying() {
        com.tencent.luggage.wxa.xg.g gVar = this.f129518e;
        if (gVar != null) {
            return gVar.isPlaying();
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.k8.b
    public boolean isPluginReady(com.tencent.luggage.wxa.z7.c cVar) {
        return true;
    }

    public void onRuntimeEnterForeground() {
        a(new l());
    }

    public final void onRuntimeEnterForegroundInternal() {
        boolean z16;
        this.f129515c0 = false;
        this.f129521f0 = false;
        if (!this.f129513b0) {
            z16 = j();
            setPlayingWhenEnterBackground(null);
        } else {
            z16 = false;
        }
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onRuntimeEnterForeground, mWebViewInBackground: " + this.f129513b0);
        if (!this.f129513b0 && isPlaying() && !this.N) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onRuntimeEnterForeground, requestFocus");
            this.f129542t0.b();
        }
        if (z16) {
            if (e()) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.SameLayer.VideoPluginHandler", "onRuntimeEnterForeground, cancel resume playing when relaunch");
            } else {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.SameLayer.VideoPluginHandler", "onRuntimeEnterForeground, isPlayingWhenEnterBackground, try resume");
                e(false);
            }
        }
    }

    public final void operate(com.tencent.luggage.wxa.z7.c cVar) {
        String str = "fail";
        if (this.f129518e == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "operate, media player is null");
            cVar.a("fail");
            return;
        }
        JSONObject a16 = cVar.a();
        String optString = a16.optString("type");
        if (!w0.c(optString)) {
            boolean z16 = false;
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "operate, type:%s", optString);
            if (b(optString)) {
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "video cast operate, type:%s", optString);
                if (this.f129532l == null) {
                    a(cVar);
                }
                this.f129532l.a(this.W);
                this.f129532l.a(h());
                z16 = optString.equalsIgnoreCase("requestFullScreen") ? g(cVar) : optString.equalsIgnoreCase("exitFullScreen") ? e(cVar) : this.f129532l.a(a16, cVar);
            } else if (optString.equalsIgnoreCase("play")) {
                z16 = e(false);
            } else if (optString.equalsIgnoreCase("pause")) {
                z16 = D();
            } else if (optString.equalsIgnoreCase("stop")) {
                boolean J = J();
                if (J && this.f129515c0) {
                    com.tencent.luggage.wxa.tn.w.d(getLogTag(), "stop, isRuntimeInBackground, setPlayingWhenEnterBackground false");
                    setPlayingWhenEnterBackground(new AtomicBoolean(false));
                }
                z16 = J;
            } else if (optString.equalsIgnoreCase(InnerAudioPlugin.AUDIO_OPERATE_SEEK)) {
                z16 = a(a16);
            } else if (optString.equalsIgnoreCase("playbackRate")) {
                z16 = b(a16);
            } else if (optString.equalsIgnoreCase("requestFullScreen")) {
                z16 = g(cVar);
            } else if (optString.equalsIgnoreCase("exitFullScreen")) {
                z16 = e(cVar);
            } else if (optString.equalsIgnoreCase("setScreenBrightness")) {
                z16 = i(cVar);
            } else if (optString.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.f123397t0)) {
                this.f129547y0.exitPip(cVar);
            } else if (optString.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.f123399u0)) {
                z16 = d(cVar);
            } else if (optString.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.f123401v0)) {
                z16 = c(cVar);
            }
            if (optString.equalsIgnoreCase("snapshot")) {
                f(cVar);
            } else if (!optString.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.f123397t0)) {
                if (z16) {
                    str = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
                }
                cVar.a(str);
            }
            if (optString.equalsIgnoreCase("pause") || optString.equalsIgnoreCase("stop")) {
                this.f129547y0.removePipId(cVar);
            }
        }
    }

    public final void operateBackground(com.tencent.luggage.wxa.z7.c cVar) {
        String str = "fail";
        if (this.f129518e == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "operateBackground, media player is null");
            cVar.a("fail");
            return;
        }
        String optString = cVar.a().optString("type");
        if (!w0.c(optString)) {
            boolean z16 = false;
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "operateBackground, type:%s", optString);
            if (optString.equalsIgnoreCase("stop")) {
                boolean c16 = c(cVar);
                if (c16 && this.f129515c0) {
                    com.tencent.luggage.wxa.tn.w.d(getLogTag(), "operateBackground, isRuntimeInBackground, setPlayingWhenEnterBackground false");
                    setPlayingWhenEnterBackground(new AtomicBoolean(false));
                }
                z16 = c16;
            }
            if (z16) {
                str = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
            }
            cVar.a(str);
        }
    }

    public void pauseExternal() {
        d(false);
    }

    public void playExternal() {
        a(new n());
    }

    public final void registerAddOnGetSnapshot() {
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "registerAddOnGetSnapshot");
        setAddOn(com.tencent.luggage.wxa.a8.l.class, new e0());
    }

    public final void registerAddOnInfo() {
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "registerAddOnInfo");
        setAddOn(com.tencent.luggage.wxa.a8.m.class, new c0());
    }

    public final void registerAddOnPlayAudio() {
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "registerAddOnPlayAudio");
        setAddOn(com.tencent.luggage.wxa.a8.n.class, new a0());
    }

    public final void registerAddOnVideoController() {
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "registerAddOnVideoController");
        setAddOn(com.tencent.luggage.wxa.a8.o.class, new b0());
    }

    public final void registerLifecycleListener(com.tencent.luggage.wxa.z7.c cVar) {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "registerLifecycleListener");
        C6288e c6288e = new C6288e();
        this.C = c6288e;
        cVar.a(c6288e);
    }

    public final void release() {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "video release");
        com.tencent.luggage.wxa.j8.b bVar = this.f129530k;
        if (bVar != null) {
            bVar.d(this.f129534m);
        }
        J();
        I();
        G();
        F();
        releaseCastHandler();
        clearSurface();
        unregisterLifecycleListener();
        releaseThreadHandler();
        unregisterMySelf();
    }

    public final void releaseCastHandler() {
        if (this.f129532l != null) {
            this.f129532l.a();
            this.f129532l = null;
        }
    }

    public void releaseExternal() {
        a(new o());
    }

    public final void releaseThreadHandler() {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "video release handler thread");
        this.f129536n0.a((Object) null);
        this.f129535m0.a();
    }

    public final void remove(com.tencent.luggage.wxa.z7.c cVar) {
        release();
        cVar.a(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
        this.f129547y0.removePipId(cVar);
    }

    public final void requestAppEnterBackground() {
        com.tencent.luggage.wxa.kj.v vVar;
        com.tencent.luggage.wxa.z7.c cVar = this.f129534m;
        if (cVar instanceof AppBrandInvokeContext) {
            com.tencent.luggage.wxa.xd.d e16 = cVar.e();
            if (e16 instanceof com.tencent.luggage.wxa.kj.v) {
                vVar = (com.tencent.luggage.wxa.kj.v) e16;
            } else if (e16 instanceof com.tencent.luggage.wxa.ic.l) {
                vVar = ((com.tencent.luggage.wxa.ic.l) e16).J();
            } else {
                vVar = null;
            }
            if (vVar != null) {
                com.tencent.luggage.wxa.ic.g runtime = vVar.getRuntime();
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "requestAppEnterBackground close runtime");
                runtime.o();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.a8.j
    public void setAddOn(Class cls, com.tencent.luggage.wxa.a8.k kVar) {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "setAddOn for " + cls.getSimpleName());
        this.G0.setAddOn(cls, kVar);
    }

    public void setOnPlayListener(com.tencent.luggage.wxa.a8.x xVar) {
        this.B0 = xVar;
        com.tencent.luggage.wxa.j8.d dVar = this.f129520f;
        if (dVar != null) {
            dVar.a(xVar);
        }
    }

    public void setPlayingWhenEnterBackground(AtomicBoolean atomicBoolean) {
        this.f129517d0 = atomicBoolean;
    }

    public boolean setSurface(Surface surface) {
        boolean z16;
        if (this.f129518e != null) {
            if (!this.H0.get()) {
                this.f129518e.setSurface(surface);
            } else {
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "setSurface, JustPlayAudio");
            }
            if (this.f129510a == surface) {
                this.f129540r0 = null;
            } else {
                this.f129540r0 = surface;
            }
            String logTag = getLogTag();
            Object[] objArr = new Object[1];
            if (this.f129540r0 != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            objArr[0] = Boolean.valueOf(z16);
            com.tencent.luggage.wxa.tn.w.d(logTag, "setSurface, SurfacePipSet exist: %b", objArr);
            return true;
        }
        com.tencent.luggage.wxa.tn.w.f(getLogTag(), "setSurface, MediaPlayer is null");
        return false;
    }

    public final synchronized boolean shouldNotifyEvent() {
        boolean z16;
        if (this.K) {
            if (this.f129520f != null) {
                z16 = true;
            }
        }
        z16 = false;
        return z16;
    }

    public void stopExternal() {
        a(new Runnable() { // from class: r21.a
            @Override // java.lang.Runnable
            public final void run() {
                e.this.J();
            }
        });
    }

    public final void tryCacheSnapshotBeforePlayAudio(Runnable runnable) {
        getSnapshotAsync(new d0(runnable));
        a(runnable, 1000L);
    }

    public final void unregisterLifecycleListener() {
        com.tencent.luggage.wxa.z7.c cVar = this.f129534m;
        if (cVar != null) {
            cVar.d();
            this.C = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0235  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void update(com.tencent.luggage.wxa.z7.c cVar) {
        boolean z16;
        boolean z17;
        boolean z18;
        String optString;
        com.tencent.luggage.wxa.j8.d dVar;
        boolean z19;
        String str;
        if (this.f129518e == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "update, media player is null");
            cVar.a("fail");
            return;
        }
        JSONObject a16 = cVar.a();
        a(this.f129518e, a16);
        this.f129525h0 = a16.optBoolean("isDrm", this.f129525h0);
        this.f129527i0 = a16.optBoolean("isLive", this.f129527i0);
        this.f129529j0 = a16.optString("provisionUrl", this.f129529j0);
        this.f129531k0 = a16.optString("licenseUrl", this.f129531k0);
        boolean z26 = true;
        boolean z27 = false;
        if (a16.has("filePath")) {
            String optString2 = a16.optString("filePath");
            if (!w0.c(optString2) && !optString2.equalsIgnoreCase(this.W)) {
                this.W = optString2;
                String a17 = a(cVar, optString2);
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "update, path:%s, proxy:%s", this.W, a17);
                if (this.f129518e == null || !w0.c(a17)) {
                    this.f129511a0 = false;
                    J();
                    h(cVar);
                }
                com.tencent.luggage.wxa.j8.b bVar = this.f129530k;
                if (bVar != null) {
                    bVar.a(this.f129534m, this.f129518e, this.W);
                }
                I();
                if (this.f129525h0) {
                    String str2 = null;
                    if (w0.c(this.f129529j0)) {
                        str = null;
                    } else {
                        str = this.f129529j0;
                    }
                    if (!w0.c(this.f129531k0)) {
                        str2 = this.f129531k0;
                    }
                    boolean z28 = this.f129527i0;
                    com.tencent.luggage.wxa.tn.w.d(getLogTag(), "update, isDrm, provisionUrl:%s, licenseUrl:%s, isLive: %b", str, str2, Boolean.valueOf(z28));
                    this.f129518e.a(a17, str, str2, z28);
                } else {
                    this.f129518e.a(a17, this.f129539q0);
                }
                a(a17);
                z16 = true;
                if (this.f129510a != null && this.f129518e != null) {
                    boolean z29 = this.H0.get();
                    String logTag = getLogTag();
                    Object[] objArr = new Object[3];
                    objArr[0] = Boolean.valueOf(this.f129513b0);
                    objArr[1] = Boolean.valueOf(z29);
                    if (this.f129540r0 == null) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    objArr[2] = Boolean.valueOf(z19);
                    com.tencent.luggage.wxa.tn.w.d(logTag, "update, setSurface, WebViewInBackground: %b, JustPlayAudio: %b, SurfacePipSet exist: %b", objArr);
                    if (this.f129513b0) {
                        if (!z29) {
                            this.f129518e.setSurface(this.f129510a);
                        }
                    } else {
                        Surface surface = this.f129540r0;
                        if (surface != null) {
                            this.f129518e.setSurface(surface);
                        } else if (!z29) {
                            this.f129518e.setSurface(this.f129510a);
                        }
                    }
                }
                if (a16.has("autoplay")) {
                    this.I = a16.optBoolean("autoplay", this.I);
                }
                if (a16.has("initialTime")) {
                    this.H = (long) (a16.optDouble("initialTime", 0.0d) * 1000.0d);
                }
                if (a16.has("loop")) {
                    this.M = a16.optBoolean("loop", this.M);
                }
                if (a16.has("muted")) {
                    boolean z36 = this.N;
                    boolean optBoolean = a16.optBoolean("muted", z36);
                    this.N = optBoolean;
                    this.f129518e.setMute(optBoolean);
                    if (this.N != z36 && isPlaying() && !this.f129513b0 && !this.f129515c0) {
                        if (this.N) {
                            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "video muted, abandonFocus");
                            this.f129542t0.a();
                        } else {
                            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "video unmuted, requestFocus");
                            this.f129542t0.b();
                        }
                    }
                }
                if (a16.has("autoPauseIfNavigate")) {
                    this.Y = a16.optBoolean("autoPauseIfNavigate", this.Y);
                }
                if (a16.has("autoPauseIfOpenNative")) {
                    this.Z = a16.optBoolean("autoPauseIfOpenNative", this.Z);
                }
                if (a16.has("needEvent")) {
                    this.K = a16.optBoolean("needEvent", this.K);
                }
                if (this.K && (dVar = this.f129520f) != null) {
                    dVar.a(cVar);
                    String optString3 = a16.optString("data", "");
                    if (a16.has("data")) {
                        this.f129520f.a(optString3);
                    }
                    if (this.f129522g != null) {
                        if (a16.has("data")) {
                            this.f129522g.a(optString3);
                        }
                        this.f129522g.a(cVar);
                    }
                }
                if (!a16.has("position")) {
                    JSONObject optJSONObject = a16.optJSONObject("position");
                    if (optJSONObject != null) {
                        int i3 = this.O;
                        int i16 = this.P;
                        this.O = com.tencent.luggage.wxa.tk.g.a(optJSONObject.optInt("width", i3));
                        this.P = com.tencent.luggage.wxa.tk.g.a(optJSONObject.optInt("height", i16));
                        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "update, size:[%d, %d]", Integer.valueOf(this.O), Integer.valueOf(this.P));
                        if (this.O != i3 || this.P != i16) {
                            z17 = true;
                            z18 = true;
                        }
                    }
                    z17 = false;
                    z18 = true;
                } else {
                    z17 = false;
                    z18 = false;
                }
                if (!a16.has("objectFit")) {
                    String str3 = this.X;
                    String optString4 = a16.optString("objectFit", str3);
                    this.X = optString4;
                    if (w0.c(optString4)) {
                        this.X = HVideoConstants.ResizeType.RESIZE_CONTAIN;
                    }
                    if (this.X.equals(str3)) {
                        z27 = z17;
                    }
                    z17 = z27;
                } else {
                    z26 = z18;
                }
                if (z26) {
                    a(z17);
                }
                a(cVar, a16);
                optString = a16.optString("filePath");
                if (this.f129532l != null && this.f129532l.f()) {
                    this.f129532l.b(optString);
                }
                this.I0 = a16.optString("title", this.I0);
                this.J0 = a16.optString(com.tencent.luggage.wxa.c8.c.f123407y0, this.J0);
                if (z16) {
                    com.tencent.luggage.wxa.tn.w.d(getLogTag(), "update, media player prepare async");
                    E();
                }
                cVar.a(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
            }
        }
        z16 = false;
        if (this.f129510a != null) {
            boolean z292 = this.H0.get();
            String logTag2 = getLogTag();
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(this.f129513b0);
            objArr2[1] = Boolean.valueOf(z292);
            if (this.f129540r0 == null) {
            }
            objArr2[2] = Boolean.valueOf(z19);
            com.tencent.luggage.wxa.tn.w.d(logTag2, "update, setSurface, WebViewInBackground: %b, JustPlayAudio: %b, SurfacePipSet exist: %b", objArr2);
            if (this.f129513b0) {
            }
        }
        if (a16.has("autoplay")) {
        }
        if (a16.has("initialTime")) {
        }
        if (a16.has("loop")) {
        }
        if (a16.has("muted")) {
        }
        if (a16.has("autoPauseIfNavigate")) {
        }
        if (a16.has("autoPauseIfOpenNative")) {
        }
        if (a16.has("needEvent")) {
        }
        if (this.K) {
            dVar.a(cVar);
            String optString32 = a16.optString("data", "");
            if (a16.has("data")) {
            }
            if (this.f129522g != null) {
            }
        }
        if (!a16.has("position")) {
        }
        if (!a16.has("objectFit")) {
        }
        if (z26) {
        }
        a(cVar, a16);
        optString = a16.optString("filePath");
        if (this.f129532l != null) {
            this.f129532l.b(optString);
        }
        this.I0 = a16.optString("title", this.I0);
        this.J0 = a16.optString(com.tencent.luggage.wxa.c8.c.f123407y0, this.J0);
        if (z16) {
        }
        cVar.a(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
    }

    public final void updateReferrers(com.tencent.luggage.wxa.z7.c cVar, JSONObject jSONObject) {
        com.tencent.luggage.wxa.xd.d e16 = cVar.e();
        if (e16 == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "updateReferrers, component is null");
            return;
        }
        com.tencent.luggage.wxa.cg.a aVar = (com.tencent.luggage.wxa.cg.a) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.cg.a.class);
        if (aVar == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "updateReferrers, referrerHelper is null");
            return;
        }
        if (this.f129538p0 == null) {
            this.f129538p0 = aVar.s();
        }
        com.tencent.luggage.wxa.cg.c a16 = aVar.a(jSONObject, e16);
        if (a16 != null) {
            this.f129538p0 = a16;
        }
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "updateReferrers, mReferrerPolicy: " + this.f129538p0);
        if (com.tencent.luggage.wxa.cg.c.NO_REFERRER == this.f129538p0) {
            this.f129539q0 = null;
            return;
        }
        this.f129539q0 = aVar.c(e16);
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "updateReferrers, mReferrer: " + this.f129539q0);
    }

    public void updateVideoPosition(JSONObject jSONObject) {
        this.Q = com.tencent.luggage.wxa.tk.g.a(jSONObject.optInt(HippyTKDListViewAdapter.X, this.Q));
        this.R = com.tencent.luggage.wxa.tk.g.a(jSONObject.optInt("y", this.R));
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "updateVideoPosition, mPosX: %d, mPosY: %d", Integer.valueOf(this.Q), Integer.valueOf(this.R));
    }

    public e(boolean z16, com.tencent.luggage.wxa.i8.a aVar) {
        this.f129514c = -1;
        this.f129516d = -1;
        this.M = false;
        this.N = false;
        this.Q = 0;
        this.R = 0;
        this.f129515c0 = false;
        this.f129517d0 = null;
        this.f129519e0 = false;
        this.f129521f0 = false;
        this.f129525h0 = false;
        this.f129527i0 = false;
        this.f129529j0 = "";
        this.f129531k0 = "";
        this.f129533l0 = new ConcurrentLinkedQueue();
        this.f129537o0 = null;
        this.f129538p0 = null;
        this.f129539q0 = null;
        this.f129540r0 = null;
        this.f129542t0 = com.tencent.luggage.wxa.p004if.b0.f130171e.a(new Function0() { // from class: r21.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                d lambda$new$0;
                lambda$new$0 = e.this.lambda$new$0();
                return lambda$new$0;
            }
        }, new k());
        this.f129543u0 = null;
        this.f129544v0 = false;
        x xVar = new x();
        this.f129545w0 = xVar;
        this.f129546x0 = new y(this, xVar);
        this.f129547y0 = new z();
        this.f129548z0 = null;
        this.A0 = null;
        this.B0 = null;
        this.C0 = 1.0f;
        this.D0 = 1.0f;
        this.E0 = false;
        this.F0 = false;
        this.G0 = new com.tencent.luggage.wxa.a8.w();
        this.H0 = new AtomicBoolean(false);
        this.I0 = null;
        this.J0 = null;
        this.K0 = null;
        this.L0 = null;
        com.tencent.luggage.wxa.a8.h create = O0.create();
        this.f129535m0 = create;
        create.start();
        this.f129536n0 = create.getHandler();
        this.f129523g0 = z16;
        this.f129541s0 = aVar;
    }

    public final void A() {
        if (!this.L) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onMediaPlayerVideoFirstFrame, mp released");
            return;
        }
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onMediaPlayerVideoFirstFrame");
        com.tencent.luggage.wxa.j8.b bVar = this.f129530k;
        if (bVar != null) {
            bVar.e(this.f129534m, this.f129518e);
        }
    }

    public void B() {
        a(new m());
    }

    public final void C() {
        this.f129515c0 = true;
        if (getPlayingWhenEnterBackground() == null) {
            boolean isPlaying = isPlaying();
            setPlayingWhenEnterBackground(new AtomicBoolean(isPlaying));
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onRuntimeEnterBackground, abandonFocus");
            this.f129542t0.a();
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onRuntimeEnterBackground, isPlayingWhenEnterBackground:%s", Boolean.valueOf(isPlaying));
            if (this.F0 && amIBackgroundAudioPlayer()) {
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onRuntimeEnterBackground, background play audio is enabled");
            } else {
                D();
            }
        }
    }

    public final boolean D() {
        return b(false);
    }

    public final void E() {
        f(true);
    }

    public final void F() {
        com.tencent.luggage.wxa.j8.d dVar = this.f129520f;
        if (dVar != null) {
            dVar.destroy();
            this.f129520f = null;
            this.f129522g = null;
        }
    }

    public final void G() {
        if (this.f129518e != null) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "releaseMediaPlayer");
            this.f129518e.a((g.e) null);
            this.f129518e.a((g.d) null);
            this.f129518e.a((g.f) null);
            this.f129518e.a((g.b) null);
            this.f129518e.a((g.InterfaceC6908g) null);
            this.f129518e.a((g.i) null);
            this.f129518e.stop();
            this.f129518e.reset();
            this.f129518e.release();
        }
        this.f129518e = null;
        this.L = false;
    }

    public final void H() {
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = false;
    }

    public final void I() {
        com.tencent.luggage.wxa.zg.j jVar;
        com.tencent.luggage.wxa.xg.g gVar = this.f129518e;
        if (gVar == null || (jVar = (com.tencent.luggage.wxa.zg.j) gVar.a(com.tencent.luggage.wxa.zg.j.class)) == null) {
            return;
        }
        j.d s16 = jVar.s();
        com.tencent.luggage.wxa.j8.b bVar = this.f129530k;
        if (bVar != null) {
            bVar.a(s16);
        }
    }

    public final void g() {
        synchronized (this.f129533l0) {
            if (!this.f129533l0.isEmpty()) {
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "flushPendingTasks, size:%d", Integer.valueOf(this.f129533l0.size()));
                Iterator it = this.f129533l0.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
                this.f129533l0.clear();
            }
        }
    }

    public int h() {
        com.tencent.luggage.wxa.xg.g gVar = this.f129518e;
        if (gVar != null) {
            return gVar.getCurrentPosition();
        }
        return 0;
    }

    public final int i() {
        com.tencent.luggage.wxa.xg.g gVar = this.f129518e;
        if (gVar != null) {
            return gVar.getDuration();
        }
        return 0;
    }

    public boolean j() {
        AtomicBoolean atomicBoolean = this.f129517d0;
        return atomicBoolean != null && atomicBoolean.get();
    }

    public com.tencent.luggage.wxa.xg.g k() {
        return this.f129518e;
    }

    public int l() {
        int i3 = (int) (this.D0 * this.P);
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "getVideoContainerHeight, videoContainerHeight: " + i3);
        return i3;
    }

    public int m() {
        int i3 = (int) (this.C0 * this.O);
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "getVideoContainerWidth, videoContainerWidth: " + i3);
        return i3;
    }

    public com.tencent.luggage.wxa.j8.d o() {
        return this.f129520f;
    }

    public final int p() {
        com.tencent.luggage.wxa.xg.g gVar = this.f129518e;
        if (gVar != null) {
            return gVar.getVideoHeight();
        }
        return 0;
    }

    public float q() {
        return this.D0;
    }

    public com.tencent.luggage.wxa.j8.e r() {
        return this.f129526i;
    }

    public final int s() {
        com.tencent.luggage.wxa.xg.g gVar = this.f129518e;
        if (gVar != null) {
            return gVar.getVideoWidth();
        }
        return 0;
    }

    public float t() {
        return this.C0;
    }

    public final void u() {
        a(new a());
    }

    public final void v() {
        if (!this.L) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onMediaPlayerCompletion, mp released");
            return;
        }
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onCompletion");
        if (shouldNotifyEvent()) {
            this.f129520f.onVideoEnded();
        }
        com.tencent.luggage.wxa.j8.b bVar = this.f129530k;
        if (bVar != null) {
            bVar.b(this.f129534m, this.f129518e);
        }
        if (this.M) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onCompletion, video loop playing");
            this.D = true;
            a(0L);
            return;
        }
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onCompletion, video end playing");
        this.f129511a0 = true;
        com.tencent.luggage.wxa.xg.g gVar = this.f129518e;
        if (gVar != null) {
            gVar.pause();
        }
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onCompletion, abandonFocus");
        this.f129542t0.a();
    }

    public final void w() {
        a(new b());
    }

    public final void x() {
        if (!this.L) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onMediaPlayerPrepared, mp released");
            return;
        }
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onPrepared");
        com.tencent.luggage.wxa.j8.b bVar = this.f129530k;
        if (bVar != null) {
            bVar.a(this.f129534m, this.f129518e, i());
        }
        boolean z16 = true;
        this.J = true;
        a(false);
        if (shouldNotifyEvent() && this.f129518e != null) {
            this.f129520f.a(s(), p(), i());
        }
        com.tencent.luggage.wxa.i8.a aVar = this.f129541s0;
        if (aVar != null) {
            aVar.a(new Size(s(), p()));
        }
        long j3 = this.H;
        if (j3 > 0) {
            a(j3);
            this.H = 0L;
        }
        boolean z17 = !this.f129513b0;
        if (this.f129534m.e() instanceof com.tencent.luggage.wxa.kj.v) {
            z17 = com.tencent.luggage.wxa.sd.b.a(this.f129534m);
        } else {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "onPrepared, component is not page view");
        }
        if (!z17 && !amIPipPlayer() && !this.f129521f0) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onPrepared, stop video auto play when webview in background");
            if (!this.I && !this.G) {
                z16 = false;
            }
            setPlayingWhenEnterBackground(new AtomicBoolean(z16));
            return;
        }
        this.f129521f0 = false;
        if (!this.I && !this.G) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onPrepared, not set start play when prepared");
            return;
        }
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onPrepared, start play when prepared, mStartWhenPrepared:%s, mControlStartWhenPrepared:%s", Boolean.valueOf(this.I), Boolean.valueOf(this.G));
        if (this.f129532l != null && this.f129532l.l()) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.SameLayer.VideoPluginHandler", "onMediaPlayerPreparedInternal: castMediaPresent, avoid play when prepared");
        } else {
            e(this.I);
        }
    }

    public final void y() {
        a(new l0());
    }

    public final void z() {
        if (!this.L) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onMediaPlayerSeekComplete, mp released");
            return;
        }
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onSeekComplete");
        if (shouldNotifyEvent()) {
            this.f129520f.b(h());
        }
        if (this.D) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onSeekComplete, start when seek complete");
            this.D = false;
            e(false);
            return;
        }
        boolean isPlaying = this.f129518e.isPlaying();
        if (this.E) {
            long duration = this.f129518e.getDuration();
            long currentPosition = this.f129518e.getCurrentPosition();
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onSeekComplete, video playing before seeking, isCurrentPlaying:%b, position:%s, duration:%s", Boolean.valueOf(isPlaying), Long.valueOf(currentPosition), Long.valueOf(duration));
            this.E = false;
            if (currentPosition / 1000 < duration / 1000) {
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onSeekComplete, video not end");
                if (isPlaying && shouldNotifyEvent()) {
                    com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onSeekComplete, dispatch play again");
                    this.f129520f.a(false);
                    return;
                }
                return;
            }
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onSeekComplete, video ends");
            this.f129518e.pause();
            this.f129518e.start();
            return;
        }
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onSeekComplete, video not playing before seeking, isCurrentPlaying:%b", Boolean.valueOf(isPlaying));
        if (isPlaying || !shouldNotifyEvent()) {
            return;
        }
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onSeekComplete, dispatch pause again");
        this.f129520f.b(false);
    }

    public final void e(int i3, int i16) {
        a(new k0(i3, i16));
    }

    public final void f(int i3, int i16) {
        if (!this.L) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onMediaPlayerVideoSizeChanged, mp released");
            return;
        }
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onVideoSizeChanged, width:%d, height:%d", Integer.valueOf(i3), Integer.valueOf(i16));
        a(false);
        int i17 = i();
        if (this.J && this.f129518e != null && (i3 != this.S || i16 != this.T || i17 != this.U)) {
            if (shouldNotifyEvent()) {
                this.f129520f.a(i3, i16, i17);
            }
            com.tencent.luggage.wxa.i8.a aVar = this.f129541s0;
            if (aVar != null) {
                aVar.a(new Size(i3, i16));
            }
        }
        this.S = i3;
        this.T = i16;
        this.U = i17;
    }

    public final void c(Surface surface) {
        this.f129510a = surface;
        if (this.f129518e != null) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "replaceSurfaceTextureInternal, setSurface:%s", surface);
            this.f129518e.setSurface(this.f129510a);
        }
    }

    public final boolean d(int i3, int i16) {
        if (!this.L) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onMediaPlayerInfo, mp released");
            return false;
        }
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onInfo, what:%d, extra:%d", Integer.valueOf(i3), Integer.valueOf(i16));
        if (i3 == 701) {
            this.F = this.f129518e.isPlaying();
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onInfo, buffering start, isPlayingBeforeBuffering:%b", Boolean.valueOf(this.F));
            if (shouldNotifyEvent()) {
                this.f129520f.onVideoWaiting();
            }
            com.tencent.luggage.wxa.j8.b bVar = this.f129530k;
            if (bVar != null) {
                bVar.c(this.f129534m, this.f129518e);
            }
        } else if (i3 == 702) {
            boolean isPlaying = this.f129518e.isPlaying();
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onInfo, buffering end, isPlayingBeforeBuffering:%b, isCurrentPlaying:%b", Boolean.valueOf(this.F), Boolean.valueOf(isPlaying));
            if (this.F) {
                this.F = false;
                if (isPlaying && shouldNotifyEvent()) {
                    com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onInfo, buffering end, notify video play");
                    this.f129520f.a(false);
                }
            } else if (!isPlaying && shouldNotifyEvent()) {
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onInfo, buffering end, notify video pause");
                this.f129520f.b(false);
            }
            com.tencent.luggage.wxa.j8.b bVar2 = this.f129530k;
            if (bVar2 != null) {
                bVar2.d(this.f129534m, this.f129518e);
            }
        } else if (i3 == 3) {
            A();
        }
        return false;
    }

    public final boolean e() {
        com.tencent.luggage.wxa.kj.v J;
        com.tencent.luggage.wxa.z7.c cVar = this.f129534m;
        if (cVar instanceof AppBrandInvokeContext) {
            com.tencent.luggage.wxa.xd.d e16 = cVar.e();
            if (e16 instanceof com.tencent.luggage.wxa.kj.v) {
                J = (com.tencent.luggage.wxa.kj.v) e16;
            } else {
                J = e16 instanceof com.tencent.luggage.wxa.ic.l ? ((com.tencent.luggage.wxa.ic.l) e16).J() : null;
            }
            if (J != null) {
                com.tencent.luggage.wxa.ic.g runtime = J.getRuntime();
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "cancelResumePlayingWhenRelaunch:%s", Boolean.valueOf(runtime.m0()));
                return runtime.m0();
            }
        }
        return false;
    }

    public final void h(com.tencent.luggage.wxa.z7.c cVar) {
        G();
        b(cVar);
        a();
    }

    public final boolean i(com.tencent.luggage.wxa.z7.c cVar) {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "setScreenBrightness");
        com.tencent.luggage.wxa.j8.b bVar = this.f129530k;
        return bVar != null && bVar.e(cVar);
    }

    public void b(Surface surface) {
        a(new f0(surface));
    }

    public final boolean b(Bitmap bitmap) {
        int i3;
        com.tencent.luggage.wxa.a8.g gVar = this.K0;
        if (gVar == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "handlePluginScreenshotTaken4NativeCall, getSnapshotCallback is null");
            return false;
        }
        if (bitmap == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "handlePluginScreenshotTaken4NativeCall, bitmap is null");
            gVar.onSnapshotGot(null);
            return true;
        }
        int i16 = this.O;
        if (i16 != 0 && (i3 = this.P) != 0) {
            bitmap = Bitmap.createScaledBitmap(bitmap, (int) (this.C0 * i16), (int) (this.D0 * i3), false);
        }
        gVar.onSnapshotGot(bitmap);
        this.K0 = null;
        return true;
    }

    public final boolean c(int i3, int i16) {
        return a(new d(i3, i16));
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final boolean b(boolean z16) {
        com.tencent.luggage.wxa.xg.g gVar = this.f129518e;
        if (gVar == null) {
            return false;
        }
        if (!this.J) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "video pause, video not prepared yet, pause video when prepared");
            this.G = false;
            return true;
        }
        if (!gVar.isPlaying()) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "video pause, video is not playing");
            return true;
        }
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "video pause");
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "video pause, passive: %b, mWebViewInBackground: %b, isRuntimeInBackground: %b", Boolean.valueOf(z16), Boolean.valueOf(this.f129513b0), Boolean.valueOf(this.f129515c0));
        if (!z16) {
            this.f129542t0.a();
        }
        this.f129518e.pause();
        if (shouldNotifyEvent()) {
            this.f129520f.b(false);
        }
        return true;
    }

    public final boolean g(com.tencent.luggage.wxa.z7.c cVar) {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "requestFullscreen");
        com.tencent.luggage.wxa.j8.b bVar = this.f129530k;
        return bVar != null && bVar.b(cVar);
    }

    public final boolean a(Bitmap bitmap) {
        int i3;
        com.tencent.luggage.wxa.z7.c cVar = this.f129537o0;
        if (cVar == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "handlePluginScreenshotTaken4JsApiCall, invokeContext is null");
            return false;
        }
        if (bitmap == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "handlePluginScreenshotTaken4JsApiCall, bitmap is null");
            return false;
        }
        int i16 = this.O;
        if (i16 != 0 && (i3 = this.P) != 0) {
            bitmap = Bitmap.createScaledBitmap(bitmap, (int) (this.C0 * i16), (int) (this.D0 * i3), false);
        }
        this.f129530k.a(cVar, bitmap);
        this.f129537o0 = null;
        return true;
    }

    public final boolean e(boolean z16) {
        return a(z16, true);
    }

    public final boolean e(com.tencent.luggage.wxa.z7.c cVar) {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "exitFullscreen");
        com.tencent.luggage.wxa.j8.b bVar = this.f129530k;
        return bVar != null && bVar.c(cVar);
    }

    public final void b(int i3) {
        if (!this.L) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onMediaPlayerBufferingUpdate, mp released");
            return;
        }
        if (i3 != this.V) {
            this.V = i3;
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onBufferingUpdate, percent:%s", Integer.valueOf(i3));
        }
        if (shouldNotifyEvent() && this.J) {
            this.f129520f.a(i3);
        }
    }

    public final void f(boolean z16) {
        if (this.f129518e != null) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "video prepare async");
            if (z16 && shouldNotifyEvent()) {
                this.f129520f.onVideoWaiting();
            }
            this.J = false;
            this.G = false;
            com.tencent.luggage.wxa.j8.b bVar = this.f129530k;
            if (bVar != null) {
                bVar.f(this.f129534m, this.f129518e);
            }
            this.f129518e.prepareAsync();
        }
    }

    public void a(com.tencent.luggage.wxa.j8.b bVar) {
        this.f129530k = bVar;
        if (bVar != null) {
            bVar.a(this);
            this.f129528j = this.f129530k.e();
            this.f129526i = this.f129530k.b();
            this.f129522g = this.f129530k.a();
            com.tencent.luggage.wxa.j8.d d16 = this.f129530k.d();
            this.f129520f = d16;
            d16.a(this);
            this.f129520f.a(this.A0);
            this.f129520f.a(this.B0);
            com.tencent.luggage.wxa.j8.c c16 = this.f129530k.c();
            this.f129524h = c16;
            c16.a(new i0());
        }
    }

    public final boolean b(int i3, int i16) {
        if (!this.L) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onMediaPlayerError, mp released");
            return false;
        }
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onError, what:%d, extra:%d", Integer.valueOf(i3), Integer.valueOf(i16));
        com.tencent.luggage.wxa.j8.c cVar = this.f129524h;
        if (cVar != null) {
            cVar.a(i3, i16);
        }
        return false;
    }

    public final boolean c(com.tencent.luggage.wxa.z7.c cVar) {
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "disableBackgroundPlayAudio");
        if (!disableBackgroundPlayAudioInternal(cVar)) {
            return false;
        }
        this.H0.set(false);
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "disableBackgroundPlayAudio, webViewInBackground: %b", Boolean.valueOf(this.f129513b0));
        com.tencent.luggage.wxa.xg.g gVar = this.f129518e;
        if (gVar != null && !this.f129513b0) {
            gVar.setSurface(this.f129510a);
        }
        this.F0 = false;
        com.tencent.luggage.wxa.j8.d dVar = this.f129520f;
        if (dVar != null) {
            dVar.onBackgroundPlaybackChange(false);
        }
        return true;
    }

    public final void d() {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "applyPluginTextureScaleIfNeed");
        if (!this.f129544v0) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "applyPluginTextureScaleIfNeed, TextureScale is not sticky");
        } else if (this.f129513b0 && this.f129540r0 != null) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "applyPluginTextureScaleIfNeed, in PIP mode");
        } else {
            com.tencent.luggage.wxa.z7.f.a(getPluginClientProxy(), getType(), getId(), this.C0, this.D0);
        }
    }

    public final void f(com.tencent.luggage.wxa.z7.c cVar) {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "getSnapshotCached");
        if (this.f129530k == null) {
            cVar.a("fail:snapshot error");
        } else {
            this.f129537o0 = cVar;
            K();
        }
    }

    public final void a(com.tencent.luggage.wxa.z7.c cVar) {
        if (this.f129532l != null) {
            return;
        }
        this.f129532l = this.f129530k.a(this.f129522g, cVar);
    }

    public final boolean b(JSONObject jSONObject) {
        if (this.f129518e != null && jSONObject != null && jSONObject.has("data")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                double optDouble = optJSONArray.optDouble(0, -1.0d);
                if (optDouble < 0.0d) {
                    com.tencent.luggage.wxa.tn.w.h(getLogTag(), "speed, invalid rate:%s", Double.valueOf(optDouble));
                    return false;
                }
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "speed, speed:%s", Double.valueOf(optDouble));
                return this.f129518e.a((float) optDouble);
            }
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "speed, data array is null");
        }
        return false;
    }

    public final boolean a(Runnable runnable) {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null && myLooper == this.f129536n0.a()) {
            runnable.run();
            return true;
        }
        this.f129536n0.a(runnable);
        return true;
    }

    public final void f() {
        try {
            if (this.f129510a == null || !this.J) {
                return;
            }
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "clearSurfaceFrame");
            a(this.f129510a);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a(getLogTag(), e16, "clearSurfaceFrame error", new Object[0]);
        }
    }

    public void d(final boolean z16) {
        a(new Runnable() { // from class: r21.b
            @Override // java.lang.Runnable
            public final void run() {
                e.this.b(z16);
            }
        });
    }

    public final boolean d(com.tencent.luggage.wxa.z7.c cVar) {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "enableBackgroundPlayAudio");
        if (w0.c(this.W)) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "enableBackgroundPlayAudio, videoPath is empty");
            return false;
        }
        if (!this.E0) {
            registerAddOnPlayAudio();
            registerAddOnVideoController();
            registerAddOnInfo();
            registerAddOnGetSnapshot();
            this.E0 = true;
        }
        if (!enableBackgroundPlayAudioInternal(cVar)) {
            return false;
        }
        this.H0.set(true);
        com.tencent.luggage.wxa.xg.g gVar = this.f129518e;
        if (gVar != null) {
            gVar.setSurface(null);
        }
        this.F0 = true;
        com.tencent.luggage.wxa.j8.d dVar = this.f129520f;
        if (dVar != null) {
            dVar.onBackgroundPlaybackChange(true);
        }
        requestAppEnterBackground();
        return true;
    }

    public final boolean a(Runnable runnable, long j3) {
        this.f129536n0.a(runnable, j3);
        return true;
    }

    public final void a(int i3) {
        a(new j0(i3));
    }

    public final boolean a(int i3, int i16) {
        return a(new c(i3, i16));
    }

    public final void a(com.tencent.luggage.wxa.z7.c cVar, JSONObject jSONObject) {
        if (jSONObject.optBoolean("enableCasting", false)) {
            boolean optBoolean = jSONObject.optBoolean("enableCasting");
            com.tencent.luggage.wxa.tn.w.a(getLogTag(), "isEnableVideoCast = " + optBoolean);
            a(cVar);
            this.f129532l.d(optBoolean);
        }
    }

    public final void b(com.tencent.luggage.wxa.z7.c cVar) {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "createMediaPlayer");
        com.tencent.luggage.wxa.j8.b bVar = this.f129530k;
        if (bVar != null) {
            this.f129518e = bVar.a(cVar, this.f129535m0.b());
        }
        if (this.f129518e == null) {
            com.tencent.luggage.wxa.tn.w.b(getLogTag(), "createMediaPlayer, create media player fail");
            return;
        }
        this.L = true;
        this.f129518e.a(new p());
        this.f129518e.a(new q());
        this.f129518e.a(new r());
        this.f129518e.a(new s());
        this.f129518e.a(new t());
        this.f129518e.a(new u());
        this.f129518e.a(new w());
        n0 n0Var = this.f129548z0;
        if (n0Var != null) {
            n0Var.a(this.J);
        }
    }

    public final String a(com.tencent.luggage.wxa.z7.c cVar, String str) {
        com.tencent.luggage.wxa.j8.b bVar = this.f129530k;
        return bVar != null ? bVar.a(cVar, str) : str;
    }

    public void a(m0 m0Var) {
        this.f129543u0 = m0Var;
    }

    public final void a(boolean z16) {
        com.tencent.luggage.wxa.j8.f fVar;
        m0 m0Var;
        if (!w0.c(this.X)) {
            if (getPluginClientProxy() != null && (fVar = this.f129528j) != null) {
                float f16 = this.C0;
                float f17 = this.D0;
                if (fVar.a(this.X, this.O, this.P, this.S, this.T)) {
                    this.C0 = this.f129528j.a();
                    this.D0 = this.f129528j.b();
                    com.tencent.luggage.wxa.tn.w.d(getLogTag(), "adjust objectFit:%s, scale:[%s, %s]", this.X, Float.valueOf(this.C0), Float.valueOf(this.D0));
                    if (this.f129513b0 && this.f129540r0 != null) {
                        this.f129544v0 = true;
                        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "adjust objectFit, TextureScale sticky");
                    } else {
                        com.tencent.luggage.wxa.z7.f.a(getPluginClientProxy(), getType(), getId(), this.C0, this.D0);
                        this.f129544v0 = false;
                    }
                    float f18 = this.C0;
                    if ((f18 == f16 && this.D0 == f17) || (m0Var = this.f129543u0) == null) {
                        return;
                    }
                    m0Var.a(z16, f18, this.D0);
                    return;
                }
                return;
            }
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "adjust objectFit, video not prepared");
            return;
        }
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "adjust objectFit, no video objectFit");
    }

    public final boolean b(String str) {
        if (str.equalsIgnoreCase("startCasting")) {
            return true;
        }
        if (this.f129532l == null) {
            return false;
        }
        return this.f129532l.f();
    }

    public final boolean a(boolean z16, boolean z17) {
        com.tencent.luggage.wxa.xg.g gVar;
        boolean z18;
        Supplier supplier = N0;
        if ((supplier != null && !((Boolean) supplier.get()).booleanValue()) || (gVar = this.f129518e) == null) {
            return false;
        }
        if (this.J && gVar.isPlaying()) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "video play, video is playing");
            if (shouldNotifyEvent()) {
                this.f129520f.a(z16);
            }
            return true;
        }
        com.tencent.luggage.wxa.xg.g gVar2 = this.f129518e;
        if (gVar2 != null && !this.J) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "video play, video not prepared yet, start until prepared");
            this.G = true;
            return true;
        }
        if (gVar2 != null && gVar2.getState() == 5) {
            if (!z17) {
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "video has ended playing, do not restart");
                return false;
            }
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "video play, video has stopped now, try prepare and start when prepared");
            E();
            this.G = true;
            return true;
        }
        if (!this.f129511a0) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "video play");
            if (this.f129518e != null) {
                com.tencent.luggage.wxa.tn.w.a(getLogTag(), "video play, mWebViewInBackground: %b, isRuntimeInBackground: %b", Boolean.valueOf(this.f129513b0), Boolean.valueOf(this.f129515c0));
                if (this.f129513b0 || this.f129515c0 || this.N) {
                    z18 = true;
                } else {
                    com.tencent.luggage.wxa.tn.w.d(getLogTag(), "video play, requestFocus");
                    z18 = this.f129542t0.b();
                }
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "video play, canStart: %b", Boolean.valueOf(z18));
                if (!z18) {
                    return false;
                }
                if (shouldNotifyEvent()) {
                    this.f129520f.a(z16);
                }
                d();
                this.f129518e.start();
                Runnable runnable = M0;
                if (runnable != null) {
                    runnable.run();
                }
            }
            return true;
        }
        if (!z17) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "video has ended playing, do not restart");
            return false;
        }
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "video play, video has ended playing, clear surface and start again");
        this.f129511a0 = false;
        f();
        h(this.f129534m);
        if (this.f129518e != null) {
            String a16 = a(this.f129534m, this.W);
            I();
            String str = w0.c(this.f129529j0) ? null : this.f129529j0;
            String str2 = w0.c(this.f129531k0) ? null : this.f129531k0;
            boolean z19 = this.f129527i0;
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "play, isDrm, provisionUrl:%s, licenseUrl:%s, isLive: %b", str, str2, Boolean.valueOf(z19));
            if (!w0.c(a16)) {
                if (this.f129525h0) {
                    this.f129518e.a(a16, str, str2, z19);
                } else {
                    this.f129518e.a(a16, this.f129539q0);
                }
                a(a16);
            } else {
                if (this.f129525h0) {
                    this.f129518e.a(this.W, str, str2, z19);
                } else {
                    this.f129518e.a(this.W, this.f129539q0);
                }
                a(this.W);
            }
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "video play, media player state:%s", Integer.valueOf(this.f129518e.getState()));
            f(false);
            this.G = true;
        }
        return true;
    }

    public final void a(long j3) {
        if (this.J && this.f129518e != null) {
            if (shouldNotifyEvent()) {
                this.f129520f.onVideoWaiting();
            }
            if (this.f129518e != null) {
                this.E = isPlaying();
                long min = Math.min(i(), Math.max(0L, j3));
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "seek, position:%s, isPlaying:%s, videoEndPlaying:%s", Long.valueOf(min), Boolean.valueOf(this.E), Boolean.valueOf(this.f129511a0));
                this.f129511a0 = false;
                this.f129518e.a(min);
                return;
            }
            return;
        }
        this.H = j3;
    }

    public final boolean a(JSONObject jSONObject) {
        if (this.f129518e != null && jSONObject != null && jSONObject.has("data")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                double optDouble = optJSONArray.optDouble(0, -1.0d);
                if (optDouble < 0.0d) {
                    com.tencent.luggage.wxa.tn.w.h(getLogTag(), "seek, invalid position:%s", Double.valueOf(optDouble));
                    return false;
                }
                a((long) (optDouble * 1000.0d));
                return true;
            }
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "seek, data array is null");
        }
        return false;
    }

    public final void a() {
        Surface surface;
        com.tencent.luggage.wxa.xg.g gVar = this.f129518e;
        if (gVar != null) {
            gVar.setMute(this.N);
            if (this.f129510a != null) {
                boolean z16 = this.H0.get();
                if (!this.f129513b0 && !z16) {
                    com.tencent.luggage.wxa.tn.w.d(getLogTag(), "applyMediaPlayerParams, setSurface");
                    this.f129518e.setSurface(this.f129510a);
                    return;
                }
                String logTag = getLogTag();
                Object[] objArr = new Object[3];
                objArr[0] = Boolean.valueOf(this.f129513b0);
                objArr[1] = Boolean.valueOf(z16);
                objArr[2] = Boolean.valueOf(this.f129540r0 != null);
                com.tencent.luggage.wxa.tn.w.d(logTag, "applyMediaPlayerParams, setSurface, WebViewInBackground: %b, JustPlayAudio: %b, SurfacePipSet exist: %b", objArr);
                if (!this.f129513b0 || (surface = this.f129540r0) == null) {
                    return;
                }
                this.f129518e.setSurface(surface);
            }
        }
    }

    public final void a(Surface surface) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl10.eglInitialize(eglGetDisplay, null);
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        egl10.eglChooseConfig(eglGetDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344}, eGLConfigArr, 1, new int[1]);
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLContext eglCreateContext = egl10.eglCreateContext(eglGetDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
        EGLSurface eglCreateWindowSurface = egl10.eglCreateWindowSurface(eglGetDisplay, eGLConfig, surface, new int[]{12344});
        egl10.eglMakeCurrent(eglGetDisplay, eglCreateWindowSurface, eglCreateWindowSurface, eglCreateContext);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        egl10.eglSwapBuffers(eglGetDisplay, eglCreateWindowSurface);
        egl10.eglDestroySurface(eglGetDisplay, eglCreateWindowSurface);
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        egl10.eglMakeCurrent(eglGetDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        egl10.eglDestroyContext(eglGetDisplay, eglCreateContext);
        egl10.eglTerminate(eglGetDisplay);
    }

    public final void a(com.tencent.luggage.wxa.xg.g gVar, JSONObject jSONObject) {
        if (jSONObject.has("preferredPeakBitRate")) {
            gVar.a(jSONObject.optDouble("preferredPeakBitRate"));
        }
    }

    public void a(n0 n0Var) {
        this.f129548z0 = n0Var;
        if (n0Var == null || this.f129518e == null) {
            return;
        }
        n0Var.a(this.J);
    }

    public void a(com.tencent.luggage.wxa.i8.b bVar) {
        this.A0 = bVar;
        com.tencent.luggage.wxa.j8.d dVar = this.f129520f;
        if (dVar != null) {
            dVar.a(bVar);
        }
    }
}
