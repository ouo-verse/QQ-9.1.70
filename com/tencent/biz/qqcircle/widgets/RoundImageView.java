package com.tencent.biz.qqcircle.widgets;

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

/* compiled from: P */
/* loaded from: classes5.dex */
public class RoundImageView extends ImageView {
    Rect C;

    /* renamed from: d, reason: collision with root package name */
    float f93476d;

    /* renamed from: e, reason: collision with root package name */
    boolean f93477e;

    /* renamed from: f, reason: collision with root package name */
    boolean f93478f;

    /* renamed from: h, reason: collision with root package name */
    Path f93479h;

    /* renamed from: i, reason: collision with root package name */
    RectF f93480i;

    /* renamed from: m, reason: collision with root package name */
    Rect f93481m;

    public RoundImageView(Context context) {
        this(context, null);
    }

    private void a(Canvas canvas) {
        try {
            canvas.clipPath(this.f93479h);
        } catch (Exception e16) {
            QLog.e("RoundImageView", 1, "clipPathSafe exception", e16);
        }
    }

    private void b(Context context, AttributeSet attributeSet, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y91.a.G7, i3, 0);
        try {
            try {
                this.f93476d = (int) obtainStyledAttributes.getDimension(y91.a.I7, 0.0f);
                this.f93477e = obtainStyledAttributes.getBoolean(y91.a.H7, false);
            } catch (Exception e16) {
                QLog.e("RoundImageView", 1, "initAttrs exception", e16);
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        try {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float f16 = this.f93476d;
            if (f16 > 0.0f) {
                if (this.f93478f) {
                    this.f93480i.set(0.0f, 0.0f, measuredWidth + f16, measuredHeight);
                } else {
                    RectF rectF = this.f93480i;
                    float f17 = measuredWidth;
                    float f18 = measuredHeight;
                    if (!this.f93477e) {
                        f16 = 0.0f;
                    }
                    rectF.set(0.0f, 0.0f, f17, f18 + f16);
                }
                Path path = this.f93479h;
                RectF rectF2 = this.f93480i;
                float f19 = this.f93476d;
                path.addRoundRect(rectF2, f19, f19, Path.Direction.CW);
                a(canvas);
                Drawable drawable = getDrawable();
                if (drawable != null) {
                    if (drawable instanceof BitmapDrawable) {
                        bitmap = ((BitmapDrawable) drawable).getBitmap();
                    } else {
                        bitmap = null;
                    }
                    if (bitmap != null && !bitmap.isRecycled()) {
                        this.f93481m.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        this.C.set(0, 0, measuredWidth, measuredHeight);
                        canvas.drawBitmap(bitmap, this.f93481m, this.C, (Paint) null);
                        return;
                    }
                }
            }
            super.onDraw(canvas);
        } catch (Exception e16) {
            QLog.e("RoundImageView", 1, "onDraw exception", e16);
        }
    }

    public void setRadiusWithoutRight(int i3) {
        this.f93476d = i3;
        this.f93478f = true;
    }

    public void setmRadius(int i3, boolean z16) {
        this.f93476d = i3;
        this.f93477e = z16;
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f93476d = 0.0f;
        this.f93477e = false;
        this.f93478f = false;
        this.f93479h = new Path();
        this.f93480i = new RectF();
        this.f93481m = new Rect();
        this.C = new Rect();
        b(context, attributeSet, i3);
    }
}
