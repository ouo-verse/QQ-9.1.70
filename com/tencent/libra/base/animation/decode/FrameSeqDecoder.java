package com.tencent.libra.base.animation.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;
import t01.d;
import t01.f;
import u01.c;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class FrameSeqDecoder<R extends d, W extends f> {

    /* renamed from: u, reason: collision with root package name */
    private static final String f118591u = "FrameSeqDecoder";

    /* renamed from: v, reason: collision with root package name */
    private static final Rect f118592v = new Rect();

    /* renamed from: a, reason: collision with root package name */
    private final int f118593a;

    /* renamed from: b, reason: collision with root package name */
    private final c f118594b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f118595c;

    /* renamed from: f, reason: collision with root package name */
    private int f118598f;

    /* renamed from: o, reason: collision with root package name */
    protected ByteBuffer f118607o;

    /* renamed from: p, reason: collision with root package name */
    protected volatile Rect f118608p;

    /* renamed from: d, reason: collision with root package name */
    protected List<com.tencent.libra.base.animation.decode.a> f118596d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    protected int f118597e = -1;

    /* renamed from: g, reason: collision with root package name */
    private Integer f118599g = null;

    /* renamed from: h, reason: collision with root package name */
    private Set<a> f118600h = new HashSet();

    /* renamed from: i, reason: collision with root package name */
    private AtomicBoolean f118601i = new AtomicBoolean(true);

    /* renamed from: j, reason: collision with root package name */
    private Runnable f118602j = new Runnable() { // from class: com.tencent.libra.base.animation.decode.FrameSeqDecoder.1
        @Override // java.lang.Runnable
        public void run() {
            if (FrameSeqDecoder.this.f118601i.get()) {
                return;
            }
            if (FrameSeqDecoder.this.p()) {
                long currentTimeMillis = System.currentTimeMillis();
                FrameSeqDecoder.this.f118595c.postDelayed(this, Math.max(0L, FrameSeqDecoder.this.P() - (System.currentTimeMillis() - currentTimeMillis)));
                Iterator it = FrameSeqDecoder.this.f118600h.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).onRender(FrameSeqDecoder.this.f118607o);
                }
                return;
            }
            FrameSeqDecoder.this.Q();
        }
    };

    /* renamed from: k, reason: collision with root package name */
    protected int f118603k = 1;

    /* renamed from: l, reason: collision with root package name */
    private Set<Bitmap> f118604l = new HashSet();

    /* renamed from: m, reason: collision with root package name */
    private final Object f118605m = new Object();

    /* renamed from: n, reason: collision with root package name */
    protected Map<Bitmap, Canvas> f118606n = new WeakHashMap();

    /* renamed from: q, reason: collision with root package name */
    private W f118609q = A();

    /* renamed from: r, reason: collision with root package name */
    private R f118610r = null;

    /* renamed from: s, reason: collision with root package name */
    private boolean f118611s = false;

    /* renamed from: t, reason: collision with root package name */
    private volatile State f118612t = State.IDLE;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum State {
        IDLE,
        RUNNING,
        INITIALIZING,
        FINISHING
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface a {
        void onEnd();

        void onRender(ByteBuffer byteBuffer);

        void onStart();
    }

    public FrameSeqDecoder(c cVar, @Nullable a aVar) {
        this.f118594b = cVar;
        if (aVar != null) {
            this.f118600h.add(aVar);
        }
        int a16 = s01.a.b().a();
        this.f118593a = a16;
        this.f118595c = new Handler(s01.a.b().c(a16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(Rect rect) {
        this.f118608p = rect;
        int width = rect.width() * rect.height();
        int i3 = this.f118603k;
        this.f118607o = ByteBuffer.allocate(((width / (i3 * i3)) + 1) * 4);
        if (this.f118609q == null) {
            this.f118609q = A();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void C() {
        this.f118601i.compareAndSet(true, false);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.f118596d.size() == 0) {
                try {
                    R r16 = this.f118610r;
                    if (r16 == null) {
                        this.f118610r = y(this.f118594b.obtain());
                    } else {
                        r16.reset();
                    }
                    B(G(this.f118610r));
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
            String str = f118591u;
            Log.i(str, q() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - currentTimeMillis));
            this.f118612t = State.RUNNING;
            if (x() != 0 && this.f118611s) {
                Log.i(str, q() + " No need to started");
                return;
            }
            this.f118597e = -1;
            this.f118602j.run();
            Iterator<a> it = this.f118600h.iterator();
            while (it.hasNext()) {
                it.next().onStart();
            }
        } catch (Throwable th6) {
            Log.i(f118591u, q() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - currentTimeMillis));
            this.f118612t = State.RUNNING;
            throw th6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void D() {
        this.f118595c.removeCallbacks(this.f118602j);
        this.f118596d.clear();
        synchronized (this.f118605m) {
            for (Bitmap bitmap : this.f118604l) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
            this.f118604l.clear();
        }
        if (this.f118607o != null) {
            this.f118607o = null;
        }
        this.f118606n.clear();
        try {
            R r16 = this.f118610r;
            if (r16 != null) {
                r16.close();
                this.f118610r = null;
            }
            W w3 = this.f118609q;
            if (w3 != null) {
                w3.close();
            }
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        I();
        this.f118612t = State.IDLE;
        Iterator<a> it = this.f118600h.iterator();
        while (it.hasNext()) {
            it.next().onEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public long P() {
        int i3 = this.f118597e + 1;
        this.f118597e = i3;
        if (i3 >= v()) {
            this.f118597e = 0;
            this.f118598f++;
        }
        com.tencent.libra.base.animation.decode.a u16 = u(this.f118597e);
        if (u16 == null) {
            return 0L;
        }
        K(u16);
        return u16.f118622f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        if (!E() || this.f118596d.size() == 0) {
            return false;
        }
        if (x() <= 0 || this.f118598f < x() - 1) {
            return true;
        }
        if (this.f118598f == x() - 1 && this.f118597e < v() - 1) {
            return true;
        }
        this.f118611s = true;
        return false;
    }

    private String q() {
        return "";
    }

    private int x() {
        Integer num = this.f118599g;
        if (num != null) {
            return num.intValue();
        }
        return w();
    }

    protected abstract W A();

    public boolean E() {
        if (this.f118612t != State.RUNNING && this.f118612t != State.INITIALIZING) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap F(int i3, int i16) {
        synchronized (this.f118605m) {
            Iterator<Bitmap> it = this.f118604l.iterator();
            Bitmap bitmap = null;
            while (it.hasNext()) {
                int i17 = i3 * i16 * 4;
                Bitmap next = it.next();
                if (next != null && next.getAllocationByteCount() >= i17) {
                    it.remove();
                    if ((next.getWidth() != i3 || next.getHeight() != i16) && i3 > 0 && i16 > 0) {
                        next.reconfigure(i3, i16, Bitmap.Config.ARGB_8888);
                    }
                    next.eraseColor(0);
                    return next;
                }
                bitmap = next;
            }
            if (i3 <= 0 || i16 <= 0) {
                return null;
            }
            try {
                bitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            } catch (Exception e16) {
                e16.printStackTrace();
            } catch (OutOfMemoryError e17) {
                e17.printStackTrace();
            }
            return bitmap;
        }
    }

    protected abstract Rect G(R r16) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public void H(Bitmap bitmap) {
        synchronized (this.f118605m) {
            if (bitmap != null) {
                if (!this.f118604l.contains(bitmap)) {
                    this.f118604l.add(bitmap);
                }
            }
        }
    }

    protected abstract void I();

    public void J(final a aVar) {
        this.f118595c.post(new Runnable() { // from class: com.tencent.libra.base.animation.decode.FrameSeqDecoder.3
            @Override // java.lang.Runnable
            public void run() {
                FrameSeqDecoder.this.f118600h.remove(aVar);
            }
        });
    }

    protected abstract void K(com.tencent.libra.base.animation.decode.a aVar);

    public void L() {
        this.f118595c.post(new Runnable() { // from class: com.tencent.libra.base.animation.decode.FrameSeqDecoder.8
            @Override // java.lang.Runnable
            public void run() {
                FrameSeqDecoder.this.f118598f = 0;
                FrameSeqDecoder frameSeqDecoder = FrameSeqDecoder.this;
                frameSeqDecoder.f118597e = -1;
                frameSeqDecoder.f118611s = false;
            }
        });
    }

    public boolean M(int i3, int i16) {
        int s16 = s(i3, i16);
        if (s16 != this.f118603k) {
            this.f118603k = s16;
            final boolean E = E();
            this.f118595c.removeCallbacks(this.f118602j);
            this.f118595c.post(new Runnable() { // from class: com.tencent.libra.base.animation.decode.FrameSeqDecoder.9
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    FrameSeqDecoder.this.D();
                    try {
                        FrameSeqDecoder frameSeqDecoder = FrameSeqDecoder.this;
                        frameSeqDecoder.B(frameSeqDecoder.G(frameSeqDecoder.y(frameSeqDecoder.f118594b.obtain())));
                        if (E) {
                            FrameSeqDecoder.this.C();
                        }
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                }
            });
            return true;
        }
        return false;
    }

    public void N(int i3) {
        this.f118599g = Integer.valueOf(i3);
    }

    public void O() {
        if (this.f118608p == f118592v) {
            return;
        }
        if (this.f118612t != State.RUNNING) {
            State state = this.f118612t;
            State state2 = State.INITIALIZING;
            if (state != state2) {
                if (this.f118612t == State.FINISHING) {
                    Log.e(f118591u, q() + " Processing,wait for finish at " + this.f118612t);
                }
                this.f118612t = state2;
                if (Looper.myLooper() == this.f118595c.getLooper()) {
                    C();
                    return;
                } else {
                    this.f118595c.post(new Runnable() { // from class: com.tencent.libra.base.animation.decode.FrameSeqDecoder.6
                        @Override // java.lang.Runnable
                        public void run() {
                            FrameSeqDecoder.this.C();
                        }
                    });
                    return;
                }
            }
        }
        Log.i(f118591u, q() + " Already started");
    }

    public void Q() {
        if (this.f118608p == f118592v) {
            return;
        }
        State state = this.f118612t;
        State state2 = State.FINISHING;
        if (state != state2 && this.f118612t != State.IDLE) {
            if (this.f118612t == State.INITIALIZING) {
                Log.e(f118591u, q() + "Processing,wait for finish at " + this.f118612t);
            }
            this.f118612t = state2;
            if (Looper.myLooper() == this.f118595c.getLooper()) {
                D();
                return;
            } else {
                this.f118595c.post(new Runnable() { // from class: com.tencent.libra.base.animation.decode.FrameSeqDecoder.7
                    @Override // java.lang.Runnable
                    public void run() {
                        FrameSeqDecoder.this.D();
                    }
                });
                return;
            }
        }
        Log.i(f118591u, q() + "No need to stop");
    }

    public void R() {
        this.f118595c.post(new Runnable() { // from class: com.tencent.libra.base.animation.decode.FrameSeqDecoder.4
            @Override // java.lang.Runnable
            public void run() {
                if (FrameSeqDecoder.this.f118600h.size() == 0) {
                    FrameSeqDecoder.this.Q();
                }
            }
        });
    }

    public void o(final a aVar) {
        this.f118595c.post(new Runnable() { // from class: com.tencent.libra.base.animation.decode.FrameSeqDecoder.2
            @Override // java.lang.Runnable
            public void run() {
                FrameSeqDecoder.this.f118600h.add(aVar);
            }
        });
    }

    public Rect r() {
        if (this.f118608p == null) {
            if (this.f118612t == State.FINISHING) {
                Log.e(f118591u, "In finishing,do not interrupt");
            }
            final Thread currentThread = Thread.currentThread();
            this.f118595c.post(new Runnable() { // from class: com.tencent.libra.base.animation.decode.FrameSeqDecoder.5
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            if (FrameSeqDecoder.this.f118608p == null) {
                                if (FrameSeqDecoder.this.f118610r == null) {
                                    FrameSeqDecoder frameSeqDecoder = FrameSeqDecoder.this;
                                    frameSeqDecoder.f118610r = frameSeqDecoder.y(frameSeqDecoder.f118594b.obtain());
                                } else {
                                    FrameSeqDecoder.this.f118610r.reset();
                                }
                                FrameSeqDecoder frameSeqDecoder2 = FrameSeqDecoder.this;
                                frameSeqDecoder2.B(frameSeqDecoder2.G(frameSeqDecoder2.f118610r));
                            }
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            FrameSeqDecoder.this.f118608p = FrameSeqDecoder.f118592v;
                        }
                    } finally {
                        LockSupport.unpark(currentThread);
                    }
                }
            });
            LockSupport.park(currentThread);
        }
        if (this.f118608p == null) {
            return f118592v;
        }
        return this.f118608p;
    }

    protected int s(int i3, int i16) {
        int i17 = 1;
        if (i3 != 0 && i16 != 0) {
            int min = Math.min(r().width() / i3, r().height() / i16);
            while (true) {
                int i18 = i17 * 2;
                if (i18 > min) {
                    break;
                }
                i17 = i18;
            }
        }
        return i17;
    }

    public abstract int t();

    public com.tencent.libra.base.animation.decode.a u(int i3) {
        if (i3 >= 0 && i3 < this.f118596d.size()) {
            return this.f118596d.get(i3);
        }
        return null;
    }

    public int v() {
        return this.f118596d.size();
    }

    protected abstract int w();

    protected abstract R y(d dVar);

    public int z() {
        return this.f118603k;
    }
}
