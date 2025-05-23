package com.tencent.mobileqq.widget.imageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import jj2.b;

/* compiled from: P */
/* loaded from: classes20.dex */
public class CircleBoarderImageView extends ImageView {
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
    private boolean Q;

    /* renamed from: d, reason: collision with root package name */
    private final RectF f316894d;

    /* renamed from: e, reason: collision with root package name */
    private final RectF f316895e;

    /* renamed from: f, reason: collision with root package name */
    private final Matrix f316896f;

    /* renamed from: h, reason: collision with root package name */
    private final Paint f316897h;

    /* renamed from: i, reason: collision with root package name */
    private final Paint f316898i;

    /* renamed from: m, reason: collision with root package name */
    private final Paint f316899m;

    public CircleBoarderImageView(Context context) {
        super(context);
        this.f316894d = new RectF();
        this.f316895e = new RectF();
        this.f316896f = new Matrix();
        this.f316897h = new Paint();
        this.f316898i = new Paint();
        this.f316899m = new Paint();
        this.C = -16777216;
        this.D = 0;
        this.E = 0;
        d();
    }

    private void a() {
        Paint paint = this.f316897h;
        if (paint != null) {
            paint.setColorFilter(this.L);
        }
    }

    private RectF b() {
        int min = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        float paddingLeft = getPaddingLeft() + ((r0 - min) / 2.0f);
        float paddingTop = getPaddingTop() + ((r1 - min) / 2.0f);
        float f16 = min;
        return new RectF(paddingLeft, paddingTop, paddingLeft + f16, f16 + paddingTop);
    }

    private Bitmap c(Drawable drawable) {
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
            QLog.e("CircleBoarderImageView", 1, "getBitmapFromDrawable Exception", e16);
            return null;
        } catch (OutOfMemoryError e17) {
            QLog.e("CircleBoarderImageView", 1, "getBitmapFromDrawable OutOfMemory", e17);
            return null;
        }
    }

    private void d() {
        super.setScaleType(R);
        this.M = true;
        if (this.N) {
            f();
            this.N = false;
        }
    }

    private void e() {
        if (this.Q) {
            this.F = null;
        } else {
            this.F = c(getDrawable());
        }
        f();
    }

    private void f() {
        int i3;
        if (!this.M) {
            this.N = true;
            return;
        }
        if (getWidth() == 0 && getHeight() == 0) {
            return;
        }
        if (this.F == null) {
            invalidate();
            return;
        }
        Bitmap bitmap = this.F;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.G = new BitmapShader(bitmap, tileMode, tileMode);
        this.f316897h.setAntiAlias(true);
        this.f316897h.setShader(this.G);
        this.f316898i.setStyle(Paint.Style.STROKE);
        this.f316898i.setAntiAlias(true);
        this.f316898i.setColor(this.C);
        this.f316898i.setStrokeWidth(this.D);
        this.f316899m.setStyle(Paint.Style.FILL);
        this.f316899m.setAntiAlias(true);
        this.f316899m.setColor(this.E);
        this.I = this.F.getHeight();
        this.H = this.F.getWidth();
        this.f316895e.set(b());
        this.K = Math.min((this.f316895e.height() - this.D) / 2.0f, (this.f316895e.width() - this.D) / 2.0f);
        this.f316894d.set(this.f316895e);
        if (!this.P && (i3 = this.D) > 0) {
            this.f316894d.inset(i3 - 1.0f, i3 - 1.0f);
        }
        this.J = Math.min(this.f316894d.height() / 2.0f, this.f316894d.width() / 2.0f);
        a();
        g();
        invalidate();
    }

    private void g() {
        float width;
        float height;
        this.f316896f.set(null);
        float f16 = 0.0f;
        if (this.H * this.f316894d.height() > this.f316894d.width() * this.I) {
            width = this.f316894d.height() / this.I;
            height = 0.0f;
            f16 = (this.f316894d.width() - (this.H * width)) * 0.5f;
        } else {
            width = this.f316894d.width() / this.H;
            height = (this.f316894d.height() - (this.I * width)) * 0.5f;
        }
        this.f316896f.setScale(width, width);
        Matrix matrix = this.f316896f;
        RectF rectF = this.f316894d;
        matrix.postTranslate(((int) (f16 + 0.5f)) + rectF.left, ((int) (height + 0.5f)) + rectF.top);
        this.G.setLocalMatrix(this.f316896f);
    }

    @Override // android.widget.ImageView
    public ColorFilter getColorFilter() {
        return this.L;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return R;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.Q) {
            super.onDraw(canvas);
            return;
        }
        if (this.F == null) {
            return;
        }
        if (this.E != 0) {
            canvas.drawCircle(this.f316894d.centerX(), this.f316894d.centerY(), this.J, this.f316899m);
        }
        canvas.drawCircle(this.f316894d.centerX(), this.f316894d.centerY(), this.J, this.f316897h);
        if (this.D > 0) {
            canvas.drawCircle(this.f316895e.centerX(), this.f316895e.centerY(), this.K, this.f316898i);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        f();
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z16) {
        if (!z16) {
        } else {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setBorderColor(int i3) {
        if (i3 == this.C) {
            return;
        }
        this.C = i3;
        this.f316898i.setColor(i3);
        invalidate();
    }

    @Deprecated
    public void setBorderColorResource(int i3) {
        setBorderColor(getContext().getResources().getColor(i3));
    }

    public void setBorderOverlay(boolean z16) {
        if (z16 == this.P) {
            return;
        }
        this.P = z16;
        f();
    }

    public void setBorderWidth(int i3) {
        if (i3 == this.D) {
            return;
        }
        this.D = i3;
        f();
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter == this.L) {
            return;
        }
        this.L = colorFilter;
        a();
        invalidate();
    }

    public void setDisableCircularTransformation(boolean z16) {
        if (this.Q == z16) {
            return;
        }
        this.Q = z16;
        e();
    }

    @Deprecated
    public void setFillColor(int i3) {
        if (i3 == this.E) {
            return;
        }
        this.E = i3;
        this.f316899m.setColor(i3);
        invalidate();
    }

    @Deprecated
    public void setFillColorResource(int i3) {
        setFillColor(getContext().getResources().getColor(i3));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        e();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        e();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i3) {
        super.setImageResource(i3);
        e();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        e();
    }

    @Override // android.view.View
    public void setPadding(int i3, int i16, int i17, int i18) {
        super.setPadding(i3, i16, i17, i18);
        f();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == R) {
        } else {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
        }
    }

    public CircleBoarderImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleBoarderImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316894d = new RectF();
        this.f316895e = new RectF();
        this.f316896f = new Matrix();
        this.f316897h = new Paint();
        this.f316898i = new Paint();
        this.f316899m = new Paint();
        this.C = -16777216;
        this.D = 0;
        this.E = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.W, i3, 0);
        this.D = obtainStyledAttributes.getDimensionPixelSize(b.Z, 0);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(b.X);
        int[] drawableState = getDrawableState();
        if (colorStateList != null) {
            this.C = colorStateList.getColorForState(drawableState, -16777216);
        }
        this.P = obtainStyledAttributes.getBoolean(b.Y, false);
        ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(b.f409983a0);
        if (colorStateList2 != null) {
            this.E = colorStateList2.getColorForState(drawableState, 0);
        }
        obtainStyledAttributes.recycle();
        d();
    }
}
