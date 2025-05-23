package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class RoundImageView extends URLImageView {
    private static final ImageView.ScaleType M = ImageView.ScaleType.CENTER_CROP;
    private static final Bitmap.Config N = Bitmap.Config.ARGB_8888;
    private int C;
    private Bitmap D;
    private BitmapShader E;
    private int F;
    private int G;
    private float H;
    private float I;
    private boolean J;
    private boolean K;
    String L;

    /* renamed from: d, reason: collision with root package name */
    private final RectF f307261d;

    /* renamed from: e, reason: collision with root package name */
    private final RectF f307262e;

    /* renamed from: f, reason: collision with root package name */
    private final Matrix f307263f;

    /* renamed from: h, reason: collision with root package name */
    private final Paint f307264h;

    /* renamed from: i, reason: collision with root package name */
    private final Paint f307265i;

    /* renamed from: m, reason: collision with root package name */
    private int f307266m;

    public RoundImageView(Context context) {
        super(context);
        this.f307261d = new RectF();
        this.f307262e = new RectF();
        this.f307263f = new Matrix();
        this.f307264h = new Paint();
        this.f307265i = new Paint();
        this.f307266m = -16777216;
        this.C = 0;
        init();
    }

    private Bitmap c(Drawable drawable) {
        int intrinsicWidth;
        int intrinsicHeight;
        Bitmap createBitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                createBitmap = Bitmap.createBitmap(1, 1, N);
            } else {
                if (drawable.getIntrinsicWidth() <= 0) {
                    intrinsicWidth = getWidth();
                } else {
                    intrinsicWidth = drawable.getIntrinsicWidth();
                }
                if (drawable.getIntrinsicHeight() <= 0) {
                    intrinsicHeight = getHeight();
                } else {
                    intrinsicHeight = drawable.getIntrinsicHeight();
                }
                createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, N);
            }
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    private void d() {
        if (!this.J) {
            this.K = true;
            return;
        }
        if (this.D == null) {
            return;
        }
        Bitmap bitmap = this.D;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.E = new BitmapShader(bitmap, tileMode, tileMode);
        this.f307264h.setAntiAlias(true);
        this.f307264h.setShader(this.E);
        this.f307265i.setStyle(Paint.Style.STROKE);
        this.f307265i.setAntiAlias(true);
        this.f307265i.setColor(this.f307266m);
        this.f307265i.setStrokeWidth(this.C);
        this.G = this.D.getHeight();
        this.F = this.D.getWidth();
        this.f307262e.set(0.0f, 0.0f, getWidth(), getHeight());
        this.I = Math.min((this.f307262e.height() - this.C) / 2.0f, (this.f307262e.width() - this.C) / 2.0f);
        RectF rectF = this.f307261d;
        int i3 = this.C;
        rectF.set(i3, i3, this.f307262e.width() - this.C, this.f307262e.height() - this.C);
        this.H = Math.min(this.f307261d.height() / 2.0f, this.f307261d.width() / 2.0f);
        e();
        invalidate();
    }

    private void e() {
        float width;
        float height;
        this.f307263f.set(null);
        float f16 = 0.0f;
        if (this.F * this.f307261d.height() > this.f307261d.width() * this.G) {
            width = this.f307261d.height() / this.G;
            height = 0.0f;
            f16 = (this.f307261d.width() - (this.F * width)) * 0.5f;
        } else {
            width = this.f307261d.width() / this.F;
            height = (this.f307261d.height() - (this.G * width)) * 0.5f;
        }
        this.f307263f.setScale(width, width);
        Matrix matrix = this.f307263f;
        int i3 = this.C;
        matrix.postTranslate(((int) (f16 + 0.5f)) + i3, ((int) (height + 0.5f)) + i3);
        this.E.setLocalMatrix(this.f307263f);
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return M;
    }

    public void init() {
        this.J = true;
        if (this.K) {
            d();
            this.K = false;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getDrawable() == null) {
            return;
        }
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.H, this.f307264h);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.I, this.f307265i);
    }

    @Override // com.tencent.image.URLImageView, com.tencent.image.URLDrawable.URLDrawableListener
    @TargetApi(11)
    public void onLoadSuccessed(URLDrawable uRLDrawable) {
        if (QLog.isColorLevel()) {
            QLog.d("faceuu", 4, "onLoadSuccessed");
        }
        setImageDrawable(uRLDrawable);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        d();
    }

    public void setBorderColor(int i3) {
        if (i3 == this.f307266m) {
            return;
        }
        this.f307266m = i3;
        this.f307265i.setColor(i3);
        invalidate();
    }

    public void setBorderWidth(int i3) {
        if (i3 == this.C) {
            return;
        }
        this.C = i3;
        d();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.D = bitmap;
        d();
    }

    @Override // com.tencent.image.URLImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.D = c(drawable);
        d();
    }

    public void setImageFilePath(String str) {
        String str2 = this.L;
        if (str2 != null && str2.equals(str)) {
            return;
        }
        try {
            setImageBitmap(BitmapFactory.decodeFile(str));
            this.L = str;
        } catch (OutOfMemoryError e16) {
            QLog.e("RoundImageView", 1, "setImageFilePath oom", e16);
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i3) {
        super.setImageResource(i3);
        this.D = c(getDrawable());
        d();
    }

    public void setIsready() {
        this.J = true;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == M) {
        } else {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
        }
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        init();
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f307261d = new RectF();
        this.f307262e = new RectF();
        this.f307263f = new Matrix();
        this.f307264h = new Paint();
        this.f307265i = new Paint();
        this.f307266m = -16777216;
        this.C = 0;
        init();
    }
}
