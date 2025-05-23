package com.tencent.mobileqq.guild.media.widget;

import android.content.Context;
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
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatImageView;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GCircleImageView extends AppCompatImageView {
    private static final ImageView.ScaleType W = ImageView.ScaleType.CENTER_CROP;

    /* renamed from: a0, reason: collision with root package name */
    private static final Bitmap.Config f229633a0 = Bitmap.Config.ARGB_8888;
    private final RectF C;
    private final Matrix D;
    private final Paint E;
    private final Paint F;
    private final Paint G;
    private int H;
    private int I;
    private int J;
    private Bitmap K;
    private BitmapShader L;
    private int M;
    private int N;
    private float P;
    private float Q;
    private ColorFilter R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;

    /* renamed from: m, reason: collision with root package name */
    private final RectF f229634m;

    public GCircleImageView(Context context) {
        super(context);
        this.f229634m = new RectF();
        this.C = new RectF();
        this.D = new Matrix();
        this.E = new Paint();
        this.F = new Paint();
        this.G = new Paint();
        this.H = -16777216;
        this.I = 0;
        this.J = 0;
        init();
    }

    private void applyColorFilter() {
        Paint paint = this.E;
        if (paint != null) {
            paint.setColorFilter(this.R);
        }
    }

    private RectF calculateBounds() {
        int min = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        float paddingLeft = getPaddingLeft() + ((r0 - min) / 2.0f);
        float paddingTop = getPaddingTop() + ((r1 - min) / 2.0f);
        float f16 = min;
        return new RectF(paddingLeft, paddingTop, paddingLeft + f16, f16 + paddingTop);
    }

    private Bitmap getBitmapFromDrawable(Drawable drawable) {
        Bitmap createBitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                createBitmap = Bitmap.createBitmap(2, 2, f229633a0);
            } else {
                createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f229633a0);
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

    private void init() {
        super.setScaleType(W);
        this.S = true;
        if (this.T) {
            setup();
            this.T = false;
        }
    }

    private void initializeBitmap() {
        if (this.V) {
            this.K = null;
        } else {
            this.K = getBitmapFromDrawable(getDrawable());
        }
        setup();
    }

    private void setup() {
        int i3;
        if (!this.S) {
            this.T = true;
            return;
        }
        if (getWidth() == 0 && getHeight() == 0) {
            return;
        }
        if (this.K == null) {
            invalidate();
            return;
        }
        Bitmap bitmap = this.K;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.L = new BitmapShader(bitmap, tileMode, tileMode);
        this.E.setAntiAlias(true);
        this.E.setShader(this.L);
        this.F.setStyle(Paint.Style.STROKE);
        this.F.setAntiAlias(true);
        this.F.setColor(this.H);
        this.F.setStrokeWidth(this.I);
        this.G.setStyle(Paint.Style.FILL);
        this.G.setAntiAlias(true);
        this.G.setColor(this.J);
        this.N = this.K.getHeight();
        this.M = this.K.getWidth();
        this.C.set(calculateBounds());
        this.Q = Math.min((this.C.height() - this.I) / 2.0f, (this.C.width() - this.I) / 2.0f);
        this.f229634m.set(this.C);
        if (!this.U && (i3 = this.I) > 0) {
            this.f229634m.inset(i3 - 1.0f, i3 - 1.0f);
        }
        this.P = Math.min(this.f229634m.height() / 2.0f, this.f229634m.width() / 2.0f);
        applyColorFilter();
        updateShaderMatrix();
        invalidate();
    }

    private void updateShaderMatrix() {
        float width;
        float height;
        this.D.set(null);
        float f16 = 0.0f;
        if (this.M * this.f229634m.height() > this.f229634m.width() * this.N) {
            width = this.f229634m.height() / this.N;
            height = 0.0f;
            f16 = (this.f229634m.width() - (this.M * width)) * 0.5f;
        } else {
            width = this.f229634m.width() / this.M;
            height = (this.f229634m.height() - (this.N * width)) * 0.5f;
        }
        this.D.setScale(width, width);
        Matrix matrix = this.D;
        RectF rectF = this.f229634m;
        matrix.postTranslate(((int) (f16 + 0.5f)) + rectF.left, ((int) (height + 0.5f)) + rectF.top);
        this.L.setLocalMatrix(this.D);
    }

    @Override // android.widget.ImageView
    public ColorFilter getColorFilter() {
        return this.R;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return W;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.V) {
            super.onDraw(canvas);
            return;
        }
        if (this.K == null) {
            return;
        }
        if (this.J != 0) {
            canvas.drawCircle(this.f229634m.centerX(), this.f229634m.centerY(), this.P, this.G);
        }
        canvas.drawCircle(this.f229634m.centerX(), this.f229634m.centerY(), this.P, this.E);
        if (this.I > 0) {
            canvas.drawCircle(this.C.centerX(), this.C.centerY(), this.Q, this.F);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        setup();
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z16) {
        if (!z16) {
        } else {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setBorderColor(@ColorInt int i3) {
        if (i3 == this.H) {
            return;
        }
        this.H = i3;
        this.F.setColor(i3);
        invalidate();
    }

    public void setBorderColorResource(@ColorRes int i3) {
        setBorderColor(getContext().getResources().getColor(i3));
    }

    public void setBorderOverlay(boolean z16) {
        if (z16 == this.U) {
            return;
        }
        this.U = z16;
        setup();
    }

    public void setBorderWidth(int i3) {
        if (i3 == this.I) {
            return;
        }
        this.I = i3;
        setup();
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter == this.R) {
            return;
        }
        this.R = colorFilter;
        applyColorFilter();
        invalidate();
    }

    public void setDisableCircularTransformation(boolean z16) {
        if (this.V == z16) {
            return;
        }
        this.V = z16;
        initializeBitmap();
    }

    @Deprecated
    public void setFillColor(@ColorInt int i3) {
        if (i3 == this.J) {
            return;
        }
        this.J = i3;
        this.G.setColor(i3);
        invalidate();
    }

    public void setFillColorResource(@ColorRes int i3) {
        setFillColor(getContext().getResources().getColor(i3));
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        initializeBitmap();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        initializeBitmap();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(@DrawableRes int i3) {
        super.setImageResource(i3);
        initializeBitmap();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        initializeBitmap();
    }

    @Override // android.view.View
    public void setPadding(int i3, int i16, int i17, int i18) {
        super.setPadding(i3, i16, i17, i18);
        setup();
    }

    @Override // android.view.View
    public void setPaddingRelative(int i3, int i16, int i17, int i18) {
        super.setPaddingRelative(i3, i16, i17, i18);
        setup();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == W) {
        } else {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
        }
    }

    public GCircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GCircleImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f229634m = new RectF();
        this.C = new RectF();
        this.D = new Matrix();
        this.E = new Paint();
        this.F = new Paint();
        this.G = new Paint();
        this.H = -16777216;
        this.I = 0;
        this.J = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, up1.a.T1, i3, 0);
        this.I = obtainStyledAttributes.getDimensionPixelSize(up1.a.W1, 0);
        this.H = obtainStyledAttributes.getColor(up1.a.U1, -16777216);
        this.U = obtainStyledAttributes.getBoolean(up1.a.V1, false);
        this.J = obtainStyledAttributes.getColor(up1.a.X1, 0);
        obtainStyledAttributes.recycle();
        init();
    }
}
