package com.tencent.smtt.sdk.ui.dialog.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes23.dex */
public class RoundImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private Paint f369575a;

    /* renamed from: b, reason: collision with root package name */
    private Xfermode f369576b;

    /* renamed from: c, reason: collision with root package name */
    private Bitmap f369577c;

    /* renamed from: d, reason: collision with root package name */
    private float[] f369578d;

    /* renamed from: e, reason: collision with root package name */
    private RectF f369579e;

    /* renamed from: f, reason: collision with root package name */
    private int f369580f;

    /* renamed from: g, reason: collision with root package name */
    private WeakReference<Bitmap> f369581g;

    /* renamed from: h, reason: collision with root package name */
    private float f369582h;

    /* renamed from: i, reason: collision with root package name */
    private Path f369583i;

    public RoundImageView(Context context) {
        this(context, null);
    }

    private void a(Canvas canvas, int i3, int i16, RectF rectF, float[] fArr) {
        a(i3, i16);
        this.f369583i.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.f369583i, this.f369575a);
    }

    @Override // android.view.View
    public void invalidate() {
        this.f369581g = null;
        Bitmap bitmap = this.f369577c;
        if (bitmap != null) {
            bitmap.recycle();
            this.f369577c = null;
        }
        super.invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        WeakReference<Bitmap> weakReference = this.f369581g;
        if (weakReference == null) {
            bitmap = null;
        } else {
            bitmap = weakReference.get();
        }
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f369575a.setXfermode(null);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.f369575a);
        } else {
            Drawable drawable = getDrawable();
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                float f16 = intrinsicWidth;
                float f17 = intrinsicHeight;
                float max = Math.max((getWidth() * 1.0f) / f16, (getHeight() * 1.0f) / f17);
                drawable.setBounds(0, 0, (int) (f16 * max), (int) (max * f17));
                drawable.draw(canvas2);
                Bitmap bitmap2 = this.f369577c;
                if (bitmap2 == null || bitmap2.isRecycled()) {
                    this.f369577c = a();
                }
                this.f369575a.reset();
                this.f369575a.setFilterBitmap(false);
                this.f369575a.setXfermode(this.f369576b);
                Bitmap bitmap3 = this.f369577c;
                if (bitmap3 != null) {
                    canvas2.drawBitmap(bitmap3, 0.0f, 0.0f, this.f369575a);
                }
                this.f369575a.setXfermode(null);
                canvas.drawBitmap(createBitmap, 0.0f, 0.0f, (Paint) null);
                this.f369581g = new WeakReference<>(createBitmap);
            }
        }
        a(canvas, 1, this.f369580f, this.f369579e, this.f369578d);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.f369579e.set(0.5f, 0.5f, i3 - 0.5f, i16 - 0.5f);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f369576b = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.f369580f = Color.parseColor("#eaeaea");
        Paint paint = new Paint();
        this.f369575a = paint;
        paint.setAntiAlias(true);
        this.f369583i = new Path();
        this.f369578d = new float[8];
        this.f369579e = new RectF();
        this.f369582h = com.tencent.smtt.sdk.ui.dialog.c.a(context, 16.46f);
        int i3 = 0;
        while (true) {
            float[] fArr = this.f369578d;
            if (i3 >= fArr.length) {
                return;
            }
            fArr[i3] = this.f369582h;
            i3++;
        }
    }

    private void a(int i3, int i16) {
        this.f369583i.reset();
        this.f369575a.setStrokeWidth(i3);
        this.f369575a.setColor(i16);
        this.f369575a.setStyle(Paint.Style.STROKE);
    }

    private Bitmap a() {
        Bitmap bitmap = null;
        try {
            bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint(1);
            paint.setColor(-16777216);
            RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            float f16 = this.f369582h;
            canvas.drawRoundRect(rectF, f16, f16, paint);
            return bitmap;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return bitmap;
        }
    }
}
