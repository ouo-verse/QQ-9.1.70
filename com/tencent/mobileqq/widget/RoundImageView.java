package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;

/* compiled from: P */
/* loaded from: classes20.dex */
public class RoundImageView extends ImageView {
    Rect C;

    /* renamed from: d, reason: collision with root package name */
    float f316187d;

    /* renamed from: e, reason: collision with root package name */
    boolean f316188e;

    /* renamed from: f, reason: collision with root package name */
    boolean f316189f;

    /* renamed from: h, reason: collision with root package name */
    Path f316190h;

    /* renamed from: i, reason: collision with root package name */
    RectF f316191i;

    /* renamed from: m, reason: collision with root package name */
    Rect f316192m;

    public RoundImageView(Context context) {
        this(context, null);
    }

    private void a(Canvas canvas) {
        try {
            canvas.clipPath(this.f316190h);
        } catch (Exception e16) {
            QLog.e("RoundImageView", 1, "clipPathSafe exception", e16);
        }
    }

    private void b(Context context, AttributeSet attributeSet, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u51.a.X0, i3, 0);
        try {
            try {
                this.f316187d = (int) obtainStyledAttributes.getDimension(u51.a.Z0, 0.0f);
                this.f316188e = obtainStyledAttributes.getBoolean(u51.a.Y0, false);
            } catch (Exception e16) {
                QLog.e("RoundImageView", 1, "initAttrs exception", e16);
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        try {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float f16 = this.f316187d;
            if (f16 > 0.0f) {
                if (this.f316189f) {
                    this.f316191i.set(0.0f, 0.0f, measuredWidth + f16, measuredHeight);
                } else {
                    RectF rectF = this.f316191i;
                    float f17 = measuredWidth;
                    float f18 = measuredHeight;
                    if (!this.f316188e) {
                        f16 = 0.0f;
                    }
                    rectF.set(0.0f, 0.0f, f17, f18 + f16);
                }
                Path path = this.f316190h;
                RectF rectF2 = this.f316191i;
                float f19 = this.f316187d;
                path.addRoundRect(rectF2, f19, f19, Path.Direction.CW);
                a(canvas);
                Drawable drawable = getDrawable();
                if (drawable != null) {
                    if (drawable instanceof SkinnableBitmapDrawable) {
                        bitmap = ((SkinnableBitmapDrawable) drawable).getBitmap();
                    } else if (drawable instanceof BitmapDrawable) {
                        bitmap = ((BitmapDrawable) drawable).getBitmap();
                    } else {
                        bitmap = null;
                    }
                    if (bitmap != null && !bitmap.isRecycled()) {
                        this.f316192m.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        this.C.set(0, 0, measuredWidth, measuredHeight);
                        canvas.drawBitmap(bitmap, this.f316192m, this.C, (Paint) null);
                        return;
                    }
                }
            }
            super.onDraw(canvas);
        } catch (Exception e16) {
            QLog.e("RoundImageView", 1, "onDraw exception", e16);
        }
    }

    public void setQwRadius(int i3) {
        this.f316187d = i3;
        invalidate();
    }

    public void setRadiusWithoutRight(int i3) {
        this.f316187d = i3;
        this.f316189f = true;
    }

    public void setmRadius(int i3, boolean z16) {
        this.f316187d = i3;
        this.f316188e = z16;
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316187d = 0.0f;
        this.f316188e = false;
        this.f316189f = false;
        this.f316190h = new Path();
        this.f316191i = new RectF();
        this.f316192m = new Rect();
        this.C = new Rect();
        b(context, attributeSet, i3);
    }
}
