package com.tencent.libra.base.animation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.tencent.libra.base.animation.decode.FrameSeqDecoder;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import r01.b;
import r01.c;
import r01.d;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class FrameAnimationDrawable<Decoder extends FrameSeqDecoder> extends Drawable implements c, FrameSeqDecoder.a {
    private static final String I = "FrameAnimationDrawable";
    private boolean C;
    private final Handler D;
    private final Runnable E;
    private boolean F;
    private final Set<WeakReference<Drawable.Callback>> G;
    private boolean H;

    /* renamed from: d, reason: collision with root package name */
    private final Paint f118584d;

    /* renamed from: e, reason: collision with root package name */
    private final Decoder f118585e;

    /* renamed from: f, reason: collision with root package name */
    private final DrawFilter f118586f;

    /* renamed from: h, reason: collision with root package name */
    private final Matrix f118587h;

    /* renamed from: i, reason: collision with root package name */
    private final Set<Animatable2Compat.AnimationCallback> f118588i;

    /* renamed from: m, reason: collision with root package name */
    private Bitmap f118589m;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 == 2) {
                    Iterator it = new ArrayList(FrameAnimationDrawable.this.f118588i).iterator();
                    while (it.hasNext()) {
                        ((Animatable2Compat.AnimationCallback) it.next()).onAnimationEnd(FrameAnimationDrawable.this);
                    }
                    return;
                }
                return;
            }
            Iterator it5 = new ArrayList(FrameAnimationDrawable.this.f118588i).iterator();
            while (it5.hasNext()) {
                ((Animatable2Compat.AnimationCallback) it5.next()).onAnimationStart(FrameAnimationDrawable.this);
            }
        }
    }

    public FrameAnimationDrawable(u01.c cVar) {
        Paint paint = new Paint();
        this.f118584d = paint;
        this.f118586f = new PaintFlagsDrawFilter(0, 3);
        this.f118587h = new Matrix();
        this.f118588i = new HashSet();
        this.D = new a(Looper.getMainLooper());
        this.E = new Runnable() { // from class: com.tencent.libra.base.animation.FrameAnimationDrawable.2
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationDrawable.this.invalidateSelf();
            }
        };
        this.F = true;
        this.G = new HashSet();
        this.H = false;
        paint.setAntiAlias(true);
        this.f118585e = b(cVar, this);
    }

    private void e() {
        ArrayList arrayList = new ArrayList();
        Drawable.Callback callback = getCallback();
        boolean z16 = false;
        for (WeakReference<Drawable.Callback> weakReference : this.G) {
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
            this.G.remove((WeakReference) it.next());
        }
        if (!z16) {
            this.G.add(new WeakReference<>(callback));
        }
    }

    private void f() {
        this.f118585e.o(this);
        if (this.F) {
            this.f118585e.O();
        } else if (!this.f118585e.E()) {
            this.f118585e.O();
        }
    }

    private void g() {
        this.f118585e.J(this);
        if (this.F) {
            this.f118585e.Q();
        } else {
            this.f118585e.R();
        }
    }

    protected abstract Decoder b(u01.c cVar, FrameSeqDecoder.a aVar);

    @Override // r01.c
    public /* synthetic */ void c(boolean z16) {
        b.i(this, z16);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        this.f118588i.clear();
    }

    public Decoder d() {
        return this.f118585e;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f118589m;
        if (bitmap != null && !bitmap.isRecycled()) {
            canvas.setDrawFilter(this.f118586f);
            canvas.drawBitmap(this.f118589m, this.f118587h, this.f118584d);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.Callback getCallback() {
        return super.getCallback();
    }

    @Override // r01.c
    public /* synthetic */ Drawable getDrawable() {
        return b.c(this);
    }

    @Override // r01.c
    public int getDuration() {
        return this.f118585e.t();
    }

    @Override // r01.c
    public /* synthetic */ int getFrameCount() {
        return b.f(this);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.H) {
            return -1;
        }
        try {
            return this.f118585e.r().height();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.H) {
            return -1;
        }
        try {
            return this.f118585e.r().width();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // r01.c
    public /* synthetic */ void i(int i3) {
        b.j(this, i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        Iterator<WeakReference<Drawable.Callback>> it = this.G.iterator();
        while (it.hasNext()) {
            Drawable.Callback callback = it.next().get();
            if (callback != null && callback != getCallback()) {
                callback.invalidateDrawable(this);
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f118585e.E();
    }

    @Override // r01.c
    public /* synthetic */ int l() {
        return b.e(this);
    }

    @Override // com.tencent.libra.base.animation.decode.FrameSeqDecoder.a
    public void onEnd() {
        Message.obtain(this.D, 2).sendToTarget();
    }

    @Override // com.tencent.libra.base.animation.decode.FrameSeqDecoder.a
    public void onRender(ByteBuffer byteBuffer) {
        if (!isRunning()) {
            return;
        }
        Bitmap bitmap = this.f118589m;
        if (bitmap == null || bitmap.isRecycled()) {
            this.f118589m = Bitmap.createBitmap(this.f118585e.r().width() / this.f118585e.z(), this.f118585e.r().height() / this.f118585e.z(), Bitmap.Config.ARGB_8888);
        }
        byteBuffer.rewind();
        if (byteBuffer.remaining() < this.f118589m.getByteCount()) {
            Log.e(I, "onRender:Buffer not large enough for pixels");
        } else {
            this.f118589m.copyPixelsFromBuffer(byteBuffer);
            this.D.post(this.E);
        }
    }

    @Override // com.tencent.libra.base.animation.decode.FrameSeqDecoder.a
    public void onStart() {
        Message.obtain(this.D, 1).sendToTarget();
    }

    @Override // r01.c
    public /* synthetic */ void r(d dVar) {
        b.a(this, dVar);
    }

    @Override // r01.c
    public /* synthetic */ void recycle() {
        b.g(this);
    }

    @Override // r01.c, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        this.f118588i.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f118584d.setAlpha(i3);
    }

    public void setAutoPlay(boolean z16) {
        this.F = z16;
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i3, int i16, int i17, int i18) {
        super.setBounds(i3, i16, i17, i18);
        boolean M = this.f118585e.M(getBounds().width(), getBounds().height());
        this.f118587h.setScale(((getBounds().width() * 1.0f) * this.f118585e.z()) / this.f118585e.r().width(), ((getBounds().height() * 1.0f) * this.f118585e.z()) / this.f118585e.r().height());
        if (M) {
            this.f118589m = Bitmap.createBitmap(this.f118585e.r().width() / this.f118585e.z(), this.f118585e.r().height() / this.f118585e.z(), Bitmap.Config.ARGB_8888);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f118584d.setColorFilter(colorFilter);
    }

    @Override // r01.c
    public void setLoopCount(int i3) {
        this.f118585e.N(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z16, boolean z17) {
        e();
        if (this.F) {
            if (z16) {
                if (!isRunning() && z17) {
                    start();
                } else if (this.C) {
                    f();
                }
            } else if (isRunning()) {
                g();
            }
        }
        return super.setVisible(z16, z17);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.C = true;
        if (this.f118585e.E()) {
            this.f118585e.Q();
        }
        this.f118585e.L();
        f();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.C = false;
        g();
    }

    @Override // r01.c, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        return this.f118588i.remove(animationCallback);
    }
}
