package com.tencent.mobileqq.wink.editor.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkRoundImageView extends ImageView {
    public static int E = 1;
    private RectF C;
    private Paint D;

    /* renamed from: d, reason: collision with root package name */
    private Paint f322705d;

    /* renamed from: e, reason: collision with root package name */
    private Matrix f322706e;

    /* renamed from: f, reason: collision with root package name */
    private BitmapShader f322707f;

    /* renamed from: h, reason: collision with root package name */
    private int f322708h;

    /* renamed from: i, reason: collision with root package name */
    private Bitmap f322709i;

    /* renamed from: m, reason: collision with root package name */
    private RectF f322710m;

    public WinkRoundImageView(Context context) {
        this(context, null);
    }

    private Bitmap a(Drawable drawable) {
        int intrinsicWidth;
        int intrinsicHeight;
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
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
            if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return createBitmap;
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getDrawable() == null) {
            return;
        }
        Bitmap bitmap = this.f322709i;
        float f16 = 1.0f;
        if (bitmap != null && (bitmap.getWidth() != getWidth() || this.f322709i.getHeight() != getHeight())) {
            f16 = Math.max((getWidth() * 1.0f) / this.f322709i.getWidth(), (getHeight() * 1.0f) / this.f322709i.getHeight());
        }
        this.f322706e.setScale(f16, f16);
        BitmapShader bitmapShader = this.f322707f;
        if (bitmapShader != null) {
            bitmapShader.setLocalMatrix(this.f322706e);
            this.f322705d.setShader(this.f322707f);
        }
        this.C.set(ImmersiveUtils.dpToPx(E), ImmersiveUtils.dpToPx(E), getMeasuredWidth() - ImmersiveUtils.dpToPx(E), getMeasuredHeight() - ImmersiveUtils.dpToPx(E));
        RectF rectF = this.f322710m;
        int i3 = this.f322708h;
        canvas.drawRoundRect(rectF, i3, i3, this.D);
        RectF rectF2 = this.C;
        int i16 = this.f322708h;
        canvas.drawRoundRect(rectF2, i16, i16, this.f322705d);
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.f322710m.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable != null && drawable != getDrawable()) {
            Bitmap a16 = a(drawable);
            this.f322709i = a16;
            if (a16 != null) {
                Bitmap bitmap = this.f322709i;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                this.f322707f = new BitmapShader(bitmap, tileMode, tileMode);
            }
        }
        super.setImageDrawable(drawable);
    }

    public void setRoundRect(int i3) {
        if (i3 <= 0) {
            i3 = 0;
        }
        this.f322708h = i3;
        invalidate();
    }

    public WinkRoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WinkRoundImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f322708h = 90;
        this.f322710m = new RectF();
        this.f322706e = new Matrix();
        Paint paint = new Paint();
        this.f322705d = paint;
        paint.setAntiAlias(true);
        this.C = new RectF();
        Paint paint2 = new Paint();
        this.D = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.D.setStrokeWidth(ImmersiveUtils.dpToPx(E));
        this.D.setColor(-1);
    }
}
