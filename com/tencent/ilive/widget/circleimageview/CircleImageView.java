package com.tencent.ilive.widget.circleimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import li2.a;

/* compiled from: P */
/* loaded from: classes7.dex */
public class CircleImageView extends ImageView {
    private static final ImageView.ScaleType R = ImageView.ScaleType.CENTER_CROP;
    private static final Bitmap.Config S = Bitmap.Config.ARGB_8888;
    private int C;
    private int D;
    private int E;
    private Bitmap F;
    private BitmapShader G;
    private int H;
    private int I;
    private float J;
    private float K;
    private ColorFilter L;
    private boolean M;
    private boolean N;
    private boolean P;
    private int Q;

    /* renamed from: d, reason: collision with root package name */
    private final RectF f116243d;

    /* renamed from: e, reason: collision with root package name */
    private final RectF f116244e;

    /* renamed from: f, reason: collision with root package name */
    private final Matrix f116245f;

    /* renamed from: h, reason: collision with root package name */
    private final Paint f116246h;

    /* renamed from: i, reason: collision with root package name */
    private final Paint f116247i;

    /* renamed from: m, reason: collision with root package name */
    private final Paint f116248m;

    public CircleImageView(Context context) {
        super(context);
        this.f116243d = new RectF();
        this.f116244e = new RectF();
        this.f116245f = new Matrix();
        this.f116246h = new Paint();
        this.f116247i = new Paint();
        this.f116248m = new Paint();
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.Q = 0;
        b();
    }

    private Bitmap a(Drawable drawable) {
        Bitmap createBitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                createBitmap = Bitmap.createBitmap(2, 2, S);
            } else {
                createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), S);
            }
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private void b() {
        super.setScaleType(R);
        this.M = true;
        if (this.N) {
            c();
            this.N = false;
        }
    }

    private void c() {
        if (!this.M) {
            this.N = true;
            return;
        }
        if (getWidth() != 0 || getHeight() != 0) {
            if (this.F == null) {
                invalidate();
                return;
            }
            Bitmap bitmap = this.F;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.G = new BitmapShader(bitmap, tileMode, tileMode);
            this.f116246h.setAntiAlias(true);
            this.f116246h.setShader(this.G);
            this.f116247i.setStyle(Paint.Style.STROKE);
            this.f116247i.setAntiAlias(true);
            this.f116247i.setColor(this.C);
            this.f116247i.setStrokeWidth(this.D);
            this.f116248m.setStyle(Paint.Style.FILL);
            this.f116248m.setAntiAlias(true);
            this.f116248m.setColor(this.E);
            this.I = this.F.getHeight();
            this.H = this.F.getWidth();
            this.f116244e.set(0.0f, 0.0f, getWidth(), getHeight());
            this.K = Math.min((this.f116244e.height() - this.D) / 2.0f, (this.f116244e.width() - this.D) / 2.0f);
            this.f116243d.set(this.f116244e);
            if (!this.P) {
                RectF rectF = this.f116243d;
                int i3 = this.D;
                rectF.inset(i3, i3);
            }
            this.J = Math.min(this.f116243d.height() / 2.0f, this.f116243d.width() / 2.0f);
            d();
            invalidate();
        }
    }

    private void d() {
        float width;
        float height;
        this.f116245f.set(null);
        float f16 = 0.0f;
        if (this.H * this.f116243d.height() > this.f116243d.width() * this.I) {
            width = this.f116243d.height() / this.I;
            height = 0.0f;
            f16 = (this.f116243d.width() - (this.H * width)) * 0.5f;
        } else {
            width = this.f116243d.width() / this.H;
            height = (this.f116243d.height() - (this.I * width)) * 0.5f;
        }
        this.f116245f.setScale(width, width);
        Matrix matrix = this.f116245f;
        RectF rectF = this.f116243d;
        matrix.postTranslate(((int) (f16 + 0.5f)) + rectF.left, ((int) (height + 0.5f)) + rectF.top);
        this.G.setLocalMatrix(this.f116245f);
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return R;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.F != null) {
            if (this.E != 0) {
                canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f116248m);
            }
            if (this.Q == 0) {
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.J, this.f116246h);
            } else {
                RectF rectF = new RectF(new Rect(0, 0, getWidth(), getHeight()));
                int i3 = this.Q;
                canvas.drawRoundRect(rectF, i3, i3, this.f116246h);
            }
            if (this.D != 0) {
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.K, this.f116247i);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        c();
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z16) {
        if (!z16) {
        } else {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setBorderColor(int i3) {
        if (i3 != this.C) {
            this.C = i3;
            this.f116247i.setColor(i3);
            invalidate();
        }
    }

    public void setBorderColorResource(int i3) {
        setBorderColor(getContext().getResources().getColor(i3));
    }

    public void setBorderOverlay(boolean z16) {
        if (z16 != this.P) {
            this.P = z16;
            c();
        }
    }

    public void setBorderWidth(int i3) {
        if (i3 != this.D) {
            this.D = i3;
            c();
        }
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.L) {
            this.L = colorFilter;
            this.f116246h.setColorFilter(colorFilter);
            invalidate();
        }
    }

    public void setFillColor(int i3) {
        if (i3 != this.E) {
            this.E = i3;
            this.f116248m.setColor(i3);
            invalidate();
        }
    }

    public void setFillColorResource(int i3) {
        setFillColor(getContext().getResources().getColor(i3));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.F = bitmap;
        c();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.F = a(drawable);
        c();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i3) {
        super.setImageResource(i3);
        this.F = a(getDrawable());
        c();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        Bitmap bitmap;
        super.setImageURI(uri);
        if (uri != null) {
            bitmap = a(getDrawable());
        } else {
            bitmap = null;
        }
        this.F = bitmap;
        c();
    }

    public void setRoundRadius(int i3) {
        this.Q = i3;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == R) {
        } else {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
        }
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f116243d = new RectF();
        this.f116244e = new RectF();
        this.f116245f = new Matrix();
        this.f116246h = new Paint();
        this.f116247i = new Paint();
        this.f116248m = new Paint();
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.Q = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f414609a0, i3, 0);
        this.D = obtainStyledAttributes.getDimensionPixelSize(a.f414636d0, 0);
        this.C = obtainStyledAttributes.getColor(a.f414618b0, 0);
        this.P = obtainStyledAttributes.getBoolean(a.f414627c0, false);
        this.E = obtainStyledAttributes.getColor(a.f414645e0, 0);
        this.Q = obtainStyledAttributes.getDimensionPixelOffset(a.f414654f0, 0);
        obtainStyledAttributes.recycle();
        b();
    }
}
