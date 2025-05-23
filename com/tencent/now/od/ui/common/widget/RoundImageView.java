package com.tencent.now.od.ui.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* compiled from: P */
/* loaded from: classes22.dex */
public class RoundImageView extends ImageView {

    /* renamed from: d, reason: collision with root package name */
    private Logger f338531d;

    /* renamed from: e, reason: collision with root package name */
    private Path f338532e;

    /* renamed from: f, reason: collision with root package name */
    private PaintFlagsDrawFilter f338533f;

    /* renamed from: h, reason: collision with root package name */
    private Paint f338534h;

    public RoundImageView(Context context) {
        super(context);
        this.f338531d = LoggerFactory.getLogger("RoundImageView");
        this.f338532e = new Path();
    }

    private void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        if (attributeSet == null || (obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, tn3.a.K)) == null) {
            return;
        }
        obtainStyledAttributes.recycle();
        this.f338533f = new PaintFlagsDrawFilter(0, 3);
        Paint paint = new Paint();
        this.f338534h = paint;
        paint.setAntiAlias(true);
        this.f338534h.setFilterBitmap(true);
        this.f338534h.setDither(true);
    }

    private Bitmap b(Bitmap bitmap, int i3, int i16) {
        if (bitmap != null && i3 > 0 && i16 > 0) {
            Bitmap createBitmap = Bitmap.createBitmap(i3, i16, bitmap.getConfig());
            float width = bitmap.getWidth();
            float height = bitmap.getHeight();
            Canvas canvas = new Canvas(createBitmap);
            float f16 = i3;
            float f17 = f16 / width;
            float f18 = i16;
            float f19 = f18 / height;
            Matrix matrix = new Matrix();
            matrix.postTranslate((f16 - (width * f17)) / 2.0f, (f18 - (height * f19)) / 1.0f);
            matrix.preScale(f17, f19);
            Paint paint = new Paint();
            paint.setFilterBitmap(true);
            canvas.drawBitmap(bitmap, matrix, paint);
            return createBitmap;
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap a16;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth <= 0 && measuredHeight <= 0) {
            super.onDraw(canvas);
            return;
        }
        float f16 = measuredWidth / 2.0f;
        this.f338532e.addCircle(f16, measuredHeight / 2.0f, f16, Path.Direction.CW);
        Drawable drawable = getDrawable();
        if (drawable != null && drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0 && (a16 = com.tencent.od.app.util.a.a(drawable)) != null && !a16.isRecycled()) {
            Bitmap b16 = b(a16, measuredWidth, measuredHeight);
            Paint paint = this.f338534h;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(b16, tileMode, tileMode));
            canvas.setDrawFilter(this.f338533f);
            canvas.drawPath(this.f338532e, this.f338534h);
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i16) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        if (size2 == 0 && size == 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        if (size2 == 0) {
            setMeasuredDimension(size, (drawable.getIntrinsicHeight() * size) / drawable.getIntrinsicWidth());
        } else if (size == 0) {
            setMeasuredDimension((drawable.getIntrinsicWidth() * size2) / drawable.getIntrinsicHeight(), size2);
        } else {
            setMeasuredDimension(size, size2);
        }
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f338531d = LoggerFactory.getLogger("RoundImageView");
        this.f338532e = new Path();
        a(attributeSet);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f338531d = LoggerFactory.getLogger("RoundImageView");
        this.f338532e = new Path();
        a(attributeSet);
    }
}
