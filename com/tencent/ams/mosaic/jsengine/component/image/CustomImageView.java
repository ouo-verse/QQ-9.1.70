package com.tencent.ams.mosaic.jsengine.component.image;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Movie;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ams.mosaic.jsengine.component.image.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class CustomImageView extends GifImageView implements c {
    static IPatchRedirector $redirector_;
    protected c.a H;
    protected boolean I;
    protected boolean J;
    protected boolean K;
    protected final Paint L;
    protected Paint M;
    protected float N;
    protected int P;
    protected float Q;
    protected float R;
    protected float S;
    protected float T;
    protected int U;
    private Bitmap V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private int f71143a0;

    /* renamed from: b0, reason: collision with root package name */
    protected ColorFilter f71144b0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void a(Canvas canvas);
    }

    public CustomImageView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.P = 0;
        setLayerType(2, null);
        this.L = new Paint();
    }

    private void f() {
        c.a aVar = this.H;
        if (aVar == null) {
            return;
        }
        if (!this.I) {
            this.I = true;
            com.tencent.ams.mosaic.utils.f.e("CustomImageView", "call onRealFirstDraw");
            aVar.b();
        }
        if (!this.J && this.I && this.K) {
            this.J = true;
            com.tencent.ams.mosaic.utils.f.e("CustomImageView", "call onFirstDrawWithImageContent");
            aVar.a();
        }
    }

    private Path g() {
        Path path = new Path();
        float f16 = this.N / 2.0f;
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        rectF.inset(f16, f16);
        float f17 = this.Q;
        float f18 = this.R;
        float f19 = this.T;
        float f26 = this.S;
        path.addRoundRect(rectF, new float[]{f17, f17, f18, f18, f19, f19, f26, f26}, Path.Direction.CW);
        return path;
    }

    private void h(Canvas canvas) {
        this.L.setStyle(Paint.Style.FILL);
        this.L.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Path g16 = g();
        g16.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        canvas.drawPath(g16, this.L);
        this.L.setXfermode(null);
        if (this.N > 0.0f && this.P != 0) {
            i(canvas);
        }
        int i3 = this.U;
        if (i3 != 0) {
            canvas.drawColor(i3);
        }
    }

    private Bitmap j(boolean z16, int i3, int i16) {
        if (z16) {
            if (i3 == this.W && i16 == this.f71143a0) {
                Bitmap bitmap = this.V;
                if (bitmap == null) {
                    this.V = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
                } else {
                    bitmap.eraseColor(0);
                }
            } else {
                Bitmap bitmap2 = this.V;
                if (bitmap2 != null) {
                    bitmap2.recycle();
                }
                this.V = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
                this.W = i3;
                this.f71143a0 = i16;
            }
            return this.V;
        }
        return Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
    }

    private Paint k() {
        if (this.M == null) {
            Paint paint = new Paint();
            this.M = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.M.setShader(null);
        }
        this.M.setStrokeWidth(this.N);
        this.M.setColor(this.P);
        return this.M;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(Canvas canvas) {
        ColorFilter colorFilter;
        super.onDraw(canvas);
        Drawable drawable = getDrawable();
        if (drawable != null && (colorFilter = this.f71144b0) != null) {
            drawable.setColorFilter(colorFilter);
        }
    }

    private boolean n() {
        if (getDrawable() != null && (this.Q > 0.0f || this.R > 0.0f || this.S > 0.0f || this.T > 0.0f || this.N > 0.0f || this.U != 0)) {
            return true;
        }
        return false;
    }

    private void o(float f16) {
        this.Q = Math.min(this.Q, f16);
        this.R = Math.min(this.R, f16);
        this.S = Math.min(this.S, f16);
        this.T = Math.min(this.T, f16);
        this.N = Math.min(this.N, f16 / 2.0f);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.c
    public View d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (View) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) canvas);
        } else {
            try {
                canvas.drawPath(g(), k());
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.view.View
    public void invalidate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        } else {
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"WrongCall"})
    public void l(Canvas canvas, @NonNull a aVar) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas, (Object) aVar);
            return;
        }
        boolean A = com.tencent.ams.mosaic.f.k().A();
        if (A) {
            z16 = n();
        } else if (getDrawable() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                int width = getWidth();
                int height = getHeight();
                o(Math.min(width, height) / 2.0f);
                Bitmap j3 = j(A, width, height);
                Canvas canvas2 = new Canvas(j3);
                aVar.a(canvas2);
                this.L.reset();
                this.L.setAntiAlias(true);
                this.L.setDither(true);
                h(canvas2);
                canvas.drawBitmap(j3, 0.0f, 0.0f, this.L);
                return;
            } catch (Throwable th5) {
                com.tencent.ams.mosaic.utils.f.c("CustomImageView", "onDraw", th5);
                return;
            }
        }
        aVar.a(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        Bitmap bitmap = this.V;
        if (bitmap != null) {
            bitmap.recycle();
            this.V = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.image.GifImageView, android.widget.ImageView, android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
        } else {
            l(canvas, new a() { // from class: com.tencent.ams.mosaic.jsengine.component.image.a
                @Override // com.tencent.ams.mosaic.jsengine.component.image.CustomImageView.a
                public final void a(Canvas canvas2) {
                    CustomImageView.this.m(canvas2);
                }
            });
            f();
        }
    }

    @Override // android.view.View
    public void postInvalidate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else if (Looper.myLooper() != Looper.getMainLooper()) {
            super.postInvalidate();
        } else {
            super.invalidate();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.c
    public void setBorderColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else if (this.P != i3) {
            this.P = i3;
            postInvalidate();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.c
    public void setBorderWidth(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16));
        } else if (this.N != f16) {
            this.N = f16;
            postInvalidate();
        }
    }

    @Override // android.widget.ImageView, com.tencent.ams.mosaic.jsengine.component.image.c
    public void setImageBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bitmap);
            return;
        }
        super.setImageBitmap(bitmap);
        com.tencent.ams.mosaic.utils.f.e("CustomImageView", " setImageBitmap");
        this.K = true;
    }

    @Override // android.widget.ImageView, com.tencent.ams.mosaic.jsengine.component.image.c
    public void setImageDrawable(@Nullable Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable);
            return;
        }
        super.setImageDrawable(drawable);
        com.tencent.ams.mosaic.utils.f.e("CustomImageView", " setImageDrawable");
        this.K = true;
    }

    public void setLeftBottomRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Float.valueOf(f16));
        } else if (this.S != f16) {
            this.S = f16;
            postInvalidate();
        }
    }

    public void setLeftTopRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Float.valueOf(f16));
        } else if (this.Q != f16) {
            this.Q = f16;
            postInvalidate();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.c
    public void setMaskColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
        } else {
            this.U = i3;
            invalidate();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.GifImageView, com.tencent.ams.mosaic.jsengine.component.image.c
    public void setMovie(Movie movie) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) movie);
            return;
        }
        super.setMovie(movie);
        com.tencent.ams.mosaic.utils.f.e("CustomImageView", " setMovie");
        this.K = true;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.c
    public void setRadius(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        if (this.Q == f16 && this.R == f17 && this.S == f19 && this.T == f18) {
            return;
        }
        this.Q = f16;
        this.R = f17;
        this.S = f19;
        this.T = f18;
        postInvalidate();
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.c
    public void setRealDrawListener(c.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) aVar);
        } else {
            this.H = aVar;
        }
    }

    public void setRightBottomRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Float.valueOf(f16));
        } else if (this.T != f16) {
            this.T = f16;
            postInvalidate();
        }
    }

    public void setRightTopRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Float.valueOf(f16));
        } else if (this.R != f16) {
            this.R = f16;
            postInvalidate();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.c
    public void setTintColorFilter(ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) colorFilter);
        } else {
            this.f71144b0 = colorFilter;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.c
    public void setRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
            setRadius(f16, f16, f16, f16);
        } else {
            iPatchRedirector.redirect((short) 22, this, Float.valueOf(f16));
        }
    }
}
