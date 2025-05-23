package com.tencent.gdtad.views.image;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import q71.a;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtRoundedURIImageView extends URLImageView {

    /* renamed from: d, reason: collision with root package name */
    private float f109629d;

    /* renamed from: e, reason: collision with root package name */
    private float f109630e;

    /* renamed from: f, reason: collision with root package name */
    private int f109631f;

    /* renamed from: h, reason: collision with root package name */
    private Paint f109632h;

    /* renamed from: i, reason: collision with root package name */
    private RectF f109633i;

    /* renamed from: m, reason: collision with root package name */
    private Path f109634m;

    public GdtRoundedURIImageView(Context context) {
        super(context);
        this.f109629d = 0.0f;
        this.f109630e = 0.0f;
        this.f109631f = 0;
        c(context, null, 0, 0);
    }

    private void c(Context context, AttributeSet attributeSet, int i3, int i16) {
        TypedArray typedArray = null;
        try {
            typedArray = context.getTheme().obtainStyledAttributes(attributeSet, a.B1, i3, i16);
            this.f109629d = typedArray.getDimensionPixelSize(a.D1, 0);
            this.f109631f = typedArray.getColor(a.C1, 0);
            this.f109630e = typedArray.getDimension(a.E1, 0.0f);
        } catch (Throwable th5) {
            QLog.e("GdtRoundedURIImageView", 1, "[init]", th5);
        }
        if (typedArray != null) {
            try {
                typedArray.recycle();
            } catch (Throwable th6) {
                QLog.e("GdtRoundedURIImageView", 1, "[init]", th6);
            }
        }
        Paint paint = new Paint();
        this.f109632h = paint;
        paint.setAntiAlias(true);
        this.f109632h.setStyle(Paint.Style.STROKE);
        this.f109632h.setStrokeWidth(this.f109629d);
        this.f109632h.setColor(this.f109631f);
        this.f109633i = new RectF();
        this.f109634m = new Path();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.f109633i;
        float f16 = this.f109629d;
        rectF.set(f16 / 2.0f, f16 / 2.0f, getWidth() - (this.f109629d / 2.0f), getHeight() - (this.f109629d / 2.0f));
        Path path = this.f109634m;
        RectF rectF2 = this.f109633i;
        float f17 = this.f109630e;
        path.addRoundRect(rectF2, f17, f17, Path.Direction.CW);
        canvas.clipPath(this.f109634m);
        super.onDraw(canvas);
        if (this.f109629d > 0.0f) {
            RectF rectF3 = this.f109633i;
            float f18 = this.f109630e;
            canvas.drawRoundRect(rectF3, f18, f18, this.f109632h);
        }
    }

    public GdtRoundedURIImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f109629d = 0.0f;
        this.f109630e = 0.0f;
        this.f109631f = 0;
        c(context, attributeSet, 0, 0);
    }

    public GdtRoundedURIImageView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f109629d = 0.0f;
        this.f109630e = 0.0f;
        this.f109631f = 0;
        c(context, attributeSet, i3, 0);
    }
}
