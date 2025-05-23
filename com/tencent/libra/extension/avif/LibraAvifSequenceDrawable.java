package com.tencent.libra.extension.avif;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libavif.AvifDecoder;
import com.tencent.libavif.AvifImage;
import com.tencent.thread.monitor.plugin.proxy.BaseScheduledThreadPoolExecutor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LibraAvifSequenceDrawable extends Drawable implements r01.c {
    private static final d U = new a();
    private ScheduledFuture<?> C;
    private AvifDecoder D;
    private final Paint E;
    private Rect F;
    private Rect G;
    private int H;
    private final Object I;
    private d J;
    private boolean K;
    private Bitmap L;
    private int M;
    private int N;
    private int P;
    private final Runnable Q;
    private final Runnable R;
    private boolean S;
    private int T;

    /* renamed from: d, reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f118710d;

    /* renamed from: e, reason: collision with root package name */
    private final Handler f118711e;

    /* renamed from: f, reason: collision with root package name */
    private int f118712f;

    /* renamed from: h, reason: collision with root package name */
    private int f118713h;

    /* renamed from: i, reason: collision with root package name */
    private long f118714i;

    /* renamed from: m, reason: collision with root package name */
    boolean f118715m;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements d {
        a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            LibraAvifSequenceDrawable.this.invalidateSelf();
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static final class c extends BaseScheduledThreadPoolExecutor {

        /* renamed from: d, reason: collision with root package name */
        private static final c f118717d = new c();

        c() {
            super(1, new ThreadPoolExecutor.DiscardPolicy());
        }

        static c a() {
            return f118717d;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface d {
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface e {
    }

    public LibraAvifSequenceDrawable(AvifDecoder avifDecoder) {
        this(avifDecoder, U);
    }

    static /* synthetic */ e e(LibraAvifSequenceDrawable libraAvifSequenceDrawable) {
        libraAvifSequenceDrawable.getClass();
        return null;
    }

    static /* synthetic */ int h(LibraAvifSequenceDrawable libraAvifSequenceDrawable) {
        int i3 = libraAvifSequenceDrawable.T;
        libraAvifSequenceDrawable.T = i3 + 1;
        return i3;
    }

    static /* synthetic */ int o(LibraAvifSequenceDrawable libraAvifSequenceDrawable) {
        int i3 = libraAvifSequenceDrawable.M;
        libraAvifSequenceDrawable.M = i3 + 1;
        return i3;
    }

    private void u() {
        if (this.K) {
            RFWLog.fatal("LibraAvifSequenceDrawable", RFWLog.USR, new IllegalStateException("Cannot perform operation on recycled drawable"));
        }
    }

    private void v() {
        synchronized (this.I) {
            if (this.f118715m) {
                return;
            }
            this.f118715m = true;
            u();
            this.f118714i = SystemClock.uptimeMillis();
            this.M = 0;
            this.T = 0;
            x();
        }
    }

    private void w() {
        synchronized (this.I) {
            if (!this.f118715m) {
                return;
            }
            this.f118715m = false;
            ScheduledFuture<?> scheduledFuture = this.C;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.M = 0;
        }
    }

    private void x() {
        if (isRunning()) {
            long j3 = this.f118714i;
            if (j3 != Long.MIN_VALUE) {
                long max = Math.max(0L, j3 - SystemClock.uptimeMillis());
                this.f118714i = Long.MIN_VALUE;
                this.f118710d.remove(this.Q);
                this.C = this.f118710d.schedule(this.Q, max, TimeUnit.MILLISECONDS);
            }
        }
    }

    @Override // r01.c
    public /* synthetic */ void c(boolean z16) {
        r01.b.i(this, z16);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* synthetic */ void clearAnimationCallbacks() {
        r01.b.b(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        synchronized (this.I) {
            int i3 = this.H;
            if (i3 != 0) {
                Gravity.apply(i3, this.L.getWidth(), this.L.getHeight(), getBounds(), this.G);
                canvas.drawBitmap(this.L, this.F, this.G, this.E);
            } else {
                canvas.drawBitmap(this.L, this.F, getBounds(), this.E);
            }
        }
    }

    @Override // r01.c
    public /* synthetic */ Drawable getDrawable() {
        return r01.b.c(this);
    }

    @Override // r01.c
    public /* synthetic */ int getDuration() {
        return r01.b.d(this);
    }

    @Override // r01.c
    public /* synthetic */ int getFrameCount() {
        return r01.b.f(this);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f118713h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f118712f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // r01.c
    public /* synthetic */ void i(int i3) {
        r01.b.j(this, i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        x();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        boolean z16;
        synchronized (this.I) {
            if (this.f118715m && !this.K) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    @Override // r01.c
    public /* synthetic */ int l() {
        return r01.b.e(this);
    }

    @Override // r01.c
    public /* synthetic */ void r(r01.d dVar) {
        r01.b.a(this, dVar);
    }

    @Override // r01.c
    public /* synthetic */ void recycle() {
        r01.b.g(this);
    }

    @Override // r01.c, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* synthetic */ void registerAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        r01.b.h(this, animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.E.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.E.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z16) {
        this.E.setFilterBitmap(z16);
    }

    @Override // r01.c
    public void setLoopCount(int i3) {
        this.P = i3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z16, boolean z17) {
        boolean visible = super.setVisible(z16, z17);
        if (z16) {
            if (z17) {
                w();
                start();
            } else if (this.S) {
                v();
            }
        } else {
            w();
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.S = true;
        v();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.S = false;
        w();
    }

    @Override // r01.c, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* synthetic */ boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        return r01.b.k(this, animationCallback);
    }

    public LibraAvifSequenceDrawable(AvifDecoder avifDecoder, d dVar) {
        this.f118710d = c.a();
        this.f118711e = new b(Looper.getMainLooper());
        this.f118714i = Long.MIN_VALUE;
        this.f118715m = false;
        this.E = new Paint(2);
        this.I = new Object();
        this.K = false;
        this.N = 1;
        this.P = 1;
        this.Q = new Runnable() { // from class: com.tencent.libra.extension.avif.LibraAvifSequenceDrawable.3
            /* JADX WARN: Removed duplicated region for block: B:24:0x00a6  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x00ac  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00c6 A[Catch: all -> 0x010f, TryCatch #2 {, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x0019, B:11:0x0030, B:12:0x0058, B:15:0x005a, B:17:0x005f, B:20:0x0069, B:25:0x00a8, B:28:0x00b0, B:30:0x00c6, B:32:0x00d3, B:34:0x00e1, B:35:0x00ec, B:37:0x00ee, B:38:0x00f3, B:39:0x00fc, B:41:0x00af, B:44:0x0081, B:47:0x00fe, B:48:0x010d), top: B:3:0x0009 }] */
            /* JADX WARN: Removed duplicated region for block: B:41:0x00af A[Catch: all -> 0x010f, TryCatch #2 {, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x0019, B:11:0x0030, B:12:0x0058, B:15:0x005a, B:17:0x005f, B:20:0x0069, B:25:0x00a8, B:28:0x00b0, B:30:0x00c6, B:32:0x00d3, B:34:0x00e1, B:35:0x00ec, B:37:0x00ee, B:38:0x00f3, B:39:0x00fc, B:41:0x00af, B:44:0x0081, B:47:0x00fe, B:48:0x010d), top: B:3:0x0009 }] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                long j3;
                boolean z16;
                long j16;
                synchronized (LibraAvifSequenceDrawable.this.I) {
                    LibraAvifSequenceDrawable libraAvifSequenceDrawable = LibraAvifSequenceDrawable.this;
                    if (libraAvifSequenceDrawable.f118715m && !libraAvifSequenceDrawable.K) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        int o16 = LibraAvifSequenceDrawable.this.D.o(LibraAvifSequenceDrawable.this.T);
                        if (o16 != 0) {
                            RFWLog.e("LibraAvifSequenceDrawable", RFWLog.USR, "[DecodeTask] return, decode fail: code=", Integer.valueOf(o16), ", currentFrameIndex=", Integer.valueOf(LibraAvifSequenceDrawable.this.T));
                            return;
                        }
                        LibraAvifSequenceDrawable.h(LibraAvifSequenceDrawable.this);
                        try {
                            j3 = LibraAvifSequenceDrawable.this.D.i();
                            try {
                                LibraAvifSequenceDrawable libraAvifSequenceDrawable2 = LibraAvifSequenceDrawable.this;
                                libraAvifSequenceDrawable2.L = libraAvifSequenceDrawable2.D.g().d(true);
                                z16 = false;
                            } catch (Exception e16) {
                                e = e16;
                                RFWLog.e("LibraAvifSequenceDrawable", RFWLog.USR, "exception during decode: " + e);
                                z16 = true;
                                if (j3 < 20) {
                                }
                                LibraAvifSequenceDrawable libraAvifSequenceDrawable3 = LibraAvifSequenceDrawable.this;
                                if (!z16) {
                                }
                                libraAvifSequenceDrawable3.f118714i = j16;
                                if (LibraAvifSequenceDrawable.this.T >= LibraAvifSequenceDrawable.this.D.h() - 1) {
                                }
                                LibraAvifSequenceDrawable.this.f118711e.sendEmptyMessage(0);
                                return;
                            }
                        } catch (Exception e17) {
                            e = e17;
                            j3 = 0;
                        }
                        if (j3 < 20) {
                            j3 = 100;
                        }
                        LibraAvifSequenceDrawable libraAvifSequenceDrawable32 = LibraAvifSequenceDrawable.this;
                        if (!z16) {
                            j16 = Long.MIN_VALUE;
                        } else {
                            j16 = uptimeMillis + j3;
                        }
                        libraAvifSequenceDrawable32.f118714i = j16;
                        if (LibraAvifSequenceDrawable.this.T >= LibraAvifSequenceDrawable.this.D.h() - 1) {
                            LibraAvifSequenceDrawable.o(LibraAvifSequenceDrawable.this);
                            if (LibraAvifSequenceDrawable.this.N != 2 || LibraAvifSequenceDrawable.this.M != LibraAvifSequenceDrawable.this.P) {
                                LibraAvifSequenceDrawable.this.T = 0;
                            } else {
                                LibraAvifSequenceDrawable libraAvifSequenceDrawable4 = LibraAvifSequenceDrawable.this;
                                libraAvifSequenceDrawable4.scheduleSelf(libraAvifSequenceDrawable4.R, 0L);
                                return;
                            }
                        }
                        LibraAvifSequenceDrawable.this.f118711e.sendEmptyMessage(0);
                        return;
                    }
                    RFWLog.e("LibraAvifSequenceDrawable", RFWLog.USR, "DecodeTask return, drawable not running or destroyed");
                }
            }
        };
        this.R = new Runnable() { // from class: com.tencent.libra.extension.avif.LibraAvifSequenceDrawable.4
            @Override // java.lang.Runnable
            public void run() {
                LibraAvifSequenceDrawable.this.stop();
                LibraAvifSequenceDrawable.e(LibraAvifSequenceDrawable.this);
            }
        };
        if (avifDecoder != null && dVar != null) {
            this.D = avifDecoder;
            avifDecoder.n();
            AvifImage g16 = avifDecoder.g();
            this.f118712f = g16.h();
            int g17 = g16.g();
            this.f118713h = g17;
            this.J = dVar;
            this.L = avifDecoder.k(this.f118712f, g17).d(true);
            this.F = new Rect(0, 0, this.f118712f, this.f118713h);
            this.G = new Rect();
            this.H = 0;
            this.T++;
            return;
        }
        RFWLog.fatal("LibraAvifSequenceDrawable", RFWLog.USR, new IllegalArgumentException("avifDecoder = null || bitmapProvider = null"));
    }
}
