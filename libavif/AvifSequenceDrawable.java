package libavif;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.Gravity;
import androidx.annotation.NonNull;
import com.tencent.thread.monitor.plugin.proxy.BaseScheduledThreadPoolExecutor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes28.dex */
public class AvifSequenceDrawable extends Drawable implements Animatable {
    private static final d S = new a();
    private ScheduledFuture<?> C;
    private final AvifDecoder D;
    private final Paint E;
    private final Rect F;
    private final Rect G;
    private int H;
    private final Object I;
    private final d J;
    private boolean K;
    private final Bitmap L;
    private int M;
    private int N;
    private int P;
    private final Runnable Q;
    private final Runnable R;

    /* renamed from: d, reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f414845d;

    /* renamed from: e, reason: collision with root package name */
    private final Handler f414846e;

    /* renamed from: f, reason: collision with root package name */
    private final int f414847f;

    /* renamed from: h, reason: collision with root package name */
    private final int f414848h;

    /* renamed from: i, reason: collision with root package name */
    private long f414849i;

    /* renamed from: m, reason: collision with root package name */
    boolean f414850m;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a implements d {
        a() {
        }

        @Override // libavif.AvifSequenceDrawable.d
        public Bitmap acquireBitmap(int i3, int i16) {
            return Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            AvifSequenceDrawable.this.invalidateSelf();
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    static final class c extends BaseScheduledThreadPoolExecutor {

        /* renamed from: d, reason: collision with root package name */
        private static final c f414852d = new c();

        c() {
            super(1, new ThreadPoolExecutor.DiscardPolicy());
        }

        static c a() {
            return f414852d;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface d {
        Bitmap acquireBitmap(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface e {
    }

    public AvifSequenceDrawable(AvifDecoder avifDecoder) {
        this(avifDecoder, S);
    }

    static /* synthetic */ e d(AvifSequenceDrawable avifSequenceDrawable) {
        avifSequenceDrawable.getClass();
        return null;
    }

    static /* synthetic */ int j(AvifSequenceDrawable avifSequenceDrawable) {
        int i3 = avifSequenceDrawable.M;
        avifSequenceDrawable.M = i3 + 1;
        return i3;
    }

    private static Bitmap p(d dVar, int i3, int i16) {
        Bitmap acquireBitmap = dVar.acquireBitmap(i3, i16);
        if (acquireBitmap.getWidth() >= i3 && acquireBitmap.getHeight() >= i16 && acquireBitmap.getConfig() == Bitmap.Config.ARGB_8888) {
            return acquireBitmap;
        }
        throw new IllegalArgumentException("Invalid bitmap provided");
    }

    private void q() {
        if (!this.K) {
        } else {
            throw new IllegalStateException("Cannot perform operation on recycled drawable");
        }
    }

    private void t() {
        if (isRunning()) {
            long j3 = this.f414849i;
            if (j3 != Long.MIN_VALUE) {
                long max = Math.max(0L, j3 - SystemClock.uptimeMillis());
                this.f414849i = Long.MIN_VALUE;
                this.f414845d.remove(this.Q);
                this.C = this.f414845d.schedule(this.Q, max, TimeUnit.MILLISECONDS);
            }
        }
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

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f414848h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f414847f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        t();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        boolean z16;
        synchronized (this.I) {
            if (this.f414850m && !this.K) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
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

    public void setLoopCount(int i3) {
        this.P = i3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z16, boolean z17) {
        boolean visible = super.setVisible(z16, z17);
        if (z16) {
            if (z17) {
                stop();
            }
            start();
        } else {
            stop();
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        synchronized (this.I) {
            if (this.f414850m) {
                return;
            }
            this.f414850m = true;
            q();
            this.f414849i = SystemClock.uptimeMillis();
            this.M = 0;
            t();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        synchronized (this.I) {
            if (!this.f414850m) {
                return;
            }
            this.f414850m = false;
            ScheduledFuture<?> scheduledFuture = this.C;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.M = 0;
            this.D.k();
        }
    }

    public void u(int i3) {
        this.N = i3;
    }

    public AvifSequenceDrawable(AvifDecoder avifDecoder, d dVar) {
        this.f414845d = c.a();
        this.f414846e = new b(Looper.getMainLooper());
        this.f414849i = Long.MIN_VALUE;
        this.f414850m = false;
        this.E = new Paint(2);
        this.I = new Object();
        this.K = false;
        this.N = 3;
        this.P = 1;
        this.Q = new Runnable() { // from class: libavif.AvifSequenceDrawable.3
            @Override // java.lang.Runnable
            public void run() {
                long j3;
                boolean z16;
                long j16;
                synchronized (AvifSequenceDrawable.this.I) {
                    AvifSequenceDrawable avifSequenceDrawable = AvifSequenceDrawable.this;
                    if (avifSequenceDrawable.f414850m && !avifSequenceDrawable.K) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        if (!AvifSequenceDrawable.this.D.j()) {
                            return;
                        }
                        try {
                            j3 = AvifSequenceDrawable.this.D.f(AvifSequenceDrawable.this.L);
                            z16 = false;
                        } catch (Exception e16) {
                            Log.e("AvifSequence", "exception during decode: " + e16);
                            j3 = 0L;
                            z16 = true;
                        }
                        if (j3 < 20) {
                            j3 = 100;
                        }
                        AvifSequenceDrawable avifSequenceDrawable2 = AvifSequenceDrawable.this;
                        if (z16) {
                            j16 = Long.MIN_VALUE;
                        } else {
                            j16 = uptimeMillis + j3;
                        }
                        avifSequenceDrawable2.f414849i = j16;
                        if (AvifSequenceDrawable.this.D.i() >= AvifSequenceDrawable.this.D.h() - 1) {
                            AvifSequenceDrawable.j(AvifSequenceDrawable.this);
                            if (AvifSequenceDrawable.this.N == 1 && AvifSequenceDrawable.this.M == AvifSequenceDrawable.this.P) {
                                AvifSequenceDrawable avifSequenceDrawable3 = AvifSequenceDrawable.this;
                                avifSequenceDrawable3.scheduleSelf(avifSequenceDrawable3.R, 0L);
                            } else {
                                AvifSequenceDrawable.this.D.k();
                            }
                        }
                        AvifSequenceDrawable.this.f414846e.sendEmptyMessage(0);
                    }
                }
            }
        };
        this.R = new Runnable() { // from class: libavif.AvifSequenceDrawable.4
            @Override // java.lang.Runnable
            public void run() {
                AvifSequenceDrawable.this.stop();
                AvifSequenceDrawable.d(AvifSequenceDrawable.this);
            }
        };
        if (avifDecoder != null && dVar != null) {
            this.D = avifDecoder;
            avifDecoder.j();
            AvifImage g16 = avifDecoder.g();
            int b16 = g16.b();
            this.f414847f = b16;
            int a16 = g16.a();
            this.f414848h = a16;
            this.J = dVar;
            Bitmap p16 = p(dVar, b16, a16);
            this.L = p16;
            this.F = new Rect(0, 0, b16, a16);
            this.G = new Rect();
            this.H = 0;
            avifDecoder.f(p16);
            return;
        }
        throw new IllegalArgumentException();
    }
}
