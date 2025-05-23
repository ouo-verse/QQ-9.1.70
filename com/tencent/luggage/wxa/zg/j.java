package com.tencent.luggage.wxa.zg;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Size;
import android.view.Surface;
import androidx.arch.core.util.Function;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.luggage.wxa.bh.c;
import com.tencent.luggage.wxa.d0.f;
import com.tencent.luggage.wxa.l0.g;
import com.tencent.luggage.wxa.l0.q;
import com.tencent.luggage.wxa.l0.r;
import com.tencent.luggage.wxa.m.e;
import com.tencent.luggage.wxa.m.p;
import com.tencent.luggage.wxa.m.u;
import com.tencent.luggage.wxa.n0.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.xg.i;
import com.tencent.luggage.wxa.z.b;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import cooperation.qzone.ShareElfFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class j extends com.tencent.luggage.wxa.xg.a {
    public static volatile boolean X = false;
    public HandlerThread A;
    public com.tencent.luggage.wxa.xg.i B;
    public int C;
    public int D;
    public int E;
    public boolean F;
    public boolean G;
    public volatile boolean H;
    public final AtomicBoolean I;
    public final AtomicBoolean J;
    public int K;
    public float L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public com.tencent.luggage.wxa.o.c T;
    public com.tencent.luggage.wxa.o.c U;
    public volatile boolean V;
    public volatile boolean W;

    /* renamed from: n, reason: collision with root package name */
    public Context f146657n;

    /* renamed from: o, reason: collision with root package name */
    public com.tencent.luggage.wxa.m.e f146658o;

    /* renamed from: p, reason: collision with root package name */
    public Surface f146659p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f146660q;

    /* renamed from: r, reason: collision with root package name */
    public h f146661r;

    /* renamed from: s, reason: collision with root package name */
    public com.tencent.luggage.wxa.d0.h f146662s;

    /* renamed from: t, reason: collision with root package name */
    public String f146663t;

    /* renamed from: u, reason: collision with root package name */
    public List f146664u;

    /* renamed from: v, reason: collision with root package name */
    public e.a f146665v;

    /* renamed from: w, reason: collision with root package name */
    public e f146666w;

    /* renamed from: x, reason: collision with root package name */
    public com.tencent.luggage.wxa.zg.g f146667x;

    /* renamed from: y, reason: collision with root package name */
    public c.b f146668y;

    /* renamed from: z, reason: collision with root package name */
    public Handler f146669z;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (j.this) {
                j.this.n();
                j.this.notifyAll();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f146671a;

        public b(long j3) {
            this.f146671a = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.this.d()) {
                j.this.f146658o.a(this.f146671a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements i.c {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.xg.i.c
        public void a() {
            synchronized (j.this) {
                if (j.this.H) {
                    return;
                }
                if (j.this.d()) {
                    int c16 = j.this.f146658o.c();
                    if (c16 != 1) {
                        if (c16 == 2 || c16 == 3) {
                            int h16 = j.this.h();
                            if (h16 != j.this.E) {
                                j.this.a(h16);
                                j.this.E = h16;
                            }
                        } else if (c16 != 4) {
                        }
                    }
                    j.this.b(false);
                }
            }
        }

        public /* synthetic */ c(j jVar, a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f146674a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f146675b;

        public d(boolean z16, boolean z17) {
            this.f146674a = z16;
            this.f146675b = z17;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements com.tencent.luggage.wxa.d0.a, f.a {
        public e() {
        }

        @Override // com.tencent.luggage.wxa.d0.a
        public void a(com.tencent.luggage.wxa.l0.j jVar, int i3, int i16, com.tencent.luggage.wxa.m.j jVar2, int i17, Object obj, long j3, long j16, long j17) {
            w.a("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadStarted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", jVar, Integer.valueOf(i16), jVar2, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
        }

        @Override // com.tencent.luggage.wxa.d0.a
        public void b(com.tencent.luggage.wxa.l0.j jVar, int i3, int i16, com.tencent.luggage.wxa.m.j jVar2, int i17, Object obj, long j3, long j16, long j17, long j18, long j19) {
            w.a("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadCompleted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", jVar, Integer.valueOf(i16), jVar2, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
        }

        @Override // com.tencent.luggage.wxa.d0.f.a
        public void onLoadError(IOException iOException) {
            j.this.f146667x.onLoadError(iOException);
            j.this.e();
            j.this.q();
        }

        public /* synthetic */ e(j jVar, a aVar) {
            this();
        }

        @Override // com.tencent.luggage.wxa.d0.a
        public void a(com.tencent.luggage.wxa.l0.j jVar, int i3, int i16, com.tencent.luggage.wxa.m.j jVar2, int i17, Object obj, long j3, long j16, long j17, long j18, long j19) {
            w.a("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadCanceled, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", jVar, Integer.valueOf(i16), jVar2, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
        }

        @Override // com.tencent.luggage.wxa.d0.a
        public void b() {
            j.this.f146667x.b();
        }

        @Override // com.tencent.luggage.wxa.d0.a
        public void a(com.tencent.luggage.wxa.l0.j jVar, int i3, int i16, com.tencent.luggage.wxa.m.j jVar2, int i17, Object obj, long j3, long j16, long j17, long j18, long j19, IOException iOException, boolean z16) {
            j.this.f146667x.a(jVar, i3, i16, jVar2, i17, obj, j3, j16, j17, j18, j19, iOException, z16);
            w.a("MicroMsg.SameLayer.ExoMediaPlayer", iOException, "onLoadError1, IOException, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s, loadDurationMs:%s, bytesLoaded:%s, wasCanceled:%s", jVar, Integer.valueOf(i16), jVar2, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19), Boolean.valueOf(z16));
            j.this.e();
            j.this.p();
        }

        @Override // com.tencent.luggage.wxa.d0.a
        public void a(int i3, com.tencent.luggage.wxa.m.j jVar, int i16, Object obj, long j3) {
            w.d("MicroMsg.SameLayer.ExoMediaPlayer", "[TRACE_ADAPTIVE] onDownstreamFormatChanged, trackType:%s, trackFormat:%s, mediaTimeMs:%s", Integer.valueOf(i3), jVar, Long.valueOf(j3));
            j.this.a(jVar.f133891a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f implements e.a {

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements Function {
            public a() {
            }

            @Override // androidx.arch.core.util.Function
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void apply(String str) {
                w.b("MicroMsg.SameLayer.ExoMediaPlayer", str);
                return null;
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class b implements Function {
            public b() {
            }

            @Override // androidx.arch.core.util.Function
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void apply(String str) {
                w.b("MicroMsg.SameLayer.ExoMediaPlayer", str);
                return null;
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class c implements Function {
            public c() {
            }

            @Override // androidx.arch.core.util.Function
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void apply(String str) {
                w.b("MicroMsg.SameLayer.ExoMediaPlayer", str);
                return null;
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class d implements Function {
            public d() {
            }

            @Override // androidx.arch.core.util.Function
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void apply(String str) {
                w.b("MicroMsg.SameLayer.ExoMediaPlayer", str);
                return null;
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class e implements Function {
            public e() {
            }

            @Override // androidx.arch.core.util.Function
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void apply(String str) {
                w.b("MicroMsg.SameLayer.ExoMediaPlayer", str);
                return null;
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.zg.j$f$f, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C6988f implements Function {
            public C6988f() {
            }

            @Override // androidx.arch.core.util.Function
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void apply(String str) {
                w.b("MicroMsg.SameLayer.ExoMediaPlayer", str);
                return null;
            }
        }

        public f() {
        }

        @Override // com.tencent.luggage.wxa.m.q.a
        public void a(u uVar, Object obj) {
            j.this.f146667x.a(uVar, obj);
        }

        public /* synthetic */ f(j jVar, a aVar) {
            this();
        }

        @Override // com.tencent.luggage.wxa.m.q.a
        public void a() {
            j.this.f146667x.a();
        }

        @Override // com.tencent.luggage.wxa.m.q.a
        public void a(com.tencent.luggage.wxa.d0.o oVar, com.tencent.luggage.wxa.k0.g gVar) {
            j.this.f146667x.a(oVar, gVar);
        }

        @Override // com.tencent.luggage.wxa.m.q.a
        public void a(p pVar) {
            j.this.f146667x.a(pVar);
        }

        @Override // com.tencent.luggage.wxa.m.q.a
        public void a(boolean z16) {
            j.this.f146667x.a(z16);
            if (z16) {
                j.this.b(true);
            }
        }

        @Override // com.tencent.luggage.wxa.m.q.a
        public void a(boolean z16, int i3) {
            j.this.f146667x.a(z16, i3);
            j.this.r();
        }

        @Override // com.tencent.luggage.wxa.m.q.a
        public void a(com.tencent.luggage.wxa.m.d dVar) {
            j.this.f146667x.a(dVar);
            if (j.this.d()) {
                j.this.b(false);
            }
            int i3 = -4999;
            if (dVar != null) {
                Throwable cause = dVar.getCause();
                if (cause != null) {
                    if (cause instanceof q.c) {
                        if (cause.toString().contains("Unable to connect")) {
                            boolean b16 = k.b(j.this.f146657n);
                            w.a("MicroMsg.SameLayer.ExoMediaPlayer", cause, "ExoPlaybackException hasNetwork=" + b16, new Object[0]);
                            if (!b16) {
                                j.this.a(-4000, -2);
                                return;
                            } else {
                                j.this.a(-4000, -3);
                                return;
                            }
                        }
                        if (cause instanceof q.d) {
                            String th5 = cause.toString();
                            if (th5.contains("403")) {
                                j.this.a(-4000, -10);
                                return;
                            }
                            if (th5.contains("404")) {
                                j.this.a(-4000, -11);
                                return;
                            }
                            if (th5.contains("500")) {
                                j.this.a(-4000, -12);
                                return;
                            } else if (th5.contains("502")) {
                                j.this.a(-4000, -13);
                                return;
                            } else {
                                j.this.a(-4000, -30);
                                return;
                            }
                        }
                        i3 = -4000;
                    } else {
                        if (cause instanceof com.tencent.luggage.wxa.d0.p) {
                            k.a(new a());
                            j.this.a(-4001, -1);
                            return;
                        }
                        if (cause instanceof IllegalStateException) {
                            k.a(new b());
                            j.this.a(-4002, -1);
                            return;
                        }
                        if (cause instanceof b.a) {
                            w.f("MicroMsg.SameLayer.ExoMediaPlayer", "onPlayError, error: " + k.a(dVar));
                            k.a(new c());
                            j.this.a(-4003, -1);
                            return;
                        }
                        if (cause instanceof r.f) {
                            k.a(new d());
                            j.this.a(-4004, -1);
                            return;
                        }
                    }
                }
                if (1 == dVar.f133817a) {
                    k.a(new e());
                    j.this.a(-4005, -1);
                    return;
                }
            }
            k.a(0, null, 30, new C6988f());
            j.this.a(i3, -1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements com.tencent.luggage.wxa.o0.g, com.tencent.luggage.wxa.n.e, com.tencent.luggage.wxa.a0.b, com.tencent.luggage.wxa.h0.b {
        public g() {
        }

        @Override // com.tencent.luggage.wxa.n.e
        public void a(com.tencent.luggage.wxa.o.c cVar) {
            j.this.f146667x.a(cVar);
            j.this.U = cVar;
        }

        @Override // com.tencent.luggage.wxa.n.e
        public void b(String str, long j3, long j16) {
            j.this.f146667x.b(str, j3, j16);
        }

        @Override // com.tencent.luggage.wxa.n.e
        public void c(com.tencent.luggage.wxa.o.c cVar) {
            j.this.f146667x.c(cVar);
            j.this.U = null;
        }

        @Override // com.tencent.luggage.wxa.o0.g
        public void d(com.tencent.luggage.wxa.o.c cVar) {
            j.this.f146667x.d(cVar);
            j.this.T = null;
        }

        public /* synthetic */ g(j jVar, a aVar) {
            this();
        }

        @Override // com.tencent.luggage.wxa.n.e
        public void b(com.tencent.luggage.wxa.m.j jVar) {
            j.this.f146667x.b(jVar);
        }

        @Override // com.tencent.luggage.wxa.n.e
        public void a(int i3) {
            j.this.f146667x.a(i3);
        }

        @Override // com.tencent.luggage.wxa.o0.g
        public void b(com.tencent.luggage.wxa.o.c cVar) {
            j.this.f146667x.b(cVar);
            j.this.T = cVar;
        }

        @Override // com.tencent.luggage.wxa.n.e
        public void a(int i3, long j3, long j16) {
            j.this.f146667x.a(i3, j3, j16);
        }

        @Override // com.tencent.luggage.wxa.o0.g
        public void a(String str, long j3, long j16) {
            j.this.f146667x.a(str, j3, j16);
        }

        @Override // com.tencent.luggage.wxa.o0.g
        public void a(com.tencent.luggage.wxa.m.j jVar) {
            j.this.f146667x.a(jVar);
        }

        @Override // com.tencent.luggage.wxa.o0.g
        public void a(int i3, long j3) {
            j.this.f146667x.a(i3, j3);
        }

        @Override // com.tencent.luggage.wxa.o0.g
        public void a(Surface surface) {
            j.this.f146667x.a(surface);
            j.this.b(3, 0);
        }

        @Override // com.tencent.luggage.wxa.o0.g
        public void a(int i3, int i16, int i17, float f16) {
            j.this.f146667x.a(i3, i16, i17, f16);
            Size a16 = j.this.a(i3, i16, i17, f16);
            int width = a16.getWidth();
            int height = a16.getHeight();
            j.this.C = width;
            j.this.D = height;
            j.this.c(width, height);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public int[] f146685a;

        public h() {
            this.f146685a = new int[]{1, 1, 1, 1};
        }

        public int a(boolean z16, int i3) {
            return (z16 ? ShareElfFile.SectionHeader.SHF_MASKPROC : 0) | i3;
        }

        public void b(boolean z16, int i3) {
            int a16 = a(z16, i3);
            w.d("MicroMsg.SameLayer.ExoMediaPlayer", "request setMostRecentState [" + z16 + "," + i3 + "], lastState=" + this.f146685a[3] + ", newState=" + a16);
            int[] iArr = this.f146685a;
            int i16 = iArr[3];
            if (i16 == a16) {
                return;
            }
            iArr[0] = iArr[1];
            iArr[1] = iArr[2];
            iArr[2] = i16;
            iArr[3] = a16;
            w.d("MicroMsg.SameLayer.ExoMediaPlayer", "new MostRecentState [" + this.f146685a[0] + "," + this.f146685a[1] + "," + this.f146685a[2] + "," + this.f146685a[3] + "]");
        }

        public void c() {
            this.f146685a = new int[]{1, 1, 1, 1};
        }

        public int a() {
            return this.f146685a[3];
        }

        public /* synthetic */ h(a aVar) {
            this();
        }

        public boolean a(int[] iArr, boolean z16) {
            int i3 = z16 ? 268435455 : -1;
            int length = this.f146685a.length - iArr.length;
            int i16 = length;
            boolean z17 = true;
            while (true) {
                int[] iArr2 = this.f146685a;
                if (i16 >= iArr2.length) {
                    return z17;
                }
                z17 &= (iArr2[i16] & i3) == (iArr[i16 - length] & i3);
                i16++;
            }
        }

        public boolean b() {
            return (this.f146685a[3] & ShareElfFile.SectionHeader.SHF_MASKPROC) != 0;
        }
    }

    public j(Handler handler) {
        this(handler, 0, 0.75f, 10000, 25000, 15000, 30000, 2500, 5000);
    }

    public abstract int a(Uri uri);

    public abstract g.a a(Map map);

    @Override // com.tencent.luggage.wxa.xg.g
    public int getCurrentPosition() {
        if (d()) {
            return (int) this.f146658o.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public int getDuration() {
        if (d()) {
            return (int) this.f146658o.getDuration();
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public int getPlayerType() {
        return 2;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public int getVideoHeight() {
        return this.D;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public int getVideoWidth() {
        return this.C;
    }

    public com.tencent.luggage.wxa.q.g i() {
        return new i();
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public boolean isPlaying() {
        if (!d()) {
            return false;
        }
        int c16 = this.f146658o.c();
        if (c16 != 1 && c16 != 2 && c16 != 3) {
            if (c16 != 4 || !this.F) {
                return false;
            }
            return true;
        }
        return this.f146658o.b();
    }

    public int j() {
        return this.P;
    }

    public int k() {
        return this.O;
    }

    public abstract com.tencent.luggage.wxa.mg.i l();

    public com.tencent.luggage.wxa.o.c m() {
        com.tencent.luggage.wxa.o.c cVar = this.T;
        if (cVar == null) {
            return k.f146687b;
        }
        return cVar;
    }

    public final void n() {
        w.d("MicroMsg.SameLayer.ExoMediaPlayer", "iniMediaPlayer");
        this.f146668y = new c.b(k.a(), this.K, this.M, this.N, 25000, this.L);
        com.tencent.luggage.wxa.k0.b bVar = new com.tencent.luggage.wxa.k0.b(this.f146668y);
        this.f146667x = new com.tencent.luggage.wxa.zg.g(bVar);
        com.tencent.luggage.wxa.m.c cVar = new com.tencent.luggage.wxa.m.c(new com.tencent.luggage.wxa.l0.k(true, 65536), this.O, this.P, this.Q, this.R);
        List list = this.f146664u;
        com.tencent.luggage.wxa.m.e a16 = com.tencent.luggage.wxa.m.f.a((com.tencent.luggage.wxa.m.r[]) list.toArray(new com.tencent.luggage.wxa.m.r[list.size()]), bVar, cVar);
        this.f146658o = a16;
        a16.b(this.f146665v);
    }

    public boolean o() {
        return this.F;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void pause() {
        if (d()) {
            this.f146658o.a(false);
            b(3);
        }
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void prepareAsync() {
        if (this.f146662s == null) {
            w.f("MicroMsg.SameLayer.ExoMediaPlayer", "prepareAsync, media source is null");
        } else if (d()) {
            this.f146658o.a(false);
            this.f146658o.a(this.f146662s);
            this.V = true;
        }
    }

    public final synchronized void r() {
        if (this.f146658o != null && !this.H) {
            int c16 = this.f146658o.c();
            boolean b16 = this.f146658o.b();
            int a16 = this.f146661r.a(b16, c16);
            if (a16 != this.f146661r.a()) {
                w.d("MicroMsg.SameLayer.ExoMediaPlayer", "reportPlayerState, set new recent state [" + b16 + "," + c16 + "]");
                this.f146661r.b(b16, c16);
                if (a16 == 3) {
                    b(true);
                } else if (a16 == 1 || a16 == 4) {
                    b(false);
                }
                if (a16 == this.f146661r.a(true, 4)) {
                    w.d("MicroMsg.SameLayer.ExoMediaPlayer", "reportPlayerState, isSeeking: %b, loopingPlaySeek: %b", Boolean.valueOf(this.J.get()), Boolean.valueOf(this.G));
                    if (this.J.getAndSet(false) && !this.G) {
                        c();
                    }
                    if (o()) {
                        w.d("MicroMsg.SameLayer.ExoMediaPlayer", "looping play start");
                        this.G = true;
                        a(0L);
                    } else {
                        b(6);
                        a();
                    }
                    return;
                }
                h hVar = this.f146661r;
                if (!hVar.a(new int[]{hVar.a(false, 1), this.f146661r.a(false, 2), this.f146661r.a(false, 3)}, false) && (!this.V || c16 != 3)) {
                    if (this.f146661r.a(new int[]{100, 2, 3}, true) | this.f146661r.a(new int[]{2, 100, 3}, true) | this.f146661r.a(new int[]{100, 3, 2, 3}, true)) {
                        if (!this.G) {
                            c();
                        } else {
                            this.G = false;
                        }
                        this.J.set(false);
                        return;
                    }
                    h hVar2 = this.f146661r;
                    if (hVar2.a(new int[]{hVar2.a(true, 3), this.f146661r.a(true, 2)}, false)) {
                        b(701, h());
                        return;
                    } else {
                        h hVar3 = this.f146661r;
                        if (hVar3.a(new int[]{hVar3.a(true, 2), this.f146661r.a(true, 3)}, false)) {
                            b(702, h());
                        }
                    }
                }
                b(2);
                b();
                this.V = false;
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xg.a, com.tencent.luggage.wxa.xg.g
    public void release() {
        this.H = true;
        if (d()) {
            b(false);
            if (d()) {
                this.f146658o.release();
                this.f146658o.a(this.f146665v);
                this.f146658o = null;
            }
            this.C = 0;
            this.D = 0;
            this.E = 0;
        }
        HandlerThread handlerThread = this.A;
        if (handlerThread != null) {
            handlerThread.quit();
            this.A = null;
        }
        Surface surface = this.f146659p;
        if (surface != null) {
            if (this.f146660q) {
                surface.release();
            }
            this.f146659p = null;
        }
        this.f144904c = null;
        this.f144905d = null;
        this.f144906e = null;
        this.f144907f = null;
        this.f144908g = null;
        this.f144909h = null;
        this.f144910i = null;
        b(-2);
        super.release();
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void reset() {
        if (d()) {
            b(false);
            if (d()) {
                this.f146658o.a(false);
                this.f146658o.stop();
            }
            this.F = false;
            this.E = 0;
            this.f146661r.c();
            b(0);
        }
    }

    public d s() {
        boolean z16;
        boolean z17;
        if (this.V) {
            if (this.S > 0) {
                z17 = true;
                z16 = false;
            } else if (!this.W) {
                z16 = true;
                z17 = false;
            }
            w.d("MicroMsg.SameLayer.ExoMediaPlayer", "statErrorPlayerNotFound, hasLoadError: %b, hasOtherError: %b", Boolean.valueOf(z17), Boolean.valueOf(z16));
            return new d(z17, z16);
        }
        z16 = false;
        z17 = false;
        w.d("MicroMsg.SameLayer.ExoMediaPlayer", "statErrorPlayerNotFound, hasLoadError: %b, hasOtherError: %b", Boolean.valueOf(z17), Boolean.valueOf(z16));
        return new d(z17, z16);
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void setMute(boolean z16) {
        if (d()) {
            if (z16) {
                a(0.0f, 0.0f);
            } else {
                a(1.0f, 1.0f);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void setSurface(Surface surface) {
        if (d()) {
            a(surface, false);
        }
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void start() {
        if (d()) {
            if (this.f146658o.c() == 4) {
                this.f146658o.a(0L);
            }
            this.f146658o.a(true);
            b(3);
            this.I.set(false);
        }
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void stop() {
        if (d() && !this.I.getAndSet(true)) {
            this.f146658o.a(false);
            this.f146658o.stop();
            b(5);
        }
    }

    public j(Handler handler, int i3, float f16, int i16, int i17, int i18, int i19, int i26, int i27) {
        this.f146663t = null;
        this.I = new AtomicBoolean();
        this.J = new AtomicBoolean(false);
        this.K = 0;
        this.L = 0.75f;
        this.M = 10000;
        this.N = 25000;
        this.O = 15000;
        this.P = 30000;
        this.Q = 2500;
        this.R = 5000;
        this.S = 0;
        this.T = null;
        this.U = null;
        this.V = false;
        this.W = false;
        w.d("MicroMsg.SameLayer.ExoMediaPlayer", "ExoMediaPlayer, handler = %s, maxInitBitrate = %s, bandFraction = %s, minDur = %s, maxDur = %s, minBuffer = %s, maxBuffer = %s, bufferForPlaybackMs:%s, bufferForPlaybackAfterRebufferMs:%s", handler, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27));
        a(i3, f16, i16, i17, i18, i19, i26, i27);
        a(handler);
    }

    public final void e() {
        w.a("MicroMsg.SameLayer.ExoMediaPlayer", "dispatchOnErrorWorkaroundWhenLoadErrorIfNeed");
        int i3 = this.S + 1;
        this.S = i3;
        if (6 > i3 || k.b(this.f146657n)) {
            return;
        }
        w.a("MicroMsg.SameLayer.ExoMediaPlayer", "dispatchOnErrorWorkaroundWhenLoadErrorIfNeed, notifyOnError");
        a(TXLiteAVCode.ERR_BGM_INVALID_URL, -2);
    }

    public com.tencent.luggage.wxa.o.c f() {
        com.tencent.luggage.wxa.o.c cVar = this.U;
        return cVar == null ? k.f146687b : cVar;
    }

    public int g() {
        return this.Q;
    }

    public final int h() {
        if (d()) {
            return this.f146658o.a();
        }
        return 0;
    }

    public final boolean d() {
        return this.f146658o != null;
    }

    public final void b(boolean z16) {
        w.a("MicroMsg.SameLayer.ExoMediaPlayer", "setBufferRepeaterStarted " + z16);
        if (z16 && this.f144909h != null) {
            this.B.a();
        } else {
            this.B.b();
        }
    }

    public final void a(Handler handler) {
        this.f146657n = z.c();
        a aVar = null;
        this.f146661r = new h(aVar);
        if (handler != null) {
            this.f146669z = handler;
        } else {
            HandlerThread b16 = com.tencent.luggage.wxa.cq.d.b("ExoMediaPlayer_HandlerThread", 5);
            this.A = b16;
            b16.start();
            this.f146669z = new Handler(this.A.getLooper());
        }
        this.f146665v = new f(this, aVar);
        this.f146666w = new e(this, aVar);
        com.tencent.luggage.wxa.xg.i iVar = new com.tencent.luggage.wxa.xg.i(this.f146669z);
        this.B = iVar;
        iVar.a(1000);
        this.B.a(new c(this, aVar));
        g gVar = new g(this, aVar);
        this.f146664u = new com.tencent.luggage.wxa.zg.f(this.f146657n, this.f146669z, gVar, gVar, gVar, gVar).a();
        if (handler != null && handler.getLooper() == Looper.myLooper()) {
            n();
            return;
        }
        this.f146669z.post(new a());
        synchronized (this) {
            while (this.f146658o == null) {
                try {
                    LockMethodProxy.wait(this);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void p() {
    }

    public void q() {
    }

    public final void a(int i3, float f16, int i16, int i17, int i18, int i19, int i26, int i27) {
        this.K = 0;
        this.L = f16;
        this.M = i16;
        this.N = i17;
        this.O = i18;
        this.P = i19;
        this.Q = i26;
        this.R = i27;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public com.tencent.luggage.wxa.xg.g a(Class cls) {
        j jVar = j.class.isAssignableFrom(cls) ? this : null;
        w.d("MicroMsg.SameLayer.ExoMediaPlayer", "castTo, playerClass: %s, playerImpl: %s", cls, jVar);
        return jVar;
    }

    @Override // com.tencent.luggage.wxa.xg.a, com.tencent.luggage.wxa.xg.g
    public void a(double d16) {
        this.f146668y.a(d16);
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(String str, String str2) {
        a(str, str2, 0);
    }

    public void a(String str, String str2, int i3) {
        this.f146662s = a(Uri.parse(str), str2, "", i3);
        this.f146663t = str;
        this.S = 0;
        b(1);
    }

    public final com.tencent.luggage.wxa.d0.h a(Uri uri, String str, String str2, int i3) {
        int a16 = 2 == i3 ? 2 : a(uri);
        Map a17 = com.tencent.luggage.wxa.cg.d.a(str);
        if (a16 == 2) {
            w.d("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, type:HLS, url:%s", uri);
            return new com.tencent.luggage.wxa.f0.h(uri, k.a(this.f146657n, a17), this.f146669z, this.f146666w);
        }
        if (a16 != 3) {
            w.b("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, unsupported type:" + a16 + ", url:" + uri);
            return null;
        }
        w.d("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, type:other, url:%s", uri);
        if (str2 != null && str2.length() > 0) {
            w.d("MicroMsg.SameLayer.ExoMediaPlayer", "[TRACE_VIDEO_PRELOAD] buildMediaSource with cutomkey = %s", str2);
            return new com.tencent.luggage.wxa.d0.f(uri, a(a17), i(), this.f146669z, this.f146666w, str2);
        }
        return new com.tencent.luggage.wxa.d0.f(uri, a(a17), i(), this.f146669z, this.f146666w);
    }

    public final void a(Surface surface, boolean z16) {
        if (d()) {
            Surface surface2 = this.f146659p;
            if (surface2 != null && surface2 != surface && surface != null) {
                if (this.f146660q) {
                    surface2.release();
                }
                a(2, 1, (Object) surface, true);
                long currentPosition = this.f146658o.getCurrentPosition();
                if (v.f135103a < 23) {
                    this.f146669z.postDelayed(new b(currentPosition), 200L);
                }
            } else {
                a(2, 1, (Object) surface, false);
            }
            this.f146659p = surface;
            this.f146660q = z16;
        }
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public boolean a(float f16) {
        if (!d()) {
            return false;
        }
        this.f146658o.a(new p(f16, 1.0f));
        return true;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(float f16, float f17) {
        a(1, 2, Float.valueOf(f16));
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(boolean z16) {
        this.F = z16;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(long j3) {
        if (d()) {
            this.f146658o.a(j3);
            h hVar = this.f146661r;
            hVar.b(hVar.b(), 100);
            this.J.set(true);
        }
    }

    @Override // com.tencent.luggage.wxa.xg.a
    public boolean a(int i3, int i16) {
        boolean a16 = super.a(i3, i16);
        com.tencent.luggage.wxa.mg.i l3 = l();
        if (l3 != null) {
            l3.d(this.f146663t);
        }
        this.W = true;
        this.S = 0;
        return a16;
    }

    public final Size a(int i3, int i16, int i17, float f16) {
        if (!X) {
            return new Size(i3, i16);
        }
        return new Size((int) (f16 * i3), i16);
    }

    public final void a(int i3, int i16, Object obj) {
        a(i3, i16, obj, false);
    }

    public final void a(int i3, int i16, Object obj, boolean z16) {
        if (this.f146664u.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (com.tencent.luggage.wxa.m.r rVar : this.f146664u) {
            if (rVar.a() == i3) {
                arrayList.add(new e.c(rVar, i16, obj));
            }
        }
        if (z16) {
            this.f146658o.b((e.c[]) arrayList.toArray(new e.c[arrayList.size()]));
        } else {
            this.f146658o.a((e.c[]) arrayList.toArray(new e.c[arrayList.size()]));
        }
    }
}
