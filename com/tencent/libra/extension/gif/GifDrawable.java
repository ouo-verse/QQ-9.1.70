package com.tencent.libra.extension.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import android.widget.MediaController;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes7.dex */
public class GifDrawable extends Drawable implements r01.c, MediaController.MediaPlayerControl {
    final GifInfoHandle C;
    final ConcurrentLinkedQueue<r01.d> D;
    private ColorStateList E;
    private PorterDuffColorFilter F;
    private PorterDuff.Mode G;
    final boolean H;
    final g I;
    private final RenderTask J;
    private volatile boolean K;
    private final Rect L;
    ScheduledFuture<?> M;
    private int N;
    private int P;
    private final Set<WeakReference<Drawable.Callback>> Q;

    /* renamed from: d, reason: collision with root package name */
    private ScheduledThreadPoolExecutor f118722d;

    /* renamed from: e, reason: collision with root package name */
    volatile boolean f118723e;

    /* renamed from: f, reason: collision with root package name */
    long f118724f;

    /* renamed from: h, reason: collision with root package name */
    private final Rect f118725h;

    /* renamed from: i, reason: collision with root package name */
    protected final Paint f118726i;

    /* renamed from: m, reason: collision with root package name */
    final Bitmap f118727m;

    /* compiled from: P */
    /* renamed from: com.tencent.libra.extension.gif.GifDrawable$3, reason: invalid class name */
    /* loaded from: classes7.dex */
    class AnonymousClass3 extends SafeRunnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f118729e;
        final /* synthetic */ GifDrawable this$0;

        @Override // com.tencent.libra.extension.gif.SafeRunnable
        public void e() {
            GifDrawable gifDrawable = this.this$0;
            gifDrawable.C.C(this.f118729e, gifDrawable.f118727m);
            this.this$0.I.sendEmptyMessageAtTime(-1, 0L);
        }
    }

    public GifDrawable(@NonNull Resources resources, @DrawableRes @RawRes int i3) throws Resources.NotFoundException, IOException {
        this(resources.openRawResourceFd(i3));
        float b16 = e.b(resources, i3);
        this.P = (int) (this.C.n() * b16);
        this.N = (int) (this.C.o() * b16);
    }

    private void a() {
        ScheduledFuture<?> scheduledFuture = this.M;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.I.removeMessages(-1);
    }

    private void h() {
        ArrayList arrayList = new ArrayList();
        Drawable.Callback callback = getCallback();
        boolean z16 = false;
        for (WeakReference<Drawable.Callback> weakReference : this.Q) {
            Drawable.Callback callback2 = weakReference.get();
            if (callback2 == null) {
                arrayList.add(weakReference);
            } else if (callback2 == callback) {
                z16 = true;
            } else {
                callback2.invalidateDrawable(this);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.Q.remove((WeakReference) it.next());
        }
        if (!z16) {
            this.Q.add(new WeakReference<>(callback));
        }
    }

    private void m() {
        if (this.H && this.f118723e) {
            long j3 = this.f118724f;
            if (j3 != Long.MIN_VALUE) {
                long max = Math.max(0L, j3 - SystemClock.uptimeMillis());
                this.f118724f = Long.MIN_VALUE;
                f().remove(this.J);
                this.M = f().schedule(this.J, max, TimeUnit.MILLISECONDS);
            }
        }
    }

    private void n(int i3, int i16) {
        if (i16 > 0 && i3 > 0) {
            int q16 = this.C.q();
            int h16 = this.C.h();
            if (i3 < q16 && i16 < h16) {
                int min = Math.min(q16 / i3, h16 / i16);
                GifInfoHandle gifInfoHandle = this.C;
                gifInfoHandle.F((char) min, gifInfoHandle.r());
            }
        }
    }

    private void o() {
        this.f118723e = false;
        this.I.removeMessages(-1);
        this.C.w();
    }

    private PorterDuffColorFilter q(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList != null && mode != null) {
            return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
        }
        return null;
    }

    public Bitmap b() {
        Bitmap bitmap = this.f118727m;
        Bitmap copy = bitmap.copy(bitmap.getConfig(), this.f118727m.isMutable());
        copy.setHasAlpha(this.f118727m.hasAlpha());
        return copy;
    }

    @Override // r01.c
    public /* synthetic */ void c(boolean z16) {
        r01.b.i(this, z16);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        if (g() > 1) {
            return true;
        }
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        if (g() > 1) {
            return true;
        }
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* synthetic */ void clearAnimationCallbacks() {
        r01.b.b(this);
    }

    public int d() {
        return this.C.c();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        boolean z16;
        if (this.F != null && this.f118726i.getColorFilter() == null) {
            this.f118726i.setColorFilter(this.F);
            z16 = true;
        } else {
            z16 = false;
        }
        try {
            canvas.drawBitmap(this.f118727m, this.L, this.f118725h, this.f118726i);
        } catch (Throwable th5) {
            RFWLog.fatal("GifDrawable", RFWLog.USR, th5);
        }
        if (z16) {
            this.f118726i.setColorFilter(null);
        }
    }

    public int e() {
        int d16 = this.C.d();
        if (d16 != 0 && d16 >= this.C.i()) {
            return d16 - 1;
        }
        return d16;
    }

    public ScheduledThreadPoolExecutor f() {
        if (this.f118722d == null) {
            this.f118722d = d.a();
        }
        return this.f118722d;
    }

    public int g() {
        return this.C.m();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f118726i.getAlpha();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        return 100;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f118726i.getColorFilter();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        return this.C.e();
    }

    @Override // r01.c
    public /* synthetic */ Drawable getDrawable() {
        return r01.b.c(this);
    }

    @Override // r01.c
    public int getDuration() {
        return this.C.f();
    }

    @Override // r01.c
    public /* synthetic */ int getFrameCount() {
        return r01.b.f(this);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.P;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.N;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.C.r() && this.f118726i.getAlpha() >= 255) {
            return -1;
        }
        return -2;
    }

    @Override // r01.c
    public /* synthetic */ void i(int i3) {
        r01.b.j(this, i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        Iterator<WeakReference<Drawable.Callback>> it = this.Q.iterator();
        while (it.hasNext()) {
            Drawable.Callback callback = it.next().get();
            if (callback != null && callback != getCallback()) {
                callback.invalidateDrawable(this);
            }
        }
        m();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return this.f118723e;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f118723e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        if (!super.isStateful() && ((colorStateList = this.E) == null || !colorStateList.isStateful())) {
            return false;
        }
        return true;
    }

    public boolean j() {
        return this.C.s();
    }

    public void k() {
        f().execute(new SafeRunnable(this) { // from class: com.tencent.libra.extension.gif.GifDrawable.1
            @Override // com.tencent.libra.extension.gif.SafeRunnable
            public void e() {
                if (GifDrawable.this.C.y()) {
                    GifDrawable.this.start();
                }
            }
        });
    }

    @Override // r01.c
    public /* synthetic */ int l() {
        return r01.b.e(this);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f118725h.set(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.E;
        if (colorStateList != null && (mode = this.G) != null) {
            this.F = q(colorStateList, mode);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(long j3) {
        if (this.H) {
            this.f118724f = 0L;
            this.I.sendEmptyMessageAtTime(-1, 0L);
        } else {
            a();
            this.M = f().schedule(this.J, Math.max(j3, 0L), TimeUnit.MILLISECONDS);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        stop();
    }

    @Override // r01.c
    public void r(@NonNull r01.d dVar) {
        this.D.add(dVar);
    }

    @Override // r01.c
    public void recycle() {
        o();
        this.f118727m.recycle();
    }

    @Override // r01.c, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* synthetic */ void registerAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        r01.b.h(this, animationCallback);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(@IntRange(from = 0, to = 2147483647L) final int i3) {
        if (i3 >= 0) {
            f().execute(new SafeRunnable(this) { // from class: com.tencent.libra.extension.gif.GifDrawable.2
                @Override // com.tencent.libra.extension.gif.SafeRunnable
                public void e() {
                    GifDrawable gifDrawable = GifDrawable.this;
                    gifDrawable.C.D(i3, gifDrawable.f118727m);
                    this.f118744d.I.sendEmptyMessageAtTime(-1, 0L);
                }
            });
            return;
        }
        throw new IllegalArgumentException("Position is not positive");
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i3) {
        this.f118726i.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f118726i.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z16) {
        this.f118726i.setDither(z16);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z16) {
        this.f118726i.setFilterBitmap(z16);
        invalidateSelf();
    }

    @Override // r01.c
    public void setLoopCount(@IntRange(from = 0, to = 65535) int i3) {
        this.C.E(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.E = colorStateList;
        this.F = q(colorStateList, this.G);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        this.G = mode;
        this.F = q(this.E, mode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z16, boolean z17) {
        h();
        boolean visible = super.setVisible(z16, z17);
        if (!this.H) {
            if (z16) {
                if (z17) {
                    k();
                }
                if (visible) {
                    start();
                }
            } else if (visible) {
                stop();
            }
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable, android.widget.MediaController.MediaPlayerControl
    public void start() {
        synchronized (this) {
            if (!this.K) {
                this.f118723e = true;
                this.K = true;
                this.J.e();
            }
            if (this.f118723e) {
                return;
            }
            this.f118723e = true;
            p(this.C.z());
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        synchronized (this) {
            if (!this.f118723e) {
                return;
            }
            this.f118723e = false;
            a();
            this.C.B();
        }
    }

    @NonNull
    public String toString() {
        return String.format(Locale.ENGLISH, "GIF: size: %dx%d, frames: %d, error: %d", Integer.valueOf(this.C.o()), Integer.valueOf(this.C.n()), Integer.valueOf(this.C.m()), Integer.valueOf(this.C.k()));
    }

    @Override // r01.c, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* synthetic */ boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        return r01.b.k(this, animationCallback);
    }

    public GifDrawable(@NonNull File file, int i3, int i16) throws IOException {
        this(new GifInfoHandle(file.getPath()), null, null, true, i3, i16);
    }

    public GifDrawable(@NonNull InputStream inputStream, int i3, int i16) throws IOException {
        this(new GifInfoHandle(inputStream), null, null, true, i3, i16);
    }

    public GifDrawable(@NonNull AssetFileDescriptor assetFileDescriptor) throws IOException {
        this(new GifInfoHandle(assetFileDescriptor), null, null, true, 0, 0);
    }

    public GifDrawable(@Nullable ContentResolver contentResolver, @NonNull Uri uri) throws IOException {
        this(GifInfoHandle.u(contentResolver, uri), null, null, true, 0, 0);
    }

    public GifDrawable(@Nullable ContentResolver contentResolver, @NonNull Uri uri, int i3, int i16) throws IOException {
        this(GifInfoHandle.u(contentResolver, uri), null, null, true, i3, i16);
    }

    GifDrawable(GifInfoHandle gifInfoHandle, GifDrawable gifDrawable, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z16, int i3, int i16) {
        this.f118723e = false;
        this.f118724f = Long.MIN_VALUE;
        this.f118725h = new Rect();
        this.f118726i = new Paint(6);
        this.D = new ConcurrentLinkedQueue<>();
        RenderTask renderTask = new RenderTask(this);
        this.J = renderTask;
        this.K = false;
        this.Q = new HashSet();
        this.H = z16;
        this.f118722d = scheduledThreadPoolExecutor;
        this.C = gifInfoHandle;
        n(i3, i16);
        Bitmap bitmap = null;
        if (gifDrawable != null) {
            synchronized (gifDrawable.C) {
                if (!gifDrawable.C.s() && gifDrawable.C.h() >= gifInfoHandle.h() && gifDrawable.C.q() >= gifInfoHandle.q()) {
                    gifDrawable.o();
                    Bitmap bitmap2 = gifDrawable.f118727m;
                    bitmap2.eraseColor(0);
                    bitmap = bitmap2;
                }
            }
        }
        if (bitmap == null) {
            this.f118727m = Bitmap.createBitmap(gifInfoHandle.o(), gifInfoHandle.n(), Bitmap.Config.ARGB_8888);
        } else {
            this.f118727m = bitmap;
        }
        this.f118727m.setHasAlpha(!gifInfoHandle.r());
        this.L = new Rect(0, 0, gifInfoHandle.o(), gifInfoHandle.n());
        this.I = new g(this);
        renderTask.f();
        this.N = gifInfoHandle.o();
        this.P = gifInfoHandle.n();
    }
}
