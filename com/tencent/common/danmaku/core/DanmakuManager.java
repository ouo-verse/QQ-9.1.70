package com.tencent.common.danmaku.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.common.danmaku.core.DanmakuMeasureManager;
import com.tencent.common.danmaku.render.g;
import com.tencent.common.danmaku.render.i;
import com.tencent.common.danmaku.tool.f;
import com.tencent.common.danmaku.tool.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DanmakuManager implements View.OnTouchListener, g.a {
    static IPatchRedirector $redirector_;

    /* renamed from: g0, reason: collision with root package name */
    public static String f99599g0;

    /* renamed from: h0, reason: collision with root package name */
    private static final DecimalFormat f99600h0;

    /* renamed from: i0, reason: collision with root package name */
    private static final DecimalFormat f99601i0;

    /* renamed from: j0, reason: collision with root package name */
    private static int f99602j0;

    /* renamed from: k0, reason: collision with root package name */
    private static int f99603k0;

    /* renamed from: l0, reason: collision with root package name */
    private static long f99604l0;
    private final Handler C;
    protected final g D;
    private final com.tencent.common.danmaku.core.c E;
    private final com.tencent.common.danmaku.core.d F;
    private final com.tencent.common.danmaku.core.b G;
    private final DanmakuMeasureManager H;
    private final f I;
    protected com.tencent.common.danmaku.tool.c J;
    private long K;
    private long L;
    protected boolean M;
    protected volatile boolean N;
    private long P;
    private long Q;
    private long R;
    private int S;
    private int T;
    private long U;
    protected long V;
    protected long W;
    protected com.tencent.common.danmaku.inject.b X;
    protected final Queue<h> Y;
    protected final List<com.tencent.common.danmaku.data.a> Z;

    /* renamed from: a0, reason: collision with root package name */
    protected final com.tencent.common.danmaku.core.a f99605a0;

    /* renamed from: b0, reason: collision with root package name */
    protected volatile e f99606b0;

    /* renamed from: c0, reason: collision with root package name */
    private d f99607c0;

    /* renamed from: d, reason: collision with root package name */
    public String f99608d;

    /* renamed from: d0, reason: collision with root package name */
    private Choreographer f99609d0;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f99610e;

    /* renamed from: e0, reason: collision with root package name */
    private Choreographer.FrameCallback f99611e0;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f99612f;

    /* renamed from: f0, reason: collision with root package name */
    Choreographer.FrameCallback f99613f0;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f99614h;

    /* renamed from: i, reason: collision with root package name */
    private Handler f99615i;

    /* renamed from: m, reason: collision with root package name */
    private HandlerThread f99616m;

    /* compiled from: P */
    /* renamed from: com.tencent.common.danmaku.core.DanmakuManager$7, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass7 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.common.danmaku.data.a f99621d;
        final /* synthetic */ DanmakuManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.this$0.f99605a0.m(this.f99621d);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.common.danmaku.core.DanmakuManager$8, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass8 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.common.danmaku.data.a f99622d;
        final /* synthetic */ DanmakuManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.this$0.f99605a0.o(this.f99622d);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class DanmakuComparator implements Comparator<com.tencent.common.danmaku.data.a>, Serializable {
        static IPatchRedirector $redirector_;

        public DanmakuComparator() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        public int compare(com.tencent.common.danmaku.data.a aVar, com.tencent.common.danmaku.data.a aVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? com.tencent.common.danmaku.util.c.a(aVar, aVar2) : ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, (Object) aVar2)).intValue();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements DanmakuMeasureManager.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DanmakuManager.this);
            }
        }

        @Override // com.tencent.common.danmaku.core.DanmakuMeasureManager.a
        public void a(com.tencent.common.danmaku.data.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
                return;
            }
            DanmakuManager.this.E.a(aVar);
            if (DanmakuManager.this.f99606b0 != null) {
                DanmakuManager.this.f99606b0.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements Choreographer.FrameCallback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DanmakuManager.this);
            }
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                DanmakuManager.this.F();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, j3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class c implements DanmakuMeasureManager.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DanmakuManager.this);
            }
        }

        @Override // com.tencent.common.danmaku.core.DanmakuMeasureManager.a
        public void a(com.tencent.common.danmaku.data.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            } else {
                DanmakuManager.this.E.b(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class d implements Handler.Callback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<DanmakuManager> f99626d;

        /* synthetic */ d(DanmakuManager danmakuManager, AnonymousClass1 anonymousClass1) {
            this(danmakuManager);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) danmakuManager, (Object) anonymousClass1);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            DanmakuManager danmakuManager = this.f99626d.get();
            if (danmakuManager != null) {
                switch (message.what) {
                    case 1:
                        danmakuManager.Y(message);
                        danmakuManager.W();
                        break;
                    case 2:
                        danmakuManager.W();
                        break;
                    case 3:
                        danmakuManager.T();
                        break;
                    case 4:
                        danmakuManager.M();
                        break;
                    case 5:
                        danmakuManager.X(message);
                        break;
                    case 6:
                        danmakuManager.U();
                        break;
                    case 7:
                        danmakuManager.S();
                        break;
                    case 8:
                        danmakuManager.V();
                        break;
                    case 9:
                        danmakuManager.P();
                        break;
                    case 10:
                        danmakuManager.R();
                        break;
                    case 11:
                        danmakuManager.Q();
                        break;
                }
                return false;
            }
            return false;
        }

        d(DanmakuManager danmakuManager) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.f99626d = new WeakReference<>(danmakuManager);
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) danmakuManager);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface e {
        void a();

        void b(List<com.tencent.common.danmaku.data.a> list);

        void c(com.tencent.common.danmaku.data.a aVar, h hVar, com.tencent.common.danmaku.tool.b bVar);

        void d(boolean z16);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7941);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 51)) {
            redirector.redirect((short) 51);
            return;
        }
        f99600h0 = new DecimalFormat("00.00");
        f99601i0 = new DecimalFormat("00");
        f99602j0 = 16;
        f99603k0 = 60;
        f99604l0 = 0L;
    }

    public DanmakuManager(View view, com.tencent.common.danmaku.inject.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view, (Object) bVar);
            return;
        }
        this.f99608d = "DanmakuManager" + hashCode();
        this.C = new Handler();
        this.N = true;
        this.Y = new LinkedBlockingDeque();
        this.Z = new LinkedList();
        this.f99607c0 = new d(this, null);
        this.X = bVar;
        g a16 = com.tencent.common.danmaku.render.c.a(view);
        this.D = a16;
        if (a16 != null) {
            a16.b(this);
            a16.setOnTouchListener(this);
        }
        f fVar = new f();
        this.I = fVar;
        this.J = new com.tencent.common.danmaku.tool.c();
        this.G = new com.tencent.common.danmaku.core.b();
        this.H = new DanmakuMeasureManager(bVar);
        DanmakuComparator danmakuComparator = new DanmakuComparator();
        com.tencent.common.danmaku.core.c cVar = new com.tencent.common.danmaku.core.c(fVar, danmakuComparator);
        this.E = cVar;
        cVar.h(bVar.m());
        try {
            int refreshRate = (int) com.tencent.common.danmaku.a.b().a().c().getDefaultDisplay().getRefreshRate();
            f99603k0 = refreshRate;
            f99602j0 = 1000 / refreshRate;
        } catch (Exception unused) {
            f99603k0 = 60;
            f99602j0 = 16;
        }
        this.f99605a0 = com.tencent.common.danmaku.core.a.j(bVar, this.G, danmakuComparator, this.I, this.J);
        this.F = new com.tencent.common.danmaku.core.d(bVar);
    }

    private void A() {
        Handler handler;
        Runnable runnable;
        Canvas canvas = null;
        try {
            canvas = this.D.lockCanvas();
            if (canvas != null) {
                com.tencent.common.danmaku.util.d.a(canvas);
                com.tencent.common.danmaku.util.e.e("surface_lock", "clearDrawing lockCanvas ", Integer.valueOf(canvas.hashCode()));
            }
            if (canvas != null) {
                try {
                    this.D.unlockCanvasAndPost(canvas);
                    com.tencent.common.danmaku.util.e.e("surface_lock", "clearDrawing unlockCanvas ", Integer.valueOf(canvas.hashCode()));
                } catch (Throwable th5) {
                    com.tencent.common.danmaku.util.e.c("surface_lock", "clearDrawing unlockCanvasAndPost exception: ", Integer.valueOf(canvas.hashCode()), th5);
                }
            }
            handler = com.tencent.common.danmaku.a.b().a().getHandler();
            runnable = new Runnable() { // from class: com.tencent.common.danmaku.core.DanmakuManager.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) DanmakuManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        DanmakuManager.this.X.t();
                    }
                }
            };
        } catch (Throwable th6) {
            if (canvas != null) {
                try {
                    com.tencent.common.danmaku.util.e.c("surface_lock", "clearDrawing lockCanvas exception: ", Integer.valueOf(canvas.hashCode()), th6);
                } catch (Throwable th7) {
                    try {
                        this.D.unlockCanvasAndPost(canvas);
                        com.tencent.common.danmaku.util.e.e("surface_lock", "clearDrawing unlockCanvas ", Integer.valueOf(canvas.hashCode()));
                    } catch (Throwable th8) {
                        com.tencent.common.danmaku.util.e.c("surface_lock", "clearDrawing unlockCanvasAndPost exception: ", Integer.valueOf(canvas.hashCode()), th8);
                    }
                    com.tencent.common.danmaku.a.b().a().getHandler().post(new Runnable() { // from class: com.tencent.common.danmaku.core.DanmakuManager.6
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DanmakuManager.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                            } else {
                                DanmakuManager.this.X.t();
                            }
                        }
                    });
                    throw th7;
                }
            }
            if (canvas != null) {
                try {
                    this.D.unlockCanvasAndPost(canvas);
                    com.tencent.common.danmaku.util.e.e("surface_lock", "clearDrawing unlockCanvas ", Integer.valueOf(canvas.hashCode()));
                } catch (Throwable th9) {
                    com.tencent.common.danmaku.util.e.c("surface_lock", "clearDrawing unlockCanvasAndPost exception: ", Integer.valueOf(canvas.hashCode()), th9);
                }
            }
            handler = com.tencent.common.danmaku.a.b().a().getHandler();
            runnable = new Runnable() { // from class: com.tencent.common.danmaku.core.DanmakuManager.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) DanmakuManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        DanmakuManager.this.X.t();
                    }
                }
            };
        }
        handler.post(runnable);
    }

    private void D(Canvas canvas) {
        if (this.f99614h) {
            this.D.unlockCanvasAndPost(canvas);
        } else {
            this.D.unlock();
        }
    }

    private void E(Canvas canvas) {
        synchronized (this) {
            D(canvas);
        }
        this.C.post(new Runnable() { // from class: com.tencent.common.danmaku.core.DanmakuManager.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DanmakuManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                com.tencent.common.danmaku.util.e.a("setOpaque");
                View view = DanmakuManager.this.D.getView();
                if (view instanceof TextureView) {
                    TextureView textureView = (TextureView) view;
                    textureView.setOpaque(true);
                    textureView.setOpaque(false);
                }
                com.tencent.common.danmaku.util.e.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 16)
    public void F() {
        if (c0()) {
            this.f99615i.post(new Runnable() { // from class: com.tencent.common.danmaku.core.DanmakuManager.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) DanmakuManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    DanmakuManager danmakuManager = DanmakuManager.this;
                    if (danmakuManager.f99613f0 == null) {
                        return;
                    }
                    danmakuManager.f99609d0.removeFrameCallback(DanmakuManager.this.f99613f0);
                    if (DanmakuManager.this.e0()) {
                        DanmakuManager.this.E0();
                    }
                    DanmakuManager.this.f99609d0.postFrameCallback(DanmakuManager.this.f99613f0);
                }
            });
        }
    }

    private void F0() {
        this.I.b(K());
        this.J.d();
        if (com.tencent.common.danmaku.util.e.f99819b >= 5) {
            com.tencent.common.danmaku.util.e.g(this.f99608d, "updateFrame:currentTime:", Long.valueOf(this.J.a()), ",lastInterval:", Long.valueOf(this.J.b()));
        }
    }

    private void H() {
        Object valueOf;
        if (this.D.g() && !Z()) {
            return;
        }
        Canvas canvas = null;
        try {
            com.tencent.common.danmaku.util.e.a("lockCanvasv");
            canvas = this.D.lockCanvas();
            com.tencent.common.danmaku.util.e.d();
            if (canvas != null) {
                com.tencent.common.danmaku.util.e.a("clearCanvas");
                com.tencent.common.danmaku.util.d.a(canvas);
                com.tencent.common.danmaku.util.e.d();
                com.tencent.common.danmaku.util.e.a("window draw");
                this.f99605a0.d(canvas, this.I.a());
                com.tencent.common.danmaku.util.e.d();
            }
            try {
                com.tencent.common.danmaku.util.e.a("dealUnLock");
                if (canvas != null) {
                    if (H0()) {
                        E(canvas);
                    } else if (this.D.c()) {
                        D(canvas);
                    } else {
                        synchronized (this) {
                            D(canvas);
                        }
                    }
                }
                com.tencent.common.danmaku.util.e.d();
            } catch (Throwable th5) {
                com.tencent.common.danmaku.util.e.c("surface_lock", "unlockCanvas exception ", Integer.valueOf(canvas.hashCode()), th5);
            }
        } catch (Throwable th6) {
            try {
                Object[] objArr = new Object[3];
                objArr[0] = "draw exception ";
                if (canvas == null) {
                    valueOf = "null";
                } else {
                    valueOf = Integer.valueOf(canvas.hashCode());
                }
                objArr[1] = valueOf;
                objArr[2] = th6;
                com.tencent.common.danmaku.util.e.c("surface_lock", objArr);
                try {
                    com.tencent.common.danmaku.util.e.a("dealUnLock");
                    if (canvas != null) {
                        if (H0()) {
                            E(canvas);
                        } else if (this.D.c()) {
                            D(canvas);
                        } else {
                            synchronized (this) {
                                D(canvas);
                            }
                        }
                    }
                    com.tencent.common.danmaku.util.e.d();
                } catch (Throwable th7) {
                    com.tencent.common.danmaku.util.e.c("surface_lock", "unlockCanvas exception ", Integer.valueOf(canvas.hashCode()), th7);
                }
            } catch (Throwable th8) {
                try {
                    com.tencent.common.danmaku.util.e.a("dealUnLock");
                    if (canvas != null) {
                        if (!H0()) {
                            if (this.D.c()) {
                                D(canvas);
                            } else {
                                synchronized (this) {
                                    D(canvas);
                                }
                            }
                        } else {
                            E(canvas);
                        }
                    }
                    com.tencent.common.danmaku.util.e.d();
                } catch (Throwable th9) {
                    com.tencent.common.danmaku.util.e.c("surface_lock", "unlockCanvas exception ", Integer.valueOf(canvas.hashCode()), th9);
                    throw th8;
                }
                throw th8;
            }
        }
    }

    private boolean H0() {
        if (this.X.f() && (this.D instanceof i)) {
            return true;
        }
        return false;
    }

    public static int L() {
        return f99602j0;
    }

    @RequiresApi(api = 16)
    private void N() {
        if (this.f99613f0 == null) {
            b bVar = new b();
            this.f99613f0 = bVar;
            this.f99609d0.postFrameCallback(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 16)
    public void O() {
        if (this.f99609d0 == null) {
            this.f99609d0 = Choreographer.getInstance();
        }
        if (this.f99611e0 == null) {
            this.f99611e0 = new Choreographer.FrameCallback() { // from class: com.tencent.common.danmaku.core.DanmakuManager.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) DanmakuManager.this);
                    }
                }

                @Override // android.view.Choreographer.FrameCallback
                public void doFrame(long j3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, j3);
                    } else if (DanmakuManager.this.b0() && DanmakuManager.this.e0() && DanmakuManager.this.f99615i != null) {
                        DanmakuManager.this.f99615i.post(new Runnable() { // from class: com.tencent.common.danmaku.core.DanmakuManager.2.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                    DanmakuManager.this.s0();
                                    if (DanmakuManager.this.e0()) {
                                        DanmakuManager.this.O();
                                        return;
                                    }
                                    return;
                                }
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                        });
                    }
                }
            };
        }
        synchronized (this) {
            E0();
        }
        this.f99609d0.postFrameCallback(this.f99611e0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        com.tencent.common.danmaku.util.e.e(this.f99608d, "handleClear()");
        this.f99605a0.c();
        this.X.c();
        this.E.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        com.tencent.common.danmaku.util.e.e("surface_lock", "handleClearDrawingCache");
        s0();
        if (this.D.c() && !H0()) {
            if (!this.f99614h) {
                return;
            }
        } else {
            synchronized (this) {
                if (!this.f99614h) {
                    return;
                }
            }
        }
        A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        if (this.f99606b0 != null) {
            while (!this.Y.isEmpty()) {
                h poll = this.Y.poll();
                com.tencent.common.danmaku.data.a k3 = this.f99605a0.k(poll);
                if (com.tencent.common.danmaku.util.e.f99819b >= 4) {
                    com.tencent.common.danmaku.util.e.g(this.f99608d, "handleClick:", poll, ",currentTime:", Long.valueOf(J()));
                }
                com.tencent.common.danmaku.a.b().a().getHandler().post(new Runnable(k3, poll) { // from class: com.tencent.common.danmaku.core.DanmakuManager.5
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ com.tencent.common.danmaku.data.a f99619d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ h f99620e;

                    {
                        this.f99619d = k3;
                        this.f99620e = poll;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, DanmakuManager.this, k3, poll);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (DanmakuManager.this.f99606b0 == null) {
                            return;
                        }
                        com.tencent.common.danmaku.data.a aVar = this.f99619d;
                        if (aVar == null) {
                            DanmakuManager.this.f99606b0.d(false);
                            return;
                        }
                        this.f99620e.c(aVar.j(), this.f99619d.k());
                        com.tencent.common.danmaku.tool.b X = this.f99619d.X(this.f99620e);
                        if (DanmakuManager.this.a0(X)) {
                            DanmakuManager.this.f99606b0.d(true);
                            if (X.f99785b) {
                                DanmakuManager.this.f99605a0.g(this.f99619d);
                            }
                            DanmakuManager.this.f99606b0.c(this.f99619d, this.f99620e, X);
                            return;
                        }
                        DanmakuManager.this.f99606b0.d(false);
                    }
                });
            }
        }
        com.tencent.common.danmaku.util.e.g(this.f99608d, "message click");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        com.tencent.common.danmaku.util.e.e(this.f99608d, "handleConfigChanged()");
        this.f99605a0.n();
        this.E.g();
        com.tencent.common.danmaku.util.e.e(this.f99608d, "message config changed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        long a16;
        com.tencent.common.danmaku.util.e.e(this.f99608d, "handlePause()");
        s0();
        this.f99612f = false;
        if (this.X.r()) {
            a16 = this.I.a();
        } else {
            a16 = this.J.a();
        }
        this.L = a16;
        if (com.tencent.common.danmaku.util.e.f99819b >= 5) {
            com.tencent.common.danmaku.util.e.g(this.f99608d, "message pause:mPausedTime:", Long.valueOf(a16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        com.tencent.common.danmaku.util.e.e(this.f99608d, "handleQuit()");
        this.f99610e = true;
        this.X.c();
        this.E.c();
        this.G.a();
        com.tencent.common.danmaku.util.e.e(this.f99608d, "message quit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        com.tencent.common.danmaku.util.e.e(this.f99608d, "handleResume()");
        if (!this.f99612f) {
            long J = J();
            long j3 = J - this.L;
            this.K = j3;
            if (com.tencent.common.danmaku.util.e.f99819b >= 5) {
                com.tencent.common.danmaku.util.e.b(this.f99608d, "handleResume, mBaseTime = ", Long.valueOf(j3), ", currentTime = ", Long.valueOf(J), ", mPauseTime = ", Long.valueOf(this.L));
            }
        }
        this.f99612f = true;
        f99599g0 = null;
        v0();
        if (com.tencent.common.danmaku.util.e.f99819b >= 5) {
            com.tencent.common.danmaku.util.e.b(this.f99608d, "message resume:mPausedTime:", Long.valueOf(this.L), ",mBaseTime:", Long.valueOf(this.K));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Message message) {
        this.f99610e = false;
        this.M = true;
        Object obj = message.obj;
        if (obj != null) {
            this.L = ((Long) obj).longValue();
        } else {
            this.L = 0L;
        }
        this.S = 0;
        this.T = 0;
        this.U = 0L;
        this.J.c();
        if (com.tencent.common.danmaku.util.e.f99819b >= 3) {
            com.tencent.common.danmaku.util.e.e(this.f99608d, "message start:startTime:", Long.valueOf(this.L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b0() {
        HandlerThread handlerThread = this.f99616m;
        if (handlerThread != null && handlerThread.isAlive()) {
            return true;
        }
        return false;
    }

    private boolean c0() {
        if (i0()) {
            if (b0() && this.f99615i != null) {
                return true;
            }
            return false;
        }
        if (this.f99615i != null) {
            return true;
        }
        return false;
    }

    private boolean f0() {
        boolean z16;
        if (this.f99614h && !this.f99610e && this.f99612f) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.common.danmaku.util.e.g(this.f99608d, "isPrepared() = ", Boolean.valueOf(z16), ", mIsSurfaceCreated = ", Boolean.valueOf(this.f99614h), ", mIsQuited = ", Boolean.valueOf(this.f99610e), ", mIsPlaying = ", Boolean.valueOf(this.f99612f));
        return z16;
    }

    private boolean h0() {
        if (this.f99614h && !this.f99610e && c0()) {
            return true;
        }
        return false;
    }

    private boolean i0() {
        return this.D instanceof com.tencent.common.danmaku.render.h;
    }

    private void j0() {
        this.f99605a0.i();
    }

    private void l0(List<com.tencent.common.danmaku.data.a> list) {
        for (com.tencent.common.danmaku.data.a aVar : list) {
            this.X.g(aVar).g(aVar);
            this.F.c(aVar);
        }
    }

    private void o0() {
        if (this.f99616m != null) {
            if (H0()) {
                this.f99616m.quit();
                this.f99616m.interrupt();
            } else if (com.tencent.common.danmaku.util.c.d()) {
                this.f99616m.quitSafely();
            } else {
                this.f99616m.quit();
            }
        }
    }

    private void p0() {
        this.Z.addAll(this.f99605a0.h());
        this.f99605a0.b();
        for (com.tencent.common.danmaku.data.a aVar : this.Z) {
            Bitmap m3 = aVar.m();
            if (m3 != null) {
                aVar.j0(null);
                aVar.f();
                this.G.e(m3);
            }
        }
        if (this.f99606b0 != null) {
            this.f99606b0.b(this.Z);
        }
        l0(this.Z);
        this.Z.clear();
    }

    private void r0() {
        List<com.tencent.common.danmaku.render.a> h16;
        com.tencent.common.danmaku.inject.b bVar = this.X;
        if (bVar != null && (h16 = bVar.h()) != null) {
            Iterator<com.tencent.common.danmaku.render.a> it = h16.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        Choreographer.FrameCallback frameCallback;
        com.tencent.common.danmaku.util.e.g(this.f99608d, "removeUpdateMessage()");
        Handler handler = this.f99615i;
        if (handler != null) {
            handler.removeMessages(4);
        }
        Choreographer choreographer = this.f99609d0;
        if (choreographer != null && (frameCallback = this.f99611e0) != null) {
            choreographer.removeFrameCallback(frameCallback);
        }
    }

    private void v0() {
        com.tencent.common.danmaku.util.e.g(this.f99608d, "resumeUpdateMessage()");
        if (d0()) {
            x0(4);
        }
    }

    private void x() {
        if (!i0() && !H0()) {
            this.f99615i = new Handler(Looper.getMainLooper(), this.f99607c0);
            return;
        }
        if (!b0()) {
            try {
                String str = "DanmakuDrawThreadPriority_" + f99604l0;
                f99604l0++;
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread(str, this.X.o());
                this.f99616m = baseHandlerThread;
                baseHandlerThread.setUncaughtExceptionHandler(new com.tencent.common.danmaku.util.b());
                this.f99616m.start();
                this.f99615i = new Handler(this.f99616m.getLooper(), this.f99607c0);
                com.tencent.common.danmaku.util.e.b(this.f99608d, "create thread, id=", Long.valueOf(f99604l0), ", pid=", Integer.valueOf(this.f99616m.getThreadId()));
            } catch (Throwable th5) {
                com.tencent.common.danmaku.util.e.c(this.f99608d, th5);
            }
        }
    }

    private void x0(int i3) {
        if (c0()) {
            this.f99615i.removeMessages(i3);
            this.f99615i.sendEmptyMessage(i3);
        }
    }

    private void z0(int i3, long j3) {
        if (c0()) {
            this.f99615i.removeMessages(i3);
            this.f99615i.sendEmptyMessageDelayed(i3, j3);
        }
    }

    public void A0(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) eVar);
        } else {
            this.f99606b0 = eVar;
        }
    }

    public void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        com.tencent.common.danmaku.util.e.e(this.f99608d, "clearDrawingCache()");
        Message obtain = Message.obtain();
        obtain.what = 11;
        y0(obtain);
    }

    public DanmakuManager B0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (DanmakuManager) iPatchRedirector.redirect((short) 39, (Object) this, z16);
        }
        this.N = z16;
        return this;
    }

    public com.tencent.common.danmaku.data.a C(int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (com.tencent.common.danmaku.data.a) iPatchRedirector.redirect((short) 46, (Object) this, i3, obj);
        }
        return this.F.a(i3, obj);
    }

    public void C0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            D0(0L);
        }
    }

    public void D0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
            return;
        }
        com.tencent.common.danmaku.util.e.g(this.f99608d, "start() time = ", Long.valueOf(j3));
        x();
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = Long.valueOf(j3);
        y0(obtain);
    }

    protected void E0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        com.tencent.common.danmaku.util.e.a("updateFrame");
        com.tencent.common.danmaku.util.e.a("updateTime");
        F0();
        com.tencent.common.danmaku.util.e.d();
        com.tencent.common.danmaku.util.e.a("clearDrawing");
        if (this.M) {
            this.f99605a0.c();
            this.M = false;
        }
        com.tencent.common.danmaku.util.e.d();
        try {
            if (com.tencent.common.danmaku.util.e.f99819b >= 4) {
                this.P = J();
            }
            com.tencent.common.danmaku.util.e.a("uploadDanmaku");
            G0();
            com.tencent.common.danmaku.util.e.d();
            if (com.tencent.common.danmaku.util.e.f99819b >= 4) {
                this.Q = J();
            }
            com.tencent.common.danmaku.util.e.a(TtmlNode.TAG_LAYOUT);
            j0();
            com.tencent.common.danmaku.util.e.d();
            if (com.tencent.common.danmaku.util.e.f99819b >= 4) {
                this.R = J();
            }
            com.tencent.common.danmaku.util.e.a("draw");
            if (e0() && this.D != null) {
                H();
            }
            com.tencent.common.danmaku.util.e.d();
            p0();
        } catch (Throwable th5) {
            com.tencent.common.danmaku.util.e.c(this.f99608d, th5.toString(), th5);
        }
        com.tencent.common.danmaku.util.e.d();
    }

    public void G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this);
            return;
        }
        s0();
        Handler handler = this.f99615i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        V();
        if (!this.f99610e) {
            U();
        }
        Choreographer.FrameCallback frameCallback = this.f99613f0;
        if (frameCallback != null) {
            this.f99609d0.removeFrameCallback(frameCallback);
        }
        this.f99613f0 = null;
        Choreographer.FrameCallback frameCallback2 = this.f99611e0;
        if (frameCallback2 != null) {
            this.f99609d0.removeFrameCallback(frameCallback2);
        }
        this.f99611e0 = null;
        g gVar = this.D;
        if (gVar != null) {
            gVar.destroy();
        }
        this.f99606b0 = null;
        this.f99607c0 = null;
        com.tencent.common.danmaku.a.b().a().a(this.T, this.S, this.U, I());
    }

    protected void G0() {
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        List<com.tencent.common.danmaku.data.a> d16 = this.E.d();
        if (com.tencent.common.danmaku.util.e.f99819b >= 3 && (size = d16.size()) > 0) {
            com.tencent.common.danmaku.util.e.e(this.f99608d, "new danmaku to draw:", Integer.valueOf(size));
        }
        Iterator<com.tencent.common.danmaku.data.a> it = d16.iterator();
        while (it.hasNext()) {
            com.tencent.common.danmaku.data.a next = it.next();
            it.remove();
            if (next.W(this.I.a())) {
                if (com.tencent.common.danmaku.util.e.f99819b >= 3) {
                    com.tencent.common.danmaku.util.e.e(this.f99608d, "before measure ", next, " is out side");
                }
                this.Z.add(next);
            } else {
                if (com.tencent.common.danmaku.util.e.f99819b >= 3 && next.T()) {
                    com.tencent.common.danmaku.util.e.e(this.f99608d, "must show danmaku upload to Windown :", next);
                }
                if (com.tencent.common.danmaku.util.e.f99819b >= 3) {
                    com.tencent.common.danmaku.util.e.e(this.f99608d, "upload, danmaku = ", next);
                }
                next.p0(this.J.a());
                this.f99605a0.a(next);
            }
        }
    }

    public HashMap I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return (HashMap) iPatchRedirector.redirect((short) 48, (Object) this);
        }
        return null;
    }

    public long J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Long) iPatchRedirector.redirect((short) 22, (Object) this)).longValue();
        }
        return SystemClock.uptimeMillis();
    }

    public long K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Long) iPatchRedirector.redirect((short) 23, (Object) this)).longValue();
        }
        if (this.X.r()) {
            return J() - this.K;
        }
        long J = J();
        long j3 = this.V;
        if (J - j3 >= 200) {
            this.V = J;
            long n3 = this.X.n();
            this.W = n3;
            return n3;
        }
        return (this.W + J) - j3;
    }

    protected void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        if (H0()) {
            s0();
            if (e0()) {
                O();
                return;
            }
            return;
        }
        if (this.D.e()) {
            if (this.f99609d0 == null) {
                this.f99609d0 = Choreographer.getInstance();
            }
            N();
            return;
        }
        com.tencent.common.danmaku.util.e.g(this.f99608d, "handelUpdate()");
        s0();
        if (e0()) {
            long J = J();
            E0();
            z0(4, (f99602j0 + J) - J());
        }
    }

    protected void V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        com.tencent.common.danmaku.util.e.e(this.f99608d, "handleRelease()");
        o0();
        this.H.f();
        this.G.d();
    }

    protected void X(Message message) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) message);
            return;
        }
        String str = this.f99608d;
        Object[] objArr = new Object[2];
        objArr[0] = "handleSeek() msg.obj is null = ";
        if (message.obj == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        objArr[1] = Boolean.valueOf(z16);
        com.tencent.common.danmaku.util.e.e(str, objArr);
        Object obj = message.obj;
        if (obj != null) {
            this.L = ((Long) obj).longValue();
            this.M = true;
            W();
        }
        if (com.tencent.common.danmaku.util.e.f99819b >= 5) {
            com.tencent.common.danmaku.util.e.g(this.f99608d, "message seek:startTime:", Long.valueOf(this.L));
        }
    }

    public boolean Z() {
        com.tencent.common.danmaku.core.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        com.tencent.common.danmaku.core.a aVar = this.f99605a0;
        if (!(aVar instanceof com.tencent.common.danmaku.core.e)) {
            return false;
        }
        if (!((com.tencent.common.danmaku.core.e) aVar).r() && ((cVar = this.E) == null || !cVar.e())) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.common.danmaku.render.g.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this);
            return;
        }
        s0();
        if (this.D.c() && !H0()) {
            this.f99614h = false;
        } else {
            synchronized (this) {
                this.f99614h = false;
                com.tencent.common.danmaku.util.e.b(this.f99608d, "onDanmakuViewDetached synchronized");
            }
        }
        com.tencent.common.danmaku.util.e.b(this.f99608d, "onDanmakuViewDetached");
    }

    protected boolean a0(com.tencent.common.danmaku.tool.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, (Object) bVar)).booleanValue();
        }
        if (g0() && bVar.f99784a != -1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.common.danmaku.render.g.a
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        com.tencent.common.danmaku.util.e.e("surface_lock", "surfaceChanged");
        if (this.D.c() && !H0()) {
            this.f99614h = true;
        } else {
            synchronized (this) {
                this.f99614h = true;
            }
        }
        v0();
    }

    @Override // com.tencent.common.danmaku.render.g.a
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
            return;
        }
        s0();
        if (this.D.c() && !H0()) {
            this.f99614h = false;
        } else {
            synchronized (this) {
                this.f99614h = false;
            }
        }
        com.tencent.common.danmaku.util.e.b(this.f99608d, "surfaceDestroyed");
    }

    @Override // com.tencent.common.danmaku.render.g.a
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
        } else {
            com.tencent.common.danmaku.util.e.e("surface_lock", "surfaceCreated");
        }
    }

    public boolean d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        if (!this.f99610e && this.f99612f) {
            return true;
        }
        return false;
    }

    public boolean e0() {
        boolean f06;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        if (this.D.c() && !H0()) {
            return f0();
        }
        synchronized (this) {
            f06 = f0();
        }
        return f06;
    }

    public boolean g0() {
        boolean h06;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        if (this.D.c() && !H0()) {
            return h0();
        }
        synchronized (this) {
            h06 = h0();
        }
        return h06;
    }

    public void k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        com.tencent.common.danmaku.util.e.g(this.f99608d, "notifyConfigChanged()");
        x();
        Message obtain = Message.obtain();
        obtain.what = 7;
        y0(obtain);
    }

    public void m0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.common.danmaku.util.e.e(this.f99608d, "pause()");
        Message obtain = Message.obtain();
        obtain.what = 3;
        y0(obtain);
    }

    public void n0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        com.tencent.common.danmaku.util.e.b(this.f99608d, "quit(); mIsQuited = true");
        this.f99610e = true;
        Message obtain = Message.obtain();
        obtain.what = 6;
        y0(obtain);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        if (this.N) {
            if (com.tencent.common.danmaku.util.e.f99819b >= 4) {
                com.tencent.common.danmaku.util.e.g(this.f99608d, "onClick:", motionEvent);
            }
            if ((motionEvent.getAction() & 255) == 0) {
                t(new Point((int) motionEvent.getX(), (int) motionEvent.getY()), 0);
            }
        }
        return false;
    }

    @Deprecated
    public void q0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        com.tencent.common.danmaku.util.e.b(this.f99608d, "release() mIsQuited = ", Boolean.valueOf(this.f99610e));
        r0();
        if (!this.f99610e) {
            n0();
        }
        Message obtain = Message.obtain();
        obtain.what = 8;
        y0(obtain);
        this.f99606b0 = null;
    }

    public void t(Point point, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) point, i3);
            return;
        }
        point.y = (int) (point.y - this.D.a());
        h hVar = new h(this.J.a(), point, i3);
        if (com.tencent.common.danmaku.util.e.f99819b >= 4) {
            com.tencent.common.danmaku.util.e.g(this.f99608d, "addClickPoint:", hVar);
        }
        this.Y.add(hVar);
        Message obtain = Message.obtain();
        obtain.what = 10;
        y0(obtain);
    }

    public void u(List<com.tencent.common.danmaku.data.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) list);
        } else {
            this.H.e(list, new a());
        }
    }

    public void u0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.common.danmaku.util.e.g(this.f99608d, "resume()");
        Message obtain = Message.obtain();
        obtain.what = 2;
        y0(obtain);
    }

    public void v(com.tencent.common.danmaku.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) aVar);
        } else {
            aVar.v0(this.I.a());
            this.H.d(aVar, new c());
        }
    }

    public void w(com.tencent.common.danmaku.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) aVar);
            return;
        }
        com.tencent.common.danmaku.core.c cVar = this.E;
        if (cVar != null) {
            cVar.a(aVar);
        }
    }

    public void w0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
            return;
        }
        com.tencent.common.danmaku.util.e.g(this.f99608d, "seek(): postime = ", Long.valueOf(j3));
        Message obtain = Message.obtain();
        obtain.what = 5;
        obtain.obj = Long.valueOf(j3);
        y0(obtain);
    }

    public void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        com.tencent.common.danmaku.util.e.g(this.f99608d, QCircleLpReportDc05507.KEY_CLEAR);
        Message obtain = Message.obtain();
        obtain.what = 9;
        y0(obtain);
        z();
    }

    protected void y0(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) message);
        } else if (c0()) {
            this.f99615i.sendMessage(message);
        }
    }

    public void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this);
            return;
        }
        com.tencent.common.danmaku.core.c cVar = this.E;
        if (cVar != null) {
            cVar.c();
        }
    }
}
