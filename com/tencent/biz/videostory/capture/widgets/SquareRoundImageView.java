package com.tencent.biz.videostory.capture.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SquareRoundImageView extends ImageView {
    private static int L = ScreenUtil.dip2px(2.0f);
    private PaintFlagsDrawFilter C;
    private BitmapShader D;
    private a E;
    private int F;
    private int G;
    private int H;
    private int I;
    private boolean J;
    private boolean K;

    /* renamed from: d, reason: collision with root package name */
    private int f97057d;

    /* renamed from: e, reason: collision with root package name */
    protected Path f97058e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f97059f;

    /* renamed from: h, reason: collision with root package name */
    private Paint f97060h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f97061i;

    /* renamed from: m, reason: collision with root package name */
    private Matrix f97062m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<SquareRoundImageView> f97063a;

        a(Looper looper, SquareRoundImageView squareRoundImageView) {
            super(looper);
            this.f97063a = new WeakReference<>(squareRoundImageView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SquareRoundImageView squareRoundImageView;
            if (message.what == 1 && (squareRoundImageView = this.f97063a.get()) != null) {
                squareRoundImageView.h();
            }
        }
    }

    public SquareRoundImageView(Context context) {
        this(context, null);
    }

    private void b() {
        float f16;
        float f17;
        Matrix matrix = this.f97062m;
        if (matrix == null) {
            this.f97062m = new Matrix();
        } else {
            matrix.reset();
        }
        if (this.F > 0 && this.G > 0 && this.H > 0 && this.I > 0) {
            if (ImageView.ScaleType.FIT_XY == getScaleType()) {
                this.f97062m.setScale(this.H / this.F, this.I / this.G);
                return;
            }
            int i3 = this.F;
            int i16 = this.I;
            int i17 = i3 * i16;
            int i18 = this.H;
            int i19 = this.G;
            float f18 = 0.0f;
            if (i17 > i18 * i19) {
                f16 = i16 / i19;
                float f19 = (i18 - (i3 * f16)) * 0.5f;
                f17 = 0.0f;
                f18 = f19;
            } else {
                float f26 = i18 / i3;
                float f27 = (i16 - (i19 * f26)) * 0.5f;
                f16 = f26;
                f17 = f27;
            }
            this.f97062m.setScale(f16, f16);
            this.f97062m.postTranslate(Math.round(f18), Math.round(f17));
        }
    }

    private void c(int i3, int i16) {
        this.f97058e.reset();
        if (i3 > 0 && i16 > 0) {
            float f16 = i3;
            float f17 = i16;
            float min = Math.min(f16 * 0.0618f, 0.0618f * f17);
            float f18 = f16 / 2.0f;
            float f19 = f17 / 2.0f;
            this.f97058e.moveTo(L, f19);
            Path path = this.f97058e;
            int i17 = L;
            path.cubicTo(i17, min, min, i17, f18, i17);
            float f26 = f16 - min;
            this.f97058e.cubicTo(f26, L, i3 - r5, min, i3 - r5, f19);
            Path path2 = this.f97058e;
            int i18 = L;
            float f27 = f17 - min;
            path2.cubicTo(i3 - i18, f27, f26, i16 - i18, f18, i16 - i18);
            Path path3 = this.f97058e;
            int i19 = L;
            path3.cubicTo(min, i16 - i19, i19, f27, i19, f19);
        }
    }

    private Bitmap d(Drawable drawable) {
        if (drawable != null && !Build.BRAND.contains("Meitu")) {
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                try {
                    Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(createBitmap);
                    drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                    drawable.draw(canvas);
                    return createBitmap;
                } catch (Exception | OutOfMemoryError unused) {
                }
            }
        }
        return null;
    }

    private void e() {
        if (this.E == null) {
            synchronized (this) {
                if (this.E == null) {
                    this.E = new a(Looper.getMainLooper(), this);
                }
            }
        }
    }

    private void f() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (width != this.H || height != this.I) {
            this.H = width;
            this.I = height;
            c(width, height);
            if (this.D != null) {
                b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Bitmap d16 = d(getDrawable());
        if (d16 != null) {
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.D = new BitmapShader(d16, tileMode, tileMode);
            this.F = d16.getWidth();
            this.G = d16.getHeight();
            b();
        } else {
            this.D = null;
            this.F = 0;
            this.G = 0;
        }
        invalidate();
    }

    public void g() {
        e();
        if (!this.E.hasMessages(1)) {
            this.E.sendEmptyMessage(1);
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        super.invalidateDrawable(drawable);
        g();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Paint paint;
        Path path = this.f97058e;
        if (path != null) {
            if (this.K) {
                canvas.drawPath(path, this.f97061i);
            }
            BitmapShader bitmapShader = this.D;
            if (bitmapShader != null) {
                bitmapShader.setLocalMatrix(this.f97062m);
                this.f97059f.setShader(this.D);
                canvas.translate(getPaddingLeft(), getPaddingTop());
                canvas.drawPath(this.f97058e, this.f97059f);
            } else {
                try {
                    canvas.setDrawFilter(this.C);
                    canvas.save();
                    this.f97058e.offset(getPaddingLeft(), getPaddingRight());
                    canvas.clipPath(this.f97058e);
                    super.onDraw(canvas);
                    this.f97058e.offset(0 - getPaddingLeft(), 0 - getPaddingRight());
                    canvas.restore();
                } catch (Exception unused) {
                    super.onDraw(canvas);
                }
            }
            if (this.J && (paint = this.f97060h) != null) {
                canvas.drawPath(this.f97058e, paint);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        if (i3 != 0 && i16 != 0) {
            if (i3 != i17 || i16 != i18) {
                f();
            }
        }
    }

    public void setDrawBack(boolean z16) {
        this.K = z16;
        invalidate();
    }

    public void setDrawChecked(boolean z16) {
        this.J = z16;
        if (z16 && this.f97060h == null) {
            Paint paint = new Paint();
            this.f97060h = paint;
            paint.setAntiAlias(true);
            this.f97060h.setColor(Color.parseColor("#FFFFFF"));
            this.f97060h.setStrokeWidth(this.f97057d);
            this.f97060h.setStyle(Paint.Style.STROKE);
        }
        invalidate();
    }

    public void setDrawShadowLayer() {
        this.f97059f.setShadowLayer(10.0f, 15.0f, 15.0f, -7829368);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        super.setImageDrawable(drawable);
        if (drawable == null) {
            e();
            if (this.E.hasMessages(1)) {
                this.E.removeMessages(1);
            }
            this.D = null;
            this.G = 0;
            this.F = 0;
            return;
        }
        g();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i3) {
        if (getResources() == null) {
            return;
        }
        try {
            setImageDrawable(getResources().getDrawable(i3));
        } catch (Exception e16) {
            QLog.e("SquareRoundImageView", 4, e16, new Object[0]);
        }
    }

    @Override // android.view.View
    public void setPadding(int i3, int i16, int i17, int i18) {
        super.setPadding(i3, i16, i17, i18);
        f();
    }

    public SquareRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f97057d = L;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.K = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SquareRoundImageView);
        int color = obtainStyledAttributes.getColor(R.styleable.SquareRoundImageView_roundImageSelectBgColor, Color.parseColor("#74000000"));
        this.f97057d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SquareRoundImageView_roundImageSelectWidth, 2);
        this.f97058e = new Path();
        Paint paint = new Paint();
        this.f97059f = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f97061i = paint2;
        paint2.setAntiAlias(true);
        this.f97061i.setColor(color);
        this.f97061i.setStyle(Paint.Style.FILL);
        this.C = new PaintFlagsDrawFilter(0, 3);
        obtainStyledAttributes.recycle();
    }
}
