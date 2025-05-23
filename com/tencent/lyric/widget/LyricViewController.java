package com.tencent.lyric.widget;

import android.os.SystemClock;
import android.util.Log;
import com.tencent.lyric.common.TimerTaskManager;
import com.tencent.lyric.widget.LyricViewScroll;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class LyricViewController {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected final String f147113a;

    /* renamed from: b, reason: collision with root package name */
    protected LyricView f147114b;

    /* renamed from: c, reason: collision with root package name */
    protected LyricViewScroll f147115c;

    /* renamed from: d, reason: collision with root package name */
    protected b f147116d;

    /* renamed from: e, reason: collision with root package name */
    protected com.tencent.lyric.data.a f147117e;

    /* renamed from: f, reason: collision with root package name */
    protected long f147118f;

    /* renamed from: g, reason: collision with root package name */
    protected volatile boolean f147119g;

    /* renamed from: h, reason: collision with root package name */
    protected volatile boolean f147120h;

    /* renamed from: i, reason: collision with root package name */
    protected int f147121i;

    /* renamed from: j, reason: collision with root package name */
    protected int f147122j;

    /* renamed from: k, reason: collision with root package name */
    protected volatile int f147123k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f147124l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f147125m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f147126n;

    /* renamed from: o, reason: collision with root package name */
    protected boolean f147127o;

    /* renamed from: p, reason: collision with root package name */
    protected int f147128p;

    /* renamed from: q, reason: collision with root package name */
    protected TimerTaskManager f147129q;

    /* renamed from: r, reason: collision with root package name */
    protected c f147130r;

    /* renamed from: s, reason: collision with root package name */
    protected boolean f147131s;

    /* renamed from: t, reason: collision with root package name */
    private LyricViewScroll.c f147132t;

    /* renamed from: u, reason: collision with root package name */
    protected TimerTaskManager.TimerTaskRunnable f147133u;

    /* compiled from: P */
    /* renamed from: com.tencent.lyric.widget.LyricViewController$5, reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass5 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f147138d;
        final /* synthetic */ LyricViewController this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.this$0.f147116d.g(this.f147138d);
            this.this$0.f147116d.f();
            LyricViewController lyricViewController = this.this$0;
            lyricViewController.f147115c.f(lyricViewController.f147116d.d());
            this.this$0.f147125m = this.f147138d;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.lyric.widget.LyricViewController$6, reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass6 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ LyricViewController this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            b bVar = this.this$0.f147116d;
            if (bVar != null) {
                bVar.h();
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.lyric.widget.LyricViewController$7, reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass7 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f147139d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f147140e;
        final /* synthetic */ LyricViewController this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            b bVar = this.this$0.f147116d;
            if (bVar != null) {
                bVar.setSegment(this.f147139d, this.f147140e);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements LyricViewScroll.c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LyricViewController.this);
            }
        }

        @Override // com.tencent.lyric.widget.LyricViewScroll.c
        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else {
                LyricViewController.this.f147119g = true;
                LyricViewController.this.i(i3);
            }
        }

        @Override // com.tencent.lyric.widget.LyricViewScroll.c
        public void b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            Log.i("ModuleController", "onScrollStop -> top:" + i3);
            LyricViewController.this.h(i3);
        }
    }

    public LyricViewController(LyricView lyricView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) lyricView);
            return;
        }
        this.f147113a = "task_name_lyric_draw_" + Math.random();
        this.f147119g = false;
        this.f147123k = 0;
        this.f147124l = false;
        this.f147125m = false;
        this.f147126n = false;
        this.f147127o = true;
        this.f147128p = 100;
        this.f147129q = com.tencent.lyric.util.b.b();
        this.f147130r = new c();
        this.f147131s = true;
        this.f147132t = new a();
        this.f147133u = new TimerTaskManager.TimerTaskRunnable() { // from class: com.tencent.lyric.widget.LyricViewController.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LyricViewController.this);
                }
            }

            @Override // com.tencent.lyric.common.TimerTaskManager.TimerTaskRunnable
            public void e() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else if (!isCancelled()) {
                    LyricViewController.this.f();
                }
            }
        };
        this.f147114b = lyricView;
        this.f147115c = lyricView.b();
        this.f147116d = lyricView.a();
        this.f147115c.setScrollListener(this.f147132t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        int i3;
        int elapsedRealtime = (int) (SystemClock.elapsedRealtime() - this.f147118f);
        if (this.f147120h && (i3 = this.f147121i) > 0) {
            elapsedRealtime -= i3;
        }
        g(elapsedRealtime);
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f147123k;
    }

    protected void d(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            e(i3, i16, true);
        }
    }

    protected void e(int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
        } else {
            com.tencent.lyric.util.b.a().post(new Runnable(i3, i16, z16) { // from class: com.tencent.lyric.widget.LyricViewController.8
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f147141d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f147142e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ boolean f147143f;

                {
                    this.f147141d = i3;
                    this.f147142e = i16;
                    this.f147143f = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, LyricViewController.this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    b bVar = LyricViewController.this.f147116d;
                    if (bVar != null) {
                        bVar.e(this.f147141d, this.f147142e);
                    }
                    LyricViewController lyricViewController = LyricViewController.this;
                    if (lyricViewController.f147115c != null) {
                        int d16 = lyricViewController.f147116d.d();
                        if (d16 != 0 && this.f147143f) {
                            LyricViewController lyricViewController2 = LyricViewController.this;
                            lyricViewController2.f147115c.g(lyricViewController2.f147116d.d());
                        } else {
                            LyricViewController.this.f147115c.f(d16);
                        }
                    }
                }
            });
        }
    }

    public void g(int i3) {
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
            return;
        }
        com.tencent.lyric.data.a c16 = this.f147116d.c();
        this.f147117e = c16;
        if (c16 != null && !c16.t() && !this.f147119g) {
            if (this.f147120h && (i17 = this.f147121i) > 0) {
                i3 += i17;
            }
            if (this.f147120h && i3 > (i16 = this.f147122j)) {
                i3 = i16;
            }
            if (this.f147123k != i3) {
                this.f147123k = i3;
                d(c16.c(i3), i3);
                return;
            }
            return;
        }
        if (this.f147119g) {
            Log.i("ModuleController", "onRefresh -> is scrolling");
        }
    }

    protected void h(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
            return;
        }
        this.f147119g = false;
        if (this.f147117e != null || this.f147116d != null) {
            int b16 = this.f147116d.b(i3);
            com.tencent.lyric.data.a aVar = this.f147117e;
            if (aVar != null && !aVar.t()) {
                Log.i("ModuleController", "onScrollStop -> scroll to lineNo\uff1a" + b16);
                if (b16 >= 0 && b16 < this.f147117e.f147056b.size()) {
                    if (this.f147117e.f147056b.get(b16) == null) {
                        Log.w("ModuleController", "onScrollStop -> current sentence is null");
                        return;
                    }
                    long j3 = this.f147117e.f147056b.get(b16).f147071b;
                    Log.i("ModuleController", "onScrollStop -> start time of current sentence\uff1a" + j3);
                    if (this.f147120h && (((i16 = this.f147121i) >= 0 && j3 < i16) || ((i16 = this.f147122j) >= 0 && j3 > i16))) {
                        j3 = i16;
                    }
                    Log.i("ModuleController", "onScrollStop -> correct start time\uff1a" + j3);
                    if (j3 < 0) {
                        j3 = 0;
                    }
                    long j16 = ((j3 / 10) + 1) * 10;
                    Log.i("ModuleController", "onScrollStop -> output time\uff1a" + j16);
                    this.f147130r.a(j16);
                    if (!this.f147124l && this.f147126n) {
                        j((int) j16);
                        return;
                    }
                    return;
                }
                Log.w("ModuleController", "onScrollStop -> scroll out of lyric scope");
                return;
            }
            Log.w("ModuleController", "onScrollStop -> scroll without measured lyric");
        }
    }

    protected void i(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
            return;
        }
        if (this.f147117e != null || this.f147116d != null) {
            int a16 = this.f147116d.a(i3);
            com.tencent.lyric.data.a aVar = this.f147117e;
            if (aVar != null && !aVar.t()) {
                if (a16 >= 0 && a16 < this.f147117e.f147056b.size()) {
                    if (this.f147117e.f147056b.get(a16) == null) {
                        Log.w("ModuleController", "onScrollStop -> current sentence is null");
                        return;
                    }
                    long j3 = this.f147117e.f147056b.get(a16).f147071b;
                    if (this.f147120h && (((i16 = this.f147121i) >= 0 && j3 < i16) || ((i16 = this.f147122j) >= 0 && j3 > i16))) {
                        j3 = i16;
                    }
                    if (j3 < 0) {
                        j3 = 0;
                    }
                    this.f147130r.b(((j3 / 10) + 1) * 10, this.f147115c.getScrollY());
                    return;
                }
                Log.w("ModuleController", "onScrollStop -> scroll out of lyric scope");
                return;
            }
            Log.w("ModuleController", "onScrolling -> scroll without measured lyric");
        }
    }

    public void j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            com.tencent.lyric.util.b.a().post(new Runnable(i3) { // from class: com.tencent.lyric.widget.LyricViewController.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f147137d;

                {
                    this.f147137d = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LyricViewController.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    LyricViewController lyricViewController;
                    int i16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    com.tencent.lyric.data.a aVar = LyricViewController.this.f147117e;
                    if (aVar != null && !aVar.t()) {
                        LyricViewController.this.f147118f = SystemClock.elapsedRealtime() - this.f147137d;
                        if (LyricViewController.this.f147120h && (i16 = (lyricViewController = LyricViewController.this).f147121i) > 0) {
                            lyricViewController.f147118f -= i16;
                        }
                        LyricViewController.this.f();
                        return;
                    }
                    Log.w("ModuleController", "seek before set lyric");
                }
            });
        }
    }

    public void k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, i3);
            return;
        }
        b bVar = this.f147116d;
        if (bVar != null) {
            bVar.setEffectType(i3);
        }
    }

    public void l(com.tencent.lyric.data.a aVar, com.tencent.lyric.data.a aVar2, com.tencent.lyric.data.a aVar3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, aVar, aVar2, aVar3);
        } else {
            Log.v("ModuleController", "setLyric begin");
            com.tencent.lyric.util.b.a().post(new Runnable(aVar3, aVar, aVar2) { // from class: com.tencent.lyric.widget.LyricViewController.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ com.tencent.lyric.data.a f147134d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ com.tencent.lyric.data.a f147135e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ com.tencent.lyric.data.a f147136f;

                {
                    this.f147134d = aVar3;
                    this.f147135e = aVar;
                    this.f147136f = aVar2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, LyricViewController.this, aVar3, aVar, aVar2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (this.f147134d == null) {
                        Log.i("ModuleController", "setLyric -> pronounce is null");
                    }
                    LyricViewController.this.f147125m = false;
                    com.tencent.lyric.data.a aVar4 = this.f147135e;
                    if (aVar4 == null) {
                        Log.i("ModuleController", "setLyric -> qrc is null");
                        LyricViewController.this.f147116d.setLyric(this.f147136f, this.f147134d);
                        LyricViewController.this.f147117e = this.f147136f;
                        return;
                    }
                    LyricViewController.this.f147116d.setLyric(aVar4, this.f147134d);
                    LyricViewController.this.f147117e = this.f147135e;
                }
            });
        }
    }

    public void m(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        b bVar = this.f147116d;
        if (bVar != null) {
            bVar.setShadowEffectExt(i3, i16, i17, i18);
        }
    }

    public void n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, i3);
            return;
        }
        b bVar = this.f147116d;
        if (bVar != null) {
            bVar.setShowLineNumber(i3);
        }
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Log.i("ModuleController", "start");
        TimerTaskManager timerTaskManager = this.f147129q;
        String str = this.f147113a;
        int i3 = this.f147128p;
        timerTaskManager.c(str, i3, i3, this.f147133u);
        this.f147124l = true;
    }

    public void p(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            j(i3);
            o();
        }
    }

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Log.i("ModuleController", "stop");
        this.f147129q.a(this.f147113a);
        this.f147118f = 0L;
        this.f147124l = false;
    }
}
