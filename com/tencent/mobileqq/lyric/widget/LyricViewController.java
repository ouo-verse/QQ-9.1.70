package com.tencent.mobileqq.lyric.widget;

import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.lyric.common.TimerTaskManager;
import com.tencent.mobileqq.lyric.widget.LyricViewScroll;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LyricViewController {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected final String f243185a;

    /* renamed from: b, reason: collision with root package name */
    private LyricViewScroll f243186b;

    /* renamed from: c, reason: collision with root package name */
    protected LyricViewInternal f243187c;

    /* renamed from: d, reason: collision with root package name */
    protected com.tencent.mobileqq.lyric.data.b f243188d;

    /* renamed from: e, reason: collision with root package name */
    protected long f243189e;

    /* renamed from: f, reason: collision with root package name */
    protected volatile boolean f243190f;

    /* renamed from: g, reason: collision with root package name */
    protected volatile boolean f243191g;

    /* renamed from: h, reason: collision with root package name */
    protected int f243192h;

    /* renamed from: i, reason: collision with root package name */
    protected int f243193i;

    /* renamed from: j, reason: collision with root package name */
    private volatile int f243194j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f243195k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f243196l;

    /* renamed from: m, reason: collision with root package name */
    protected TimerTaskManager f243197m;

    /* renamed from: n, reason: collision with root package name */
    protected com.tencent.mobileqq.lyric.widget.a f243198n;

    /* renamed from: o, reason: collision with root package name */
    private LyricViewScroll.a f243199o;

    /* renamed from: p, reason: collision with root package name */
    protected TimerTaskManager.TimerTaskRunnable f243200p;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.lyric.widget.LyricViewController$6, reason: invalid class name */
    /* loaded from: classes15.dex */
    class AnonymousClass6 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f243205d;
        final /* synthetic */ LyricViewController this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.this$0.f243187c.s(this.f243205d);
            this.this$0.f243187c.t();
            this.this$0.f243186b.d(this.this$0.f243187c.f());
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.lyric.widget.LyricViewController$7, reason: invalid class name */
    /* loaded from: classes15.dex */
    class AnonymousClass7 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ LyricViewController this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            LyricViewInternal lyricViewInternal = this.this$0.f243187c;
            if (lyricViewInternal != null) {
                lyricViewInternal.p();
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.lyric.widget.LyricViewController$8, reason: invalid class name */
    /* loaded from: classes15.dex */
    class AnonymousClass8 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f243206d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f243207e;
        final /* synthetic */ LyricViewController this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            LyricViewInternal lyricViewInternal = this.this$0.f243187c;
            if (lyricViewInternal != null) {
                lyricViewInternal.setSegment(this.f243206d, this.f243207e);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements LyricViewScroll.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LyricViewController.this);
            }
        }

        @Override // com.tencent.mobileqq.lyric.widget.LyricViewScroll.a
        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else {
                LyricViewController.this.f243190f = true;
                LyricViewController.this.g(i3);
            }
        }

        @Override // com.tencent.mobileqq.lyric.widget.LyricViewScroll.a
        public void b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            Log.d("ModuleController", "onScrollStop -> top:" + i3);
            LyricViewController.this.f(i3);
        }
    }

    public LyricViewController(LyricView lyricView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) lyricView);
            return;
        }
        this.f243185a = "task_name_lyric_draw_" + System.currentTimeMillis();
        this.f243190f = false;
        this.f243194j = 0;
        this.f243195k = false;
        this.f243196l = false;
        this.f243197m = com.tencent.mobileqq.lyric.util.a.b();
        this.f243198n = new com.tencent.mobileqq.lyric.widget.a();
        this.f243199o = new a();
        this.f243200p = new TimerTaskManager.TimerTaskRunnable() { // from class: com.tencent.mobileqq.lyric.widget.LyricViewController.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LyricViewController.this);
                }
            }

            @Override // com.tencent.mobileqq.lyric.common.TimerTaskManager.TimerTaskRunnable
            public void e() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else if (!isCancelled()) {
                    LyricViewController.this.e();
                }
            }
        };
        this.f243186b = lyricView.b();
        this.f243187c = lyricView.a();
        this.f243186b.setScrollListener(this.f243199o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        int i3;
        com.tencent.mobileqq.lyric.data.b e16 = this.f243187c.e();
        this.f243188d = e16;
        if (e16 != null && !e16.j() && !this.f243190f) {
            int elapsedRealtime = (int) (SystemClock.elapsedRealtime() - this.f243189e);
            if (this.f243191g && elapsedRealtime >= (i3 = this.f243193i)) {
                elapsedRealtime = i3;
            }
            this.f243194j = elapsedRealtime;
            d(e16.c(elapsedRealtime), elapsedRealtime);
            return;
        }
        if (this.f243190f) {
            Log.d("ModuleController", "onRefresh -> is scrolling");
        }
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.f243195k;
    }

    protected void d(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        LyricViewInternal lyricViewInternal = this.f243187c;
        if (lyricViewInternal != null && lyricViewInternal.getWindowToken() != null) {
            ThreadManager.getUIHandler().post(new Runnable(i3, i16) { // from class: com.tencent.mobileqq.lyric.widget.LyricViewController.9
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f243208d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f243209e;

                {
                    this.f243208d = i3;
                    this.f243209e = i16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, LyricViewController.this, Integer.valueOf(i3), Integer.valueOf(i16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        LyricViewController.this.f243187c.k(this.f243208d, this.f243209e);
                    }
                }
            });
        }
        LyricViewScroll lyricViewScroll = this.f243186b;
        if (lyricViewScroll != null && lyricViewScroll.getWindowToken() != null) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.lyric.widget.LyricViewController.10
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LyricViewController.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        LyricViewController.this.f243186b.e(LyricViewController.this.f243187c.f());
                    }
                }
            });
        }
    }

    protected void f(int i3) {
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
            return;
        }
        this.f243190f = false;
        if (this.f243188d != null) {
            LyricViewInternal lyricViewInternal = this.f243187c;
            if (lyricViewInternal != null) {
                i16 = lyricViewInternal.i(i3);
            } else {
                i16 = -1;
            }
            com.tencent.mobileqq.lyric.data.b bVar = this.f243188d;
            if (bVar != null && !bVar.j()) {
                Log.d("ModuleController", "onScrollStop -> scroll to lineNo\uff1a" + i16);
                if (i16 >= 0 && i16 < this.f243188d.f243142b.size()) {
                    if (this.f243188d.f243142b.get(i16) == null) {
                        Log.w("ModuleController", "onScrollStop -> current sentence is null");
                        return;
                    }
                    long j3 = this.f243188d.f243142b.get(i16).f243149b;
                    Log.d("ModuleController", "onScrollStop -> start time of current sentence\uff1a" + j3);
                    if (this.f243191g && (((i17 = this.f243192h) >= 0 && j3 < i17) || ((i17 = this.f243193i) >= 0 && j3 > i17))) {
                        j3 = i17;
                    }
                    Log.d("ModuleController", "onScrollStop -> correct start time\uff1a" + j3);
                    if (j3 < 0) {
                        j3 = 0;
                    }
                    long j16 = ((j3 / 10) + 1) * 10;
                    Log.d("ModuleController", "onScrollStop -> output time\uff1a" + j16);
                    this.f243198n.a(j16);
                    if (!this.f243195k && this.f243196l) {
                        i((int) j16);
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

    protected void g(int i3) {
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
            return;
        }
        if (this.f243188d != null || this.f243187c != null) {
            LyricViewInternal lyricViewInternal = this.f243187c;
            if (lyricViewInternal != null) {
                i16 = lyricViewInternal.j(i3);
            } else {
                i16 = -1;
            }
            com.tencent.mobileqq.lyric.data.b bVar = this.f243188d;
            if (bVar != null && !bVar.j()) {
                if (i16 >= 0 && i16 < this.f243188d.f243142b.size()) {
                    if (this.f243188d.f243142b.get(i16) == null) {
                        Log.w("ModuleController", "onScrollStop -> current sentence is null");
                        return;
                    }
                    long j3 = this.f243188d.f243142b.get(i16).f243149b;
                    if (this.f243191g && (((i17 = this.f243192h) >= 0 && j3 < i17) || ((i17 = this.f243193i) >= 0 && j3 > i17))) {
                        j3 = i17;
                    }
                    if (j3 < 0) {
                        j3 = 0;
                    }
                    this.f243198n.b(((j3 / 10) + 1) * 10);
                    return;
                }
                Log.w("ModuleController", "onScrollStop -> scroll out of lyric scope");
                return;
            }
            Log.w("ModuleController", "onScrolling -> scroll without measured lyric");
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.f243197m.a(this.f243185a);
            this.f243195k = false;
        }
    }

    public void i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        Log.d("ModuleController", "seek " + i3);
        com.tencent.mobileqq.lyric.util.a.a().post(new Runnable(i3) { // from class: com.tencent.mobileqq.lyric.widget.LyricViewController.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f243204d;

            {
                this.f243204d = i3;
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
                LyricViewInternal lyricViewInternal = LyricViewController.this.f243187c;
                if (lyricViewInternal != null) {
                    lyricViewInternal.q();
                }
                com.tencent.mobileqq.lyric.data.b bVar = LyricViewController.this.f243188d;
                if (bVar != null && !bVar.j()) {
                    LyricViewController.this.f243189e = SystemClock.elapsedRealtime() - this.f243204d;
                    if (LyricViewController.this.f243191g && (i16 = (lyricViewController = LyricViewController.this).f243192h) > 0) {
                        lyricViewController.f243189e -= i16;
                    }
                    LyricViewController.this.e();
                    return;
                }
                Log.w("ModuleController", "seek before set lyric");
            }
        });
    }

    public void j(com.tencent.mobileqq.lyric.data.b bVar, com.tencent.mobileqq.lyric.data.b bVar2, com.tencent.mobileqq.lyric.data.b bVar3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, bVar, bVar2, bVar3);
        } else {
            Log.v("ModuleController", "setLyric begin");
            com.tencent.mobileqq.lyric.util.a.a().post(new Runnable(bVar3, bVar, bVar2) { // from class: com.tencent.mobileqq.lyric.widget.LyricViewController.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.lyric.data.b f243201d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.lyric.data.b f243202e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.lyric.data.b f243203f;

                {
                    this.f243201d = bVar3;
                    this.f243202e = bVar;
                    this.f243203f = bVar2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, LyricViewController.this, bVar3, bVar, bVar2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (this.f243201d == null) {
                        Log.d("ModuleController", "setLyric -> pronounce is null");
                    }
                    com.tencent.mobileqq.lyric.data.b bVar4 = this.f243202e;
                    if (bVar4 == null) {
                        Log.d("ModuleController", "setLyric -> qrc is null");
                        LyricViewController.this.f243187c.r(this.f243203f, this.f243201d);
                        LyricViewController.this.f243188d = this.f243203f;
                        return;
                    }
                    LyricViewController.this.f243187c.r(bVar4, this.f243201d);
                    LyricViewController lyricViewController = LyricViewController.this;
                    com.tencent.mobileqq.lyric.data.b bVar5 = this.f243202e;
                    lyricViewController.f243188d = bVar5;
                    lyricViewController.f243193i = bVar5.g();
                }
            });
        }
    }

    public void k(LyricView lyricView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) lyricView);
            return;
        }
        this.f243186b = lyricView.b();
        this.f243187c = lyricView.a();
        this.f243186b.setScrollListener(this.f243199o);
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Log.d("ModuleController", "start");
        com.tencent.mobileqq.lyric.util.a.a().post(new Runnable() { // from class: com.tencent.mobileqq.lyric.widget.LyricViewController.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LyricViewController.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                LyricViewInternal lyricViewInternal = LyricViewController.this.f243187c;
                if (lyricViewInternal != null) {
                    lyricViewInternal.q();
                }
            }
        });
        this.f243197m.c(this.f243185a, 100L, 100L, this.f243200p);
        this.f243195k = true;
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Log.d("ModuleController", "stop");
        this.f243197m.a(this.f243185a);
        this.f243189e = 0L;
        this.f243195k = false;
    }
}
