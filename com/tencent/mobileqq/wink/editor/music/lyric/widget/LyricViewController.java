package com.tencent.mobileqq.wink.editor.music.lyric.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.wink.editor.music.lyric.common.TimerTaskManager;
import com.tencent.mobileqq.wink.editor.music.lyric.e;
import com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewScroll;
import com.tencent.mobileqq.wink.editor.music.lyric.widget.b;

/* compiled from: P */
/* loaded from: classes21.dex */
public class LyricViewController {

    /* renamed from: u, reason: collision with root package name */
    protected static final String f321015u = "task_name_lyric_draw_" + Math.random();

    /* renamed from: a, reason: collision with root package name */
    protected LyricViewScroll f321016a;

    /* renamed from: b, reason: collision with root package name */
    protected com.tencent.mobileqq.wink.editor.music.lyric.widget.a f321017b;

    /* renamed from: c, reason: collision with root package name */
    protected d73.b f321018c;

    /* renamed from: d, reason: collision with root package name */
    protected long f321019d;

    /* renamed from: e, reason: collision with root package name */
    protected volatile boolean f321020e;

    /* renamed from: f, reason: collision with root package name */
    protected int f321021f;

    /* renamed from: g, reason: collision with root package name */
    protected int f321022g;

    /* renamed from: h, reason: collision with root package name */
    private volatile int f321023h = 0;

    /* renamed from: i, reason: collision with root package name */
    private boolean f321024i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f321025j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f321026k = false;

    /* renamed from: l, reason: collision with root package name */
    protected int f321027l = 100;

    /* renamed from: m, reason: collision with root package name */
    protected TimerTaskManager f321028m = f73.b.b();

    /* renamed from: n, reason: collision with root package name */
    protected com.tencent.mobileqq.wink.editor.music.lyric.widget.b f321029n = new com.tencent.mobileqq.wink.editor.music.lyric.widget.b();

    /* renamed from: o, reason: collision with root package name */
    private LyricViewScroll.c f321030o = new a();

    /* renamed from: p, reason: collision with root package name */
    protected TimerTaskManager.TimerTaskRunnable f321031p = new TimerTaskManager.TimerTaskRunnable() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewController.2
        @Override // com.tencent.mobileqq.wink.editor.music.lyric.common.TimerTaskManager.TimerTaskRunnable
        public void e() {
            if (!isCancelled()) {
                LyricViewController.this.j(0, false);
            }
        }
    };

    /* renamed from: q, reason: collision with root package name */
    private int f321032q = 0;

    /* renamed from: r, reason: collision with root package name */
    private int f321033r = 0;

    /* renamed from: s, reason: collision with root package name */
    private Handler f321034s = new b(Looper.getMainLooper());

    /* renamed from: t, reason: collision with root package name */
    private boolean f321035t = false;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a implements LyricViewScroll.c {
        a() {
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewScroll.c
        public void a(int i3) {
            Log.d("ModuleController", "onScrolling() top => " + i3);
            LyricViewController.this.l(i3);
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewScroll.c
        public void b(int i3) {
            Log.d("ModuleController", "onScrollStop -> top:" + i3);
            LyricViewController.this.k(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 993323) {
                LyricViewController.this.s();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface c {
    }

    public LyricViewController(LyricView lyricView) {
        this.f321016a = lyricView.b();
        this.f321017b = lyricView.a();
        this.f321016a.setScrollListener(this.f321030o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i3, boolean z16) {
        if (!z16) {
            i3 = (int) e.a().c(false);
        }
        if (i3 > 0) {
            this.f321033r = i3;
        }
        i(this.f321033r);
    }

    public float e(float f16) {
        if (this.f321016a != null) {
            return r0.getScrollY() + f16;
        }
        return f16;
    }

    public int f() {
        return this.f321023h;
    }

    public void g(final int i3) {
        if (Thread.currentThread().equals(Looper.getMainLooper().getThread())) {
            i(i3);
        } else {
            f73.b.a().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewController.5
                @Override // java.lang.Runnable
                public void run() {
                    LyricViewController.this.i(i3);
                }
            });
        }
    }

    protected void h(final int i3, final int i16) {
        f73.b.a().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewController.6
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.mobileqq.wink.editor.music.lyric.widget.a aVar = LyricViewController.this.f321017b;
                if (aVar != null) {
                    aVar.e(i3, i16);
                }
                LyricViewController lyricViewController = LyricViewController.this;
                if (lyricViewController.f321016a != null && lyricViewController.f321017b != null) {
                    if (lyricViewController.f321035t) {
                        ms.a.a("ModuleController", "current is selecting lyric. not auto scroll.");
                        return;
                    }
                    int d16 = LyricViewController.this.f321017b.d();
                    if (LyricViewController.this.f321032q == d16) {
                        return;
                    }
                    if (d16 == 0) {
                        LyricViewController.this.f321016a.f(d16);
                    } else {
                        LyricViewController.this.f321016a.g(d16);
                    }
                }
            }
        });
    }

    public void i(int i3) {
        int i16;
        int i17;
        d73.b c16 = this.f321017b.c();
        this.f321018c = c16;
        if (c16 != null && !c16.k()) {
            if (this.f321020e && (i17 = this.f321021f) > 0) {
                i3 += i17;
            }
            if (this.f321020e && i3 >= (i16 = this.f321022g)) {
                i3 = i16;
            }
            this.f321023h = i3;
            h(c16.c(i3), i3);
        }
    }

    protected void k(int i3) {
        int i16;
        int i17;
        int i18;
        if (this.f321018c != null || this.f321017b != null) {
            com.tencent.mobileqq.wink.editor.music.lyric.widget.a aVar = this.f321017b;
            if (aVar != null) {
                i16 = aVar.b(i3);
            } else {
                i16 = -1;
            }
            d73.b bVar = this.f321018c;
            if (bVar != null && !bVar.k()) {
                if (i16 == this.f321018c.f393162b.size() - 1) {
                    com.tencent.mobileqq.wink.editor.music.lyric.widget.a aVar2 = this.f321017b;
                    if (aVar2 != null) {
                        i18 = aVar2.f();
                    } else {
                        i18 = 0;
                    }
                    if (this.f321016a != null) {
                        Log.d("ModuleController", "onScrollStop() endTop => " + i18);
                        this.f321016a.smoothScrollTo(0, i18);
                    }
                    if (this.f321029n != null) {
                        this.f321029n.b(this.f321018c.f393162b.get(i16).f393181b, i18);
                        return;
                    }
                    return;
                }
                Log.d("ModuleController", "onScrollStop -> scroll to lineNo\uff1a" + i16);
                if (i16 >= 0 && i16 < this.f321018c.f393162b.size()) {
                    if (this.f321018c.f393162b.get(i16) == null) {
                        Log.w("ModuleController", "onScrollStop -> current sentence is null");
                        return;
                    }
                    long j3 = this.f321018c.f393162b.get(i16).f393181b;
                    Log.d("ModuleController", "onScrollStop -> start time of current sentence\uff1a" + j3);
                    if (this.f321020e && (((i17 = this.f321021f) >= 0 && j3 < i17) || ((i17 = this.f321022g) >= 0 && j3 > i17))) {
                        j3 = i17;
                    }
                    Log.d("ModuleController", "onScrollStop -> correct start time\uff1a" + j3);
                    if (j3 < 0) {
                        j3 = 0;
                    }
                    long j16 = ((j3 / 10) + 1) * 10;
                    Log.d("ModuleController", "onScrollStop -> output time\uff1a" + j16);
                    com.tencent.mobileqq.wink.editor.music.lyric.widget.b bVar2 = this.f321029n;
                    if (bVar2 != null) {
                        bVar2.a(j16);
                    }
                    if (!this.f321024i && this.f321026k) {
                        n((int) j16, false);
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

    protected void l(int i3) {
        int i16;
        int i17;
        if (this.f321018c != null || this.f321017b != null) {
            com.tencent.mobileqq.wink.editor.music.lyric.widget.a aVar = this.f321017b;
            if (aVar != null) {
                i16 = aVar.a(i3);
            } else {
                i16 = -1;
            }
            d73.b bVar = this.f321018c;
            if (bVar != null && !bVar.k()) {
                if (i16 >= 0 && i16 < this.f321018c.f393162b.size()) {
                    if (this.f321018c.f393162b.get(i16) == null) {
                        Log.w("ModuleController", "onScrollStop -> current sentence is null");
                        return;
                    }
                    long j3 = this.f321018c.f393162b.get(i16).f393181b;
                    if (this.f321020e && (((i17 = this.f321021f) >= 0 && j3 < i17) || ((i17 = this.f321022g) >= 0 && j3 > i17))) {
                        j3 = i17;
                    }
                    if (j3 < 0) {
                        j3 = 0;
                    }
                    long j16 = ((j3 / 10) + 1) * 10;
                    int scrollY = this.f321016a.getScrollY();
                    ms.a.a("ModuleController", "onScrolling() scrollY => " + scrollY + ",position => " + j16 + ",lineNo:" + i16);
                    this.f321029n.b(j16, scrollY);
                    return;
                }
                Log.w("ModuleController", "onScrollStop -> scroll out of lyric scope");
                return;
            }
            Log.w("ModuleController", "onScrolling -> scroll without measured lyric");
        }
    }

    public void m(b.a aVar) {
        this.f321029n.c(aVar);
    }

    public void n(final int i3, final boolean z16) {
        f73.b.a().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewController.4
            @Override // java.lang.Runnable
            public void run() {
                LyricViewController lyricViewController;
                int i16;
                d73.b bVar = LyricViewController.this.f321018c;
                if (bVar != null && !bVar.k()) {
                    LyricViewController.this.f321019d = SystemClock.elapsedRealtime() - i3;
                    if (LyricViewController.this.f321020e && (i16 = (lyricViewController = LyricViewController.this).f321021f) > 0) {
                        lyricViewController.f321019d -= i16;
                    }
                    LyricViewController.this.j(i3, z16);
                    return;
                }
                Log.w("ModuleController", "seek before set lyric");
            }
        });
    }

    public void o(boolean z16) {
        com.tencent.mobileqq.wink.editor.music.lyric.widget.a aVar = this.f321017b;
        if (aVar != null) {
            aVar.setEffectEnable(z16);
        }
    }

    public void p(final d73.b bVar, final d73.b bVar2, final d73.b bVar3) {
        Log.v("ModuleController", "setLyric begin");
        f73.b.a().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewController.3
            @Override // java.lang.Runnable
            public void run() {
                if (bVar3 == null) {
                    Log.d("ModuleController", "setLyric -> pronounce is null");
                }
                LyricViewController.this.f321025j = false;
                d73.b bVar4 = bVar;
                if (bVar4 == null) {
                    Log.d("ModuleController", "setLyric -> qrc is null");
                    LyricViewController.this.f321017b.setLyric(bVar2, bVar3);
                    LyricViewController.this.f321018c = bVar2;
                    return;
                }
                LyricViewController.this.f321017b.setLyric(bVar4, bVar3);
                LyricViewController.this.f321018c = bVar;
            }
        });
    }

    public void r(boolean z16) {
        this.f321035t = z16;
    }

    public void s() {
        Log.d("ModuleController", "stop");
        this.f321028m.a(f321015u);
        this.f321019d = 0L;
        this.f321024i = false;
    }

    public void q(c cVar) {
    }
}
